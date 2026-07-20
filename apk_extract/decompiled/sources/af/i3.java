package af;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qf.c f325d;
    public final ze.r0 e;
    public final t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f2 f328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u6.c f331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j3 f332m;

    public i3(j3 j3Var, qf.c cVar) {
        this.f332m = j3Var;
        List list = (List) cVar.f9047b;
        this.f327h = list;
        j3Var.getClass();
        this.f325d = cVar;
        ze.r0 r0Var = new ze.r0("Subchannel", j3Var.f362t.b(), ze.r0.f11418d.incrementAndGet());
        this.e = r0Var;
        Logger logger = j3.c0;
        k2 k2Var = j3Var.f356l;
        v vVar = new v(r0Var, k2Var.g(), "Subchannel for " + list);
        this.f326g = vVar;
        this.f = new t(vVar, k2Var);
    }

    @Override // ze.i
    public final List a() {
        this.f332m.f357m.d();
        v8.n(this.f329j, "not started");
        return this.f327h;
    }

    @Override // ze.i
    public final ze.b b() {
        return (ze.b) this.f325d.f9048c;
    }

    @Override // ze.i
    public final ze.i c() {
        return this.f;
    }

    @Override // ze.i
    public final Object d() {
        v8.n(this.f329j, "Subchannel is not started");
        return this.f328i;
    }

    @Override // ze.i
    public final void o() {
        this.f332m.f357m.d();
        v8.n(this.f329j, "not started");
        f2 f2Var = this.f328i;
        if (f2Var.u != null) {
            return;
        }
        f2Var.f267j.execute(new w1(f2Var, 1));
    }

    @Override // ze.i
    public final void p() {
        u6.c cVar;
        j3 j3Var = this.f332m;
        j3Var.f357m.d();
        if (this.f328i == null) {
            this.f330k = true;
            return;
        }
        if (!this.f330k) {
            this.f330k = true;
        } else {
            if (!j3Var.H || (cVar = this.f331l) == null) {
                return;
            }
            cVar.t();
            this.f331l = null;
        }
        if (!j3Var.H) {
            this.f331l = j3Var.f357m.c(new r2(new f(this, 6)), 5L, TimeUnit.SECONDS, j3Var.f.f520a.f1560d);
            return;
        }
        f2 f2Var = this.f328i;
        ze.q2 q2Var = j3.f0;
        f2Var.getClass();
        f2Var.f267j.execute(new x1(f2Var, q2Var, 0));
    }

    @Override // ze.i
    public final void r(ze.a1 a1Var) {
        j3 j3Var = this.f332m;
        j3Var.f357m.d();
        v8.n(!this.f329j, "already started");
        v8.n(!this.f330k, "already shutdown");
        v8.n(!j3Var.H, "Channel is being terminated");
        this.f329j = true;
        List list = (List) this.f325d.f9047b;
        String strB = j3Var.f362t.b();
        q qVar = j3Var.f;
        ScheduledExecutorService scheduledExecutorService = qVar.f520a.f1560d;
        l6 l6Var = new l6(3, this, a1Var);
        j3Var.K.getClass();
        f2 f2Var = new f2(list, strB, j3Var.f361s, qVar, scheduledExecutorService, j3Var.p, j3Var.f357m, l6Var, j3Var.O, new r(), this.f326g, this.e, this.f);
        ze.l0 l0Var = ze.l0.CT_INFO;
        long jG = j3Var.f356l.g();
        v8.i(l0Var, "severity");
        j3Var.M.b(new ze.m0("Child Subchannel started", l0Var, jG, f2Var));
        this.f328i = f2Var;
        ze.o0.a(j3Var.O.f11392c, f2Var);
        j3Var.f367z.add(f2Var);
    }

    @Override // ze.i
    public final void t(List list) {
        this.f332m.f357m.d();
        this.f327h = list;
        f2 f2Var = this.f328i;
        f2Var.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v8.i(it.next(), "newAddressGroups contains null entry");
        }
        v8.c("newAddressGroups is empty", !list.isEmpty());
        f2Var.f267j.execute(new e(15, f2Var, Collections.unmodifiableList(new ArrayList(list))));
    }

    public final String toString() {
        return this.e.toString();
    }
}
