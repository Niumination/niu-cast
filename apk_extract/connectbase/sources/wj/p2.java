package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 extends r0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vj.a.c<b> f19159e = new vj.a.c<>("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.x1 f19160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o2 f19161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.c3 f19162d;

    @b1.e
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p2.this.b();
        }
    }

    public class b {
        public b() {
        }

        public void a(vj.y2 y2Var) {
            if (y2Var.r()) {
                p2.this.f19161c.reset();
            } else {
                p2.this.f19161c.a(p2.this.new a());
            }
        }
    }

    public class c extends vj.x1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.x1.e f19165a;

        public c(vj.x1.e eVar) {
            this.f19165a = eVar;
        }

        @Override // vj.x1.e, vj.x1.f
        public void a(vj.y2 y2Var) {
            this.f19165a.a(y2Var);
            p2.this.f19162d.execute(new Runnable() { // from class: wj.q2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19189a.e();
                }
            });
        }

        @Override // vj.x1.e
        public void c(vj.x1.g gVar) {
            vj.a aVar = gVar.f17534b;
            vj.a.c<b> cVar = p2.f19159e;
            if (aVar.f17048a.get(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            vj.x1.e eVar = this.f19165a;
            vj.x1.g.a aVarE = gVar.e();
            vj.a aVar2 = gVar.f17534b;
            aVar2.getClass();
            aVarE.f17537b = new vj.a.b(aVar2).d(cVar, p2.this.new b()).a();
            eVar.c(aVarE.a());
        }

        public final /* synthetic */ void e() {
            p2.this.f19161c.a(p2.this.new a());
        }
    }

    public p2(vj.x1 x1Var, o2 o2Var, vj.c3 c3Var) {
        super(x1Var);
        this.f19160b = x1Var;
        this.f19161c = o2Var;
        this.f19162d = c3Var;
    }

    @Override // wj.r0, vj.x1
    public void c() {
        super.c();
        this.f19161c.reset();
    }

    @Override // wj.r0, vj.x1
    public void d(vj.x1.e eVar) {
        super.d(new c(eVar));
    }

    @b1.e
    public vj.x1 h() {
        return this.f19160b;
    }
}
