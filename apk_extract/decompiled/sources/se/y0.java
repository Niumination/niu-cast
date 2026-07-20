package se;

import android.util.Log;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.nfbd.NearDevice;
import k3.gc;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f10065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NearDevice f10066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10067d;

    public /* synthetic */ y0(z0 z0Var, NearDevice nearDevice, int i8, int i9) {
        this.f10064a = i9;
        this.f10065b = z0Var;
        this.f10066c = nearDevice;
        this.f10067d = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String error;
        NearDevice device = this.f10066c;
        int i8 = this.f10067d;
        z0 z0Var = this.f10065b;
        switch (this.f10064a) {
            case 0:
                q5.a aVar = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter("1", "error");
                StringBuilder sbY = a1.a.y("onNearDisconnectResult: ", device.f3884b, ", ");
                sbY.append(i8);
                sbY.append(", 1");
                String log = sbY.toString();
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), log);
                }
                Function2 function2 = mc.b.e;
                if (function2 != null) {
                    function2.invoke(device, Integer.valueOf(i8));
                }
                break;
            default:
                q5.a aVar2 = z0Var.f10076b;
                if (i8 == 12) {
                    error = "WIFI_P2P_CONNECT_FAILED";
                } else if (i8 == 13) {
                    error = "LAN_INVALID_IP";
                } else if (i8 == 25) {
                    error = "WIFI_P2P_OCCUPY_BY_OTHER";
                } else if (i8 != 65280) {
                    switch (i8) {
                        case -1:
                            error = "INVALID";
                            break;
                        case 0:
                            error = "NONE";
                            break;
                        case 1:
                            error = "BLUETOOTH_DISCONNECTED";
                            break;
                        case 2:
                            error = "WIFI_P2P_DISCONNECTED";
                            break;
                        case 3:
                            error = "BLUETOOTH_OFF";
                            break;
                        case 4:
                            error = "WIFI_OFF";
                            break;
                        case 5:
                            error = "WIFI_P2P_OFF";
                            break;
                        case 6:
                            error = "WIFI_P2P_ERROR";
                            break;
                        case 7:
                            error = "WIFI_P2P_UNSUPPORTED";
                            break;
                        case 8:
                            error = "WIFI_P2P_BUSY";
                            break;
                        case 9:
                            error = "WIFI_P2P_NO_SERVICE";
                            break;
                        case 10:
                            error = "WIFI_P2P_TIMEOUT";
                            break;
                        default:
                            switch (i8) {
                                case 100:
                                    error = "CONNECT_RES_FAILED";
                                    break;
                                case 101:
                                    error = "CONNECT_RES_TIMEOUT";
                                    break;
                                case 102:
                                    error = "LOCAL_OPT_REJECT";
                                    break;
                                case DeviceType.INFRARED_TV_BOX /* 103 */:
                                    error = "REMOTE_OPT_CANCEL";
                                    break;
                                case 104:
                                    error = "REMOTE_OPT_REJECT";
                                    break;
                                case DeviceType.INFRARED_AIR_CONDITION /* 105 */:
                                    error = "CONNECT_LE_CONFLICT";
                                    break;
                                case DeviceType.INFRARED_PROJECTOR /* 106 */:
                                    error = "CONNECT_LE_RES_TIMEOUT";
                                    break;
                                case DeviceType.INFRARED_AMPLIFIER /* 107 */:
                                    error = "DISCONNECT_LE_RES_TIMEOUT";
                                    break;
                                case 108:
                                    error = "FOUND_EMPTY_DEVICE";
                                    break;
                                case 109:
                                    error = "FOUND_DIFFERENT_DEVICE";
                                    break;
                                case DeviceType.INFRARED_LIGHT /* 110 */:
                                    error = "DISCONNECT_RES_TIMEOUT";
                                    break;
                                case DeviceType.INFRARED_AIR_PURIFIER /* 111 */:
                                    error = "USER_OPT_DISCONNECT";
                                    break;
                                default:
                                    error = "Unknown reason";
                                    break;
                            }
                            break;
                    }
                } else {
                    error = "PC_CONNECTION_UNKNOWN";
                }
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(error, "error");
                gc.c("TranConnectManager", "onNearConnectResult: " + device.f3884b + ", " + i8 + ", " + error + ", rejectCallback:" + mc.b.f + ", disconnectCallback:" + mc.b.e + ", pcDisconnectCallback:" + mc.b.f7963h);
                mc.b.f7966k = null;
                mc.b.f7959b = null;
                if (mc.b.f7967l.get()) {
                    gc.c("TranConnectManager", "isPcRequestConn:true");
                    ag.q qVar = mc.b.f7963h;
                    if (qVar != null) {
                        qVar.invoke(device, Integer.valueOf(i8));
                    }
                    Lazy lazy = mc.b.f7958a;
                    mc.b.f();
                } else if (i8 != 104) {
                    Function2 function3 = mc.b.e;
                    if (function3 != null) {
                        function3.invoke(device, Integer.valueOf(i8));
                    }
                    if (mc.b.e == null) {
                        gc.c("TranConnectManager", "isPcRequestConn2222:true");
                        ag.q qVar2 = mc.b.f7963h;
                        if (qVar2 != null) {
                            qVar2.invoke(device, Integer.valueOf(i8));
                        }
                    }
                    Lazy lazy2 = mc.b.f7958a;
                    mc.b.f();
                } else {
                    Function2 function4 = mc.b.f;
                    if (function4 != null) {
                        function4.invoke(device, Integer.valueOf(i8));
                    }
                    Lazy lazy3 = mc.b.f7958a;
                    mc.b.f();
                }
                break;
        }
    }
}
