package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class g2 {
    public static final vj.b a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        vj.b bVarB = vj.d.b(name);
        Intrinsics.checkNotNullExpressionValue(bVarB, "getLogger(...)");
        return bVarB;
    }
}
