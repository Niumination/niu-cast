package pq;

import kn.l0;
import lm.z0;
import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
@in.g
public final class p<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f13308b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final c f13309c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Object f13310a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        @in.f
        public final Throwable f13311a;

        public a(@os.m Throwable th2) {
            this.f13311a = th2;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof a) && l0.g(this.f13311a, ((a) obj).f13311a);
        }

        public int hashCode() {
            Throwable th2 = this.f13311a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // pq.p.c
        @os.l
        public String toString() {
            return "Closed(" + this.f13311a + ')';
        }
    }

    @g2
    public static final class b {
        public b() {
        }

        @g2
        @os.l
        public final <E> Object a(@os.m Throwable th2) {
            return p.c(new a(th2));
        }

        @g2
        @os.l
        public final <E> Object b() {
            return p.f13309c;
        }

        @g2
        @os.l
        public final <E> Object c(E e10) {
            return p.c(e10);
        }

        public b(kn.w wVar) {
        }
    }

    public static class c {
        @os.l
        public String toString() {
            return "Failed";
        }
    }

    @z0
    public /* synthetic */ p(Object obj) {
        this.f13310a = obj;
    }

    public static final /* synthetic */ p b(Object obj) {
        return new p(obj);
    }

    @z0
    @os.l
    public static <T> Object c(@os.m Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof p) && l0.g(obj, ((p) obj2).f13310a);
    }

    public static final boolean e(Object obj, Object obj2) {
        return l0.g(obj, obj2);
    }

    @os.m
    public static final Throwable f(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f13311a;
        }
        return null;
    }

    @z0
    public static /* synthetic */ void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final T h(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T i(Object obj) throws Throwable {
        Throwable th2;
        if (!(obj instanceof c)) {
            return obj;
        }
        if ((obj instanceof a) && (th2 = ((a) obj).f13311a) != null) {
            throw th2;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean k(Object obj) {
        return obj instanceof a;
    }

    public static final boolean l(Object obj) {
        return obj instanceof c;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof c);
    }

    @os.l
    public static String n(Object obj) {
        return obj instanceof a ? ((a) obj).toString() : em.a.a("Value(", obj, ')');
    }

    public boolean equals(Object obj) {
        return d(this.f13310a, obj);
    }

    public int hashCode() {
        return j(this.f13310a);
    }

    public final /* synthetic */ Object o() {
        return this.f13310a;
    }

    @os.l
    public String toString() {
        return n(this.f13310a);
    }
}
