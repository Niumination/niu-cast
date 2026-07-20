package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class x<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6898b;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6900b;

        public a(x<T> xVar) {
            this.f6899a = xVar.f6898b;
            this.f6900b = xVar.f6897a.iterator();
        }

        @os.l
        public final Iterator<T> a() {
            return this.f6900b;
        }

        public final int c() {
            return this.f6899a;
        }

        public final void e(int i10) {
            this.f6899a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6899a > 0 && this.f6900b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i10 = this.f6899a;
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            this.f6899a = i10 - 1;
            return this.f6900b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(@os.l m<? extends T> mVar, int i10) {
        l0.p(mVar, "sequence");
        this.f6897a = mVar;
        this.f6898b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + n1.e.f11183c).toString());
    }

    @Override // gq.e
    @os.l
    public m<T> a(int i10) {
        int i11 = this.f6898b;
        return i10 >= i11 ? g.f6836a : new w(this.f6897a, i10, i11);
    }

    @Override // gq.e
    @os.l
    public m<T> b(int i10) {
        return i10 >= this.f6898b ? this : new x(this.f6897a, i10);
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
