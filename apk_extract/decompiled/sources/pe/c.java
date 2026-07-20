package pe;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.transsion.message.bank.MessageBank;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothSocket f8795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothDevice f8796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f8797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OutputStream f8798d;
    public final /* synthetic */ d e;

    public c(d dVar, BluetoothSocket socket, BluetoothDevice device, String socketType) {
        InputStream inputStream;
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(socketType, "socketType");
        this.e = dVar;
        h0.a.D("ConnectedThread: Socket Type: ", socketType, "BluetoothConnection");
        this.f8795a = socket;
        this.f8796b = device;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e = e;
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("temp sockets not created", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:temp sockets not created", e);
                }
            }
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
        }
        this.f8797c = inputStream;
        this.f8798d = outputStream;
    }

    public final void a() {
        try {
            BluetoothSocket bluetoothSocket = this.f8795a;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (IOException e) {
            Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
            Intrinsics.checkNotNullParameter("Could not close socket during cancel", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BluetoothConnection", "TransConnect:Could not close socket during cancel", e);
            }
        }
    }

    public final void b(byte[] bArr) {
        try {
            OutputStream outputStream = this.f8798d;
            Intrinsics.checkNotNull(outputStream);
            outputStream.write(bArr);
            this.e.e(3, -1, -1, bArr).sendToTarget();
        } catch (IOException e) {
            Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
            Intrinsics.checkNotNullParameter("Exception during write", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BluetoothConnection", "TransConnect:Exception during write", e);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        BluetoothDevice bluetoothDevice = this.f8796b;
        d dVar = this.e;
        h.h("BluetoothConnection", "start ConnectedThread");
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                InputStream inputStream = this.f8797c;
                Intrinsics.checkNotNull(inputStream);
                Message messageObtainMessage = dVar.a().obtainMessage(2, inputStream.read(bArr), -1);
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
                Bundle bundle = new Bundle();
                bundle.putParcelable("device", bluetoothDevice);
                bundle.putByteArray("data", bArr);
                messageObtainMessage.setData(bundle);
                dVar.i(messageObtainMessage);
            } catch (IOException e) {
                Intrinsics.checkNotNullParameter("BluetoothConnection", "tag");
                Intrinsics.checkNotNullParameter("disconnected", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BluetoothConnection", "TransConnect:disconnected", e);
                }
                Message messageObtainMessage2 = dVar.a().obtainMessage(5);
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage2, "obtainMessage(...)");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("reason", l5.a.CODE_SCANNER_APP_NAME_UNAVAILABLE);
                bundle2.putString(MessageBank.KEY_MESSAGE, "Device connection was lost");
                bundle2.putParcelable("device", bluetoothDevice);
                messageObtainMessage2.setData(bundle2);
                dVar.i(messageObtainMessage2);
                dVar.v();
                dVar.v();
                return;
            }
        }
    }
}
