package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class w<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6893c;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w<T> f6896c;

        public a(w<T> wVar) {
            this.f6896c = wVar;
            this.f6894a = wVar.f6891a.iterator();
        }

        private final void a() {
            while (this.f6895b < this.f6896c.f6892b && this.f6894a.hasNext()) {
                this.f6894a.next();
                this.f6895b++;
            }
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6894a;
        }

        public final int e() {
            return this.f6895b;
        }

        public final void f(int i10) {
            this.f6895b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f6895b < this.f6896c.f6893c && this.f6894a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            int i10 = this.f6895b;
            if (i10 >= this.f6896c.f6893c) {
                throw new NoSuchElementException();
            }
            this.f6895b = i10 + 1;
            return this.f6894a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(@os.l m<? extends T> mVar, int i10, int i11) {
        l0.p(mVar, "sequence");
        this.f6891a = mVar;
        this.f6892b = i10;
        this.f6893c = i11;
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("startIndex should be non-negative, but is ", i10).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(h.a.a("endIndex should be non-negative, but is ", i11).toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(e0.a.a("endIndex should be not less than startIndex, but was ", i11, " < ", i10).toString());
        }
    }

    @Override // gq.e
    @os.l
    public m<T> a(int i10) {
        return i10 >= f() ? g.f6836a : new w(this.f6891a, this.f6892b + i10, this.f6893c);
    }

    @Override // gq.e
    @os.l
    public m<T> b(int i10) {
        if (i10 >= f()) {
            return this;
        }
        m<T> mVar = this.f6891a;
        int i11 = this.f6892b;
        return new w(mVar, i11, i10 + i11);
    }

    public final int f() {
        return this.f6893c - this.f6892b;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
