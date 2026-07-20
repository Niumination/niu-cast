package co;

import ao.k;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import jq.d0;
import jq.h0;
import kn.l0;
import nm.y;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f1685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f1686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f1687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f1688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final String f1689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final dp.b f1690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final dp.c f1691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final dp.b f1692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final dp.b f1693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public static final dp.b f1694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public static final HashMap<dp.d, dp.b> f1695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public static final HashMap<dp.d, dp.b> f1696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public static final HashMap<dp.d, dp.c> f1697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final HashMap<dp.d, dp.c> f1698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @l
    public static final List<a> f1699o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final dp.b f1700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final dp.b f1701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final dp.b f1702c;

        public a(@l dp.b bVar, @l dp.b bVar2, @l dp.b bVar3) {
            l0.p(bVar, "javaClass");
            l0.p(bVar2, "kotlinReadOnly");
            l0.p(bVar3, "kotlinMutable");
            this.f1700a = bVar;
            this.f1701b = bVar2;
            this.f1702c = bVar3;
        }

        @l
        public final dp.b a() {
            return this.f1700a;
        }

        @l
        public final dp.b b() {
            return this.f1701b;
        }

        @l
        public final dp.b c() {
            return this.f1702c;
        }

        @l
        public final dp.b d() {
            return this.f1700a;
        }

        public boolean equals(@m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return l0.g(this.f1700a, aVar.f1700a) && l0.g(this.f1701b, aVar.f1701b) && l0.g(this.f1702c, aVar.f1702c);
        }

        public int hashCode() {
            return this.f1702c.hashCode() + ((this.f1701b.hashCode() + (this.f1700a.hashCode() * 31)) * 31);
        }

        @l
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f1700a + ", kotlinReadOnly=" + this.f1701b + ", kotlinMutable=" + this.f1702c + ')';
        }
    }

    static {
        c cVar = new c();
        f1685a = cVar;
        StringBuilder sb2 = new StringBuilder();
        bo.c cVar2 = bo.c.Function;
        sb2.append(cVar2.getPackageFqName().f3810a.toString());
        sb2.append(n1.e.f11183c);
        sb2.append(cVar2.getClassNamePrefix());
        f1686b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        bo.c cVar3 = bo.c.KFunction;
        sb3.append(cVar3.getPackageFqName().f3810a.toString());
        sb3.append(n1.e.f11183c);
        sb3.append(cVar3.getClassNamePrefix());
        f1687c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        bo.c cVar4 = bo.c.SuspendFunction;
        sb4.append(cVar4.getPackageFqName().f3810a.toString());
        sb4.append(n1.e.f11183c);
        sb4.append(cVar4.getClassNamePrefix());
        f1688d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        bo.c cVar5 = bo.c.KSuspendFunction;
        sb5.append(cVar5.getPackageFqName().f3810a.toString());
        sb5.append(n1.e.f11183c);
        sb5.append(cVar5.getClassNamePrefix());
        f1689e = sb5.toString();
        dp.b bVarM = dp.b.m(new dp.c("kotlin.jvm.functions.FunctionN"));
        l0.o(bVarM, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f1690f = bVarM;
        dp.c cVarB = bVarM.b();
        l0.o(cVarB, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f1691g = cVarB;
        dp.b bVarM2 = dp.b.m(new dp.c("kotlin.reflect.KFunction"));
        l0.o(bVarM2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f1692h = bVarM2;
        dp.b bVarM3 = dp.b.m(new dp.c("kotlin.reflect.KClass"));
        l0.o(bVarM3, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        f1693i = bVarM3;
        f1694j = cVar.h(Class.class);
        f1695k = new HashMap<>();
        f1696l = new HashMap<>();
        f1697m = new HashMap<>();
        f1698n = new HashMap<>();
        dp.b bVarM4 = dp.b.m(k.a.O);
        l0.o(bVarM4, "topLevel(FqNames.iterable)");
        dp.c cVar6 = k.a.W;
        dp.c cVarH = bVarM4.h();
        dp.c cVarH2 = bVarM4.h();
        l0.o(cVarH2, "kotlinReadOnly.packageFqName");
        dp.c cVarG = dp.e.g(cVar6, cVarH2);
        a aVar = new a(cVar.h(Iterable.class), bVarM4, new dp.b(cVarH, cVarG, false));
        dp.b bVarM5 = dp.b.m(k.a.N);
        l0.o(bVarM5, "topLevel(FqNames.iterator)");
        dp.c cVar7 = k.a.V;
        dp.c cVarH3 = bVarM5.h();
        dp.c cVarH4 = bVarM5.h();
        l0.o(cVarH4, "kotlinReadOnly.packageFqName");
        a aVar2 = new a(cVar.h(Iterator.class), bVarM5, new dp.b(cVarH3, dp.e.g(cVar7, cVarH4), false));
        dp.b bVarM6 = dp.b.m(k.a.P);
        l0.o(bVarM6, "topLevel(FqNames.collection)");
        dp.c cVar8 = k.a.X;
        dp.c cVarH5 = bVarM6.h();
        dp.c cVarH6 = bVarM6.h();
        l0.o(cVarH6, "kotlinReadOnly.packageFqName");
        a aVar3 = new a(cVar.h(Collection.class), bVarM6, new dp.b(cVarH5, dp.e.g(cVar8, cVarH6), false));
        dp.b bVarM7 = dp.b.m(k.a.Q);
        l0.o(bVarM7, "topLevel(FqNames.list)");
        dp.c cVar9 = k.a.Y;
        dp.c cVarH7 = bVarM7.h();
        dp.c cVarH8 = bVarM7.h();
        l0.o(cVarH8, "kotlinReadOnly.packageFqName");
        a aVar4 = new a(cVar.h(List.class), bVarM7, new dp.b(cVarH7, dp.e.g(cVar9, cVarH8), false));
        dp.b bVarM8 = dp.b.m(k.a.S);
        l0.o(bVarM8, "topLevel(FqNames.set)");
        dp.c cVar10 = k.a.f572a0;
        dp.c cVarH9 = bVarM8.h();
        dp.c cVarH10 = bVarM8.h();
        l0.o(cVarH10, "kotlinReadOnly.packageFqName");
        a aVar5 = new a(cVar.h(Set.class), bVarM8, new dp.b(cVarH9, dp.e.g(cVar10, cVarH10), false));
        dp.b bVarM9 = dp.b.m(k.a.R);
        l0.o(bVarM9, "topLevel(FqNames.listIterator)");
        dp.c cVar11 = k.a.Z;
        dp.c cVarH11 = bVarM9.h();
        dp.c cVarH12 = bVarM9.h();
        l0.o(cVarH12, "kotlinReadOnly.packageFqName");
        a aVar6 = new a(cVar.h(ListIterator.class), bVarM9, new dp.b(cVarH11, dp.e.g(cVar11, cVarH12), false));
        dp.c cVar12 = k.a.T;
        dp.b bVarM10 = dp.b.m(cVar12);
        l0.o(bVarM10, "topLevel(FqNames.map)");
        dp.c cVar13 = k.a.f574b0;
        dp.c cVarH13 = bVarM10.h();
        dp.c cVarH14 = bVarM10.h();
        l0.o(cVarH14, "kotlinReadOnly.packageFqName");
        a aVar7 = new a(cVar.h(Map.class), bVarM10, new dp.b(cVarH13, dp.e.g(cVar13, cVarH14), false));
        dp.b bVarD = dp.b.m(cVar12).d(k.a.U.g());
        l0.o(bVarD, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        dp.c cVar14 = k.a.f576c0;
        dp.c cVarH15 = bVarD.h();
        dp.c cVarH16 = bVarD.h();
        l0.o(cVarH16, "kotlinReadOnly.packageFqName");
        List<a> listO = y.O(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a(cVar.h(Map.Entry.class), bVarD, new dp.b(cVarH15, dp.e.g(cVar14, cVarH16), false)));
        f1699o = listO;
        cVar.g(Object.class, k.a.f573b);
        cVar.g(String.class, k.a.f585h);
        cVar.g(CharSequence.class, k.a.f583g);
        cVar.f(Throwable.class, k.a.f611u);
        cVar.g(Cloneable.class, k.a.f577d);
        cVar.g(Number.class, k.a.f605r);
        cVar.f(Comparable.class, k.a.f613v);
        cVar.g(Enum.class, k.a.f607s);
        cVar.f(Annotation.class, k.a.E);
        Iterator<a> it = listO.iterator();
        while (it.hasNext()) {
            f1685a.e(it.next());
        }
        mp.e[] eVarArrValues = mp.e.values();
        int length = eVarArrValues.length;
        int i10 = 0;
        while (i10 < length) {
            mp.e eVar = eVarArrValues[i10];
            i10++;
            c cVar15 = f1685a;
            dp.b bVarM11 = dp.b.m(eVar.getWrapperFqName());
            l0.o(bVarM11, "topLevel(jvmType.wrapperFqName)");
            ao.i primitiveType = eVar.getPrimitiveType();
            l0.o(primitiveType, "jvmType.primitiveType");
            dp.b bVarM12 = dp.b.m(k.c(primitiveType));
            l0.o(bVarM12, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            cVar15.b(bVarM11, bVarM12);
        }
        ao.c.f519a.getClass();
        for (dp.b bVar : ao.c.f520b) {
            c cVar16 = f1685a;
            dp.b bVarM13 = dp.b.m(new dp.c("kotlin.jvm.internal." + bVar.j().b() + "CompanionObject"));
            l0.o(bVarM13, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            dp.b bVarD2 = bVar.d(dp.h.f3827d);
            l0.o(bVarD2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            cVar16.b(bVarM13, bVarD2);
        }
        for (int i11 = 0; i11 < 23; i11++) {
            c cVar17 = f1685a;
            dp.b bVarM14 = dp.b.m(new dp.c(l0.C("kotlin.jvm.functions.Function", Integer.valueOf(i11))));
            l0.o(bVarM14, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            cVar17.b(bVarM14, k.a(i11));
            cVar17.d(new dp.c(l0.C(f1687c, Integer.valueOf(i11))), f1692h);
        }
        for (int i12 = 0; i12 < 22; i12++) {
            bo.c cVar18 = bo.c.KSuspendFunction;
            f1685a.d(new dp.c(l0.C(cVar18.getPackageFqName().f3810a.toString() + n1.e.f11183c + cVar18.getClassNamePrefix(), Integer.valueOf(i12))), f1692h);
        }
        c cVar19 = f1685a;
        dp.c cVarL = k.a.f575c.l();
        l0.o(cVarL, "nothing.toSafe()");
        cVar19.d(cVarL, cVar19.h(Void.class));
    }

    public final void b(dp.b bVar, dp.b bVar2) {
        c(bVar, bVar2);
        dp.c cVarB = bVar2.b();
        l0.o(cVarB, "kotlinClassId.asSingleFqName()");
        d(cVarB, bVar);
    }

    public final void c(dp.b bVar, dp.b bVar2) {
        HashMap<dp.d, dp.b> map = f1695k;
        dp.d dVarJ = bVar.b().j();
        l0.o(dVarJ, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, bVar2);
    }

    public final void d(dp.c cVar, dp.b bVar) {
        HashMap<dp.d, dp.b> map = f1696l;
        dp.d dVarJ = cVar.j();
        l0.o(dVarJ, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(dVarJ, bVar);
    }

    public final void e(a aVar) {
        dp.b bVar = aVar.f1700a;
        dp.b bVar2 = aVar.f1701b;
        dp.b bVar3 = aVar.f1702c;
        b(bVar, bVar2);
        dp.c cVarB = bVar3.b();
        l0.o(cVarB, "mutableClassId.asSingleFqName()");
        d(cVarB, bVar);
        dp.c cVarB2 = bVar2.b();
        l0.o(cVarB2, "readOnlyClassId.asSingleFqName()");
        dp.c cVarB3 = bVar3.b();
        l0.o(cVarB3, "mutableClassId.asSingleFqName()");
        HashMap<dp.d, dp.c> map = f1697m;
        dp.d dVarJ = bVar3.b().j();
        l0.o(dVarJ, "mutableClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, cVarB2);
        HashMap<dp.d, dp.c> map2 = f1698n;
        dp.d dVarJ2 = cVarB2.j();
        l0.o(dVarJ2, "readOnlyFqName.toUnsafe()");
        map2.put(dVarJ2, cVarB3);
    }

    public final void f(Class<?> cls, dp.c cVar) {
        dp.b bVarH = h(cls);
        dp.b bVarM = dp.b.m(cVar);
        l0.o(bVarM, "topLevel(kotlinFqName)");
        b(bVarH, bVarM);
    }

    public final void g(Class<?> cls, dp.d dVar) {
        dp.c cVarL = dVar.l();
        l0.o(cVarL, "kotlinFqName.toSafe()");
        f(cls, cVarL);
    }

    public final dp.b h(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            dp.b bVarM = dp.b.m(new dp.c(cls.getCanonicalName()));
            l0.o(bVarM, "topLevel(FqName(clazz.canonicalName))");
            return bVarM;
        }
        dp.b bVarD = h(declaringClass).d(dp.f.k(cls.getSimpleName()));
        l0.o(bVarD, "classId(outer).createNes…tifier(clazz.simpleName))");
        return bVarD;
    }

    @l
    public final dp.c i() {
        return f1691g;
    }

    @l
    public final List<a> j() {
        return f1699o;
    }

    public final boolean k(dp.d dVar, String str) {
        Integer numX0;
        String strB = dVar.b();
        l0.o(strB, "kotlinFqName.asString()");
        String strL5 = h0.l5(strB, str, "");
        return strL5.length() > 0 && !h0.b5(strL5, '0', false, 2, null) && (numX0 = d0.X0(strL5)) != null && numX0.intValue() >= 23;
    }

    public final boolean l(@m dp.d dVar) {
        return f1697m.containsKey(dVar);
    }

    public final boolean m(@m dp.d dVar) {
        return f1698n.containsKey(dVar);
    }

    @m
    public final dp.b n(@l dp.c cVar) {
        l0.p(cVar, "fqName");
        return f1695k.get(cVar.j());
    }

    @m
    public final dp.b o(@l dp.d dVar) {
        l0.p(dVar, "kotlinFqName");
        if (!k(dVar, f1686b) && !k(dVar, f1688d)) {
            if (!k(dVar, f1687c) && !k(dVar, f1689e)) {
                return f1696l.get(dVar);
            }
            return f1692h;
        }
        return f1690f;
    }

    @m
    public final dp.c p(@m dp.d dVar) {
        return f1697m.get(dVar);
    }

    @m
    public final dp.c q(@m dp.d dVar) {
        return f1698n.get(dVar);
    }
}
