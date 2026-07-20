package zj;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f11707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f11708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f11709c;

    public u0(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                throw new IllegalArgumentException();
            }
        }
        for (Type type3 : typeArr) {
            Objects.requireNonNull(type3, "typeArgument == null");
            s.c(type3);
        }
        this.f11707a = type;
        this.f11708b = type2;
        this.f11709c = (Type[]) typeArr.clone();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && s.d(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f11709c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f11707a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f11708b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f11709c) ^ this.f11708b.hashCode();
        Type type = this.f11707a;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.f11709c;
        int length = typeArr.length;
        Type type = this.f11708b;
        if (length == 0) {
            return s.q(type);
        }
        StringBuilder sb2 = new StringBuilder((typeArr.length + 1) * 30);
        sb2.append(s.q(type));
        sb2.append("<");
        sb2.append(s.q(typeArr[0]));
        for (int i8 = 1; i8 < typeArr.length; i8++) {
            sb2.append(", ");
            sb2.append(s.q(typeArr[i8]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
