package wj;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.e
    public final vj.y2 f18750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t.a f18751b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u.a f18752a;

        public a(u.a aVar) {
            this.f18752a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.a aVar = this.f18752a;
            vj.y2 y2Var = j0.this.f18750a;
            y2Var.getClass();
            aVar.a(new vj.z2(y2Var));
        }
    }

    public j0(vj.y2 y2Var, t.a aVar) {
        c1.h0.e(!y2Var.r(), "error must not be OK");
        this.f18750a = y2Var;
        this.f18751b = aVar;
    }

    @Override // wj.u
    public void d(u.a aVar, Executor executor) {
        executor.execute(new a(aVar));
    }

    @Override // vj.m1
    public vj.c1 e() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // vj.a1
    public q1.s1<vj.v0.l> j() {
        q1.l2 l2VarF = q1.l2.F();
        l2VarF.B(null);
        return l2VarF;
    }

    @Override // wj.u
    public s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
        return new i0(this.f18750a, this.f18751b, nVarArr);
    }
}
