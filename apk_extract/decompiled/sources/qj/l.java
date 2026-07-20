package qj;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b0 {
    public b0 e;

    public l(b0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.e = delegate;
    }

    @Override // qj.b0
    public final b0 a() {
        return this.e.a();
    }

    @Override // qj.b0
    public final b0 b() {
        return this.e.b();
    }

    @Override // qj.b0
    public final long c() {
        return this.e.c();
    }

    @Override // qj.b0
    public final b0 d(long j8) {
        return this.e.d(j8);
    }

    @Override // qj.b0
    public final boolean e() {
        return this.e.e();
    }

    @Override // qj.b0
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // qj.b0
    public final b0 g(long j8, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.e.g(j8, unit);
    }
}
