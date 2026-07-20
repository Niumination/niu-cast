package eb;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.Log;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(Context context, Continuation<? super m0> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m0(this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i8 = 0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = this.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zIsEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
            String strO = o.d.o("checkBluetooth bleState:", zIsEnabled, "PCConnectSwitchManager", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCConnectSwitchManager"), strO);
            }
            if (zIsEnabled) {
                return Boxing.boxBoolean(true);
            }
            y0 y0Var = y0.f4813a;
            Context context = this.$context;
            this.label = 1;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(this));
            lVar.s();
            qi.c cVar = y0.f4822l;
            r0 r0Var = new r0(li.l0.p(cVar, null, null, new u0(lVar, null), 3), lVar, i8);
            li.l0.p(cVar, qi.r.f9163a, null, new q0(r0Var, null), 2);
            Intrinsics.checkNotNullParameter(context, "context");
            if (!BluetoothAdapter.getDefaultAdapter().isEnabled() && context.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothAdapter.getDefaultAdapter().enable();
            }
            t0 t0Var = new t0(r0Var, i8);
            lVar.v(t0Var);
            na.a.a(lVar, t0Var);
            obj = lVar.r();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Boolean> continuation) {
        return ((m0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
