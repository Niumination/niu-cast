package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f10007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f10008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ConnectRequest f10009d;
    public final /* synthetic */ NearDevice e;

    public /* synthetic */ u(Pair pair, BluetoothDevice bluetoothDevice, ConnectRequest connectRequest, NearDevice nearDevice, int i8) {
        this.f10006a = i8;
        this.f10007b = pair;
        this.f10008c = bluetoothDevice;
        this.f10009d = connectRequest;
        this.e = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10006a) {
            case 0:
                ((e1) this.f10007b.getSecond()).b(this.f10008c, this.f10009d, this.e);
                break;
            case 1:
                ((e1) this.f10007b.getSecond()).b(this.f10008c, this.f10009d, this.e);
                break;
            case 2:
                ((e1) this.f10007b.getSecond()).b(this.f10008c, this.f10009d, this.e);
                break;
            case 3:
                ((e1) this.f10007b.getSecond()).b(this.f10008c, this.f10009d, this.e);
                break;
            case 4:
                ((e1) this.f10007b.getSecond()).c(this.f10008c, this.f10009d, this.e);
                break;
            default:
                ((e1) this.f10007b.getSecond()).b(this.f10008c, this.f10009d, this.e);
                break;
        }
    }
}
