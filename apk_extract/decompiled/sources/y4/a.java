package y4;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements v4.q0 {
    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        Type type = aVar.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type arrayComponentType = x4.i.getArrayComponentType(type);
        return new b(qVar, qVar.getAdapter(c5.a.get(arrayComponentType)), x4.i.getRawType(arrayComponentType));
    }
}
