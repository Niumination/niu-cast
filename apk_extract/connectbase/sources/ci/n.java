package ci;

import bi.q;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class n implements q {
    @Override // bi.q
    public Object a(bi.p pVar, Object obj, Type type, Class cls) {
        if (type == null || !(type instanceof ParameterizedType)) {
            return pVar.m((Map) obj, b(), null, null);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        Map map = (Map) obj;
        HashMap<Object, Object> mapB = b();
        if (type2 == Object.class) {
            type2 = null;
        }
        return pVar.m(map, mapB, type2, type3 != Object.class ? type3 : null);
    }

    public HashMap<Object, Object> b() {
        return new HashMap<>();
    }
}
