package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class t0<T> implements Iterable<s0<? extends T>>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<Iterator<T>> f11695a;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(@os.l jn.a<? extends Iterator<? extends T>> aVar) {
        kn.l0.p(aVar, "iteratorFactory");
        this.f11695a = aVar;
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<s0<T>> iterator() {
        return new u0(this.f11695a.invoke());
    }
}
