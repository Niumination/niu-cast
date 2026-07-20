package p1;

import c1.b0;
import c1.h0;
import c1.j0;
import c1.y;
import f1.g4;
import f1.i3;
import f1.k3;
import f1.x7;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import jq.m0;

/* JADX INFO: loaded from: classes.dex */
@p1.d
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f12750a = new y(", ").s(d6.a.E);

    public class a extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f12751b;

        public a(final AtomicReference val$result) {
            this.f12751b = val$result;
        }

        @Override // p1.s
        public void b(Class<?> t10) {
            this.f12751b.set(t10.getComponentType());
        }

        @Override // p1.s
        public void c(GenericArrayType t10) {
            this.f12751b.set(t10.getGenericComponentType());
        }

        @Override // p1.s
        public void e(TypeVariable<?> t10) {
            this.f12751b.set(t.p(t10.getBounds()));
        }

        @Override // p1.s
        public void f(WildcardType t10) {
            this.f12751b.set(t.p(t10.getUpperBounds()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b {
        public static final b OWNED_BY_ENCLOSING_CLASS = new a("OWNED_BY_ENCLOSING_CLASS", 0);
        public static final b LOCAL_CLASS_HAS_NO_OWNER = new c("LOCAL_CLASS_HAS_NO_OWNER", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f12752a = a();
        static final b JVM_BEHAVIOR = b();

        public final enum a extends b {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.b
            @gm.a
            public Class<?> getOwnerType(Class<?> rawType) {
                return rawType.getEnclosingClass();
            }
        }

        /* JADX INFO: renamed from: p1.t$b$b, reason: collision with other inner class name */
        public class C0323b<T> {
        }

        public final enum c extends b {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.b
            @gm.a
            public Class<?> getOwnerType(Class<?> rawType) {
                if (rawType.isLocalClass()) {
                    return null;
                }
                return rawType.getEnclosingClass();
            }
        }

        public class d extends C0323b<String> {
        }

        public b(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{OWNED_BY_ENCLOSING_CLASS, LOCAL_CLASS_HAS_NO_OWNER};
        }

        public static b b() {
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (b bVar : values()) {
                if (bVar.getOwnerType(C0323b.class) == parameterizedType2.getOwnerType()) {
                    return bVar;
                }
            }
            throw new AssertionError();
        }

        public static b valueOf(String name) {
            return (b) Enum.valueOf(b.class, name);
        }

        public static b[] values() {
            return (b[]) f12752a.clone();
        }

        @gm.a
        public abstract Class<?> getOwnerType(Class<?> rawType);

        public b(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static final class c implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public c(Type componentType) {
            this.componentType = d.CURRENT.usedInGenericType(componentType);
        }

        public boolean equals(@gm.a Object obj) {
            if (obj instanceof GenericArrayType) {
                return b0.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return t.s(this.componentType) + "[]";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class d {
        static final d CURRENT;
        public static final d JAVA6;
        public static final d JAVA7;
        public static final d JAVA8;
        public static final d JAVA9;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f12753a;

        public final enum a extends d {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.d
            public Type usedInGenericType(Type type) {
                type.getClass();
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new c(cls.getComponentType()) : type;
            }

            @Override // p1.t.d
            public GenericArrayType newArrayType(Type componentType) {
                return new c(componentType);
            }
        }

        public final enum b extends d {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.d
            public Type newArrayType(Type componentType) {
                return componentType instanceof Class ? t.h((Class) componentType) : new c(componentType);
            }

            @Override // p1.t.d
            public Type usedInGenericType(Type type) {
                type.getClass();
                return type;
            }
        }

        public final enum c extends d {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.d
            public Type newArrayType(Type componentType) {
                return d.JAVA7.newArrayType(componentType);
            }

            @Override // p1.t.d
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11);
                }
            }

            @Override // p1.t.d
            public Type usedInGenericType(Type type) {
                return d.JAVA7.usedInGenericType(type);
            }
        }

        /* JADX INFO: renamed from: p1.t$d$d, reason: collision with other inner class name */
        public final enum C0324d extends d {
            public C0324d(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // p1.t.d
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // p1.t.d
            public Type newArrayType(Type componentType) {
                return d.JAVA8.newArrayType(componentType);
            }

            @Override // p1.t.d
            public String typeName(Type type) {
                return d.JAVA8.typeName(type);
            }

            @Override // p1.t.d
            public Type usedInGenericType(Type type) {
                return d.JAVA8.usedInGenericType(type);
            }
        }

        public class e extends m<Map.Entry<String, int[][]>> {
        }

        public class f extends m<int[]> {
        }

        static {
            a aVar = new a("JAVA6", 0);
            JAVA6 = aVar;
            b bVar = new b("JAVA7", 1);
            JAVA7 = bVar;
            c cVar = new c("JAVA8", 2);
            JAVA8 = cVar;
            C0324d c0324d = new C0324d("JAVA9", 3);
            JAVA9 = c0324d;
            f12753a = a();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new e().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = cVar;
                    return;
                } else {
                    CURRENT = c0324d;
                    return;
                }
            }
            if (new f().capture() instanceof Class) {
                CURRENT = bVar;
            } else {
                CURRENT = aVar;
            }
        }

        public d(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ d[] a() {
            return new d[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        public static d valueOf(String name) {
            return (d) Enum.valueOf(d.class, name);
        }

        public static d[] values() {
            return (d[]) f12753a.clone();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type componentType);

        public String typeName(Type type) {
            return t.s(type);
        }

        public final i3<Type> usedInGenericType(Type[] types) {
            i3.a aVarBuilder = i3.builder();
            for (Type type : types) {
                aVarBuilder.j(usedInGenericType(type));
            }
            return aVarBuilder.e();
        }

        public abstract Type usedInGenericType(Type type);

        public d(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static final class e<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f12754a = !e.class.getTypeParameters()[0].equals(t.k(e.class, "X", new Type[0]));
    }

    public static final class f implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final i3<Type> argumentsList;

        @gm.a
        private final Type ownerType;
        private final Class<?> rawType;

        public f(@gm.a Type ownerType, Class<?> rawType, Type[] typeArguments) {
            rawType.getClass();
            h0.d(typeArguments.length == rawType.getTypeParameters().length);
            t.f(typeArguments, "type parameter");
            this.ownerType = ownerType;
            this.rawType = rawType;
            this.argumentsList = d.CURRENT.usedInGenericType(typeArguments);
        }

        public boolean equals(@gm.a Object other) {
            if (!(other instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) other;
            return getRawType().equals(parameterizedType.getRawType()) && b0.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return t.r(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        @gm.a
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return this.rawType.hashCode() ^ ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.ownerType != null) {
                d dVar = d.CURRENT;
                if (dVar.jdkTypeDuplicatesOwnerName()) {
                    sb2.append(dVar.typeName(this.ownerType));
                    sb2.append(n1.e.f11183c);
                }
            }
            sb2.append(this.rawType.getName());
            sb2.append(m0.f8867e);
            y yVar = t.f12750a;
            i3<Type> i3Var = this.argumentsList;
            final d dVar2 = d.CURRENT;
            Objects.requireNonNull(dVar2);
            sb2.append(yVar.k(g4.T(i3Var, new c1.t() { // from class: p1.u
                @Override // c1.t
                public final Object apply(Object obj) {
                    return dVar2.typeName((Type) obj);
                }
            })));
            sb2.append(m0.f8868f);
            return sb2.toString();
        }
    }

    public static final class g<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f12755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i3<Type> f12757c;

        public g(D genericDeclaration, String name, Type[] bounds) {
            t.f(bounds, "bound for type variable");
            genericDeclaration.getClass();
            this.f12755a = genericDeclaration;
            name.getClass();
            this.f12756b = name;
            this.f12757c = i3.copyOf(bounds);
        }

        public Type[] a() {
            return t.r(this.f12757c);
        }

        public D b() {
            return this.f12755a;
        }

        public String c() {
            return this.f12756b;
        }

        public String d() {
            return this.f12756b;
        }

        public boolean equals(@gm.a Object obj) {
            if (!e.f12754a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f12756b.equals(typeVariable.getName()) && this.f12755a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof h)) {
                return false;
            }
            g gVar = ((h) Proxy.getInvocationHandler(obj)).f12759a;
            return this.f12756b.equals(gVar.f12756b) && this.f12755a.equals(gVar.f12755a) && this.f12757c.equals(gVar.f12757c);
        }

        public int hashCode() {
            return this.f12756b.hashCode() ^ this.f12755a.hashCode();
        }

        public String toString() {
            return this.f12756b;
        }
    }

    public static final class h implements InvocationHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k3<String, Method> f12758b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<?> f12759a;

        static {
            k3.b bVarBuilder = k3.builder();
            for (Method method : g.class.getMethods()) {
                if (method.getDeclaringClass().equals(g.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    bVarBuilder.i(method.getName(), method);
                }
            }
            f12758b = bVarBuilder.c();
        }

        public h(g<?> typeVariableImpl) {
            this.f12759a = typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        @gm.a
        public Object invoke(Object proxy, Method method, @gm.a Object[] args) throws Throwable {
            String name = method.getName();
            Method method2 = f12758b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f12759a, args);
            } catch (InvocationTargetException e10) {
                throw e10.getCause();
            }
        }
    }

    public static final class i implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final i3<Type> lowerBounds;
        private final i3<Type> upperBounds;

        public i(Type[] lowerBounds, Type[] upperBounds) {
            t.f(lowerBounds, "lower bound for wildcard");
            t.f(upperBounds, "upper bound for wildcard");
            d dVar = d.CURRENT;
            this.lowerBounds = dVar.usedInGenericType(lowerBounds);
            this.upperBounds = dVar.usedInGenericType(upperBounds);
        }

        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return t.r(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return t.r(this.upperBounds);
        }

        public int hashCode() {
            return this.upperBounds.hashCode() ^ this.lowerBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("?");
            x7<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                Type next = it.next();
                sb2.append(" super ");
                sb2.append(d.CURRENT.typeName(next));
            }
            for (Type type : t.g(this.upperBounds)) {
                sb2.append(" extends ");
                sb2.append(d.CURRENT.typeName(type));
            }
            return sb2.toString();
        }
    }

    public static void f(Type[] types, String usedAs) {
        for (Type type : types) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                h0.y(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, usedAs);
            }
        }
    }

    public static Iterable<Type> g(Iterable<Type> bounds) {
        return g4.o(bounds, new j0.i(j0.m(Object.class)));
    }

    public static Class<?> h(Class<?> componentType) {
        return Array.newInstance(componentType, 0).getClass();
    }

    @gm.a
    public static Type i(Type type) {
        type.getClass();
        AtomicReference atomicReference = new AtomicReference();
        new a(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type j(Type componentType) {
        if (!(componentType instanceof WildcardType)) {
            return d.CURRENT.newArrayType(componentType);
        }
        WildcardType wildcardType = (WildcardType) componentType;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        h0.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        h0.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    public static <D extends GenericDeclaration> TypeVariable<D> k(D declaration, String name, Type... bounds) {
        if (bounds.length == 0) {
            bounds = new Type[]{Object.class};
        }
        return n(declaration, name, bounds);
    }

    public static ParameterizedType l(Class<?> rawType, Type... arguments) {
        return new f(b.JVM_BEHAVIOR.getOwnerType(rawType), rawType, arguments);
    }

    public static ParameterizedType m(@gm.a Type ownerType, Class<?> rawType, Type... arguments) {
        if (ownerType == null) {
            return l(rawType, arguments);
        }
        arguments.getClass();
        h0.u(rawType.getEnclosingClass() != null, "Owner type for unenclosed %s", rawType);
        return new f(ownerType, rawType, arguments);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> n(D genericDeclaration, String name, Type[] bounds) {
        return (TypeVariable) l.d(TypeVariable.class, new h(new g(genericDeclaration, name, bounds)));
    }

    @b1.e
    public static WildcardType o(Type upperBound) {
        return new i(new Type[0], new Type[]{upperBound});
    }

    @gm.a
    public static Type p(Type[] bounds) {
        for (Type type : bounds) {
            Type typeI = i(type);
            if (typeI != null) {
                if (typeI instanceof Class) {
                    Class cls = (Class) typeI;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(typeI);
            }
        }
        return null;
    }

    @b1.e
    public static WildcardType q(Type lowerBound) {
        return new i(new Type[]{lowerBound}, new Type[]{Object.class});
    }

    public static Type[] r(Collection<Type> types) {
        return (Type[]) types.toArray(new Type[0]);
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
