package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {
    public static final <R> R a(@os.l s sVar, @os.l jn.l<? super v, ? extends R> lVar) {
        kn.l0.p(sVar, "<this>");
        kn.l0.p(lVar, "block");
        v vVarB = b(sVar);
        try {
            return lVar.invoke(vVarB);
        } finally {
            vVarB.z2();
        }
    }

    @lm.z0
    @os.l
    public static final v b(@os.l s sVar) {
        kn.l0.p(sVar, "<this>");
        ul.b bVarL0 = sVar.l0();
        if (bVarL0 != ul.b.f16311i.a()) {
            return new v(n.c(bVarL0), sVar.f15806b);
        }
        v.f15884f.getClass();
        return v.f15885g;
    }
}
