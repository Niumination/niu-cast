package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class m implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        try {
            return Long.valueOf(Long.parseLong(obj.toString()));
        } catch (Exception unused) {
            throw pVar.r(obj, Long.class);
        }
    }
}
