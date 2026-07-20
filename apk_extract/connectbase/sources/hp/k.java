package hp;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kn.l0;
import od.c1;
import vp.a1;
import vp.z0;
import yp.v;
import yp.w;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements wp.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Map<a1, a1> f7506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final wp.e.a f7507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final wp.g f7508c;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@os.m Map<a1, ? extends a1> map, @os.l wp.e.a aVar, @os.l wp.g gVar) {
        l0.p(aVar, "equalityAxioms");
        l0.p(gVar, "kotlinTypeRefiner");
        this.f7506a = map;
        this.f7507b = aVar;
        this.f7508c = gVar;
    }

    @Override // yp.r
    @os.m
    public yp.n A(@os.l yp.k kVar, int i10) {
        return wp.b.a.p(this, kVar, i10);
    }

    public final boolean A0(a1 a1Var, a1 a1Var2) {
        if (this.f7507b.a(a1Var, a1Var2)) {
            return true;
        }
        Map<a1, a1> map = this.f7506a;
        if (map == null) {
            return false;
        }
        a1 a1Var3 = map.get(a1Var);
        a1 a1Var4 = this.f7506a.get(a1Var2);
        if (a1Var3 == null || !l0.g(a1Var3, a1Var2)) {
            return a1Var4 != null && l0.g(a1Var4, a1Var);
        }
        return true;
    }

    @Override // yp.r
    public boolean B(@os.l yp.o oVar) {
        return wp.b.a.R(this, oVar);
    }

    @os.l
    public z0 B0(boolean z10, boolean z11) {
        return wp.a.b(z10, z11, this, null, this.f7508c, 8, null);
    }

    @Override // yp.r
    @os.m
    public yp.i C(@os.l yp.d dVar) {
        return wp.b.a.k0(this, dVar);
    }

    @Override // yp.r
    public boolean D(@os.l yp.o oVar) {
        return wp.b.a.M(this, oVar);
    }

    @Override // yp.r
    public boolean E(@os.l yp.i iVar) {
        return wp.b.a.g0(this, iVar);
    }

    @Override // yp.r
    public boolean F(@os.l yp.d dVar) {
        return wp.b.a.Y(this, dVar);
    }

    @Override // yp.r
    @os.l
    public yp.k G(@os.l yp.i iVar) {
        return wp.b.a.z0(this, iVar);
    }

    @Override // yp.r
    @os.l
    public yp.n H(@os.l yp.i iVar) {
        return wp.b.a.i(this, iVar);
    }

    @Override // vp.i1
    @os.l
    public yp.i I(@os.l yp.p pVar) {
        return wp.b.a.u(this, pVar);
    }

    @Override // yp.r
    public boolean J(@os.l yp.i iVar) {
        return wp.b.a.O(this, iVar);
    }

    @Override // yp.r
    @os.l
    public yp.b K(@os.l yp.d dVar) {
        return wp.b.a.k(this, dVar);
    }

    @Override // yp.r
    public boolean L(@os.l yp.k kVar) {
        return wp.b.a.Z(this, kVar);
    }

    @Override // yp.r
    public boolean M(@os.l yp.k kVar) {
        return wp.b.a.f0(this, kVar);
    }

    @Override // yp.r
    @os.l
    public yp.k N(@os.l yp.e eVar) {
        return wp.b.a.o0(this, eVar);
    }

    @Override // yp.r
    @os.l
    public yp.n O(@os.l yp.i iVar, int i10) {
        return wp.b.a.o(this, iVar, i10);
    }

    @Override // yp.r
    public boolean P(@os.l yp.i iVar) {
        return wp.b.a.X(this, iVar);
    }

    @Override // yp.r
    public boolean Q(@os.l yp.i iVar) {
        return wp.b.a.C(this, iVar);
    }

    @Override // vp.i1
    public boolean R(@os.l yp.o oVar) {
        return wp.b.a.P(this, oVar);
    }

    @Override // yp.r
    @os.l
    public Collection<yp.i> S(@os.l yp.k kVar) {
        return wp.b.a.q0(this, kVar);
    }

    @Override // yp.r
    @os.m
    public List<yp.k> T(@os.l yp.k kVar, @os.l yp.o oVar) {
        return wp.b.a.m(this, kVar, oVar);
    }

    @Override // yp.r
    public boolean U(@os.l yp.i iVar) {
        return wp.b.a.N(this, iVar);
    }

    @Override // yp.r
    public boolean V(@os.l yp.o oVar, @os.l yp.o oVar2) {
        l0.p(oVar, c1.f12184a);
        l0.p(oVar2, "c2");
        if (!(oVar instanceof a1)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (oVar2 instanceof a1) {
            return wp.b.a.a(this, oVar, oVar2) || A0((a1) oVar, (a1) oVar2);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // yp.r
    public boolean W(@os.l yp.o oVar) {
        return wp.b.a.S(this, oVar);
    }

    @Override // yp.r
    public boolean X(@os.l yp.k kVar) {
        return wp.b.a.Q(this, kVar);
    }

    @Override // yp.r
    public boolean Y(@os.l yp.k kVar) {
        return wp.b.a.U(this, kVar);
    }

    @Override // vp.i1
    @os.m
    public ao.i Z(@os.l yp.o oVar) {
        return wp.b.a.s(this, oVar);
    }

    @Override // wp.b, yp.r
    public boolean a(@os.l yp.k kVar) {
        return wp.b.a.b0(this, kVar);
    }

    @Override // yp.r
    public boolean a0(@os.l yp.d dVar) {
        return wp.b.a.a0(this, dVar);
    }

    @Override // wp.b, yp.r
    @os.l
    public yp.o b(@os.l yp.k kVar) {
        return wp.b.a.x0(this, kVar);
    }

    @Override // yp.r
    @os.m
    public yp.g b0(@os.l yp.i iVar) {
        return wp.b.a.g(this, iVar);
    }

    @Override // wp.b, yp.r
    @os.l
    public yp.k c(@os.l yp.k kVar, boolean z10) {
        return wp.b.a.B0(this, kVar, z10);
    }

    @Override // yp.r
    public boolean c0(@os.l yp.p pVar, @os.m yp.o oVar) {
        return wp.b.a.D(this, pVar, oVar);
    }

    @Override // wp.b, yp.r
    @os.m
    public yp.k d(@os.l yp.i iVar) {
        return wp.b.a.h(this, iVar);
    }

    @Override // yp.r
    public int d0(@os.l yp.o oVar) {
        return wp.b.a.p0(this, oVar);
    }

    @Override // wp.b, yp.r
    @os.l
    public yp.k e(@os.l yp.g gVar) {
        return wp.b.a.i0(this, gVar);
    }

    @Override // yp.r
    @os.l
    public yp.i e0(@os.l List<? extends yp.i> list) {
        return wp.b.a.F(this, list);
    }

    @Override // wp.b, yp.r
    @os.m
    public yp.d f(@os.l yp.k kVar) {
        return wp.b.a.d(this, kVar);
    }

    @Override // yp.r
    public boolean f0(@os.l yp.i iVar) {
        return wp.b.a.L(this, iVar);
    }

    @Override // wp.b, yp.r
    @os.l
    public yp.k g(@os.l yp.g gVar) {
        return wp.b.a.y0(this, gVar);
    }

    @Override // yp.r
    public boolean g0(@os.l yp.i iVar) {
        return wp.b.a.T(this, iVar);
    }

    @Override // yp.r
    public boolean h(@os.l yp.k kVar) {
        return wp.b.a.I(this, kVar);
    }

    @Override // yp.r
    @os.l
    public yp.p h0(@os.l yp.o oVar, int i10) {
        return wp.b.a.r(this, oVar, i10);
    }

    @Override // vp.i1
    @os.m
    public ao.i i(@os.l yp.o oVar) {
        return wp.b.a.t(this, oVar);
    }

    @Override // wp.b
    @os.l
    public yp.i i0(@os.l yp.k kVar, @os.l yp.k kVar2) {
        return wp.b.a.l(this, kVar, kVar2);
    }

    @Override // yp.r
    public int j(@os.l yp.i iVar) {
        return wp.b.a.b(this, iVar);
    }

    @Override // yp.r
    public boolean j0(@os.l yp.i iVar) {
        return wp.b.a.V(this, iVar);
    }

    @Override // vp.i1
    public boolean k(@os.l yp.i iVar, @os.l dp.c cVar) {
        return wp.b.a.B(this, iVar, cVar);
    }

    @Override // yp.r
    public boolean k0(@os.l yp.o oVar) {
        return wp.b.a.W(this, oVar);
    }

    @Override // yp.r
    @os.l
    public yp.m l(@os.l yp.k kVar) {
        return wp.b.a.c(this, kVar);
    }

    @Override // yp.r
    @os.m
    public yp.k l0(@os.l yp.k kVar, @os.l yp.b bVar) {
        return wp.b.a.j(this, kVar, bVar);
    }

    @Override // yp.r
    public boolean m(@os.l yp.o oVar) {
        return wp.b.a.K(this, oVar);
    }

    @Override // vp.i1
    @os.l
    public dp.d m0(@os.l yp.o oVar) {
        return wp.b.a.q(this, oVar);
    }

    @Override // yp.r
    @os.l
    public yp.n n(@os.l yp.c cVar) {
        return wp.b.a.r0(this, cVar);
    }

    @Override // vp.i1
    @os.m
    public yp.i n0(@os.l yp.i iVar) {
        return wp.b.a.v(this, iVar);
    }

    @Override // yp.r
    @os.l
    public yp.i o(@os.l yp.n nVar) {
        return wp.b.a.w(this, nVar);
    }

    @Override // yp.r
    @os.m
    public yp.p o0(@os.l v vVar) {
        return wp.b.a.x(this, vVar);
    }

    @Override // yp.r
    @os.m
    public yp.f p(@os.l yp.g gVar) {
        return wp.b.a.f(this, gVar);
    }

    @Override // yp.r
    @os.l
    public w p0(@os.l yp.n nVar) {
        return wp.b.a.z(this, nVar);
    }

    @Override // yp.r
    public int q(@os.l yp.m mVar) {
        return wp.b.a.s0(this, mVar);
    }

    @Override // yp.r
    @os.m
    public yp.e q0(@os.l yp.k kVar) {
        return wp.b.a.e(this, kVar);
    }

    @Override // yp.r
    @os.l
    public Collection<yp.i> r(@os.l yp.o oVar) {
        return wp.b.a.u0(this, oVar);
    }

    @Override // yp.r
    @os.m
    public yp.p r0(@os.l yp.o oVar) {
        return wp.b.a.y(this, oVar);
    }

    @Override // yp.r
    public boolean s(@os.l yp.k kVar) {
        return wp.b.a.e0(this, kVar);
    }

    @Override // yp.r
    @os.l
    public yp.o s0(@os.l yp.i iVar) {
        return wp.b.a.w0(this, iVar);
    }

    @Override // yp.r
    @os.l
    public yp.c t(@os.l yp.d dVar) {
        return wp.b.a.v0(this, dVar);
    }

    @Override // vp.i1
    public boolean t0(@os.l yp.o oVar) {
        return wp.b.a.h0(this, oVar);
    }

    @Override // yp.u
    public boolean u(@os.l yp.k kVar, @os.l yp.k kVar2) {
        return wp.b.a.E(this, kVar, kVar2);
    }

    @Override // yp.r
    @os.l
    public yp.k u0(@os.l yp.i iVar) {
        return wp.b.a.j0(this, iVar);
    }

    @Override // yp.r
    public boolean v(@os.l yp.o oVar) {
        return wp.b.a.G(this, oVar);
    }

    @Override // yp.r
    public boolean v0(@os.l yp.o oVar) {
        return wp.b.a.J(this, oVar);
    }

    @Override // yp.r
    public boolean w(@os.l yp.i iVar) {
        return wp.b.a.H(this, iVar);
    }

    @Override // yp.r
    public boolean w0(@os.l yp.n nVar) {
        return wp.b.a.d0(this, nVar);
    }

    @Override // yp.r
    @os.l
    public yp.n x(@os.l yp.m mVar, int i10) {
        return wp.b.a.n(this, mVar, i10);
    }

    @Override // yp.r
    @os.l
    public yp.i x0(@os.l yp.i iVar, boolean z10) {
        return wp.b.a.A0(this, iVar, z10);
    }

    @Override // yp.r
    @os.l
    public z0.b y(@os.l yp.k kVar) {
        return wp.b.a.t0(this, kVar);
    }

    @Override // yp.r
    @os.l
    public yp.i y0(@os.l yp.i iVar) {
        return wp.b.a.l0(this, iVar);
    }

    @Override // yp.r
    @os.l
    public w z(@os.l yp.p pVar) {
        return wp.b.a.A(this, pVar);
    }

    @Override // vp.i1
    @os.l
    public yp.i z0(@os.l yp.i iVar) {
        return wp.b.a.m0(this, iVar);
    }
}
