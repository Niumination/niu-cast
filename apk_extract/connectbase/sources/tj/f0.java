package tj;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends d implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f15604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15605b;

    public f0(sj.o oVar, j1 j1Var) {
        this(oVar, j1Var, 0);
    }

    private sj.c.h i() {
        return new sj.c.h("need to Config#resolve(), see the API docs for Config#resolve(); substitution not resolved: " + this);
    }

    @Override // tj.o1
    public Collection<f0> a() {
        return Collections.singleton(this);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof f0;
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        return (obj instanceof f0) && (obj instanceof f0) && this.f15604a.equals(((f0) obj).f15604a);
    }

    public j1 f() {
        return this.f15604a;
    }

    @Override // tj.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public f0 newCopy(sj.o oVar) {
        return new f0(oVar, this.f15604a, this.f15605b);
    }

    @Override // tj.d
    public int hashCode() {
        return this.f15604a.hashCode();
    }

    @Override // tj.d
    public boolean ignoresFallbacks() {
        return false;
    }

    @Override // tj.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f0 relativized(p0 p0Var) {
        j1 j1Var = this.f15604a;
        j1 j1VarA = j1Var.a(j1Var.f15632a.i(p0Var));
        return new f0(origin(), j1VarA, p0Var.e() + this.f15605b);
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        sb2.append(this.f15604a.toString());
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.UNRESOLVED;
    }

    @Override // tj.d
    public w0<? extends d> resolveSubstitutions(u0 u0Var, x0 x0Var) {
        d dVar;
        u0 u0VarA = u0Var.a(this);
        try {
            x0.b bVarD = x0Var.d(u0VarA, this.f15604a, this.f15605b);
            w0<? extends d> w0Var = bVarD.f15750a;
            u0VarA = w0Var.f15744a;
            if (w0Var.f15745b != 0) {
                if (m.N()) {
                    m.K(u0VarA.b(), "recursively resolving " + bVarD + " which was the resolution of " + this.f15604a + " against " + x0Var);
                }
                x0 x0Var2 = new x0((c) bVarD.f15751b.b(), bVarD.f15751b);
                if (m.N()) {
                    m.K(u0VarA.b(), "will recursively resolve against " + x0Var2);
                }
                w0<? extends d> w0VarL = u0VarA.l(bVarD.f15750a.f15745b, x0Var2);
                dVar = w0VarL.f15745b;
                u0VarA = w0VarL.f15744a;
            } else {
                dVar = (V) u0Var.f15735b.f15102c.a(this.f15604a.f15632a.k());
            }
        } catch (d.c e10) {
            if (m.N()) {
                m.K(u0VarA.b(), "not possible to resolve " + this.f15604a + ", cycle involved: " + e10.traceString());
            }
            if (!this.f15604a.f15633b) {
                throw new sj.c.k(origin(), this.f15604a + " was part of a cycle of substitutions involving " + e10.traceString(), e10);
            }
            dVar = null;
        }
        if (dVar != null || this.f15604a.f15633b) {
            return new w0<>(u0VarA.j(this), dVar);
        }
        if (u0VarA.f15735b.f15101b) {
            return new w0<>(u0VarA.j(this), this);
        }
        throw new sj.c.k(origin(), this.f15604a.toString());
    }

    @Override // sj.x
    public Object unwrapped() {
        throw i();
    }

    @Override // sj.x
    public sj.z valueType() {
        throw i();
    }

    public f0(sj.o oVar, j1 j1Var, int i10) {
        super(oVar);
        this.f15604a = j1Var;
        this.f15605b = i10;
    }
}
