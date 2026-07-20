package af;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ze.q2 f681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f2 f682c;

    public /* synthetic */ x1(f2 f2Var, ze.q2 q2Var, int i8) {
        this.f680a = i8;
        this.f682c = f2Var;
        this.f681b = q2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f680a) {
            case 0:
                ze.q qVar = this.f682c.f276v.f11416a;
                ze.q qVar2 = ze.q.SHUTDOWN;
                if (qVar != qVar2) {
                    f2 f2Var = this.f682c;
                    f2Var.f277w = this.f681b;
                    j0 j0Var = f2Var.u;
                    f2 f2Var2 = this.f682c;
                    a2 a2Var = f2Var2.f275t;
                    f2Var2.u = null;
                    f2 f2Var3 = this.f682c;
                    f2Var3.f275t = null;
                    f2.b(f2Var3, qVar2);
                    this.f682c.f268k.a();
                    if (this.f682c.f273r.isEmpty()) {
                        f2 f2Var4 = this.f682c;
                        f2Var4.getClass();
                        f2Var4.f267j.execute(new w1(f2Var4, 2));
                    }
                    f2 f2Var5 = this.f682c;
                    f2Var5.f267j.d();
                    u6.c cVar = f2Var5.f272o;
                    if (cVar != null) {
                        cVar.t();
                        f2Var5.f272o = null;
                        f2Var5.f270m = null;
                    }
                    u6.c cVar2 = this.f682c.p;
                    if (cVar2 != null) {
                        cVar2.t();
                        this.f682c.q.c(this.f681b);
                        f2 f2Var6 = this.f682c;
                        f2Var6.p = null;
                        f2Var6.q = null;
                    }
                    if (j0Var != null) {
                        j0Var.c(this.f681b);
                    }
                    if (a2Var != null) {
                        a2Var.c(this.f681b);
                    }
                    break;
                }
                break;
            default:
                Iterator it = new ArrayList(this.f682c.f273r).iterator();
                while (it.hasNext()) {
                    ((r3) it.next()).a(this.f681b);
                }
                break;
        }
    }
}
