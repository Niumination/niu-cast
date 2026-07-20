package com.transsion.connectx.mirror.source.pad;

import android.R;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import jq.h0;
import kn.d0;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.l2;
import lm.v;
import n2.i;
import os.l;
import os.m;
import p5.g0;
import p5.m0;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nMirrorFullScreenActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MirrorFullScreenActivity.kt\ncom/transsion/connectx/mirror/source/pad/MirrorFullScreenActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
public final class MirrorFullScreenActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final a f2117c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f2118d = "MirrorFullScreenActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public HomeKeyReceiver f2119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2120b;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.l<i, l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(i iVar) {
            invoke2(iVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(i iVar) {
            String strD = iVar.d();
            l0.o(strD, "getPackageName(...)");
            if (h0.Q2(strD, "launcher", true)) {
                return;
            }
            MirrorFullScreenActivity.this.f2120b = 0;
        }
    }

    public static final class c extends n0 implements jn.a<l2> {
        public c() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            k4.m.e(MirrorFullScreenActivity.f2118d, "exit full screen");
            MirrorFullScreenActivity.this.setContentView(new View(MirrorFullScreenActivity.this));
            MirrorFullScreenActivity.this.finishAndRemoveTask();
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
            MirrorFullScreenActivity.this.setRequestedOrientation(i10);
        }
    }

    public static final class f implements Observer, d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f2121a;

        public f(jn.l lVar) {
            l0.p(lVar, "function");
            this.f2121a = lVar;
        }

        public final boolean equals(@m Object obj) {
            if ((obj instanceof Observer) && (obj instanceof d0)) {
                return l0.g(this.f2121a, ((d0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kn.d0
        @l
        public final v<?> getFunctionDelegate() {
            return this.f2121a;
        }

        public final int hashCode() {
            return this.f2121a.hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f2121a.invoke(obj);
        }
    }

    private final void d() {
        FloatingWindow floatingWindowD = g0.f12817a.d();
        setRequestedOrientation(floatingWindowD != null ? floatingWindowD.getWindowOrientation() : 14);
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

    public final void e() {
        g0.f12817a.getClass();
        g0.f12835s.observe(this, new f(new b()));
    }

    public final void f() {
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(e.INSTANCE);
        l5.a.a(this, homeKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), Boolean.FALSE);
        this.f2119a = homeKeyReceiver;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FloatingWindow floatingWindowD;
        String strD;
        g0 g0Var = g0.f12817a;
        g0Var.getClass();
        MutableLiveData<i> mutableLiveData = g0.f12835s;
        i value = mutableLiveData.getValue();
        Boolean boolValueOf = null;
        k4.m.e(f2118d, "MirrorWindowManager.currentMirrorForegroundApp.value?.packageName:" + (value != null ? value.d() : null));
        g0Var.getClass();
        i value2 = mutableLiveData.getValue();
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
        int i10 = this.f2120b + 1;
        this.f2120b = i10;
        if (i10 != 2 || (floatingWindowD = g0Var.d()) == null) {
            return;
        }
        floatingWindowD.w0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@m Bundle bundle) {
        super.onCreate(bundle);
        findViewById(R.id.content).setBackground(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        g0 g0Var = g0.f12817a;
        FloatingWindow floatingWindowD = g0Var.d();
        if (floatingWindowD != null) {
            ViewParent parent = floatingWindowD.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(floatingWindowD);
            }
        }
        setContentView(floatingWindowD);
        f();
        d();
        c cVar = new c();
        d dVar = new d();
        FloatingWindow floatingWindowD2 = g0Var.d();
        if (floatingWindowD2 != null) {
            floatingWindowD2.y0(cVar, dVar);
        }
        e();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k4.m.e(f2118d, "onDestroy");
        FloatingWindow floatingWindowD = g0.f12817a.d();
        if (floatingWindowD != null) {
            floatingWindowD.G0();
        }
        HomeKeyReceiver homeKeyReceiver = this.f2119a;
        if (homeKeyReceiver != null) {
            unregisterReceiver(homeKeyReceiver);
        }
        this.f2119a = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        k4.m.h(f2118d, "onStop");
    }

    public static final class e extends n0 implements jn.a<l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            k4.m.h(MirrorFullScreenActivity.f2118d, "onHomePressed");
            FloatingWindow floatingWindowD = g0.f12817a.d();
            if (floatingWindowD != null) {
                floatingWindowD.w0();
            }
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }
    }
}
