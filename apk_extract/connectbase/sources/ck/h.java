package ck;

import c1.h0;
import vj.e0;
import vj.o1;
import vj.u;
import vj.v;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
@e0("https://github.com/grpc/grpc-java/issues/5999")
public final class h extends e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @b1.e
    public static final o1.k f1497p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o1 f1498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o1.f f1499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @gm.j
    public o1.d f1500i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o1 f1501j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.j
    public o1.d f1502k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o1 f1503l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u f1504m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o1.k f1505n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1506o;

    public class a extends o1 {
        public a() {
        }

        @Override // vj.o1
        public void c(y2 y2Var) {
            h.this.f1499h.q(u.TRANSIENT_FAILURE, new o1.e(o1.g.f(y2Var)));
        }

        @Override // vj.o1
        public void d(o1.i iVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // vj.o1
        public void g() {
        }
    }

    public class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o1 f1508a;

        public b() {
        }

        @Override // ck.f, vj.o1.f
        public void q(u uVar, o1.k kVar) {
            if (this.f1508a == h.this.f1503l) {
                h0.h0(h.this.f1506o, "there's pending lb while current lb has been out of READY");
                h hVar = h.this;
                hVar.f1504m = uVar;
                hVar.f1505n = kVar;
                if (uVar == u.READY) {
                    hVar.s();
                    return;
                }
                return;
            }
            o1 o1Var = this.f1508a;
            h hVar2 = h.this;
            if (o1Var == hVar2.f1501j) {
                boolean z10 = uVar == u.READY;
                hVar2.f1506o = z10;
                if (z10 || hVar2.f1503l == hVar2.f1498g) {
                    hVar2.f1499h.q(uVar, kVar);
                } else {
                    hVar2.s();
                }
            }
        }

        @Override // ck.f
        public o1.f t() {
            return h.this.f1499h;
        }
    }

    public class c extends o1.k {
        @Override // vj.o1.k
        public o1.g a(o1.h hVar) {
            return o1.g.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public h(o1.f fVar) {
        a aVar = new a();
        this.f1498g = aVar;
        this.f1501j = aVar;
        this.f1503l = aVar;
        this.f1499h = (o1.f) h0.F(fVar, "helper");
    }

    @Override // ck.e, vj.o1
    @Deprecated
    public void e(o1.j jVar, v vVar) {
        throw new UnsupportedOperationException("handleSubchannelState() is not supported by ".concat(h.class.getName()));
    }

    @Override // ck.e, vj.o1
    public void g() {
        this.f1503l.g();
        this.f1501j.g();
    }

    @Override // ck.e
    public o1 h() {
        o1 o1Var = this.f1503l;
        return o1Var == this.f1498g ? this.f1501j : o1Var;
    }

    public String r() {
        return h().getClass().getSimpleName();
    }

    public final void s() {
        this.f1499h.q(this.f1504m, this.f1505n);
        this.f1501j.g();
        this.f1501j = this.f1503l;
        this.f1500i = this.f1502k;
        this.f1503l = this.f1498g;
        this.f1502k = null;
    }

    public void t(o1.d dVar) {
        h0.F(dVar, "newBalancerFactory");
        if (dVar.equals(this.f1502k)) {
            return;
        }
        this.f1503l.g();
        this.f1503l = this.f1498g;
        this.f1502k = null;
        this.f1504m = u.CONNECTING;
        this.f1505n = f1497p;
        if (dVar.equals(this.f1500i)) {
            return;
        }
        b bVar = new b();
        o1 o1VarA = dVar.a(bVar);
        bVar.f1508a = o1VarA;
        this.f1503l = o1VarA;
        this.f1502k = dVar;
        if (this.f1506o) {
            return;
        }
        s();
    }
}
