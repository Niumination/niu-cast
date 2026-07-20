package ik;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f8103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final o f8104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final kl.d f8106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final String f8107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final String f8108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final Map<String, String> f8111j;

    public l(@os.l String str, @os.l String str2, @os.l o oVar, int i10, @os.m kl.d dVar, @os.m String str3, @os.m String str4, boolean z10, boolean z11, @os.l Map<String, String> map) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        kn.l0.p(oVar, "encoding");
        kn.l0.p(map, "extensions");
        this.f8102a = str;
        this.f8103b = str2;
        this.f8104c = oVar;
        this.f8105d = i10;
        this.f8106e = dVar;
        this.f8107f = str3;
        this.f8108g = str4;
        this.f8109h = z10;
        this.f8110i = z11;
        this.f8111j = map;
    }

    @os.l
    public final String a() {
        return this.f8102a;
    }

    @os.l
    public final Map<String, String> b() {
        return this.f8111j;
    }

    @os.l
    public final String c() {
        return this.f8103b;
    }

    @os.l
    public final o d() {
        return this.f8104c;
    }

    public final int e() {
        return this.f8105d;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kn.l0.g(this.f8102a, lVar.f8102a) && kn.l0.g(this.f8103b, lVar.f8103b) && this.f8104c == lVar.f8104c && this.f8105d == lVar.f8105d && kn.l0.g(this.f8106e, lVar.f8106e) && kn.l0.g(this.f8107f, lVar.f8107f) && kn.l0.g(this.f8108g, lVar.f8108g) && this.f8109h == lVar.f8109h && this.f8110i == lVar.f8110i && kn.l0.g(this.f8111j, lVar.f8111j);
    }

    @os.m
    public final kl.d f() {
        return this.f8106e;
    }

    @os.m
    public final String g() {
        return this.f8107f;
    }

    @os.m
    public final String h() {
        return this.f8108g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int iA = k0.d.a(this.f8105d, (this.f8104c.hashCode() + s0.b.a(this.f8103b, this.f8102a.hashCode() * 31, 31)) * 31, 31);
        kl.d dVar = this.f8106e;
        int iHashCode = (iA + (dVar == null ? 0 : dVar.hashCode())) * 31;
        String str = this.f8107f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8108g;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.f8109h;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        int i10 = (iHashCode3 + r10) * 31;
        boolean z11 = this.f8110i;
        return this.f8111j.hashCode() + ((i10 + (z11 ? 1 : z11)) * 31);
    }

    public final boolean i() {
        return this.f8109h;
    }

    public final boolean j() {
        return this.f8110i;
    }

    @os.l
    public final l k(@os.l String str, @os.l String str2, @os.l o oVar, int i10, @os.m kl.d dVar, @os.m String str3, @os.m String str4, boolean z10, boolean z11, @os.l Map<String, String> map) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        kn.l0.p(oVar, "encoding");
        kn.l0.p(map, "extensions");
        return new l(str, str2, oVar, i10, dVar, str3, str4, z10, z11, map);
    }

    @os.m
    public final String m() {
        return this.f8107f;
    }

    @os.l
    public final o n() {
        return this.f8104c;
    }

    @os.m
    public final kl.d o() {
        return this.f8106e;
    }

    @os.l
    public final Map<String, String> p() {
        return this.f8111j;
    }

    public final boolean q() {
        return this.f8110i;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int r() {
        return this.f8105d;
    }

    @in.i(name = "getMaxAgeInt")
    public final int s() {
        return this.f8105d;
    }

    @os.l
    public final String t() {
        return this.f8102a;
    }

    @os.l
    public String toString() {
        return "Cookie(name=" + this.f8102a + ", value=" + this.f8103b + ", encoding=" + this.f8104c + ", maxAge=" + this.f8105d + ", expires=" + this.f8106e + ", domain=" + ((Object) this.f8107f) + ", path=" + ((Object) this.f8108g) + ", secure=" + this.f8109h + ", httpOnly=" + this.f8110i + ", extensions=" + this.f8111j + ')';
    }

    @os.m
    public final String u() {
        return this.f8108g;
    }

    public final boolean v() {
        return this.f8109h;
    }

    @os.l
    public final String w() {
        return this.f8103b;
    }

    public /* synthetic */ l(String str, String str2, o oVar, int i10, kl.d dVar, String str3, String str4, boolean z10, boolean z11, Map map, int i11, kn.w wVar) {
        this(str, str2, (i11 & 4) != 0 ? o.URI_ENCODING : oVar, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : dVar, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & 128) != 0 ? false : z10, (i11 & 256) != 0 ? false : z11, (i11 & 512) != 0 ? nm.d1.z() : map);
    }
}
