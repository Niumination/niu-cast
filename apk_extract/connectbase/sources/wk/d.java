package wk;

import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @os.l
    public static final v a(@os.l v vVar, @os.l String str, int i10, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(str, "host");
        kn.l0.p(lVar, "build");
        List listK = nm.x.k(str);
        nm.k0 k0Var = nm.k0.INSTANCE;
        return b(vVar, listK, k0Var, i10 > 0 ? nm.x.k(Integer.valueOf(i10)) : k0Var, lVar);
    }

    @os.l
    public static final v b(@os.l v vVar, @os.l List<String> list, @os.l List<jq.r> list2, @os.l List<Integer> list3, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(list, "hosts");
        kn.l0.p(list2, "hostPatterns");
        kn.l0.p(list3, "ports");
        kn.l0.p(lVar, "build");
        v vVarY = vVar.Y(new c(list, list2, list3));
        lVar.invoke(vVarY);
        return vVarY;
    }

    @os.l
    public static final v c(@os.l v vVar, @os.l List<String> list, @os.l List<Integer> list2, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(list, "hosts");
        kn.l0.p(list2, "ports");
        kn.l0.p(lVar, "build");
        return b(vVar, list, nm.k0.INSTANCE, list2, lVar);
    }

    @os.l
    public static final v d(@os.l v vVar, @os.l jq.r rVar, int i10, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(rVar, "hostPattern");
        kn.l0.p(lVar, "build");
        nm.k0 k0Var = nm.k0.INSTANCE;
        return b(vVar, k0Var, nm.x.k(rVar), i10 > 0 ? nm.x.k(Integer.valueOf(i10)) : k0Var, lVar);
    }

    public static /* synthetic */ v e(v vVar, String str, int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return a(vVar, str, i10, lVar);
    }

    public static v f(v vVar, List list, List list2, List list3, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list3 = nm.k0.INSTANCE;
        }
        return b(vVar, list, list2, list3, lVar);
    }

    public static v g(v vVar, List list, List list2, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list2 = nm.k0.INSTANCE;
        }
        return c(vVar, list, list2, lVar);
    }

    public static /* synthetic */ v h(v vVar, jq.r rVar, int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return d(vVar, rVar, i10, lVar);
    }

    @os.l
    public static final v i(@os.l v vVar, @os.l int[] iArr, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(iArr, "ports");
        kn.l0.p(lVar, "build");
        if (iArr.length == 0) {
            throw new IllegalArgumentException("At least one port need to be specified");
        }
        nm.k0 k0Var = nm.k0.INSTANCE;
        v vVarY = vVar.Y(new c(k0Var, k0Var, nm.r.Iy(iArr)));
        lVar.invoke(vVarY);
        return vVarY;
    }
}
