package pe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f8790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothSocket f8791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BluetoothAdapter f8792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8793d;
    public final o.e e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d f8794h;

    public b(d dVar, BluetoothDevice mDevice, boolean z2) throws IOException {
        BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
        Intrinsics.checkNotNullParameter(mDevice, "mDevice");
        this.f8794h = dVar;
        this.f8790a = mDevice;
        this.f8793d = z2 ? "Secure" : "Insecure";
        if (ContextCompat.checkSelfPermission(dVar.f8799c, "android.permission.BLUETOOTH_CONNECT") != 0) {
            throw new IllegalArgumentException("Bluetooth Connect permission is required for ConnectThread");
        }
        Object systemService = dVar.f8799c.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        this.f8792c = adapter;
        if (adapter != null) {
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = z2 ? mDevice.createRfcommSocketToServiceRecord(dVar.f8800d) : mDevice.createInsecureRfcommSocketToServiceRecord(dVar.f8800d);
            } catch (Exception e) {
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("Error creating Bluetooth socket", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:Error creating Bluetooth socket", e);
                }
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
        } else {
            bluetoothSocketCreateRfcommSocketToServiceRecord = null;
        }
        if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
            this.f8791b = bluetoothSocketCreateRfcommSocketToServiceRecord;
            this.e = new o.e(4, this.f8794h, this);
        } else {
            Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
            Intrinsics.checkNotNullParameter("Failed to create Bluetooth device socket", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BluetoothConnection", "TransConnect:Failed to create Bluetooth device socket", null);
            }
            throw new IOException("Unable to create Bluetooth device socket");
        }
    }

    public final void a() {
        try {
            BluetoothSocket bluetoothSocket = this.f8791b;
            if (bluetoothSocket != null) {
                Intrinsics.checkNotNull(bluetoothSocket);
                bluetoothSocket.close();
                this.f8791b = null;
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
            Intrinsics.checkNotNullParameter("Error while closing socket", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BluetoothConnection", "TransConnect:Error while closing socket", e);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (this.f8791b == null) {
            d.j(this.f8794h, this.f8790a, l5.a.CODE_SCANNER_TASK_IN_PROGRESS);
            return;
        }
        BluetoothAdapter bluetoothAdapter = this.f8792c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        d dVar = this.f8794h;
        if (dVar.p) {
            dVar.g(dVar.q, this.e);
        }
        try {
            BluetoothSocket bluetoothSocket = this.f8791b;
            if (bluetoothSocket != null) {
                bluetoothSocket.connect();
            }
            this.f8794h.h(this.e);
            d dVar2 = this.f8794h;
            synchronized (dVar2) {
                dVar2.f8802h = null;
                Unit unit = Unit.INSTANCE;
            }
            d.k(this.f8794h);
            d dVar3 = this.f8794h;
            BluetoothSocket bluetoothSocket2 = this.f8791b;
            Intrinsics.checkNotNull(bluetoothSocket2);
            BluetoothSocket bluetoothSocket3 = this.f8791b;
            Intrinsics.checkNotNull(bluetoothSocket3);
            BluetoothDevice remoteDevice = bluetoothSocket3.getRemoteDevice();
            Intrinsics.checkNotNullExpressionValue(remoteDevice, "getRemoteDevice(...)");
            dVar3.m(bluetoothSocket2, remoteDevice, this.f8793d, 0);
        } catch (Exception unused) {
            this.f8794h.h(this.e);
            a();
            d.j(this.f8794h, this.f8790a, l5.a.CODE_SCANNER_CANCELLED);
        }
    }
}
