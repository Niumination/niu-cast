package oc;

import af.r5;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import nc.c;
import nc.e;
import nc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8441a;

    public final Object a(r5 r5Var, Object obj, Type type, Class cls) {
        Class<?> componentType;
        switch (this.f8441a) {
            case 0:
                List list = (List) obj;
                f fVar = (f) r5Var.f559d;
                fVar.f8167a.add("values");
                try {
                    try {
                        if (cls.getComponentType() != null) {
                            componentType = cls.getComponentType();
                        } else {
                            componentType = null;
                        }
                        if (componentType == null) {
                            throw new c("Missing concrete class for array.  You might require a use() method.");
                        }
                        Object objNewInstance = Array.newInstance(componentType, list.size());
                        for (int i8 = 0; i8 < list.size(); i8++) {
                            Array.set(objNewInstance, i8, r5Var.b(list.get(i8), componentType));
                        }
                        fVar.a();
                        return objNewInstance;
                    } catch (Throwable th2) {
                        fVar.a();
                        throw th2;
                    }
                } catch (ClassNotFoundException e) {
                    throw new c(fVar + ": Could not find class " + e.getMessage(), e);
                }
            case 1:
                try {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    return r5Var.c((Map) obj, declaredConstructor.newInstance(null), type);
                } catch (IllegalAccessException e4) {
                    throw new c(((f) r5Var.f559d) + ":There was an exception trying to instantiate an instance of " + cls.getName(), e4);
                } catch (InstantiationException e10) {
                    throw new c(((f) r5Var.f559d) + ":There was an exception trying to instantiate an instance of " + cls.getName(), e10);
                } catch (NoSuchMethodException e11) {
                    throw new c(((f) r5Var.f559d) + ": " + cls.getName() + " lacks a no argument constructor.  com.zero.json will instantiate any protected, private, or public no-arg constructor.", e11);
                } catch (InvocationTargetException e12) {
                    throw new c(((f) r5Var.f559d) + ":There was an exception trying to instantiate an instance of " + cls.getName(), e12);
                }
            case 2:
                return obj;
            case 3:
                if (obj instanceof Number) {
                    return Byte.valueOf(((Number) obj).byteValue());
                }
                throw r5Var.k(Byte.class, obj);
            case 4:
                return Character.valueOf(obj.toString().charAt(0));
            case 5:
                if (obj instanceof Number) {
                    return Double.valueOf(((Number) obj).doubleValue());
                }
                try {
                    return Double.valueOf(Double.parseDouble(obj.toString()));
                } catch (Exception unused) {
                    throw r5Var.k(Double.class, obj);
                }
            case 6:
                if (obj instanceof String) {
                    return Enum.valueOf((Class) type, obj.toString());
                }
                throw new c(String.format("%s:  Don't know how to convert %s to enumerated constant of %s", (f) r5Var.f559d, obj, type));
            case 7:
                if (obj instanceof Number) {
                    return Float.valueOf(((Number) obj).floatValue());
                }
                try {
                    return Float.valueOf(Float.parseFloat(obj.toString()));
                } catch (Exception unused2) {
                    throw r5Var.k(Float.class, obj);
                }
            case 8:
                if (obj instanceof Number) {
                    return Integer.valueOf(((Number) obj).intValue());
                }
                try {
                    return Integer.valueOf(Integer.parseInt(obj.toString()));
                } catch (Exception unused3) {
                    throw r5Var.k(Integer.class, obj);
                }
            case 9:
                e eVar = (e) obj;
                return eVar.a() ? Long.valueOf(eVar.longValue()) : Double.valueOf(eVar.doubleValue());
            case 10:
                if (obj instanceof Collection) {
                    ArrayList arrayList = new ArrayList();
                    r5Var.f((Collection) obj, arrayList, type);
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(r5Var.b(obj, null));
                return arrayList2;
            case 11:
                if (obj instanceof Number) {
                    return Long.valueOf(((Number) obj).longValue());
                }
                try {
                    return Long.valueOf(Long.parseLong(obj.toString()));
                } catch (Exception unused4) {
                    throw r5Var.k(Long.class, obj);
                }
            case 12:
                if (type == null || !(type instanceof ParameterizedType)) {
                    HashMap map = new HashMap();
                    r5Var.g((Map) obj, map, null, null);
                    return map;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                Map map2 = (Map) obj;
                HashMap map3 = new HashMap();
                if (type2 == Object.class) {
                    type2 = null;
                }
                r5Var.g(map2, map3, type2, type3 != Object.class ? type3 : null);
                return map3;
            case 13:
                if (obj instanceof Collection) {
                    HashSet hashSet = new HashSet();
                    r5Var.f((Collection) obj, hashSet, type);
                    return hashSet;
                }
                HashSet hashSet2 = new HashSet();
                hashSet2.add(r5Var.b(obj, null));
                return hashSet2;
            default:
                return obj;
        }
    }
}
