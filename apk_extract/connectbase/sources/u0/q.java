package u0;

import p0.t;

/* JADX INFO: loaded from: classes.dex */
public class q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.b f16165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.b f16166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.b f16167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16168f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException(h.a.a("Unknown trim path type ", i10));
        }
    }

    public q(String str, a aVar, t0.b bVar, t0.b bVar2, t0.b bVar3, boolean z10) {
        this.f16163a = str;
        this.f16164b = aVar;
        this.f16165c = bVar;
        this.f16166d = bVar2;
        this.f16167e = bVar3;
        this.f16168f = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new t(aVar, this);
    }

    public t0.b b() {
        return this.f16166d;
    }

    public String c() {
        return this.f16163a;
    }

    public t0.b d() {
        return this.f16167e;
    }

    public t0.b e() {
        return this.f16165c;
    }

    public a f() {
        return this.f16164b;
    }

    public boolean g() {
        return this.f16168f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f16165c + ", end: " + this.f16166d + ", offset: " + this.f16167e + "}";
    }
}
