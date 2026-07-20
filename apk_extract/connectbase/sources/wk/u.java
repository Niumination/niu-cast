package wk;

import fl.t0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class u extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<String> f19661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final x f19662c;

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        if (i10 != 0) {
            throw new IllegalStateException("Root selector should be evaluated first.");
        }
        if (this.f19661b.isEmpty()) {
            x.f19664e.getClass();
            return x.f19677r;
        }
        List<String> list = this.f19661b;
        List<String> list2 = j0Var.f19627d;
        if (list2.size() < list.size()) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        int size = list.size() + i10;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (!kn.l0.g(list2.get(i10), list.get(i10))) {
                x.f19664e.getClass();
                return x.f19675p;
            }
            i10 = i11;
        }
        return this.f19662c;
    }

    @os.l
    public String toString() {
        return nm.h0.m3(this.f19661b, "/", null, null, 0, null, null, 62, null);
    }

    public u(@os.l String str) {
        kn.l0.p(str, "rootPath");
        List<g0> list = f0.f19611b.b(str).f19613a;
        ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
        for (g0 g0Var : list) {
            if (g0Var.f19616b != h0.Constant) {
                throw new IllegalArgumentException("rootPath should be constant, no wildcards supported.");
            }
            arrayList.add(g0Var.f19615a);
        }
        this.f19661b = arrayList;
        this.f19662c = new x(true, 1.0d, null, arrayList.size(), 4, null);
    }

    public /* synthetic */ u(String str, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
