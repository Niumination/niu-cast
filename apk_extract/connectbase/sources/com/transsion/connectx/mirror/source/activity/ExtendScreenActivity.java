package com.transsion.connectx.mirror.source.activity;

import a6.p;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.activity.ExtendScreenActivity;
import k4.m;
import k5.b0;
import k5.c0;
import k5.e0;
import k5.j;
import k5.z;
import p2.f;
import w4.l1;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendScreenActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f1899y = "arg_extend_screen_info";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f1900z = "ExtendScreenActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f1901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimView f1902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceView f1903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0<j.a, MotionEvent> f1904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExtendScreenViewModel f1905e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ContentObserver f1908i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DisplayManager.DisplayListener f1909n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i6.a f1906f = i6.a.b.f7724a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f1907g = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1910p = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Runnable f1911v = new Runnable() { // from class: x4.k
        @Override // java.lang.Runnable
        public final void run() {
            this.f20035a.H();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Runnable f1912w = new Runnable() { // from class: x4.l
        @Override // java.lang.Runnable
        public final void run() {
            this.f20036a.I();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f1913x = new a();

    public class a implements b0 {
        public a() {
        }

        @Override // k5.b0
        public void a(int i10) {
            m2.b.a("[EXTEND] onScreenLoading:", i10, ExtendScreenActivity.f1900z);
        }

        @Override // k5.b0
        public void b() {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] onScreenResume");
            z.a.f9097a.W();
        }

        @Override // k5.b0
        public void c() {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] onScreenPause");
        }

        @Override // k5.b0
        public void d(int i10) {
            m2.b.a("onScreenDestroy: reason", i10, ExtendScreenActivity.f1900z);
            ExtendScreenActivity.this.f1910p = true;
            ExtendScreenActivity.this.f1906f.a(new Runnable() { // from class: x4.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20038a.i();
                }
            });
        }

        @Override // k5.b0
        public void e() {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] onConnecting");
        }

        @Override // k5.b0
        public void f(o2.c cVar) {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] onScreenReset");
            ExtendScreenActivity.this.f1905e.c(cVar.b(), cVar.a(), ExtendScreenActivity.this.f1903c.getHolder().getSurface(), ExtendScreenActivity.this.x());
        }

        @Override // k5.b0
        public void g(int i10) {
            m2.b.a("[EXTEND] onScreenRotate:", i10, ExtendScreenActivity.f1900z);
            int iX = ExtendScreenActivity.this.x();
            int i11 = 1;
            int i12 = 0;
            if (i10 != 0) {
                if (i10 != 1) {
                    i11 = 3;
                    if (i10 == 2) {
                        i12 = 8;
                    } else if (i10 != 3) {
                        i11 = 0;
                    } else {
                        i12 = 9;
                        i11 = 2;
                    }
                } else {
                    i12 = 1;
                    i11 = 0;
                }
            }
            if (i11 == iX) {
                ExtendScreenActivity.this.w();
                m.e(ExtendScreenActivity.f1900z, "onScreenRotate:same orientation");
                return;
            }
            ExtendScreenActivity.this.setRequestedOrientation(i12);
            if (ExtendScreenActivity.this.B()) {
                ExtendScreenActivity.this.setRequestedOrientation(4);
            }
            ExtendScreenActivity.this.L(i11);
            ExtendScreenActivity.this.w();
        }

        public final /* synthetic */ void i() {
            ExtendScreenActivity.this.finishAndRemoveTask();
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            StringBuilder sbA = i0.a.a("[EXTEND] surfaceChanged:width:", i11, ",height:", i12, ",format:");
            sbA.append(i10);
            m.e(ExtendScreenActivity.f1900z, sbA.toString());
            ExtendScreenActivity.this.f1904d.a(i11, i12);
            ExtendScreenActivity.this.f1905e.h();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] surfaceCreated");
            ExtendScreenViewModel extendScreenViewModel = ExtendScreenActivity.this.f1905e;
            ExtendScreenViewModel extendScreenViewModel2 = ExtendScreenActivity.this.f1905e;
            extendScreenViewModel.c(extendScreenViewModel2.f1924c, extendScreenViewModel2.f1925d, surfaceHolder.getSurface(), ExtendScreenActivity.this.x());
            ExtendScreenActivity.this.w();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            m.e(ExtendScreenActivity.f1900z, "[EXTEND] surfaceDestroyed");
            ExtendScreenActivity.this.f1905e.e();
            ExtendScreenActivity extendScreenActivity = ExtendScreenActivity.this;
            if (extendScreenActivity.f1910p) {
                extendScreenActivity.f1910p = false;
            } else {
                o1.a.f18113a.o();
            }
        }
    }

    public class c implements DisplayManager.DisplayListener {
        public c() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            int iX = ExtendScreenActivity.this.x();
            if (ExtendScreenActivity.this.f1907g == -1) {
                ExtendScreenActivity.this.f1907g = iX;
            } else {
                ExtendScreenActivity.this.M(iX);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }

    public class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            if (ExtendScreenActivity.this.B()) {
                m.e(ExtendScreenActivity.f1900z, "open screen rotate");
                ExtendScreenActivity.this.setRequestedOrientation(4);
            } else {
                m.e(ExtendScreenActivity.f1900z, "close screen rotate");
                ExtendScreenActivity.this.setRequestedOrientation(14);
            }
        }
    }

    public static void C(j.a aVar) {
        if (aVar != null) {
            m.b(f1900z, "uibc:" + aVar);
            z.a.f9097a.t(aVar);
        }
    }

    public static /* synthetic */ void E(WindowInsetsController windowInsetsController) {
        windowInsetsController.hide(WindowInsets.Type.systemBars());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        Display display = getDisplay();
        if (display != null) {
            return display.getRotation();
        }
        m.c(f1900z, "rotationScreen: display is null");
        return 0;
    }

    public final void A() {
        Window window = getWindow();
        final WindowInsetsController insetsController = window.getInsetsController();
        final View decorView = getWindow().getDecorView();
        if (insetsController != null) {
            m.e(f1900z, "initWindow: set WindowInsetsController");
            insetsController.hide(WindowInsets.Type.statusBars());
            insetsController.hide(WindowInsets.Type.navigationBars());
            if (p.a(this)) {
                insetsController.setSystemBarsBehavior(2);
            }
        }
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: x4.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f20031a.F(decorView, insetsController);
            }
        });
        if (p.a(this)) {
            window.setNavigationBarColor(0);
        } else {
            window.setNavigationBarColor(-1);
        }
        window.setDecorFitsSystemWindows(false);
        window.addFlags(128);
    }

    public final boolean B() {
        return Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    public final /* synthetic */ boolean D(View view, MotionEvent motionEvent) {
        this.f1904d.c(motionEvent);
        return true;
    }

    public final /* synthetic */ void F(View view, final WindowInsetsController windowInsetsController) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null || !rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars()) || windowInsetsController == null) {
            return;
        }
        this.f1906f.d(new Runnable() { // from class: x4.j
            @Override // java.lang.Runnable
            public final void run() {
                ExtendScreenActivity.E(windowInsetsController);
            }
        }, 2000);
    }

    public final /* synthetic */ void G() {
        m.e(f1900z, "closeLoading mLoadingPb:");
        if (this.f1901a.getVisibility() == 8) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f1903c.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f1903c.setLayoutParams(layoutParams);
        this.f1901a.setVisibility(8);
        this.f1902b.a();
    }

    public final /* synthetic */ void H() {
        runOnUiThread(new Runnable() { // from class: x4.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f20030a.G();
            }
        });
    }

    public final /* synthetic */ void I() {
        this.f1905e.h();
        if (this.f1905e.i(this.f1907g, this.f1903c.getHolder().getSurface())) {
            return;
        }
        m.e(f1900z, "no run rotate");
        w();
    }

    public final void J() {
        this.f1909n = new c();
        ((DisplayManager) getSystemService("display")).registerDisplayListener(this.f1909n, null);
    }

    public final void K() {
        d dVar = new d(new Handler(getMainLooper()));
        this.f1908i = dVar;
        getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, dVar);
    }

    public final synchronized void L(int i10) {
        this.f1905e.d(i10, this.f1903c.getHolder().getSurface());
    }

    public final void M(int i10) {
        if (i10 == this.f1907g) {
            return;
        }
        m2.b.a("rotateScreen: orientation:", i10, f1900z);
        this.f1907g = i10;
        N();
        this.f1906f.e().e(this.f1912w);
        this.f1906f.e().b(this.f1912w, 1000L);
    }

    public final void N() {
        m.e(f1900z, "showLoading:");
        this.f1906f.e().e(this.f1911v);
        if (this.f1901a.getVisibility() == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f1903c.getLayoutParams();
        layoutParams.width = 1;
        layoutParams.height = 1;
        this.f1903c.setLayoutParams(layoutParams);
        this.f1902b.f(getResources().getAssets(), "loading.mp4");
        this.f1901a.setVisibility(0);
    }

    public final void O() {
        Intent intent = getIntent();
        if (intent == null) {
            m.c(f1900z, "[EXTEND] start extend screen,intent is null");
            finishAndRemoveTask();
            return;
        }
        f fVar = (f) intent.getSerializableExtra(f1899y);
        m.e(f1900z, "[EXTEND] config:" + fVar);
        if (fVar != null) {
            this.f1905e.j(fVar);
        } else {
            m.c(f1900z, "[EXTEND] start extend screen,param error");
            finishAndRemoveTask();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        M(x());
        m.e(f1900z, "[EXTEND] onConfigurationChanged" + configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int iV0 = l1.h.f18073a.v0();
        m2.b.a("[EXTEND] onCreate:tccp state:", iV0, f1900z);
        if (iV0 != 1) {
            m.c(f1900z, "TCCP status not connected");
            finishAndRemoveTask();
            return;
        }
        if ((getIntent().getFlags() & 1048576) != 0) {
            m.c(f1900z, "Extended screen not connected");
            finishAndRemoveTask();
            return;
        }
        setContentView(R.layout.activity_extend_screen);
        A();
        z();
        N();
        y();
        ExtendScreenViewModel extendScreenViewModel = (ExtendScreenViewModel) new ViewModelProvider(this).get(ExtendScreenViewModel.class);
        this.f1905e = extendScreenViewModel;
        extendScreenViewModel.f(this.f1913x);
        J();
        K();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m.e(f1900z, "[EXTEND] onDestroy");
        super.onDestroy();
        this.f1905e.k(this.f1913x);
        if (this.f1908i != null) {
            getContentResolver().unregisterContentObserver(this.f1908i);
        }
        if (this.f1909n != null) {
            ((DisplayManager) getSystemService("display")).unregisterDisplayListener(this.f1909n);
        }
        AnimView animView = this.f1902b;
        if (animView != null) {
            animView.a();
        }
        this.f1906f.e().e(this.f1912w);
        this.f1906f.e().e(this.f1911v);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        m.e(f1900z, "[EXTEND] onPause");
        super.onPause();
        this.f1905e.e();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1905e.b();
        m.e(f1900z, "[EXTEND] onResume state： " + this.f1905e.f1922a);
        if (this.f1903c.getHolder().getSurface().isValid()) {
            m.e(f1900z, "onResume: restore play");
            this.f1905e.d(x(), this.f1903c.getHolder().getSurface());
        }
        if (this.f1905e.f1922a != 1) {
            return;
        }
        O();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void w() {
        this.f1906f.e().b(this.f1911v, 1000L);
    }

    @b.a({"ClickableViewAccessibility"})
    public final void y() {
        c0 c0Var = new c0(this.f1903c);
        this.f1904d = c0Var;
        c0Var.d(new x4.m());
        this.f1903c.setOnTouchListener(new View.OnTouchListener() { // from class: x4.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f20037a.D(view, motionEvent);
            }
        });
        this.f1903c.getHolder().addCallback(new b());
    }

    public final void z() {
        this.f1901a = (FrameLayout) findViewById(R.id.pb_extend_loading);
        this.f1903c = (SurfaceView) findViewById(R.id.sfv_play);
        AnimView animView = (AnimView) findViewById(R.id.loading_anim);
        this.f1902b = animView;
        animView.setLoop(Integer.MAX_VALUE);
    }
}
