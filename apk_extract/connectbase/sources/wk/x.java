package wk;

import ik.b1;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final double f19665f = 1.0d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f19666g = 1.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final double f19667h = 0.9d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final double f19668i = 0.8d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double f19669j = 0.8d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final double f19670k = 0.8d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final double f19671l = 0.5d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final double f19672m = 0.2d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final double f19673n = 0.1d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final double f19674o = -1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f19682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final b1 f19683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f19664e = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final x f19675p = new x(false, 0.0d, null, 0, 12, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final x f19676q = new x(true, 0.2d, null, 0, 12, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public static final x f19677r = new x(true, 1.0d, null, 0, 12, null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public static final x f19678s = new x(true, -1.0d, null, 0, 12, null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final x f19679t = new x(true, 1.0d, null, 1, 4, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final x f19680u = new x(true, 0.5d, null, 1, 4, null);

    public static final class a {
        public a() {
        }

        @os.l
        public final x a() {
            return x.f19677r;
        }

        @os.l
        public final x b() {
            return x.f19679t;
        }

        @os.l
        public final x c() {
            return x.f19675p;
        }

        @os.l
        public final x d() {
            return x.f19676q;
        }

        @os.l
        public final x e() {
            return x.f19678s;
        }

        @os.l
        public final x f() {
            return x.f19680u;
        }

        public a(kn.w wVar) {
        }
    }

    public x(boolean z10, double d10, @os.l b1 b1Var, int i10) {
        kn.l0.p(b1Var, "parameters");
        this.f19681a = z10;
        this.f19682b = d10;
        this.f19683c = b1Var;
        this.f19684d = i10;
    }

    public static /* synthetic */ x l(x xVar, boolean z10, double d10, b1 b1Var, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = xVar.f19681a;
        }
        if ((i11 & 2) != 0) {
            d10 = xVar.f19682b;
        }
        double d11 = d10;
        if ((i11 & 4) != 0) {
            b1Var = xVar.f19683c;
        }
        b1 b1Var2 = b1Var;
        if ((i11 & 8) != 0) {
            i10 = xVar.f19684d;
        }
        return xVar.k(z10, d11, b1Var2, i10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f19681a == xVar.f19681a && kn.l0.g(Double.valueOf(this.f19682b), Double.valueOf(xVar.f19682b)) && kn.l0.g(this.f19683c, xVar.f19683c) && this.f19684d == xVar.f19684d;
    }

    public final boolean g() {
        return this.f19681a;
    }

    public final double h() {
        return this.f19682b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public int hashCode() {
        boolean z10 = this.f19681a;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return Integer.hashCode(this.f19684d) + ((this.f19683c.hashCode() + ((Double.hashCode(this.f19682b) + (r10 * 31)) * 31)) * 31);
    }

    @os.l
    public final b1 i() {
        return this.f19683c;
    }

    public final int j() {
        return this.f19684d;
    }

    @os.l
    public final x k(boolean z10, double d10, @os.l b1 b1Var, int i10) {
        kn.l0.p(b1Var, "parameters");
        return new x(z10, d10, b1Var, i10);
    }

    @os.l
    public final b1 m() {
        return this.f19683c;
    }

    public final double n() {
        return this.f19682b;
    }

    public final int o() {
        return this.f19684d;
    }

    public final boolean p() {
        return this.f19681a;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("RouteSelectorEvaluation(succeeded=");
        sb2.append(this.f19681a);
        sb2.append(", quality=");
        sb2.append(this.f19682b);
        sb2.append(", parameters=");
        sb2.append(this.f19683c);
        sb2.append(", segmentIncrement=");
        return u.a.a(sb2, this.f19684d, ')');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public x(boolean z10, double d10, b1 b1Var, int i10, int i11, kn.w wVar) {
        if ((i11 & 4) != 0) {
            b1.f7942c.getClass();
            b1Var = b1.a.f7944b;
        }
        this(z10, d10, b1Var, (i11 & 8) != 0 ? 0 : i10);
    }
}
