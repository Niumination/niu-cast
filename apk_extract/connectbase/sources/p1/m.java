package p1;

import c1.h0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@d
public abstract class m<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        h0.u(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
