package p1;

import c1.h0;
import c1.y;
import f1.k3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import jq.m0;

/* JADX INFO: loaded from: classes.dex */
@p1.d
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12720a;

    public class a extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f12721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f12722c;

        public a(final Map val$mappings, final Type val$to) {
            this.f12721b = val$mappings;
            this.f12722c = val$to;
        }

        @Override // p1.s
        public void b(Class<?> fromClass) {
            if (this.f12722c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + fromClass + " to " + this.f12722c);
        }

        @Override // p1.s
        public void c(GenericArrayType fromArrayType) {
            Type type = this.f12722c;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeI = t.i(type);
            h0.u(typeI != null, "%s is not an array type.", this.f12722c);
            o.g(this.f12721b, fromArrayType.getGenericComponentType(), typeI);
        }

        @Override // p1.s
        public void d(ParameterizedType fromParameterizedType) {
            Type type = this.f12722c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType = (ParameterizedType) o.e(ParameterizedType.class, type);
            if (fromParameterizedType.getOwnerType() != null && parameterizedType.getOwnerType() != null) {
                o.g(this.f12721b, fromParameterizedType.getOwnerType(), parameterizedType.getOwnerType());
            }
            h0.y(fromParameterizedType.getRawType().equals(parameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", fromParameterizedType, this.f12722c);
            Type[] actualTypeArguments = fromParameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType.getActualTypeArguments();
            h0.y(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", fromParameterizedType, parameterizedType);
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                o.g(this.f12721b, actualTypeArguments[i10], actualTypeArguments2[i10]);
            }
        }

        @Override // p1.s
        public void e(TypeVariable<?> typeVariable) {
            this.f12721b.put(new d(typeVariable), this.f12722c);
        }

        @Override // p1.s
        public void f(WildcardType fromWildcardType) {
            Type type = this.f12722c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] upperBounds = fromWildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType.getUpperBounds();
                Type[] lowerBounds = fromWildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType.getLowerBounds();
                h0.y(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", fromWildcardType, this.f12722c);
                for (int i10 = 0; i10 < upperBounds.length; i10++) {
                    o.g(this.f12721b, upperBounds[i10], upperBounds2[i10]);
                }
                for (int i11 = 0; i11 < lowerBounds.length; i11++) {
                    o.g(this.f12721b, lowerBounds[i11], lowerBounds2[i11]);
                }
            }
        }
    }

    public static final class b extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<d, Type> f12723b = new HashMap();

        public static k3<d, Type> g(Type contextType) {
            contextType.getClass();
            b bVar = new b();
            bVar.a(contextType);
            return k3.copyOf((Map) bVar.f12723b);
        }

        @Override // p1.s
        public void b(Class<?> clazz) {
            a(clazz.getGenericSuperclass());
            a(clazz.getGenericInterfaces());
        }

        @Override // p1.s
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            h0.g0(typeParameters.length == actualTypeArguments.length);
            for (int i10 = 0; i10 < typeParameters.length; i10++) {
                h(new d(typeParameters[i10]), actualTypeArguments[i10]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // p1.s
        public void e(TypeVariable<?> t10) {
            a(t10.getBounds());
        }

        @Override // p1.s
        public void f(WildcardType t10) {
            a(t10.getUpperBounds());
        }

        public final void h(d var, Type arg) {
            if (this.f12723b.containsKey(var)) {
                return;
            }
            Type type = arg;
            while (type != null) {
                if (var.a(type)) {
                    while (arg != null) {
                        arg = this.f12723b.remove(d.c(arg));
                    }
                    return;
                }
                type = this.f12723b.get(d.c(type));
            }
            this.f12723b.put(var, arg);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f12727a;

        public d(TypeVariable<?> var) {
            var.getClass();
            this.f12727a = var;
        }

        @gm.a
        public static d c(Type t10) {
            if (t10 instanceof TypeVariable) {
                return new d((TypeVariable) t10);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> that) {
            return this.f12727a.getGenericDeclaration().equals(that.getGenericDeclaration()) && this.f12727a.getName().equals(that.getName());
        }

        public boolean equals(@gm.a Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f12727a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f12727a.getGenericDeclaration(), this.f12727a.getName()});
        }

        public String toString() {
            return this.f12727a.toString();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f12728b = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f12729a;

        public class a extends e {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f12730c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(final e this$0, AtomicInteger id2, final TypeVariable val$typeParam) {
                super(id2);
                this.f12730c = val$typeParam;
            }

            @Override // p1.o.e
            public TypeVariable<?> b(Type[] upperBounds) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(upperBounds));
                linkedHashSet.addAll(Arrays.asList(this.f12730c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            type.getClass();
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return t.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                actualTypeArguments[i10] = d(typeParameters[i10]).a(actualTypeArguments[i10]);
            }
            return t.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable<?> b(Type[] upperBounds) {
            return t.k(e.class, "capture#" + this.f12729a.incrementAndGet() + "-of ? extends " + y.o(m0.f8866d).n(upperBounds), upperBounds);
        }

        @gm.a
        public final Type c(@gm.a Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable<?> typeParam) {
            return new a(this, this.f12729a, typeParam);
        }

        public final e e() {
            return new e(this.f12729a);
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger id2) {
            this.f12729a = id2;
        }
    }

    public /* synthetic */ o(c cVar, a aVar) {
        this(cVar);
    }

    public static o d(Type contextType) {
        return new o().o(b.g(contextType));
    }

    public static <T> T e(Class<T> type, Object arg) {
        try {
            return type.cast(arg);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(arg + " is not a " + type.getSimpleName());
        }
    }

    public static o f(Type contextType) {
        return new o().o(b.g(e.f12728b.a(contextType)));
    }

    public static void g(Map<d, Type> mappings, Type from, Type to2) {
        if (from.equals(to2)) {
            return;
        }
        new a(mappings, to2).a(from);
    }

    public final Type h(GenericArrayType type) {
        return t.j(j(type.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType type) {
        Type ownerType = type.getOwnerType();
        return t.m(ownerType == null ? null : j(ownerType), (Class) j(type.getRawType()), k(type.getActualTypeArguments()));
    }

    public Type j(Type type) {
        type.getClass();
        if (type instanceof TypeVariable) {
            return this.f12720a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] types) {
        Type[] typeArr = new Type[types.length];
        for (int i10 = 0; i10 < types.length; i10++) {
            typeArr[i10] = j(types[i10]);
        }
        return typeArr;
    }

    public Type[] l(Type[] types) {
        for (int i10 = 0; i10 < types.length; i10++) {
            types[i10] = j(types[i10]);
        }
        return types;
    }

    public final WildcardType m(WildcardType type) {
        return new t.i(k(type.getLowerBounds()), k(type.getUpperBounds()));
    }

    public o n(Type formal, Type actual) {
        HashMap map = new HashMap();
        formal.getClass();
        actual.getClass();
        g(map, formal, actual);
        return o(map);
    }

    public o o(Map<d, ? extends Type> mappings) {
        return new o(this.f12720a.c(mappings));
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3<d, Type> f12724a;

        public class a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f12725b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f12726c;

            public a(final c this$0, final TypeVariable val$var, final c val$unguarded) {
                this.f12725b = val$var;
                this.f12726c = val$unguarded;
            }

            @Override // p1.o.c
            public Type b(TypeVariable<?> intermediateVar, c forDependent) {
                return intermediateVar.getGenericDeclaration().equals(this.f12725b.getGenericDeclaration()) ? intermediateVar : this.f12726c.b(intermediateVar, forDependent);
            }
        }

        public c() {
            this.f12724a = k3.of();
        }

        public final Type a(TypeVariable<?> var) {
            return b(var, new a(this, var, this));
        }

        public Type b(TypeVariable<?> var, c forDependants) {
            Type type = this.f12724a.get(new d(var));
            if (type != null) {
                return new o(forDependants).j(type);
            }
            Type[] bounds = var.getBounds();
            if (bounds.length == 0) {
                return var;
            }
            Type[] typeArrK = new o(forDependants).k(bounds);
            return (t.e.f12754a && Arrays.equals(bounds, typeArrK)) ? var : t.k(var.getGenericDeclaration(), var.getName(), typeArrK);
        }

        public final c c(Map<d, ? extends Type> mappings) {
            k3.b bVarBuilder = k3.builder();
            bVarBuilder.l(this.f12724a);
            for (Map.Entry<d, ? extends Type> entry : mappings.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                h0.u(!key.a(value), "Type variable %s bound to itself", key);
                bVarBuilder.i(key, value);
            }
            return new c(bVarBuilder.d());
        }

        public c(k3<d, Type> map) {
            this.f12724a = map;
        }
    }

    public o() {
        this.f12720a = new c();
    }

    public o(c typeTable) {
        this.f12720a = typeTable;
    }
}
