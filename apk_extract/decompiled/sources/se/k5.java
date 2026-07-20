package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k5 extends FunctionReferenceImpl implements Function1 {
    public static final k5 INSTANCE = new k5();

    public k5() {
        super(1, com.welink.protocol.nfbd.z.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final com.welink.protocol.nfbd.z invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.z(p0);
    }
}
