package x1;

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
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import v1.w;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final Map<Type, v1.g<?>> instanceCreators;
    private final List<w> reflectionFilters;
    private final boolean useJdkUnsafe;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: x1.c$c, reason: collision with other inner class name */
    public class C0496c<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> implements x1.k<T> {
        @Override // x1.k
        public T construct() {
            return (T) new x1.i();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f19944a;

        public j(Class cls) {
            this.f19944a = cls;
        }

        @Override // x1.k
        public T construct() {
            try {
                return (T) x1.p.INSTANCE.newInstance(this.f19944a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f19944a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class k<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v1.g f19946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f19947b;

        public k(v1.g gVar, Type type) {
            this.f19946a = gVar;
            this.f19947b = type;
        }

        @Override // x1.k
        public T construct() {
            return (T) this.f19946a.createInstance(this.f19947b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class l<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19949a;

        public l(String str) {
            this.f19949a = str;
        }

        @Override // x1.k
        public T construct() {
            throw new v1.l(this.f19949a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class m<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v1.g f19951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f19952b;

        public m(v1.g gVar, Type type) {
            this.f19951a = gVar;
            this.f19952b = type;
        }

        @Override // x1.k
        public T construct() {
            return (T) this.f19951a.createInstance(this.f19952b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class n<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19954a;

        public n(String str) {
            this.f19954a = str;
        }

        @Override // x1.k
        public T construct() {
            throw new v1.l(this.f19954a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class o<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19956a;

        public o(String str) {
            this.f19956a = str;
        }

        @Override // x1.k
        public T construct() {
            throw new v1.l(this.f19956a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class p<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f19958a;

        public p(Type type) {
            this.f19958a = type;
        }

        @Override // x1.k
        public T construct() {
            Type type = this.f19958a;
            if (!(type instanceof ParameterizedType)) {
                throw new v1.l("Invalid EnumSet type: " + this.f19958a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new v1.l("Invalid EnumSet type: " + this.f19958a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class q<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f19959a;

        public q(Type type) {
            this.f19959a = type;
        }

        @Override // x1.k
        public T construct() {
            Type type = this.f19959a;
            if (!(type instanceof ParameterizedType)) {
                throw new v1.l("Invalid EnumMap type: " + this.f19959a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new v1.l("Invalid EnumMap type: " + this.f19959a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class r<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19960a;

        public r(String str) {
            this.f19960a = str;
        }

        @Override // x1.k
        public T construct() {
            throw new v1.l(this.f19960a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class s<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19961a;

        public s(String str) {
            this.f19961a = str;
        }

        @Override // x1.k
        public T construct() {
            throw new v1.l(this.f19961a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class t<T> implements x1.k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Constructor f19962a;

        public t(Constructor constructor) {
            this.f19962a = constructor;
        }

        @Override // x1.k
        public T construct() {
            try {
                return (T) this.f19962a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw a2.a.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + a2.a.constructorToString(this.f19962a) + "' with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + a2.a.constructorToString(this.f19962a) + "' with no args", e12.getCause());
            }
        }
    }

    public c(Map<Type, v1.g<?>> map, boolean z10, List<w> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z10;
        this.reflectionFilters = list;
    }

    public static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    private static <T> x1.k<T> newDefaultConstructor(Class<? super T> cls, w.e eVar) {
        String strTryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            w.e eVar2 = w.e.ALLOW;
            if (eVar == eVar2 || (x1.n.canAccess(declaredConstructor, null) && (eVar != w.e.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (eVar != eVar2 || (strTryMakeAccessible = a2.a.tryMakeAccessible(declaredConstructor)) == null) ? new t(declaredConstructor) : new s(strTryMakeAccessible);
            }
            return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> x1.k<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new C0496c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(c2.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new i() : new h();
    }

    private static <T> x1.k<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> x1.k<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> x1.k<T> get(c2.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        v1.g<?> gVar = this.instanceCreators.get(type);
        if (gVar != null) {
            return new k(gVar, type);
        }
        v1.g<?> gVar2 = this.instanceCreators.get(rawType);
        if (gVar2 != null) {
            return new m(gVar2, type);
        }
        x1.k<T> kVarNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (kVarNewSpecialCollectionConstructor != null) {
            return kVarNewSpecialCollectionConstructor;
        }
        w.e filterResult = x1.n.getFilterResult(this.reflectionFilters, rawType);
        x1.k<T> kVarNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (kVarNewDefaultConstructor != null) {
            return kVarNewDefaultConstructor;
        }
        x1.k<T> kVarNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (kVarNewDefaultImplementationConstructor != null) {
            return kVarNewDefaultImplementationConstructor;
        }
        String strA = a(rawType);
        if (strA != null) {
            return new n(strA);
        }
        if (filterResult == w.e.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
