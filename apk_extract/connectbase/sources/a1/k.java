package a1;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f36a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f37b;

    public k(float f10, float f11) {
        this.f36a = f10;
        this.f37b = f11;
    }

    public boolean a(float f10, float f11) {
        return this.f36a == f10 && this.f37b == f11;
    }

    public float b() {
        return this.f36a;
    }

    public float c() {
        return this.f37b;
    }

    public void d(float f10, float f11) {
        this.f36a = f10;
        this.f37b = f11;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public k() {
        this(1.0f, 1.0f);
    }
}
