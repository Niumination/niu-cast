package ik;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final a f8224j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final t1 f8225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f8226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final String f8228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final b1 f8229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f8230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final String f8231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public final String f8232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8233i;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public y1(@os.l t1 t1Var, @os.l String str, int i10, @os.l String str2, @os.l b1 b1Var, @os.l String str3, @os.m String str4, @os.m String str5, boolean z10) {
        kn.l0.p(t1Var, "protocol");
        kn.l0.p(str, "host");
        kn.l0.p(str2, "encodedPath");
        kn.l0.p(b1Var, "parameters");
        kn.l0.p(str3, "fragment");
        this.f8225a = t1Var;
        this.f8226b = str;
        this.f8227c = i10;
        this.f8228d = str2;
        this.f8229e = b1Var;
        this.f8230f = str3;
        this.f8231g = str4;
        this.f8232h = str5;
        this.f8233i = z10;
        if ((i10 < 0 || i10 >= 65536) && i10 != 0) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set");
        }
    }

    @os.l
    public final t1 a() {
        return this.f8225a;
    }

    @os.l
    public final String b() {
        return this.f8226b;
    }

    public final int c() {
        return this.f8227c;
    }

    @os.l
    public final String d() {
        return this.f8228d;
    }

    @os.l
    public final b1 e() {
        return this.f8229e;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        return kn.l0.g(this.f8225a, y1Var.f8225a) && kn.l0.g(this.f8226b, y1Var.f8226b) && this.f8227c == y1Var.f8227c && kn.l0.g(this.f8228d, y1Var.f8228d) && kn.l0.g(this.f8229e, y1Var.f8229e) && kn.l0.g(this.f8230f, y1Var.f8230f) && kn.l0.g(this.f8231g, y1Var.f8231g) && kn.l0.g(this.f8232h, y1Var.f8232h) && this.f8233i == y1Var.f8233i;
    }

    @os.l
    public final String f() {
        return this.f8230f;
    }

    @os.m
    public final String g() {
        return this.f8231g;
    }

    @os.m
    public final String h() {
        return this.f8232h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public int hashCode() {
        int iA = s0.b.a(this.f8230f, (this.f8229e.hashCode() + s0.b.a(this.f8228d, k0.d.a(this.f8227c, s0.b.a(this.f8226b, this.f8225a.hashCode() * 31, 31), 31), 31)) * 31, 31);
        String str = this.f8231g;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8232h;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.f8233i;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode2 + r10;
    }

    public final boolean i() {
        return this.f8233i;
    }

    @os.l
    public final y1 j(@os.l t1 t1Var, @os.l String str, int i10, @os.l String str2, @os.l b1 b1Var, @os.l String str3, @os.m String str4, @os.m String str5, boolean z10) {
        kn.l0.p(t1Var, "protocol");
        kn.l0.p(str, "host");
        kn.l0.p(str2, "encodedPath");
        kn.l0.p(b1Var, "parameters");
        kn.l0.p(str3, "fragment");
        return new y1(t1Var, str, i10, str2, b1Var, str3, str4, str5, z10);
    }

    @os.l
    public final String l() {
        return this.f8228d;
    }

    @os.l
    public final String m() {
        return this.f8230f;
    }

    @os.l
    public final String n() {
        return this.f8226b;
    }

    @os.l
    public final b1 o() {
        return this.f8229e;
    }

    @os.m
    public final String p() {
        return this.f8232h;
    }

    public final int q() {
        Integer numValueOf = Integer.valueOf(this.f8227c);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        return numValueOf == null ? this.f8225a.f8197b : numValueOf.intValue();
    }

    @os.l
    public final t1 r() {
        return this.f8225a;
    }

    public final int s() {
        return this.f8227c;
    }

    public final boolean t() {
        return this.f8233i;
    }

    @os.l
    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8225a.f8196a);
        String str = this.f8225a.f8196a;
        if (kn.l0.g(str, "file")) {
            p1.c(sb2, this.f8226b, this.f8228d);
        } else if (kn.l0.g(str, "mailto")) {
            String str2 = this.f8231g;
            if (str2 == null) {
                throw new IllegalStateException("User can't be empty.");
            }
            p1.d(sb2, str2, this.f8226b);
        } else {
            sb2.append("://");
            sb2.append(p1.h(this));
            sb2.append(w1.h(this));
            if (this.f8230f.length() > 0) {
                sb2.append('#');
                sb2.append(this.f8230f);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.m
    public final String u() {
        return this.f8231g;
    }
}
