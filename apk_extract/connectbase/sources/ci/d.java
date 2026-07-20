package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class d implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        throw pVar.r(obj, Byte.class);
    }
}
