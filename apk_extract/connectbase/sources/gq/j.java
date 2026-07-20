package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<T> f6850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, T> f6851b;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public T f6852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6853b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j<T> f6854c;

        public a(j<T> jVar) {
            this.f6854c = jVar;
        }

        private final void a() {
            T tInvoke;
            if (this.f6853b == -2) {
                tInvoke = this.f6854c.f6850a.invoke();
            } else {
                jn.l<T, T> lVar = this.f6854c.f6851b;
                T t10 = this.f6852a;
                l0.m(t10);
                tInvoke = lVar.invoke(t10);
            }
            this.f6852a = tInvoke;
            this.f6853b = tInvoke == null ? 0 : 1;
        }

        @os.m
        public final T c() {
            return this.f6852a;
        }

        public final int e() {
            return this.f6853b;
        }

        public final void f(@os.m T t10) {
            this.f6852a = t10;
        }

        public final void g(int i10) {
            this.f6853b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6853b < 0) {
                a();
            }
            return this.f6853b == 1;
        }

        @Override // java.util.Iterator
        @os.l
        public T next() {
            if (this.f6853b < 0) {
                a();
            }
            if (this.f6853b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f6852a;
            l0.n(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f6853b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@os.l jn.a<? extends T> aVar, @os.l jn.l<? super T, ? extends T> lVar) {
        l0.p(aVar, "getInitialValue");
        l0.p(lVar, "getNextValue");
        this.f6850a = aVar;
        this.f6851b = lVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
