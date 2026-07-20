package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import k.b;

/* JADX INFO: loaded from: classes2.dex */
final class PoolThreadCache {
    private static final int INTEGER_SIZE_MINUS_ONE = 31;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PoolThreadCache.class);
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final FreeOnFinalize freeOnFinalize;
    private final int freeSweepAllocationThreshold;
    private final AtomicBoolean freed = new AtomicBoolean();
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;

    /* JADX INFO: renamed from: io.netty.buffer.PoolThreadCache$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[PoolArena.SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[PoolArena.SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class FreeOnFinalize {
        private final PoolThreadCache cache;

        public /* synthetic */ FreeOnFinalize(PoolThreadCache poolThreadCache, AnonymousClass1 anonymousClass1) {
            this(poolThreadCache);
        }

        public void finalize() throws Throwable {
            try {
                super.finalize();
            } finally {
                this.cache.free(true);
            }
        }

        private FreeOnFinalize(PoolThreadCache poolThreadCache) {
            this.cache = poolThreadCache;
        }
    }

    public static abstract class MemoryRegionCache<T> {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        public static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1;
            ByteBuffer nioBuffer;
            int normCapacity;
            final Recycler.EnhancedHandle<Entry<?>> recyclerHandle;

            public Entry(ObjectPool.Handle<Entry<?>> handle) {
                this.recyclerHandle = (Recycler.EnhancedHandle) handle;
            }

            public void recycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.recycle(this);
            }

            public void unguardedRecycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.unguardedRecycle(this);
            }
        }

        public MemoryRegionCache(int i10, PoolArena.SizeClass sizeClass) {
            int iSafeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i10);
            this.size = iSafeFindNextPositivePowerOfTwo;
            this.queue = PlatformDependent.newFixedMpscQueue(iSafeFindNextPositivePowerOfTwo);
            this.sizeClass = sizeClass;
        }

        private void freeEntry(Entry entry, boolean z10) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j10 = entry.handle;
            ByteBuffer byteBuffer = entry.nioBuffer;
            int i10 = entry.normCapacity;
            if (!z10) {
                entry.recycle();
            }
            poolChunk.arena.freeChunk(poolChunk, j10, i10, this.sizeClass, byteBuffer, z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, ByteBuffer byteBuffer, long j10, int i10) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.nioBuffer = byteBuffer;
            entry.handle = j10;
            entry.normCapacity = i10;
            return entry;
        }

        public final boolean add(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, int i10) {
            Entry<T> entryNewEntry = newEntry(poolChunk, byteBuffer, j10, i10);
            boolean zOffer = this.queue.offer(entryNewEntry);
            if (!zOffer) {
                entryNewEntry.unguardedRecycle();
            }
            return zOffer;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i10, PoolThreadCache poolThreadCache) {
            Entry<T> entryPoll = this.queue.poll();
            if (entryPoll == null) {
                return false;
            }
            initBuf(entryPoll.chunk, entryPoll.nioBuffer, entryPoll.handle, pooledByteBuf, i10, poolThreadCache);
            entryPoll.unguardedRecycle();
            this.allocations++;
            return true;
        }

        public final int free(boolean z10) {
            return free(Integer.MAX_VALUE, z10);
        }

        public abstract void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, PooledByteBuf<T> pooledByteBuf, int i10, PoolThreadCache poolThreadCache);

        public final void trim() {
            int i10 = this.size - this.allocations;
            this.allocations = 0;
            if (i10 > 0) {
                free(i10, false);
            }
        }

        private int free(int i10, boolean z10) {
            int i11 = 0;
            while (i11 < i10) {
                Entry<T> entryPoll = this.queue.poll();
                if (entryPoll == null) {
                    break;
                }
                freeEntry(entryPoll, z10);
                i11++;
            }
            return i11;
        }
    }

    public static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        public NormalMemoryRegionCache(int i10) {
            super(i10, PoolArena.SizeClass.Normal);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        public void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, PooledByteBuf<T> pooledByteBuf, int i10, PoolThreadCache poolThreadCache) {
            poolChunk.initBuf(pooledByteBuf, byteBuffer, j10, i10, poolThreadCache);
        }
    }

    public static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        public SubPageMemoryRegionCache(int i10) {
            super(i10, PoolArena.SizeClass.Small);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        public void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, PooledByteBuf<T> pooledByteBuf, int i10, PoolThreadCache poolThreadCache) {
            poolChunk.initBufWithSubpage(pooledByteBuf, byteBuffer, j10, i10, poolThreadCache);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i10, int i11, int i12, int i13, boolean z10) {
        ObjectUtil.checkPositiveOrZero(i12, "maxCachedBufferCapacity");
        this.freeSweepAllocationThreshold = i13;
        this.heapArena = poolArena;
        this.directArena = poolArena2;
        Object[] objArr = 0;
        if (poolArena2 != null) {
            this.smallSubPageDirectCaches = createSubPageCaches(i10, poolArena2.numSmallSubpagePools);
            this.normalDirectCaches = createNormalCaches(i11, i12, poolArena2);
            poolArena2.numThreadCaches.getAndIncrement();
        } else {
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
        }
        if (poolArena != null) {
            this.smallSubPageHeapCaches = createSubPageCaches(i10, poolArena.numSmallSubpagePools);
            this.normalHeapCaches = createNormalCaches(i11, i12, poolArena);
            poolArena.numThreadCaches.getAndIncrement();
        } else {
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
        }
        if (!(this.smallSubPageDirectCaches == null && this.normalDirectCaches == null && this.smallSubPageHeapCaches == null && this.normalHeapCaches == null) && i13 < 1) {
            throw new IllegalArgumentException(b.a("freeSweepAllocationThreshold: ", i13, " (expected: > 0)"));
        }
        this.freeOnFinalize = z10 ? new FreeOnFinalize(this, objArr == true ? 1 : 0) : null;
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i10) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean zAllocate = memoryRegionCache.allocate(pooledByteBuf, i10, this);
        int i11 = this.allocations + 1;
        this.allocations = i11;
        if (i11 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return zAllocate;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i10, PoolArena.SizeClass sizeClass) {
        int i11 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i11 == 1) {
            return cacheForNormal(poolArena, i10);
        }
        if (i11 == 2) {
            return cacheForSmall(poolArena, i10);
        }
        throw new Error();
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i10) {
        int i11 = i10 - poolArena.numSmallSubpagePools;
        return poolArena.isDirect() ? cache(this.normalDirectCaches, i11) : cache(this.normalHeapCaches, i11);
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i10) {
        return poolArena.isDirect() ? cache(this.smallSubPageDirectCaches, i10) : cache(this.smallSubPageHeapCaches, i10);
    }

    private static void checkCacheMayLeak(MemoryRegionCache<?>[] memoryRegionCacheArr, String str) {
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            if (!((MemoryRegionCache) memoryRegionCache).queue.isEmpty()) {
                logger.debug("{} memory may leak.", str);
                return;
            }
        }
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i10, int i11, PoolArena<T> poolArena) {
        if (i10 <= 0 || i11 <= 0) {
            return null;
        }
        int iMin = Math.min(poolArena.chunkSize, i11);
        ArrayList arrayList = new ArrayList();
        for (int i12 = poolArena.numSmallSubpagePools; i12 < poolArena.nSizes && poolArena.sizeIdx2size(i12) <= iMin; i12++) {
            arrayList.add(new NormalMemoryRegionCache(i10));
        }
        return (MemoryRegionCache[]) arrayList.toArray(new MemoryRegionCache[0]);
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return null;
        }
        MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            memoryRegionCacheArr[i12] = new SubPageMemoryRegionCache(i10);
        }
        return memoryRegionCacheArr;
    }

    public static int log2(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, ByteBuffer byteBuffer, long j10, int i10, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> memoryRegionCacheCache = cache(poolArena, poolArena.size2SizeIdx(i10), sizeClass);
        if (memoryRegionCacheCache == null || this.freed.get()) {
            return false;
        }
        return memoryRegionCacheCache.add(poolChunk, byteBuffer, j10, i10);
    }

    public boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i10, int i11) {
        return allocate(cacheForNormal(poolArena, i11), pooledByteBuf, i10);
    }

    public boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i10, int i11) {
        return allocate(cacheForSmall(poolArena, i11), pooledByteBuf, i10);
    }

    public void free(boolean z10) {
        if (!this.freed.compareAndSet(false, true)) {
            checkCacheMayLeak(this.smallSubPageDirectCaches, "SmallSubPageDirectCaches");
            checkCacheMayLeak(this.normalDirectCaches, "NormalDirectCaches");
            checkCacheMayLeak(this.smallSubPageHeapCaches, "SmallSubPageHeapCaches");
            checkCacheMayLeak(this.normalHeapCaches, "NormalHeapCaches");
            return;
        }
        int iFree = free(this.smallSubPageDirectCaches, z10) + free(this.normalDirectCaches, z10) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches, z10) + free((MemoryRegionCache<?>[]) this.normalHeapCaches, z10);
        if (iFree > 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(iFree), Thread.currentThread().getName());
            }
        }
        PoolArena<ByteBuffer> poolArena = this.directArena;
        if (poolArena != null) {
            poolArena.numThreadCaches.getAndDecrement();
        }
        PoolArena<byte[]> poolArena2 = this.heapArena;
        if (poolArena2 != null) {
            poolArena2.numThreadCaches.getAndDecrement();
        }
    }

    public void trim() {
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i10) {
        if (memoryRegionCacheArr == null || i10 > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i10];
    }

    private static void trim(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return;
        }
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            trim(memoryRegionCache);
        }
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }

    private static int free(MemoryRegionCache<?>[] memoryRegionCacheArr, boolean z10) {
        if (memoryRegionCacheArr == null) {
            return 0;
        }
        int iFree = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            iFree += free(memoryRegionCache, z10);
        }
        return iFree;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache, boolean z10) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free(z10);
    }
}
