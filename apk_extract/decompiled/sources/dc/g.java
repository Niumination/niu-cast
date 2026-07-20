package dc;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.service.quicksettings.TileService;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.ChannelOccupyDialog;
import eb.k0;
import eb.k1;
import eb.l0;
import k3.gc;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.h0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4406a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g2 f4407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f4408c;

    static {
        v0 v0Var = v0.f7498a;
        f4408c = h0.a(si.e.f10118a);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(int i8, Context context, Function1 function1, ContinuationImpl continuationImpl) {
        e eVar;
        if (continuationImpl instanceof e) {
            eVar = (e) continuationImpl;
            int i9 = eVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                eVar.label = i9 - Integer.MIN_VALUE;
            } else {
                eVar = new e(this, continuationImpl);
            }
        } else {
            eVar = new e(this, continuationImpl);
        }
        Object objR = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = eVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(objR);
            k1 k1Var = k1.f4765a;
            eVar.L$0 = context;
            eVar.L$1 = function1;
            eVar.I$0 = i8;
            eVar.label = 1;
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("isP2PConnected", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PhysicalConnectManager"), "isP2PConnected");
            }
            Lazy lazy = l0.f4770a;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(eVar));
            lVar.s();
            WifiP2pManager wifiP2pManager = (WifiP2pManager) l0.f4770a.getValue();
            if (wifiP2pManager != null) {
                wifiP2pManager.requestConnectionInfo((WifiP2pManager.Channel) l0.f4771b.getValue(), new k0(lVar));
            }
            objR = lVar.r();
            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(eVar);
            }
            if (objR == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i8 = eVar.I$0;
            function1 = (Function1) eVar.L$1;
            context = (Context) eVar.L$0;
            ResultKt.throwOnFailure(objR);
        }
        if (((Boolean) objR).booleanValue()) {
            d dVar = new d(0, function1);
            d dVar2 = ChannelOccupyDialog.f2726c;
            Intrinsics.checkNotNullParameter(context, "context");
            ChannelOccupyDialog.f2726c = dVar;
            Intent intent = new Intent(context, (Class<?>) ChannelOccupyDialog.class);
            intent.setFlags(268435456);
            Intent intentPutExtra = intent.putExtra("serviceType", i8);
            if (context instanceof TileService) {
                Intrinsics.checkNotNullParameter("ChannelOccupyDialog", "tag");
                Intrinsics.checkNotNullParameter("openDialog context is TileService", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ChannelOccupyDialog"), "openDialog context is TileService");
                }
                ((TileService) context).startActivity(intentPutExtra);
            } else {
                context.startActivity(intentPutExtra);
            }
        } else {
            function1.invoke(context);
        }
        return Unit.INSTANCE;
    }
}
