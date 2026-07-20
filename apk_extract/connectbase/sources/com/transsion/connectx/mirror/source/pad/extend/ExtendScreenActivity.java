package com.transsion.connectx.mirror.source.pad.extend;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.bean.PadMotionEventBean;
import com.transsion.connectx.mirror.source.databinding.ActivityPhoneExtendScreenBinding;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import com.transsion.connectx.mirror.source.pad.extend.ExtendScreenActivity;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import com.transsion.connectx.sdk.TCCPSourceApi;
import jq.h0;
import kn.d0;
import kn.l0;
import kn.n0;
import lm.l2;
import lm.v;
import n2.w;
import os.m;
import p5.g0;
import p5.m0;
import p5.u0;
import w4.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtendScreenActivity extends AppCompatActivity {
    public static final int H = 1;
    public static final int I = 0;
    public static final int J = -100;
    public static final int K = 100;

    @m
    public static ExtendScreenActivity L = null;
    public static boolean M = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final a f2136x = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final String f2137y = "ExtendSrceenActivity";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final String f2138z = "connectx.screen.cast";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityPhoneExtendScreenBinding f2139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FloatingWindowViewModel f2140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public IStreamDataListener f2141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public IStreamDataListener f2142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public jn.l<? super Integer, l2> f2143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public w f2144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m
    public w.c f2145g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HomeKeyReceiver f2146i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2147n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2148p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @m
    public u0 f2149v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @m
    public p5.b f2150w;

    public static final class a {
        public a() {
        }

        public final void a() {
            ExtendScreenActivity extendScreenActivity = ExtendScreenActivity.L;
            if (extendScreenActivity != null) {
                extendScreenActivity.finishAndRemoveTask();
            }
        }

        public final void b() {
            ExtendScreenActivity extendScreenActivity = ExtendScreenActivity.L;
            if (extendScreenActivity != null) {
                extendScreenActivity.moveTaskToBack(true);
            }
        }

        public final void c(boolean z10) {
            ExtendScreenActivity.M = z10;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends n0 implements jn.l<Boolean, l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return l2.f10208a;
        }

        public final void invoke(boolean z10) {
            ExtendScreenActivity.this.N(z10);
        }
    }

    public static final class c implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(@m Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            k4.m.e(ExtendScreenActivity.f2137y, "onTextChanged: " + ((Object) charSequence) + "， start:" + i10 + ", before:" + i11 + ", count:" + i12);
            if (i12 > i11) {
                m0.k0(m0.f12861a, charSequence.subSequence(i11 + i10, i10 + i12).toString(), 0, 2, null);
            } else {
                m0.f12861a.j0(charSequence.subSequence(i10, i12 + i10).toString(), i11);
            }
        }
    }

    public static final class d implements IStreamDataListener {
        public d() {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            k4.m.e(ExtendScreenActivity.f2137y, "mVideoStreamListener onClose");
            ExtendScreenActivity.this.finishAndRemoveTask();
            c0.b.f17991a.h0();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            c0.b.f17991a.j0();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@os.l byte[] bArr, int i10, int i11) {
            l0.p(bArr, "data");
            u0 u0Var = ExtendScreenActivity.this.f2149v;
            if (u0Var != null) {
                u0Var.v(bArr);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
        }
    }

    public static final class e implements IStreamDataListener {
        public e() {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(@os.l byte[] bArr, int i10, int i11) {
            l0.p(bArr, "data");
            p5.b bVar = ExtendScreenActivity.this.f2150w;
            if (bVar != null) {
                bVar.h(bArr);
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
        }
    }

    public static final class f extends n0 implements jn.l<Integer, l2> {
        public f() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Integer num) {
            invoke(num.intValue());
            return l2.f10208a;
        }

        public final void invoke(int i10) {
            ExtendScreenActivity.this.v(i10);
        }
    }

    public static final class g extends n0 implements jn.l<Boolean, l2> {
        public g() {
            super(1);
        }

        public static final void b(ExtendScreenActivity extendScreenActivity) {
            l0.p(extendScreenActivity, "this$0");
            FloatingWindowViewModel floatingWindowViewModel = extendScreenActivity.f2140b;
            if (floatingWindowViewModel == null) {
                l0.S("mProjectionViewModel");
                floatingWindowViewModel = null;
            }
            floatingWindowViewModel.D(false);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            k4.m.e(ExtendScreenActivity.f2137y, "updateLockScreenVisible: " + bool);
            if (bool.booleanValue()) {
                return;
            }
            FloatingWindowViewModel floatingWindowViewModel = ExtendScreenActivity.this.f2140b;
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = null;
            if (floatingWindowViewModel == null) {
                l0.S("mProjectionViewModel");
                floatingWindowViewModel = null;
            }
            floatingWindowViewModel.D(true);
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding2 = ExtendScreenActivity.this.f2139a;
            if (activityPhoneExtendScreenBinding2 == null) {
                l0.S("mBinding");
            } else {
                activityPhoneExtendScreenBinding = activityPhoneExtendScreenBinding2;
            }
            FrameLayout frameLayout = activityPhoneExtendScreenBinding.f1951a;
            final ExtendScreenActivity extendScreenActivity = ExtendScreenActivity.this;
            frameLayout.postDelayed(new Runnable() { // from class: q5.e
                @Override // java.lang.Runnable
                public final void run() {
                    ExtendScreenActivity.g.b(extendScreenActivity);
                }
            }, 1000L);
        }
    }

    public static final class h extends n0 implements jn.l<Boolean, l2> {
        public h() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool) {
            invoke2(bool);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = ExtendScreenActivity.this.f2139a;
            if (activityPhoneExtendScreenBinding == null) {
                l0.S("mBinding");
                activityPhoneExtendScreenBinding = null;
            }
            AnimView animView = activityPhoneExtendScreenBinding.f1953c.f2021b;
            l0.o(animView, "mirrorLoading");
            l0.m(bool);
            if (!bool.booleanValue()) {
                animView.a();
                return;
            }
            animView.setLoop(Integer.MAX_VALUE);
            AssetManager assets = ExtendScreenActivity.this.getResources().getAssets();
            l0.o(assets, "getAssets(...)");
            animView.f(assets, "pad/load/video.mp4");
        }
    }

    public static final class i implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Runnable f2153a;

        public i() {
            this.f2153a = new Runnable() { // from class: q5.f
                @Override // java.lang.Runnable
                public final void run() {
                    ExtendScreenActivity.i.b(extendScreenActivity);
                }
            };
        }

        public static final void b(ExtendScreenActivity extendScreenActivity) {
            l0.p(extendScreenActivity, "this$0");
            FloatingWindowViewModel floatingWindowViewModel = extendScreenActivity.f2140b;
            if (floatingWindowViewModel == null) {
                l0.S("mProjectionViewModel");
                floatingWindowViewModel = null;
            }
            floatingWindowViewModel.D(false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@os.l SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            l0.p(surfaceHolder, "holder");
            m0.f12861a.W();
            k4.m.e(ExtendScreenActivity.f2137y, "surfaceChanged: width:" + i11 + "; height:" + i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@os.l SurfaceHolder surfaceHolder) {
            l0.p(surfaceHolder, "holder");
            k4.m.e(ExtendScreenActivity.f2137y, "surfaceCreated");
            u0 u0Var = ExtendScreenActivity.this.f2149v;
            if (u0Var != null) {
                ExtendScreenActivity extendScreenActivity = ExtendScreenActivity.this;
                u0Var.F(surfaceHolder.getSurface());
                ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = extendScreenActivity.f2139a;
                if (activityPhoneExtendScreenBinding == null) {
                    l0.S("mBinding");
                    activityPhoneExtendScreenBinding = null;
                }
                activityPhoneExtendScreenBinding.f1951a.postDelayed(this.f2153a, 1000L);
                return;
            }
            ExtendScreenActivity.this.f2149v = new u0(surfaceHolder.getSurface());
            u0 u0Var2 = ExtendScreenActivity.this.f2149v;
            if (u0Var2 != null) {
                u0Var2.B(this.f2153a);
            }
            ExtendScreenActivity extendScreenActivity2 = ExtendScreenActivity.this;
            u0 u0Var3 = extendScreenActivity2.f2149v;
            if (u0Var3 != null) {
                w.c cVar = extendScreenActivity2.f2145g;
                int iJ = cVar != null ? cVar.j() : w4.c.f17970e;
                w.c cVar2 = ExtendScreenActivity.this.f2145g;
                u0Var3.I(iJ, cVar2 != null ? cVar2.f() : 1400, 0);
            }
            ExtendScreenActivity.this.y();
            m0 m0Var = m0.f12861a;
            ExtendScreenActivity extendScreenActivity3 = ExtendScreenActivity.this;
            m0Var.b0(extendScreenActivity3.f2141c, extendScreenActivity3.f2142d);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@os.l SurfaceHolder surfaceHolder) {
            l0.p(surfaceHolder, "holder");
            k4.m.e(ExtendScreenActivity.f2137y, "surfaceDestroyed");
            u0 u0Var = ExtendScreenActivity.this.f2149v;
            if (u0Var != null) {
                u0Var.D();
            }
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = ExtendScreenActivity.this.f2139a;
            if (activityPhoneExtendScreenBinding == null) {
                l0.S("mBinding");
                activityPhoneExtendScreenBinding = null;
            }
            activityPhoneExtendScreenBinding.f1951a.removeCallbacks(this.f2153a);
        }
    }

    public static final class j extends n0 implements jn.l<n2.i, l2> {
        public j() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(n2.i iVar) {
            invoke2(iVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(n2.i iVar) {
            String strD;
            if (iVar == null || (strD = iVar.d()) == null || h0.Q2(strD, "launcher", true)) {
                return;
            }
            ExtendScreenActivity.this.f2147n = 0;
        }
    }

    public static final class k extends n0 implements jn.a<l2> {
        public static final k INSTANCE = new k();

        public k() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            k4.m.h(ExtendScreenActivity.f2137y, "onHomePressed");
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }
    }

    public static final class l implements Observer, d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f2155a;

        public l(jn.l lVar) {
            l0.p(lVar, "function");
            this.f2155a = lVar;
        }

        public final boolean equals(@m Object obj) {
            if ((obj instanceof Observer) && (obj instanceof d0)) {
                return l0.g(this.f2155a, ((d0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kn.d0
        @os.l
        public final v<?> getFunctionDelegate() {
            return this.f2155a;
        }

        public final int hashCode() {
            return this.f2155a.hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f2155a.invoke(obj);
        }
    }

    public static final boolean D(ExtendScreenActivity extendScreenActivity, SurfaceView surfaceView, View view, MotionEvent motionEvent) {
        l0.p(extendScreenActivity, "this$0");
        l0.p(surfaceView, "$surfaceView");
        FloatingWindowViewModel floatingWindowViewModel = extendScreenActivity.f2140b;
        if (floatingWindowViewModel == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel = null;
        }
        Boolean boolX = floatingWindowViewModel.x(Boolean.FALSE);
        l0.o(boolX, "setMenuVisible(...)");
        if (boolX.booleanValue()) {
            return true;
        }
        k4.m.e(f2137y, "onTouch surfaceView event: " + motionEvent + ", width:" + surfaceView.getWidth() + ", height:" + surfaceView.getHeight() + ",mIsPadLandAndPhoneVertical:" + extendScreenActivity.f2148p);
        m0 m0Var = m0.f12861a;
        PadMotionEventBean.a aVar = PadMotionEventBean.CREATOR;
        l0.m(motionEvent);
        m0Var.n0(aVar.b(motionEvent, surfaceView.getWidth(), surfaceView.getHeight(), extendScreenActivity.f2148p, 2).o());
        return true;
    }

    public static final boolean E(SurfaceView surfaceView, ExtendScreenActivity extendScreenActivity, View view, MotionEvent motionEvent) {
        l0.p(surfaceView, "$surfaceView");
        l0.p(extendScreenActivity, "this$0");
        k4.m.c(f2137y, "OnGenericMotionListener: " + motionEvent);
        m0 m0Var = m0.f12861a;
        PadMotionEventBean.a aVar = PadMotionEventBean.CREATOR;
        l0.m(motionEvent);
        m0Var.n0(aVar.b(motionEvent, surfaceView.getWidth(), surfaceView.getHeight(), extendScreenActivity.f2148p, 2).o());
        return extendScreenActivity.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    public static final boolean F(View view, int i10, KeyEvent keyEvent) {
        k4.m.e(f2137y, "OnKeyListener: " + i10 + ", " + keyEvent);
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

    private final void G() {
        B();
        C();
        z();
        x();
    }

    private final void H() {
        setRequestedOrientation(-1);
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().addFlags(128);
        WindowInsetsController insetsController = getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.hide(WindowInsets.Type.statusBars());
        }
        if (insetsController != null) {
            insetsController.hide(WindowInsets.Type.navigationBars());
        }
        if (insetsController == null) {
            return;
        }
        insetsController.setSystemBarsBehavior(2);
    }

    private final void I() {
        g0.f12817a.getClass();
        g0.f12835s.observe(this, new l(new j()));
    }

    private final void J() {
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(k.INSTANCE);
        l5.a.a(this, homeKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), Boolean.FALSE);
        this.f2146i = homeKeyReceiver;
    }

    public static final void O(boolean z10, ExtendScreenActivity extendScreenActivity) {
        l0.p(extendScreenActivity, "this$0");
        try {
            k4.m.e(f2137y, "updateInputShow:" + z10);
            InputMethodManager inputMethodManager = (InputMethodManager) extendScreenActivity.getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = null;
            if (z10) {
                ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding2 = extendScreenActivity.f2139a;
                if (activityPhoneExtendScreenBinding2 == null) {
                    l0.S("mBinding");
                } else {
                    activityPhoneExtendScreenBinding = activityPhoneExtendScreenBinding2;
                }
                activityPhoneExtendScreenBinding.f1952b.requestFocus();
                return;
            }
            if (inputMethodManager != null) {
                ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding3 = extendScreenActivity.f2139a;
                if (activityPhoneExtendScreenBinding3 == null) {
                    l0.S("mBinding");
                    activityPhoneExtendScreenBinding3 = null;
                }
                inputMethodManager.hideSoftInputFromWindow(activityPhoneExtendScreenBinding3.f1952b.getWindowToken(), 0);
            }
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding4 = extendScreenActivity.f2139a;
            if (activityPhoneExtendScreenBinding4 == null) {
                l0.S("mBinding");
                activityPhoneExtendScreenBinding4 = null;
            }
            activityPhoneExtendScreenBinding4.f1952b.clearFocus();
            ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding5 = extendScreenActivity.f2139a;
            if (activityPhoneExtendScreenBinding5 == null) {
                l0.S("mBinding");
            } else {
                activityPhoneExtendScreenBinding = activityPhoneExtendScreenBinding5;
            }
            activityPhoneExtendScreenBinding.f1952b.setText("");
        } catch (Exception e10) {
            k4.m.c(f2137y, "updateInputShow:" + e10.getMessage());
            k4.m.d(f2137y, e10);
        }
    }

    public final void A(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("video_info");
        this.f2145g = (w.c) k4.j.a.f8962a.a(k4.j.a.f8962a.f(stringExtra, cb.b.c.f1411r), w.c.class);
        w wVar = (w) k4.j.a.f8962a.a(stringExtra, w.class);
        this.f2144f = wVar;
        if (wVar == null) {
            k4.m.c(f2137y, "initParam: video info is null");
            return;
        }
        k4.m.e(f2137y, "initParam: video info:" + this.f2145g);
    }

    public final void B() {
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = this.f2139a;
        if (activityPhoneExtendScreenBinding == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding = null;
        }
        SurfaceHolder holder = activityPhoneExtendScreenBinding.f1954d.getHolder();
        if (holder != null) {
            holder.addCallback(new i());
        }
    }

    @b.a({"ClickableViewAccessibility"})
    public final void C() {
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = this.f2139a;
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding2 = null;
        if (activityPhoneExtendScreenBinding == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding = null;
        }
        final SurfaceView surfaceView = activityPhoneExtendScreenBinding.f1954d;
        l0.o(surfaceView, "phoneScreen");
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding3 = this.f2139a;
        if (activityPhoneExtendScreenBinding3 == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding3 = null;
        }
        activityPhoneExtendScreenBinding3.f1954d.setOnTouchListener(new View.OnTouchListener() { // from class: q5.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ExtendScreenActivity.D(this.f13847a, surfaceView, view, motionEvent);
            }
        });
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding4 = this.f2139a;
        if (activityPhoneExtendScreenBinding4 == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding4 = null;
        }
        activityPhoneExtendScreenBinding4.f1954d.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: q5.c
            @Override // android.view.View.OnGenericMotionListener
            public final boolean onGenericMotion(View view, MotionEvent motionEvent) {
                return ExtendScreenActivity.E(surfaceView, this, view, motionEvent);
            }
        });
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding5 = this.f2139a;
        if (activityPhoneExtendScreenBinding5 == null) {
            l0.S("mBinding");
        } else {
            activityPhoneExtendScreenBinding2 = activityPhoneExtendScreenBinding5;
        }
        activityPhoneExtendScreenBinding2.f1952b.setOnKeyListener(new q5.d());
    }

    public final synchronized void K(ExtendScreenActivity extendScreenActivity) {
        try {
            k4.m.e(f2137y, "resetActivity");
            ExtendScreenActivity extendScreenActivity2 = L;
            if (extendScreenActivity2 != null) {
                extendScreenActivity2.finishAndRemoveTask();
            }
            L = extendScreenActivity;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @b.a({"SoonBlockedPrivateApi", "BlockedPrivateApi"})
    public final void L(boolean z10) {
    }

    public final void M() {
        k4.m.e(f2137y, "startCastDialog: " + M);
        if (M) {
            startActivity(new Intent("com.transsion.iotservice.CAST_CONTROL_DIALOG"));
        }
    }

    public final void N(final boolean z10) {
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = this.f2139a;
        if (activityPhoneExtendScreenBinding == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding = null;
        }
        activityPhoneExtendScreenBinding.f1952b.post(new Runnable() { // from class: q5.a
            @Override // java.lang.Runnable
            public final void run() {
                ExtendScreenActivity.O(z10, this);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String strD;
        g0 g0Var = g0.f12817a;
        g0Var.getClass();
        MutableLiveData<n2.i> mutableLiveData = g0.f12835s;
        n2.i value = mutableLiveData.getValue();
        Boolean boolValueOf = null;
        k4.m.e(f2137y, "MirrorWindowManager.currentMirrorForegroundApp.value?.packageName:" + (value != null ? value.d() : null));
        g0Var.getClass();
        n2.i value2 = mutableLiveData.getValue();
        if (value2 != null && (strD = value2.d()) != null) {
            boolValueOf = Boolean.valueOf(h0.Q2(strD, "launcher", true));
        }
        if (!l0.g(boolValueOf, Boolean.TRUE)) {
            m0 m0Var = m0.f12861a;
            byte[] bArrA = x5.b.a(4);
            l0.o(bArrA, "createKeyEventByte(...)");
            m0Var.p0(bArrA);
            return;
        }
        int i10 = this.f2147n + 1;
        this.f2147n = i10;
        if (i10 == 2) {
            m0.f12861a.v();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@os.l Configuration configuration) {
        l0.p(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        u(configuration.orientation);
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = this.f2139a;
        if (activityPhoneExtendScreenBinding == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding = null;
        }
        activityPhoneExtendScreenBinding.f1953c.f2020a.setBackgroundColor(getResources().getColor(R.color.pad_action_bar));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@m Bundle bundle) {
        super.onCreate(bundle);
        k4.m.e(f2137y, "onCreate");
        K(this);
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        }
        FloatingWindowViewModel floatingWindowViewModel = (FloatingWindowViewModel) new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FloatingWindowViewModel.class);
        floatingWindowViewModel.o();
        this.f2140b = floatingWindowViewModel;
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_phone_extend_screen);
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = (ActivityPhoneExtendScreenBinding) contentView;
        FloatingWindowViewModel floatingWindowViewModel2 = this.f2140b;
        if (floatingWindowViewModel2 == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel2 = null;
        }
        activityPhoneExtendScreenBinding.i(floatingWindowViewModel2);
        activityPhoneExtendScreenBinding.setLifecycleOwner(this);
        l0.o(contentView, "apply(...)");
        this.f2139a = activityPhoneExtendScreenBinding;
        A(getIntent());
        G();
        J();
        H();
        I();
        w();
        M();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k4.m.e(f2137y, "onDestroy");
        u5.c.f16204a.a(false);
        K(null);
        HomeKeyReceiver homeKeyReceiver = this.f2146i;
        if (homeKeyReceiver == null) {
            l0.S("mHomeKeyReceiver");
            homeKeyReceiver = null;
        }
        unregisterReceiver(homeKeyReceiver);
        this.f2144f = null;
        u0 u0Var = this.f2149v;
        if (u0Var != null) {
            u0Var.C();
        }
        p5.b bVar = this.f2150w;
        if (bVar != null) {
            bVar.j();
        }
        this.f2141c = null;
        this.f2142d = null;
        m0.f12861a.t(z4.e.f21818e);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        k4.m.h(f2137y, "onStart: " + getResources().getConfiguration().orientation);
        FloatingWindowViewModel floatingWindowViewModel = this.f2140b;
        if (floatingWindowViewModel == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel = null;
        }
        floatingWindowViewModel.D(true);
        u(getResources().getConfiguration().orientation);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        k4.m.h(f2137y, "onStop");
    }

    public final void u(int i10) {
        m2.b.a("changeOrientation: ", i10, f2137y);
        FloatingWindowViewModel floatingWindowViewModel = this.f2140b;
        if (floatingWindowViewModel == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel = null;
        }
        floatingWindowViewModel.D(true);
        u0 u0Var = this.f2149v;
        if (u0Var != null) {
            u0Var.E(0);
        }
        m0.f12861a.w0(Integer.valueOf(getResources().getConfiguration().orientation));
    }

    public final void v(int i10) {
        m2.b.a("orientation: ", i10, f2137y);
        this.f2148p = i10 == 3;
        if (i10 == -100) {
            k4.m.e(f2137y, "screen_orientation_landscape");
            setRequestedOrientation(6);
        } else {
            if (i10 != 100) {
                return;
            }
            k4.m.e(f2137y, "screen_orientation_unspecified");
            setRequestedOrientation(-1);
        }
    }

    public final void w() {
        p5.b bVar = new p5.b();
        this.f2150w = bVar;
        bVar.f();
    }

    public final void x() {
        m0.f12861a.Z(new b());
        ActivityPhoneExtendScreenBinding activityPhoneExtendScreenBinding = this.f2139a;
        if (activityPhoneExtendScreenBinding == null) {
            l0.S("mBinding");
            activityPhoneExtendScreenBinding = null;
        }
        activityPhoneExtendScreenBinding.f1952b.addTextChangedListener(new c());
    }

    public final void y() {
        this.f2141c = new d();
        this.f2142d = new e();
        f fVar = new f();
        this.f2143e = fVar;
        m0.f12861a.a0(fVar);
    }

    public final void z() {
        FloatingWindowViewModel floatingWindowViewModel = this.f2140b;
        FloatingWindowViewModel floatingWindowViewModel2 = null;
        if (floatingWindowViewModel == null) {
            l0.S("mProjectionViewModel");
            floatingWindowViewModel = null;
        }
        floatingWindowViewModel.f2108m.observe(this, new l(new g()));
        FloatingWindowViewModel floatingWindowViewModel3 = this.f2140b;
        if (floatingWindowViewModel3 == null) {
            l0.S("mProjectionViewModel");
        } else {
            floatingWindowViewModel2 = floatingWindowViewModel3;
        }
        floatingWindowViewModel2.f2113r.observe(this, new l(new h()));
    }
}
