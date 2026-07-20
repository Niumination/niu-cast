package eo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {
    public static final void a(@os.l l0 l0Var, @os.l dp.c cVar, @os.l Collection<k0> collection) {
        kn.l0.p(l0Var, "<this>");
        kn.l0.p(cVar, "fqName");
        kn.l0.p(collection, "packageFragments");
        if (l0Var instanceof o0) {
            ((o0) l0Var).c(cVar, collection);
        } else {
            collection.addAll(l0Var.a(cVar));
        }
    }

    public static final boolean b(@os.l l0 l0Var, @os.l dp.c cVar) {
        kn.l0.p(l0Var, "<this>");
        kn.l0.p(cVar, "fqName");
        return l0Var instanceof o0 ? ((o0) l0Var).b(cVar) : c(l0Var, cVar).isEmpty();
    }

    @os.l
    public static final List<k0> c(@os.l l0 l0Var, @os.l dp.c cVar) {
        kn.l0.p(l0Var, "<this>");
        kn.l0.p(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        a(l0Var, cVar, arrayList);
        return arrayList;
    }
}
