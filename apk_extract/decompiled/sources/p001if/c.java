package p001if;

import af.e4;
import java.util.List;
import k3.v8;
import ze.b1;
import ze.c0;
import ze.f0;
import ze.i;
import ze.q;
import ze.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5791a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b1 f5793c;

    public c(d dVar) {
        this.f5793c = dVar;
    }

    @Override // p001if.a, ze.f0
    public i a(qf.c cVar) {
        switch (this.f5791a) {
            case 1:
                i iVarA = ((f0) this.f5792b).a(cVar);
                r rVar = (r) this.f5793c;
                q qVar = new q(rVar, iVarA);
                List list = (List) cVar.f9047b;
                if (r.g(list) && rVar.f5842d.containsKey(((c0) list.get(0)).f11332a.get(0))) {
                    i iVar = (i) rVar.f5842d.get(((c0) list.get(0)).f11332a.get(0));
                    iVar.a(qVar);
                    if (iVar.f5817d != null) {
                        qVar.u();
                    }
                }
                return qVar;
            default:
                return super.a(cVar);
        }
    }

    @Override // ze.f0
    public final void m(q qVar, z0 z0Var) {
        switch (this.f5791a) {
            case 0:
                b1 b1Var = (b1) this.f5792b;
                d dVar = (d) this.f5793c;
                b1 b1Var2 = dVar.f5798i;
                if (b1Var == b1Var2) {
                    v8.n(dVar.f5801l, "there's pending lb while current lb has been out of READY");
                    dVar.f5799j = qVar;
                    dVar.f5800k = z0Var;
                    if (qVar == q.READY) {
                        dVar.h();
                    }
                } else if (b1Var == dVar.f5796g) {
                    boolean z2 = qVar == q.READY;
                    dVar.f5801l = z2;
                    if (z2 || b1Var2 == dVar.f5795d) {
                        dVar.e.m(qVar, z0Var);
                    } else {
                        dVar.h();
                    }
                }
                break;
            default:
                ((f0) this.f5792b).m(qVar, new e4(z0Var));
                break;
        }
    }

    @Override // p001if.a
    public final f0 n() {
        switch (this.f5791a) {
            case 0:
                return ((d) this.f5793c).e;
            default:
                return (f0) this.f5792b;
        }
    }

    public c(r rVar, f0 f0Var) {
        this.f5793c = rVar;
        this.f5792b = f0Var;
    }
}
