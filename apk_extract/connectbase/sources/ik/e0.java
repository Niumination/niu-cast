package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    @os.l
    public static final b0 a() {
        b0.f7939b.getClass();
        return b0.a.f7941b;
    }

    @os.l
    public static final b0 b(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new f0(str, nm.x.k(str2));
    }

    @os.l
    public static final b0 c(@os.l String str, @os.l List<String> list) {
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
        return new f0(str, list);
    }

    @os.l
    public static final b0 d(@os.l lm.t0<String, ? extends List<String>>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        return new d0(nm.d1.D0(nm.p.t(t0VarArr)));
    }
}
