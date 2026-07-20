package wj;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements o2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f18813f = Logger.getLogger(m.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.c3 f18815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.a f18816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f18817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vj.c3.d f18818e;

    public m(k.a aVar, ScheduledExecutorService scheduledExecutorService, vj.c3 c3Var) {
        this.f18816c = aVar;
        this.f18814a = scheduledExecutorService;
        this.f18815b = c3Var;
    }

    @Override // wj.o2
    public void a(Runnable runnable) {
        this.f18815b.e();
        if (this.f18817d == null) {
            this.f18817d = this.f18816c.get();
        }
        vj.c3.d dVar = this.f18818e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f18817d.a();
            this.f18818e = this.f18815b.c(runnable, jA, TimeUnit.NANOSECONDS, this.f18814a);
            f18813f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    public final /* synthetic */ void c() {
        vj.c3.d dVar = this.f18818e;
        if (dVar != null && dVar.b()) {
            this.f18818e.a();
        }
        this.f18817d = null;
    }

    @Override // wj.o2
    public void reset() {
        this.f18815b.e();
        this.f18815b.execute(new Runnable() { // from class: wj.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f18789a.c();
            }
        });
    }
}
