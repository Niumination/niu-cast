package wk;

import ik.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f19621c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f19622d = "$LocalPort";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19623b;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public j(int i10) {
        this.f19623b = i10;
    }

    public static j f(j jVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = jVar.f19623b;
        }
        jVar.getClass();
        return new j(i10);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        int iA = j0Var.f19625b.d().g().a();
        int i11 = this.f19623b;
        if (iA == i11) {
            return new x(true, 1.0d, e1.b(f19622d, String.valueOf(i11)), 0, 8, null);
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    public final int d() {
        return this.f19623b;
    }

    @os.l
    public final j e(int i10) {
        return new j(i10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f19623b == ((j) obj).f19623b;
    }

    public final int g() {
        return this.f19623b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f19623b);
    }

    @os.l
    public String toString() {
        return u.a.a(new StringBuilder("LocalPortRouteSelector(port="), this.f19623b, ')');
    }
}
