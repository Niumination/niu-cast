package wj;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 extends vj.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b1.e
    public static final vj.y2 f18799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b1.e
    public static final vj.y2 f18800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j0 f18801i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f18802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f18804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f18805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<vj.x0> f18806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r.e f18807f = new a();

    public class a implements r.e {
        public a() {
        }

        @Override // wj.r.e
        public s a(vj.w1<?, ?> w1Var, vj.e eVar, vj.v1 v1Var, vj.w wVar) {
            u uVar = l3.this.f18802a.f18555x;
            if (uVar == null) {
                uVar = l3.f18801i;
            }
            vj.n[] nVarArrH = v0.h(eVar, v1Var, 0, false);
            vj.w wVarC = wVar.c();
            try {
                return uVar.k(w1Var, v1Var, eVar, nVarArrH);
            } finally {
                wVar.q(wVarC);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RequestT, ResponseT] */
    public class b<RequestT, ResponseT> extends vj.k<RequestT, ResponseT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f18809a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.k.a f18811a;

            public a(vj.k.a aVar) {
                this.f18811a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18811a.a(l3.f18800h, new vj.v1());
            }
        }

        public b(Executor executor) {
            this.f18809a = executor;
        }

        @Override // vj.k
        public void a(String str, Throwable th2) {
        }

        @Override // vj.k
        public void c() {
        }

        @Override // vj.k
        public void e(int i10) {
        }

        @Override // vj.k
        public void f(RequestT requestt) {
        }

        @Override // vj.k
        public void h(vj.k.a<ResponseT> aVar, vj.v1 v1Var) {
            this.f18809a.execute(new a(aVar));
        }
    }

    static {
        vj.y2 y2Var = vj.y2.f17563t;
        vj.y2 y2VarU = y2Var.u("Subchannel is NOT READY");
        f18799g = y2VarU;
        f18800h = y2Var.u("wait-for-ready RPC is not supported on Subchannel.asChannel()");
        f18801i = new j0(y2VarU, t.a.MISCARRIED);
    }

    public l3(e1 e1Var, Executor executor, ScheduledExecutorService scheduledExecutorService, o oVar, AtomicReference<vj.x0> atomicReference) {
        this.f18802a = (e1) c1.h0.F(e1Var, "subchannel");
        this.f18803b = (Executor) c1.h0.F(executor, "executor");
        this.f18804c = (ScheduledExecutorService) c1.h0.F(scheduledExecutorService, "deadlineCancellationExecutor");
        this.f18805d = (o) c1.h0.F(oVar, "callsTracer");
        this.f18806e = (AtomicReference) c1.h0.F(atomicReference, "configSelector");
    }

    @Override // vj.f
    public String b() {
        return this.f18802a.f18533b;
    }

    @Override // vj.f
    public <RequestT, ResponseT> vj.k<RequestT, ResponseT> g(vj.w1<RequestT, ResponseT> w1Var, vj.e eVar) {
        Executor executor = eVar.f17087b;
        if (executor == null) {
            executor = this.f18803b;
        }
        Executor executor2 = executor;
        return eVar.m() ? new b(executor2) : new r(w1Var, executor2, eVar.x(v0.I, Boolean.TRUE), this.f18807f, this.f18804c, this.f18805d, this.f18806e.get());
    }
}
