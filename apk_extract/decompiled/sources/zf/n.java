package zf;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f11523c;

    public n(String value, List params) {
        Double d7;
        Object next;
        String str;
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f11521a = value;
        this.f11522b = params;
        Iterator it = params.iterator();
        do {
            d7 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((o) next).f11528a, "q"));
        o oVar = (o) next;
        double dDoubleValue = 1.0d;
        if (oVar != null && (str = oVar.f11529b) != null && (doubleOrNull = StringsKt.toDoubleOrNull(str)) != null) {
            double dDoubleValue2 = doubleOrNull.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                d7 = doubleOrNull;
            }
            if (d7 != null) {
                dDoubleValue = d7.doubleValue();
            }
        }
        this.f11523c = dDoubleValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual(this.f11521a, nVar.f11521a) && Intrinsics.areEqual(this.f11522b, nVar.f11522b);
    }

    public final int hashCode() {
        return this.f11522b.hashCode() + (this.f11521a.hashCode() * 31);
    }

    public final String toString() {
        return "HeaderValue(value=" + this.f11521a + ", params=" + this.f11522b + ')';
    }
}
