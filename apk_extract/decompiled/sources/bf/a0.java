package bf;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ze.c2;
import ze.p1;
import ze.q2;
import ze.r2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends SuspendLambda implements Function2 {
    final /* synthetic */ c2 $call;
    final /* synthetic */ Function1<oi.h, oi.h> $implementation;
    final /* synthetic */ t $readiness;
    final /* synthetic */ oi.h $requests;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a0(Function1<? super oi.h, ? extends oi.h> function1, oi.h hVar, t tVar, c2 c2Var, Continuation<? super a0> continuation) {
        super(2, continuation);
        this.$implementation = function1;
        this.$requests = hVar;
        this.$readiness = tVar;
        this.$call = c2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        a0 a0Var = new a0(this.$implementation, this.$requests, this.$readiness, this.$call, continuation);
        a0Var.L$0 = obj;
        return a0Var;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00db  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x0100  */
    /* JADX WARN: Code duplicated, block: B:54:0x011a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.concurrent.atomic.AtomicBoolean] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM159constructorimpl;
        ?? r7;
        Throwable thM162exceptionOrNullimpl;
        c2 c2Var;
        Throwable th2;
        vi.a aVar;
        vi.a aVar2;
        q2 q2VarG;
        p1 p1Var;
        c2 c2Var2;
        vi.c cVar;
        q2 q2Var;
        vi.a aVar3;
        c2 c2Var3;
        p1 p1Var2;
        vi.a aVar4;
        vi.a aVar5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = this.label;
        try {
            if (r10 != 0) {
                if (r10 == 1) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) this.L$1;
                    vi.a aVar6 = (vi.a) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r10 = atomicBoolean;
                    aVar5 = aVar6;
                } else if (r10 == 2) {
                    c2Var = (c2) this.L$3;
                    vi.a aVar7 = (vi.a) this.L$2;
                    th2 = (Throwable) this.L$1;
                    vi.a aVar8 = (vi.a) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    aVar4 = aVar7;
                    aVar = aVar8;
                    try {
                        c2Var.c(new p1());
                        Unit unit = Unit.INSTANCE;
                        ((vi.c) aVar4).e(null);
                        thM162exceptionOrNullimpl = th2;
                        aVar2 = aVar;
                        if (thM162exceptionOrNullimpl == null) {
                            q2VarG = q2.e;
                        } else if (thM162exceptionOrNullimpl instanceof CancellationException) {
                            q2VarG = q2.f.g(thM162exceptionOrNullimpl);
                        } else {
                            if (thM162exceptionOrNullimpl instanceof r2 ? true : thM162exceptionOrNullimpl instanceof s2) {
                                q2VarG = q2.d(thM162exceptionOrNullimpl);
                            } else {
                                q2VarG = q2.d(thM162exceptionOrNullimpl).g(thM162exceptionOrNullimpl);
                            }
                        }
                        if (thM162exceptionOrNullimpl != null || (p1Var = q2.f(thM162exceptionOrNullimpl)) == null) {
                            p1Var = new p1();
                        }
                        c2Var2 = this.$call;
                        this.L$0 = q2VarG;
                        this.L$1 = p1Var;
                        this.L$2 = aVar2;
                        this.L$3 = c2Var2;
                        this.label = 3;
                        cVar = (vi.c) aVar2;
                        if (cVar.d(null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        q2Var = q2VarG;
                        aVar3 = cVar;
                        c2Var3 = c2Var2;
                        p1Var2 = p1Var;
                    } catch (Throwable th3) {
                        ((vi.c) aVar4).e(null);
                        throw th3;
                    }
                } else {
                    if (r10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c2Var3 = (c2) this.L$3;
                    aVar3 = (vi.a) this.L$2;
                    p1Var2 = (p1) this.L$1;
                    q2Var = (q2) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                try {
                    c2Var3.a(q2Var, p1Var2);
                    Unit unit2 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                } finally {
                    ((vi.c) aVar3).e(null);
                }
            }
            ResultKt.throwOnFailure(obj);
            vi.c cVarA = vi.d.a();
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            Function1<oi.h, oi.h> function1 = this.$implementation;
            oi.h hVar = this.$requests;
            t tVar = this.$readiness;
            c2 c2Var4 = this.$call;
            Result.Companion companion = Result.INSTANCE;
            oi.h hVarInvoke = function1.invoke(hVar);
            z zVar = new z(atomicBoolean2, cVarA, tVar, c2Var4);
            this.L$0 = cVarA;
            this.L$1 = atomicBoolean2;
            this.label = 1;
            r10 = atomicBoolean2;
            aVar5 = cVarA;
            if (hVarInvoke.a(zVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
            r7 = r10;
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th4));
            r7 = r10;
        }
        thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        aVar2 = aVar5;
        if (thM162exceptionOrNullimpl == null && r7.compareAndSet(false, true)) {
            c2Var = this.$call;
            this.L$0 = aVar5;
            this.L$1 = thM162exceptionOrNullimpl;
            this.L$2 = aVar5;
            this.L$3 = c2Var;
            this.label = 2;
            vi.c cVar2 = (vi.c) aVar5;
            if (cVar2.d(null, this) == coroutine_suspended) {
                aVar2 = aVar5;
                return coroutine_suspended;
            }
            aVar2 = aVar5;
            th2 = thM162exceptionOrNullimpl;
            aVar = cVar2;
            aVar4 = cVar2;
            c2Var.c(new p1());
            Unit unit3 = Unit.INSTANCE;
            ((vi.c) aVar4).e(null);
            thM162exceptionOrNullimpl = th2;
            aVar2 = aVar;
        }
        if (thM162exceptionOrNullimpl == null) {
            q2VarG = q2.e;
        } else if (thM162exceptionOrNullimpl instanceof CancellationException) {
            q2VarG = q2.f.g(thM162exceptionOrNullimpl);
        } else {
            if (thM162exceptionOrNullimpl instanceof r2 ? true : thM162exceptionOrNullimpl instanceof s2) {
                q2VarG = q2.d(thM162exceptionOrNullimpl);
            } else {
                q2VarG = q2.d(thM162exceptionOrNullimpl).g(thM162exceptionOrNullimpl);
            }
        }
        if (thM162exceptionOrNullimpl != null) {
            p1Var = new p1();
        } else {
            p1Var = new p1();
        }
        c2Var2 = this.$call;
        this.L$0 = q2VarG;
        this.L$1 = p1Var;
        this.L$2 = aVar2;
        this.L$3 = c2Var2;
        this.label = 3;
        cVar = (vi.c) aVar2;
        if (cVar.d(null, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        q2Var = q2VarG;
        aVar3 = cVar;
        c2Var3 = c2Var2;
        p1Var2 = p1Var;
        c2Var3.a(q2Var, p1Var2);
        Unit unit4 = Unit.INSTANCE;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
