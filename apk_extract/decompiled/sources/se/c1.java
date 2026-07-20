package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c1 extends FunctionReferenceImpl implements Function2 {
    public static final c1 INSTANCE = new c1();

    public c1() {
        super(2, com.welink.protocol.nfbd.g.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/TranConnectionManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final com.welink.protocol.nfbd.g invoke(Context p0, com.welink.protocol.nfbd.z p7) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p7, "p1");
        return new com.welink.protocol.nfbd.g(p0, p7);
    }
}
