package a2;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f27b;

    public a(Object obj, c cVar) {
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f26a = (byte[]) obj;
        if (cVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f27b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        aVar.getClass();
        return this.f26a.equals(aVar.f26a) && this.f27b.equals(aVar.f27b);
    }

    public final int hashCode() {
        return this.f27b.hashCode() ^ (((1000003 * 1000003) ^ this.f26a.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f26a + ", priority=" + this.f27b + "}";
    }
}
