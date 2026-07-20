package eb;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.bean.MultiConnectInfo;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcConnectSettingViewModel;
import com.transsion.pcconnect.invoke.bridge.Device;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f4754b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData f4756d;
    public static final MutableLiveData e;
    public static Device f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final qi.c f4757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static li.g2 f4758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static li.g2 f4759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f4760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static se.e f4761k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f4753a = new g0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MultiConnectInfo f4755c = new MultiConnectInfo("p2p0", "ble", 10);

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        f4756d = mutableLiveData;
        e = mutableLiveData;
        li.v0 v0Var = li.v0.f7498a;
        f4757g = li.h0.a(si.e.f10118a);
        f4760j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(int i8, boolean z2) {
        String strM = o.d.m("changeSubTitle subTitle: ", "MultiConnectManager", "tag", "log", i8);
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), strM);
        }
        ConnectedDevice connectedDevice = (ConnectedDevice) e.getValue();
        if (connectedDevice != null) {
            connectedDevice.changeSubTitle(i8, z2);
            f4756d.postValue(connectedDevice);
        }
    }

    public static String b() {
        Device device = f;
        String log = "getMultiConnectName:".concat(device != null ? device.f2948b : "");
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), log);
        }
        Device device2 = f;
        return device2 != null ? device2.f2948b : "";
    }

    public static String c() {
        Device device = f;
        String log = "getMultiConnectPid:".concat(device != null ? device.f2947a : "");
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), log);
        }
        Device device2 = f;
        return device2 != null ? device2.f2947a : "";
    }

    public static String d() {
        MultiConnectInfo multiConnectInfo = f4755c;
        String strN = o.d.n("getMultiConnectType:", multiConnectInfo.getConnectType(), "MultiConnectManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), strN);
        }
        return multiConnectInfo.getConnectType();
    }

    public static boolean e() {
        MultiConnectInfo multiConnectInfo = f4755c;
        String strM = o.d.m("isP2pConnect:", "MultiConnectManager", "tag", "log", multiConnectInfo.getNetWorkType());
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), strM);
        }
        return multiConnectInfo.getNetWorkType() != 14;
    }

    public static void f() {
        se.e eVar = f4761k;
        if (eVar != null) {
            Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
            Intrinsics.checkNotNullParameter("onDeviceNameChanged", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SettingViewModel"), "onDeviceNameChanged");
            }
            ((PcConnectSettingViewModel) eVar.f9720b).c();
        }
    }

    public static void g() {
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter("release", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), "release");
        }
        f = null;
        f4754b = false;
        f4756d.postValue(null);
        dc.i.f4413c = true;
        dc.i.f4412b.clear();
    }
}
