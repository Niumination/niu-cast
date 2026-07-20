package u0;

/* JADX INFO: loaded from: classes.dex */
public class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.h f16147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16148d;

    public o(String str, int i10, t0.h hVar, boolean z10) {
        this.f16145a = str;
        this.f16146b = i10;
        this.f16147c = hVar;
        this.f16148d = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.r(jVar, aVar, this);
    }

    public String b() {
        return this.f16145a;
    }

    public t0.h c() {
        return this.f16147c;
    }

    public boolean d() {
        return this.f16148d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ShapePath{name=");
        sb2.append(this.f16145a);
        sb2.append(", index=");
        return u.a.a(sb2, this.f16146b, rs.f.f14860b);
    }
}
