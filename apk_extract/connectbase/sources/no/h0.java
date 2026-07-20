package no;

import eo.m1;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static final boolean a(@os.l eo.b bVar) {
        l0.p(bVar, "memberDescriptor");
        return (bVar instanceof eo.y) && l0.g(bVar.j0(po.e.Y), Boolean.TRUE);
    }

    public static final boolean b(@os.l v vVar) {
        l0.p(vVar, "javaTypeEnhancementState");
        return vVar.f11788b.invoke(t.e()) == e0.STRICT;
    }

    @os.l
    public static final eo.u c(@os.l m1 m1Var) {
        l0.p(m1Var, "<this>");
        eo.u uVarG = r.g(m1Var);
        l0.o(uVarG, "toDescriptorVisibility(this)");
        return uVarG;
    }
}
