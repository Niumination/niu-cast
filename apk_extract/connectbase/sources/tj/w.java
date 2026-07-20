package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f15741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f15742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15743c;

    public w(Collection<a> collection, o oVar, boolean z10) {
        this.f15741a = new ArrayList<>(collection);
        this.f15742b = oVar;
        this.f15743c = z10;
    }

    @Override // tj.a
    public Collection<k1> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f15741a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().a());
        }
        return arrayList;
    }

    public final Collection<a> b() {
        return this.f15741a;
    }

    public boolean c() {
        return this.f15743c;
    }

    public o d() {
        return this.f15742b;
    }

    public String e() {
        for (a aVar : this.f15741a) {
            if (aVar instanceof a0) {
                return (String) n1.i(((a0) aVar).f15569a).unwrapped();
            }
        }
        return null;
    }
}
