package gq;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class z<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<Integer, T, R> f6908b;

    public static final class a implements Iterator<R>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z<T, R> f6911c;

        public a(z<T, R> zVar) {
            this.f6911c = zVar;
            this.f6909a = zVar.f6907a.iterator();
        }

        public final int a() {
            return this.f6910b;
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6909a;
        }

        public final void e(int i10) {
            this.f6910b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6909a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            jn.p<Integer, T, R> pVar = this.f6911c.f6908b;
            int i10 = this.f6910b;
            this.f6910b = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            return (R) pVar.invoke(Integer.valueOf(i10), this.f6909a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(@os.l m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        l0.p(mVar, "sequence");
        l0.p(pVar, "transformer");
        this.f6907a = mVar;
        this.f6908b = pVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<R> iterator() {
        return new a(this);
    }
}
