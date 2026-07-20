package d6;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4364d;

    public v(int i8, int i9, int i10, int i11) {
        this.f4361a = i8;
        this.f4362b = i9;
        this.f4363c = i10;
        this.f4364d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f4361a == vVar.f4361a && this.f4362b == vVar.f4362b && this.f4363c == vVar.f4363c && this.f4364d == vVar.f4364d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4364d) + a1.a.c(this.f4363c, a1.a.c(this.f4362b, Integer.hashCode(this.f4361a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PointRect(x=");
        sb2.append(this.f4361a);
        sb2.append(", y=");
        sb2.append(this.f4362b);
        sb2.append(", w=");
        sb2.append(this.f4363c);
        sb2.append(", h=");
        return a1.a.r(sb2, this.f4364d, ')');
    }
}
