package ho;

import eo.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<eo.l0> f7357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f7358b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@os.l List<? extends eo.l0> list, @os.l String str) {
        kn.l0.p(list, "providers");
        kn.l0.p(str, "debugName");
        this.f7357a = list;
        this.f7358b = str;
        list.size();
        nm.h0.a6(list).size();
    }

    @Override // eo.l0
    @os.l
    public List<eo.k0> a(@os.l dp.c cVar) {
        kn.l0.p(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<eo.l0> it = this.f7357a.iterator();
        while (it.hasNext()) {
            eo.n0.a(it.next(), cVar, arrayList);
        }
        return nm.h0.V5(arrayList);
    }

    @Override // eo.o0
    public boolean b(@os.l dp.c cVar) {
        kn.l0.p(cVar, "fqName");
        List<eo.l0> list = this.f7357a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!eo.n0.b((eo.l0) it.next(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // eo.o0
    public void c(@os.l dp.c cVar, @os.l Collection<eo.k0> collection) {
        kn.l0.p(cVar, "fqName");
        kn.l0.p(collection, "packageFragments");
        Iterator<eo.l0> it = this.f7357a.iterator();
        while (it.hasNext()) {
            eo.n0.a(it.next(), cVar, collection);
        }
    }

    @Override // eo.l0
    @os.l
    public Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        kn.l0.p(cVar, "fqName");
        kn.l0.p(lVar, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<eo.l0> it = this.f7357a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().p(cVar, lVar));
        }
        return hashSet;
    }

    @os.l
    public String toString() {
        return this.f7358b;
    }
}
