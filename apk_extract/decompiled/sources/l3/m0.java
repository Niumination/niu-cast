package l3;

/* JADX INFO: loaded from: classes.dex */
public abstract class m0 implements Cloneable, r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f7269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q0 f7270b;

    public m0(q0 q0Var) {
        this.f7269a = q0Var;
        if (q0Var.k()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f7270b = (q0) q0Var.n(4, null);
    }

    @Override // l3.r1
    public final boolean a() {
        return q0.j(this.f7270b, false);
    }

    public final void b(q0 q0Var) {
        if (this.f7269a.equals(q0Var)) {
            return;
        }
        if (!this.f7270b.k()) {
            h();
        }
        q0 q0Var2 = this.f7270b;
        y1.f7325c.b(q0Var2.getClass()).f(q0Var2, q0Var);
    }

    public final q0 c() {
        q0 q0VarD = d();
        q0VarD.getClass();
        if (q0.j(q0VarD, true)) {
            return q0VarD;
        }
        throw new n2(q0VarD);
    }

    public final Object clone() {
        m0 m0Var = (m0) this.f7269a.n(5, null);
        m0Var.f7270b = d();
        return m0Var;
    }

    public q0 d() {
        if (!this.f7270b.k()) {
            return this.f7270b;
        }
        q0 q0Var = this.f7270b;
        q0Var.getClass();
        y1.f7325c.b(q0Var.getClass()).b(q0Var);
        q0Var.g();
        return this.f7270b;
    }

    public /* bridge */ q1 e() {
        return d();
    }

    public final void f() {
        if (this.f7270b.k()) {
            return;
        }
        h();
    }

    public void h() {
        q0 q0Var = (q0) this.f7269a.n(4, null);
        y1.f7325c.b(q0Var.getClass()).f(q0Var, this.f7270b);
        this.f7270b = q0Var;
    }
}
