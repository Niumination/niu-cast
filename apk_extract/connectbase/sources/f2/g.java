package f2;

import android.os.Handler;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final a f5735t = new a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final String f5736u = "AnimPlayer.AnimPlayer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final y f5737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public h2.a f5739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public p f5740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public m f5741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.m
    public Runnable f5751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public final b f5754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public final k2.a f5755s;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public g(@os.l y yVar) {
        l0.p(yVar, "animView");
        this.f5737a = yVar;
        this.f5738b = true;
        this.f5748l = 1;
        this.f5754r = new b(this);
        this.f5755s = new k2.a(this);
    }

    public static final void X(g gVar, g2.c cVar) {
        h2.a aVar;
        l0.p(gVar, "this$0");
        l0.p(cVar, "$fileContainer");
        int iG = gVar.f5754r.g(cVar, gVar.f5747k, gVar.f5748l, gVar.f5743g);
        if (iG != 0) {
            gVar.f5752p = false;
            p pVar = gVar.f5740d;
            if (pVar != null) {
                pVar.c(iG, o.b(o.f5776a, iG, null, 2, null));
            }
            p pVar2 = gVar.f5740d;
            if (pVar2 == null) {
                return;
            }
            pVar2.a();
            return;
        }
        l2.a aVar2 = l2.a.f9640a;
        aVar2.e(f5736u, l0.C("parse ", gVar.f5754r.f5673b));
        f2.a aVar3 = gVar.f5754r.f5673b;
        if (aVar3 == null || (!aVar3.f5662l && ((aVar = gVar.f5739c) == null || !aVar.f(aVar3)))) {
            aVar2.e(f5736u, "onVideoConfigReady return false");
        } else {
            gVar.t(cVar);
        }
    }

    public static final void Z(g gVar, g2.c cVar, boolean z10) {
        h2.a aVar;
        l0.p(gVar, "this$0");
        l0.p(cVar, "$fileContainer");
        int iG = gVar.f5754r.g(cVar, gVar.f5747k, gVar.f5748l, gVar.f5743g);
        if (iG != 0) {
            gVar.f5752p = false;
            p pVar = gVar.f5740d;
            if (pVar != null) {
                pVar.c(iG, o.b(o.f5776a, iG, null, 2, null));
            }
            p pVar2 = gVar.f5740d;
            if (pVar2 == null) {
                return;
            }
            pVar2.a();
            return;
        }
        l2.a aVar2 = l2.a.f9640a;
        aVar2.e(f5736u, l0.C("parse ", gVar.f5754r.f5673b));
        f2.a aVar3 = gVar.f5754r.f5673b;
        if (aVar3 == null || (!aVar3.f5662l && ((aVar = gVar.f5739c) == null || !aVar.f(aVar3)))) {
            aVar2.e(f5736u, "onVideoConfigReady return false");
        } else {
            gVar.v(cVar, z10);
        }
    }

    public static final void u(g gVar, g2.c cVar) {
        l0.p(gVar, "this$0");
        l0.p(cVar, "$fileContainer");
        gVar.t(cVar);
    }

    public static final void w(g gVar, g2.c cVar, boolean z10) {
        l0.p(gVar, "this$0");
        l0.p(cVar, "$fileContainer");
        gVar.v(cVar, z10);
    }

    public final boolean A() {
        return this.f5752p;
    }

    public final boolean B() {
        return this.f5750n;
    }

    public final void C(int i10, int i11) {
        this.f5750n = true;
        Runnable runnable = this.f5751o;
        if (runnable != null) {
            runnable.run();
        }
        this.f5751o = null;
    }

    public final void D() {
        this.f5750n = false;
        this.f5752p = false;
        p pVar = this.f5740d;
        if (pVar != null) {
            pVar.g();
        }
        m mVar = this.f5741e;
        if (mVar == null) {
            return;
        }
        mVar.b();
    }

    public final void E(int i10, int i11) {
        p pVar = this.f5740d;
        if (pVar == null) {
            return;
        }
        pVar.s(i10, i11);
    }

    public final void F() {
        if (this.f5740d == null) {
            x xVar = new x(this);
            xVar.Q = this.f5738b;
            xVar.f5811i = this.f5744h;
            xVar.w(this.f5742f);
            l2 l2Var = l2.f10208a;
            this.f5740d = xVar;
        }
        if (this.f5741e == null) {
            m mVar = new m(this);
            mVar.f5770g = this.f5744h;
            l2 l2Var2 = l2.f10208a;
            this.f5741e = mVar;
        }
    }

    public final void G(@os.m h2.a aVar) {
        this.f5739c = aVar;
    }

    public final void H(@os.m m mVar) {
        this.f5741e = mVar;
    }

    public final void I(boolean z10) {
        this.f5738b = z10;
    }

    public final void J(@os.m p pVar) {
        this.f5740d = pVar;
    }

    public final void K(int i10) {
        this.f5743g = i10;
    }

    public final void L(boolean z10) {
        this.f5749m = z10;
    }

    public final void M(boolean z10) {
        this.f5747k = z10;
    }

    public final void N(int i10) {
        p pVar = this.f5740d;
        if (pVar != null) {
            pVar.w(i10);
        }
        this.f5742f = i10;
    }

    public final void O(boolean z10) {
        this.f5746j = z10;
    }

    public final void P(boolean z10) {
        this.f5753q = z10;
    }

    public final void Q(int i10) {
        p pVar = this.f5740d;
        if (pVar != null) {
            pVar.f5811i = i10;
        }
        m mVar = this.f5741e;
        if (mVar != null) {
            mVar.f5770g = i10;
        }
        this.f5744h = i10;
    }

    public final void R(@os.m Runnable runnable) {
        this.f5751o = runnable;
    }

    public final void S(boolean z10) {
        this.f5752p = z10;
    }

    public final void T(boolean z10) {
        this.f5745i = z10;
    }

    public final void U(boolean z10) {
        this.f5750n = z10;
    }

    public final void V(int i10) {
        this.f5748l = i10;
    }

    public final void W(@os.l final g2.c cVar) {
        r rVar;
        Handler handler;
        l0.p(cVar, "fileContainer");
        this.f5752p = true;
        F();
        p pVar = this.f5740d;
        if (pVar == null || pVar.v()) {
            p pVar2 = this.f5740d;
            if (pVar2 == null || (rVar = pVar2.f5806c) == null || (handler = rVar.f5825b) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: f2.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.X(this.f5703a, cVar);
                }
            });
            return;
        }
        this.f5752p = false;
        p pVar3 = this.f5740d;
        if (pVar3 != null) {
            pVar3.c(o.f5788m, o.f5796u);
        }
        p pVar4 = this.f5740d;
        if (pVar4 == null) {
            return;
        }
        pVar4.a();
    }

    public final void Y(@os.l final g2.c cVar, final boolean z10) {
        r rVar;
        Handler handler;
        l0.p(cVar, "fileContainer");
        this.f5752p = true;
        F();
        p pVar = this.f5740d;
        if (pVar == null || pVar.v()) {
            p pVar2 = this.f5740d;
            if (pVar2 == null || (rVar = pVar2.f5806c) == null || (handler = rVar.f5825b) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: f2.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.Z(this.f5729a, cVar, z10);
                }
            });
            return;
        }
        this.f5752p = false;
        p pVar3 = this.f5740d;
        if (pVar3 != null) {
            pVar3.c(o.f5788m, o.f5796u);
        }
        p pVar4 = this.f5740d;
        if (pVar4 == null) {
            return;
        }
        pVar4.a();
    }

    public final void a0() {
        p pVar = this.f5740d;
        if (pVar != null) {
            pVar.f5814v = true;
        }
        m mVar = this.f5741e;
        if (mVar == null) {
            return;
        }
        mVar.f5771h = true;
    }

    public final void b0(@os.m i2.b bVar) {
        i2.b bVar2;
        f2.a aVar = this.f5754r.f5673b;
        if (aVar != null) {
            i2.b bVar3 = aVar == null ? null : aVar.f5664n;
            if (bVar3 == null) {
                bVar3 = new i2.b();
            }
            aVar.f5664n = bVar3;
        }
        if (aVar != null && (bVar2 = aVar.f5664n) != null) {
            bVar2.f(bVar == null ? null : bVar.f7676d);
        }
        f2.a aVar2 = this.f5754r.f5673b;
        i2.b bVar4 = aVar2 == null ? null : aVar2.f5664n;
        if (bVar4 != null) {
            bVar4.f7674b = bVar == null ? null : bVar.f7674b;
        }
        i2.b bVar5 = aVar2 == null ? null : aVar2.f5664n;
        if (bVar5 == null) {
            return;
        }
        bVar5.f7673a = bVar != null ? bVar.f7673a : null;
    }

    @os.m
    public final h2.a e() {
        return this.f5739c;
    }

    @os.l
    public final y f() {
        return this.f5737a;
    }

    @os.m
    public final m g() {
        return this.f5741e;
    }

    public final boolean h() {
        return this.f5738b;
    }

    @os.l
    public final b i() {
        return this.f5754r;
    }

    @os.m
    public final p j() {
        return this.f5740d;
    }

    public final int k() {
        return this.f5743g;
    }

    public final boolean l() {
        return this.f5747k;
    }

    public final int m() {
        return this.f5742f;
    }

    public final boolean n() {
        return this.f5746j;
    }

    public final int o() {
        return this.f5744h;
    }

    @os.l
    public final k2.a p() {
        return this.f5755s;
    }

    @os.m
    public final Runnable q() {
        return this.f5751o;
    }

    public final boolean r() {
        return this.f5745i;
    }

    public final int s() {
        return this.f5748l;
    }

    public final void t(final g2.c cVar) {
        m mVar;
        synchronized (g.class) {
            try {
                if (this.f5750n) {
                    this.f5752p = false;
                    p pVar = this.f5740d;
                    if (pVar != null) {
                        pVar.C(cVar);
                    }
                    if (!this.f5753q && (mVar = this.f5741e) != null) {
                        mVar.w(cVar);
                    }
                } else {
                    this.f5751o = new Runnable() { // from class: f2.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.u(this.f5680a, cVar);
                        }
                    };
                    this.f5737a.b();
                }
                l2 l2Var = l2.f10208a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void v(final g2.c cVar, final boolean z10) {
        m mVar;
        synchronized (g.class) {
            try {
                if (this.f5750n) {
                    this.f5752p = false;
                    p pVar = this.f5740d;
                    if (pVar != null) {
                        pVar.f5812n = z10;
                    }
                    if (pVar != null) {
                        pVar.C(cVar);
                    }
                    if (!this.f5753q && (mVar = this.f5741e) != null) {
                        mVar.w(cVar);
                    }
                } else {
                    this.f5751o = new Runnable() { // from class: f2.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.w(this.f5697a, cVar, z10);
                        }
                    };
                    this.f5737a.b();
                }
                l2 l2Var = l2.f10208a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean x() {
        return this.f5749m;
    }

    public final boolean y() {
        return this.f5753q;
    }

    public final boolean z() {
        if (!this.f5752p) {
            p pVar = this.f5740d;
            if (!(pVar == null ? false : pVar.f5813p)) {
                return false;
            }
        }
        return true;
    }
}
