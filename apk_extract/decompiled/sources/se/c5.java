package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c5 extends FunctionReferenceImpl implements Function2 {
    public static final c5 INSTANCE = new c5();

    public c5() {
        super(2, h5.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearConnectionService;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final h5 invoke(Context p0, com.welink.protocol.nfbd.g p7) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p7, "p1");
        return new h5(p0, p7);
    }
}
