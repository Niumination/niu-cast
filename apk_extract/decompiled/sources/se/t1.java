package se;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends we.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9990d;
    public final ConcurrentHashMap.KeySetView e;
    public final ConcurrentHashMap.KeySetView f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f9997m;

    public t1() {
        super(false, "DeviceTableFusion");
        this.f9989c = ConcurrentHashMap.newKeySet();
        this.f9990d = new Object();
        this.e = ConcurrentHashMap.newKeySet();
        this.f = ConcurrentHashMap.newKeySet();
        this.f9991g = ConcurrentHashMap.newKeySet();
        this.f9992h = ConcurrentHashMap.newKeySet();
        this.f9993i = ConcurrentHashMap.newKeySet();
        this.f9994j = ConcurrentHashMap.newKeySet();
        this.f9995k = ConcurrentHashMap.newKeySet();
        this.f9996l = ConcurrentHashMap.newKeySet();
        this.f9997m = new ConcurrentHashMap();
        vi.d.a();
    }

    public static boolean q(NearDevice nearDevice, NearDevice nearDevice2) {
        List listJ;
        return (nearDevice.j() == null || (listJ = nearDevice.j()) == null || !listJ.contains(nearDevice2)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    public static boolean r(NearDevice nearDevice, NearDevice nearDevice2) {
        Integer num;
        NearDeviceExtension nearDeviceExtension;
        if (!Intrinsics.areEqual(nearDevice.f3883a, nearDevice2.f3883a)) {
            String str = nearDevice2.f3885c;
            String str2 = nearDevice.f3885c;
            if (Intrinsics.areEqual(str2, str)) {
                num = nearDevice.f3898v;
                if (num != null && num.intValue() == 1006 && nearDevice.e != nearDevice2.e && (nearDeviceExtension = nearDevice.u) != null && nearDeviceExtension.e) {
                    return true;
                }
            } else {
                NearDeviceExtension nearDeviceExtension2 = nearDevice2.u;
                if (Intrinsics.areEqual(str2, nearDeviceExtension2 != null ? nearDeviceExtension2.f3906b : null)) {
                    num = nearDevice.f3898v;
                    if (num != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean t(NearDevice nearDevice, NearDevice nearDevice2) {
        Integer num;
        Integer num2;
        int i8 = nearDevice2.f3889j;
        String str = nearDevice2.f3883a;
        int i9 = nearDevice2.f3890k;
        String str2 = nearDevice2.f3885c;
        if (i8 == 15 || i8 == 16 || i8 == 17) {
            return !(Intrinsics.areEqual(nearDevice.f3883a, str) && nearDevice.C == nearDevice2.C && nearDevice.D == nearDevice2.D) && Intrinsics.areEqual(nearDevice.f3885c, str2) && (num = nearDevice.f3898v) != null && num.intValue() == 1006 && nearDevice.f3890k == i9;
        }
        return !Intrinsics.areEqual(nearDevice.f3883a, str) && Intrinsics.areEqual(nearDevice.f3885c, str2) && (num2 = nearDevice.f3898v) != null && num2.intValue() == 1006 && nearDevice.f3890k == i9;
    }

    public static boolean u(NearDevice nearDevice, NearDevice nearDevice2) {
        String str;
        Integer num;
        NearDeviceExtension nearDeviceExtension = nearDevice.u;
        LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
        NearDeviceExtension nearDeviceExtension2 = nearDevice2.u;
        LanNetworkInfo lanNetworkInfo2 = nearDeviceExtension2 != null ? nearDeviceExtension2.f3909h : null;
        String str2 = nearDevice.f3883a;
        return (str2 == null || (str = nearDevice2.f3883a) == null || !Intrinsics.areEqual(str2, str) || !Intrinsics.areEqual(nearDevice.f3885c, nearDevice2.f3885c) || (num = nearDevice.f3898v) == null || num.intValue() != 1006 || nearDevice.e != nearDevice2.e || lanNetworkInfo == null || lanNetworkInfo2 == null || Intrinsics.areEqual(lanNetworkInfo, lanNetworkInfo2)) ? false : true;
    }

    public static t4 w(NearDevice nearDevice) {
        switch (nearDevice.f3890k) {
            case 0:
                return t4.LE_DEVICE;
            case 1:
                return t4.BT_DEVICE;
            case 2:
                return t4.WIFI_DEVICE;
            case 3:
                return t4.P2P_DEVICE;
            case 4:
                return t4.NAN_DEVICE;
            case 5:
            case 9:
            case 12:
            case 13:
            default:
                return t4.UNKNOWN_DEVICE;
            case 6:
                return t4.UWB_DEVICE;
            case 7:
                return t4.NFC_DEVICE;
            case 8:
                return t4.THREAD_DEVICE;
            case 10:
                return t4.P2P_DEVICE;
            case 11:
                return t4.P2P_DEVICE;
            case 14:
                return t4.MDNS_DEVICE;
            case 15:
                return t4.MQTT_DEVICE;
            case 16:
                return t4.COAP_DEVICE;
        }
    }

    public final void A(NearDevice nearDevice) {
        ConcurrentHashMap.KeySetView<Pair> observers = this.f9989c;
        Intrinsics.checkNotNullExpressionValue(observers, "observers");
        for (Pair pair : observers) {
            ((Executor) pair.getFirst()).execute(new o(pair, nearDevice, 3));
        }
    }

    public final void B(NearDevice nearDevice, boolean z2) {
        ConcurrentHashMap.KeySetView<Pair> observers = this.f9989c;
        Intrinsics.checkNotNullExpressionValue(observers, "observers");
        for (Pair pair : observers) {
            ((Executor) pair.getFirst()).execute(new p(pair, nearDevice, z2, 2));
        }
    }

    public final void C(NearDevice nearDevice) {
        ConcurrentHashMap.KeySetView<Pair> observers = this.f9989c;
        Intrinsics.checkNotNullExpressionValue(observers, "observers");
        for (Pair pair : observers) {
            ((Executor) pair.getFirst()).execute(new o(pair, nearDevice, 4));
        }
    }

    public final void D(NearDevice nearDevice, boolean z2) {
        k1 k1VarQ = nearDevice.q();
        int iO = nearDevice.o();
        ConcurrentHashMap concurrentHashMap = this.f9997m;
        NearDevice nearDevice2 = (NearDevice) concurrentHashMap.get(Integer.valueOf(iO));
        ConcurrentHashMap.KeySetView keySetView = this.f9991g;
        if (nearDevice2 == null) {
            we.h.b("NearDeviceTableFusion", "New device found, add it to list");
            concurrentHashMap.put(Integer.valueOf(iO), nearDevice);
            p();
            keySetView.add(nearDevice);
            B(nearDevice, z2);
            return;
        }
        k1 k1VarQ2 = nearDevice2.q();
        if (k1VarQ2.compareTo(k1VarQ) < 0 || z2) {
            we.h.h("NearDeviceTableFusion", "Higher priority device or invited device found, replace it");
            concurrentHashMap.put(Integer.valueOf(iO), nearDevice);
            keySetView.remove(nearDevice2);
            C(nearDevice2);
            keySetView.add(nearDevice);
            B(nearDevice, z2);
            p();
            return;
        }
        if (k1VarQ2 == k1VarQ && Intrinsics.areEqual(nearDevice2, nearDevice)) {
            nearDevice2.E(nearDevice);
            ConcurrentHashMap.KeySetView<Pair> observers = this.f9989c;
            Intrinsics.checkNotNullExpressionValue(observers, "observers");
            for (Pair pair : observers) {
                ((Executor) pair.getFirst()).execute(new o(pair, nearDevice2, 2));
            }
            return;
        }
        if (k1VarQ2 != k1VarQ || Intrinsics.areEqual(nearDevice2, nearDevice)) {
            we.h.j("NearDeviceTableFusion", "Lower priority device found, ignore");
            return;
        }
        we.h.b("NearDeviceTableFusion", "Same priority device found");
        int i8 = nearDevice.f3890k;
        if (i8 == 10 || i8 == 11) {
            we.h.h("NearDeviceTableFusion", "Same priority new device found, report it");
            concurrentHashMap.put(Integer.valueOf(iO), nearDevice);
            keySetView.add(nearDevice);
            B(nearDevice, z2);
        }
    }

    public final void E(we.i executor, u4 observer) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNull(executor, "null cannot be cast to non-null type com.welink.protocol.utils.NearHandlerExecutor");
        ConcurrentHashMap.KeySetView<Pair> observers = this.f9989c;
        Intrinsics.checkNotNullExpressionValue(observers, "observers");
        if (observers == null || !observers.isEmpty()) {
            for (Pair pair : observers) {
                if (pair.getFirst() instanceof we.i) {
                    Object first = pair.getFirst();
                    Intrinsics.checkNotNull(first, "null cannot be cast to non-null type com.welink.protocol.utils.NearHandlerExecutor");
                    if (((we.i) first).f10727a == executor.f10727a && pair.getSecond() == observer) {
                        we.h.b("NearDeviceTableFusion", "registerListener: pair already exists in executorListenerPairs");
                        return;
                    }
                }
            }
        }
        we.h.b("NearDeviceTableFusion", "registerListener: executorListenerPairs add new pair");
        observers.add(TuplesKt.to(executor, observer));
    }

    public final void F() {
        ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
        synchronized (mBleCachedDevices) {
            try {
                Iterator it = this.f9992h.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    NearDevice nearDevice = (NearDevice) it.next();
                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    Intrinsics.checkNotNull(nearDevice);
                    o(nearDevice);
                }
                this.f9992h.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        ConcurrentHashMap.KeySetView mNsdCachedDevices = this.f9994j;
        Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
        synchronized (mNsdCachedDevices) {
            try {
                Iterator it2 = this.f9994j.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    NearDevice nearDevice2 = (NearDevice) it2.next();
                    ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice2.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice2.hashCode()));
                    }
                    Intrinsics.checkNotNull(nearDevice2);
                    o(nearDevice2);
                }
                this.f9994j.clear();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        ConcurrentHashMap.KeySetView mBtCachedDevices = this.f9993i;
        Intrinsics.checkNotNullExpressionValue(mBtCachedDevices, "mBtCachedDevices");
        synchronized (mBtCachedDevices) {
            try {
                Iterator it3 = this.f9993i.iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                while (it3.hasNext()) {
                    NearDevice nearDevice3 = (NearDevice) it3.next();
                    ConcurrentHashMap concurrentHashMap3 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice3.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice3.hashCode()));
                    }
                    Intrinsics.checkNotNull(nearDevice3);
                    o(nearDevice3);
                }
                this.f9993i.clear();
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th4) {
                throw th4;
            }
        }
        ConcurrentHashMap.KeySetView mNfcCachedDevices = this.f9995k;
        Intrinsics.checkNotNullExpressionValue(mNfcCachedDevices, "mNfcCachedDevices");
        synchronized (mNfcCachedDevices) {
            try {
                Iterator it4 = this.f9995k.iterator();
                Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
                while (it4.hasNext()) {
                    NearDevice nearDevice4 = (NearDevice) it4.next();
                    ConcurrentHashMap concurrentHashMap4 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice4.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice4.hashCode()));
                    }
                    Intrinsics.checkNotNull(nearDevice4);
                    o(nearDevice4);
                }
                this.f9995k.clear();
                Unit unit4 = Unit.INSTANCE;
            } catch (Throwable th5) {
                throw th5;
            }
        }
        ConcurrentHashMap.KeySetView mP2pCachedDevices = this.f9996l;
        Intrinsics.checkNotNullExpressionValue(mP2pCachedDevices, "mP2pCachedDevices");
        synchronized (mP2pCachedDevices) {
            try {
                Iterator it5 = this.f9996l.iterator();
                Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
                while (it5.hasNext()) {
                    NearDevice nearDevice5 = (NearDevice) it5.next();
                    ConcurrentHashMap concurrentHashMap5 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice5.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice5.hashCode()));
                    }
                    Intrinsics.checkNotNull(nearDevice5);
                    o(nearDevice5);
                }
                this.f9996l.clear();
                Unit unit5 = Unit.INSTANCE;
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    public final void G(NearDevice device, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        f(new r1(this, device, z2, 0));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x027e A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0296 A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02ad A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0309 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:134:0x031e A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0329 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x032a A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0348 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:146:0x034d A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0362 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0372 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:152:0x0376 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0380 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0397 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:158:0x03a6 A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:160:0x03bd A[Catch: all -> 0x02f2, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:163:0x03ce A[Catch: all -> 0x02f2, TRY_LEAVE, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:166:0x03d7 A[Catch: all -> 0x02f2, TRY_ENTER, TryCatch #0 {all -> 0x02f2, blocks: (B:115:0x02ca, B:116:0x02d5, B:118:0x02db, B:120:0x02eb, B:126:0x02f6, B:127:0x0303, B:129:0x0309, B:132:0x031a, B:134:0x031e, B:154:0x0380, B:156:0x0397, B:157:0x03a2, B:167:0x03da, B:137:0x032a, B:139:0x0330, B:142:0x0338, B:144:0x0348, B:146:0x034d, B:148:0x0362, B:149:0x036d, B:151:0x0372, B:152:0x0376, B:158:0x03a6, B:160:0x03bd, B:161:0x03c8, B:163:0x03ce, B:166:0x03d7), top: B:172:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    /* JADX WARN: Code duplicated, block: B:192:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:? A[LOOP:5: B:127:0x0303->B:193:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0084  */
    /* JADX WARN: Code duplicated, block: B:26:0x0099  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:42:0x0101  */
    /* JADX WARN: Code duplicated, block: B:44:0x0116  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0142  */
    /* JADX WARN: Code duplicated, block: B:59:0x0175  */
    /* JADX WARN: Code duplicated, block: B:61:0x018c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0193  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:84:0x0213 A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0235 A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:93:0x023c A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0251 A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0267 A[Catch: all -> 0x020c, TryCatch #1 {all -> 0x020c, blocks: (B:74:0x01ec, B:75:0x01f7, B:77:0x01fd, B:82:0x020f, B:84:0x0213, B:99:0x0267, B:101:0x027e, B:102:0x0289, B:103:0x028e, B:108:0x02bb, B:87:0x021f, B:89:0x0225, B:91:0x0235, B:93:0x023c, B:95:0x0251, B:96:0x025c, B:97:0x0261, B:104:0x0296, B:106:0x02ad, B:107:0x02b8), top: B:173:0x01ec }] */
    public final void H(NearDevice nearDevice, t4 t4Var, boolean z2, boolean z3) {
        Object next;
        NearDevice nearDevice2;
        NearDevice nearDevice3;
        Integer num;
        NearDevice nearDevice4;
        NearDevice nearDevice5;
        NearDevice nearDevice6;
        Integer num2;
        NearDevice nearDevice7;
        NearDevice nearDevice8;
        NearDevice nearDevice9;
        Object obj = null;
        switch (s1.$EnumSwitchMapping$0[t4Var.ordinal()]) {
            case 1:
                ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
                Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                synchronized (mBleCachedDevices) {
                    try {
                        ConcurrentHashMap.KeySetView mBleCachedDevices2 = this.f9992h;
                        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices2, "mBleCachedDevices");
                        Iterator it = mBleCachedDevices2.iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                                nearDevice5 = (NearDevice) next;
                                Intrinsics.checkNotNull(nearDevice5);
                                if (!Intrinsics.areEqual(nearDevice5, nearDevice)) {
                                }
                            } else {
                                next = null;
                            }
                            nearDevice2 = (NearDevice) next;
                            ConcurrentHashMap.KeySetView mBleCachedDevices3 = this.f9992h;
                            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices3, "mBleCachedDevices");
                            for (Object obj2 : mBleCachedDevices3) {
                                nearDevice4 = (NearDevice) obj2;
                                Intrinsics.checkNotNull(nearDevice4);
                                if (q(nearDevice4, nearDevice)) {
                                    obj = obj2;
                                    nearDevice3 = (NearDevice) obj;
                                    if (nearDevice2 != null) {
                                        we.h.b("NearDeviceTableFusion", "LE Device in cache list, remove it");
                                        num = nearDevice2.f3898v;
                                        if (num != null && num.intValue() == 1006 && (!s(nearDevice) || z2)) {
                                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                                            if (!we.m.d(Integer.valueOf(nearDevice2.hashCode()))) {
                                                I(nearDevice2, t4Var);
                                            }
                                            if (z3) {
                                                we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list");
                                                if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                                }
                                                I(nearDevice2, t4Var);
                                            }
                                            if (nearDevice3 == null) {
                                                J(nearDevice2, t4Var, z2);
                                            } else {
                                                we.h.h("NearDeviceTableFusion", "Cascade device lost, remove it from cascaded list");
                                            }
                                        } else if (z3) {
                                            we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list for Connected State");
                                            ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                            }
                                            I(nearDevice2, t4Var);
                                        }
                                    } else {
                                        we.h.b("NearDeviceTableFusion", "LE Device not in cache list, remove it directly");
                                        ConcurrentHashMap concurrentHashMap3 = we.m.f10734a;
                                        if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                            we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                        }
                                        if (s(nearDevice)) {
                                            we.h.h("NearDeviceTableFusion", "NearDevice is in connected state, ignore");
                                            return;
                                        }
                                        J(nearDevice, t4Var, z2);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    return;
                                }
                            }
                            nearDevice3 = (NearDevice) obj;
                            if (nearDevice2 != null) {
                                we.h.b("NearDeviceTableFusion", "LE Device in cache list, remove it");
                                num = nearDevice2.f3898v;
                                if (num != null) {
                                    ConcurrentHashMap concurrentHashMap4 = we.m.f10734a;
                                    if (!we.m.d(Integer.valueOf(nearDevice2.hashCode()))) {
                                        I(nearDevice2, t4Var);
                                    }
                                    if (z3) {
                                        we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list");
                                        if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                            we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                        }
                                        I(nearDevice2, t4Var);
                                    }
                                    if (nearDevice3 == null) {
                                        J(nearDevice2, t4Var, z2);
                                    } else {
                                        we.h.h("NearDeviceTableFusion", "Cascade device lost, remove it from cascaded list");
                                    }
                                }
                                if (z3) {
                                    we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list for Connected State");
                                    ConcurrentHashMap concurrentHashMap5 = we.m.f10734a;
                                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    }
                                    I(nearDevice2, t4Var);
                                }
                            } else {
                                we.h.b("NearDeviceTableFusion", "LE Device not in cache list, remove it directly");
                                ConcurrentHashMap concurrentHashMap6 = we.m.f10734a;
                                if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                }
                                if (s(nearDevice)) {
                                    we.h.h("NearDeviceTableFusion", "NearDevice is in connected state, ignore");
                                    return;
                                }
                                J(nearDevice, t4Var, z2);
                            }
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        } while (!q(nearDevice5, nearDevice));
                        nearDevice2 = (NearDevice) next;
                        ConcurrentHashMap.KeySetView mBleCachedDevices4 = this.f9992h;
                        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices4, "mBleCachedDevices");
                        while (r3.hasNext()) {
                            nearDevice4 = (NearDevice) obj2;
                            Intrinsics.checkNotNull(nearDevice4);
                            if (q(nearDevice4, nearDevice)) {
                                obj = obj2;
                                nearDevice3 = (NearDevice) obj;
                                if (nearDevice2 != null) {
                                    we.h.b("NearDeviceTableFusion", "LE Device in cache list, remove it");
                                    num = nearDevice2.f3898v;
                                    if (num != null) {
                                        ConcurrentHashMap concurrentHashMap7 = we.m.f10734a;
                                        if (!we.m.d(Integer.valueOf(nearDevice2.hashCode()))) {
                                            I(nearDevice2, t4Var);
                                        }
                                        if (z3) {
                                            we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list");
                                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                            }
                                            I(nearDevice2, t4Var);
                                        }
                                        if (nearDevice3 == null) {
                                            J(nearDevice2, t4Var, z2);
                                        } else {
                                            we.h.h("NearDeviceTableFusion", "Cascade device lost, remove it from cascaded list");
                                        }
                                    }
                                    if (z3) {
                                        we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list for Connected State");
                                        ConcurrentHashMap concurrentHashMap8 = we.m.f10734a;
                                        if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                            we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                        }
                                        I(nearDevice2, t4Var);
                                    }
                                } else {
                                    we.h.b("NearDeviceTableFusion", "LE Device not in cache list, remove it directly");
                                    ConcurrentHashMap concurrentHashMap9 = we.m.f10734a;
                                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    }
                                    if (s(nearDevice)) {
                                        we.h.h("NearDeviceTableFusion", "NearDevice is in connected state, ignore");
                                        return;
                                    }
                                    J(nearDevice, t4Var, z2);
                                }
                                Unit unit3 = Unit.INSTANCE;
                                return;
                            }
                        }
                        nearDevice3 = (NearDevice) obj;
                        if (nearDevice2 != null) {
                            we.h.b("NearDeviceTableFusion", "LE Device in cache list, remove it");
                            num = nearDevice2.f3898v;
                            if (num != null) {
                                ConcurrentHashMap concurrentHashMap10 = we.m.f10734a;
                                if (!we.m.d(Integer.valueOf(nearDevice2.hashCode()))) {
                                    I(nearDevice2, t4Var);
                                }
                                if (z3) {
                                    we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list");
                                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    }
                                    I(nearDevice2, t4Var);
                                }
                                if (nearDevice3 == null) {
                                    J(nearDevice2, t4Var, z2);
                                } else {
                                    we.h.h("NearDeviceTableFusion", "Cascade device lost, remove it from cascaded list");
                                }
                            }
                            if (z3) {
                                we.h.h("NearDeviceTableFusion", "LE Device lost, remove it from cache list for Connected State");
                                ConcurrentHashMap concurrentHashMap11 = we.m.f10734a;
                                if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                }
                                I(nearDevice2, t4Var);
                            }
                        } else {
                            we.h.b("NearDeviceTableFusion", "LE Device not in cache list, remove it directly");
                            ConcurrentHashMap concurrentHashMap12 = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            if (s(nearDevice)) {
                                we.h.h("NearDeviceTableFusion", "NearDevice is in connected state, ignore");
                                return;
                            }
                            J(nearDevice, t4Var, z2);
                        }
                        Unit unit4 = Unit.INSTANCE;
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            case 2:
                ConcurrentHashMap.KeySetView mNsdCachedDevices = this.f9994j;
                Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
                synchronized (mNsdCachedDevices) {
                    try {
                        ConcurrentHashMap.KeySetView mNsdCachedDevices2 = this.f9994j;
                        Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices2, "mNsdCachedDevices");
                        for (Object obj3 : mNsdCachedDevices2) {
                            if (Intrinsics.areEqual((NearDevice) obj3, nearDevice)) {
                                obj = obj3;
                                nearDevice6 = (NearDevice) obj;
                                if (nearDevice6 != null) {
                                    we.h.h("NearDeviceTableFusion", "NSD Device in cache list, remove it");
                                    num2 = nearDevice6.f3898v;
                                    if (num2 != null && num2.intValue() == 1006) {
                                        ConcurrentHashMap concurrentHashMap13 = we.m.f10734a;
                                        if (!we.m.d(Integer.valueOf(nearDevice6.hashCode()))) {
                                            this.f9994j.remove(nearDevice6);
                                        }
                                        if (z3) {
                                            we.h.h("NearDeviceTableFusion", "NSD Device lost, remove it from cache list");
                                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                            }
                                            this.f9994j.remove(nearDevice6);
                                        }
                                        J(nearDevice6, t4Var, z2);
                                    } else {
                                        if (z3) {
                                            we.h.h("NearDeviceTableFusion", "NSD Device lost, remove it from cache list for Connected State");
                                            ConcurrentHashMap concurrentHashMap14 = we.m.f10734a;
                                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                            }
                                            this.f9994j.remove(nearDevice6);
                                        }
                                        we.h.h("NearDeviceTableFusion", "NSD Device not in disconnected, ignore");
                                    }
                                } else {
                                    we.h.h("NearDeviceTableFusion", "NSD Device not in cache list, remove it directly");
                                    ConcurrentHashMap concurrentHashMap15 = we.m.f10734a;
                                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    }
                                    J(nearDevice, t4Var, z2);
                                }
                                Unit unit5 = Unit.INSTANCE;
                            }
                        }
                        nearDevice6 = (NearDevice) obj;
                        if (nearDevice6 != null) {
                            we.h.h("NearDeviceTableFusion", "NSD Device in cache list, remove it");
                            num2 = nearDevice6.f3898v;
                            if (num2 != null) {
                                ConcurrentHashMap concurrentHashMap16 = we.m.f10734a;
                                if (!we.m.d(Integer.valueOf(nearDevice6.hashCode()))) {
                                    this.f9994j.remove(nearDevice6);
                                }
                                if (z3) {
                                    we.h.h("NearDeviceTableFusion", "NSD Device lost, remove it from cache list");
                                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    }
                                    this.f9994j.remove(nearDevice6);
                                }
                                J(nearDevice6, t4Var, z2);
                            }
                            if (z3) {
                                we.h.h("NearDeviceTableFusion", "NSD Device lost, remove it from cache list for Connected State");
                                ConcurrentHashMap concurrentHashMap17 = we.m.f10734a;
                                if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                }
                                this.f9994j.remove(nearDevice6);
                            }
                            we.h.h("NearDeviceTableFusion", "NSD Device not in disconnected, ignore");
                        } else {
                            we.h.h("NearDeviceTableFusion", "NSD Device not in cache list, remove it directly");
                            ConcurrentHashMap concurrentHashMap18 = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            J(nearDevice, t4Var, z2);
                        }
                        Unit unit6 = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
            case 3:
                ConcurrentHashMap.KeySetView mNfcCachedDevices = this.f9995k;
                Intrinsics.checkNotNullExpressionValue(mNfcCachedDevices, "mNfcCachedDevices");
                for (Object obj4 : mNfcCachedDevices) {
                    if (Intrinsics.areEqual((NearDevice) obj4, nearDevice)) {
                        obj = obj4;
                        nearDevice7 = (NearDevice) obj;
                        if (nearDevice7 != null) {
                            we.h.h("NearDeviceTableFusion", "NFC Device not in list, remove it directly");
                            ConcurrentHashMap concurrentHashMap19 = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            J(nearDevice, t4Var, z2);
                            return;
                        }
                        we.h.h("NearDeviceTableFusion", "NFC Device in list, remove it");
                        ConcurrentHashMap concurrentHashMap20 = we.m.f10734a;
                        if (!we.m.d(Integer.valueOf(nearDevice7.hashCode()))) {
                            this.f9995k.remove(nearDevice7);
                        }
                        if (z3) {
                            we.h.h("NearDeviceTableFusion", "NFC Device lost, remove it from cache list");
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            this.f9995k.remove(nearDevice7);
                        }
                        J(nearDevice7, t4Var, z2);
                        return;
                    }
                }
                nearDevice7 = (NearDevice) obj;
                if (nearDevice7 != null) {
                    we.h.h("NearDeviceTableFusion", "NFC Device not in list, remove it directly");
                    ConcurrentHashMap concurrentHashMap110 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    J(nearDevice, t4Var, z2);
                    return;
                }
                we.h.h("NearDeviceTableFusion", "NFC Device in list, remove it");
                ConcurrentHashMap concurrentHashMap21 = we.m.f10734a;
                if (!we.m.d(Integer.valueOf(nearDevice7.hashCode()))) {
                    this.f9995k.remove(nearDevice7);
                }
                if (z3) {
                    we.h.h("NearDeviceTableFusion", "NFC Device lost, remove it from cache list");
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    this.f9995k.remove(nearDevice7);
                }
                J(nearDevice7, t4Var, z2);
                return;
            case 4:
                ConcurrentHashMap.KeySetView mP2pCachedDevices = this.f9996l;
                Intrinsics.checkNotNullExpressionValue(mP2pCachedDevices, "mP2pCachedDevices");
                for (Object obj5 : mP2pCachedDevices) {
                    if (Intrinsics.areEqual((NearDevice) obj5, nearDevice)) {
                        obj = obj5;
                        nearDevice8 = (NearDevice) obj;
                        if (nearDevice8 != null) {
                            we.h.h("NearDeviceTableFusion", "P2P Device not in list, remove it directly");
                            ConcurrentHashMap concurrentHashMap22 = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            J(nearDevice, t4Var, z2);
                            return;
                        }
                        we.h.h("NearDeviceTableFusion", "P2P Device in list, remove it");
                        ConcurrentHashMap concurrentHashMap23 = we.m.f10734a;
                        if (!we.m.d(Integer.valueOf(nearDevice8.hashCode()))) {
                            this.f9996l.remove(nearDevice8);
                        }
                        if (z3) {
                            we.h.h("NearDeviceTableFusion", "P2P Device lost, remove it from cache list");
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            this.f9996l.remove(nearDevice8);
                        }
                        J(nearDevice8, t4Var, z2);
                        return;
                    }
                }
                nearDevice8 = (NearDevice) obj;
                if (nearDevice8 != null) {
                    we.h.h("NearDeviceTableFusion", "P2P Device not in list, remove it directly");
                    ConcurrentHashMap concurrentHashMap24 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    J(nearDevice, t4Var, z2);
                    return;
                }
                we.h.h("NearDeviceTableFusion", "P2P Device in list, remove it");
                ConcurrentHashMap concurrentHashMap25 = we.m.f10734a;
                if (!we.m.d(Integer.valueOf(nearDevice8.hashCode()))) {
                    this.f9996l.remove(nearDevice8);
                }
                if (z3) {
                    we.h.h("NearDeviceTableFusion", "P2P Device lost, remove it from cache list");
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    this.f9996l.remove(nearDevice8);
                }
                J(nearDevice8, t4Var, z2);
                return;
            case 5:
                ConcurrentHashMap.KeySetView mBtCachedDevices = this.f9993i;
                Intrinsics.checkNotNullExpressionValue(mBtCachedDevices, "mBtCachedDevices");
                for (Object obj6 : mBtCachedDevices) {
                    if (Intrinsics.areEqual((NearDevice) obj6, nearDevice)) {
                        obj = obj6;
                        nearDevice9 = (NearDevice) obj;
                        if (nearDevice9 != null) {
                            we.h.h("NearDeviceTableFusion", "BT Device not in list, remove it directly");
                            ConcurrentHashMap concurrentHashMap26 = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            J(nearDevice, t4Var, z2);
                            return;
                        }
                        we.h.h("NearDeviceTableFusion", "BT Device in list, remove it");
                        ConcurrentHashMap concurrentHashMap27 = we.m.f10734a;
                        if (!we.m.d(Integer.valueOf(nearDevice9.hashCode()))) {
                            this.f9993i.remove(nearDevice9);
                        }
                        if (z3) {
                            we.h.h("NearDeviceTableFusion", "BT Device lost, remove it from cache list");
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            this.f9993i.remove(nearDevice9);
                        }
                        J(nearDevice9, t4Var, z2);
                        return;
                    }
                }
                nearDevice9 = (NearDevice) obj;
                if (nearDevice9 != null) {
                    we.h.h("NearDeviceTableFusion", "BT Device not in list, remove it directly");
                    ConcurrentHashMap concurrentHashMap28 = we.m.f10734a;
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    J(nearDevice, t4Var, z2);
                    return;
                }
                we.h.h("NearDeviceTableFusion", "BT Device in list, remove it");
                ConcurrentHashMap concurrentHashMap29 = we.m.f10734a;
                if (!we.m.d(Integer.valueOf(nearDevice9.hashCode()))) {
                    this.f9993i.remove(nearDevice9);
                }
                if (z3) {
                    we.h.h("NearDeviceTableFusion", "BT Device lost, remove it from cache list");
                    if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                        we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    }
                    this.f9993i.remove(nearDevice9);
                }
                J(nearDevice9, t4Var, z2);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return;
            case 12:
                Intrinsics.checkNotNullParameter("NearDeviceTableFusion", "tag");
                Intrinsics.checkNotNullParameter("Unknown Device Type, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearDeviceTableFusion", "TransConnect:Unknown Device Type, ignore", null);
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void I(NearDevice nearDevice, t4 t4Var) {
        if (s1.$EnumSwitchMapping$0[t4Var.ordinal()] != 1) {
            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4Var.name());
            return;
        }
        ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
        synchronized (mBleCachedDevices) {
            try {
                Iterator it = this.f9992h.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    NearDevice nearDevice2 = (NearDevice) it.next();
                    Intrinsics.checkNotNull(nearDevice2);
                    if (Intrinsics.areEqual(nearDevice2, nearDevice)) {
                        it.remove();
                        if (q(nearDevice2, nearDevice)) {
                            nearDevice2.z(nearDevice);
                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                                we.m.b(Integer.valueOf(nearDevice.hashCode()));
                            }
                            we.h.h("NearDeviceTableFusion", "Cascade device removed from removed parent cache list");
                        }
                    } else if (q(nearDevice2, nearDevice)) {
                        nearDevice2.z(nearDevice);
                        ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                        if (we.m.d(Integer.valueOf(nearDevice.hashCode()))) {
                            we.m.b(Integer.valueOf(nearDevice.hashCode()));
                        }
                        we.h.h("NearDeviceTableFusion", "Cascade device removed from cached device list");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void J(NearDevice nearDevice, t4 t4Var, boolean z2) {
        Object next;
        int iO = nearDevice.o();
        ConcurrentHashMap concurrentHashMap = this.f9997m;
        NearDevice nearDevice2 = (NearDevice) concurrentHashMap.get(Integer.valueOf(iO));
        if (nearDevice2 != null) {
            boolean zAreEqual = Intrinsics.areEqual(nearDevice2, nearDevice);
            ConcurrentHashMap.KeySetView keySetView = this.f9991g;
            if (!zAreEqual) {
                we.h.h("NearDeviceTableFusion", "Device not in list");
                String str = nearDevice.f3885c;
                String str2 = nearDevice2.f3885c;
                boolean zAreEqual2 = Intrinsics.areEqual(str, str2);
                String str3 = nearDevice.f3883a;
                String str4 = nearDevice2.f3883a;
                int i8 = nearDevice.e;
                int i9 = nearDevice2.e;
                if (zAreEqual2 && Intrinsics.areEqual(str3, str4) && i8 == i9 && !Intrinsics.areEqual(nearDevice.j(), nearDevice2.j())) {
                    we.h.h("NearDeviceTableFusion", "Cascade device remove it");
                    J(nearDevice2, t4Var, z2);
                    return;
                }
                if (Intrinsics.areEqual(str, str2) && !Intrinsics.areEqual(str3, str4) && i8 == i9) {
                    int i10 = nearDevice.f3890k;
                    if (i10 == 10 || i10 == 11) {
                        we.h.h("NearDeviceTableFusion", "Old QR/NFC device remove it");
                        keySetView.remove(nearDevice);
                        if (z2) {
                            we.h.h("NearDeviceTableFusion", "Device flushed, notify application");
                            A(nearDevice);
                            return;
                        } else {
                            we.h.h("NearDeviceTableFusion", "Device lost, notify application");
                            C(nearDevice);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            we.h.h("NearDeviceTableFusion", "Device removed from list, remove it");
            concurrentHashMap.remove(Integer.valueOf(iO));
            keySetView.remove(nearDevice2);
            p();
            if (z2) {
                we.h.h("NearDeviceTableFusion", "Device flushed, notify application");
                A(nearDevice2);
            } else {
                we.h.h("NearDeviceTableFusion", "Device lost, notify application");
                C(nearDevice2);
            }
            int i11 = s1.$EnumSwitchMapping$0[t4Var.ordinal()];
            ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
            Object obj = null;
            if (i11 == 1) {
                Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                for (Object obj2 : mBleCachedDevices) {
                    if (((NearDevice) obj2).o() == iO) {
                        obj = obj2;
                        break;
                    }
                }
                NearDevice nearDevice3 = (NearDevice) obj;
                if (nearDevice3 != null) {
                    we.h.h("NearDeviceTableFusion", "Unpublish dynamic client LE device, found new LE device to update, publish it");
                    D(nearDevice3, false);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                ConcurrentHashMap.KeySetView mNsdCachedDevices = this.f9994j;
                Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
                Iterator it = mNsdCachedDevices.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((NearDevice) next).o() != iO);
                NearDevice nearDevice4 = (NearDevice) next;
                if (nearDevice4 != null) {
                    we.h.b("NearDeviceTableFusion", "Unpublish dynamic client mDNS device, found new NSD device to update, publish it");
                    D(nearDevice4, false);
                    return;
                }
                we.h.h("NearDeviceTableFusion", "Unpublish mDNS device, drop to other device type");
                Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                for (Object obj3 : mBleCachedDevices) {
                    if (((NearDevice) obj3).o() == iO) {
                        obj = obj3;
                        break;
                    }
                }
                NearDevice nearDevice5 = (NearDevice) obj;
                if (nearDevice5 != null) {
                    we.h.b("NearDeviceTableFusion", "Unpublish mDNS device, found new LE device to update, publish it");
                    D(nearDevice5, false);
                    return;
                }
                return;
            }
            if (i11 == 3) {
                Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                for (Object obj4 : mBleCachedDevices) {
                    if (((NearDevice) obj4).o() == iO) {
                        obj = obj4;
                        break;
                    }
                }
                NearDevice nearDevice6 = (NearDevice) obj;
                if (nearDevice6 != null) {
                    we.h.h("NearDeviceTableFusion", "Unpublish nfc device, found new LE device to update, publish it");
                    D(nearDevice6, false);
                    return;
                }
                return;
            }
            if (i11 != 4) {
                we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4Var.name());
                return;
            }
            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
            for (Object obj5 : mBleCachedDevices) {
                if (((NearDevice) obj5).o() == iO) {
                    obj = obj5;
                    break;
                }
            }
            NearDevice nearDevice7 = (NearDevice) obj;
            if (nearDevice7 != null) {
                we.h.h("NearDeviceTableFusion", "Unpublish p2p device, found new LE device to update, publish it");
                D(nearDevice7, false);
            }
        }
    }

    public final void K(NearDevice nearDevice, t4 t4Var) {
        long j8 = 7000;
        switch (s1.$EnumSwitchMapping$0[w(nearDevice).ordinal()]) {
            case 1:
                break;
            case 2:
                j8 = 42000;
                break;
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                we.h.j("NearDeviceTableFusion", "Unsupported device type " + t4Var.name());
                break;
            case 5:
                j8 = 14000;
                break;
            case 12:
                we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4Var.name());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        we.h.h("NearDeviceTableFusion", "Device updated, timeout updated: " + j8);
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        Integer token = Integer.valueOf(nearDevice.hashCode());
        we.f notifyHandler = a();
        n1 runnable = new n1(this, nearDevice, t4Var, 0);
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(notifyHandler, "notifyHandler");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        we.m.b(token);
        we.m.f(token, j8, notifyHandler, runnable);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:116:0x017a A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:118:0x017d A[Catch: all -> 0x0172, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0172, blocks: (B:105:0x0150, B:106:0x015b, B:108:0x0161, B:114:0x0176, B:118:0x017d), top: B:177:0x0150 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0182  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:127:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:128:0x01de  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:130:0x0205  */
    /* JADX WARN: Code duplicated, block: B:165:0x0298  */
    /* JADX WARN: Code duplicated, block: B:167:0x029e  */
    /* JADX WARN: Code duplicated, block: B:172:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:173:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0 A[Catch: all -> 0x00c7, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c7, blocks: (B:45:0x00a8, B:46:0x00b3, B:48:0x00b9, B:54:0x00ca, B:58:0x00d0), top: B:179:0x00a8 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0105 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:78:0x0107 A[Catch: all -> 0x00fe, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00fe, blocks: (B:65:0x00df, B:66:0x00ea, B:68:0x00f0, B:74:0x0101, B:78:0x0107), top: B:183:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:96:0x013f A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:98:0x0142 A[Catch: all -> 0x0138, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0138, blocks: (B:85:0x0116, B:86:0x0121, B:88:0x0127, B:94:0x013b, B:98:0x0142), top: B:181:0x0116 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v23 java.lang.Object, still in use, count: 2, list:
          (r3v23 java.lang.Object) from 0x0101: PHI (r3 I:??) = (r3v20 java.lang.Object), (r3v23 java.lang.Object) binds: [B:73:0x0100, B:70:0x00fd] A[DONT_GENERATE, DONT_INLINE]
          (r3v23 java.lang.Object) from 0x00f5: CHECK_CAST (com.welink.protocol.nfbd.NearDevice) (r3v23 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final void j(com.welink.protocol.nfbd.NearDevice r8, se.t4 r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.t1.j(com.welink.protocol.nfbd.NearDevice, se.t4, boolean, boolean):void");
    }

    public final void k(final NearDevice device, final t4 t4Var, final boolean z2, final boolean z3) {
        Intrinsics.checkNotNullParameter(device, "device");
        f(new Runnable() { // from class: se.p1
            /* JADX WARN: Code duplicated, block: B:44:0x00a8 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:45:0x00aa A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:5:0x0013, B:6:0x0017, B:7:0x001f, B:8:0x0022, B:9:0x0027, B:12:0x002b, B:50:0x00ba, B:13:0x0042, B:14:0x0058, B:15:0x005c, B:16:0x0060, B:17:0x0064, B:19:0x006a, B:32:0x0090, B:48:0x00b3, B:38:0x009e, B:22:0x0070, B:24:0x0076, B:26:0x007a, B:28:0x007e, B:30:0x008a, B:45:0x00aa, B:49:0x00b7), top: B:55:0x0013 }] */
            @Override // java.lang.Runnable
            public final void run() {
                NearDeviceExtension nearDeviceExtension;
                List list;
                int i8;
                t1 t1Var = this.f9931a;
                NearDevice nearDevice = device;
                t4 t4VarW = t4Var;
                boolean z5 = z2;
                boolean z10 = z3;
                synchronized (t1Var.f9990d) {
                    if (t4VarW == null) {
                        try {
                            t4VarW = t1.w(nearDevice);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    switch (s1.$EnumSwitchMapping$0[t4VarW.ordinal()]) {
                        case 1:
                        case 5:
                            t1Var.j(nearDevice, t4VarW, z5, z10);
                            break;
                        case 2:
                            if (t1Var.x(nearDevice)) {
                                if (nearDevice.e == 0 || (t1Var.z(nearDevice) && (nearDeviceExtension = nearDevice.u) != null && (list = nearDeviceExtension.f3905a) != null && list.contains(8) && list.size() == 1)) {
                                    int i9 = nearDevice.f3890k;
                                    if ((i9 == 14 || i9 == 15 || i9 == 16) && ((i8 = nearDevice.f3889j) == 1 || i8 == 5 || i8 == 6)) {
                                        if (!z10) {
                                            we.h.j("NearDeviceTableFusion", "Lan device is not cacheable, ignore");
                                            return;
                                        }
                                    }
                                }
                            } else if (!z10) {
                                we.h.j("NearDeviceTableFusion", "Lan device is not cacheable, ignore");
                                return;
                            }
                            t1Var.j(nearDevice, t4VarW, z5, z10);
                        case 3:
                            t1Var.j(nearDevice, t4VarW, z5, z10);
                            break;
                        case 4:
                            t1Var.j(nearDevice, t4VarW, z5, z10);
                            break;
                        case 6:
                            t1Var.j(nearDevice, t4VarW, z5, z10);
                            break;
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                            break;
                        case 12:
                            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    public final void l(NearDevice nearDevice, t4 t4Var) {
        switch (s1.$EnumSwitchMapping$0[t4Var.ordinal()]) {
            case 1:
                ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
                Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                synchronized (mBleCachedDevices) {
                    this.f9992h.add(nearDevice);
                }
                return;
            case 2:
                ConcurrentHashMap.KeySetView mNsdCachedDevices = this.f9994j;
                Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
                synchronized (mNsdCachedDevices) {
                    this.f9994j.add(nearDevice);
                }
                return;
            case 3:
                ConcurrentHashMap.KeySetView mNfcCachedDevices = this.f9995k;
                Intrinsics.checkNotNullExpressionValue(mNfcCachedDevices, "mNfcCachedDevices");
                synchronized (mNfcCachedDevices) {
                    this.f9995k.add(nearDevice);
                }
                return;
            case 4:
                ConcurrentHashMap.KeySetView mP2pCachedDevices = this.f9996l;
                Intrinsics.checkNotNullExpressionValue(mP2pCachedDevices, "mP2pCachedDevices");
                synchronized (mP2pCachedDevices) {
                    this.f9996l.add(nearDevice);
                }
                return;
            case 5:
                ConcurrentHashMap.KeySetView mBtCachedDevices = this.f9993i;
                Intrinsics.checkNotNullExpressionValue(mBtCachedDevices, "mBtCachedDevices");
                synchronized (mBtCachedDevices) {
                    this.f9993i.add(nearDevice);
                }
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4Var.name());
                return;
            case 12:
                we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4Var.name());
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean m(NearDevice nearDevice, NearDevice nearDevice2) {
        String str;
        String str2;
        Object obj = null;
        if (nearDevice.f3890k != 0) {
            Intrinsics.checkNotNullParameter("NearDeviceTableFusion", "tag");
            Intrinsics.checkNotNullParameter("Unknown supported wireless type", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearDeviceTableFusion", "TransConnect:Unknown supported wireless type", null);
            }
        } else if (!Intrinsics.areEqual(nearDevice.f3883a, nearDevice2.f3883a)) {
            String str3 = nearDevice.f3885c;
            String str4 = nearDevice2.f3885c;
            if (Intrinsics.areEqual(str3, str4)) {
                int i8 = nearDevice.e;
                int i9 = nearDevice2.e;
                if (i8 == i9 || z(nearDevice2)) {
                    NearDeviceExtension nearDeviceExtension = nearDevice.u;
                    int i10 = nearDeviceExtension != null ? nearDeviceExtension.f3908d : 0;
                    NearDeviceExtension nearDeviceExtension2 = nearDevice2.u;
                    if (i10 != (nearDeviceExtension2 != null ? nearDeviceExtension2.f3908d : 0)) {
                        we.h.h("NearDeviceTableFusion", "Device can be cascaded, device has diff ble version");
                        String str5 = nearDevice2.f3884b;
                        if ((str5 == null || str5.length() == 0 || (((str2 = nearDevice2.f3884b) != null && Intrinsics.areEqual(str2, nearDevice2.f3883a)) || StringsKt__StringsJVMKt.equals$default(nearDevice2.f3884b, nearDevice.f3884b, false, 2, null))) && (str = nearDevice.f3884b) != null && str.length() != 0) {
                            we.h.j("NearDeviceTableFusion", "Device name is empty or same, cascaded");
                            List<NearDevice> listJ = nearDevice.j();
                            if (listJ != null && listJ.contains(nearDevice2)) {
                                for (Object obj2 : listJ) {
                                    if (Intrinsics.areEqual((NearDevice) obj2, nearDevice2)) {
                                        obj = obj2;
                                        break;
                                    }
                                }
                                NearDevice nearDevice3 = (NearDevice) obj;
                                if (nearDevice3 != null) {
                                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                                    if (we.m.d(Integer.valueOf(nearDevice3.hashCode()))) {
                                        K(nearDevice3, w(nearDevice2));
                                    }
                                }
                                if (nearDevice3 != null) {
                                    nearDevice3.E(nearDevice2);
                                }
                                return true;
                            }
                            if (listJ != null && (!listJ.isEmpty())) {
                                for (NearDevice nearDevice4 : listJ) {
                                    if (!Intrinsics.areEqual(nearDevice4.f3883a, nearDevice2.f3883a) && Intrinsics.areEqual(nearDevice4.f3885c, str4) && nearDevice4.e == i9) {
                                        NearDeviceExtension nearDeviceExtension3 = nearDevice4.u;
                                        if ((nearDeviceExtension3 != null ? nearDeviceExtension3.f3908d : 0) == (nearDeviceExtension2 != null ? nearDeviceExtension2.f3908d : 0)) {
                                            we.h.j("NearDeviceTableFusion", "Cascade device(Connectable) address was updated?");
                                            nearDevice.z(nearDevice4);
                                            ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                                            we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                            f(new n1(this, nearDevice, t4.LE_DEVICE, 1));
                                            return true;
                                        }
                                    }
                                }
                            }
                            nearDevice.b(nearDevice2);
                            ConcurrentHashMap concurrentHashMap3 = we.m.f10734a;
                            we.m.f(Integer.valueOf(nearDevice2.hashCode()), 7000L, a(), new o1(this, nearDevice2, 0));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean n(NearDevice nearDevice, NearDevice nearDevice2) {
        String name;
        Object obj = null;
        if (nearDevice.f3890k != 0) {
            Intrinsics.checkNotNullParameter("NearDeviceTableFusion", "tag");
            Intrinsics.checkNotNullParameter("Unknown supported wireless type", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearDeviceTableFusion", "TransConnect:Unknown supported wireless type", null);
            }
        } else if (!Intrinsics.areEqual(nearDevice.f3883a, nearDevice2.f3883a)) {
            String str = nearDevice.f3885c;
            String str2 = nearDevice2.f3885c;
            if (Intrinsics.areEqual(str, str2)) {
                int i8 = nearDevice.e;
                int i9 = nearDevice2.e;
                if (i8 == i9) {
                    we.h.h("NearDeviceTableFusion", "Device can be cascaded, device has different ble version");
                    String str3 = nearDevice2.f3884b;
                    Integer numValueOf = str3 != null ? Integer.valueOf(str3.length()) : null;
                    String str4 = nearDevice.f3884b;
                    Integer numValueOf2 = str4 != null ? Integer.valueOf(str4.length()) : null;
                    if (numValueOf != null && numValueOf2 != null && numValueOf.intValue() > numValueOf2.intValue() && (name = nearDevice2.f3884b) != null) {
                        Intrinsics.checkNotNullParameter(name, "name");
                        nearDevice.f3884b = name;
                    }
                    List<NearDevice> listJ = nearDevice.j();
                    if (listJ != null && listJ.contains(nearDevice2)) {
                        for (Object obj2 : listJ) {
                            if (Intrinsics.areEqual((NearDevice) obj2, nearDevice2)) {
                                obj = obj2;
                                break;
                            }
                        }
                        NearDevice nearDevice3 = (NearDevice) obj;
                        if (nearDevice3 != null) {
                            nearDevice3.E(nearDevice2);
                        }
                        if (nearDevice3 != null) {
                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                            if (we.m.d(Integer.valueOf(nearDevice3.hashCode()))) {
                                K(nearDevice3, w(nearDevice2));
                            }
                        }
                        return true;
                    }
                    if (listJ != null && (!listJ.isEmpty())) {
                        for (NearDevice nearDevice4 : listJ) {
                            if (!Intrinsics.areEqual(nearDevice4.f3883a, nearDevice2.f3883a) && Intrinsics.areEqual(nearDevice4.f3885c, str2) && nearDevice4.e == i9) {
                                NearDeviceExtension nearDeviceExtension = nearDevice4.u;
                                int i10 = nearDeviceExtension != null ? nearDeviceExtension.f3908d : 0;
                                NearDeviceExtension nearDeviceExtension2 = nearDevice2.u;
                                if (i10 == (nearDeviceExtension2 != null ? nearDeviceExtension2.f3908d : 0)) {
                                    we.h.j("NearDeviceTableFusion", "Cascade device(Non-connectable) address was updated?");
                                    nearDevice.z(nearDevice4);
                                    ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                                    f(new n1(this, nearDevice, t4.LE_DEVICE, 1));
                                    return true;
                                }
                            }
                        }
                    }
                    nearDevice.b(nearDevice2);
                    return true;
                }
            }
        }
        return false;
    }

    public final void o(NearDevice nearDevice) {
        synchronized (this.f9990d) {
            try {
                int iO = nearDevice.o();
                NearDevice nearDevice2 = (NearDevice) this.f9997m.get(Integer.valueOf(iO));
                if (nearDevice2 != null) {
                    if (Intrinsics.areEqual(nearDevice2, nearDevice)) {
                        we.h.h("NearDeviceTableFusion", "Device removed from table list");
                        this.f9997m.remove(Integer.valueOf(iO));
                        this.f9991g.remove(nearDevice2);
                        p();
                        we.h.h("NearDeviceTableFusion", "Device flushed, notify application");
                        A(nearDevice2);
                    } else {
                        we.h.h("NearDeviceTableFusion", "Device not in table list, ignore");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void p() {
        ConcurrentHashMap concurrentHashMap = this.f9997m;
        we.h.b("NearDeviceTableFusion", "Device HashMap size: " + concurrentHashMap.size());
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            we.h.b("NearDeviceTableFusion", "Device HashMap: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public final boolean s(NearDevice nearDevice) {
        NearDevice nearDevice2 = (NearDevice) this.f9997m.get(Integer.valueOf(nearDevice.o()));
        if (nearDevice2 == null) {
            return false;
        }
        Integer num = nearDevice2.f3898v;
        return (num != null && num.intValue() == 1006 && nearDevice2.f3900x == 1014) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0169 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:109:0x016b A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:21:0x0072 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:23:0x0074 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:59:0x00dc A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:61:0x00de A[DONT_GENERATE] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v22 java.lang.Object, still in use, count: 2, list:
          (r0v22 java.lang.Object) from 0x00d8: PHI (r0 I:??) = (r0v19 java.lang.Object), (r0v22 java.lang.Object) binds: [B:56:0x00d7, B:53:0x00d4] A[DONT_GENERATE, DONT_INLINE]
          (r0v22 java.lang.Object) from 0x00cc: CHECK_CAST (com.welink.protocol.nfbd.NearDevice) (r0v22 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final com.welink.protocol.nfbd.NearDevice v(com.welink.protocol.nfbd.NearDevice r5, se.t4 r6) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.t1.v(com.welink.protocol.nfbd.NearDevice, se.t4):com.welink.protocol.nfbd.NearDevice");
    }

    public final boolean x(NearDevice nearDevice) {
        Object obj;
        Object next;
        NearDevice nearDevice2;
        Integer num;
        Integer num2;
        Integer num3;
        ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
        Iterator it = mBleCachedDevices.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            NearDevice nearDevice3 = (NearDevice) next;
            if (nearDevice3.o() == nearDevice.o() && ((num3 = nearDevice3.f3898v) == null || num3.intValue() != 1006 || nearDevice3.f3900x != 1014)) {
                break;
            }
        }
        NearDevice nearDevice4 = (NearDevice) next;
        if (nearDevice4 == null) {
            ConcurrentHashMap.KeySetView mNearDevices = this.f9991g;
            Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
            for (Object obj2 : mNearDevices) {
                NearDevice nearDevice5 = (NearDevice) obj2;
                if (nearDevice5.o() == nearDevice.o() && ((num2 = nearDevice5.f3898v) == null || num2.intValue() != 1006 || nearDevice5.f3900x != 1014)) {
                    obj = obj2;
                    break;
                }
            }
            nearDevice4 = (NearDevice) obj;
        }
        if (nearDevice4 == null && (nearDevice2 = (NearDevice) this.f9997m.get(Integer.valueOf(nearDevice.o()))) != null && ((num = nearDevice2.f3898v) == null || num.intValue() != 1006 || nearDevice2.f3900x != 1014)) {
            nearDevice4 = nearDevice2;
        }
        return nearDevice4 == null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean y(NearDevice device) {
        boolean zContains;
        boolean zContains2;
        boolean zContains3;
        Intrinsics.checkNotNullParameter(device, "device");
        synchronized (this.f9990d) {
            try {
                t4 t4VarW = w(device);
                switch (s1.$EnumSwitchMapping$0[t4VarW.ordinal()]) {
                    case 1:
                        ConcurrentHashMap.KeySetView mBleCachedDevices = this.f9992h;
                        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                        synchronized (mBleCachedDevices) {
                            zContains = this.f9992h.contains(device);
                        }
                        return zContains;
                    case 2:
                        ConcurrentHashMap.KeySetView mNsdCachedDevices = this.f9994j;
                        Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
                        synchronized (mNsdCachedDevices) {
                            zContains2 = this.f9994j.contains(device);
                        }
                        return zContains2;
                    case 3:
                    case 4:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        Unit unit = Unit.INSTANCE;
                        return false;
                    case 5:
                        ConcurrentHashMap.KeySetView mBtCachedDevices = this.f9993i;
                        Intrinsics.checkNotNullExpressionValue(mBtCachedDevices, "mBtCachedDevices");
                        synchronized (mBtCachedDevices) {
                            zContains3 = this.f9993i.contains(device);
                        }
                        return zContains3;
                    case 6:
                        we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                        Unit unit2 = Unit.INSTANCE;
                        return false;
                    case 12:
                        we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                        Unit unit3 = Unit.INSTANCE;
                        return false;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean z(NearDevice device) {
        NearDeviceExtension nearDeviceExtension;
        List list;
        Intrinsics.checkNotNullParameter(device, "device");
        ConcurrentHashMap.KeySetView<Integer> mDiscoveryServiceList = this.e;
        Intrinsics.checkNotNullExpressionValue(mDiscoveryServiceList, "mDiscoveryServiceList");
        if (mDiscoveryServiceList != null && mDiscoveryServiceList.isEmpty()) {
            return false;
        }
        for (Integer num : mDiscoveryServiceList) {
            int i8 = device.e;
            if ((num != null && i8 == num.intValue()) || (device.e == 251 && (nearDeviceExtension = device.u) != null && (list = nearDeviceExtension.f3905a) != null && list.contains(num))) {
                return true;
            }
        }
        return false;
    }
}
