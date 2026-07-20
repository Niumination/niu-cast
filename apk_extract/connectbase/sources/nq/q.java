package nq;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
@lm.z0
public class q<T> extends h1<T> implements p<T>, xm.e, b4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11895f = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11896g = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11897i = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_parentHandle");

    @in.x
    private volatile int _decisionAndIndex;

    @os.m
    @in.x
    private volatile Object _parentHandle;

    @os.m
    @in.x
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final um.d<T> f11898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final um.g f11899e;

    /* JADX WARN: Multi-variable type inference failed */
    public q(@os.l um.d<? super T> dVar, int i10) {
        super(i10);
        this.f11898d = dVar;
        this.f11899e = dVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f11834a;
    }

    private final void J(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final void K(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void T(q qVar, Object obj, int i10, jn.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        qVar.S(obj, i10, lVar);
    }

    private final boolean V() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11895f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f11895f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    private final boolean X() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11895f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f11895f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    @os.m
    public final Object A() {
        return f11896g.get(this);
    }

    public final String B() {
        Object obj = f11896g.get(this);
        if (obj instanceof b3) {
            return "Active";
        }
        return obj instanceof t ? "Cancelled" : "Completed";
    }

    public final n1 C() {
        l2 l2Var = (l2) getContext().get(l2.f11882k);
        if (l2Var == null) {
            return null;
        }
        n1 n1VarG = l2.a.g(l2Var, true, false, new u(this), 2, null);
        j.d.a(f11897i, this, null, n1VarG);
        return n1VarG;
    }

    public final void D(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof n ? true : obj2 instanceof vq.r0) {
                    N(obj, obj2);
                } else {
                    if (obj2 instanceof d0) {
                        d0 d0Var = (d0) obj2;
                        if (!d0Var.b()) {
                            N(obj, obj2);
                        }
                        if (obj2 instanceof t) {
                            if (!(obj2 instanceof d0)) {
                                d0Var = null;
                            }
                            Throwable th2 = d0Var != null ? d0Var.f11836a : null;
                            if (obj instanceof n) {
                                p((n) obj, th2);
                                return;
                            } else {
                                kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                s((vq.r0) obj, th2);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof c0) {
                        c0 c0Var = (c0) obj2;
                        if (c0Var.f11827b != null) {
                            N(obj, obj2);
                        }
                        if (obj instanceof vq.r0) {
                            return;
                        }
                        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        n nVar = (n) obj;
                        if (c0Var.h()) {
                            p(nVar, c0Var.f11830e);
                            return;
                        } else {
                            if (j.d.a(f11896g, this, obj2, c0.g(c0Var, null, nVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof vq.r0) {
                            return;
                        }
                        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (j.d.a(f11896g, this, obj2, new c0(obj2, (n) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (j.d.a(f11896g, this, obj2, obj)) {
                return;
            }
        }
    }

    public final boolean E() {
        if (i1.d(this.f11857c)) {
            um.d<T> dVar = this.f11898d;
            kn.l0.n(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((vq.m) dVar).s()) {
                return true;
            }
        }
        return false;
    }

    @Override // nq.p
    public void F() {
        n1 n1VarC = C();
        if (n1VarC != null && isCompleted()) {
            n1VarC.dispose();
            f11897i.set(this, a3.f11823a);
        }
    }

    @Override // nq.p
    public void G(@os.l n0 n0Var, T t10) {
        um.d<T> dVar = this.f11898d;
        vq.m mVar = dVar instanceof vq.m ? (vq.m) dVar : null;
        T(this, t10, (mVar != null ? mVar.f17863d : null) == n0Var ? 4 : this.f11857c, null, 4, null);
    }

    @Override // nq.p
    public void H(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        D(L(lVar));
    }

    @Override // nq.p
    @os.m
    public Object I(T t10, @os.m Object obj, @os.m jn.l<? super Throwable, lm.l2> lVar) {
        return W(t10, obj, lVar);
    }

    public final n L(jn.l<? super Throwable, lm.l2> lVar) {
        return lVar instanceof n ? (n) lVar : new i2(lVar);
    }

    @Override // nq.p
    public void M(@os.l Object obj) {
        w(this.f11857c);
    }

    public final void N(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    @os.l
    public String O() {
        return "CancellableContinuation";
    }

    public final void P(@os.l Throwable th2) {
        if (t(th2)) {
            return;
        }
        c(th2);
        v();
    }

    public final void Q() {
        Throwable thZ;
        um.d<T> dVar = this.f11898d;
        vq.m mVar = dVar instanceof vq.m ? (vq.m) dVar : null;
        if (mVar == null || (thZ = mVar.z(this)) == null) {
            return;
        }
        u();
        c(thZ);
    }

    @in.i(name = "resetStateReusable")
    public final boolean R() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof c0) && ((c0) obj).f11829d != null) {
            u();
            return false;
        }
        f11895f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f11834a);
        return true;
    }

    public final void S(Object obj, int i10, jn.l<? super Throwable, lm.l2> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof b3)) {
                if (obj2 instanceof t) {
                    t tVar = (t) obj2;
                    if (tVar.c()) {
                        if (lVar != null) {
                            r(lVar, tVar.f11836a);
                            return;
                        }
                        return;
                    }
                }
                n(obj);
                throw new lm.y();
            }
        } while (!j.d.a(f11896g, this, obj2, U((b3) obj2, obj, i10, lVar, null)));
        v();
        w(i10);
    }

    public final Object U(b3 b3Var, Object obj, int i10, jn.l<? super Throwable, lm.l2> lVar, Object obj2) {
        if (obj instanceof d0) {
            return obj;
        }
        if (!i1.c(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(b3Var instanceof n) && obj2 == null) {
            return obj;
        }
        return new c0(obj, b3Var instanceof n ? (n) b3Var : null, lVar, obj2, null, 16, null);
    }

    public final vq.u0 W(Object obj, Object obj2, jn.l<? super Throwable, lm.l2> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof b3)) {
                if ((obj3 instanceof c0) && obj2 != null && ((c0) obj3).f11829d == obj2) {
                    return r.f11909g;
                }
                return null;
            }
        } while (!j.d.a(f11896g, this, obj3, U((b3) obj3, obj, this.f11857c, lVar, obj2)));
        v();
        return r.f11909g;
    }

    public final void Y(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, Integer> lVar, Object obj) {
        int i10;
        do {
            i10 = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i10, lVar.invoke(Integer.valueOf(i10)).intValue()));
    }

    @Override // nq.h1
    public void b(@os.m Object obj, @os.l Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b3) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof d0) {
                return;
            }
            if (obj2 instanceof c0) {
                c0 c0Var = (c0) obj2;
                if (c0Var.h()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                if (j.d.a(f11896g, this, obj2, c0.g(c0Var, null, null, null, null, th2, 15, null))) {
                    c0Var.i(this, th2);
                    return;
                }
            } else if (j.d.a(f11896g, this, obj2, new c0(obj2, null, null, null, th2, 14, null))) {
                return;
            }
        }
    }

    @Override // nq.p
    public boolean c(@os.m Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11896g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof b3)) {
                return false;
            }
        } while (!j.d.a(f11896g, this, obj, new t(this, th2, (obj instanceof n) || (obj instanceof vq.r0))));
        b3 b3Var = (b3) obj;
        if (b3Var instanceof n) {
            p((n) obj, th2);
        } else if (b3Var instanceof vq.r0) {
            s((vq.r0) obj, th2);
        }
        v();
        w(this.f11857c);
        return true;
    }

    @Override // nq.b4
    public void d(@os.l vq.r0<?> r0Var, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11895f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        D(r0Var);
    }

    @Override // nq.p
    @os.m
    public Object e(T t10, @os.m Object obj) {
        return W(t10, obj, null);
    }

    @Override // nq.h1
    @os.l
    public final um.d<T> f() {
        return this.f11898d;
    }

    @Override // nq.p
    public void g(T t10, @os.m jn.l<? super Throwable, lm.l2> lVar) {
        S(t10, this.f11857c, lVar);
    }

    @Override // xm.e
    @os.m
    public xm.e getCallerFrame() {
        um.d<T> dVar = this.f11898d;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return this.f11899e;
    }

    @Override // xm.e
    @os.m
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // nq.h1
    @os.m
    public Throwable h(@os.m Object obj) {
        Throwable thH = super.h(obj);
        if (thH != null) {
            return thH;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nq.h1
    public <T> T i(@os.m Object obj) {
        return obj instanceof c0 ? (T) ((c0) obj).f11826a : obj;
    }

    @Override // nq.p
    public boolean isActive() {
        return f11896g.get(this) instanceof b3;
    }

    @Override // nq.p
    public boolean isCancelled() {
        return f11896g.get(this) instanceof t;
    }

    @Override // nq.p
    public boolean isCompleted() {
        return !(f11896g.get(this) instanceof b3);
    }

    @Override // nq.p
    @os.m
    public Object j(@os.l Throwable th2) {
        return W(new d0(th2, false, 2, null), null, null);
    }

    @Override // nq.p
    public void l(@os.l n0 n0Var, @os.l Throwable th2) {
        um.d<T> dVar = this.f11898d;
        vq.m mVar = dVar instanceof vq.m ? (vq.m) dVar : null;
        T(this, new d0(th2, false, 2, null), (mVar != null ? mVar.f17863d : null) == n0Var ? 4 : this.f11857c, null, 4, null);
    }

    @Override // nq.h1
    @os.m
    public Object m() {
        return f11896g.get(this);
    }

    public final Void n(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void o(jn.l<? super Throwable, lm.l2> lVar, Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            p0.b(getContext(), new g0("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void p(@os.l n nVar, @os.m Throwable th2) {
        try {
            nVar.invoke(th2);
        } catch (Throwable th3) {
            p0.b(getContext(), new g0("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void q(jn.a<lm.l2> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th2) {
            p0.b(getContext(), new g0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void r(@os.l jn.l<? super Throwable, lm.l2> lVar, @os.l Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            p0.b(getContext(), new g0("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        T(this, j0.c(obj, this), this.f11857c, null, 4, null);
    }

    public final void s(vq.r0<?> r0Var, Throwable th2) {
        int i10 = f11895f.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            r0Var.q(i10, th2, getContext());
        } catch (Throwable th3) {
            p0.b(getContext(), new g0("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final boolean t(Throwable th2) {
        if (!E()) {
            return false;
        }
        um.d<T> dVar = this.f11898d;
        kn.l0.n(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((vq.m) dVar).u(th2);
    }

    @os.l
    public String toString() {
        return O() + '(' + x0.c(this.f11898d) + "){" + B() + "}@" + x0.b(this);
    }

    public final void u() {
        n1 n1VarY = y();
        if (n1VarY == null) {
            return;
        }
        n1VarY.dispose();
        f11897i.set(this, a3.f11823a);
    }

    public final void v() {
        if (E()) {
            return;
        }
        u();
    }

    public final void w(int i10) {
        if (V()) {
            return;
        }
        i1.a(this, i10);
    }

    @os.l
    public Throwable x(@os.l l2 l2Var) {
        return l2Var.O();
    }

    public final n1 y() {
        return (n1) f11897i.get(this);
    }

    @os.m
    @lm.z0
    public final Object z() {
        l2 l2Var;
        boolean zE = E();
        if (X()) {
            if (y() == null) {
                C();
            }
            if (zE) {
                Q();
            }
            return wm.a.COROUTINE_SUSPENDED;
        }
        if (zE) {
            Q();
        }
        Object obj = f11896g.get(this);
        if (obj instanceof d0) {
            throw ((d0) obj).f11836a;
        }
        if (!i1.c(this.f11857c) || (l2Var = (l2) getContext().get(l2.f11882k)) == null || l2Var.isActive()) {
            return i(obj);
        }
        CancellationException cancellationExceptionO = l2Var.O();
        b(obj, cancellationExceptionO);
        throw cancellationExceptionO;
    }
}
