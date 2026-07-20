package se;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b5 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u0 f9660g = new u0(z4.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f9661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.welink.protocol.nfbd.z f9662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9663c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f9664d = new LinkedHashMap();
    public final LinkedHashMap e = new LinkedHashMap();
    public sb.a f;

    public b5(Context context) {
        a5 a5Var = new a5(this);
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        Object systemService2 = context.getApplicationContext().getSystemService("wifip2p");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
        Object systemService3 = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService3;
        this.f9661a = connectivityManager;
        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), a5Var);
        }
        u0 u0Var = com.welink.protocol.nfbd.z.f4202l;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f9662b = (com.welink.protocol.nfbd.z) u0Var.b(applicationContext);
    }
}
