package s0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public T f14919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f14920b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t10, T t11) {
        this.f14919a = t10;
        this.f14920b = t11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.first, this.f14919a) && a(pair.second, this.f14920b);
    }

    public int hashCode() {
        T t10 = this.f14919a;
        int iHashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.f14920b;
        return iHashCode ^ (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f14919a) + " " + String.valueOf(this.f14920b) + "}";
    }
}
