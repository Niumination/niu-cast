package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    public static final double a(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i10 = bVar.f15801d;
            int i11 = bVar.f15800c;
            if (i10 - i11 > 8) {
                bVar.f15800c = i11 + 8;
                return bVar.f15799b.getDouble(i11);
            }
        }
        return b(g0Var);
    }

    public static final double b(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        ul.b bVarJ = ul.k.j(g0Var, 8);
        if (bVarJ == null) {
            throw pl.h.a(8);
        }
        double dZ = l.z(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return dZ;
    }

    public static final float c(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i10 = bVar.f15801d;
            int i11 = bVar.f15800c;
            if (i10 - i11 > 4) {
                bVar.f15800c = i11 + 4;
                return bVar.f15799b.getFloat(i11);
            }
        }
        return d(g0Var);
    }

    public static final float d(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        ul.b bVarJ = ul.k.j(g0Var, 4);
        if (bVarJ == null) {
            throw pl.h.a(4);
        }
        float fC = l.C(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return fC;
    }

    public static final int e(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i10 = bVar.f15801d;
            int i11 = bVar.f15800c;
            if (i10 - i11 > 4) {
                bVar.f15800c = i11 + 4;
                return bVar.f15799b.getInt(i11);
            }
        }
        return f(g0Var);
    }

    public static final int f(g0 g0Var) {
        ul.b bVarJ = ul.k.j(g0Var, 4);
        if (bVarJ == null) {
            throw pl.h.a(4);
        }
        int iC0 = l.c0(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return iC0;
    }

    public static final long g(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i10 = bVar.f15801d;
            int i11 = bVar.f15800c;
            if (i10 - i11 > 8) {
                bVar.f15800c = i11 + 8;
                return bVar.f15799b.getLong(i11);
            }
        }
        return h(g0Var);
    }

    public static final long h(g0 g0Var) {
        ul.b bVarJ = ul.k.j(g0Var, 8);
        if (bVarJ == null) {
            throw pl.h.a(8);
        }
        long jE0 = l.e0(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return jE0;
    }

    public static final <R> R i(g0 g0Var, int i10, jn.p<? super ql.f, ? super Integer, ? extends R> pVar, jn.a<? extends R> aVar) {
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i11 = bVar.f15801d;
            int i12 = bVar.f15800c;
            if (i11 - i12 > i10) {
                bVar.f15800c = i10 + i12;
                return pVar.invoke(ql.f.b(bVar.f15799b), Integer.valueOf(i12));
            }
        }
        return aVar.invoke();
    }

    public static final <R> R j(g0 g0Var, int i10, jn.l<? super e, ? extends R> lVar) {
        ul.b bVarJ = ul.k.j(g0Var, i10);
        if (bVarJ == null) {
            throw pl.h.a(i10);
        }
        R rInvoke = lVar.invoke(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return rInvoke;
    }

    public static final short k(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        if (g0Var instanceof a) {
            b bVar = ((a) g0Var).f15790b;
            int i10 = bVar.f15801d;
            int i11 = bVar.f15800c;
            if (i10 - i11 > 2) {
                bVar.f15800c = i11 + 2;
                return bVar.f15799b.getShort(i11);
            }
        }
        return l(g0Var);
    }

    public static final short l(g0 g0Var) {
        ul.b bVarJ = ul.k.j(g0Var, 2);
        if (bVarJ == null) {
            throw pl.h.a(2);
        }
        short sG0 = l.g0(bVarJ);
        ul.k.e(g0Var, bVarJ);
        return sG0;
    }
}
