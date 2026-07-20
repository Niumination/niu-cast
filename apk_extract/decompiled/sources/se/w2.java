package se;

import com.welink.protocol.nfbd.NearDevice;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class w2 extends SuspendLambda implements Function2 {
    final /* synthetic */ NearDevice $device;
    final /* synthetic */ String $remoteIp;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(b3 b3Var, NearDevice nearDevice, String str, Continuation<? super w2> continuation) {
        super(2, continuation);
        this.this$0 = b3Var;
        this.$device = nearDevice;
        this.$remoteIp = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        w2 w2Var = new w2(this.this$0, this.$device, this.$remoteIp, continuation);
        w2Var.L$0 = obj;
        return w2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            uf.d dVar = (uf.d) this.L$0;
            this.this$0.getClass();
            we.h.h("WebSocketKtorClient", "WebSocket opened");
            b3 b3Var = this.this$0;
            NearDevice nearDevice = this.$device;
            String str = this.$remoteIp;
            b3Var.f9656a.put(str, dVar);
            d3 d3Var = b3Var.f9659d;
            d3Var.f9711j.put(str, dVar);
            af.r4 r4Var = new af.r4(d3Var, nearDevice, str, dVar, null, 2);
            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
            we.m.a(1792, 50L, d3Var.a(), r4Var);
            b3 b3Var2 = this.this$0;
            NearDevice nearDevice2 = this.$device;
            String str2 = this.$remoteIp;
            this.label = 1;
            if (b3.a(b3Var2, nearDevice2, str2, dVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(uf.d dVar, Continuation<? super Unit> continuation) {
        return ((w2) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
