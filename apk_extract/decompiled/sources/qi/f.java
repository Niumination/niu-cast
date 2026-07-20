package qi;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import li.f1;
import li.k2;
import li.l0;
import li.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends t0 implements CoroutineStackFrame, Continuation {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9140j = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final li.a0 f9141d;
    public final Continuation e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f9142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f9143i;

    public f(li.a0 a0Var, Continuation continuation) {
        super(-1);
        this.f9141d = a0Var;
        this.e = continuation;
        this.f9142h = g.f9144a;
        this.f9143i = z.b(continuation.get$context());
    }

    @Override // li.t0
    public final Continuation f() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.e.get$context();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // li.t0
    public final Object j() {
        Object obj = this.f9142h;
        this.f9142h = g.f9144a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(obj);
        Object uVar = thM162exceptionOrNullimpl == null ? obj : new li.u(false, thM162exceptionOrNullimpl);
        Continuation continuation = this.e;
        CoroutineContext coroutineContext = continuation.get$context();
        li.a0 a0Var = this.f9141d;
        if (a0Var.isDispatchNeeded(coroutineContext)) {
            this.f9142h = uVar;
            this.f7491c = 0;
            a0Var.dispatch(continuation.get$context(), this);
            return;
        }
        f1 f1VarA = k2.a();
        if (f1VarA.w()) {
            this.f9142h = uVar;
            this.f7491c = 0;
            f1VarA.k(this);
            return;
        }
        f1VarA.o(true);
        try {
            CoroutineContext coroutineContext2 = continuation.get$context();
            Object objC = z.c(coroutineContext2, this.f9143i);
            try {
                continuation.resumeWith(obj);
                Unit unit = Unit.INSTANCE;
                z.a(coroutineContext2, objC);
                while (f1VarA.E()) {
                }
            } catch (Throwable th2) {
                z.a(coroutineContext2, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                i(th3);
            } finally {
                f1VarA.i(true);
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f9141d + ", " + l0.s(this.e) + ']';
    }
}
