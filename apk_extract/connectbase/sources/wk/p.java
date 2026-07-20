package wk;

import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final String f19652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final String f19653d;

    public /* synthetic */ p(String str, String str2, String str3, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ p h(p pVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pVar.f19651b;
        }
        if ((i10 & 2) != 0) {
            str2 = pVar.f19652c;
        }
        if ((i10 & 4) != 0) {
            str3 = pVar.f19653d;
        }
        return pVar.g(str, str2, str3);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        return y.a(j0Var.f19627d, i10, this.f19651b, this.f19652c, this.f19653d, true);
    }

    @os.l
    public final String d() {
        return this.f19651b;
    }

    @os.m
    public final String e() {
        return this.f19652c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kn.l0.g(this.f19651b, pVar.f19651b) && kn.l0.g(this.f19652c, pVar.f19652c) && kn.l0.g(this.f19653d, pVar.f19653d);
    }

    @os.m
    public final String f() {
        return this.f19653d;
    }

    @os.l
    public final p g(@os.l String str, @os.m String str2, @os.m String str3) {
        kn.l0.p(str, "name");
        return new p(str, str2, str3);
    }

    public int hashCode() {
        int iHashCode = this.f19651b.hashCode() * 31;
        String str = this.f19652c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f19653d;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @os.l
    public final String i() {
        return this.f19651b;
    }

    @os.m
    public final String j() {
        return this.f19652c;
    }

    @os.m
    public final String k() {
        return this.f19653d;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f19652c;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append(rs.f.f14859a);
        sb2.append(this.f19651b);
        sb2.append("?}");
        String str2 = this.f19653d;
        sb2.append(str2 != null ? str2 : "");
        return sb2.toString();
    }

    public p(@os.l String str, @os.m String str2, @os.m String str3) {
        kn.l0.p(str, "name");
        this.f19651b = str;
        this.f19652c = str2;
        this.f19653d = str3;
    }

    public /* synthetic */ p(String str, String str2, String str3, boolean z10, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "PathSegmentOptionalParameterRouteSelector(value, prefix, suffix)", imports = {}))
    public p(@os.l String str, @os.m String str2, @os.m String str3, boolean z10) {
        this(str, str2, str3);
        kn.l0.p(str, "name");
    }
}
