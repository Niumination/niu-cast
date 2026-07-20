package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class i implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        try {
            return Float.valueOf(Float.parseFloat(obj.toString()));
        } catch (Exception unused) {
            throw pVar.r(obj, Float.class);
        }
    }
}
