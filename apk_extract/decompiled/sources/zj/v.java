package zj;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends dj.m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.x f11710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11711c;

    public v(dj.x xVar, long j8) {
        this.f11710b = xVar;
        this.f11711c = j8;
    }

    @Override // dj.m0
    public final long a() {
        return this.f11711c;
    }

    @Override // dj.m0
    public final dj.x c() {
        return this.f11710b;
    }

    @Override // dj.m0
    public final qj.h g() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
