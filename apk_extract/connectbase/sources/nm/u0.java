package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class u0<T> implements Iterator<s0<? extends T>>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Iterator<T> f11696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11697b;

    /* JADX WARN: Multi-variable type inference failed */
    public u0(@os.l Iterator<? extends T> it) {
        kn.l0.p(it, "iterator");
        this.f11696a = it;
    }

    @Override // java.util.Iterator
    @os.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final s0<T> next() {
        int i10 = this.f11697b;
        this.f11697b = i10 + 1;
        if (i10 < 0) {
            y.Z();
        }
        return new s0<>(i10, this.f11696a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11696a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
