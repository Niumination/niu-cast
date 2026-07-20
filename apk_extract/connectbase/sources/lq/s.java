package lq;

import kn.l0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {l.class})
public interface s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f10265a = a.f10266a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10266a = new a();
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final b f10267b = new b();

        @Override // lq.s.c, lq.s
        public d a() {
            return new a(p.f10262b.e());
        }

        public long b() {
            return p.f10262b.e();
        }

        @os.l
        public String toString() {
            p.f10262b.getClass();
            return "TimeSource(System.nanoTime())";
        }

        @in.g
        @p2(markerClass = {l.class})
        @f1(version = "1.9")
        public static final class a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f10268a;

            public /* synthetic */ a(long j10) {
                this.f10268a = j10;
            }

            public static final /* synthetic */ a f(long j10) {
                return new a(j10);
            }

            public static final int h(long j10, long j11) {
                long jS = s(j10, j11);
                e.f10247b.getClass();
                return e.m(jS, e.f10248c);
            }

            public static int k(long j10, @os.l d dVar) {
                l0.p(dVar, "other");
                return d.a.a(new a(j10), dVar);
            }

            public static long l(long j10) {
                return j10;
            }

            public static long m(long j10) {
                return p.f10262b.d(j10);
            }

            public static boolean n(long j10, Object obj) {
                return (obj instanceof a) && j10 == ((a) obj).f10268a;
            }

            public static final boolean o(long j10, long j11) {
                return j10 == j11;
            }

            public static boolean p(long j10) {
                return e.f0(p.f10262b.d(j10));
            }

            public static boolean q(long j10) {
                return !e.f0(p.f10262b.d(j10));
            }

            public static int r(long j10) {
                return Long.hashCode(j10);
            }

            public static final long s(long j10, long j11) {
                p.f10262b.getClass();
                return m.h(j10, j11, h.NANOSECONDS);
            }

            public static long u(long j10, long j11) {
                p pVar = p.f10262b;
                long jZ0 = e.z0(j11);
                pVar.getClass();
                return m.d(j10, h.NANOSECONDS, jZ0);
            }

            public static long v(long j10, @os.l d dVar) {
                l0.p(dVar, "other");
                if (dVar instanceof a) {
                    return s(j10, ((a) dVar).f10268a);
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) y(j10)) + " and " + dVar);
            }

            public static long x(long j10, long j11) {
                p.f10262b.getClass();
                return m.d(j10, h.NANOSECONDS, j11);
            }

            public static String y(long j10) {
                return "ValueTimeMark(reading=" + j10 + ')';
            }

            @Override // lq.r
            public long a() {
                return p.f10262b.d(this.f10268a);
            }

            @Override // lq.r
            public boolean b() {
                return q(this.f10268a);
            }

            @Override // lq.d, lq.r
            public d c(long j10) {
                return new a(x(this.f10268a, j10));
            }

            @Override // java.lang.Comparable
            public int compareTo(d dVar) {
                return d.a.a(this, dVar);
            }

            @Override // lq.r
            public boolean d() {
                return p(this.f10268a);
            }

            @Override // lq.d, lq.r
            public d e(long j10) {
                return new a(u(this.f10268a, j10));
            }

            @Override // lq.d
            public boolean equals(Object obj) {
                return n(this.f10268a, obj);
            }

            @Override // lq.d
            public int hashCode() {
                return Long.hashCode(this.f10268a);
            }

            @Override // lq.d
            public int i(@os.l d dVar) {
                return d.a.a(this, dVar);
            }

            @Override // lq.d
            public long j(@os.l d dVar) {
                l0.p(dVar, "other");
                return v(this.f10268a, dVar);
            }

            public long t(long j10) {
                return u(this.f10268a, j10);
            }

            public String toString() {
                return y(this.f10268a);
            }

            public long w(long j10) {
                return x(this.f10268a, j10);
            }

            public final /* synthetic */ long z() {
                return this.f10268a;
            }

            @Override // lq.r
            public r c(long j10) {
                return new a(x(this.f10268a, j10));
            }

            @Override // lq.r
            public r e(long j10) {
                return new a(u(this.f10268a, j10));
            }
        }

        @Override // lq.s
        public r a() {
            return new a(p.f10262b.e());
        }
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    public interface c extends s {
        @Override // lq.s
        @os.l
        d a();
    }

    @os.l
    r a();
}
