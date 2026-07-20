package wo;

import eo.h1;
import eo.w0;
import eo.y0;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.h0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final void a(StringBuilder sb2, f0 f0Var) {
        sb2.append(g(f0Var));
    }

    @os.l
    public static final String b(@os.l eo.y yVar, boolean z10, boolean z11) {
        String strB;
        l0.p(yVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            if (yVar instanceof eo.l) {
                strB = "<init>";
            } else {
                strB = yVar.getName().b();
                l0.o(strB, "name.asString()");
            }
            sb2.append(strB);
        }
        sb2.append("(");
        w0 w0VarR = yVar.R();
        if (w0VarR != null) {
            f0 type = w0VarR.getType();
            l0.o(type, "it.type");
            a(sb2, type);
        }
        Iterator<h1> it = yVar.h().iterator();
        while (it.hasNext()) {
            f0 type2 = it.next().getType();
            l0.o(type2, "parameter.type");
            a(sb2, type2);
        }
        sb2.append(")");
        if (z10) {
            if (c.c(yVar)) {
                sb2.append("V");
            } else {
                f0 returnType = yVar.getReturnType();
                l0.m(returnType);
                l0.o(returnType, "returnType!!");
                a(sb2, returnType);
            }
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String c(eo.y yVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return b(yVar, z10, z11);
    }

    @os.m
    public static final String d(@os.l eo.a aVar) {
        l0.p(aVar, "<this>");
        w wVar = w.f19826a;
        if (hp.d.E(aVar)) {
            return null;
        }
        eo.m mVarB = aVar.b();
        eo.e eVar = mVarB instanceof eo.e ? (eo.e) mVarB : null;
        if (eVar == null || eVar.getName().f3821b) {
            return null;
        }
        eo.a aVarA = aVar.a();
        y0 y0Var = aVarA instanceof y0 ? (y0) aVarA : null;
        if (y0Var == null) {
            return null;
        }
        return t.a(wVar, eVar, c(y0Var, false, false, 3, null));
    }

    public static final boolean e(@os.l eo.a aVar) {
        eo.y yVarK;
        l0.p(aVar, "f");
        if (!(aVar instanceof eo.y)) {
            return false;
        }
        eo.y yVar = (eo.y) aVar;
        if (!l0.g(yVar.getName().b(), "remove") || yVar.h().size() != 1 || no.f0.h((eo.b) aVar)) {
            return false;
        }
        List<h1> listH = yVar.a().h();
        l0.o(listH, "f.original.valueParameters");
        f0 type = ((h1) h0.h5(listH)).getType();
        l0.o(type, "f.original.valueParameters.single().type");
        k kVarG = g(type);
        k.d dVar = kVarG instanceof k.d ? (k.d) kVarG : null;
        if ((dVar != null ? dVar.f19812j : null) != mp.e.INT || (yVarK = no.f.k(yVar)) == null) {
            return false;
        }
        List<h1> listH2 = yVarK.a().h();
        l0.o(listH2, "overridden.original.valueParameters");
        f0 type2 = ((h1) h0.h5(listH2)).getType();
        l0.o(type2, "overridden.original.valueParameters.single().type");
        k kVarG2 = g(type2);
        eo.m mVarB = yVarK.b();
        l0.o(mVarB, "overridden.containingDeclaration");
        return l0.g(lp.a.j(mVarB), ao.k.a.X.j()) && (kVarG2 instanceof k.c) && l0.g(((k.c) kVarG2).f19811j, "java/lang/Object");
    }

    @os.l
    public static final String f(@os.l eo.e eVar) {
        l0.p(eVar, "<this>");
        co.c cVar = co.c.f1685a;
        dp.d dVarJ = lp.a.i(eVar).j();
        l0.o(dVarJ, "fqNameSafe.toUnsafe()");
        dp.b bVarO = cVar.o(dVarJ);
        if (bVarO == null) {
            return c.b(eVar, null, 2, null);
        }
        String strF = mp.d.b(bVarO).f();
        l0.o(strF, "byClassId(it).internalName");
        return strF;
    }

    @os.l
    public static final k g(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return (k) c.e(f0Var, m.f19813a, z.f19832o, y.f19827a, null, null, 32, null);
    }
}
