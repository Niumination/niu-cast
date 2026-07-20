package p001if;

import ad.b;
import af.k2;
import af.m0;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import k3.v8;
import u6.c;
import ze.a;
import ze.b1;
import ze.c0;
import ze.c1;
import ze.f0;
import ze.h;
import ze.i;
import ze.q2;
import ze.t2;
import ze.u2;
import ze.v2;
import ze.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends b1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f5841l = new a("addressTrackerKey");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f5842d;
    public final v2 e;
    public final d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k2 f5843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f5844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f5845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f5846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f5847k;

    public r(f0 f0Var) {
        k2 k2Var = k2.f377c;
        i iVarB = f0Var.b();
        this.f5847k = iVarB;
        this.f = new d(new c(this, f0Var));
        this.f5842d = new j();
        v2 v2VarD = f0Var.d();
        v8.i(v2VarD, "syncContext");
        this.e = v2VarD;
        ScheduledExecutorService scheduledExecutorServiceC = f0Var.c();
        v8.i(scheduledExecutorServiceC, "timeService");
        this.f5844h = scheduledExecutorServiceC;
        this.f5843g = k2Var;
        iVarB.f(h.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean g(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((c0) it.next()).f11332a.size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList h(j jVar, int i8) {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = jVar.values().iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.c() >= i8) {
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    @Override // ze.b1
    public final q2 a(y0 y0Var) {
        i iVar = this.f5847k;
        iVar.g(h.DEBUG, "Received resolution result: {0}", y0Var);
        m mVar = (m) y0Var.f11479c;
        ArrayList<SocketAddress> arrayList = new ArrayList();
        Iterator it = y0Var.f11477a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((c0) it.next()).f11332a);
        }
        j jVar = this.f5842d;
        jVar.keySet().retainAll(arrayList);
        Iterator it2 = jVar.f5818a.values().iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).f5814a = mVar;
        }
        for (SocketAddress socketAddress : arrayList) {
            HashMap map = jVar.f5818a;
            if (!map.containsKey(socketAddress)) {
                map.put(socketAddress, new i(mVar));
            }
        }
        c1 c1Var = mVar.f5830g.f207a;
        d dVar = this.f;
        dVar.i(c1Var);
        if (mVar.e == null && mVar.f == null) {
            c cVar = this.f5845i;
            if (cVar != null) {
                cVar.t();
                this.f5846j = null;
                for (i iVar2 : jVar.f5818a.values()) {
                    if (iVar2.d()) {
                        iVar2.e();
                    }
                    iVar2.e = 0;
                }
            }
        } else {
            Long l4 = this.f5846j;
            Long l8 = mVar.f5826a;
            Long lValueOf = l4 == null ? l8 : Long.valueOf(Math.max(0L, l8.longValue() - (this.f5843g.g() - this.f5846j.longValue())));
            c cVar2 = this.f5845i;
            if (cVar2 != null) {
                cVar2.t();
                for (i iVar3 : jVar.f5818a.values()) {
                    b bVar = iVar3.f5815b;
                    ((AtomicLong) bVar.f92a).set(0L);
                    ((AtomicLong) bVar.f93b).set(0L);
                    b bVar2 = iVar3.f5816c;
                    ((AtomicLong) bVar2.f92a).set(0L);
                    ((AtomicLong) bVar2.f93b).set(0L);
                }
            }
            m0 m0Var = new m0(this, 7, mVar, iVar);
            long jLongValue = lValueOf.longValue();
            long jLongValue2 = l8.longValue();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            v2 v2Var = this.e;
            v2Var.getClass();
            u2 u2Var = new u2(m0Var);
            this.f5845i = new c(u2Var, this.f5844h.scheduleWithFixedDelay(new t2(v2Var, u2Var, m0Var, jLongValue2), jLongValue, jLongValue2, timeUnit));
        }
        ze.b bVar3 = ze.b.f11321b;
        dVar.d(new y0(y0Var.f11477a, y0Var.f11478b, mVar.f5830g.f208b));
        return q2.e;
    }

    @Override // ze.b1
    public final void c(q2 q2Var) {
        this.f.c(q2Var);
    }

    @Override // ze.b1
    public final void f() {
        this.f.f();
    }
}
