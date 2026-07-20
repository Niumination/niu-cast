package af;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f225c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f223a = i8;
        this.f225c = obj;
        this.f224b = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c6 A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:17:0x0068, B:38:0x00f8, B:20:0x0076, B:22:0x0096, B:24:0x00a2, B:29:0x00b0, B:33:0x00c6, B:37:0x00eb, B:36:0x00d5), top: B:294:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d5 A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:17:0x0068, B:38:0x00f8, B:20:0x0076, B:22:0x0096, B:24:0x00a2, B:29:0x00b0, B:33:0x00c6, B:37:0x00eb, B:36:0x00d5), top: B:294:0x0068 }] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        List listSingletonList;
        ze.s1 s1Var;
        z0 z0Var;
        j0 j0Var;
        p3 p3Var;
        ze.q2 q2VarA;
        Object obj;
        b5 b5Var;
        int i8 = 10;
        int i9 = 2;
        u6.a aVar = null;
        d2Var = null;
        d2 d2Var = null;
        aVar = null;
        u6.a aVar2 = null;
        boolean z2 = true;
        char c9 = 1;
        char c10 = 1;
        int i10 = 0;
        switch (this.f223a) {
            case 0:
                ((cf.a0) this.f225c).p((ze.q2) this.f224b);
                return;
            case 1:
                ((e3) this.f225c).g(ze.q2.f11405h.h(((StringBuilder) this.f224b).toString()), true);
                return;
            case 2:
                ze.j jVar = ((e3) this.f225c).f;
                ze.q2 q2Var = (ze.q2) this.f224b;
                jVar.a(q2Var.f11414b, q2Var.f11415c);
                return;
            case 3:
                ((e3) this.f225c).f.e(this.f224b);
                return;
            case 4:
                ((q0) this.f225c).f522a.h((ze.p1) this.f224b);
                return;
            case 5:
                ((q0) this.f225c).f522a.i((MessageLite) this.f224b);
                return;
            case 6:
                v8.n(((j3) ((t0) this.f225c).f588h.f10264a).F.get(), "Channel must have been shut down");
                return;
            case 7:
                ((s0) this.f225c).f564c.a((ze.o) this.f224b);
                return;
            case 8:
                ((s0) this.f225c).f564c.d((ze.b0) this.f224b);
                return;
            case 9:
                ((s0) this.f225c).f564c.m((ze.z) this.f224b);
                return;
            case 10:
                ((s0) this.f225c).f564c.i((gf.a) this.f224b);
                return;
            case 11:
                ((s0) this.f225c).f564c.h((ze.q2) this.f224b);
                return;
            case 12:
                ((d0) ((w0) this.f225c).f641b).j((a8.a) this.f224b);
                return;
            case 13:
                ((d0) ((w0) this.f225c).f641b).i((ze.p1) this.f224b);
                return;
            case 14:
                ze.f0 f0Var = (ze.f0) this.f224b;
                Logger logger = b1.f161v;
                Level level = Level.FINER;
                boolean zIsLoggable = logger.isLoggable(level);
                b1 b1Var = (b1) this.f225c;
                if (zIsLoggable) {
                    logger.finer("Attempting DNS resolution of " + b1Var.f169i);
                }
                try {
                    try {
                        ze.z1 z1VarA = b1Var.f166d.a(InetSocketAddress.createUnresolved(b1Var.f169i, b1Var.f170j));
                        ze.c0 c0Var = z1VarA != null ? new ze.c0(z1VarA) : null;
                        List listEmptyList = Collections.emptyList();
                        ze.b bVar = ze.b.f11321b;
                        ze.v2 v2Var = b1Var.f173m;
                        if (c0Var == null) {
                            u6.a aVarU = b1Var.u();
                            try {
                                ze.q2 q2Var2 = (ze.q2) aVarU.f10378b;
                                if (q2Var2 != null) {
                                    f0Var.g(q2Var2);
                                    z0Var = new z0(this, ((ze.q2) aVarU.f10378b) == null, i10);
                                } else {
                                    List list = (List) aVarU.f10379c;
                                    if (list != null) {
                                        listEmptyList = list;
                                    }
                                    ze.s1 s1Var2 = (ze.s1) aVarU.f10380d;
                                    ze.s1 s1Var3 = s1Var2 != null ? s1Var2 : null;
                                    listSingletonList = listEmptyList;
                                    s1Var = s1Var3;
                                    aVar = aVarU;
                                }
                                v2Var.execute(z0Var);
                                return;
                            } catch (IOException e) {
                                e = e;
                                aVar = aVarU;
                                f0Var.g(ze.q2.f11411n.h("Unable to resolve host " + b1Var.f169i).g(e));
                                b1Var.f173m.execute(new z0(this, aVar != null && ((ze.q2) aVar.f10378b) == null, i10));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar2 = aVarU;
                                b1Var.f173m.execute(new z0(this, aVar2 != null && ((ze.q2) aVar2.f10378b) == null, i10));
                                throw th;
                            }
                        }
                        if (logger.isLoggable(level)) {
                            logger.finer("Using proxy address " + c0Var);
                        }
                        listSingletonList = Collections.singletonList(c0Var);
                        s1Var = null;
                        f0Var.k(new ze.t1(listSingletonList, bVar, s1Var));
                        z0Var = new z0(this, aVar != null && ((ze.q2) aVar.f10378b) == null, i10);
                        v2Var.execute(z0Var);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
                break;
            case 15:
                b2 b2Var = ((f2) this.f225c).f268k;
                SocketAddress socketAddress = (SocketAddress) ((ze.c0) ((List) b2Var.f181c).get(b2Var.f179a)).f11332a.get(b2Var.f180b);
                b2 b2Var2 = ((f2) this.f225c).f268k;
                b2Var2.f181c = (List) this.f224b;
                b2Var2.a();
                ((f2) this.f225c).f269l = (List) this.f224b;
                if (((f2) this.f225c).f276v.f11416a == ze.q.READY || ((f2) this.f225c).f276v.f11416a == ze.q.CONNECTING) {
                    b2 b2Var3 = ((f2) this.f225c).f268k;
                    while (true) {
                        if (i10 < ((List) b2Var3.f181c).size()) {
                            int iIndexOf = ((ze.c0) ((List) b2Var3.f181c).get(i10)).f11332a.indexOf(socketAddress);
                            if (iIndexOf == -1) {
                                i10++;
                            } else {
                                b2Var3.f179a = i10;
                                b2Var3.f180b = iIndexOf;
                            }
                        } else if (((f2) this.f225c).f276v.f11416a == ze.q.READY) {
                            j0Var = ((f2) this.f225c).u;
                            ((f2) this.f225c).u = null;
                            ((f2) this.f225c).f268k.a();
                            f2.b((f2) this.f225c, ze.q.IDLE);
                        } else {
                            ((f2) this.f225c).f275t.c(ze.q2.f11411n.h("InternalSubchannel closed pending transport due to address change"));
                            f2 f2Var = (f2) this.f225c;
                            f2Var.f275t = null;
                            f2Var.f268k.a();
                            f2.e((f2) this.f225c);
                        }
                        j0Var = null;
                    }
                } else {
                    j0Var = null;
                }
                if (j0Var != null) {
                    f2 f2Var2 = (f2) this.f225c;
                    if (f2Var2.p != null) {
                        f2Var2.q.c(ze.q2.f11411n.h("InternalSubchannel closed transport early due to address change"));
                        ((f2) this.f225c).p.t();
                        f2 f2Var3 = (f2) this.f225c;
                        f2Var3.p = null;
                        f2Var3.q = null;
                    }
                    f2 f2Var4 = (f2) this.f225c;
                    f2Var4.q = j0Var;
                    f2Var4.p = f2Var4.f267j.c(new f(this, 3), 5L, TimeUnit.SECONDS, f2Var4.f);
                    return;
                }
                return;
            case 16:
                if (((f2) ((d2) this.f225c).f215c).f276v.f11416a == ze.q.SHUTDOWN) {
                    return;
                }
                j0 j0Var2 = ((f2) ((d2) this.f225c).f215c).u;
                d2 d2Var2 = (d2) this.f225c;
                a2 a2Var = (a2) d2Var2.f214b;
                if (j0Var2 == a2Var) {
                    ((f2) d2Var2.f215c).u = null;
                    ((f2) ((d2) this.f225c).f215c).f268k.a();
                    f2.b((f2) ((d2) this.f225c).f215c, ze.q.IDLE);
                    return;
                }
                f2 f2Var5 = (f2) d2Var2.f215c;
                if (f2Var5.f275t == a2Var) {
                    v8.l("Expected state is CONNECTING, actual state is %s", f2Var5.f276v.f11416a == ze.q.CONNECTING, ((f2) ((d2) this.f225c).f215c).f276v.f11416a);
                    b2 b2Var4 = ((f2) ((d2) this.f225c).f215c).f268k;
                    ze.c0 c0Var2 = (ze.c0) ((List) b2Var4.f181c).get(b2Var4.f179a);
                    int i11 = b2Var4.f180b + 1;
                    b2Var4.f180b = i11;
                    if (i11 >= c0Var2.f11332a.size()) {
                        b2Var4.f179a++;
                        b2Var4.f180b = 0;
                    }
                    b2 b2Var5 = ((f2) ((d2) this.f225c).f215c).f268k;
                    if (b2Var5.f179a < ((List) b2Var5.f181c).size()) {
                        f2.e((f2) ((d2) this.f225c).f215c);
                        return;
                    }
                    f2 f2Var6 = (f2) ((d2) this.f225c).f215c;
                    f2Var6.f275t = null;
                    f2Var6.f268k.a();
                    f2 f2Var7 = (f2) ((d2) this.f225c).f215c;
                    ze.q2 q2Var3 = (ze.q2) this.f224b;
                    f2Var7.f267j.d();
                    v8.c("The error status must not be OK", !q2Var3.e());
                    f2Var7.h(new ze.r(ze.q.TRANSIENT_FAILURE, q2Var3));
                    if (f2Var7.f270m == null) {
                        f2Var7.f262c.getClass();
                        f2Var7.f270m = k2.h();
                    }
                    long jA = f2Var7.f270m.a();
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long jA2 = jA - f2Var7.f271n.a(timeUnit);
                    f2Var7.f266i.g(ze.h.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", f2.i(q2Var3), Long.valueOf(jA2));
                    v8.n(f2Var7.f272o == null, "previous reconnectTask is not done");
                    f2Var7.f272o = f2Var7.f267j.c(new w1(f2Var7, i10), jA2, timeUnit, f2Var7.f);
                    return;
                }
                return;
            case 17:
                b3 b3Var = (b3) this.f225c;
                b3Var.getClass();
                Logger logger2 = j3.c0;
                Level level2 = Level.WARNING;
                j3 j3Var = b3Var.f184c;
                ze.r0 r0Var = j3Var.f345a;
                ze.q2 q2Var4 = (ze.q2) this.f224b;
                logger2.log(level2, "[{0}] Failed to resolve name. status={1}", new Object[]{r0Var, q2Var4});
                f3 f3Var = j3Var.P;
                if (f3Var.f278a.get() == j3.f344i0) {
                    f3Var.i(null);
                }
                g3 g3Var = j3Var.Q;
                g3 g3Var2 = g3.ERROR;
                if (g3Var != g3Var2) {
                    j3Var.N.g(ze.h.WARNING, "Failed to resolve name: {0}", q2Var4);
                    j3Var.Q = g3Var2;
                }
                a3 a3Var = j3Var.f364w;
                a3 a3Var2 = b3Var.f182a;
                if (a3Var2 != a3Var) {
                    return;
                }
                ((ze.b1) a3Var2.f140a.f539b).c(q2Var4);
                return;
            case 18:
                b3 b3Var2 = (b3) this.f225c;
                j3 j3Var2 = b3Var2.f184c;
                if (j3Var2.u != b3Var2.f183b) {
                    return;
                }
                ze.t1 t1Var = (ze.t1) this.f224b;
                List list2 = t1Var.f11437a;
                t tVar = j3Var2.N;
                ze.h hVar = ze.h.DEBUG;
                tVar.g(hVar, "Resolved address: {0}, config={1}", list2, t1Var.f11438b);
                j3 j3Var3 = ((b3) this.f225c).f184c;
                g3 g3Var3 = j3Var3.Q;
                g3 g3Var4 = g3.SUCCESS;
                if (g3Var3 != g3Var4) {
                    j3Var3.N.g(ze.h.INFO, "Address resolved: {0}", list2);
                    ((b3) this.f225c).f184c.Q = g3Var4;
                }
                ze.t1 t1Var2 = (ze.t1) this.f224b;
                ze.s1 s1Var4 = t1Var2.f11439c;
                h5 h5Var = (h5) t1Var2.f11438b.f11322a.get(j5.f372g);
                ze.b bVar2 = ((ze.t1) this.f224b).f11438b;
                ze.a aVar3 = ze.p0.f11396a;
                ze.p0 p0Var = (ze.p0) bVar2.f11322a.get(aVar3);
                p3 p3Var2 = (s1Var4 == null || (obj = s1Var4.f11434b) == null) ? null : (p3) obj;
                ze.q2 q2Var5 = s1Var4 != null ? s1Var4.f11433a : null;
                j3 j3Var4 = ((b3) this.f225c).f184c;
                if (j3Var4.T) {
                    if (p3Var2 != null) {
                        if (p0Var != null) {
                            j3Var4.P.i(p0Var);
                            if (p3Var2.b() != null) {
                                ((b3) this.f225c).f184c.N.f(hVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                            }
                        } else {
                            j3Var4.P.i(p3Var2.b());
                        }
                    } else if (q2Var5 == null) {
                        p3Var2 = j3.f343h0;
                        j3Var4.P.i(null);
                    } else {
                        if (!j3Var4.S) {
                            j3Var4.N.f(ze.h.INFO, "Fallback to error due to invalid first service config without default config");
                            ((b3) this.f225c).g(s1Var4.f11433a);
                            if (h5Var != null) {
                                boolean zE = s1Var4.f11433a.e();
                                j5 j5Var = h5Var.f310a;
                                if (!zE) {
                                    j5Var.e.a(new f(j5Var, i8));
                                    return;
                                }
                                o oVar = j5Var.e;
                                ze.v2 v2Var2 = oVar.f476b;
                                v2Var2.d();
                                v2Var2.execute(new a4.c(oVar, i9));
                                return;
                            }
                            return;
                        }
                        p3Var2 = j3Var4.R;
                    }
                    if (!p3Var2.equals(((b3) this.f225c).f184c.R)) {
                        ((b3) this.f225c).f184c.N.g(ze.h.INFO, "Service config changed{0}", p3Var2 == j3.f343h0 ? " to empty" : "");
                        j3 j3Var5 = ((b3) this.f225c).f184c;
                        j3Var5.R = p3Var2;
                        j3Var5.f346a0.f374a = p3Var2.f503d;
                    }
                    try {
                        ((b3) this.f225c).f184c.S = true;
                    } catch (RuntimeException e10) {
                        j3.c0.log(Level.WARNING, "[" + ((b3) this.f225c).f184c.f345a + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    p3Var = p3Var2;
                    break;
                } else {
                    if (p3Var2 != null) {
                        j3Var4.N.f(ze.h.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    ((b3) this.f225c).f184c.getClass();
                    p3Var = j3.f343h0;
                    if (p0Var != null) {
                        ((b3) this.f225c).f184c.N.f(ze.h.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    ((b3) this.f225c).f184c.P.i(p3Var.b());
                }
                ze.b bVar3 = ((ze.t1) this.f224b).f11438b;
                b3 b3Var3 = (b3) this.f225c;
                if (b3Var3.f182a == b3Var3.f184c.f364w) {
                    n6.a aVarA = bVar3.a();
                    if (((ze.b) aVarA.f8122b).f11322a.containsKey(aVar3)) {
                        IdentityHashMap identityHashMap = new IdentityHashMap(((ze.b) aVarA.f8122b).f11322a);
                        identityHashMap.remove(aVar3);
                        aVarA.f8122b = new ze.b(identityHashMap);
                    }
                    IdentityHashMap identityHashMap2 = (IdentityHashMap) aVarA.f8123c;
                    if (identityHashMap2 != null) {
                        identityHashMap2.remove(aVar3);
                    }
                    Map map = p3Var.f;
                    if (map != null) {
                        aVarA.j(ze.b1.f11327b, map);
                        aVarA.g();
                    }
                    ze.b bVarG = aVarA.g();
                    r rVar = ((b3) this.f225c).f182a.f140a;
                    ze.b bVar4 = ze.b.f11321b;
                    ze.y0 y0Var = new ze.y0(list2, bVarG, p3Var.e);
                    rVar.getClass();
                    c6 c6Var = (c6) y0Var.f11479c;
                    a3 a3Var3 = (a3) rVar.f538a;
                    if (c6Var == null) {
                        try {
                            l6 l6Var = (l6) rVar.f541d;
                            String str = (String) l6Var.f447c;
                            ze.c1 c1VarB = ((ze.d1) l6Var.f446b).b(str);
                            if (c1VarB == null) {
                                throw new n("Trying to load '" + str + "' because using default policy, but it's unavailable", null);
                            }
                            c6Var = new c6(c1VarB, null);
                        } catch (n e11) {
                            a3Var3.m(ze.q.TRANSIENT_FAILURE, new v2(ze.q2.f11410m.h(e11.getMessage()), i9));
                            ((ze.b1) rVar.f539b).f();
                            rVar.f540c = null;
                            rVar.f539b = new m();
                            q2VarA = ze.q2.e;
                        }
                    }
                    ze.c1 c1Var = (ze.c1) rVar.f540c;
                    ze.c1 c1Var2 = c6Var.f207a;
                    if (c1Var == null || !c1Var2.a().equals(((ze.c1) rVar.f540c).a())) {
                        a3Var3.m(ze.q.CONNECTING, new l(0));
                        ((ze.b1) rVar.f539b).f();
                        rVar.f540c = c1Var2;
                        ze.b1 b1Var2 = (ze.b1) rVar.f539b;
                        rVar.f539b = c1Var2.d(a3Var3);
                        a3Var3.f141b.N.g(ze.h.INFO, "Load balancer changed from {0} to {1}", b1Var2.getClass().getSimpleName(), ((ze.b1) rVar.f539b).getClass().getSimpleName());
                    }
                    Object obj2 = c6Var.f208b;
                    if (obj2 != null) {
                        a3Var3.f141b.N.g(ze.h.DEBUG, "Load-balancing config: {0}", obj2);
                    }
                    q2VarA = ((ze.b1) rVar.f539b).a(new ze.y0(y0Var.f11477a, y0Var.f11478b, obj2));
                    if (h5Var != null) {
                        boolean zE2 = q2VarA.e();
                        j5 j5Var2 = h5Var.f310a;
                        if (!zE2) {
                            j5Var2.e.a(new f(j5Var2, i8));
                            return;
                        }
                        o oVar2 = j5Var2.e;
                        ze.v2 v2Var3 = oVar2.f476b;
                        v2Var3.d();
                        v2Var3.execute(new a4.c(oVar2, i9));
                        return;
                    }
                    return;
                }
                return;
            case 19:
                f3 f3Var2 = (f3) this.f225c;
                Object obj3 = f3Var2.f278a.get();
                t2 t2Var = j3.f344i0;
                e3 e3Var = (e3) this.f224b;
                if (obj3 != t2Var) {
                    e3Var.j();
                    return;
                }
                j3 j3Var6 = f3Var2.f281d;
                if (j3Var6.A == null) {
                    j3Var6.A = new LinkedHashSet();
                    j3Var6.Z.l(j3Var6.B, true);
                }
                j3Var6.A.add(e3Var);
                return;
            case 20:
                ((y) this.f224b).run();
                e3 e3Var2 = (e3) this.f225c;
                e3Var2.f242n.f281d.f357m.execute(new n0(e3Var2, z2 ? 1 : 0));
                return;
            case 21:
                synchronized (((x2) ((e) this.f225c).f225c).f689i) {
                    try {
                        e eVar = (e) this.f225c;
                        if (!((d2) eVar.f224b).f213a) {
                            x2 x2Var = (x2) eVar.f225c;
                            x2Var.f695o = x2Var.f695o.a((e5) this.f224b);
                            x2 x2Var2 = (x2) ((e) this.f225c).f225c;
                            if (x2Var2.s(x2Var2.f695o)) {
                                f5 f5Var = ((x2) ((e) this.f225c).f225c).f693m;
                                if (f5Var != null) {
                                    if (f5Var.f288d.get() <= f5Var.f286b) {
                                        c10 = 0;
                                    }
                                    if (c10 == 0) {
                                        x2 x2Var3 = (x2) ((e) this.f225c).f225c;
                                        b5Var = x2Var3.f695o;
                                        if (b5Var.f191h) {
                                            b5Var = new b5(b5Var.f187b, b5Var.f188c, b5Var.f189d, b5Var.f, b5Var.f190g, b5Var.f186a, true, b5Var.e);
                                        }
                                        x2Var3.f695o = b5Var;
                                        ((x2) ((e) this.f225c).f225c).f700w = null;
                                    }
                                }
                                x2 x2Var4 = (x2) ((e) this.f225c).f225c;
                                d2Var = new d2(x2Var4.f689i);
                                x2Var4.f700w = d2Var;
                            } else {
                                x2 x2Var5 = (x2) ((e) this.f225c).f225c;
                                b5Var = x2Var5.f695o;
                                if (b5Var.f191h) {
                                    b5Var = new b5(b5Var.f187b, b5Var.f188c, b5Var.f189d, b5Var.f, b5Var.f190g, b5Var.f186a, true, b5Var.e);
                                }
                                x2Var5.f695o = b5Var;
                                ((x2) ((e) this.f225c).f225c).f700w = null;
                            }
                            c9 = 0;
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                    break;
                }
                if (c9 != 0) {
                    e5 e5Var = (e5) this.f224b;
                    e5Var.f245a.c(new l6(5, (x2) ((e) this.f225c).f225c, e5Var));
                    ((e5) this.f224b).f245a.h(ze.q2.f.h("Unneeded hedging"));
                    return;
                } else {
                    if (d2Var != null) {
                        x2 x2Var6 = (x2) ((e) this.f225c).f225c;
                        d2Var.g(x2Var6.f686d.schedule(new e(22, x2Var6, d2Var), x2Var6.f687g.f481b, TimeUnit.NANOSECONDS));
                    }
                    ((x2) ((e) this.f225c).f225c).q((e5) this.f224b);
                    return;
                }
            case 22:
                x2 x2Var7 = (x2) this.f225c;
                e5 e5VarO = x2Var7.o(x2Var7.f695o.e, false);
                if (e5VarO == null) {
                    return;
                }
                ((x2) this.f225c).f684b.execute(new e(21, this, e5VarO));
                return;
            case 23:
                ((x2) ((l6) this.f225c).f447c).u.i((ze.p1) this.f224b);
                return;
            case 24:
                ((x2) ((l6) this.f225c).f447c).u.j((a8.a) this.f224b);
                return;
            default:
                ((ze.s) this.f224b).t((Throwable) this.f225c);
                return;
        }
    }

    public e(b1 b1Var, ze.f0 f0Var) {
        this.f223a = 14;
        this.f225c = b1Var;
        v8.i(f0Var, "savedListener");
        this.f224b = f0Var;
    }

    public e(ze.s sVar, Throwable th2) {
        this.f223a = 25;
        this.f224b = sVar;
        this.f225c = th2;
    }
}
