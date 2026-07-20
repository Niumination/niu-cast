package k5;

import androidx.annotation.NonNull;
import com.transsion.streamServer.IServerConnectCallback;
import com.transsion.streamServer.IServerCreateCallback;
import com.transsion.streamServer.IServerDisconnectCallback;
import com.transsion.streamServer.IServerStreamClose;
import com.transsion.streamServer.StreamServer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f9078j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f9079k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f9080l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f9081m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9082n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f9083o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f9084p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f9085q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f9086r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9087s = "ExtendScreenManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i6.a f9092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b0> f9093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f9094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p2.g f9095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9096i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f9097a = new z();
    }

    public static z s() {
        return a.f9097a;
    }

    public static /* synthetic */ void x(int i10, d0 d0Var, IServerStreamClose iServerStreamClose, IServerCreateCallback iServerCreateCallback, IServerConnectCallback iServerConnectCallback) {
        StreamServer.getInstance().createWaitConnect(i10, 1000.0f, d0Var, iServerStreamClose, iServerCreateCallback, iServerConnectCallback);
    }

    public static /* synthetic */ void z(int i10, int i11, b0 b0Var) {
        b0Var.f(new o2.c(i10, i11));
    }

    public final void D(int i10, String str) {
        G(3);
        w4.c0.b.f17991a.n0();
        k4.m.e(f9087s, "[EXTEND] video service release->disconnect:code:" + i10 + ",info:" + str);
    }

    public final /* synthetic */ void E(IServerDisconnectCallback iServerDisconnectCallback) {
        StreamServer.getInstance().disconnect(this.f9091d, iServerDisconnectCallback);
        this.f9091d = -1L;
    }

    public void F() {
        k4.m.e(f9087s, "[EXTEND] notifyOnScreenConnecting");
        this.f9093f.forEach(new p());
    }

    public void G(final int i10) {
        m2.b.a("[EXTEND] notifyOnScreenDestroy:", i10, f9087s);
        this.f9093f.forEach(new Consumer() { // from class: k5.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((b0) obj).d(i10);
            }
        });
    }

    public void H(final int i10, final int i11) {
        k4.m.e(f9087s, "[EXTEND] notifyOnScreenDpiChange:" + i10 + ";height:" + i11);
        this.f9093f.forEach(new Consumer() { // from class: k5.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                z.z(i10, i11, (b0) obj);
            }
        });
    }

    public void I(final int i10) {
        m2.b.a("[EXTEND] notifyOnScreenLoading:", i10, f9087s);
        this.f9093f.forEach(new Consumer() { // from class: k5.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((b0) obj).a(i10);
            }
        });
    }

    public void J() {
        k4.m.e(f9087s, "[EXTEND] notifyOnScreenPause");
        this.f9093f.forEach(new u());
    }

    public final void K(final o2.c cVar) {
        this.f9093f.forEach(new Consumer() { // from class: k5.t
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((b0) obj).f(cVar);
            }
        });
    }

    public void L() {
        k4.m.e(f9087s, "[EXTEND] notifyOnScreenResume");
        this.f9093f.forEach(new v());
    }

    public void M(final int i10) {
        m2.b.a("[EXTEND] notifyOnScreenRotate:", i10, f9087s);
        this.f9093f.forEach(new Consumer() { // from class: k5.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((b0) obj).g(i10);
            }
        });
    }

    public void N() {
        T(1, 0);
    }

    public void O(b0 b0Var) {
        if (b0Var == null || this.f9093f.contains(b0Var)) {
            return;
        }
        this.f9093f.add(b0Var);
        b0Var.g(this.f9095h.getOrientation());
    }

    public void P() {
        k4.m.e(f9087s, "[EXTEND] video disconnect release:" + this.f9091d);
        com.transsion.connectx.mirror.source.a.b.f1897a.d();
        this.f9095h = new p2.g(0, true, w4.c.n().e(), w4.c.n().d());
        this.f9089b = -1;
        this.f9088a = 1;
        if (this.f9091d > 0) {
            final IServerDisconnectCallback iServerDisconnectCallback = new IServerDisconnectCallback() { // from class: k5.r
                @Override // com.transsion.streamServer.IServerDisconnectCallback
                public final void onSuccess(int i10, String str) {
                    this.f9070a.D(i10, str);
                }
            };
            this.f9092e.a(new Runnable() { // from class: k5.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9071a.E(iServerDisconnectCallback);
                }
            });
        }
    }

    public void Q() {
        if (this.f9089b == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] destroyExtendScreen error,not connected");
        } else {
            this.f9095h = new p2.g(0, true);
            v4.g.e().h(this.f9089b);
        }
    }

    public final void R() {
        k4.m.e(f9087s, "[EXTEND] requestResetExtendScreen");
        if (this.f9089b == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] requestResetExtendScreen error,not connected");
        } else {
            v4.g.e().k(new n2.a0(this.f9089b));
        }
    }

    public void S(@NonNull n2.s sVar) {
        if (this.f9088a != 1) {
            k4.m.c(f9087s, "[EXTEND] requestStartExtendScreen error,already connect extend screen");
            return;
        }
        this.f9096i = true;
        this.f9095h = new p2.g(0, true);
        v4.g.e().j(sVar);
    }

    public final void T(int i10, int i11) {
        k4.m.e(f9087s, "[EXTEND] requestToggleExtendScreen :status:" + i10 + ",reason:" + i11);
        if (this.f9089b == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] pauseExtendScreen error,not connected");
        } else {
            v4.g.e().m(new n2.j0(this.f9089b, i10, i11));
        }
    }

    public void U(o2.c cVar) {
        K(cVar);
    }

    public void V() {
        R();
    }

    public void W() {
        T(0, 0);
    }

    public void X(int i10) {
        if (this.f9089b == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] rotateExtendScreen error,not connected");
            return;
        }
        k4.m.e(f9087s, "[EXTEND] The phone screen rotates: " + i10);
        v4.g.e().l(new n2.c0(this.f9089b, i10));
    }

    public final void Y(p2.g gVar) {
        if (gVar.getIsExtendMode()) {
            o1.a.f18113a.r();
        } else {
            o1.a.f18113a.s();
        }
    }

    public void Z(b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        this.f9093f.remove(b0Var);
    }

    public void l(@NonNull p2.f fVar, @NonNull final d0 d0Var) {
        k4.m.b(f9087s, "[EXTEND] connect config: " + fVar);
        int i10 = this.f9088a;
        if (i10 == 3 || i10 == 2) {
            k4.m.c(f9087s, "[EXTEND] already connected");
            return;
        }
        this.f9089b = fVar.getId();
        this.f9088a = 2;
        final int iP = p();
        F();
        this.f9094g.i();
        final IServerStreamClose iServerStreamClose = new IServerStreamClose() { // from class: k5.w
            @Override // com.transsion.streamServer.IServerStreamClose
            public final void closeListener(long j10) {
                this.f9074a.u(j10);
            }
        };
        final IServerCreateCallback iServerCreateCallback = new IServerCreateCallback() { // from class: k5.x
            @Override // com.transsion.streamServer.IServerCreateCallback
            public final void onSuccess() {
                this.f9075a.v(iP);
            }
        };
        final IServerConnectCallback iServerConnectCallback = new IServerConnectCallback() { // from class: k5.y
            @Override // com.transsion.streamServer.IServerConnectCallback
            public final void onSuccess(int i11, long j10, String str) {
                this.f9077a.w(i11, j10, str);
            }
        };
        this.f9092e.a(new Runnable() { // from class: k5.m
            @Override // java.lang.Runnable
            public final void run() {
                z.x(iP, d0Var, iServerStreamClose, iServerCreateCallback, iServerConnectCallback);
            }
        });
    }

    public void m(p2.g gVar) {
        k4.m.e(f9087s, "dealScreenDisplayInfoChange: info:" + gVar);
        if (this.f9095h.getOrientation() != gVar.getOrientation()) {
            M(gVar.getOrientation());
        }
        if (this.f9096i) {
            Y(gVar);
        }
        if (this.f9095h.getIsExtendMode() != gVar.getIsExtendMode()) {
            k4.m.e(f9087s, "mode change:" + gVar.getIsExtendMode());
            if (!this.f9096i) {
                Y(gVar);
            }
        }
        if (this.f9096i) {
            this.f9096i = false;
        }
        if (this.f9095h.getWidth() != gVar.getWidth() || this.f9095h.getHeight() != gVar.getHeight()) {
            k4.m.e(f9087s, "dpi change: width:" + gVar.getWidth() + "; height:" + gVar.getHeight());
            H(gVar.getWidth(), gVar.getHeight());
        }
        this.f9095h = gVar;
    }

    public final void n() {
        if (a.f9097a.q().getOrientation() == 3) {
            a.f9097a.X(1);
            a.f9097a.X(3);
        } else if (a.f9097a.q().getOrientation() == 1) {
            a.f9097a.X(3);
            a.f9097a.X(1);
        }
    }

    public void o(int i10) {
        if (this.f9089b == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] destroyExtendScreen error,not connected");
        } else {
            this.f9095h = new p2.g(0, true);
            G(i10);
        }
    }

    public final synchronized int p() {
        try {
            int i10 = this.f9090c + 1;
            this.f9090c = i10;
            if (i10 >= 27000) {
                this.f9090c = o2.d.f12068a;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f9090c;
    }

    public p2.g q() {
        return this.f9095h;
    }

    public int r() {
        return this.f9088a;
    }

    public void t(@NonNull j.b bVar) {
        int i10 = this.f9089b;
        if (i10 == -1 || this.f9088a != 3) {
            k4.m.c(f9087s, "[EXTEND] inject mouse event error,not connected");
        } else {
            bVar.i(i10);
            this.f9094g.l(bVar);
        }
    }

    public final /* synthetic */ void u(long j10) {
        k4.m.e(f9087s, "[EXTEND] video service Stream close serviceId:" + j10);
        P();
        G(2);
    }

    public final void v(int i10) {
        com.transsion.connectx.mirror.source.a.b.f1897a.g();
        v4.g.e().n(this.f9089b, i10);
        k4.m.e(f9087s, "[EXTEND] video service created  screenId: " + this.f9089b);
    }

    public final void w(int i10, long j10, String str) {
        k4.m.e(f9087s, "[EXTEND] video service connectScreen: serviceId: " + j10 + "  info: " + str + "  code: " + i10);
        if (i10 == 0) {
            this.f9091d = j10;
            this.f9088a = 3;
            n();
            L();
            w4.c0.b.f17991a.u0();
            o1.a.f18113a.M();
            return;
        }
        k4.m.e(f9087s, "[EXTEND] video service connect error  code: " + i10);
        P();
        w4.c0.b.f17991a.n0();
        G(1);
    }

    public z() {
        this.f9088a = 1;
        this.f9089b = -1;
        this.f9090c = o2.d.f12068a;
        this.f9091d = -1L;
        this.f9092e = i6.a.b.f7724a;
        this.f9093f = new ConcurrentLinkedQueue<>();
        this.f9094g = j.c.f9028a;
        this.f9095h = new p2.g(0, true, w4.c.n().e(), w4.c.n().d());
        this.f9096i = false;
    }
}
