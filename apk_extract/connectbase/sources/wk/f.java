package wk;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f19610c;

    public f(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        this.f19609b = str;
        this.f19610c = str2;
    }

    public static /* synthetic */ f g(f fVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fVar.f19609b;
        }
        if ((i10 & 2) != 0) {
            str2 = fVar.f19610c;
        }
        return fVar.f(str, str2);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        Object next;
        kn.l0.p(j0Var, "context");
        Iterator<T> it = ik.i0.c(j0Var.f19625b.d().b().get(this.f19609b)).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!jq.e0.K1(((ik.x) next).f8200a, this.f19610c, true));
        ik.x xVar = (ik.x) next;
        if (xVar != null) {
            return new x(true, xVar.f8202c, null, 0, 12, null);
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    @os.l
    public final String d() {
        return this.f19609b;
    }

    @os.l
    public final String e() {
        return this.f19610c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kn.l0.g(this.f19609b, fVar.f19609b) && kn.l0.g(this.f19610c, fVar.f19610c);
    }

    @os.l
    public final f f(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new f(str, str2);
    }

    @os.l
    public final String h() {
        return this.f19609b;
    }

    public int hashCode() {
        return this.f19610c.hashCode() + (this.f19609b.hashCode() * 31);
    }

    @os.l
    public final String i() {
        return this.f19610c;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("(header:");
        sb2.append(this.f19609b);
        sb2.append(" = ");
        return l.a.a(sb2, this.f19610c, ')');
    }
}
