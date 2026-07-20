package i1;

import f1.t3;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@w
public class e1<N, E> extends j<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v<N> f7531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v<E> f7532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0<N, y0<N, E>> f7533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0<E, N> f7534g;

    public e1(x0<? super N, ? super E> x0Var, Map<N, y0<N, E>> map, Map<E, N> map2) {
        this.f7528a = x0Var.f7556a;
        this.f7529b = x0Var.f7660f;
        this.f7530c = x0Var.f7557b;
        v<? super N> vVar = x0Var.f7558c;
        vVar.getClass();
        this.f7531d = vVar;
        v<? super Object> vVar2 = x0Var.f7661g;
        vVar2.getClass();
        this.f7532e = vVar2;
        this.f7533f = map instanceof TreeMap ? new r0<>(map) : new q0<>(map);
        this.f7534g = new q0<>(map2);
    }

    @Override // i1.w0
    public x<N> D(E edge) {
        N nS = S(edge);
        y0<N, E> y0VarF = this.f7533f.f(nS);
        Objects.requireNonNull(y0VarF);
        return x.i(this, nS, y0VarF.h(edge));
    }

    @Override // i1.w0
    public v<E> H() {
        return this.f7532e;
    }

    @Override // i1.w0
    public Set<E> J(N node) {
        return R(node).i();
    }

    public final y0<N, E> R(N node) {
        y0<N, E> y0VarF = this.f7533f.f(node);
        if (y0VarF != null) {
            return y0VarF;
        }
        node.getClass();
        throw new IllegalArgumentException(String.format(f0.f7540f, node));
    }

    public final N S(E edge) {
        N nF = this.f7534g.f(edge);
        if (nF != null) {
            return nF;
        }
        edge.getClass();
        throw new IllegalArgumentException(String.format(f0.f7541g, edge));
    }

    public final boolean T(E edge) {
        return this.f7534g.e(edge);
    }

    public final boolean U(N node) {
        return this.f7533f.e(node);
    }

    @Override // i1.w0
    public Set<E> c() {
        q0<E, N> q0Var = this.f7534g;
        q0Var.getClass();
        return new q0.a();
    }

    @Override // i1.w0
    public boolean e() {
        return this.f7528a;
    }

    @Override // i1.w0
    public v<N> h() {
        return this.f7531d;
    }

    @Override // i1.w0
    public boolean j() {
        return this.f7530c;
    }

    @Override // i1.w0
    public Set<N> k(N node) {
        return R(node).c();
    }

    @Override // i1.w0
    public Set<E> l(N node) {
        return R(node).g();
    }

    @Override // i1.w0
    public Set<N> m() {
        q0<N, y0<N, E>> q0Var = this.f7533f;
        q0Var.getClass();
        return new q0.a();
    }

    @Override // i1.w0
    public Set<E> u(N node) {
        return R(node).k();
    }

    @Override // i1.j, i1.w0
    public Set<E> w(N nodeU, N nodeV) {
        y0<N, E> y0VarR = R(nodeU);
        if (!this.f7530c && nodeU == nodeV) {
            return t3.of();
        }
        c1.h0.u(this.f7533f.e(nodeV), f0.f7540f, nodeV);
        return y0VarR.l(nodeV);
    }

    @Override // i1.w0
    public boolean y() {
        return this.f7529b;
    }

    @Override // i1.w0, i1.a1
    public Set<N> a(N node) {
        return R(node).b();
    }

    @Override // i1.w0, i1.g1
    public Set<N> b(N node) {
        return R(node).a();
    }

    public e1(x0<? super N, ? super E> builder) {
        this(builder, builder.f7558c.c(builder.f7560e.or(10).intValue()), builder.f7661g.c(builder.f7662h.or(20).intValue()));
    }
}
