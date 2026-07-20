package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class y<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, Boolean> f6902b;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6904b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public T f6905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ y<T> f6906d;

        public a(y<T> yVar) {
            this.f6906d = yVar;
            this.f6903a = yVar.f6901a.iterator();
        }

        private final void a() {
            if (this.f6903a.hasNext()) {
                T next = this.f6903a.next();
                if (this.f6906d.f6902b.invoke(next).booleanValue()) {
                    this.f6904b = 1;
                    this.f6905c = next;
                    return;
                }
            }
            this.f6904b = 0;
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6903a;
        }

        @os.m
        public final T e() {
            return this.f6905c;
        }

        public final int f() {
            return this.f6904b;
        }

        public final void g(@os.m T t10) {
            this.f6905c = t10;
        }

        public final void h(int i10) {
            this.f6904b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6904b == -1) {
                a();
            }
            return this.f6904b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f6904b == -1) {
                a();
            }
            if (this.f6904b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f6905c;
            this.f6905c = null;
            this.f6904b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(@os.l m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "sequence");
        l0.p(lVar, "predicate");
        this.f6901a = mVar;
        this.f6902b = lVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
