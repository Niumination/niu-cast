package q1;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public class a3<V> extends u0.a<V> implements RunnableFuture<V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public volatile p1<?> f13405n;

    public final class a extends p1<s1<V>> {
        private final w<V> callable;

        public a(w<V> callable) {
            callable.getClass();
            this.callable = callable;
        }

        @Override // q1.p1
        public void afterRanInterruptiblyFailure(Throwable error) {
            a3.this.C(error);
        }

        @Override // q1.p1
        public final boolean isDone() {
            return a3.this.isDone();
        }

        @Override // q1.p1
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // q1.p1
        public void afterRanInterruptiblySuccess(s1<V> result) {
            a3.this.D(result);
        }

        @Override // q1.p1
        public s1<V> runInterruptibly() throws Exception {
            return (s1) c1.h0.V(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }
    }

    public final class b extends p1<V> {
        private final Callable<V> callable;

        public b(Callable<V> callable) {
            callable.getClass();
            this.callable = callable;
        }

        @Override // q1.p1
        public void afterRanInterruptiblyFailure(Throwable error) {
            a3.this.C(error);
        }

        @Override // q1.p1
        public void afterRanInterruptiblySuccess(@c2 V result) {
            a3.this.B(result);
        }

        @Override // q1.p1
        public final boolean isDone() {
            return a3.this.isDone();
        }

        @Override // q1.p1
        @c2
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // q1.p1
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public a3(Callable<V> callable) {
        this.f13405n = new b(callable);
    }

    public static <V> a3<V> N(Runnable runnable, @c2 V result) {
        return new a3<>(Executors.callable(runnable, result));
    }

    public static <V> a3<V> O(Callable<V> callable) {
        return new a3<>(callable);
    }

    public static <V> a3<V> P(w<V> callable) {
        return new a3<>(callable);
    }

    @Override // q1.f
    public void m() {
        p1<?> p1Var;
        if (E() && (p1Var = this.f13405n) != null) {
            p1Var.interruptTask();
        }
        this.f13405n = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        p1<?> p1Var = this.f13405n;
        if (p1Var != null) {
            p1Var.run();
        }
        this.f13405n = null;
    }

    @Override // q1.f
    @gm.a
    public String y() {
        p1<?> p1Var = this.f13405n;
        if (p1Var == null) {
            return super.y();
        }
        return "task=[" + p1Var + "]";
    }

    public a3(w<V> callable) {
        this.f13405n = new a(callable);
    }
}
