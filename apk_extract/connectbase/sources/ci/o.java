package ci;

import bi.q;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class o implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Collection) {
            return pVar.p((Collection) obj, new HashSet(), type);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(pVar.i(obj));
        return hashSet;
    }
}
