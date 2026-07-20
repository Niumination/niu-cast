package x4;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public g(Type type, Class<?> cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && i.requiresOwnerType(cls)) {
            throw new IllegalArgumentException("Must specify owner type for " + cls);
        }
        this.ownerType = type == null ? null : i.canonicalize(type);
        this.rawType = i.canonicalize(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.typeArguments = typeArr2;
        int length = typeArr2.length;
        for (int i8 = 0; i8 < length; i8++) {
            Objects.requireNonNull(this.typeArguments[i8]);
            i.a(this.typeArguments[i8]);
            Type[] typeArr3 = this.typeArguments;
            typeArr3[i8] = i.canonicalize(typeArr3[i8]);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && i.equals(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
        Type type = this.ownerType;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public String toString() {
        int length = this.typeArguments.length;
        if (length == 0) {
            return i.typeToString(this.rawType);
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 30);
        sb2.append(i.typeToString(this.rawType));
        sb2.append("<");
        sb2.append(i.typeToString(this.typeArguments[0]));
        for (int i8 = 1; i8 < length; i8++) {
            sb2.append(", ");
            sb2.append(i.typeToString(this.typeArguments[i8]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
