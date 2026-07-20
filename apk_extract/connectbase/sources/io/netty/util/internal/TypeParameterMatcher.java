package io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeParameterMatcher {
    private static final TypeParameterMatcher NOOP = new TypeParameterMatcher() { // from class: io.netty.util.internal.TypeParameterMatcher.1
        @Override // io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object obj) {
            return true;
        }
    };

    public static final class ReflectiveMatcher extends TypeParameterMatcher {
        private final Class<?> type;

        public ReflectiveMatcher(Class<?> cls) {
            this.type = cls;
        }

        @Override // io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object obj) {
            return this.type.isInstance(obj);
        }
    }

    private static Class<?> fail(Class<?> cls, String str) {
        throw new IllegalStateException("cannot determine the type of the type parameter '" + str + "': " + cls);
    }

    public static TypeParameterMatcher find(Object obj, Class<?> cls, String str) {
        Map<Class<?>, Map<String, TypeParameterMatcher>> mapTypeParameterMatcherFindCache = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
        Class<?> cls2 = obj.getClass();
        Map<String, TypeParameterMatcher> map = mapTypeParameterMatcherFindCache.get(cls2);
        if (map == null) {
            map = new HashMap<>();
            mapTypeParameterMatcherFindCache.put(cls2, map);
        }
        TypeParameterMatcher typeParameterMatcher = map.get(str);
        if (typeParameterMatcher != null) {
            return typeParameterMatcher;
        }
        TypeParameterMatcher typeParameterMatcher2 = get(find0(obj, cls, str));
        map.put(str, typeParameterMatcher2);
        return typeParameterMatcher2;
    }

    private static Class<?> find0(Object obj, Class<?> cls, String str) {
        Class<?> cls2 = obj.getClass();
        Class<?> superclass = cls2;
        while (true) {
            if (superclass.getSuperclass() == cls) {
                TypeVariable<Class<? super Object>>[] typeParameters = superclass.getSuperclass().getTypeParameters();
                int i10 = 0;
                while (true) {
                    if (i10 >= typeParameters.length) {
                        i10 = -1;
                        break;
                    }
                    if (str.equals(typeParameters[i10].getName())) {
                        break;
                    }
                    i10++;
                }
                if (i10 < 0) {
                    throw new IllegalStateException("unknown type parameter '" + str + "': " + cls);
                }
                Type genericSuperclass = superclass.getGenericSuperclass();
                if (!(genericSuperclass instanceof ParameterizedType)) {
                    return Object.class;
                }
                Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i10];
                if (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                if (rawType instanceof GenericArrayType) {
                    Type genericComponentType = ((GenericArrayType) rawType).getGenericComponentType();
                    if (genericComponentType instanceof ParameterizedType) {
                        genericComponentType = ((ParameterizedType) genericComponentType).getRawType();
                    }
                    if (genericComponentType instanceof Class) {
                        return Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                    }
                }
                if (!(rawType instanceof TypeVariable)) {
                    return fail(cls2, str);
                }
                TypeVariable typeVariable = (TypeVariable) rawType;
                if (!(typeVariable.getGenericDeclaration() instanceof Class)) {
                    return Object.class;
                }
                Class<?> cls3 = (Class) typeVariable.getGenericDeclaration();
                String name = typeVariable.getName();
                if (!cls3.isAssignableFrom(cls2)) {
                    return Object.class;
                }
                superclass = cls2;
                str = name;
                cls = cls3;
            } else {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    return fail(cls2, str);
                }
            }
        }
    }

    public static TypeParameterMatcher get(Class<?> cls) {
        Map<Class<?>, TypeParameterMatcher> mapTypeParameterMatcherGetCache = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
        TypeParameterMatcher reflectiveMatcher = mapTypeParameterMatcherGetCache.get(cls);
        if (reflectiveMatcher == null) {
            reflectiveMatcher = cls == Object.class ? NOOP : new ReflectiveMatcher(cls);
            mapTypeParameterMatcherGetCache.put(cls, reflectiveMatcher);
        }
        return reflectiveMatcher;
    }

    public abstract boolean match(Object obj);
}
