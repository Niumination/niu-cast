package z0;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f21759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21760b;

    public void a(float f10) {
        float f11 = this.f21759a + f10;
        this.f21759a = f11;
        int i10 = this.f21760b + 1;
        this.f21760b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f21759a = f11 / 2.0f;
            this.f21760b = i10 / 2;
        }
    }

    public float b() {
        int i10 = this.f21760b;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f21759a / i10;
    }
}
