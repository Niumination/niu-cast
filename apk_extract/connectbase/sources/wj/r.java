package wj;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class r<ReqT, RespT> extends vj.k<ReqT, RespT> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f19206r = Logger.getLogger(r.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f19207s = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final double f19208t = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.w1<ReqT, RespT> f19209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fm.e f19210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f19211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f19213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vj.w f19214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r<ReqT, RespT>.c f19215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vj.e f19217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f19218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f19221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ScheduledExecutorService f19222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public vj.a0 f19224p = vj.a0.c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public vj.t f19225q = vj.t.a();

    public class a extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vj.k.a f19226b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vj.k.a aVar) {
            super(r.this.f19214f);
            this.f19226b = aVar;
        }

        @Override // wj.a0
        public void a() {
            r rVar = r.this;
            r.j(rVar, this.f19226b, vj.x.b(rVar.f19214f), new vj.v1());
        }
    }

    public class b extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vj.k.a f19228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19229c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vj.k.a aVar, String str) {
            super(r.this.f19214f);
            this.f19228b = aVar;
            this.f19229c = str;
        }

        @Override // wj.a0
        public void a() {
            r.j(r.this, this.f19228b, vj.y2.f17562s.u(String.format("Unable to find compressor by name %s", this.f19229c)), new vj.v1());
        }
    }

    public final class c implements Runnable, vj.w.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f19231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f19232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f19233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile ScheduledFuture<?> f19234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f19235e;

        public c(vj.y yVar, boolean z10) {
            this.f19231a = z10;
            if (yVar == null) {
                this.f19232b = false;
                this.f19233c = 0L;
            } else {
                this.f19232b = true;
                this.f19233c = yVar.q(TimeUnit.NANOSECONDS);
            }
        }

        @Override // vj.w.g
        public void a(vj.w wVar) {
            if (this.f19232b && this.f19231a && (wVar.k() instanceof TimeoutException)) {
                r.this.f19218j.a(c());
            } else {
                r.this.f19218j.a(vj.x.b(wVar));
            }
        }

        public vj.y2 c() {
            long jAbs = Math.abs(this.f19233c);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit.toNanos(1L);
            long jAbs2 = Math.abs(this.f19233c) % timeUnit.toNanos(1L);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f19231a ? "Context" : "CallOptions");
            sb2.append(" deadline exceeded after ");
            if (this.f19233c < 0) {
                sb2.append('-');
            }
            sb2.append(nanos);
            Locale locale = Locale.US;
            sb2.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
            sb2.append("s. ");
            Long l10 = (Long) r.this.f19217i.j(vj.n.f17186a);
            sb2.append(String.format(locale, "Name resolution delay %.9f seconds.", Double.valueOf(l10 == null ? 0.0d : l10.longValue() / r.f19208t)));
            if (r.this.f19218j != null) {
                b1 b1Var = new b1();
                r.this.f19218j.x(b1Var);
                sb2.append(" ");
                sb2.append(b1Var);
            }
            return vj.y2.f17552i.u(sb2.toString());
        }

        public void d() {
            if (this.f19235e) {
                return;
            }
            if (this.f19232b && !this.f19231a && r.this.f19222n != null) {
                this.f19234d = r.this.f19222n.schedule(new k1(this), this.f19233c, TimeUnit.NANOSECONDS);
            }
            r.this.f19214f.b(this, q1.n0.INSTANCE);
            if (this.f19235e) {
                e();
            }
        }

        public void e() {
            this.f19235e = true;
            ScheduledFuture<?> scheduledFuture = this.f19234d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            r.this.f19214f.g0(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f19218j.a(c());
        }
    }

    public class d implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.k.a<RespT> f19237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vj.y2 f19238b;

        public final class a extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19240b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f19241c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(fm.b bVar, vj.v1 v1Var) {
                super(r.this.f19214f);
                this.f19240b = bVar;
                this.f19241c = v1Var;
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ClientCall$Listener.headersRead");
                try {
                    fm.c.a(r.this.f19210b);
                    fm.c.n(this.f19240b);
                    b();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }

            public final void b() {
                d dVar = d.this;
                if (dVar.f19238b != null) {
                    return;
                }
                try {
                    dVar.f19237a.b(this.f19241c);
                } catch (Throwable th2) {
                    d.this.k(vj.y2.f17549f.t(th2).u("Failed to read headers"));
                }
            }
        }

        public final class b extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19243b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k3.a f19244c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(fm.b bVar, k3.a aVar) {
                super(r.this.f19214f);
                this.f19243b = bVar;
                this.f19244c = aVar;
            }

            private void b() {
                if (d.this.f19238b != null) {
                    v0.f(this.f19244c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f19244c.next();
                        if (next == null) {
                            return;
                        }
                        try {
                            d dVar = d.this;
                            dVar.f19237a.c(r.this.f19209a.f17484e.c(next));
                            next.close();
                        } catch (Throwable th2) {
                            v0.e(next);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        v0.f(this.f19244c);
                        d.this.k(vj.y2.f17549f.t(th3).u("Failed to read message."));
                        return;
                    }
                }
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ClientCall$Listener.messagesAvailable");
                try {
                    fm.c.a(r.this.f19210b);
                    fm.c.n(this.f19243b);
                    b();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        public final class c extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19246b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f19247c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f19248d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(fm.b bVar, vj.y2 y2Var, vj.v1 v1Var) {
                super(r.this.f19214f);
                this.f19246b = bVar;
                this.f19247c = y2Var;
                this.f19248d = v1Var;
            }

            private void b() {
                r.this.f19215g.e();
                vj.y2 y2Var = this.f19247c;
                vj.v1 v1Var = this.f19248d;
                vj.y2 y2Var2 = d.this.f19238b;
                if (y2Var2 != null) {
                    v1Var = new vj.v1();
                    y2Var = y2Var2;
                }
                try {
                    d dVar = d.this;
                    r.j(r.this, dVar.f19237a, y2Var, v1Var);
                } finally {
                    r.this.f19213e.b(y2Var.r());
                }
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ClientCall$Listener.onClose");
                try {
                    fm.c.a(r.this.f19210b);
                    fm.c.n(this.f19246b);
                    b();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        /* JADX INFO: renamed from: wj.r$d$d, reason: collision with other inner class name */
        public final class C0478d extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19250b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0478d(fm.b bVar) {
                super(r.this.f19214f);
                this.f19250b = bVar;
            }

            private void b() {
                d dVar = d.this;
                if (dVar.f19238b != null) {
                    return;
                }
                try {
                    dVar.f19237a.d();
                } catch (Throwable th2) {
                    d.this.k(vj.y2.f17549f.t(th2).u("Failed to call onReady."));
                }
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ClientCall$Listener.onReady");
                try {
                    fm.c.a(r.this.f19210b);
                    fm.c.n(this.f19250b);
                    b();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        public d(vj.k.a<RespT> aVar) {
            this.f19237a = (vj.k.a) c1.h0.F(aVar, "observer");
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            fm.f fVarZ = fm.c.z("ClientStreamListener.messagesAvailable");
            try {
                fm.c.a(r.this.f19210b);
                r.this.f19211c.execute(new b(fm.c.f6114a.k(), aVar));
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // wj.t
        public void b(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
            fm.f fVarZ = fm.c.z("ClientStreamListener.closed");
            try {
                fm.c.a(r.this.f19210b);
                j(y2Var, aVar, v1Var);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // wj.k3
        public void d() {
            if (r.this.f19209a.f17480a.clientSendsOneMessage()) {
                return;
            }
            fm.f fVarZ = fm.c.z("ClientStreamListener.onReady");
            try {
                fm.c.a(r.this.f19210b);
                r.this.f19211c.execute(new C0478d(fm.c.f6114a.k()));
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // wj.t
        public void f(vj.v1 v1Var) {
            fm.f fVarZ = fm.c.z("ClientStreamListener.headersRead");
            try {
                fm.c.a(r.this.f19210b);
                r.this.f19211c.execute(new a(fm.c.f6114a.k(), v1Var));
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        public final void j(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
            vj.y yVarX = r.this.x();
            if (y2Var.f17568a == vj.y2.b.CANCELLED && yVarX != null && yVarX.m()) {
                y2Var = r.this.f19215g.c();
                v1Var = new vj.v1();
            }
            r.this.f19211c.execute(new c(fm.c.o(), y2Var, v1Var));
        }

        public final void k(vj.y2 y2Var) {
            this.f19238b = y2Var;
            r.this.f19218j.a(y2Var);
        }
    }

    public interface e {
        s a(vj.w1<?, ?> w1Var, vj.e eVar, vj.v1 v1Var, vj.w wVar);
    }

    public r(vj.w1<ReqT, RespT> w1Var, Executor executor, vj.e eVar, e eVar2, ScheduledExecutorService scheduledExecutorService, o oVar, @gm.j vj.x0 x0Var) {
        this.f19209a = w1Var;
        fm.e eVarI = fm.c.i(w1Var.f17481b, System.identityHashCode(this));
        this.f19210b = eVarI;
        if (executor == q1.n0.INSTANCE) {
            this.f19211c = new s2();
            this.f19212d = true;
        } else {
            this.f19211c = new t2(executor);
            this.f19212d = false;
        }
        this.f19213e = oVar;
        this.f19214f = vj.w.o();
        vj.w1.d dVar = w1Var.f17480a;
        this.f19216h = dVar == vj.w1.d.UNARY || dVar == vj.w1.d.SERVER_STREAMING;
        this.f19217i = eVar;
        this.f19221m = eVar2;
        this.f19222n = scheduledExecutorService;
        fm.c.k("ClientCall.<init>", eVarI);
    }

    @b1.e
    public static void A(vj.v1 v1Var, vj.a0 a0Var, vj.s sVar, boolean z10) {
        v1Var.j(v0.f19363i);
        vj.v1.i<String> iVar = v0.f19359e;
        v1Var.j(iVar);
        if (sVar != vj.p.b.f17223a) {
            v1Var.w(iVar, sVar.a());
        }
        vj.v1.i<byte[]> iVar2 = v0.f19360f;
        v1Var.j(iVar2);
        byte[] bArr = a0Var.f17056b;
        if (bArr.length != 0) {
            v1Var.w(iVar2, bArr);
        }
        v1Var.j(v0.f19361g);
        vj.v1.i<byte[]> iVar3 = v0.f19362h;
        v1Var.j(iVar3);
        if (z10) {
            v1Var.w(iVar3, f19207s);
        }
    }

    public static void j(r rVar, vj.k.a aVar, vj.y2 y2Var, vj.v1 v1Var) {
        rVar.getClass();
        aVar.a(y2Var, v1Var);
    }

    @gm.j
    public static vj.y z(@gm.j vj.y yVar, @gm.j vj.y yVar2) {
        if (yVar == null) {
            return yVar2;
        }
        return yVar2 == null ? yVar : yVar.n(yVar2);
    }

    public final void B(ReqT reqt) {
        c1.h0.h0(this.f19218j != null, "Not started");
        c1.h0.h0(!this.f19219k, "call was cancelled");
        c1.h0.h0(!this.f19220l, "call was half-closed");
        try {
            s sVar = this.f19218j;
            if (sVar instanceof m2) {
                ((m2) sVar).w0(reqt);
            } else {
                sVar.j(this.f19209a.f17483d.a(reqt));
            }
            if (this.f19216h) {
                return;
            }
            this.f19218j.flush();
        } catch (Error e10) {
            this.f19218j.a(vj.y2.f17549f.u("Client sendMessage() failed with Error"));
            throw e10;
        } catch (RuntimeException e11) {
            this.f19218j.a(vj.y2.f17549f.t(e11).u("Failed to stream message"));
        }
    }

    public r<ReqT, RespT> C(vj.t tVar) {
        this.f19225q = tVar;
        return this;
    }

    public r<ReqT, RespT> D(vj.a0 a0Var) {
        this.f19224p = a0Var;
        return this;
    }

    public r<ReqT, RespT> E(boolean z10) {
        this.f19223o = z10;
        return this;
    }

    public final void F(vj.k.a<RespT> aVar, vj.v1 v1Var) {
        vj.s sVarB;
        c1.h0.h0(this.f19218j == null, "Already started");
        c1.h0.h0(!this.f19219k, "call was cancelled");
        c1.h0.F(aVar, "observer");
        c1.h0.F(v1Var, "headers");
        if (this.f19214f.E()) {
            this.f19218j = y1.f19572a;
            this.f19211c.execute(new a(aVar));
            return;
        }
        u();
        String str = this.f19217i.f17090e;
        if (str != null) {
            sVarB = this.f19225q.b(str);
            if (sVarB == null) {
                this.f19218j = y1.f19572a;
                this.f19211c.execute(new b(aVar, str));
                return;
            }
        } else {
            sVarB = vj.p.b.f17223a;
        }
        A(v1Var, this.f19224p, sVarB, this.f19223o);
        vj.y yVarX = x();
        boolean z10 = yVarX != null && yVarX.equals(this.f19214f.A());
        r<ReqT, RespT>.c cVar = new c(yVarX, z10);
        this.f19215g = cVar;
        if (yVarX == null || cVar.f19233c > 0) {
            this.f19218j = this.f19221m.a(this.f19209a, this.f19217i, v1Var, this.f19214f);
        } else {
            vj.n[] nVarArrH = v0.h(this.f19217i, v1Var, 0, false);
            String str2 = z10 ? "Context" : "CallOptions";
            Long l10 = (Long) this.f19217i.j(vj.n.f17186a);
            double d10 = this.f19215g.f19233c;
            double d11 = f19208t;
            this.f19218j = new i0(vj.y2.f17552i.u(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str2, Double.valueOf(d10 / d11), Double.valueOf(l10 == null ? 0.0d : l10.longValue() / d11))), nVarArrH);
        }
        if (this.f19212d) {
            this.f19218j.n();
        }
        String str3 = this.f19217i.f17088c;
        if (str3 != null) {
            this.f19218j.t(str3);
        }
        Integer num = this.f19217i.f17094i;
        if (num != null) {
            this.f19218j.h(num.intValue());
        }
        Integer num2 = this.f19217i.f17095j;
        if (num2 != null) {
            this.f19218j.i(num2.intValue());
        }
        if (yVarX != null) {
            this.f19218j.r(yVarX);
        }
        this.f19218j.f(sVarB);
        boolean z11 = this.f19223o;
        if (z11) {
            this.f19218j.o(z11);
        }
        this.f19218j.m(this.f19224p);
        this.f19213e.c();
        this.f19218j.y(new d(aVar));
        this.f19215g.d();
    }

    @Override // vj.k
    public void a(@gm.j String str, @gm.j Throwable th2) {
        fm.f fVarZ = fm.c.z("ClientCall.cancel");
        try {
            fm.c.a(this.f19210b);
            v(str, th2);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th3) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    @Override // vj.k
    public vj.a b() {
        s sVar = this.f19218j;
        return sVar != null ? sVar.c() : vj.a.f17046c;
    }

    @Override // vj.k
    public void c() {
        fm.f fVarZ = fm.c.z("ClientCall.halfClose");
        try {
            fm.c.a(this.f19210b);
            y();
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // vj.k
    public boolean d() {
        if (this.f19220l) {
            return false;
        }
        return this.f19218j.s();
    }

    @Override // vj.k
    public void e(int i10) {
        fm.f fVarZ = fm.c.z("ClientCall.request");
        try {
            fm.c.a(this.f19210b);
            c1.h0.h0(this.f19218j != null, "Not started");
            c1.h0.e(i10 >= 0, "Number requested must be non-negative");
            this.f19218j.b(i10);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // vj.k
    public void f(ReqT reqt) {
        fm.f fVarZ = fm.c.z("ClientCall.sendMessage");
        try {
            fm.c.a(this.f19210b);
            B(reqt);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // vj.k
    public void g(boolean z10) {
        c1.h0.h0(this.f19218j != null, "Not started");
        this.f19218j.e(z10);
    }

    @Override // vj.k
    public void h(vj.k.a<RespT> aVar, vj.v1 v1Var) {
        fm.f fVarZ = fm.c.z("ClientCall.start");
        try {
            fm.c.a(this.f19210b);
            F(aVar, v1Var);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public String toString() {
        return c1.z.c(this).j("method", this.f19209a).toString();
    }

    public final void u() {
        q1.b bVar = (q1.b) this.f19217i.j(q1.b.f19181g);
        if (bVar == null) {
            return;
        }
        Long l10 = bVar.f19182a;
        if (l10 != null) {
            vj.y yVarA = vj.y.a(l10.longValue(), TimeUnit.NANOSECONDS);
            vj.y yVar = this.f19217i.f17086a;
            if (yVar == null || yVarA.compareTo(yVar) < 0) {
                this.f19217i = this.f19217i.r(yVarA);
            }
        }
        Boolean bool = bVar.f19183b;
        if (bool != null) {
            this.f19217i = bool.booleanValue() ? this.f19217i.z() : this.f19217i.A();
        }
        Integer num = bVar.f19184c;
        if (num != null) {
            vj.e eVar = this.f19217i;
            Integer num2 = eVar.f17094i;
            if (num2 != null) {
                this.f19217i = eVar.u(Math.min(num2.intValue(), bVar.f19184c.intValue()));
            } else {
                this.f19217i = eVar.u(num.intValue());
            }
        }
        Integer num3 = bVar.f19185d;
        if (num3 != null) {
            vj.e eVar2 = this.f19217i;
            Integer num4 = eVar2.f17095j;
            if (num4 != null) {
                this.f19217i = eVar2.v(Math.min(num4.intValue(), bVar.f19185d.intValue()));
            } else {
                this.f19217i = eVar2.v(num3.intValue());
            }
        }
    }

    public final void v(@gm.j String str, @gm.j Throwable th2) {
        if (str == null && th2 == null) {
            th2 = new CancellationException("Cancelled without a message or cause");
            f19206r.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th2);
        }
        if (this.f19219k) {
            return;
        }
        this.f19219k = true;
        try {
            if (this.f19218j != null) {
                vj.y2 y2Var = vj.y2.f17549f;
                vj.y2 y2VarU = str != null ? y2Var.u(str) : y2Var.u("Call cancelled without message");
                if (th2 != null) {
                    y2VarU = y2VarU.t(th2);
                }
                this.f19218j.a(y2VarU);
            }
        } finally {
            r<ReqT, RespT>.c cVar = this.f19215g;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public final void w(vj.k.a<RespT> aVar, vj.y2 y2Var, vj.v1 v1Var) {
        aVar.a(y2Var, v1Var);
    }

    @gm.j
    public final vj.y x() {
        return z(this.f19217i.f17086a, this.f19214f.A());
    }

    public final void y() {
        c1.h0.h0(this.f19218j != null, "Not started");
        c1.h0.h0(!this.f19219k, "call was cancelled");
        c1.h0.h0(!this.f19220l, "call already half-closed");
        this.f19220l = true;
        this.f19218j.v();
    }
}
