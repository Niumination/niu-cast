package tj;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f15754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<k1> f15755b;

    public y(p0 p0Var, Collection<k1> collection) {
        this.f15754a = p0Var;
        this.f15755b = new ArrayList<>(collection);
    }

    @Override // tj.a
    public Collection<k1> a() {
        return this.f15755b;
    }

    public y b() {
        ArrayList arrayList = new ArrayList(this.f15755b);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (n1.o((k1) arrayList.get(i10)) && ((k1) arrayList.get(i10)).e().equals(".")) {
                return new y(this.f15754a.n(0, 1), arrayList.subList(0, i10));
            }
        }
        return this;
    }

    public y c(int i10) {
        ArrayList arrayList = new ArrayList(this.f15755b);
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            if (n1.o((k1) arrayList.get(i12)) && ((k1) arrayList.get(i12)).e().equals(".")) {
                i11++;
            }
            if (i11 == i10) {
                return new y(this.f15754a.m(i10), arrayList.subList(i12 + 1, arrayList.size()));
            }
        }
        throw new sj.c.d("Tried to remove too many elements from a Path node");
    }

    public p0 d() {
        return this.f15754a;
    }
}
