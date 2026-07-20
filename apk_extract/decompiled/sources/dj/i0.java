package dj;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f4561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f4562b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4564d;
    public q e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m0 f4565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f4566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j0 f4567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j0 f4568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f4571m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4563c = -1;
    public r f = new r(0);

    public static void b(j0 j0Var, String str) {
        if (j0Var != null) {
            if (j0Var.f4581i != null) {
                throw new IllegalArgumentException(str.concat(".body != null").toString());
            }
            if (j0Var.f4582j != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (j0Var.f4583k != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (j0Var.f4584l != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final j0 a() {
        int i8 = this.f4563c;
        if (!(i8 >= 0)) {
            throw new IllegalStateException(("code < 0: " + this.f4563c).toString());
        }
        e0 e0Var = this.f4561a;
        if (e0Var == null) {
            throw new IllegalStateException("request == null");
        }
        d0 d0Var = this.f4562b;
        if (d0Var == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.f4564d;
        if (str != null) {
            return new j0(e0Var, d0Var, str, i8, this.e, this.f.c(), this.f4565g, this.f4566h, this.f4567i, this.f4568j, this.f4569k, this.f4570l, this.f4571m);
        }
        throw new IllegalStateException("message == null");
    }
}
