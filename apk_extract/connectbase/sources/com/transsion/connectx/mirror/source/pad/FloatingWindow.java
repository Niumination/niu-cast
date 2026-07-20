package com.transsion.connectx.mirror.source.pad;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.Observer;
import com.google.android.material.badge.BadgeDrawable;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.bean.PadMotionEventBean;
import com.transsion.connectx.mirror.source.databinding.PhoneFloatingWindowsBinding;
import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import com.transsion.connectx.mirror.source.pad.view.TriangleView;
import com.transsion.connectx.mirror.source.pad.view.WindowStrokeView;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.util.List;
import java.util.Locale;
import jq.h0;
import kn.d0;
import kn.k1;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.d1;
import lm.l2;
import lm.t0;
import lm.v;
import n2.w;
import nq.s0;
import p5.g0;
import p5.m0;
import p5.u0;
import rb.s;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
@b.a({"ViewConstructor"})
public final class FloatingWindow extends LinearLayout {

    @os.l
    public static final a W = new a();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @os.l
    public static final String f2047a0 = "FloatingWindow";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @os.l
    public static final String f2048b0 = "start";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @os.l
    public static final String f2049c0 = "end";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f2050d0 = 40;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f2051e0 = 80;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f2052f0 = 395;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f2053g0 = 24;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @os.l
    public static final String f2054h0 = "connected";
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public String R;
    public int S;

    @os.m
    public OrientationEventListener T;

    @os.m
    public jn.a<l2> U;

    @os.l
    public final s0 V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final FloatingWindowViewModel f2055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final PhoneFloatingWindowsBinding f2058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public WindowManager f2059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public LinearLayout f2060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WindowManager.LayoutParams f2061g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WindowManager.LayoutParams f2062i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DisplayMetrics f2063n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.m
    public w.c f2064p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public SurfaceView f2065v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.m
    public u0 f2066w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.m
    public p5.b f2067x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.m
    public jn.a<l2> f2068y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.m
    public jn.l<? super Integer, l2> f2069z;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b implements FloatingWindowViewModel.a {
        public b() {
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void a() {
            FloatingWindow.this.W();
            FloatingWindow.this.f2058d.f2029d.f2005a.setVisibility(8);
            ConstraintLayout constraintLayout = FloatingWindow.this.f2058d.f2029d.f2008d;
            l0.o(constraintLayout, "windowButton");
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            l0.o(FloatingWindow.this.f2058d.f2033i, "rootContent");
            layoutParams.width = -1;
            constraintLayout.setLayoutParams(layoutParams);
            h();
            g();
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void b() {
            Boolean boolX = FloatingWindow.this.f2055a.x(Boolean.FALSE);
            l0.o(boolX, "setMenuVisible(...)");
            if (boolX.booleanValue()) {
                return;
            }
            m0 m0Var = m0.f12861a;
            byte[] bArrA = x5.b.a(187);
            l0.o(bArrA, "createKeyEventByte(...)");
            m0Var.p0(bArrA);
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void c() {
            Boolean boolX = FloatingWindow.this.f2055a.x(Boolean.FALSE);
            l0.o(boolX, "setMenuVisible(...)");
            if (boolX.booleanValue()) {
                return;
            }
            m0.f12861a.v();
            o1.a.f18113a.L(FloatingWindow.f2054h0);
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void d() {
            Boolean boolX = FloatingWindow.this.f2055a.x(Boolean.FALSE);
            l0.o(boolX, "setMenuVisible(...)");
            if (boolX.booleanValue()) {
                return;
            }
            m0 m0Var = m0.f12861a;
            byte[] bArrA = x5.b.a(4);
            l0.o(bArrA, "createKeyEventByte(...)");
            m0Var.p0(bArrA);
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void e() {
            Boolean boolX = FloatingWindow.this.f2055a.x(Boolean.FALSE);
            l0.o(boolX, "setMenuVisible(...)");
            if (boolX.booleanValue()) {
                return;
            }
            m0 m0Var = m0.f12861a;
            byte[] bArrA = x5.b.a(3);
            l0.o(bArrA, "createKeyEventByte(...)");
            m0Var.p0(bArrA);
        }

        @Override // com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel.a
        public void f() {
            FloatingWindow.this.X();
            FloatingWindow.this.f2058d.f2029d.f2005a.setAlpha(0.5f);
            FloatingWindow.this.f2058d.f2029d.f2005a.setVisibility(0);
            ConstraintLayout constraintLayout = FloatingWindow.this.f2058d.f2029d.f2008d;
            l0.o(constraintLayout, "windowButton");
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            layoutParams.width = (int) TypedValue.applyDimension(1, 300.0f, constraintLayout.getResources().getDisplayMetrics());
            constraintLayout.setLayoutParams(layoutParams);
            j();
            i();
        }

        public final void g() {
            ConstraintLayout constraintLayout = FloatingWindow.this.f2058d.f2029d.f2010f;
            l0.o(constraintLayout, "windowLayout");
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            FloatingWindow.this.Q(constraintSet, R.id.window_button);
            constraintSet.connect(R.id.window_button, 3, 0, 3);
            constraintSet.connect(R.id.window_button, FloatingWindow.this.c0(FloatingWindow.f2048b0), 0, FloatingWindow.this.c0(FloatingWindow.f2048b0));
            constraintSet.applyTo(constraintLayout);
            constraintLayout.requestLayout();
        }

        public final void h() {
            TriangleView triangleView = FloatingWindow.this.f2058d.f2029d.f2007c;
            l0.o(triangleView, "trUp");
            TriangleView triangleView2 = FloatingWindow.this.f2058d.f2029d.f2006b;
            l0.o(triangleView2, "trDown");
            ConstraintLayout constraintLayout = FloatingWindow.this.f2058d.f2029d.f2008d;
            l0.o(constraintLayout, "windowButton");
            ConstraintSet constraintSet = new ConstraintSet();
            triangleView.setVisibility(0);
            triangleView2.setVisibility(8);
            constraintSet.clone(constraintLayout);
            constraintSet.setMargin(R.id.tr_up, 6, 45);
            constraintSet.setMargin(R.id.window_button_content, 7, 25);
            constraintSet.setMargin(R.id.window_button_content, 6, 25);
            constraintSet.applyTo(constraintLayout);
            constraintLayout.requestLayout();
        }

        public final void i() {
            FloatingWindow.this.Y();
        }

        public final void j() {
            TriangleView triangleView = FloatingWindow.this.f2058d.f2029d.f2007c;
            l0.o(triangleView, "trUp");
            TriangleView triangleView2 = FloatingWindow.this.f2058d.f2029d.f2006b;
            l0.o(triangleView2, "trDown");
            ConstraintLayout constraintLayout = FloatingWindow.this.f2058d.f2029d.f2008d;
            l0.o(constraintLayout, "windowButton");
            ConstraintSet constraintSet = new ConstraintSet();
            triangleView.setVisibility(8);
            triangleView2.setVisibility(0);
            constraintSet.clone(constraintLayout);
            constraintSet.setMargin(R.id.tr_down, 6, FloatingWindow.f2052f0);
            constraintSet.setMargin(R.id.window_button_content, 7, 0);
            constraintSet.setMargin(R.id.window_button_content, 6, 0);
            constraintSet.applyTo(constraintLayout);
            constraintLayout.requestLayout();
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2073c = 33;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f2074d;

        public c() {
        }

        public final void a(MotionEvent motionEvent) {
            int rawX = (int) (motionEvent.getRawX() - this.f2071a);
            int rawY = (int) (motionEvent.getRawY() - this.f2072b);
            this.f2071a = motionEvent.getRawX();
            this.f2072b = motionEvent.getRawY();
            WindowManager.LayoutParams layoutParams = FloatingWindow.this.f2061g;
            WindowManager.LayoutParams layoutParams2 = null;
            if (layoutParams == null) {
                l0.S("mWindowParam");
                layoutParams = null;
            }
            layoutParams.x += rawX;
            WindowManager.LayoutParams layoutParams3 = FloatingWindow.this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams3;
            }
            layoutParams2.y += rawY;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@os.l View view, @os.l MotionEvent motionEvent) {
            l0.p(view, "v");
            l0.p(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (FloatingWindow.this.L) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2071a = motionEvent.getRawX();
                this.f2072b = motionEvent.getRawY();
                FloatingWindow.this.f2055a.x(Boolean.FALSE);
            } else if (action == 1 || action == 2) {
                a(motionEvent);
                FloatingWindow.this.x0();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f2074d > this.f2073c) {
                    FloatingWindow floatingWindow = FloatingWindow.this;
                    WindowManager windowManager = floatingWindow.f2059e;
                    LinearLayout linearLayout = floatingWindow.f2060f;
                    WindowManager.LayoutParams layoutParams = floatingWindow.f2061g;
                    WindowManager.LayoutParams layoutParams2 = null;
                    if (layoutParams == null) {
                        l0.S("mWindowParam");
                        layoutParams = null;
                    }
                    windowManager.updateViewLayout(linearLayout, floatingWindow.d0(layoutParams));
                    FloatingWindow floatingWindow2 = FloatingWindow.this;
                    WindowManager windowManager2 = floatingWindow2.f2059e;
                    WindowManager.LayoutParams layoutParams3 = floatingWindow2.f2061g;
                    if (layoutParams3 == null) {
                        l0.S("mWindowParam");
                    } else {
                        layoutParams2 = layoutParams3;
                    }
                    windowManager2.updateViewLayout(floatingWindow2, layoutParams2);
                    this.f2074d = jCurrentTimeMillis;
                }
            }
            return true;
        }
    }

    @r1({"SMAP\nFloatingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingWindow.kt\ncom/transsion/connectx/mirror/source/pad/FloatingWindow$initButtonMoveListener$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1408:1\n260#2:1409\n260#2:1410\n*S KotlinDebug\n*F\n+ 1 FloatingWindow.kt\ncom/transsion/connectx/mirror/source/pad/FloatingWindow$initButtonMoveListener$1\n*L\n712#1:1409\n717#1:1410\n*E\n"})
    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f2081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final ConstraintSet f2082g = new ConstraintSet();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f2083i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ImageView f2084n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f2085p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ FloatingWindow f2086v;

        public d(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, FloatingWindow floatingWindow) {
            this.f2083i = constraintLayout;
            this.f2084n = imageView;
            this.f2085p = constraintLayout2;
            this.f2086v = floatingWindow;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@os.m View view, @os.m MotionEvent motionEvent) {
            boolean z10 = false;
            if (motionEvent == null || view == null) {
                return false;
            }
            this.f2082g.clone(this.f2083i);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f2078c = motionEvent.getRawX();
                this.f2079d = motionEvent.getRawY();
                this.f2080e = view.getX() - motionEvent.getRawX();
                this.f2081f = view.getY() - motionEvent.getRawY();
                p5.i.f12841a.r(this.f2084n);
                this.f2076a = this.f2085p.getVisibility() == 0;
                this.f2077b = SystemClock.uptimeMillis();
            } else if (actionMasked == 1) {
                this.f2086v.P0(this.f2083i, this.f2082g, motionEvent, view, this.f2080e, this.f2081f);
                if (Math.abs(SystemClock.uptimeMillis() - this.f2077b) < 200 && !this.f2076a) {
                    z10 = true;
                }
                k4.m.e(FloatingWindow.f2047a0, "setMenuVisible: " + z10);
                if (!z10) {
                    p5.i.f12841a.q(this.f2084n, true);
                }
                this.f2086v.f2055a.x(Boolean.valueOf(z10));
            } else {
                if (actionMasked != 2) {
                    return false;
                }
                if (this.f2085p.getVisibility() == 0 && (Math.abs(this.f2078c - motionEvent.getRawX()) > 10.0f || Math.abs(this.f2079d - motionEvent.getRawY()) > 10.0f)) {
                    k4.m.e(FloatingWindow.f2047a0, "windowButton.visibility = View.GONE");
                    this.f2086v.f2055a.x(Boolean.FALSE);
                }
                this.f2086v.H0(this.f2083i, this.f2082g, motionEvent, this.f2080e, this.f2081f);
            }
            return true;
        }
    }

    public static final class e extends n0 implements jn.l<Boolean, l2> {
        public e() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return l2.f10208a;
        }

        public final void invoke(boolean z10) {
            FloatingWindow.this.I0(z10);
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public String f2087a = "";

        @Override // android.text.TextWatcher
        public void afterTextChanged(@os.m Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@os.m CharSequence charSequence, int i10, int i11, int i12) {
            String string;
            k4.m.e(FloatingWindow.f2047a0, "beforeTextChanged: " + ((Object) charSequence) + "， start:" + i10 + ", count:" + i11 + ", after:" + i12);
            if (charSequence == null || (string = charSequence.subSequence(i10, i11 + i10).toString()) == null) {
                string = "";
            }
            this.f2087a = string;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@os.m CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            k4.m.e(FloatingWindow.f2047a0, "onTextChanged: " + ((Object) charSequence) + "， start:" + i10 + ", s.length:" + charSequence.length() + ", before:" + i11 + ", count:" + i12);
            try {
                if (i12 > i11) {
                    m0.k0(m0.f12861a, charSequence.subSequence(i11 + i10, i10 + i12).toString(), 0, 2, null);
                } else {
                    if (i12 == i11 && l0.g(this.f2087a, charSequence.subSequence(i10, i10 + i11).toString())) {
                        return;
                    }
                    m0.f12861a.j0(charSequence.subSequence(i10, i12 + i10).toString(), i11);
                }
            } catch (Exception e10) {
                k4.m.c(FloatingWindow.f2047a0, "onTextChanged:" + e10.getMessage());
                k4.m.d(FloatingWindow.f2047a0, e10);
            }
        }
    }

    public static final class g extends OrientationEventListener {
        public g(Context context) {
            super(context, 3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            if (FloatingWindow.this.L || i10 == -1) {
                return;
            }
            int iH = w4.c.h(FloatingWindow.this.getContext());
            FloatingWindow floatingWindow = FloatingWindow.this;
            if (iH != floatingWindow.S) {
                floatingWindow.S = iH;
                floatingWindow.O();
                FloatingWindow.this.N0();
            }
        }
    }

    public static final class h implements SurfaceHolder.Callback {
        public h() {
        }

        public static final void e(u0 u0Var, SurfaceHolder surfaceHolder) {
            l0.p(u0Var, "$it");
            l0.p(surfaceHolder, "$holder");
            u0Var.F(surfaceHolder.getSurface());
        }

        public static final void f(FloatingWindow floatingWindow) {
            l0.p(floatingWindow, "this$0");
            floatingWindow.f2055a.D(false);
        }

        public static final void g(FloatingWindow floatingWindow) {
            l0.p(floatingWindow, "this$0");
            floatingWindow.f2055a.D(false);
        }

        public static final void h(FloatingWindow floatingWindow) {
            l0.p(floatingWindow, "this$0");
            floatingWindow.f2055a.D(false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@os.l SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            l0.p(surfaceHolder, "holder");
            m0.f12861a.W();
            k4.m.e(FloatingWindow.f2047a0, "surfaceChanged: width:" + i11 + "; height:" + i12);
            if (FloatingWindow.this.L) {
                return;
            }
            WindowManager.LayoutParams layoutParams = FloatingWindow.this.f2061g;
            WindowManager.LayoutParams layoutParams2 = null;
            if (layoutParams == null) {
                l0.S("mWindowParam");
                layoutParams = null;
            }
            DisplayMetrics displayMetrics = FloatingWindow.this.f2063n;
            if (displayMetrics == null) {
                l0.S("mScreenDisplay");
                displayMetrics = null;
            }
            layoutParams.x = (displayMetrics.widthPixels - i11) - 40;
            WindowManager.LayoutParams layoutParams3 = FloatingWindow.this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams3;
            }
            layoutParams2.y = 80;
            FloatingWindow.this.N0();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@os.l final SurfaceHolder surfaceHolder) {
            l0.p(surfaceHolder, "holder");
            k4.m.e(FloatingWindow.f2047a0, "surfaceCreated: " + surfaceHolder.getSurface().isValid());
            final u0 u0Var = FloatingWindow.this.f2066w;
            if (u0Var != null) {
                final FloatingWindow floatingWindow = FloatingWindow.this;
                floatingWindow.postDelayed(new Runnable() { // from class: p5.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatingWindow.h.e(u0Var, surfaceHolder);
                    }
                }, 500L);
                floatingWindow.postDelayed(new Runnable() { // from class: p5.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatingWindow.h.f(floatingWindow);
                    }
                }, 1500L);
                return;
            }
            FloatingWindow.this.f2066w = new u0(surfaceHolder.getSurface());
            final FloatingWindow floatingWindow2 = FloatingWindow.this;
            u0 u0Var2 = floatingWindow2.f2066w;
            if (u0Var2 != null) {
                u0Var2.B(new Runnable() { // from class: p5.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatingWindow.h.g(floatingWindow2);
                    }
                });
            }
            FloatingWindow floatingWindow3 = FloatingWindow.this;
            u0 u0Var3 = floatingWindow3.f2066w;
            if (u0Var3 != null) {
                w.c cVar = floatingWindow3.f2064p;
                int iJ = cVar != null ? cVar.j() : w4.c.f17970e;
                w.c cVar2 = FloatingWindow.this.f2064p;
                u0Var3.I(iJ, cVar2 != null ? cVar2.f() : 1400, FloatingWindow.this.I);
            }
            jn.a<l2> aVar = FloatingWindow.this.U;
            if (aVar != null) {
                aVar.invoke();
            }
            final FloatingWindow floatingWindow4 = FloatingWindow.this;
            floatingWindow4.postDelayed(new Runnable() { // from class: p5.v
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingWindow.h.h(floatingWindow4);
                }
            }, r4.a.O);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@os.l SurfaceHolder surfaceHolder) {
            l0.p(surfaceHolder, "holder");
            k4.m.e(FloatingWindow.f2047a0, "surfaceDestroyed");
            u0 u0Var = FloatingWindow.this.f2066w;
            if (u0Var != null) {
                u0Var.D();
            }
        }
    }

    @r1({"SMAP\nFloatingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingWindow.kt\ncom/transsion/connectx/mirror/source/pad/FloatingWindow$initView$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1408:1\n260#2:1409\n260#2:1410\n*S KotlinDebug\n*F\n+ 1 FloatingWindow.kt\ncom/transsion/connectx/mirror/source/pad/FloatingWindow$initView$1\n*L\n937#1:1409\n944#1:1410\n*E\n"})
    public static final class i extends n0 implements jn.l<Boolean, l2> {
        final /* synthetic */ ImageView $btnCircle;
        final /* synthetic */ ConstraintLayout $windowButton;
        final /* synthetic */ FloatingWindow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ConstraintLayout constraintLayout, ImageView imageView, FloatingWindow floatingWindow) {
            super(1);
            this.$windowButton = constraintLayout;
            this.$btnCircle = imageView;
            this.this$0 = floatingWindow;
        }

        public static final void b(ImageView imageView, FloatingWindow floatingWindow, k1.e eVar, ConstraintLayout constraintLayout, k1.e eVar2) {
            float f10;
            float f11;
            float f12;
            l0.p(imageView, "$btnCircle");
            l0.p(floatingWindow, "this$0");
            l0.p(eVar, "$y");
            l0.p(constraintLayout, "$windowButton");
            l0.p(eVar2, "$x");
            float y10 = imageView.getY();
            DisplayMetrics displayMetrics = floatingWindow.f2063n;
            DisplayMetrics displayMetrics2 = null;
            if (displayMetrics == null) {
                l0.S("mScreenDisplay");
                displayMetrics = null;
            }
            float height = (displayMetrics.heightPixels - y10) - imageView.getHeight();
            float x10 = imageView.getX();
            DisplayMetrics displayMetrics3 = floatingWindow.f2063n;
            if (displayMetrics3 == null) {
                l0.S("mScreenDisplay");
                displayMetrics3 = null;
            }
            float width = (displayMetrics3.widthPixels - x10) - imageView.getWidth();
            if (y10 > height) {
                eVar.element = constraintLayout.getHeight();
            }
            if (x10 > width) {
                f10 = FloatingWindow.f2052f0;
                f11 = 10;
                DisplayMetrics displayMetrics4 = floatingWindow.f2063n;
                if (displayMetrics4 == null) {
                    l0.S("mScreenDisplay");
                } else {
                    displayMetrics2 = displayMetrics4;
                }
                f12 = displayMetrics2.density;
            } else {
                f10 = 24;
                f11 = 10;
                DisplayMetrics displayMetrics5 = floatingWindow.f2063n;
                if (displayMetrics5 == null) {
                    l0.S("mScreenDisplay");
                } else {
                    displayMetrics2 = displayMetrics5;
                }
                f12 = displayMetrics2.density;
            }
            float f13 = (f11 * f12) + f10;
            eVar2.element = f13;
            p5.i.f12841a.v(constraintLayout, f13, eVar.element);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            float f10;
            if (!bool.booleanValue()) {
                p5.i iVar = p5.i.f12841a;
                p5.i.t(iVar, this.$windowButton, 0L, 2, null);
                if (this.$btnCircle.getVisibility() == 0) {
                    iVar.q(this.$btnCircle, true);
                    return;
                }
                return;
            }
            final k1.e eVar = new k1.e();
            if (this.this$0.t0()) {
                f10 = this.this$0.J - 60.0f;
            } else {
                float f11 = 40;
                DisplayMetrics displayMetrics = this.this$0.f2063n;
                if (displayMetrics == null) {
                    l0.S("mScreenDisplay");
                    displayMetrics = null;
                }
                f10 = f11 * displayMetrics.density;
            }
            eVar.element = f10;
            final k1.e eVar2 = new k1.e();
            eVar2.element = 30.0f;
            if (this.$btnCircle.getVisibility() != 0) {
                p5.i.f12841a.v(this.$windowButton, eVar.element, eVar2.element);
                return;
            }
            final ImageView imageView = this.$btnCircle;
            final FloatingWindow floatingWindow = this.this$0;
            final ConstraintLayout constraintLayout = this.$windowButton;
            imageView.post(new Runnable() { // from class: p5.w
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingWindow.i.b(imageView, floatingWindow, eVar2, constraintLayout, eVar);
                }
            });
        }
    }

    public static final class j extends n0 implements jn.l<Boolean, l2> {
        public j() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            l0.m(bool);
            if (bool.booleanValue()) {
                FloatingWindow.this.f2058d.f2035p.f1965d.setImageResource(R.drawable.ic_public_menu_disable);
            } else {
                FloatingWindow.this.f2058d.f2035p.f1965d.setImageResource(R.drawable.ic_public_menu);
            }
        }
    }

    public static final class k extends n0 implements jn.l<Boolean, l2> {
        final /* synthetic */ ConstraintLayout $extendTip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ConstraintLayout constraintLayout) {
            super(1);
            this.$extendTip = constraintLayout;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            float f10;
            if (bool.booleanValue()) {
                if (FloatingWindow.this.t0()) {
                    f10 = FloatingWindow.this.J - 60.0f;
                } else {
                    float f11 = 40;
                    DisplayMetrics displayMetrics = FloatingWindow.this.f2063n;
                    if (displayMetrics == null) {
                        l0.S("mScreenDisplay");
                        displayMetrics = null;
                    }
                    f10 = f11 * displayMetrics.density;
                }
                p5.i iVar = p5.i.f12841a;
                iVar.v(this.$extendTip, f10, 30.0f);
                iVar.s(this.$extendTip, 10200L);
            }
        }
    }

    public static final class l extends n0 implements jn.l<Boolean, l2> {

        @xm.f(c = "com.transsion.connectx.mirror.source.pad.FloatingWindow$initView$4$1", f = "FloatingWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ Boolean $it;
            int label;
            final /* synthetic */ FloatingWindow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(FloatingWindow floatingWindow, Boolean bool, um.d<? super a> dVar) {
                super(2, dVar);
                this.this$0 = floatingWindow;
                this.$it = bool;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(this.this$0, this.$it, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                AnimView animView = this.this$0.f2058d.f2030e.f2021b;
                l0.o(animView, "mirrorLoading");
                Boolean bool = this.$it;
                l0.o(bool, "$it");
                if (bool.booleanValue()) {
                    animView.setLoop(Integer.MAX_VALUE);
                    AssetManager assets = this.this$0.getResources().getAssets();
                    l0.o(assets, "getAssets(...)");
                    animView.f(assets, "pad/load/video.mp4");
                } else {
                    animView.a();
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public l() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            nq.k.f(FloatingWindow.this.V, null, null, new a(FloatingWindow.this, bool, null), 3, null);
        }
    }

    public static final class m extends n0 implements jn.l<Boolean, l2> {
        final /* synthetic */ AnimView $loading;
        final /* synthetic */ LinearLayout $loadingBg;

        @xm.f(c = "com.transsion.connectx.mirror.source.pad.FloatingWindow$initView$5$1", f = "FloatingWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ Boolean $it;
            final /* synthetic */ AnimView $loading;
            final /* synthetic */ LinearLayout $loadingBg;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Boolean bool, LinearLayout linearLayout, AnimView animView, um.d<? super a> dVar) {
                super(2, dVar);
                this.$it = bool;
                this.$loadingBg = linearLayout;
                this.$loading = animView;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(this.$it, this.$loadingBg, this.$loading, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                Boolean bool = this.$it;
                l0.o(bool, "$it");
                if (bool.booleanValue()) {
                    this.$loadingBg.setVisibility(0);
                    this.$loading.setVisibility(0);
                    p5.i.f12841a.o(this.$loading);
                } else {
                    p5.i.f12841a.j(this.$loading, this.$loadingBg);
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(LinearLayout linearLayout, AnimView animView) {
            super(1);
            this.$loadingBg = linearLayout;
            this.$loading = animView;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            nq.k.f(FloatingWindow.this.V, null, null, new a(bool, this.$loadingBg, this.$loading, null), 3, null);
        }
    }

    public static final class n extends n0 implements jn.l<Boolean, l2> {
        public n() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (FloatingWindow.this.f2064p == null) {
                return;
            }
            l0.m(bool);
            int dimension = (int) (bool.booleanValue() ? FloatingWindow.this.getResources().getDimension(R.dimen.mirror_window_tool_bar_height_gesture) : FloatingWindow.this.getResources().getDimension(R.dimen.mirror_window_tool_bar_height));
            FloatingWindow floatingWindow = FloatingWindow.this;
            if (floatingWindow.Q == dimension) {
                return;
            }
            floatingWindow.Q = dimension;
            ViewGroup.LayoutParams layoutParams = floatingWindow.f2058d.f2026a.getRoot().getLayoutParams();
            FloatingWindow floatingWindow2 = FloatingWindow.this;
            layoutParams.height = floatingWindow2.Q;
            if (floatingWindow2.L) {
                return;
            }
            floatingWindow2.O();
            FloatingWindow.this.N0();
        }
    }

    public static final class o extends n0 implements jn.l<Integer, l2> {
        public o() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Integer num) {
            invoke2(num);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            boolean unused = FloatingWindow.this.L;
        }
    }

    public static final class p implements Observer, d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f2090a;

        public p(jn.l lVar) {
            l0.p(lVar, "function");
            this.f2090a = lVar;
        }

        public final boolean equals(@os.m Object obj) {
            if ((obj instanceof Observer) && (obj instanceof d0)) {
                return l0.g(this.f2090a, ((d0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kn.d0
        @os.l
        public final v<?> getFunctionDelegate() {
            return this.f2090a;
        }

        public final int hashCode() {
            return this.f2090a.hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f2090a.invoke(obj);
        }
    }

    public /* synthetic */ FloatingWindow(Context context, FloatingWindowViewModel floatingWindowViewModel, int i10, int i11, int i12, kn.w wVar) {
        this(context, floatingWindowViewModel, (i12 & 4) != 0 ? 40 : i10, (i12 & 8) != 0 ? 80 : i11);
    }

    public static final boolean A0(FloatingWindow floatingWindow, View view, MotionEvent motionEvent) {
        l0.p(floatingWindow, "this$0");
        floatingWindow.f2055a.x(Boolean.FALSE);
        return true;
    }

    public static final void J0(boolean z10, final FloatingWindow floatingWindow) {
        l0.p(floatingWindow, "this$0");
        try {
            k4.m.e(f2047a0, "updateInputShow:" + z10);
            final InputMethodManager inputMethodManager = (InputMethodManager) floatingWindow.getContext().getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
            WindowManager.LayoutParams layoutParams = null;
            if (z10) {
                if (!floatingWindow.L) {
                    WindowManager.LayoutParams layoutParams2 = floatingWindow.f2061g;
                    if (layoutParams2 == null) {
                        l0.S("mWindowParam");
                        layoutParams2 = null;
                    }
                    WindowManager.LayoutParams layoutParams3 = floatingWindow.f2061g;
                    if (layoutParams3 == null) {
                        l0.S("mWindowParam");
                    } else {
                        layoutParams = layoutParams3;
                    }
                    layoutParams2.flags = layoutParams.flags & (-9);
                    floatingWindow.N0();
                }
                floatingWindow.f2058d.f2027b.postDelayed(new Runnable() { // from class: p5.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatingWindow.K0(this.f12856a, inputMethodManager);
                    }
                }, 500L);
                return;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(floatingWindow.f2058d.f2027b.getWindowToken(), 0);
            }
            floatingWindow.f2058d.f2027b.clearFocus();
            floatingWindow.f2058d.f2027b.setText("");
            if (floatingWindow.L) {
                return;
            }
            WindowManager.LayoutParams layoutParams4 = floatingWindow.f2061g;
            if (layoutParams4 == null) {
                l0.S("mWindowParam");
                layoutParams4 = null;
            }
            WindowManager.LayoutParams layoutParams5 = floatingWindow.f2061g;
            if (layoutParams5 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams = layoutParams5;
            }
            layoutParams4.flags = layoutParams.flags | 8;
            floatingWindow.N0();
        } catch (Exception e10) {
            k4.m.c(f2047a0, "updateInputShow:" + e10.getMessage());
            k4.m.d(f2047a0, e10);
        }
    }

    public static final void K0(FloatingWindow floatingWindow, InputMethodManager inputMethodManager) {
        l0.p(floatingWindow, "this$0");
        floatingWindow.requestFocus();
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(floatingWindow.f2058d.f2027b, 2);
        }
    }

    public static final void O0(FloatingWindow floatingWindow) {
        l0.p(floatingWindow, "this$0");
        if (floatingWindow.L) {
            return;
        }
        try {
            floatingWindow.x0();
            WindowManager windowManager = floatingWindow.f2059e;
            LinearLayout linearLayout = floatingWindow.f2060f;
            WindowManager.LayoutParams layoutParams = floatingWindow.f2061g;
            WindowManager.LayoutParams layoutParams2 = null;
            if (layoutParams == null) {
                l0.S("mWindowParam");
                layoutParams = null;
            }
            windowManager.updateViewLayout(linearLayout, floatingWindow.d0(layoutParams));
            WindowManager windowManager2 = floatingWindow.f2059e;
            WindowManager.LayoutParams layoutParams3 = floatingWindow.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams3;
            }
            windowManager2.updateViewLayout(floatingWindow, layoutParams2);
        } catch (Exception e10) {
            k4.m.d(f2047a0, e10);
        }
    }

    public static final void S(FloatingWindow floatingWindow) {
        l0.p(floatingWindow, "this$0");
        floatingWindow.f2055a.j();
        floatingWindow.Y();
    }

    public static final int a0(int i10, int i11) {
        return i11 == 0 ? i10 : a0(i11, i10 % i11);
    }

    private final FloatingWindowViewModel.a getProjectionViewEventListener() {
        return new b();
    }

    public static final void l0(FloatingWindow floatingWindow, int i10, String str) {
        l0.p(floatingWindow, "this$0");
        floatingWindow.I0(false);
    }

    public static final boolean o0(FloatingWindow floatingWindow, SurfaceView surfaceView, View view, MotionEvent motionEvent) {
        l0.p(floatingWindow, "this$0");
        l0.p(surfaceView, "$surfaceView");
        Boolean boolX = floatingWindow.f2055a.x(Boolean.FALSE);
        l0.o(boolX, "setMenuVisible(...)");
        if (boolX.booleanValue()) {
            return true;
        }
        k4.m.e(f2047a0, "onTouch surfaceView event: " + motionEvent + ", width:" + surfaceView.getWidth() + ", height:" + surfaceView.getHeight());
        m0 m0Var = m0.f12861a;
        PadMotionEventBean.a aVar = PadMotionEventBean.CREATOR;
        l0.m(motionEvent);
        m0Var.n0(PadMotionEventBean.a.c(aVar, motionEvent, surfaceView.getWidth(), surfaceView.getHeight(), false, 0, 24, null).o());
        return true;
    }

    public static final boolean p0(SurfaceView surfaceView, FloatingWindow floatingWindow, View view, MotionEvent motionEvent) {
        l0.p(surfaceView, "$surfaceView");
        l0.p(floatingWindow, "this$0");
        k4.m.c(f2047a0, "OnGenericMotionListener: " + motionEvent);
        m0 m0Var = m0.f12861a;
        PadMotionEventBean.a aVar = PadMotionEventBean.CREATOR;
        l0.m(motionEvent);
        m0Var.n0(PadMotionEventBean.a.c(aVar, motionEvent, surfaceView.getWidth(), surfaceView.getHeight(), false, 0, 24, null).o());
        return floatingWindow.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    public static final boolean q0(View view, int i10, KeyEvent keyEvent) {
        k4.m.e(f2047a0, "OnKeyListener: " + i10 + ", " + keyEvent);
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i10 != 67) {
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                    m0.f12861a.l0(i10, keyEvent.getMetaState());
                    break;
                default:
                    if (!keyEvent.isCtrlPressed()) {
                        return false;
                    }
                    if (i10 != 29 && i10 != 31 && i10 != 50 && i10 != 52) {
                        return false;
                    }
                    m0.f12861a.l0(i10, keyEvent.getMetaState());
                    break;
                    break;
            }
        } else {
            m0.f12861a.l0(i10, keyEvent.getMetaState());
        }
        return true;
    }

    public final void B0(@os.l jn.a<l2> aVar) {
        l0.p(aVar, "onReady");
        this.U = aVar;
    }

    public final void C0(LifecycleService lifecycleService) {
        this.f2055a.f2110o.observe(lifecycleService, new p(new n()));
    }

    public final void D0(LifecycleService lifecycleService) {
        g0.f12817a.getClass();
        g0.f12837u.observe(lifecycleService, new p(new o()));
    }

    public final void E0(int i10) {
        m2.b.a("reloadPlayer:orientation=", i10, f2047a0);
        u0 u0Var = this.f2066w;
        if (u0Var != null) {
            u0Var.E(i10);
        }
    }

    public final void F0() {
        this.f2055a.y();
    }

    public final void G0() {
        this.f2068y = null;
        this.f2069z = null;
    }

    public final void H0(ConstraintLayout constraintLayout, ConstraintSet constraintSet, MotionEvent motionEvent, float f10, float f11) {
        Q(constraintSet, R.id.btn_circle);
        constraintSet.connect(R.id.btn_circle, 3, 0, 3, (int) (motionEvent.getRawY() + f11));
        constraintSet.connect(R.id.btn_circle, c0(f2048b0), 0, c0(f2048b0), (int) (motionEvent.getRawX() + f10));
        constraintSet.applyTo(constraintLayout);
        constraintLayout.requestLayout();
    }

    public final void I0(final boolean z10) {
        this.f2058d.f2027b.post(new Runnable() { // from class: p5.p
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindow.J0(z10, this);
            }
        });
    }

    public final void L0() {
        DisplayMetrics displayMetrics = this.f2063n;
        DisplayMetrics displayMetrics2 = null;
        if (displayMetrics == null) {
            l0.S("mScreenDisplay");
            displayMetrics = null;
        }
        int i10 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics3 = this.f2063n;
        if (displayMetrics3 == null) {
            l0.S("mScreenDisplay");
        } else {
            displayMetrics2 = displayMetrics3;
        }
        this.N = Math.max(i10, displayMetrics2.heightPixels);
        w.c cVar = this.f2064p;
        if (cVar != null) {
            this.M = (int) (this.N * (cVar.j() / cVar.f()));
        }
    }

    public final void M() {
        this.f2058d.f2026a.f1973a.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.window_bottom_bg));
        this.f2058d.f2026a.f1974b.setImageResource(R.drawable.navigation_back);
        this.f2058d.f2026a.f1975c.setImageResource(R.drawable.navigation_home);
        this.f2058d.f2026a.f1976d.setImageResource(R.drawable.navigation_recent);
        this.f2058d.f2035p.f1962a.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.actionbar_bg));
        this.f2058d.f2035p.f1963b.setImageResource(R.drawable.ic_close);
        this.f2058d.f2035p.f1964c.setImageResource(R.drawable.ic_full_screen);
        this.f2058d.f2030e.f2020a.setBackground(AppCompatResources.getDrawable(getContext(), R.color.pad_action_bar));
        if (l0.g(this.f2055a.f2108m.getValue(), Boolean.TRUE)) {
            this.f2058d.f2035p.f1965d.setImageResource(R.drawable.ic_public_menu_disable);
        } else {
            this.f2058d.f2035p.f1965d.setImageResource(R.drawable.ic_public_menu);
        }
    }

    public final void M0(@os.l w.c cVar) {
        l0.p(cVar, "videoParam");
        this.f2064p = cVar;
        k4.m.e(f2047a0, "video param:" + cVar);
        DisplayMetrics displayMetrics = this.f2063n;
        WindowManager.LayoutParams layoutParams = null;
        if (displayMetrics == null) {
            l0.S("mScreenDisplay");
            displayMetrics = null;
        }
        int i10 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = this.f2063n;
        if (displayMetrics2 == null) {
            l0.S("mScreenDisplay");
            displayMetrics2 = null;
        }
        this.N = Math.max(i10, displayMetrics2.heightPixels);
        int dimension = (int) getResources().getDimension(R.dimen.mirror_window_tool_bar_height_gesture);
        this.P = dimension;
        this.Q = dimension;
        if (cVar.a() != 2) {
            this.Q = (int) getResources().getDimension(R.dimen.mirror_window_tool_bar_height);
            View viewFindViewById = findViewById(R.id.bottom_nav);
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById != null ? viewFindViewById.getLayoutParams() : null;
            if (layoutParams2 != null) {
                layoutParams2.height = this.Q;
            }
        }
        w.c cVar2 = this.f2064p;
        if (cVar2 != null) {
            this.H = cVar2.h();
            this.R = Z(cVar2.j(), cVar2.f());
            this.M = (int) (((double) this.N) * (((double) cVar2.j()) / ((double) cVar2.f())));
            String str = this.R;
            if (str == null) {
                l0.S("mVideoAspectRatio");
                str = null;
            }
            t0<Integer, Integer> t0VarF0 = f0(str, this.H);
            this.J = t0VarF0.getFirst().intValue() + 1;
            this.K = t0VarF0.getSecond().intValue() + this.P + this.Q;
            this.I = O();
            R(this.H);
            P();
            x0();
            WindowManager windowManager = this.f2059e;
            LinearLayout linearLayout = this.f2060f;
            WindowManager.LayoutParams layoutParams3 = this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
                layoutParams3 = null;
            }
            windowManager.updateViewLayout(linearLayout, d0(layoutParams3));
            WindowManager windowManager2 = this.f2059e;
            WindowManager.LayoutParams layoutParams4 = this.f2061g;
            if (layoutParams4 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams = layoutParams4;
            }
            windowManager2.updateViewLayout(this, layoutParams);
            E0(this.I);
        }
        z0();
    }

    public final void N() {
        boolean zT0 = t0();
        m2.b.a("onConfigurationChanged: isRTL:", zT0 ? 1 : 0, f2047a0);
        this.f2058d.f2026a.f1973a.setLayoutDirection(zT0 ? 1 : 0);
    }

    public final void N0() {
        i6.a.b.f7724a.a(new Runnable() { // from class: p5.q
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindow.O0(this.f12896a);
            }
        });
    }

    @b.a({"SwitchIntDef"})
    public final int O() {
        String str = this.R;
        WindowManager.LayoutParams layoutParams = null;
        if (str == null) {
            l0.S("mVideoAspectRatio");
            str = null;
        }
        t0<Integer, Integer> t0VarF0 = f0(str, this.H);
        this.f2065v.getLayoutParams().width = t0VarF0.getFirst().intValue() + 3;
        this.f2065v.getLayoutParams().height = t0VarF0.getSecond().intValue() + 3;
        int i10 = this.H;
        int i11 = 0;
        if (i10 == 0) {
            WindowManager.LayoutParams layoutParams2 = this.f2061g;
            if (layoutParams2 == null) {
                l0.S("mWindowParam");
                layoutParams2 = null;
            }
            layoutParams2.width = t0VarF0.getFirst().intValue();
            WindowManager.LayoutParams layoutParams3 = this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
                layoutParams3 = null;
            }
            layoutParams3.height = t0VarF0.getSecond().intValue() + this.P + this.Q;
        } else if (i10 == 1) {
            WindowManager.LayoutParams layoutParams4 = this.f2061g;
            if (layoutParams4 == null) {
                l0.S("mWindowParam");
                layoutParams4 = null;
            }
            layoutParams4.width = t0VarF0.getFirst().intValue();
            WindowManager.LayoutParams layoutParams5 = this.f2061g;
            if (layoutParams5 == null) {
                l0.S("mWindowParam");
                layoutParams5 = null;
            }
            layoutParams5.height = t0VarF0.getSecond().intValue() + this.P + this.Q;
            i11 = 270;
        } else if (i10 == 3) {
            WindowManager.LayoutParams layoutParams6 = this.f2061g;
            if (layoutParams6 == null) {
                l0.S("mWindowParam");
                layoutParams6 = null;
            }
            layoutParams6.width = t0VarF0.getFirst().intValue();
            WindowManager.LayoutParams layoutParams7 = this.f2061g;
            if (layoutParams7 == null) {
                l0.S("mWindowParam");
                layoutParams7 = null;
            }
            layoutParams7.height = t0VarF0.getSecond().intValue() + this.P + this.Q;
            i11 = 90;
        }
        k4.m.e(f2047a0, "surface info: mSurfaceWidth:" + this.O + ", mSmallWindowHeight:" + this.K);
        k4.m.e(f2047a0, "surface info: mPhoneScreenView.layoutParams.width:" + this.f2065v.getLayoutParams().width + ", mPhoneScreenView.layoutParams.height:" + this.f2065v.getLayoutParams().height);
        w.c cVar = this.f2064p;
        Integer numValueOf = cVar != null ? Integer.valueOf(cVar.j()) : null;
        w.c cVar2 = this.f2064p;
        k4.m.e(f2047a0, "surface info: mVideoParam width:" + numValueOf + ", mVideoParam height:" + (cVar2 != null ? Integer.valueOf(cVar2.f()) : null));
        WindowManager.LayoutParams layoutParams8 = this.f2061g;
        if (layoutParams8 == null) {
            l0.S("mWindowParam");
            layoutParams8 = null;
        }
        int i12 = layoutParams8.width;
        WindowManager.LayoutParams layoutParams9 = this.f2061g;
        if (layoutParams9 == null) {
            l0.S("mWindowParam");
        } else {
            layoutParams = layoutParams9;
        }
        k4.m.e(f2047a0, "surface info: mWindowParam.width:" + i12 + ", mWindowParam.height:" + layoutParams.height);
        return i11;
    }

    public final void P() {
        int iH = w4.c.h(getContext());
        m2.b.a("Pad orientation:", iH, f2047a0);
        boolean z10 = true;
        boolean z11 = iH == 0 || iH == 2;
        int i10 = this.H;
        if (i10 != 1 && i10 != 3) {
            z10 = false;
        }
        k4.m.e(f2047a0, "calWindowPointByOrientation:isLandPad=" + z11 + ", isLandPhone=" + z10);
        WindowManager.LayoutParams layoutParams = this.f2061g;
        WindowManager.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            l0.S("mWindowParam");
            layoutParams = null;
        }
        DisplayMetrics displayMetrics = this.f2063n;
        if (displayMetrics == null) {
            l0.S("mScreenDisplay");
            displayMetrics = null;
        }
        layoutParams.x = (displayMetrics.widthPixels - this.J) - 40;
        if (z11 && z10) {
            WindowManager.LayoutParams layoutParams3 = this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams3;
            }
            layoutParams2.y = 0;
            return;
        }
        if (!z11 && z10) {
            WindowManager.LayoutParams layoutParams4 = this.f2061g;
            if (layoutParams4 == null) {
                l0.S("mWindowParam");
                layoutParams4 = null;
            }
            layoutParams4.x = 40;
            WindowManager.LayoutParams layoutParams5 = this.f2061g;
            if (layoutParams5 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams5;
            }
            layoutParams2.y = 0;
            return;
        }
        if (z11 && !z10) {
            WindowManager.LayoutParams layoutParams6 = this.f2061g;
            if (layoutParams6 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams6;
            }
            layoutParams2.y = 0;
            return;
        }
        if (z11 || z10) {
            return;
        }
        WindowManager.LayoutParams layoutParams7 = this.f2061g;
        if (layoutParams7 == null) {
            l0.S("mWindowParam");
        } else {
            layoutParams2 = layoutParams7;
        }
        layoutParams2.y = 80;
    }

    public final void P0(ConstraintLayout constraintLayout, ConstraintSet constraintSet, MotionEvent motionEvent, View view, float f10, float f11) {
        int i10;
        TriangleView triangleView = this.f2058d.f2029d.f2007c;
        l0.o(triangleView, "trUp");
        TriangleView triangleView2 = this.f2058d.f2029d.f2006b;
        l0.o(triangleView2, "trDown");
        ConstraintLayout constraintLayout2 = this.f2058d.f2029d.f2008d;
        l0.o(constraintLayout2, "windowButton");
        ImageView imageView = this.f2058d.f2029d.f2005a;
        l0.o(imageView, "btnCircle");
        ConstraintSet constraintSet2 = new ConstraintSet();
        float rawY = motionEvent.getRawY() + f11;
        DisplayMetrics displayMetrics = this.f2063n;
        DisplayMetrics displayMetrics2 = null;
        if (displayMetrics == null) {
            l0.S("mScreenDisplay");
            displayMetrics = null;
        }
        float height = (displayMetrics.heightPixels - rawY) - view.getHeight();
        float rawX = motionEvent.getRawX() + f10;
        DisplayMetrics displayMetrics3 = this.f2063n;
        if (displayMetrics3 == null) {
            l0.S("mScreenDisplay");
        } else {
            displayMetrics2 = displayMetrics3;
        }
        float width = (displayMetrics2.widthPixels - rawX) - view.getWidth();
        Q(constraintSet, R.id.btn_circle);
        Q(constraintSet, R.id.window_button);
        constraintSet2.clone(constraintLayout2);
        int rawY2 = (int) (motionEvent.getRawY() + f11);
        if (rawY2 < 0) {
            i10 = 0;
        } else {
            Context context = getContext();
            l0.o(context, "getContext(...)");
            if (rawY2 > b0(context).heightPixels - imageView.getHeight()) {
                Context context2 = getContext();
                l0.o(context2, "getContext(...)");
                rawY2 = (b0(context2).heightPixels - imageView.getHeight()) - 5;
            }
            i10 = rawY2;
        }
        m2.b.a("locationY end: ", i10, f2047a0);
        constraintSet.connect(R.id.btn_circle, 3, 0, 3, i10);
        if (rawY > height) {
            constraintSet.connect(R.id.window_button, 4, R.id.btn_circle, 3);
            constraintSet2.setVisibility(R.id.tr_up, 8);
            constraintSet2.setVisibility(R.id.tr_down, 0);
            if (rawY < 0.0f) {
                constraintSet.connect(R.id.btn_circle, 3, 0, 3);
            }
        } else {
            constraintSet.connect(R.id.window_button, 3, R.id.btn_circle, 4);
            triangleView.setVisibility(0);
            triangleView2.setVisibility(8);
            constraintSet2.setVisibility(R.id.tr_up, 0);
            constraintSet2.setVisibility(R.id.tr_down, 8);
            if (height < 0.0f) {
                constraintSet.connect(R.id.btn_circle, 4, 0, 4);
            }
        }
        if (rawX > width) {
            constraintSet2.setMargin(R.id.tr_down, 6, e0(f2052f0));
            constraintSet2.setMargin(R.id.tr_up, 6, e0(f2052f0));
            constraintSet.connect(R.id.btn_circle, c0(f2049c0), 0, c0(f2049c0));
            constraintSet.setMargin(R.id.btn_circle, c0(f2049c0), 40);
            constraintSet.connect(R.id.window_button, c0(f2049c0), R.id.btn_circle, c0(f2049c0));
        } else {
            constraintSet2.setMargin(R.id.tr_down, 6, e0(24));
            constraintSet2.setMargin(R.id.tr_up, 6, e0(24));
            constraintSet.connect(R.id.btn_circle, c0(f2048b0), 0, c0(f2048b0));
            constraintSet.setMargin(R.id.btn_circle, c0(f2048b0), 40);
            constraintSet.connect(R.id.window_button, c0(f2048b0), R.id.btn_circle, c0(f2048b0));
        }
        constraintSet2.applyTo(constraintLayout2);
        constraintLayout2.requestLayout();
        constraintSet.applyTo(constraintLayout);
        constraintLayout.requestLayout();
    }

    public final void Q(ConstraintSet constraintSet, int i10) {
        constraintSet.clear(i10, 3);
        constraintSet.clear(i10, 6);
        constraintSet.clear(i10, 7);
        constraintSet.clear(i10, 4);
    }

    public final void R(int i10) {
        m2.b.a("ProjectionView dealOrientation:", i10, f2047a0);
        this.H = i10;
        if (this.L) {
            i6.a.b.f7724a.a(new Runnable() { // from class: p5.j
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingWindow.S(this.f12855a);
                }
            });
            return;
        }
        g0.f12817a.getClass();
        z4.l lVar = g0.f12828l;
        if (lVar != null) {
            m2.b.a("getSceneChangeParam:", lVar.e(), f2047a0);
            if ((i10 == 1 || i10 == 3) && lVar.e() == 1) {
                this.f2055a.j();
                return;
            }
        }
        int iO = O();
        N0();
        this.f2055a.D(true);
        E0(iO);
    }

    public final void T() {
        k4.m.e(f2047a0, "ProjectionView destroy");
        OrientationEventListener orientationEventListener = this.T;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.T = null;
        u0 u0Var = this.f2066w;
        if (u0Var != null) {
            u0Var.C();
        }
        p5.b bVar = this.f2067x;
        if (bVar != null) {
            bVar.j();
        }
        jn.a<l2> aVar = this.f2068y;
        if (aVar != null) {
            aVar.invoke();
        }
        this.f2068y = null;
        if (!this.L) {
            try {
                this.f2059e.removeView(this);
                this.f2059e.removeView(this.f2060f);
            } catch (IllegalArgumentException unused) {
                k4.m.c(f2047a0, "View already removed or not attached to WindowManager");
            }
        }
        p5.i.f12841a.p();
    }

    @b.a({"ClickableViewAccessibility"})
    public final void U() {
        WindowInsetsController windowInsetsController = getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.show(WindowInsets.Type.statusBars());
            windowInsetsController.show(WindowInsets.Type.navigationBars());
            windowInsetsController.setSystemBarsBehavior(1);
        }
    }

    public final void V() {
        WindowInsetsController windowInsetsController = getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.systemBars());
            windowInsetsController.setSystemBarsBehavior(2);
        }
    }

    public final void W() {
        jn.a<l2> aVar = this.f2068y;
        if (aVar != null) {
            aVar.invoke();
        }
        k4.m.e(f2047a0, "ProjectionView exitFullScreen");
        k4.m.e(f2047a0, "exitFullScreen: mSmallWindowWidth:" + this.J + ", mSmallWindowHeight:" + this.K);
        P();
        WindowManager.LayoutParams layoutParams = this.f2061g;
        WindowManager.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            l0.S("mWindowParam");
            layoutParams = null;
        }
        layoutParams.flags = 168;
        WindowManager.LayoutParams layoutParams3 = this.f2061g;
        if (layoutParams3 == null) {
            l0.S("mWindowParam");
            layoutParams3 = null;
        }
        layoutParams3.screenOrientation = -1;
        E0(O());
        WindowManager windowManager = this.f2059e;
        LinearLayout linearLayout = this.f2060f;
        WindowManager.LayoutParams layoutParams4 = this.f2061g;
        if (layoutParams4 == null) {
            l0.S("mWindowParam");
            layoutParams4 = null;
        }
        windowManager.addView(linearLayout, d0(layoutParams4));
        WindowManager windowManager2 = this.f2059e;
        WindowManager.LayoutParams layoutParams5 = this.f2061g;
        if (layoutParams5 == null) {
            l0.S("mWindowParam");
        } else {
            layoutParams2 = layoutParams5;
        }
        windowManager2.addView(this, layoutParams2);
        N0();
        this.L = false;
        U();
        this.f2055a.D(true);
    }

    public final void X() {
        k4.m.e(f2047a0, "ProjectionView fullScreen");
        L0();
        int iMax = Math.max(this.J, this.K);
        int iMin = Math.min(this.J, this.K);
        int i10 = this.H;
        WindowManager.LayoutParams layoutParams = null;
        if (i10 == 0) {
            this.f2058d.f2032g.getLayoutParams().width = this.M;
            this.f2058d.f2032g.getLayoutParams().height = this.N;
            E0(0);
            WindowManager.LayoutParams layoutParams2 = this.f2061g;
            if (layoutParams2 == null) {
                l0.S("mWindowParam");
                layoutParams2 = null;
            }
            layoutParams2.screenOrientation = 1;
            this.J = iMin;
            this.K = iMax;
        } else if (i10 == 1) {
            this.f2058d.f2032g.getLayoutParams().width = this.N;
            this.f2058d.f2032g.getLayoutParams().height = this.M;
            E0(270);
            WindowManager.LayoutParams layoutParams3 = this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
                layoutParams3 = null;
            }
            layoutParams3.screenOrientation = 0;
            this.J = iMax;
            this.K = iMin;
        } else if (i10 == 3) {
            this.f2058d.f2032g.getLayoutParams().width = this.N;
            this.f2058d.f2032g.getLayoutParams().height = this.M;
            E0(90);
            WindowManager.LayoutParams layoutParams4 = this.f2061g;
            if (layoutParams4 == null) {
                l0.S("mWindowParam");
                layoutParams4 = null;
            }
            layoutParams4.screenOrientation = 8;
            this.J = iMax;
            this.K = iMin;
        }
        WindowManager.LayoutParams layoutParams5 = this.f2061g;
        if (layoutParams5 == null) {
            l0.S("mWindowParam");
            layoutParams5 = null;
        }
        layoutParams5.height = -1;
        WindowManager.LayoutParams layoutParams6 = this.f2061g;
        if (layoutParams6 == null) {
            l0.S("mWindowParam");
            layoutParams6 = null;
        }
        layoutParams6.width = -1;
        WindowManager.LayoutParams layoutParams7 = this.f2061g;
        if (layoutParams7 == null) {
            l0.S("mWindowParam");
            layoutParams7 = null;
        }
        layoutParams7.x = 0;
        WindowManager.LayoutParams layoutParams8 = this.f2061g;
        if (layoutParams8 == null) {
            l0.S("mWindowParam");
            layoutParams8 = null;
        }
        layoutParams8.y = 0;
        WindowManager.LayoutParams layoutParams9 = this.f2061g;
        if (layoutParams9 == null) {
            l0.S("mWindowParam");
            layoutParams9 = null;
        }
        layoutParams9.flags = 800;
        V();
        jn.l<? super Integer, l2> lVar = this.f2069z;
        if (lVar != null) {
            WindowManager.LayoutParams layoutParams10 = this.f2061g;
            if (layoutParams10 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams = layoutParams10;
            }
            lVar.invoke(Integer.valueOf(layoutParams.screenOrientation));
        }
        if (!this.L) {
            N0();
            this.f2059e.removeView(this);
            this.f2059e.removeView(this.f2060f);
            Intent intent = new Intent(getContext(), (Class<?>) MirrorFullScreenActivity.class);
            intent.setFlags(268435456);
            getContext().startActivity(intent);
        }
        this.f2055a.D(true);
        this.L = true;
    }

    public final void Y() {
        ConstraintLayout constraintLayout = this.f2058d.f2029d.f2010f;
        l0.o(constraintLayout, "windowLayout");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        Q(constraintSet, R.id.btn_circle);
        Q(constraintSet, R.id.window_button);
        constraintSet.connect(R.id.btn_circle, 4, 0, 4);
        constraintSet.connect(R.id.btn_circle, c0(f2049c0), 0, c0(f2049c0));
        constraintSet.connect(R.id.window_button, 4, R.id.btn_circle, 3);
        constraintSet.connect(R.id.window_button, c0(f2049c0), R.id.btn_circle, c0(f2049c0));
        constraintSet.setMargin(R.id.btn_circle, 4, 40);
        constraintSet.setMargin(R.id.btn_circle, c0(f2048b0), 40);
        constraintSet.setMargin(R.id.btn_circle, c0(f2049c0), 40);
        constraintSet.applyTo(constraintLayout);
    }

    public final String Z(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return "";
        }
        int iA0 = a0(i10, i11);
        return (i10 / iA0) + ":" + (i11 / iA0);
    }

    public final DisplayMetrics b0(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        l0.n(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        m2.b.a("heightPixels: ", displayMetrics.heightPixels, f2047a0);
        return displayMetrics;
    }

    public final int c0(String str) {
        if (t0()) {
            return l0.g(str, f2048b0) ? 7 : 6;
        }
        return l0.g(str, f2048b0) ? 6 : 7;
    }

    public final WindowManager.LayoutParams d0(WindowManager.LayoutParams layoutParams) {
        float f10 = 2;
        DisplayMetrics displayMetrics = this.f2063n;
        if (displayMetrics == null) {
            l0.S("mScreenDisplay");
            displayMetrics = null;
        }
        int i10 = (int) (f10 * displayMetrics.density);
        if (i10 % 2 != 0) {
            i10++;
        }
        WindowManager.LayoutParams layoutParams2 = this.f2062i;
        if (layoutParams2 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams2 = null;
        }
        layoutParams2.width = layoutParams.width + i10;
        WindowManager.LayoutParams layoutParams3 = this.f2062i;
        if (layoutParams3 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams3 = null;
        }
        layoutParams3.height = layoutParams.height + i10;
        WindowManager.LayoutParams layoutParams4 = this.f2062i;
        if (layoutParams4 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams4 = null;
        }
        int i11 = i10 / 2;
        layoutParams4.x = layoutParams.x - i11;
        WindowManager.LayoutParams layoutParams5 = this.f2062i;
        if (layoutParams5 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams5 = null;
        }
        layoutParams5.y = layoutParams.y - i11;
        WindowManager.LayoutParams layoutParams6 = this.f2062i;
        if (layoutParams6 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams6 = null;
        }
        layoutParams6.screenOrientation = layoutParams.screenOrientation;
        WindowManager.LayoutParams layoutParams7 = this.f2062i;
        if (layoutParams7 != null) {
            return layoutParams7;
        }
        l0.S("mWindowStrokeParam");
        return null;
    }

    public final int e0(int i10) {
        if (!t0()) {
            return i10;
        }
        if (i10 == 395) {
            return 24;
        }
        return f2052f0;
    }

    public final t0<Integer, Integer> f0(String str, int i10) {
        String str2;
        int i11;
        int i12;
        Context context = getContext();
        l0.o(context, "getContext(...)");
        DisplayMetrics displayMetricsB0 = b0(context);
        int iMin = Math.min(displayMetricsB0.widthPixels, displayMetricsB0.heightPixels);
        List listR4 = h0.R4(str, new String[]{":"}, false, 0, 6, null);
        Integer numX0 = jq.d0.X0((String) listR4.get(0));
        int iIntValue = numX0 != null ? numX0.intValue() : 0;
        Integer numX1 = jq.d0.X0((String) listR4.get(1));
        int iIntValue2 = numX1 != null ? numX1.intValue() : 0;
        int iH = w4.c.h(getContext());
        this.S = iH;
        boolean z10 = iH == 0 || iH == 2;
        boolean z11 = i10 == 1 || i10 == 3;
        k4.m.e(f2047a0, "getWindowSize:pad width:" + iMin);
        k4.m.e(f2047a0, "getWindowSize:aspectRatio:" + str);
        k4.m.e(f2047a0, "calWindowPointByOrientation:isLandPad=" + z10 + ", isLandPhone=" + z11);
        double d10 = (double) iIntValue;
        int i13 = iIntValue;
        double d11 = (double) iIntValue2;
        while (d11 > 20.0d) {
            double d12 = 2;
            d11 /= d12;
            d10 /= d12;
            z10 = z10;
        }
        boolean z12 = z10;
        k4.m.e(f2047a0, "getWindowSize:preciseWidthRatio:" + d10 + ", preciseHeightRatio:" + d11);
        if (z12 && z11) {
            int iG = ((int) (((double) (w4.c.g(getContext()) + iMin)) / d11)) + 2;
            str2 = f2047a0;
            m2.b.a("getWindowSize:factor", iG, str2);
            double d13 = iG;
            i11 = (int) (d13 * d11);
            i12 = (int) (d13 * d10);
        } else {
            str2 = f2047a0;
            i11 = 0;
            i12 = 0;
        }
        if (!z12 && z11) {
            int i14 = (int) (((double) iMin) / d11);
            m2.b.a("getWindowSize:factor", i14, str2);
            double d14 = i14;
            i12 = (int) (d14 * d10);
            i11 = (int) (d14 * d11);
        }
        if (z12 && !z11) {
            int i15 = (int) (((double) ((((iMin - w4.c.i(getContext())) - w4.c.g(getContext())) - this.P) - this.Q)) / d11);
            m2.b.a("getWindowSize:factor", i15, str2);
            double d15 = i15;
            i12 = (int) (d15 * d11);
            i11 = (int) (d15 * d10);
        }
        if (!z12 && !z11) {
            int i16 = ((int) (((double) iMin) / d11)) + 2;
            m2.b.a("getWindowSize:factor", i16, str2);
            double d16 = i16;
            i12 = (int) (d16 * d11);
            i11 = (int) (d10 * d16);
        }
        String strZ = Z(i11 > i12 ? i12 : i11, i12 < i11 ? i11 : i12);
        List listR5 = h0.R4(strZ, new String[]{":"}, false, 0, 6, null);
        Integer numX2 = jq.d0.X0((String) listR5.get(0));
        int iIntValue3 = numX2 != null ? numX2.intValue() : 0;
        Integer numX3 = jq.d0.X0((String) listR5.get(1));
        int iIntValue4 = numX3 != null ? numX3.intValue() : 0;
        k4.m.e(str2, "getWindowSize:video width=" + i11 + ", video height:" + i12);
        k4.m.e(str2, "getWindowSize:newAspectRatio" + strZ + ", old:" + str);
        if (i13 / iIntValue2 > iIntValue3 / iIntValue4) {
            if (i12 > i11) {
                this.f2065v.setScaleX(1.004f);
            } else {
                this.f2065v.setScaleX(1.002f);
                this.f2065v.setScaleY(1.002f);
            }
        }
        return new t0<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @b.a({"ClickableViewAccessibility"})
    public final void g0() {
        this.f2058d.f2035p.f1962a.setOnTouchListener(new c());
    }

    public final int getWindowOrientation() {
        WindowManager.LayoutParams layoutParams = this.f2061g;
        if (layoutParams == null) {
            l0.S("mWindowParam");
            layoutParams = null;
        }
        return layoutParams.screenOrientation;
    }

    public final void h0() {
        p5.b bVar = new p5.b();
        this.f2067x = bVar;
        bVar.f();
    }

    @b.a({"ClickableViewAccessibility"})
    public final void i0() {
        ImageView imageView = this.f2058d.f2029d.f2005a;
        l0.o(imageView, "btnCircle");
        ConstraintLayout constraintLayout = this.f2058d.f2029d.f2008d;
        l0.o(constraintLayout, "windowButton");
        ConstraintLayout constraintLayout2 = this.f2058d.f2029d.f2010f;
        l0.o(constraintLayout2, "windowLayout");
        imageView.setOnTouchListener(new d(constraintLayout2, imageView, constraintLayout, this));
    }

    public final void j0() {
        m0.f12861a.Z(new e());
        this.f2058d.f2027b.addTextChangedListener(new f());
    }

    @b.a({"ClickableViewAccessibility"})
    public final void k0() {
        g0();
        n0();
        i0();
        j0();
        g gVar = new g(getContext());
        this.T = gVar;
        if (gVar.canDetectOrientation()) {
            OrientationEventListener orientationEventListener = this.T;
            if (orientationEventListener != null) {
                orientationEventListener.enable();
            }
        } else {
            k4.m.e(f2047a0, "onOrientationChanged:not support");
            this.T = null;
        }
        k4.h.a.f8959a.k(new k4.h.d() { // from class: p5.r
            @Override // k4.h.d
            public final void a(int i10, String str) {
                FloatingWindow.l0(this.f12898a, i10, str);
            }
        });
    }

    public final void m0() {
        SurfaceHolder holder = this.f2065v.getHolder();
        if (holder != null) {
            holder.addCallback(new h());
        }
    }

    @b.a({"ClickableViewAccessibility"})
    public final void n0() {
        final SurfaceView surfaceView = this.f2058d.f2032g;
        l0.o(surfaceView, "phoneScreen");
        this.f2058d.f2032g.setOnTouchListener(new View.OnTouchListener() { // from class: p5.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FloatingWindow.o0(this.f12859a, surfaceView, view, motionEvent);
            }
        });
        this.f2058d.f2032g.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: p5.n
            @Override // android.view.View.OnGenericMotionListener
            public final boolean onGenericMotion(View view, MotionEvent motionEvent) {
                return FloatingWindow.p0(surfaceView, this, view, motionEvent);
            }
        });
        this.f2058d.f2027b.setOnKeyListener(new p5.o());
    }

    @Override // android.view.View
    public void onConfigurationChanged(@os.l Configuration configuration) {
        l0.p(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        k4.m.e(f2047a0, "onConfigurationChanged");
        this.f2055a.A();
        M();
        N();
        if (this.L) {
            return;
        }
        O();
        N0();
    }

    public final void r0(LifecycleService lifecycleService) {
        ImageView imageView = this.f2058d.f2029d.f2005a;
        l0.o(imageView, "btnCircle");
        ConstraintLayout constraintLayout = this.f2058d.f2029d.f2008d;
        l0.o(constraintLayout, "windowButton");
        ConstraintLayout constraintLayout2 = this.f2058d.f2028c.f1984a;
        l0.o(constraintLayout2, "extendTip");
        LinearLayout linearLayout = this.f2058d.f2034n.f2041a;
        l0.o(linearLayout, "loadingBg");
        AnimView animView = this.f2058d.f2034n.f2042b;
        l0.o(animView, "mirrorLoading");
        this.f2055a.f2101f.observe(lifecycleService, new p(new i(constraintLayout, imageView, this)));
        this.f2055a.f2108m.observe(lifecycleService, new p(new j()));
        this.f2055a.f2107l.observe(lifecycleService, new p(new k(constraintLayout2)));
        this.f2055a.f2113r.observe(lifecycleService, new p(new l()));
        this.f2055a.f2115t.observe(lifecycleService, new p(new m(linearLayout, animView)));
        p5.i.f12841a.o(animView);
    }

    public final void s0() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        l0.o(displayMetrics, "getDisplayMetrics(...)");
        this.f2063n = displayMetrics;
        w.c cVar = this.f2064p;
        int iJ = cVar != null ? cVar.j() : 300;
        w.c cVar2 = this.f2064p;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(iJ, cVar2 != null ? cVar2.f() : 600, s.f14432g, 168, -3);
        this.f2061g = layoutParams;
        layoutParams.softInputMode = 48;
        WindowManager.LayoutParams layoutParams2 = this.f2061g;
        WindowManager.LayoutParams layoutParams3 = null;
        if (layoutParams2 == null) {
            l0.S("mWindowParam");
            layoutParams2 = null;
        }
        layoutParams2.gravity = BadgeDrawable.TOP_START;
        WindowManager.LayoutParams layoutParams4 = this.f2061g;
        if (layoutParams4 == null) {
            l0.S("mWindowParam");
            layoutParams4 = null;
        }
        layoutParams4.x = this.f2056b;
        WindowManager.LayoutParams layoutParams5 = this.f2061g;
        if (layoutParams5 == null) {
            l0.S("mWindowParam");
            layoutParams5 = null;
        }
        layoutParams5.y = this.f2057c;
        m4.a aVar = m4.a.C0275a.f10375a;
        WindowManager.LayoutParams layoutParams6 = this.f2061g;
        if (layoutParams6 == null) {
            l0.S("mWindowParam");
            layoutParams6 = null;
        }
        aVar.b(layoutParams6);
        w.c cVar3 = this.f2064p;
        int iJ2 = cVar3 != null ? cVar3.j() : 300;
        w.c cVar4 = this.f2064p;
        WindowManager.LayoutParams layoutParams7 = new WindowManager.LayoutParams(iJ2, cVar4 != null ? cVar4.f() : 600, s.f14432g, 648, -3);
        this.f2062i = layoutParams7;
        layoutParams7.gravity = BadgeDrawable.TOP_START;
        m4.a aVar2 = m4.a.C0275a.f10375a;
        WindowManager.LayoutParams layoutParams8 = this.f2062i;
        if (layoutParams8 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams8 = null;
        }
        aVar2.b(layoutParams8);
        WindowManager windowManager = this.f2059e;
        LinearLayout linearLayout = this.f2060f;
        WindowManager.LayoutParams layoutParams9 = this.f2062i;
        if (layoutParams9 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams9 = null;
        }
        windowManager.addView(linearLayout, layoutParams9);
        WindowManager windowManager2 = this.f2059e;
        WindowManager.LayoutParams layoutParams10 = this.f2061g;
        if (layoutParams10 == null) {
            l0.S("mWindowParam");
        } else {
            layoutParams3 = layoutParams10;
        }
        windowManager2.addView(this, layoutParams3);
    }

    public final boolean t0() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final void u0(@os.l byte[] bArr) {
        l0.p(bArr, "data");
        p5.b bVar = this.f2067x;
        if (bVar != null) {
            bVar.h(bArr);
        }
    }

    public final void v0(@os.l byte[] bArr) {
        l0.p(bArr, "data");
        u0 u0Var = this.f2066w;
        if (u0Var != null) {
            u0Var.v(bArr);
        }
    }

    public final void w0() {
        if (this.L) {
            this.f2055a.h();
        }
    }

    public final void x0() {
        WindowManager.LayoutParams layoutParams = this.f2061g;
        WindowManager.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            l0.S("mWindowParam");
            layoutParams = null;
        }
        if (layoutParams.x < 0) {
            WindowManager.LayoutParams layoutParams3 = this.f2061g;
            if (layoutParams3 == null) {
                l0.S("mWindowParam");
                layoutParams3 = null;
            }
            layoutParams3.x = 0;
        }
        WindowManager.LayoutParams layoutParams4 = this.f2061g;
        if (layoutParams4 == null) {
            l0.S("mWindowParam");
            layoutParams4 = null;
        }
        if (layoutParams4.y < 0) {
            WindowManager.LayoutParams layoutParams5 = this.f2061g;
            if (layoutParams5 == null) {
                l0.S("mWindowParam");
                layoutParams5 = null;
            }
            layoutParams5.y = 0;
        }
        Context context = getContext();
        l0.o(context, "getContext(...)");
        DisplayMetrics displayMetricsB0 = b0(context);
        WindowManager.LayoutParams layoutParams6 = this.f2061g;
        if (layoutParams6 == null) {
            l0.S("mWindowParam");
            layoutParams6 = null;
        }
        int i10 = layoutParams6.x;
        int i11 = displayMetricsB0.widthPixels;
        WindowManager.LayoutParams layoutParams7 = this.f2061g;
        if (layoutParams7 == null) {
            l0.S("mWindowParam");
            layoutParams7 = null;
        }
        if (i10 > i11 - layoutParams7.width) {
            WindowManager.LayoutParams layoutParams8 = this.f2061g;
            if (layoutParams8 == null) {
                l0.S("mWindowParam");
                layoutParams8 = null;
            }
            int i12 = displayMetricsB0.widthPixels;
            WindowManager.LayoutParams layoutParams9 = this.f2061g;
            if (layoutParams9 == null) {
                l0.S("mWindowParam");
                layoutParams9 = null;
            }
            layoutParams8.x = i12 - layoutParams9.width;
        }
        int i13 = displayMetricsB0.heightPixels;
        WindowManager.LayoutParams layoutParams10 = this.f2062i;
        if (layoutParams10 == null) {
            l0.S("mWindowStrokeParam");
            layoutParams10 = null;
        }
        int i14 = ((i13 - layoutParams10.height) - w4.c.i(getContext())) - w4.c.g(getContext());
        WindowManager.LayoutParams layoutParams11 = this.f2061g;
        if (layoutParams11 == null) {
            l0.S("mWindowParam");
            layoutParams11 = null;
        }
        if (layoutParams11.y > i14) {
            WindowManager.LayoutParams layoutParams12 = this.f2061g;
            if (layoutParams12 == null) {
                l0.S("mWindowParam");
            } else {
                layoutParams2 = layoutParams12;
            }
            layoutParams2.y = i14;
        }
    }

    public final void y0(@os.l jn.a<l2> aVar, @os.l jn.l<? super Integer, l2> lVar) {
        l0.p(aVar, "listener");
        l0.p(lVar, "orientationListener");
        this.f2068y = aVar;
        this.f2069z = lVar;
    }

    @b.a({"ClickableViewAccessibility"})
    public final void z0() {
        setOnTouchListener(new View.OnTouchListener() { // from class: p5.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FloatingWindow.A0(this.f12858a, view, motionEvent);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingWindow(@os.l Context context, @os.l FloatingWindowViewModel floatingWindowViewModel, int i10, int i11) {
        super(context);
        l0.p(context, "context");
        l0.p(floatingWindowViewModel, "mProjectionViewModel");
        this.f2055a = floatingWindowViewModel;
        this.f2056b = i10;
        this.f2057c = i11;
        this.f2060f = new WindowStrokeView(context, null, 0, 6, null);
        this.V = nq.t0.a(nq.k1.e());
        k4.m.e(f2047a0, "ProjectionView onCreate");
        Object systemService = context.getSystemService("window");
        l0.n(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f2059e = (WindowManager) systemService;
        floatingWindowViewModel.n(getProjectionViewEventListener());
        LifecycleService lifecycleService = (LifecycleService) context;
        PhoneFloatingWindowsBinding phoneFloatingWindowsBindingF = PhoneFloatingWindowsBinding.f(LayoutInflater.from(context), this, true);
        l0.o(phoneFloatingWindowsBindingF, "inflate(...)");
        this.f2058d = phoneFloatingWindowsBindingF;
        phoneFloatingWindowsBindingF.setLifecycleOwner(lifecycleService);
        phoneFloatingWindowsBindingF.i(floatingWindowViewModel);
        SurfaceView surfaceView = phoneFloatingWindowsBindingF.f2032g;
        l0.o(surfaceView, "phoneScreen");
        this.f2065v = surfaceView;
        r0(lifecycleService);
        s0();
        m0();
        k0();
        h0();
        C0(lifecycleService);
        D0(lifecycleService);
    }
}
