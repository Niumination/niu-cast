package x4;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type componentType;

    public f(Type type) {
        Objects.requireNonNull(type);
        this.componentType = i.canonicalize(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && i.equals(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return i.typeToString(this.componentType) + "[]";
    }
}
