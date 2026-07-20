package q1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public class o1<V> implements s1<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s1<?> f13640b = new o1(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f13641c = Logger.getLogger(o1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c2
    public final V f13642a;

    public static final class a<V> extends f.j<V> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @gm.a
        public static final a<Object> f13643n;

        static {
            f13643n = f.f13421d ? null : new a<>();
        }

        public a() {
            cancel(false);
        }
    }

    public static final class b<V> extends f.j<V> {
        public b(Throwable thrown) {
            C(thrown);
        }
    }

    public o1(@c2 V value) {
        this.f13642a = value;
    }

    @Override // q1.s1
    public void addListener(Runnable listener, Executor executor) {
        c1.h0.F(listener, "Runnable was null.");
        c1.h0.F(executor, "Executor was null.");
        try {
            executor.execute(listener);
        } catch (RuntimeException e10) {
            f13641c.log(Level.SEVERE, "RuntimeException while executing runnable " + listener + " with executor " + executor, (Throwable) e10);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override // java.util.concurrent.Future
    @c2
    public V get() {
        return this.f13642a;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=SUCCESS, result=[");
        return j.e.a(sb2, this.f13642a, "]]");
    }

    @Override // java.util.concurrent.Future
    @c2
    public V get(long timeout, TimeUnit unit) throws ExecutionException {
        unit.getClass();
        return get();
    }
}
