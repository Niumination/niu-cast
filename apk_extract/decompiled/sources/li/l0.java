package li;

import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import k3.bd;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import se.q3;
import se.r3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8.a f7469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a8.a f7470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a8.a f7471d;
    public static final a8.a e;
    public static final a8.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a8.a f7472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a8.a f7473h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8.a f7468a = new a8.a("RESUME_TOKEN", 15);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final z0 f7474i = new z0(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z0 f7475j = new z0(true);

    static {
        int i8 = 15;
        f7469b = new a8.a("REMOVED_TASK", i8);
        f7470c = new a8.a("CLOSED_EMPTY", i8);
        int i9 = 15;
        f7471d = new a8.a("COMPLETING_ALREADY", i9);
        e = new a8.a("COMPLETING_WAITING_CHILDREN", i9);
        f = new a8.a("COMPLETING_RETRY", i9);
        f7472g = new a8.a("TOO_LATE_TO_CANCEL", i9);
        f7473h = new a8.a("SEALED", i9);
    }

    public static final CancellationException a(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    public static r b() {
        r rVar = new r(true);
        rVar.Y(null);
        return rVar;
    }

    public static r1 c() {
        return new r1(null);
    }

    public static i2 d() {
        return new i2(null);
    }

    public static p0 e(g0 g0Var, CoroutineContext coroutineContext, Function2 function2, int i8) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        j0 j0Var = j0.DEFAULT;
        CoroutineContext coroutineContextB = y.b(g0Var, coroutineContext);
        p0 y1Var = j0Var.isLazy() ? new y1(coroutineContextB, function2) : new p0(coroutineContextB, true, true);
        j0Var.invoke(function2, y1Var, y1Var);
        return y1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object f(Collection collection, zg.e eVar) {
        if (collection.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        o0[] o0VarArr = (o0[]) collection.toArray(new o0[0]);
        e eVar2 = new e(o0VarArr);
        l lVar = new l(1, IntrinsicsKt.intercepted(eVar));
        lVar.s();
        int length = o0VarArr.length;
        c[] cVarArr = new c[length];
        for (int i8 = 0; i8 < length; i8++) {
            p0 p0Var = o0VarArr[i8];
            p0Var.start();
            c cVar = new c(eVar2, lVar);
            cVar.f7436h = m(p0Var, cVar);
            Unit unit = Unit.INSTANCE;
            cVarArr[i8] = cVar;
        }
        d dVar = new d(cVarArr);
        for (int i9 = 0; i9 < length; i9++) {
            c cVar2 = cVarArr[i9];
            cVar2.getClass();
            c.f7435j.set(cVar2, dVar);
        }
        if (l.f7465i.get(lVar) instanceof e2) {
            lVar.w(dVar);
        } else {
            dVar.b();
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(eVar);
        }
        return objR;
    }

    public static final void g(String str, Throwable th2, p1 p1Var) {
        p1Var.h(a(str, th2));
    }

    public static void h(CoroutineContext coroutineContext) {
        p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
        if (p1Var != null) {
            p1Var.h(null);
        }
    }

    public static final void i(CoroutineContext coroutineContext) {
        p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
        if (p1Var != null && !p1Var.a()) {
            throw p1Var.t();
        }
    }

    public static final String j(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final p1 k(CoroutineContext coroutineContext) {
        p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
        if (p1Var != null) {
            return p1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final l l(Continuation continuation) {
        l lVar;
        l lVar2;
        if (!(continuation instanceof qi.f)) {
            return new l(1, continuation);
        }
        qi.f fVar = (qi.f) continuation;
        fVar.getClass();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.f.f9140j;
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            a8.a aVar = qi.g.f9145b;
            lVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, aVar);
                lVar2 = null;
                break;
            }
            if (obj instanceof l) {
                if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, aVar)) {
                    lVar2 = (l) obj;
                    break;
                }
            } else if (obj != aVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (lVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l.f7465i;
            Object obj2 = atomicReferenceFieldUpdater2.get(lVar2);
            if (!(obj2 instanceof t) || ((t) obj2).f7490d == null) {
                l.f7464h.set(lVar2, 536870911);
                atomicReferenceFieldUpdater2.set(lVar2, b.f7432a);
                lVar = lVar2;
            } else {
                lVar2.n();
            }
            if (lVar != null) {
                return lVar;
            }
        }
        return new l(2, continuation);
    }

    public static x0 m(p1 p1Var, t1 t1Var) {
        return p1Var instanceof x1 ? ((x1) p1Var).Z(true, t1Var) : p1Var.s(t1Var.j(), true, new s1(t1Var));
    }

    public static final boolean n(CoroutineContext coroutineContext) {
        p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
        if (p1Var != null) {
            return p1Var.a();
        }
        return true;
    }

    public static final g2 o(g0 g0Var, CoroutineContext coroutineContext, j0 j0Var, Function2 function2) {
        CoroutineContext coroutineContextB = y.b(g0Var, coroutineContext);
        g2 z1Var = j0Var.isLazy() ? new z1(coroutineContextB, function2) : new g2(coroutineContextB, true, true);
        j0Var.invoke(function2, z1Var, z1Var);
        return z1Var;
    }

    public static /* synthetic */ g2 p(g0 g0Var, CoroutineContext coroutineContext, j0 j0Var, Function2 function2, int i8) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i8 & 2) != 0) {
            j0Var = j0.DEFAULT;
        }
        return o(g0Var, coroutineContext, j0Var, function2);
    }

    public static Object q(Function2 function2) throws Throwable {
        f1 f1VarA;
        CoroutineContext coroutineContextA;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor.Companion key = ContinuationInterceptor.INSTANCE;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) emptyCoroutineContext.get(key);
        if (continuationInterceptor == null) {
            f1VarA = k2.a();
            coroutineContextA = y.a(emptyCoroutineContext, emptyCoroutineContext.plus(f1VarA), true);
            si.f fVar = v0.f7499b;
            if (coroutineContextA != fVar && coroutineContextA.get(key) == null) {
                coroutineContextA = coroutineContextA.plus(fVar);
            }
        } else {
            if (continuationInterceptor instanceof f1) {
            }
            f1VarA = (f1) k2.f7463a.get();
            coroutineContextA = y.a(emptyCoroutineContext, emptyCoroutineContext, true);
            si.f fVar2 = v0.f7499b;
            if (coroutineContextA != fVar2 && coroutineContextA.get(key) == null) {
                coroutineContextA = coroutineContextA.plus(fVar2);
            }
        }
        f fVar3 = new f(coroutineContextA, threadCurrentThread, f1VarA);
        j0.DEFAULT.invoke(function2, fVar3, fVar3);
        f1 f1Var = fVar3.e;
        if (f1Var != null) {
            int i8 = f1.f7451d;
            f1Var.o(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jB = f1Var != null ? f1Var.B() : Long.MAX_VALUE;
                if (fVar3.H()) {
                    if (f1Var != null) {
                        int i9 = f1.f7451d;
                        f1Var.i(false);
                    }
                    Object objT = t(x1.f7509a.get(fVar3));
                    u uVar = objT instanceof u ? (u) objT : null;
                    if (uVar == null) {
                        return objT;
                    }
                    throw uVar.f7494a;
                }
                LockSupport.parkNanos(fVar3, jB);
            } catch (Throwable th2) {
                if (f1Var != null) {
                    int i10 = f1.f7451d;
                    f1Var.i(false);
                }
                throw th2;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        fVar3.z(interruptedException);
        throw interruptedException;
    }

    public static final Object r(q3 q3Var, r3 r3Var) {
        h2 h2Var = new h2(r3Var.get$context(), r3Var, 0);
        Object objA = bd.a(h2Var, h2Var, q3Var);
        if (objA == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(r3Var);
        }
        return objA;
    }

    public static final String s(Continuation continuation) {
        Object objM159constructorimpl;
        if (continuation instanceof qi.f) {
            return ((qi.f) continuation).toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(continuation + '@' + j(continuation));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m162exceptionOrNullimpl(objM159constructorimpl) != null) {
            objM159constructorimpl = continuation.getClass().getName() + '@' + j(continuation);
        }
        return (String) objM159constructorimpl;
    }

    public static final Object t(Object obj) {
        l1 l1Var;
        m1 m1Var = obj instanceof m1 ? (m1) obj : null;
        return (m1Var == null || (l1Var = m1Var.f7479a) == null) ? obj : l1Var;
    }

    public static final Object u(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) throws Throwable {
        Object objT;
        CoroutineContext context = continuation.get$context();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, new ag.q(8))).booleanValue() ? context.plus(coroutineContext) : y.a(context, coroutineContext, false);
        i(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            qi.v vVar = new qi.v(continuation, coroutineContextPlus);
            objT = bd.a(vVar, vVar, function2);
        } else {
            ContinuationInterceptor.Companion key = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(coroutineContextPlus.get(key), context.get(key))) {
                q2 q2Var = new q2(continuation, coroutineContextPlus);
                CoroutineContext coroutineContext2 = q2Var.f7429c;
                Object objC = qi.z.c(coroutineContext2, null);
                try {
                    Object objA = bd.a(q2Var, q2Var, function2);
                    qi.z.a(coroutineContext2, objC);
                    objT = objA;
                } catch (Throwable th2) {
                    qi.z.a(coroutineContext2, objC);
                    throw th2;
                }
            } else {
                s0 s0Var = new s0(continuation, coroutineContextPlus);
                ri.a.b(function2, s0Var, s0Var);
                while (true) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = s0.e;
                    int i8 = atomicIntegerFieldUpdater.get(s0Var);
                    if (i8 != 0) {
                        if (i8 != 2) {
                            throw new IllegalStateException("Already suspended");
                        }
                        objT = t(x1.f7509a.get(s0Var));
                        if (!(objT instanceof u)) {
                            break;
                        }
                        throw ((u) objT).f7494a;
                    }
                    if (atomicIntegerFieldUpdater.compareAndSet(s0Var, 0, 1)) {
                        objT = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        break;
                    }
                }
            }
        }
        if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objT;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object v(ContinuationImpl continuationImpl) {
        Object coroutine_suspended;
        CoroutineContext context = continuationImpl.get$context();
        i(context);
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(continuationImpl);
        qi.f fVar = continuationIntercepted instanceof qi.f ? (qi.f) continuationIntercepted : null;
        if (fVar == null) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            a0 a0Var = fVar.f9141d;
            if (a0Var.isDispatchNeeded(context)) {
                fVar.f9142h = Unit.INSTANCE;
                fVar.f7491c = 1;
                a0Var.dispatchYield(context, fVar);
            } else {
                u2 u2Var = new u2(u2.f7496b);
                CoroutineContext coroutineContextPlus = context.plus(u2Var);
                Unit unit = Unit.INSTANCE;
                fVar.f9142h = unit;
                fVar.f7491c = 1;
                a0Var.dispatchYield(coroutineContextPlus, fVar);
                if (u2Var.f7497a) {
                    f1 f1VarA = k2.a();
                    ArrayDeque arrayDeque = f1VarA.f7454c;
                    if (arrayDeque != null ? arrayDeque.isEmpty() : true) {
                        coroutine_suspended = Unit.INSTANCE;
                    } else if (f1VarA.w()) {
                        fVar.f9142h = unit;
                        fVar.f7491c = 1;
                        f1VarA.k(fVar);
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    } else {
                        f1VarA.o(true);
                        try {
                            fVar.run();
                            do {
                            } while (f1VarA.E());
                        } catch (Throwable th2) {
                            try {
                                fVar.i(th2);
                            } catch (Throwable th3) {
                                f1VarA.i(true);
                                throw th3;
                            }
                        }
                        f1VarA.i(true);
                        coroutine_suspended = Unit.INSTANCE;
                    }
                }
            }
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuationImpl);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
