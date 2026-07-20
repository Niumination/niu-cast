package u0;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f16090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.c f16091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.d f16092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.f f16093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t0.f f16094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t0.b f16095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p.b f16096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p.c f16097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f16098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<t0.b> f16099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final t0.b f16100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f16101m;

    public e(String str, f fVar, t0.c cVar, t0.d dVar, t0.f fVar2, t0.f fVar3, t0.b bVar, p.b bVar2, p.c cVar2, float f10, List<t0.b> list, @Nullable t0.b bVar3, boolean z10) {
        this.f16089a = str;
        this.f16090b = fVar;
        this.f16091c = cVar;
        this.f16092d = dVar;
        this.f16093e = fVar2;
        this.f16094f = fVar3;
        this.f16095g = bVar;
        this.f16096h = bVar2;
        this.f16097i = cVar2;
        this.f16098j = f10;
        this.f16099k = list;
        this.f16100l = bVar3;
        this.f16101m = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.i(jVar, aVar, this);
    }

    public p.b b() {
        return this.f16096h;
    }

    @Nullable
    public t0.b c() {
        return this.f16100l;
    }

    public t0.f d() {
        return this.f16094f;
    }

    public t0.c e() {
        return this.f16091c;
    }

    public f f() {
        return this.f16090b;
    }

    public p.c g() {
        return this.f16097i;
    }

    public List<t0.b> h() {
        return this.f16099k;
    }

    public float i() {
        return this.f16098j;
    }

    public String j() {
        return this.f16089a;
    }

    public t0.d k() {
        return this.f16092d;
    }

    public t0.f l() {
        return this.f16093e;
    }

    public t0.b m() {
        return this.f16095g;
    }

    public boolean n() {
        return this.f16101m;
    }
}
