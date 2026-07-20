package xn;

import eo.t0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.l2;
import nm.c1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j implements kn.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f20365a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f20366b = kn.w.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final jq.r f20367c = new jq.r("<v#(\\d+)>");

    public static final class a {
        public a() {
        }

        @os.l
        public final jq.r a() {
            return j.f20367c;
        }

        public a(kn.w wVar) {
        }
    }

    public abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f20368c = {l1.f9319a.n(new g1(l1.d(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final a0.a f20369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f20370b;

        public static final class a extends n0 implements jn.a<jo.k> {
            final /* synthetic */ j this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar) {
                super(0);
                this.this$0 = jVar;
            }

            @Override // jn.a
            public final jo.k invoke() {
                return z.b(this.this$0.s());
            }
        }

        public b(j jVar) {
            l0.p(jVar, "this$0");
            this.f20370b = jVar;
            this.f20369a = a0.d(new a(jVar));
        }

        @os.l
        public final jo.k a() {
            a0.a aVar = this.f20369a;
            un.o<Object> oVar = f20368c[0];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-moduleData>(...)");
            return (jo.k) objInvoke;
        }
    }

    public enum c {
        DECLARED,
        INHERITED;

        public final boolean accept(@os.l eo.b bVar) {
            l0.p(bVar, "member");
            return bVar.getKind().isReal() == (this == DECLARED);
        }
    }

    public static final class d extends n0 implements jn.l<eo.y, CharSequence> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l eo.y yVar) {
            l0.p(yVar, "descriptor");
            return gp.c.f6770j.s(yVar) + " | " + d0.f20319a.g(yVar).a();
        }
    }

    public static final class e extends n0 implements jn.l<t0, CharSequence> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l t0 t0Var) {
            l0.p(t0Var, "descriptor");
            return gp.c.f6770j.s(t0Var) + " | " + d0.f20319a.f(t0Var).a();
        }
    }

    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f20372a = new f<>();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(eo.u uVar, eo.u uVar2) {
            Integer numD = eo.t.d(uVar, uVar2);
            if (numD == null) {
                return 0;
            }
            return numD.intValue();
        }
    }

    public static final class g extends xn.a {
        public g() {
            super(j.this);
        }

        @Override // ho.l, eo.o
        @os.l
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public xn.f<?> c(@os.l eo.l lVar, @os.l l2 l2Var) {
            l0.p(lVar, "descriptor");
            l0.p(l2Var, "data");
            throw new IllegalStateException(l0.C("No constructors should appear here: ", lVar));
        }
    }

    public final void B(List<Class<?>> list, String str, boolean z10) {
        List<Class<?>> listO = O(str);
        list.addAll(listO);
        int size = (listO.size() + 31) / 32;
        int i10 = 0;
        while (i10 < size) {
            i10++;
            Class<?> cls = Integer.TYPE;
            l0.o(cls, "TYPE");
            list.add(cls);
        }
        Class<?> cls2 = z10 ? f20366b : Object.class;
        l0.o(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    @os.m
    public final Constructor<?> C(@os.l String str) {
        l0.p(str, "desc");
        return S(s(), O(str));
    }

    @os.m
    public final Constructor<?> D(@os.l String str) {
        l0.p(str, "desc");
        Class<?> clsS = s();
        ArrayList arrayList = new ArrayList();
        B(arrayList, str, true);
        l2 l2Var = l2.f10208a;
        return S(clsS, arrayList);
    }

    @os.m
    public final Method E(@os.l String str, @os.l String str2, boolean z10) {
        l0.p(str, "name");
        l0.p(str2, "desc");
        if (l0.g(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(s());
        }
        B(arrayList, str2, false);
        Class<?> clsM = M();
        String strC = l0.C(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            return Q(clsM, strC, (Class[]) array, P(str2), z10);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @os.l
    public final eo.y F(@os.l String str, @os.l String str2) {
        List listJ;
        l0.p(str, "name");
        l0.p(str2, "signature");
        if (l0.g(str, "<init>")) {
            listJ = nm.h0.V5(I());
        } else {
            dp.f fVarK = dp.f.k(str);
            l0.o(fVarK, "identifier(name)");
            listJ = J(fVarK);
        }
        Collection<eo.y> collection = listJ;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (l0.g(d0.f20319a.g((eo.y) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (eo.y) nm.h0.h5(arrayList);
        }
        String strM3 = nm.h0.m3(collection, "\n", null, null, 0, null, d.INSTANCE, 30, null);
        StringBuilder sb2 = new StringBuilder("Function '");
        sb2.append(str);
        sb2.append("' (JVM signature: ");
        sb2.append(str2);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(n1.e.f11184d);
        sb2.append(strM3.length() == 0 ? " no members found" : l0.C("\n", strM3));
        throw new y(sb2.toString());
    }

    @os.m
    public final Method G(@os.l String str, @os.l String str2) {
        Method methodQ;
        l0.p(str, "name");
        l0.p(str2, "desc");
        if (l0.g(str, "<init>")) {
            return null;
        }
        Object[] array = O(str2).toArray(new Class[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Class<?>[] clsArr = (Class[]) array;
        Class<?> clsP = P(str2);
        Method methodQ2 = Q(M(), str, clsArr, clsP, false);
        if (methodQ2 != null) {
            return methodQ2;
        }
        if (!M().isInterface() || (methodQ = Q(Object.class, str, clsArr, clsP, false)) == null) {
            return null;
        }
        return methodQ;
    }

    @os.l
    public final t0 H(@os.l String str, @os.l String str2) {
        l0.p(str, "name");
        l0.p(str2, "signature");
        jq.p pVarMatchEntire = f20367c.matchEntire(str2);
        if (pVarMatchEntire != null) {
            String str3 = pVarMatchEntire.a().f8889a.b().get(1);
            t0 t0VarK = K(Integer.parseInt(str3));
            if (t0VarK != null) {
                return t0VarK;
            }
            StringBuilder sbA = e.a.a("Local property #", str3, " not found in ");
            sbA.append(s());
            throw new y(sbA.toString());
        }
        dp.f fVarK = dp.f.k(str);
        l0.o(fVarK, "identifier(name)");
        Collection<t0> collectionN = N(fVarK);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionN) {
            if (l0.g(d0.f20319a.f((t0) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new y("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (t0) nm.h0.h5(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            eo.u visibility = ((t0) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = c1.r(linkedHashMap, f.f20372a).values();
        l0.o(collectionValues, "properties\n             …\n                }.values");
        List list = (List) nm.h0.n3(collectionValues);
        if (list.size() == 1) {
            l0.o(list, "mostVisibleProperties");
            return (t0) nm.h0.B2(list);
        }
        dp.f fVarK2 = dp.f.k(str);
        l0.o(fVarK2, "identifier(name)");
        String strM3 = nm.h0.m3(N(fVarK2), "\n", null, null, 0, null, e.INSTANCE, 30, null);
        StringBuilder sb2 = new StringBuilder("Property '");
        sb2.append(str);
        sb2.append("' (JVM signature: ");
        sb2.append(str2);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(n1.e.f11184d);
        sb2.append(strM3.length() == 0 ? " no members found" : l0.C("\n", strM3));
        throw new y(sb2.toString());
    }

    @os.l
    public abstract Collection<eo.l> I();

    @os.l
    public abstract Collection<eo.y> J(@os.l dp.f fVar);

    @os.m
    public abstract t0 K(int i10);

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    @os.l
    public final Collection<xn.f<?>> L(@os.l op.h hVar, @os.l c cVar) {
        xn.f fVar;
        l0.p(hVar, "scope");
        l0.p(cVar, "belonginess");
        g gVar = new g();
        Collection<eo.m> collectionA = op.k.a.a(hVar, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (eo.m mVar : collectionA) {
            if (mVar instanceof eo.b) {
                eo.b bVar = (eo.b) mVar;
                if (l0.g(bVar.getVisibility(), eo.t.f4636h) || !cVar.accept(bVar)) {
                    fVar = null;
                } else {
                    fVar = (xn.f) mVar.A(gVar, l2.f10208a);
                }
            } else {
                fVar = null;
            }
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return nm.h0.V5(arrayList);
    }

    @os.l
    public Class<?> M() {
        Class<?> clsG = ko.d.g(s());
        return clsG == null ? s() : clsG;
    }

    @os.l
    public abstract Collection<t0> N(@os.l dp.f fVar);

    public final List<Class<?>> O(String str) {
        int iO3;
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        while (str.charAt(i10) != ')') {
            int i11 = i10;
            while (str.charAt(i11) == '[') {
                i11++;
            }
            char cCharAt = str.charAt(i11);
            if (jq.h0.S2("VZCBSIFJD", cCharAt, false, 2, null)) {
                iO3 = i11 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new y(l0.C("Unknown type prefix in the method signature: ", str));
                }
                iO3 = jq.h0.o3(str, ';', i10, false, 4, null) + 1;
            }
            arrayList.add(R(str, i10, iO3));
            i10 = iO3;
        }
        return arrayList;
    }

    public final Class<?> P(String str) {
        return R(str, jq.h0.o3(str, ')', 0, false, 6, null) + 1, str.length());
    }

    public final Method Q(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z10) {
        Class<? super Object> superclass;
        Class<?> clsA;
        if (z10) {
            clsArr[0] = cls;
        }
        Method methodT = T(cls, str, clsArr, cls2);
        if (methodT != null || ((superclass = cls.getSuperclass()) != null && (methodT = Q(superclass, str, clsArr, cls2, z10)) != null)) {
            return methodT;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        l0.o(interfaces, "interfaces");
        int length = interfaces.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls3 = interfaces[i10];
            i10++;
            l0.o(cls3, "superInterface");
            Method methodQ = Q(cls3, str, clsArr, cls2, z10);
            if (methodQ == null) {
                if (z10 && (clsA = jo.e.a(ko.d.f(cls3), l0.C(cls3.getName(), "$DefaultImpls"))) != null) {
                    clsArr[0] = cls3;
                    methodQ = T(clsA, str, clsArr, cls2);
                    if (methodQ == null) {
                    }
                }
            }
            return methodQ;
        }
        return null;
    }

    public final Class<?> R(String str, int i10, int i11) throws ClassNotFoundException {
        char cCharAt = str.charAt(i10);
        if (cCharAt == 'L') {
            ClassLoader classLoaderF = ko.d.f(s());
            String strSubstring = str.substring(i10 + 1, i11 - 1);
            l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = classLoaderF.loadClass(jq.e0.h2(strSubstring, el.b0.f4502a, n1.e.f11183c, false, 4, null));
            l0.o(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == '[') {
            return h0.f(R(str, i10 + 1, i11));
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            l0.o(cls, "TYPE");
            return cls;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new y(l0.C("Unknown type prefix in the method signature: ", str));
    }

    public final Constructor<?> S(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method T(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (l0.g(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            l0.o(declaredMethods, "declaredMethods");
            int length = declaredMethods.length;
            int i10 = 0;
            while (i10 < length) {
                Method method = declaredMethods[i10];
                i10++;
                if (l0.g(method.getName(), str) && l0.g(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
