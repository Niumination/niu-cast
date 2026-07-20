package p001if;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import k3.v8;
import n6.a;
import ze.a1;
import ze.b;
import ze.c0;
import ze.h;
import ze.i;
import ze.q2;
import ze.r;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f5836d;
    public i e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f5837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a1 f5838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f5839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r f5840j;

    public q(r rVar, i iVar) {
        this.f5840j = rVar;
        this.f5836d = iVar;
        this.f5839i = iVar.c();
    }

    @Override // ze.i
    public final List a() {
        return this.f5836d.a();
    }

    @Override // ze.i
    public final b b() {
        i iVar = this.e;
        i iVar2 = this.f5836d;
        if (iVar == null) {
            return iVar2.b();
        }
        a aVarA = iVar2.b().a();
        aVarA.j(r.f5841l, this.e);
        return aVarA.g();
    }

    @Override // ze.i
    public final i c() {
        return this.f5836d.c();
    }

    @Override // ze.i
    public final Object d() {
        return this.f5836d.d();
    }

    @Override // ze.i
    public final void o() {
        this.f5836d.o();
    }

    @Override // ze.i
    public final void p() {
        i iVar = this.e;
        if (iVar != null) {
            this.e = null;
            iVar.f.remove(this);
        }
        this.f5836d.p();
    }

    @Override // ze.i
    public final void r(a1 a1Var) {
        this.f5838h = a1Var;
        this.f5836d.r(new f5.a(this, a1Var));
    }

    @Override // ze.i
    public final void t(List list) {
        i iVar = this.f5836d;
        boolean zG = r.g(iVar.a());
        r rVar = this.f5840j;
        if (zG && r.g(list)) {
            if (rVar.f5842d.containsValue(this.e)) {
                i iVar2 = this.e;
                iVar2.getClass();
                this.e = null;
                iVar2.f.remove(this);
            }
            SocketAddress socketAddress = (SocketAddress) ((c0) list.get(0)).f11332a.get(0);
            if (rVar.f5842d.containsKey(socketAddress)) {
                ((i) rVar.f5842d.get(socketAddress)).a(this);
            }
        } else if (r.g(iVar.a()) && !r.g(list)) {
            j jVar = rVar.f5842d;
            List listA = this.f5836d.a();
            v8.l("%s does not have exactly one group", listA.size() == 1, listA);
            if (jVar.containsKey(((c0) listA.get(0)).f11332a.get(0))) {
                j jVar2 = rVar.f5842d;
                List listA2 = this.f5836d.a();
                v8.l("%s does not have exactly one group", listA2.size() == 1, listA2);
                i iVar3 = (i) jVar2.get(((c0) listA2.get(0)).f11332a.get(0));
                iVar3.getClass();
                this.e = null;
                iVar3.f.remove(this);
                ad.b bVar = iVar3.f5815b;
                ((AtomicLong) bVar.f92a).set(0L);
                ((AtomicLong) bVar.f93b).set(0L);
                ad.b bVar2 = iVar3.f5816c;
                ((AtomicLong) bVar2.f92a).set(0L);
                ((AtomicLong) bVar2.f93b).set(0L);
            }
        } else if (!r.g(iVar.a()) && r.g(list)) {
            SocketAddress socketAddress2 = (SocketAddress) ((c0) list.get(0)).f11332a.get(0);
            if (rVar.f5842d.containsKey(socketAddress2)) {
                ((i) rVar.f5842d.get(socketAddress2)).a(this);
            }
        }
        iVar.t(list);
    }

    public final String toString() {
        return "OutlierDetectionSubchannel{addresses=" + this.f5836d.a() + '}';
    }

    public final void u() {
        this.f = true;
        a1 a1Var = this.f5838h;
        q2 q2Var = q2.f11411n;
        v8.c("The error status must not be OK", true ^ q2Var.e());
        a1Var.a(new r(ze.q.TRANSIENT_FAILURE, q2Var));
        this.f5839i.g(h.INFO, "Subchannel ejected: {0}", this);
    }
}
