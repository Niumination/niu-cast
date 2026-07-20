package wj;

import androidx.core.app.NotificationCompat;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class u2<ReqT, RespT> extends vj.k2<ReqT, RespT> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Logger f19328n = Logger.getLogger(u2.class.getName());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @b1.e
    public static final String f19329o = "Too many responses";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @b1.e
    public static final String f19330p = "Completed without a response";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z2 f19331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.w1<ReqT, RespT> f19332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fm.e f19333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.w.f f19334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f19335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vj.a0 f19336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vj.t f19337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f19338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f19339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public vj.s f19342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19343m;

    @b1.e
    public static final class a<ReqT> implements a3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u2<ReqT, ?> f19344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.k2.a<ReqT> f19345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.w.f f19346c;

        /* JADX INFO: renamed from: wj.u2$a$a, reason: collision with other inner class name */
        public class C0479a implements vj.w.g {
            public C0479a() {
            }

            @Override // vj.w.g
            public void a(vj.w wVar) {
                if (wVar.k() != null) {
                    a.this.f19344a.f19339i = true;
                }
            }
        }

        public a(u2<ReqT, ?> u2Var, vj.k2.a<ReqT> aVar, vj.w.f fVar) {
            this.f19344a = (u2) c1.h0.F(u2Var, NotificationCompat.CATEGORY_CALL);
            this.f19345b = (vj.k2.a) c1.h0.F(aVar, "listener must not be null");
            vj.w.f fVar2 = (vj.w.f) c1.h0.F(fVar, "context");
            this.f19346c = fVar2;
            fVar2.b(new C0479a(), q1.n0.INSTANCE);
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            fm.f fVarZ = fm.c.z("ServerStreamListener.messagesAvailable");
            try {
                fm.c.a(this.f19344a.f19333c);
                i(aVar);
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

        @Override // wj.a3
        public void c() {
            fm.f fVarZ = fm.c.z("ServerStreamListener.halfClosed");
            try {
                fm.c.a(this.f19344a.f19333c);
                if (this.f19344a.f19339i) {
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } else {
                    this.f19345b.c();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
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
            fm.f fVarZ = fm.c.z("ServerStreamListener.onReady");
            try {
                fm.c.a(this.f19344a.f19333c);
                if (this.f19344a.f19339i) {
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } else {
                    this.f19345b.e();
                    if (fVarZ != null) {
                        fm.c.u();
                    }
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

        @Override // wj.a3
        public void e(vj.y2 y2Var) {
            fm.f fVarZ = fm.c.z("ServerStreamListener.closed");
            try {
                fm.c.a(this.f19344a.f19333c);
                h(y2Var);
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

        public final void h(vj.y2 y2Var) {
            vj.a3 a3VarA = null;
            try {
                if (y2Var.r()) {
                    this.f19345b.b();
                } else {
                    this.f19344a.f19339i = true;
                    this.f19345b.a();
                    a3VarA = vj.l1.a(vj.y2.f17549f.u("RPC cancelled"), null, false);
                }
            } finally {
                this.f19346c.U0(null);
            }
        }

        public final void i(k3.a aVar) {
            if (this.f19344a.f19339i) {
                v0.f(aVar);
                return;
            }
            while (true) {
                try {
                    InputStream next = aVar.next();
                    if (next == null) {
                        return;
                    }
                    try {
                        this.f19345b.d(this.f19344a.f19332b.f17483d.c(next));
                        next.close();
                    } catch (Throwable th2) {
                        v0.e(next);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    v0.f(aVar);
                    c1.t0.w(th3);
                    throw new RuntimeException(th3);
                }
            }
        }
    }

    public u2(z2 z2Var, vj.w1<ReqT, RespT> w1Var, vj.v1 v1Var, vj.w.f fVar, vj.a0 a0Var, vj.t tVar, o oVar, fm.e eVar) {
        this.f19331a = z2Var;
        this.f19332b = w1Var;
        this.f19334d = fVar;
        this.f19335e = (byte[]) v1Var.l(v0.f19360f);
        this.f19336f = a0Var;
        this.f19337g = tVar;
        this.f19338h = oVar;
        oVar.c();
        this.f19333c = eVar;
    }

    @Override // vj.k2
    public void a(vj.y2 y2Var, vj.v1 v1Var) {
        fm.f fVarZ = fm.c.z("ServerCall.close");
        try {
            fm.c.a(this.f19333c);
            r(y2Var, v1Var);
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

    @Override // vj.k2
    public vj.a b() {
        return this.f19331a.c();
    }

    @Override // vj.k2
    public String c() {
        return this.f19331a.q();
    }

    @Override // vj.k2
    public vj.w1<ReqT, RespT> d() {
        return this.f19332b;
    }

    @Override // vj.k2
    public vj.h2 e() {
        vj.a aVarC = this.f19331a.c();
        if (aVarC == null) {
            return vj.h2.NONE;
        }
        vj.h2 h2Var = (vj.h2) aVarC.f17048a.get(u0.f19305a);
        return h2Var == null ? vj.h2.NONE : h2Var;
    }

    @Override // vj.k2
    public boolean f() {
        return this.f19339i;
    }

    @Override // vj.k2
    public boolean g() {
        if (this.f19341k) {
            return false;
        }
        return this.f19331a.s();
    }

    @Override // vj.k2
    public void h(int i10) {
        fm.f fVarZ = fm.c.z("ServerCall.request");
        try {
            fm.c.a(this.f19333c);
            this.f19331a.b(i10);
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

    @Override // vj.k2
    public void i(vj.v1 v1Var) {
        fm.f fVarZ = fm.c.z("ServerCall.sendHeaders");
        try {
            fm.c.a(this.f19333c);
            u(v1Var);
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

    @Override // vj.k2
    public void j(RespT respt) {
        fm.f fVarZ = fm.c.z("ServerCall.sendMessage");
        try {
            fm.c.a(this.f19333c);
            v(respt);
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

    @Override // vj.k2
    public void k(String str) {
        c1.h0.h0(!this.f19340j, "sendHeaders has been called");
        vj.s sVarB = this.f19337g.b(str);
        this.f19342l = sVarB;
        c1.h0.u(sVarB != null, "Unable to find compressor by name %s", str);
    }

    @Override // vj.k2
    public void l(boolean z10) {
        this.f19331a.e(z10);
    }

    @Override // vj.k2
    public void m(int i10) {
        this.f19331a.l(i10);
    }

    public final void r(vj.y2 y2Var, vj.v1 v1Var) {
        c1.h0.h0(!this.f19341k, "call already closed");
        try {
            this.f19341k = true;
            if (!y2Var.r() || !this.f19332b.f17480a.serverSendsOneMessage() || this.f19343m) {
                this.f19331a.p(y2Var, v1Var);
                return;
            }
            vj.y2 y2VarU = vj.y2.f17562s.u(f19330p);
            y2VarU.getClass();
            s(new vj.a3(y2VarU));
        } finally {
            this.f19338h.b(y2Var.r());
        }
    }

    public final void s(Throwable th2) {
        f19328n.log(Level.WARNING, "Cancelling the stream because of internal error", th2);
        this.f19331a.a(th2 instanceof vj.a3 ? ((vj.a3) th2).getStatus() : vj.y2.f17562s.t(th2).u("Internal error so cancelling stream."));
        this.f19338h.b(false);
    }

    public a3 t(vj.k2.a<ReqT> aVar) {
        return new a(this, aVar, this.f19334d);
    }

    public final void u(vj.v1 v1Var) {
        byte[] bArr;
        c1.h0.h0(!this.f19340j, "sendHeaders has already been called");
        c1.h0.h0(!this.f19341k, "call is closed");
        v1Var.j(v0.f19363i);
        vj.v1.i<String> iVar = v0.f19359e;
        v1Var.j(iVar);
        if (this.f19342l == null || (bArr = this.f19335e) == null || !v0.r(v0.f19379y.n(new String(bArr, v0.f19357c)), this.f19342l.a())) {
            this.f19342l = vj.p.b.f17223a;
        }
        v1Var.w(iVar, this.f19342l.a());
        this.f19331a.f(this.f19342l);
        vj.v1.i<byte[]> iVar2 = v0.f19360f;
        v1Var.j(iVar2);
        byte[] bArr2 = this.f19336f.f17056b;
        if (bArr2.length != 0) {
            v1Var.w(iVar2, bArr2);
        }
        this.f19340j = true;
        this.f19331a.d(v1Var, !this.f19332b.f17480a.serverSendsOneMessage());
    }

    public final void v(RespT respt) {
        c1.h0.h0(this.f19340j, "sendHeaders has not been called");
        c1.h0.h0(!this.f19341k, "call is closed");
        if (this.f19332b.f17480a.serverSendsOneMessage() && this.f19343m) {
            vj.y2 y2VarU = vj.y2.f17562s.u(f19329o);
            y2VarU.getClass();
            s(new vj.a3(y2VarU));
            return;
        }
        this.f19343m = true;
        try {
            this.f19331a.j(this.f19332b.f17484e.a(respt));
            if (this.f19332b.f17480a.serverSendsOneMessage()) {
                return;
            }
            this.f19331a.flush();
        } catch (Error e10) {
            a(vj.y2.f17549f.u("Server sendMessage() failed with Error"), new vj.v1());
            throw e10;
        } catch (RuntimeException e11) {
            s(e11);
        }
    }
}
