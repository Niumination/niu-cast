package ok;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8568b;

    public b(long j8, Object obj) {
        this.f8568b = obj;
        this.f8567a = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f8567a != bVar.f8567a) {
            return false;
        }
        Object obj2 = bVar.f8568b;
        Object obj3 = this.f8568b;
        if (obj3 == null) {
            if (obj2 != null) {
                return false;
            }
        } else if (!obj3.equals(obj2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j8 = this.f8567a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) + 31) * 31;
        Object obj = this.f8568b;
        return i8 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f8567a), this.f8568b.toString());
    }
}
