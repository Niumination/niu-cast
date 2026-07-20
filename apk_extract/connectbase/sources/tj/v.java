package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f15739a;

    public v(Collection<a> collection) {
        this.f15739a = new ArrayList<>(collection);
    }

    @Override // tj.a
    public Collection<k1> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f15739a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().a());
        }
        return arrayList;
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.f15739a) {
            if (aVar instanceof s) {
                arrayList.add(n1.a(((s) aVar).f15573a));
            }
        }
        return arrayList;
    }

    public y c() {
        for (int i10 = 0; i10 < this.f15739a.size(); i10++) {
            if (this.f15739a.get(i10) instanceof y) {
                return (y) this.f15739a.get(i10);
            }
        }
        throw new sj.c.d("Field node doesn't have a path");
    }

    public v d(b bVar) {
        ArrayList arrayList = new ArrayList(this.f15739a);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (arrayList.get(i10) instanceof b) {
                arrayList.set(i10, bVar);
                return new v(arrayList);
            }
        }
        throw new sj.c.d("Field node doesn't have a value");
    }

    public k1 e() {
        k1 k1VarB;
        for (a aVar : this.f15739a) {
            if ((aVar instanceof b0) && ((k1VarB = ((b0) aVar).b()) == n1.f15694j || k1VarB == n1.f15689e || k1VarB == n1.f15688d)) {
                return k1VarB;
            }
        }
        return null;
    }

    public b f() {
        for (int i10 = 0; i10 < this.f15739a.size(); i10++) {
            if (this.f15739a.get(i10) instanceof b) {
                return (b) this.f15739a.get(i10);
            }
        }
        throw new sj.c.d("Field node doesn't have a value");
    }
}
