package wj;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class e1 implements vj.a1<vj.v0.b>, p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f18532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wj.k.a f18535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f18536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v f18537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f18538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vj.v0 f18539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wj.o f18540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q f18541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vj.h f18542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<vj.o> f18543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final vj.c3 f18544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f18545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile List<vj.d0> f18546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public wj.k f18547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c1.o0 f18548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @gm.j
    public vj.c3.d f18549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @gm.j
    public vj.c3.d f18550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @gm.j
    public r1 f18551t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @gm.j
    public x f18554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @gm.j
    public volatile r1 f18555x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public vj.y2 f18557z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Collection<x> f18552u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a1<x> f18553v = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile vj.v f18556y = vj.v.a(vj.u.IDLE);

    public class a extends a1<x> {
        public a() {
        }

        @Override // wj.a1
        public void b() {
            e1 e1Var = e1.this;
            e1Var.f18536e.a(e1Var);
        }

        @Override // wj.a1
        public void c() {
            e1 e1Var = e1.this;
            e1Var.f18536e.b(e1Var);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e1 e1Var = e1.this;
            e1Var.f18549r = null;
            e1Var.f18542k.a(vj.h.a.INFO, "CONNECTING after backoff");
            e1.this.X(vj.u.CONNECTING);
            e1.this.e0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e1.this.f18556y.f17279a == vj.u.IDLE) {
                e1.this.f18542k.a(vj.h.a.INFO, "CONNECTING as requested");
                e1.this.X(vj.u.CONNECTING);
                e1.this.e0();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e1.this.f18556y.f17279a != vj.u.TRANSIENT_FAILURE) {
                return;
            }
            e1.this.Q();
            e1.this.f18542k.a(vj.h.a.INFO, "CONNECTING; backoff interrupted");
            e1.this.X(vj.u.CONNECTING);
            e1.this.e0();
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f18562a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e1 e1Var = e1.this;
                r1 r1Var = e1Var.f18551t;
                e1Var.f18550s = null;
                e1Var.f18551t = null;
                r1Var.n(vj.y2.f17563t.u("InternalSubchannel closed transport due to address change"));
            }
        }

        public e(List list) {
            this.f18562a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            r1 r1Var;
            SocketAddress socketAddressA = e1.this.f18545n.a();
            e1.this.f18545n.i(this.f18562a);
            e1.this.f18546o = this.f18562a;
            vj.u uVar = e1.this.f18556y.f17279a;
            vj.u uVar2 = vj.u.READY;
            if ((uVar != uVar2 && e1.this.f18556y.f17279a != vj.u.CONNECTING) || e1.this.f18545n.h(socketAddressA)) {
                r1Var = null;
            } else if (e1.this.f18556y.f17279a == uVar2) {
                r1Var = e1.this.f18555x;
                e1.this.f18555x = null;
                e1.this.f18545n.g();
                e1.this.X(vj.u.IDLE);
            } else {
                e1.this.f18554w.n(vj.y2.f17563t.u("InternalSubchannel closed pending transport due to address change"));
                e1 e1Var = e1.this;
                e1Var.f18554w = null;
                e1Var.f18545n.g();
                e1.this.e0();
                r1Var = null;
            }
            if (r1Var != null) {
                e1 e1Var2 = e1.this;
                if (e1Var2.f18550s != null) {
                    e1Var2.f18551t.n(vj.y2.f17563t.u("InternalSubchannel closed transport early due to address change"));
                    e1.this.f18550s.a();
                    e1 e1Var3 = e1.this;
                    e1Var3.f18550s = null;
                    e1Var3.f18551t = null;
                }
                e1 e1Var4 = e1.this;
                e1Var4.f18551t = r1Var;
                e1Var4.f18550s = e1Var4.f18544m.c(new a(), 5L, TimeUnit.SECONDS, e1.this.f18538g);
            }
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18565a;

        public f(vj.y2 y2Var) {
            this.f18565a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.u uVar = e1.this.f18556y.f17279a;
            vj.u uVar2 = vj.u.SHUTDOWN;
            if (uVar == uVar2) {
                return;
            }
            e1 e1Var = e1.this;
            e1Var.f18557z = this.f18565a;
            r1 r1Var = e1Var.f18555x;
            e1 e1Var2 = e1.this;
            x xVar = e1Var2.f18554w;
            e1Var2.f18555x = null;
            e1 e1Var3 = e1.this;
            e1Var3.f18554w = null;
            e1Var3.X(uVar2);
            e1.this.f18545n.g();
            if (e1.this.f18552u.isEmpty()) {
                e1.this.Z();
            }
            e1.this.Q();
            vj.c3.d dVar = e1.this.f18550s;
            if (dVar != null) {
                dVar.a();
                e1.this.f18551t.n(this.f18565a);
                e1 e1Var4 = e1.this;
                e1Var4.f18550s = null;
                e1Var4.f18551t = null;
            }
            if (r1Var != null) {
                r1Var.n(this.f18565a);
            }
            if (xVar != null) {
                xVar.n(this.f18565a);
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e1.this.f18542k.a(vj.h.a.INFO, "Terminated");
            e1 e1Var = e1.this;
            e1Var.f18536e.d(e1Var);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f18568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18569b;

        public h(x xVar, boolean z10) {
            this.f18568a = xVar;
            this.f18569b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e1.this.f18553v.e(this.f18568a, this.f18569b);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18571a;

        public i(vj.y2 y2Var) {
            this.f18571a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(e1.this.f18552u).iterator();
            while (it.hasNext()) {
                ((r1) it.next()).a(this.f18571a);
            }
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q1.l2 f18573a;

        public j(q1.l2 l2Var) {
            this.f18573a = l2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.v0.b.a aVar = new vj.v0.b.a();
            List<vj.d0> list = e1.this.f18545n.f18581a;
            ArrayList arrayList = new ArrayList(e1.this.f18552u);
            aVar.f17298a = list.toString();
            aVar.f17299b = e1.this.f18556y.f17279a;
            aVar.g(arrayList);
            e1.this.f18540i.d(aVar);
            e1.this.f18541j.g(aVar);
            this.f18573a.B(aVar.a());
        }
    }

    public static abstract class l {
        @t1.g
        public void a(e1 e1Var) {
        }

        @t1.g
        public void b(e1 e1Var) {
        }

        @t1.g
        public void c(e1 e1Var, vj.v vVar) {
        }

        @t1.g
        public void d(e1 e1Var) {
        }
    }

    @b1.e
    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<vj.d0> f18581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18583c;

        public m(List<vj.d0> list) {
            this.f18581a = list;
        }

        public SocketAddress a() {
            return this.f18581a.get(this.f18582b).f17080a.get(this.f18583c);
        }

        public vj.a b() {
            return this.f18581a.get(this.f18582b).f17081b;
        }

        public List<vj.d0> c() {
            return this.f18581a;
        }

        public void d() {
            vj.d0 d0Var = this.f18581a.get(this.f18582b);
            int i10 = this.f18583c + 1;
            this.f18583c = i10;
            if (i10 >= d0Var.f17080a.size()) {
                this.f18582b++;
                this.f18583c = 0;
            }
        }

        public boolean e() {
            return this.f18582b == 0 && this.f18583c == 0;
        }

        public boolean f() {
            return this.f18582b < this.f18581a.size();
        }

        public void g() {
            this.f18582b = 0;
            this.f18583c = 0;
        }

        public boolean h(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f18581a.size(); i10++) {
                int iIndexOf = this.f18581a.get(i10).f17080a.indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f18582b = i10;
                    this.f18583c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public void i(List<vj.d0> list) {
            this.f18581a = list;
            g();
        }
    }

    public class n implements r1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f18584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18585b = false;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = n.this;
                e1 e1Var = e1.this;
                e1Var.f18547p = null;
                if (e1Var.f18557z != null) {
                    c1.h0.h0(e1Var.f18555x == null, "Unexpected non-null activeTransport");
                    n nVar2 = n.this;
                    nVar2.f18584a.n(e1.this.f18557z);
                    return;
                }
                x xVar = e1Var.f18554w;
                x xVar2 = nVar.f18584a;
                if (xVar == xVar2) {
                    e1Var.f18555x = xVar2;
                    e1 e1Var2 = e1.this;
                    e1Var2.f18554w = null;
                    e1Var2.X(vj.u.READY);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f18588a;

            public b(vj.y2 y2Var) {
                this.f18588a = y2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e1.this.f18556y.f17279a == vj.u.SHUTDOWN) {
                    return;
                }
                r1 r1Var = e1.this.f18555x;
                n nVar = n.this;
                x xVar = nVar.f18584a;
                if (r1Var == xVar) {
                    e1.this.f18555x = null;
                    e1.this.f18545n.g();
                    e1.this.X(vj.u.IDLE);
                    return;
                }
                e1 e1Var = e1.this;
                if (e1Var.f18554w == xVar) {
                    c1.h0.x0(e1Var.f18556y.f17279a == vj.u.CONNECTING, "Expected state is CONNECTING, actual state is %s", e1.this.f18556y.f17279a);
                    e1.this.f18545n.d();
                    if (e1.this.f18545n.f()) {
                        e1.this.e0();
                        return;
                    }
                    e1 e1Var2 = e1.this;
                    e1Var2.f18554w = null;
                    e1Var2.f18545n.g();
                    e1.this.d0(this.f18588a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = n.this;
                e1.this.f18552u.remove(nVar.f18584a);
                if (e1.this.f18556y.f17279a == vj.u.SHUTDOWN && e1.this.f18552u.isEmpty()) {
                    e1.this.Z();
                }
            }
        }

        public n(x xVar) {
            this.f18584a = xVar;
        }

        @Override // wj.r1.a
        public void a() {
            c1.h0.h0(this.f18585b, "transportShutdown() must be called before transportTerminated().");
            e1.this.f18542k.b(vj.h.a.INFO, "{0} Terminated", this.f18584a.e());
            e1.this.f18539h.y(this.f18584a);
            e1.this.a0(this.f18584a, false);
            Iterator<vj.o> it = e1.this.f18543l.iterator();
            while (it.hasNext()) {
                it.next().b(this.f18584a.c());
            }
            e1.this.f18544m.execute(new c());
        }

        @Override // wj.r1.a
        public void b() {
            e1.this.f18542k.a(vj.h.a.INFO, "READY");
            e1.this.f18544m.execute(new a());
        }

        @Override // wj.r1.a
        public void c(boolean z10) {
            e1.this.a0(this.f18584a, z10);
        }

        @Override // wj.r1.a
        public void d(vj.y2 y2Var) {
            e1.this.f18542k.b(vj.h.a.INFO, "{0} SHUTDOWN with {1}", this.f18584a.e(), e1.this.b0(y2Var));
            this.f18585b = true;
            e1.this.f18544m.execute(new b(y2Var));
        }

        @Override // wj.r1.a
        public vj.a e(vj.a aVar) {
            for (vj.o oVar : e1.this.f18543l) {
                aVar = (vj.a) c1.h0.V(oVar.a(aVar), "Filter %s returned null", oVar);
            }
            return aVar;
        }
    }

    @b1.e
    public static final class o extends vj.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.c1 f18591a;

        @Override // vj.h
        public void a(vj.h.a aVar, String str) {
            p.d(this.f18591a, aVar, str);
        }

        @Override // vj.h
        public void b(vj.h.a aVar, String str, Object... objArr) {
            p.e(this.f18591a, aVar, str, objArr);
        }
    }

    public e1(List<vj.d0> list, String str, String str2, wj.k.a aVar, v vVar, ScheduledExecutorService scheduledExecutorService, c1.q0<c1.o0> q0Var, vj.c3 c3Var, l lVar, vj.v0 v0Var, wj.o oVar, q qVar, vj.c1 c1Var, vj.h hVar, List<vj.o> list2) {
        c1.h0.F(list, "addressGroups");
        c1.h0.e(!list.isEmpty(), "addressGroups is empty");
        R(list, "addressGroups contains null entry");
        List<vj.d0> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f18546o = listUnmodifiableList;
        this.f18545n = new m(listUnmodifiableList);
        this.f18533b = str;
        this.f18534c = str2;
        this.f18535d = aVar;
        this.f18537f = vVar;
        this.f18538g = scheduledExecutorService;
        this.f18548q = q0Var.get();
        this.f18544m = c3Var;
        this.f18536e = lVar;
        this.f18539h = v0Var;
        this.f18540i = oVar;
        this.f18541j = (q) c1.h0.F(qVar, "channelTracer");
        this.f18532a = (vj.c1) c1.h0.F(c1Var, "logId");
        this.f18542k = (vj.h) c1.h0.F(hVar, "channelLogger");
        this.f18543l = list2;
    }

    public static void R(List<?> list, String str) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            c1.h0.F(it.next(), str);
        }
    }

    public final void Q() {
        this.f18544m.e();
        vj.c3.d dVar = this.f18549r;
        if (dVar != null) {
            dVar.a();
            this.f18549r = null;
            this.f18547p = null;
        }
    }

    public List<vj.d0> S() {
        return this.f18546o;
    }

    public String T() {
        return this.f18533b;
    }

    public vj.h U() {
        return this.f18542k;
    }

    public vj.u V() {
        return this.f18556y.f17279a;
    }

    @gm.j
    public u W() {
        return this.f18555x;
    }

    public final void X(vj.u uVar) {
        this.f18544m.e();
        Y(vj.v.a(uVar));
    }

    public final void Y(vj.v vVar) {
        this.f18544m.e();
        if (this.f18556y.f17279a != vVar.f17279a) {
            c1.h0.h0(this.f18556y.f17279a != vj.u.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + vVar);
            this.f18556y = vVar;
            this.f18536e.c(this, vVar);
        }
    }

    public final void Z() {
        this.f18544m.execute(new g());
    }

    public void a(vj.y2 y2Var) {
        n(y2Var);
        this.f18544m.execute(new i(y2Var));
    }

    public final void a0(x xVar, boolean z10) {
        this.f18544m.execute(new h(xVar, z10));
    }

    @Override // wj.p3
    public u b() {
        r1 r1Var = this.f18555x;
        if (r1Var != null) {
            return r1Var;
        }
        this.f18544m.execute(new c());
        return null;
    }

    public final String b0(vj.y2 y2Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y2Var.f17568a);
        if (y2Var.f17569b != null) {
            sb2.append("(");
            sb2.append(y2Var.f17569b);
            sb2.append(")");
        }
        if (y2Var.f17570c != null) {
            sb2.append("[");
            sb2.append(y2Var.f17570c);
            sb2.append("]");
        }
        return sb2.toString();
    }

    public void c0() {
        this.f18544m.execute(new d());
    }

    public final void d0(vj.y2 y2Var) {
        this.f18544m.e();
        Y(vj.v.b(y2Var));
        if (this.f18547p == null) {
            this.f18547p = this.f18535d.get();
        }
        long jA = this.f18547p.a();
        c1.o0 o0Var = this.f18548q;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jG = jA - o0Var.g(timeUnit);
        this.f18542k.b(vj.h.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", b0(y2Var), Long.valueOf(jG));
        c1.h0.h0(this.f18549r == null, "previous reconnectTask is not done");
        this.f18549r = this.f18544m.c(new b(), jG, timeUnit, this.f18538g);
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f18532a;
    }

    public final void e0() {
        SocketAddress targetAddress;
        vj.q0 q0Var;
        this.f18544m.e();
        c1.h0.h0(this.f18549r == null, "Should have no reconnectTask scheduled");
        if (this.f18545n.e()) {
            this.f18548q.j().k();
        }
        SocketAddress socketAddressA = this.f18545n.a();
        if (socketAddressA instanceof vj.q0) {
            q0Var = (vj.q0) socketAddressA;
            targetAddress = q0Var.getTargetAddress();
        } else {
            targetAddress = socketAddressA;
            q0Var = null;
        }
        vj.a aVarB = this.f18545n.b();
        String str = (String) aVarB.f17048a.get(vj.d0.f17079d);
        v.a aVar = new v.a();
        if (str == null) {
            str = this.f18533b;
        }
        v.a aVarH = aVar.f(str).h(aVarB);
        aVarH.f19351d = this.f18534c;
        aVarH.f19352e = q0Var;
        o oVar = new o();
        oVar.f18591a = this.f18532a;
        k kVar = new k(this.f18537f.D(targetAddress, aVarH, oVar), this.f18540i);
        oVar.f18591a = kVar.e();
        this.f18539h.c(kVar);
        this.f18554w = kVar;
        this.f18552u.add(kVar);
        Runnable runnableF = kVar.f(new n(kVar));
        if (runnableF != null) {
            this.f18544m.b(runnableF);
        }
        this.f18542k.b(vj.h.a.INFO, "Started transport {0}", oVar.f18591a);
    }

    public void f0(List<vj.d0> list) {
        c1.h0.F(list, "newAddressGroups");
        R(list, "newAddressGroups contains null entry");
        c1.h0.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f18544m.execute(new e(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // vj.a1
    public q1.s1<vj.v0.b> j() {
        q1.l2 l2VarF = q1.l2.F();
        this.f18544m.execute(new j(l2VarF));
        return l2VarF;
    }

    public void n(vj.y2 y2Var) {
        this.f18544m.execute(new f(y2Var));
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f18532a.f17063c).j("addressGroups", this.f18546o).toString();
    }

    @b1.e
    public static final class k extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f18575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wj.o f18576b;

        public class a extends l0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f18577a;

            /* JADX INFO: renamed from: wj.e1$k$a$a, reason: collision with other inner class name */
            public class C0475a extends m0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ t f18579a;

                public C0475a(t tVar) {
                    this.f18579a = tVar;
                }

                @Override // wj.m0, wj.t
                public void b(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
                    k.this.f18576b.b(y2Var.r());
                    super.b(y2Var, aVar, v1Var);
                }

                @Override // wj.m0
                public t g() {
                    return this.f18579a;
                }
            }

            public a(s sVar) {
                this.f18577a = sVar;
            }

            @Override // wj.l0
            public s w() {
                return this.f18577a;
            }

            @Override // wj.l0, wj.s
            public void y(t tVar) {
                k.this.f18576b.c();
                super.y(new C0475a(tVar));
            }
        }

        public k(x xVar, wj.o oVar) {
            this.f18575a = xVar;
            this.f18576b = oVar;
        }

        @Override // wj.o0
        public x b() {
            return this.f18575a;
        }

        @Override // wj.o0, wj.u
        public s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
            return new a(super.k(w1Var, v1Var, eVar, nVarArr));
        }

        public /* synthetic */ k(x xVar, wj.o oVar, a aVar) {
            this(xVar, oVar);
        }
    }
}
