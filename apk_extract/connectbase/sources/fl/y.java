package fl;

import java.util.Iterator;
import nq.l2;
import nq.l3;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    public static final class a extends um.a implements nq.o0 {
        public a(nq.o0.b bVar) {
            super(bVar);
        }

        @Override // nq.o0
        public void g0(@os.l um.g gVar, @os.l Throwable th2) {
        }
    }

    @t0
    @os.l
    public static final um.g a(@os.m l2 l2Var) {
        return um.g.b.a.d(new l3(l2Var), new a((um.g.c<?>) nq.o0.f11887j));
    }

    public static /* synthetic */ um.g b(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return a(l2Var);
    }

    @t0
    public static final void c(@os.l l2 l2Var, int i10) {
        kn.l0.p(l2Var, "<this>");
        System.out.println((Object) kn.l0.C(jq.e0.e2(" ", i10), l2Var));
        Iterator<l2> it = l2Var.y().iterator();
        while (it.hasNext()) {
            c(it.next(), i10 + 2);
        }
        if (i10 == 0) {
            System.out.println();
        }
    }

    public static /* synthetic */ void d(l2 l2Var, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        c(l2Var, i10);
    }
}
