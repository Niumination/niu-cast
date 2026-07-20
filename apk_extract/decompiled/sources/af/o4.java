package af;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class o4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p4 f485b;

    public /* synthetic */ o4(p4 p4Var, int i8) {
        this.f484a = i8;
        this.f485b = p4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f484a) {
            case 0:
                p4 p4Var = this.f485b;
                if (!p4Var.f) {
                    p4Var.f508g = null;
                } else {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long jA = p4Var.e - p4Var.f507d.a(timeUnit);
                    if (jA <= 0) {
                        p4Var.f = false;
                        p4Var.f508g = null;
                        p4Var.f506c.run();
                    } else {
                        p4Var.f508g = p4Var.f504a.schedule(new o4(p4Var, 1), jA, timeUnit);
                    }
                }
                break;
            default:
                p4 p4Var2 = this.f485b;
                p4Var2.f505b.execute(new o4(p4Var2, 0));
                break;
        }
    }
}
