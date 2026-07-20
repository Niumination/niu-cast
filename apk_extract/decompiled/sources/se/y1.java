package se;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y1 extends FunctionReferenceImpl implements Function3 {
    public static final y1 INSTANCE = new y1();

    public y1() {
        super(3, com.welink.protocol.nfbd.j.class, "<init>", "<init>(Landroid/content/Context;Landroid/bluetooth/BluetoothManager;Lcom/welink/protocol/nfbd/NearBleManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final com.welink.protocol.nfbd.j invoke(Context p0, BluetoothManager bluetoothManager, com.welink.protocol.nfbd.a aVar) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.j(p0, bluetoothManager, aVar);
    }
}
