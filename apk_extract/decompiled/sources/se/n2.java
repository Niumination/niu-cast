package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n2 extends FunctionReferenceImpl implements Function1 {
    public static final n2 INSTANCE = new n2();

    public n2() {
        super(1, com.welink.protocol.nfbd.m.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final com.welink.protocol.nfbd.m invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.m(p0);
    }
}
