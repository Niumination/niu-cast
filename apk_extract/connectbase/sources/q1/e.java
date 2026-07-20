package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class e implements i2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f13417b = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2 f13418a = new a();

    public class a extends q {
        public a() {
        }

        public final /* synthetic */ String A() {
            return e.this.n();
        }

        public final /* synthetic */ void B() {
            try {
                e.this.p();
                u();
                if (isRunning()) {
                    try {
                        e.this.m();
                    } catch (Throwable th2) {
                        e2.b(th2);
                        try {
                            e.this.o();
                        } catch (Exception e10) {
                            e2.b(e10);
                            e.f13417b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e10);
                        }
                        t(th2);
                        return;
                    }
                }
                e.this.o();
                v();
            } catch (Throwable th3) {
                e2.b(th3);
                t(th3);
            }
        }

        @Override // q1.q
        public final void m() {
            z1.q(e.this.k(), new c1.q0() { // from class: q1.c
                @Override // c1.q0
                public final Object get() {
                    return e.this.n();
                }
            }).execute(new Runnable() { // from class: q1.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13414a.B();
                }
            });
        }

        @Override // q1.q
        public void n() {
            e.this.q();
        }

        @Override // q1.q
        public String toString() {
            return e.this.toString();
        }
    }

    @Override // q1.i2
    public final void a(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13418a.a(timeout, unit);
    }

    @Override // q1.i2
    public final void b(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13418a.b(timeout, unit);
    }

    @Override // q1.i2
    public final void c() {
        this.f13418a.c();
    }

    @Override // q1.i2
    @t1.a
    public final i2 d() {
        this.f13418a.d();
        return this;
    }

    @Override // q1.i2
    public final void e(i2.a listener, Executor executor) {
        this.f13418a.e(listener, executor);
    }

    @Override // q1.i2
    public final void f() {
        this.f13418a.f();
    }

    @Override // q1.i2
    public final Throwable g() {
        return this.f13418a.g();
    }

    @Override // q1.i2
    @t1.a
    public final i2 h() {
        this.f13418a.h();
        return this;
    }

    @Override // q1.i2
    public final boolean isRunning() {
        return this.f13418a.isRunning();
    }

    public Executor k() {
        return new Executor() { // from class: q1.b
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f13406a.l(runnable);
            }
        };
    }

    public final /* synthetic */ void l(Runnable runnable) {
        z1.n(n(), runnable).start();
    }

    public abstract void m() throws Exception;

    public String n() {
        return getClass().getSimpleName();
    }

    public void o() throws Exception {
    }

    public void p() throws Exception {
    }

    public void q() {
    }

    @Override // q1.i2
    public final i2.b state() {
        return this.f13418a.state();
    }

    public String toString() {
        return n() + " [" + this.f13418a.state() + "]";
    }
}
