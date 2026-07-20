package un;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
@lm.r
public final class a implements GenericArrayType, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Type f16337a;

    public a(@os.l Type type) {
        l0.p(type, "elementType");
        this.f16337a = type;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof GenericArrayType) && l0.g(this.f16337a, ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @os.l
    public Type getGenericComponentType() {
        return this.f16337a;
    }

    @Override // java.lang.reflect.Type, un.y
    @os.l
    public String getTypeName() {
        return b0.j(this.f16337a) + "[]";
    }

    public int hashCode() {
        return this.f16337a.hashCode();
    }

    @os.l
    public String toString() {
        return getTypeName();
    }
}
