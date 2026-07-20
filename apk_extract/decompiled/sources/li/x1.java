package li;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public class x1 implements p1, f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7509a = AtomicReferenceFieldUpdater.newUpdater(x1.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7510b = AtomicReferenceFieldUpdater.newUpdater(x1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public x1(boolean z2) {
        this._state$volatile = z2 ? l0.f7475j : l0.f7474i;
    }

    public static p g0(qi.m mVar) {
        while (mVar.g()) {
            qi.m mVarD = mVar.d();
            if (mVarD == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.m.f9154b;
                Object obj = atomicReferenceFieldUpdater.get(mVar);
                while (true) {
                    mVar = (qi.m) obj;
                    if (!mVar.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(mVar);
                }
            } else {
                mVar = mVarD;
            }
        }
        while (true) {
            mVar = mVar.f();
            if (!mVar.g()) {
                if (mVar instanceof p) {
                    return (p) mVar;
                }
                if (mVar instanceof b2) {
                    return null;
                }
            }
        }
    }

    public static String o0(Object obj) {
        if (!(obj instanceof w1)) {
            if (obj instanceof l1) {
                return ((l1) obj).a() ? "Active" : "New";
            }
            return obj instanceof u ? "Cancelled" : "Completed";
        }
        w1 w1Var = (w1) obj;
        if (w1Var.e()) {
            return "Cancelling";
        }
        return w1.f7505b.get(w1Var) != 0 ? "Completing" : "Active";
    }

    @Override // li.p1
    public final x0 A(Function1 function1) {
        return Z(true, new y0(function1, 1));
    }

    public void C(CancellationException cancellationException) {
        z(cancellationException);
    }

    public final boolean D(Throwable th2) {
        if (c0()) {
            return true;
        }
        boolean z2 = th2 instanceof CancellationException;
        o oVar = (o) f7510b.get(this);
        if (oVar == null || oVar == d2.f7443a) {
            return z2;
        }
        return oVar.h(th2) || z2;
    }

    public String F() {
        return "Job was cancelled";
    }

    public boolean G(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return z(th2) && Q();
    }

    @Override // li.p1
    public final boolean H() {
        return !(f7509a.get(this) instanceof l1);
    }

    public final void J(l1 l1Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7510b;
        o oVar = (o) atomicReferenceFieldUpdater.get(this);
        if (oVar != null) {
            oVar.dispose();
            atomicReferenceFieldUpdater.set(this, d2.f7443a);
        }
        v vVar = null;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th2 = uVar != null ? uVar.f7494a : null;
        if (l1Var instanceof t1) {
            try {
                ((t1) l1Var).k(th2);
                return;
            } catch (Throwable th3) {
                W(new v("Exception in completion handler " + l1Var + " for " + this, th3));
                return;
            }
        }
        b2 b2VarB = l1Var.b();
        if (b2VarB != null) {
            b2VarB.c(new qi.j(1), 1);
            Object obj2 = qi.m.f9153a.get(b2VarB);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (qi.m mVarF = (qi.m) obj2; !Intrinsics.areEqual(mVarF, b2VarB); mVarF = mVarF.f()) {
                if (mVarF instanceof t1) {
                    try {
                        ((t1) mVarF).k(th2);
                    } catch (Throwable th4) {
                        if (vVar != null) {
                            ExceptionsKt.addSuppressed(vVar, th4);
                        } else {
                            vVar = new v("Exception in completion handler " + mVarF + " for " + this, th4);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (vVar != null) {
                W(vVar);
            }
        }
    }

    public final Throwable K(Object obj) {
        Throwable thD;
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new q1(F(), null, this) : th2;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        x1 x1Var = (x1) ((f2) obj);
        x1Var.getClass();
        Object obj2 = f7509a.get(x1Var);
        if (obj2 instanceof w1) {
            thD = ((w1) obj2).d();
        } else if (obj2 instanceof u) {
            thD = ((u) obj2).f7494a;
        } else {
            if (obj2 instanceof l1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            thD = null;
        }
        CancellationException q1Var = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (q1Var == null) {
            q1Var = new q1("Parent job is ".concat(o0(obj2)), thD, x1Var);
        }
        return q1Var;
    }

    public final Object M(w1 w1Var, Object obj) {
        boolean zE;
        Throwable thP;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th2 = uVar != null ? uVar.f7494a : null;
        synchronized (w1Var) {
            zE = w1Var.e();
            ArrayList<Throwable> arrayListF = w1Var.f(th2);
            thP = P(w1Var, arrayListF);
            if (thP != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                for (Throwable th3 : arrayListF) {
                    if (th3 != thP && th3 != thP && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                        ExceptionsKt.addSuppressed(thP, th3);
                    }
                }
            }
        }
        if (thP != null && thP != th2) {
            obj = new u(false, thP);
        }
        if (thP != null && (D(thP) || U(thP))) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            u uVar2 = (u) obj;
            uVar2.getClass();
            u.f7493b.compareAndSet(uVar2, 0, 1);
        }
        if (!zE) {
            j0(thP);
        }
        k0(obj);
        f7509a.compareAndSet(this, w1Var, obj instanceof l1 ? new m1((l1) obj) : obj);
        J(w1Var, obj);
        return obj;
    }

    public final Object O() throws Throwable {
        Object obj = f7509a.get(this);
        if (obj instanceof l1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof u) {
            throw ((u) obj).f7494a;
        }
        return l0.t(obj);
    }

    public final Throwable P(w1 w1Var, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (w1Var.e()) {
                return new q1(F(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Throwable) next) instanceof CancellationException);
        Throwable th2 = (Throwable) next;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = (Throwable) arrayList.get(0);
        if (th3 instanceof l2) {
            for (Object obj2 : arrayList) {
                Throwable th4 = (Throwable) obj2;
                if (th4 != th3 && (th4 instanceof l2)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        return this instanceof r;
    }

    @Override // li.p1
    public final Object S(Continuation continuation) {
        Object obj;
        do {
            obj = f7509a.get(this);
            if (!(obj instanceof l1)) {
                l0.i(continuation.get$context());
                return Unit.INSTANCE;
            }
        } while (n0(obj) < 0);
        l lVar = new l(1, IntrinsicsKt.intercepted(continuation));
        lVar.s();
        lVar.w(new h(l0.m(this, new n(lVar, 1)), 2));
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objR = Unit.INSTANCE;
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    public final b2 T(l1 l1Var) {
        b2 b2VarB = l1Var.b();
        if (b2VarB != null) {
            return b2VarB;
        }
        if (l1Var instanceof z0) {
            return new b2();
        }
        if (l1Var instanceof t1) {
            m0((t1) l1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + l1Var).toString());
    }

    public boolean U(Throwable th2) {
        return false;
    }

    public void W(v vVar) {
        throw vVar;
    }

    public final void Y(p1 p1Var) {
        d2 d2Var = d2.f7443a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7510b;
        if (p1Var == null) {
            atomicReferenceFieldUpdater.set(this, d2Var);
            return;
        }
        p1Var.start();
        o oVarA0 = p1Var.a0(this);
        atomicReferenceFieldUpdater.set(this, oVarA0);
        if (H()) {
            oVarA0.dispose();
            atomicReferenceFieldUpdater.set(this, d2Var);
        }
    }

    public final x0 Z(boolean z2, t1 t1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        d2 d2Var;
        boolean z3;
        boolean zC;
        t1Var.f7492d = this;
        while (true) {
            atomicReferenceFieldUpdater = f7509a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z5 = obj instanceof z0;
            d2Var = d2.f7443a;
            z3 = true;
            if (!z5) {
                if (!(obj instanceof l1)) {
                    z3 = false;
                    break;
                }
                l1 l1Var = (l1) obj;
                b2 b2VarB = l1Var.b();
                if (b2VarB == null) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    m0((t1) obj);
                } else {
                    if (t1Var.j()) {
                        w1 w1Var = l1Var instanceof w1 ? (w1) l1Var : null;
                        Throwable thD = w1Var != null ? w1Var.d() : null;
                        if (thD != null) {
                            if (z2) {
                                t1Var.k(thD);
                            }
                            return d2Var;
                        }
                        zC = b2VarB.c(t1Var, 5);
                    } else {
                        zC = b2VarB.c(t1Var, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                z0 z0Var = (z0) obj;
                if (!z0Var.f7513a) {
                    b2 b2Var = new b2();
                    Object k1Var = b2Var;
                    if (!z0Var.f7513a) {
                        k1Var = new k1(b2Var);
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, z0Var, k1Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, t1Var)) {
                    break;
                }
            }
        }
        if (z3) {
            return t1Var;
        }
        if (z2) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            t1Var.k(uVar != null ? uVar.f7494a : null);
        }
        return d2Var;
    }

    @Override // li.p1
    public boolean a() {
        Object obj = f7509a.get(this);
        return (obj instanceof l1) && ((l1) obj).a();
    }

    @Override // li.p1
    public final o a0(x1 x1Var) {
        p pVar = new p(x1Var);
        pVar.f7492d = this;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7509a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof z0) {
                z0 z0Var = (z0) obj;
                if (!z0Var.f7513a) {
                    b2 b2Var = new b2();
                    Object k1Var = b2Var;
                    if (!z0Var.f7513a) {
                        k1Var = new k1(b2Var);
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, z0Var, k1Var);
                } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                    break;
                }
            } else {
                boolean z2 = obj instanceof l1;
                d2 d2Var = d2.f7443a;
                Throwable thD = null;
                if (!z2) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    u uVar = obj2 instanceof u ? (u) obj2 : null;
                    pVar.k(uVar != null ? uVar.f7494a : null);
                    return d2Var;
                }
                b2 b2VarB = ((l1) obj).b();
                if (b2VarB != null) {
                    if (b2VarB.c(pVar, 7)) {
                        break;
                    }
                    boolean zC = b2VarB.c(pVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof w1) {
                        thD = ((w1) obj3).d();
                    } else {
                        u uVar2 = obj3 instanceof u ? (u) obj3 : null;
                        if (uVar2 != null) {
                            thD = uVar2.f7494a;
                        }
                    }
                    pVar.k(thD);
                    if (zC) {
                        break;
                    }
                    return d2Var;
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                m0((t1) obj);
            }
        }
        return pVar;
    }

    public boolean c0() {
        return this instanceof f;
    }

    public final boolean d0(Object obj) {
        Object objP0;
        do {
            objP0 = p0(f7509a.get(this), obj);
            if (objP0 == l0.f7471d) {
                return false;
            }
            if (objP0 == l0.e) {
                return true;
            }
        } while (objP0 == l0.f);
        v(objP0);
        return true;
    }

    public final Object e0(Object obj) {
        Object objP0;
        do {
            objP0 = p0(f7509a.get(this), obj);
            if (objP0 == l0.f7471d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                u uVar = obj instanceof u ? (u) obj : null;
                throw new IllegalStateException(str, uVar != null ? uVar.f7494a : null);
            }
        } while (objP0 == l0.f);
        return objP0;
    }

    public String f0() {
        return getClass().getSimpleName();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return o1.f7483a;
    }

    @Override // li.p1
    public void h(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new q1(F(), null, this);
        }
        C(cancellationException);
    }

    public final void h0(b2 b2Var, Throwable th2) {
        j0(th2);
        b2Var.c(new qi.j(4), 4);
        Object obj = qi.m.f9153a.get(b2Var);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        v vVar = null;
        for (qi.m mVarF = (qi.m) obj; !Intrinsics.areEqual(mVarF, b2Var); mVarF = mVarF.f()) {
            if ((mVarF instanceof t1) && ((t1) mVarF).j()) {
                try {
                    ((t1) mVarF).k(th2);
                } catch (Throwable th3) {
                    if (vVar != null) {
                        ExceptionsKt.addSuppressed(vVar, th3);
                    } else {
                        vVar = new v("Exception in completion handler " + mVarF + " for " + this, th3);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (vVar != null) {
            W(vVar);
        }
        D(th2);
    }

    @Override // li.p1
    public final boolean isCancelled() {
        Object obj = f7509a.get(this);
        return (obj instanceof u) || ((obj instanceof w1) && ((w1) obj).e());
    }

    public void j0(Throwable th2) {
    }

    public void k0(Object obj) {
    }

    public void l0() {
    }

    public Object m() {
        return O();
    }

    public final void m0(t1 t1Var) {
        b2 b2Var = new b2();
        t1Var.getClass();
        qi.m.f9154b.set(b2Var, t1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.m.f9153a;
        atomicReferenceFieldUpdater.set(b2Var, t1Var);
        while (atomicReferenceFieldUpdater.get(t1Var) == t1Var) {
            if (atomicReferenceFieldUpdater.compareAndSet(t1Var, t1Var, b2Var)) {
                b2Var.e(t1Var);
                break;
            }
        }
        f7509a.compareAndSet(this, t1Var, t1Var.f());
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public final int n0(Object obj) {
        boolean z2 = obj instanceof z0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7509a;
        if (z2) {
            if (((z0) obj).f7513a) {
                return 0;
            }
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, l0.f7475j)) {
                return -1;
            }
            l0();
            return 1;
        }
        if (!(obj instanceof k1)) {
            return 0;
        }
        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, ((k1) obj).f7462a)) {
            return -1;
        }
        l0();
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final Object p0(Object obj, Object obj2) {
        if (!(obj instanceof l1)) {
            return l0.f7471d;
        }
        if (((obj instanceof z0) || (obj instanceof t1)) && !(obj instanceof p) && !(obj2 instanceof u)) {
            l1 l1Var = (l1) obj;
            if (!f7509a.compareAndSet(this, l1Var, obj2 instanceof l1 ? new m1((l1) obj2) : obj2)) {
                return l0.f;
            }
            j0(null);
            k0(obj2);
            J(l1Var, obj2);
            return obj2;
        }
        l1 l1Var2 = (l1) obj;
        b2 b2VarT = T(l1Var2);
        if (b2VarT == null) {
            return l0.f;
        }
        w1 w1Var = l1Var2 instanceof w1 ? (w1) l1Var2 : null;
        if (w1Var == null) {
            w1Var = new w1(b2VarT, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (w1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = w1.f7505b;
            if (atomicIntegerFieldUpdater.get(w1Var) != 0) {
                return l0.f7471d;
            }
            atomicIntegerFieldUpdater.set(w1Var, 1);
            if (w1Var != l1Var2 && !f7509a.compareAndSet(this, l1Var2, w1Var)) {
                return l0.f;
            }
            boolean zE = w1Var.e();
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            if (uVar != null) {
                w1Var.c(uVar.f7494a);
            }
            ?? D = zE ? 0 : w1Var.d();
            objectRef.element = D;
            Unit unit = Unit.INSTANCE;
            if (D != 0) {
                h0(b2VarT, D);
            }
            p pVarG0 = g0(b2VarT);
            if (pVarG0 != null && q0(w1Var, pVarG0, obj2)) {
                return l0.e;
            }
            b2VarT.c(new qi.j(2), 2);
            p pVarG1 = g0(b2VarT);
            return (pVarG1 == null || !q0(w1Var, pVarG1, obj2)) ? M(w1Var, obj2) : l0.e;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    public final boolean q0(w1 w1Var, p pVar, Object obj) {
        while (pVar.e.Z(false, new v1(this, w1Var, pVar, obj)) == d2.f7443a) {
            pVar = g0(pVar);
            if (pVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // li.p1
    public final x0 s(boolean z2, boolean z3, Function1 function1) {
        return Z(z3, z2 ? new n1(function1) : new y0(function1, 1));
    }

    @Override // li.p1
    public final boolean start() {
        int iN0;
        do {
            iN0 = n0(f7509a.get(this));
            if (iN0 == 0) {
                return false;
            }
        } while (iN0 != 1);
        return true;
    }

    @Override // li.p1
    public final CancellationException t() {
        CancellationException cancellationException;
        Object obj = f7509a.get(this);
        if (!(obj instanceof w1)) {
            if (obj instanceof l1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof u)) {
                return new q1(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th2 = ((u) obj).f7494a;
            cancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            return cancellationException == null ? new q1(F(), th2, this) : cancellationException;
        }
        Throwable thD = ((w1) obj).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = F();
        }
        return new q1(strConcat, thD, this);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f0() + '{' + o0(f7509a.get(this)) + '}');
        sb2.append('@');
        sb2.append(l0.j(this));
        return sb2.toString();
    }

    public void v(Object obj) {
    }

    public void x(Object obj) {
        v(obj);
    }

    public final Object y(ContinuationImpl continuationImpl) throws Throwable {
        Object obj;
        do {
            obj = f7509a.get(this);
            if (!(obj instanceof l1)) {
                if (obj instanceof u) {
                    throw ((u) obj).f7494a;
                }
                return l0.t(obj);
            }
        } while (n0(obj) < 0);
        u1 u1Var = new u1(IntrinsicsKt.intercepted(continuationImpl), this);
        u1Var.s();
        u1Var.w(new h(l0.m(this, new y0(u1Var, 2)), 2));
        Object objR = u1Var.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuationImpl);
        }
        return objR;
    }

    public final boolean z(Object obj) {
        a8.a aVar;
        Object objP0 = l0.f7471d;
        if (R()) {
            do {
                Object obj2 = f7509a.get(this);
                if (obj2 instanceof l1) {
                    if (obj2 instanceof w1) {
                        w1 w1Var = (w1) obj2;
                        w1Var.getClass();
                        if (w1.f7505b.get(w1Var) != 0) {
                        }
                    }
                    objP0 = p0(obj2, new u(false, K(obj)));
                }
                objP0 = l0.f7471d;
                break;
            } while (objP0 == l0.f);
            if (objP0 == l0.e) {
                return true;
            }
        }
        if (objP0 == l0.f7471d) {
            Throwable thK = null;
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7509a;
                Object obj3 = atomicReferenceFieldUpdater.get(this);
                if (obj3 instanceof w1) {
                    synchronized (obj3) {
                        try {
                            w1 w1Var2 = (w1) obj3;
                            w1Var2.getClass();
                            if (w1.f7507d.get(w1Var2) == l0.f7473h) {
                                aVar = l0.f7472g;
                            } else {
                                boolean zE = ((w1) obj3).e();
                                if (obj != null || !zE) {
                                    if (thK == null) {
                                        thK = K(obj);
                                    }
                                    ((w1) obj3).c(thK);
                                }
                                Throwable thD = zE ? null : ((w1) obj3).d();
                                if (thD != null) {
                                    h0(((w1) obj3).f7508a, thD);
                                }
                                aVar = l0.f7471d;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } else if (obj3 instanceof l1) {
                    if (thK == null) {
                        thK = K(obj);
                    }
                    l1 l1Var = (l1) obj3;
                    if (l1Var.a()) {
                        b2 b2VarT = T(l1Var);
                        if (b2VarT != null && atomicReferenceFieldUpdater.compareAndSet(this, l1Var, new w1(b2VarT, thK))) {
                            h0(b2VarT, thK);
                            aVar = l0.f7471d;
                        }
                    } else {
                        Object objP1 = p0(obj3, new u(false, thK));
                        if (objP1 == l0.f7471d) {
                            throw new IllegalStateException(("Cannot happen in " + obj3).toString());
                        }
                        if (objP1 != l0.f) {
                            objP0 = objP1;
                            break;
                        }
                    }
                } else {
                    aVar = l0.f7472g;
                }
                objP0 = aVar;
                break;
            }
        }
        if (objP0 != l0.f7471d && objP0 != l0.e) {
            if (objP0 == l0.f7472g) {
                return false;
            }
            v(objP0);
        }
        return true;
    }
}
