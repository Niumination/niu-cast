package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@t1.f("Create an AbstractIdleService")
@b1.d
public interface i2 {

    public static abstract class a {
        public void a(b from, Throwable failure) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(b from) {
        }

        public void e(b from) {
        }
    }

    public enum b {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    void a(long timeout, TimeUnit unit) throws TimeoutException;

    void b(long timeout, TimeUnit unit) throws TimeoutException;

    void c();

    @t1.a
    i2 d();

    void e(a listener, Executor executor);

    void f();

    Throwable g();

    @t1.a
    i2 h();

    boolean isRunning();

    b state();
}
