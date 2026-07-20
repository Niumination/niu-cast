package se;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.TranWifiController$mBroadcastReceiver$1;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import se.k6;

/* JADX INFO: loaded from: classes3.dex */
public final class k6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u0 f9842g = new u0(j6.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiManager f9844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public lc.a f9845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9846d = new Object();
    public boolean e;
    public final TranWifiController$mBroadcastReceiver$1 f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.BroadcastReceiver, com.welink.protocol.nfbd.TranWifiController$mBroadcastReceiver$1] */
    public k6(Context context) {
        this.f9843a = context;
        ?? r7 = new BroadcastReceiver() { // from class: com.welink.protocol.nfbd.TranWifiController$mBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Context applicationContext;
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.net.wifi.SCAN_RESULTS")) {
                    Context context3 = this.f3986a.f9843a;
                    if (context3 == null || (applicationContext = context3.getApplicationContext()) == null || applicationContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                        we.h.a("No permission to get wifi scan results");
                        return;
                    }
                    WifiManager wifiManager = this.f3986a.f9844b;
                    List<ScanResult> scanResults = wifiManager != null ? wifiManager.getScanResults() : null;
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            DeviceInfo deviceInfo = new DeviceInfo((byte) 11, (byte) -1, "4657", scanResult.BSSID, Boolean.FALSE, (EarBudsInfo) null, 2, -1, 0, -1, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                            k6 k6Var = this.f3986a;
                            synchronized (k6Var.f9846d) {
                                lc.a aVar = k6Var.f9845c;
                                if (aVar != null) {
                                    Intrinsics.checkNotNull(scanResult);
                                    aVar.invoke(scanResult, deviceInfo);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                }
            }
        };
        this.f = r7;
        Object systemService = context != 0 ? context.getSystemService("wifi") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.f9844b = (WifiManager) systemService;
        if (context != 0) {
            context.registerReceiver(r7, new IntentFilter("android.net.wifi.SCAN_RESULTS"), 2);
        }
        this.e = true;
    }
}
