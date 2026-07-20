package oh;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f8481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8482b;

    public c(String message, short s2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f8481a = s2;
        this.f8482b = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8481a == cVar.f8481a && Intrinsics.areEqual(this.f8482b, cVar.f8482b);
    }

    public final int hashCode() {
        return this.f8482b.hashCode() + (Short.hashCode(this.f8481a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CloseReason(reason=");
        b.Companion.getClass();
        Map map = b.byCodeMap;
        short s2 = this.f8481a;
        Object objValueOf = (b) map.get(Short.valueOf(s2));
        if (objValueOf == null) {
            objValueOf = Short.valueOf(s2);
        }
        sb2.append(objValueOf);
        sb2.append(", message=");
        return a1.a.s(sb2, this.f8482b, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(b code, String message) {
        this(message, code.getCode());
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
