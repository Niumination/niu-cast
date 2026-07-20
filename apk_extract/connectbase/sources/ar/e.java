package ar;

import in.x;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.p;
import kn.h0;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;
import nq.b4;
import nq.q;
import nq.s;
import os.l;
import os.m;
import q1.w2;
import vq.r0;
import vq.s0;
import xm.h;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
public class e implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final AtomicReferenceFieldUpdater f697c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final AtomicLongFieldUpdater f698d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final AtomicReferenceFieldUpdater f699e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final AtomicLongFieldUpdater f700f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final AtomicIntegerFieldUpdater f701g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");

    @x
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final jn.l<Throwable, l2> f703b;

    @x
    private volatile long deqIdx;

    @x
    private volatile long enqIdx;

    @m
    @x
    private volatile Object head;

    @m
    @x
    private volatile Object tail;

    public /* synthetic */ class a extends h0 implements p<Long, g, g> {
        public static final a INSTANCE = new a();

        public a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @l
        public final g invoke(long j10, @m g gVar) {
            return f.j(j10, gVar);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ g invoke(Long l10, g gVar) {
            return invoke(l10.longValue(), gVar);
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l Throwable th2) {
            e.this.release();
        }
    }

    public /* synthetic */ class c extends h0 implements p<Long, g, g> {
        public static final c INSTANCE = new c();

        public c() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @l
        public final g invoke(long j10, @m g gVar) {
            return f.j(j10, gVar);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ g invoke(Long l10, g gVar) {
            return invoke(l10.longValue(), gVar);
        }
    }

    public e(int i10, int i11) {
        this.f702a = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(h.a.a("Semaphore should have at least 1 permit, but had ", i10).toString());
        }
        if (i11 < 0 || i11 > i10) {
            throw new IllegalArgumentException(h.a.a("The number of acquired permits should be in 0..", i10).toString());
        }
        g gVar = new g(0L, null, 2);
        this.head = gVar;
        this.tail = gVar;
        this._availablePermits = i10 - i11;
        this.f703b = new b();
    }

    public static Object n(e eVar, um.d<? super l2> dVar) {
        Object objO;
        return (eVar.r() <= 0 && (objO = eVar.o(dVar)) == wm.a.COROUTINE_SUSPENDED) ? objO : l2.f10208a;
    }

    @Override // ar.d
    public int a() {
        return Math.max(f701g.get(this), 0);
    }

    @Override // ar.d
    @m
    public Object b(@l um.d<? super l2> dVar) {
        return n(this, dVar);
    }

    @Override // ar.d
    public boolean c() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f701g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f702a) {
                q();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final <W> void l(W w10, jn.l<? super W, Boolean> lVar, jn.l<? super W, l2> lVar2) {
        while (r() <= 0) {
            if (lVar.invoke(w10).booleanValue()) {
                return;
            }
        }
        lVar2.invoke(w10);
    }

    public final void m(@l nq.p<? super l2> pVar) {
        while (r() <= 0) {
            l0.n(pVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (p((b4) pVar)) {
                return;
            }
        }
        pVar.g(l2.f10208a, this.f703b);
    }

    public final Object o(um.d<? super l2> dVar) {
        q qVarB = s.b(wm.c.e(dVar));
        try {
            if (!p(qVarB)) {
                m(qVarB);
            }
            Object objZ = qVarB.z();
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objZ == aVar) {
                h.c(dVar);
            }
            return objZ == aVar ? objZ : l2.f10208a;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }

    public final boolean p(b4 b4Var) {
        Object objG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f699e;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f700f.getAndIncrement(this);
        a aVar = a.INSTANCE;
        long j10 = andIncrement / ((long) f.f709f);
        loop0: while (true) {
            objG = vq.f.g(gVar, j10, aVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        g gVar2 = (g) s0.f(objG);
        int i10 = (int) (andIncrement % ((long) f.f709f));
        if (w2.a(gVar2.f710e, i10, null, b4Var)) {
            b4Var.d(gVar2, i10);
            return true;
        }
        if (!w2.a(gVar2.f710e, i10, f.f705b, f.f706c)) {
            return false;
        }
        if (b4Var instanceof nq.p) {
            l0.n(b4Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((nq.p) b4Var).g(l2.f10208a, this.f703b);
        } else {
            if (!(b4Var instanceof yq.m)) {
                throw new IllegalStateException(("unexpected: " + b4Var).toString());
            }
            ((yq.m) b4Var).f(l2.f10208a);
        }
        return true;
    }

    public final void q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f701g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.f702a;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    public final int r() {
        int andDecrement;
        do {
            andDecrement = f701g.getAndDecrement(this);
        } while (andDecrement > this.f702a);
        return andDecrement;
    }

    @Override // ar.d
    public void release() {
        do {
            int andIncrement = f701g.getAndIncrement(this);
            if (andIncrement >= this.f702a) {
                q();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f702a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!u());
    }

    public final void s(@l yq.m<?> mVar, @m Object obj) {
        while (r() <= 0) {
            l0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (p((b4) mVar)) {
                return;
            }
        }
        mVar.f(l2.f10208a);
    }

    public final boolean t(Object obj) {
        if (!(obj instanceof nq.p)) {
            if (obj instanceof yq.m) {
                return ((yq.m) obj).i(this, l2.f10208a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        nq.p pVar = (nq.p) obj;
        Object objI = pVar.I(l2.f10208a, null, this.f703b);
        if (objI == null) {
            return false;
        }
        pVar.M(objI);
        return true;
    }

    public final boolean u() {
        Object objG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f697c;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f698d.getAndIncrement(this);
        long j10 = andIncrement / ((long) f.f709f);
        c cVar = c.INSTANCE;
        loop0: while (true) {
            objG = vq.f.g(gVar, j10, cVar);
            if (s0.h(objG)) {
                break;
            }
            r0 r0VarF = s0.f(objG);
            while (true) {
                r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                if (r0Var.f17877c >= r0VarF.f17877c) {
                    break loop0;
                }
                if (!r0VarF.s()) {
                    break;
                }
                if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, r0VarF)) {
                    if (!r0Var.o()) {
                        break loop0;
                    }
                    r0Var.l();
                    break loop0;
                }
                if (r0VarF.o()) {
                    r0VarF.l();
                }
            }
        }
        g gVar2 = (g) s0.f(objG);
        gVar2.b();
        if (gVar2.f17877c > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) f.f709f));
        Object andSet = gVar2.f710e.getAndSet(i10, f.f705b);
        if (andSet != null) {
            if (andSet == f.f708e) {
                return false;
            }
            return t(andSet);
        }
        int i11 = f.f704a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (gVar2.f710e.get(i10) == f.f706c) {
                return true;
            }
        }
        return !w2.a(gVar2.f710e, i10, f.f705b, f.f707d);
    }
}
