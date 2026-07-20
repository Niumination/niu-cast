package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class h implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof String) {
            return Enum.valueOf((Class) type, obj.toString());
        }
        throw new bi.l(String.format("%s:  Don't know how to convert %s to enumerated constant of %s", pVar.d(), obj, type));
    }
}
