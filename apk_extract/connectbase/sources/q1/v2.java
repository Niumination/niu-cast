package q1;

import f1.p4;
import f1.r4;
import f1.s4;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class v2<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13738a = 1024;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13739b = -1;

    public static class b<L> extends f<L> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object[] f13740d;

        @Override // q1.v2
        public L j(int i10) {
            return (L) this.f13740d[i10];
        }

        @Override // q1.v2
        public int v() {
            return this.f13740d.length;
        }

        public b(int stripes, c1.q0<L> supplier) {
            super(stripes);
            int i10 = 0;
            c1.h0.e(stripes <= 1073741824, "Stripes must be <= 2^30)");
            this.f13740d = new Object[this.f13744c + 1];
            while (true) {
                Object[] objArr = this.f13740d;
                if (i10 >= objArr.length) {
                    return;
                }
                objArr[i10] = supplier.get();
                i10++;
            }
        }
    }

    @b1.e
    public static class c<L> extends f<L> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConcurrentMap<Integer, L> f13741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c1.q0<L> f13742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f13743f;

        public c(int stripes, c1.q0<L> supplier) {
            super(stripes);
            int i10 = this.f13744c;
            this.f13743f = i10 == -1 ? Integer.MAX_VALUE : i10 + 1;
            this.f13742e = supplier;
            this.f13741d = new r4().k(s4.q.WEAK).i();
        }

        @Override // q1.v2
        public L j(int i10) {
            if (this.f13743f != Integer.MAX_VALUE) {
                c1.h0.C(i10, v());
            }
            L l10 = this.f13741d.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10;
            }
            L l11 = this.f13742e.get();
            return (L) c1.z.a(this.f13741d.putIfAbsent(Integer.valueOf(i10), l11), l11);
        }

        @Override // q1.v2
        public int v() {
            return this.f13743f;
        }
    }

    public static class d extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public d() {
            super(false);
        }
    }

    public static class e extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public e(int permits) {
            super(permits, false);
        }
    }

    public static abstract class f<L> extends v2<L> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13744c;

        public f(int stripes) {
            c1.h0.e(stripes > 0, "Stripes must be positive");
            this.f13744c = stripes > 1073741824 ? -1 : v2.g(stripes) - 1;
        }

        @Override // q1.v2
        public final L i(Object key) {
            return j(k(key));
        }

        @Override // q1.v2
        public final int k(Object key) {
            return this.f13744c & v2.w(key.hashCode());
        }
    }

    @b1.e
    public static class g<L> extends f<L> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceArray<a<? extends L>> f13745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c1.q0<L> f13746e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f13747f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ReferenceQueue<L> f13748g;

        public static final class a<L> extends WeakReference<L> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f13749a;

            public a(L referent, int index, ReferenceQueue<L> queue) {
                super(referent, queue);
                this.f13749a = index;
            }
        }

        public g(int stripes, c1.q0<L> supplier) {
            super(stripes);
            this.f13748g = new ReferenceQueue<>();
            int i10 = this.f13744c;
            int i11 = i10 == -1 ? Integer.MAX_VALUE : i10 + 1;
            this.f13747f = i11;
            this.f13745d = new AtomicReferenceArray<>(i11);
            this.f13746e = supplier;
        }

        @Override // q1.v2
        public L j(int index) {
            if (this.f13747f != Integer.MAX_VALUE) {
                c1.h0.C(index, v());
            }
            a<? extends L> aVar = this.f13745d.get(index);
            L l10 = aVar == null ? null : aVar.get();
            if (l10 != null) {
                return l10;
            }
            L l11 = this.f13746e.get();
            a aVar2 = new a(l11, index, this.f13748g);
            while (!w2.a(this.f13745d, index, aVar, aVar2)) {
                aVar = this.f13745d.get(index);
                L l12 = aVar == null ? null : aVar.get();
                if (l12 != null) {
                    return l12;
                }
            }
            x();
            return l11;
        }

        @Override // q1.v2
        public int v() {
            return this.f13747f;
        }

        public final void x() {
            while (true) {
                Reference<? extends L> referencePoll = this.f13748g.poll();
                if (referencePoll == null) {
                    return;
                }
                a aVar = (a) referencePoll;
                w2.a(this.f13745d, aVar.f13749a, aVar, null);
            }
        }
    }

    public static final class h extends x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Condition f13750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f13751b;

        public h(Condition delegate, j strongReference) {
            this.f13750a = delegate;
            this.f13751b = strongReference;
        }

        @Override // q1.x0
        public Condition a() {
            return this.f13750a;
        }
    }

    public static final class i extends d1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f13752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f13753b;

        public i(Lock delegate, j strongReference) {
            this.f13752a = delegate;
            this.f13753b = strongReference;
        }

        @Override // q1.d1
        public Lock a() {
            return this.f13752a;
        }

        @Override // q1.d1, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new h(this.f13752a.newCondition(), this.f13753b);
        }
    }

    public static final class j implements ReadWriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReadWriteLock f13754a = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new i(this.f13754a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new i(this.f13754a.writeLock(), this);
        }
    }

    public v2() {
    }

    public static /* synthetic */ Semaphore a(int i10) {
        return new e(i10);
    }

    public static int g(int x10) {
        return 1 << m1.f.p(x10, RoundingMode.CEILING);
    }

    public static <L> v2<L> h(int stripes, c1.q0<L> supplier) {
        return new b(stripes, supplier);
    }

    public static /* synthetic */ Lock l() {
        return new ReentrantLock(false);
    }

    public static /* synthetic */ Semaphore m(int i10) {
        return new Semaphore(i10, false);
    }

    public static /* synthetic */ Semaphore n(int i10) {
        return new e(i10);
    }

    public static <L> v2<L> o(int stripes, c1.q0<L> supplier) {
        return stripes < 1024 ? new g(stripes, supplier) : new c(stripes, supplier);
    }

    public static v2<Lock> p(int stripes) {
        return o(stripes, new t2());
    }

    public static v2<ReadWriteLock> q(int stripes) {
        return o(stripes, new p2());
    }

    public static v2<Semaphore> r(int stripes, final int permits) {
        return o(stripes, new c1.q0() { // from class: q1.s2
            @Override // c1.q0
            public final Object get() {
                return v2.m(permits);
            }
        });
    }

    public static v2<Lock> s(int stripes) {
        return new b(stripes, new q2());
    }

    public static v2<ReadWriteLock> t(int stripes) {
        return new b(stripes, new u2());
    }

    public static v2<Semaphore> u(int stripes, final int permits) {
        return new b(stripes, new c1.q0() { // from class: q1.r2
            @Override // c1.q0
            public final Object get() {
                return new v2.e(permits);
            }
        });
    }

    public static int w(int hashCode) {
        int i10 = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return (i10 >>> 4) ^ ((i10 >>> 7) ^ i10);
    }

    public Iterable<L> f(Iterable<? extends Object> keys) {
        ArrayList arrayListR = p4.r(keys);
        if (arrayListR.isEmpty()) {
            return f1.i3.of();
        }
        int[] iArr = new int[arrayListR.size()];
        for (int i10 = 0; i10 < arrayListR.size(); i10++) {
            iArr[i10] = k(arrayListR.get(i10));
        }
        Arrays.sort(iArr);
        int i11 = iArr[0];
        arrayListR.set(0, j(i11));
        for (int i12 = 1; i12 < arrayListR.size(); i12++) {
            int i13 = iArr[i12];
            if (i13 == i11) {
                arrayListR.set(i12, arrayListR.get(i12 - 1));
            } else {
                arrayListR.set(i12, j(i13));
                i11 = i13;
            }
        }
        return Collections.unmodifiableList(arrayListR);
    }

    public abstract L i(Object key);

    public abstract L j(int index);

    public abstract int k(Object key);

    public abstract int v();

    public v2(a aVar) {
    }
}
