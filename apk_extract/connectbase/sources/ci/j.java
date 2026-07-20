package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class j implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        try {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        } catch (Exception unused) {
            throw pVar.r(obj, Integer.class);
        }
    }
}
