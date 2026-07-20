package lm;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public final class a0 implements Comparable<a0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10166f = 255;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f10165e = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @in.f
    @os.l
    public static final a0 f10167g = b0.a();

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public a0(int i10, int i11, int i12) {
        this.f10168a = i10;
        this.f10169b = i11;
        this.f10170c = i12;
        this.f10171d = l(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@os.l a0 a0Var) {
        kn.l0.p(a0Var, "other");
        return this.f10171d - a0Var.f10171d;
    }

    public final int b() {
        return this.f10168a;
    }

    public final int d() {
        return this.f10169b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        return a0Var != null && this.f10171d == a0Var.f10171d;
    }

    public final int f() {
        return this.f10170c;
    }

    public final boolean h(int i10, int i11) {
        int i12 = this.f10168a;
        return i12 > i10 || (i12 == i10 && this.f10169b >= i11);
    }

    public int hashCode() {
        return this.f10171d;
    }

    public final boolean k(int i10, int i11, int i12) {
        int i13;
        int i14 = this.f10168a;
        return i14 > i10 || (i14 == i10 && ((i13 = this.f10169b) > i11 || (i13 == i11 && this.f10170c >= i12)));
    }

    public final int l(int i10, int i11, int i12) {
        if (new tn.l(0, 255, 1).l(i10) && new tn.l(0, 255, 1).l(i11) && new tn.l(0, 255, 1).l(i12)) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + n1.e.f11183c + i11 + n1.e.f11183c + i12).toString());
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10168a);
        sb2.append(n1.e.f11183c);
        sb2.append(this.f10169b);
        sb2.append(n1.e.f11183c);
        sb2.append(this.f10170c);
        return sb2.toString();
    }

    public a0(int i10, int i11) {
        this(i10, i11, 0);
    }
}
