package tj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f15734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sj.t f15735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0 f15736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f15737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<d> f15738e;

    public u0(v0 v0Var, sj.t tVar, p0 p0Var, List<d> list, Set<d> set) {
        this.f15734a = v0Var;
        this.f15735b = tVar;
        this.f15736c = p0Var;
        this.f15737d = list;
        this.f15738e = set;
    }

    public static Set<d> e() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static d k(d dVar, c cVar, sj.t tVar) {
        try {
            return new u0(tVar, null).l(dVar, new x0(cVar)).f15745b;
        } catch (d.c e10) {
            throw new sj.c.d("NotPossibleToResolve was thrown from an outermost resolve", e10);
        }
    }

    public u0 a(d dVar) {
        if (m.N()) {
            m.K(b(), "++ Cycle marker " + dVar + "@" + System.identityHashCode(dVar));
        }
        if (this.f15738e.contains(dVar)) {
            throw new sj.c.d("Added cycle marker twice " + dVar);
        }
        Set<d> setE = e();
        setE.addAll(this.f15738e);
        setE.add(dVar);
        return new u0(this.f15734a, this.f15735b, this.f15736c, this.f15737d, setE);
    }

    public int b() {
        if (this.f15737d.size() <= 30) {
            return this.f15737d.size();
        }
        throw new sj.c.d("resolve getting too deep");
    }

    public boolean c() {
        return this.f15736c != null;
    }

    public final u0 d(l0 l0Var, d dVar) {
        return new u0(this.f15734a.b(l0Var, dVar), this.f15735b, this.f15736c, this.f15737d, this.f15738e);
    }

    public sj.t f() {
        return this.f15735b;
    }

    public u0 g() {
        ArrayList arrayList = new ArrayList(this.f15737d);
        d dVar = (d) arrayList.remove(this.f15737d.size() - 1);
        if (m.N()) {
            m.K(b() - 1, "popped trace " + dVar);
        }
        return new u0(this.f15734a, this.f15735b, this.f15736c, arrayList, this.f15738e);
    }

    public final u0 h(d dVar) {
        if (m.N()) {
            m.K(b(), "pushing trace " + dVar);
        }
        ArrayList arrayList = new ArrayList(this.f15737d);
        arrayList.add(dVar);
        return new u0(this.f15734a, this.f15735b, this.f15736c, arrayList, this.f15738e);
    }

    public final w0<? extends d> i(d dVar, x0 x0Var) throws d.c {
        u0 u0VarD;
        l0 l0Var = null;
        l0 l0Var2 = new l0(dVar, null);
        d dVarA = this.f15734a.a(l0Var2);
        if (dVarA == null && c()) {
            l0Var = new l0(dVar, this.f15736c);
            dVarA = this.f15734a.a(l0Var);
        }
        if (dVarA != null) {
            if (m.N()) {
                m.K(b(), "using cached resolution " + dVarA + " for " + dVar + " restrictToChild " + this.f15736c);
            }
            return new w0<>(this, dVarA);
        }
        if (m.N()) {
            m.K(b(), "not found in cache, resolving " + dVar + "@" + System.identityHashCode(dVar));
        }
        if (this.f15738e.contains(dVar)) {
            if (m.N()) {
                m.K(b(), "Cycle detected, can't resolve; " + dVar + "@" + System.identityHashCode(dVar));
            }
            throw new d.c(this);
        }
        w0<? extends d> w0VarResolveSubstitutions = dVar.resolveSubstitutions(this, x0Var);
        d dVar2 = w0VarResolveSubstitutions.f15745b;
        if (m.N()) {
            m.K(b(), "resolved to " + dVar2 + "@" + System.identityHashCode(dVar2) + " from " + dVar + "@" + System.identityHashCode(dVar2));
        }
        u0 u0Var = w0VarResolveSubstitutions.f15744a;
        if (dVar2 == null || dVar2.resolveStatus() == y0.RESOLVED) {
            if (m.N()) {
                m.K(b(), "caching " + l0Var2 + " result " + dVar2);
            }
            u0VarD = u0Var.d(l0Var2, dVar2);
        } else if (c()) {
            if (l0Var == null) {
                throw new sj.c.d("restrictedKey should not be null here");
            }
            if (m.N()) {
                m.K(b(), "caching " + l0Var + " result " + dVar2);
            }
            u0VarD = u0Var.d(l0Var, dVar2);
        } else {
            if (!this.f15735b.f15101b) {
                throw new sj.c.d("resolveSubstitutions() did not give us a resolved object");
            }
            if (m.N()) {
                m.K(b(), "caching " + l0Var2 + " result " + dVar2);
            }
            u0VarD = u0Var.d(l0Var2, dVar2);
        }
        return new w0<>(u0VarD, dVar2);
    }

    public u0 j(d dVar) {
        if (m.N()) {
            m.K(b(), "-- Cycle marker " + dVar + "@" + System.identityHashCode(dVar));
        }
        Set<d> setE = e();
        setE.addAll(this.f15738e);
        setE.remove(dVar);
        return new u0(this.f15734a, this.f15735b, this.f15736c, this.f15737d, setE);
    }

    public w0<? extends d> l(d dVar, x0 x0Var) throws d.c {
        if (m.N()) {
            m.K(b(), "resolving " + dVar + " restrictToChild=" + this.f15736c + " in " + x0Var);
        }
        return h(dVar).i(dVar, x0Var).d();
    }

    public u0 m(p0 p0Var) {
        return p0Var == this.f15736c ? this : new u0(this.f15734a, this.f15735b, p0Var, this.f15737d, this.f15738e);
    }

    public p0 n() {
        return this.f15736c;
    }

    public String o() {
        StringBuilder sb2 = new StringBuilder();
        for (d dVar : this.f15737d) {
            if (dVar instanceof f0) {
                sb2.append(((f0) dVar).f15604a.toString());
                sb2.append(", ");
            }
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 2);
        }
        return sb2.toString();
    }

    public u0 p() {
        return m(null);
    }

    public u0(sj.t tVar, p0 p0Var) {
        this(new v0(), tVar, p0Var, new ArrayList(), e());
        if (m.N()) {
            m.K(b(), "ResolveContext restrict to child " + p0Var);
        }
    }
}
