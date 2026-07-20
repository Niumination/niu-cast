package qi;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import li.d0;
import li.f1;
import li.k2;
import li.o1;
import li.p1;
import li.q2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8.a f9144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8.a f9145b;

    static {
        int i8 = 15;
        f9144a = new a8.a("UNDEFINED", i8);
        f9145b = new a8.a("REUSABLE_CLAIMED", i8);
    }

    public static final void a(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        c0 c0VarB = b(function1, obj, null);
        if (c0VarB != null) {
            d0.a(coroutineContext, c0VarB);
        }
    }

    public static final c0 b(Function1 function1, Object obj, c0 c0Var) {
        try {
            function1.invoke(obj);
        } catch (Throwable th2) {
            if (c0Var == null || c0Var.getCause() == th2) {
                return new c0(a1.a.p(obj, "Exception in undelivered element handler for "), th2);
            }
            ExceptionsKt.addSuppressed(c0Var, th2);
        }
        return c0Var;
    }

    public static final void c(int i8) {
        if (i8 < 1) {
            throw new IllegalArgumentException(a1.a.o(i8, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final w d(Object obj) {
        if (obj == a.f9128a) {
            throw new IllegalStateException("Does not contain segment");
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (w) obj;
    }

    public static final void e(CoroutineContext coroutineContext, Throwable th2) {
        Throwable runtimeException;
        Iterator it = d.f9138a.iterator();
        while (it.hasNext()) {
            try {
                ((li.c0) it.next()).L(coroutineContext, th2);
            } catch (h unused) {
                return;
            } catch (Throwable th3) {
                if (th2 == th3) {
                    runtimeException = th2;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    ExceptionsKt.addSuppressed(runtimeException, th2);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ExceptionsKt.addSuppressed(th2, new e(coroutineContext));
        } catch (Throwable unused2) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
    }

    public static final boolean f(Object obj) {
        return obj == a.f9128a;
    }

    public static final Object g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void h(Object obj, Continuation continuation) {
        if (!(continuation instanceof f)) {
            continuation.resumeWith(obj);
            return;
        }
        f fVar = (f) continuation;
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(obj);
        Object uVar = thM162exceptionOrNullimpl == null ? obj : new li.u(false, thM162exceptionOrNullimpl);
        li.a0 a0Var = fVar.f9141d;
        Continuation continuation2 = fVar.e;
        if (a0Var.isDispatchNeeded(continuation2.get$context())) {
            fVar.f9142h = uVar;
            fVar.f7491c = 1;
            fVar.f9141d.dispatch(continuation2.get$context(), fVar);
            return;
        }
        f1 f1VarA = k2.a();
        if (f1VarA.w()) {
            fVar.f9142h = uVar;
            fVar.f7491c = 1;
            f1VarA.k(fVar);
            return;
        }
        f1VarA.o(true);
        try {
            p1 p1Var = (p1) continuation2.get$context().get(o1.f7483a);
            if (p1Var == null || p1Var.a()) {
                Object obj2 = fVar.f9143i;
                CoroutineContext context = continuation2.get$context();
                Object objC = z.c(context, obj2);
                q2 q2VarC = objC != z.f9173a ? li.y.c(continuation2, context, objC) : null;
                try {
                    continuation2.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                    if (q2VarC == null || q2VarC.t0()) {
                        z.a(context, objC);
                    }
                } catch (Throwable th2) {
                    if (q2VarC == null || q2VarC.t0()) {
                        z.a(context, objC);
                    }
                    throw th2;
                }
            } else {
                fVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(p1Var.t())));
            }
            while (f1VarA.E()) {
            }
        } catch (Throwable th3) {
            try {
                fVar.i(th3);
            } finally {
                f1VarA.i(true);
            }
        }
    }

    public static final long i(long j8, long j10, long j11, String str) {
        String property;
        int i8 = y.f9172a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j8;
        }
        Long longOrNull = StringsKt.toLongOrNull(property);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j10 <= jLongValue && jLongValue <= j11) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j10 + ".." + j11 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int j(String str, int i8, int i9, int i10, int i11) {
        if ((i11 & 4) != 0) {
            i9 = 1;
        }
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return (int) i(i8, i9, i10, str);
    }
}
