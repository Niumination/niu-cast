package nq;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
@lm.z0
public abstract class h1<T> extends xq.k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    public int f11857c;

    public h1(int i10) {
        this.f11857c = i10;
    }

    public void b(@os.m Object obj, @os.l Throwable th2) {
    }

    @os.l
    public abstract um.d<T> f();

    @os.m
    public Throwable h(@os.m Object obj) {
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        if (d0Var != null) {
            return d0Var.f11836a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T i(@os.m Object obj) {
        return obj;
    }

    public final void k(@os.m Throwable th2, @os.m Throwable th3) throws IllegalAccessException, InvocationTargetException {
        if (th2 == null && th3 == null) {
            return;
        }
        if (th2 != null && th3 != null) {
            lm.p.a(th2, th3);
        }
        if (th2 == null) {
            th2 = th3;
        }
        kn.l0.m(th2);
        p0.b(f().getContext(), new v0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    @os.m
    public abstract Object m();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objM59constructorimpl;
        Object objM59constructorimpl2;
        xq.l lVar = this.f20517b;
        try {
            um.d<T> dVarF = f();
            kn.l0.n(dVarF, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            vq.m mVar = (vq.m) dVarF;
            um.d<T> dVar = mVar.f17864e;
            Object obj = mVar.f17866g;
            um.g context = dVar.getContext();
            Object objC = vq.a1.c(context, obj);
            z3<?> z3VarG = objC != vq.a1.f17796a ? m0.g(dVar, context, objC) : null;
            try {
                um.g context2 = dVar.getContext();
                Object objM = m();
                Throwable thH = h(objM);
                l2 l2Var = (thH == null && i1.c(this.f11857c)) ? (l2) context2.get(l2.f11882k) : null;
                if (l2Var != null && !l2Var.isActive()) {
                    CancellationException cancellationExceptionO = l2Var.O();
                    b(objM, cancellationExceptionO);
                    lm.c1.a aVar = lm.c1.Companion;
                    dVar.resumeWith(lm.c1.m59constructorimpl(lm.d1.a(cancellationExceptionO)));
                } else if (thH != null) {
                    lm.c1.a aVar2 = lm.c1.Companion;
                    dVar.resumeWith(lm.c1.m59constructorimpl(lm.d1.a(thH)));
                } else {
                    lm.c1.a aVar3 = lm.c1.Companion;
                    dVar.resumeWith(lm.c1.m59constructorimpl(i(objM)));
                }
                lm.l2 l2Var2 = lm.l2.f10208a;
                if (z3VarG == null || z3VarG.V1()) {
                    vq.a1.a(context, objC);
                }
                try {
                    lm.c1.a aVar4 = lm.c1.Companion;
                    lVar.h();
                    objM59constructorimpl2 = lm.c1.m59constructorimpl(l2Var2);
                } catch (Throwable th2) {
                    lm.c1.a aVar5 = lm.c1.Companion;
                    objM59constructorimpl2 = lm.c1.m59constructorimpl(lm.d1.a(th2));
                }
                k(null, lm.c1.m62exceptionOrNullimpl(objM59constructorimpl2));
            } catch (Throwable th3) {
                if (z3VarG == null || z3VarG.V1()) {
                    vq.a1.a(context, objC);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                lm.c1.a aVar6 = lm.c1.Companion;
                lVar.h();
                objM59constructorimpl = lm.c1.m59constructorimpl(lm.l2.f10208a);
            } catch (Throwable th5) {
                lm.c1.a aVar7 = lm.c1.Companion;
                objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th5));
            }
            k(th4, lm.c1.m62exceptionOrNullimpl(objM59constructorimpl));
        }
    }
}
