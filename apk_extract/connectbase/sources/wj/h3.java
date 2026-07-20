package wj;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class h3 extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1.b f18723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18724b;

    public h3(t1.b bVar) {
        this.f18723a = bVar;
    }

    @Override // wj.p0, wj.t1.b
    public void a(k3.a aVar) {
        if (!this.f18724b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            v0.e((Closeable) aVar);
        }
    }

    @Override // wj.p0, wj.t1.b
    public void c(Throwable th2) {
        this.f18724b = true;
        super.c(th2);
    }

    @Override // wj.p0
    public t1.b d() {
        return this.f18723a;
    }

    @Override // wj.p0, wj.t1.b
    public void e(boolean z10) {
        this.f18724b = true;
        super.e(z10);
    }
}
