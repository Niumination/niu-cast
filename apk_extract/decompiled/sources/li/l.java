package li;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class l extends t0 implements j, CoroutineStackFrame, s2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7464h = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decisionAndIndex$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7465i = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7466j = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f7467d;
    public final CoroutineContext e;

    public l(int i8, Continuation continuation) {
        super(i8);
        this.f7467d = continuation;
        this.e = continuation.get$context();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f7432a;
    }

    public static Object D(e2 e2Var, Object obj, int i8, Function3 function3) {
        if ((obj instanceof u) || !u0.a(i8)) {
            return obj;
        }
        if (function3 != null || (e2Var instanceof i)) {
            return new t(obj, e2Var instanceof i ? (i) e2Var : null, function3, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void y(e2 e2Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + e2Var + ", already has " + obj).toString());
    }

    public final void A() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        a8.a aVar;
        Continuation continuation = this.f7467d;
        Throwable th2 = null;
        qi.f fVar = continuation instanceof qi.f ? (qi.f) continuation : null;
        if (fVar != null) {
            do {
                atomicReferenceFieldUpdater = qi.f.f9140j;
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                aVar = qi.g.f9145b;
                if (obj != aVar) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    if (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    th2 = (Throwable) obj;
                    break;
                }
            } while (!atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, this));
            if (th2 == null) {
                return;
            }
            n();
            b(th2);
        }
    }

    public final void B(Object obj, int i8, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        do {
            atomicReferenceFieldUpdater = f7465i;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof e2)) {
                if (obj2 instanceof m) {
                    m mVar = (m) obj2;
                    mVar.getClass();
                    if (m.f7476c.compareAndSet(mVar, 0, 1)) {
                        if (function3 != null) {
                            l(function3, mVar.f7494a, obj);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, D((e2) obj2, obj, i8, function3)));
        if (!x()) {
            n();
        }
        o(i8);
    }

    public final void C(a0 a0Var, Unit unit) {
        Continuation continuation = this.f7467d;
        qi.f fVar = continuation instanceof qi.f ? (qi.f) continuation : null;
        B(unit, (fVar != null ? fVar.f9141d : null) == a0Var ? 4 : this.f7491c, null);
    }

    public final a8.a E(Object obj, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        a8.a aVar;
        do {
            atomicReferenceFieldUpdater = f7465i;
            obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z2 = obj2 instanceof e2;
            aVar = l0.f7468a;
            if (!z2) {
                boolean z3 = obj2 instanceof t;
                return null;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, D((e2) obj2, obj, this.f7491c, function3)));
        if (!x()) {
            n();
        }
        return aVar;
    }

    @Override // li.j
    public final boolean a() {
        return f7465i.get(this) instanceof e2;
    }

    @Override // li.j
    public final boolean b(Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = f7465i;
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof e2)) {
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, new m(this, th2, (obj instanceof i) || (obj instanceof qi.w))));
        e2 e2Var = (e2) obj;
        if (e2Var instanceof i) {
            k((i) obj, th2);
        } else if (e2Var instanceof qi.w) {
            m((qi.w) obj, th2);
        }
        if (!x()) {
            n();
        }
        o(this.f7491c);
        return true;
    }

    @Override // li.s2
    public final void c(qi.w wVar, int i8) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f7464h;
            i9 = atomicIntegerFieldUpdater.get(this);
            if ((i9 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, ((i9 >> 29) << 29) + i8));
        w(wVar);
    }

    @Override // li.j
    public final a8.a d(Object obj, Function3 function3) {
        return E(obj, function3);
    }

    @Override // li.t0
    public final void e(CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7465i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof e2) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof u) {
                return;
            }
            if (obj instanceof t) {
                t tVar = (t) obj;
                if (tVar.e != null) {
                    throw new IllegalStateException("Must be called at most once");
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, t.a(tVar, null, cancellationException, 15))) {
                    i iVar = tVar.f7488b;
                    if (iVar != null) {
                        k(iVar, cancellationException);
                    }
                    Function3 function3 = tVar.f7489c;
                    if (function3 != null) {
                        l(function3, cancellationException, tVar.f7487a);
                        return;
                    }
                    return;
                }
            } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, new t(obj, (i) null, (Function3) null, cancellationException, 14))) {
                return;
            }
        }
    }

    @Override // li.t0
    public final Continuation f() {
        return this.f7467d;
    }

    @Override // li.t0
    public final Throwable g(Object obj) {
        Throwable thG = super.g(obj);
        if (thG != null) {
            return thG;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f7467d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // li.t0
    public final Object h(Object obj) {
        return obj instanceof t ? ((t) obj).f7487a : obj;
    }

    @Override // li.t0
    public final Object j() {
        return f7465i.get(this);
    }

    public final void k(i iVar, Throwable th2) {
        try {
            iVar.a(th2);
        } catch (Throwable th3) {
            d0.a(this.e, new v("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void l(Function3 function3, Throwable th2, Object obj) {
        CoroutineContext coroutineContext = this.e;
        try {
            function3.invoke(th2, obj, coroutineContext);
        } catch (Throwable th3) {
            d0.a(coroutineContext, new v("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    public final void m(qi.w wVar, Throwable th2) {
        CoroutineContext coroutineContext = this.e;
        int i8 = f7464h.get(this) & 536870911;
        if (i8 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            wVar.h(i8, coroutineContext);
        } catch (Throwable th3) {
            d0.a(coroutineContext, new v("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7466j;
        x0 x0Var = (x0) atomicReferenceFieldUpdater.get(this);
        if (x0Var == null) {
            return;
        }
        x0Var.dispose();
        atomicReferenceFieldUpdater.set(this, d2.f7443a);
    }

    public final void o(int i8) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f7464h;
            i9 = atomicIntegerFieldUpdater.get(this);
            int i10 = i9 >> 29;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z2 = i8 == 4;
                Continuation continuation = this.f7467d;
                if (z2 || !(continuation instanceof qi.f) || u0.a(i8) != u0.a(this.f7491c)) {
                    u0.b(this, continuation, z2);
                    return;
                }
                qi.f fVar = (qi.f) continuation;
                a0 a0Var = fVar.f9141d;
                CoroutineContext coroutineContext = fVar.e.get$context();
                if (a0Var.isDispatchNeeded(coroutineContext)) {
                    a0Var.dispatch(coroutineContext, this);
                    return;
                }
                f1 f1VarA = k2.a();
                if (f1VarA.w()) {
                    f1VarA.k(this);
                    return;
                }
                f1VarA.o(true);
                try {
                    u0.b(this, continuation, true);
                    do {
                    } while (f1VarA.E());
                } catch (Throwable th2) {
                    try {
                        i(th2);
                    } finally {
                        f1VarA.i(true);
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, BasicMeasure.EXACTLY + (536870911 & i9)));
    }

    @Override // li.j
    public final void p(Object obj, Function3 function3) {
        B(obj, this.f7491c, function3);
    }

    public Throwable q(x1 x1Var) {
        return x1Var.t();
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        boolean zX = x();
        do {
            atomicIntegerFieldUpdater = f7464h;
            i8 = atomicIntegerFieldUpdater.get(this);
            int i9 = i8 >> 29;
            if (i9 != 0) {
                if (i9 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zX) {
                    A();
                }
                Object obj = f7465i.get(this);
                if (obj instanceof u) {
                    throw ((u) obj).f7494a;
                }
                if (u0.a(this.f7491c)) {
                    p1 p1Var = (p1) this.e.get(o1.f7483a);
                    if (p1Var != null && !p1Var.a()) {
                        CancellationException cancellationExceptionT = p1Var.t();
                        e(cancellationExceptionT);
                        throw cancellationExceptionT;
                    }
                }
                return h(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, 536870912 + (536870911 & i8)));
        if (((x0) f7466j.get(this)) == null) {
            t();
        }
        if (zX) {
            A();
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(obj);
        if (thM162exceptionOrNullimpl != null) {
            obj = new u(false, thM162exceptionOrNullimpl);
        }
        B(obj, this.f7491c, null);
    }

    public final void s() {
        x0 x0VarT = t();
        if (x0VarT == null || (f7465i.get(this) instanceof e2)) {
            return;
        }
        x0VarT.dispose();
        f7466j.set(this, d2.f7443a);
    }

    public final x0 t() {
        p1 p1Var = (p1) this.e.get(o1.f7483a);
        if (p1Var == null) {
            return null;
        }
        x0 x0VarM = l0.m(p1Var, new n(this, 0));
        f7466j.compareAndSet(this, null, x0VarM);
        return x0VarM;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z());
        sb2.append('(');
        sb2.append(l0.s(this.f7467d));
        sb2.append("){");
        Object obj = f7465i.get(this);
        if (obj instanceof e2) {
            str = "Active";
        } else {
            str = obj instanceof m ? "Cancelled" : "Completed";
        }
        sb2.append(str);
        sb2.append("}@");
        sb2.append(l0.j(this));
        return sb2.toString();
    }

    @Override // li.j
    public final void u(Object obj) {
        o(this.f7491c);
    }

    public final void v(Function1 function1) {
        w(new h(function1, 1));
    }

    public final void w(e2 e2Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7465i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof b)) {
                if ((obj instanceof i) || (obj instanceof qi.w)) {
                    y(e2Var, obj);
                    throw null;
                }
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    uVar.getClass();
                    if (!u.f7493b.compareAndSet(uVar, 0, 1)) {
                        y(e2Var, obj);
                        throw null;
                    }
                    if (obj instanceof m) {
                        if (!(obj instanceof u)) {
                            uVar = null;
                        }
                        Throwable th2 = uVar != null ? uVar.f7494a : null;
                        if (e2Var instanceof i) {
                            k((i) e2Var, th2);
                            return;
                        } else {
                            Intrinsics.checkNotNull(e2Var, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            m((qi.w) e2Var, th2);
                            return;
                        }
                    }
                    return;
                }
                if (obj instanceof t) {
                    t tVar = (t) obj;
                    if (tVar.f7488b != null) {
                        y(e2Var, obj);
                        throw null;
                    }
                    if (e2Var instanceof qi.w) {
                        return;
                    }
                    Intrinsics.checkNotNull(e2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    i iVar = (i) e2Var;
                    Throwable th3 = tVar.e;
                    if (th3 != null) {
                        k(iVar, th3);
                        return;
                    } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, t.a(tVar, iVar, null, 29))) {
                        return;
                    }
                } else {
                    if (e2Var instanceof qi.w) {
                        return;
                    }
                    Intrinsics.checkNotNull(e2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, new t(obj, (i) e2Var, (Function3) null, (CancellationException) null, 28))) {
                        return;
                    }
                }
            } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj, e2Var)) {
                return;
            }
        }
    }

    public final boolean x() {
        if (this.f7491c == 2) {
            Continuation continuation = this.f7467d;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            qi.f fVar = (qi.f) continuation;
            fVar.getClass();
            if (qi.f.f9140j.get(fVar) != null) {
                return true;
            }
        }
        return false;
    }

    public String z() {
        return "CancellableContinuation";
    }
}
