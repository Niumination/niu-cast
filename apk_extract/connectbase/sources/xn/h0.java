package xn;

import eo.w0;
import eo.z0;
import ik.y0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.m0;
import kn.j1;
import kn.l0;
import kn.n1;
import lm.t0;
import nm.d1;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final dp.c f20360a = new dp.c("kotlin.jvm.JvmStatic");

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20361a;

        static {
            int[] iArr = new int[ao.i.values().length];
            iArr[ao.i.BOOLEAN.ordinal()] = 1;
            iArr[ao.i.CHAR.ordinal()] = 2;
            iArr[ao.i.BYTE.ordinal()] = 3;
            iArr[ao.i.SHORT.ordinal()] = 4;
            iArr[ao.i.INT.ordinal()] = 5;
            iArr[ao.i.FLOAT.ordinal()] = 6;
            iArr[ao.i.LONG.ordinal()] = 7;
            iArr[ao.i.DOUBLE.ordinal()] = 8;
            f20361a = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v15, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v19, types: [byte[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v25, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v27, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v30, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(jp.b r6, java.lang.ClassLoader r7) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xn.h0.a(jp.b, java.lang.ClassLoader):java.lang.Object");
    }

    @os.m
    public static final f<?> b(@os.m Object obj) {
        f<?> fVar = obj instanceof f ? (f) obj : null;
        if (fVar != null) {
            return fVar;
        }
        k kVarC = c(obj);
        return kVarC == null ? d(obj) : kVarC;
    }

    @os.m
    public static final k c(@os.m Object obj) {
        k kVar = obj instanceof k ? (k) obj : null;
        if (kVar != null) {
            return kVar;
        }
        kn.g0 g0Var = obj instanceof kn.g0 ? (kn.g0) obj : null;
        un.c cVarCompute = g0Var == null ? null : g0Var.compute();
        if (cVarCompute instanceof k) {
            return (k) cVarCompute;
        }
        return null;
    }

    @os.m
    public static final t<?> d(@os.m Object obj) {
        t<?> tVar = obj instanceof t ? (t) obj : null;
        if (tVar != null) {
            return tVar;
        }
        j1 j1Var = obj instanceof j1 ? (j1) obj : null;
        un.c cVarCompute = j1Var == null ? null : j1Var.compute();
        if (cVarCompute instanceof t) {
            return (t) cVarCompute;
        }
        return null;
    }

    @os.l
    public static final List<Annotation> e(@os.l fo.a aVar) {
        Annotation annotationO;
        l0.p(aVar, "<this>");
        fo.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (fo.c cVar : annotations) {
            z0 source = cVar.getSource();
            if (source instanceof jo.b) {
                annotationO = ((jo.b) source).f8755b;
            } else if (source instanceof jo.l.a) {
                ko.p pVar = ((jo.l.a) source).f8769b;
                ko.e eVar = pVar instanceof ko.e ? (ko.e) pVar : null;
                annotationO = eVar == null ? null : eVar.f9419a;
            } else {
                annotationO = o(cVar);
            }
            if (annotationO != null) {
                arrayList.add(annotationO);
            }
        }
        return s(arrayList);
    }

    @os.l
    public static final Class<?> f(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    @os.m
    public static final Object g(@os.l Type type) {
        l0.p(type, y0.a.f8215h);
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (l0.g(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (l0.g(type, Character.TYPE)) {
            return (char) 0;
        }
        if (l0.g(type, Byte.TYPE)) {
            return (byte) 0;
        }
        if (l0.g(type, Short.TYPE)) {
            return (short) 0;
        }
        if (l0.g(type, Integer.TYPE)) {
            return 0;
        }
        if (l0.g(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (l0.g(type, Long.TYPE)) {
            return 0L;
        }
        if (l0.g(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (l0.g(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException(l0.C("Unknown primitive: ", type));
    }

    @os.l
    public static final <M extends fp.q, D extends eo.a> D h(@os.l Class<?> cls, @os.l M m10, @os.l ap.c cVar, @os.l ap.g gVar, @os.l ap.a aVar, @os.l jn.p<? super rp.w, ? super M, ? extends D> pVar) {
        List<yo.a.s> typeParameterList;
        l0.p(cls, "moduleAnchor");
        l0.p(m10, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar, "typeTable");
        l0.p(aVar, "metadataVersion");
        l0.p(pVar, "createDescriptor");
        jo.k kVarB = z.b(cls);
        if (m10 instanceof yo.a.i) {
            typeParameterList = ((yo.a.i) m10).getTypeParameterList();
        } else {
            if (!(m10 instanceof yo.a.n)) {
                throw new IllegalStateException(l0.C("Unsupported message: ", m10).toString());
            }
            typeParameterList = ((yo.a.n) m10).getTypeParameterList();
        }
        List<yo.a.s> list = typeParameterList;
        rp.j jVar = kVarB.f8766a;
        eo.h0 h0Var = jVar.f14728b;
        ap.h.f672b.getClass();
        ap.h hVar = ap.h.f673c;
        l0.o(list, "typeParameters");
        return pVar.invoke(new rp.w(new rp.l(jVar, cVar, h0Var, gVar, hVar, aVar, null, null, list)), m10);
    }

    @os.m
    public static final w0 i(@os.l eo.a aVar) {
        l0.p(aVar, "<this>");
        if (aVar.O() != null) {
            return ((eo.e) aVar.b()).D0();
        }
        return null;
    }

    @os.l
    public static final dp.c j() {
        return f20360a;
    }

    public static final boolean k(@os.l un.s sVar) {
        l0.p(sVar, "<this>");
        v vVar = sVar instanceof v ? (v) sVar : null;
        return vVar != null && hp.f.c(vVar.f20427a);
    }

    public static final Class<?> l(ClassLoader classLoader, dp.b bVar, int i10) {
        co.c cVar = co.c.f1685a;
        dp.d dVarJ = bVar.b().j();
        l0.o(dVarJ, "kotlinClassId.asSingleFqName().toUnsafe()");
        dp.b bVarO = cVar.o(dVarJ);
        if (bVarO != null) {
            bVar = bVarO;
        }
        String strB = bVar.h().b();
        l0.o(strB, "javaClassId.packageFqName.asString()");
        String strB2 = bVar.i().b();
        l0.o(strB2, "javaClassId.relativeClassName.asString()");
        return m(classLoader, strB, strB2, i10);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class<?> m(ClassLoader classLoader, String str, String str2, int i10) {
        if (l0.g(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + n1.e.f11183c + jq.e0.h2(str2, n1.e.f11183c, m0.f8865c, false, 4, null);
        if (i10 > 0) {
            str3 = jq.e0.e2("[", i10) + 'L' + str3 + ';';
        }
        return jo.e.a(classLoader, str3);
    }

    public static /* synthetic */ Class n(ClassLoader classLoader, dp.b bVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return l(classLoader, bVar, i10);
    }

    public static final Annotation o(fo.c cVar) {
        eo.e eVarF = lp.a.f(cVar);
        Class<?> clsP = eVarF == null ? null : p(eVarF);
        if (clsP == null) {
            clsP = null;
        }
        if (clsP == null) {
            return null;
        }
        Set<Map.Entry<dp.f, jp.g<?>>> setEntrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            dp.f fVar = (dp.f) entry.getKey();
            jp.g gVar = (jp.g) entry.getValue();
            ClassLoader classLoader = clsP.getClassLoader();
            l0.o(classLoader, "annotationClass.classLoader");
            Object objR = r(gVar, classLoader);
            t0 t0Var = objR == null ? null : new t0(fVar.b(), objR);
            if (t0Var != null) {
                arrayList.add(t0Var);
            }
        }
        return (Annotation) yn.b.g(clsP, d1.D0(arrayList), null, 4, null);
    }

    @os.m
    public static final Class<?> p(@os.l eo.e eVar) {
        l0.p(eVar, "<this>");
        z0 source = eVar.getSource();
        l0.o(source, "source");
        if (source instanceof wo.r) {
            return ((jo.f) ((wo.r) source).f19819b).f8759a;
        }
        if (source instanceof jo.l.a) {
            return ((ko.l) ((jo.l.a) source).f8769b).f9428a;
        }
        dp.b bVarH = lp.a.h(eVar);
        if (bVarH == null) {
            return null;
        }
        return l(ko.d.f(eVar.getClass()), bVarH, 0);
    }

    @os.m
    public static final un.w q(@os.l eo.u uVar) {
        l0.p(uVar, "<this>");
        if (l0.g(uVar, eo.t.f4633e)) {
            return un.w.PUBLIC;
        }
        if (l0.g(uVar, eo.t.f4631c)) {
            return un.w.PROTECTED;
        }
        if (l0.g(uVar, eo.t.f4632d)) {
            return un.w.INTERNAL;
        }
        if (l0.g(uVar, eo.t.f4629a) ? true : l0.g(uVar, eo.t.f4630b)) {
            return un.w.PRIVATE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object r(jp.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof jp.a) {
            return o((fo.c) ((jp.a) gVar).f8774a);
        }
        if (gVar instanceof jp.b) {
            return a((jp.b) gVar, classLoader);
        }
        if (gVar instanceof jp.j) {
            t0 t0Var = (t0) ((jp.j) gVar).f8774a;
            dp.b bVar = (dp.b) t0Var.component1();
            dp.f fVar = (dp.f) t0Var.component2();
            Class clsN = n(classLoader, bVar, 0, 4, null);
            if (clsN != null) {
                return Enum.valueOf(clsN, fVar.b());
            }
        } else if (gVar instanceof jp.q) {
            jp.q.b bVar2 = (jp.q.b) ((jp.q) gVar).f8774a;
            if (bVar2 instanceof jp.q.b.C0228b) {
                jp.f fVar2 = ((jp.q.b.C0228b) bVar2).f8793a;
                return l(classLoader, fVar2.f8772a, fVar2.f8773b);
            }
            if (!(bVar2 instanceof jp.q.b.a)) {
                throw new lm.i0();
            }
            eo.h hVarD = ((jp.q.b.a) bVar2).f8792a.G0().d();
            eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
            if (eVar != null) {
                return p(eVar);
            }
        } else {
            if (!(gVar instanceof jp.k ? true : gVar instanceof jp.s)) {
                return gVar.b();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<? extends java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List<java.lang.annotation.Annotation>] */
    public static final List<Annotation> s(List<? extends Annotation> list) throws IllegalAccessException, InvocationTargetException {
        List listK;
        Iterable<Annotation> iterable = (Iterable) list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (l0.g(in.b.e(in.b.a((Annotation) it.next())).getSimpleName(), "Container")) {
                    list = new ArrayList<>();
                    for (Annotation annotation : iterable) {
                        Class clsE = in.b.e(in.b.a(annotation));
                        if (!l0.g(clsE.getSimpleName(), "Container") || clsE.getAnnotation(n1.class) == null) {
                            listK = nm.x.k(annotation);
                        } else {
                            Object objInvoke = clsE.getDeclaredMethod("value", null).invoke(annotation, null);
                            if (objInvoke == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                            }
                            listK = nm.p.t((Annotation[]) objInvoke);
                        }
                        nm.d0.r0(list, listK);
                    }
                    break;
                }
            }
        }
        return list;
    }
}
