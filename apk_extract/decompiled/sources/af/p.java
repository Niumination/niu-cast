package af;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicInteger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f490a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile ze.q2 f492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ze.q2 f493d;
    public ze.q2 e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f494g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f491b = new AtomicInteger(-2147483647);
    public final tj.x f = new tj.x(this);

    public p(q qVar, j0 j0Var, String str) {
        this.f494g = qVar;
        v8.i(j0Var, "delegate");
        this.f490a = j0Var;
        v8.i(str, "authority");
    }

    public static void e(p pVar) {
        synchronized (pVar) {
            try {
                if (pVar.f491b.get() != 0) {
                    return;
                }
                ze.q2 q2Var = pVar.f493d;
                ze.q2 q2Var2 = pVar.e;
                pVar.f493d = null;
                pVar.e = null;
                if (q2Var != null) {
                    super.c(q2Var);
                }
                if (q2Var2 != null) {
                    super.a(q2Var2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.g1, af.r3
    public final void a(ze.q2 q2Var) {
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        synchronized (this) {
            try {
                if (this.f491b.get() < 0) {
                    this.f492c = q2Var;
                    this.f491b.addAndGet(Integer.MAX_VALUE);
                } else if (this.e != null) {
                    return;
                }
                if (this.f491b.get() != 0) {
                    this.e = q2Var;
                } else {
                    super.a(q2Var);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.g1
    public final j0 b() {
        return this.f490a;
    }

    @Override // af.g1, af.r3
    public final void c(ze.q2 q2Var) {
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        synchronized (this) {
            try {
                if (this.f491b.get() < 0) {
                    this.f492c = q2Var;
                    this.f491b.addAndGet(Integer.MAX_VALUE);
                    if (this.f491b.get() != 0) {
                        this.f493d = q2Var;
                    } else {
                        super.c(q2Var);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.e0
    public final b0 f(ze.r1 r1Var, ze.p1 p1Var, ze.f fVar, ze.n[] nVarArr) {
        fVar.getClass();
        this.f494g.getClass();
        return this.f491b.get() >= 0 ? new e1(this.f492c, nVarArr) : this.f490a.f(r1Var, p1Var, fVar, nVarArr);
    }
}
