package x5;

import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20046f;

    public a(int i10, float f10, float f11, int i11, int i12, int i13) {
        this.f20041a = i10;
        this.f20042b = f10;
        this.f20043c = f11;
        this.f20044d = i11;
        this.f20045e = i12;
        this.f20046f = i13;
    }

    public int a() {
        return this.f20041a;
    }

    public int b() {
        return this.f20044d;
    }

    public int c() {
        return this.f20045e;
    }

    public float d() {
        return this.f20042b;
    }

    public float e() {
        return this.f20043c;
    }

    public int f() {
        return this.f20046f;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GameKeymapEventBean{action=");
        sb2.append(this.f20041a);
        sb2.append(", x=");
        sb2.append(this.f20042b);
        sb2.append(", y=");
        sb2.append(this.f20043c);
        sb2.append(", displayId=");
        sb2.append(this.f20044d);
        sb2.append(", id=");
        sb2.append(this.f20045e);
        sb2.append(", zDelta=");
        return u.a.a(sb2, this.f20046f, f.f14860b);
    }
}
