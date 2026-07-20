package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f15733a;

    public t(Collection<a> collection) {
        this.f15733a = new ArrayList<>(collection);
    }

    @Override // tj.a
    public Collection<k1> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f15733a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().a());
        }
        return arrayList;
    }

    public final Collection<a> b() {
        return this.f15733a;
    }

    public t c(a aVar) {
        ArrayList arrayList = new ArrayList(this.f15733a);
        int i10 = 0;
        while (i10 < arrayList.size()) {
            a aVar2 = (a) arrayList.get(i10);
            if ((aVar2 instanceof b0) && n1.l(((b0) aVar2).b())) {
                i10++;
                arrayList.add(i10, aVar);
            } else if (aVar2 instanceof v) {
                v vVar = (v) aVar2;
                b bVarF = vVar.f();
                if (bVarF instanceof t) {
                    arrayList.set(i10, vVar.d(((t) bVarF).c(aVar)));
                }
            } else if (aVar2 instanceof t) {
                arrayList.set(i10, ((t) aVar2).c(aVar));
            }
            i10++;
        }
        return d(arrayList);
    }

    public abstract t d(Collection<a> collection);
}
