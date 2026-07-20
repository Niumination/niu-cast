package se;

import com.welink.protocol.nfbd.NearDevice;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class x2 extends SuspendLambda implements Function2 {
    final /* synthetic */ NearDevice $device;
    final /* synthetic */ Ref.IntRef $reasonCode;
    final /* synthetic */ String $remoteIp;
    final /* synthetic */ Ref.IntRef $remotePort;
    int label;
    final /* synthetic */ b3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(b3 b3Var, String str, Ref.IntRef intRef, Ref.IntRef intRef2, NearDevice nearDevice, Continuation<? super x2> continuation) {
        super(2, continuation);
        this.this$0 = b3Var;
        this.$remoteIp = str;
        this.$remotePort = intRef;
        this.$reasonCode = intRef2;
        this.$device = nearDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new x2(this.this$0, this.$remoteIp, this.$remotePort, this.$reasonCode, this.$device, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [se.b3] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                jf.d dVar = this.this$0.f9658c;
                zf.x xVar = zf.x.f11553b;
                String str = this.$remoteIp;
                Integer numBoxInt = Boxing.boxInt(this.$remotePort.element);
                w2 w2Var = new w2(this.this$0, this.$device, this.$remoteIp, null);
                this.label = 1;
                if (uf.c.b(dVar, xVar, str, numBoxInt, w2Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this = this.this$0;
            obj2 = this;
        } catch (Exception e) {
            e.printStackTrace();
            this.this$0.getClass();
            we.h.c("WebSocketKtorClient", "connect exception failed", e);
            this.$reasonCode.element = 17;
            b3 b3Var = this.this$0;
            b3Var.f9659d.o(this.$device, null, Boxing.boxInt(17));
            obj2 = this.this$0;
        } finally {
            this.this$0.getClass();
            we.h.h("WebSocketKtorClient", "WebSocket disconnected");
        }
        obj2.getClass();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((x2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
