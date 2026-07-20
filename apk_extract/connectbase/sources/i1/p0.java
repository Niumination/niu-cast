package i1;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class p0<N> extends AbstractSet<x<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f7613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<N> f7614b;

    public p0(n<N> graph, N node) {
        this.f7614b = graph;
        this.f7613a = node;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f7614b.e()) {
            if (!xVar.b()) {
                return false;
            }
            Object objK = xVar.k();
            Object objL = xVar.l();
            return (this.f7613a.equals(objK) && this.f7614b.b((Object) this.f7613a).contains(objL)) || (this.f7613a.equals(objL) && this.f7614b.a((Object) this.f7613a).contains(objK));
        }
        if (xVar.b()) {
            return false;
        }
        Set<N> setK = this.f7614b.k(this.f7613a);
        N n10 = xVar.f7658a;
        N n11 = xVar.f7659b;
        return (this.f7613a.equals(n11) && setK.contains(n10)) || (this.f7613a.equals(n10) && setK.contains(n11));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@gm.a Object o10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (!this.f7614b.e()) {
            return this.f7614b.k(this.f7613a).size();
        }
        return (this.f7614b.i(this.f7613a) + this.f7614b.n(this.f7613a)) - (this.f7614b.b((Object) this.f7613a).contains(this.f7613a) ? 1 : 0);
    }
}
