package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public abstract class f<N> extends a<N> implements c0<N> {
    @Override // i1.a, i1.n
    public Set c() {
        return new a.C0206a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean d(Object nodeU, Object nodeV) {
        return super.d(nodeU, nodeV);
    }

    @Override // i1.c0
    public final boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return e() == c0Var.e() && m().equals(c0Var.m()) && c().equals(c0Var.c());
    }

    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean f(x endpoints) {
        return super.f(endpoints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int g(Object node) {
        return super.g(node);
    }

    @Override // i1.c0
    public final int hashCode() {
        return c().hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int i(Object node) {
        return super.i(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ Set l(Object node) {
        return super.l(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int n(Object node) {
        return super.n(node);
    }

    @Override // i1.a, i1.n
    public v p() {
        return v.i();
    }

    public String toString() {
        return "isDirected: " + e() + ", allowsSelfLoops: " + j() + ", nodes: " + m() + ", edges: " + c();
    }
}
