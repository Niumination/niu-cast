package tl;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    @os.l
    public static final v a(int i10, @os.l jn.l<? super s, l2> lVar) {
        kn.l0.p(lVar, "block");
        s sVarA = w0.a(i10);
        try {
            lVar.invoke(sVarA);
            return sVarA.z2();
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static v b(int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        kn.l0.p(lVar, "block");
        s sVarA = w0.a(i10);
        try {
            lVar.invoke(sVarA);
            return sVarA.z2();
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static final void c(@os.l s sVar) {
        kn.l0.p(sVar, "<this>");
        sVar.close();
    }
}
