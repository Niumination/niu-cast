package q1;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@o0
@b1.d
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<s1<Void>> f13708a = new AtomicReference<>(o1.f13640b);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f13709b = new e();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f13710a;

        public a(final s0 this$0, final Callable val$callable) {
            this.f13710a = val$callable;
        }

        @Override // q1.w
        public s1<T> call() throws Exception {
            return h1.o(this.f13710a.call());
        }

        public String toString() {
            return this.f13710a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f13711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f13712b;

        public b(final s0 this$0, final d val$taskExecutor, final w val$callable) {
            this.f13711a = val$taskExecutor;
            this.f13712b = val$callable;
        }

        @Override // q1.w
        public s1<T> call() throws Exception {
            return !this.f13711a.b() ? h1.m() : this.f13712b.call();
        }

        public String toString() {
            return this.f13712b.toString();
        }
    }

    public enum c {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static final class d extends AtomicReference<c> implements Executor, Runnable {

        @gm.a
        Executor delegate;

        @gm.a
        s0 sequencer;

        @gm.a
        Thread submitting;

        @gm.a
        Runnable task;

        public /* synthetic */ d(Executor executor, s0 s0Var, a aVar) {
            this(executor, s0Var);
        }

        public final boolean a() {
            return compareAndSet(c.NOT_RUN, c.CANCELLED);
        }

        public final boolean b() {
            return compareAndSet(c.NOT_RUN, c.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable task) {
            if (get() == c.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                s0 s0Var = this.sequencer;
                Objects.requireNonNull(s0Var);
                e eVar = s0Var.f13709b;
                if (eVar.f13714a == this.submitting) {
                    this.sequencer = null;
                    c1.h0.g0(eVar.f13715b == null);
                    eVar.f13715b = task;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    eVar.f13716c = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = task;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            e eVar = new e();
            eVar.f13714a = threadCurrentThread;
            s0 s0Var = this.sequencer;
            Objects.requireNonNull(s0Var);
            s0Var.f13709b = eVar;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = eVar.f13715b;
                    if (runnable3 == null || (executor = eVar.f13716c) == null) {
                        break;
                    }
                    eVar.f13715b = null;
                    eVar.f13716c = null;
                    executor.execute(runnable3);
                }
                eVar.f13714a = null;
            } catch (Throwable th2) {
                eVar.f13714a = null;
                throw th2;
            }
        }

        public d(Executor delegate, s0 sequencer) {
            super(c.NOT_RUN);
            this.delegate = delegate;
            this.sequencer = sequencer;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public Thread f13714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Runnable f13715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public Executor f13716c;

        public e() {
        }

        public e(a aVar) {
        }
    }

    public static s0 d() {
        return new s0();
    }

    public static /* synthetic */ void e(a3 a3Var, l2 l2Var, s1 s1Var, s1 s1Var2, d dVar) {
        if (a3Var.isDone()) {
            l2Var.D(s1Var);
        } else if (s1Var2.isCancelled() && dVar.a()) {
            a3Var.cancel(false);
        }
    }

    public <T> s1<T> f(Callable<T> callable, Executor executor) {
        callable.getClass();
        executor.getClass();
        return g(new a(this, callable), executor);
    }

    public <T> s1<T> g(w<T> callable, Executor executor) {
        callable.getClass();
        executor.getClass();
        final d dVar = new d(executor, this, null);
        b bVar = new b(this, dVar, callable);
        final l2 l2VarF = l2.F();
        final s1<Void> andSet = this.f13708a.getAndSet(l2VarF);
        final a3 a3VarP = a3.P(bVar);
        andSet.addListener(a3VarP, dVar);
        final s1<T> s1VarU = h1.u(a3VarP);
        Runnable runnable = new Runnable() { // from class: q1.r0
            @Override // java.lang.Runnable
            public final void run() {
                s0.e(a3VarP, l2VarF, andSet, s1VarU, dVar);
            }
        };
        n0 n0Var = n0.INSTANCE;
        s1VarU.addListener(runnable, n0Var);
        a3VarP.addListener(runnable, n0Var);
        return s1VarU;
    }
}
