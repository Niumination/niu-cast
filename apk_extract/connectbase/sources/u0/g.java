package u0;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0.h f16104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.d f16105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16106d;

    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, t0.h hVar, t0.d dVar, boolean z10) {
        this.f16103a = aVar;
        this.f16104b = hVar;
        this.f16105c = dVar;
        this.f16106d = z10;
    }

    public a a() {
        return this.f16103a;
    }

    public t0.h b() {
        return this.f16104b;
    }

    public t0.d c() {
        return this.f16105c;
    }

    public boolean d() {
        return this.f16106d;
    }
}
