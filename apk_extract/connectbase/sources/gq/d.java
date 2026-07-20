package gq;

import java.util.Iterator;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class d<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6827b;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6829b;

        public a(d<T> dVar) {
            this.f6828a = dVar.f6826a.iterator();
            this.f6829b = dVar.f6827b;
        }

        public final void a() {
            while (this.f6829b > 0 && this.f6828a.hasNext()) {
                this.f6828a.next();
                this.f6829b--;
            }
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6828a;
        }

        public final int e() {
            return this.f6829b;
        }

        public final void f(int i10) {
            this.f6829b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f6828a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f6828a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@os.l m<? extends T> mVar, int i10) {
        l0.p(mVar, "sequence");
        this.f6826a = mVar;
        this.f6827b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + n1.e.f11183c).toString());
    }

    @Override // gq.e
    @os.l
    public m<T> a(int i10) {
        int i11 = this.f6827b + i10;
        return i11 < 0 ? new d(this, i10) : new d(this.f6826a, i11);
    }

    @Override // gq.e
    @os.l
    public m<T> b(int i10) {
        int i11 = this.f6827b;
        int i12 = i11 + i10;
        return i12 < 0 ? new x(this, i10) : new w(this.f6826a, i11, i12);
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }
}
