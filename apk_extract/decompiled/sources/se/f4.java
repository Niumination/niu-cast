package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f4 extends FunctionReferenceImpl implements Function1 {
    public static final f4 INSTANCE = new f4();

    public f4() {
        super(1, h4.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final h4 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new h4(p0);
    }
}
