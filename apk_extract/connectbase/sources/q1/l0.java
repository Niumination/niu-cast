package q1;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public final class l0<V> extends u<Object, V> {

    @gm.a
    public l0<V>.c<?> I;

    public final class a extends l0<V>.c<s1<V>> {
        private final w<V> callable;

        public a(w<V> callable, Executor listenerExecutor) {
            super(listenerExecutor);
            callable.getClass();
            this.callable = callable;
        }

        @Override // q1.p1
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // q1.p1
        public s1<V> runInterruptibly() throws Exception {
            return (s1) c1.h0.V(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // q1.l0.c
        public void setValue(s1<V> value) {
            l0.this.D(value);
        }
    }

    public final class b extends l0<V>.c<V> {
        private final Callable<V> callable;

        public b(Callable<V> callable, Executor listenerExecutor) {
            super(listenerExecutor);
            callable.getClass();
            this.callable = callable;
        }

        @Override // q1.p1
        @c2
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // q1.l0.c
        public void setValue(@c2 V value) {
            l0.this.B(value);
        }

        @Override // q1.p1
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class c<T> extends p1<T> {
        private final Executor listenerExecutor;

        public c(Executor listenerExecutor) {
            listenerExecutor.getClass();
            this.listenerExecutor = listenerExecutor;
        }

        @Override // q1.p1
        public final void afterRanInterruptiblyFailure(Throwable error) {
            l0.this.I = null;
            if (error instanceof ExecutionException) {
                l0.this.C(((ExecutionException) error).getCause());
            } else if (error instanceof CancellationException) {
                l0.this.cancel(false);
            } else {
                l0.this.C(error);
            }
        }

        @Override // q1.p1
        public final void afterRanInterruptiblySuccess(@c2 T result) {
            l0.this.I = null;
            setValue(result);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e10) {
                l0.this.C(e10);
            }
        }

        @Override // q1.p1
        public final boolean isDone() {
            return l0.this.isDone();
        }

        public abstract void setValue(@c2 T value);
    }

    public l0(f1.e3<? extends s1<?>> futures, boolean allMustSucceed, Executor listenerExecutor, w<V> callable) {
        super(futures, allMustSucceed, false);
        this.I = new a(callable, listenerExecutor);
        U();
    }

    @Override // q1.u
    public void P(int index, @gm.a Object returnValue) {
    }

    @Override // q1.u
    public void S() {
        l0<V>.c<?> cVar = this.I;
        if (cVar != null) {
            cVar.execute();
        }
    }

    @Override // q1.u
    public void Z(u.a reason) {
        super.Z(reason);
        if (reason == u.a.OUTPUT_FUTURE_DONE) {
            this.I = null;
        }
    }

    @Override // q1.f
    public void w() {
        l0<V>.c<?> cVar = this.I;
        if (cVar != null) {
            cVar.interruptTask();
        }
    }

    public l0(f1.e3<? extends s1<?>> futures, boolean allMustSucceed, Executor listenerExecutor, Callable<V> callable) {
        super(futures, allMustSucceed, false);
        this.I = new b(callable, listenerExecutor);
        U();
    }
}
