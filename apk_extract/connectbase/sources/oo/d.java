package oo;

import eo.h0;
import eo.h1;
import fo.m;
import fo.n;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.t0;
import nm.d0;
import nm.d1;
import nm.m0;
import nm.z;
import os.l;
import vp.f0;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final d f12343a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Map<String, EnumSet<n>> f12344b = d1.W(new t0("PACKAGE", EnumSet.noneOf(n.class)), new t0("TYPE", EnumSet.of(n.CLASS, n.FILE)), new t0("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), new t0("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), new t0("FIELD", EnumSet.of(n.FIELD)), new t0("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), new t0("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), new t0("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), new t0("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), new t0("TYPE_USE", EnumSet.of(n.TYPE)));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final Map<String, m> f12345c = d1.W(new t0("RUNTIME", m.RUNTIME), new t0("CLASS", m.BINARY), new t0("SOURCE", m.SOURCE));

    public static final class a extends n0 implements jn.l<h0, f0> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @l
        public final f0 invoke(@l h0 h0Var) {
            f0 type;
            String str;
            l0.p(h0Var, "module");
            c.f12337a.getClass();
            h1 h1VarB = oo.a.b(c.f12339c, h0Var.n().o(ao.k.a.F));
            if (h1VarB == null) {
                type = x.j("Error: AnnotationTarget[]");
                str = "createErrorType(\"Error: AnnotationTarget[]\")";
            } else {
                type = h1VarB.getType();
                str = "parameterDescriptor?.typ…ror: AnnotationTarget[]\")";
            }
            l0.o(type, str);
            return type;
        }
    }

    @os.m
    public final jp.g<?> a(@os.m uo.b bVar) {
        uo.m mVar = bVar instanceof uo.m ? (uo.m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, m> map = f12345c;
        dp.f fVarE = mVar.e();
        m mVar2 = map.get(fVarE == null ? null : fVarE.b());
        if (mVar2 == null) {
            return null;
        }
        dp.b bVarM = dp.b.m(ao.k.a.H);
        l0.o(bVarM, "topLevel(StandardNames.F…ames.annotationRetention)");
        dp.f fVarK = dp.f.k(mVar2.name());
        l0.o(fVarK, "identifier(retention.name)");
        return new jp.j(bVarM, fVarK);
    }

    @l
    public final Set<n> b(@os.m String str) {
        EnumSet<n> enumSet = f12344b.get(str);
        return enumSet == null ? m0.INSTANCE : enumSet;
    }

    @l
    public final jp.g<?> c(@l List<? extends uo.b> list) {
        l0.p(list, "arguments");
        ArrayList<uo.m> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof uo.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<n> arrayList2 = new ArrayList();
        for (uo.m mVar : arrayList) {
            d dVar = f12343a;
            dp.f fVarE = mVar.e();
            d0.r0(arrayList2, dVar.b(fVarE == null ? null : fVarE.b()));
        }
        ArrayList arrayList3 = new ArrayList(z.b0(arrayList2, 10));
        for (n nVar : arrayList2) {
            dp.b bVarM = dp.b.m(ao.k.a.G);
            l0.o(bVarM, "topLevel(StandardNames.FqNames.annotationTarget)");
            dp.f fVarK = dp.f.k(nVar.name());
            l0.o(fVarK, "identifier(kotlinTarget.name)");
            arrayList3.add(new jp.j(bVarM, fVarK));
        }
        return new jp.b(arrayList3, a.INSTANCE);
    }
}
