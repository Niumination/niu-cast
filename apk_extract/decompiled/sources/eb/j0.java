package eb;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import k3.gc;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(li.j jVar, Continuation<? super j0> continuation) {
        super(2, continuation);
        this.$continuation = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j0(this.$continuation, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Lazy lazy = l0.f4770a;
            this.label = 1;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(this));
            lVar.s();
            WifiP2pManager wifiP2pManager = (WifiP2pManager) l0.f4770a.getValue();
            if (wifiP2pManager != null) {
                wifiP2pManager.requestGroupInfo((WifiP2pManager.Channel) l0.f4771b.getValue(), new i0(lVar));
            }
            obj = lVar.r();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String strO = o.d.o("hasConnectedGC: ", zBooleanValue, "P2PTool", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PTool"), strO);
        }
        this.$continuation.resumeWith(Result.m159constructorimpl(Boxing.boxBoolean(zBooleanValue)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((j0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
