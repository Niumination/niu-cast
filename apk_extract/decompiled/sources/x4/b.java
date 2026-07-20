package x4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final Map<Type, v4.s> instanceCreators;
    private final List<v4.g0> reflectionFilters;
    private final boolean useJdkUnsafe;

    public b(Map<Type, v4.s> map, boolean z2, List<v4.g0> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z2;
        this.reflectionFilters = list;
    }

    private static boolean hasStringKeyType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        return actualTypeArguments.length != 0 && i.getRawType(actualTypeArguments[0]) == String.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$2(String str) {
        throw new v4.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$3(String str) {
        throw new v4.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$4(String str) {
        throw new v4.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$10() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$11() {
        return new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$12() {
        return new TreeSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$13() {
        return new ArrayDeque();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$7(String str) {
        throw new v4.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$8(String str) {
        throw new v4.v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$9(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e) {
            throw a5.d.createExceptionForUnexpectedIllegalAccess(e);
        } catch (InstantiationException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + a5.d.constructorToString(constructor) + "' with no args", e4);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("Failed to invoke constructor '" + a5.d.constructorToString(constructor) + "' with no args", e10.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$14() {
        return new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$15() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$16() {
        return new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$17() {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$18() {
        return new ConcurrentSkipListMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$5(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new v4.v("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new v4.v("Invalid EnumSet type: " + type.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$6(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new v4.v("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new v4.v("Invalid EnumMap type: " + type.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$19(Class cls) {
        try {
            return i0.INSTANCE.newInstance(cls);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$20(String str) {
        throw new v4.v(str);
    }

    private static t newCollectionConstructor(Class<?> cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new e0.b(17);
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new e0.b(18);
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new e0.b(19);
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return new e0.b(20);
        }
        return null;
    }

    private static <T> t newDefaultConstructor(Class<? super T> cls, v4.f0 f0Var) {
        String strTryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            v4.f0 f0Var2 = v4.f0.ALLOW;
            if (f0Var == f0Var2 || (z.canAccess(declaredConstructor, null) && (f0Var != v4.f0.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (f0Var != f0Var2 || (strTryMakeAccessible = a5.d.tryMakeAccessible(declaredConstructor)) == null) ? new a4.b(declaredConstructor, 27) : new e0.a(strTryMakeAccessible, 3);
            }
            return new e0.a("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.", 2);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> t newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return newCollectionConstructor(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return newMapConstructor(type, cls);
        }
        return null;
    }

    private static t newMapConstructor(Type type, Class<?> cls) {
        if (cls.isAssignableFrom(q.class) && hasStringKeyType(type)) {
            return new e0.b(12);
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return new e0.b(13);
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new e0.b(14);
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return new e0.b(15);
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return new e0.b(16);
        }
        return null;
    }

    private static <T> t newSpecialCollectionConstructor(final Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            final int i8 = 1;
            return new t() { // from class: x4.a
                @Override // x4.t
                public final Object construct() {
                    int i9 = i8;
                    Type type2 = type;
                    switch (i9) {
                        case 0:
                            return b.lambda$newSpecialCollectionConstructor$6(type2);
                        default:
                            return b.lambda$newSpecialCollectionConstructor$5(type2);
                    }
                }
            };
        }
        if (cls != EnumMap.class) {
            return null;
        }
        final int i9 = 0;
        return new t() { // from class: x4.a
            @Override // x4.t
            public final Object construct() {
                int i10 = i9;
                Type type2 = type;
                switch (i10) {
                    case 0:
                        return b.lambda$newSpecialCollectionConstructor$6(type2);
                    default:
                        return b.lambda$newSpecialCollectionConstructor$5(type2);
                }
            }
        };
    }

    private <T> t newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new a4.b(cls, 28);
        }
        String strB = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            strB = h0.a.B(strB, " Or adjust your R8 configuration to keep the no-args constructor of the class.");
        }
        return new e0.a(strB, 6);
    }

    public static String t(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + d0.createUrl("r8-abstract-class");
    }

    public <T> t get(c5.a<T> aVar) {
        return get(aVar, true);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }

    public <T> t get(c5.a<T> aVar, boolean z2) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (this.instanceCreators.get(type) != null) {
            throw new ClassCastException();
        }
        if (this.instanceCreators.get(rawType) != null) {
            throw new ClassCastException();
        }
        t tVarNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (tVarNewSpecialCollectionConstructor != null) {
            return tVarNewSpecialCollectionConstructor;
        }
        v4.f0 filterResult = z.getFilterResult(this.reflectionFilters, rawType);
        t tVarNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (tVarNewDefaultConstructor != null) {
            return tVarNewDefaultConstructor;
        }
        t tVarNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (tVarNewDefaultImplementationConstructor != null) {
            return tVarNewDefaultImplementationConstructor;
        }
        String strT = t(rawType);
        if (strT != null) {
            return new e0.a(strT, 1);
        }
        if (!z2) {
            return new e0.a("Unable to create instance of " + rawType + "; Register an InstanceCreator or a TypeAdapter for this type.", 4);
        }
        if (filterResult == v4.f0.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new e0.a("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.", 5);
    }
}
