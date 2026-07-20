package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s0 extends FunctionReferenceImpl implements Function1 {
    public static final s0 INSTANCE = new s0();

    public s0() {
        super(1, b1.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final b1 invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new b1(p0);
    }
}
