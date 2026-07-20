package q1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class r1 {
    public static <V> s1<V> a(Future<V> future) {
        return future instanceof s1 ? (s1) future : new a(future);
    }

    public static <V> s1<V> b(Future<V> future, Executor executor) {
        executor.getClass();
        return future instanceof s1 ? (s1) future : new a(future, executor);
    }

    public static class a<V> extends a1<V> implements s1<V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ThreadFactory f13698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Executor f13699f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f13700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q0 f13701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f13702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Future<V> f13703d;

        static {
            x2 x2Var = new x2();
            x2Var.f13756b = Boolean.TRUE;
            x2 x2VarF = x2Var.f("ListenableFutureAdapter-thread-%d");
            x2VarF.getClass();
            ThreadFactory threadFactoryC = x2.c(x2VarF);
            f13698e = threadFactoryC;
            f13699f = Executors.newCachedThreadPool(threadFactoryC);
        }

        public a(Future<V> delegate, Executor adapterExecutor) {
            this.f13701b = new q0();
            this.f13702c = new AtomicBoolean(false);
            delegate.getClass();
            this.f13703d = delegate;
            adapterExecutor.getClass();
            this.f13700a = adapterExecutor;
        }

        @Override // q1.s1
        public void addListener(Runnable listener, Executor exec) {
            this.f13701b.a(listener, exec);
            if (this.f13702c.compareAndSet(false, true)) {
                if (this.f13703d.isDone()) {
                    this.f13701b.b();
                } else {
                    this.f13700a.execute(new Runnable() { // from class: q1.q1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f13690a.q();
                        }
                    });
                }
            }
        }

        @Override // q1.a1, f1.j2
        /* JADX INFO: renamed from: l */
        public Future<V> delegate() {
            return this.f13703d;
        }

        public final /* synthetic */ void q() {
            try {
                e3.f(this.f13703d);
            } catch (Error | RuntimeException | ExecutionException unused) {
            }
            this.f13701b.b();
        }

        public a(Future<V> delegate) {
            this(delegate, f13699f);
        }
    }
}
