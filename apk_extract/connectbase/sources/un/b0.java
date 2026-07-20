package un;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jq.e0;
import kn.h0;
import kn.l0;
import kn.m0;
import kn.r1;
import lm.f1;
import lm.i0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
public final class b0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16339a;

        static {
            int[] iArr = new int[v.values().length];
            try {
                iArr[v.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[v.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[v.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16339a = iArr;
        }
    }

    public /* synthetic */ class b extends h0 implements jn.l<Class<?>, Class<?>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // jn.l
        public final Class<?> invoke(@os.l Class<?> cls) {
            l0.p(cls, "p0");
            return cls.getComponentType();
        }
    }

    @lm.r
    public static final Type c(s sVar, boolean z10) {
        g gVarI = sVar.i();
        if (gVarI instanceof t) {
            return new a0((t) gVarI);
        }
        if (!(gVarI instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + sVar);
        }
        d dVar = (d) gVarI;
        Class clsG = z10 ? in.b.g(dVar) : in.b.e(dVar);
        List<u> listN = sVar.n();
        if (listN.isEmpty()) {
            return clsG;
        }
        if (!clsG.isArray()) {
            return e(clsG, listN);
        }
        if (clsG.getComponentType().isPrimitive()) {
            return clsG;
        }
        u uVar = (u) nm.h0.k5(listN);
        if (uVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + sVar);
        }
        v vVar = uVar.f16348a;
        s sVar2 = uVar.f16349b;
        int i10 = vVar == null ? -1 : a.f16339a[vVar.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return clsG;
        }
        if (i10 != 2 && i10 != 3) {
            throw new i0();
        }
        l0.m(sVar2);
        Type typeD = d(sVar2, false, 1, null);
        return typeD instanceof Class ? clsG : new un.a(typeD);
    }

    public static /* synthetic */ Type d(s sVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(sVar, z10);
    }

    @lm.r
    public static final Type e(Class<?> cls, List<u> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<u> list2 = list;
            ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(g((u) it.next()));
            }
            return new x(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<u> list3 = list;
            ArrayList arrayList2 = new ArrayList(nm.z.b0(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((u) it2.next()));
            }
            return new x(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<u> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(nm.z.b0(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((u) it3.next()));
        }
        return new x(cls, typeE, arrayList3);
    }

    @os.l
    public static final Type f(@os.l s sVar) {
        Type typeP;
        l0.p(sVar, "<this>");
        return (!(sVar instanceof m0) || (typeP = ((m0) sVar).p()) == null) ? d(sVar, false, 1, null) : typeP;
    }

    public static final Type g(u uVar) {
        v vVar = uVar.f16348a;
        if (vVar == null) {
            c0.f16340c.getClass();
            return c0.f16341d;
        }
        s sVar = uVar.f16349b;
        l0.m(sVar);
        int i10 = a.f16339a[vVar.ordinal()];
        if (i10 == 1) {
            return new c0(null, c(sVar, true));
        }
        if (i10 == 2) {
            return c(sVar, true);
        }
        if (i10 == 3) {
            return new c0(c(sVar, true), null);
        }
        throw new i0();
    }

    @an.h
    @f1(version = "1.4")
    @lm.r
    public static /* synthetic */ void h(s sVar) {
    }

    @lm.r
    public static /* synthetic */ void i(u uVar) {
    }

    public static final String j(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            gq.m mVarL = gq.s.l(type, b.INSTANCE);
            name = ((Class) gq.v.f1(mVarL)).getName() + e0.e2("[]", gq.v.g0(mVarL));
        } else {
            name = cls.getName();
        }
        l0.m(name);
        return name;
    }
}
