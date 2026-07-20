package i1;

import f1.i3;
import f1.x7;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@w
public final class d1<N, V> extends f1<N, V> implements v0<N, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v<N> f7523f;

    public d1(g<? super N> gVar) {
        super(gVar);
        v<? super N> vVar = gVar.f7559d;
        vVar.getClass();
        this.f7523f = vVar;
    }

    @Override // i1.v0
    @gm.a
    @t1.a
    public V K(N nodeU, N nodeV, V value) {
        c1.h0.F(nodeU, "nodeU");
        c1.h0.F(nodeV, "nodeV");
        c1.h0.F(value, "value");
        if (!this.f7551b) {
            c1.h0.u(!nodeU.equals(nodeV), f0.f7545k, nodeU);
        }
        e0<N, V> e0VarF = this.f7553d.f(nodeU);
        if (e0VarF == null) {
            e0VarF = X(nodeU);
        }
        V vH = e0VarF.h(nodeV, value);
        e0<N, V> e0VarF2 = this.f7553d.f(nodeV);
        if (e0VarF2 == null) {
            e0VarF2 = X(nodeV);
        }
        e0VarF2.i(nodeU, value);
        if (vH == null) {
            long j10 = this.f7554e + 1;
            this.f7554e = j10;
            g0.e(j10);
        }
        return vH;
    }

    @Override // i1.v0
    @gm.a
    @t1.a
    public V L(x<N> endpoints, V value) {
        P(endpoints);
        return K(endpoints.f7658a, endpoints.f7659b, value);
    }

    @t1.a
    public final e0<N, V> X(N node) {
        e0<N, V> e0VarY = Y();
        c1.h0.g0(this.f7553d.i(node, e0VarY) == null);
        return e0VarY;
    }

    public final e0<N, V> Y() {
        return this.f7550a ? r.x(this.f7523f) : j1.l(this.f7523f);
    }

    @Override // i1.v0
    @t1.a
    public boolean o(N n10) {
        c1.h0.F(n10, "node");
        e0 e0Var = (e0<N, V>) this.f7553d.f(n10);
        if (e0Var == null) {
            return false;
        }
        if (this.f7551b && e0Var.e(n10) != null) {
            e0Var.f(n10);
            this.f7554e--;
        }
        x7 it = i3.copyOf((Collection) e0Var.a()).iterator();
        while (it.hasNext()) {
            E next = it.next();
            e0<N, V> e0VarH = this.f7553d.h(next);
            Objects.requireNonNull(e0VarH);
            e0VarH.f(n10);
            Objects.requireNonNull(e0Var.e(next));
            this.f7554e--;
        }
        if (this.f7550a) {
            x7 it2 = i3.copyOf((Collection) e0Var.b()).iterator();
            while (it2.hasNext()) {
                E next2 = it2.next();
                e0<N, V> e0VarH2 = this.f7553d.h(next2);
                Objects.requireNonNull(e0VarH2);
                c1.h0.g0(e0VarH2.e(n10) != null);
                e0Var.f(next2);
                this.f7554e--;
            }
        }
        this.f7553d.j(n10);
        g0.c(this.f7554e);
        return true;
    }

    @Override // i1.m, i1.a, i1.n
    public v<N> p() {
        return this.f7523f;
    }

    @Override // i1.v0
    @t1.a
    public boolean q(N node) {
        c1.h0.F(node, "node");
        if (this.f7553d.e(node)) {
            return false;
        }
        X(node);
        return true;
    }

    @Override // i1.v0
    @gm.a
    @t1.a
    public V r(N nodeU, N nodeV) {
        c1.h0.F(nodeU, "nodeU");
        c1.h0.F(nodeV, "nodeV");
        e0<N, V> e0VarF = this.f7553d.f(nodeU);
        e0<N, V> e0VarF2 = this.f7553d.f(nodeV);
        if (e0VarF == null || e0VarF2 == null) {
            return null;
        }
        V vE = e0VarF.e(nodeV);
        if (vE != null) {
            e0VarF2.f(nodeU);
            long j10 = this.f7554e - 1;
            this.f7554e = j10;
            g0.c(j10);
        }
        return vE;
    }

    @Override // i1.v0
    @gm.a
    @t1.a
    public V s(x<N> endpoints) {
        P(endpoints);
        return r(endpoints.f7658a, endpoints.f7659b);
    }
}
