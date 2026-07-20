package cb;

import a0.e;
import a4.c;
import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.MultiConnectInfo;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailDialog;
import com.transsion.pcconnect.invoke.bridge.Device;
import dc.i;
import eb.b0;
import eb.d0;
import eb.e0;
import eb.g0;
import eb.l2;
import eb.y;
import eb.y1;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jb.h;
import k3.gc;
import k3.gd;
import k3.o1;
import k3.oc;
import k3.pb;
import k3.sb;
import k3.vb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import li.g2;
import li.l0;
import na.k;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(Device device, String action, boolean z2, String capabilityList) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(action, "action");
        gc.c("InvokeBridgeProvider", "device:" + device + ", onAction: " + action + ", enable: " + z2 + ", param: " + capabilityList);
        int i8 = 0;
        SharedPreferences sharedPreferences = null;
        switch (action.hashCode()) {
            case -1725840204:
                if (action.equals("EXCHANGE_CAPABILITY")) {
                    g0 g0Var = g0.f4753a;
                    Intrinsics.checkNotNullParameter(device, "device");
                    gc.c("MultiConnectManager", "exchangeCapability enable:" + z2 + " param:" + capabilityList);
                    Device device2 = g0.f;
                    if (device2 != null) {
                        if (Intrinsics.areEqual(device2.f2950d, device.f2950d)) {
                            if (capabilityList == null) {
                                gc.b("MultiConnectManager", "exchangeCapability param is null");
                                return;
                            }
                            ConcurrentHashMap concurrentHashMap = o7.a.f8410a;
                            Intrinsics.checkNotNullParameter(capabilityList, "capabilityList");
                            Set setKeySet = o7.a.f8410a.keySet();
                            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
                            String params = "";
                            for (Object obj : CollectionsKt.toList(setKeySet)) {
                                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                                String str = (String) obj;
                                if (StringsKt__StringsKt.contains$default(capabilityList, str, false, 2, (Object) null)) {
                                    params = d.l(params, str, ",");
                                }
                            }
                            Intrinsics.checkNotNullParameter(params, "params");
                            String log = "exchangeCapability params: " + params;
                            Intrinsics.checkNotNullParameter("InvokeBridgeProvider", "tag");
                            Intrinsics.checkNotNullParameter(log, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("InvokeBridgeProvider"), log);
                            }
                            Device device3 = g0.f;
                            if (device3 != null) {
                                b.c(device3, "EXCHANGE_CAPABILITY", true, params);
                                return;
                            }
                            return;
                        }
                    }
                    gc.b("MultiConnectManager", "exchangeCapability device not connect");
                    return;
                }
                return;
            case -1574274103:
                if (action.equals("SERIVCE_CAPABILITY_ALBUM_BACKUP")) {
                    g0 g0Var2 = g0.f4753a;
                    Intrinsics.checkNotNullParameter(device, "device");
                    String log2 = "changeAlbumBackupState enable:" + z2 + " param:" + capabilityList;
                    Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("MultiConnectManager"), log2);
                    }
                    i.f4411a.a(new b0(device, z2, i8));
                    return;
                }
                return;
            case -1487874936:
                if (!action.equals("SERVICE_SCREEN_CAST")) {
                    return;
                }
                break;
            case -515125346:
                if (!action.equals("SERVICE_AIR_CAST")) {
                    return;
                }
                break;
            case 92347297:
                if (action.equals("SERIVCE_CAPABILITY_EXTEND_SINK")) {
                    g0 g0Var3 = g0.f4753a;
                    Intrinsics.checkNotNullParameter(device, "device");
                    String log3 = "changePhoneExtendState enable:" + z2 + " param:" + capabilityList;
                    Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                    Intrinsics.checkNotNullParameter(log3, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("MultiConnectManager"), log3);
                    }
                    g2 g2Var = g0.f4758h;
                    if (g2Var != null) {
                        g2Var.h(null);
                    }
                    g0.f4758h = l0.p(g0.f4757g, null, null, new d0(device, z2, null), 3);
                    if (z2) {
                        b.a(false);
                        return;
                    }
                    return;
                }
                return;
            case 822417805:
                if (action.equals("USB_CONNECT_FAILED")) {
                    y yVar = y.f4799a;
                    int i9 = UsbConnectFailDialog.e;
                    gd.a(pb.a());
                    k kVar = k.f8141a;
                    Application applicationA = pb.a();
                    String string = pb.a().getString(R$string.toast_usb_connect_fail);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    kVar.b(applicationA, string);
                    return;
                }
                return;
            case 856446871:
                if (action.equals("WLAN_TYPE")) {
                    g0 g0Var4 = g0.f4753a;
                    String strO = d.o("setWlanState enable:", z2, "MultiConnectManager", "tag", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("MultiConnectManager"), strO);
                    }
                    g0.f4760j = z2;
                    return;
                }
                return;
            case 1669334218:
                if (action.equals("CONNECT")) {
                    if (!z2) {
                        g0 g0Var5 = g0.f4753a;
                        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                        Intrinsics.checkNotNullParameter("disConnectMainSocket", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("MultiConnectManager"), "disConnectMainSocket");
                        }
                        y yVar2 = y.f4799a;
                        if (sb.b()) {
                            l2.j();
                        } else {
                            y1.e();
                        }
                        g0.g();
                        return;
                    }
                    g0 g0Var6 = g0.f4753a;
                    Intrinsics.checkNotNullParameter(device, "device");
                    gc.c("MultiConnectManager", "connectMainSocket");
                    MultiConnectInfo multiConnectInfo = (MultiConnectInfo) na.b.a(capabilityList, MultiConnectInfo.class);
                    if (TextUtils.isEmpty(device.f2949c) || TextUtils.isEmpty(device.f2950d)) {
                        if (!Intrinsics.areEqual(multiConnectInfo != null ? multiConnectInfo.getConnectType() : null, "cable")) {
                            gc.b("MultiConnectManager", "connectMainSocket device type or ip is empty");
                            return;
                        }
                    }
                    ArrayList arrayListA = o1.a(pb.a(), CollectionsKt.listOf((Object[]) new Permission[]{h.f6141d, h.f6138a, h.f6139b}));
                    int i10 = !Intrinsics.areEqual(device.f2949c, ExifInterface.GPS_MEASUREMENT_3D) ? 1 : 0;
                    gc.c("MultiConnectManager", "notGrantedPermission:" + arrayListA);
                    e eVar = new e(8, multiConnectInfo, device);
                    if (arrayListA.isEmpty()) {
                        Intrinsics.checkNotNullParameter("UserPermissionNotifyIsShow", "key");
                        SharedPreferences sharedPreferences2 = vb.f6684a;
                        if (sharedPreferences2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        } else {
                            sharedPreferences = sharedPreferences2;
                        }
                        if (!sharedPreferences.getBoolean("UserPermissionNotifyIsShow", true)) {
                            eVar.run();
                            return;
                        }
                    }
                    Runnable runnable = BlankActivity.f2696b;
                    oc.a(pb.a(), arrayListA, i10, new c(eVar, 16));
                    return;
                }
                return;
            default:
                return;
        }
        g0 g0Var7 = g0.f4753a;
        Intrinsics.checkNotNullParameter(device, "device");
        String log4 = "add changePhoneMirrorState enable:" + z2 + " param:" + capabilityList;
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log4, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), log4);
        }
        g2 g2Var2 = g0.f4758h;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
        g0.f4758h = l0.p(g0.f4757g, null, null, new e0(device, z2, null), 3);
        if (z2) {
            b.b(false);
        }
    }
}
