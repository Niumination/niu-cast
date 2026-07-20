package u0;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f16079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f16080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.c f16081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.d f16082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.f f16083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t0.f f16084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final t0.b f16086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final t0.b f16087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16088j;

    public d(String str, f fVar, Path.FillType fillType, t0.c cVar, t0.d dVar, t0.f fVar2, t0.f fVar3, t0.b bVar, t0.b bVar2, boolean z10) {
        this.f16079a = fVar;
        this.f16080b = fillType;
        this.f16081c = cVar;
        this.f16082d = dVar;
        this.f16083e = fVar2;
        this.f16084f = fVar3;
        this.f16085g = str;
        this.f16086h = bVar;
        this.f16087i = bVar2;
        this.f16088j = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.h(jVar, aVar, this);
    }

    public t0.f b() {
        return this.f16084f;
    }

    public Path.FillType c() {
        return this.f16080b;
    }

    public t0.c d() {
        return this.f16081c;
    }

    public f e() {
        return this.f16079a;
    }

    @Nullable
    public t0.b f() {
        return this.f16087i;
    }

    @Nullable
    public t0.b g() {
        return this.f16086h;
    }

    public String h() {
        return this.f16085g;
    }

    public t0.d i() {
        return this.f16082d;
    }

    public t0.f j() {
        return this.f16083e;
    }

    public boolean k() {
        return this.f16088j;
    }
}
