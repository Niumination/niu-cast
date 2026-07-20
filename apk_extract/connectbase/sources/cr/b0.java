package cr;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import nq.v1;

/* JADX INFO: loaded from: classes3.dex */
public class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f3397d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3400c;

    public class a extends b0 {
        @Override // cr.b0
        public b0 e(long j10) {
            return this;
        }

        @Override // cr.b0
        public void h() throws IOException {
        }

        @Override // cr.b0
        public b0 i(long j10, TimeUnit timeUnit) {
            return this;
        }
    }

    public static long g(long j10, long j11) {
        if (j10 == 0) {
            return j11;
        }
        return (j11 != 0 && j10 >= j11) ? j11 : j10;
    }

    public b0 a() {
        this.f3398a = false;
        return this;
    }

    public b0 b() {
        this.f3400c = 0L;
        return this;
    }

    public final b0 c(long j10, TimeUnit timeUnit) {
        if (j10 <= 0) {
            throw new IllegalArgumentException(h0.b.a("duration <= 0: ", j10));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        return e(timeUnit.toNanos(j10) + System.nanoTime());
    }

    public long d() {
        if (this.f3398a) {
            return this.f3399b;
        }
        throw new IllegalStateException("No deadline");
    }

    public b0 e(long j10) {
        this.f3398a = true;
        this.f3399b = j10;
        return this;
    }

    public boolean f() {
        return this.f3398a;
    }

    public void h() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3398a && this.f3399b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public b0 i(long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("timeout < 0: ", j10));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.f3400c = timeUnit.toNanos(j10);
        return this;
    }

    public long j() {
        return this.f3400c;
    }

    public final void k(Object obj) throws InterruptedIOException {
        try {
            boolean zF = f();
            long j10 = j();
            long jNanoTime = 0;
            if (!zF && j10 == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && j10 != 0) {
                j10 = Math.min(j10, d() - jNanoTime2);
            } else if (zF) {
                j10 = d() - jNanoTime2;
            }
            if (j10 > 0) {
                long j11 = j10 / v1.f11967e;
                obj.wait(j11, (int) (j10 - (v1.f11967e * j11)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= j10) {
                throw new InterruptedIOException(RtspHeaders.Values.TIMEOUT);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
