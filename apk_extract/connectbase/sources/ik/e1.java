package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    @os.l
    public static final b1 a() {
        b1.f7942c.getClass();
        return b1.a.f7944b;
    }

    @os.l
    public static final b1 b(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new f1(str, nm.x.k(str2));
    }

    @os.l
    public static final b1 c(@os.l String str, @os.l List<String> list) {
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
        return new f1(str, list);
    }

    @os.l
    public static final b1 d(@os.l lm.t0<String, ? extends List<String>>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        return new d1(nm.d1.D0(nm.p.t(t0VarArr)), null, 2, null);
    }

    @os.l
    public static final b1 e(@os.l b1 b1Var, @os.l b1 b1Var2) {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(b1Var2, "other");
        if (b1Var.a() != b1Var2.a()) {
            throw new IllegalArgumentException("Cannot concatenate Parameters with case-sensitive and case-insensitive names");
        }
        if (b1Var.isEmpty()) {
            return b1Var2;
        }
        if (b1Var2.isEmpty()) {
            return b1Var;
        }
        b1.a aVar = b1.f7942c;
        c1 c1Var = new c1(0, null, 3, null);
        c1Var.b(b1Var);
        c1Var.b(b1Var2);
        return c1Var.f();
    }
}
