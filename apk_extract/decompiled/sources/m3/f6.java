package m3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class f6 {
    public static zf.n0 a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String strB = r6.b(name);
        zf.n0 n0Var = (zf.n0) zf.n0.e.get(strB);
        return n0Var == null ? new zf.n0(strB, 0) : n0Var;
    }
}
