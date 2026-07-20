package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m0 extends FunctionReferenceImpl implements Function2 {
    public static final m0 INSTANCE = new m0();

    public m0() {
        super(2, com.welink.protocol.nfbd.d.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearWifiP2pManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final com.welink.protocol.nfbd.d invoke(Context p0, h4 h4Var) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.d(p0, h4Var);
    }
}
