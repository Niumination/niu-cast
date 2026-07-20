package wp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.i0;
import nm.h0;
import nm.z;
import vp.c0;
import vp.g0;
import vp.n0;
import vp.n1;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    @os.l
    public static final n1 a(@os.l List<? extends n1> list) {
        n0 n0Var;
        l0.p(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (n1) h0.h5(list);
        }
        List<? extends n1> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        boolean z10 = false;
        boolean z11 = false;
        for (n1 n1Var : list2) {
            z10 = z10 || vp.h0.a(n1Var);
            if (n1Var instanceof n0) {
                n0Var = (n0) n1Var;
            } else {
                if (!(n1Var instanceof vp.z)) {
                    throw new i0();
                }
                if (vp.v.a(n1Var)) {
                    return n1Var;
                }
                n0Var = ((vp.z) n1Var).f17773b;
                z11 = true;
            }
            arrayList.add(n0Var);
        }
        if (z10) {
            n0 n0VarJ = vp.x.j(l0.C("Intersection of error types: ", list));
            l0.o(n0VarJ, "createErrorType(\"Interse… of error types: $types\")");
            return n0VarJ;
        }
        if (!z11) {
            return w.f19879a.c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(c0.d((n1) it.next()));
        }
        w wVar = w.f19879a;
        return g0.d(wVar.c(arrayList), wVar.c(arrayList2));
    }
}
