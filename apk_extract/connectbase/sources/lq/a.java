package lq;

import kn.l0;
import kn.w;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@lm.k(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@l
public abstract class a implements s.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h f10236b;

    /* JADX INFO: renamed from: lq.a$a, reason: collision with other inner class name */
    public static final class C0269a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f10237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final a f10238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10239c;

        public /* synthetic */ C0269a(double d10, a aVar, long j10, w wVar) {
            this(d10, aVar, j10);
        }

        @Override // lq.r
        public long a() {
            return e.h0(g.l0(this.f10238b.c() - this.f10237a, this.f10238b.f10236b), this.f10239c);
        }

        @Override // lq.r
        public boolean b() {
            return r.a.b(this);
        }

        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            return d.a.a(this, dVar);
        }

        @Override // lq.r
        public boolean d() {
            return r.a.a(this);
        }

        @Override // lq.d, lq.r
        @os.l
        public d e(long j10) {
            return d.a.d(this, j10);
        }

        @Override // lq.d
        public boolean equals(@os.m Object obj) {
            if ((obj instanceof C0269a) && l0.g(this.f10238b, ((C0269a) obj).f10238b)) {
                long j10 = j((d) obj);
                e.f10247b.getClass();
                if (e.s(j10, e.f10248c)) {
                    return true;
                }
            }
            return false;
        }

        @Override // lq.d
        public int hashCode() {
            return Long.hashCode(e.i0(g.l0(this.f10237a, this.f10238b.f10236b), this.f10239c));
        }

        @Override // lq.d
        public int i(@os.l d dVar) {
            return d.a.a(this, dVar);
        }

        @Override // lq.d
        public long j(@os.l d dVar) {
            l0.p(dVar, "other");
            if (dVar instanceof C0269a) {
                C0269a c0269a = (C0269a) dVar;
                if (l0.g(this.f10238b, c0269a.f10238b)) {
                    if (e.s(this.f10239c, c0269a.f10239c) && e.e0(this.f10239c)) {
                        e.f10247b.getClass();
                        return e.f10248c;
                    }
                    long jH0 = e.h0(this.f10239c, c0269a.f10239c);
                    long jL0 = g.l0(this.f10237a - c0269a.f10237a, this.f10238b.f10236b);
                    if (!e.s(jL0, e.z0(jH0))) {
                        return e.i0(jL0, jH0);
                    }
                    e.f10247b.getClass();
                    return e.f10248c;
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + dVar);
        }

        @os.l
        public String toString() {
            return "DoubleTimeMark(" + this.f10237a + k.h(this.f10238b.f10236b) + " + " + ((Object) e.v0(this.f10239c)) + ", " + this.f10238b + ')';
        }

        public C0269a(double d10, a aVar, long j10) {
            l0.p(aVar, "timeSource");
            this.f10237a = d10;
            this.f10238b = aVar;
            this.f10239c = j10;
        }

        @Override // lq.r
        @os.l
        public d c(long j10) {
            return new C0269a(this.f10237a, this.f10238b, e.i0(this.f10239c, j10));
        }

        @Override // lq.r
        public r e(long j10) {
            return d.a.d(this, j10);
        }
    }

    public a(@os.l h hVar) {
        l0.p(hVar, "unit");
        this.f10236b = hVar;
    }

    @os.l
    public final h b() {
        return this.f10236b;
    }

    public abstract double c();

    @Override // lq.s
    @os.l
    public d a() {
        double dC = c();
        e.f10247b.getClass();
        return new C0269a(dC, this, e.f10248c);
    }
}
