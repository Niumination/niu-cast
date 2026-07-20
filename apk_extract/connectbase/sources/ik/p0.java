package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f8135b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final p0 f8136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final p0 f8137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final p0 f8138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final p0 f8139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final p0 f8140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final p0 f8141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final p0 f8142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final List<p0> f8143j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8144a;

    public static final class a {
        public a() {
        }

        @os.l
        public final List<p0> a() {
            return p0.f8143j;
        }

        @os.l
        public final p0 b() {
            return p0.f8140g;
        }

        @os.l
        public final p0 c() {
            return p0.f8136c;
        }

        @os.l
        public final p0 d() {
            return p0.f8141h;
        }

        @os.l
        public final p0 e() {
            return p0.f8142i;
        }

        @os.l
        public final p0 f() {
            return p0.f8139f;
        }

        @os.l
        public final p0 g() {
            return p0.f8137d;
        }

        @os.l
        public final p0 h() {
            return p0.f8138e;
        }

        @os.l
        public final p0 i(@os.l String str) {
            kn.l0.p(str, "method");
            if (kn.l0.g(str, p0.f8136c.f8144a)) {
                return p0.f8136c;
            }
            if (kn.l0.g(str, p0.f8137d.f8144a)) {
                return p0.f8137d;
            }
            if (kn.l0.g(str, p0.f8138e.f8144a)) {
                return p0.f8138e;
            }
            if (kn.l0.g(str, p0.f8139f.f8144a)) {
                return p0.f8139f;
            }
            if (kn.l0.g(str, p0.f8140g.f8144a)) {
                return p0.f8140g;
            }
            if (kn.l0.g(str, p0.f8141h.f8144a)) {
                return p0.f8141h;
            }
            return kn.l0.g(str, p0.f8142i.f8144a) ? p0.f8142i : new p0(str);
        }

        public a(kn.w wVar) {
        }
    }

    static {
        p0 p0Var = new p0("GET");
        f8136c = p0Var;
        p0 p0Var2 = new p0(wj.v0.f19370p);
        f8137d = p0Var2;
        p0 p0Var3 = new p0("PUT");
        f8138e = p0Var3;
        p0 p0Var4 = new p0("PATCH");
        f8139f = p0Var4;
        p0 p0Var5 = new p0("DELETE");
        f8140g = p0Var5;
        p0 p0Var6 = new p0("HEAD");
        f8141h = p0Var6;
        p0 p0Var7 = new p0("OPTIONS");
        f8142i = p0Var7;
        f8143j = nm.y.O(p0Var, p0Var2, p0Var3, p0Var4, p0Var5, p0Var6, p0Var7);
    }

    public p0(@os.l String str) {
        kn.l0.p(str, "value");
        this.f8144a = str;
    }

    public static /* synthetic */ p0 k(p0 p0Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = p0Var.f8144a;
        }
        return p0Var.j(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p0) && kn.l0.g(this.f8144a, ((p0) obj).f8144a);
    }

    public int hashCode() {
        return this.f8144a.hashCode();
    }

    @os.l
    public final String i() {
        return this.f8144a;
    }

    @os.l
    public final p0 j(@os.l String str) {
        kn.l0.p(str, "value");
        return new p0(str);
    }

    @os.l
    public final String l() {
        return this.f8144a;
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("HttpMethod(value="), this.f8144a, ')');
    }
}
