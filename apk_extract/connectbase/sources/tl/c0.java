package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {
    public static final long a(@os.l g0 g0Var, @os.l q0 q0Var) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(q0Var, "output");
        if (!(g0Var instanceof a) || !(q0Var instanceof c)) {
            return b(g0Var, q0Var);
        }
        long j10 = 0;
        while (true) {
            a aVar = (a) g0Var;
            ul.b bVarJ2 = aVar.J2();
            if (bVarJ2 != null) {
                long jO = n.o(bVarJ2) + j10;
                ((c) q0Var).o(bVarJ2);
                j10 = jO;
            } else if (aVar.i2(1) == null) {
                return j10;
            }
        }
    }

    public static final long b(g0 g0Var, q0 q0Var) {
        ul.b.f16311i.getClass();
        ul.b bVar = (ul.b) ul.b.f16315w.W0();
        long j10 = 0;
        while (true) {
            try {
                bVar.v0();
                int iH = i0.h(g0Var, bVar, 0, 2, null);
                if (iH == -1) {
                    ul.b.f16311i.getClass();
                    bVar.j2(ul.b.f16315w);
                    return j10;
                }
                j10 += (long) iH;
                s0.p(q0Var, bVar, 0, 2, null);
            } catch (Throwable th2) {
                ul.b.f16311i.getClass();
                bVar.j2(ul.b.f16315w);
                throw th2;
            }
        }
    }
}
