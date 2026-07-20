package ci;

import bi.q;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class l implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Collection) {
            return pVar.p((Collection) obj, new ArrayList(), type);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(pVar.i(obj));
        return arrayList;
    }
}
