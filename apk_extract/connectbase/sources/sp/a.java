package sp;

import el.b0;
import fp.g;
import fp.i;
import java.util.List;
import jq.e0;
import kn.l0;
import lm.l2;
import n1.e;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends qp.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final a f15197n = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        g gVarD = g.d();
        zo.b.a(gVarD);
        l2 l2Var = l2.f10208a;
        l0.o(gVarD, "newInstance().apply(Buil…f::registerAllExtensions)");
        i.g<yo.a.l, Integer> gVar = zo.b.f21952a;
        l0.o(gVar, "packageFqName");
        i.g<yo.a.d, List<yo.a.b>> gVar2 = zo.b.f21954c;
        l0.o(gVar2, "constructorAnnotation");
        i.g<yo.a.c, List<yo.a.b>> gVar3 = zo.b.f21953b;
        l0.o(gVar3, "classAnnotation");
        i.g<yo.a.i, List<yo.a.b>> gVar4 = zo.b.f21955d;
        l0.o(gVar4, "functionAnnotation");
        i.g<yo.a.n, List<yo.a.b>> gVar5 = zo.b.f21956e;
        l0.o(gVar5, "propertyAnnotation");
        i.g<yo.a.n, List<yo.a.b>> gVar6 = zo.b.f21957f;
        l0.o(gVar6, "propertyGetterAnnotation");
        i.g<yo.a.n, List<yo.a.b>> gVar7 = zo.b.f21958g;
        l0.o(gVar7, "propertySetterAnnotation");
        i.g<yo.a.g, List<yo.a.b>> gVar8 = zo.b.f21960i;
        l0.o(gVar8, "enumEntryAnnotation");
        i.g<yo.a.n, yo.a.b.C0559b.c> gVar9 = zo.b.f21959h;
        l0.o(gVar9, "compileTimeValue");
        i.g<yo.a.u, List<yo.a.b>> gVar10 = zo.b.f21961j;
        l0.o(gVar10, "parameterAnnotation");
        i.g<yo.a.q, List<yo.a.b>> gVar11 = zo.b.f21962k;
        l0.o(gVar11, "typeAnnotation");
        i.g<yo.a.s, List<yo.a.b>> gVar12 = zo.b.f21963l;
        l0.o(gVar12, "typeParameterAnnotation");
        super(gVarD, gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11, gVar12);
    }

    @l
    public final String m(@l dp.c cVar) {
        l0.p(cVar, "fqName");
        return l0.C(o(cVar), ".kotlin_builtins");
    }

    @l
    public final String n(@l dp.c cVar) {
        l0.p(cVar, "fqName");
        StringBuilder sb2 = new StringBuilder();
        String strB = cVar.b();
        l0.o(strB, "fqName.asString()");
        sb2.append(e0.h2(strB, e.f11183c, b0.f4502a, false, 4, null));
        sb2.append(b0.f4502a);
        sb2.append(m(cVar));
        return sb2.toString();
    }

    public final String o(dp.c cVar) {
        if (cVar.d()) {
            return "default-package";
        }
        String strB = cVar.g().b();
        l0.o(strB, "fqName.shortName().asString()");
        return strB;
    }
}
