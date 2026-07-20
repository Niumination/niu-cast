package wk;

import ik.e1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19647b;

    public n(@os.l String str) {
        kn.l0.p(str, "name");
        this.f19647b = str;
    }

    public static /* synthetic */ n f(n nVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nVar.f19647b;
        }
        return nVar.e(str);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        List<String> listB = j0Var.f19625b.getParameters().b(this.f19647b);
        if (listB != null) {
            return new x(true, 1.0d, e1.c(this.f19647b, listB), 0, 8, null);
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    @os.l
    public final String d() {
        return this.f19647b;
    }

    @os.l
    public final n e(@os.l String str) {
        kn.l0.p(str, "name");
        return new n(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && kn.l0.g(this.f19647b, ((n) obj).f19647b);
    }

    @os.l
    public final String g() {
        return this.f19647b;
    }

    public int hashCode() {
        return this.f19647b.hashCode();
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("["), this.f19647b, ']');
    }
}
