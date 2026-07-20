package wk;

import gk.u0;
import ik.b1;
import ik.c1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f19598e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final String f19599f = "$RequestHost";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final String f19600g = "$RequestPort";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<String> f19601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<jq.r> f19602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<Integer> f19603d;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public c(@os.l List<String> list, @os.l List<jq.r> list2, @os.l List<Integer> list3) {
        kn.l0.p(list, "hostList");
        kn.l0.p(list2, "hostPatterns");
        kn.l0.p(list3, "portsList");
        this.f19601b = list;
        this.f19602c = list2;
        this.f19603d = list3;
        if (list.isEmpty() && list2.isEmpty() && list3.isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c h(c cVar, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = cVar.f19601b;
        }
        if ((i10 & 2) != 0) {
            list2 = cVar.f19602c;
        }
        if ((i10 & 4) != 0) {
            list3 = cVar.f19603d;
        }
        return cVar.g(list, list2, list3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004f A[EDGE_INSN: B:12:0x004f->B:19:0x0068 BREAK  A[LOOP:0: B:14:0x0055->B:33:?]] */
    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        boolean z10;
        kn.l0.p(j0Var, "context");
        String strB = u0.e(j0Var.f19625b.d()).b();
        int iA = u0.e(j0Var.f19625b.d()).a();
        if (!this.f19601b.isEmpty() || !this.f19602c.isEmpty()) {
            boolean zContains = this.f19601b.contains(strB);
            if (!zContains) {
                List<jq.r> list = this.f19602c;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = false;
                            break;
                        }
                        if (((jq.r) it.next()).matches(strB)) {
                            z10 = true;
                            break;
                        }
                    }
                } else {
                    z10 = false;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
            if (!zContains && !z10) {
                x.f19664e.getClass();
                return x.f19675p;
            }
        }
        if (!this.f19603d.isEmpty() && !this.f19603d.contains(Integer.valueOf(iA))) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        b1.a aVar = b1.f7942c;
        c1 c1Var = new c1(0, null, 3, null);
        c1Var.a(f19599f, strB);
        c1Var.a(f19600g, String.valueOf(iA));
        return new x(true, 1.0d, c1Var.f(), 0, 8, null);
    }

    @os.l
    public final List<String> d() {
        return this.f19601b;
    }

    @os.l
    public final List<jq.r> e() {
        return this.f19602c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kn.l0.g(this.f19601b, cVar.f19601b) && kn.l0.g(this.f19602c, cVar.f19602c) && kn.l0.g(this.f19603d, cVar.f19603d);
    }

    @os.l
    public final List<Integer> f() {
        return this.f19603d;
    }

    @os.l
    public final c g(@os.l List<String> list, @os.l List<jq.r> list2, @os.l List<Integer> list3) {
        kn.l0.p(list, "hostList");
        kn.l0.p(list2, "hostPatterns");
        kn.l0.p(list3, "portsList");
        return new c(list, list2, list3);
    }

    public int hashCode() {
        return this.f19603d.hashCode() + ((this.f19602c.hashCode() + (this.f19601b.hashCode() * 31)) * 31);
    }

    @os.l
    public final List<String> i() {
        return this.f19601b;
    }

    @os.l
    public final List<jq.r> j() {
        return this.f19602c;
    }

    @os.l
    public final List<Integer> k() {
        return this.f19603d;
    }

    @os.l
    public String toString() {
        return "(" + this.f19601b + ", " + this.f19602c + ", " + this.f19603d + ')';
    }
}
