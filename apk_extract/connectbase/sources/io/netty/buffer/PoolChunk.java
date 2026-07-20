package io.netty.buffer;

import el.b0;
import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BITMAP_IDX_BIT_LENGTH = 32;
    private static final int INUSED_BIT_LENGTH = 1;
    static final int IS_SUBPAGE_SHIFT = 32;
    static final int IS_USED_SHIFT = 33;
    static final int RUN_OFFSET_SHIFT = 49;
    private static final int SIZE_BIT_LENGTH = 15;
    static final int SIZE_SHIFT = 34;
    private static final int SUBPAGE_BIT_LENGTH = 1;
    final PoolArena<T> arena;
    final Object base;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    int freeBytes;
    final T memory;
    PoolChunk<T> next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    private final LongCounter pinnedBytes;
    PoolChunk<T> prev;
    private final IntPriorityQueue[] runsAvail;
    private final ReentrantLock runsAvailLock;
    private final LongLongHashMap runsAvailMap;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;

    public PoolChunk(PoolArena<T> poolArena, Object obj, T t10, int i10, int i11, int i12, int i13) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = false;
        this.arena = poolArena;
        this.base = obj;
        this.memory = t10;
        this.pageSize = i10;
        this.pageShifts = i11;
        this.chunkSize = i12;
        this.freeBytes = i12;
        this.runsAvail = newRunsAvailqueueArray(i13);
        this.runsAvailLock = new ReentrantLock();
        this.runsAvailMap = new LongLongHashMap(-1L);
        int i14 = i12 >> i11;
        this.subpages = new PoolSubpage[i14];
        insertAvailRun(0, i14, ((long) i14) << 34);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    private long allocateRun(int i10) {
        int i11 = i10 >> this.pageShifts;
        int iPages2pageIdx = this.arena.pages2pageIdx(i11);
        this.runsAvailLock.lock();
        try {
            int iRunFirstBestFit = runFirstBestFit(iPages2pageIdx);
            if (iRunFirstBestFit == -1) {
                return -1L;
            }
            long jPoll = ((long) this.runsAvail[iRunFirstBestFit].poll()) << 32;
            removeAvailRun0(jPoll);
            long jSplitLargeRun = splitLargeRun(jPoll, i11);
            this.freeBytes -= runSize(this.pageShifts, jSplitLargeRun);
            return jSplitLargeRun;
        } finally {
            this.runsAvailLock.unlock();
        }
    }

    private long allocateSubpage(int i10, PoolSubpage<T> poolSubpage) {
        long jAllocateRun = allocateRun(calculateRunSize(i10));
        if (jAllocateRun < 0) {
            return -1L;
        }
        int iRunOffset = runOffset(jAllocateRun);
        int iSizeIdx2size = this.arena.sizeIdx2size(i10);
        int i11 = this.pageShifts;
        PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(poolSubpage, this, i11, iRunOffset, runSize(i11, jAllocateRun), iSizeIdx2size);
        this.subpages[iRunOffset] = poolSubpage2;
        return poolSubpage2.allocate();
    }

    public static int bitmapIdx(long j10) {
        return (int) j10;
    }

    private int calculateRunSize(int i10) {
        int i11;
        int i12 = 1 << (this.pageShifts - 4);
        int iSizeIdx2size = this.arena.sizeIdx2size(i10);
        int i13 = 0;
        do {
            i13 += this.pageSize;
            i11 = i13 / iSizeIdx2size;
            if (i11 >= i12) {
                break;
            }
        } while (i13 != i11 * iSizeIdx2size);
        while (i11 > i12) {
            i13 -= this.pageSize;
            i11 = i13 / iSizeIdx2size;
        }
        return i13;
    }

    private long collapseNext(long j10) {
        while (true) {
            int iRunOffset = runOffset(j10);
            int iRunPages = runPages(j10);
            int i10 = iRunOffset + iRunPages;
            long availRunByOffset = getAvailRunByOffset(i10);
            if (availRunByOffset == -1) {
                return j10;
            }
            int iRunOffset2 = runOffset(availRunByOffset);
            int iRunPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j10 || i10 != iRunOffset2) {
                return j10;
            }
            removeAvailRun(availRunByOffset);
            j10 = toRunHandle(iRunOffset, iRunPages + iRunPages2, 0);
        }
    }

    private long collapsePast(long j10) {
        while (true) {
            int iRunOffset = runOffset(j10);
            int iRunPages = runPages(j10);
            long availRunByOffset = getAvailRunByOffset(iRunOffset - 1);
            if (availRunByOffset == -1) {
                return j10;
            }
            int iRunOffset2 = runOffset(availRunByOffset);
            int iRunPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j10 || iRunOffset2 + iRunPages2 != iRunOffset) {
                return j10;
            }
            removeAvailRun(availRunByOffset);
            j10 = toRunHandle(iRunOffset2, iRunPages2 + iRunPages, 0);
        }
    }

    private long collapseRuns(long j10) {
        return collapseNext(collapsePast(j10));
    }

    private long getAvailRunByOffset(int i10) {
        return this.runsAvailMap.get(i10);
    }

    private void insertAvailRun(int i10, int i11, long j10) {
        this.runsAvail[this.arena.pages2pageIdxFloor(i11)].offer((int) (j10 >> 32));
        insertAvailRun0(i10, j10);
        if (i11 > 1) {
            insertAvailRun0(lastPage(i10, i11), j10);
        }
    }

    private void insertAvailRun0(int i10, long j10) {
        this.runsAvailMap.put(i10, j10);
    }

    public static boolean isRun(long j10) {
        return !isSubpage(j10);
    }

    public static boolean isSubpage(long j10) {
        return ((j10 >> 32) & 1) == 1;
    }

    public static boolean isUsed(long j10) {
        return ((j10 >> 33) & 1) == 1;
    }

    private static int lastPage(int i10, int i11) {
        return (i10 + i11) - 1;
    }

    private static IntPriorityQueue[] newRunsAvailqueueArray(int i10) {
        IntPriorityQueue[] intPriorityQueueArr = new IntPriorityQueue[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            intPriorityQueueArr[i11] = new IntPriorityQueue();
        }
        return intPriorityQueueArr;
    }

    private void removeAvailRun(long j10) {
        this.runsAvail[this.arena.pages2pageIdxFloor(runPages(j10))].remove((int) (j10 >> 32));
        removeAvailRun0(j10);
    }

    private void removeAvailRun0(long j10) {
        int iRunOffset = runOffset(j10);
        int iRunPages = runPages(j10);
        this.runsAvailMap.remove(iRunOffset);
        if (iRunPages > 1) {
            this.runsAvailMap.remove(lastPage(iRunOffset, iRunPages));
        }
    }

    private int runFirstBestFit(int i10) {
        if (this.freeBytes == this.chunkSize) {
            return this.arena.nPSizes - 1;
        }
        while (i10 < this.arena.nPSizes) {
            IntPriorityQueue intPriorityQueue = this.runsAvail[i10];
            if (intPriorityQueue != null && !intPriorityQueue.isEmpty()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int runOffset(long j10) {
        return (int) (j10 >> 49);
    }

    public static int runPages(long j10) {
        return (int) ((j10 >> 34) & 32767);
    }

    public static int runSize(int i10, long j10) {
        return runPages(j10) << i10;
    }

    private long splitLargeRun(long j10, int i10) {
        int iRunPages = runPages(j10) - i10;
        if (iRunPages <= 0) {
            return j10 | 8589934592L;
        }
        int iRunOffset = runOffset(j10);
        int i11 = iRunOffset + i10;
        insertAvailRun(i11, iRunPages, toRunHandle(i11, iRunPages, 0));
        return toRunHandle(iRunOffset, i10, 1);
    }

    private static long toRunHandle(int i10, int i11, int i12) {
        return (((long) i11) << 34) | (((long) i10) << 49) | (((long) i12) << 33);
    }

    public boolean allocate(PooledByteBuf<T> pooledByteBuf, int i10, int i11, PoolThreadCache poolThreadCache) {
        long j10;
        PoolArena<T> poolArena = this.arena;
        if (i11 <= poolArena.smallMaxSizeIdx) {
            PoolSubpage<T> poolSubpage = poolArena.smallSubpagePools[i11];
            poolSubpage.lock();
            try {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                if (poolSubpage2 != poolSubpage) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, null, poolSubpage2.allocate(), i10, poolThreadCache);
                    poolSubpage.unlock();
                    return true;
                }
                long jAllocateSubpage = allocateSubpage(i11, poolSubpage);
                if (jAllocateSubpage < 0) {
                    poolSubpage.unlock();
                    return false;
                }
                poolSubpage.unlock();
                j10 = jAllocateSubpage;
            } catch (Throwable th2) {
                poolSubpage.unlock();
                throw th2;
            }
        } else {
            long jAllocateRun = allocateRun(poolArena.sizeIdx2size(i11));
            if (jAllocateRun < 0) {
                return false;
            }
            j10 = jAllocateRun;
        }
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        initBuf(pooledByteBuf, deque != null ? deque.pollLast() : null, j10, i10, poolThreadCache);
        return true;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    public void decrementPinnedMemory(int i10) {
        this.pinnedBytes.add(-i10);
    }

    public void destroy() {
        this.arena.destroyChunk(this);
    }

    public void free(long j10, int i10, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        if (isSubpage(j10)) {
            int iRunOffset = runOffset(j10);
            PoolSubpage<T> poolSubpage = this.subpages[iRunOffset];
            PoolSubpage<T> poolSubpage2 = poolSubpage.chunk.arena.smallSubpagePools[poolSubpage.headIndex];
            poolSubpage2.lock();
            try {
                if (poolSubpage.free(poolSubpage2, bitmapIdx(j10))) {
                    poolSubpage2.unlock();
                    return;
                } else {
                    this.subpages[iRunOffset] = null;
                    poolSubpage2.unlock();
                }
            } catch (Throwable th2) {
                poolSubpage2.unlock();
                throw th2;
            }
        }
        int iRunSize = runSize(this.pageShifts, j10);
        this.runsAvailLock.lock();
        try {
            long jCollapseRuns = collapseRuns(j10) & (-12884901889L);
            insertAvailRun(runOffset(jCollapseRuns), runPages(jCollapseRuns), jCollapseRuns);
            this.freeBytes += iRunSize;
            this.runsAvailLock.unlock();
            if (byteBuffer == null || (deque = this.cachedNioBuffers) == null || deque.size() >= PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
                return;
            }
            this.cachedNioBuffers.offer(byteBuffer);
        } catch (Throwable th3) {
            this.runsAvailLock.unlock();
            throw th3;
        }
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        if (this.unpooled) {
            return this.freeBytes;
        }
        this.runsAvailLock.lock();
        try {
            return this.freeBytes;
        } finally {
            this.runsAvailLock.unlock();
        }
    }

    public void incrementPinnedMemory(int i10) {
        this.pinnedBytes.add(i10);
    }

    public void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        if (isSubpage(j10)) {
            initBufWithSubpage(pooledByteBuf, byteBuffer, j10, i10, poolThreadCache);
        } else {
            pooledByteBuf.init(this, byteBuffer, j10, runOffset(j10) << this.pageShifts, i10, runSize(this.pageShifts, j10), this.arena.parent.threadCache());
        }
    }

    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        int iRunOffset = runOffset(j10);
        int iBitmapIdx = bitmapIdx(j10);
        PoolSubpage<T> poolSubpage = this.subpages[iRunOffset];
        int i11 = iRunOffset << this.pageShifts;
        int i12 = poolSubpage.elemSize;
        pooledByteBuf.init(this, byteBuffer, j10, (iBitmapIdx * i12) + i11, i10, i12, poolThreadCache);
    }

    public int pinnedBytes() {
        return (int) this.pinnedBytes.value();
    }

    public String toString() {
        int i10;
        if (this.unpooled) {
            i10 = this.freeBytes;
        } else {
            this.runsAvailLock.lock();
            try {
                i10 = this.freeBytes;
                this.runsAvailLock.unlock();
            } catch (Throwable th2) {
                this.runsAvailLock.unlock();
                throw th2;
            }
        }
        StringBuilder sb2 = new StringBuilder("Chunk(");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(": ");
        sb2.append(usage(i10));
        sb2.append("%, ");
        sb2.append(this.chunkSize - i10);
        sb2.append(b0.f4502a);
        return a.a(sb2, this.chunkSize, ')');
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int usage() {
        int i10;
        if (this.unpooled) {
            i10 = this.freeBytes;
        } else {
            this.runsAvailLock.lock();
            try {
                i10 = this.freeBytes;
            } finally {
                this.runsAvailLock.unlock();
            }
        }
        return usage(i10);
    }

    private int usage(int i10) {
        if (i10 == 0) {
            return 100;
        }
        int i11 = (int) ((((long) i10) * 100) / ((long) this.chunkSize));
        if (i11 == 0) {
            return 99;
        }
        return 100 - i11;
    }

    public PoolChunk(PoolArena<T> poolArena, Object obj, T t10, int i10) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = true;
        this.arena = poolArena;
        this.base = obj;
        this.memory = t10;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.runsAvailLock = null;
        this.subpages = null;
        this.chunkSize = i10;
        this.cachedNioBuffers = null;
    }
}
