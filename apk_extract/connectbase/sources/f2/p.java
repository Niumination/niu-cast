package f2;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import io.netty.util.internal.StringUtil;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements h2.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final a f5802x = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final String f5803y = "AnimPlayer.Decoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g f5804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public z f5805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final r f5806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final r f5807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5810g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5811i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5812n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5813p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final lm.d0 f5815w;

    public static final class a {
        public a() {
        }

        public final boolean a(@os.l r rVar, @os.l String str) {
            l0.p(rVar, "handlerHolder");
            l0.p(str, "name");
            try {
                HandlerThread handlerThread = rVar.f5824a;
                if (handlerThread != null && (handlerThread == null || handlerThread.isAlive())) {
                    return true;
                }
                HandlerThread handlerThread2 = new HandlerThread(str);
                handlerThread2.start();
                rVar.f5825b = new Handler(handlerThread2.getLooper());
                l2 l2Var = l2.f10208a;
                rVar.f5824a = handlerThread2;
                return true;
            } catch (OutOfMemoryError e10) {
                l2.a.f9640a.c(p.f5803y, "createThread OOM", e10);
                return false;
            }
        }

        @os.m
        public final HandlerThread b(@os.m HandlerThread handlerThread) {
            if (handlerThread == null) {
                return null;
            }
            handlerThread.quitSafely();
            return null;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<l2.m> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final l2.m invoke() {
            return new l2.m();
        }
    }

    public p(@os.l g gVar) {
        l0.p(gVar, "player");
        this.f5804a = gVar;
        this.f5806c = new r(null, null);
        this.f5807d = new r(null, null);
        this.f5815w = lm.f0.b(b.INSTANCE);
    }

    public final void A(boolean z10) {
        this.f5813p = z10;
    }

    public final void B(boolean z10) {
        this.f5814v = z10;
    }

    public abstract void C(@os.l g2.c cVar);

    public final void D() {
        this.f5814v = true;
    }

    public final void E(int i10, int i11) {
        f2.a aVar;
        if (i10 <= 0 || i11 <= 0 || (aVar = this.f5804a.f5754r.f5673b) == null) {
            return;
        }
        if (aVar.f5655e == i10 && aVar.f5656f == i11) {
            return;
        }
        l2.a.f9640a.e(f5803y, "videoSizeChange old=(" + aVar.f5655e + StringUtil.COMMA + aVar.f5656f + "), new=(" + i10 + StringUtil.COMMA + i11 + ')');
        aVar.f5655e = i10;
        aVar.f5656f = i11;
        z zVar = this.f5805b;
        if (zVar == null) {
            return;
        }
        zVar.a(aVar);
    }

    @Override // h2.a
    public void a() {
        l2.a.f9640a.e(f5803y, "onVideoComplete");
        h2.a aVar = this.f5804a.f5739c;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    @Override // h2.a
    public void b() {
        l2.a.f9640a.e(f5803y, "onVideoDestroy");
        h2.a aVar = this.f5804a.f5739c;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    @Override // h2.a
    public void c(int i10, @os.m String str) {
        l2.a.f9640a.b(f5803y, "onFailed errorType=" + i10 + ", errorMsg=" + ((Object) str));
        h2.a aVar = this.f5804a.f5739c;
        if (aVar == null) {
            return;
        }
        aVar.c(i10, str);
    }

    @Override // h2.a
    public void d() {
        l2.a.f9640a.e(f5803y, "onVideoStart");
        h2.a aVar = this.f5804a.f5739c;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // h2.a
    public void e(int i10, @os.m f2.a aVar) {
        l2.a.f9640a.a(f5803y, "onVideoRender");
        h2.a aVar2 = this.f5804a.f5739c;
        if (aVar2 == null) {
            return;
        }
        aVar2.e(i10, aVar);
    }

    @Override // h2.a
    public boolean f(@os.l f2.a aVar) {
        return h2.a.C0189a.a(this, aVar);
    }

    public abstract void g();

    public final void h() {
        if (this.f5804a.f5749m) {
            l2.a.f9640a.e(f5803y, "destroyThread");
            Handler handler = this.f5806c.f5825b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f5807d.f5825b;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            r rVar = this.f5806c;
            a aVar = f5802x;
            rVar.f5824a = aVar.b(rVar.f5824a);
            r rVar2 = this.f5807d;
            rVar2.f5824a = aVar.b(rVar2.f5824a);
            this.f5806c.f5825b = null;
            this.f5807d.f5825b = null;
        }
    }

    @os.l
    public final r i() {
        return this.f5807d;
    }

    public final int j() {
        return this.f5810g;
    }

    public final boolean k() {
        return this.f5812n;
    }

    public final int l() {
        return this.f5811i;
    }

    @os.l
    public final g m() {
        return this.f5804a;
    }

    @os.m
    public final z n() {
        return this.f5805b;
    }

    @os.l
    public final r o() {
        return this.f5806c;
    }

    @os.l
    public final l2.m p() {
        return (l2.m) this.f5815w.getValue();
    }

    public final boolean q() {
        return this.f5813p;
    }

    public final boolean r() {
        return this.f5814v;
    }

    public final void s(int i10, int i11) {
        this.f5808e = i10;
        this.f5809f = i11;
        z zVar = this.f5805b;
        if (zVar == null) {
            return;
        }
        zVar.c(i10, i11);
    }

    public final void t(int i10, int i11) {
        z zVar;
        this.f5804a.f5754r.a(i10, i11);
        f2.a aVar = this.f5804a.f5754r.f5673b;
        if (aVar != null && (zVar = this.f5805b) != null) {
            zVar.a(aVar);
        }
        this.f5804a.f5755s.j();
    }

    public final boolean u(boolean z10) {
        if (this.f5805b == null) {
            l2.a aVar = l2.a.f9640a;
            aVar.e(f5803y, "prepareRender");
            SurfaceTexture surfaceTexture = this.f5804a.f5737a.getSurfaceTexture();
            if (surfaceTexture != null) {
                if (z10) {
                    aVar.e(f5803y, "use yuv render");
                    this.f5805b = new e0(surfaceTexture);
                } else {
                    c0 c0Var = new c0(surfaceTexture);
                    c0Var.c(this.f5808e, this.f5809f);
                    l2 l2Var = l2.f10208a;
                    this.f5805b = c0Var;
                }
            }
        }
        return this.f5805b != null;
    }

    public final boolean v() {
        a aVar = f5802x;
        return aVar.a(this.f5806c, "anim_render_thread") && aVar.a(this.f5807d, "anim_decode_thread");
    }

    public final void w(int i10) {
        p().c(i10);
        this.f5810g = i10;
    }

    public final void x(boolean z10) {
        this.f5812n = z10;
    }

    public final void y(int i10) {
        this.f5811i = i10;
    }

    public final void z(@os.m z zVar) {
        this.f5805b = zVar;
    }
}
