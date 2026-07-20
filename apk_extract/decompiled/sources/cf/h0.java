package cf;

import af.a6;
import af.f6;
import af.g6;
import af.l1;
import af.l2;
import af.l6;
import af.q2;
import af.s3;
import af.w5;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import k3.v8;
import ze.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements a6, d, m0 {
    public static final Logger A = Logger.getLogger(h0.class.getName());
    public static final long B = TimeUnit.SECONDS.toNanos(1);
    public static final qj.j C = qj.j.encodeUtf8(":method");
    public static final qj.j D = qj.j.encodeUtf8("CONNECT");
    public static final qj.j E = qj.j.encodeUtf8("POST");
    public static final qj.j F = qj.j.encodeUtf8(":scheme");
    public static final qj.j G = qj.j.encodeUtf8(":path");
    public static final qj.j H = qj.j.encodeUtf8(":authority");
    public static final qj.j I = qj.j.encodeUtf8("connection");
    public static final qj.j J = qj.j.encodeUtf8("host");
    public static final qj.j K = qj.j.encodeUtf8("te");
    public static final qj.j L = qj.j.encodeUtf8("trailers");
    public static final qj.j M = qj.j.encodeUtf8("content-type");
    public static final qj.j N = qj.j.encodeUtf8("content-length");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f1535a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l6 f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f1538d;
    public Socket e;
    public qf.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Executor f1539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledExecutorService f1540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ze.b f1541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q2 f1542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s3 f1543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScheduledFuture f1544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l2 f1545m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1547o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public e f1548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public o0 f1549s;
    public int u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ze.q2 f1552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ScheduledFuture f1553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ScheduledFuture f1554y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.m f1536b = new ef.m();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f1546n = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TreeMap f1550t = new TreeMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1551v = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Long f1555z = null;

    public h0(d0 d0Var, Socket socket) {
        v8.i(d0Var, "config");
        this.f1535a = d0Var;
        v8.i(socket, "bareSocket");
        this.e = socket;
        d0Var.f1508d.getClass();
        this.f1537c = new l6();
        this.f1538d = r0.a(h0.class, this.e.getRemoteSocketAddress().toString());
        this.f1539g = (Executor) g6.a((f6) d0Var.f1506b.f44b);
        this.f1540h = (ScheduledExecutorService) g6.a((f6) d0Var.f1507c.f44b);
        this.f1545m = new l2(d0Var.f1514l, TimeUnit.NANOSECONDS);
    }

    public static String i(qj.j jVar) {
        for (int i8 = 0; i8 < jVar.size(); i8++) {
            if (jVar.getByte(i8) < 0) {
                return jVar.string(l1.f412c);
            }
        }
        return jVar.utf8();
    }

    public static int j(ArrayList arrayList, qj.j jVar, int i8) {
        while (i8 < arrayList.size()) {
            if (((ef.d) arrayList.get(i8)).f4912a.equals(jVar)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    @Override // cf.d
    public final void b(Exception exc) {
        h(ef.a.INTERNAL_ERROR, "I/O failure", ze.q2.f11411n.g(exc), false);
    }

    @Override // ze.q0
    public final r0 d() {
        return this.f1538d;
    }

    @Override // cf.m0
    public final l0[] e() {
        l0[] l0VarArr;
        synchronized (this.f1546n) {
            try {
                l0VarArr = new l0[this.f1550t.size()];
                Iterator it = this.f1550t.values().iterator();
                int i8 = 0;
                while (it.hasNext()) {
                    l0VarArr[i8] = ((g0) it.next()).g();
                    i8++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return l0VarArr;
    }

    public final void h(ef.a aVar, String str, ze.q2 q2Var, boolean z2) {
        synchronized (this.f1546n) {
            try {
                if (this.f1547o) {
                    return;
                }
                this.f1547o = true;
                this.f1552w = q2Var;
                ScheduledFuture scheduledFuture = this.f1553x;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.f1553x = null;
                }
                for (Map.Entry entry : this.f1550t.entrySet()) {
                    if (z2) {
                        this.f1548r.f(((Integer) entry.getKey()).intValue(), ef.a.CANCEL);
                    }
                    ((g0) entry.getValue()).f(q2Var);
                }
                this.f1550t.clear();
                this.f1548r.c0(this.u, aVar, str.getBytes(l1.f412c));
                this.f1551v = this.u;
                this.f1548r.close();
                this.f1554y = this.f1540h.schedule(new c0(this, 0), 1L, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k(Long l4) {
        synchronized (this.f1546n) {
            try {
                if (!this.p && !this.f1547o) {
                    this.p = true;
                    this.f1555z = l4;
                    if (this.f1548r == null) {
                        this.q = true;
                        l1.b(this.e);
                    } else {
                        this.f1553x = this.f1540h.schedule(new c0(this, 1), B, TimeUnit.NANOSECONDS);
                        this.f1548r.c0(Integer.MAX_VALUE, ef.a.NO_ERROR, new byte[0]);
                        this.f1548r.j(false, 0, 4369);
                        this.f1548r.flush();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(int i8, boolean z2) {
        synchronized (this.f1546n) {
            try {
                this.f1550t.remove(Integer.valueOf(i8));
                if (this.f1550t.isEmpty()) {
                    this.f1545m.e = false;
                    s3 s3Var = this.f1543k;
                    if (s3Var != null) {
                        s3Var.f579g = false;
                        ScheduledFuture scheduledFuture = s3Var.f576b;
                        if (scheduledFuture != null) {
                            boolean zIsDone = scheduledFuture.isDone();
                            long j8 = s3Var.f575a;
                            if (zIsDone) {
                                s3Var.f = false;
                                s3Var.f576b = s3Var.f578d.schedule(s3Var.f577c, j8, TimeUnit.NANOSECONDS);
                            } else {
                                s3Var.e = System.nanoTime() + j8;
                            }
                        }
                    }
                }
                if (this.p && this.f1550t.isEmpty()) {
                    this.f1548r.close();
                } else if (z2) {
                    this.f1548r.flush();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m() {
        ScheduledFuture scheduledFuture;
        synchronized (this.f1546n) {
            try {
                ScheduledFuture scheduledFuture2 = this.f1554y;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f1554y = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        q2 q2Var = this.f1542j;
        if (q2Var != null) {
            q2Var.c();
        }
        s3 s3Var = this.f1543k;
        if (s3Var != null && (scheduledFuture = s3Var.f576b) != null) {
            scheduledFuture.cancel(false);
            s3Var.f576b = null;
        }
        ScheduledFuture scheduledFuture3 = this.f1544l;
        if (scheduledFuture3 != null) {
            scheduledFuture3.cancel(false);
        }
        this.f1535a.f1506b.n(this.f1539g);
        this.f1539g = null;
        this.f1535a.f1507c.n(this.f1540h);
        this.f1540h = null;
        qf.c cVar = this.f;
        Future future = (Future) cVar.f9048c;
        if (future != null) {
            future.cancel(false);
            cVar.f9048c = null;
        }
        Iterator it = ((w5) cVar.f9049d).f666g.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        w5 w5Var = (w5) cVar.f9049d;
        h0 h0Var = (h0) cVar.f9047b;
        synchronized (w5Var.f672m) {
            if (!w5Var.f673n.remove(h0Var)) {
                throw new AssertionError("Transport already removed");
            }
            ze.o0.b((ze.n0) w5Var.q.e.get(Long.valueOf(w5Var.f663b.f11421c)), h0Var);
            synchronized (w5Var.f672m) {
            }
        }
    }

    public final void n() {
        synchronized (this.f1546n) {
            try {
                ScheduledFuture scheduledFuture = this.f1553x;
                if (scheduledFuture == null) {
                    return;
                }
                scheduledFuture.cancel(false);
                this.f1553x = null;
                this.f1548r.c0(this.u, ef.a.NO_ERROR, new byte[0]);
                this.f1551v = this.u;
                if (this.f1550t.isEmpty()) {
                    this.f1548r.close();
                } else {
                    this.f1548r.flush();
                }
                Long l4 = this.f1555z;
                if (l4 != null) {
                    this.f1554y = this.f1540h.schedule(new c0(this, 0), l4.longValue(), TimeUnit.NANOSECONDS);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
