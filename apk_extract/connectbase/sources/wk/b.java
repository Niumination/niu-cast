package wk;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f19594c;

    public b(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        this.f19593b = str;
        this.f19594c = str2;
    }

    public static /* synthetic */ b g(b bVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bVar.f19593b;
        }
        if ((i10 & 2) != 0) {
            str2 = bVar.f19594c;
        }
        return bVar.f(str, str2);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        if (j0Var.f19625b.getParameters().d(this.f19593b, this.f19594c)) {
            x.f19664e.getClass();
            return x.f19677r;
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    @os.l
    public final String d() {
        return this.f19593b;
    }

    @os.l
    public final String e() {
        return this.f19594c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kn.l0.g(this.f19593b, bVar.f19593b) && kn.l0.g(this.f19594c, bVar.f19594c);
    }

    @os.l
    public final b f(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new b(str, str2);
    }

    @os.l
    public final String h() {
        return this.f19593b;
    }

    public int hashCode() {
        return this.f19594c.hashCode() + (this.f19593b.hashCode() * 31);
    }

    @os.l
    public final String i() {
        return this.f19594c;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f19593b);
        sb2.append(" = ");
        return l.a.a(sb2, this.f19594c, ']');
    }
}
