package fo;

import java.util.Iterator;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<c> f6170a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l List<? extends c> list) {
        l0.p(list, "annotations");
        this.f6170a = list;
    }

    @Override // fo.g
    @os.m
    public c d(@os.l dp.c cVar) {
        return g.b.a(this, cVar);
    }

    @Override // fo.g
    public boolean isEmpty() {
        return this.f6170a.isEmpty();
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<c> iterator() {
        return this.f6170a.iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        return g.b.b(this, cVar);
    }

    @os.l
    public String toString() {
        return this.f6170a.toString();
    }
}
