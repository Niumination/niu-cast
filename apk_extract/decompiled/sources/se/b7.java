package se;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b7 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c7 f9679a;

    public b7(c7 c7Var) {
        this.f9679a = c7Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        we.h.g("onReceive : " + action);
        boolean zAreEqual = Intrinsics.areEqual(action, "android.bluetooth.adapter.action.STATE_CHANGED");
        c7 c7Var = this.f9679a;
        if (zAreEqual) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            we.h.g("BT state change " + intExtra + " -> " + intExtra2);
            if (intExtra == 12) {
                c7Var.b(2);
                return;
            }
            if (intExtra2 == 12) {
                boolean z2 = c7Var.f9696d;
                WifiManager wifiManager = c7Var.f9695c;
                Intrinsics.checkNotNull(wifiManager);
                boolean zIsWifiEnabled = wifiManager.isWifiEnabled();
                we.h.g("isSmartConnectEnable : " + z2 + " isWifiEnable : " + zIsWifiEnabled);
                if (z2 && zIsWifiEnabled) {
                    c7Var.a(2);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, "android.net.wifi.WIFI_STATE_CHANGED")) {
            int intExtra3 = intent.getIntExtra("previous_wifi_state", 4);
            int intExtra4 = intent.getIntExtra("wifi_state", 4);
            we.h.g("WIFI state change " + intExtra3 + " -> " + intExtra4);
            if (intExtra3 == 3) {
                c7Var.b(4);
                return;
            }
            if (intExtra4 == 3) {
                boolean z3 = c7Var.f9696d;
                BluetoothAdapter bluetoothAdapter = c7Var.f9694b;
                Intrinsics.checkNotNull(bluetoothAdapter);
                boolean zIsEnabled = bluetoothAdapter.isEnabled();
                we.h.g("isSmartConnectEnable : " + z3 + " isBluetoothEnable : " + zIsEnabled);
                if (z3 && zIsEnabled) {
                    c7Var.a(4);
                }
            }
        }
    }
}
