package se;

import android.bluetooth.BluetoothDevice;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9651b;

    public /* synthetic */ b0(BluetoothDevice bluetoothDevice, int i8) {
        this.f9650a = i8;
        this.f9651b = bluetoothDevice;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9650a) {
            case 0:
                Pair it = (Pair) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getFirst(), this.f9651b));
            default:
                return Boolean.valueOf(Intrinsics.areEqual(((BluetoothDevice) obj).getAddress(), this.f9651b.getAddress()));
        }
    }
}
