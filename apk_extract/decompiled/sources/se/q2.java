package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q2 extends FunctionReferenceImpl implements Function2 {
    public static final q2 INSTANCE = new q2();

    public q2() {
        super(2, d3.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearLanManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final d3 invoke(Context p0, com.welink.protocol.nfbd.m mVar) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new d3(p0, mVar);
    }
}
