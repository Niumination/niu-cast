package pe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.io.IOException;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothServerSocket f8786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothSocket f8788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f8789d;

    public a(d dVar, boolean z2) throws IOException {
        BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord;
        this.f8789d = dVar;
        this.f8787b = z2 ? "Secure" : "Insecure";
        if (ContextCompat.checkSelfPermission(dVar.f8799c, "android.permission.BLUETOOTH_CONNECT") != 0) {
            throw new IllegalArgumentException("Bluetooth Connect permission is required for AcceptThread");
        }
        Object systemService = dVar.f8799c.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        if (adapter != null) {
            try {
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = z2 ? adapter.listenUsingRfcommWithServiceRecord("transConnection", dVar.f8800d) : adapter.listenUsingInsecureRfcommWithServiceRecord("transConnection", dVar.f8800d);
            } catch (Exception e) {
                e.printStackTrace();
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = null;
            }
        } else {
            bluetoothServerSocketListenUsingRfcommWithServiceRecord = null;
        }
        if (bluetoothServerSocketListenUsingRfcommWithServiceRecord != null) {
            this.f8786a = bluetoothServerSocketListenUsingRfcommWithServiceRecord;
            return;
        }
        Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
        Intrinsics.checkNotNullParameter("Failed to create Bluetooth server socket", "mes");
        if (lb.f6529c >= 1) {
            Log.e("BluetoothConnection", "TransConnect:Failed to create Bluetooth server socket", null);
        }
        throw new IOException("Unable to create Bluetooth server socket");
    }

    public final void a() {
        BluetoothServerSocket bluetoothServerSocket = this.f8786a;
        if (bluetoothServerSocket != null) {
            try {
                bluetoothServerSocket.close();
                this.f8786a = null;
            } catch (IOException e) {
                String mes = "Error while closing server socket, " + e;
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "BluetoothConnection", null);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (this.f8786a == null) {
            d.j(this.f8789d, null, 302);
            return;
        }
        while (this.f8789d.p() != 102) {
            try {
                BluetoothServerSocket bluetoothServerSocket = this.f8786a;
                BluetoothSocket bluetoothSocketAccept = bluetoothServerSocket != null ? bluetoothServerSocket.accept() : null;
                this.f8788c = bluetoothSocketAccept;
                if (bluetoothSocketAccept != null) {
                    d dVar = this.f8789d;
                    synchronized (dVar) {
                        int iP = dVar.p();
                        if (iP != 0) {
                            switch (iP) {
                                case 101:
                                case 104:
                                    d.k(dVar);
                                    BluetoothSocket bluetoothSocket = this.f8788c;
                                    Intrinsics.checkNotNull(bluetoothSocket);
                                    BluetoothSocket bluetoothSocket2 = this.f8788c;
                                    Intrinsics.checkNotNull(bluetoothSocket2);
                                    BluetoothDevice remoteDevice = bluetoothSocket2.getRemoteDevice();
                                    Intrinsics.checkNotNullExpressionValue(remoteDevice, "getRemoteDevice(...)");
                                    dVar.m(bluetoothSocket, remoteDevice, this.f8787b, 1);
                                    break;
                                case 102:
                                case DeviceType.INFRARED_TV_BOX /* 103 */:
                                    try {
                                        BluetoothSocket bluetoothSocket3 = this.f8788c;
                                        Intrinsics.checkNotNull(bluetoothSocket3);
                                        bluetoothSocket3.close();
                                    } catch (IOException e) {
                                        Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                                        Intrinsics.checkNotNullParameter("Could not close unwanted socket", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("BluetoothConnection", "TransConnect:Could not close unwanted socket", e);
                                        }
                                    }
                                    break;
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            BluetoothSocket bluetoothSocket4 = this.f8788c;
                            Intrinsics.checkNotNull(bluetoothSocket4);
                            bluetoothSocket4.close();
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (IOException e4) {
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("Socket accept() failed", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:Socket accept() failed", e4);
                    return;
                }
                return;
            }
        }
    }
}
