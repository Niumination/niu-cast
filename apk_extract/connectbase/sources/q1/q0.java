package q1;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f13684c = Logger.getLogger(q0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    @u1.a("this")
    public a f13685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.a("this")
    public boolean f13686b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f13687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f13688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public a f13689c;

        public a(Runnable runnable, Executor executor, @gm.a a next) {
            this.f13687a = runnable;
            this.f13688b = executor;
            this.f13689c = next;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f13684c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        c1.h0.F(runnable, "Runnable was null.");
        c1.h0.F(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f13686b) {
                    c(runnable, executor);
                } else {
                    this.f13685a = new a(runnable, executor, this.f13685a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f13686b) {
                    return;
                }
                this.f13686b = true;
                a aVar = this.f13685a;
                a aVar2 = null;
                this.f13685a = null;
                while (aVar != null) {
                    a aVar3 = aVar.f13689c;
                    aVar.f13689c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.f13687a, aVar2.f13688b);
                    aVar2 = aVar2.f13689c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
