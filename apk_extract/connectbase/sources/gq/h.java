package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class h<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<T, Boolean> f6839c;

    public static final class a implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<T> f6840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6841b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public T f6842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h<T> f6843d;

        public a(h<T> hVar) {
            this.f6843d = hVar;
            this.f6840a = hVar.f6837a.iterator();
        }

        public final void a() {
            while (this.f6840a.hasNext()) {
                T next = this.f6840a.next();
                if (this.f6843d.f6839c.invoke(next).booleanValue() == this.f6843d.f6838b) {
                    this.f6842c = next;
                    this.f6841b = 1;
                    return;
                }
            }
            this.f6841b = 0;
        }

        @os.l
        public final Iterator<T> c() {
            return this.f6840a;
        }

        @os.m
        public final T e() {
            return this.f6842c;
        }

        public final int f() {
            return this.f6841b;
        }

        public final void g(@os.m T t10) {
            this.f6842c = t10;
        }

        public final void h(int i10) {
            this.f6841b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6841b == -1) {
                a();
            }
            return this.f6841b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f6841b == -1) {
                a();
            }
            if (this.f6841b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f6842c;
            this.f6842c = null;
            this.f6841b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l m<? extends T> mVar, boolean z10, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "sequence");
        l0.p(lVar, "predicate");
        this.f6837a = mVar;
        this.f6838b = z10;
        this.f6839c = lVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }

    public /* synthetic */ h(m mVar, boolean z10, jn.l lVar, int i10, kn.w wVar) {
        this(mVar, (i10 & 2) != 0 ? true : z10, lVar);
    }
}
