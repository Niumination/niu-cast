package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
abstract class PoolArena<T> extends SizeClasses implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    private final LongCounter activeBytesHuge;
    private final LongCounter allocationsHuge;
    private long allocationsNormal;
    private final LongCounter allocationsSmall;
    private final List<PoolChunkListMetric> chunkListMetrics;
    private final LongCounter deallocationsHuge;
    private long deallocationsNormal;
    private long deallocationsSmall;
    final int directMemoryCacheAlignment;
    private final ReentrantLock lock;
    final int numSmallSubpagePools;
    final AtomicInteger numThreadCaches;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    final PoolSubpage<T>[] smallSubpagePools;

    /* JADX INFO: renamed from: io.netty.buffer.PoolArena$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class DirectArena extends PoolArena<ByteBuffer> {
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12, int i13) {
            super(pooledByteBufAllocator, i10, i11, i12, i13);
        }

        private static ByteBuffer allocateDirect(int i10) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(i10) : ByteBuffer.allocateDirect(i10);
        }

        @Override // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner((ByteBuffer) poolChunk.base);
            } else {
                PlatformDependent.freeDirectBuffer((ByteBuffer) poolChunk.base);
            }
        }

        @Override // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return true;
        }

        @Override // io.netty.buffer.PoolArena
        public PooledByteBuf<ByteBuffer> newByteBuf(int i10) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(i10) : PooledDirectByteBuf.newInstance(i10);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<ByteBuffer> newChunk(int i10, int i11, int i12, int i13) {
            int i14 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i14 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i13);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i10, i12, i13, i11);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i14 + i13);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i10, i12, i13, i11);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<ByteBuffer> newUnpooledChunk(int i10) {
            int i11 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i11 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i10);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i10);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i11 + i10);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i10);
        }

        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i10, PooledByteBuf<ByteBuffer> pooledByteBuf, int i11) {
            if (i11 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) i10), PlatformDependent.directBufferAddress(pooledByteBuf.memory) + ((long) pooledByteBuf.offset), i11);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            ByteBuffer byteBufferInternalNioBuffer = pooledByteBuf.internalNioBuffer();
            byteBufferDuplicate.position(i10).limit(i10 + i11);
            byteBufferInternalNioBuffer.position(pooledByteBuf.offset);
            byteBufferInternalNioBuffer.put(byteBufferDuplicate);
        }
    }

    public static final class HeapArena extends PoolArena<byte[]> {
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12) {
            super(pooledByteBufAllocator, i10, i11, i12, 0);
        }

        private static byte[] newByteArray(int i10) {
            return PlatformDependent.allocateUninitializedArray(i10);
        }

        @Override // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        @Override // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return false;
        }

        @Override // io.netty.buffer.PoolArena
        public PooledByteBuf<byte[]> newByteBuf(int i10) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i10) : PooledHeapByteBuf.newInstance(i10);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<byte[]> newChunk(int i10, int i11, int i12, int i13) {
            return new PoolChunk<>(this, null, newByteArray(i13), i10, i12, i13, i11);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<byte[]> newUnpooledChunk(int i10) {
            return new PoolChunk<>(this, null, newByteArray(i10), i10);
        }

        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i10, PooledByteBuf<byte[]> pooledByteBuf, int i11) {
            if (i11 == 0) {
                return;
            }
            System.arraycopy(bArr, i10, pooledByteBuf.memory, pooledByteBuf.offset, i11);
        }
    }

    public enum SizeClass {
        Small,
        Normal
    }

    public PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
        this.allocationsSmall = PlatformDependent.newLongCounter();
        this.allocationsHuge = PlatformDependent.newLongCounter();
        this.activeBytesHuge = PlatformDependent.newLongCounter();
        this.deallocationsHuge = PlatformDependent.newLongCounter();
        this.numThreadCaches = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.parent = pooledByteBufAllocator;
        this.directMemoryCacheAlignment = i13;
        int i14 = this.nSubpages;
        this.numSmallSubpagePools = i14;
        this.smallSubpagePools = newSubpagePoolArray(i14);
        int i15 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.smallSubpagePools;
            if (i15 >= poolSubpageArr.length) {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(this, null, 100, Integer.MAX_VALUE, i12);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(this, poolChunkList, 75, 100, i12);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(this, poolChunkList2, 50, 100, i12);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(this, poolChunkList3, 25, 75, i12);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(this, poolChunkList4, 1, 50, i12);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(this, poolChunkList5, Integer.MIN_VALUE, 25, i12);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
            poolSubpageArr[i15] = newSubpagePoolHead(i15);
            i15++;
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i10) {
        PoolChunk<T> poolChunkNewUnpooledChunk = newUnpooledChunk(i10);
        this.activeBytesHuge.add(poolChunkNewUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(poolChunkNewUnpooledChunk, i10);
        this.allocationsHuge.increment();
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i10, int i11, PoolThreadCache poolThreadCache) {
        if (this.q050.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q025.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q000.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.qInit.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q075.allocate(pooledByteBuf, i10, i11, poolThreadCache)) {
            return;
        }
        PoolChunk<T> poolChunkNewChunk = newChunk(this.pageSize, this.nPSizes, this.pageShifts, this.chunkSize);
        poolChunkNewChunk.allocate(pooledByteBuf, i10, i11, poolThreadCache);
        this.qInit.add(poolChunkNewChunk);
    }

    private static void appendPoolSubPages(StringBuilder sb2, PoolSubpage<?>[] poolSubpageArr) {
        for (int i10 = 0; i10 < poolSubpageArr.length; i10++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i10];
            PoolSubpage<?> poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage && poolSubpage2 != null) {
                sb2.append(StringUtil.NEWLINE);
                sb2.append(i10);
                sb2.append(": ");
                PoolSubpage poolSubpage3 = poolSubpage.next;
                while (poolSubpage3 != null) {
                    sb2.append(poolSubpage3);
                    poolSubpage3 = poolSubpage3.next;
                    if (poolSubpage3 == poolSubpage) {
                        break;
                    }
                }
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> poolChunkList : poolChunkListArr) {
            poolChunkList.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            poolSubpage.destroy();
        }
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i10) {
        return new PoolSubpage[i10];
    }

    private PoolSubpage<T> newSubpagePoolHead(int i10) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i10);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private static SizeClass sizeClass(long j10) {
        return PoolChunk.isSubpage(j10) ? SizeClass.Small : SizeClass.Normal;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            PoolSubpage poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage) {
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    private void tcacheAllocateNormal(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10, int i11) {
        if (poolThreadCache.allocateNormal(this, pooledByteBuf, i10, i11)) {
            return;
        }
        lock();
        try {
            allocateNormal(pooledByteBuf, i10, i11, poolThreadCache);
            this.allocationsNormal++;
        } finally {
            unlock();
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10, int i11) {
        if (poolThreadCache.allocateSmall(this, pooledByteBuf, i10, i11)) {
            return;
        }
        PoolSubpage<T> poolSubpage = this.smallSubpagePools[i11];
        poolSubpage.lock();
        try {
            PoolSubpage<T> poolSubpage2 = poolSubpage.next;
            boolean z10 = poolSubpage2 == poolSubpage;
            if (!z10) {
                poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, null, poolSubpage2.allocate(), i10, poolThreadCache);
            }
            poolSubpage.unlock();
            if (z10) {
                lock();
                try {
                    allocateNormal(pooledByteBuf, i10, i11, poolThreadCache);
                    unlock();
                } catch (Throwable th2) {
                    unlock();
                    throw th2;
                }
            }
            incSmallAllocation();
        } catch (Throwable th3) {
            poolSubpage.unlock();
            throw th3;
        }
    }

    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i10, int i11) {
        PooledByteBuf<T> pooledByteBufNewByteBuf = newByteBuf(i11);
        allocate(poolThreadCache, pooledByteBufNewByteBuf, i10);
        return pooledByteBufNewByteBuf;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    public abstract void destroyChunk(PoolChunk<T> poolChunk);

    public final void finalize() throws Throwable {
        try {
            super.finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th2) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th2;
        }
    }

    public void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        poolChunk.decrementPinnedMemory(i10);
        if (poolChunk.unpooled) {
            int iChunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-iChunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(j10);
        if (poolThreadCache == null || !poolThreadCache.add(this, poolChunk, byteBuffer, j10, i10, sizeClass)) {
            freeChunk(poolChunk, j10, i10, sizeClass, byteBuffer, false);
        }
    }

    public void freeChunk(PoolChunk<T> poolChunk, long j10, int i10, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z10) {
        lock();
        if (!z10) {
            try {
                int i11 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                if (i11 == 1) {
                    this.deallocationsNormal++;
                } else {
                    if (i11 != 2) {
                        throw new Error();
                    }
                    this.deallocationsSmall++;
                }
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }
        boolean zFree = poolChunk.parent.free(poolChunk, j10, i10, byteBuffer);
        unlock();
        if (zFree) {
            return;
        }
        destroyChunk(poolChunk);
    }

    public abstract boolean isDirect();

    public void lock() {
        this.lock.lock();
    }

    public abstract void memoryCopy(T t10, int i10, PooledByteBuf<T> pooledByteBuf, int i11);

    public abstract PooledByteBuf<T> newByteBuf(int i10);

    public abstract PoolChunk<T> newChunk(int i10, int i11, int i12, int i13);

    public abstract PoolChunk<T> newUnpooledChunk(int i10);

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long jValue = (this.allocationsHuge.value() + this.allocationsSmall.value()) - this.deallocationsHuge.value();
        lock();
        try {
            return Math.max((this.allocationsNormal - (this.deallocationsSmall + this.deallocationsNormal)) + jValue, 0L);
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long jValue = this.activeBytesHuge.value();
        lock();
        for (int i10 = 0; i10 < this.chunkListMetrics.size(); i10++) {
            try {
                Iterator<PoolChunkMetric> it = this.chunkListMetrics.get(i10).iterator();
                while (it.hasNext()) {
                    jValue += (long) it.next().chunkSize();
                }
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }
        unlock();
        return Math.max(0L, jValue);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        lock();
        try {
            return Math.max(this.allocationsNormal - this.deallocationsNormal, 0L);
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        lock();
        try {
            return this.allocationsHuge.value() + this.allocationsSmall.value() + this.allocationsNormal;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        lock();
        try {
            return this.deallocationsHuge.value() + this.deallocationsSmall + this.deallocationsNormal;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalAllocations() {
        lock();
        try {
            return this.allocationsNormal;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalDeallocations() {
        lock();
        try {
            return this.deallocationsNormal;
        } finally {
            unlock();
        }
    }

    public long numPinnedBytes() {
        long jValue = this.activeBytesHuge.value();
        lock();
        for (int i10 = 0; i10 < this.chunkListMetrics.size(); i10++) {
            try {
                Iterator<PoolChunkMetric> it = this.chunkListMetrics.get(i10).iterator();
                while (it.hasNext()) {
                    jValue += (long) ((PoolChunk) it.next()).pinnedBytes();
                }
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }
        unlock();
        return Math.max(0L, jValue);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallDeallocations() {
        lock();
        try {
            return this.deallocationsSmall;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyDeallocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return 0;
    }

    public void reallocate(PooledByteBuf<T> pooledByteBuf, int i10) {
        synchronized (pooledByteBuf) {
            try {
                int i11 = pooledByteBuf.length;
                if (i11 == i10) {
                    return;
                }
                PoolChunk<T> poolChunk = pooledByteBuf.chunk;
                ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
                long j10 = pooledByteBuf.handle;
                T t10 = pooledByteBuf.memory;
                int i12 = pooledByteBuf.offset;
                int i13 = pooledByteBuf.maxLength;
                PoolThreadCache poolThreadCache = pooledByteBuf.cache;
                allocate(this.parent.threadCache(), pooledByteBuf, i10);
                if (i10 > i11) {
                    i10 = i11;
                } else {
                    pooledByteBuf.trimIndicesToCapacity(i10);
                }
                memoryCopy(t10, i12, pooledByteBuf, i10);
                free(poolChunk, byteBuffer, j10, i13, poolThreadCache);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return Collections.emptyList();
    }

    public String toString() {
        lock();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Chunk(s) at 0~25%:");
            String str = StringUtil.NEWLINE;
            sb2.append(str);
            sb2.append(this.qInit);
            sb2.append(str);
            sb2.append("Chunk(s) at 0~50%:");
            sb2.append(str);
            sb2.append(this.q000);
            sb2.append(str);
            sb2.append("Chunk(s) at 25~75%:");
            sb2.append(str);
            sb2.append(this.q025);
            sb2.append(str);
            sb2.append("Chunk(s) at 50~100%:");
            sb2.append(str);
            sb2.append(this.q050);
            sb2.append(str);
            sb2.append("Chunk(s) at 75~100%:");
            sb2.append(str);
            sb2.append(this.q075);
            sb2.append(str);
            sb2.append("Chunk(s) at 100%:");
            sb2.append(str);
            sb2.append(this.q100);
            sb2.append(str);
            sb2.append("small subpages:");
            appendPoolSubPages(sb2, this.smallSubpagePools);
            sb2.append(str);
            return sb2.toString();
        } finally {
            unlock();
        }
    }

    public void unlock() {
        this.lock.unlock();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10) {
        int iSize2SizeIdx = size2SizeIdx(i10);
        if (iSize2SizeIdx <= this.smallMaxSizeIdx) {
            tcacheAllocateSmall(poolThreadCache, pooledByteBuf, i10, iSize2SizeIdx);
        } else {
            if (iSize2SizeIdx < this.nSizes) {
                tcacheAllocateNormal(poolThreadCache, pooledByteBuf, i10, iSize2SizeIdx);
                return;
            }
            if (this.directMemoryCacheAlignment > 0) {
                i10 = normalizeSize(i10);
            }
            allocateHuge(pooledByteBuf, i10);
        }
    }
}
