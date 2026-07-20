package u0;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0.m<PointF, PointF> f16073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.f f16074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16076e;

    public a(String str, t0.m<PointF, PointF> mVar, t0.f fVar, boolean z10, boolean z11) {
        this.f16072a = str;
        this.f16073b = mVar;
        this.f16074c = fVar;
        this.f16075d = z10;
        this.f16076e = z11;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.f(jVar, aVar, this);
    }

    public String b() {
        return this.f16072a;
    }

    public t0.m<PointF, PointF> c() {
        return this.f16073b;
    }

    public t0.f d() {
        return this.f16074c;
    }

    public boolean e() {
        return this.f16076e;
    }

    public boolean f() {
        return this.f16075d;
    }
}
