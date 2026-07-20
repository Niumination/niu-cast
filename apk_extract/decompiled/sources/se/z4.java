package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z4 extends FunctionReferenceImpl implements Function1 {
    public static final z4 INSTANCE = new z4();

    public z4() {
        super(1, b5.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final b5 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new b5(p0);
    }
}
