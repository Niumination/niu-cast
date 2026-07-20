package wk;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ik.i f19608b;

    public e(@os.l ik.i iVar) {
        kn.l0.p(iVar, "contentType");
        this.f19608b = iVar;
    }

    public static /* synthetic */ e f(e eVar, ik.i iVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = eVar.f19608b;
        }
        return eVar.e(iVar);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) throws gk.c {
        Object next;
        kn.l0.p(j0Var, "context");
        ik.b0 b0VarB = j0Var.f19625b.d().b();
        ik.j0.f8048a.getClass();
        String str = b0VarB.get(ik.j0.f8050b);
        try {
            List<ik.x> listB = ik.i0.b(str);
            if (listB.isEmpty()) {
                x.f19664e.getClass();
                return x.f19676q;
            }
            Iterator<T> it = listB.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!this.f19608b.i(((ik.x) next).f8200a));
            ik.x xVar = (ik.x) next;
            if (xVar != null) {
                return new x(true, xVar.f8202c, null, 0, 12, null);
            }
            x.f19664e.getClass();
            return x.f19675p;
        } catch (ik.c e10) {
            throw new gk.c(kn.l0.C("Illegal Accept header format: ", str), e10);
        }
    }

    @os.l
    public final ik.i d() {
        return this.f19608b;
    }

    @os.l
    public final e e(@os.l ik.i iVar) {
        kn.l0.p(iVar, "contentType");
        return new e(iVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && kn.l0.g(this.f19608b, ((e) obj).f19608b);
    }

    @os.l
    public final ik.i g() {
        return this.f19608b;
    }

    public int hashCode() {
        return this.f19608b.hashCode();
    }

    @os.l
    public String toString() {
        return "(contentType:" + this.f19608b + ')';
    }
}
