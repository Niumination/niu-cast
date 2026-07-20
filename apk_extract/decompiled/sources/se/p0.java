package se;

import android.content.Context;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p0 extends FunctionReferenceImpl implements Function3 {
    public static final p0 INSTANCE = new p0();

    public p0() {
        super(3, com.welink.protocol.nfbd.f.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearBluetoothManager;Lcom/welink/protocol/nfbd/NearWifiP2pManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final com.welink.protocol.nfbd.f invoke(Context p0, com.welink.protocol.nfbd.d dVar, h4 h4Var) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.f(p0, dVar, h4Var);
    }
}
