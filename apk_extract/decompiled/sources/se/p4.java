package se;

import android.content.Context;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p4 extends FunctionReferenceImpl implements Function1 {
    public static final p4 INSTANCE = new p4();

    public p4() {
        super(1, q4.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final q4 invoke(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "p0");
        q4 q4Var = new q4();
        q4Var.f9952c = new LinkedHashMap();
        tj.x xVar = new tj.x(q4Var);
        q5.a aVar = new q5.a();
        pe.f fVar = new pe.f(mContext);
        q4Var.f9950a = fVar;
        fVar.f = xVar;
        fVar.f8818h = aVar;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        q4Var.f9953d = new pe.g();
        return q4Var;
    }
}
