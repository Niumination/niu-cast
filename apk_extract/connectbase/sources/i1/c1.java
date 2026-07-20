package i1;

import f1.i3;
import f1.x7;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@w
public final class c1<N, E> extends e1<N, E> implements u0<N, E> {
    public c1(x0<? super N, ? super E> builder) {
        super(builder);
    }

    @Override // i1.u0
    @t1.a
    public boolean F(x<N> endpoints, E edge) {
        Q(endpoints);
        return M(endpoints.f7658a, endpoints.f7659b, edge);
    }

    @Override // i1.u0
    @t1.a
    public boolean I(E edge) {
        c1.h0.F(edge, "edge");
        N nF = this.f7534g.f(edge);
        boolean z10 = false;
        if (nF == null) {
            return false;
        }
        y0<N, E> y0VarF = this.f7533f.f(nF);
        Objects.requireNonNull(y0VarF);
        y0<N, E> y0Var = y0VarF;
        N nH = y0Var.h(edge);
        y0<N, E> y0VarF2 = this.f7533f.f(nH);
        Objects.requireNonNull(y0VarF2);
        y0<N, E> y0Var2 = y0VarF2;
        y0Var.j(edge);
        if (this.f7530c && nF.equals(nH)) {
            z10 = true;
        }
        y0Var2.d(edge, z10);
        this.f7534g.j(edge);
        return true;
    }

    @Override // i1.u0
    @t1.a
    public boolean M(N nodeU, N nodeV, E edge) {
        c1.h0.F(nodeU, "nodeU");
        c1.h0.F(nodeV, "nodeV");
        c1.h0.F(edge, "edge");
        if (this.f7534g.e(edge)) {
            x<N> xVarD = D(edge);
            x xVarI = x.i(this, nodeU, nodeV);
            c1.h0.z(xVarD.equals(xVarI), f0.f7542h, edge, xVarD, xVarI);
            return false;
        }
        y0<N, E> y0VarF = this.f7533f.f(nodeU);
        if (!this.f7529b) {
            c1.h0.y(y0VarF == null || !y0VarF.a().contains(nodeV), f0.f7544j, nodeU, nodeV);
        }
        boolean zEquals = nodeU.equals(nodeV);
        if (!this.f7530c) {
            c1.h0.u(!zEquals, f0.f7545k, nodeU);
        }
        if (y0VarF == null) {
            y0VarF = V(nodeU);
        }
        y0VarF.e(edge, nodeV);
        y0<N, E> y0VarF2 = this.f7533f.f(nodeV);
        if (y0VarF2 == null) {
            y0VarF2 = V(nodeV);
        }
        y0VarF2.f(edge, nodeU, zEquals);
        this.f7534g.i(edge, nodeU);
        return true;
    }

    @t1.a
    public final y0<N, E> V(N node) {
        y0<N, E> y0VarW = W();
        c1.h0.g0(this.f7533f.i(node, y0VarW) == null);
        return y0VarW;
    }

    public final y0<N, E> W() {
        if (this.f7528a) {
            return this.f7529b ? s.p() : t.n();
        }
        return this.f7529b ? k1.p() : l1.m();
    }

    @Override // i1.u0
    @t1.a
    public boolean o(N node) {
        c1.h0.F(node, "node");
        y0<N, E> y0VarF = this.f7533f.f(node);
        if (y0VarF == null) {
            return false;
        }
        x7<E> it = i3.copyOf((Collection) y0VarF.g()).iterator();
        while (it.hasNext()) {
            I(it.next());
        }
        this.f7533f.j(node);
        return true;
    }

    @Override // i1.u0
    @t1.a
    public boolean q(N node) {
        c1.h0.F(node, "node");
        if (this.f7533f.e(node)) {
            return false;
        }
        V(node);
        return true;
    }
}
