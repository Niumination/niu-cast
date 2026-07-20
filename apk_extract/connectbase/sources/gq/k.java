package gq;

import java.util.Iterator;
import kn.l0;
import nm.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class k<T> implements m<s0<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6855a;

    public static final class a implements Iterator<s0<? extends T>>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6857b;

        public a(k<T> kVar) {
            this.f6856a = kVar.f6855a.iterator();
        }

        public final int a() {
            return this.f6857b;
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6856a;
        }

        @Override // java.util.Iterator
        @os.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public s0<T> next() {
            int i10 = this.f6857b;
            this.f6857b = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            return new s0<>(i10, this.f6856a.next());
        }

        public final void f(int i10) {
            this.f6857b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6856a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@os.l m<? extends T> mVar) {
        l0.p(mVar, "sequence");
        this.f6855a = mVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<s0<T>> iterator() {
        return new a(this);
    }
}
