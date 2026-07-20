package eb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$bluetoothReceiver$1;
import com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$hotspotReceiver$1;
import com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$wifiReceiver$1;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import eb.k1;
import eb.y0;
import k3.fd;
import k3.gc;
import k3.pb;
import k3.ub;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import na.k;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f4813a = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData f4815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData f4816d;
    public static boolean e;
    public static final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MutableLiveData f4817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableLiveData f4818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MutableLiveData f4819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MutableLiveData f4820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final MutableLiveData f4821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final qi.c f4822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final PCConnectSwitchManager$bluetoothReceiver$1 f4823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final PCConnectSwitchManager$wifiReceiver$1 f4824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final PCConnectSwitchManager$hotspotReceiver$1 f4825o;

    /* JADX WARN: Type inference failed for: r0v7, types: [com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$bluetoothReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$wifiReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$hotspotReceiver$1] */
    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        f4815c = mutableLiveData;
        f4816d = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        f = mutableLiveData2;
        f4817g = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        f4818h = mutableLiveData3;
        f4819i = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        f4820j = mutableLiveData4;
        f4821k = mutableLiveData4;
        f4822l = li.h0.a(li.v0.f7499b);
        f4823m = new BroadcastReceiver() { // from class: com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$bluetoothReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
                Intrinsics.checkNotNullParameter("on bluetooth state changed", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "on bluetooth state changed");
                }
                if (intent == null || !Intrinsics.areEqual("android.bluetooth.adapter.action.STATE_CHANGED", intent.getAction())) {
                    return;
                }
                y0 y0Var = y0.f4813a;
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                String strM = d.m("bluetoothState:", "PCConnectSwitchManager", "tag", "log", intExtra);
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("PCConnectSwitchManager"), strM);
                }
                MutableLiveData mutableLiveData5 = y0.f;
                if (intExtra != 10) {
                    if (intExtra != 12) {
                        return;
                    }
                    mutableLiveData5.setValue(Boolean.TRUE);
                    return;
                }
                mutableLiveData5.setValue(Boolean.FALSE);
                if (!y0.e || DeviceConnectState.INSTANCE.isConnected() || Intrinsics.areEqual(k1.f4766b, "cable")) {
                    return;
                }
                y0.b("self:onBleClosed");
                y0.g();
            }
        };
        f4824n = new BroadcastReceiver() { // from class: com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$wifiReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
                Intrinsics.checkNotNullParameter("on wifi state changed", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "on wifi state changed");
                }
                if (intent != null) {
                    y0 y0Var = y0.f4813a;
                    int intExtra = intent.getIntExtra("wifi_state", 1);
                    String strM = d.m("wifiState:", "PCConnectSwitchManager", "tag", "log", intExtra);
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("PCConnectSwitchManager"), strM);
                    }
                    MutableLiveData mutableLiveData5 = y0.f4818h;
                    if (intExtra != 1) {
                        if (intExtra != 3) {
                            return;
                        }
                        mutableLiveData5.setValue(Boolean.TRUE);
                    } else {
                        mutableLiveData5.setValue(Boolean.FALSE);
                        if (!y0.e || Intrinsics.areEqual(k1.f4766b, "cable")) {
                            return;
                        }
                        y0.b("self:onWifiClosed");
                        y0.g();
                    }
                }
            }
        };
        f4825o = new BroadcastReceiver() { // from class: com.transsion.iotservice.multiscreen.pc.manager.PCConnectSwitchManager$hotspotReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
                Intrinsics.checkNotNullParameter("on hotspot state changed", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "on hotspot state changed");
                }
                if (intent != null) {
                    y0 y0Var = y0.f4813a;
                    int intExtra = intent.getIntExtra("wifi_state", 1);
                    MutableLiveData mutableLiveData5 = y0.f4820j;
                    if (intExtra == 11) {
                        mutableLiveData5.postValue(Boolean.FALSE);
                        return;
                    }
                    if (intExtra != 13) {
                        return;
                    }
                    if (y0.e) {
                        y0.b("onHotSpotOpen");
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = pb.a().getString(R$string.hot_spot_open_tip);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        k.f8141a.b(pb.a(), d.q(new Object[]{pb.a().getString(R$string.module_pc_connect)}, 1, string, "format(...)"));
                    }
                    mutableLiveData5.postValue(Boolean.TRUE);
                }
            }
        };
    }

    public static void b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String log = "closePcConnectionSwitch from ".concat(tag);
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectSwitchManager"), log);
        }
        if (!f(false) || Intrinsics.areEqual(y.f4804h, new Initial())) {
            return;
        }
        li.l0.p(f4822l, null, null, new p0(tag, true, null), 3);
    }

    public static void c(String tag, boolean z2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String log = "closePcConnectionSwitchOnly from " + tag + ", isInterrupt: " + z2;
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectSwitchManager"), log);
        }
        f(false);
        if (m3.m.f7774a) {
            ob.b.f8417b.b("disconnect_other_ways");
        }
        if (z2) {
            boolean z3 = DialogUtilActivity.f2733j;
            fd.a(pb.a());
        }
    }

    public static void d(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String log = "openPcConnectionSwitch from ".concat(tag);
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectSwitchManager"), log);
        }
        f(true);
    }

    public static Object e(Context context, SuspendLambda suspendLambda) {
        li.l lVar = new li.l(1, IntrinsicsKt.intercepted(suspendLambda));
        lVar.s();
        x0 x0Var = new x0(lVar, null);
        qi.c cVar = f4822l;
        r0 r0Var = new r0(li.l0.p(cVar, null, null, x0Var, 3), lVar, 1);
        li.l0.p(cVar, qi.r.f9163a, null, new v0(r0Var, null), 2);
        ub.c(context);
        t0 t0Var = new t0(r0Var, 1);
        lVar.v(t0Var);
        na.a.a(lVar, t0Var);
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(suspendLambda);
        }
        return objR;
    }

    public static boolean f(boolean z2) {
        if (e == z2) {
            return false;
        }
        e = z2;
        boolean zAreEqual = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        MutableLiveData mutableLiveData = f4815c;
        if (zAreEqual) {
            mutableLiveData.setValue(Boolean.valueOf(e));
            return true;
        }
        mutableLiveData.postValue(Boolean.valueOf(e));
        return true;
    }

    public static void g() {
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter("refreshConnectState,ble or wifi state change releaseResource", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PCConnectSwitchManager"), "refreshConnectState,ble or wifi state change releaseResource");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = pb.a().getString(R$string.module_pc_wifi_ble_state_tip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        na.k.f8141a.b(pb.a(), o.d.q(new Object[]{pb.a().getString(R$string.module_pc_connect)}, 1, string, "format(...)"));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x0098 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final Object a(Context context, boolean z2, boolean z3, ContinuationImpl continuationImpl) throws Throwable {
        n0 n0Var;
        Context context2;
        y0 y0Var;
        ?? BooleanValue;
        boolean zBooleanValue;
        ?? r7;
        ?? r10;
        if (continuationImpl instanceof n0) {
            n0Var = (n0) continuationImpl;
            int i8 = n0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                n0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                n0Var = new n0(this, continuationImpl);
            }
        } else {
            n0Var = new n0(this, continuationImpl);
        }
        Object objU = n0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = n0Var.label;
        boolean z5 = true;
        if (i9 != 0) {
            if (i9 == 1) {
                z3 = n0Var.Z$0;
                context = (Context) n0Var.L$1;
                this = (y0) n0Var.L$0;
                ResultKt.throwOnFailure(objU);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i10 = n0Var.I$0;
                ResultKt.throwOnFailure(objU);
                r10 = i10;
            }
            r10 = BooleanValue;
            zBooleanValue = ((Boolean) objU).booleanValue();
            r7 = r10;
            if (r7 != 0 || !zBooleanValue) {
                r7 = BooleanValue;
                z5 = false;
            }
            return Boxing.boxBoolean(z5);
        }
        ResultKt.throwOnFailure(objU);
        if (z2) {
            n0Var.L$0 = this;
            n0Var.L$1 = context;
            n0Var.Z$0 = z3;
            n0Var.label = 1;
            li.v0 v0Var = li.v0.f7498a;
            objU = li.l0.u(si.e.f10118a, new o0(context, null), n0Var);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            context2 = context;
            y0Var = this;
            BooleanValue = 1;
        }
        if (z3) {
            n0Var.L$0 = null;
            n0Var.L$1 = null;
            n0Var.I$0 = BooleanValue;
            n0Var.label = 2;
            y0Var.getClass();
            li.v0 v0Var2 = li.v0.f7498a;
            objU = li.l0.u(si.e.f10118a, new m0(context2, null), n0Var);
            if (objU == coroutine_suspended) {
                r10 = BooleanValue;
                return coroutine_suspended;
            }
            r10 = BooleanValue;
            zBooleanValue = ((Boolean) objU).booleanValue();
            r7 = r10;
        } else {
            zBooleanValue = true;
        }
        if (r7 != 0) {
            r7 = BooleanValue;
            z5 = false;
        } else {
            r7 = BooleanValue;
            z5 = false;
        }
        return Boxing.boxBoolean(z5);
        Context context3 = context;
        y0Var = this;
        BooleanValue = ((Boolean) objU).booleanValue();
        context2 = context3;
        if (z3) {
            n0Var.L$0 = null;
            n0Var.L$1 = null;
            n0Var.I$0 = BooleanValue;
            n0Var.label = 2;
            y0Var.getClass();
            li.v0 v0Var3 = li.v0.f7498a;
            objU = li.l0.u(si.e.f10118a, new m0(context2, null), n0Var);
            if (objU == coroutine_suspended) {
                r10 = BooleanValue;
                return coroutine_suspended;
            }
            r10 = BooleanValue;
            zBooleanValue = ((Boolean) objU).booleanValue();
            r7 = r10;
        } else {
            zBooleanValue = true;
        }
        if (r7 != 0) {
            r7 = BooleanValue;
            z5 = false;
        } else {
            r7 = BooleanValue;
            z5 = false;
        }
        return Boxing.boxBoolean(z5);
    }
}
