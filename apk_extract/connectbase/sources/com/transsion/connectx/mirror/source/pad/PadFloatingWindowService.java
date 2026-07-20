package com.transsion.connectx.mirror.source.pad;

import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.transsion.aiotlink.IStreamDataListener;
import k4.j;
import kn.l0;
import kn.n0;
import lm.l2;
import n2.w;
import os.l;
import os.m;
import p5.g0;
import p5.m0;
import w4.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class PadFloatingWindowService extends LifecycleService {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final a f2122n = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final String f2123p = "PadFloatingWindowService";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public static final String f2124v = "video_info";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public static final String f2125w = "mirror_window_x";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public static final String f2126x = "mirror_window_y";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @m
    @b.a({"StaticFieldLeak"})
    public static FloatingWindow f2127y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IStreamDataListener f2128a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FloatingWindowViewModel f2130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IStreamDataListener f2131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jn.l<? super Integer, l2> f2132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public w f2133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m
    public w.c f2134g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final ViewModelStore f2129b = new ViewModelStore();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2135i = -1;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b implements IStreamDataListener {
        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            m0.f12861a.u0();
            c0.b.f17991a.a0();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            c0.b.f17991a.k0();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@l byte[] bArr, int i10, int i11) {
            l0.p(bArr, "data");
            FloatingWindow floatingWindow = PadFloatingWindowService.f2127y;
            if (floatingWindow != null) {
                floatingWindow.v0(bArr);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
        }
    }

    public static final class c implements IStreamDataListener {
        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@l byte[] bArr, int i10, int i11) {
            l0.p(bArr, "data");
            FloatingWindow floatingWindow = PadFloatingWindowService.f2127y;
            if (floatingWindow != null) {
                floatingWindow.u0(bArr);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
        }
    }

    public static final class d extends n0 implements jn.l<Integer, l2> {
        public d() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Integer num) {
            invoke(num.intValue());
            return l2.f10208a;
        }

        public final void invoke(int i10) {
            PadFloatingWindowService.this.e(i10);
        }
    }

    public static final class e extends n0 implements jn.a<l2> {
        public e() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            m0 m0Var = m0.f12861a;
            IStreamDataListener iStreamDataListener = PadFloatingWindowService.this.f2128a;
            IStreamDataListener iStreamDataListener2 = null;
            if (iStreamDataListener == null) {
                l0.S("mVideoStreamListener");
                iStreamDataListener = null;
            }
            IStreamDataListener iStreamDataListener3 = PadFloatingWindowService.this.f2131d;
            if (iStreamDataListener3 == null) {
                l0.S("mAudioStreamListener");
            } else {
                iStreamDataListener2 = iStreamDataListener3;
            }
            m0Var.b0(iStreamDataListener, iStreamDataListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i10) {
        m2.b.a("phone orientation:", i10, f2123p);
        if (this.f2135i == i10) {
            return;
        }
        this.f2135i = i10;
        FloatingWindow floatingWindow = f2127y;
        if (floatingWindow != null) {
            floatingWindow.R(i10);
        }
    }

    private final void f() {
        this.f2128a = new b();
        this.f2131d = new c();
        d dVar = new d();
        this.f2132e = dVar;
        m0.f12861a.a0(dVar);
        FloatingWindow floatingWindow = f2127y;
        if (floatingWindow != null) {
            floatingWindow.B0(new e());
        }
    }

    private final void g(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("video_info");
        this.f2134g = (w.c) j.a.f8962a.a(j.a.f8962a.f(stringExtra, cb.b.c.f1411r), w.c.class);
        w wVar = (w) j.a.f8962a.a(stringExtra, w.class);
        this.f2133f = wVar;
        if (wVar == null) {
            k4.m.c(f2123p, "initParam: video info is null");
            return;
        }
        k4.m.e(f2123p, "initParam: video info:" + this.f2134g);
        FloatingWindow floatingWindow = f2127y;
        if (floatingWindow != null) {
            floatingWindow.T();
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f2130c;
        if (floatingWindowViewModel == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel = null;
        }
        FloatingWindow floatingWindow2 = new FloatingWindow(this, floatingWindowViewModel, 0, 0, 12, null);
        w.c cVar = this.f2134g;
        if (cVar != null) {
            g0.f12817a.o(cVar.a());
            floatingWindow2.M0(cVar);
            p5.c.f12806a.e(true);
        }
        g0.f12817a.j(floatingWindow2);
        f2127y = floatingWindow2;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    @m
    public IBinder onBind(@l Intent intent) {
        l0.p(intent, "intent");
        super.onBind(intent);
        return null;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        k4.m.e(f2123p, "onCreate");
        this.f2130c = (FloatingWindowViewModel) new ViewModelProvider(this.f2129b, new ViewModelProvider.NewInstanceFactory(), null, 4, null).get(FloatingWindowViewModel.class);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m0 m0Var = m0.f12861a;
        m0Var.f0();
        m0Var.e0();
        p5.c.f12806a.e(false);
        FloatingWindow floatingWindow = f2127y;
        if (floatingWindow != null) {
            floatingWindow.T();
        }
        f2127y = null;
        this.f2133f = null;
        g0.f12817a.a();
        this.f2129b.clear();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@m Intent intent, int i10, int i11) {
        g(intent);
        f();
        return super.onStartCommand(intent, i10, i11);
    }
}
