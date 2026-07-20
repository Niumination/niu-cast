package bb;

import android.content.SharedPreferences;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import k3.vb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f1241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f1243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f1244d;
    public final HashMap e;
    public final vi.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zb.b f1247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScannedDevice f1248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g2 f1249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o f1250l;

    public r(g0 mCoroutineScope) {
        Intrinsics.checkNotNullParameter(mCoroutineScope, "mCoroutineScope");
        this.f1241a = mCoroutineScope;
        this.f1243c = new HashMap();
        this.f1244d = new ConcurrentHashMap();
        this.e = new HashMap();
        this.f = vi.d.a();
        this.f1250l = new o(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ScannedDevice scannedDevice, ContinuationImpl continuationImpl) {
        n nVar;
        String deviceMac;
        if (continuationImpl instanceof n) {
            nVar = (n) continuationImpl;
            int i8 = nVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                nVar.label = i8 - Integer.MIN_VALUE;
            } else {
                nVar = new n(this, continuationImpl);
            }
        } else {
            nVar = new n(this, continuationImpl);
        }
        Object obj = nVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = nVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            deviceMac = scannedDevice.getDeviceMac();
            if (scannedDevice.getDeviceRssi() < -75) {
                return Unit.INSTANCE;
            }
            nVar.L$0 = this;
            nVar.L$1 = scannedDevice;
            nVar.L$2 = deviceMac;
            nVar.label = 1;
            if (this.f.d(null, nVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = (String) nVar.L$2;
            scannedDevice = (ScannedDevice) nVar.L$1;
            r rVar = (r) nVar.L$0;
            ResultKt.throwOnFailure(obj);
            deviceMac = str;
            this = rVar;
        }
        this.f1246h = false;
        HashMap map = this.f1243c;
        if (!map.containsKey(deviceMac)) {
            map.put(deviceMac, scannedDevice);
            String log = "found new device:" + scannedDevice;
            Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("BleScanDataFilterHelper"), log);
            }
            this.c(deviceMac, scannedDevice);
            this.b(false);
        } else if (scannedDevice.isLost()) {
            ScannedDevice scannedDevice2 = (ScannedDevice) map.get(deviceMac);
            if (scannedDevice2 != null) {
                if (map.values().contains(scannedDevice2)) {
                    l0.p(this.f1241a, null, null, new m(this, scannedDevice2.getDeviceMac(), null), 3);
                } else {
                    String log2 = "deleteDevice:" + scannedDevice2.getDeviceMac() + " not exist";
                    Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("BleScanDataFilterHelper"), log2);
                    }
                }
                String log3 = "delete device:" + scannedDevice;
                Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
                Intrinsics.checkNotNullParameter(log3, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("BleScanDataFilterHelper"), log3);
                }
            }
            Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
            Intrinsics.checkNotNullParameter("delete device end", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("BleScanDataFilterHelper"), "delete device end");
            }
        } else {
            String log4 = "update device:" + scannedDevice;
            Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
            Intrinsics.checkNotNullParameter(log4, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("BleScanDataFilterHelper"), log4);
            }
            this.f1246h = true;
            this.c(deviceMac, scannedDevice);
        }
        this.f.e(null);
        return Unit.INSTANCE;
    }

    public final void b(boolean z2) {
        g2 g2Var = this.f1249k;
        if (g2Var != null) {
            g2Var.h(null);
        }
        v0 v0Var = v0.f7498a;
        this.f1249k = l0.p(this.f1241a, si.e.f10118a, null, new p(z2, this, null), 2);
    }

    public final void c(String deviceMac, ScannedDevice scannedDevice) {
        ConcurrentHashMap concurrentHashMap = this.f1244d;
        if (concurrentHashMap.containsKey(deviceMac)) {
            Object obj = concurrentHashMap.get(deviceMac);
            Intrinsics.checkNotNull(obj);
            PcBleScanedDeviceBean pcBleScanedDeviceBean = (PcBleScanedDeviceBean) obj;
            pcBleScanedDeviceBean.setMRssi(scannedDevice.getDeviceRssi());
            concurrentHashMap.put(deviceMac, pcBleScanedDeviceBean);
            return;
        }
        String deviceMac2 = scannedDevice.getDeviceMac();
        String deviceName = scannedDevice.getDeviceName();
        StringBuilder sbP = h0.a.p("updateUiDeviceMap:localDeviceMac:", deviceMac, ",deviceMac:", deviceMac2, ",deviceName:");
        sbP.append(deviceName);
        gc.c("BleScanDataFilterHelper", sbP.toString());
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String upperCase = deviceMac.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Intrinsics.checkNotNullParameter("recent_connect_device", "key");
        Intrinsics.checkNotNullParameter("-1", "defaultVal");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("recent_connect_device", "");
        boolean zAreEqual = Intrinsics.areEqual(upperCase, string != null ? string : "");
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String upperCase2 = deviceMac.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        gc.c("BleScanDataFilterHelper", "updateUiDeviceMap:" + zAreEqual + "  deviceMac:" + upperCase2 + " ");
        String deviceName2 = scannedDevice.getDeviceName();
        if (deviceName2.length() > 15) {
            String strSubstring = deviceName2.substring(0, 11);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = deviceName2.substring(deviceName2.length() - 1, deviceName2.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            deviceName2 = o.d.l(strSubstring, "...", strSubstring2);
            gc.c("BleScanDataFilterHelper", "deviceName :" + deviceName2);
        }
        concurrentHashMap.put(deviceMac, new PcBleScanedDeviceBean(deviceName2, scannedDevice.getDeviceRssi(), scannedDevice.getDeviceMac(), zAreEqual, scannedDevice.getDeviceBrand(), 0, 32, null));
    }
}
