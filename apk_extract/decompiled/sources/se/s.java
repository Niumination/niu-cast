package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f9970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9972d;
    public final /* synthetic */ int e;

    public /* synthetic */ s(Pair pair, BluetoothDevice bluetoothDevice, int i8, NearDevice nearDevice, int i9) {
        this.f9969a = i9;
        this.f9970b = pair;
        this.f9971c = bluetoothDevice;
        this.e = i8;
        this.f9972d = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9969a) {
            case 0:
                ((e1) this.f9970b.getSecond()).g(this.e, this.f9971c, this.f9972d);
                break;
            case 1:
                ((e1) this.f9970b.getSecond()).g(this.e, this.f9971c, this.f9972d);
                break;
            case 2:
                ((e1) this.f9970b.getSecond()).j(this.f9971c, null, this.e, this.f9972d);
                break;
            case 3:
                ((e1) this.f9970b.getSecond()).g(this.e, this.f9971c, this.f9972d);
                break;
            case 4:
                ((e1) this.f9970b.getSecond()).j(this.f9971c, null, this.e, this.f9972d);
                break;
            case 5:
                ((e1) this.f9970b.getSecond()).g(this.e, this.f9971c, this.f9972d);
                break;
            default:
                ((e1) this.f9970b.getSecond()).g(this.e, this.f9971c, this.f9972d);
                break;
        }
    }

    public /* synthetic */ s(Pair pair, BluetoothDevice bluetoothDevice, NearDevice nearDevice, int i8, int i9) {
        this.f9969a = i9;
        this.f9970b = pair;
        this.f9971c = bluetoothDevice;
        this.f9972d = nearDevice;
        this.e = i8;
    }
}
