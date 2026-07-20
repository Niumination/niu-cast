package ik;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    public static final void a(@os.l vk.a aVar, @os.l y0 y0Var) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(y0Var, "header");
        vk.g gVarB = aVar.b();
        j0.f8048a.getClass();
        vk.g.c(gVarB, j0.R, y0Var.toString(), false, 4, null);
    }

    public static final void b(@os.l vk.a aVar, @os.l String str, @os.l String... strArr) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(str, "uri");
        kn.l0.p(strArr, y0.a.f8209b);
        a(aVar, new y0(str, (String[]) Arrays.copyOf(strArr, strArr.length)));
    }
}
