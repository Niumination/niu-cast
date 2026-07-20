package gq;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, R> f6818b;

    public static final class a implements Iterator<R>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a0<T, R> f6820b;

        public a(a0<T, R> a0Var) {
            this.f6820b = a0Var;
            this.f6819a = a0Var.f6817a.iterator();
        }

        @os.l
        public final Iterator<T> a() {
            return this.f6819a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6819a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f6820b.f6818b.invoke(this.f6819a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(@os.l m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "sequence");
        l0.p(lVar, "transformer");
        this.f6817a = mVar;
        this.f6818b = lVar;
    }

    @os.l
    public final <E> m<E> e(@os.l jn.l<? super R, ? extends Iterator<? extends E>> lVar) {
        l0.p(lVar, "iterator");
        return new i(this.f6817a, this.f6818b, lVar);
    }

    @Override // gq.m
    @os.l
    public Iterator<R> iterator() {
        return new a(this);
    }
}
