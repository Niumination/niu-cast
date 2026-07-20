package jh;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.r1;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2<z0, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ k $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n0(Function2<? super z0, ? super Continuation<? super Unit>, ? extends Object> function2, k kVar, Continuation<? super n0> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$channel = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        n0 n0Var = new n0(this.$block, this.$channel, continuation);
        n0Var.L$0 = obj;
        return n0Var;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2 A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #1 {all -> 0x00b4, blocks: (B:30:0x0094, B:32:0x00a2), top: B:74:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0110 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [li.p1] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r9v19 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        k kVar;
        Throwable th2;
        Throwable th3;
        li.g0 g0Var;
        r1 r1Var;
        k kVar2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = this.label;
        try {
            try {
                switch (r7) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        g0Var = (li.g0) this.L$0;
                        r1 r1Var2 = new r1(li.l0.k(g0Var.getCoroutineContext()));
                        Function2<z0, Continuation<? super Unit>, Object> function2 = this.$block;
                        z0 z0Var = new z0(this.$channel, g0Var.getCoroutineContext().plus(r1Var2));
                        this.L$0 = g0Var;
                        this.L$1 = r1Var2;
                        this.label = 1;
                        r7 = r1Var2;
                        if (function2.invoke(z0Var, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r1Var = (r1) r7;
                        r1Var.r0();
                        try {
                            if (li.l0.k(g0Var.getCoroutineContext()).isCancelled()) {
                                this.$channel.b(li.l0.k(g0Var.getCoroutineContext()).t());
                            }
                            this.L$0 = g0Var;
                            this.L$1 = null;
                            this.label = 2;
                            if (r1Var.S(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            kVar2 = this.$channel;
                            Result.Companion companion = Result.INSTANCE;
                            this.L$0 = null;
                            this.label = 3;
                            if (kVar2.i(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Result.m159constructorimpl(Unit.INSTANCE);
                            break;
                        } catch (Throwable th4) {
                            r7 = r1Var;
                            th = th4;
                            try {
                                li.l0.g("Exception thrown while writing to channel", th, r7);
                                this.$channel.b(th);
                                this.L$0 = g0Var;
                                this.L$1 = null;
                                this.label = 4;
                                if (((x1) r7).S(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                kVar = this.$channel;
                                Result.Companion companion2 = Result.INSTANCE;
                                this.L$0 = null;
                                this.label = 5;
                                if (kVar.i(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Result.m159constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th5) {
                                th = th5;
                                this.L$0 = g0Var;
                                this.L$1 = th;
                                this.label = 6;
                                if (((x1) r7).S(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        li.s sVar = (li.s) this.L$1;
                        g0Var = (li.g0) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r7 = sVar;
                        r1Var = (r1) r7;
                        r1Var.r0();
                        if (li.l0.k(g0Var.getCoroutineContext()).isCancelled()) {
                            this.$channel.b(li.l0.k(g0Var.getCoroutineContext()).t());
                            break;
                        }
                        this.L$0 = g0Var;
                        this.L$1 = null;
                        this.label = 2;
                        if (r1Var.S(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kVar2 = this.$channel;
                        Result.Companion companion3 = Result.INSTANCE;
                        this.L$0 = null;
                        this.label = 3;
                        if (kVar2.i(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Result.m159constructorimpl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        kVar2 = this.$channel;
                        Result.Companion companion4 = Result.INSTANCE;
                        this.L$0 = null;
                        this.label = 3;
                        if (kVar2.i(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Result.m159constructorimpl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        Result.m159constructorimpl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        kVar = this.$channel;
                        Result.Companion companion5 = Result.INSTANCE;
                        this.L$0 = null;
                        this.label = 5;
                        if (kVar.i(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Result.m159constructorimpl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        Result.m159constructorimpl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 6:
                        Throwable th6 = (Throwable) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        th = th6;
                        k kVar3 = this.$channel;
                        try {
                            Result.Companion companion6 = Result.INSTANCE;
                            this.L$0 = th;
                            this.L$1 = null;
                            this.label = 7;
                            if (kVar3.i(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            th3 = th;
                            Result.m159constructorimpl(Unit.INSTANCE);
                            throw th3;
                        } catch (Throwable th7) {
                            Throwable th8 = th;
                            th2 = th7;
                            th3 = th8;
                            Result.Companion companion7 = Result.INSTANCE;
                            Result.m159constructorimpl(ResultKt.createFailure(th2));
                            throw th3;
                        }
                    case 7:
                        th3 = (Throwable) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Result.m159constructorimpl(Unit.INSTANCE);
                            throw th3;
                        } catch (Throwable th9) {
                            th2 = th9;
                            Result.Companion companion8 = Result.INSTANCE;
                            Result.m159constructorimpl(ResultKt.createFailure(th2));
                            throw th3;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } catch (Throwable th11) {
            Result.Companion companion9 = Result.INSTANCE;
            Result.m159constructorimpl(ResultKt.createFailure(th11));
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((n0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
