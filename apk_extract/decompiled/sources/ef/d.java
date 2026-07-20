package ef;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qj.j f4909d = qj.j.encodeUtf8(":status");
    public static final qj.j e = qj.j.encodeUtf8(":method");
    public static final qj.j f = qj.j.encodeUtf8(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final qj.j f4910g = qj.j.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final qj.j f4911h = qj.j.encodeUtf8(":authority");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.j f4912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qj.j f4913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4914c;

    static {
        qj.j.encodeUtf8(":host");
        qj.j.encodeUtf8(":version");
    }

    public d(String str, String str2) {
        this(qj.j.encodeUtf8(str), qj.j.encodeUtf8(str2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4912a.equals(dVar.f4912a) && this.f4913b.equals(dVar.f4913b);
    }

    public final int hashCode() {
        return this.f4913b.hashCode() + ((this.f4912a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return o.d.l(this.f4912a.utf8(), ": ", this.f4913b.utf8());
    }

    public d(String str, qj.j jVar) {
        this(jVar, qj.j.encodeUtf8(str));
    }

    public d(qj.j jVar, qj.j jVar2) {
        this.f4912a = jVar;
        this.f4913b = jVar2;
        this.f4914c = jVar2.size() + jVar.size() + 32;
    }
}
