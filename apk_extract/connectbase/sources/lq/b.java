package lq;

import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d0;
import lm.f0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {l.class})
public abstract class b implements s.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h f10240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final d0 f10241c;

    @r1({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:200\n*E\n"})
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final b f10243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10244c;

        public /* synthetic */ a(long j10, b bVar, long j11, w wVar) {
            this(j10, bVar, j11);
        }

        @Override // lq.r
        public long a() {
            return e.h0(m.h(this.f10243b.c(), this.f10242a, this.f10243b.f10240b), this.f10244c);
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
            if ((obj instanceof a) && l0.g(this.f10243b, ((a) obj).f10243b)) {
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
            return Long.hashCode(this.f10242a) + (e.a0(this.f10244c) * 37);
        }

        @Override // lq.d
        public int i(@os.l d dVar) {
            return d.a.a(this, dVar);
        }

        @Override // lq.d
        public long j(@os.l d dVar) {
            l0.p(dVar, "other");
            if (dVar instanceof a) {
                a aVar = (a) dVar;
                if (l0.g(this.f10243b, aVar.f10243b)) {
                    return e.i0(m.h(this.f10242a, aVar.f10242a, this.f10243b.f10240b), e.h0(this.f10244c, aVar.f10244c));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + dVar);
        }

        @os.l
        public String toString() {
            return "LongTimeMark(" + this.f10242a + k.h(this.f10243b.f10240b) + " + " + ((Object) e.v0(this.f10244c)) + ", " + this.f10243b + ')';
        }

        public a(long j10, b bVar, long j11) {
            l0.p(bVar, "timeSource");
            this.f10242a = j10;
            this.f10243b = bVar;
            this.f10244c = j11;
        }

        @Override // lq.r
        @os.l
        public d c(long j10) {
            h hVar = this.f10243b.f10240b;
            if (e.e0(j10)) {
                long jD = m.d(this.f10242a, hVar, j10);
                b bVar = this.f10243b;
                e.f10247b.getClass();
                return new a(jD, bVar, e.f10248c);
            }
            long jY0 = e.y0(j10, hVar);
            long jI0 = e.i0(e.h0(j10, jY0), this.f10244c);
            long jD2 = m.d(this.f10242a, hVar, jY0);
            long jY1 = e.y0(jI0, hVar);
            long jD3 = m.d(jD2, hVar, jY1);
            long jH0 = e.h0(jI0, jY1);
            long jP = e.P(jH0);
            if (jD3 != 0 && jP != 0 && (jD3 ^ jP) < 0) {
                long jM0 = g.m0(pn.d.V(jP), hVar);
                jD3 = m.d(jD3, hVar, jM0);
                jH0 = e.h0(jH0, jM0);
            }
            if ((1 | (jD3 - 1)) == Long.MAX_VALUE) {
                e.f10247b.getClass();
                jH0 = e.f10248c;
            }
            return new a(jD3, this.f10243b, jH0);
        }

        @Override // lq.r
        public r e(long j10) {
            return d.a.d(this, j10);
        }
    }

    /* JADX INFO: renamed from: lq.b$b, reason: collision with other inner class name */
    public static final class C0270b extends n0 implements jn.a<Long> {
        public C0270b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Long invoke() {
            return Long.valueOf(b.this.f());
        }
    }

    public b(@os.l h hVar) {
        l0.p(hVar, "unit");
        this.f10240b = hVar;
        this.f10241c = f0.b(new C0270b());
    }

    public final long c() {
        return f() - e();
    }

    @os.l
    public final h d() {
        return this.f10240b;
    }

    public final long e() {
        return ((Number) this.f10241c.getValue()).longValue();
    }

    public abstract long f();

    @Override // lq.s
    @os.l
    public d a() {
        long jC = c();
        e.f10247b.getClass();
        return new a(jC, this, e.f10248c);
    }
}
