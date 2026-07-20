package wk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final v f19643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public k0 f19645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public List<m0> f19646d;

    public m0(@os.l v vVar, int i10, @os.m k0 k0Var) {
        kn.l0.p(vVar, "route");
        this.f19643a = vVar;
        this.f19644b = i10;
        this.f19645c = k0Var;
    }

    public final void a(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "item");
        List arrayList = this.f19646d;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f19646d = arrayList;
        }
        arrayList.add(m0Var);
    }

    public void b(@os.l StringBuilder sb2, int i10) {
        kn.l0.p(sb2, "builder");
        sb2.append(kn.l0.C(jq.e0.e2("  ", i10), this));
        kn.l0.o(sb2, "append(value)");
        sb2.append('\n');
        kn.l0.o(sb2, "append('\\n')");
        List<m0> list = this.f19646d;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((m0) it.next()).b(sb2, i10 + 1);
        }
    }

    @os.m
    public final k0 c() {
        return this.f19645c;
    }

    @os.l
    public final v d() {
        return this.f19643a;
    }

    public final int e() {
        return this.f19644b;
    }

    public final void f(@os.m k0 k0Var) {
        this.f19645c = k0Var;
    }

    @os.l
    public String toString() {
        return this.f19643a + ", segment:" + this.f19644b + " -> " + this.f19645c;
    }

    public /* synthetic */ m0(v vVar, int i10, k0 k0Var, int i11, kn.w wVar) {
        this(vVar, i10, (i11 & 4) != 0 ? null : k0Var);
    }
}
