package y4;

import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements v4.q0 {
    private final x4.b constructorConstructor;

    public d(x4.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // v4.q0
    public <T> v4.p0 create(v4.q qVar, c5.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = x4.i.getCollectionElementType(type, rawType);
        return new c(new i0(qVar, qVar.getAdapter(c5.a.get(collectionElementType)), collectionElementType), this.constructorConstructor.get(aVar, false));
    }
}
