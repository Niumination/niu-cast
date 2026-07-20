package wk;

import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final String f19655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final String f19656d;

    public /* synthetic */ q(String str, String str2, String str3, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ q h(q qVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qVar.f19654b;
        }
        if ((i10 & 2) != 0) {
            str2 = qVar.f19655c;
        }
        if ((i10 & 4) != 0) {
            str3 = qVar.f19656d;
        }
        return qVar.g(str, str2, str3);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        return y.a(j0Var.f19627d, i10, this.f19654b, this.f19655c, this.f19656d, false);
    }

    @os.l
    public final String d() {
        return this.f19654b;
    }

    @os.m
    public final String e() {
        return this.f19655c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kn.l0.g(this.f19654b, qVar.f19654b) && kn.l0.g(this.f19655c, qVar.f19655c) && kn.l0.g(this.f19656d, qVar.f19656d);
    }

    @os.m
    public final String f() {
        return this.f19656d;
    }

    @os.l
    public final q g(@os.l String str, @os.m String str2, @os.m String str3) {
        kn.l0.p(str, "name");
        return new q(str, str2, str3);
    }

    public int hashCode() {
        int iHashCode = this.f19654b.hashCode() * 31;
        String str = this.f19655c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f19656d;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @os.l
    public final String i() {
        return this.f19654b;
    }

    @os.m
    public final String j() {
        return this.f19655c;
    }

    @os.m
    public final String k() {
        return this.f19656d;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f19655c;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append(rs.f.f14859a);
        sb2.append(this.f19654b);
        sb2.append(rs.f.f14860b);
        String str2 = this.f19656d;
        sb2.append(str2 != null ? str2 : "");
        return sb2.toString();
    }

    public q(@os.l String str, @os.m String str2, @os.m String str3) {
        kn.l0.p(str, "name");
        this.f19654b = str;
        this.f19655c = str2;
        this.f19656d = str3;
    }

    public /* synthetic */ q(String str, String str2, String str3, boolean z10, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "PathSegmentParameterRouteSelector(value, prefix, suffix)", imports = {}))
    public q(@os.l String str, @os.m String str2, @os.m String str3, boolean z10) {
        this(str, str2, str3);
        kn.l0.p(str, "name");
    }
}
