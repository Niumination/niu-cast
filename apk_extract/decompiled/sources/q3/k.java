package q3;

import af.d2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class k extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8957a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d2 f8958b = new d2(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f8960d;
    public Object e;
    public Exception f;

    @Override // q3.f
    public final Exception a() {
        Exception exc;
        synchronized (this.f8957a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // q3.f
    public final Object b() {
        Object obj;
        synchronized (this.f8957a) {
            try {
                l.g(this.f8959c, "Task is not yet complete");
                if (this.f8960d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new e(exc);
                }
                obj = this.e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    @Override // q3.f
    public final boolean c() {
        boolean z2;
        synchronized (this.f8957a) {
            z2 = this.f8959c;
        }
        return z2;
    }

    @Override // q3.f
    public final boolean d() {
        boolean z2;
        synchronized (this.f8957a) {
            try {
                z2 = false;
                if (this.f8959c && !this.f8960d && this.f == null) {
                    z2 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }

    public final k e(Executor executor, c cVar) {
        this.f8958b.k(new i(executor, cVar));
        j();
        return this;
    }

    public final void f(Exception exc) {
        l.f(exc, "Exception must not be null");
        synchronized (this.f8957a) {
            if (this.f8959c) {
                throw a.of(this);
            }
            this.f8959c = true;
            this.f = exc;
        }
        this.f8958b.l(this);
    }

    public final void g(Object obj) {
        synchronized (this.f8957a) {
            if (this.f8959c) {
                throw a.of(this);
            }
            this.f8959c = true;
            this.e = obj;
        }
        this.f8958b.l(this);
    }

    public final void h() {
        synchronized (this.f8957a) {
            try {
                if (this.f8959c) {
                    return;
                }
                this.f8959c = true;
                this.f8960d = true;
                this.f8958b.l(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean i(Object obj) {
        synchronized (this.f8957a) {
            try {
                if (this.f8959c) {
                    return false;
                }
                this.f8959c = true;
                this.e = obj;
                this.f8958b.l(this);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void j() {
        synchronized (this.f8957a) {
            try {
                if (this.f8959c) {
                    this.f8958b.l(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
