package u7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.RemoteException;
import android.util.Log;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import li.g2;
import na.m;
import na.n;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10406b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10407c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10408d = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static g2 f10410h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10405a = new e();
    public static final Lazy e = LazyKt.lazy(new ob.c(14));
    public static final AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f10409g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicBoolean f10411i = new AtomicBoolean(true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f10412j = LazyKt.lazy(new ob.c(15));

    public static b d() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        Lazy lazy = e;
        ConnectivityManager connectivityManager2 = (ConnectivityManager) lazy.getValue();
        Network activeNetwork = connectivityManager2 != null ? connectivityManager2.getActiveNetwork() : null;
        ConnectivityManager connectivityManager3 = (ConnectivityManager) lazy.getValue();
        if (connectivityManager3 != null && (networkCapabilities = connectivityManager3.getNetworkCapabilities(activeNetwork)) != null && ((networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0)) && (connectivityManager = (ConnectivityManager) lazy.getValue()) != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null)) {
            String strN = o.d.n("interface: ", linkProperties.getInterfaceName(), "NetworkSharingManager", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("NetworkSharingManager"), strN);
            }
            String interfaceName = linkProperties.getInterfaceName();
            if (interfaceName == null) {
                interfaceName = "";
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            Intrinsics.checkNotNullExpressionValue(dnsServers, "getDnsServers(...)");
            for (InetAddress inetAddress : dnsServers) {
                String log = "dns server: " + inetAddress.getHostAddress() + ", local:" + inetAddress.isLinkLocalAddress();
                Intrinsics.checkNotNullParameter("NetworkSharingManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("NetworkSharingManager"), log);
                }
                String hostAddress = inetAddress.getHostAddress();
                if (hostAddress == null) {
                    hostAddress = "";
                }
                if (StringsKt__StringsKt.contains$default((CharSequence) StringsKt__StringsKt.trim((CharSequence) hostAddress).toString(), '.', false, 2, (Object) null)) {
                    return new b(hostAddress, interfaceName);
                }
            }
        }
        return null;
    }

    public static boolean e(boolean z2, boolean z3) {
        if (z3 && (StringsKt__StringsKt.trim((CharSequence) f10407c).toString().length() <= 0 || StringsKt__StringsKt.trim((CharSequence) f10408d).toString().length() <= 0 || StringsKt__StringsKt.trim((CharSequence) f10406b).toString().length() <= 0)) {
            String str = f10408d;
            String str2 = f10407c;
            String str3 = f10406b;
            StringBuilder sbP = h0.a.p("setupHotpot param error:up:", str, ",dns:", str2, ",down:");
            sbP.append(str3);
            String log = sbP.toString();
            Intrinsics.checkNotNullParameter("NetworkSharingManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("NetworkSharingManager"), log);
            }
            return false;
        }
        String str4 = f10408d;
        String str5 = f10407c;
        String str6 = f10406b;
        String str7 = z2 ? "1" : "0";
        String strConcat = "network ipfwdEnableForwarding iotservice ".concat(str7);
        gc.c("NetworkSharingManager", "startCmd:" + strConcat);
        String str8 = "network tetherAddForward " + str6 + " " + str4 + " " + str7;
        gc.c("NetworkSharingManager", "tetherCmd:" + str8);
        String str9 = "network enableNatPortforward " + str6 + " 53 " + str5 + " 53 udp " + str7;
        gc.c("NetworkSharingManager", "natPortFwdCmd:" + str9);
        String strConcat2 = "network enableIpPortforward 192.168.137.0 53 udp ".concat(str7);
        gc.c("NetworkSharingManager", "ipPortFwdCmd:" + strConcat2);
        String str10 = "network ipfwdAddInterfaceForward " + str6 + " " + str4 + " " + str7;
        gc.c("NetworkSharingManager", "ipFwdCmd:" + str10);
        Integer numA = m.a(strConcat);
        if (numA == null || numA.intValue() != 0) {
            gc.a("NetworkSharingManager", "Set Ipforward failed");
            return false;
        }
        m.d("all", str7);
        m.d(str6, str7);
        m.d(str4, str7);
        Integer numA2 = m.a(str8);
        if (numA2 == null || numA2.intValue() != 0) {
            gc.a("NetworkSharingManager", "Set tetherAddForward failed");
            return false;
        }
        Integer numA3 = m.a(str9);
        if (numA3 == null || numA3.intValue() != 0) {
            gc.a("NetworkSharingManager", "Set enableNatPortforward failed");
            return false;
        }
        Integer numA4 = m.a(strConcat2);
        if (numA4 == null || numA4.intValue() != 0) {
            gc.a("NetworkSharingManager", "Set enableIpPortforward failed");
            return false;
        }
        Integer numA5 = m.a(str10);
        if (numA5 != null && numA5.intValue() == 0) {
            return true;
        }
        gc.a("NetworkSharingManager", "Set ipfwdAddInterfaceForward failed");
        return false;
    }

    public static boolean f(boolean z2) {
        String strO = o.d.o("usbHotpotSetup:", z2, "NetworkSharingManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("NetworkSharingManager"), strO);
        }
        Context applicationContext = pb.a().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return n.a(applicationContext, z2);
    }

    public final void a() {
        f.compareAndSet(true, false);
        boolean zAreEqual = Intrinsics.areEqual("usb", f10406b);
        AtomicBoolean atomicBoolean = f10409g;
        if (zAreEqual && f(false)) {
            atomicBoolean.compareAndSet(true, false);
            return;
        }
        gc.a("NetworkSharingManager", "disableNetworkSharing");
        gc.a("NetworkSharingManager", "upLinkDNSAddress" + f10407c);
        gc.a("NetworkSharingManager", "upLinkInterfaceName" + f10408d + " ");
        gc.a("NetworkSharingManager", "downLinkInterfaceName ".concat(f10406b));
        if (e(false, true)) {
            atomicBoolean.compareAndSet(true, false);
            Lazy lazy = a.f10398a;
            ConnectivityManager.NetworkCallback networkCallback = (ConnectivityManager.NetworkCallback) f10412j.getValue();
            Intrinsics.checkNotNullParameter(networkCallback, "networkCallback");
            Log.d("NetWorkUtils", "unregisterNetWorkChangeCallBack:" + networkCallback);
            ConcurrentLinkedQueue concurrentLinkedQueue = a.f10399b;
            if (concurrentLinkedQueue.contains(networkCallback)) {
                concurrentLinkedQueue.remove(networkCallback);
            }
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                AtomicBoolean atomicBoolean = f10409g;
                if (atomicBoolean.get()) {
                    f10405a.a();
                    atomicBoolean.compareAndSet(true, false);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c() {
        if (!f10411i.get()) {
            return false;
        }
        try {
            b bVarD = d();
            if (bVarD == null) {
                return false;
            }
            f10407c = bVarD.getIp();
            f10408d = bVarD.getName();
            if (!e(true, true)) {
                return false;
            }
            f10409g.compareAndSet(false, true);
            return true;
        } catch (RemoteException e4) {
            Intrinsics.checkNotNullParameter("NetworkSharingManager", "tag");
            Intrinsics.checkNotNullParameter(e4, "e");
            Log.e(gc.f6463b.concat("NetworkSharingManager"), e4.getMessage(), e4);
            return false;
        }
    }
}
