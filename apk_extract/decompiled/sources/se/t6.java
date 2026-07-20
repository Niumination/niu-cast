package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t6 extends FunctionReferenceImpl implements Function1 {
    public static final t6 INSTANCE = new t6();

    public t6() {
        super(1, com.welink.protocol.nfbd.c0.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final com.welink.protocol.nfbd.c0 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new com.welink.protocol.nfbd.c0(p0);
    }
}
