package gq;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, Boolean> f6831b;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6833b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public T f6834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f<T> f6835d;

        public a(f<T> fVar) {
            this.f6835d = fVar;
            this.f6832a = fVar.f6830a.iterator();
        }

        private final void a() {
            while (this.f6832a.hasNext()) {
                T next = this.f6832a.next();
                if (!this.f6835d.f6831b.invoke(next).booleanValue()) {
                    this.f6834c = next;
                    this.f6833b = 1;
                    return;
                }
            }
            this.f6833b = 0;
        }

        public final int c() {
            return this.f6833b;
        }

        @os.l
        public final Iterator<T> e() {
            return this.f6832a;
        }

        @os.m
        public final T f() {
            return this.f6834c;
        }

        public final void g(int i10) {
            this.f6833b = i10;
        }

        public final void h(@os.m T t10) {
            this.f6834c = t10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6833b == -1) {
                a();
            }
            return this.f6833b == 1 || this.f6832a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f6833b == -1) {
                a();
            }
            if (this.f6833b != 1) {
                return this.f6832a.next();
            }
            T t10 = this.f6834c;
            this.f6834c = null;
            this.f6833b = 0;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@os.l m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "sequence");
        l0.p(lVar, "predicate");
        this.f6830a = mVar;
        this.f6831b = lVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
