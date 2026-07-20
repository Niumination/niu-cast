package x4;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type lowerBound;
    private final Type upperBound;

    public h(Type[] typeArr, Type[] typeArr2) {
        e.checkArgument(typeArr2.length <= 1);
        e.checkArgument(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            i.a(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = i.canonicalize(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        i.a(typeArr2[0]);
        e.checkArgument(typeArr[0] == Object.class);
        this.lowerBound = i.canonicalize(typeArr2[0]);
        this.upperBound = Object.class;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && i.equals(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : i.f10844a;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public int hashCode() {
        Type type = this.lowerBound;
        return (this.upperBound.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public String toString() {
        if (this.lowerBound != null) {
            return "? super " + i.typeToString(this.lowerBound);
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        return "? extends " + i.typeToString(this.upperBound);
    }
}
