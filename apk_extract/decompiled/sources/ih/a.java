package ih;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f5872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KType f5873b;

    public a(KClass type, KType kType) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f5872a = type;
        this.f5873b = kType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        KType kType = this.f5873b;
        if (kType == null) {
            a aVar = (a) obj;
            if (aVar.f5873b == null) {
                return Intrinsics.areEqual(this.f5872a, aVar.f5872a);
            }
        }
        return Intrinsics.areEqual(kType, ((a) obj).f5873b);
    }

    public final int hashCode() {
        KType kType = this.f5873b;
        return kType != null ? kType.hashCode() : this.f5872a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TypeInfo(");
        Object obj = this.f5873b;
        if (obj == null) {
            obj = this.f5872a;
        }
        sb2.append(obj);
        sb2.append(')');
        return sb2.toString();
    }
}
