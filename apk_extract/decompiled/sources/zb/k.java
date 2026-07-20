package zb;

import ag.d0;
import ag.q;
import android.app.Application;
import android.util.Log;
import bb.s;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import eb.k1;
import eb.y0;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(DeviceViewModel deviceViewModel, Continuation<? super k> continuation) {
        super(2, continuation);
        this.this$0 = deviceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i8 = 2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = this.label;
        if (i9 != 0) {
            if (i9 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            k1 k1Var = k1.f4765a;
            k1.j("ble");
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        y0 y0Var = y0.f4813a;
        Application applicationA = pb.a();
        this.label = 1;
        obj = y0.f4813a.a(applicationA, true, true, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
            Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
            Intrinsics.checkNotNullParameter("startScanDeviceAndRegisterPCPassiveConnect: check fail, close icon", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DeviceViewModel"), "startScanDeviceAndRegisterPCPassiveConnect: check fail, close icon");
            }
            y0.b("DeviceViewModel:startScanDeviceAndRegisterPCPassiveConnect");
            return Unit.INSTANCE;
        }
        DeviceViewModel deviceViewModel = this.this$0;
        deviceViewModel.getClass();
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("registerPCPassiveConnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), "registerPCPassiveConnect");
        }
        k1 k1Var2 = k1.f4765a;
        b callback = new b(deviceViewModel, i8);
        Intrinsics.checkNotNullParameter(callback, "callback");
        d0 callback2 = new d0(callback, 7);
        s onPreConnectCallback = new s(6);
        Intrinsics.checkNotNullParameter(callback2, "callback");
        Intrinsics.checkNotNullParameter(onPreConnectCallback, "onPreConnectCallback");
        Intrinsics.checkNotNullParameter("BleConnectFromPeer", "tag");
        Intrinsics.checkNotNullParameter("registerBleConnectFromPeer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BleConnectFromPeer"), "registerBleConnectFromPeer");
        }
        ma.a.f7953b = callback2;
        ma.a.f7954c = onPreConnectCallback;
        ma.a.f7955d = new q(11);
        ma.a.e = new ag.b(18);
        ma.a.f = new q(12);
        Lazy lazy = mc.b.f7958a;
        q qVar = ma.a.f7955d;
        q qVar2 = ma.a.f;
        ag.b bVar = ma.a.e;
        String log = "setPcConnCallback:connectCallback:" + qVar + ",disconnectCallback:" + qVar2 + ",notifyCallback:" + bVar + ",p2pOccupyCallback:null  ";
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), log);
        }
        mc.b.f7962g = qVar;
        mc.b.f7963h = qVar2;
        mc.b.f7964i = bVar;
        DeviceViewModel deviceViewModel2 = this.this$0;
        this.label = 2;
        if (DeviceViewModel.b(deviceViewModel2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        k1 k1Var3 = k1.f4765a;
        k1.j("ble");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((k) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
