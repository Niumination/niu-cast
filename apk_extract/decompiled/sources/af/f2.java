package af;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class f2 implements ze.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.r0 f260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k2 f262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l6 f263d;
    public final q e;
    public final ScheduledExecutorService f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ze.o0 f264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ze.i f266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ze.v2 f267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b2 f268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile List f269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d1 f270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z4 f271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u6.c f272o;
    public u6.c p;
    public r3 q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f273r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final v1 f274s = new v1(this, 0);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a2 f275t;
    public volatile j0 u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile ze.r f276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ze.q2 f277w;

    public f2(List list, String str, k2 k2Var, q qVar, ScheduledExecutorService scheduledExecutorService, k2 k2Var2, ze.v2 v2Var, l6 l6Var, ze.o0 o0Var, r rVar, v vVar, ze.r0 r0Var, ze.i iVar) {
        ze.q qVar2 = ze.q.IDLE;
        v8.c("state is TRANSIENT_ERROR. Use forError() instead", qVar2 != ze.q.TRANSIENT_FAILURE);
        this.f276v = new ze.r(qVar2, ze.q2.e);
        v8.i(list, "addressGroups");
        v8.c("addressGroups is empty", !list.isEmpty());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v8.i(it.next(), "addressGroups contains null entry");
        }
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f269l = listUnmodifiableList;
        b2 b2Var = new b2();
        b2Var.f181c = listUnmodifiableList;
        this.f268k = b2Var;
        this.f261b = str;
        this.f262c = k2Var;
        this.e = qVar;
        this.f = scheduledExecutorService;
        k2Var2.getClass();
        this.f271n = new z4(1);
        this.f267j = v2Var;
        this.f263d = l6Var;
        this.f264g = o0Var;
        this.f265h = rVar;
        v8.i(vVar, "channelTracer");
        v8.i(r0Var, "logId");
        this.f260a = r0Var;
        v8.i(iVar, "channelLogger");
        this.f266i = iVar;
    }

    public static void b(f2 f2Var, ze.q qVar) {
        f2Var.f267j.d();
        v8.c("state is TRANSIENT_ERROR. Use forError() instead", qVar != ze.q.TRANSIENT_FAILURE);
        f2Var.h(new ze.r(qVar, ze.q2.e));
    }

    public static void e(f2 f2Var) {
        SocketAddress targetAddress;
        ze.i0 i0Var;
        ze.v2 v2Var = f2Var.f267j;
        v2Var.d();
        v8.n(f2Var.f272o == null, "Should have no reconnectTask scheduled");
        b2 b2Var = f2Var.f268k;
        if (b2Var.f179a == 0 && b2Var.f180b == 0) {
            z4 z4Var = f2Var.f271n;
            z4Var.f750b = false;
            z4Var.b();
        }
        SocketAddress socketAddress = (SocketAddress) ((ze.c0) ((List) b2Var.f181c).get(b2Var.f179a)).f11332a.get(b2Var.f180b);
        if (socketAddress instanceof ze.i0) {
            i0Var = (ze.i0) socketAddress;
            targetAddress = i0Var.getTargetAddress();
        } else {
            targetAddress = socketAddress;
            i0Var = null;
        }
        ze.b bVar = ((ze.c0) ((List) b2Var.f181c).get(b2Var.f179a)).f11333b;
        String str = (String) bVar.f11322a.get(ze.c0.f11331d);
        f0 f0Var = new f0();
        f0Var.f254a = "unknown-authority";
        f0Var.f255b = ze.b.f11321b;
        if (str == null) {
            str = f2Var.f261b;
        }
        v8.i(str, "authority");
        f0Var.f254a = str;
        f0Var.f255b = bVar;
        f0Var.f256c = i0Var;
        e2 e2Var = new e2();
        e2Var.f229d = f2Var.f260a;
        q qVar = f2Var.e;
        cf.j jVar = qVar.f520a;
        if (jVar.p) {
            throw new IllegalStateException("The transport factory is closed.");
        }
        j jVar2 = jVar.f1565l;
        long j8 = jVar2.f340b.get();
        cf.q qVar2 = new cf.q(jVar, (InetSocketAddress) targetAddress, f0Var.f254a, f0Var.f255b, f0Var.f256c, new f(new i(jVar2, j8), 13));
        if (jVar.f1564k) {
            qVar2.G = true;
            qVar2.H = j8;
            qVar2.I = jVar.f1566m;
        }
        a2 a2Var = new a2(new p(qVar, qVar2, f0Var.f254a), f2Var.f265h);
        e2Var.f229d = a2Var.d();
        ze.o0.a(f2Var.f264g.f11393d, a2Var);
        f2Var.f275t = a2Var;
        f2Var.f273r.add(a2Var);
        Runnable runnableG = a2Var.g(new d2(f2Var, a2Var));
        if (runnableG != null) {
            v2Var.b(runnableG);
        }
        f2Var.f266i.g(ze.h.INFO, "Started transport {0}", e2Var.f229d);
    }

    public static String i(ze.q2 q2Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(q2Var.f11413a);
        String str = q2Var.f11414b;
        if (str != null) {
            sb2.append("(");
            sb2.append(str);
            sb2.append(")");
        }
        Throwable th2 = q2Var.f11415c;
        if (th2 != null) {
            sb2.append("[");
            sb2.append(th2);
            sb2.append("]");
        }
        return sb2.toString();
    }

    @Override // ze.q0
    public final ze.r0 d() {
        return this.f260a;
    }

    public final void h(ze.r rVar) {
        this.f267j.d();
        if (this.f276v.f11416a != rVar.f11416a) {
            v8.n(this.f276v.f11416a != ze.q.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + rVar);
            this.f276v = rVar;
            ((ze.a1) this.f263d.f446b).a(rVar);
        }
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.e("logId", this.f260a.f11421c);
        aVarA.d(this.f269l, "addressGroups");
        return aVarA.toString();
    }
}
