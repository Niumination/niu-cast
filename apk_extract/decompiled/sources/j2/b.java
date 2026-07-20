package j2;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d2.d f6040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2.b f6041c;

    public b(long j8, d2.d dVar, d2.b bVar) {
        this.f6039a = j8;
        this.f6040b = dVar;
        this.f6041c = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6039a == bVar.f6039a && this.f6040b.equals(bVar.f6040b) && this.f6041c.equals(bVar.f6041c);
    }

    public final int hashCode() {
        long j8 = this.f6039a;
        return this.f6041c.hashCode() ^ ((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f6040b.hashCode()) * 1000003);
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f6039a + ", transportContext=" + this.f6040b + ", event=" + this.f6041c + "}";
    }
}
