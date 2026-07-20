package i1;

/* JADX INFO: loaded from: classes.dex */
@w
public final class b1<N> extends z<N> implements t0<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<N, f0.a> f7520a;

    public b1(g<? super N> builder) {
        this.f7520a = new d1(builder);
    }

    @Override // i1.t0
    public boolean C(x<N> endpoints) {
        P(endpoints);
        return G(endpoints.f7658a, endpoints.f7659b);
    }

    @Override // i1.t0
    public boolean G(N nodeU, N nodeV) {
        return this.f7520a.K(nodeU, nodeV, f0.a.EDGE_EXISTS) == null;
    }

    @Override // i1.z
    public n<N> Q() {
        return this.f7520a;
    }

    @Override // i1.t0
    public boolean o(N node) {
        return this.f7520a.o(node);
    }

    @Override // i1.t0
    public boolean q(N node) {
        return this.f7520a.q(node);
    }

    @Override // i1.t0
    public boolean r(N nodeU, N nodeV) {
        return this.f7520a.r(nodeU, nodeV) != null;
    }

    @Override // i1.t0
    public boolean s(x<N> endpoints) {
        P(endpoints);
        return r(endpoints.f7658a, endpoints.f7659b);
    }
}
