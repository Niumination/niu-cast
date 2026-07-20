package wk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    @os.l
    public static final dk.a a(@os.l v vVar) {
        kn.l0.p(vVar, "<this>");
        if (vVar instanceof z) {
            return ((z) vVar).M;
        }
        v vVar2 = vVar.I;
        dk.a aVarA = vVar2 == null ? null : a(vVar2);
        if (aVarA != null) {
            return aVarA;
        }
        throw new UnsupportedOperationException("Cannot retrieve application from unattached routing entry");
    }

    @nl.a
    @os.l
    public static final z b(@os.l dk.a aVar, @os.l jn.l<? super z, l2> lVar) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(lVar, "configuration");
        z.a aVar2 = z.O;
        z zVar = (z) dk.i.b(aVar, aVar2);
        if (zVar == null) {
            zVar = null;
        } else {
            lVar.invoke(zVar);
        }
        return zVar == null ? (z) dk.i.c(aVar, aVar2, lVar) : zVar;
    }
}
