package qj;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f9179d = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9182c;

    public b0 a() {
        this.f9180a = false;
        return this;
    }

    public b0 b() {
        this.f9182c = 0L;
        return this;
    }

    public long c() {
        if (this.f9180a) {
            return this.f9181b;
        }
        throw new IllegalStateException("No deadline");
    }

    public b0 d(long j8) {
        this.f9180a = true;
        this.f9181b = j8;
        return this;
    }

    public boolean e() {
        return this.f9180a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f9180a && this.f9181b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public b0 g(long j8, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("timeout < 0: ", j8).toString());
        }
        this.f9182c = unit.toNanos(j8);
        return this;
    }
}
