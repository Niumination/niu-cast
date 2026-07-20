package vk;

import ik.b0;
import ik.c0;
import ik.j0;
import ik.x1;
import java.util.List;
import kn.l0;
import nm.h0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static /* synthetic */ void c(g gVar, String str, String str2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: append");
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        gVar.b(str, str2, z10);
    }

    @l
    public final b0 a() {
        b0.a aVar = b0.f7939b;
        c0 c0Var = new c0(0, 1, null);
        for (String str : g()) {
            c0Var.c(str, h(str));
        }
        return c0Var.f();
    }

    public final void b(@l String str, @l String str2, boolean z10) {
        l0.p(str, "name");
        l0.p(str2, "value");
        if (z10 && j0.f8048a.a1(str)) {
            throw new x1(str);
        }
        j0 j0Var = j0.f8048a;
        j0Var.a(str);
        j0Var.b(str2);
        e(str, str2);
    }

    public final boolean d(@l String str) {
        l0.p(str, "name");
        return f(str) != null;
    }

    public abstract void e(@l String str, @l String str2);

    @m
    public String f(@l String str) {
        l0.p(str, "name");
        return (String) h0.G2(h(str));
    }

    @l
    public abstract List<String> g();

    @l
    public abstract List<String> h(@l String str);

    @l
    public final List<String> i(@l String str) {
        l0.p(str, "name");
        return h(str);
    }
}
