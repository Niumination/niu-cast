package wj;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class s2 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f19270c = Logger.getLogger(s2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque<Runnable> f19272b;

    public final void a() {
        while (true) {
            Runnable runnablePoll = this.f19272b.poll();
            if (runnablePoll == null) {
                return;
            }
            try {
                runnablePoll.run();
            } catch (Throwable th2) {
                f19270c.log(Level.SEVERE, "Exception while executing runnable " + runnablePoll, th2);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f19272b == null) {
            this.f19272b = new ArrayDeque<>(4);
        }
        this.f19272b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c1.h0.F(runnable, "'task' must not be null.");
        if (this.f19271a) {
            b(runnable);
            return;
        }
        this.f19271a = true;
        try {
            runnable.run();
            if (this.f19272b != null) {
            }
        } catch (Throwable th2) {
            try {
                f19270c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th2);
            } finally {
                if (this.f19272b != null) {
                    a();
                }
                this.f19271a = false;
            }
        }
    }
}
