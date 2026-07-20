package p1;

import c1.h0;
import c1.i0;
import c1.y;
import f1.i3;
import f1.k3;
import f1.l2;
import f1.l5;
import f1.p1;
import f1.t3;
import f1.x7;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@p1.d
public abstract class q<T> extends m<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient o f12731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient o f12732b;
    private final Type runtimeType;

    public class a extends p1.g.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // p1.g.b, p1.g
        public Type[] f() {
            return q.this.k().l(this.f12710d.getGenericExceptionTypes());
        }

        @Override // p1.g.b, p1.g
        public Type[] g() {
            return q.this.l().l(this.f12710d.getGenericParameterTypes());
        }

        @Override // p1.g.b, p1.g
        public Type h() {
            return q.this.k().j(this.f12710d.getGenericReturnType());
        }

        @Override // p1.g
        public q<T> i() {
            return q.this;
        }

        @Override // p1.g
        public String toString() {
            return i() + "." + this.f12708b.toString();
        }
    }

    public class b extends p1.g.a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // p1.g.a, p1.g
        public Type[] f() {
            return q.this.k().l(this.f12709d.getGenericExceptionTypes());
        }

        @Override // p1.g.a, p1.g
        public Type[] g() {
            return q.this.l().l(super.g());
        }

        @Override // p1.g.a, p1.g
        public Type h() {
            return q.this.k().j(super.h());
        }

        @Override // p1.g
        public q<T> i() {
            return q.this;
        }

        @Override // p1.g
        public String toString() {
            return i() + "(" + new y(", ").n(g()) + ")";
        }
    }

    public class c extends s {
        public c() {
        }

        @Override // p1.s
        public void c(GenericArrayType type) {
            a(type.getGenericComponentType());
        }

        @Override // p1.s
        public void d(ParameterizedType type) {
            a(type.getActualTypeArguments());
            a(type.getOwnerType());
        }

        @Override // p1.s
        public void e(TypeVariable<?> type) {
            throw new IllegalArgumentException(q.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // p1.s
        public void f(WildcardType type) {
            a(type.getLowerBounds());
            a(type.getUpperBounds());
        }
    }

    public class d extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t3.a f12736b;

        public d(final q this$0, final t3.a val$builder) {
            this.f12736b = val$builder;
        }

        @Override // p1.s
        public void b(Class<?> t10) {
            this.f12736b.a(t10);
        }

        @Override // p1.s
        public void c(GenericArrayType t10) {
            this.f12736b.a(t.h(q.of(t10.getGenericComponentType()).getRawType()));
        }

        @Override // p1.s
        public void d(ParameterizedType t10) {
            this.f12736b.a((Class) t10.getRawType());
        }

        @Override // p1.s
        public void e(TypeVariable<?> t10) {
            a(t10.getBounds());
        }

        @Override // p1.s
        public void f(WildcardType t10) {
            a(t10.getUpperBounds());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type[] f12737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12738b;

        public e(Type[] bounds, boolean target) {
            this.f12737a = bounds;
            this.f12738b = target;
        }

        public boolean a(Type supertype) {
            for (Type type : this.f12737a) {
                boolean zIsSubtypeOf = q.of(type).isSubtypeOf(supertype);
                boolean z10 = this.f12738b;
                if (zIsSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f12738b;
        }

        public boolean b(Type subtype) {
            q<?> qVarOf = q.of(subtype);
            for (Type type : this.f12737a) {
                boolean zIsSubtypeOf = qVarOf.isSubtypeOf(type);
                boolean z10 = this.f12738b;
                if (zIsSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f12738b;
        }
    }

    public final class f extends q<T>.k {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public transient t3<q<? super T>> f12739b;

        public f() {
            super();
        }

        private Object readResolve() {
            return q.this.getTypes().classes();
        }

        @Override // p1.q.k
        public q<T>.k classes() {
            return this;
        }

        @Override // p1.q.k
        public q<T>.k interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // p1.q.k
        public Set<Class<? super T>> rawTypes() {
            i<Class<?>> iVar = i.f12743b;
            iVar.getClass();
            return t3.copyOf((Collection) new i.c(iVar).c(q.this.n()));
        }

        public /* synthetic */ f(q qVar, a aVar) {
            this();
        }

        @Override // p1.q.k, f1.l2, f1.s1, f1.j2
        public Set<q<? super T>> delegate() {
            t3<q<? super T>> t3Var = this.f12739b;
            if (t3Var != null) {
                return t3Var;
            }
            i<q<?>> iVar = i.f12742a;
            iVar.getClass();
            t3<q<? super T>> t3VarI = p1.u(new i.c(iVar).d(q.this)).o(j.IGNORE_TYPE_VARIABLE_OR_WILDCARD).I();
            this.f12739b = t3VarI;
            return t3VarI;
        }
    }

    public static final class h<T> extends q<T> {
        private static final long serialVersionUID = 0;

        public h(Type type) {
            super(type, null);
        }
    }

    public static abstract class i<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<q<?>> f12742a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i<Class<?>> f12743b = new b();

        public class a extends i<q<?>> {
            @Override // p1.q.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends q<?>> e(q<?> type) {
                return type.getGenericInterfaces();
            }

            @Override // p1.q.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(q<?> type) {
                return type.getRawType();
            }

            @Override // p1.q.i
            @gm.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public q<?> g(q<?> type) {
                return type.getGenericSuperclass();
            }
        }

        public class b extends i<Class<?>> {
            @Override // p1.q.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> type) {
                return Arrays.asList(type.getInterfaces());
            }

            @Override // p1.q.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> type) {
                return type;
            }

            @Override // p1.q.i
            @gm.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> type) {
                return type.getSuperclass();
            }
        }

        public class c extends e<K> {
            public c(final i this$0, i delegate) {
                super(delegate);
            }

            @Override // p1.q.i
            public i3<K> c(Iterable<? extends K> types) {
                i3.a aVarBuilder = i3.builder();
                for (K k10 : types) {
                    if (!f(k10).isInterface()) {
                        aVarBuilder.j(k10);
                    }
                }
                return super.c(aVarBuilder.e());
            }

            @Override // p1.q.i.e, p1.q.i
            public Iterable<? extends K> e(K type) {
                return t3.of();
            }
        }

        public class d extends l5<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Comparator f12744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f12745b;

            public d(final Comparator val$valueComparator, final Map val$map) {
                this.f12744a = val$valueComparator;
                this.f12745b = val$map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.l5, java.util.Comparator
            public int compare(K left, K right) {
                Comparator comparator = this.f12744a;
                Object obj = this.f12745b.get(left);
                Objects.requireNonNull(obj);
                Object obj2 = this.f12745b.get(right);
                Objects.requireNonNull(obj2);
                return comparator.compare(obj, obj2);
            }
        }

        public static class e<K> extends i<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final i<K> f12746c;

            public e(i<K> delegate) {
                this.f12746c = delegate;
            }

            @Override // p1.q.i
            public Iterable<? extends K> e(K type) {
                return this.f12746c.e(type);
            }

            @Override // p1.q.i
            public Class<?> f(K type) {
                return this.f12746c.f(type);
            }

            @Override // p1.q.i
            @gm.a
            public K g(K type) {
                return this.f12746c.g(type);
            }
        }

        public i() {
        }

        public static <K, V> i3<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (i3<K>) new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final i<K> a() {
            return new c(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @t1.a
        public final int b(K k10, Map<? super K, Integer> map) {
            Integer num = map.get(k10);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(k10).isInterface();
            Iterator<? extends K> it = e(k10).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            K kG = g(k10);
            int iMax2 = iMax;
            if (kG != null) {
                iMax2 = Math.max(iMax, b(kG, map));
            }
            int i10 = iMax2 + 1;
            map.put(k10, Integer.valueOf(i10));
            return i10;
        }

        public i3<K> c(Iterable<? extends K> types) {
            HashMap map = new HashMap();
            Iterator<? extends K> it = types.iterator();
            while (it.hasNext()) {
                b(it.next(), map);
            }
            return h(map, l5.natural().reverse());
        }

        public final i3<K> d(K type) {
            return c(i3.of(type));
        }

        public abstract Iterable<? extends K> e(K type);

        public abstract Class<?> f(K type);

        @gm.a
        public abstract K g(K type);

        public i(a aVar) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class j implements i0<q<?>> {
        public static final j IGNORE_TYPE_VARIABLE_OR_WILDCARD = new a("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
        public static final j INTERFACE_ONLY = new b("INTERFACE_ONLY", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ j[] f12747a = a();

        public final enum a extends j {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(q<?> type) {
                return ((((q) type).runtimeType instanceof TypeVariable) || (((q) type).runtimeType instanceof WildcardType)) ? false : true;
            }
        }

        public final enum b extends j {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(q<?> type) {
                return type.getRawType().isInterface();
            }
        }

        public j(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ j[] a() {
            return new j[]{IGNORE_TYPE_VARIABLE_OR_WILDCARD, INTERFACE_ONLY};
        }

        public static j valueOf(String name) {
            return (j) Enum.valueOf(j.class, name);
        }

        public static j[] values() {
            return (j[]) f12747a.clone();
        }

        public j(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public /* synthetic */ q(Type type, a aVar) {
        this(type);
    }

    public static e a(Type[] bounds) {
        return new e(bounds, true);
    }

    public static Type d(TypeVariable<?> declaration, Type typeArg) {
        return typeArg instanceof WildcardType ? e(declaration, (WildcardType) typeArg) : g(typeArg);
    }

    public static WildcardType e(TypeVariable<?> declaration, WildcardType type) {
        Type[] bounds = declaration.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type2 : type.getUpperBounds()) {
            if (!a(bounds).a(type2)) {
                arrayList.add(g(type2));
            }
        }
        return new t.i(type.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    public static ParameterizedType f(ParameterizedType type) {
        Class cls = (Class) type.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = type.getActualTypeArguments();
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            actualTypeArguments[i10] = d(typeParameters[i10], actualTypeArguments[i10]);
        }
        return t.m(type.getOwnerType(), cls, actualTypeArguments);
    }

    public static Type g(Type type) {
        if (type instanceof ParameterizedType) {
            return f((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? t.j(g(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    public static e h(Type[] bounds) {
        return new e(bounds, false);
    }

    public static <T> q<T> of(Class<T> type) {
        return new h(type);
    }

    @b1.e
    public static <T> q<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (q<? extends T>) of(t.j(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (q<? extends T>) of(t.m(type, cls, typeParameters)) : of((Class) cls);
    }

    public static Type w(Type componentType) {
        return t.d.JAVA7.newArrayType(componentType);
    }

    @gm.a
    public final q<? super T> b(Type type) {
        q<? super T> qVar = (q<? super T>) of(type);
        if (qVar.getRawType().isInterface()) {
            return null;
        }
        return qVar;
    }

    public final i3<q<? super T>> c(Type[] bounds) {
        i3.a aVarBuilder = i3.builder();
        for (Type type : bounds) {
            q<?> qVarOf = of(type);
            if (qVarOf.getRawType().isInterface()) {
                aVarBuilder.j(qVarOf);
            }
        }
        return aVarBuilder.e();
    }

    public final p1.g<T, T> constructor(Constructor<?> constructor) {
        h0.y(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(@gm.a Object o10) {
        if (o10 instanceof q) {
            return this.runtimeType.equals(((q) o10).runtimeType);
        }
        return false;
    }

    @gm.a
    public final q<?> getComponentType() {
        Type typeI = t.i(this.runtimeType);
        if (typeI == null) {
            return null;
        }
        return of(typeI);
    }

    public final i3<q<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return c(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return c(((WildcardType) type).getUpperBounds());
        }
        i3.a aVarBuilder = i3.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            aVarBuilder.j(x(type2));
        }
        return aVarBuilder.e();
    }

    @gm.a
    public final q<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return b(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return b(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (q<? super T>) x(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return n().iterator().next();
    }

    public final q<? extends T> getSubtype(Class<?> cls) {
        h0.u(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return o(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return i(cls);
        }
        h0.y(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        q<? extends T> qVar = (q<? extends T>) of(y(cls));
        h0.y(qVar.isSubtypeOf((q<?>) this), "%s does not appear to be a subtype of %s", qVar, this);
        return qVar;
    }

    public final q<? super T> getSupertype(Class<? super T> cls) {
        h0.y(z(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return p(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return p(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? j(cls) : (q<? super T>) x(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final q<T>.k getTypes() {
        return new k();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final q<? extends T> i(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            q<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (q<? extends T>) of(t.d.JAVA7.newArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        throw new IllegalArgumentException(cls + " does not appear to be a subtype of " + this);
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(q<?> type) {
        return isSubtypeOf(type.getType());
    }

    public final boolean isSupertypeOf(q<?> type) {
        return type.isSubtypeOf(getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<? super T> j(Class<? super T> cls) {
        q<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (q<? super T>) of(t.d.JAVA7.newArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    public final o k() {
        o oVar = this.f12732b;
        if (oVar != null) {
            return oVar;
        }
        o oVarD = o.d(this.runtimeType);
        this.f12732b = oVarD;
        return oVarD;
    }

    public final o l() {
        o oVar = this.f12731a;
        if (oVar != null) {
            return oVar;
        }
        o oVarF = o.f(this.runtimeType);
        this.f12731a = oVarF;
        return oVarF;
    }

    @gm.a
    public final Type m() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    public final p1.g<T, Object> method(Method method) {
        h0.y(z(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final t3<Class<? super T>> n() {
        t3.a aVarBuilder = t3.builder();
        new d(this, aVarBuilder).a(this.runtimeType);
        return aVarBuilder.e();
    }

    public final q<? extends T> o(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (q<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    public final q<? super T> p(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            q<?> qVarOf = of(type);
            if (qVarOf.isSubtypeOf(cls)) {
                return (q<? super T>) qVarOf.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    public final boolean q(Type formalType, TypeVariable<?> declaration) {
        if (this.runtimeType.equals(formalType)) {
            return true;
        }
        if (!(formalType instanceof WildcardType)) {
            return g(this.runtimeType).equals(g(formalType));
        }
        WildcardType wildcardTypeE = e(declaration, (WildcardType) formalType);
        return h(wildcardTypeE.getUpperBounds()).b(this.runtimeType) && h(wildcardTypeE.getLowerBounds()).a(this.runtimeType);
    }

    public final boolean r(Type supertype) {
        Iterator<q<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type typeM = it.next().m();
            if (typeM != null && of(typeM).isSubtypeOf(supertype)) {
                return true;
            }
        }
        return false;
    }

    @t1.a
    public final q<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final q<?> resolveType(Type type) {
        type.getClass();
        return of(l().j(type));
    }

    public final boolean s(GenericArrayType supertype) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(supertype.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(supertype.getGenericComponentType());
        }
        return false;
    }

    public final boolean t(ParameterizedType supertype) {
        Class<? super Object> rawType = of(supertype).getRawType();
        if (!z(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = supertype.getActualTypeArguments();
        for (int i10 = 0; i10 < typeParameters.length; i10++) {
            if (!of(k().j(typeParameters[i10])).q(actualTypeArguments[i10], typeParameters[i10])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) supertype.getRawType()).getModifiers()) || supertype.getOwnerType() == null || r(supertype.getOwnerType());
    }

    public String toString() {
        return t.s(this.runtimeType);
    }

    public final boolean u(GenericArrayType subtype) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(subtype.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(subtype.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    public final q<T> unwrap() {
        return v() ? of(o1.q.e((Class) this.runtimeType)) : this;
    }

    public final boolean v() {
        return o1.q.c().contains(this.runtimeType);
    }

    public final <X> q<T> where(n<X> typeParam, q<X> typeArg) {
        return new h(new o().o(k3.of(new o.d(typeParam.f12719a), typeArg.runtimeType)).j(this.runtimeType));
    }

    public final q<T> wrap() {
        return isPrimitive() ? of(o1.q.f((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new o().j(this.runtimeType));
    }

    public final q<?> x(Type type) {
        q<?> qVarOf = of(k().j(type));
        qVarOf.f12732b = this.f12732b;
        qVarOf.f12731a = this.f12731a;
        return qVarOf;
    }

    public final Type y(Class<?> subclass) {
        if ((this.runtimeType instanceof Class) && (subclass.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return subclass;
        }
        q genericType = toGenericType(subclass);
        return new o().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    public final boolean z(Class<?> superclass) {
        x7<Class<? super T>> it = n().iterator();
        while (it.hasNext()) {
            if (superclass.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final class g extends q<T>.k {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient q<T>.k f12740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public transient t3<q<? super T>> f12741c;

        public g(q<T>.k allTypes) {
            super();
            this.f12740b = allTypes;
        }

        private Object readResolve() {
            return q.this.getTypes().interfaces();
        }

        @Override // p1.q.k
        public q<T>.k classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // p1.q.k
        public q<T>.k interfaces() {
            return this;
        }

        @Override // p1.q.k
        public Set<Class<? super T>> rawTypes() {
            return p1.u(i.f12743b.c(q.this.n())).o(new r()).I();
        }

        @Override // p1.q.k, f1.l2, f1.s1, f1.j2
        public Set<q<? super T>> delegate() {
            t3<q<? super T>> t3Var = this.f12741c;
            if (t3Var != null) {
                return t3Var;
            }
            t3<q<? super T>> t3VarI = p1.u(this.f12740b).o(j.INTERFACE_ONLY).I();
            this.f12741c = t3VarI;
            return t3VarI;
        }
    }

    public class k extends l2<q<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public transient t3<q<? super T>> f12748a;

        public k() {
        }

        public q<T>.k classes() {
            return new f(q.this, null);
        }

        public q<T>.k interfaces() {
            return new g(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return t3.copyOf((Collection) i.f12743b.c(q.this.n()));
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<q<? super T>> delegate() {
            t3<q<? super T>> t3Var = this.f12748a;
            if (t3Var != null) {
                return t3Var;
            }
            t3<q<? super T>> t3VarI = p1.u(i.f12742a.d(q.this)).o(j.IGNORE_TYPE_VARIABLE_OR_WILDCARD).I();
            this.f12748a = t3VarI;
            return t3VarI;
        }
    }

    public q() {
        Type typeCapture = capture();
        this.runtimeType = typeCapture;
        h0.x0(!(typeCapture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeCapture);
    }

    public static q<?> of(Type type) {
        return new h(type);
    }

    public final boolean isSubtypeOf(Type supertype) {
        supertype.getClass();
        if (supertype instanceof WildcardType) {
            return a(((WildcardType) supertype).getLowerBounds()).b(this.runtimeType);
        }
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getUpperBounds()).a(supertype);
        }
        if (type instanceof TypeVariable) {
            return type.equals(supertype) || a(((TypeVariable) this.runtimeType).getBounds()).a(supertype);
        }
        if (type instanceof GenericArrayType) {
            return of(supertype).u((GenericArrayType) this.runtimeType);
        }
        if (supertype instanceof Class) {
            return z((Class) supertype);
        }
        if (supertype instanceof ParameterizedType) {
            return t((ParameterizedType) supertype);
        }
        if (supertype instanceof GenericArrayType) {
            return s((GenericArrayType) supertype);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public q(Class<?> declaringClass) {
        Type typeCapture = capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = o.d(declaringClass).j(typeCapture);
        }
    }

    public final <X> q<T> where(n<X> typeParam, Class<X> typeArg) {
        return where(typeParam, of((Class) typeArg));
    }

    public q(Type type) {
        type.getClass();
        this.runtimeType = type;
    }
}
