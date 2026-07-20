package vq;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.l2;
import nq.p3;
import nq.z3;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
@lm.z0
public final class m<T> extends nq.h1<T> implements xm.e, um.d<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17862i = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_reusableCancellableContinuation");

    @os.m
    @in.x
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public final nq.n0 f17863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    @os.l
    public final um.d<T> f17864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    @in.f
    public Object f17865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @in.f
    @os.l
    public final Object f17866g;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@os.l nq.n0 n0Var, @os.l um.d<? super T> dVar) {
        super(-1);
        this.f17863d = n0Var;
        this.f17864e = dVar;
        this.f17865f = n.f17867a;
        this.f17866g = a1.b(dVar.getContext());
    }

    public static /* synthetic */ void r() {
    }

    private final void t(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // nq.h1
    public void b(@os.m Object obj, @os.l Throwable th2) {
        if (obj instanceof nq.e0) {
            ((nq.e0) obj).f11847b.invoke(th2);
        }
    }

    @Override // nq.h1
    @os.l
    public um.d<T> f() {
        return this;
    }

    @Override // xm.e
    @os.m
    public xm.e getCallerFrame() {
        um.d<T> dVar = this.f17864e;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return this.f17864e.getContext();
    }

    @Override // xm.e
    @os.m
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // nq.h1
    @os.m
    public Object m() {
        Object obj = this.f17865f;
        this.f17865f = n.f17867a;
        return obj;
    }

    public final void n() {
        while (f17862i.get(this) == n.f17868b) {
        }
    }

    @os.m
    public final nq.q<T> o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f17862i.set(this, n.f17868b);
                return null;
            }
            if (obj instanceof nq.q) {
                if (j.d.a(f17862i, this, obj, n.f17868b)) {
                    return (nq.q) obj;
                }
            } else if (obj != n.f17868b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void p(@os.l um.g gVar, T t10) {
        this.f17865f = t10;
        this.f11857c = 1;
        this.f17863d.dispatchYield(gVar, this);
    }

    public final nq.q<?> q() {
        Object obj = f17862i.get(this);
        if (obj instanceof nq.q) {
            return (nq.q) obj;
        }
        return null;
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        um.g context = this.f17864e.getContext();
        Object objD = nq.j0.d(obj, null, 1, null);
        if (this.f17863d.isDispatchNeeded(context)) {
            this.f17865f = objD;
            this.f11857c = 0;
            this.f17863d.dispatch(context, this);
            return;
        }
        nq.r1 r1VarB = p3.f11893a.b();
        if (r1VarB.T0()) {
            this.f17865f = objD;
            this.f11857c = 0;
            r1VarB.v0(this);
            return;
        }
        r1VarB.F0(true);
        try {
            um.g context2 = this.f17864e.getContext();
            Object objC = a1.c(context2, this.f17866g);
            try {
                this.f17864e.resumeWith(obj);
                l2 l2Var = l2.f10208a;
                a1.a(context2, objC);
                while (r1VarB.B1()) {
                }
            } catch (Throwable th2) {
                a1.a(context2, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                k(th3, null);
            } finally {
                r1VarB.f0(true);
            }
        }
    }

    public final boolean s() {
        return f17862i.get(this) != null;
    }

    @os.l
    public String toString() {
        return "DispatchedContinuation[" + this.f17863d + ", " + nq.x0.c(this.f17864e) + ']';
    }

    public final boolean u(@os.l Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            u0 u0Var = n.f17868b;
            if (kn.l0.g(obj, u0Var)) {
                if (j.d.a(f17862i, this, u0Var, th2)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (j.d.a(f17862i, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void v() {
        n();
        nq.q<?> qVarQ = q();
        if (qVarQ != null) {
            qVarQ.u();
        }
    }

    public final void w(@os.l Object obj, @os.m jn.l<? super Throwable, l2> lVar) {
        Object objB = nq.j0.b(obj, lVar);
        if (this.f17863d.isDispatchNeeded(this.f17864e.getContext())) {
            this.f17865f = objB;
            this.f11857c = 1;
            this.f17863d.dispatch(this.f17864e.getContext(), this);
            return;
        }
        nq.r1 r1VarB = p3.f11893a.b();
        if (r1VarB.T0()) {
            this.f17865f = objB;
            this.f11857c = 1;
            r1VarB.v0(this);
            return;
        }
        r1VarB.F0(true);
        try {
            nq.l2 l2Var = (nq.l2) this.f17864e.getContext().get(nq.l2.f11882k);
            if (l2Var == null || l2Var.isActive()) {
                um.d<T> dVar = this.f17864e;
                Object obj2 = this.f17866g;
                um.g context = dVar.getContext();
                Object objC = a1.c(context, obj2);
                z3<?> z3VarG = objC != a1.f17796a ? nq.m0.g(dVar, context, objC) : null;
                try {
                    this.f17864e.resumeWith(obj);
                    l2 l2Var2 = l2.f10208a;
                    if (z3VarG == null || z3VarG.V1()) {
                        a1.a(context, objC);
                    }
                } catch (Throwable th2) {
                    if (z3VarG == null || z3VarG.V1()) {
                        a1.a(context, objC);
                    }
                    throw th2;
                }
            } else {
                CancellationException cancellationExceptionO = l2Var.O();
                b(objB, cancellationExceptionO);
                lm.c1.a aVar = lm.c1.Companion;
                resumeWith(lm.c1.m59constructorimpl(lm.d1.a(cancellationExceptionO)));
            }
            while (r1VarB.B1()) {
            }
        } catch (Throwable th3) {
            try {
                k(th3, null);
            } finally {
                r1VarB.f0(true);
            }
        }
    }

    public final boolean x(@os.m Object obj) {
        nq.l2 l2Var = (nq.l2) this.f17864e.getContext().get(nq.l2.f11882k);
        if (l2Var == null || l2Var.isActive()) {
            return false;
        }
        CancellationException cancellationExceptionO = l2Var.O();
        b(obj, cancellationExceptionO);
        lm.c1.a aVar = lm.c1.Companion;
        resumeWith(lm.c1.m59constructorimpl(lm.d1.a(cancellationExceptionO)));
        return true;
    }

    public final void y(@os.l Object obj) {
        um.d<T> dVar = this.f17864e;
        Object obj2 = this.f17866g;
        um.g context = dVar.getContext();
        Object objC = a1.c(context, obj2);
        z3<?> z3VarG = objC != a1.f17796a ? nq.m0.g(dVar, context, objC) : null;
        try {
            this.f17864e.resumeWith(obj);
            l2 l2Var = l2.f10208a;
        } finally {
            if (z3VarG == null || z3VarG.V1()) {
                a1.a(context, objC);
            }
        }
    }

    @os.m
    public final Throwable z(@os.l nq.p<?> pVar) {
        u0 u0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17862i;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            u0Var = n.f17868b;
            if (obj != u0Var) {
                if (obj instanceof Throwable) {
                    if (j.d.a(f17862i, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!j.d.a(f17862i, this, u0Var, pVar));
        return null;
    }
}
