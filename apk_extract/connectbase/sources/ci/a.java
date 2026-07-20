package ci;

import bi.q;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        List list = (List) obj;
        pVar.d().a("values");
        try {
            try {
                Class<?> componentType = cls.getComponentType() != null ? cls.getComponentType() : pVar.e(pVar.d());
                if (componentType == null) {
                    throw new bi.l("Missing concrete class for array.  You might require a use() method.");
                }
                Object objNewInstance = Array.newInstance(componentType, list.size());
                for (int i10 = 0; i10 < list.size(); i10++) {
                    Array.set(objNewInstance, i10, pVar.k(list.get(i10), componentType));
                }
                pVar.d().d();
                return objNewInstance;
            } catch (ClassNotFoundException e10) {
                throw new bi.l(String.format("%s: Could not find class %s", pVar.d(), e10.getMessage()), e10);
            }
        } catch (Throwable th2) {
            pVar.d().d();
            throw th2;
        }
    }
}
