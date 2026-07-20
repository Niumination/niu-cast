package se;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a7 extends FunctionReferenceImpl implements Function1 {
    public static final a7 INSTANCE = new a7();

    public a7() {
        super(1, c7.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final c7 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        c7 c7Var = new c7();
        c7Var.f9693a = p0;
        ArrayList arrayList = i6.f9809a;
        p0.getApplicationContext();
        i6.f9809a.add(com.welink.protocol.nfbd.g.class);
        b7 b7Var = new b7(c7Var);
        c7Var.f9694b = BluetoothAdapter.getDefaultAdapter();
        Object systemService = p0.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        c7Var.f9695c = (WifiManager) systemService;
        c7Var.f9696d = false;
        u0 u0Var = com.welink.protocol.nfbd.z.f4202l;
        Context applicationContext = p0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        c7Var.e = (com.welink.protocol.nfbd.z) u0Var.b(applicationContext);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        p0.registerReceiver(b7Var, intentFilter, 2);
        return c7Var;
    }
}
