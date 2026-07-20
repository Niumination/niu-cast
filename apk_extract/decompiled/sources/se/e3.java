package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e3 extends FunctionReferenceImpl implements Function2 {
    public static final e3 INSTANCE = new e3();

    public e3() {
        super(2, com.welink.protocol.nfbd.p.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearLanManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final com.welink.protocol.nfbd.p invoke(Context p0, com.welink.protocol.nfbd.m mVar) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.p(p0, mVar);
    }
}
