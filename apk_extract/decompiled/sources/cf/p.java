package cf;

import af.c2;
import af.d2;
import af.f2;
import af.k1;
import af.n2;
import af.q1;
import af.r1;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import ze.o2;
import ze.p1;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements ef.b, Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.k f1608b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f1610d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka.d f1607a = new ka.d(Level.FINE, q.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1609c = true;

    public p(q qVar, ef.k kVar) {
        this.f1610d = qVar;
        this.f1608b = kVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0072, please report this as an issue */
    @Override // ef.b
    public final void d(int i8, long j8) {
        boolean z2;
        l0 l0Var;
        this.f1607a.o(r.INBOUND, i8, j8);
        if (j8 == 0) {
            if (i8 == 0) {
                q.h(this.f1610d, ef.a.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                return;
            } else {
                this.f1610d.k(i8, q2.f11410m.h("Received 0 flow control window increment."), af.c0.PROCESSED, false, ef.a.PROTOCOL_ERROR, null);
                return;
            }
        }
        synchronized (this.f1610d.f1619k) {
            try {
                if (i8 == 0) {
                    this.f1610d.f1618j.d(null, (int) j8);
                    return;
                }
                n nVar = (n) this.f1610d.f1622n.get(Integer.valueOf(i8));
                if (nVar == null) {
                    z2 = this.f1610d.n(i8) ? false : true;
                    if (z2) {
                        q.h(this.f1610d, ef.a.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i8);
                    }
                }
                o0 o0Var = this.f1610d.f1618j;
                m mVar = nVar.f1600n;
                synchronized (mVar.f1591w) {
                    l0Var = mVar.J;
                }
                o0Var.d(l0Var, (int) j8);
                if (z2) {
                    q.h(this.f1610d, ef.a.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i8);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void e(ef.o oVar) {
        boolean zB;
        this.f1607a.n(r.INBOUND, oVar);
        synchronized (this.f1610d.f1619k) {
            try {
                if (oVar.b(4)) {
                    this.f1610d.C = ((int[]) oVar.f4952b)[4];
                }
                if (oVar.b(7)) {
                    zB = this.f1610d.f1618j.b(((int[]) oVar.f4952b)[7]);
                } else {
                    zB = false;
                }
                if (this.f1609c) {
                    d2 d2Var = this.f1610d.f1616h;
                    f2 f2Var = (f2) d2Var.f215c;
                    f2Var.f266i.f(ze.h.INFO, "READY");
                    f2Var.f267j.execute(new c2(d2Var, 0));
                    this.f1609c = false;
                }
                this.f1610d.f1617i.Z(oVar);
                if (zB) {
                    this.f1610d.f1618j.e();
                }
                this.f1610d.s();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void f(int i8, ef.a aVar) {
        this.f1607a.m(r.INBOUND, i8, aVar);
        q2 q2VarA = q.v(aVar).a("Rst Stream");
        o2 o2Var = q2VarA.f11413a;
        boolean z2 = o2Var == o2.CANCELLED || o2Var == o2.DEADLINE_EXCEEDED;
        synchronized (this.f1610d.f1619k) {
            try {
                n nVar = (n) this.f1610d.f1622n.get(Integer.valueOf(i8));
                if (nVar != null) {
                    ph.c cVar = nVar.f1600n.I;
                    ph.b.b();
                    this.f1610d.k(i8, q2VarA, aVar == ef.a.REFUSED_STREAM ? af.c0.REFUSED : af.c0.PROCESSED, z2, null, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ef.b
    public final void j(boolean z2, int i8, int i9) {
        r1 r1Var;
        long j8 = (((long) i8) << 32) | (((long) i9) & 4294967295L);
        this.f1607a.j(r.INBOUND, j8);
        if (!z2) {
            synchronized (this.f1610d.f1619k) {
                this.f1610d.f1617i.j(true, i8, i9);
            }
            return;
        }
        synchronized (this.f1610d.f1619k) {
            try {
                q qVar = this.f1610d;
                r1Var = qVar.f1629x;
                if (r1Var != null) {
                    long j10 = r1Var.f545a;
                    if (j10 == j8) {
                        qVar.f1629x = null;
                    } else {
                        Logger logger = q.Q;
                        Level level = Level.WARNING;
                        Locale locale = Locale.US;
                        logger.log(level, "Received unexpected ping ack. Expecting " + j10 + ", got " + j8);
                    }
                } else {
                    q.Q.warning("Received unexpected ping ack. No ping outstanding");
                }
                r1Var = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (r1Var != null) {
            synchronized (r1Var) {
                try {
                    if (!r1Var.f548d) {
                        r1Var.f548d = true;
                        long jA = r1Var.f546b.a(TimeUnit.NANOSECONDS);
                        r1Var.f = jA;
                        LinkedHashMap linkedHashMap = r1Var.f547c;
                        r1Var.f547c = null;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            try {
                                ((Executor) entry.getValue()).execute(new q1((n2) entry.getKey(), jA));
                            } catch (Throwable th3) {
                                r1.f544g.log(Level.SEVERE, "Failed to execute PingCallback", th3);
                            }
                        }
                    }
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    @Override // ef.b
    public final void k(ArrayList arrayList, int i8, int i9) {
        this.f1607a.l(r.INBOUND, i8, i9, arrayList);
        synchronized (this.f1610d.f1619k) {
            this.f1610d.f1617i.f(i8, ef.a.PROTOCOL_ERROR);
        }
    }

    @Override // ef.b
    public final void l(int i8, ef.a aVar, qj.j jVar) {
        this.f1607a.h(r.INBOUND, i8, aVar, jVar);
        ef.a aVar2 = ef.a.ENHANCE_YOUR_CALM;
        q qVar = this.f1610d;
        if (aVar == aVar2) {
            String strUtf8 = jVar.utf8();
            q.Q.log(Level.WARNING, this + ": Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: " + strUtf8);
            if ("too_many_pings".equals(strUtf8)) {
                qVar.J.run();
            }
        }
        q2 q2VarA = k1.statusForCode(aVar.httpCode).a("Received Goaway");
        if (jVar.size() > 0) {
            q2VarA = q2VarA.a(jVar.utf8());
        }
        Map map = q.P;
        qVar.r(i8, null, q2VarA);
    }

    @Override // ef.b
    public final void m(int i8, int i9, int i10, boolean z2) {
    }

    @Override // ef.b
    public final void n(boolean z2, int i8, qj.t tVar, int i9, int i10) throws EOFException {
        n nVar;
        this.f1607a.g(r.INBOUND, i8, tVar.f9222b, i9, z2);
        q qVar = this.f1610d;
        synchronized (qVar.f1619k) {
            nVar = (n) qVar.f1622n.get(Integer.valueOf(i8));
        }
        if (nVar != null) {
            long j8 = i9;
            tVar.K(j8);
            qj.f fVar = new qj.f();
            fVar.k0(tVar.f9222b, j8);
            ph.c cVar = nVar.f1600n.I;
            ph.b.b();
            synchronized (this.f1610d.f1619k) {
                nVar.f1600n.z(i10 - i9, fVar, z2);
            }
        } else {
            if (!this.f1610d.n(i8)) {
                q.h(this.f1610d, ef.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i8);
                return;
            }
            synchronized (this.f1610d.f1619k) {
                this.f1610d.f1617i.f(i8, ef.a.STREAM_CLOSED);
            }
            tVar.m(i9);
        }
        q qVar2 = this.f1610d;
        int i11 = qVar2.f1625s + i10;
        qVar2.f1625s = i11;
        if (i11 >= qVar2.f * 0.5f) {
            synchronized (qVar2.f1619k) {
                q qVar3 = this.f1610d;
                qVar3.f1617i.d(0, qVar3.f1625s);
            }
            this.f1610d.f1625s = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0070  */
    @Override // ef.b
    public final void o(ArrayList arrayList, int i8, boolean z2) {
        q2 q2VarH;
        this.f1607a.i(r.INBOUND, i8, arrayList, z2);
        boolean z3 = false;
        if (this.f1610d.K != Integer.MAX_VALUE) {
            long size = 0;
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                ef.d dVar = (ef.d) arrayList.get(i9);
                size += (long) (dVar.f4913b.size() + dVar.f4912a.size() + 32);
            }
            int iMin = (int) Math.min(size, 2147483647L);
            int i10 = this.f1610d.K;
            if (iMin > i10) {
                q2 q2Var = q2.f11408k;
                Locale locale = Locale.US;
                q2VarH = q2Var.h("Response " + (z2 ? "trailer" : "header") + " metadata larger than " + i10 + ": " + iMin);
            } else {
                q2VarH = null;
            }
        } else {
            q2VarH = null;
        }
        synchronized (this.f1610d.f1619k) {
            try {
                n nVar = (n) this.f1610d.f1622n.get(Integer.valueOf(i8));
                if (nVar == null) {
                    if (this.f1610d.n(i8)) {
                        this.f1610d.f1617i.f(i8, ef.a.STREAM_CLOSED);
                    } else {
                        z3 = true;
                    }
                } else if (q2VarH == null) {
                    ph.c cVar = nVar.f1600n.I;
                    ph.b.b();
                    nVar.f1600n.A(arrayList, z2);
                } else {
                    if (!z2) {
                        this.f1610d.f1617i.f(i8, ef.a.CANCEL);
                    }
                    nVar.f1600n.s(q2VarH, new p1(), false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z3) {
            q.h(this.f1610d, ef.a.PROTOCOL_ERROR, "Received header for unknown stream: " + i8);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar;
        q2 q2VarH;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.f1608b.a(this)) {
            try {
                af.q2 q2Var = this.f1610d.F;
                if (q2Var != null) {
                    q2Var.a();
                }
            } catch (Throwable th2) {
                try {
                    q qVar2 = this.f1610d;
                    ef.a aVar = ef.a.PROTOCOL_ERROR;
                    q2 q2VarG = q2.f11410m.h("error in frame handler").g(th2);
                    Map map = q.P;
                    qVar2.r(0, aVar, q2VarG);
                    try {
                        this.f1608b.close();
                    } catch (IOException e) {
                        q.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                    }
                    qVar = this.f1610d;
                } finally {
                    try {
                        this.f1608b.close();
                    } catch (IOException e4) {
                        q.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e4);
                    }
                    this.f1610d.f1616h.j();
                    Thread.currentThread().setName(name);
                }
            }
        }
        synchronized (this.f1610d.f1619k) {
            q2VarH = this.f1610d.f1627v;
        }
        if (q2VarH == null) {
            q2VarH = q2.f11411n.h("End of stream or IOException");
        }
        this.f1610d.r(0, ef.a.INTERNAL_ERROR, q2VarH);
        try {
            this.f1608b.close();
        } catch (IOException e10) {
            q.Q.log(Level.INFO, "Exception closing frame reader", (Throwable) e10);
        }
        qVar = this.f1610d;
        d2 d2Var = qVar.f1616h;
    }
}
