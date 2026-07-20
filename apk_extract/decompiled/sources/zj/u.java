package zj;

import java.io.IOException;
import k3.sc;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends dj.m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.m0 f11704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.t f11705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IOException f11706d;

    public u(dj.m0 m0Var) {
        this.f11704b = m0Var;
        this.f11705c = sc.b(new t(this, m0Var.g()));
    }

    @Override // dj.m0
    public final long a() {
        return this.f11704b.a();
    }

    @Override // dj.m0
    public final dj.x c() {
        return this.f11704b.c();
    }

    @Override // dj.m0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11704b.close();
    }

    @Override // dj.m0
    public final qj.h g() {
        return this.f11705c;
    }
}
