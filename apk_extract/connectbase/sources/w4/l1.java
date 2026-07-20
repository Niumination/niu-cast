package w4;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.connectx.link.source.SourceNativeLinkManager;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.sdk.FileInfoSyncRequest;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class l1 {
    public static final String M = "SourceManager";
    public static final String N = "com.transsion.aclauncher";
    public static final String O = "com.transsion.XOSLauncher.upgrade";
    public static final int P = 13000;
    public static final int Q = 24000;
    public static final int R = 10030;
    public static final int S = 9452;
    public static final int T = 12000;
    public static final int U = 10;
    public static final int V = 1;
    public static final int W = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int Z = 5;
    public final k4.h.c A;
    public final k4.h.g B;
    public final com.transsion.connectx.mirror.source.receiver.a.b C;
    public final k4.h.d D;
    public final k4.h.e E;
    public final k4.h.b F;
    public final z5.a G;
    public boolean H;
    public boolean I;
    public final Runnable J;
    public final i6.a K;
    public z4.k L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j5.l f18034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, z4.k> f18036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, t5.d> f18037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentLinkedQueue<k5.b0> f18038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v4.d f18039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, z4.m> f18040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public t5.a f18041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ContentObserver f18042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContentObserver f18043m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m4.c f18044n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f18045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f18046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f18047q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18048r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f18049s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18050t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f18051u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f18052v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v4.e f18053w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final y5.c.b f18054x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m2.c f18055y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o5.j f18056z;

    public class a implements v4.e {
        public a() {
        }

        @Override // v4.e
        public void a(byte[] bArr, int i10) {
            l1.this.E0(bArr, i10);
        }

        @Override // v4.e
        public void b(byte[] bArr, int i10) {
            l1.this.A0(bArr);
        }

        @Override // v4.e
        public void c(byte[] bArr, int i10) {
            l1.this.z0(bArr, i10);
        }

        @Override // v4.e
        public void d(byte[] bArr, int i10) {
            l1.this.D0(bArr, i10);
        }

        @Override // v4.e
        public void e(byte[] bArr, int i10) {
            l1.this.B0(bArr, i10);
        }

        @Override // v4.e
        public void f(byte[] bArr, int i10) {
            l1.this.C0(bArr, i10);
            l1.this.f18046p = SystemClock.elapsedRealtime();
        }
    }

    public class b extends m2.c {
        public b() {
        }

        @Override // m2.c
        public void b(String str, boolean z10) {
            super.b(str, z10);
            l1.this.I0(str, z10);
        }

        @Override // m2.c
        public void c(p2.o oVar) {
            super.c(oVar);
            l1.this.K0(oVar);
        }

        @Override // m2.c
        public void d() {
            l1.this.L0();
        }

        @Override // m2.c
        public void e(n2.l0 l0Var) {
            super.e(l0Var);
            l1.this.M0(l0Var);
        }

        @Override // m2.c
        public void f(n2.v vVar) {
            super.f(vVar);
            m5.m0.a.f10496a.p(vVar);
        }

        @Override // m2.c
        public void i(int i10, int i11, int i12) {
            super.i(i10, i11, i12);
            l1.this.N0(i10, i11, i12);
        }

        @Override // m2.c
        public void j(int i10, int i11) {
            super.j(i10, i11);
            l1.this.O0(i10, i11);
        }

        @Override // m2.c
        public void k() {
            super.k();
            l1.this.P0();
        }

        @Override // m2.c
        public void l(int i10) {
            super.l(i10);
            l1.this.F0(i10);
        }

        @Override // m2.c
        public void m(String str) {
            super.m(str);
            l1.this.y0(str);
        }

        @Override // m2.c
        public void n(int i10) {
            super.n(i10);
            o1.a.f18113a.C(i10, 1);
            l1.this.M1();
            l1.this.m1(6);
        }
    }

    public class c implements o5.j {
        public c() {
        }

        @Override // o5.j
        public void b(o5.a aVar) {
            l1.this.t1(aVar);
        }
    }

    public class d extends t5.b.C0402b {
        public d(l1 l1Var) {
        }

        @Override // t5.b.C0402b
        public void a() {
            c0.b.f17991a.i0();
        }
    }

    public class e extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18060a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l1 l1Var, Handler handler, Context context) {
            super(handler);
            this.f18060a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            try {
                int i10 = Settings.Global.getInt(this.f18060a.getContentResolver(), "key_exit_second_display");
                k4.m.e(l1.M, "key_exit_second_display changed: " + i10);
                if (i10 == 1) {
                    k4.m.e(l1.M, "syncExtendHomeKey");
                    v4.g.e().x();
                } else if (i10 == 2) {
                    h.f18073a.a0(w4.c.p(SourceApplication.b(), "phone_mirror_pad"));
                    k4.m.e(l1.M, "openMirror");
                }
                Settings.Global.putInt(this.f18060a.getContentResolver(), "key_exit_second_display", 0);
            } catch (Settings.SettingNotFoundException unused) {
                k4.m.e(l1.M, "key_exit_second_display not found");
            }
        }
    }

    public class f extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Handler handler, Context context) {
            super(handler);
            this.f18061a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            l1.this.R1(this.f18061a);
        }
    }

    public class g extends t5.b.C0402b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i6.d f18064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t5.d f18065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f18066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r4.c f18067e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ r4.d f18068f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f18069g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f18070h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f18071i;

        public g(Runnable runnable, i6.d dVar, t5.d dVar2, int i10, r4.c cVar, r4.d dVar3, boolean z10, String str, String str2) {
            this.f18063a = runnable;
            this.f18064b = dVar;
            this.f18065c = dVar2;
            this.f18066d = i10;
            this.f18067e = cVar;
            this.f18068f = dVar3;
            this.f18069g = z10;
            this.f18070h = str;
            this.f18071i = str2;
        }

        public static /* synthetic */ void e() {
            w5.h.h().g();
        }

        @Override // t5.b.C0402b
        public void a() {
            l1.this.K.e().e(this.f18063a);
            VirtualDisplay virtualDisplay = (VirtualDisplay) this.f18064b.result();
            l1 l1Var = l1.this;
            int i10 = 0;
            l1Var.f18032b = false;
            if (virtualDisplay == null) {
                this.f18065c.g();
                l1.this.f18037g.remove(Integer.valueOf(this.f18066d));
                return;
            }
            l1Var.f18036f.put(Integer.valueOf(this.f18066d), new z4.k(virtualDisplay, this.f18067e, this.f18065c, this.f18068f, this.f18069g, this.f18066d));
            l1.this.g0(this.f18065c.m().a());
            if (Objects.equals(this.f18070h, "phone_mirror_pad")) {
                c0.b.f17991a.h0();
                c0.b.f17991a.k0();
                t5.a aVar = l1.this.f18041k;
                if (aVar != null) {
                    aVar.h(false);
                }
            } else if (Objects.equals(this.f18070h, z4.e.f21818e)) {
                c0.b.f17991a.a0();
                c0.b.f17991a.j0();
                if (l1.this.f18041k != null) {
                    a6.q.f124a.b();
                    l1.this.f18041k.h(true);
                }
                l1.this.K.e().b(new m1(), r4.a.O);
            }
            int displayId = virtualDisplay.getDisplay().getDisplayId();
            String strZ = this.f18071i;
            if (this.f18069g) {
                int iW = l1.this.f18034d.w(SourceApplication.b(), 0);
                if (iW != this.f18068f.i()) {
                    l1.this.J0(0, iW);
                }
                l1.this.O1();
                strZ = l1.this.f18034d.z(0);
            } else {
                i10 = displayId;
            }
            if (!TextUtils.isEmpty(strZ)) {
                l1.this.N1(i10, strZ);
            }
            this.f18065c.f();
            o1.a.f18113a.l(this.f18066d, this.f18071i, this.f18069g);
        }

        @Override // t5.b.C0402b
        public void b() {
            l1 l1Var = l1.this;
            l1Var.f18032b = false;
            l1Var.f18049s = false;
            l1Var.f18051u = false;
        }

        @Override // t5.b.C0402b
        public void c() {
            l1 l1Var = l1.this;
            l1Var.f18032b = false;
            l1Var.f18049s = false;
            l1Var.f18051u = false;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l1 f18073a = new l1();
    }

    public static /* synthetic */ void g1(Integer num, z4.k kVar) {
        kVar.d().g();
    }

    public static /* synthetic */ void i1() {
        k4.m.h(M, "Process.killProcess myPid");
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public static void k1() {
        c0.b.f17991a.A0();
    }

    public static l1 s0() {
        return h.f18073a;
    }

    public final void A0(byte[] bArr) {
        String strB = k4.c.b(bArr);
        k4.m.e(M, "handleOnInputMethodEvent:  " + strB);
        Boolean bool = this.f18047q.get(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        if (bool == null || !bool.booleanValue()) {
            k4.m.e(M, "handleOnInputMethodEvent:input method not enabled");
        } else {
            w5.f.a.f18172a.g(strB, null);
        }
    }

    public void A1() {
        Application applicationB = SourceApplication.b();
        this.f18042l = new e(this, new Handler(Looper.getMainLooper()), applicationB);
        applicationB.getContentResolver().registerContentObserver(Settings.Global.getUriFor("key_exit_second_display"), false, this.f18042l);
    }

    public final void B0(byte[] bArr, int i10) {
        List<KeyEvent> listC = w5.h.h().c(bArr, o0(i10));
        if (listC == null || listC.size() != 2) {
            return;
        }
        if (!this.f18031a) {
            w5.f fVar = w5.f.a.f18172a;
            fVar.f(listC.get(0));
            fVar.f(listC.get(1));
            return;
        }
        if (w5.h.a.f18179a.e(listC.get(0))) {
            w5.f.a.f18172a.g(null, listC.get(0));
        }
        if (w5.h.a.f18179a.f(listC.get(0))) {
            w5.f fVar2 = w5.f.a.f18172a;
            fVar2.f(listC.get(0));
            fVar2.f(listC.get(1));
        }
    }

    public void B1(k5.b0 b0Var) {
        if (b0Var == null || this.f18038h.contains(b0Var)) {
            return;
        }
        this.f18038h.add(b0Var);
    }

    public final void C0(byte[] bArr, int i10) {
        MotionEvent motionEventD;
        z4.k kVarO0 = o0(i10);
        if (kVarO0 == null || (motionEventD = w5.h.h().d(bArr, kVarO0)) == null) {
            return;
        }
        w5.f.a.f18172a.f(motionEventD);
    }

    public void C1() {
        Application applicationB = SourceApplication.b();
        this.f18043m = new f(new Handler(Looper.getMainLooper()), applicationB);
        applicationB.getContentResolver().registerContentObserver(Settings.Global.getUriFor("transsion_video_assistant"), false, this.f18043m);
        R1(applicationB);
    }

    public final void D0(byte[] bArr, int i10) {
        int iH = k4.c.h(Arrays.copyOfRange(bArr, 0, 4));
        String strB = k4.c.b(Arrays.copyOfRange(bArr, 4, bArr.length));
        k4.m.e(M, "handleOnPadInputText deleteCount: " + iH + " inputResult:  " + strB);
        Boolean bool = this.f18047q.get(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        if (bool == null || !bool.booleanValue()) {
            k4.m.e(M, "handleOnPadInputText:input method not enabled");
            return;
        }
        if (iH > 0) {
            w5.f.a.f18172a.g(String.valueOf(iH), w5.h.h().i(67, 0, o0(i10)).get(0));
        }
        w5.f.a.f18172a.g(strB, null);
    }

    public void D1() {
        k4.m.c(M, "release");
        this.f18049s = false;
        this.f18051u = false;
        this.H = false;
        u5.c.f16204a.a(false);
        this.f18039i.stopTCCPServer();
        this.f18034d.S();
        this.f18036f.forEach(new t0());
        this.f18036f.clear();
        this.f18037g.forEach(new u0());
        this.f18037g.clear();
        this.f18040j.clear();
        y4.b.a.f20705a.e();
        w5.f.a.f18172a.j();
        t5.a aVar = this.f18041k;
        if (aVar != null) {
            aVar.g();
            this.f18041k = null;
        }
        this.f18033c = 3;
        m5.s.a.f10535a.l();
        k4.u.a.f8983a.e();
        o1.a.f18113a.q();
        o1.a.f18113a.T();
        k5.z.a.f9097a.P();
        k5.j.c.f9028a.j();
        j0();
        this.f18032b = false;
        T1();
        a5.a.f47a.getClass();
        a5.a.f52f = null;
        this.K.d(new v0(), ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }

    public final void E0(byte[] bArr, int i10) {
        MotionEvent motionEventA = w5.h.h().a(bArr, o0(i10));
        if (motionEventA == null) {
            return;
        }
        w5.f.a.f18172a.f(motionEventA);
    }

    public final void E1(int i10, int i11) {
        k4.m.e(M, "reparentContentToExistingDisplayAndCast:from:" + i10 + ",toDisplay:" + i11);
        this.f18044n.k(i10, i11, true);
    }

    public void F0(int i10) {
        t5.a aVar = this.f18041k;
        if (aVar != null && aVar.a() == i10) {
            this.f18041k.g();
            this.f18041k = null;
            c0.b.f17991a.Z();
            return;
        }
        z4.k kVar = this.f18036f.get(Integer.valueOf(i10));
        if (kVar == null) {
            return;
        }
        if (kVar.h()) {
            this.f18049s = false;
        }
        kVar.d().g();
        this.f18036f.remove(Integer.valueOf(i10));
        this.f18037g.remove(Integer.valueOf(i10));
        this.f18040j.remove(Integer.valueOf(i10));
        o1.a.f18113a.E(i10);
        if (kVar.h()) {
            this.f18034d.o();
            w5.f.a.f18172a.k(0);
        } else {
            this.f18051u = false;
            this.f18034d.n(kVar.a());
            w5.f.a.f18172a.k(kVar.a());
        }
        if (this.f18036f.isEmpty()) {
            c0.b.f17991a.a0();
            c0.b.f17991a.h0();
        }
    }

    public final void F1(int i10) {
        m2.b.a("reparentContentToMainScreenAndCast:from:", i10, M);
        if (i10 == 0) {
            k4.m.c(M, "can not reparent from main to main");
            return;
        }
        this.f18044n.k(i10, 0, true);
        if (t0() == null) {
            a0(w4.c.p(SourceApplication.b(), "phone_mirror_pad"));
        }
    }

    public void G0(z4.c cVar) {
        if (this.f18041k == null && this.f18036f.isEmpty()) {
            k4.m.e(M, "audio sender start because main display has been created");
            W(w4.c.q());
        }
        r4.d dVarP = w4.c.p(SourceApplication.b(), z4.e.f21818e);
        dVarP.t(cVar.l());
        dVarP.p(cVar.i());
        dVarP.s(cVar.j());
        dVarP.m(cVar.h());
        k4.m.e(M, "videoConfig: " + dVarP);
        V(dVarP);
    }

    public final void G1(final int i10) {
        m2.b.a("reparentContentToNewDisplayAndCast:from:", i10, M);
        if (this.f18032b) {
            k4.m.c(M, "reparentContentToNewDisplayAndCast is casting");
            return;
        }
        if (this.f18036f.size() >= this.f18045o) {
            k4.m.c(M, "reparentContentToNewDisplayAndCast ,now display count reached max");
            return;
        }
        r4.d dVarM = w4.c.m(SourceApplication.b());
        String strZ = this.f18034d.z(i10);
        k4.m.e(M, "reparentContentToNewDisplayAndCast:" + strZ);
        if (TextUtils.isEmpty(strZ)) {
            k4.m.e(M, "reparentContentToNewDisplayAndCast:display packageName is null");
            return;
        }
        if (!e5.b.a.f4068a.g(strZ)) {
            k4.m.c(M, "reparentContentToNewDisplayAndCast:disable reparent:" + strZ);
            return;
        }
        if (f5.b.a.f5846a.f(strZ)) {
            k4.m.e(M, "reparentContentToNewDisplayAndCast,usb broad width cast:" + strZ);
            dVarM = w4.c.r(SourceApplication.f1881c);
        }
        final r4.d dVar = dVarM;
        final r4.h hVar = new r4.h(dVar);
        this.f18032b = true;
        X(3, strZ, hVar, new i6.d() { // from class: w4.y0
            @Override // i6.d
            public final Object result() {
                return this.f18142a.j1(i10, dVar, hVar);
            }
        }, dVar, false, this.f18052v);
    }

    public void H0(String str) {
        o1.a.f18113a.m(v5.d.f16654b);
        if (this.f18041k == null && this.f18036f.isEmpty()) {
            k4.m.e(M, "audio sender start because main display has been created");
            W(w4.c.q());
        }
        a0(w4.c.p(SourceApplication.b(), str));
    }

    public void H1(@NonNull FileInfoSyncRequest fileInfoSyncRequest) {
        if (this.f18033c != 1) {
            k4.m.c(M, "notifyDragEventToPeer,cast server not start");
        } else {
            m5.m0.a.f10496a.z(fileInfoSyncRequest);
        }
    }

    public void I0(String str, boolean z10) {
        try {
            if (z10) {
                k4.m.b(M, "open notification in main screen");
                o5.g.a.f12095a.t(Integer.parseInt(str));
                a0(w4.c.p(SourceApplication.b(), "phone_mirror_pad"));
            } else {
                k4.m.b(M, "open notification in virtual display");
                b0(w4.c.m(SourceApplication.b()), Integer.parseInt(str));
            }
        } catch (Exception e10) {
            k4.m.d(M, e10);
        }
    }

    public void I1(boolean z10) {
        k4.m.e(M, "setClipboardHandlingEnabled: " + z10);
        this.f18050t = z10;
    }

    public final void J0(int i10, int i11) {
        z4.k kVarN0 = n0(i10);
        if (kVarN0 == null) {
            k4.m.c(M, "onDisplayOrientationChanged: no display link found with displayId:" + i10);
        } else {
            boolean zW0 = W0(kVarN0.b(), i11);
            kVarN0.i(i11);
            v4.g.e().K(kVarN0.c(), i11, zW0);
            o1.a.f18113a.O(i11);
        }
    }

    public synchronized int J1() {
        int i10 = this.f18033c;
        if (i10 != 1 && i10 != 2) {
            this.f18033c = 2;
            u5.a.a();
            u5.a.b();
            this.f18039i.h(S, this.J);
            return S;
        }
        k4.m.c(M, "startCastSourceServer:cast already running," + this.f18033c);
        return -1;
    }

    public void K0(p2.o oVar) {
        if (this.f18033c != 1) {
            k4.m.e(M, "handlePeerConfirmReceiveFile,cast not running");
        } else if (oVar.b() == 0) {
            m5.s.a.f10535a.m(oVar.d(), oVar.e(), oVar.f(), oVar.c(), oVar.a());
        } else {
            k4.m.e(M, "handlePeerConfirmReceiveFile:denied");
        }
    }

    public void K1() {
        if (v0() != 1) {
            k4.m.c(M, "stopAllCastAudio failed,cast not running");
            return;
        }
        t5.a aVar = this.f18041k;
        if (aVar != null) {
            aVar.g();
            v4.g.e().q(this.f18041k.a());
            this.f18041k = null;
            c0.b.f17991a.Z();
        }
    }

    public void L0() {
        if (this.f18033c != 1) {
            k4.m.e(M, "handleOnResponseCancelFileServers,cast not running");
        } else {
            m5.s.a.f10535a.b();
        }
    }

    public void L1() {
        if (v0() != 1) {
            k4.m.c(M, "stopAllCastVideo failed,cast not running");
            return;
        }
        for (z4.k kVar : this.f18036f.values()) {
            if (kVar.h()) {
                this.f18049s = false;
            }
            h0(kVar.a(), true);
            this.f18051u = false;
        }
    }

    public void M0(n2.l0 l0Var) {
        if (this.f18033c != 1) {
            k4.m.e(M, "handleRequestFile,cast not running");
            return;
        }
        String strD = l0Var.d();
        k4.m.e(M, "handlePeerRequestReceiveFile,targetPackageName=" + strD);
        if (TextUtils.isEmpty(strD)) {
            k4.m.e(M, "handlePeerRequestReceiveFile: can not get target window package,receive by source-service");
        } else {
            m5.m0.a.f10496a.o(l0Var, strD);
        }
    }

    public synchronized void M1() {
        D1();
        i6.a.b.f7724a.b(new w0());
        u5.a.a();
    }

    public void N0(int i10, int i11, int i12) {
        z4.k kVarO0 = o0(i11);
        if (kVarO0 == null) {
            k4.m.c(M, "handleReparent:from display not found in cast list");
            return;
        }
        if (this.f18044n.d()) {
            k4.m.c(M, "now is multiWindow status is not allow reparent");
            return;
        }
        int iA = kVarO0.a();
        if (kVarO0.h()) {
            iA = 0;
        }
        if (i10 == 1) {
            F1(iA);
            return;
        }
        if (i10 == 3) {
            G1(iA);
            return;
        }
        if (i10 == 2) {
            z4.k kVarO1 = o0(i12);
            if (kVarO1 == null) {
                k4.m.c(M, "reparent to sub failed,no port:" + i12);
            } else {
                if (!kVarO1.h()) {
                    E1(iA, kVarO1.a());
                    return;
                }
                k4.m.c(M, "reparent to sub failed,port is main:" + i12);
            }
        }
    }

    public final void N1(int i10, @os.l String str) {
        z4.k kVarN0 = n0(i10);
        if (kVarN0 == null) {
            k4.m.c(M, "onDisplayResumedActivityChanged: no display link found with displayId:" + i10);
            return;
        }
        ComponentName componentNameB = k4.a.b(SourceApplication.b());
        String className = (componentNameB == null || TextUtils.isEmpty(componentNameB.getClassName())) ? "" : componentNameB.getClassName();
        String strB = k4.n.c(SourceApplication.f1881c).b(str);
        Drawable drawableA = k4.n.c(SourceApplication.f1881c).a(str);
        f0(str, className);
        boolean z10 = e5.b.a.f4068a.g(str) && !this.f18044n.d();
        int iQ0 = q0(str);
        z4.m mVar = this.f18040j.get(Integer.valueOf(kVarN0.c()));
        if (mVar == null || !mVar.a(kVarN0.c(), str, strB, z10, iQ0)) {
            if (mVar == null) {
                mVar = new z4.m(kVarN0.c(), str, strB, z10, iQ0);
            } else {
                mVar.b(kVarN0.c(), str, strB, z10, iQ0);
            }
            this.f18040j.put(Integer.valueOf(kVarN0.c()), mVar);
            v4.g.e().w(kVarN0.c(), str, strB, Base64.getEncoder().encodeToString(k4.l.d(drawableA, 20)), z10, iQ0);
        }
    }

    public void O0(int i10, int i11) {
        z4.k kVarO0 = o0(i10);
        if (kVarO0 == null) {
            k4.m.c(M, "handleRequestFpsChange producer is null:" + i10);
        } else {
            if (i11 >= 5 && i11 <= 60) {
                kVarO0.f().d(i11);
                return;
            }
            k4.m.c(M, "handleRequestFpsChange fps range from 5-90:" + i11);
        }
    }

    public final void O1() {
        if (!a6.m.b() || a6.m.a()) {
            s1(true);
        } else {
            s1(false);
        }
        if (this.f18048r) {
            v1(0, true);
        } else {
            v1(0, false);
        }
    }

    public void P0() {
        Pair<Long, Long> pairB = a6.o.b(SourceApplication.b());
        v4.g.e().M(((Long) pairB.first).longValue(), ((Long) pairB.second).longValue());
    }

    public void P1(int i10) {
        z4.k kVarO0 = o0(i10);
        v4.g.e().K(kVarO0.c(), kVarO0.b(), true);
    }

    public void Q0(int i10) {
        z4.k kVarO0 = o0(i10);
        if (kVarO0 != null) {
            k4.m.b(M, "handleRetryEncoder");
            kVarO0.f().a();
        } else {
            k4.m.c(M, "handleRetryEncoder producer is null:" + i10);
        }
    }

    public final void Q1() {
        v4.g.e().E(k4.j.a.f8962a.g(new z4.j(a6.j.f71a.b())));
    }

    public final void R0() {
        if (this.H) {
            return;
        }
        this.H = true;
        o5.g.a.f12095a.u(this.f18056z);
        this.f18039i.l(this.f18055y);
        this.f18039i.k(this.f18053w);
        k4.h.a.f8959a.j(this.A);
        k4.h.a.f8959a.k(this.D);
        k4.h.a.f8959a.n(this.B);
        k4.h.a.f8959a.l(this.E);
        com.transsion.connectx.mirror.source.receiver.a.C0076a.f2172a.f(this.C);
        k4.h.a.f8959a.i(this.F);
        z5.b.f(SourceApplication.b()).h(this.G);
        l0();
    }

    public final void R1(Context context) {
        int i10;
        try {
            i10 = Settings.Global.getInt(context.getContentResolver(), "transsion_video_assistant");
        } catch (Settings.SettingNotFoundException unused) {
            k4.m.e(M, "key_exit_second_display not found");
            i10 = 0;
        }
        k4.m.e(M, "transsion_video_assistant changed: " + i10);
        v4.g.e().H(k4.j.a.f8962a.g(new z4.l(0, i10)));
        o1.a.f18113a.X(i10);
    }

    public void S(z4.c cVar) {
        if (cVar == null) {
            k4.m.e(M, "extendMirrorInfo is null");
            return;
        }
        z4.k kVar = this.f18036f.get(Integer.valueOf(cVar.k()));
        if (T0() && this.f18036f.isEmpty()) {
            k5.z.a.f9097a.o(4);
            return;
        }
        if (kVar == null) {
            k4.m.e(M, "OnVideoResolutionChanged:there's no ProducerWrapper instance match the given display id");
            return;
        }
        try {
            Size sizeU0 = u0(cVar.l(), cVar.i(), cVar.j());
            k4.m.e(M, "OnVideoResolutionChanged: with:" + sizeU0.getWidth() + ", height:" + sizeU0.getHeight() + ", getOrientation:" + cVar.j() + ", port: " + kVar.c());
            r4.c cVarF = kVar.f();
            cVarF.g(sizeU0.getWidth(), sizeU0.getHeight());
            VirtualDisplay virtualDisplayG = kVar.g();
            if (virtualDisplayG == null) {
                k4.m.e(M, "OnVideoResolutionChanged: virtualDisplay is null");
                return;
            }
            virtualDisplayG.setSurface(null);
            virtualDisplayG.setSurface(cVarF.c());
            virtualDisplayG.resize(sizeU0.getWidth(), sizeU0.getHeight(), cVar.h());
        } catch (Exception e10) {
            k4.m.b(M, "virtualDisplay exception" + e10);
        }
    }

    public boolean S0() {
        boolean z10 = this.f18033c == 1 && !this.f18036f.isEmpty();
        k4.m.b(M, "isCastRunning:" + z10);
        return z10;
    }

    public void S1() {
        if (this.f18033c != 1) {
            return;
        }
        t5.a aVar = this.f18041k;
        if (aVar == null) {
            W(w4.c.q());
            return;
        }
        aVar.g();
        v4.g.e().q(this.f18041k.a());
        this.f18041k = null;
        c0.b.f17991a.Z();
    }

    public void T(final r4.d dVar, final String str) {
        StringBuilder sbA = e.a.a("castActivity:", str, ",config:");
        sbA.append(dVar.toString());
        k4.m.e(M, sbA.toString());
        if (e0(str)) {
            k4.m.c(M, "castActivity:ERROR_CAST_APP_NOT_INSTALL");
            return;
        }
        if (this.f18034d.m(str) != -1) {
            k4.m.c(M, "castActivity:ERROR_CAST_APP_OPENED");
        } else if (this.f18036f.size() >= this.f18045o) {
            k4.m.c(M, "castDisplay ,now display count reached max");
        } else {
            final r4.h hVar = new r4.h(dVar);
            X(q0(str), str, hVar, new i6.d() { // from class: w4.e1
                @Override // i6.d
                public final Object result() {
                    return this.f17996a.X0(dVar, str, hVar);
                }
            }, dVar, false, this.f18052v);
        }
    }

    public boolean T0() {
        boolean z10 = this.f18033c == 1 && k5.z.a.f9097a.r() == 3;
        k4.m.b(M, "isExtendScreenRunning:" + z10);
        return z10;
    }

    public final void T1() {
        Application applicationB = SourceApplication.b();
        applicationB.getContentResolver().unregisterContentObserver(this.f18043m);
        applicationB.getContentResolver().unregisterContentObserver(this.f18042l);
    }

    public void U(final r4.d dVar, final Intent intent) {
        k4.m.e(M, "open app Implicit");
        if (TextUtils.isEmpty(intent.getPackage())) {
            k4.m.c(M, "castActivityByImplicitStart:package is empty");
            return;
        }
        if (e0(intent.getPackage())) {
            k4.m.c(M, "castActivityByImplicitStart:ERROR_CAST_APP_NOT_INSTALL");
        } else if (this.f18036f.size() >= this.f18045o) {
            k4.m.c(M, "castDisplay ,now display count reached max");
        } else {
            final r4.h hVar = new r4.h(dVar);
            X(3, intent.getPackage(), hVar, new i6.d() { // from class: w4.o0
                @Override // i6.d
                public final Object result() {
                    return this.f18083a.Y0(dVar, intent, hVar);
                }
            }, dVar, false, this.f18052v);
        }
    }

    public final boolean U0(int i10) {
        if (i10 == 0) {
            return true;
        }
        for (Integer num : this.f18036f.keySet()) {
            num.intValue();
            if (this.f18036f.get(num) != null && this.f18036f.get(num).h()) {
                return true;
            }
        }
        return false;
    }

    public void U1() {
        if (!this.I) {
            k4.m.e(M, "ClipboardListener is not registered");
            return;
        }
        h.f18073a.I1(false);
        y5.c.d(SourceApplication.b()).k(null);
        this.I = false;
        k4.m.e(M, "ClipboardListener unregistered.");
    }

    public void V(final r4.d dVar) {
        ComponentName componentNameB = k4.a.b(SourceApplication.b());
        if (componentNameB == null) {
            k4.m.c(M, "castActivityInExtend fail: topActivity is null");
            return;
        }
        final String strD = a6.q.f124a.d(componentNameB.getPackageName());
        StringBuilder sbA = e.a.a("castActivityInExtend:", strD, ",config:");
        sbA.append(dVar.toString());
        k4.m.e(M, sbA.toString());
        if (e0(strD)) {
            k4.m.c(M, "castActivityInExtend:ERROR_CAST_APP_NOT_INSTALL");
            return;
        }
        if (SourceApplication.f1881c.getPackageManager().getLaunchIntentForPackage(strD) == null || !e5.b.a.f4068a.f(strD)) {
            Y(dVar);
            return;
        }
        this.f18051u = true;
        if (this.f18034d.m(strD) != -1) {
            k4.m.c(M, "castActivityInExtend:ERROR_CAST_APP_OPENED");
        } else {
            if (this.f18036f.size() >= this.f18045o) {
                k4.m.c(M, "castActivityInExtend ,now display count reached max");
                return;
            }
            final r4.h hVar = new r4.h(dVar);
            this.f18052v = z4.e.f21818e;
            X(q0(strD), strD, hVar, new i6.d() { // from class: w4.f1
                @Override // i6.d
                public final Object result() {
                    return this.f18001a.Z0(dVar, strD, hVar);
                }
            }, dVar, false, this.f18052v);
        }
    }

    public boolean V0(long j10) {
        return SystemClock.elapsedRealtime() - this.f18046p <= j10;
    }

    public void V1(k5.b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        this.f18038h.remove(b0Var);
    }

    public synchronized void W(q4.a aVar) {
        try {
            Application applicationB = SourceApplication.b();
            if (this.f18041k != null) {
                k4.m.e(M, "castAudio audio started, stop audio first");
                return;
            }
            try {
                t5.a aVar2 = new t5.a(new q4.d(aVar, applicationB), this.f18039i);
                this.f18041k = aVar2;
                aVar2.i(R);
                this.f18041k.e(new d());
            } catch (Exception e10) {
                k4.m.d(M, e10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean W0(int i10, int i11) {
        if (i10 == i11) {
            return false;
        }
        return ((i10 == 1 || i10 == 3) && (i11 == 1 || i11 == 3)) ? false : true;
    }

    public final void W1(int i10, @os.l String str) {
        t5.a aVar;
        a6.q qVar = a6.q.f124a;
        if (qVar.a(i10, str) && (aVar = this.f18041k) != null) {
            qVar.getClass();
            aVar.j(a6.q.f127d);
        }
        if (i10 != 0) {
            boolean zA = a6.g.f65a.a(str);
            k4.m.e(M, "setWifiScanningEnabled: " + zA + ", packageName: " + str);
            u5.c.f16204a.a(zA);
            v4.g.e().p(zA);
        }
    }

    public final void X(int i10, String str, r4.c cVar, i6.d<VirtualDisplay> dVar, r4.d dVar2, final boolean z10, String str2) {
        if (this.f18037g.size() >= 10) {
            k4.m.b(M, "not cast display,because encoder instances reached to max number");
            cVar.stop();
            this.f18032b = false;
            this.f18049s = false;
            this.f18051u = false;
            return;
        }
        final int iP0 = p0();
        final t5.d dVar3 = new t5.d(cVar, this.f18039i);
        this.f18037g.put(Integer.valueOf(iP0), dVar3);
        Runnable runnable = new Runnable() { // from class: w4.z0
            @Override // java.lang.Runnable
            public final void run() {
                this.f18147a.a1(dVar3, iP0, z10);
            }
        };
        this.K.e().b(runnable, 10000L);
        dVar3.f15490f = new g(runnable, dVar, dVar3, iP0, cVar, dVar2, z10, str2, str);
        dVar3.n(i10, str, iP0, dVar2.i(), z5.b.f(SourceApplication.b()).e(), z10, str2);
    }

    public final /* synthetic */ VirtualDisplay X0(r4.d dVar, String str, r4.h hVar) {
        return this.f18034d.V(SourceApplication.b(), dVar, str, hVar.c(), Boolean.FALSE);
    }

    public final void X1(boolean z10) {
        I1(z10);
        if (z10) {
            k4.m.e(M, "registerClipboardListener");
            z1();
        } else {
            k4.m.e(M, "unregisterClipboardListener");
            U1();
        }
    }

    public synchronized void Y(final r4.d dVar) {
        ComponentName componentNameB;
        if (this.f18051u) {
            k4.m.e(M, "castExtendScreen:extend screen already cast");
            return;
        }
        this.f18051u = true;
        k4.u.a.f8983a.d(-1L);
        final r4.h hVar = new r4.h(dVar);
        String strX = this.f18034d.x();
        if (TextUtils.isEmpty(strX) && (componentNameB = k4.a.b(SourceApplication.b())) != null) {
            strX = componentNameB.getPackageName();
        }
        this.f18052v = z4.e.f21818e;
        X(1, strX, hVar, new i6.d() { // from class: w4.a1
            @Override // i6.d
            public final Object result() {
                return this.f17949a.b1(dVar, hVar);
            }
        }, dVar, false, this.f18052v);
    }

    public final /* synthetic */ VirtualDisplay Y0(r4.d dVar, Intent intent, r4.h hVar) {
        return this.f18034d.B(SourceApplication.b(), dVar, intent, hVar.c());
    }

    public void Z() {
        v4.g.e().b();
    }

    public final /* synthetic */ VirtualDisplay Z0(r4.d dVar, String str, r4.h hVar) {
        return this.f18034d.V(SourceApplication.b(), dVar, str, hVar.c(), Boolean.TRUE);
    }

    public synchronized void a0(final r4.d dVar) {
        ComponentName componentNameB;
        if (this.f18049s) {
            k4.m.e(M, "castMainScreen:main screen already cast");
            return;
        }
        this.f18049s = true;
        k4.u.a.f8983a.d(-1L);
        final r4.h hVar = new r4.h(dVar);
        String strX = this.f18034d.x();
        if (TextUtils.isEmpty(strX) && (componentNameB = k4.a.b(SourceApplication.b())) != null) {
            strX = componentNameB.getPackageName();
        }
        this.f18052v = "phone_mirror_pad";
        X(1, strX, hVar, new i6.d() { // from class: w4.c1
            @Override // i6.d
            public final Object result() {
                return this.f17992a.c1(dVar, hVar);
            }
        }, dVar, true, this.f18052v);
    }

    public final /* synthetic */ void a1(t5.d dVar, int i10, boolean z10) {
        dVar.g();
        this.f18037g.remove(Integer.valueOf(i10));
        this.f18032b = false;
        if (z10) {
            this.f18049s = false;
        }
        this.f18051u = false;
    }

    public void b0(final r4.d dVar, final int i10) {
        k4.m.e(M, "open notification id:" + i10);
        final o5.a aVarK = o5.g.a.f12095a.k(i10);
        if (aVarK == null || TextUtils.isEmpty(aVarK.k())) {
            k4.m.c(M, "castNotificationActivity:notification not found " + i10);
        } else if (this.f18036f.size() >= this.f18045o) {
            k4.m.c(M, "castDisplay ,now display count reached max");
        } else {
            final r4.h hVar = new r4.h(dVar);
            X(3, aVarK.k(), hVar, new i6.d() { // from class: w4.b1
                @Override // i6.d
                public final Object result() {
                    return this.f17961a.d1(dVar, i10, hVar, aVarK);
                }
            }, dVar, false, this.f18052v);
        }
    }

    public final /* synthetic */ VirtualDisplay b1(r4.d dVar, r4.c cVar) {
        return this.f18034d.N(SourceApplication.b(), dVar, cVar.c());
    }

    public final int c0(int i10, @os.l String str) {
        int iV = this.f18034d.v(str);
        if (iV == 0 || iV == -1 || str.equals(this.f18034d.z(i10))) {
            return -1;
        }
        return iV;
    }

    public final /* synthetic */ VirtualDisplay c1(r4.d dVar, r4.c cVar) {
        return this.f18034d.O(SourceApplication.b(), dVar, cVar.c());
    }

    public void d0() {
        int i10 = this.f18033c;
        if (i10 == 1 || i10 == 2 || p5.m0.f12861a.O()) {
            return;
        }
        u5.a.a();
    }

    public final /* synthetic */ VirtualDisplay d1(r4.d dVar, int i10, r4.h hVar, o5.a aVar) {
        return this.f18034d.W(SourceApplication.b(), dVar, i10, hVar.c(), aVar.k());
    }

    public final boolean e0(String str) {
        try {
            SourceApplication.b().getPackageManager().getPackageInfo(str, 8192);
            return false;
        } catch (PackageManager.NameNotFoundException e10) {
            k4.m.d(M, e10);
            return true;
        }
    }

    public final void e1() {
        k4.m.c(M, "mOnTccpConnected");
        this.f18033c = 1;
        x1();
        y1();
        R0();
        Q1();
        y4.b.a.f20705a.c();
        w5.f.a.f18172a.d();
        w0();
        o1.a.f18113a.B(v5.d.f16653a);
        c0.b.f17991a.C0();
        i5.d.a.f7720a.f();
        v4.g.e().F(this.f18045o);
        this.f18034d.R();
        A1();
        C1();
    }

    public final void f0(String str, String str2) {
        j5.l.b bVarU = this.f18034d.u(str);
        if (bVarU == null) {
            return;
        }
        boolean zF = h5.e.a.f6975a.f(str, str2);
        k4.m.e(M, "secure:" + zF + ",vd se:" + bVarU.o());
        if (zF != bVarU.o()) {
            bVarU.s(zF);
            int displayId = bVarU.m() ? 0 : bVarU.l().getDisplay().getDisplayId();
            k4.m.e(M, "secure flag changed by secure list check:" + displayId);
            k4.h.a.f8959a.g(displayId, zF);
            return;
        }
        k4.m.b(M, "secure flag not changed " + str + ks.g.f9491d + str2 + ks.g.f9491d + zF);
    }

    public final void g0(String str) {
        k4.m.e(M, "funcType: " + str);
        for (z4.k kVar : this.f18036f.values()) {
            k4.m.e(M, "pw.getDisplayId: " + kVar.a() + ", getFuncType: " + kVar.d().m().a());
            if (str.equals("phone_mirror_pad")) {
                this.f18051u = false;
                if (z4.e.f21818e.equals(kVar.d().m().a())) {
                    h0(kVar.a(), false);
                }
            } else if (str.equals(z4.e.f21818e)) {
                this.f18049s = false;
                if (!z4.e.f21818e.equals(kVar.d().m().a())) {
                    h0(kVar.a(), false);
                }
            }
        }
        for (z4.k kVar2 : this.f18036f.values()) {
            k4.m.e(M, "finally pw.getDisplayId: " + kVar2.a() + ", getFuncType: " + kVar2.d().m().a());
        }
    }

    public final void h0(int i10, boolean z10) {
        this.f18034d.T(i10);
        z4.k kVarN0 = n0(i10);
        if (kVarN0 == null) {
            k4.m.e(M, "closeWindByDisplayId:" + i10 + ",isEmpty");
            return;
        }
        k4.m.c(M, "remove displayId: " + i10);
        k4.m.b(M, "clear exists display and close pc window");
        v4.g.e().q(kVarN0.c());
        kVarN0.d().g();
        this.f18036f.remove(Integer.valueOf(kVarN0.c()));
        this.f18037g.remove(Integer.valueOf(kVarN0.c()));
        w5.f.a.f18172a.k(i10);
        o1.a.f18113a.E(kVarN0.c());
        if (this.f18036f.isEmpty() && z10) {
            k4.m.e(M, "closeWindowByDisplayId:all video closed");
            c0.b.f17991a.a0();
            c0.b.f17991a.h0();
        }
    }

    public final void i0(int i10, int i11) {
        k4.m.b(M, "debug: onOrientationChanged: " + i11 + "  displayId: " + i10);
        if (this.f18034d.y() == null) {
            return;
        }
        VirtualDisplay virtualDisplayL = this.f18034d.y().l();
        z4.k kVar = this.L;
        r4.d dVarE = kVar.e();
        r4.c cVarF = kVar.f();
        boolean zW0 = W0(i11, dVarE.i());
        virtualDisplayL.setSurface(null);
        virtualDisplayL.setSurface(cVarF.c());
        virtualDisplayL.resize(!zW0 ? dVarE.j() : dVarE.f(), !zW0 ? dVarE.f() : dVarE.j(), dVarE.c());
    }

    public final void j0() {
        Application applicationB = SourceApplication.b();
        U1();
        y5.c.d(applicationB).m(applicationB);
    }

    public final /* synthetic */ VirtualDisplay j1(int i10, r4.d dVar, r4.h hVar) {
        return this.f18034d.U(SourceApplication.b(), i10, dVar, true, hVar.c());
    }

    public void k0(int i10, int i11) {
        if (o0(i11).h()) {
            a6.n.a(i10);
        } else {
            k4.m.e(M, "dispatchShortcutKeyEvent is not main");
        }
    }

    public final void l0() {
        y5.c cVarD = y5.c.d(SourceApplication.b());
        cVarD.i(SourceApplication.f1881c);
        cVarD.l(new y5.c.InterfaceC0538c() { // from class: w4.d1
            @Override // y5.c.InterfaceC0538c
            public final void a(boolean z10) {
                this.f17995a.X1(z10);
            }
        });
    }

    public final void l1(int i10) {
        k4.m.b(M, "sync nav mode change, new nav mode " + i10);
        v4.g.e().A(i10);
    }

    public synchronized void m0(List<String> list, boolean z10) {
        if (this.f18033c == 1) {
            k4.m.e(M, "enableFeatures:cast is already running");
            return;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.f18047q.get(str) != null) {
                    this.f18047q.put(str, Boolean.valueOf(z10));
                }
            }
        }
    }

    public void m1(final int i10) {
        m2.b.a("notifyOnScreenDestroy:", i10, M);
        this.f18038h.forEach(new Consumer() { // from class: w4.x0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((k5.b0) obj).d(i10);
            }
        });
    }

    public final z4.k n0(int i10) {
        for (Integer num : this.f18036f.keySet()) {
            num.intValue();
            z4.k kVar = this.f18036f.get(num);
            if (kVar != null && ((i10 == 0 && kVar.h()) || kVar.a() == i10)) {
                return kVar;
            }
        }
        return null;
    }

    public void n1(String str) {
        if (this.f18033c != 1) {
            k4.m.e(M, "on clipboard content changed,server not ready");
            return;
        }
        k4.m.b(M, "on clipboard content changed:" + str);
        v4.g.e().v(str);
    }

    public final z4.k o0(int i10) {
        return this.f18036f.get(Integer.valueOf(i10));
    }

    public final void o1(int i10, int i11) {
        if (this.f18033c != 1) {
            k4.m.e(M, "display child count changed,server not ready");
            d0();
            return;
        }
        k4.m.e(M, "onDisplayChildCountChanged, displayId:" + i10 + ", count:" + i11);
        if (i11 != 0) {
            return;
        }
        h0(i10, true);
    }

    public final synchronized int p0() {
        try {
            int i10 = this.f18035e + 1;
            this.f18035e = i10;
            if (i10 >= 24000) {
                this.f18035e = P;
            }
            if (this.f18036f.containsKey(Integer.valueOf(this.f18035e))) {
                return p0();
            }
            return this.f18035e;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void p1(int i10, int i11) {
        if (this.f18033c == 1) {
            J0(i10, i11);
        } else {
            k4.m.e(M, "onDisplayOrientationChanged cast not running");
            d0();
        }
    }

    public final int q0(String str) {
        if (O.equals(str)) {
            return 1;
        }
        if (N.equals(str)) {
            return 2;
        }
        return g5.b.a.f6412a.c(str) ? 4 : 3;
    }

    public final void q1(int i10, @os.l String str) {
        k4.m.c(M, "onDisplayResumedActivityChanged displayId" + i10 + ", packageName" + str);
        W1(i10, str);
        if (!this.f18049s || i10 != 0) {
            N1(i10, str);
            return;
        }
        ComponentName componentNameB = k4.a.b(SourceApplication.b());
        String className = (componentNameB == null || TextUtils.isEmpty(componentNameB.getClassName())) ? "" : componentNameB.getClassName();
        k4.m.b(M, "activity changed, current package name is " + str + ",display:" + i10 + ",activity:" + className);
        if (this.f18033c != 1) {
            k4.m.e(M, "onDisplayResumedActivityChanged cast not running");
            this.f18034d.Q(i10, str, className);
            d0();
        } else {
            if (this.f18034d.A(i10) == null) {
                k4.m.b(M, "This display does not belong to Source service management, display id:" + i10);
                return;
            }
            int iC0 = c0(i10, str);
            m2.b.a("onDisplayResumedActivityChanged: checkResult:", iC0, M);
            if (iC0 != -1) {
                h0(iC0, true);
            }
            if (e5.b.a.f4068a.d(str) != null) {
                F1(i10);
                i10 = 0;
            }
            this.f18034d.Q(i10, str, className);
            N1(i10, str);
        }
    }

    public String r0(n2.v vVar) {
        if (this.f18033c != 1) {
            k4.m.b(M, "getFileTransferHandleAppByRequest:Cast not running");
            return null;
        }
        if (vVar.d() == -1) {
            k4.m.b(M, "getFileTransferHandleAppByRequest:no target window,receive by source-service");
            return "";
        }
        String strA = a6.f.a();
        if (vVar.d() == 0) {
            k4.m.b(M, "getFileTransferHandleAppByRequest:target video port is 0");
            return strA;
        }
        z4.k kVarO0 = o0(vVar.d());
        if (kVarO0 == null) {
            k4.m.b(M, "getFileTransferHandleAppByRequest:producer is null");
            return strA;
        }
        int iA = kVarO0.a();
        if (kVarO0.h()) {
            iA = 0;
        }
        return this.f18034d.z(iA);
    }

    public final void r1(Boolean bool) {
        if (this.f18033c != 1) {
            k4.m.e(M, "Input method status changed,server not ready");
            d0();
            return;
        }
        this.f18031a = bool.booleanValue();
        k4.m.b(M, "on Input method status changed:" + bool);
        v4.g.e().y(bool.booleanValue());
    }

    public final void s1(boolean z10) {
        if (!S0()) {
            k4.m.e(M, "onLockWindowVisibleChanged cast not running");
            return;
        }
        for (Integer num : this.f18036f.keySet()) {
            num.intValue();
            z4.k kVar = this.f18036f.get(num);
            if (kVar != null) {
                kVar.f().j(z10);
            }
        }
        k4.m.e(M, "onLockWindowVisibleChanged isLock is " + z10);
        v4.g.e().u(n2.u.f11318b, -1, z10);
        if (z10) {
            o1.a.f18113a.P();
        }
    }

    @Nullable
    public final z4.k t0() {
        for (Integer num : this.f18036f.keySet()) {
            num.intValue();
            z4.k kVar = this.f18036f.get(num);
            if (kVar != null && kVar.h()) {
                return kVar;
            }
        }
        return null;
    }

    public final void t1(o5.a aVar) {
        if (this.f18033c != 1) {
            k4.m.e(M, "onReceiveNotification,cast not running");
            return;
        }
        k4.m.b(M, "sync notification to peer:" + aVar);
        v4.g.e().B(aVar.g(), aVar.r(), aVar.f(), aVar.o(), aVar.h(), aVar.m().longValue());
    }

    public final Size u0(int i10, int i11, int i12) {
        boolean z10 = i12 == 2;
        boolean z11 = i10 > i11;
        return (!(z10 && z11) && (z10 || z11)) ? new Size(i11, i10) : new Size(i10, i11);
    }

    public void u1() {
        z4.k kVarT0 = t0();
        if (T0() && this.f18036f.isEmpty()) {
            k5.z.a.f9097a.o(4);
            return;
        }
        if (kVarT0 == null) {
            k4.m.e(M, "OnVideoResolutionChanged:there's no ProducerWrapper instance match the given display id");
            return;
        }
        Application applicationB = SourceApplication.b();
        int iJ = w4.c.j(applicationB);
        int iC = w4.c.c(applicationB);
        int iH = w4.c.h(applicationB);
        m2.b.a("provideLauncherDisplayConfig :orientation:", iH, M);
        if (iH == 2) {
            iJ = w4.c.c(applicationB);
            iC = w4.c.j(applicationB);
        }
        StringBuilder sbA = i0.a.a("OnVideoResolutionChanged:with:", iJ, ",height:", iC, "port: ");
        sbA.append(kVarT0.c());
        k4.m.e(M, sbA.toString());
        r4.c cVarF = kVarT0.f();
        cVarF.g(iJ, iC);
        VirtualDisplay virtualDisplayG = kVarT0.g();
        if (virtualDisplayG == null) {
            k4.m.e(M, "OnVideoResolutionChanged: virtualDisplay is null");
            return;
        }
        virtualDisplayG.setSurface(null);
        virtualDisplayG.setSurface(cVarF.c());
        virtualDisplayG.resize(iJ, iC, w4.c.b(applicationB));
        v4.g.e().O(iJ, iC, kVarT0.c());
    }

    public int v0() {
        k4.m.b(M, "current cast state:" + this.f18033c);
        return this.f18033c;
    }

    public final void v1(int i10, boolean z10) {
        if (U0(i10)) {
            this.f18048r = z10;
        }
        if (this.f18033c != 1) {
            k4.m.e(M, "onSecureWindowVisibleChanged cast not running");
            d0();
            return;
        }
        z4.k kVarN0 = n0(i10);
        if (kVarN0 != null) {
            v4.g.e().u(n2.u.f11317a, kVarN0.c(), z10);
            kVarN0.f().j(z10);
        } else {
            k4.m.c(M, "onSecureWindowVisibleChanged: no display link found with displayId:" + i10);
        }
    }

    public final void w0() {
        String strA = a6.r.a();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        v4.g.e().P(strA);
    }

    public void w1() {
        if (this.f18033c != 1) {
            k4.m.c(M, "openExtendScreen error,tccp not connected");
            return;
        }
        if (!this.f18036f.isEmpty()) {
            L1();
            K1();
            k4.m.c(M, "Stop all cast request Start ExtendScreen");
        }
        k5.z.a.f9097a.S(w4.c.n());
    }

    public void x0(int i10, Object obj) {
        k4.m.e(M, "handExtendMirrorMsg:code:" + i10 + ",data:" + obj);
        if (i10 == 1) {
            z4.c cVar = (z4.c) k4.j.a.f8962a.a(obj.toString(), z4.c.class);
            if (cVar == null) {
                k4.m.e(M, "extendMirrorInfo is null");
                return;
            }
            k4.m.e(M, "extendMirrorInfo " + cVar);
            S(cVar);
        }
    }

    public void x1() {
        m5.s.a.f10535a.n();
    }

    public final void y0(String str) {
        if (this.f18033c != 1 || !this.f18050t) {
            k4.m.e(M, "clipboard content change, server not ready");
            return;
        }
        k4.m.e(M, "clipboard content change, content:" + str);
        y5.c.d(SourceApplication.b()).h(str);
    }

    public void y1() {
        Boolean bool = this.f18047q.get(TCCPSourceApi.KEY_FEATURE_UIBC);
        if (bool == null || !bool.booleanValue()) {
            k4.m.e(M, "openUibcChannel:uibc not enabled");
        } else {
            this.f18039i.j(12000, this.f18053w);
        }
    }

    public final void z0(byte[] bArr, int i10) {
        x5.a aVarB = w5.h.h().b(bArr, o0(i10));
        if (aVarB != null) {
            w5.f.a.f18172a.e(aVarB);
        }
    }

    public void z1() {
        if (this.I) {
            k4.m.e(M, "ClipboardListener is already registered.");
            return;
        }
        y5.c.d(SourceApplication.b()).k(this.f18054x);
        this.I = true;
        k4.m.e(M, "ClipboardListener registered.");
    }

    public l1() {
        this.f18032b = false;
        this.f18033c = 3;
        this.f18034d = new j5.l();
        this.f18035e = P;
        this.f18036f = new ConcurrentHashMap<>();
        this.f18037g = new ConcurrentHashMap<>();
        this.f18038h = new ConcurrentLinkedQueue<>();
        this.f18039i = v4.k.a.f16583a;
        this.f18040j = new ConcurrentHashMap<>();
        this.f18044n = m4.a.C0275a.f10375a;
        this.f18045o = Integer.parseInt(m4.a.C0275a.f10375a.F("tr_connectx.cast_window_count.feature.config", "persist.tran_cast_window_count", o1.I));
        this.f18046p = 0L;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        this.f18047q = concurrentHashMap;
        this.f18048r = false;
        this.f18049s = false;
        this.f18050t = true;
        this.f18051u = false;
        this.f18052v = z4.e.f21815b;
        this.f18053w = new a();
        this.f18054x = new y5.c.b() { // from class: w4.g1
            @Override // y5.c.b
            public final void a(String str) {
                this.f18011a.n1(str);
            }
        };
        this.f18055y = new b();
        this.f18056z = new c();
        this.A = new k4.h.c() { // from class: w4.h1
            @Override // k4.h.c
            public final void a(int i10, int i11) {
                this.f18014a.p1(i10, i11);
            }
        };
        this.B = new k4.h.g() { // from class: w4.i1
            @Override // k4.h.g
            public final void a(int i10, boolean z10) {
                this.f18017a.v1(i10, z10);
            }
        };
        this.C = new com.transsion.connectx.mirror.source.receiver.a.b() { // from class: w4.j1
            @Override // com.transsion.connectx.mirror.source.receiver.a.b
            public final void a(boolean z10) {
                this.f18019a.s1(z10);
            }
        };
        this.D = new k4.h.d() { // from class: w4.k1
            @Override // k4.h.d
            public final void a(int i10, String str) {
                this.f18029a.q1(i10, str);
            }
        };
        this.E = new k4.h.e() { // from class: w4.p0
            @Override // k4.h.e
            public final void a(Boolean bool) {
                this.f18117a.r1(bool);
            }
        };
        this.F = new k4.h.b() { // from class: w4.q0
            @Override // k4.h.b
            public final void a(int i10, int i11) {
                this.f18123a.o1(i10, i11);
            }
        };
        this.G = new z5.a() { // from class: w4.r0
            @Override // z5.a
            public final void a(int i10) {
                this.f18127a.l1(i10);
            }
        };
        this.H = false;
        this.I = false;
        this.J = new Runnable() { // from class: w4.s0
            @Override // java.lang.Runnable
            public final void run() {
                this.f18132a.e1();
            }
        };
        this.K = i6.a.b.f7724a;
        this.L = null;
        v4.k.a.f16583a.r(SourceNativeLinkManager.H());
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put(TCCPSourceApi.KEY_FEATURE_UIBC, bool);
        concurrentHashMap.put(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD, bool);
    }
}
