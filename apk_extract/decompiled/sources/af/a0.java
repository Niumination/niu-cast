package af;

import com.google.protobuf.MessageLite;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends ze.j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f122s = Logger.getLogger(a0.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final double f123t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.r1 f124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ph.c f125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f127d;
    public final r e;
    public final ze.y f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture f128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ze.f f130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b0 f131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f134m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k0 f135n;
    public final ScheduledExecutorService p;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a8.a f136o = new a8.a(this, 1);
    public ze.b0 q = ze.b0.f11324d;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ze.p f137r = ze.p.f11394b;

    static {
        "gzip".getBytes(Charset.forName("US-ASCII"));
        f123t = TimeUnit.SECONDS.toNanos(1L) * 1.0d;
    }

    public a0(ze.r1 r1Var, Executor executor, ze.f fVar, k0 k0Var, ScheduledExecutorService scheduledExecutorService, r rVar) {
        this.f124a = r1Var;
        String str = r1Var.f11423b;
        System.identityHashCode(this);
        ph.b.f8887a.getClass();
        this.f125b = ph.a.f8885a;
        if (executor == m4.k.INSTANCE) {
            this.f126c = new l5();
            this.f127d = true;
        } else {
            this.f126c = new o5(executor);
            this.f127d = false;
        }
        this.e = rVar;
        this.f = ze.y.i();
        ze.q1 q1Var = ze.q1.UNARY;
        ze.q1 q1Var2 = r1Var.f11422a;
        this.f129h = q1Var2 == q1Var || q1Var2 == ze.q1.SERVER_STREAMING;
        this.f130i = fVar;
        this.f135n = k0Var;
        this.p = scheduledExecutorService;
        ph.b.b();
    }

    @Override // ze.j
    public final void a(String str, Throwable th2) {
        ph.b.d();
        try {
            ph.b.a();
            g(str, th2);
            ph.b.f8887a.getClass();
        } catch (Throwable th3) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    @Override // ze.j
    public final void b() {
        ph.b.d();
        try {
            ph.b.a();
            v8.n(this.f131j != null, "Not started");
            v8.n(!this.f133l, "call was cancelled");
            v8.n(!this.f134m, "call already half-closed");
            this.f134m = true;
            this.f131j.k();
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.j
    public final boolean c() {
        if (this.f134m) {
            return false;
        }
        return this.f131j.isReady();
    }

    @Override // ze.j
    public final void d(int i8) {
        ph.b.d();
        try {
            ph.b.a();
            v8.n(this.f131j != null, "Not started");
            v8.c("Number requested must be non-negative", i8 >= 0);
            this.f131j.e(i8);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.j
    public final void e(Object obj) {
        ph.b.d();
        try {
            ph.b.a();
            i(obj);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.j
    public final void f(ze.f0 f0Var, ze.p1 p1Var) {
        ph.b.d();
        try {
            ph.b.a();
            j(f0Var, p1Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void g(String str, Throwable th2) {
        if (str == null && th2 == null) {
            th2 = new CancellationException("Cancelled without a message or cause");
            f122s.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th2);
        }
        if (this.f133l) {
            return;
        }
        this.f133l = true;
        try {
            if (this.f131j != null) {
                ze.q2 q2Var = ze.q2.f;
                ze.q2 q2VarH = str != null ? q2Var.h(str) : q2Var.h("Call cancelled without message");
                if (th2 != null) {
                    q2VarH = q2VarH.g(th2);
                }
                this.f131j.h(q2VarH);
            }
        } finally {
            h();
        }
    }

    public final void h() {
        this.f.o(this.f136o);
        ScheduledFuture scheduledFuture = this.f128g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void i(Object obj) {
        v8.n(this.f131j != null, "Not started");
        v8.n(!this.f133l, "call was cancelled");
        v8.n(!this.f134m, "call was half-closed");
        try {
            b0 b0Var = this.f131j;
            if (b0Var instanceof x2) {
                ((x2) b0Var).u(obj);
            } else {
                gf.b bVar = this.f124a.f11425d;
                bVar.getClass();
                b0Var.i(new gf.a((MessageLite) obj, bVar.f5181a));
            }
            if (this.f129h) {
                return;
            }
            this.f131j.flush();
        } catch (Error e) {
            this.f131j.h(ze.q2.f.h("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e4) {
            this.f131j.h(ze.q2.f.g(e4).h("Failed to stream message"));
        }
    }

    public final void j(ze.f0 f0Var, ze.p1 p1Var) {
        ze.o oVar;
        ze.z zVar;
        b0 x2Var;
        ze.f fVar;
        boolean zD = true;
        v8.n(this.f131j == null, "Already started");
        v8.n(!this.f133l, "call was cancelled");
        v8.i(f0Var, "observer");
        boolean zM = this.f.m();
        b4 b4Var = b4.f185a;
        if (zM) {
            this.f131j = b4Var;
            this.f126c.execute(new w(this, f0Var));
            return;
        }
        ze.f fVar2 = this.f130i;
        ze.e eVar = n3.f465g;
        n3 n3Var = (n3) fVar2.a(eVar);
        if (n3Var != null) {
            Long l4 = n3Var.f466a;
            if (l4 != null) {
                ze.z zVarA = ze.z.a(l4.longValue(), TimeUnit.NANOSECONDS, ze.z.f11480d);
                ze.z zVar2 = this.f130i.f11347a;
                if (zVar2 == null || zVarA.compareTo(zVar2) < 0) {
                    ze.f fVar3 = this.f130i;
                    fVar3.getClass();
                    ze.d dVarB = ze.f.b(fVar3);
                    dVarB.f11335a = zVarA;
                    this.f130i = new ze.f(dVarB);
                }
            }
            Boolean bool = n3Var.f467b;
            if (bool != null) {
                if (bool.booleanValue()) {
                    ze.f fVar4 = this.f130i;
                    fVar4.getClass();
                    ze.d dVarB2 = ze.f.b(fVar4);
                    dVarB2.f = Boolean.TRUE;
                    fVar = new ze.f(dVarB2);
                } else {
                    ze.f fVar5 = this.f130i;
                    fVar5.getClass();
                    ze.d dVarB3 = ze.f.b(fVar5);
                    dVarB3.f = Boolean.FALSE;
                    fVar = new ze.f(dVarB3);
                }
                this.f130i = fVar;
            }
            Integer num = n3Var.f468c;
            if (num != null) {
                ze.f fVar6 = this.f130i;
                Integer num2 = fVar6.f11351g;
                if (num2 != null) {
                    this.f130i = fVar6.c(Math.min(num2.intValue(), num.intValue()));
                } else {
                    this.f130i = fVar6.c(num.intValue());
                }
            }
            Integer num3 = n3Var.f469d;
            if (num3 != null) {
                ze.f fVar7 = this.f130i;
                Integer num4 = fVar7.f11352h;
                if (num4 != null) {
                    this.f130i = fVar7.d(Math.min(num4.intValue(), num3.intValue()));
                } else {
                    this.f130i = fVar7.d(num3.intValue());
                }
            }
        }
        String str = this.f130i.f11349c;
        ze.o oVar2 = ze.o.f11387b;
        if (str != null) {
            ze.o oVar3 = (ze.o) this.f137r.f11395a.get(str);
            if (oVar3 == null) {
                this.f131j = b4Var;
                this.f126c.execute(new x(this, f0Var, str));
                return;
            }
            oVar = oVar3;
        } else {
            oVar = oVar2;
        }
        ze.b0 b0Var = this.q;
        p1Var.a(l1.f416i);
        ze.m1 m1Var = l1.e;
        p1Var.a(m1Var);
        if (oVar != oVar2) {
            p1Var.f(m1Var, oVar.a());
        }
        ze.m1 m1Var2 = l1.f;
        p1Var.a(m1Var2);
        byte[] bArr = b0Var.f11326b;
        if (bArr.length != 0) {
            p1Var.f(m1Var2, bArr);
        }
        p1Var.a(l1.f414g);
        p1Var.a(l1.f415h);
        ze.z zVar3 = this.f130i.f11347a;
        ze.z zVarL = this.f.l();
        if (zVar3 == null) {
            zVar = zVarL;
        } else {
            if (zVarL != null) {
                zVar3.b(zVarL);
                if (!zVar3.d(zVarL)) {
                    zVar3 = zVarL;
                }
            }
            zVar = zVar3;
        }
        if (zVar == null || !zVar.e()) {
            ze.z zVarL2 = this.f.l();
            ze.z zVar4 = this.f130i.f11347a;
            Level level = Level.FINE;
            Logger logger = f122s;
            if (logger.isLoggable(level) && zVar != null && zVar.equals(zVarL2)) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jMax = Math.max(0L, zVar.f(timeUnit));
                Locale locale = Locale.US;
                StringBuilder sb2 = new StringBuilder("Call timeout set to '" + jMax + "' ns, due to context deadline.");
                if (zVar4 == null) {
                    sb2.append(" Explicit call timeout was not set.");
                } else {
                    sb2.append(" Explicit call timeout was '" + zVar4.f(timeUnit) + "' ns.");
                }
                logger.fine(sb2.toString());
            }
            k0 k0Var = this.f135n;
            ze.r1 r1Var = this.f124a;
            ze.f fVar8 = this.f130i;
            ze.y yVar = this.f;
            if (((j3) k0Var.f375b).X) {
                n3 n3Var2 = (n3) fVar8.a(eVar);
                x2Var = new x2(k0Var, r1Var, p1Var, fVar8, n3Var2 == null ? null : n3Var2.e, n3Var2 == null ? null : n3Var2.f, yVar);
            } else {
                e0 e0VarA = k0Var.a(new i4(r1Var, p1Var, fVar8));
                ze.y yVarC = yVar.c();
                try {
                    x2Var = e0VarA.f(r1Var, p1Var, fVar8, l1.d(fVar8, p1Var, 0, false));
                    yVar.k(yVarC);
                } catch (Throwable th2) {
                    yVar.k(yVarC);
                    throw th2;
                }
            }
            this.f131j = x2Var;
        } else {
            ze.n[] nVarArrD = l1.d(this.f130i, p1Var, 0, false);
            ze.z zVar5 = this.f130i.f11347a;
            ze.z zVarL3 = this.f.l();
            if (zVar5 == null) {
                zD = false;
            } else if (zVarL3 != null) {
                zD = zVar5.d(zVarL3);
            }
            String str2 = zD ? "CallOptions" : "Context";
            Long l8 = (Long) this.f130i.a(ze.n.f11385a);
            double dF = zVar.f(TimeUnit.NANOSECONDS);
            double d7 = f123t;
            this.f131j = new e1(ze.q2.f11405h.h(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str2, Double.valueOf(dF / d7), Double.valueOf(l8 == null ? 0.0d : l8.longValue() / d7))), nVarArrD);
        }
        if (this.f127d) {
            this.f131j.g();
        }
        this.f130i.getClass();
        Integer num5 = this.f130i.f11351g;
        if (num5 != null) {
            this.f131j.f(num5.intValue());
        }
        Integer num6 = this.f130i.f11352h;
        if (num6 != null) {
            this.f131j.b(num6.intValue());
        }
        if (zVar != null) {
            this.f131j.m(zVar);
        }
        this.f131j.a(oVar);
        this.f131j.d(this.q);
        r rVar = this.e;
        ((s2) rVar.f539b).e();
        ((k2) rVar.f538a).g();
        this.f131j.c(new qf.c(this, f0Var));
        this.f.a(this.f136o, m4.k.INSTANCE);
        if (zVar != null && !zVar.equals(this.f.l()) && this.p != null) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            long jF = zVar.f(timeUnit2);
            this.f128g = this.p.schedule(new r2(new z(this, jF)), jF, timeUnit2);
        }
        if (this.f132k) {
            h();
        }
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f124a, "method");
        return aVarA.toString();
    }
}
