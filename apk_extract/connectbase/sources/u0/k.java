package u0;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0.b f16129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.b f16130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.l f16131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16132e;

    public k(String str, t0.b bVar, t0.b bVar2, t0.l lVar, boolean z10) {
        this.f16128a = str;
        this.f16129b = bVar;
        this.f16130c = bVar2;
        this.f16131d = lVar;
        this.f16132e = z10;
    }

    @Override // u0.b
    @Nullable
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.q(jVar, aVar, this);
    }

    public t0.b b() {
        return this.f16129b;
    }

    public String c() {
        return this.f16128a;
    }

    public t0.b d() {
        return this.f16130c;
    }

    public t0.l e() {
        return this.f16131d;
    }

    public boolean f() {
        return this.f16132e;
    }
}
