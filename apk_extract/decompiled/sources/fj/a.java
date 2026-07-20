package fj;

import dj.i0;
import dj.j0;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final j0 a(j0 j0Var) {
        if ((j0Var != null ? j0Var.f4581i : null) == null) {
            return j0Var;
        }
        i0 i0VarG = j0Var.g();
        i0VarG.f4565g = null;
        return i0VarG.a();
    }

    public static boolean b(String str) {
        return (StringsKt__StringsJVMKt.equals("Connection", str, true) || StringsKt__StringsJVMKt.equals("Keep-Alive", str, true) || StringsKt__StringsJVMKt.equals("Proxy-Authenticate", str, true) || StringsKt__StringsJVMKt.equals("Proxy-Authorization", str, true) || StringsKt__StringsJVMKt.equals("TE", str, true) || StringsKt__StringsJVMKt.equals("Trailers", str, true) || StringsKt__StringsJVMKt.equals("Transfer-Encoding", str, true) || StringsKt__StringsJVMKt.equals("Upgrade", str, true)) ? false : true;
    }
}
