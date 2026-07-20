package rk;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.p;
import kn.l0;
import kn.w;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14521g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14522h = 30;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14523i = 1073741823;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14524j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f14525k = 1073741823;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14526l = 30;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f14527m = 1152921503533105152L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f14528n = 60;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f14529o = 1152921504606846976L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f14530p = 61;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f14531q = 2305843009213693952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14533s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f14534t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f14535u = 2;

    @os.l
    private volatile /* synthetic */ Object _next = null;

    @os.l
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final AtomicReferenceArray<Object> f14538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final b f14518d = new b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @in.f
    @os.l
    public static final Object f14532r = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14519e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f14520f = AtomicLongFieldUpdater.newUpdater(e.class, "_state");

    public static final class a {
        @os.l
        public String toString() {
            return "REMOVE_FROZEN";
        }
    }

    public static final class b {
        public b() {
        }

        public static final long d(b bVar, long j10, long j11) {
            bVar.getClass();
            return j10 & (~j11);
        }

        public final int e(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long f(long j10, int i10) {
            return (j10 & (-1073741824)) | ((long) i10);
        }

        public final long g(long j10, int i10) {
            return (j10 & (-1152921503533105153L)) | (((long) i10) << 30);
        }

        public final <T> T h(long j10, p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.invoke(Integer.valueOf((int) (1073741823 & j10)), Integer.valueOf((int) ((j10 & 1152921503533105152L) >> 30)));
        }

        public final long i(long j10, long j11) {
            return j10 & (~j11);
        }

        public b(w wVar) {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        public final int f14539a;

        public c(int i10) {
            this.f14539a = i10;
        }
    }

    public e(int i10) {
        this.f14536a = i10;
        int i11 = i10 - 1;
        this.f14537b = i11;
        this.f14538c = new AtomicReferenceArray<>(i10);
        if (i11 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(@os.l E e10) {
        long j10;
        int i10;
        l0.p(e10, "element");
        do {
            j10 = this._state;
            if ((3458764513820540928L & j10) != 0) {
                return f14518d.e(j10);
            }
            i10 = (int) ((1152921503533105152L & j10) >> 30);
            int i11 = this.f14537b;
            if (((i10 + 2) & i11) == (((int) (1073741823 & j10)) & i11)) {
                return 1;
            }
        } while (!f14520f.compareAndSet(this, j10, f14518d.g(j10, (i10 + 1) & 1073741823)));
        this.f14538c.set(this.f14537b & i10, e10);
        while ((this._state & 1152921504606846976L) != 0 && (this = this.h().e(i10, e10)) != null) {
        }
        return 0;
    }

    public final e<E> b(long j10) {
        e<E> eVar = new e<>(this.f14536a * 2);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f14537b;
            if ((i10 & i12) == (i11 & i12)) {
                eVar._state = b.d(f14518d, j10, 1152921504606846976L);
                return eVar;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = eVar.f14538c;
            int i13 = eVar.f14537b & i10;
            Object cVar = this.f14538c.get(i12 & i10);
            if (cVar == null) {
                cVar = new c(i10);
            }
            atomicReferenceArray.set(i13, cVar);
            i10++;
        }
    }

    public final e<E> c(long j10) {
        while (true) {
            e<E> eVar = (e) this._next;
            if (eVar != null) {
                return eVar;
            }
            j.d.a(f14519e, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        do {
            j10 = this._state;
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!f14520f.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final e<E> e(int i10, E e10) {
        Object obj = this.f14538c.get(this.f14537b & i10);
        if (!(obj instanceof c) || ((c) obj).f14539a != i10) {
            return null;
        }
        this.f14538c.set(i10 & this.f14537b, e10);
        return this;
    }

    public final boolean f() {
        long j10 = this._state;
        return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final long g() {
        long j10;
        long j11;
        do {
            j10 = this._state;
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!f14520f.compareAndSet(this, j10, j11));
        return j11;
    }

    @os.l
    public final e<E> h() {
        return c(g());
    }

    @m
    public final Object i() {
        Object obj;
        long j10 = this._state;
        if ((1152921504606846976L & j10) != 0) {
            return f14532r;
        }
        int i10 = (int) (1073741823 & j10);
        int i11 = this.f14537b;
        if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11) || (obj = this.f14538c.get(i11 & i10)) == null || (obj instanceof c)) {
            return null;
        }
        int i12 = (i10 + 1) & 1073741823;
        if (f14520f.compareAndSet(this, j10, f14518d.f(j10, i12))) {
            this.f14538c.set(this.f14537b & i10, null);
            return obj;
        }
        do {
            this = this.j(i10, i12);
        } while (this != null);
        return obj;
    }

    public final e<E> j(int i10, int i11) {
        long j10;
        int i12;
        do {
            j10 = this._state;
            i12 = (int) (1073741823 & j10);
            if (i12 != i10) {
                throw new IllegalStateException("This queue can have only one consumer");
            }
            if ((1152921504606846976L & j10) != 0) {
                return h();
            }
        } while (!f14520f.compareAndSet(this, j10, f14518d.f(j10, i11)));
        this.f14538c.set(this.f14537b & i12, null);
        return null;
    }
}
