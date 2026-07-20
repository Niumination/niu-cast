package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class i implements i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.q0<String> f13494a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2 f13495b = new b();

    public final class b extends q {
        public b() {
        }

        public final /* synthetic */ void A() {
            try {
                i.this.o();
                u();
            } catch (Throwable th2) {
                e2.b(th2);
                t(th2);
            }
        }

        public final /* synthetic */ void B() {
            try {
                i.this.n();
                v();
            } catch (Throwable th2) {
                e2.b(th2);
                t(th2);
            }
        }

        @Override // q1.q
        public final void m() {
            z1.q(i.this.k(), i.this.f13494a).execute(new Runnable() { // from class: q1.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13585a.A();
                }
            });
        }

        @Override // q1.q
        public final void n() {
            z1.q(i.this.k(), i.this.f13494a).execute(new Runnable() { // from class: q1.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13564a.B();
                }
            });
        }

        @Override // q1.q
        public String toString() {
            return i.this.toString();
        }
    }

    public final class c implements c1.q0<String> {
        public c() {
        }

        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return i.this.m() + " " + i.this.f13495b.state();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Runnable runnable) {
        z1.n(this.f13494a.get(), runnable).start();
    }

    @Override // q1.i2
    public final void a(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13495b.a(timeout, unit);
    }

    @Override // q1.i2
    public final void b(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13495b.b(timeout, unit);
    }

    @Override // q1.i2
    public final void c() {
        this.f13495b.c();
    }

    @Override // q1.i2
    @t1.a
    public final i2 d() {
        this.f13495b.d();
        return this;
    }

    @Override // q1.i2
    public final void e(i2.a listener, Executor executor) {
        this.f13495b.e(listener, executor);
    }

    @Override // q1.i2
    public final void f() {
        this.f13495b.f();
    }

    @Override // q1.i2
    public final Throwable g() {
        return this.f13495b.g();
    }

    @Override // q1.i2
    @t1.a
    public final i2 h() {
        this.f13495b.h();
        return this;
    }

    @Override // q1.i2
    public final boolean isRunning() {
        return this.f13495b.isRunning();
    }

    public Executor k() {
        return new Executor() { // from class: q1.h
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f13467a.l(runnable);
            }
        };
    }

    public String m() {
        return getClass().getSimpleName();
    }

    public abstract void n() throws Exception;

    public abstract void o() throws Exception;

    @Override // q1.i2
    public final i2.b state() {
        return this.f13495b.state();
    }

    public String toString() {
        return m() + " [" + this.f13495b.state() + "]";
    }
}
