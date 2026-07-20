package zj;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements GenericArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f11703a;

    public t0(Type type) {
        this.f11703a = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && s.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f11703a;
    }

    public final int hashCode() {
        return this.f11703a.hashCode();
    }

    public final String toString() {
        return s.q(this.f11703a) + "[]";
    }
}
