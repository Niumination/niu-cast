package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public final class f4 {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r4 f4875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4876b;

        public <E> e4<E> a() {
            if (!this.f4876b) {
                this.f4875a.l();
            }
            return new d(this.f4875a);
        }

        public b b(int concurrencyLevel) {
            this.f4875a.a(concurrencyLevel);
            return this;
        }

        public b c() {
            this.f4876b = true;
            return this;
        }

        @b1.c("java.lang.ref.WeakReference")
        public b d() {
            this.f4876b = false;
            return this;
        }

        public b() {
            this.f4875a = new r4();
            this.f4876b = true;
        }
    }

    public static class c<E> implements c1.t<E, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e4<E> f4877a;

        public c(e4<E> interner) {
            this.f4877a = interner;
        }

        @Override // c1.t
        public E apply(E input) {
            return this.f4877a.a(input);
        }

        @Override // c1.t
        public boolean equals(@gm.a Object other) {
            if (other instanceof c) {
                return this.f4877a.equals(((c) other).f4877a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4877a.hashCode();
        }
    }

    @b1.e
    public static final class d<E> implements e4<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @b1.e
        public final s4<E, r4.a, ?, ?> f4878a;

        @Override // f1.e4
        public E a(E e10) {
            E e11;
            do {
                s4.j entry = this.f4878a.getEntry(e10);
                if (entry != null && (e11 = (E) entry.getKey()) != null) {
                    return e11;
                }
            } while (this.f4878a.putIfAbsent(e10, r4.a.VALUE) != null);
            return e10;
        }

        public d(r4 mapMaker) {
            this.f4878a = s4.createWithDummyValues(mapMaker.h(c1.m.equals()));
        }
    }

    public static <E> c1.t<E, E> a(e4<E> interner) {
        interner.getClass();
        return new c(interner);
    }

    public static b b() {
        return new b();
    }

    public static <E> e4<E> c() {
        b bVar = new b();
        bVar.f4876b = true;
        return bVar.a();
    }

    @b1.c("java.lang.ref.WeakReference")
    public static <E> e4<E> d() {
        b bVar = new b();
        bVar.f4876b = false;
        return bVar.a();
    }
}
