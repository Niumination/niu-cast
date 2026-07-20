package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f10021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f10022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiP2pDevice f10023d;
    public final /* synthetic */ NearDevice e;

    public /* synthetic */ v(Pair pair, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice, int i8) {
        this.f10020a = i8;
        this.f10021b = pair;
        this.f10022c = bluetoothDevice;
        this.f10023d = wifiP2pDevice;
        this.e = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10020a) {
            case 0:
                ((e1) this.f10021b.getSecond()).i(this.f10022c, this.f10023d, this.e, null);
                break;
            case 1:
                ((e1) this.f10021b.getSecond()).i(this.f10022c, this.f10023d, this.e, null);
                break;
            case 2:
                ((e1) this.f10021b.getSecond()).i(this.f10022c, this.f10023d, this.e, null);
                break;
            default:
                ((e1) this.f10021b.getSecond()).i(this.f10022c, this.f10023d, this.e, null);
                break;
        }
    }
}
