package gq;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class l<T1, T2, V> implements m<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T1> f6858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m<T2> f6859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.p<T1, T2, V> f6860c;

    public static final class a implements Iterator<V>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T1> f6861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Iterator<T2> f6862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l<T1, T2, V> f6863c;

        public a(l<T1, T2, V> lVar) {
            this.f6863c = lVar;
            this.f6861a = lVar.f6858a.iterator();
            this.f6862b = lVar.f6859b.iterator();
        }

        @os.l
        public final Iterator<T1> a() {
            return this.f6861a;
        }

        @os.l
        public final Iterator<T2> c() {
            return this.f6862b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6861a.hasNext() && this.f6862b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) this.f6863c.f6860c.invoke(this.f6861a.next(), this.f6862b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@os.l m<? extends T1> mVar, @os.l m<? extends T2> mVar2, @os.l jn.p<? super T1, ? super T2, ? extends V> pVar) {
        l0.p(mVar, "sequence1");
        l0.p(mVar2, "sequence2");
        l0.p(pVar, "transform");
        this.f6858a = mVar;
        this.f6859b = mVar2;
        this.f6860c = pVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<V> iterator() {
        return new a(this);
    }
}
