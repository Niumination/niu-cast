package wj;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class a2 extends vj.r1 implements vj.a1<vj.v0.b> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Logger f18317q = Logger.getLogger(a2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e1 f18318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wj.e f18319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vj.o1.k f18320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.c1 f18321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f18323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vj.v0 f18324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z1<? extends Executor> f18325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f18326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScheduledExecutorService f18327j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f18329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o f18330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q f18331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n3 f18332o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CountDownLatch f18328k = new CountDownLatch(1);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r.e f18333p = new a();

    public class a implements r.e {
        public a() {
        }

        @Override // wj.r.e
        public s a(vj.w1<?, ?> w1Var, vj.e eVar, vj.v1 v1Var, vj.w wVar) {
            vj.n[] nVarArrH = v0.h(eVar, v1Var, 0, false);
            vj.w wVarC = wVar.c();
            try {
                return a2.this.f18323f.k(w1Var, v1Var, eVar, nVarArrH);
            } finally {
                wVar.q(wVarC);
            }
        }
    }

    public final class b extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.g f18335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vj.v f18336b;

        public b(vj.v vVar) {
            this.f18336b = vVar;
            this.f18335a = vj.o1.g.f(vVar.f17280b);
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return this.f18335a;
        }

        public String toString() {
            return c1.z.b(b.class).j("errorResult", this.f18335a).toString();
        }
    }

    public final class c extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.g f18338a;

        public c() {
            this.f18338a = vj.o1.g.h(a2.this.f18319b);
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return this.f18338a;
        }

        public String toString() {
            return c1.z.b(c.class).j("result", this.f18338a).toString();
        }
    }

    public class d implements r1.a {
        public d() {
        }

        @Override // wj.r1.a
        public void a() {
            a2.this.f18319b.h();
        }

        @Override // wj.r1.a
        public void b() {
        }

        @Override // wj.r1.a
        public void c(boolean z10) {
        }

        @Override // wj.r1.a
        public void d(vj.y2 y2Var) {
        }

        @Override // wj.r1.a
        public vj.a e(vj.a aVar) {
            return aVar;
        }
    }

    public class e extends wj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e1 f18341a;

        public e(e1 e1Var) {
            this.f18341a = e1Var;
        }

        @Override // vj.o1.j
        public List<vj.d0> c() {
            return this.f18341a.f18546o;
        }

        @Override // vj.o1.j
        public vj.a d() {
            return vj.a.f17046c;
        }

        @Override // vj.o1.j
        public Object f() {
            return this.f18341a;
        }

        @Override // vj.o1.j
        public void g() {
            this.f18341a.b();
        }

        @Override // vj.o1.j
        public void h() {
            this.f18341a.n(vj.y2.f17563t.u("OobChannel is shutdown"));
        }

        @Override // wj.e
        public vj.a1<vj.v0.b> k() {
            return this.f18341a;
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18343a;

        static {
            int[] iArr = new int[vj.u.values().length];
            f18343a = iArr;
            try {
                iArr[vj.u.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18343a[vj.u.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18343a[vj.u.TRANSIENT_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a2(String str, z1<? extends Executor> z1Var, ScheduledExecutorService scheduledExecutorService, vj.c3 c3Var, o oVar, q qVar, vj.v0 v0Var, n3 n3Var) {
        this.f18322e = (String) c1.h0.F(str, "authority");
        this.f18321d = vj.c1.a(a2.class, str);
        this.f18325h = (z1) c1.h0.F(z1Var, "executorPool");
        Executor executor = (Executor) c1.h0.F(z1Var.a(), "executor");
        this.f18326i = executor;
        this.f18327j = (ScheduledExecutorService) c1.h0.F(scheduledExecutorService, "deadlineCancellationExecutor");
        d0 d0Var = new d0(executor, c3Var);
        this.f18323f = d0Var;
        v0Var.getClass();
        this.f18324g = v0Var;
        d0Var.f(new d());
        this.f18330m = oVar;
        this.f18331n = (q) c1.h0.F(qVar, "channelTracer");
        this.f18332o = (n3) c1.h0.F(n3Var, "timeProvider");
    }

    public void A(e1 e1Var) {
        f18317q.log(Level.FINE, "[{0}] Created with [{1}]", new Object[]{this, e1Var});
        this.f18318a = e1Var;
        this.f18319b = new e(e1Var);
        c cVar = new c();
        this.f18320c = cVar;
        this.f18323f.u(cVar);
    }

    public void B(List<vj.d0> list) {
        this.f18318a.f0(list);
    }

    @Override // vj.f
    public String b() {
        return this.f18322e;
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f18321d;
    }

    @Override // vj.f
    public <RequestT, ResponseT> vj.k<RequestT, ResponseT> g(vj.w1<RequestT, ResponseT> w1Var, vj.e eVar) {
        Executor executor = eVar.f17087b;
        if (executor == null) {
            executor = this.f18326i;
        }
        return new r(w1Var, executor, eVar, this.f18333p, this.f18327j, this.f18330m, null);
    }

    @Override // vj.r1
    public boolean h(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f18328k.await(j10, timeUnit);
    }

    @Override // vj.a1
    public q1.s1<vj.v0.b> j() {
        q1.l2 l2VarF = q1.l2.F();
        vj.v0.b.a aVar = new vj.v0.b.a();
        this.f18330m.d(aVar);
        this.f18331n.g(aVar);
        aVar.f17298a = this.f18322e;
        aVar.f17299b = this.f18318a.f18556y.f17279a;
        aVar.i(Collections.singletonList(this.f18318a));
        l2VarF.B(aVar.a());
        return l2VarF;
    }

    @Override // vj.r1
    public vj.u l(boolean z10) {
        e1 e1Var = this.f18318a;
        return e1Var == null ? vj.u.IDLE : e1Var.f18556y.f17279a;
    }

    @Override // vj.r1
    public boolean o() {
        return this.f18329l;
    }

    @Override // vj.r1
    public boolean p() {
        return this.f18328k.getCount() == 0;
    }

    @Override // vj.r1
    public void r() {
        this.f18318a.c0();
    }

    @Override // vj.r1
    public vj.r1 s() {
        this.f18329l = true;
        this.f18323f.n(vj.y2.f17563t.u("OobChannel.shutdown() called"));
        return this;
    }

    @Override // vj.r1
    public vj.r1 t() {
        this.f18329l = true;
        this.f18323f.a(vj.y2.f17563t.u("OobChannel.shutdownNow() called"));
        return this;
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f18321d.f17063c).j("authority", this.f18322e).toString();
    }

    public e1 w() {
        return this.f18318a;
    }

    @b1.e
    public vj.o1.j x() {
        return this.f18319b;
    }

    public void y(vj.v vVar) {
        q qVar = this.f18331n;
        vj.v0.c.b.a aVar = new vj.v0.c.b.a();
        aVar.f17318a = "Entering " + vVar.f17279a + " state";
        aVar.f17319b = vj.v0.c.b.EnumC0456b.CT_INFO;
        aVar.f17320c = Long.valueOf(this.f18332o.a());
        qVar.e(aVar.a());
        int i10 = f.f18343a[vVar.f17279a.ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.f18323f.u(this.f18320c);
        } else {
            if (i10 != 3) {
                return;
            }
            this.f18323f.u(new b(vVar));
        }
    }

    public void z() {
        this.f18324g.D(this);
        this.f18325h.b(this.f18326i);
        this.f18328k.countDown();
    }
}
