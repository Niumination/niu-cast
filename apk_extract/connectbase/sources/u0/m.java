package u0;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f16137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final t0.a f16139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final t0.d f16140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16141f;

    public m(String str, boolean z10, Path.FillType fillType, @Nullable t0.a aVar, @Nullable t0.d dVar, boolean z11) {
        this.f16138c = str;
        this.f16136a = z10;
        this.f16137b = fillType;
        this.f16139d = aVar;
        this.f16140e = dVar;
        this.f16141f = z11;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.g(jVar, aVar, this);
    }

    @Nullable
    public t0.a b() {
        return this.f16139d;
    }

    public Path.FillType c() {
        return this.f16137b;
    }

    public String d() {
        return this.f16138c;
    }

    @Nullable
    public t0.d e() {
        return this.f16140e;
    }

    public boolean f() {
        return this.f16141f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f16136a + rs.f.f14860b;
    }
}
