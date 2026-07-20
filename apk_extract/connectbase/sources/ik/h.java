package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    @os.l
    public static final String a(@os.m tn.o oVar, @os.m Long l10, @os.l i1 i1Var) {
        kn.l0.p(i1Var, "unit");
        return b(oVar, l10, i1Var.getUnitToken());
    }

    @os.l
    public static final String b(@os.m tn.o oVar, @os.m Long l10, @os.l String str) {
        kn.l0.p(str, "unit");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" ");
        if (oVar != null) {
            sb2.append(oVar.f15921a);
            sb2.append('-');
            sb2.append(oVar.f15922b);
        } else {
            sb2.append(kl.f.f9277j);
        }
        sb2.append(el.b0.f4502a);
        Object obj = l10;
        if (l10 == null) {
            obj = "*";
        }
        sb2.append(obj);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String c(tn.o oVar, Long l10, i1 i1Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            i1Var = i1.Bytes;
        }
        return a(oVar, l10, i1Var);
    }

    public static /* synthetic */ String d(tn.o oVar, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = i1.Bytes.getUnitToken();
        }
        return b(oVar, l10, str);
    }
}
