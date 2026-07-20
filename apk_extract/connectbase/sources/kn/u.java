package kn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1559#2:206\n1590#2,4:207\n1253#2,4:211\n1238#2,4:217\n453#3:215\n403#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
public final class u implements un.d<Object>, t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f9358b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Map<Class<? extends lm.v<?>>, Integer> f9359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final HashMap<String, String> f9360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final HashMap<String, String> f9361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final HashMap<String, String> f9362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final Map<String, String> f9363g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Class<?> f9364a;

    @r1({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    public static final class a {
        public a() {
        }

        @os.m
        public final String a(@os.l Class<?> cls) {
            String str;
            l0.p(cls, "jClass");
            String strConcat = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str2 = (String) u.f9362f.get(cls.getName());
                return str2 == null ? cls.getCanonicalName() : str2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) u.f9362f.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "kotlin.Array" : strConcat;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        
            if (r1 == null) goto L13;
         */
        @os.m
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(@os.l java.lang.Class<?> r6) {
            /*
                r5 = this;
                java.lang.String r5 = "jClass"
                kn.l0.p(r6, r5)
                boolean r5 = r6.isAnonymousClass()
                r0 = 0
                if (r5 == 0) goto Le
                goto La7
            Le:
                boolean r5 = r6.isLocalClass()
                if (r5 == 0) goto L69
                java.lang.String r5 = r6.getSimpleName()
                java.lang.reflect.Method r1 = r6.getEnclosingMethod()
                r2 = 2
                r3 = 36
                if (r1 == 0) goto L40
                kn.l0.m(r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r1 = r1.getName()
                r4.append(r1)
                r4.append(r3)
                java.lang.String r1 = r4.toString()
                java.lang.String r1 = jq.h0.n5(r5, r1, r0, r2, r0)
                if (r1 != 0) goto L3e
                goto L40
            L3e:
                r0 = r1
                goto La7
            L40:
                java.lang.reflect.Constructor r6 = r6.getEnclosingConstructor()
                if (r6 == 0) goto L61
                kn.l0.m(r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r6 = r6.getName()
                r1.append(r6)
                r1.append(r3)
                java.lang.String r6 = r1.toString()
                java.lang.String r0 = jq.h0.n5(r5, r6, r0, r2, r0)
                goto La7
            L61:
                kn.l0.m(r5)
                java.lang.String r0 = jq.h0.m5(r5, r3, r0, r2, r0)
                goto La7
            L69:
                boolean r5 = r6.isArray()
                if (r5 == 0) goto L92
                java.lang.Class r5 = r6.getComponentType()
                boolean r6 = r5.isPrimitive()
                java.lang.String r1 = "Array"
                if (r6 == 0) goto L8f
                java.util.Map r6 = kn.u.B()
                java.lang.String r5 = r5.getName()
                java.lang.Object r5 = r6.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L8f
                java.lang.String r0 = r5.concat(r1)
            L8f:
                if (r0 != 0) goto La7
                goto L3e
            L92:
                java.util.Map r5 = kn.u.B()
                java.lang.String r0 = r6.getName()
                java.lang.Object r5 = r5.get(r0)
                r0 = r5
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto La7
                java.lang.String r0 = r6.getSimpleName()
            La7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kn.u.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(@os.m Object obj, @os.l Class<?> cls) {
            l0.p(cls, "jClass");
            Map map = u.f9359c;
            l0.n(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return u1.B(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = in.b.g(in.b.i(cls));
            }
            return cls.isInstance(obj);
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List listO = nm.y.O(jn.a.class, jn.l.class, jn.p.class, jn.q.class, jn.r.class, jn.s.class, jn.t.class, jn.u.class, jn.v.class, jn.w.class, jn.b.class, jn.c.class, jn.d.class, jn.e.class, jn.f.class, jn.g.class, jn.h.class, jn.i.class, jn.j.class, jn.k.class, jn.m.class, jn.n.class, jn.o.class);
        ArrayList arrayList = new ArrayList(nm.z.b0(listO, 10));
        int i10 = 0;
        for (Object obj : listO) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            arrayList.add(new lm.t0((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f9359c = nm.d1.D0(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f9360d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f9361e = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        l0.o(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            l0.m(str);
            lm.t0 t0Var = new lm.t0(j.c.a(sb2, jq.h0.q5(str, n1.e.f11183c, null, 2, null), "CompanionObject"), j.a.a(str, ".Companion"));
            map3.put(t0Var.getFirst(), t0Var.getSecond());
        }
        for (Map.Entry<Class<? extends lm.v<?>>, Integer> entry : f9359c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f9362f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(nm.c1.j(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), jq.h0.q5((String) entry2.getValue(), n1.e.f11183c, null, 2, null));
        }
        f9363g = linkedHashMap;
    }

    public u(@os.l Class<?> cls) {
        l0.p(cls, "jClass");
        this.f9364a = cls;
    }

    @lm.f1(version = "1.3")
    public static /* synthetic */ void D() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void E() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void I() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void J() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void K() {
    }

    @lm.f1(version = "1.4")
    public static /* synthetic */ void L() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void M() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void N() {
    }

    @lm.f1(version = "1.1")
    public static /* synthetic */ void O() {
    }

    @lm.f1(version = "1.5")
    public static /* synthetic */ void P() {
    }

    public final Void C() {
        throw new in.r();
    }

    @Override // un.d
    @os.l
    public List<un.s> a() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean c() {
        C();
        throw new lm.y();
    }

    @Override // un.d, un.h
    @os.l
    public Collection<un.c<?>> d() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.l
    public Collection<un.d<?>> e() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean equals(@os.m Object obj) {
        return (obj instanceof u) && l0.g(in.b.g(this), in.b.g((un.d) obj));
    }

    @Override // un.d
    @os.l
    public Collection<un.i<Object>> g() {
        C();
        throw new lm.y();
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.l
    public List<un.t> getTypeParameters() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.m
    public un.w getVisibility() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.m
    public Object h() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public int hashCode() {
        return in.b.g(this).hashCode();
    }

    @Override // un.d
    public boolean isAbstract() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean isFinal() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean isOpen() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.l
    public List<un.d<? extends Object>> k() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean l() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    public boolean q() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @lm.f1(version = "1.1")
    public boolean r(@os.m Object obj) {
        return f9358b.c(obj, this.f9364a);
    }

    @Override // kn.t
    @os.l
    public Class<?> s() {
        return this.f9364a;
    }

    @Override // un.d
    public boolean t() {
        C();
        throw new lm.y();
    }

    @os.l
    public String toString() {
        return this.f9364a.toString() + l1.f9320b;
    }

    @Override // un.d
    public boolean u() {
        C();
        throw new lm.y();
    }

    @Override // un.d
    @os.m
    public String v() {
        return f9358b.a(this.f9364a);
    }

    @Override // un.d
    @os.m
    public String w() {
        return f9358b.b(this.f9364a);
    }

    @Override // un.d
    public boolean x() {
        C();
        throw new lm.y();
    }
}
