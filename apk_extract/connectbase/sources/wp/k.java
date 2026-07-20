package wp;

import androidx.core.app.NotificationCompat;
import eo.e1;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.t0;
import nm.h0;
import nm.z;
import vp.b1;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.h1;
import vp.n0;
import vp.n1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final List<c1> a(n1 n1Var, yp.b bVar) {
        if (n1Var.F0().size() != n1Var.G0().getParameters().size()) {
            return null;
        }
        List<c1> listF0 = n1Var.F0();
        List<c1> list = listF0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((c1) it.next()).c() != o1.INVARIANT) {
                    List<e1> parameters = n1Var.G0().getParameters();
                    l0.o(parameters, "type.constructor.parameters");
                    List<t0> listI6 = h0.i6(list, parameters);
                    ArrayList arrayList = new ArrayList(z.b0(listI6, 10));
                    for (t0 t0Var : listI6) {
                        c1 c1VarA = (c1) t0Var.component1();
                        e1 e1Var = (e1) t0Var.component2();
                        if (c1VarA.c() != o1.INVARIANT) {
                            n1 n1VarJ0 = (c1VarA.a() || c1VarA.c() != o1.IN_VARIANCE) ? null : c1VarA.getType().J0();
                            l0.o(e1Var, "parameter");
                            c1VarA = zp.a.a(new i(bVar, n1VarJ0, c1VarA, e1Var));
                        }
                        arrayList.add(c1VarA);
                    }
                    h1 h1VarC = b1.f17666c.b(n1Var.G0(), arrayList).c();
                    int size = listF0.size();
                    int i10 = 0;
                    while (i10 < size) {
                        int i11 = i10 + 1;
                        c1 c1Var = listF0.get(i10);
                        c1 c1Var2 = (c1) arrayList.get(i10);
                        if (c1Var.c() != o1.INVARIANT) {
                            List<f0> upperBounds = n1Var.G0().getParameters().get(i10).getUpperBounds();
                            l0.o(upperBounds, "type.constructor.parameters[index].upperBounds");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(f.a.f19852a.a(h1VarC.n((f0) it2.next(), o1.INVARIANT).J0()));
                            }
                            if (!c1Var.a() && c1Var.c() == o1.OUT_VARIANCE) {
                                arrayList2.add(f.a.f19852a.a(c1Var.getType().J0()));
                            }
                            ((i) c1Var2.getType()).f19856c.i(arrayList2);
                        }
                        i10 = i11;
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    @os.m
    public static final n0 b(@os.l n0 n0Var, @os.l yp.b bVar) {
        l0.p(n0Var, y0.a.f8215h);
        l0.p(bVar, NotificationCompat.CATEGORY_STATUS);
        List<c1> listA = a(n0Var, bVar);
        if (listA == null) {
            return null;
        }
        return c(n0Var, listA);
    }

    public static final n0 c(n1 n1Var, List<? extends c1> list) {
        return g0.j(n1Var.getAnnotations(), n1Var.G0(), list, n1Var.H0(), null, 16, null);
    }
}
