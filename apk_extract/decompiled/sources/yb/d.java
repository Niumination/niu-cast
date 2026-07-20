package yb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.ConnectingFragment;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.r0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ ConnectingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ConnectingFragment connectingFragment, Continuation<? super d> continuation) {
        super(2, continuation);
        this.this$0 = connectingFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (r0.a(60000L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Intrinsics.checkNotNullParameter("ConnectingFragment", "tag");
        Intrinsics.checkNotNullParameter("connect timeout", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("ConnectingFragment"), "connect timeout");
        }
        this.this$0.e().f();
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        String triggerScene = ob.b.f8418c;
        Intrinsics.checkNotNullParameter("others_failed", "requestConnectStatus");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        bVar.f8437a.q("others_failed", triggerScene);
        v0 v0Var = v0.f7498a;
        si.e eVar = si.e.f10118a;
        c cVar = new c(null);
        this.label = 2;
        if (l0.u(eVar, cVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
