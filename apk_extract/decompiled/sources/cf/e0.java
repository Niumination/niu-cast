package cf;

import af.h6;
import af.k1;
import af.l1;
import af.l2;
import af.s3;
import af.w5;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import ze.o2;
import ze.p1;
import ze.q2;
import ze.t0;
import ze.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements ef.b, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka.d f1521a = new ka.d(Level.FINE, h0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.k f1522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1524d;
    public final /* synthetic */ h0 e;

    public e0(h0 h0Var, ef.k kVar) {
        this.e = h0Var;
        this.f1522b = kVar;
    }

    public final void a(ef.a aVar, String str) {
        this.e.h(aVar, str, k1.statusForCode(aVar.httpCode).h("HTTP2 connection error: " + aVar + " '" + str + "'"), false);
    }

    public final void b(int i8, boolean z2, int i9, o2 o2Var, String str) {
        p1 p1Var = new p1();
        p1Var.f(v0.f11452b, o2Var.toStatus());
        p1Var.f(v0.f11451a, str);
        ef.d dVar = f.f1525a;
        Charset charset = t0.f11435a;
        ArrayList arrayList = new ArrayList(p1Var.f11400b + 2);
        arrayList.add(new ef.d(a1.a.o(i9, ""), ef.d.f4909d));
        arrayList.add(new ef.d(l1.f417j.f11380a, "text/plain; charset=utf-8"));
        f.a(arrayList, p1Var);
        qj.f fVar = new qj.f();
        fVar.m0(str);
        synchronized (this.e.f1546n) {
            try {
                h0 h0Var = this.e;
                f0 f0Var = new f0(i8, h0Var.f1546n, h0Var.f1549s, h0Var.f1535a.f1510h);
                if (this.e.f1550t.isEmpty()) {
                    h0 h0Var2 = this.e;
                    h0Var2.f1545m.e = true;
                    s3 s3Var = h0Var2.f1543k;
                    if (s3Var != null) {
                        s3Var.f579g = true;
                        s3Var.f = true;
                    }
                }
                this.e.f1550t.put(Integer.valueOf(i8), f0Var);
                if (z2) {
                    f0Var.b(true, 0, new qj.f(), 0);
                }
                this.e.f1548r.f0(i8, arrayList);
                this.e.f1549s.a(true, f0Var.g(), fVar, true);
                o0 o0Var = this.e.f1549s;
                l0 l0VarG = f0Var.g();
                a0.e eVar = new a0.e(4, this, f0Var);
                o0Var.getClass();
                o0.c(l0VarG, eVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(int i8, ef.a aVar, String str) {
        if (aVar == ef.a.PROTOCOL_ERROR) {
            h0.A.log(Level.FINE, "Responding with RST_STREAM {0}: {1}", new Object[]{aVar, str});
        }
        synchronized (this.e.f1546n) {
            try {
                this.e.f1548r.f(i8, aVar);
                this.e.f1548r.flush();
                g0 g0Var = (g0) this.e.f1550t.get(Integer.valueOf(i8));
                if (g0Var != null) {
                    g0Var.f(q2.f11410m.h("Responded with RST_STREAM " + aVar + ": " + str));
                    this.e.l(i8, false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void d(int i8, long j8) {
        this.f1521a.o(r.INBOUND, i8, j8);
        synchronized (this.e.f1546n) {
            try {
                if (i8 == 0) {
                    this.e.f1549s.d(null, (int) j8);
                } else {
                    g0 g0Var = (g0) this.e.f1550t.get(Integer.valueOf(i8));
                    if (g0Var != null) {
                        this.e.f1549s.d(g0Var.g(), (int) j8);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void e(ef.o oVar) {
        boolean zB;
        this.f1521a.n(r.INBOUND, oVar);
        synchronized (this.e.f1546n) {
            try {
                if (oVar.b(7)) {
                    zB = this.e.f1549s.b(((int[]) oVar.f4952b)[7]);
                } else {
                    zB = false;
                }
                this.e.f1548r.Z(oVar);
                this.e.f1548r.flush();
                if (!this.f1523c) {
                    this.f1523c = true;
                    h0 h0Var = this.e;
                    qf.c cVar = h0Var.f;
                    ze.b bVar = h0Var.f1541i;
                    ((Future) cVar.f9048c).cancel(false);
                    cVar.f9048c = null;
                    Iterator it = ((w5) cVar.f9049d).f666g.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                    h0Var.f1541i = bVar;
                }
                if (zB) {
                    this.e.f1549s.e();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void f(int i8, ef.a aVar) {
        this.f1521a.m(r.INBOUND, i8, aVar);
        if (!ef.a.NO_ERROR.equals(aVar) && !ef.a.CANCEL.equals(aVar) && !ef.a.STREAM_CLOSED.equals(aVar)) {
            h0.A.log(Level.INFO, "Received RST_STREAM: " + aVar);
        }
        q2 q2VarH = k1.statusForCode(aVar.httpCode).h("RST_STREAM");
        synchronized (this.e.f1546n) {
            try {
                g0 g0Var = (g0) this.e.f1550t.get(Integer.valueOf(i8));
                if (g0Var != null) {
                    g0Var.d(q2VarH);
                    this.e.l(i8, false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void j(boolean z2, int i8, int i9) {
        l2 l2Var = this.e.f1545m;
        l2Var.f429b.getClass();
        long jNanoTime = System.nanoTime();
        if (l2Var.e ? (l2Var.f431d + l2Var.f428a) - jNanoTime > 0 : (l2Var.f431d + l2.f427g) - jNanoTime > 0) {
            int i10 = l2Var.f + 1;
            l2Var.f = i10;
            if (i10 > 2) {
                this.e.h(ef.a.ENHANCE_YOUR_CALM, "too_many_pings", q2.f11408k.h("Too many pings from client"), false);
                return;
            }
        } else {
            l2Var.f431d = jNanoTime;
        }
        long j8 = (((long) i8) << 32) | (((long) i9) & 4294967295L);
        if (!z2) {
            this.f1521a.j(r.INBOUND, j8);
            synchronized (this.e.f1546n) {
                this.e.f1548r.j(true, i8, i9);
                this.e.f1548r.flush();
            }
            return;
        }
        this.f1521a.k(r.INBOUND, j8);
        if (57005 == j8) {
            return;
        }
        if (4369 == j8) {
            this.e.n();
            return;
        }
        h0.A.log(Level.INFO, "Received unexpected ping ack: " + j8);
    }

    @Override // ef.b
    public final void k(ArrayList arrayList, int i8, int i9) {
        this.f1521a.l(r.INBOUND, i8, i9, arrayList);
        a(ef.a.PROTOCOL_ERROR, "PUSH_PROMISE only allowed on peer-initiated streams. RFC7540 section 6.6");
    }

    @Override // ef.b
    public final void l(int i8, ef.a aVar, qj.j jVar) {
        this.f1521a.h(r.INBOUND, i8, aVar, jVar);
        q2 q2VarH = k1.statusForCode(aVar.httpCode).h("Received GOAWAY: " + aVar + " '" + jVar.utf8() + "'");
        if (!ef.a.NO_ERROR.equals(aVar)) {
            h0.A.log(Level.WARNING, "Received GOAWAY: {0} {1}", new Object[]{aVar, jVar.utf8()});
        }
        synchronized (this.e.f1546n) {
            this.e.f1552w = q2VarH;
        }
    }

    @Override // ef.b
    public final void m(int i8, int i9, int i10, boolean z2) {
        r rVar = r.INBOUND;
        ka.d dVar = this.f1521a;
        if (dVar.f()) {
            ((Logger) dVar.f6816a).log((Level) dVar.f6817b, rVar + " PRIORITY: streamId=" + i8 + " streamDependency=" + i9 + " weight=" + i10 + " exclusive=" + z2);
        }
    }

    @Override // ef.b
    public final void n(boolean z2, int i8, qj.t tVar, int i9, int i10) throws EOFException {
        this.f1521a.g(r.INBOUND, i8, tVar.f9222b, i9, z2);
        if (i8 == 0) {
            a(ef.a.PROTOCOL_ERROR, "Stream 0 is reserved for control messages. RFC7540 section 5.1.1");
            return;
        }
        if ((i8 & 1) == 0) {
            a(ef.a.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
            return;
        }
        long j8 = i9;
        tVar.K(j8);
        synchronized (this.e.f1546n) {
            try {
                g0 g0Var = (g0) this.e.f1550t.get(Integer.valueOf(i8));
                if (g0Var == null) {
                    tVar.m(j8);
                    c(i8, ef.a.STREAM_CLOSED, "Received data for closed stream");
                    return;
                }
                if (g0Var.e()) {
                    tVar.m(j8);
                    c(i8, ef.a.STREAM_CLOSED, "Received DATA for half-closed (remote) stream. RFC7540 section 5.1");
                    return;
                }
                if (g0Var.c() < i10) {
                    tVar.m(j8);
                    c(i8, ef.a.FLOW_CONTROL_ERROR, "Received DATA size exceeded window size. RFC7540 section 6.9");
                    return;
                }
                qj.f fVar = new qj.f();
                fVar.k0(tVar.f9222b, j8);
                g0Var.b(z2, i9, fVar, i10 - i9);
                int i11 = this.f1524d + i10;
                this.f1524d = i11;
                float f = i11;
                h0 h0Var = this.e;
                if (f >= h0Var.f1535a.f1510h * 0.5f) {
                    synchronized (h0Var.f1546n) {
                        this.e.f1548r.d(0, this.f1524d);
                        this.e.f1548r.flush();
                    }
                    this.f1524d = 0;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void o(ArrayList arrayList, int i8, boolean z2) throws Throwable {
        h6 h6Var;
        Object obj;
        qj.j jVar;
        int iJ;
        this.f1521a.i(r.INBOUND, i8, arrayList, z2);
        if ((i8 & 1) == 0) {
            a(ef.a.PROTOCOL_ERROR, "Clients cannot open even numbered streams. RFC7540 section 5.1.1");
            return;
        }
        synchronized (this.e.f1546n) {
            try {
                h0 h0Var = this.e;
                if (i8 > h0Var.f1551v) {
                    return;
                }
                boolean z3 = i8 > h0Var.u;
                if (z3) {
                    h0Var.u = i8;
                }
                long size = 0;
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    ef.d dVar = (ef.d) arrayList.get(i9);
                    size += (long) (dVar.f4913b.size() + dVar.f4912a.size() + 32);
                }
                int iMin = (int) Math.min(size, 2147483647L);
                int i10 = this.e.f1535a.f1512j;
                if (iMin > i10) {
                    o2 o2Var = o2.RESOURCE_EXHAUSTED;
                    Locale locale = Locale.US;
                    b(i8, z2, 431, o2Var, o.d.f(i10, iMin, "Request metadata larger than ", ": "));
                    return;
                }
                qj.j jVar2 = qj.j.EMPTY;
                int iJ2 = 0;
                while (true) {
                    iJ2 = h0.j(arrayList, jVar2, iJ2);
                    if (iJ2 == -1) {
                        break;
                    } else {
                        arrayList.remove(iJ2);
                    }
                }
                qj.j jVar3 = null;
                qj.j jVar4 = null;
                qj.j jVar5 = null;
                qj.j jVar6 = null;
                while (arrayList.size() > 0 && ((ef.d) arrayList.get(0)).f4912a.getByte(0) == 58) {
                    ef.d dVar2 = (ef.d) arrayList.remove(0);
                    if (h0.C.equals(dVar2.f4912a) && jVar3 == null) {
                        jVar3 = dVar2.f4913b;
                    } else if (h0.F.equals(dVar2.f4912a) && jVar4 == null) {
                        jVar4 = dVar2.f4913b;
                    } else if (h0.G.equals(dVar2.f4912a) && jVar5 == null) {
                        jVar5 = dVar2.f4913b;
                    } else {
                        if (!h0.H.equals(dVar2.f4912a) || jVar6 != null) {
                            c(i8, ef.a.PROTOCOL_ERROR, "Unexpected pseudo header. RFC7540 section 8.1.2.1");
                            return;
                        }
                        jVar6 = dVar2.f4913b;
                    }
                }
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    if (((ef.d) arrayList.get(i11)).f4912a.getByte(0) == 58) {
                        c(i8, ef.a.PROTOCOL_ERROR, "Pseudo header not before regular headers. RFC7540 section 8.1.2.1");
                        return;
                    }
                }
                if (!h0.D.equals(jVar3) && z3 && (jVar3 == null || jVar4 == null || jVar5 == null)) {
                    c(i8, ef.a.PROTOCOL_ERROR, "Missing required pseudo header. RFC7540 section 8.1.2.3");
                    return;
                }
                if (h0.j(arrayList, h0.I, 0) != -1) {
                    c(i8, ef.a.PROTOCOL_ERROR, "Connection-specific headers not permitted. RFC7540 section 8.1.2.2");
                    return;
                }
                if (!z3) {
                    if (!z2) {
                        c(i8, ef.a.PROTOCOL_ERROR, "Headers disallowed in the middle of the stream. RFC7540 section 8.1");
                        return;
                    }
                    synchronized (this.e.f1546n) {
                        try {
                            g0 g0Var = (g0) this.e.f1550t.get(Integer.valueOf(i8));
                            if (g0Var == null) {
                                c(i8, ef.a.STREAM_CLOSED, "Received headers for closed stream");
                                return;
                            } else if (g0Var.e()) {
                                c(i8, ef.a.STREAM_CLOSED, "Received HEADERS for half-closed (remote) stream. RFC7540 section 5.1");
                                return;
                            } else {
                                g0Var.b(true, 0, new qj.f(), 0);
                                return;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                if (jVar6 == null && (iJ = h0.j(arrayList, (jVar = h0.J), 0)) != -1) {
                    if (h0.j(arrayList, jVar, iJ + 1) != -1) {
                        b(i8, z2, 400, o2.INTERNAL, "Multiple host headers disallowed. RFC7230 section 5.4");
                        return;
                    }
                    jVar6 = ((ef.d) arrayList.get(iJ)).f4913b;
                }
                qj.j jVar7 = jVar6;
                qj.j jVar8 = h0.J;
                int iJ3 = 0;
                while (true) {
                    iJ3 = h0.j(arrayList, jVar8, iJ3);
                    if (iJ3 == -1) {
                        break;
                    } else {
                        arrayList.remove(iJ3);
                    }
                }
                if (jVar5.size() == 0 || jVar5.getByte(0) != 47) {
                    b(i8, z2, 404, o2.UNIMPLEMENTED, "Expected path to start with /: " + h0.i(jVar5));
                    return;
                }
                String strSubstring = h0.i(jVar5).substring(1);
                qj.j jVar9 = h0.M;
                int iJ4 = h0.j(arrayList, jVar9, 0);
                qj.j jVar10 = (iJ4 != -1 && h0.j(arrayList, jVar9, iJ4 + 1) == -1) ? ((ef.d) arrayList.get(iJ4)).f4913b : null;
                if (jVar10 == null) {
                    b(i8, z2, 415, o2.INTERNAL, "Content-Type is missing or duplicated");
                    return;
                }
                String strI = h0.i(jVar10);
                if (!l1.i(strI)) {
                    b(i8, z2, 415, o2.INTERNAL, h0.a.i("Content-Type is not supported: ", strI));
                    return;
                }
                if (!h0.E.equals(jVar3)) {
                    b(i8, z2, 405, o2.INTERNAL, "HTTP Method is not supported: " + h0.i(jVar3));
                    return;
                }
                qj.j jVar11 = h0.K;
                int iJ5 = h0.j(arrayList, jVar11, 0);
                qj.j jVar12 = (iJ5 != -1 && h0.j(arrayList, jVar11, iJ5 + 1) == -1) ? ((ef.d) arrayList.get(iJ5)).f4913b : null;
                qj.j jVar13 = h0.L;
                if (!jVar13.equals(jVar12)) {
                    o2 o2Var2 = o2.INTERNAL;
                    String strL = h0.a.l("Expected header TE: ", h0.i(jVar13), ", but ", jVar12 == null ? "<missing>" : h0.i(jVar12), " is received. Some intermediate proxy may not support trailers");
                    p1 p1Var = new p1();
                    p1Var.f(v0.f11452b, o2Var2.toStatus());
                    p1Var.f(v0.f11451a, strL);
                    ArrayList arrayListB = f.b(p1Var);
                    synchronized (this.e.f1546n) {
                        try {
                            this.e.f1548r.Q(true, i8, arrayListB);
                            if (!z2) {
                                this.e.f1548r.f(i8, ef.a.NO_ERROR);
                            }
                            this.e.f1548r.flush();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    return;
                }
                qj.j jVar14 = h0.N;
                int iJ6 = 0;
                while (true) {
                    iJ6 = h0.j(arrayList, jVar14, iJ6);
                    if (iJ6 == -1) {
                        break;
                    } else {
                        arrayList.remove(iJ6);
                    }
                }
                byte[][] bArrA = p0.a(arrayList);
                int length = bArrA.length / 2;
                p1 p1Var2 = new p1();
                p1Var2.f11400b = length;
                p1Var2.f11399a = bArrA;
                List list = this.e.f1535a.f1505a;
                h6 h6Var2 = h6.f311c;
                if (list.isEmpty()) {
                    h6Var = h6.f311c;
                } else {
                    int size2 = list.size();
                    ze.n[] nVarArr = new ze.n[size2];
                    if (size2 > 0) {
                        list.get(0).getClass();
                        throw new ClassCastException();
                    }
                    h6Var = new h6(nVarArr);
                }
                h6 h6Var3 = h6Var;
                Object obj2 = this.e.f1546n;
                synchronized (obj2) {
                    try {
                        h0 h0Var2 = this.e;
                        d0 d0Var = h0Var2.f1535a;
                        obj = obj2;
                        try {
                            a0 a0Var = new a0(h0Var2, i8, d0Var.f1511i, h6Var3, h0Var2.f1546n, h0Var2.f1548r, h0Var2.f1549s, d0Var.f1510h, h0Var2.f1537c);
                            b0 b0Var = new b0(a0Var, this.e.f1541i, jVar7 == null ? null : h0.i(jVar7), h6Var3, this.e.f1537c);
                            if (this.e.f1550t.isEmpty()) {
                                h0 h0Var3 = this.e;
                                h0Var3.f1545m.e = true;
                                s3 s3Var = h0Var3.f1543k;
                                if (s3Var != null) {
                                    s3Var.f579g = true;
                                    s3Var.f = true;
                                }
                            }
                            this.e.f1550t.put(Integer.valueOf(i8), a0Var);
                            qf.c cVar = this.e.f;
                            cVar.getClass();
                            int i12 = b0Var.f1488g.q;
                            ph.b.f8887a.getClass();
                            ph.b.d();
                            try {
                                ph.b.a();
                                cVar.B(b0Var, strSubstring, p1Var2);
                                a0Var.n();
                                if (z2) {
                                    a0Var.b(z2, 0, new qj.f(), 0);
                                }
                            } catch (Throwable th4) {
                                try {
                                    ph.b.f8887a.getClass();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th4.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        obj = obj2;
                    }
                }
            } catch (Throwable th8) {
                throw th8;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        h0 h0Var;
        q2 q2VarH;
        h0 h0Var2;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpServerTransport");
        try {
            this.f1522b.c();
            if (this.f1522b.a(this)) {
                if (this.f1523c) {
                    while (this.f1522b.a(this)) {
                        af.q2 q2Var = this.e.f1542j;
                        if (q2Var != null) {
                            q2Var.a();
                        }
                    }
                    synchronized (this.e.f1546n) {
                        q2VarH = this.e.f1552w;
                    }
                    if (q2VarH == null) {
                        q2VarH = q2.f11411n.h("TCP connection closed or IOException");
                    }
                    this.e.h(ef.a.INTERNAL_ERROR, "I/O failure", q2VarH, false);
                    try {
                        l1.c(this.e.e.getInputStream());
                    } catch (IOException unused) {
                    }
                    l1.b(this.e.e);
                    h0Var = this.e;
                } else {
                    a(ef.a.PROTOCOL_ERROR, "First HTTP/2 frame must be SETTINGS. RFC7540 section 3.5");
                    try {
                        l1.c(this.e.e.getInputStream());
                    } catch (IOException unused2) {
                    }
                    l1.b(this.e.e);
                    h0Var2 = this.e;
                }
                h0Var.m();
                return;
            }
            a(ef.a.INTERNAL_ERROR, "Failed to read initial SETTINGS");
            try {
                l1.c(this.e.e.getInputStream());
            } catch (IOException unused3) {
            }
            l1.b(this.e.e);
            h0Var2 = this.e;
            h0Var2.m();
            Thread.currentThread().setName(name);
        } catch (Throwable th2) {
            try {
                h0.A.log(Level.WARNING, "Error decoding HTTP/2 frames", th2);
                this.e.h(ef.a.INTERNAL_ERROR, "Error in frame decoder", q2.f11410m.h("Error decoding HTTP/2 frames").g(th2), false);
                try {
                    l1.c(this.e.e.getInputStream());
                } catch (IOException unused4) {
                }
                l1.b(this.e.e);
                h0Var = this.e;
            } finally {
                try {
                    l1.c(this.e.e.getInputStream());
                } catch (IOException unused5) {
                }
                l1.b(this.e.e);
                this.e.m();
                Thread.currentThread().setName(name);
            }
        }
    }
}
