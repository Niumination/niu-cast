package yn;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.m0;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.d0;
import lm.f0;
import nm.h0;
import nm.r;
import nm.z;
import os.l;
import xn.y;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    public static final class a extends n0 implements jn.a<Integer> {
        final /* synthetic */ Map<String, Object> $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map<String, ? extends Object> map) {
            super(0);
            this.$values = map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Integer invoke() {
            int iHashCode;
            Iterator<T> it = this.$values.entrySet().iterator();
            int iHashCode2 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    iHashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    iHashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    iHashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    iHashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    iHashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    iHashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    iHashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    iHashCode = Arrays.hashCode((double[]) value);
                } else {
                    iHashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                iHashCode2 += iHashCode ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(iHashCode2);
        }
    }

    /* JADX INFO: renamed from: yn.b$b, reason: collision with other inner class name */
    public static final class C0552b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class<T> f21473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f21474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d0<String> f21475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d0<Integer> f21476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List<Method> f21477e;

        public C0552b(Class<T> cls, Map<String, ? extends Object> map, d0<String> d0Var, d0<Integer> d0Var2, List<Method> list) {
            this.f21473a = cls;
            this.f21474b = map;
            this.f21475c = d0Var;
            this.f21476d = d0Var2;
            this.f21477e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1776922004) {
                    if (iHashCode != 147696667) {
                        if (iHashCode == 1444986633 && name.equals("annotationType")) {
                            return this.f21473a;
                        }
                    } else if (name.equals("hashCode")) {
                        return Integer.valueOf(b.i(this.f21476d));
                    }
                } else if (name.equals("toString")) {
                    return this.f21475c.getValue();
                }
            }
            if (l0.g(name, "equals") && objArr != null && objArr.length == 1) {
                Class<T> cls = this.f21473a;
                List<Method> list = this.f21477e;
                Map<String, Object> map = this.f21474b;
                l0.o(objArr, d6.a.F);
                return Boolean.valueOf(b.h(cls, list, map, r.gt(objArr)));
            }
            if (this.f21474b.containsKey(name)) {
                return this.f21474b.get(name);
            }
            StringBuilder sb2 = new StringBuilder("Method is not supported: ");
            sb2.append(method);
            sb2.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb2.append(r.Ky(objArr));
            sb2.append(')');
            throw new y(sb2.toString());
        }
    }

    public static final class c extends n0 implements jn.a<String> {
        final /* synthetic */ Class<T> $annotationClass;
        final /* synthetic */ Map<String, Object> $values;

        public static final class a extends n0 implements jn.l<Map.Entry<? extends String, ? extends Object>, CharSequence> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                return invoke2((Map.Entry<String, ? extends Object>) entry);
            }

            @l
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(@l Map.Entry<String, ? extends Object> entry) {
                String string;
                l0.p(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    string = Arrays.toString((boolean[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof char[]) {
                    string = Arrays.toString((char[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof byte[]) {
                    string = Arrays.toString((byte[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof short[]) {
                    string = Arrays.toString((short[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof int[]) {
                    string = Arrays.toString((int[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof float[]) {
                    string = Arrays.toString((float[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof long[]) {
                    string = Arrays.toString((long[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof double[]) {
                    string = Arrays.toString((double[]) value);
                    l0.o(string, "toString(this)");
                } else if (value instanceof Object[]) {
                    string = Arrays.toString((Object[]) value);
                    l0.o(string, "toString(this)");
                } else {
                    string = value.toString();
                }
                return key + fl.h.f6043c + string;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Class<T> cls, Map<String, ? extends Object> map) {
            super(0);
            this.$annotationClass = cls;
            this.$values = map;
        }

        @Override // jn.a
        @l
        public final String invoke() throws IOException {
            Class<T> cls = this.$annotationClass;
            Map<String, Object> map = this.$values;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            sb2.append(cls.getCanonicalName());
            h0.j3(map.entrySet(), sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : "(", (y5.a.f20716e0 & 8) == 0 ? ")" : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : a.INSTANCE);
            String string = sb2.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final String c(d0 d0Var) {
        return (String) d0Var.getValue();
    }

    @l
    public static final <T> T f(@l Class<T> cls, @l Map<String, ? extends Object> map, @l List<Method> list) {
        l0.p(cls, "annotationClass");
        l0.p(map, "values");
        l0.p(list, "methods");
        d0 d0VarB = f0.b(new a(map));
        T t10 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0552b(cls, map, f0.b(new c(cls, map)), d0VarB, list));
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
    }

    public static /* synthetic */ Object g(Class cls, Map map, List list, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(z.b0(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return f(cls, map, list);
    }

    public static final <T> boolean h(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) throws IllegalAccessException, InvocationTargetException {
        boolean zG;
        boolean z10;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (!l0.g(annotation == null ? null : in.b.e(in.b.a(annotation)), cls)) {
            return false;
        }
        List<Method> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z10 = true;
        } else {
            for (Method method : list2) {
                Object obj2 = map.get(method.getName());
                Object objInvoke = method.invoke(obj, null);
                if (obj2 instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                    }
                    zG = Arrays.equals(zArr, (boolean[]) objInvoke);
                } else if (obj2 instanceof char[]) {
                    char[] cArr = (char[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharArray");
                    }
                    zG = Arrays.equals(cArr, (char[]) objInvoke);
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                    }
                    zG = Arrays.equals(bArr, (byte[]) objInvoke);
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.ShortArray");
                    }
                    zG = Arrays.equals(sArr, (short[]) objInvoke);
                } else if (obj2 instanceof int[]) {
                    int[] iArr = (int[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
                    }
                    zG = Arrays.equals(iArr, (int[]) objInvoke);
                } else if (obj2 instanceof float[]) {
                    float[] fArr = (float[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.FloatArray");
                    }
                    zG = Arrays.equals(fArr, (float[]) objInvoke);
                } else if (obj2 instanceof long[]) {
                    long[] jArr = (long[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.LongArray");
                    }
                    zG = Arrays.equals(jArr, (long[]) objInvoke);
                } else if (obj2 instanceof double[]) {
                    double[] dArr = (double[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.DoubleArray");
                    }
                    zG = Arrays.equals(dArr, (double[]) objInvoke);
                } else if (obj2 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj2;
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
                    }
                    zG = Arrays.equals(objArr, (Object[]) objInvoke);
                } else {
                    zG = l0.g(obj2, objInvoke);
                }
                if (!zG) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public static final int i(d0<Integer> d0Var) {
        return d0Var.getValue().intValue();
    }

    public static final String j(d0<String> d0Var) {
        return d0Var.getValue();
    }

    public static final Void k(int i10, String str, Class<?> cls) {
        un.d dVarD;
        String strV;
        if (l0.g(cls, Class.class)) {
            dVarD = l1.d(un.d.class);
        } else {
            dVarD = (cls.isArray() && l0.g(cls.getComponentType(), Class.class)) ? l1.d(un.d[].class) : in.b.i(cls);
        }
        if (l0.g(dVarD.v(), l1.d(Object[].class).v())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) dVarD.v());
            sb2.append(m0.f8867e);
            Class<?> componentType = in.b.e(dVarD).getComponentType();
            l0.o(componentType, "kotlinClass.java.componentType");
            sb2.append((Object) in.b.i(componentType).v());
            sb2.append(m0.f8868f);
            strV = sb2.toString();
        } else {
            strV = dVarD.v();
        }
        throw new IllegalArgumentException("Argument #" + i10 + ' ' + str + " is not of the required type " + ((Object) strV));
    }

    public static final Object l(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof un.d) {
            obj = in.b.e((un.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (!(objArr instanceof un.d[])) {
                obj = objArr;
            } else {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                }
                un.d[] dVarArr = (un.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                int length = dVarArr.length;
                int i10 = 0;
                while (i10 < length) {
                    un.d dVar = dVarArr[i10];
                    i10++;
                    arrayList.add(in.b.e(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
