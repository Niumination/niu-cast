package a2;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f28a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f28a.equals(((b) obj).f28a);
    }

    public final int hashCode() {
        return this.f28a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return h0.a.n(new StringBuilder("Encoding{name=\""), this.f28a, "\"}");
    }
}
