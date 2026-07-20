package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class i<T, R, E> implements m<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, R> f6845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<R, Iterator<E>> f6846c;

    public static final class a implements Iterator<E>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public Iterator<? extends E> f6848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i<T, R, E> f6849c;

        public a(i<T, R, E> iVar) {
            this.f6849c = iVar;
            this.f6847a = iVar.f6844a.iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it = this.f6848b;
            if (it != null && !it.hasNext()) {
                this.f6848b = null;
            }
            while (this.f6848b == null) {
                if (!this.f6847a.hasNext()) {
                    return false;
                }
                T next = this.f6847a.next();
                i<T, R, E> iVar = this.f6849c;
                Iterator<? extends E> it2 = (Iterator) iVar.f6846c.invoke(iVar.f6845b.invoke(next));
                if (it2.hasNext()) {
                    this.f6848b = it2;
                    break;
                }
            }
            return true;
        }

        @os.m
        public final Iterator<E> c() {
            return this.f6848b;
        }

        @os.l
        public final Iterator<T> e() {
            return this.f6847a;
        }

        public final void f(@os.m Iterator<? extends E> it) {
            this.f6848b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f6848b;
            l0.m(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@os.l m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar, @os.l jn.l<? super R, ? extends Iterator<? extends E>> lVar2) {
        l0.p(mVar, "sequence");
        l0.p(lVar, "transformer");
        l0.p(lVar2, "iterator");
        this.f6844a = mVar;
        this.f6845b = lVar;
        this.f6846c = lVar2;
    }

    @Override // gq.m
    @os.l
    public Iterator<E> iterator() {
        return new a(this);
    }
}
