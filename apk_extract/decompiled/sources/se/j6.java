package se;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j6 extends FunctionReferenceImpl implements Function1 {
    public static final j6 INSTANCE = new j6();

    public j6() {
        super(1, k6.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final k6 invoke(Context context) {
        return new k6(context);
    }
}
