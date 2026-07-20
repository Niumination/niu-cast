package io.netty.buffer;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k.b;
import n1.e;

/* JADX INFO: loaded from: classes2.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_NOT_USED = 0;
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final Runnable trimTask;

    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        public PoolThreadLocalCache(boolean z10) {
            this.useCacheForAllThreads = z10;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            if (poolArena.numThreadCaches.get() == 0) {
                return poolArena;
            }
            for (int i10 = 1; i10 < poolArenaArr.length; i10++) {
                PoolArena<T> poolArena2 = poolArenaArr[i10];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            PoolArena poolArenaLeastUsedArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena poolArenaLeastUsedArena2 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread threadCurrentThread = Thread.currentThread();
            EventExecutor eventExecutorCurrentExecutor = ThreadExecutorMap.currentExecutor();
            if (!this.useCacheForAllThreads && !(threadCurrentThread instanceof FastThreadLocalThread) && eventExecutorCurrentExecutor == null) {
                return new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, 0, 0, 0, 0, false);
            }
            PoolThreadCache poolThreadCache = new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL, true);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && eventExecutorCurrentExecutor != null) {
                eventExecutorCurrentExecutor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return poolThreadCache;
        }

        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    static {
        Object obj;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i11 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i11, i10);
            obj = null;
        } catch (Throwable th2) {
            obj = th2;
            i10 = 0;
            i11 = 8192;
        }
        DEFAULT_PAGE_SIZE = i11;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = i10;
        int i12 = 9;
        int i13 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        try {
            validateAndCalculateChunkSize(i11, i13);
            i12 = i13;
        } catch (Throwable th3) {
            obj2 = th3;
        }
        DEFAULT_MAX_ORDER = i12;
        Runtime runtime = Runtime.getRuntime();
        int iAvailableProcessors = NettyRuntime.availableProcessors() * 2;
        int i14 = DEFAULT_PAGE_SIZE;
        long j10 = iAvailableProcessors;
        long j11 = i14 << i12;
        int iMax = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(j10, ((runtime.maxMemory() / j11) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = iMax;
        int iMax2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(j10, ((PlatformDependent.maxDirectMemory() / j11) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = iMax2;
        int i15 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i15;
        int i16 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i16;
        int i17 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i17;
        int i18 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i18;
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z10;
        int i19 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i19;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(iMax));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(iMax2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i14));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i14), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i12));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i12), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i14 << i12));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i15));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i16));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i17));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i18));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z10));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(i19));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    private static <T> PoolArena<T>[] newArenaArray(int i10) {
        return new PoolArena[i10];
    }

    private static long pinnedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long jNumPinnedBytes = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            jNumPinnedBytes += poolArena.numPinnedBytes();
            if (jNumPinnedBytes < 0) {
                return Long.MAX_VALUE;
            }
        }
        return jNumPinnedBytes;
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long jNumActiveBytes = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            jNumActiveBytes += poolArena.numActiveBytes();
            if (jNumActiveBytes < 0) {
                return Long.MAX_VALUE;
            }
        }
        return jNumActiveBytes;
    }

    private static int validateAndCalculateChunkSize(int i10, int i11) {
        if (i11 > 14) {
            throw new IllegalArgumentException(b.a("maxOrder: ", i11, " (expected: 0-14)"));
        }
        int i12 = i10;
        for (int i13 = i11; i13 > 0; i13--) {
            if (i12 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i10), Integer.valueOf(i11), 1073741824));
            }
            i12 <<= 1;
        }
        return i12;
    }

    private static int validateAndCalculatePageShifts(int i10, int i11) {
        if (i10 < 4096) {
            throw new IllegalArgumentException(b.a("pageSize: ", i10, " (expected: 4096)"));
        }
        if (((i10 - 1) & i10) != 0) {
            throw new IllegalArgumentException(b.a("pageSize: ", i10, " (expected: power of 2)"));
        }
        if (i10 >= i11) {
            return 31 - Integer.numberOfLeadingZeros(i10);
        }
        throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + i11 + ", page size: " + i10 + e.f11183c);
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] poolArenaArr = this.heapArenas;
        int length = poolArenaArr == null ? 0 : poolArenaArr.length;
        StringBuilder sb2 = new StringBuilder(512);
        sb2.append(length);
        sb2.append(" heap arena(s):");
        sb2.append(StringUtil.NEWLINE);
        if (length > 0) {
            for (PoolArena<byte[]> poolArena : this.heapArenas) {
                sb2.append(poolArena);
            }
        }
        PoolArena<ByteBuffer>[] poolArenaArr2 = this.directArenas;
        int length2 = poolArenaArr2 == null ? 0 : poolArenaArr2.length;
        sb2.append(length2);
        sb2.append(" direct arena(s):");
        sb2.append(StringUtil.NEWLINE);
        if (length2 > 0) {
            for (PoolArena<ByteBuffer> poolArena2 : this.directArenas) {
                sb2.append(poolArena2);
            }
        }
        return sb2.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() throws Throwable {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newDirectBuffer(int i10, int i11) {
        ByteBuf byteBufNewUnsafeDirectByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        if (poolArena != null) {
            byteBufNewUnsafeDirectByteBuf = poolArena.allocate(poolThreadCache, i10, i11);
        } else {
            byteBufNewUnsafeDirectByteBuf = PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i10, i11) : new UnpooledDirectByteBuf(this, i10, i11);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(byteBufNewUnsafeDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newHeapBuffer(int i10, int i11) {
        ByteBuf unpooledUnsafeHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledUnsafeHeapByteBuf = poolArena.allocate(poolThreadCache, i10, i11);
        } else {
            unpooledUnsafeHeapByteBuf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i10, i11) : new UnpooledHeapByteBuf(this, i10, i11);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledUnsafeHeapByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i10 = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i10 += poolArena.numThreadCaches.get();
        }
        return i10;
    }

    public final long pinnedDirectMemory() {
        return pinnedMemory(this.directArenas);
    }

    public final long pinnedHeapMemory() {
        return pinnedMemory(this.heapArenas);
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    public final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache ifExists = this.threadCache.getIfExists();
        if (ifExists == null) {
            return false;
        }
        ifExists.trim();
        return true;
    }

    public final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    public final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    public PooledByteBufAllocator(boolean z10) {
        this(z10, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetricProvider
    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    public PooledByteBufAllocator(int i10, int i11, int i12, int i13) {
        this(false, i10, i11, i12, i13);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13) {
        this(z10, i10, i11, i12, i13, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this(z10, i10, i11, i12, i13, i15, i16, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11) {
        this(z10, i10, i11, i12, i13, i15, i16, z11);
    }

    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, boolean z11) {
        this(z10, i10, i11, i12, i13, i14, i15, z11, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11, int i17) {
        this(z10, i10, i11, i12, i13, i15, i16, z11, i17);
    }

    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16) {
        super(z10);
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z11);
        this.smallCacheSize = i14;
        this.normalCacheSize = i15;
        if (i16 != 0) {
            if (PlatformDependent.hasAlignDirectByteBuffer()) {
                i12 = (int) PlatformDependent.align(i12, i16);
            } else {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
        }
        int i17 = i12;
        this.chunkSize = validateAndCalculateChunkSize(i17, i13);
        ObjectUtil.checkPositiveOrZero(i10, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i11, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i16, "directMemoryCacheAlignment");
        if (i16 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if (((-i16) & i16) == i16) {
            int iValidateAndCalculatePageShifts = validateAndCalculatePageShifts(i17, i16);
            if (i10 > 0) {
                PoolArena<byte[]>[] poolArenaArrNewArenaArray = newArenaArray(i10);
                this.heapArenas = poolArenaArrNewArenaArray;
                ArrayList arrayList = new ArrayList(poolArenaArrNewArenaArray.length);
                for (int i18 = 0; i18 < this.heapArenas.length; i18++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i17, iValidateAndCalculatePageShifts, this.chunkSize);
                    this.heapArenas[i18] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.emptyList();
            }
            if (i11 > 0) {
                PoolArena<ByteBuffer>[] poolArenaArrNewArenaArray2 = newArenaArray(i11);
                this.directArenas = poolArenaArrNewArenaArray2;
                ArrayList arrayList2 = new ArrayList(poolArenaArrNewArenaArray2.length);
                for (int i19 = 0; i19 < this.directArenas.length; i19++) {
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i17, iValidateAndCalculatePageShifts, this.chunkSize, i16);
                    this.directArenas[i19] = directArena;
                    arrayList2.add(directArena);
                }
                this.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                this.directArenas = null;
                this.directArenaMetrics = Collections.emptyList();
            }
            this.metric = new PooledByteBufAllocatorMetric(this);
            return;
        }
        throw new IllegalArgumentException(b.a("directMemoryCacheAlignment: ", i16, " (expected: power of two)"));
    }
}
