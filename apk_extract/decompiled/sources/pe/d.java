package pe;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.transsion.message.bank.MessageBank;
import com.welink.protocol.libspp.BluetoothConnection$mBluetoothConnectionReceiver$1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.UUID;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pe.d;
import se.l0;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends we.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UUID f8800d;
    public final LinkedHashSet e;
    public a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f8801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f8802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f8803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BluetoothDevice f8804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BluetoothDevice f8805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8807m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8808n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8809o;
    public boolean p;
    public long q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BluetoothConnection$mBluetoothConnectionReceiver$1 f8810r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.welink.protocol.libspp.BluetoothConnection$mBluetoothConnectionReceiver$1] */
    public d(Context context) {
        super(false, "BluetoothConnection");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8799c = context;
        UUID uuidFromString = UUID.fromString("0000FD35-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this.f8800d = uuidFromString;
        this.e = new LinkedHashSet();
        this.f8806l = -1;
        this.q = 35000L;
        this.f8810r = new BroadcastReceiver() { // from class: com.welink.protocol.libspp.BluetoothConnection$mBluetoothConnectionReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                BluetoothDevice bluetoothDevice;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action == null || Intrinsics.areEqual(action, "") || !Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_DISCONNECTED") || (bluetoothDevice = (BluetoothDevice) ((Parcelable) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class))) == null) {
                    return;
                }
                d dVar = this.f3857a;
                if (Intrinsics.areEqual(bluetoothDevice, dVar.f8804j)) {
                    dVar.r(bluetoothDevice, 7, -1);
                    dVar.u(DeviceType.INFRARED_AIR_CONDITION);
                }
            }
        };
    }

    public static final void j(d dVar, BluetoothDevice bluetoothDevice, int i8) {
        Message messageObtainMessage = dVar.a().obtainMessage(5);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        Bundle bundle = new Bundle();
        bundle.putInt("reason", i8);
        bundle.putString(MessageBank.KEY_MESSAGE, "Unable to connect device");
        bundle.putParcelable("device", bluetoothDevice);
        messageObtainMessage.setData(bundle);
        dVar.i(messageObtainMessage);
        dVar.v();
    }

    public static final void k(d dVar) {
        if (dVar.f8808n) {
            return;
        }
        try {
            dVar.f8799c.registerReceiver(dVar.f8810r, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"), 2);
            dVar.f8808n = true;
        } catch (Exception e) {
            String strN = o.d.n("Error registering broadcast receiver: ", e.getMessage(), "BluetoothConnection", "tag", "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strN, "BluetoothConnection", null);
            }
        }
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        switch (msg.what) {
            case 1:
                int i8 = msg.arg1;
                switch (i8) {
                    case 101:
                        t(this.f8805k, i8, -1);
                        return;
                    case 102:
                        t(this.f8804j, i8, this.f8806l);
                        return;
                    case DeviceType.INFRARED_TV_BOX /* 103 */:
                    default:
                        String strM = o.d.m("Unknown state: ", "BluetoothConnection", "tag", "mes", i8);
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", strM, "BluetoothConnection", null);
                            return;
                        }
                        return;
                    case 104:
                        t(null, i8, -1);
                        return;
                    case DeviceType.INFRARED_AIR_CONDITION /* 105 */:
                        t(this.f8804j, DeviceType.INFRARED_TV_BOX, this.f8806l);
                        this.f8805k = null;
                        this.f8804j = null;
                        this.f8806l = -1;
                        v();
                        return;
                }
            case 2:
                Bundle data = msg.getData();
                byte[] byteArray = data.getByteArray("data");
                Intrinsics.checkNotNull(data);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) ((Parcelable) data.getParcelable("device", BluetoothDevice.class));
                int i9 = msg.arg1;
                int i10 = this.f8806l;
                synchronized (this) {
                    synchronized (this.e) {
                        try {
                            Iterator it = this.e.iterator();
                            while (it.hasNext()) {
                                ((l0) it.next()).c(bluetoothDevice, byteArray, i9, i10);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
            case 3:
                byte[] bArr = (byte[]) msg.obj;
                h.b("BluetoothConnection", "Wrote: " + (bArr != null ? Integer.valueOf(bArr.length) : null) + " bytes done");
                BluetoothDevice bluetoothDevice2 = this.f8804j;
                int length = bArr != null ? bArr.length : 0;
                int i11 = this.f8806l;
                synchronized (this) {
                    synchronized (this.e) {
                        try {
                            Iterator it2 = this.e.iterator();
                            while (it2.hasNext()) {
                                ((l0) it2.next()).d(bluetoothDevice2, length, i11);
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
                return;
            case 4:
                Bundle data2 = msg.getData();
                Intrinsics.checkNotNull(data2);
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) ((Parcelable) data2.getParcelable("device", BluetoothDevice.class));
                String string = data2.getString("device_name");
                int i12 = data2.getInt("mode");
                this.f8804j = bluetoothDevice3;
                this.f8805k = null;
                this.f8806l = i12;
                h.b("BluetoothConnection", "Connected to device: " + bluetoothDevice3 + ", name: " + string + ", mode: " + (i12 == 0 ? "Client" : "Server"));
                return;
            case 5:
                Bundle data3 = msg.getData();
                Intrinsics.checkNotNull(data3);
                BluetoothDevice bluetoothDevice4 = (BluetoothDevice) ((Parcelable) data3.getParcelable("device", BluetoothDevice.class));
                int i13 = data3.getInt("reason");
                h.c("BluetoothConnection", "Connection lost: " + data3.getString(MessageBank.KEY_MESSAGE), null);
                if (i13 != 302) {
                    switch (i13) {
                        case l5.a.CODE_SCANNER_CANCELLED /* 201 */:
                            h.c("BluetoothConnection", "Connection failed on Device: " + bluetoothDevice4, null);
                            if (bluetoothDevice4 == null) {
                                bluetoothDevice4 = this.f8805k;
                            }
                            s(bluetoothDevice4, PointerIconCompat.TYPE_HAND, -1);
                            break;
                        case l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED /* 202 */:
                            h.c("BluetoothConnection", "Connection timeout on Device: " + bluetoothDevice4, null);
                            if (bluetoothDevice4 == null) {
                                bluetoothDevice4 = this.f8805k;
                            }
                            s(bluetoothDevice4, PointerIconCompat.TYPE_HELP, -1);
                            break;
                        case l5.a.CODE_SCANNER_APP_NAME_UNAVAILABLE /* 203 */:
                            h.h("BluetoothConnection", "Connection lost on Device: " + bluetoothDevice4);
                            w();
                            if (bluetoothDevice4 == null && (bluetoothDevice4 = this.f8804j) == null) {
                                bluetoothDevice4 = this.f8805k;
                            }
                            s(bluetoothDevice4, PointerIconCompat.TYPE_CONTEXT_MENU, this.f8806l);
                            break;
                        case l5.a.CODE_SCANNER_TASK_IN_PROGRESS /* 204 */:
                            h.h("BluetoothConnection", "Socket not found on Device: " + bluetoothDevice4);
                            if (bluetoothDevice4 == null) {
                                bluetoothDevice4 = this.f8805k;
                            }
                            s(bluetoothDevice4, PointerIconCompat.TYPE_WAIT, -1);
                            break;
                        default:
                            h.c("BluetoothConnection", "Unknown reason: " + i13, null);
                            break;
                    }
                } else {
                    h.h("BluetoothConnection", "Server socket not found on Device");
                    s(null, 1005, -1);
                }
                this.f8805k = null;
                this.f8804j = null;
                this.f8806l = -1;
                return;
            case 6:
                Bundle data4 = msg.getData();
                Intrinsics.checkNotNull(data4);
                BluetoothDevice bluetoothDevice5 = (BluetoothDevice) ((Parcelable) data4.getParcelable("device", BluetoothDevice.class));
                String string2 = data4.getString("device_name");
                this.f8805k = bluetoothDevice5;
                h.b("BluetoothConnection", "Connecting to device: " + bluetoothDevice5 + ", name: " + string2);
                return;
            case 7:
                Bundle data5 = msg.getData();
                Intrinsics.checkNotNull(data5);
                h.b("BluetoothConnection", "Bluetooth ACL disconnected: " + ((BluetoothDevice) ((Parcelable) data5.getParcelable("device", BluetoothDevice.class))) + ", name: " + data5.getString("device_name"));
                w();
                return;
            default:
                return;
        }
    }

    public final synchronized void l(BluetoothDevice device, boolean z2) {
        c cVar;
        b bVar;
        try {
            Intrinsics.checkNotNullParameter(device, "device");
            if (p() == 101 && (bVar = this.f8802h) != null) {
                Intrinsics.checkNotNull(bVar);
                bVar.f8794h.h(bVar.e);
                bVar.a();
                this.f8802h = null;
            }
            if (p() == 102 && (cVar = this.f8803i) != null) {
                Intrinsics.checkNotNull(cVar);
                cVar.a();
                this.f8803i = null;
            }
            b bVar2 = new b(this, device, z2);
            this.f8802h = bVar2;
            bVar2.start();
            r(device, 6, -1);
            u(101);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void m(BluetoothSocket socket, BluetoothDevice device, String socketType, int i8) {
        try {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(socketType, "socketType");
            h.b("BluetoothConnection", "connected, Socket Type: " + socketType);
            b bVar = this.f8802h;
            if (bVar != null) {
                Intrinsics.checkNotNull(bVar);
                bVar.f8794h.h(bVar.e);
                bVar.a();
                this.f8802h = null;
            }
            c cVar = this.f8803i;
            if (cVar != null) {
                Intrinsics.checkNotNull(cVar);
                cVar.a();
                this.f8803i = null;
            }
            a aVar = this.f;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.a();
                this.f = null;
            }
            a aVar2 = this.f8801g;
            if (aVar2 != null) {
                Intrinsics.checkNotNull(aVar2);
                aVar2.a();
                this.f8801g = null;
            }
            c cVar2 = new c(this, socket, device, socketType);
            this.f8803i = cVar2;
            Intrinsics.checkNotNull(cVar2);
            cVar2.start();
            r(device, 4, i8);
            u(102);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            if (Intrinsics.areEqual(bluetoothDevice, this.f8804j) || Intrinsics.areEqual(bluetoothDevice, this.f8805k)) {
                int iP = p();
                if (iP == 101) {
                    b bVar = this.f8802h;
                    if (bVar != null) {
                        Intrinsics.checkNotNull(bVar);
                        bVar.f8794h.h(bVar.e);
                        bVar.a();
                        this.f8802h = null;
                        return;
                    }
                    return;
                }
                if (iP != 102) {
                    String strM = o.d.m("Error: Invalid state: ", "BluetoothConnection", "tag", "mes", p());
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strM, "BluetoothConnection", null);
                        return;
                    }
                    return;
                }
                if (this.f8803i != null) {
                    w();
                    c cVar = this.f8803i;
                    Intrinsics.checkNotNull(cVar);
                    cVar.a();
                    this.f8803i = null;
                }
            }
        }
    }

    public final BluetoothSocket o() {
        BluetoothSocket bluetoothSocket;
        try {
            b bVar = this.f8802h;
            if (bVar == null || (bluetoothSocket = bVar.f8791b) == null) {
                return null;
            }
            return bluetoothSocket;
        } catch (Exception e) {
            String strN = o.d.n("Error retrieving Bluetooth socket: ", e.getMessage(), "BluetoothConnection", "tag", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            h0.a.x("TransConnect:", strN, "BluetoothConnection", null);
            return null;
        }
    }

    public final synchronized int p() {
        return this.f8807m;
    }

    public final boolean q() {
        return p() == 102;
    }

    public final void r(BluetoothDevice bluetoothDevice, int i8, int i9) {
        Message messageObtainMessage = a().obtainMessage(i8);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        Bundle bundle = new Bundle();
        bundle.putParcelable("device", bluetoothDevice);
        bundle.putString("device_name", bluetoothDevice.getName());
        bundle.putInt("mode", i9);
        messageObtainMessage.setData(bundle);
        i(messageObtainMessage);
    }

    public final synchronized void s(BluetoothDevice bluetoothDevice, int i8, int i9) {
        synchronized (this.e) {
            try {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((l0) it.next()).a(bluetoothDevice, i8, i9);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void t(BluetoothDevice bluetoothDevice, int i8, int i9) {
        synchronized (this.e) {
            try {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((l0) it.next()).b(bluetoothDevice, i8, i9);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void u(int i8) {
        h.b("BluetoothConnection", "setState() " + this.f8807m + " -> " + i8);
        this.f8807m = i8;
        Message messageObtainMessage = a().obtainMessage(1, i8, -1);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        messageObtainMessage.sendToTarget();
    }

    public final synchronized void v() {
        h.b("BluetoothConnection", "start");
        if (!this.f8809o) {
            h.c("BluetoothConnection", "Error: Server not started", null);
            return;
        }
        b bVar = this.f8802h;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.f8794h.h(bVar.e);
            bVar.a();
            this.f8802h = null;
        }
        c cVar = this.f8803i;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.a();
            this.f8803i = null;
        }
        u(104);
        if (this.f == null) {
            a aVar = new a(this, true);
            this.f = aVar;
            Intrinsics.checkNotNull(aVar);
            aVar.start();
        }
        if (this.f8801g == null) {
            a aVar2 = new a(this, false);
            this.f8801g = aVar2;
            Intrinsics.checkNotNull(aVar2);
            aVar2.start();
        }
    }

    public final void w() {
        if (this.f8808n) {
            this.f8799c.unregisterReceiver(this.f8810r);
            this.f8808n = false;
        }
    }

    public final boolean x(byte[] bArr) {
        synchronized (this) {
            boolean z2 = false;
            if (p() != 102) {
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("Error sending byte array: not connected", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:Error sending byte array: not connected", null);
                }
                return false;
            }
            if (bArr == null || bArr.length == 0) {
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("Byte array is null or empty", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:Byte array is null or empty", null);
                }
            } else {
                try {
                    c cVar = this.f8803i;
                    if (cVar != null) {
                        cVar.b(bArr);
                    }
                    z2 = true;
                } catch (Exception e) {
                    String mes = "Error sending byte array: " + e.getMessage();
                    Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("BluetoothConnection", "TransConnect:" + mes, null);
                    }
                }
            }
            return z2;
        }
    }
}
