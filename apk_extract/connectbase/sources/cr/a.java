package cr;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import nq.v1;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3384h = 65536;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f3385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f3386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.j
    public static a f3387k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.j
    public a f3389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3390g;

    /* JADX INFO: renamed from: cr.a$a, reason: collision with other inner class name */
    public class C0079a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f3391a;

        public C0079a(z zVar) {
            this.f3391a = zVar;
        }

        @Override // cr.z
        public void Z0(cr.c cVar, long j10) throws IOException {
            d0.b(cVar.f3404b, 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                w wVar = cVar.f3403a;
                while (j11 < 65536) {
                    j11 += (long) (wVar.f3488c - wVar.f3487b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    wVar = wVar.f3491f;
                }
                a.this.n();
                try {
                    try {
                        this.f3391a.Z0(cVar, j11);
                        j10 -= j11;
                        a.this.p(true);
                    } catch (IOException e10) {
                        throw a.this.o(e10);
                    }
                } catch (Throwable th2) {
                    a.this.p(false);
                    throw th2;
                }
            }
        }

        @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.n();
            try {
                try {
                    this.f3391a.close();
                    a.this.p(true);
                } catch (IOException e10) {
                    throw a.this.o(e10);
                }
            } catch (Throwable th2) {
                a.this.p(false);
                throw th2;
            }
        }

        @Override // cr.z
        public b0 f() {
            return a.this;
        }

        @Override // cr.z, java.io.Flushable
        public void flush() throws IOException {
            a.this.n();
            try {
                try {
                    this.f3391a.flush();
                    a.this.p(true);
                } catch (IOException e10) {
                    throw a.this.o(e10);
                }
            } catch (Throwable th2) {
                a.this.p(false);
                throw th2;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f3391a + ")";
        }
    }

    public class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f3393a;

        public b(a0 a0Var) {
            this.f3393a = a0Var;
        }

        @Override // cr.a0
        public long Y0(cr.c cVar, long j10) throws IOException {
            a.this.n();
            try {
                try {
                    long jY0 = this.f3393a.Y0(cVar, j10);
                    a.this.p(true);
                    return jY0;
                } catch (IOException e10) {
                    throw a.this.o(e10);
                }
            } catch (Throwable th2) {
                a.this.p(false);
                throw th2;
            }
        }

        @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.n();
            try {
                try {
                    this.f3393a.close();
                    a.this.p(true);
                } catch (IOException e10) {
                    throw a.this.o(e10);
                }
            } catch (Throwable th2) {
                a.this.p(false);
                throw th2;
            }
        }

        @Override // cr.a0
        public b0 f() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f3393a + ")";
        }
    }

    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0017, code lost:
        
            r0.w();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r2 = this;
            L0:
                java.lang.Class<cr.a> r2 = cr.a.class
                monitor-enter(r2)     // Catch: java.lang.InterruptedException -> L0
                cr.a r0 = cr.a.l()     // Catch: java.lang.Throwable -> Lb
                if (r0 != 0) goto Ld
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r0 = move-exception
                goto L1b
            Ld:
                cr.a r1 = cr.a.f3387k     // Catch: java.lang.Throwable -> Lb
                if (r0 != r1) goto L16
                r0 = 0
                cr.a.f3387k = r0     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                r0.w()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                throw r0     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: cr.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f3385i = millis;
        f3386j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @gm.j
    public static a l() throws InterruptedException {
        a aVar = f3387k.f3389f;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(f3385i);
            if (f3387k.f3389f != null || System.nanoTime() - jNanoTime < f3386j) {
                return null;
            }
            return f3387k;
        }
        long jNanoTime2 = aVar.f3390g - System.nanoTime();
        if (jNanoTime2 > 0) {
            long j10 = jNanoTime2 / v1.f11967e;
            a.class.wait(j10, (int) (jNanoTime2 - (v1.f11967e * j10)));
            return null;
        }
        f3387k.f3389f = aVar.f3389f;
        aVar.f3389f = null;
        return aVar;
    }

    public static synchronized boolean m(a aVar) {
        a aVar2 = f3387k;
        while (aVar2 != null) {
            a aVar3 = aVar2.f3389f;
            if (aVar3 == aVar) {
                aVar2.f3389f = aVar.f3389f;
                aVar.f3389f = null;
                return false;
            }
            aVar2 = aVar3;
        }
        return true;
    }

    public static synchronized void t(a aVar, long j10, boolean z10) {
        a aVar2;
        try {
            if (f3387k == null) {
                f3387k = new a();
                new c().start();
            }
            long jNanoTime = System.nanoTime();
            if (j10 != 0 && z10) {
                aVar.f3390g = Math.min(j10, aVar.d() - jNanoTime) + jNanoTime;
            } else if (j10 != 0) {
                aVar.f3390g = j10 + jNanoTime;
            } else {
                if (!z10) {
                    throw new AssertionError();
                }
                aVar.f3390g = aVar.d();
            }
            long j11 = aVar.f3390g - jNanoTime;
            a aVar3 = f3387k;
            while (true) {
                aVar2 = aVar3.f3389f;
                if (aVar2 == null || j11 < aVar2.f3390g - jNanoTime) {
                    break;
                    break;
                }
                aVar3 = aVar2;
            }
            aVar.f3389f = aVar2;
            aVar3.f3389f = aVar;
            if (aVar3 == f3387k) {
                a.class.notify();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n() {
        if (this.f3388e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long j10 = j();
        boolean zF = f();
        if (j10 != 0 || zF) {
            this.f3388e = true;
            t(this, j10, zF);
        }
    }

    public final IOException o(IOException iOException) throws IOException {
        return !q() ? iOException : r(iOException);
    }

    public final void p(boolean z10) throws IOException {
        if (q() && z10) {
            throw r(null);
        }
    }

    public final boolean q() {
        if (!this.f3388e) {
            return false;
        }
        this.f3388e = false;
        return m(this);
    }

    public IOException r(@gm.j IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(RtspHeaders.Values.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long s(long j10) {
        return this.f3390g - j10;
    }

    public final z u(z zVar) {
        return new C0079a(zVar);
    }

    public final a0 v(a0 a0Var) {
        return new b(a0Var);
    }

    public void w() {
    }
}
