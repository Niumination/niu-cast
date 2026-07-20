package nf;

import java.util.concurrent.CancellationException;
import jh.j0;
import jh.l0;
import jh.o0;
import jh.v0;
import k3.ha;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends SuspendLambda implements Function2 {
    final /* synthetic */ cg.j $body;
    final /* synthetic */ j0 $channel;
    final /* synthetic */ v0 $chunkedJob;
    final /* synthetic */ boolean $closeChannel;
    final /* synthetic */ j0 $output;
    final /* synthetic */ vf.d $request;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(vf.d dVar, cg.j jVar, j0 j0Var, v0 v0Var, j0 j0Var2, boolean z2, Continuation<? super y> continuation) {
        super(2, continuation);
        this.$request = dVar;
        this.$body = jVar;
        this.$channel = j0Var;
        this.$chunkedJob = v0Var;
        this.$output = j0Var2;
        this.$closeChannel = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new y(this.$request, this.$body, this.$channel, this.$chunkedJob, this.$output, this.$closeChannel, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0099  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:80:0x0103  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th2;
        Throwable thC;
        Throwable thA;
        Throwable th3;
        v0 v0Var;
        v0 v0Var2;
        Object objS;
        Throwable thC2;
        Throwable thA2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i8 == 2) {
                    ResultKt.throwOnFailure(obj);
                    v0Var = this.$chunkedJob;
                    if (v0Var != null) {
                        ha.a(v0Var.f6306a);
                    }
                    v0Var2 = this.$chunkedJob;
                    if (v0Var2 != null) {
                        this.label = 3;
                        l0 l0Var = o0.f6300a;
                        objS = ((x1) v0Var2.a()).S(this);
                        if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            objS = Unit.INSTANCE;
                        }
                        if (objS == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            Throwable th4 = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            th = th4;
                            v0 v0Var3 = this.$chunkedJob;
                            if (v0Var3 != null) {
                                ha.a(v0Var3.f6306a);
                            }
                            v0 v0Var4 = this.$chunkedJob;
                            if (v0Var4 != null) {
                                this.L$0 = th;
                                this.label = 5;
                                l0 l0Var2 = o0.f6300a;
                                Object objS2 = ((x1) v0Var4.a()).S(this);
                                if (objS2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    objS2 = Unit.INSTANCE;
                                }
                                if (objS2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                th2 = th;
                            }
                            thC = ((jh.k) this.$output).c();
                            if (thC != null && (thA = xf.a.a(thC)) != null) {
                                th3 = thA instanceof CancellationException ? null : thA;
                                if (th3 != null) {
                                    throw th3;
                                }
                            }
                            if (this.$closeChannel) {
                                ha.a(this.$output);
                            }
                            throw th;
                        }
                        if (i8 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th2 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        th = th2;
                        thC = ((jh.k) this.$output).c();
                        if (thC != null) {
                            if (thA instanceof CancellationException) {
                            }
                            if (th3 != null) {
                                throw th3;
                            }
                        }
                        if (this.$closeChannel) {
                            ha.a(this.$output);
                        }
                        throw th;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                thC2 = ((jh.k) this.$output).c();
                if (thC2 != null && (thA2 = xf.a.a(thC2)) != null) {
                    th3 = thA2 instanceof CancellationException ? null : thA2;
                    if (th3 != null) {
                        throw th3;
                    }
                }
                if (this.$closeChannel) {
                    ha.a(this.$output);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            cg.j jVar = this.$body;
            j0 j0Var = this.$channel;
            this.label = 1;
            if (b0.b(jVar, j0Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j0 j0Var2 = this.$channel;
            this.label = 2;
            if (((jh.k) j0Var2).h(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            v0Var = this.$chunkedJob;
            if (v0Var != null) {
                ha.a(v0Var.f6306a);
            }
            v0Var2 = this.$chunkedJob;
            if (v0Var2 != null) {
                this.label = 3;
                l0 l0Var3 = o0.f6300a;
                objS = ((x1) v0Var2.a()).S(this);
                if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objS = Unit.INSTANCE;
                }
                if (objS == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            thC2 = ((jh.k) this.$output).c();
            if (thC2 != null) {
                if (thA2 instanceof CancellationException) {
                }
                if (th3 != null) {
                    throw th3;
                }
            }
            if (this.$closeChannel) {
                ha.a(this.$output);
            }
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            try {
                o0.a(this.$channel, th5);
                throw th5;
            } catch (Throwable th6) {
                th = th6;
                j0 j0Var3 = this.$channel;
                this.L$0 = th;
                this.label = 4;
                if (((jh.k) j0Var3).h(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((y) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
