package e2;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4661b;

    public a(c cVar, long j8) {
        if (cVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f4660a = cVar;
        this.f4661b = j8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4660a.equals(aVar.f4660a) && this.f4661b == aVar.f4661b;
    }

    public final int hashCode() {
        int iHashCode = (this.f4660a.hashCode() ^ 1000003) * 1000003;
        long j8 = this.f4661b;
        return ((int) ((j8 >>> 32) ^ j8)) ^ iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackendResponse{status=");
        sb2.append(this.f4660a);
        sb2.append(", nextRequestWaitMillis=");
        return o.d.p(sb2, this.f4661b, "}");
    }
}
