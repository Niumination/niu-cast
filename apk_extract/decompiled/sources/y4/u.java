package y4;

import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements v4.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11070a;
    private final x4.b constructorConstructor;

    public u(x4.b bVar, boolean z2) {
        this.constructorConstructor = bVar;
        this.f11070a = z2;
    }

    private v4.p0 getKeyAdapter(v4.q qVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n1.BOOLEAN_AS_STRING : qVar.getAdapter(c5.a.get(type));
    }

    @Override // v4.q0
    public <T> v4.p0 create(v4.q qVar, c5.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] mapKeyAndValueTypes = x4.i.getMapKeyAndValueTypes(type, rawType);
        Type type2 = mapKeyAndValueTypes[0];
        Type type3 = mapKeyAndValueTypes[1];
        return new t(this, new i0(qVar, getKeyAdapter(qVar, type2), type2), new i0(qVar, qVar.getAdapter(c5.a.get(type3)), type3), this.constructorConstructor.get(aVar, false));
    }
}
