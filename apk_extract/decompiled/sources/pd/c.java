package pd;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f8725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8727d;
    public int e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f8724a, cVar.f8724a) == 0 && Float.compare(this.f8725b, cVar.f8725b) == 0 && this.f8726c == cVar.f8726c && this.f8727d == cVar.f8727d && this.e == cVar.e;
    }

    public final float getDensity() {
        return this.f8724a;
    }

    public final int getDensityDpi() {
        return this.f8726c;
    }

    public final float getScaledDensity() {
        return this.f8725b;
    }

    public final int getScreenHeightDp() {
        return this.e;
    }

    public final int getScreenWidthDp() {
        return this.f8727d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.e) + a1.a.c(this.f8727d, a1.a.c(this.f8726c, (Float.hashCode(this.f8725b) + (Float.hashCode(this.f8724a) * 31)) * 31, 31), 31);
    }

    public final void setDensity(float f) {
        this.f8724a = f;
    }

    public final void setDensityDpi(int i8) {
        this.f8726c = i8;
    }

    public final void setScaledDensity(float f) {
        this.f8725b = f;
    }

    public final void setScreenHeightDp(int i8) {
        this.e = i8;
    }

    public final void setScreenWidthDp(int i8) {
        this.f8727d = i8;
    }

    public final String toString() {
        float f = this.f8724a;
        float f4 = this.f8725b;
        int i8 = this.f8726c;
        int i9 = this.f8727d;
        int i10 = this.e;
        StringBuilder sb2 = new StringBuilder("Config(density=");
        sb2.append(f);
        sb2.append(", scaledDensity=");
        sb2.append(f4);
        sb2.append(", densityDpi=");
        sb2.append(i8);
        sb2.append(", screenWidthDp=");
        sb2.append(i9);
        sb2.append(", screenHeightDp=");
        return h0.a.m(sb2, ")", i10);
    }
}
