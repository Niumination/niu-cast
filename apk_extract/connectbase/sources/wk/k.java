package wk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    @os.l
    public static final v a(@os.l v vVar, int i10, @os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(lVar, "build");
        if (1 > i10 || i10 >= 65536) {
            throw new IllegalArgumentException(k.b.a("Port ", i10, " must be a positive number between 1 and 65,535").toString());
        }
        v vVarY = vVar.Y(new j(i10));
        lVar.invoke(vVarY);
        return vVarY;
    }
}
