package se;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y2 extends SuspendLambda implements Function2 {
    final /* synthetic */ uf.d $currentSession;
    final /* synthetic */ NearDevice $device;
    int label;
    final /* synthetic */ b3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y2(uf.d dVar, b3 b3Var, NearDevice nearDevice, Continuation<? super y2> continuation) {
        super(2, continuation);
        this.$currentSession = dVar;
        this.this$0 = b3Var;
        this.$device = nearDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new y2(this.$currentSession, this.this$0, this.$device, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.welink.protocol.nfbd.NearDevice] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                if (li.h0.d(this.$currentSession)) {
                    uf.d dVar = this.$currentSession;
                    oh.c cVar = new oh.c(oh.b.NORMAL, "Closing the session");
                    this.label = 1;
                    if (oh.u0.b(dVar, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.this$0.getClass();
                    we.h.h("WebSocketKtorClient", "session is not active");
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.this$0.getClass();
            Intrinsics.checkNotNullParameter("WebSocketKtorClient", "tag");
            Intrinsics.checkNotNullParameter("disconnect exception", "mes");
            if (lb.f6529c >= 1) {
                Log.e("WebSocketKtorClient", "TransConnect:disconnect exception", e);
            }
        } finally {
            b3.b(this.this$0, this.$device);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((y2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
