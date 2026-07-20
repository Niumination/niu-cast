package no;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final v f11727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.h<eo.e, fo.c> f11728b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final fo.c f11729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11730b;

        public a(@os.l fo.c cVar, int i10) {
            l0.p(cVar, "typeQualifier");
            this.f11729a = cVar;
            this.f11730b = i10;
        }

        @os.l
        public final fo.c a() {
            return this.f11729a;
        }

        @os.l
        public final List<no.a> b() {
            no.a[] aVarArrValues = no.a.values();
            ArrayList arrayList = new ArrayList();
            int length = aVarArrValues.length;
            int i10 = 0;
            while (i10 < length) {
                no.a aVar = aVarArrValues[i10];
                i10++;
                if (d(aVar)) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }

        public final boolean c(no.a aVar) {
            return (this.f11730b & (1 << aVar.ordinal())) != 0;
        }

        public final boolean d(no.a aVar) {
            if (c(aVar)) {
                return true;
            }
            return c(no.a.TYPE_USE) && aVar != no.a.TYPE_PARAMETER_BOUNDS;
        }
    }

    public static final class b extends n0 implements jn.p<jp.j, no.a, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l jp.j jVar, @os.l no.a aVar) {
            l0.p(jVar, "$this$mapConstantToQualifierApplicabilityTypes");
            l0.p(aVar, "it");
            return Boolean.valueOf(l0.g(jVar.f8777c.f(), aVar.getJavaTarget()));
        }
    }

    /* JADX INFO: renamed from: no.c$c, reason: collision with other inner class name */
    public static final class C0301c extends n0 implements jn.p<jp.j, no.a, Boolean> {
        public C0301c() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l jp.j jVar, @os.l no.a aVar) {
            l0.p(jVar, "$this$mapConstantToQualifierApplicabilityTypes");
            l0.p(aVar, "it");
            return Boolean.valueOf(c.this.p(aVar.getJavaTarget()).contains(jVar.f8777c.f()));
        }
    }

    public /* synthetic */ class d extends kn.g0 implements jn.l<eo.e, fo.c> {
        public d(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(c.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // jn.l
        @os.m
        public final fo.c invoke(@os.l eo.e eVar) {
            l0.p(eVar, "p0");
            return ((c) this.receiver).c(eVar);
        }
    }

    public c(@os.l up.n nVar, @os.l v vVar) {
        l0.p(nVar, "storageManager");
        l0.p(vVar, "javaTypeEnhancementState");
        this.f11727a = vVar;
        this.f11728b = nVar.f(new d(this));
    }

    public final fo.c c(eo.e eVar) {
        if (!eVar.getAnnotations().p(no.b.g())) {
            return null;
        }
        Iterator<fo.c> it = eVar.getAnnotations().iterator();
        while (it.hasNext()) {
            fo.c cVarM = m(it.next());
            if (cVarM != null) {
                return cVarM;
            }
        }
        return null;
    }

    public final List<no.a> d(jp.g<?> gVar, jn.p<? super jp.j, ? super no.a, Boolean> pVar) {
        no.a aVar;
        if (gVar instanceof jp.b) {
            List<? extends jp.g<?>> listB = ((jp.b) gVar).b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                nm.d0.r0(arrayList, d((jp.g) it.next(), pVar));
            }
            return arrayList;
        }
        if (!(gVar instanceof jp.j)) {
            return k0.INSTANCE;
        }
        no.a[] aVarArrValues = no.a.values();
        int length = aVarArrValues.length;
        int i10 = 0;
        while (i10 < length) {
            aVar = aVarArrValues[i10];
            i10++;
            if (pVar.invoke(gVar, aVar).booleanValue()) {
                return nm.y.P(aVar);
            }
        }
        aVar = null;
        return nm.y.P(aVar);
    }

    public final List<no.a> e(jp.g<?> gVar) {
        return d(gVar, b.INSTANCE);
    }

    public final List<no.a> f(jp.g<?> gVar) {
        return d(gVar, new C0301c());
    }

    public final e0 g(eo.e eVar) {
        fo.c cVarD = eVar.getAnnotations().d(no.b.d());
        jp.g<?> gVarB = cVarD == null ? null : lp.a.b(cVarD);
        jp.j jVar = gVarB instanceof jp.j ? (jp.j) gVarB : null;
        if (jVar == null) {
            return null;
        }
        e0 e0Var = this.f11727a.f11787a.f11792b;
        if (e0Var != null) {
            return e0Var;
        }
        String strB = jVar.f8777c.b();
        int iHashCode = strB.hashCode();
        if (iHashCode == -2137067054) {
            if (strB.equals("IGNORE")) {
                return e0.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strB.equals("STRICT")) {
                return e0.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strB.equals("WARN")) {
            return e0.WARN;
        }
        return null;
    }

    @os.m
    public final a h(@os.l fo.c cVar) {
        l0.p(cVar, "annotationDescriptor");
        eo.e eVarF = lp.a.f(cVar);
        if (eVarF == null) {
            return null;
        }
        fo.g annotations = eVarF.getAnnotations();
        dp.c cVar2 = z.f11803d;
        l0.o(cVar2, "TARGET_ANNOTATION");
        fo.c cVarD = annotations.d(cVar2);
        if (cVarD == null) {
            return null;
        }
        Map<dp.f, jp.g<?>> mapA = cVarD.a();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<dp.f, jp.g<?>>> it = mapA.entrySet().iterator();
        while (it.hasNext()) {
            nm.d0.r0(arrayList, f(it.next().getValue()));
        }
        Iterator it2 = arrayList.iterator();
        int iOrdinal = 0;
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((no.a) it2.next()).ordinal();
        }
        return new a(cVar, iOrdinal);
    }

    public final e0 i(fo.c cVar) {
        dp.c cVarE = cVar.e();
        return (cVarE == null || !no.b.c().containsKey(cVarE)) ? j(cVar) : this.f11727a.f11788b.invoke(cVarE);
    }

    @os.l
    public final e0 j(@os.l fo.c cVar) {
        l0.p(cVar, "annotationDescriptor");
        e0 e0VarK = k(cVar);
        return e0VarK == null ? this.f11727a.f11787a.f11791a : e0VarK;
    }

    @os.m
    public final e0 k(@os.l fo.c cVar) {
        l0.p(cVar, "annotationDescriptor");
        e0 e0Var = this.f11727a.f11787a.f11793c.get(cVar.e());
        if (e0Var != null) {
            return e0Var;
        }
        eo.e eVarF = lp.a.f(cVar);
        if (eVarF == null) {
            return null;
        }
        return g(eVarF);
    }

    @os.m
    public final q l(@os.l fo.c cVar) {
        q qVar;
        l0.p(cVar, "annotationDescriptor");
        if (this.f11727a.f11789c || (qVar = no.b.a().get(cVar.e())) == null) {
            return null;
        }
        e0 e0VarI = i(cVar);
        if (e0VarI == e0.IGNORE) {
            e0VarI = null;
        }
        if (e0VarI == null) {
            return null;
        }
        return q.b(qVar, vo.h.b(qVar.f11768a, null, e0VarI.isWarning(), 1, null), null, false, 6, null);
    }

    @os.m
    public final fo.c m(@os.l fo.c cVar) {
        eo.e eVarF;
        l0.p(cVar, "annotationDescriptor");
        if (this.f11727a.f11787a.f11795e || (eVarF = lp.a.f(cVar)) == null) {
            return null;
        }
        return no.d.b(eVarF) ? cVar : o(eVarF);
    }

    @os.m
    public final a n(@os.l fo.c cVar) {
        fo.c next;
        l0.p(cVar, "annotationDescriptor");
        if (this.f11727a.f11787a.f11795e) {
            return null;
        }
        eo.e eVarF = lp.a.f(cVar);
        if (eVarF == null || !eVarF.getAnnotations().p(no.b.e())) {
            eVarF = null;
        }
        if (eVarF == null) {
            return null;
        }
        eo.e eVarF2 = lp.a.f(cVar);
        l0.m(eVarF2);
        fo.c cVarD = eVarF2.getAnnotations().d(no.b.e());
        l0.m(cVarD);
        Map<dp.f, jp.g<?>> mapA = cVarD.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<dp.f, jp.g<?>> entry : mapA.entrySet()) {
            nm.d0.r0(arrayList, l0.g(entry.getKey(), z.f11802c) ? d(entry.getValue(), b.INSTANCE) : k0.INSTANCE);
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((no.a) it.next()).ordinal();
        }
        Iterator<fo.c> it2 = eVarF.getAnnotations().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (m(next) == null);
        fo.c cVar2 = next;
        if (cVar2 == null) {
            return null;
        }
        return new a(cVar2, iOrdinal);
    }

    public final fo.c o(eo.e eVar) {
        if (eVar.getKind() != eo.f.ANNOTATION_CLASS) {
            return null;
        }
        return this.f11728b.invoke(eVar);
    }

    public final List<String> p(String str) {
        Set<fo.n> setB = oo.d.f12343a.b(str);
        ArrayList arrayList = new ArrayList(nm.z.b0(setB, 10));
        Iterator<T> it = setB.iterator();
        while (it.hasNext()) {
            arrayList.add(((fo.n) it.next()).name());
        }
        return arrayList;
    }
}
