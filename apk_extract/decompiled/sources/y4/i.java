package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements v4.q0 {
    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        Class rawType = aVar.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new j(rawType);
    }
}
