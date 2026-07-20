package fq;

/* JADX INFO: loaded from: classes3.dex */
public final class c<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c<Object> f6331f = new c<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f6333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<V> f6334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<V> f6335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6336e;

    public c() {
        this.f6336e = 0;
        this.f6332a = 0L;
        this.f6333b = null;
        this.f6334c = null;
        this.f6335d = null;
    }

    public static <V> c<V> e(long j10, V v10, c<V> cVar, c<V> cVar2) {
        int i10 = cVar.f6336e;
        int i11 = cVar2.f6336e;
        if (i10 + i11 > 1) {
            if (i10 >= i11 * 5) {
                c<V> cVar3 = cVar.f6334c;
                c<V> cVar4 = cVar.f6335d;
                if (cVar4.f6336e < cVar3.f6336e * 2) {
                    long j11 = cVar.f6332a;
                    return new c<>(j11 + j10, cVar.f6333b, cVar3, new c(-j11, v10, cVar4.g(cVar4.f6332a + j11), cVar2));
                }
                c<V> cVar5 = cVar4.f6334c;
                c<V> cVar6 = cVar4.f6335d;
                long j12 = cVar4.f6332a;
                long j13 = cVar.f6332a + j12 + j10;
                V v11 = cVar4.f6333b;
                c cVar7 = new c(-j12, cVar.f6333b, cVar3, cVar5.g(cVar5.f6332a + j12));
                long j14 = cVar.f6332a;
                long j15 = cVar4.f6332a;
                return new c<>(j13, v11, cVar7, new c((-j14) - j15, v10, cVar6.g(cVar6.f6332a + j15 + j14), cVar2));
            }
            if (i11 >= i10 * 5) {
                c<V> cVar8 = cVar2.f6334c;
                c<V> cVar9 = cVar2.f6335d;
                if (cVar8.f6336e < cVar9.f6336e * 2) {
                    long j16 = cVar2.f6332a;
                    return new c<>(j16 + j10, cVar2.f6333b, new c(-j16, v10, cVar, cVar8.g(cVar8.f6332a + j16)), cVar9);
                }
                c<V> cVar10 = cVar8.f6334c;
                c<V> cVar11 = cVar8.f6335d;
                long j17 = cVar8.f6332a;
                long j18 = cVar2.f6332a;
                long j19 = j17 + j18 + j10;
                V v12 = cVar8.f6333b;
                c cVar12 = new c((-j18) - j17, v10, cVar, cVar10.g(cVar10.f6332a + j17 + j18));
                long j20 = cVar8.f6332a;
                return new c<>(j19, v12, cVar12, new c(-j20, cVar2.f6333b, cVar11.g(cVar11.f6332a + j20), cVar9));
            }
        }
        return new c<>(j10, v10, cVar, cVar2);
    }

    public V a(long j10) {
        if (this.f6336e == 0) {
            return null;
        }
        long j11 = this.f6332a;
        if (j10 < j11) {
            return this.f6334c.a(j10 - j11);
        }
        return j10 > j11 ? this.f6335d.a(j10 - j11) : this.f6333b;
    }

    public final long b() {
        c<V> cVar = this.f6334c;
        return cVar.f6336e == 0 ? this.f6332a : cVar.b() + this.f6332a;
    }

    public c<V> c(long j10) {
        if (this.f6336e == 0) {
            return this;
        }
        long j11 = this.f6332a;
        if (j10 < j11) {
            return f(this.f6334c.c(j10 - j11), this.f6335d);
        }
        if (j10 > j11) {
            return f(this.f6334c, this.f6335d.c(j10 - j11));
        }
        c<V> cVar = this.f6334c;
        if (cVar.f6336e == 0) {
            c<V> cVar2 = this.f6335d;
            return cVar2.g(cVar2.f6332a + j11);
        }
        c<V> cVar3 = this.f6335d;
        if (cVar3.f6336e == 0) {
            return cVar.g(cVar.f6332a + j11);
        }
        long jB = cVar3.b();
        long j12 = this.f6332a;
        long j13 = jB + j12;
        V vA = this.f6335d.a(j13 - j12);
        c<V> cVarC = this.f6335d.c(j13 - this.f6332a);
        c<V> cVarG = cVarC.g((cVarC.f6332a + this.f6332a) - j13);
        c<V> cVar4 = this.f6334c;
        return e(j13, vA, cVar4.g((cVar4.f6332a + this.f6332a) - j13), cVarG);
    }

    public c<V> d(long j10, V v10) {
        if (this.f6336e == 0) {
            return new c<>(j10, v10, this, this);
        }
        long j11 = this.f6332a;
        if (j10 < j11) {
            return f(this.f6334c.d(j10 - j11, v10), this.f6335d);
        }
        if (j10 > j11) {
            return f(this.f6334c, this.f6335d.d(j10 - j11, v10));
        }
        return v10 == this.f6333b ? this : new c<>(j10, v10, this.f6334c, this.f6335d);
    }

    public final c<V> f(c<V> cVar, c<V> cVar2) {
        return (cVar == this.f6334c && cVar2 == this.f6335d) ? this : e(this.f6332a, this.f6333b, cVar, cVar2);
    }

    public final c<V> g(long j10) {
        return (this.f6336e == 0 || j10 == this.f6332a) ? this : new c<>(j10, this.f6333b, this.f6334c, this.f6335d);
    }

    public c(long j10, V v10, c<V> cVar, c<V> cVar2) {
        this.f6332a = j10;
        this.f6333b = v10;
        this.f6334c = cVar;
        this.f6335d = cVar2;
        this.f6336e = cVar.f6336e + 1 + cVar2.f6336e;
    }
}
