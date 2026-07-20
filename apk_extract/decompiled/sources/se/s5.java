package se;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.lb;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s5 implements NsdManager.DiscoveryListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b6 f9977b;

    public s5(b6 b6Var, String mServiceType) {
        Intrinsics.checkNotNullParameter(mServiceType, "mServiceType");
        this.f9977b = b6Var;
        this.f9976a = mServiceType;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStarted(String serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        b6 b6Var = this.f9977b;
        b6Var.f9670j.put(serviceType, Boolean.TRUE);
        b6Var.f9671k.add(this);
        tj.w wVar = b6Var.q;
        if (wVar != null) {
            we.h.b("NearLanManager", "onDiscoverStarted");
            ((com.welink.protocol.nfbd.m) wVar.f10262b).f4181o = true;
        }
        o.d.z("onDiscoveryStarted, serviceType: ", serviceType, "TranLanController");
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStopped(String serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        b6 b6Var = this.f9977b;
        b6Var.f9670j.remove(serviceType);
        b6Var.f9671k.remove(this);
        tj.w wVar = b6Var.q;
        if (wVar != null) {
            we.h.b("NearLanManager", "onDiscoverStopped");
            ((com.welink.protocol.nfbd.m) wVar.f10262b).f4181o = false;
        }
        o.d.z("onDiscoveryStopped, serviceType: ", serviceType, "TranLanController");
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceFound(NsdServiceInfo service) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(service, "service");
        we.h.b("TranLanController", "Service Found: " + service);
        String serviceType = service.getServiceType();
        Intrinsics.checkNotNullExpressionValue(serviceType, "getServiceType(...)");
        if (!StringsKt__StringsKt.contains$default(serviceType, this.f9976a, false, 2, (Object) null)) {
            we.h.j("TranLanController", "Found service Type not match: " + service.getServiceType());
            return;
        }
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        b6 b6Var = this.f9977b;
        Context context = b6Var.f9665c;
        byte[] bArrM = ne.b.m();
        if (bArrM != null) {
            Intrinsics.checkNotNullParameter(bArrM, "<this>");
            Intrinsics.checkNotNullParameter("", "separator");
            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
        } else {
            strJoinToString$default = null;
        }
        String strI = h0.a.i("transConnectService-", strJoinToString$default);
        String serviceType2 = service.getServiceType();
        Intrinsics.checkNotNullExpressionValue(serviceType2, "getServiceType(...)");
        if (!new Regex(".*_tran[^.]*\\._tcp.*").matches(serviceType2)) {
            String serviceType3 = service.getServiceType();
            Intrinsics.checkNotNullExpressionValue(serviceType3, "getServiceType(...)");
            if (!new Regex(".*_tran[^.]*\\._udp.*").matches(serviceType3)) {
                o.d.z("Unknown Service Type: ", service.getServiceType(), "TranLanController");
                return;
            }
        }
        if (!Intrinsics.areEqual(service.getServiceName(), b6Var.f9672l)) {
            String serviceName = service.getServiceName();
            Intrinsics.checkNotNullExpressionValue(serviceName, "getServiceName(...)");
            if (!StringsKt__StringsKt.contains(serviceName, (CharSequence) strI, true)) {
                String serviceName2 = service.getServiceName();
                Intrinsics.checkNotNullExpressionValue(serviceName2, "getServiceName(...)");
                if (StringsKt__StringsKt.contains$default(serviceName2, "transConnectService", false, 2, (Object) null)) {
                    o.d.z("Resolve Service Name: ", service.getServiceName(), "TranLanController");
                    int i8 = Build.VERSION.SDK_INT;
                    ConcurrentLinkedQueue concurrentLinkedQueue = b6Var.f9673m;
                    if (i8 >= 34) {
                        concurrentLinkedQueue.add(new v5(service, null, new u5(b6Var, service)));
                    } else {
                        concurrentLinkedQueue.add(new v5(service, new t5(b6Var), null));
                    }
                    b6.k(b6Var);
                    return;
                }
                return;
            }
        }
        o.d.z("Same machine: ", b6Var.f9672l, "TranLanController");
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        o.d.z("Service Lost: ", nsdServiceInfo != null ? nsdServiceInfo.getServiceName() : null, "TranLanController");
        b6.j(this.f9977b, nsdServiceInfo);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStartDiscoveryFailed(String str, int i8) {
        Intrinsics.checkNotNullParameter("TranLanController", "tag");
        Intrinsics.checkNotNullParameter("onStartDiscoveryFailed", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranLanController", "TransConnect:onStartDiscoveryFailed", null);
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStopDiscoveryFailed(String str, int i8) {
        Intrinsics.checkNotNullParameter("TranLanController", "tag");
        Intrinsics.checkNotNullParameter("onStopDiscoveryFailed", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranLanController", "TransConnect:onStopDiscoveryFailed", null);
        }
    }
}
