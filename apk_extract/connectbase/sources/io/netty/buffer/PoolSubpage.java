package io.netty.buffer;

import c.a;
import el.b0;
import h.b;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private final int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    final int elemSize;
    final int headIndex;
    final ReentrantLock lock;
    private final int maxNumElems;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage<T> prev;
    private final int runOffset;
    private final int runSize;

    public PoolSubpage(int i10) {
        this.chunk = null;
        this.lock = new ReentrantLock();
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
        this.bitmapLength = -1;
        this.maxNumElems = 0;
        this.headIndex = i10;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        for (int i10 = 0; i10 < this.bitmapLength; i10++) {
            long j10 = this.bitmap[i10];
            if ((~j10) != 0) {
                return findNextAvail0(i10, j10);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i10, long j10) {
        int i11 = i10 << 6;
        for (int i12 = 0; i12 < 64; i12++) {
            if ((1 & j10) == 0) {
                int i13 = i11 | i12;
                if (i13 < this.maxNumElems) {
                    return i13;
                }
                return -1;
            }
            j10 >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i10 = this.nextAvail;
        if (i10 < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i10;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i10) {
        this.nextAvail = i10;
    }

    private long toHandle(int i10) {
        return ((long) i10) | (((long) this.runOffset) << 49) | (((long) (this.runSize >> this.pageShifts)) << 34) | 12884901888L;
    }

    public long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        if (nextAvail < 0) {
            removeFromPool();
            StringBuilder sbA = b.a("No next available bitmap index found (bitmapIdx = ", nextAvail, "), even though there are supposed to be (numAvail = ");
            sbA.append(this.numAvail);
            sbA.append(") out of (maxNumElems = ");
            throw new AssertionError(a.a(sbA, this.maxNumElems, ") available indexes."));
        }
        int i10 = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i10] = jArr[i10] | (1 << (nextAvail & 63));
        int i11 = this.numAvail - 1;
        this.numAvail = i11;
        if (i11 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    public void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        return this.elemSize;
    }

    public boolean free(PoolSubpage<T> poolSubpage, int i10) {
        int i11 = i10 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i11] = jArr[i11] ^ (1 << (i10 & 63));
        setNextAvail(i10);
        int i12 = this.numAvail;
        this.numAvail = i12 + 1;
        if (i12 == 0) {
            addToPool(poolSubpage);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    public boolean isDoNotDestroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return true;
        }
        PoolSubpage<T> poolSubpage = poolChunk.arena.smallSubpagePools[this.headIndex];
        poolSubpage.lock();
        try {
            return this.doNotDestroy;
        } finally {
            poolSubpage.unlock();
        }
    }

    public void lock() {
        this.lock.lock();
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        return this.maxNumElems;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        PoolSubpage<T> poolSubpage = poolChunk.arena.smallSubpagePools[this.headIndex];
        poolSubpage.lock();
        try {
            return this.numAvail;
        } finally {
            poolSubpage.unlock();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    public String toString() {
        int i10;
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            i10 = 0;
        } else {
            PoolSubpage<T> poolSubpage = poolChunk.arena.smallSubpagePools[this.headIndex];
            poolSubpage.lock();
            try {
                boolean z10 = this.doNotDestroy;
                int i11 = this.numAvail;
                poolSubpage.unlock();
                if (!z10) {
                    return a.a(new StringBuilder("("), this.runOffset, ": not in use)");
                }
                i10 = i11;
            } catch (Throwable th2) {
                poolSubpage.unlock();
                throw th2;
            }
        }
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(this.runOffset);
        sb2.append(": ");
        sb2.append(this.maxNumElems - i10);
        sb2.append(b0.f4502a);
        sb2.append(this.maxNumElems);
        sb2.append(", offset: ");
        sb2.append(this.runOffset);
        sb2.append(", length: ");
        sb2.append(this.runSize);
        sb2.append(", elemSize: ");
        return u.a.a(sb2, this.elemSize, ')');
    }

    public void unlock() {
        this.lock.unlock();
    }

    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i10, int i11, int i12, int i13) {
        this.headIndex = poolSubpage.headIndex;
        this.chunk = poolChunk;
        this.pageShifts = i10;
        this.runOffset = i11;
        this.runSize = i12;
        this.elemSize = i13;
        this.doNotDestroy = true;
        int i14 = i12 / i13;
        this.numAvail = i14;
        this.maxNumElems = i14;
        int i15 = i14 >>> 6;
        i15 = (i14 & 63) != 0 ? i15 + 1 : i15;
        this.bitmapLength = i15;
        this.bitmap = new long[i15];
        this.nextAvail = 0;
        this.lock = null;
        addToPool(poolSubpage);
    }
}
