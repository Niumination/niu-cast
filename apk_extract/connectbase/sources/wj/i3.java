package wj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class i3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i3 f18740c = new i3(new vj.b3[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.b3[] f18741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f18742b = new AtomicBoolean(false);

    @b1.e
    public i3(vj.b3[] b3VarArr) {
        this.f18741a = b3VarArr;
    }

    public static i3 i(vj.n[] nVarArr, vj.a aVar, vj.v1 v1Var) {
        i3 i3Var = new i3(nVarArr);
        for (vj.n nVar : nVarArr) {
            nVar.n(aVar, v1Var);
        }
        return i3Var;
    }

    public static i3 j(List<? extends vj.u2.a> list, String str, vj.v1 v1Var) {
        if (list.isEmpty()) {
            return f18740c;
        }
        int size = list.size();
        vj.b3[] b3VarArr = new vj.b3[size];
        for (int i10 = 0; i10 < size; i10++) {
            b3VarArr[i10] = list.get(i10).a(str, v1Var);
        }
        return new i3(b3VarArr);
    }

    public void a() {
        for (vj.b3 b3Var : this.f18741a) {
            ((vj.n) b3Var).k();
        }
    }

    public void b(vj.v1 v1Var) {
        for (vj.b3 b3Var : this.f18741a) {
            ((vj.n) b3Var).l(v1Var);
        }
    }

    public void c() {
        for (vj.b3 b3Var : this.f18741a) {
            ((vj.n) b3Var).m();
        }
    }

    @b1.e
    public List<vj.b3> d() {
        return new ArrayList(Arrays.asList(this.f18741a));
    }

    public void e(int i10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.a(i10);
        }
    }

    public void f(int i10, long j10, long j11) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.b(i10, j10, j11);
        }
    }

    public void g(long j10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.c(j10);
        }
    }

    public void h(long j10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.d(j10);
        }
    }

    public void k(int i10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.e(i10);
        }
    }

    public void l(int i10, long j10, long j11) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.f(i10, j10, j11);
        }
    }

    public void m(long j10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.g(j10);
        }
    }

    public void n(long j10) {
        for (vj.b3 b3Var : this.f18741a) {
            b3Var.h(j10);
        }
    }

    public void o(vj.u2.c<?, ?> cVar) {
        for (vj.b3 b3Var : this.f18741a) {
            ((vj.u2) b3Var).l(cVar);
        }
    }

    public <ReqT, RespT> vj.w p(vj.w wVar) {
        vj.w wVarJ = (vj.w) c1.h0.F(wVar, "context");
        for (vj.b3 b3Var : this.f18741a) {
            wVarJ = ((vj.u2) b3Var).j(wVarJ);
            c1.h0.V(wVarJ, "%s returns null context", b3Var);
        }
        return wVarJ;
    }

    public void q(vj.y2 y2Var) {
        if (this.f18742b.compareAndSet(false, true)) {
            for (vj.b3 b3Var : this.f18741a) {
                b3Var.i(y2Var);
            }
        }
    }
}
