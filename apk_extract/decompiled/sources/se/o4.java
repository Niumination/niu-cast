package se;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Build;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o4 extends we.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9913d;
    public final ye.d e;
    public i2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h4 f9914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NearDevice f9915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f9916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f9917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f9918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f9919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f9920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9922o;
    public long p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final n4 f9923r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j4 f9924s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o4(Context mContext, h4 h4Var, String mP2pType, int i8) {
        super(false, "P2pConnectControllerHandler");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mP2pType, "mP2pType");
        this.f9912c = mP2pType;
        this.f9913d = i8;
        this.f9916i = new LinkedHashSet();
        this.f9917j = new LinkedHashSet();
        this.f9918k = new LinkedHashSet();
        this.f9919l = new LinkedHashMap();
        this.f9920m = new LinkedHashMap();
        this.p = WorkRequest.MIN_BACKOFF_MILLIS;
        this.e = new ye.d(mContext);
        this.f9914g = h4Var;
        this.f9923r = new n4(this);
        this.f9924s = new j4(this, 0);
        new j4(this, 1);
        new j4(this, 2);
        new j4(this, 3);
    }

    public static final void j(o4 o4Var, String str, String str2, WifiP2pDevice wifiP2pDevice, String str3, WifiP2pGroup wifiP2pGroup) {
        synchronized (o4Var) {
            try {
                if (!o4Var.f9916i.isEmpty()) {
                    i2 i2Var = o4Var.f;
                    TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var != null ? i2Var.f9793a : null, i2Var != null ? i2Var.f9796d : null, i2Var != null ? i2Var.f9795c : 0, str, str2, 0, 0, wifiP2pDevice, wifiP2pGroup);
                    for (w wVar : o4Var.f9916i) {
                        NearDevice nearDevice = o4Var.f9915h;
                        if (nearDevice != null) {
                            wVar.d(null, wifiP2pDevice, str3, tranConnectionController$P2pDeviceInfo.f3979d, tranConnectionController$P2pDeviceInfo.e, tranConnectionController$P2pDeviceInfo, nearDevice);
                        } else {
                            String tag = "P2pConnectController-" + o4Var.f9912c;
                            Intrinsics.checkNotNullParameter(tag, "tag");
                            Intrinsics.checkNotNullParameter("P2p owner device or mNearDevice is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e(tag, "TransConnect:P2p owner device or mNearDevice is null", null);
                            }
                        }
                    }
                    o4Var.f9917j.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00e9 A[Catch: all -> 0x001d, LOOP:1: B:56:0x00e3->B:58:0x00e9, LOOP_END, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:5:0x000d, B:7:0x0014, B:14:0x0023, B:21:0x0030, B:23:0x0053, B:29:0x0077, B:32:0x0081, B:33:0x0085, B:41:0x009c, B:43:0x00a5, B:46:0x00ab, B:47:0x00af, B:55:0x00c8, B:56:0x00e3, B:58:0x00e9, B:59:0x00f3, B:61:0x00fb, B:63:0x00ff, B:64:0x0109, B:66:0x0125, B:50:0x00b6, B:53:0x00c2, B:36:0x008b, B:39:0x0096, B:18:0x002a), top: B:71:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fb A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:5:0x000d, B:7:0x0014, B:14:0x0023, B:21:0x0030, B:23:0x0053, B:29:0x0077, B:32:0x0081, B:33:0x0085, B:41:0x009c, B:43:0x00a5, B:46:0x00ab, B:47:0x00af, B:55:0x00c8, B:56:0x00e3, B:58:0x00e9, B:59:0x00f3, B:61:0x00fb, B:63:0x00ff, B:64:0x0109, B:66:0x0125, B:50:0x00b6, B:53:0x00c2, B:36:0x008b, B:39:0x0096, B:18:0x002a), top: B:71:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:5:0x000d, B:7:0x0014, B:14:0x0023, B:21:0x0030, B:23:0x0053, B:29:0x0077, B:32:0x0081, B:33:0x0085, B:41:0x009c, B:43:0x00a5, B:46:0x00ab, B:47:0x00af, B:55:0x00c8, B:56:0x00e3, B:58:0x00e9, B:59:0x00f3, B:61:0x00fb, B:63:0x00ff, B:64:0x0109, B:66:0x0125, B:50:0x00b6, B:53:0x00c2, B:36:0x008b, B:39:0x0096, B:18:0x002a), top: B:71:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0109 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:5:0x000d, B:7:0x0014, B:14:0x0023, B:21:0x0030, B:23:0x0053, B:29:0x0077, B:32:0x0081, B:33:0x0085, B:41:0x009c, B:43:0x00a5, B:46:0x00ab, B:47:0x00af, B:55:0x00c8, B:56:0x00e3, B:58:0x00e9, B:59:0x00f3, B:61:0x00fb, B:63:0x00ff, B:64:0x0109, B:66:0x0125, B:50:0x00b6, B:53:0x00c2, B:36:0x008b, B:39:0x0096, B:18:0x002a), top: B:71:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0125 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:5:0x000d, B:7:0x0014, B:14:0x0023, B:21:0x0030, B:23:0x0053, B:29:0x0077, B:32:0x0081, B:33:0x0085, B:41:0x009c, B:43:0x00a5, B:46:0x00ab, B:47:0x00af, B:55:0x00c8, B:56:0x00e3, B:58:0x00e9, B:59:0x00f3, B:61:0x00fb, B:63:0x00ff, B:64:0x0109, B:66:0x0125, B:50:0x00b6, B:53:0x00c2, B:36:0x008b, B:39:0x0096, B:18:0x002a), top: B:71:0x0007 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x0109, please report this as an issue */
    public static final void k(o4 o4Var, String str, String str2, String str3, int i8, WifiP2pDevice p2pOwnerDevice, WifiP2pGroup wifiP2pGroup) {
        i2 i2Var;
        NearDevice nearDevice;
        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo;
        int i9;
        int i10;
        Iterator it;
        long j8;
        h4 h4Var;
        h4 h4Var2;
        int i11;
        int i12;
        synchronized (o4Var) {
            try {
                Iterator it2 = o4Var.f9918k.iterator();
                do {
                    if (!it2.hasNext()) {
                        i2Var = null;
                        break;
                    }
                    i2Var = (i2) it2.next();
                } while (i2Var == null);
                if (i2Var == null || (nearDevice = i2Var.f9797g) == null) {
                    nearDevice = o4Var.f9915h;
                }
                NearDevice nearDevice2 = nearDevice;
                if (nearDevice2 == null) {
                    String tag = "P2pConnectController-" + o4Var.f9912c;
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter("nearDevice is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e(tag, "TransConnect:nearDevice is null", null);
                    }
                    return;
                }
                if (i2Var != null) {
                    i2Var.f9793a = str2;
                    i2Var.f9794b = str3;
                    if (2412 > i8 || i8 >= 2485) {
                        if (5180 <= i8 && i8 < 5886) {
                            i11 = ((i8 - 5180) / 5) + 36;
                        } else if (5955 > i8 || i8 >= 7116) {
                            i11 = 0;
                        } else {
                            i12 = (i8 - 5955) / 5;
                        }
                        i2Var.f9795c = i11;
                        i2Var.f9798h = i8;
                    } else {
                        i12 = (i8 - 2412) / 5;
                    }
                    i11 = i12 + 1;
                    i2Var.f9795c = i11;
                    i2Var.f9798h = i8;
                }
                if (2412 > i8 || i8 >= 2485) {
                    if (5180 <= i8 && i8 < 5886) {
                        i9 = ((i8 - 5180) / 5) + 36;
                    } else if (5955 > i8 || i8 >= 7116) {
                        i9 = 0;
                    } else {
                        i10 = (i8 - 5955) / 5;
                    }
                    tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(str2, str3, i9, str, null, 0, i8, p2pOwnerDevice, wifiP2pGroup);
                    it = o4Var.f9916i.iterator();
                    while (it.hasNext()) {
                        ((w) it.next()).f(null, p2pOwnerDevice, nearDevice2, tranConnectionController$P2pDeviceInfo);
                    }
                    j8 = o4Var.p;
                    if (j8 > 0) {
                        h4Var2 = o4Var.f9914g;
                        if (h4Var2 != null) {
                            h4Var2.E(null, p2pOwnerDevice, nearDevice2, j8, 100);
                        }
                    } else {
                        we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p group owner wait timeout is 0 or negative, do not start timer");
                        h4Var = o4Var.f9914g;
                        if (h4Var != null) {
                            Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                            h4Var.f9769l = new a0.g(h4Var, 15, p2pOwnerDevice, nearDevice2);
                        }
                    }
                }
                i10 = (i8 - 2412) / 5;
                i9 = i10 + 1;
                tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(str2, str3, i9, str, null, 0, i8, p2pOwnerDevice, wifiP2pGroup);
                it = o4Var.f9916i.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).f(null, p2pOwnerDevice, nearDevice2, tranConnectionController$P2pDeviceInfo);
                }
                j8 = o4Var.p;
                if (j8 > 0) {
                    h4Var2 = o4Var.f9914g;
                    if (h4Var2 != null) {
                        h4Var2.E(null, p2pOwnerDevice, nearDevice2, j8, 100);
                    }
                } else {
                    we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p group owner wait timeout is 0 or negative, do not start timer");
                    h4Var = o4Var.f9914g;
                    if (h4Var != null) {
                        Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                        h4Var.f9769l = new a0.g(h4Var, 15, p2pOwnerDevice, nearDevice2);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m(o4 o4Var, String str, int i8, int i9, String str2) {
        o4Var.getClass();
        o4Var.f(new b0.b(str, i8, i9, str2, null, null, o4Var, null, null));
    }

    public final void l(int i8) {
        boolean zQ = q();
        String str = this.f9912c;
        if (!zQ) {
            we.h.h("P2pConnectController-" + str, "P2p is in idle state, do not cleanup");
        } else {
            if (i8 != 1) {
                if (i8 != 4) {
                    h0.a.u(i8, "unknown disconnect type: ", h0.a.i("P2pConnectController-", str));
                    return;
                } else {
                    m(this, null, 12, 0, null);
                    return;
                }
            }
            we.h.h("P2pConnectController-" + str, "P2p disconnect by user");
            g(CoroutineLiveDataKt.DEFAULT_TIMEOUT, this.f9924s);
        }
    }

    public final void n() {
        if (!q()) {
            we.h.h("P2pConnectController-" + this.f9912c, "P2p is in idle state, do not disconnect");
        } else {
            h4 h4Var = this.f9914g;
            if (h4Var == null || h4Var.l()) {
                return;
            }
            h4Var.o();
        }
    }

    public final void o(NearDevice nearDevice) {
        String str = this.f9912c;
        if (nearDevice == null) {
            we.h.j("P2pConnectController-" + str, "flushDevice: device is null");
            return;
        }
        int i8 = nearDevice.f3890k;
        if (i8 != 0) {
            switch (i8) {
                case 10:
                case 11:
                    int i9 = this.f9922o;
                    if (i9 <= 0) {
                        this.f9922o = 0;
                    } else {
                        int i10 = i9 - 1;
                        this.f9922o = i10;
                        if (i10 == 0) {
                            h4 h4Var = this.f9914g;
                            if (h4Var != null) {
                                h4Var.J(this.f9923r, this.f9913d);
                            }
                            we.h.h("P2pConnectController-" + str, "unregisterNearP2pManagerListener done");
                        } else {
                            we.h.j(h0.a.i("P2pConnectController-", str), "unregisterNearP2pManagerListener: count: " + this.f9922o);
                        }
                    }
                    if (!q() && this.f9922o <= 0) {
                        we.h.h("P2pConnectController-" + str, "flushDevice: P2P device, flush");
                        f(new o.e(7, this, nearDevice));
                    } else {
                        we.h.h("P2pConnectController-" + str, "flushDevice: P2p recovery mode, ignore");
                    }
                    break;
                case 12:
                    break;
                default:
                    we.h.h("P2pConnectController-" + str, "flushDevice: unknown device, ignore");
                    break;
            }
            return;
        }
        we.h.h("P2pConnectController-" + str, "flushDevice: BLE device, ignore");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    public final Integer p() {
        if (!q()) {
            we.h.h("P2pConnectController-" + this.f9912c, "P2p is in idle state, do not get transfer state");
            return null;
        }
        h4 h4Var = this.f9914g;
        if (h4Var == null) {
            return null;
        }
        n6 n6Var = h4Var.f9765h;
        int i8 = 1;
        if (n6Var instanceof p6) {
            n6 n6Var2 = h4Var.f9764g;
            if (n6Var2 instanceof p6) {
                i8 = 0;
            } else if (n6Var2 instanceof l6) {
                i8 = 2;
            }
        } else if (n6Var instanceof l6) {
            i8 = 2;
        }
        return Integer.valueOf(i8);
    }

    public final boolean q() {
        return (this.f9917j.isEmpty() && this.f9918k.isEmpty() && this.f9920m.isEmpty() && this.f9919l.isEmpty()) ? false : true;
    }

    public final void r() {
        h4 h4Var = this.f9914g;
        if (h4Var != null) {
            h4Var.u(new we.i(this), this.f9923r, this.f9913d);
        }
        this.f9922o++;
        h0.a.u(this.f9922o, "registerNearP2pManagerListener: count: ", "P2pConnectController-" + this.f9912c);
    }

    public final void s(WifiP2pDevice wifiP2pDevice, String str) {
        String strRemovePrefix;
        i2 i2Var;
        NearDevice nearDevice;
        synchronized (this) {
            try {
                Iterator it = this.f9918k.iterator();
                do {
                    strRemovePrefix = null;
                    if (!it.hasNext()) {
                        i2Var = null;
                        break;
                    }
                    i2Var = (i2) it.next();
                } while (i2Var == null);
                if (i2Var == null || (nearDevice = i2Var.f9797g) == null) {
                    nearDevice = this.f9915h;
                }
                if (nearDevice != null) {
                    nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
                    if (Build.VERSION.SDK_INT >= 35) {
                        we.h.h("P2pConnectController-" + this.f9912c, "onGroupClientConnected VANILLA_ICE_CREAM, get client ip address: " + wifiP2pDevice.getIpAddress());
                        strRemovePrefix = StringsKt__StringsKt.removePrefix(String.valueOf(wifiP2pDevice.getIpAddress()), (CharSequence) "/");
                    }
                    Iterator it2 = this.f9916i.iterator();
                    while (it2.hasNext()) {
                        ((w) it2.next()).c(null, wifiP2pDevice, nearDevice, str, strRemovePrefix);
                    }
                    if (this.f9920m.get(str) != null) {
                        m4 m4Var = (m4) this.f9920m.get(str);
                        if (m4Var != null) {
                            m4Var.f9872a.add(wifiP2pDevice);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(wifiP2pDevice);
                        this.f9920m.put(str, new m4(arrayList, nearDevice));
                    }
                    this.f9918k.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
