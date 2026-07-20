package li;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 extends si.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7491c;

    public t0(int i8) {
        super(0L, false);
        this.f7491c = i8;
    }

    public void e(CancellationException cancellationException) {
    }

    public abstract Continuation f();

    public Throwable g(Object obj) {
        u uVar = obj instanceof u ? (u) obj : null;
        if (uVar != null) {
            return uVar.f7494a;
        }
        return null;
    }

    public Object h(Object obj) {
        return obj;
    }

    public final void i(Throwable th2) {
        d0.a(f().get$context(), new k0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Continuation continuationF = f();
            Intrinsics.checkNotNull(continuationF, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            qi.f fVar = (qi.f) continuationF;
            Continuation continuation = fVar.e;
            Object obj = fVar.f9143i;
            CoroutineContext context = continuation.get$context();
            Object objC = qi.z.c(context, obj);
            p1 p1Var = null;
            q2 q2VarC = objC != qi.z.f9173a ? y.c(continuation, context, objC) : null;
            try {
                CoroutineContext context2 = continuation.get$context();
                Object objJ = j();
                Throwable thG = g(objJ);
                if (thG == null && u0.a(this.f7491c)) {
                    p1Var = (p1) context2.get(o1.f7483a);
                }
                if (p1Var != null && !p1Var.a()) {
                    CancellationException cancellationExceptionT = p1Var.t();
                    e(cancellationExceptionT);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(cancellationExceptionT)));
                } else if (thG != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(thG)));
                } else {
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation.resumeWith(Result.m159constructorimpl(h(objJ)));
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                if (q2VarC == null || q2VarC.t0()) {
                    qi.z.a(context, objC);
                }
            }
        } catch (Throwable th2) {
            i(th2);
        }
    }
}
