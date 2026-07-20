package u0;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0.m<PointF, PointF> f16124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.m<PointF, PointF> f16125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.b f16126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16127e;

    public j(String str, t0.m<PointF, PointF> mVar, t0.m<PointF, PointF> mVar2, t0.b bVar, boolean z10) {
        this.f16123a = str;
        this.f16124b = mVar;
        this.f16125c = mVar2;
        this.f16126d = bVar;
        this.f16127e = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.p(jVar, aVar, this);
    }

    public t0.b b() {
        return this.f16126d;
    }

    public String c() {
        return this.f16123a;
    }

    public t0.m<PointF, PointF> d() {
        return this.f16124b;
    }

    public t0.m<PointF, PointF> e() {
        return this.f16125c;
    }

    public boolean f() {
        return this.f16127e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f16124b + ", size=" + this.f16125c + rs.f.f14860b;
    }
}
