package af;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q2 f453b;

    public /* synthetic */ m2(q2 q2Var, int i8) {
        this.f452a = i8;
        this.f453b = q2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q2 q2Var;
        boolean z2;
        boolean z3;
        switch (this.f452a) {
            case 0:
                synchronized (this.f453b) {
                    q2Var = this.f453b;
                    p2 p2Var = q2Var.e;
                    p2 p2Var2 = p2.DISCONNECTED;
                    if (p2Var != p2Var2) {
                        q2Var.e = p2Var2;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    break;
                }
                if (z2) {
                    q2Var.f529c.j();
                    return;
                }
                return;
            default:
                synchronized (this.f453b) {
                    try {
                        q2 q2Var2 = this.f453b;
                        q2Var2.f531g = null;
                        p2 p2Var3 = q2Var2.e;
                        p2 p2Var4 = p2.PING_SCHEDULED;
                        if (p2Var3 == p2Var4) {
                            q2Var2.e = p2.PING_SENT;
                            q2Var2.f = q2Var2.f527a.schedule(q2Var2.f532h, q2Var2.f535k, TimeUnit.NANOSECONDS);
                            z3 = true;
                        } else {
                            if (p2Var3 == p2.PING_DELAYED) {
                                ScheduledExecutorService scheduledExecutorService = q2Var2.f527a;
                                r2 r2Var = q2Var2.f533i;
                                long j8 = q2Var2.f534j;
                                z4 z4Var = q2Var2.f528b;
                                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                q2Var2.f531g = scheduledExecutorService.schedule(r2Var, j8 - z4Var.a(timeUnit), timeUnit);
                                this.f453b.e = p2Var4;
                            }
                            z3 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (z3) {
                    this.f453b.f529c.f();
                    return;
                }
                return;
        }
    }
}
