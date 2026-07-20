package kl;

import kn.l0;
import kn.w;
import n2.k0;
import os.l;
import os.m;
import y1.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final a f9252p = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public static final d f9253v = kl.a.b(0L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final i f9257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final h f9260g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9261i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f9262n;

    public static final class a {
        public a() {
        }

        @l
        public final d a() {
            return d.f9253v;
        }

        public a(w wVar) {
        }
    }

    public d(int i10, int i11, int i12, @l i iVar, int i13, int i14, @l h hVar, int i15, long j10) {
        l0.p(iVar, "dayOfWeek");
        l0.p(hVar, o.r.f20670b);
        this.f9254a = i10;
        this.f9255b = i11;
        this.f9256c = i12;
        this.f9257d = iVar;
        this.f9258e = i13;
        this.f9259f = i14;
        this.f9260g = hVar;
        this.f9261i = i15;
        this.f9262n = j10;
    }

    public final int A() {
        return this.f9261i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@l d dVar) {
        l0.p(dVar, "other");
        return l0.u(this.f9262n, dVar.f9262n);
    }

    public final int d() {
        return this.f9254a;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9254a == dVar.f9254a && this.f9255b == dVar.f9255b && this.f9256c == dVar.f9256c && this.f9257d == dVar.f9257d && this.f9258e == dVar.f9258e && this.f9259f == dVar.f9259f && this.f9260g == dVar.f9260g && this.f9261i == dVar.f9261i && this.f9262n == dVar.f9262n;
    }

    public final int f() {
        return this.f9255b;
    }

    public final int h() {
        return this.f9256c;
    }

    public int hashCode() {
        return Long.hashCode(this.f9262n) + k0.d.a(this.f9261i, (this.f9260g.hashCode() + k0.d.a(this.f9259f, k0.d.a(this.f9258e, (this.f9257d.hashCode() + k0.d.a(this.f9256c, k0.d.a(this.f9255b, Integer.hashCode(this.f9254a) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    @l
    public final i k() {
        return this.f9257d;
    }

    public final int l() {
        return this.f9258e;
    }

    public final int m() {
        return this.f9259f;
    }

    @l
    public final h n() {
        return this.f9260g;
    }

    public final int o() {
        return this.f9261i;
    }

    public final long p() {
        return this.f9262n;
    }

    @l
    public final d q(int i10, int i11, int i12, @l i iVar, int i13, int i14, @l h hVar, int i15, long j10) {
        l0.p(iVar, "dayOfWeek");
        l0.p(hVar, o.r.f20670b);
        return new d(i10, i11, i12, iVar, i13, i14, hVar, i15, j10);
    }

    public final int s() {
        return this.f9258e;
    }

    @l
    public final i t() {
        return this.f9257d;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("GMTDate(seconds=");
        sb2.append(this.f9254a);
        sb2.append(", minutes=");
        sb2.append(this.f9255b);
        sb2.append(", hours=");
        sb2.append(this.f9256c);
        sb2.append(", dayOfWeek=");
        sb2.append(this.f9257d);
        sb2.append(", dayOfMonth=");
        sb2.append(this.f9258e);
        sb2.append(", dayOfYear=");
        sb2.append(this.f9259f);
        sb2.append(", month=");
        sb2.append(this.f9260g);
        sb2.append(", year=");
        sb2.append(this.f9261i);
        sb2.append(", timestamp=");
        return k0.a(sb2, this.f9262n, ')');
    }

    public final int u() {
        return this.f9259f;
    }

    public final int v() {
        return this.f9256c;
    }

    public final int w() {
        return this.f9255b;
    }

    @l
    public final h x() {
        return this.f9260g;
    }

    public final int y() {
        return this.f9254a;
    }

    public final long z() {
        return this.f9262n;
    }
}
