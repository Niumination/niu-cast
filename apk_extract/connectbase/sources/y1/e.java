package y1;

import v1.a0;
import v1.s;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class e implements a0 {
    private final x1.c constructorConstructor;

    public e(x1.c cVar) {
        this.constructorConstructor = cVar;
    }

    public z<?> a(x1.c cVar, v1.e eVar, c2.a<?> aVar, w1.b bVar) {
        z<?> mVar;
        Object objConstruct = cVar.get(c2.a.get((Class) bVar.value())).construct();
        boolean zNullSafe = bVar.nullSafe();
        if (objConstruct instanceof z) {
            mVar = (z) objConstruct;
        } else if (objConstruct instanceof a0) {
            mVar = ((a0) objConstruct).create(eVar, aVar);
        } else {
            boolean z10 = objConstruct instanceof s;
            if (!z10 && !(objConstruct instanceof v1.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m<>(z10 ? (s) objConstruct : null, objConstruct instanceof v1.j ? (v1.j) objConstruct : null, eVar, aVar, null, zNullSafe);
            zNullSafe = false;
        }
        return (mVar == null || !zNullSafe) ? mVar : mVar.nullSafe();
    }

    @Override // v1.a0
    public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
        w1.b bVar = (w1.b) aVar.getRawType().getAnnotation(w1.b.class);
        if (bVar == null) {
            return null;
        }
        return (z<T>) a(this.constructorConstructor, eVar, aVar, bVar);
    }
}
