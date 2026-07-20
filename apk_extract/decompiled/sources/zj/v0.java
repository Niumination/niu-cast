package zj;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements WildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f11712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f11713b;

    public v0(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            s.c(typeArr[0]);
            this.f11713b = null;
            this.f11712a = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        s.c(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.f11713b = typeArr2[0];
        this.f11712a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && s.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f11713b;
        return type != null ? new Type[]{type} : s.f11700a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f11712a};
    }

    public final int hashCode() {
        Type type = this.f11713b;
        return (this.f11712a.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.f11713b;
        if (type != null) {
            return "? super " + s.q(type);
        }
        Type type2 = this.f11712a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + s.q(type2);
    }
}
