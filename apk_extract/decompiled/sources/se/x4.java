package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x4 extends FunctionReferenceImpl implements Function1 {
    public static final x4 INSTANCE = new x4();

    public x4() {
        super(1, y4.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final y4 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        y4 y4Var = new y4();
        Object systemService = p0.getSystemService("servicediscovery");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.nsd.NsdManager");
        u0 u0Var = com.welink.protocol.nfbd.z.f4202l;
        Context applicationContext = p0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        y4Var.f10069a = (com.welink.protocol.nfbd.z) u0Var.b(applicationContext);
        return y4Var;
    }
}
