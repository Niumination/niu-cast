package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class g implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        try {
            return Double.valueOf(Double.parseDouble(obj.toString()));
        } catch (Exception unused) {
            throw pVar.r(obj, Double.class);
        }
    }
}
