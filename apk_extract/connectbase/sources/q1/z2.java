package q1;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class z2<V> extends u0.a<V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public s1<V> f13794n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @gm.a
    public ScheduledFuture<?> f13795p;

    public static final class b<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public z2<V> f13796a;

        public b(z2<V> timeoutFuture) {
            this.f13796a = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            s1<? extends V> s1Var;
            z2<V> z2Var = this.f13796a;
            if (z2Var == null || (s1Var = z2Var.f13794n) == null) {
                return;
            }
            this.f13796a = null;
            if (s1Var.isDone()) {
                z2Var.D(s1Var);
                return;
            }
            try {
                ScheduledFuture<?> scheduledFuture = z2Var.f13795p;
                z2Var.f13795p = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                        }
                    } catch (Throwable th2) {
                        z2Var.C(new c(str, null));
                        throw th2;
                    }
                }
                z2Var.C(new c(str + ": " + s1Var, null));
                s1Var.cancel(true);
            } catch (Throwable th3) {
                s1Var.cancel(true);
                throw th3;
            }
        }
    }

    public static final class c extends TimeoutException {
        public c(String message) {
            super(message);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        public c(String str, a aVar) {
            super(str);
        }
    }

    public z2(s1<V> delegate) {
        delegate.getClass();
        this.f13794n = delegate;
    }

    public static <V> s1<V> Q(s1<V> delegate, long time, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        z2 z2Var = new z2(delegate);
        b bVar = new b(z2Var);
        z2Var.f13795p = scheduledExecutor.schedule(bVar, time, unit);
        delegate.addListener(bVar, n0.INSTANCE);
        return z2Var;
    }

    @Override // q1.f
    public void m() {
        x(this.f13794n);
        ScheduledFuture<?> scheduledFuture = this.f13795p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f13794n = null;
        this.f13795p = null;
    }

    @Override // q1.f
    @gm.a
    public String y() {
        s1<V> s1Var = this.f13794n;
        ScheduledFuture<?> scheduledFuture = this.f13795p;
        if (s1Var == null) {
            return null;
        }
        String str = "inputFuture=[" + s1Var + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
