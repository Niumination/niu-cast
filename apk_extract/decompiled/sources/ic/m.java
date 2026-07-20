package ic;

import android.util.Log;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.nfbd.c0;
import com.welink.protocol.nfbd.y;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import k3.gc;
import k3.lb;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import li.g2;
import li.l0;
import se.b1;
import se.j1;
import se.t4;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer[] f5740b = {36, 40, 44, 48, 52, 56, 60, 64, 100, 104, 108, Integer.valueOf(DeviceType.INFRARED_HEATER), 116, 120, Integer.valueOf(OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION), 128, 132, 136, 140, 149, 153, 157, 161, 165};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f5741c = new IntRange(1, 14);

    @Override // ic.h
    public final boolean a(hc.c device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return device instanceof hc.d;
    }

    @Override // ic.h
    public final Object b(hc.c cVar, Continuation continuation) {
        int iC;
        String str;
        li.l lVar;
        boolean z2;
        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.transsion.iotservice.physicalconnect.bean.P2PConnectDevice");
        hc.d dVar = (hc.d) cVar;
        gc.c("P2PConnectHelper", "connect p2p device: " + dVar);
        int i8 = dVar.f5292i;
        IntRange intRange = this.f5741c;
        int first = intRange.getFirst();
        if ((i8 > intRange.getLast() || first > i8) && !ArraysKt.contains(this.f5740b, Boxing.boxInt(i8))) {
            gc.c("P2PConnectHelper", "channel is not in range: " + dVar.f5292i);
            iC = 0;
        } else {
            gc.c("P2PConnectHelper", "channel is in range: " + dVar.f5292i);
            iC = dVar.f5292i;
        }
        String ssid = dVar.f5290g;
        String pwd = dVar.f5291h;
        String mac = dVar.f5288c;
        int i9 = dVar.f5289d;
        if (i9 == Integer.parseInt("03")) {
            str = "Tecno";
        } else if (i9 == Integer.parseInt("04")) {
            str = "Infinix";
        } else {
            str = i9 == Integer.parseInt("02") ? "Itel" : "UNKONW";
        }
        String brand = str;
        int i10 = dVar.e;
        String name = dVar.f5287b;
        int i11 = dVar.f;
        li.l lVar2 = new li.l(1, IntrinsicsKt.intercepted(continuation));
        lVar2.s();
        Intrinsics.checkNotNullParameter("P2PConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("connectP2PExt", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PConnectHelper"), "connectP2PExt");
        }
        g2 g2VarP = l0.p(this.f5733a, null, null, new l(lVar2, null), 3);
        i iVar = new i(g2VarP, lVar2, mac);
        j jVar = new j(lVar2, g2VarP);
        k kVar = k.f5739a;
        lVar2.v(kVar);
        na.a.a(lVar2, kVar);
        Lazy lazy = mc.b.f7958a;
        mc.b.h(iVar, jVar, null);
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(name, "name");
        c0 c0Var = mc.b.e().f9655c.f4191c;
        boolean z3 = (c0Var != null ? c0Var.d() : 0) == 1;
        StringBuilder sbP = h0.a.p("ssid:", ssid, ", pwd:", pwd, ", mac:");
        sbP.append(mac);
        sbP.append(", channel:");
        sbP.append(iC);
        sbP.append(", brand:");
        sbP.append(brand);
        sbP.append(",  service:");
        sbP.append(i10);
        sbP.append(", name:");
        sbP.append(name);
        sbP.append(", deviceType:");
        sbP.append(i11);
        sbP.append(", sdk connect enable:");
        sbP.append(z3);
        String log = sbP.toString();
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), log);
        }
        mc.b.f7969n = true;
        mc.b.g();
        b1 b1VarE = mc.b.e();
        b1VarE.getClass();
        if (ssid == null || ssid.length() == 0 || pwd == null || pwd.length() == 0) {
            lVar = lVar2;
            Intrinsics.checkNotNullParameter("NearConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("p2pConnect: ssid or password is null or empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionManager", "TransConnect:p2pConnect: ssid or password is null or empty", null);
            }
        } else if (ssid.length() > 32 || pwd.length() < 8) {
            lVar = lVar2;
            Intrinsics.checkNotNullParameter("NearConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("p2pConnect: ssid or password length is invalid, ssid length should be less than or equal to 32, password length should be greater than or equal to 8", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionManager", "TransConnect:p2pConnect: ssid or password length is invalid, ssid length should be less than or equal to 32, password length should be greater than or equal to 8", null);
            }
        } else if (new Regex("^DIRECT-[a-zA-Z0-9]{2}.*").matches(ssid)) {
            if (!ye.h.f(iC) && (iC == 0 || !ye.h.f(iC))) {
                iC = ye.h.c(iC);
            }
            Map map = com.welink.protocol.nfbd.h.f4132a;
            int i12 = iC;
            lVar = lVar2;
            WirelessDevice.P2p p2p = new WirelessDevice.P2p(ssid, "02:00:00:00:00:00", pwd, i12, null, WorkRequest.MIN_BACKOFF_MILLIS);
            ArrayList arrayListE = ye.h.e();
            List capability = CollectionsKt.listOf(Integer.valueOf(i10));
            Intrinsics.checkNotNullParameter(capability, "capability");
            NearDeviceExtension nearDeviceExtension = new NearDeviceExtension(capability, null, null, 0, false, null, null, null);
            j1 j1Var = new j1();
            j1Var.f9816i = 10;
            j1Var.f9812c = i11;
            j1Var.f9813d = i10;
            j1Var.f9820m = Integer.valueOf(PointerIconCompat.TYPE_CELL);
            j1Var.f9821n = PointerIconCompat.TYPE_COPY;
            j1Var.c(1000);
            j1Var.f9817j = brand;
            j1Var.f9810a = "02:00:00:00:00:00";
            j1Var.f9811b = "02:00:00:00:00:00";
            if (name != null) {
                ssid = name;
            }
            j1Var.f9818k = ssid;
            j1Var.f9825t = p2p;
            j1Var.q = 1;
            j1Var.p = null;
            j1Var.u = arrayListE;
            j1Var.f9826v = nearDeviceExtension;
            NearDevice device = j1Var.a();
            WirelessDevice wirelessDevice = device.f3896s;
            if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.P2p)) {
                we.h.b("NearConnectionManager", "P2P Device info is invalid, ignore");
            } else {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                if (((WirelessDevice.P2p) wirelessDevice).f4013a != null) {
                    WirelessDevice wirelessDevice2 = device.f3896s;
                    Intrinsics.checkNotNull(wirelessDevice2, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                    if (((WirelessDevice.P2p) wirelessDevice2).f4015c != null) {
                        WirelessDevice wirelessDevice3 = device.f3896s;
                        Intrinsics.checkNotNull(wirelessDevice3, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                        String str2 = ((WirelessDevice.P2p) wirelessDevice3).f4015c;
                        Intrinsics.checkNotNull(str2);
                        int length = str2.length();
                        if (1 > length || length >= 8) {
                            WirelessDevice wirelessDevice4 = device.f3896s;
                            Intrinsics.checkNotNull(wirelessDevice4, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                            if (((WirelessDevice.P2p) wirelessDevice4).f4014b != null) {
                                WirelessDevice wirelessDevice5 = device.f3896s;
                                Intrinsics.checkNotNull(wirelessDevice5, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                                String str3 = ((WirelessDevice.P2p) wirelessDevice5).f4014b;
                                if (str3 == null || xe.a.f10918a.matches(str3)) {
                                }
                            }
                            LinkedHashSet linkedHashSet = b1VarE.f9654b;
                            if (!linkedHashSet.contains(device)) {
                                linkedHashSet.add(device);
                            }
                            if (device.f3883a != null || device.f3885c != null) {
                                y yVar = b1VarE.f9655c;
                                yVar.getClass();
                                Intrinsics.checkNotNullParameter(device, "device");
                                WirelessDevice wirelessDevice6 = device.f3896s;
                                Intrinsics.checkNotNull(wirelessDevice6, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                                WirelessDevice.P2p p2p2 = (WirelessDevice.P2p) wirelessDevice6;
                                if (p2p2.f4016d < 0) {
                                    we.h.b("SmartConnectWrapper", "P2P Device Info is not complete, force set to 0");
                                    z2 = false;
                                    p2p2.f4016d = 0;
                                } else {
                                    z2 = false;
                                }
                                if (!yVar.f4196j.contains(device)) {
                                    yVar.f4195i.k(device, t4.P2P_DEVICE, z2, z2);
                                }
                                c0 c0Var2 = yVar.f4191c;
                                if (c0Var2 != null) {
                                    c0Var2.i(device, yVar.p);
                                }
                            }
                        }
                    }
                }
                we.h.a("P2P Device Info is not complete, ignore");
                we.h.b("NearConnectionManager", "P2P Device info is invalid, ignore");
            }
        } else {
            Intrinsics.checkNotNullParameter("NearConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("p2pConnect: ssid is not valid, it should start with DIRECT-XX", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionManager", "TransConnect:p2pConnect: ssid is not valid, it should start with DIRECT-XX", null);
            }
            lVar = lVar2;
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objR;
    }
}
