package pe;

import android.bluetooth.BluetoothAdapter;
import com.welink.protocol.libspp.BluetoothController$discoveryBroadcast$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f8812b;

    public /* synthetic */ e(f fVar, int i8) {
        this.f8811a = i8;
        this.f8812b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.f8812b;
        switch (this.f8811a) {
            case 0:
                fVar.getClass();
                try {
                    fVar.k(true);
                    BluetoothAdapter bluetoothAdapter = f.f8813l;
                    Intrinsics.checkNotNull(bluetoothAdapter);
                    bluetoothAdapter.startDiscovery();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case 1:
                int i8 = BluetoothController$discoveryBroadcast$1.f3858b;
                q5.a aVar = fVar.f8818h;
                break;
            default:
                int i9 = BluetoothController$discoveryBroadcast$1.f3858b;
                q5.a aVar2 = fVar.f8818h;
                break;
        }
    }
}
