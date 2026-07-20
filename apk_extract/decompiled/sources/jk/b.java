package jk;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f6337i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f6338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6339d;
    public final AtomicLong e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6340h;

    public b(int i8) {
        super(i8);
        this.f6338c = new AtomicLong();
        this.e = new AtomicLong();
        this.f6340h = Math.min(i8 / 4, f6337i.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f6338c.get() == this.e.get();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f6335a;
        AtomicLong atomicLong = this.f6338c;
        long j8 = atomicLong.get();
        int i8 = this.f6336b;
        int i9 = ((int) j8) & i8;
        if (j8 >= this.f6339d) {
            long j10 = ((long) this.f6340h) + j8;
            if (atomicReferenceArray.get(i8 & ((int) j10)) == null) {
                this.f6339d = j10;
            } else if (atomicReferenceArray.get(i9) != null) {
                return false;
            }
        }
        atomicLong.lazySet(j8 + 1);
        atomicReferenceArray.lazySet(i9, obj);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        return this.f6335a.get(((int) this.e.get()) & this.f6336b);
    }

    @Override // java.util.Queue
    public final Object poll() {
        AtomicLong atomicLong = this.e;
        long j8 = atomicLong.get();
        int i8 = ((int) j8) & this.f6336b;
        AtomicReferenceArray atomicReferenceArray = this.f6335a;
        Object obj = atomicReferenceArray.get(i8);
        if (obj == null) {
            return null;
        }
        atomicLong.lazySet(j8 + 1);
        atomicReferenceArray.lazySet(i8, null);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        AtomicLong atomicLong = this.e;
        long j8 = atomicLong.get();
        while (true) {
            long j10 = this.f6338c.get();
            long j11 = atomicLong.get();
            if (j8 == j11) {
                return (int) (j10 - j11);
            }
            j8 = j11;
        }
    }
}
