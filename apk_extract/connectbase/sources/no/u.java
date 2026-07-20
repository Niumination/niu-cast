package no;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f11780d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final u f11781e = new u(e0.STRICT, null, null, 6, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e0 f11782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final lm.a0 f11783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final e0 f11784c;

    public static final class a {
        public a() {
        }

        @os.l
        public final u a() {
            return u.f11781e;
        }

        public a(kn.w wVar) {
        }
    }

    public u(@os.l e0 e0Var, @os.m lm.a0 a0Var, @os.l e0 e0Var2) {
        l0.p(e0Var, "reportLevelBefore");
        l0.p(e0Var2, "reportLevelAfter");
        this.f11782a = e0Var;
        this.f11783b = a0Var;
        this.f11784c = e0Var2;
    }

    @os.l
    public final e0 b() {
        return this.f11784c;
    }

    @os.l
    public final e0 c() {
        return this.f11782a;
    }

    @os.m
    public final lm.a0 d() {
        return this.f11783b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f11782a == uVar.f11782a && l0.g(this.f11783b, uVar.f11783b) && this.f11784c == uVar.f11784c;
    }

    public int hashCode() {
        int iHashCode = this.f11782a.hashCode() * 31;
        lm.a0 a0Var = this.f11783b;
        return this.f11784c.hashCode() + ((iHashCode + (a0Var == null ? 0 : a0Var.f10171d)) * 31);
    }

    @os.l
    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f11782a + ", sinceVersion=" + this.f11783b + ", reportLevelAfter=" + this.f11784c + ')';
    }

    public u(e0 e0Var, lm.a0 a0Var, e0 e0Var2, int i10, kn.w wVar) {
        this(e0Var, (i10 & 2) != 0 ? new lm.a0(1, 0, 0) : a0Var, (i10 & 4) != 0 ? e0Var : e0Var2);
    }
}
