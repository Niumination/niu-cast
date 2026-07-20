package bi;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class, q> f895d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Object> f892a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Object> f893b = new LinkedList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f894c = new s();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<s, q> f896e = new HashMap();

    public p() {
        HashMap map = new HashMap();
        this.f895d = map;
        map.put(Object.class, new ci.b());
        map.put(Collection.class, new ci.l());
        map.put(List.class, new ci.l());
        map.put(Set.class, new ci.o());
        map.put(Map.class, new ci.n());
        map.put(Integer.class, new ci.j());
        map.put(Integer.TYPE, new ci.j());
        map.put(Float.class, new ci.i());
        map.put(Float.TYPE, new ci.i());
        map.put(Double.class, new ci.g());
        map.put(Double.TYPE, new ci.g());
        map.put(Long.class, new ci.m());
        map.put(Long.TYPE, new ci.m());
        map.put(Byte.class, new ci.d());
        map.put(Byte.TYPE, new ci.d());
        map.put(Boolean.class, new ci.c());
        map.put(Boolean.TYPE, new ci.c());
        map.put(Character.class, new ci.e());
        map.put(Character.TYPE, new ci.e());
        map.put(Enum.class, new ci.h());
        map.put(String.class, new ci.p());
        map.put(Array.class, new ci.a());
        map.put(o.class, new ci.k());
    }

    public p a(s sVar, q qVar) {
        this.f896e.put(sVar, qVar);
        return this;
    }

    public p b(Class cls, q qVar) {
        this.f895d.put(cls, qVar);
        return this;
    }

    public final q c(Class cls) {
        q qVar = this.f895d.get(cls);
        if (qVar != null || cls == null) {
            return qVar;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            q qVarC = c(cls2);
            if (qVarC != null) {
                return qVarC;
            }
        }
        if (cls.getSuperclass() != null) {
            return c(cls.getSuperclass());
        }
        return null;
    }

    public s d() {
        return this.f894c;
    }

    public Class e(s sVar) throws ClassNotFoundException {
        q qVar = this.f896e.get(sVar);
        if (qVar instanceof ci.f) {
            return ((ci.f) qVar).b().a(this, sVar);
        }
        return null;
    }

    public Class f(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            return cls2.isAssignableFrom(cls) ? cls : cls2;
        }
        if (cls2 != null) {
            return cls2;
        }
        if (cls != null) {
            return cls;
        }
        return null;
    }

    public final Class g(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.class;
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable)) {
            return null;
        }
        throw new l(this.f894c + ":  Unknown type " + type);
    }

    public Class h(Map map, Class cls) {
        if (cls != null) {
            return cls;
        }
        String str = (String) map.get("class");
        if (str == null) {
            return null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new l(String.format("%s:  Could not load %s", this.f894c, str), e10);
        }
    }

    public Object i(Object obj) {
        return k(obj, null);
    }

    public Object j(Object obj, Class cls) {
        if (obj.getClass() == cls) {
            return obj;
        }
        if (obj instanceof Number) {
            if (cls.equals(Double.class)) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (cls.equals(Integer.class)) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (cls.equals(Long.class)) {
                return Long.valueOf(((Number) obj).longValue());
            }
            if (cls.equals(Short.class)) {
                return Short.valueOf(((Number) obj).shortValue());
            }
            if (cls.equals(Byte.class)) {
                return Byte.valueOf(((Number) obj).byteValue());
            }
            if (cls.equals(Float.class)) {
                return Float.valueOf(((Number) obj).floatValue());
            }
            if (cls == Date.class) {
                return new Date(((Number) obj).longValue());
            }
        } else if ((obj instanceof Boolean) && cls.equals(Boolean.class)) {
            return obj;
        }
        throw new l(String.format("%s: Don't know how to bind %s into class %s.  You might need to use an ObjectFactory instead of a plain class.", d().toString(), obj, cls.getName()));
    }

    public Object k(Object obj, Type type) {
        this.f893b.add(obj);
        if (obj == null) {
            this.f893b.removeLast();
            return null;
        }
        try {
            Class clsU = u(obj, g(type));
            q qVarS = s(clsU);
            if (qVarS != null) {
                Object objA = qVarS.a(this, obj, type, clsU);
                this.f893b.removeLast();
                return objA;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f894c);
            sb2.append(": + Could not find a suitable ObjectFactory for ");
            sb2.append(clsU);
            throw new l(sb2.toString());
        } catch (Throwable th2) {
            this.f893b.removeLast();
            throw th2;
        }
    }

    public Object l(Map map, Object obj, Type type) {
        try {
            this.f892a.add(obj);
            d dVarA = d.a(obj.getClass());
            for (e eVar : dVarA != null ? dVarA.c() : null) {
                if (q(map, eVar)) {
                    Object objT = t(map, eVar);
                    if (eVar.p().booleanValue()) {
                        this.f894c.a(eVar.e());
                        Method methodK = eVar.k();
                        if (methodK != null) {
                            Type[] genericParameterTypes = methodK.getGenericParameterTypes();
                            if (genericParameterTypes.length != 1) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.f894c);
                                sb2.append(":  Expected a single parameter for method ");
                                sb2.append(obj.getClass().getName());
                                sb2.append(".");
                                sb2.append(methodK.getName());
                                sb2.append(" but got ");
                                sb2.append(genericParameterTypes.length);
                                throw new l(sb2.toString());
                            }
                            methodK.invoke(this.f892a.getLast(), k(objT, o(genericParameterTypes[0], type)));
                        } else {
                            Field fieldG = eVar.g();
                            if (fieldG != null) {
                                fieldG.setAccessible(true);
                                fieldG.set(obj, k(objT, fieldG.getGenericType()));
                            }
                        }
                        this.f894c.d();
                    } else {
                        continue;
                    }
                }
            }
            return this.f892a.removeLast();
        } catch (IllegalAccessException e10) {
            throw new l(this.f894c + ":  Could not access the no-arg constructor for " + obj.getClass().getName(), e10);
        } catch (InvocationTargetException e11) {
            throw new l(this.f894c + ":  Exception while trying to invoke setter method.", e11);
        }
    }

    public Object m(Map map, Map<Object, Object> map2, Type type, Type type2) {
        this.f893b.add(map);
        this.f892a.add(map2);
        for (Object obj : map.keySet()) {
            this.f894c.a("keys");
            Object objK = k(obj, type);
            this.f894c.d();
            this.f894c.a("values");
            Object objK2 = k(map.get(obj), type2);
            this.f894c.d();
            map2.put(objK, objK2);
        }
        this.f892a.removeLast();
        this.f893b.removeLast();
        return map2;
    }

    public final String n(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public final Type o(Type type, Type type2) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            return type;
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return type2;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        throw new l(this.f894c + ":  Unknown generic type " + type + ".");
    }

    public <T extends Collection<Object>> T p(Collection collection, T t10, Type type) {
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        this.f893b.add(collection);
        this.f892a.add(t10);
        d().a("values");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t10.add(k(it.next(), type2));
        }
        d().d();
        this.f892a.removeLast();
        this.f893b.removeLast();
        return t10;
    }

    public final boolean q(Map map, e eVar) {
        return map.containsKey(eVar.b()) || map.containsKey(n(eVar.b()));
    }

    public l r(Object obj, Class cls) {
        return new l(String.format("%s:  Can not convert %s into %s", this.f894c, obj.getClass().getName(), cls.getName()));
    }

    public final q s(Class cls) {
        q qVar = this.f896e.get(this.f894c);
        if (qVar == null) {
            return (cls == null || !cls.isArray()) ? c(cls) : this.f895d.get(Array.class);
        }
        return qVar;
    }

    public final Object t(Map map, e eVar) {
        Object obj = map.get(eVar.b());
        return obj == null ? map.get(n(eVar.b())) : obj;
    }

    public final Class u(Object obj, Class cls) throws l {
        if (this.f896e.containsKey(this.f894c)) {
            return null;
        }
        Class clsF = f(obj instanceof Map ? h((Map) obj, null) : null, cls);
        return clsF == null ? obj.getClass() : clsF;
    }
}
