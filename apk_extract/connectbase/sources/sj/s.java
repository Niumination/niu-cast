package sj;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15098d;

    public s(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f15095a = z10;
        this.f15096b = z11;
        this.f15097c = z12;
        this.f15098d = z13;
    }

    public static s a() {
        return new s(false, false, false, true);
    }

    public static s b() {
        return new s(true, true, true, true);
    }

    public boolean c() {
        return this.f15096b;
    }

    public boolean d() {
        return this.f15097c;
    }

    public boolean e() {
        return this.f15098d;
    }

    public boolean f() {
        return this.f15095a;
    }

    public s g(boolean z10) {
        return z10 == this.f15096b ? this : new s(this.f15095a, z10, this.f15097c, this.f15098d);
    }

    public s h(boolean z10) {
        return z10 == this.f15097c ? this : new s(this.f15095a, this.f15096b, z10, this.f15098d);
    }

    public s i(boolean z10) {
        return z10 == this.f15098d ? this : new s(this.f15095a, this.f15096b, this.f15097c, z10);
    }

    public s j(boolean z10) {
        return z10 == this.f15095a ? this : new s(z10, this.f15096b, this.f15097c, this.f15098d);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConfigRenderOptions(");
        if (this.f15095a) {
            sb2.append("originComments,");
        }
        if (this.f15096b) {
            sb2.append("comments,");
        }
        if (this.f15097c) {
            sb2.append("formatted,");
        }
        if (this.f15098d) {
            sb2.append("json,");
        }
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.setLength(sb2.length() - 1);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
