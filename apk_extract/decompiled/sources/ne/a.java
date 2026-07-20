package ne;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Intent;
import java.util.Iterator;
import k3.lb;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import se.g1;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AdvertiseCallback {
    @Override // android.bluetooth.le.AdvertiseCallback
    public final void onStartFailure(int i8) {
        String str;
        super.onStartFailure(i8);
        if (i8 == 1) {
            b.f8191k = false;
            str = "ADVERTISE_Failed_DATA_TOO_LARGE";
        } else if (i8 == 2) {
            b.f8191k = false;
            str = "ADVERTISE_Failed_TOO_MANY_ADVERTISERS";
        } else if (i8 == 3) {
            if (!b.f8191k) {
                b.f8191k = true;
            }
            str = "ADVERTISE_Failed_ALREADY_STARTED";
        } else if (i8 == 4) {
            b.f8191k = false;
            str = "ADVERTISE_Failed_INTERNAL_ERROR";
        } else if (i8 != 5) {
            b.f8191k = false;
            str = "unkNown";
        } else {
            b.f8191k = false;
            str = "ADVERTISE_Failed_FEATURE_UNSUPPORTED";
        }
        BluetoothAdapter bluetoothAdapter = b.f8183a;
        b.s(i8);
        String mes = "Advertising start failed, reason = ".concat(str);
        Intrinsics.checkNotNullParameter("AdvertiseTool", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, "AdvertiseTool", null);
        }
        b.a();
    }

    @Override // android.bluetooth.le.AdvertiseCallback
    public final void onStartSuccess(AdvertiseSettings settingsInEffect) {
        Intrinsics.checkNotNullParameter(settingsInEffect, "settingsInEffect");
        super.onStartSuccess(settingsInEffect);
        h.g("Advertising start successfully");
        Iterator it = b.e.iterator();
        while (it.hasNext()) {
            com.welink.protocol.nfbd.g gVar = ((g1) ((Pair) it.next()).getSecond()).f9742a;
            gVar.getClass();
            gVar.f4112b.j(new Intent("com.welink.service.ACTION_NEAR_DEVICE_ADVERTISE_START_SUCCESS"));
        }
        b.f8191k = true;
        b.a();
    }
}
