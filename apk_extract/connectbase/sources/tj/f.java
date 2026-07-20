package tj;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static <T> T a(sj.a aVar, Class<T> cls) {
        if (((c1) aVar).root().resolveStatus() != y0.RESOLVED) {
            throw new sj.c.h("need to Config#resolve() a config before using it to initialize a bean, see the API docs for Config#resolve()");
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (Map.Entry<String, sj.x> entry : aVar.root().entrySet()) {
            String key = entry.getKey();
            String strM = n.m(key);
            if (!map2.containsKey(strM) || key.equals(strM)) {
                map.put(strM, (d) entry.getValue());
                map2.put(strM, key);
            }
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(cls);
            try {
                ArrayList<PropertyDescriptor> arrayList = new ArrayList();
                for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                    if (propertyDescriptor.getReadMethod() != null && propertyDescriptor.getWriteMethod() != null) {
                        arrayList.add(propertyDescriptor);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (PropertyDescriptor propertyDescriptor2 : arrayList) {
                    sj.z zVarF = f(propertyDescriptor2.getWriteMethod().getParameterTypes()[0]);
                    if (zVarF != null) {
                        String name = (String) map2.get(propertyDescriptor2.getName());
                        if (name == null) {
                            name = propertyDescriptor2.getName();
                        }
                        p0 p0VarF = p0.f(name);
                        d dVar = (d) map.get(propertyDescriptor2.getName());
                        if (dVar != null) {
                            c1.checkValid(p0VarF, zVarF, dVar, arrayList2);
                        } else if (!h(cls, propertyDescriptor2)) {
                            c1.addMissing(arrayList2, zVarF, p0VarF, aVar.origin());
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    throw new sj.c.l(arrayList2);
                }
                T tNewInstance = cls.newInstance();
                for (PropertyDescriptor propertyDescriptor3 : arrayList) {
                    Method writeMethod = propertyDescriptor3.getWriteMethod();
                    Type type = writeMethod.getGenericParameterTypes()[0];
                    Class<?> cls2 = writeMethod.getParameterTypes()[0];
                    String str = (String) map2.get(propertyDescriptor3.getName());
                    if (str != null) {
                        writeMethod.invoke(tNewInstance, e(cls, type, cls2, aVar, str));
                    } else if (!h(cls, propertyDescriptor3)) {
                        throw new sj.c.g(propertyDescriptor3.getName());
                    }
                }
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new sj.c.a(cls.getName().concat(" getters and setters are not accessible, they must be for use as a bean"), e10);
            } catch (InstantiationException e11) {
                throw new sj.c.a(cls.getName().concat(" needs a public no-args constructor to be used as a bean"), e11);
            } catch (InvocationTargetException e12) {
                throw new sj.c.a("Calling bean method on " + cls.getName() + " caused an exception", e12);
            }
        } catch (IntrospectionException e13) {
            throw new sj.c.a("Could not get bean information for class ".concat(cls.getName()), e13);
        }
    }

    public static Field b(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return b(superclass, str);
        }
    }

    public static Object c(Class<?> cls, Type type, Class<?> cls2, sj.a aVar, String str) {
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 == Boolean.class) {
            return aVar.getBooleanList(str);
        }
        if (type2 == Integer.class) {
            return aVar.getIntList(str);
        }
        if (type2 == Double.class) {
            return aVar.getDoubleList(str);
        }
        if (type2 == Long.class) {
            return aVar.getLongList(str);
        }
        if (type2 == String.class) {
            return aVar.getStringList(str);
        }
        if (type2 == Duration.class) {
            return aVar.getDurationList(str);
        }
        if (type2 == sj.l.class) {
            return aVar.getMemorySizeList(str);
        }
        if (type2 == Object.class) {
            return aVar.getAnyRefList(str);
        }
        if (type2 == sj.a.class) {
            return aVar.getConfigList(str);
        }
        if (type2 == sj.n.class) {
            return aVar.getObjectList(str);
        }
        if (type2 == sj.x.class) {
            return aVar.getList(str);
        }
        Class cls3 = (Class) type2;
        if (cls3.isEnum()) {
            return aVar.getEnumList(cls3, str);
        }
        if (g(cls3)) {
            ArrayList arrayList = new ArrayList();
            Iterator<? extends sj.a> it = aVar.getConfigList(str).iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next(), cls3));
            }
            return arrayList;
        }
        StringBuilder sbA = e.a.a("Bean property '", str, "' of class ");
        sbA.append(cls.getName());
        sbA.append(" has unsupported list element type ");
        sbA.append(type2);
        throw new sj.c.a(sbA.toString());
    }

    public static Object d(Class<?> cls, Type type, Class<?> cls2, sj.a aVar, String str) {
        return new HashSet((List) c(cls, type, cls2, aVar, str));
    }

    public static Object e(Class<?> cls, Type type, Class<?> cls2, sj.a aVar, String str) {
        if (cls2 == Boolean.class || cls2 == Boolean.TYPE) {
            return Boolean.valueOf(aVar.getBoolean(str));
        }
        if (cls2 == Integer.class || cls2 == Integer.TYPE) {
            return Integer.valueOf(aVar.getInt(str));
        }
        if (cls2 == Double.class || cls2 == Double.TYPE) {
            return Double.valueOf(aVar.getDouble(str));
        }
        if (cls2 == Long.class || cls2 == Long.TYPE) {
            return Long.valueOf(aVar.getLong(str));
        }
        if (cls2 == String.class) {
            return aVar.getString(str);
        }
        if (cls2 == Duration.class) {
            return aVar.getDuration(str);
        }
        if (cls2 == sj.l.class) {
            return aVar.getMemorySize(str);
        }
        if (cls2 == Object.class) {
            return aVar.getAnyRef(str);
        }
        if (cls2 == List.class) {
            return c(cls, type, cls2, aVar, str);
        }
        if (cls2 == Set.class) {
            return d(cls, type, cls2, aVar, str);
        }
        if (cls2 == Map.class) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments[0] == String.class && actualTypeArguments[1] == Object.class) {
                return aVar.getObject(str).unwrapped();
            }
            StringBuilder sbA = e.a.a("Bean property '", str, "' of class ");
            sbA.append(cls.getName());
            sbA.append(" has unsupported Map<");
            sbA.append(actualTypeArguments[0]);
            sbA.append(ks.g.f9491d);
            sbA.append(actualTypeArguments[1]);
            sbA.append(">, only Map<String,Object> is supported right now");
            throw new sj.c.a(sbA.toString());
        }
        if (cls2 == sj.a.class) {
            return aVar.getConfig(str);
        }
        if (cls2 == sj.n.class) {
            return aVar.getObject(str);
        }
        if (cls2 == sj.x.class) {
            return aVar.getValue(str);
        }
        if (cls2 == sj.j.class) {
            return aVar.getList(str);
        }
        if (cls2.isEnum()) {
            return aVar.getEnum(cls2, str);
        }
        if (g(cls2)) {
            return a(aVar.getConfig(str), cls2);
        }
        StringBuilder sbA2 = e.a.a("Bean property ", str, " of class ");
        sbA2.append(cls.getName());
        sbA2.append(" has unsupported type ");
        sbA2.append(type);
        throw new sj.c.a(sbA2.toString());
    }

    public static sj.z f(Class<?> cls) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return sj.z.BOOLEAN;
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return sj.z.NUMBER;
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return sj.z.NUMBER;
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return sj.z.NUMBER;
        }
        if (cls == String.class) {
            return sj.z.STRING;
        }
        if (cls == Duration.class || cls == sj.l.class) {
            return null;
        }
        if (cls == List.class) {
            return sj.z.LIST;
        }
        if (cls != Map.class && cls != sj.a.class && cls != sj.n.class) {
            if (cls == sj.j.class) {
                return sj.z.LIST;
            }
            return null;
        }
        return sj.z.OBJECT;
    }

    public static boolean g(Class<?> cls) {
        try {
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                if (propertyDescriptor.getReadMethod() != null && propertyDescriptor.getWriteMethod() != null) {
                    return true;
                }
            }
        } catch (IntrospectionException unused) {
        }
        return false;
    }

    public static boolean h(Class cls, PropertyDescriptor propertyDescriptor) {
        Field fieldB = b(cls, propertyDescriptor.getName());
        if (fieldB != null) {
            if (((sj.c0[]) fieldB.getAnnotationsByType(sj.c0.class)).length <= 0) {
                return false;
            }
        } else if (((sj.c0[]) propertyDescriptor.getReadMethod().getAnnotationsByType(sj.c0.class)).length <= 0) {
            return false;
        }
        return true;
    }
}
