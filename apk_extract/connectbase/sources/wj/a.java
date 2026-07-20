package wj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends d implements s, u1.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f18289g = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q3 f18290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0 f18291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vj.v1 f18294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f18295f;

    /* JADX INFO: renamed from: wj.a$a, reason: collision with other inner class name */
    public class C0471a implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.v1 f18296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i3 f18298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f18299d;

        public C0471a(vj.v1 v1Var, i3 i3Var) {
            this.f18296a = (vj.v1) c1.h0.F(v1Var, "headers");
            this.f18298c = (i3) c1.h0.F(i3Var, "statsTraceCtx");
        }

        @Override // wj.t0
        public void close() {
            this.f18297b = true;
            c1.h0.h0(this.f18299d != null, "Lack of request message. GET request is only supported for unary requests");
            a.this.D().b(this.f18296a, this.f18299d);
            this.f18299d = null;
            this.f18296a = null;
        }

        @Override // wj.t0
        public void dispose() {
            this.f18297b = true;
            this.f18299d = null;
            this.f18296a = null;
        }

        @Override // wj.t0
        public t0 e(boolean z10) {
            return this;
        }

        @Override // wj.t0
        public t0 f(vj.s sVar) {
            return this;
        }

        @Override // wj.t0
        public void flush() {
        }

        @Override // wj.t0
        public boolean g() {
            return this.f18297b;
        }

        @Override // wj.t0
        public void h(InputStream inputStream) {
            c1.h0.h0(this.f18299d == null, "writePayload should not be called multiple times");
            try {
                this.f18299d = l1.h.u(inputStream);
                this.f18298c.k(0);
                i3 i3Var = this.f18298c;
                byte[] bArr = this.f18299d;
                i3Var.l(0, bArr.length, bArr.length);
                this.f18298c.m(this.f18299d.length);
                this.f18298c.n(this.f18299d.length);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // wj.t0
        public void i(int i10) {
        }
    }

    public interface b {
        void a(vj.y2 y2Var);

        void b(vj.v1 v1Var, @gm.j byte[] bArr);

        void c(@gm.j r3 r3Var, boolean z10, boolean z11, int i10);
    }

    public static abstract class c extends d.a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final i3 f18301k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f18302l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public t f18303m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f18304n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public vj.a0 f18305o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f18306p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Runnable f18307q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public volatile boolean f18308r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f18309s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f18310t;

        /* JADX INFO: renamed from: wj.a$c$a, reason: collision with other inner class name */
        public class RunnableC0472a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f18311a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t.a f18312b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18313c;

            public RunnableC0472a(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
                this.f18311a = y2Var;
                this.f18312b = aVar;
                this.f18313c = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.G(this.f18311a, this.f18312b, this.f18313c);
            }
        }

        public c(int i10, i3 i3Var, q3 q3Var, vj.e eVar) {
            super(i10, i3Var, q3Var);
            this.f18305o = vj.a0.c();
            this.f18306p = false;
            this.f18301k = (i3) c1.h0.F(i3Var, "statsTraceCtx");
            Integer num = eVar.f17096k;
            if (num != null) {
                B(num.intValue());
            }
        }

        public static void C(c cVar, boolean z10) {
            cVar.f18304n = z10;
        }

        public static void E(c cVar) {
            cVar.f18308r = true;
        }

        public final void G(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
            if (this.f18302l) {
                return;
            }
            this.f18302l = true;
            this.f18301k.q(y2Var);
            if (n() != null) {
                n().h(y2Var.r());
            }
            this.f18303m.b(y2Var, aVar, v1Var);
        }

        public void H(i2 i2Var) throws Throwable {
            c1.h0.F(i2Var, TypedValues.AttributesType.S_FRAME);
            boolean z10 = true;
            try {
                if (this.f18309s) {
                    a.f18289g.log(Level.INFO, "Received data on closed stream");
                    i2Var.close();
                    return;
                } else {
                    try {
                        l(i2Var);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            if (z10) {
                i2Var.close();
            }
            throw th;
        }

        public void I(vj.v1 v1Var) {
            boolean z10 = true;
            c1.h0.h0(!this.f18309s, "Received headers on closed stream");
            this.f18301k.a();
            String str = (String) v1Var.l(v0.f19361g);
            if (!this.f18304n || str == null) {
                z10 = false;
            } else if (str.equalsIgnoreCase("gzip")) {
                z(new w0());
            } else {
                if (!str.equalsIgnoreCase("identity")) {
                    vj.y2 y2VarU = vj.y2.f17562s.u(String.format("Can't find full stream decompressor for %s", str));
                    y2VarU.getClass();
                    c(new vj.a3(y2VarU));
                    return;
                }
                z10 = false;
            }
            String str2 = (String) v1Var.l(v0.f19359e);
            if (str2 != null) {
                vj.z zVarF = this.f18305o.f(str2);
                if (zVarF == null) {
                    vj.y2 y2VarU2 = vj.y2.f17562s.u(String.format("Can't find decompressor for %s", str2));
                    y2VarU2.getClass();
                    c(new vj.a3(y2VarU2));
                    return;
                } else if (zVarF != vj.p.b.f17223a) {
                    if (z10) {
                        vj.y2 y2VarU3 = vj.y2.f17562s.u("Full stream and gRPC message encoding cannot both be set");
                        y2VarU3.getClass();
                        c(new vj.a3(y2VarU3));
                        return;
                    }
                    y(zVarF);
                }
            }
            this.f18303m.f(v1Var);
        }

        public void J(vj.v1 v1Var, vj.y2 y2Var) {
            c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            c1.h0.F(v1Var, "trailers");
            if (this.f18309s) {
                a.f18289g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{y2Var, v1Var});
            } else {
                this.f18301k.b(v1Var);
                R(y2Var, false, v1Var);
            }
        }

        public final boolean K() {
            return this.f18308r;
        }

        public final t L() {
            return this.f18303m;
        }

        public final void M(vj.a0 a0Var) {
            c1.h0.h0(this.f18303m == null, "Already called start");
            this.f18305o = (vj.a0) c1.h0.F(a0Var, "decompressorRegistry");
        }

        public final void N(boolean z10) {
            this.f18304n = z10;
        }

        @b1.e
        public final void O(t tVar) {
            c1.h0.h0(this.f18303m == null, "Already called setListener");
            this.f18303m = (t) c1.h0.F(tVar, "listener");
        }

        public final void P() {
            this.f18308r = true;
        }

        public final void Q(vj.y2 y2Var, t.a aVar, boolean z10, vj.v1 v1Var) {
            c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            c1.h0.F(v1Var, "trailers");
            if (!this.f18309s || z10) {
                this.f18309s = true;
                this.f18310t = y2Var.r();
                u();
                if (this.f18306p) {
                    this.f18307q = null;
                    G(y2Var, aVar, v1Var);
                } else {
                    this.f18307q = new RunnableC0472a(y2Var, aVar, v1Var);
                    k(z10);
                }
            }
        }

        public final void R(vj.y2 y2Var, boolean z10, vj.v1 v1Var) {
            Q(y2Var, t.a.PROCESSED, z10, v1Var);
        }

        @Override // wj.t1.b
        public void e(boolean z10) {
            c1.h0.h0(this.f18309s, "status should have been reported on deframer closed");
            this.f18306p = true;
            if (this.f18310t && z10) {
                R(vj.y2.f17562s.u("Encountered end-of-stream mid-frame"), true, new vj.v1());
            }
            Runnable runnable = this.f18307q;
            if (runnable != null) {
                runnable.run();
                this.f18307q = null;
            }
        }

        @Override // wj.d.a
        public k3 p() {
            return this.f18303m;
        }
    }

    public a(s3 s3Var, i3 i3Var, q3 q3Var, vj.v1 v1Var, vj.e eVar, boolean z10) {
        c1.h0.F(v1Var, "headers");
        this.f18290a = (q3) c1.h0.F(q3Var, "transportTracer");
        this.f18292c = v0.t(eVar);
        this.f18293d = z10;
        if (z10) {
            this.f18291b = new C0471a(v1Var, i3Var);
        } else {
            this.f18291b = new u1(this, s3Var, i3Var);
            this.f18294e = v1Var;
        }
    }

    @Override // wj.d
    public final t0 A() {
        return this.f18291b;
    }

    public abstract b D();

    public q3 F() {
        return this.f18290a;
    }

    public final boolean G() {
        return this.f18292c;
    }

    @Override // wj.d
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public abstract c C();

    @Override // wj.s
    public final void a(vj.y2 y2Var) {
        c1.h0.e(!y2Var.r(), "Should not cancel with OK status");
        this.f18295f = true;
        D().a(y2Var);
    }

    @Override // wj.s
    public void h(int i10) {
        C().A(i10);
    }

    @Override // wj.s
    public void i(int i10) {
        this.f18291b.i(i10);
    }

    @Override // wj.s
    public final void m(vj.a0 a0Var) {
        C().M(a0Var);
    }

    @Override // wj.s
    public final void o(boolean z10) {
        C().f18304n = z10;
    }

    @Override // wj.s
    public void r(vj.y yVar) {
        vj.v1 v1Var = this.f18294e;
        vj.v1.i<Long> iVar = v0.f19358d;
        v1Var.j(iVar);
        this.f18294e.w(iVar, Long.valueOf(Math.max(0L, yVar.q(TimeUnit.NANOSECONDS))));
    }

    @Override // wj.d, wj.j3
    public final boolean s() {
        return super.s() && !this.f18295f;
    }

    @Override // wj.s
    public final void v() {
        if (C().f18308r) {
            return;
        }
        C().f18308r = true;
        z();
    }

    @Override // wj.u1.d
    public final void w(r3 r3Var, boolean z10, boolean z11, int i10) {
        c1.h0.e(r3Var != null || z10, "null frame before EOS");
        D().c(r3Var, z10, z11, i10);
    }

    @Override // wj.s
    public final void x(b1 b1Var) {
        vj.a aVarC = c();
        b1Var.b("remote_addr", aVarC.f17048a.get(vj.n0.f17193a));
    }

    @Override // wj.s
    public final void y(t tVar) {
        C().O(tVar);
        if (this.f18293d) {
            return;
        }
        D().b(this.f18294e, null);
        this.f18294e = null;
    }
}
