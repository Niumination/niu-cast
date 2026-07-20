package p5;

import android.app.Application;
import android.content.Intent;
import android.os.Process;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.ITCCPListener;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.pad.PadFloatingWindowService;
import com.transsion.connectx.mirror.source.pad.extend.ExtendScreenActivity;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import lm.d1;
import nq.k1;
import nq.l2;
import w4.l1;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    public static long A = 0;
    public static final long B = 500;

    @os.l
    public static final Runnable C;

    @os.l
    public static final Runnable D;

    @os.l
    public static final y5.c.b E;

    @os.l
    public static final nq.s0 F;

    @os.m
    public static l2 G = null;

    @os.l
    public static final d H;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f12862b = "PadSourceManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12863c = 12000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12864d = 240;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final String f12865e = "video_info";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public static IStreamDataListener f12866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public static IStreamDataListener f12867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public static IStreamDataListener f12868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public static IStreamDataListener f12869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public static jn.l<? super Integer, lm.l2> f12870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.m
    public static jn.l<? super Boolean, lm.l2> f12871k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final v4.i f12873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final lm.d0 f12874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.m
    public static String f12875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f12876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.m
    public static n2.w f12877q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.m
    public static n2.w f12878r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.m
    public static Intent f12879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.m
    public static Intent f12880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final lm.d0 f12881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f12882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f12883w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f12884x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f12885y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.m
    public static z4.j f12886z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m0 f12861a = new m0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final ArrayList<byte[]> f12872l = new ArrayList<>();

    public static final class a implements IStreamDataListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12887a;

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            if (this.f12887a == 1) {
                IStreamDataListener iStreamDataListener = m0.f12866f;
                if (iStreamDataListener != null) {
                    iStreamDataListener.onClose();
                }
                m0 m0Var = m0.f12861a;
                m0Var.f0();
                m0Var.e0();
                w4.c0.b.f17991a.a0();
                w4.c0.b.f17991a.h0();
            }
            this.f12887a--;
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            k4.m.e(m0.f12862b, "video onConnect");
            this.f12887a++;
            IStreamDataListener iStreamDataListener = m0.f12866f;
            if (iStreamDataListener != null) {
                iStreamDataListener.onConnect(i10);
            }
            n2.w wVar = m0.f12877q;
            if (wVar != null) {
                try {
                    k4.m.c(m0.f12862b, wVar.a());
                    if (kn.l0.g(wVar.a(), "phone_mirror_pad")) {
                        w4.c0.b.f17991a.h0();
                        w4.c0.b.f17991a.k0();
                    } else if (kn.l0.g(wVar.a(), z4.e.f21818e)) {
                        w4.c0.b.f17991a.a0();
                        w4.c0.b.f17991a.j0();
                    }
                } catch (Exception unused) {
                    w4.c0.b.f17991a.k0();
                }
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@os.l byte[] bArr, int i10, int i11) {
            kn.l0.p(bArr, "data");
            m0.f12861a.L().i();
            if (m0.f12866f == null) {
                m0.f12872l.add(bArr);
            }
            IStreamDataListener iStreamDataListener = m0.f12866f;
            if (iStreamDataListener != null) {
                iStreamDataListener.onReceiveData(bArr, i10, i11);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
            IStreamDataListener iStreamDataListener = m0.f12866f;
            if (iStreamDataListener != null) {
                iStreamDataListener.onStartServer();
            }
        }
    }

    public static final class b implements IStreamDataListener {
        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            IStreamDataListener iStreamDataListener = m0.f12867g;
            if (iStreamDataListener != null) {
                iStreamDataListener.onClose();
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            k4.m.e(m0.f12862b, "audio onConnect");
            IStreamDataListener iStreamDataListener = m0.f12867g;
            if (iStreamDataListener != null) {
                iStreamDataListener.onConnect(i10);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@os.l byte[] bArr, int i10, int i11) {
            kn.l0.p(bArr, "data");
            m0.f12861a.L().i();
            IStreamDataListener iStreamDataListener = m0.f12867g;
            if (iStreamDataListener != null) {
                iStreamDataListener.onReceiveData(bArr, i10, i11);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
            IStreamDataListener iStreamDataListener = m0.f12867g;
            if (iStreamDataListener != null) {
                iStreamDataListener.onStartServer();
            }
        }
    }

    public static final class c implements ITCCPListener {
        @Override // com.transsion.aiotlink.ITCCPListener
        public void onClose() {
            k4.m.e(m0.f12862b, "Tccp on close");
            m0.f12861a.c0();
            w4.c0.b.f17991a.A0();
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onConnect(int i10) {
            u5.a.a();
            u5.a.b();
            k4.m.e(m0.f12862b, "Tccp on connect");
            m0 m0Var = m0.f12861a;
            m0Var.L().h();
            w4.c0.b.f17991a.C0();
            p5.c.f12806a.d(true, m0.H);
            m0Var.J();
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onTccpRequest(short s10, int i10, @os.l String str) {
            kn.l0.p(str, cb.b.c.f1411r);
            m0 m0Var = m0.f12861a;
            m0Var.L().i();
            k4.m.e(m0.f12862b, "onTccpRequest: operator: " + ((int) s10) + "; content:" + str);
            m0Var.D(s10, str);
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onTccpResponse(short s10, int i10, short s11, @os.l String str) {
            kn.l0.p(str, cb.b.c.f1411r);
            k4.m.e(m0.f12862b, "onTccpResponse:" + i10 + ";content:" + str);
        }
    }

    public static final class d implements hi.j {

        @xm.f(c = "com.transsion.connectx.mirror.source.pad.PadSourceManager$mCastEntryClickListener$1$onCastEntryClicked$1", f = "PadSourceManager.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super lm.l2>, Object> {
            int label;

            public a(um.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @os.l
            public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    this.label = 1;
                    if (nq.d1.b(300L, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                if (m0.f12877q != null) {
                    n2.w wVar = m0.f12877q;
                    if (kn.l0.g(wVar != null ? wVar.a() : null, "phone_mirror_pad")) {
                        m0.f12861a.v();
                    }
                } else {
                    m0.f12861a.V();
                    o1.a.f18113a.S("dock_enable_mirror");
                }
                return lm.l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
            }
        }

        @Override // hi.j
        public void a() {
            k4.m.e(hi.l.f7142b, "onCastEntryClicked");
            l2 l2Var = m0.G;
            if (l2Var != null) {
                l2.a.b(l2Var, null, 1, null);
            }
            m0 m0Var = m0.f12861a;
            m0.G = nq.k.f(m0.F, null, null, new a(null), 3, null);
        }
    }

    public static final class e extends kn.n0 implements jn.a<v4.c> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final v4.c invoke() {
            return new v4.c(1000, 20, m0.C, m0.D);
        }
    }

    public static final class f extends kn.n0 implements jn.a<String> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        @Override // jn.a
        public final String invoke() {
            return k4.j.a.f8962a.g(new v4.b(0));
        }
    }

    static {
        v4.i iVar = v4.i.a.f16581a;
        kn.l0.o(iVar, "getInstance(...)");
        f12873m = iVar;
        f12874n = lm.f0.b(e.INSTANCE);
        f12876p = l1.S;
        f12881u = lm.f0.b(f.INSTANCE);
        f12883w = 100;
        f12884x = true;
        A = System.currentTimeMillis();
        C = new i0();
        D = new j0();
        E = new k0();
        F = nq.t0.a(k1.c());
        H = new d();
        f12868h = new a();
        f12869i = new b();
    }

    public static final void K(boolean z10) {
        f12861a.C0(z10);
    }

    public static final void Q() {
        f12873m.f(v4.g.f16570w0, f12861a.M());
    }

    public static final void R(String str) {
        if (str != null) {
            f12861a.T(str);
        }
    }

    public static final void S() {
        f12861a.c0();
        k4.m.e(f12862b, "tccp onClose reason for heartbeat");
    }

    public static final void d0() {
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static /* synthetic */ void i0(m0 m0Var, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        m0Var.h0(i10, obj);
    }

    public static /* synthetic */ void k0(m0 m0Var, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        m0Var.j0(str, i10);
    }

    public static /* synthetic */ void m0(m0 m0Var, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        m0Var.l0(i10, i11);
    }

    public static /* synthetic */ void x0(m0 m0Var, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        m0Var.w0(num);
    }

    public final void A(String str) {
        if (f12884x) {
            k4.m.e(f12862b, "dealClipboardContent");
            n2.d dVar = (n2.d) k4.j.a.f8962a.a(str, n2.d.class);
            if (dVar != null) {
                y5.c.d(SourceApplication.b()).h(dVar.a());
            }
        }
    }

    public final void A0() {
        k4.m.e(f12862b, "toExtendHomeKey");
        ExtendScreenActivity.f2136x.b();
    }

    public final void B(String str) {
        n2.k kVar = (n2.k) k4.j.a.f8962a.a(str, n2.k.class);
        if (kVar == null) {
            k4.m.c(f12862b, "dealMainVideoOrientationChange: info null");
            return;
        }
        jn.l<? super Integer, lm.l2> lVar = f12870j;
        if (lVar != null) {
            lVar.invoke(Integer.valueOf(kVar.a()));
        }
    }

    public final void B0() {
        if (!f12885y) {
            k4.m.e(f12862b, "ClipboardListener is not registered.");
            return;
        }
        y5.c cVarD = y5.c.d(SourceApplication.b());
        cVarD.k(null);
        cVarD.j();
        f12885y = false;
        k4.m.e(f12862b, "ClipboardListener unregistered.");
    }

    public final void C(String str) {
        k4.m.e(f12862b, "dealMirrorPaused:" + str);
        n2.u uVar = (n2.u) k4.j.a.f8962a.a(str, n2.u.class);
        if (uVar == null) {
            k4.m.c(f12862b, "dealMirrorPaused:ill param");
            return;
        }
        if (kn.l0.g(uVar.a(), n2.u.f11317a)) {
            g0.f12817a.p(uVar.c());
        }
        if (kn.l0.g(uVar.a(), n2.u.f11318b)) {
            g0.f12817a.n(uVar.c());
        }
    }

    public final void C0(boolean z10) {
        q0(z10);
        if (z10) {
            k4.m.e(f12862b, "registerClipboardListener");
            Y();
        } else {
            k4.m.e(f12862b, "unregisterClipboardListener");
            B0();
        }
    }

    public final void D(short s10, String str) {
        if (s10 == 1028) {
            y0(str);
            return;
        }
        if (s10 == 512) {
            F(str);
            return;
        }
        if (s10 == 1024) {
            B(str);
            return;
        }
        if (s10 == 2048) {
            z0();
            return;
        }
        if (s10 == 1542) {
            y();
            return;
        }
        if (s10 == 1540) {
            A(str);
            return;
        }
        if (s10 == 1539) {
            C(str);
            return;
        }
        if (s10 == 1544) {
            D0(str);
            return;
        }
        if (s10 == 1555) {
            g0.f12817a.b(str);
            return;
        }
        if (s10 == 1579) {
            U();
            return;
        }
        if (s10 == 1587) {
            A0();
            return;
        }
        if (s10 == 1027) {
            E(str);
        } else if (s10 == 1538) {
            g0.f12817a.l(str);
        } else if (s10 == 1588) {
            G(str);
        }
    }

    public final void D0(String str) {
        n2.m mVar = (n2.m) k4.j.a.f8962a.a(str, n2.m.class);
        if (mVar == null) {
            k4.m.c(f12862b, "updateInputShown:null");
            return;
        }
        jn.l<? super Boolean, lm.l2> lVar = f12871k;
        if (lVar != null) {
            Boolean boolA = mVar.a();
            lVar.invoke(Boolean.valueOf(boolA == null ? false : boolA.booleanValue()));
        }
    }

    public final void E(String str) {
        k4.m.e(f12862b, "dealSceneChange:" + str);
        z4.l lVar = (z4.l) k4.j.a.f8962a.a(str, z4.l.class);
        if (lVar == null) {
            k4.m.c(f12862b, "dealSceneChange:ill param");
        } else {
            g0.f12817a.k(lVar);
        }
    }

    public final void E0(int i10, int i11) {
        k4.m.e(f12862b, "updateMirrorWindowPoint:x=" + i10 + ", y=" + i11);
        f12882v = i10;
        f12883w = i11;
    }

    public final void F(String str) {
        k4.m.e(f12862b, "dealVideoOrAudioPlay:" + str);
        n2.w wVar = (n2.w) k4.j.a.f8962a.a(str, n2.w.class);
        if (wVar == null) {
            k4.m.c(f12862b, "ProtocolManager.PLAY: data is null");
            return;
        }
        if (wVar.e() == 2) {
            f12877q = wVar;
            z(str);
        }
        if (wVar.e() == 1) {
            f12878r = wVar;
            w(str);
        }
    }

    public final void G(String str) {
        k4.m.e(f12862b, "dealWifiScanEnabledStatus: " + str);
        u5.c.f16204a.a(Boolean.parseBoolean(str));
    }

    public final void H() {
        k4.m.e(f12862b, "disableClipboardFeatureListening");
        Application applicationB = SourceApplication.b();
        q0(false);
        B0();
        y5.c.d(applicationB).m(applicationB);
    }

    public final void I() {
        k4.m.e(f12862b, "disconnect");
        v();
        f12873m.f(v4.g.f16568v0, "");
        c0();
    }

    public final void J() {
        y5.c cVarD = y5.c.d(SourceApplication.b());
        cVarD.i(SourceApplication.f1881c);
        cVarD.l(new l0());
    }

    public final v4.c L() {
        return (v4.c) f12874n.getValue();
    }

    public final String M() {
        return (String) f12881u.getValue();
    }

    @os.m
    public final n2.w N() {
        return f12877q;
    }

    public final boolean O() {
        return f12875o != null;
    }

    public final boolean P() {
        String str;
        z4.j jVar = f12886z;
        k4.m.e(f12862b, "isXos: " + (jVar != null ? jVar.f21826a : null));
        z4.j jVar2 = f12886z;
        if (jVar2 == null || (str = jVar2.f21826a) == null) {
            return false;
        }
        return jq.h0.T2(str, "xos", false, 2, null);
    }

    public final void T(String str) {
        k4.m.e(f12862b, "onClipboardContentChangeEvent");
        f12873m.f(v4.g.f16542i0, k4.j.a.f8962a.g(new n2.c(str)));
    }

    public final void U() {
        k4.m.e(f12862b, "open extend screen");
        Application applicationB = SourceApplication.b();
        f12873m.f(v4.g.f16548l0, k4.j.a.f8962a.g(new z4.i(new z4.c(w4.c.j(applicationB), w4.c.c(applicationB), w4.c.h(applicationB), f12864d, 0), z4.e.f21818e)));
    }

    public final void V() {
        k4.m.e(f12862b, "open main screen");
        f12873m.f(v4.g.f16548l0, k4.j.a.f8962a.g(new z4.i(null, "phone_mirror_pad")));
    }

    public final void W() {
        k4.m.e(f12862b, "refreshVideoStream");
        X();
    }

    public final void X() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = A;
        if (jCurrentTimeMillis - j10 > 500 || j10 > jCurrentTimeMillis) {
            A = jCurrentTimeMillis;
            k4.m.e(f12862b, "发送了重渲染请求");
            n2.w wVar = f12877q;
            if (wVar != null) {
                f12873m.f(v4.g.f16539h, k4.j.a.f8962a.g(new n2.b0(wVar.b())));
            }
        }
    }

    public final void Y() {
        if (f12885y) {
            k4.m.e(f12862b, "ClipboardListener is already registered.");
            return;
        }
        y5.c cVarD = y5.c.d(SourceApplication.b());
        cVarD.k(E);
        cVarD.c();
        f12885y = true;
        k4.m.e(f12862b, "ClipboardListener registered.");
    }

    public final void Z(@os.m jn.l<? super Boolean, lm.l2> lVar) {
        k4.m.e(f12862b, "registerInputShowChangeListener");
        f12871k = lVar;
    }

    public final void a0(@os.l jn.l<? super Integer, lm.l2> lVar) {
        kn.l0.p(lVar, "listener");
        k4.m.e(f12862b, "registerVideoOrientationListener");
        f12870j = lVar;
    }

    public final void b0(@os.m IStreamDataListener iStreamDataListener, @os.m IStreamDataListener iStreamDataListener2) {
        k4.m.e(f12862b, "registerMirrorStreamListener");
        f12866f = iStreamDataListener;
        f12867g = iStreamDataListener2;
        for (byte[] bArr : f12872l) {
            IStreamDataListener iStreamDataListener3 = f12866f;
            if (iStreamDataListener3 != null) {
                iStreamDataListener3.onReceiveData(bArr, 0, 0);
            }
        }
        f12872l.clear();
    }

    public final void c0() {
        u5.a.a();
        u5.c.f16204a.a(false);
        f12872l.clear();
        L().f();
        g0();
        p5.c.f12806a.d(false, H);
        f12875o = null;
        k4.p.a.f8971a.c(SourceApplication.b(), g0.f12819c, g0.f12820d, "");
        H();
        i6.a.b.f7724a.d(new h0(), ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }

    public final void e0() {
        k4.m.e(f12862b, "removeMainScreenOrientationListener");
        f12870j = null;
    }

    public final void f0() {
        k4.m.e(f12862b, "removeMirrorStreamListener");
        f12866f = null;
        f12867g = null;
    }

    public final void g0() {
        k4.m.e(f12862b, "resetScreen");
        f0();
        e0();
        u0();
        v0();
        f12877q = null;
    }

    public final void h0(int i10, Object obj) {
        f12873m.f(v4.g.Y, k4.j.a.f8962a.g(new z4.d(obj, i10)));
    }

    public final void j0(@os.l String str, int i10) {
        kn.l0.p(str, "text");
        k4.m.e(f12862b, "sendInputText:" + str);
        byte[] bytes = str.getBytes(jq.f.f8800b);
        kn.l0.o(bytes, "getBytes(...)");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 4);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.put(bytes);
        n2.w wVar = f12877q;
        if (wVar != null) {
            int iB = wVar.b();
            byte[] bArrArray = byteBufferAllocate.array();
            kn.l0.o(bArrArray, "array(...)");
            byte[] bArrA = z4.h.a(bArrArray, (short) iB, (short) 5);
            f12873m.g(bArrA, bArrA.length);
        }
    }

    public final void l0(int i10, int i11) {
        k4.m.e(f12862b, "sendKeyCode:" + i10 + ", metadata:" + i11);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i11);
        n2.w wVar = f12877q;
        if (wVar != null) {
            int iB = wVar.b();
            byte[] bArrArray = byteBufferAllocate.array();
            kn.l0.o(bArrArray, "array(...)");
            byte[] bArrA = z4.h.a(bArrArray, (short) iB, (short) 1);
            f12873m.g(bArrA, bArrA.length);
        }
    }

    public final void n0(@os.l byte[] bArr) {
        kn.l0.p(bArr, "data");
        n2.w wVar = f12877q;
        if (wVar != null) {
            byte[] bArrA = z4.h.a(bArr, (short) wVar.b(), (short) 4);
            f12873m.g(bArrA, bArrA.length);
        }
    }

    public final void o0(int i10) {
        n2.w wVar = f12877q;
        if (wVar != null) {
            f12873m.f(v4.g.f16566u0, k4.j.a.f8962a.g(new n2.e0(wVar.b(), i10)));
        }
    }

    public final void p0(@os.l byte[] bArr) {
        kn.l0.p(bArr, "data");
        n2.w wVar = f12877q;
        if (wVar != null) {
            byte[] bArrA = z4.h.a(bArr, (short) wVar.b(), (short) 1);
            f12873m.g(bArrA, bArrA.length);
        }
    }

    public final void q0(boolean z10) {
        k4.m.e(f12862b, "setClipboardFeatureEnabled: " + z10);
        f12884x = z10;
    }

    public final void r0(@os.l String str) {
        kn.l0.p(str, "peerIp");
        k4.m.e(f12862b, "setPeerIp:" + str);
        f12875o = str;
    }

    public final void s0(String str) {
        k4.m.e(f12862b, "startFloatingWindowService");
        v0();
        Intent intent = new Intent(SourceApplication.b(), (Class<?>) PadFloatingWindowService.class);
        intent.putExtra("video_info", str);
        intent.putExtra(PadFloatingWindowService.f2125w, f12882v);
        intent.putExtra(PadFloatingWindowService.f2126x, f12883w);
        SourceApplication.f1881c.startService(intent);
        f12879s = intent;
    }

    public final void t(@os.l String str) {
        kn.l0.p(str, "funcType");
        k4.m.e(f12862b, "changeScreen");
        if (f12877q == null) {
            k4.m.c(f12862b, "not main screen info");
        }
        n2.w wVar = f12877q;
        if (wVar == null || !kn.l0.g(str, wVar.a())) {
            return;
        }
        f12873m.f(v4.g.f16535f, k4.j.a.f8962a.g(new n2.h0(wVar.b())));
    }

    public final void t0(String str) {
        k4.m.e(f12862b, "startExtendScreen");
        u0();
        Intent intent = new Intent(SourceApplication.b(), (Class<?>) ExtendScreenActivity.class);
        intent.putExtra("video_info", str);
        intent.addFlags(268435456);
        SourceApplication.f1881c.startActivity(intent);
        f12880t = intent;
    }

    public final void u() {
        if (f12878r == null) {
            k4.m.c(f12862b, "not Audio info");
        }
        n2.w wVar = f12878r;
        if (wVar != null) {
            f12873m.f(v4.g.f16535f, k4.j.a.f8962a.g(new n2.h0(wVar.b())));
        }
        f12878r = null;
    }

    public final void u0() {
        k4.m.e(f12862b, "stopFloatingWindowService");
        if (f12879s != null) {
            SourceApplication.b().stopService(f12879s);
            f12879s = null;
        }
    }

    public final void v() {
        k4.m.e(f12862b, "closeMainScreen");
        if (f12877q == null) {
            k4.m.c(f12862b, "not main screen info");
        }
        n2.w wVar = f12877q;
        if (wVar != null) {
            f12873m.f(v4.g.f16535f, k4.j.a.f8962a.g(new n2.h0(wVar.b())));
            m0 m0Var = f12861a;
            m0Var.u0();
            m0Var.v0();
        }
        f12877q = null;
        u();
    }

    public final void v0() {
        k4.m.e(f12862b, "stopPhoneExtendScreen");
        if (f12880t != null) {
            ExtendScreenActivity.f2136x.a();
            f12880t = null;
        }
    }

    public final void w(@os.l String str) {
        kn.l0.p(str, "data");
        n2.w wVar = f12878r;
        if (wVar != null) {
            f12873m.a(f12875o, wVar.b(), f12869i);
        }
    }

    public final void w0(@os.m Integer num) {
        n2.w wVar = f12877q;
        if (wVar != null) {
            Application applicationB = SourceApplication.b();
            z4.c cVar = new z4.c(w4.c.j(applicationB), w4.c.c(applicationB), num != null ? num.intValue() : w4.c.h(applicationB), f12864d, wVar.b());
            k4.m.e(f12862b, "syncPadInfo: " + cVar);
            f12861a.h0(1, cVar);
        }
    }

    public final void x(@os.l String str, int i10) {
        kn.l0.p(str, "peerIp");
        f12875o = str;
        f12876p = i10;
        f12873m.b(str, i10, new c());
    }

    public final void y() {
        String str = f12875o;
        if (str != null) {
            f12873m.c(str, 12000);
        }
    }

    public final void y0(String str) {
        z4.j jVar = (z4.j) k4.j.a.f8962a.a(str, z4.j.class);
        if (jVar == null) {
            k4.m.c(f12862b, "syncPhoneInfo:ill param");
        } else {
            f12886z = jVar;
        }
    }

    public final void z(@os.l String str) {
        kn.l0.p(str, "data");
        String str2 = f12875o;
        if (str2 == null) {
            k4.m.c(f12862b, "connectVideoServer: ip is null");
            return;
        }
        n2.w wVar = f12877q;
        if (wVar == null) {
            k4.m.c(f12862b, "connectVideoServer: mMainScreenInfo is null");
            return;
        }
        if (wVar != null) {
            f12873m.d(str2, wVar.b(), f12868h);
            if (kn.l0.g(wVar.a(), "phone_mirror_pad")) {
                f12861a.s0(str);
            } else if (kn.l0.g(wVar.a(), z4.e.f21818e)) {
                f12861a.t0(str);
            } else {
                f12861a.s0(str);
            }
        }
    }

    public final void z0() {
        k4.m.e(f12862b, "tearDown");
        c0();
    }
}
