package ci;

import bi.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        try {
            return pVar.l((Map) obj, b(cls), type);
        } catch (IllegalAccessException e10) {
            throw new bi.l(pVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e10);
        } catch (InstantiationException e11) {
            throw new bi.l(pVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e11);
        } catch (NoSuchMethodException e12) {
            throw new bi.l(pVar.d() + ": " + cls.getName() + " lacks a no argument constructor.  com.zero.json will instantiate any protected, private, or public no-arg constructor.", e12);
        } catch (InvocationTargetException e13) {
            throw new bi.l(pVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e13);
        }
    }

    public Object b(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(null);
    }
}
