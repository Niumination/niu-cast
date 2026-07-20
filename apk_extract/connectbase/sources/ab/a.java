package ab;

import ae.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f194c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k8.a f196b;

    public void a(boolean z10) {
        e(b.a.f5999s).c(z10);
    }

    public int b() {
        return e(b.a.f5999s).h();
    }

    public int c() {
        return e(b.a.f5985e).g();
    }

    public int d() {
        return e(b.a.f5985e).d();
    }

    public ug.a e(String str) {
        if (b.b(str)) {
            dc.e.f(f194c, "TranThubPictureQuality");
            e eVar = this.f195a;
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e();
            this.f195a = eVar2;
            return eVar2;
        }
        dc.e.f(f194c, "TranAospPictureQuality");
        k8.a aVar = this.f196b;
        if (aVar != null) {
            return aVar;
        }
        k8.a aVar2 = new k8.a();
        this.f196b = aVar2;
        return aVar2;
    }

    public void f(int i10) {
        e(b.a.f5999s).a(i10);
    }

    public void g(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("invalid index");
        }
        if (this.f196b == null) {
            this.f196b = new k8.a();
        }
        this.f196b.e(i10);
    }

    public void h(int i10) {
        if (i10 < 0 || i10 > 2) {
            throw new IllegalArgumentException("invalid picture mode");
        }
        e(b.a.f5985e).f(i10);
    }

    public void i(int i10) {
        e(b.a.f5999s).b(i10);
    }
}
