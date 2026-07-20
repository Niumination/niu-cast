package tj;

/* JADX INFO: loaded from: classes2.dex */
public class h1 implements sj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f15623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sj.q f15624b;

    public h1(o0 o0Var) {
        this.f15623a = o0Var;
        this.f15624b = i1.f(o0Var.b());
    }

    @Override // sj.e
    public sj.r a(String str) {
        if (m.M()) {
            StringBuilder sbA = e.a.a("Looking for '", str, "' relative to ");
            sbA.append(this.f15623a);
            m.L(sbA.toString());
        }
        o0 o0Var = this.f15623a;
        if (o0Var != null) {
            return o0Var.a(str);
        }
        return null;
    }

    @Override // sj.e
    public sj.q b() {
        return this.f15624b;
    }

    @Override // sj.e
    public sj.e c(sj.q qVar) {
        return new h1(this.f15623a, qVar.m(null).l(null));
    }

    public h1 d(o0 o0Var) {
        return o0Var == this.f15623a ? this : new h1(o0Var);
    }

    public h1(o0 o0Var, sj.q qVar) {
        this.f15623a = o0Var;
        this.f15624b = qVar;
    }
}
