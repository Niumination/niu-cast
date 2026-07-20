package se;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $remoteIp;
    final /* synthetic */ uf.d $session;
    Object L$0;
    int label;
    final /* synthetic */ b3 this$0;
    final /* synthetic */ d3 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3(b3 b3Var, String str, uf.d dVar, byte[] bArr, d3 d3Var, Continuation<? super a3> continuation) {
        super(2, continuation);
        this.this$0 = b3Var;
        this.$remoteIp = str;
        this.$session = dVar;
        this.$data = bArr;
        this.this$1 = d3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a3(this.this$0, this.$remoteIp, this.$session, this.$data, this.this$1, continuation);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x00e7: IGET (r0 I:oh.d) = (r14 I:uf.d) uf.d.a oh.d, block:B:55:0x00e3 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0116: IGET (r0 I:oh.d) = (r14 I:uf.d) uf.d.a oh.d, block:B:67:0x0112 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0130: IGET (r3 I:oh.d) = (r14 I:uf.d) uf.d.a oh.d, block:B:75:0x012b */
    /* JADX WARN: Type inference failed for: r14v0, types: [uf.d] */
    /* JADX WARN: Type inference failed for: r14v1, types: [uf.d] */
    /* JADX WARN: Type inference failed for: r14v2, types: [uf.d] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ?? r14;
        ?? r15;
        ?? r16;
        uf.d dVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        dVar = (uf.d) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i8 != 2 && i8 != 3 && i8 != 4) {
                            if (i8 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th2 = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th2;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                uf.d dVar2 = (uf.d) this.this$0.f9656a.get(this.$remoteIp);
                if (dVar2 == null) {
                    dVar2 = this.$session;
                }
                dVar = dVar2;
                if (li.h0.d(dVar)) {
                    byte[] data = this.$data;
                    this.L$0 = dVar;
                    this.label = 1;
                    Intrinsics.checkNotNullParameter(data, "data");
                    Object objE = dVar.E(new oh.m(true, data, false, false, false), this);
                    if (objE != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        objE = Unit.INSTANCE;
                    }
                    if (objE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                    Intrinsics.checkNotNullParameter("sendPacketArray, session is not active", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearLanTcpClient", "TransConnect:sendPacketArray, session is not active", null);
                    }
                    CountDownLatch countDownLatch = this.this$1.f9713l;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
                CountDownLatch countDownLatch2 = this.this$1.f9713l;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                this.L$0 = null;
                this.label = 2;
                if (dVar.f10425a.l(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (IOException e) {
                e.printStackTrace();
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("sendPacketArray, write exception", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:sendPacketArray, write exception", e);
                }
                CountDownLatch countDownLatch3 = this.this$1.f9713l;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                CountDownLatch countDownLatch4 = this.this$1.f9713l;
                if (countDownLatch4 != null) {
                    countDownLatch4.countDown();
                }
                this.L$0 = null;
                this.label = 3;
                if (r15.f10425a.l(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("sendPacketArray, write exception", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:sendPacketArray, write exception", e4);
                }
                CountDownLatch countDownLatch5 = this.this$1.f9713l;
                if (countDownLatch5 != null) {
                    countDownLatch5.countDown();
                }
                CountDownLatch countDownLatch6 = this.this$1.f9713l;
                if (countDownLatch6 != null) {
                    countDownLatch6.countDown();
                }
                this.L$0 = null;
                this.label = 4;
                if (r14.f10425a.l(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            CountDownLatch countDownLatch7 = this.this$1.f9713l;
            if (countDownLatch7 != null) {
                countDownLatch7.countDown();
            }
            this.L$0 = th3;
            this.label = 5;
            if (r16.f10425a.l(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
