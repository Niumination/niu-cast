package wj;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.q1 f18743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18744b;

    @b1.e
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.f f18745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vj.o1 f18746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vj.p1 f18747c;

        public b(vj.o1.f fVar) {
            this.f18745a = fVar;
            vj.p1 p1VarE = j.this.f18743a.e(j.this.f18744b);
            this.f18747c = p1VarE;
            if (p1VarE == null) {
                throw new IllegalStateException(j.c.a(new StringBuilder("Could not find policy '"), j.this.f18744b, "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."));
            }
            this.f18746b = p1VarE.a(fVar);
        }

        @b1.e
        public vj.o1 a() {
            return this.f18746b;
        }

        @b1.e
        public vj.p1 b() {
            return this.f18747c;
        }

        public void c(vj.y2 y2Var) {
            this.f18746b.c(y2Var);
        }

        @Deprecated
        public void d(vj.o1.j jVar, vj.v vVar) {
            this.f18746b.e(jVar, vVar);
        }

        public void e() {
            this.f18746b.f();
        }

        @b1.e
        public void f(vj.o1 o1Var) {
            this.f18746b = o1Var;
        }

        public void g() {
            this.f18746b.g();
            this.f18746b = null;
        }

        public vj.y2 h(vj.o1.i iVar) {
            e3.b bVar = (e3.b) iVar.f17219c;
            if (bVar == null) {
                try {
                    j jVar = j.this;
                    bVar = new e3.b(jVar.d(jVar.f18744b, "using default policy"), null);
                } catch (f e10) {
                    this.f18745a.q(vj.u.TRANSIENT_FAILURE, new d(vj.y2.f17562s.u(e10.getMessage())));
                    this.f18746b.g();
                    this.f18747c = null;
                    this.f18746b = new e();
                    return vj.y2.f17548e;
                }
            }
            if (this.f18747c == null || !bVar.f18607a.b().equals(this.f18747c.b())) {
                this.f18745a.q(vj.u.CONNECTING, new c());
                this.f18746b.g();
                vj.p1 p1Var = bVar.f18607a;
                this.f18747c = p1Var;
                vj.o1 o1Var = this.f18746b;
                this.f18746b = p1Var.a(this.f18745a);
                this.f18745a.i().b(vj.h.a.INFO, "Load balancer changed from {0} to {1}", o1Var.getClass().getSimpleName(), this.f18746b.getClass().getSimpleName());
            }
            Object obj = bVar.f18608b;
            if (obj != null) {
                this.f18745a.i().b(vj.h.a.DEBUG, "Load-balancing config: {0}", bVar.f18608b);
            }
            vj.o1 o1Var2 = this.f18746b;
            vj.o1.i.a aVar = new vj.o1.i.a();
            aVar.f17220a = iVar.f17217a;
            aVar.f17221b = iVar.f17218b;
            aVar.f17222c = obj;
            return o1Var2.a(aVar.a());
        }
    }

    public static final class c extends vj.o1.k {
        public c() {
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return vj.o1.g.g();
        }

        public String toString() {
            return c1.z.b(c.class).toString();
        }

        public c(a aVar) {
        }
    }

    public static final class d extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.y2 f18749a;

        public d(vj.y2 y2Var) {
            this.f18749a = y2Var;
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return vj.o1.g.f(this.f18749a);
        }
    }

    public static final class e extends vj.o1 {
        public e() {
        }

        @Override // vj.o1
        public vj.y2 a(vj.o1.i iVar) {
            return vj.y2.f17548e;
        }

        @Override // vj.o1
        public void c(vj.y2 y2Var) {
        }

        @Override // vj.o1
        @Deprecated
        public void d(vj.o1.i iVar) {
        }

        @Override // vj.o1
        public void g() {
        }

        public e(a aVar) {
        }
    }

    @b1.e
    public static final class f extends Exception {
        private static final long serialVersionUID = 1;

        public f(String str) {
            super(str);
        }

        public f(String str, a aVar) {
            super(str);
        }
    }

    public j(String str) {
        this(vj.q1.c(), str);
    }

    public final vj.p1 d(String str, String str2) throws f {
        vj.p1 p1VarE = this.f18743a.e(str);
        if (p1VarE != null) {
            return p1VarE;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable", null);
    }

    public b e(vj.o1.f fVar) {
        return new b(fVar);
    }

    @gm.j
    public vj.x1.c f(Map<String, ?> map) {
        List<e3.a> listB;
        if (map != null) {
            try {
                listB = e3.B(e3.h(map));
            } catch (RuntimeException e10) {
                return vj.x1.c.b(vj.y2.f17550g.u("can't parse load balancer configuration").t(e10));
            }
        } else {
            listB = null;
        }
        if (listB == null || listB.isEmpty()) {
            return null;
        }
        return e3.z(listB, this.f18743a);
    }

    @b1.e
    public j(vj.q1 q1Var, String str) {
        this.f18743a = (vj.q1) c1.h0.F(q1Var, "registry");
        this.f18744b = (String) c1.h0.F(str, "defaultPolicy");
    }
}
