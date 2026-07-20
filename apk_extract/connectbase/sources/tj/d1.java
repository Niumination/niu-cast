package tj;

import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 implements uj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f15578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sj.q f15579b;

    public d1(z zVar, sj.q qVar) {
        this.f15578a = zVar;
        this.f15579b = qVar;
    }

    @Override // uj.a
    public uj.a a(String str, String str2) {
        if (str2 == null) {
            throw new sj.c.d(n.a.a("null value for ", str, " passed to withValueText"));
        }
        g1 g1VarT = g1.t("single value parsing");
        StringReader stringReader = new StringReader(str2);
        b bVarB = k.b(m1.d(g1VarT, stringReader, this.f15579b.f15090a), g1VarT, this.f15579b);
        stringReader.close();
        return new d1(this.f15578a.g(str, bVarB, this.f15579b.f15090a), this.f15579b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof uj.a) && this.f15578a.render().equals(((uj.a) obj).render());
    }

    @Override // uj.a
    public boolean hasPath(String str) {
        return this.f15578a.e(str);
    }

    public int hashCode() {
        return this.f15578a.render().hashCode();
    }

    @Override // uj.a
    public String render() {
        return this.f15578a.render();
    }

    @Override // uj.a
    public uj.a withValue(String str, sj.x xVar) {
        if (xVar != null) {
            return a(str, xVar.render(sj.s.b().j(false)).trim());
        }
        throw new sj.c.d(n.a.a("null value for ", str, " passed to withValue"));
    }

    @Override // uj.a
    public uj.a withoutPath(String str) {
        return new d1(this.f15578a.g(str, null, this.f15579b.f15090a), this.f15579b);
    }
}
