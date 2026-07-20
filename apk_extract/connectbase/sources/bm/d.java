package bm;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kn.l0;
import kn.w;
import kn.x0;
import os.l;
import os.m;
import q1.w2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T> implements h<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final b f970f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final AtomicLongFieldUpdater<d<?>> f971g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final AtomicReferenceArray<T> f975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final int[] f976e;
    private volatile long top;

    public static final class b {
        public b() {
        }

        public b(w wVar) {
        }
    }

    static {
        AtomicLongFieldUpdater<d<?>> atomicLongFieldUpdaterNewUpdater = AtomicLongFieldUpdater.newUpdater(d.class, new x0() { // from class: bm.d.a
            @Override // kn.x0, un.q
            @m
            public Object get(@m Object obj) {
                return Long.valueOf(((d) obj).top);
            }

            @Override // kn.x0, un.l
            public void set(@m Object obj, @m Object obj2) {
                ((d) obj).top = ((Number) obj2).longValue();
            }
        }.getName());
        l0.o(atomicLongFieldUpdaterNewUpdater, "newUpdater(Owner::class.java, p.name)");
        f971g = atomicLongFieldUpdaterNewUpdater;
    }

    public d(int i10) {
        this.f972a = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(l0.C("capacity should be positive but it is ", Integer.valueOf(i10)).toString());
        }
        if (i10 > 536870911) {
            throw new IllegalArgumentException(l0.C("capacity should be less or equal to 536870911 but it is ", Integer.valueOf(i10)).toString());
        }
        int iHighestOneBit = Integer.highestOneBit((i10 * 4) - 1) * 2;
        this.f973b = iHighestOneBit;
        this.f974c = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        this.f975d = new AtomicReferenceArray<>(iHighestOneBit + 1);
        this.f976e = new int[iHighestOneBit + 1];
    }

    @Override // bm.h
    public final int Q1() {
        return this.f972a;
    }

    @Override // bm.h
    @l
    public final T W0() {
        T tP = p();
        T tD = tP == null ? null : d(tP);
        return tD == null ? n() : tD;
    }

    @Override // bm.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h.a.a(this);
    }

    @l
    public T d(@l T t10) {
        l0.p(t10, "instance");
        return t10;
    }

    @Override // bm.h
    public final void dispose() {
        while (true) {
            T tP = p();
            if (tP == null) {
                return;
            } else {
                h(tP);
            }
        }
    }

    public void h(@l T t10) {
        l0.p(t10, "instance");
    }

    public final int k() {
        long j10;
        long j11;
        int i10;
        do {
            j10 = this.top;
            if (j10 == 0) {
                return 0;
            }
            j11 = ((j10 >> 32) & 4294967295L) + 1;
            i10 = (int) (4294967295L & j10);
            if (i10 == 0) {
                return 0;
            }
        } while (!f971g.compareAndSet(this, j10, (j11 << 32) | ((long) this.f976e[i10])));
        return i10;
    }

    @l
    public abstract T n();

    public final void o(int i10) {
        long j10;
        if (i10 <= 0) {
            throw new IllegalArgumentException("index should be positive");
        }
        do {
            j10 = this.top;
            this.f976e[i10] = (int) (4294967295L & j10);
        } while (!f971g.compareAndSet(this, j10, ((((j10 >> 32) & 4294967295L) + 1) << 32) | ((long) i10)));
    }

    public final T p() {
        int iK = k();
        if (iK == 0) {
            return null;
        }
        return this.f975d.getAndSet(iK, null);
    }

    public final boolean q(T t10) {
        int iIdentityHashCode = ((System.identityHashCode(t10) * (-1640531527)) >>> this.f974c) + 1;
        int i10 = 0;
        while (i10 < 8) {
            i10++;
            if (w2.a(this.f975d, iIdentityHashCode, null, t10)) {
                o(iIdentityHashCode);
                return true;
            }
            iIdentityHashCode--;
            if (iIdentityHashCode == 0) {
                iIdentityHashCode = this.f973b;
            }
        }
        return false;
    }

    @Override // bm.h
    public final void recycle(@l T t10) {
        l0.p(t10, "instance");
        t(t10);
        if (q(t10)) {
            return;
        }
        h(t10);
    }

    public void t(@l T t10) {
        l0.p(t10, "instance");
    }
}
