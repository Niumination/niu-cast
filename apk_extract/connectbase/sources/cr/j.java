package cr;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class j extends b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b0 f3420e;

    public j(b0 b0Var) {
        if (b0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3420e = b0Var;
    }

    @Override // cr.b0
    public b0 a() {
        return this.f3420e.a();
    }

    @Override // cr.b0
    public b0 b() {
        return this.f3420e.b();
    }

    @Override // cr.b0
    public long d() {
        return this.f3420e.d();
    }

    @Override // cr.b0
    public b0 e(long j10) {
        return this.f3420e.e(j10);
    }

    @Override // cr.b0
    public boolean f() {
        return this.f3420e.f();
    }

    @Override // cr.b0
    public void h() throws IOException {
        this.f3420e.h();
    }

    @Override // cr.b0
    public b0 i(long j10, TimeUnit timeUnit) {
        return this.f3420e.i(j10, timeUnit);
    }

    @Override // cr.b0
    public long j() {
        return this.f3420e.j();
    }

    public final b0 l() {
        return this.f3420e;
    }

    public final j m(b0 b0Var) {
        if (b0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3420e = b0Var;
        return this;
    }
}
