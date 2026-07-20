package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k3.lb;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import se.h5;
import se.k5;
import se.k6;
import se.r6;
import se.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends we.g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u0 f4202l = new u0(k5.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h5 f4203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f4204d;
    public final k6 e;
    public r6 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1 f4205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1 f4206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f4207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f4208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f4209k;

    public z(Context context) {
        super(false, "NearConnectionHandler");
        this.f4208j = new HashMap();
        this.f4204d = (m) m.f4170t.b(context);
        this.e = (k6) k6.f9842g.b(context);
        g gVar = (g) g.L.a(context, this);
        this.f4207i = gVar;
        this.f4203c = gVar != null ? gVar.f4115g : null;
        this.f4209k = MapsKt.mapOf(TuplesKt.to(0, "Oraimo"), TuplesKt.to(1, "Syinix"), TuplesKt.to(2, "itel"), TuplesKt.to(3, "TECNO"), TuplesKt.to(4, "Infinix"), TuplesKt.to(5, "Boomplay"), TuplesKt.to(6, "TECNO Mobile"), TuplesKt.to(248, "Apple"), TuplesKt.to(249, "Hasee"), TuplesKt.to(Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "Asus"), TuplesKt.to(251, "HP"), TuplesKt.to(252, "Dell"), TuplesKt.to(253, "Lenovo"), TuplesKt.to(254, "ThinkPad"));
    }

    public final void j(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        f(new o.e(8, this, intent));
    }

    public final void k(boolean z2) {
        Intent intent = new Intent();
        intent.setAction("com.welink.protocol.nfbd.action.ACTION_UPDATE_CON_STATE");
        intent.putExtra("STATE", z2);
        g gVar = this.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
    }

    public final void l(int i8, BluetoothDevice device, NearDevice nearDevice) {
        DeviceInfo deviceInfo;
        String name;
        Intrinsics.checkNotNullParameter(device, "device");
        TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 18, i8, 0, 0, nearDevice != null ? new NearDeviceDataParcel(nearDevice, device) : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            deviceInfo = new DeviceInfo(h.e(nearDevice.f3889j), h.g(nearDevice.h()), device.getName(), device.getAddress(), (Boolean) null, (EarBudsInfo) null, 0, h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096640);
        } else {
            deviceInfo = new DeviceInfo((byte) 0, (byte) 0, (String) null, device.getAddress(), (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        }
        DeviceInfo deviceInfo2 = deviceInfo;
        if (nearDevice == null || (name = nearDevice.f3884b) == null) {
            name = device.getName();
        }
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, name, 18, deviceInfo2, tranConnectionController$EventInfo, new NearDeviceDataParcel(device, nearDevice));
        we.h.h("TranConnectionManager", "Gatt Client Connected");
        q(tranConnectionController$MessageInfo, nearDevice);
    }

    public final void m(int i8, BluetoothDevice device, NearDevice nearDevice) {
        DeviceInfo deviceInfo;
        String str;
        Intrinsics.checkNotNullParameter(device, "device");
        TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 19, i8, 0, 0, nearDevice != null ? new NearDeviceDataParcel(nearDevice, device) : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            deviceInfo = new DeviceInfo(h.e(nearDevice.f3889j), h.g(nearDevice.h()), device.getName(), device.getAddress(), (Boolean) null, (EarBudsInfo) null, 0, h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        } else {
            deviceInfo = new DeviceInfo((byte) 0, (byte) 0, (String) null, device.getAddress(), (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        }
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, (nearDevice == null || (str = nearDevice.f3884b) == null) ? device.getName() : str, 19, deviceInfo, tranConnectionController$EventInfo, new NearDeviceDataParcel(device, nearDevice));
        we.h.h("TranConnectionManager", "Gatt Client Disconnected");
        q(tranConnectionController$MessageInfo, nearDevice);
    }

    public final void n(String str, String str2, NearDevice nearDevice) {
        DeviceInfo deviceInfo;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(str, 32, 0, 0, 0, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            deviceInfo = new DeviceInfo(h.e(nearDevice.f3889j), h.g(nearDevice.h()), nearDevice.r(), (String) null, (Boolean) null, (EarBudsInfo) null, 10, h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096640);
        } else {
            deviceInfo = new DeviceInfo((byte) 0, (byte) 0, (String) null, (String) null, (Boolean) null, (EarBudsInfo) null, 10, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        }
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(str2, 0, 0, null, 32, deviceInfo, tranConnectionController$EventInfo, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
        we.h.h("TranConnectionManager", "Lan connected");
        q(tranConnectionController$MessageInfo, nearDevice);
    }

    public final void o(String remoteAddress, String str, NearDevice nearDevice, int i8) {
        DeviceInfo deviceInfo;
        String str2;
        Intrinsics.checkNotNullParameter(remoteAddress, "remoteAddress");
        TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(remoteAddress, 33, i8, 0, 0, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            deviceInfo = new DeviceInfo(h.e(nearDevice.f3889j), h.g(nearDevice.h()), nearDevice.r(), (String) null, (Boolean) null, (EarBudsInfo) null, 10, h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        } else {
            deviceInfo = new DeviceInfo((byte) 0, (byte) 0, (String) null, (String) null, (Boolean) null, (EarBudsInfo) null, 10, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
        }
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(str, 0, 0, (nearDevice == null || (str2 = nearDevice.f3884b) == null) ? remoteAddress : str2, 33, deviceInfo, tranConnectionController$EventInfo, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
        we.h.h("TranConnectionManager", "Lan disconnected");
        q(tranConnectionController$MessageInfo, nearDevice);
    }

    public final void p(NearDevice nearDevice, Function1 function1, boolean z2) {
        HashMap map = this.f4208j;
        if (map.get(Integer.valueOf(nearDevice != null ? nearDevice.hashCode() : 0)) != null) {
            map.remove(Integer.valueOf(nearDevice != null ? nearDevice.hashCode() : 0));
        }
        map.put(Integer.valueOf(nearDevice != null ? nearDevice.hashCode() : 0), function1);
        if (z2) {
            this.f4205g = function1;
            this.f4206h = null;
            we.h.b("TranConnectionManager", "onDeviceUpdateCallback: connect mode");
        } else {
            this.f4206h = function1;
            this.f4205g = null;
            we.h.b("TranConnectionManager", "onDeviceUpdateCallback: disconnect mode");
        }
    }

    public final void q(TranConnectionController$MessageInfo tranConnectionController$MessageInfo, NearDevice nearDevice) {
        Function1 function1 = nearDevice != null ? (Function1) this.f4208j.get(Integer.valueOf(nearDevice.hashCode())) : null;
        if (function1 != null) {
            function1.invoke(tranConnectionController$MessageInfo);
            return;
        }
        Function1 function2 = this.f4205g;
        if (function2 != null) {
            function2.invoke(tranConnectionController$MessageInfo);
            return;
        }
        Function1 function3 = this.f4206h;
        if (function3 != null) {
            function3.invoke(tranConnectionController$MessageInfo);
            return;
        }
        r6 r6Var = this.f;
        if (r6Var != null) {
            r6Var.invoke(tranConnectionController$MessageInfo);
            return;
        }
        Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("Not found any registered callback for NearDeviceEventNotify", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranConnectionManager", "TransConnect:Not found any registered callback for NearDeviceEventNotify", null);
        }
    }

    public final void r(int i8) {
        Intent intent = new Intent();
        intent.setAction("com.welink.protocol.nfbd.action.DISCONNECT_RESET_CONN");
        intent.putExtra("TRANDIR", i8);
        g gVar = this.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
    }
}
