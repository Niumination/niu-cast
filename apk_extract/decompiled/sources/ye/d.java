package ye;

import android.content.Context;
import android.net.MacAddress;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import com.welink.protocol.wifi.P2pTool$mP2pReceiver$1;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import k3.lb;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import se.g4;
import se.h4;
import se.i2;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WifiP2pManager f11172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WifiP2pManager.Channel f11173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g4 f11174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11175d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f11178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i2 f11179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final P2pTool$mP2pReceiver$1 f11181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f11182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f11183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11184o;
    public qe.g p;
    public final b q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f11185r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f11186s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f11187t;

    /* JADX WARN: Type inference failed for: r2v2, types: [ye.a] */
    /* JADX WARN: Type inference failed for: r2v5, types: [ye.a] */
    /* JADX WARN: Type inference failed for: r2v7, types: [ye.a] */
    public d(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f11181l = new P2pTool$mP2pReceiver$1(this);
        final int i8 = 0;
        this.f11182m = new WifiP2pManager.GroupInfoListener(this) { // from class: ye.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f11166b;

            {
                this.f11166b = this;
            }

            @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
            public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                WifiP2pManager wifiP2pManager;
                switch (i8) {
                    case 0:
                        we.h.g("onGroupInfoAvailable");
                        d dVar = this.f11166b;
                        if (wifiP2pGroup == null) {
                            dVar.b(dVar.f11176g, dVar.f11177h, dVar.e, dVar.f11175d, dVar.f);
                            return;
                        }
                        we.h.i("Apps using Wi-Fi P2P channels are already turned off", null);
                        WifiP2pManager wifiP2pManager2 = dVar.f11172a;
                        if (wifiP2pManager2 != null) {
                            WifiP2pManager.Channel channel = dVar.f11173b;
                            Intrinsics.checkNotNull(channel);
                            wifiP2pManager2.removeGroup(channel, dVar.f11183n);
                            return;
                        }
                        return;
                    case 1:
                        we.h.g("onGroupInfoAvailable");
                        d dVar2 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, ignore", null);
                            g4 g4Var = dVar2.f11174c;
                            if (g4Var != null) {
                                h4 h4Var = g4Var.f9745a;
                                synchronized (g4Var) {
                                    h4.x(h4Var, 0, 30);
                                    Unit unit = Unit.INSTANCE;
                                }
                                return;
                            }
                            return;
                        }
                        if (!dVar2.a(wifiP2pGroup)) {
                            we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                            WifiP2pManager wifiP2pManager3 = dVar2.f11172a;
                            if (wifiP2pManager3 != null) {
                                WifiP2pManager.Channel channel2 = dVar2.f11173b;
                                Intrinsics.checkNotNull(channel2);
                                wifiP2pManager3.removeGroup(channel2, dVar2.q);
                                return;
                            }
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is has been removed already", null);
                        we.h.g("Removing persistent groups, nothing to do");
                        dVar2.f11179j = null;
                        dVar2.f11180k = null;
                        g4 g4Var2 = dVar2.f11174c;
                        if (g4Var2 != null) {
                            g4Var2.f();
                            return;
                        }
                        return;
                    default:
                        we.h.g("onGroupInfoAvailable, Creating Group");
                        d dVar3 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, create new group directly", null);
                            dVar3.c(dVar3.f11178i, dVar3.f11179j);
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                        WifiP2pManager.Channel channel3 = dVar3.f11173b;
                        if (channel3 == null || (wifiP2pManager = dVar3.f11172a) == null) {
                            return;
                        }
                        wifiP2pManager.removeGroup(channel3, dVar3.f11186s);
                        return;
                }
            }
        };
        this.f11183n = new b(this, 3);
        this.q = new b(this, 5);
        final int i9 = 1;
        this.f11185r = new WifiP2pManager.GroupInfoListener(this) { // from class: ye.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f11166b;

            {
                this.f11166b = this;
            }

            @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
            public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                WifiP2pManager wifiP2pManager;
                switch (i9) {
                    case 0:
                        we.h.g("onGroupInfoAvailable");
                        d dVar = this.f11166b;
                        if (wifiP2pGroup == null) {
                            dVar.b(dVar.f11176g, dVar.f11177h, dVar.e, dVar.f11175d, dVar.f);
                            return;
                        }
                        we.h.i("Apps using Wi-Fi P2P channels are already turned off", null);
                        WifiP2pManager wifiP2pManager2 = dVar.f11172a;
                        if (wifiP2pManager2 != null) {
                            WifiP2pManager.Channel channel = dVar.f11173b;
                            Intrinsics.checkNotNull(channel);
                            wifiP2pManager2.removeGroup(channel, dVar.f11183n);
                            return;
                        }
                        return;
                    case 1:
                        we.h.g("onGroupInfoAvailable");
                        d dVar2 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, ignore", null);
                            g4 g4Var = dVar2.f11174c;
                            if (g4Var != null) {
                                h4 h4Var = g4Var.f9745a;
                                synchronized (g4Var) {
                                    h4.x(h4Var, 0, 30);
                                    Unit unit = Unit.INSTANCE;
                                }
                                return;
                            }
                            return;
                        }
                        if (!dVar2.a(wifiP2pGroup)) {
                            we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                            WifiP2pManager wifiP2pManager3 = dVar2.f11172a;
                            if (wifiP2pManager3 != null) {
                                WifiP2pManager.Channel channel2 = dVar2.f11173b;
                                Intrinsics.checkNotNull(channel2);
                                wifiP2pManager3.removeGroup(channel2, dVar2.q);
                                return;
                            }
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is has been removed already", null);
                        we.h.g("Removing persistent groups, nothing to do");
                        dVar2.f11179j = null;
                        dVar2.f11180k = null;
                        g4 g4Var2 = dVar2.f11174c;
                        if (g4Var2 != null) {
                            g4Var2.f();
                            return;
                        }
                        return;
                    default:
                        we.h.g("onGroupInfoAvailable, Creating Group");
                        d dVar3 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, create new group directly", null);
                            dVar3.c(dVar3.f11178i, dVar3.f11179j);
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                        WifiP2pManager.Channel channel3 = dVar3.f11173b;
                        if (channel3 == null || (wifiP2pManager = dVar3.f11172a) == null) {
                            return;
                        }
                        wifiP2pManager.removeGroup(channel3, dVar3.f11186s);
                        return;
                }
            }
        };
        this.f11186s = new b(this, 4);
        final int i10 = 2;
        this.f11187t = new WifiP2pManager.GroupInfoListener(this) { // from class: ye.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f11166b;

            {
                this.f11166b = this;
            }

            @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
            public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                WifiP2pManager wifiP2pManager;
                switch (i10) {
                    case 0:
                        we.h.g("onGroupInfoAvailable");
                        d dVar = this.f11166b;
                        if (wifiP2pGroup == null) {
                            dVar.b(dVar.f11176g, dVar.f11177h, dVar.e, dVar.f11175d, dVar.f);
                            return;
                        }
                        we.h.i("Apps using Wi-Fi P2P channels are already turned off", null);
                        WifiP2pManager wifiP2pManager2 = dVar.f11172a;
                        if (wifiP2pManager2 != null) {
                            WifiP2pManager.Channel channel = dVar.f11173b;
                            Intrinsics.checkNotNull(channel);
                            wifiP2pManager2.removeGroup(channel, dVar.f11183n);
                            return;
                        }
                        return;
                    case 1:
                        we.h.g("onGroupInfoAvailable");
                        d dVar2 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, ignore", null);
                            g4 g4Var = dVar2.f11174c;
                            if (g4Var != null) {
                                h4 h4Var = g4Var.f9745a;
                                synchronized (g4Var) {
                                    h4.x(h4Var, 0, 30);
                                    Unit unit = Unit.INSTANCE;
                                }
                                return;
                            }
                            return;
                        }
                        if (!dVar2.a(wifiP2pGroup)) {
                            we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                            WifiP2pManager wifiP2pManager3 = dVar2.f11172a;
                            if (wifiP2pManager3 != null) {
                                WifiP2pManager.Channel channel2 = dVar2.f11173b;
                                Intrinsics.checkNotNull(channel2);
                                wifiP2pManager3.removeGroup(channel2, dVar2.q);
                                return;
                            }
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is has been removed already", null);
                        we.h.g("Removing persistent groups, nothing to do");
                        dVar2.f11179j = null;
                        dVar2.f11180k = null;
                        g4 g4Var2 = dVar2.f11174c;
                        if (g4Var2 != null) {
                            g4Var2.f();
                            return;
                        }
                        return;
                    default:
                        we.h.g("onGroupInfoAvailable, Creating Group");
                        d dVar3 = this.f11166b;
                        if (wifiP2pGroup == null) {
                            we.h.i("Group info is null, create new group directly", null);
                            dVar3.c(dVar3.f11178i, dVar3.f11179j);
                            return;
                        }
                        we.h.i("Wi-Fi P2P Group is formed, remove group owner", null);
                        WifiP2pManager.Channel channel3 = dVar3.f11173b;
                        if (channel3 == null || (wifiP2pManager = dVar3.f11172a) == null) {
                            return;
                        }
                        wifiP2pManager.removeGroup(channel3, dVar3.f11186s);
                        return;
                }
            }
        };
    }

    public static Inet4Address d(WifiP2pGroup info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getInterface() == null) {
            String mes = "Could not obtain address of network interface " + info.getInterface() + " because it had no IPv4 addresses.";
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes, null);
            }
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName(info.getInterface());
            if (byName == null) {
                String mes2 = "Could not obtain network interface " + info.getInterface();
                Intrinsics.checkNotNullParameter(mes2, "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", mes2, null);
                }
                return null;
            }
            Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
            Intrinsics.checkNotNullExpressionValue(inetAddresses, "getInetAddresses(...)");
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (inetAddressNextElement instanceof Inet4Address) {
                    return (Inet4Address) inetAddressNextElement;
                }
            }
            String mes3 = "Could not obtain address of network interface " + info.getInterface() + " because it had no IPv4 addresses.";
            Intrinsics.checkNotNullParameter(mes3, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes3, null);
            }
            return null;
        } catch (NullPointerException e) {
            Intrinsics.checkNotNullParameter("Could not obtain address of network interface, null interface nameinterface not found", "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", "Could not obtain address of network interface, null interface nameinterface not found", null);
            }
            e.printStackTrace();
            return null;
        } catch (SocketException e4) {
            String mes4 = "Could not obtain address of network interface, socket exception" + info.getInterface();
            Intrinsics.checkNotNullParameter(mes4, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes4, null);
            }
            e4.printStackTrace();
            return null;
        }
    }

    public static Inet6Address e(WifiP2pGroup info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getInterface() == null) {
            String mes = "Could not obtain address of network interface " + info.getInterface() + " because it had no IPv6 addresses.";
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes, null);
            }
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName(info.getInterface());
            if (byName == null) {
                String mes2 = "Could not obtain network interface " + info.getInterface();
                Intrinsics.checkNotNullParameter(mes2, "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", mes2, null);
                }
                return null;
            }
            Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
            Intrinsics.checkNotNullExpressionValue(inetAddresses, "getInetAddresses(...)");
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (inetAddressNextElement instanceof Inet6Address) {
                    Inet6Address inet6Address = (Inet6Address) inetAddressNextElement;
                    if (inet6Address.isLinkLocalAddress()) {
                        return inet6Address;
                    }
                }
            }
            String mes3 = "Could not obtain address of network interface " + info.getInterface() + " because it had no IPv6 addresses.";
            Intrinsics.checkNotNullParameter(mes3, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes3, null);
            }
            return null;
        } catch (NullPointerException e) {
            Intrinsics.checkNotNullParameter("Could not obtain address of network interface, null interface nameinterface not found", "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", "Could not obtain address of network interface, null interface nameinterface not found", null);
            }
            e.printStackTrace();
            return null;
        } catch (SocketException e4) {
            String mes4 = "Could not obtain address of network interface, socket exception" + info.getInterface();
            Intrinsics.checkNotNullParameter(mes4, "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", mes4, null);
            }
            e4.printStackTrace();
            return null;
        }
    }

    public final boolean a(WifiP2pGroup wifiP2pGroup) {
        boolean z2 = this.f11180k != null ? !Intrinsics.areEqual(wifiP2pGroup.getInterface(), this.f11180k) : false;
        if (z2) {
            we.h.g("Group removed probably and replaced by new group, waiting state");
            return true;
        }
        i2 i2Var = this.f11179j;
        if (i2Var != null) {
            Intrinsics.checkNotNull(i2Var);
            if (i2Var.f9793a != null) {
                i2 i2Var2 = this.f11179j;
                z2 = !Intrinsics.areEqual(i2Var2 != null ? i2Var2.f9793a : null, wifiP2pGroup.getNetworkName());
            }
        }
        if (!z2) {
            return false;
        }
        we.h.g("Group removed probably and replaced by new group- creating state");
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: IllegalArgumentException -> 0x0027, TRY_LEAVE, TryCatch #0 {IllegalArgumentException -> 0x0027, blocks: (B:4:0x000f, B:7:0x0016, B:11:0x0022), top: B:28:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    public final void b(int i8, int i9, String str, String str2, String str3) {
        boolean zMatches;
        MacAddress macAddressFromString = MacAddress.fromString("02:00:00:00:00:00");
        Intrinsics.checkNotNullExpressionValue(macAddressFromString, "fromString(...)");
        MacAddress macAddressFromString2 = null;
        if (str3 != null) {
            try {
                zMatches = str3.length() == 0 ? false : Pattern.matches("^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$", str3);
                if (zMatches) {
                    if (str3 != null) {
                        macAddressFromString2 = MacAddress.fromString(str3);
                    } else {
                        macAddressFromString2 = macAddressFromString;
                    }
                }
            } catch (IllegalArgumentException e) {
                String mes = "Invalid MAC address: " + str3;
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", mes, e);
                }
            }
        } else {
            if (zMatches) {
                if (str3 != null) {
                    macAddressFromString2 = MacAddress.fromString(str3);
                } else {
                    macAddressFromString2 = macAddressFromString;
                }
            }
        }
        if (macAddressFromString2 != null) {
            macAddressFromString = macAddressFromString2;
        }
        if (i9 <= 0) {
            i9 = h.a(i8);
        }
        WifiP2pConfig.Builder builder = new WifiP2pConfig.Builder();
        Intrinsics.checkNotNull(str);
        WifiP2pConfig.Builder networkName = builder.setNetworkName(str);
        Intrinsics.checkNotNull(str2);
        WifiP2pConfig wifiP2pConfigBuild = networkName.setPassphrase(str2).setDeviceAddress(macAddressFromString).setGroupOperatingFrequency(i9).enablePersistentMode(false).build();
        Intrinsics.checkNotNullExpressionValue(wifiP2pConfigBuild, "build(...)");
        we.h.g("Connecting " + wifiP2pConfigBuild.getNetworkName());
        WifiP2pManager wifiP2pManager = this.f11172a;
        if (wifiP2pManager != null) {
            WifiP2pManager.Channel channel = this.f11173b;
            Intrinsics.checkNotNull(channel);
            wifiP2pManager.connect(channel, wifiP2pConfigBuild, new b(this, 0));
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x021b  */
    /* JADX WARN: Code duplicated, block: B:105:0x022e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0241  */
    /* JADX WARN: Code duplicated, block: B:114:0x024f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0287  */
    /* JADX WARN: Code duplicated, block: B:137:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0037 A[PHI: r9
      0x0037: PHI (r9v24 java.lang.Boolean) = (r9v13 java.lang.Boolean), (r9v16 java.lang.Boolean) binds: [B:21:0x0035, B:27:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x0052 A[PHI: r10
      0x0052: PHI (r10v23 java.lang.Boolean) = (r10v15 java.lang.Boolean), (r10v18 java.lang.Boolean) binds: [B:31:0x0050, B:37:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:6:0x0010 A[PHI: r8
      0x0010: PHI (r8v30 java.lang.Boolean) = (r8v22 java.lang.Boolean), (r8v25 java.lang.Boolean) binds: [B:5:0x000e, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:98:0x0211  */
    public final void c(List list, i2 i2Var) {
        int i8;
        int i9;
        MacAddress macAddressFromString;
        WifiP2pManager.Channel channel;
        WifiP2pManager wifiP2pManager;
        int iB;
        int i10;
        String str;
        String str2;
        String str3;
        MacAddress macAddress;
        String strG;
        String strSubstring;
        boolean zBooleanValue;
        boolean zBooleanValue2;
        boolean zBooleanValue3;
        WifiManager wifiManager;
        if (list == null) {
            i8 = 0;
        } else {
            Boolean boolValueOf = h.f11193c;
            if (boolValueOf == null) {
                WifiManager wifiManager2 = h.f11191a;
                boolValueOf = wifiManager2 != null ? Boolean.valueOf(wifiManager2.is5GHzBandSupported()) : null;
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else {
                    zBooleanValue = false;
                }
            } else {
                zBooleanValue = boolValueOf.booleanValue();
            }
            if (h.f11192b == null && (wifiManager = h.f11191a) != null) {
                wifiManager.is24GHzBandSupported();
            }
            Boolean boolValueOf2 = h.f11194d;
            if (boolValueOf2 == null) {
                WifiManager wifiManager3 = h.f11191a;
                boolValueOf2 = wifiManager3 != null ? Boolean.valueOf(wifiManager3.is6GHzBandSupported()) : null;
                if (boolValueOf2 != null) {
                    zBooleanValue2 = boolValueOf2.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
            } else {
                zBooleanValue2 = boolValueOf2.booleanValue();
            }
            Boolean boolValueOf3 = h.e;
            if (boolValueOf3 == null) {
                WifiManager wifiManager4 = h.f11191a;
                boolValueOf3 = wifiManager4 != null ? Boolean.valueOf(wifiManager4.is60GHzBandSupported()) : null;
                if (boolValueOf3 != null) {
                    zBooleanValue3 = boolValueOf3.booleanValue();
                } else {
                    zBooleanValue3 = false;
                }
            } else {
                zBooleanValue3 = boolValueOf3.booleanValue();
            }
            if ((list.contains("5G") && zBooleanValue) || ((list.contains("6G") && zBooleanValue2) || (list.contains("60G") && zBooleanValue3))) {
                i8 = 2;
            } else if ((!list.contains("5G") || zBooleanValue) && (list.contains("5G") || !zBooleanValue)) {
                i8 = 0;
            } else {
                i8 = 1;
            }
        }
        IntRange intRange = new IntRange(1, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(intRange));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            Character ch2 = (Character) CollectionsKt___CollectionsKt.random(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9')), Random.INSTANCE);
            ch2.getClass();
            arrayList.add(ch2);
        }
        String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        IntRange intRange2 = new IntRange(1, 16);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(intRange2));
        Iterator<Integer> it2 = intRange2.iterator();
        while (it2.hasNext()) {
            ((IntIterator) it2).nextInt();
            Character ch3 = (Character) CollectionsKt___CollectionsKt.random(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9')), Random.INSTANCE);
            ch3.getClass();
            arrayList2.add(ch3);
        }
        String strK = h0.a.k("DIRECT-", strJoinToString$default, "-", CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "", null, null, 0, null, null, 62, null));
        String strG2 = h.g(16);
        if (i2Var != null) {
            int iA = i2Var.f9798h;
            if (iA == 0) {
                if (h.f(i2Var.f9795c)) {
                    iA = h.a(i2Var.f9795c);
                    we.h.g("p2pInfo fixed channel mode for 2.4G or 5G, freq is " + iA);
                    i9 = iA;
                    i10 = 0;
                    str = i2Var.f9793a;
                    if (str != null && str.length() != 0 && (strSubstring = i2Var.f9793a) != null) {
                        if (strSubstring.length() > 32) {
                            Intrinsics.checkNotNullParameter("ssid length is too long, use first 32 characters instead", "mes");
                            if (lb.f6529c >= 2) {
                                Log.w("welinkBLE", "ssid length is too long, use first 32 characters instead", null);
                            }
                            strSubstring = strSubstring.substring(0, 32);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        }
                        strK = strSubstring;
                    }
                    str2 = i2Var.f9794b;
                    if (str2 != null && str2.length() != 0 && (strG = i2Var.f9794b) != null) {
                        if (strG.length() < 8) {
                            strG = h.g(8);
                            Intrinsics.checkNotNullParameter("password length is illegal, use random password instead", "mes");
                            if (lb.f6529c >= 2) {
                                Log.w("welinkBLE", "password length is illegal, use random password instead", null);
                            }
                        }
                        strG2 = strG;
                    }
                    str3 = i2Var.f9796d;
                    if (str3 != null) {
                        try {
                            try {
                                Intrinsics.checkNotNull(str3);
                                macAddressFromString = MacAddress.fromString(str3);
                                we.h.g("p2pInfo bssid is " + macAddressFromString);
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                macAddress = null;
                                we.h.d("p2pInfo bssid is illegal, use null instead", null);
                                we.h.g("p2pInfo bssid is null");
                                macAddressFromString = macAddress;
                                i8 = i10;
                                WifiP2pConfig wifiP2pConfigBuild = new WifiP2pConfig.Builder().setNetworkName(strK).setPassphrase(strG2).enablePersistentMode(false).setGroupOperatingBand(i8).setGroupOperatingFrequency(i9).setDeviceAddress(macAddressFromString).build();
                                Intrinsics.checkNotNullExpressionValue(wifiP2pConfigBuild, "build(...)");
                                channel = this.f11173b;
                                if (channel != null) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            i8 = i10;
                        } catch (Throwable th2) {
                            we.h.g("p2pInfo bssid is null");
                            throw th2;
                        }
                    } else {
                        macAddress = null;
                    }
                    macAddressFromString = macAddress;
                    i8 = i10;
                } else {
                    int i11 = i2Var.f9795c;
                    if (i11 == 2400 || i11 == 5000) {
                        iB = h.b(i11);
                        we.h.g("p2pInfo auto channel for 2.4G or 5G mode, band is: " + (i2Var.f9795c / 1000) + " band");
                        i10 = iB;
                    } else {
                        we.h.g("p2pInfo auto band and channel for 2.4G or 5G");
                        i10 = 0;
                    }
                    i9 = 0;
                    str = i2Var.f9793a;
                    if (str != null) {
                        if (strSubstring.length() > 32) {
                            Intrinsics.checkNotNullParameter("ssid length is too long, use first 32 characters instead", "mes");
                            if (lb.f6529c >= 2) {
                                Log.w("welinkBLE", "ssid length is too long, use first 32 characters instead", null);
                            }
                            strSubstring = strSubstring.substring(0, 32);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        }
                        strK = strSubstring;
                    }
                    str2 = i2Var.f9794b;
                    if (str2 != null) {
                        if (strG.length() < 8) {
                            strG = h.g(8);
                            Intrinsics.checkNotNullParameter("password length is illegal, use random password instead", "mes");
                            if (lb.f6529c >= 2) {
                                Log.w("welinkBLE", "password length is illegal, use random password instead", null);
                            }
                        }
                        strG2 = strG;
                    }
                    str3 = i2Var.f9796d;
                    if (str3 != null) {
                        Intrinsics.checkNotNull(str3);
                        macAddressFromString = MacAddress.fromString(str3);
                        we.h.g("p2pInfo bssid is " + macAddressFromString);
                        i8 = i10;
                    } else {
                        macAddress = null;
                    }
                    macAddressFromString = macAddress;
                    i8 = i10;
                }
            } else if (h.c(iA) != 0) {
                we.h.g("p2pInfo fixed freq mode for 5G or 6G or 60G, freq is " + iA);
                i9 = iA;
                i10 = 0;
                str = i2Var.f9793a;
                if (str != null) {
                    if (strSubstring.length() > 32) {
                        Intrinsics.checkNotNullParameter("ssid length is too long, use first 32 characters instead", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "ssid length is too long, use first 32 characters instead", null);
                        }
                        strSubstring = strSubstring.substring(0, 32);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                    strK = strSubstring;
                }
                str2 = i2Var.f9794b;
                if (str2 != null) {
                    if (strG.length() < 8) {
                        strG = h.g(8);
                        Intrinsics.checkNotNullParameter("password length is illegal, use random password instead", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "password length is illegal, use random password instead", null);
                        }
                    }
                    strG2 = strG;
                }
                str3 = i2Var.f9796d;
                if (str3 != null) {
                    Intrinsics.checkNotNull(str3);
                    macAddressFromString = MacAddress.fromString(str3);
                    we.h.g("p2pInfo bssid is " + macAddressFromString);
                    i8 = i10;
                } else {
                    macAddress = null;
                }
                macAddressFromString = macAddress;
                i8 = i10;
            } else {
                iB = h.b(0);
                Intrinsics.checkNotNullParameter("p2pInfo freq is invalid, use auto band and channel", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", "p2pInfo freq is invalid, use auto band and channel", null);
                }
                i10 = iB;
                i9 = 0;
                str = i2Var.f9793a;
                if (str != null) {
                    if (strSubstring.length() > 32) {
                        Intrinsics.checkNotNullParameter("ssid length is too long, use first 32 characters instead", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "ssid length is too long, use first 32 characters instead", null);
                        }
                        strSubstring = strSubstring.substring(0, 32);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                    strK = strSubstring;
                }
                str2 = i2Var.f9794b;
                if (str2 != null) {
                    if (strG.length() < 8) {
                        strG = h.g(8);
                        Intrinsics.checkNotNullParameter("password length is illegal, use random password instead", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "password length is illegal, use random password instead", null);
                        }
                    }
                    strG2 = strG;
                }
                str3 = i2Var.f9796d;
                if (str3 != null) {
                    Intrinsics.checkNotNull(str3);
                    macAddressFromString = MacAddress.fromString(str3);
                    we.h.g("p2pInfo bssid is " + macAddressFromString);
                    i8 = i10;
                } else {
                    macAddress = null;
                }
                macAddressFromString = macAddress;
                i8 = i10;
            }
        } else {
            we.h.g("p2pInfo is null, use default config");
            i9 = 0;
            this.f11179j = new i2(strK, strG2, 0, null, 0, 0, null, 0);
            macAddressFromString = null;
        }
        WifiP2pConfig wifiP2pConfigBuild2 = new WifiP2pConfig.Builder().setNetworkName(strK).setPassphrase(strG2).enablePersistentMode(false).setGroupOperatingBand(i8).setGroupOperatingFrequency(i9).setDeviceAddress(macAddressFromString).build();
        Intrinsics.checkNotNullExpressionValue(wifiP2pConfigBuild2, "build(...)");
        channel = this.f11173b;
        if (channel != null || (wifiP2pManager = this.f11172a) == null) {
            return;
        }
        wifiP2pManager.createGroup(channel, wifiP2pConfigBuild2, new b(this, 1));
    }

    public final void f() {
        we.h.g("Removing persistent groups, nothing to do");
        WifiP2pManager.Channel channel = this.f11173b;
        if (channel != null) {
            WifiP2pManager wifiP2pManager = this.f11172a;
            if (wifiP2pManager != null) {
                wifiP2pManager.requestGroupInfo(channel, this.f11185r);
            }
        } else {
            Intrinsics.checkNotNullParameter("P2P may be disconnected already", "mes");
            if (lb.f6529c >= 2) {
                Log.w("welinkBLE", "P2P may be disconnected already", null);
            }
        }
        if (this.f11184o != 0) {
            this.f11184o = 0;
            this.f11180k = null;
            this.f11179j = null;
            this.p = null;
        }
    }
}
