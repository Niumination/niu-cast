package p1;

import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8646b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.f8645a;
        if (f != obj2 && (f == 0 || !f.equals(obj2))) {
            return false;
        }
        S s2 = pair.second;
        Object obj3 = this.f8646b;
        return s2 == obj3 || (s2 != 0 && s2.equals(obj3));
    }

    public final int hashCode() {
        String str = this.f8645a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f8646b;
        return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + ((Object) this.f8645a) + " " + ((Object) this.f8646b) + "}";
    }
}
