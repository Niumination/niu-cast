package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y3 extends FunctionReferenceImpl implements Function2 {
    public static final y3 INSTANCE = new y3();

    public y3() {
        super(2, a4.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearWifiP2pManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final a4 invoke(Context p0, h4 h4Var) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new a4(p0, h4Var);
    }
}
