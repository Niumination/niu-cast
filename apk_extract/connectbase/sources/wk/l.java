package wk;

import ik.e1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19634b;

    public l(@os.l String str) {
        kn.l0.p(str, "name");
        this.f19634b = str;
    }

    public static /* synthetic */ l f(l lVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = lVar.f19634b;
        }
        return lVar.e(str);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        List<String> listB = j0Var.f19625b.getParameters().b(this.f19634b);
        if (listB != null) {
            return new x(true, 1.0d, e1.c(this.f19634b, listB), 0, 8, null);
        }
        x.f19664e.getClass();
        return x.f19676q;
    }

    @os.l
    public final String d() {
        return this.f19634b;
    }

    @os.l
    public final l e(@os.l String str) {
        kn.l0.p(str, "name");
        return new l(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && kn.l0.g(this.f19634b, ((l) obj).f19634b);
    }

    @os.l
    public final String g() {
        return this.f19634b;
    }

    public int hashCode() {
        return this.f19634b.hashCode();
    }

    @os.l
    public String toString() {
        return j.c.a(new StringBuilder("["), this.f19634b, "?]");
    }
}
