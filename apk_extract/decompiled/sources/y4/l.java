package y4;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements v4.q0 {
    private static final v4.q0 TREE_TYPE_CLASS_DUMMY_FACTORY = new k(0);
    private static final v4.q0 TREE_TYPE_FIELD_DUMMY_FACTORY = new k(0);
    private final ConcurrentMap<Class<?>, v4.q0> adapterFactoryMap = new ConcurrentHashMap();
    private final x4.b constructorConstructor;

    public l(x4.b bVar) {
        this.constructorConstructor = bVar;
    }

    private static Object createAdapter(x4.b bVar, Class<?> cls) {
        return bVar.get(c5.a.get((Class) cls), true).construct();
    }

    private static w4.b getAnnotation(Class<?> cls) {
        return (w4.b) cls.getAnnotation(w4.b.class);
    }

    private v4.q0 putFactoryAndGetCurrent(Class<?> cls, v4.q0 q0Var) {
        v4.q0 q0VarPutIfAbsent = this.adapterFactoryMap.putIfAbsent(cls, q0Var);
        return q0VarPutIfAbsent != null ? q0VarPutIfAbsent : q0Var;
    }

    public final v4.p0 a(x4.b bVar, v4.q qVar, c5.a aVar, w4.b bVar2, boolean z2) {
        v4.p0 p0VarCreate;
        Object objCreateAdapter = createAdapter(bVar, bVar2.value());
        boolean zNullSafe = bVar2.nullSafe();
        if (objCreateAdapter instanceof v4.p0) {
            p0VarCreate = (v4.p0) objCreateAdapter;
        } else {
            if (!(objCreateAdapter instanceof v4.q0)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objCreateAdapter.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            v4.q0 q0VarPutFactoryAndGetCurrent = (v4.q0) objCreateAdapter;
            if (z2) {
                q0VarPutFactoryAndGetCurrent = putFactoryAndGetCurrent(aVar.getRawType(), q0VarPutFactoryAndGetCurrent);
            }
            p0VarCreate = q0VarPutFactoryAndGetCurrent.create(qVar, aVar);
        }
        return (p0VarCreate == null || !zNullSafe) ? p0VarCreate : p0VarCreate.nullSafe();
    }

    @Override // v4.q0
    public <T> v4.p0 create(v4.q qVar, c5.a<T> aVar) {
        w4.b annotation = getAnnotation(aVar.getRawType());
        if (annotation == null) {
            return null;
        }
        return a(this.constructorConstructor, qVar, aVar, annotation, true);
    }

    public boolean isClassJsonAdapterFactory(c5.a<?> aVar, v4.q0 q0Var) {
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(q0Var);
        if (q0Var == TREE_TYPE_CLASS_DUMMY_FACTORY) {
            return true;
        }
        Class<? super Object> rawType = aVar.getRawType();
        v4.q0 q0Var2 = this.adapterFactoryMap.get(rawType);
        if (q0Var2 != null) {
            return q0Var2 == q0Var;
        }
        w4.b annotation = getAnnotation(rawType);
        if (annotation == null) {
            return false;
        }
        Class clsValue = annotation.value();
        return v4.q0.class.isAssignableFrom(clsValue) && putFactoryAndGetCurrent(rawType, (v4.q0) createAdapter(this.constructorConstructor, clsValue)) == q0Var;
    }
}
