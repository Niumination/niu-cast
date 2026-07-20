package m3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class g6 {
    public static final boolean a(zf.n0 n0Var) {
        Intrinsics.checkNotNullParameter(n0Var, "<this>");
        return Intrinsics.areEqual(n0Var.f11526a, "https") || Intrinsics.areEqual(n0Var.f11526a, "wss");
    }

    public static final boolean b(zf.n0 n0Var) {
        Intrinsics.checkNotNullParameter(n0Var, "<this>");
        return Intrinsics.areEqual(n0Var.f11526a, "ws") || Intrinsics.areEqual(n0Var.f11526a, "wss");
    }
}
