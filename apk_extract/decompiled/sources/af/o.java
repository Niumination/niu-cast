package af;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final Logger e = Logger.getLogger(o.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h3 f475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.v2 f476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d1 f477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u6.c f478d;

    public o(k2 k2Var, h3 h3Var, ze.v2 v2Var) {
        this.f475a = h3Var;
        this.f476b = v2Var;
    }

    public final void a(f fVar) {
        this.f476b.d();
        if (this.f477c == null) {
            this.f477c = k2.h();
        }
        u6.c cVar = this.f478d;
        if (cVar != null) {
            ze.u2 u2Var = (ze.u2) cVar.f10388c;
            if (!u2Var.f11447c && !u2Var.f11446b) {
                return;
            }
        }
        long jA = this.f477c.a();
        this.f478d = this.f476b.c(fVar, jA, TimeUnit.NANOSECONDS, this.f475a);
        e.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
    }
}
