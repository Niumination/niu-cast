package ko;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jq.e0;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import lm.t0;
import nm.d1;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final List<un.d<? extends Object>> f9415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Map<Class<? extends Object>, Class<? extends Object>> f9416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Map<Class<? extends Object>, Class<? extends Object>> f9417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Map<Class<? extends lm.v<?>>, Integer> f9418d;

    public static final class a extends n0 implements jn.l<ParameterizedType, ParameterizedType> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final ParameterizedType invoke(@os.l ParameterizedType parameterizedType) {
            l0.p(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    public static final class b extends n0 implements jn.l<ParameterizedType, gq.m<? extends Type>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final gq.m<Type> invoke(@os.l ParameterizedType parameterizedType) {
            l0.p(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            l0.o(actualTypeArguments, "it.actualTypeArguments");
            return nm.r.K5(actualTypeArguments);
        }
    }

    static {
        int i10 = 0;
        un.d dVarD = l1.d(Boolean.TYPE);
        Class cls = Byte.TYPE;
        m1 m1Var = l1.f9319a;
        List<un.d<? extends Object>> listO = nm.y.O(dVarD, m1Var.d(cls), m1Var.d(Character.TYPE), m1Var.d(Double.TYPE), m1Var.d(Float.TYPE), m1Var.d(Integer.TYPE), m1Var.d(Long.TYPE), m1Var.d(Short.TYPE));
        f9415a = listO;
        List<un.d<? extends Object>> list = listO;
        ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            un.d dVar = (un.d) it.next();
            arrayList.add(new t0(in.b.g(dVar), in.b.h(dVar)));
        }
        f9416b = d1.D0(arrayList);
        List<un.d<? extends Object>> list2 = f9415a;
        ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            un.d dVar2 = (un.d) it2.next();
            arrayList2.add(new t0(in.b.h(dVar2), in.b.g(dVar2)));
        }
        f9417c = d1.D0(arrayList2);
        List listO2 = nm.y.O(jn.a.class, jn.l.class, jn.p.class, jn.q.class, jn.r.class, jn.s.class, jn.t.class, jn.u.class, jn.v.class, jn.w.class, jn.b.class, jn.c.class, jn.d.class, jn.e.class, jn.f.class, jn.g.class, jn.h.class, jn.i.class, jn.j.class, jn.k.class, jn.m.class, jn.n.class, jn.o.class);
        ArrayList arrayList3 = new ArrayList(nm.z.b0(listO2, 10));
        for (Object obj : listO2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            arrayList3.add(new t0((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f9418d = d1.D0(arrayList3);
    }

    @os.l
    public static final dp.b a(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(l0.C("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(l0.C("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            l0.o(simpleName, "simpleName");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                dp.b bVarM = declaringClass == null ? dp.b.m(new dp.c(cls.getName())) : a(declaringClass).d(dp.f.k(cls.getSimpleName()));
                l0.o(bVarM, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                return bVarM;
            }
        }
        dp.c cVar = new dp.c(cls.getName());
        return new dp.b(cVar.e(), dp.c.k(cVar.g()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @os.l
    public static final String b(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                l0.o(name, "name");
                return e0.h2(name, n1.e.f11183c, el.b0.f4502a, false, 4, null);
            }
            StringBuilder sb2 = new StringBuilder("L");
            String name2 = cls.getName();
            l0.o(name2, "name");
            return l.a.a(sb2, e0.h2(name2, n1.e.f11183c, el.b0.f4502a, false, 4, null), ';');
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name3.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals(TypedValues.Custom.S_FLOAT)) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException(l0.C("Unsupported primitive type: ", cls));
    }

    @os.m
    public static final Integer c(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        return f9418d.get(cls);
    }

    @os.l
    public static final List<Type> d(@os.l Type type) {
        l0.p(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return k0.INSTANCE;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return gq.v.c3(gq.v.H0(gq.s.l(type, a.INSTANCE), b.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        l0.o(actualTypeArguments, "actualTypeArguments");
        return nm.r.Ky(actualTypeArguments);
    }

    @os.m
    public static final Class<?> e(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        return f9416b.get(cls);
    }

    @os.l
    public static final ClassLoader f(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        l0.o(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    @os.m
    public static final Class<?> g(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        return f9417c.get(cls);
    }

    public static final boolean h(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
