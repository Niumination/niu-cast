package ci;

import bi.q;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class k implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        bi.o oVar = (bi.o) obj;
        return oVar.a() ? Long.valueOf(oVar.longValue()) : Double.valueOf(oVar.doubleValue());
    }
}
