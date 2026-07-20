package vq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
public final class c0<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17808h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17809i = 30;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17810j = 1073741823;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17811k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f17812l = 1073741823;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f17813m = 30;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f17814n = 1152921503533105152L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17815o = 60;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f17816p = 1152921504606846976L;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f17817q = 61;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f17818r = 2305843009213693952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f17819s = 1024;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17821u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17822v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f17823w = 2;

    @os.m
    @in.x
    private volatile Object _next;

    @in.x
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final AtomicReferenceArray f17827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17805e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17806f = AtomicReferenceFieldUpdater.newUpdater(c0.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f17807g = AtomicLongFieldUpdater.newUpdater(c0.class, "_state");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @in.f
    @os.l
    public static final u0 f17820t = new u0("REMOVE_FROZEN");

    public static final class a {
        public a() {
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return (j10 & (-1073741824)) | ((long) i10);
        }

        public final long c(long j10, int i10) {
            return (j10 & (-1152921503533105153L)) | (((long) i10) << 30);
        }

        public final <T> T d(long j10, @os.l jn.p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.invoke(Integer.valueOf((int) (1073741823 & j10)), Integer.valueOf((int) ((j10 & 1152921503533105152L) >> 30)));
        }

        public final long e(long j10, long j11) {
            return j10 & (~j11);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        public final int f17828a;

        public b(int i10) {
            this.f17828a = i10;
        }
    }

    public c0(int i10, boolean z10) {
        this.f17824a = i10;
        this.f17825b = z10;
        int i11 = i10 - 1;
        this.f17826c = i11;
        this.f17827d = new AtomicReferenceArray(i10);
        if (i11 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(@os.l E e10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j10) != 0) {
                return f17805e.a(j10);
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f17826c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            if (!this.f17825b && this.f17827d.get(i11 & i12) != null) {
                int i13 = this.f17824a;
                if (i13 < 1024 || ((i11 - i10) & 1073741823) > (i13 >> 1)) {
                    return 1;
                }
            } else if (f17807g.compareAndSet(this, j10, f17805e.c(j10, (i11 + 1) & 1073741823))) {
                this.f17827d.set(i11 & i12, e10);
                while ((f17807g.get(this) & 1152921504606846976L) != 0 && (this = this.m().e(i11, e10)) != null) {
                }
                return 0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c0<E> b(long j10) {
        c0<E> c0Var = new c0<>(this.f17824a * 2, this.f17825b);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f17826c;
            if ((i10 & i12) == (i11 & i12)) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
                f17805e.getClass();
                atomicLongFieldUpdater.set(c0Var, j10 & (-1152921504606846977L));
                return c0Var;
            }
            Object bVar = this.f17827d.get(i12 & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            c0Var.f17827d.set(c0Var.f17826c & i10, bVar);
            i10++;
        }
    }

    public final c0<E> c(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17806f;
        while (true) {
            c0<E> c0Var = (c0) atomicReferenceFieldUpdater.get(this);
            if (c0Var != null) {
                return c0Var;
            }
            j.d.a(f17806f, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final c0<E> e(int i10, E e10) {
        Object obj = this.f17827d.get(this.f17826c & i10);
        if (!(obj instanceof b) || ((b) obj).f17828a != i10) {
            return null;
        }
        this.f17827d.set(i10 & this.f17826c, e10);
        return this;
    }

    public final int f() {
        long j10 = f17807g.get(this);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final boolean g() {
        return (f17807g.get(this) & 2305843009213693952L) != 0;
    }

    public final boolean h() {
        long j10 = f17807g.get(this);
        return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final void i(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final void j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @os.l
    public final <R> List<R> k(@os.l jn.l<? super E, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(this.f17824a);
        long j10 = f17807g.get(this);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((j10 & 1152921503533105152L) >> 30);
        while (true) {
            int i12 = this.f17826c;
            if ((i10 & i12) == (i11 & i12)) {
                return arrayList;
            }
            a1.d dVar = (Object) this.f17827d.get(i12 & i10);
            if (dVar != null && !(dVar instanceof b)) {
                arrayList.add(lVar.invoke(dVar));
            }
            i10++;
        }
    }

    public final long l() {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j11));
        return j11;
    }

    @os.l
    public final c0<E> m() {
        return c(l());
    }

    @os.m
    public final Object n() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return f17820t;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = this.f17826c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            Object obj = this.f17827d.get(i11 & i10);
            if (obj == null) {
                if (this.f17825b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                if (f17807g.compareAndSet(this, j10, f17805e.b(j10, i12))) {
                    this.f17827d.set(this.f17826c & i10, null);
                    return obj;
                }
                if (this.f17825b) {
                    do {
                        this = this.o(i10, i12);
                    } while (this != null);
                    return obj;
                }
            }
        }
    }

    public final c0<E> o(int i10, int i11) {
        long j10;
        int i12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17807g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            i12 = (int) (1073741823 & j10);
            if ((1152921504606846976L & j10) != 0) {
                return m();
            }
        } while (!f17807g.compareAndSet(this, j10, f17805e.b(j10, i11)));
        this.f17827d.set(this.f17826c & i12, null);
        return null;
    }

    public final void p(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, Long> lVar, Object obj) {
        long j10;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lVar.invoke(Long.valueOf(j10)).longValue()));
    }

    public final long q(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, Long> lVar, Object obj) {
        long j10;
        Long lInvoke;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
            lInvoke = lVar.invoke(Long.valueOf(j10));
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lInvoke.longValue()));
        return lInvoke.longValue();
    }
}
