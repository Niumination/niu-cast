package ci;

import bi.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bi.h f1454a;

    private Object c(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(null);
    }

    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        Class cls2 = null;
        try {
            try {
                Class clsA = this.f1454a.a(pVar, pVar.d());
                if (clsA == null) {
                    return null;
                }
                try {
                    if (Collection.class.isAssignableFrom(clsA)) {
                        return pVar.p((Collection) obj, (Collection) c(clsA), type);
                    }
                    if (!Map.class.isAssignableFrom(clsA)) {
                        return obj instanceof Map ? pVar.l((Map) obj, c(clsA), clsA) : pVar.j(obj, clsA);
                    }
                    if (!(type instanceof ParameterizedType)) {
                        return pVar.m((Map) obj, (Map) c(clsA), null, null);
                    }
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    return pVar.m((Map) obj, (Map) c(clsA), parameterizedType.getActualTypeArguments()[0], parameterizedType.getActualTypeArguments()[1]);
                } catch (IllegalAccessException e10) {
                    e = e10;
                    cls2 = clsA;
                    throw new bi.l(String.format("%s: Could not instantiate class %s", pVar.d(), cls2.getName()), e);
                } catch (InstantiationException e11) {
                    e = e11;
                    cls2 = clsA;
                    throw new bi.l(String.format("%s: Problem while instantiating class %s", pVar.d(), cls2.getName()), e);
                } catch (NoSuchMethodException e12) {
                    e = e12;
                    cls2 = clsA;
                    throw new bi.l(String.format("%s: Could not find a no-arg constructor for %s", pVar.d(), cls2.getName()), e);
                } catch (InvocationTargetException e13) {
                    e = e13;
                    cls2 = clsA;
                    throw new bi.l(String.format("%s: Problem while invoking the no-arg constructor for %s", pVar.d(), cls2.getName()), e);
                }
            } catch (ClassNotFoundException e14) {
                throw new bi.l(String.format("%s: Could not find class %s", pVar.d(), e14.getMessage()), e14);
            }
        } catch (IllegalAccessException e15) {
            e = e15;
        } catch (InstantiationException e16) {
            e = e16;
        } catch (NoSuchMethodException e17) {
            e = e17;
        } catch (InvocationTargetException e18) {
            e = e18;
        }
    }

    public bi.h b() {
        return this.f1454a;
    }
}
