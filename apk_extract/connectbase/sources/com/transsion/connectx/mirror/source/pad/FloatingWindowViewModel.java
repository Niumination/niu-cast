package com.transsion.connectx.mirror.source.pad;

import a6.s;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.transsion.connectx.mirror.source.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.m;
import m2.b;
import p5.f0;
import p5.g0;
import p5.m0;
import w4.o1;
import z4.g;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingWindowViewModel extends ViewModel {
    public static final String A = "recent";
    public static final String B = "desktop";
    public static final String C = "shortcut";
    public static final String D = "mirror_pin";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2091v = "FloatingWindowViewModel";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2092w = "exit_fullscreen";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f2093x = "fullscreen";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f2094y = "notification_center";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f2095z = "control_center";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<List<g>> f2096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveData<List<g>> f2097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<List<String>> f2098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveData<List<String>> f2099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveData<Boolean> f2101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveData<Boolean> f2103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveData<Boolean> f2105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LiveData<Boolean> f2107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveData<Boolean> f2108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveData<Boolean> f2109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LiveData<Boolean> f2110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f2111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2112q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LiveData<Boolean> f2113r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MutableLiveData<Boolean> f2114s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LiveData<Boolean> f2115t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2116u;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public FloatingWindowViewModel() {
        MutableLiveData<List<g>> mutableLiveData = new MutableLiveData<>(new ArrayList());
        this.f2096a = mutableLiveData;
        this.f2097b = mutableLiveData;
        MutableLiveData<List<String>> mutableLiveData2 = new MutableLiveData<>(new ArrayList());
        this.f2098c = mutableLiveData2;
        this.f2099d = mutableLiveData2;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
        this.f2100e = mutableLiveData3;
        this.f2101f = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(bool);
        this.f2102g = mutableLiveData4;
        this.f2103h = mutableLiveData4;
        Boolean bool2 = Boolean.TRUE;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(bool2);
        this.f2104i = mutableLiveData5;
        this.f2105j = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(bool);
        this.f2106k = mutableLiveData6;
        this.f2107l = mutableLiveData6;
        g0 g0Var = g0.f12817a;
        g0Var.getClass();
        this.f2108m = g0.f12839w;
        g0Var.getClass();
        this.f2109n = g0.f12831o;
        g0Var.getClass();
        this.f2110o = g0.f12833q;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>(bool2);
        this.f2112q = mutableLiveData7;
        this.f2113r = mutableLiveData7;
        MutableLiveData<Boolean> mutableLiveData8 = new MutableLiveData<>(bool2);
        this.f2114s = mutableLiveData8;
        this.f2115t = mutableLiveData8;
        this.f2116u = false;
    }

    public static void v() {
        m0.f12861a.U();
        o1.a.f18113a.R();
    }

    public void A() {
        if (this.f2097b.getValue() == null) {
            return;
        }
        this.f2096a.postValue(k());
        this.f2098c.setValue(l());
    }

    public final void B(List<g> list) {
        Iterator<g> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().d().booleanValue()) {
                i10++;
            }
        }
        b.a("updateLineVisible isLineVisibleCount = ", i10, f2091v);
        z(Boolean.valueOf(i10 > 4));
    }

    public void C() {
        Boolean bool = Boolean.FALSE;
        if (bool.equals(this.f2108m.getValue())) {
            MutableLiveData<Boolean> mutableLiveData = this.f2100e;
            mutableLiveData.postValue(Boolean.valueOf(bool.equals(mutableLiveData.getValue())));
        }
        o1.a.f18113a.I();
    }

    public void D(boolean z10) {
        m.e(f2091v, "updateVideoLoading: isVisible = " + z10);
        if (!z10) {
            m();
        }
        if (Boolean.TRUE.equals(this.f2112q.getValue()) == z10) {
            return;
        }
        this.f2112q.postValue(Boolean.valueOf(z10));
    }

    public final void E(Boolean bool) {
        m.e(f2091v, "updateWindowMenuContent isFullScreen = " + bool);
        if (this.f2096a.getValue() == null) {
            return;
        }
        List<g> listK = k();
        listK.get(7).g(bool);
        B(listK);
        this.f2096a.postValue(listK);
        this.f2116u = bool.booleanValue();
    }

    public void h() {
        this.f2104i.postValue(Boolean.TRUE);
        this.f2111p.a();
        Boolean bool = Boolean.FALSE;
        E(bool);
        x(bool);
        w(f2092w);
    }

    public void i() {
        if (x(Boolean.FALSE).booleanValue()) {
            return;
        }
        j();
    }

    public void j() {
        this.f2104i.postValue(Boolean.FALSE);
        this.f2111p.f();
        E(Boolean.TRUE);
        w(f2093x);
    }

    public final List<g> k() {
        Boolean boolValueOf = Boolean.valueOf(a5.a.f47a.c(a5.a.f54h));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g(R.drawable.button_notification, s.a(R.string.pad_notification), new Runnable() { // from class: p5.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f12931a.p();
            }
        }));
        arrayList.add(new g(R.drawable.button_control_center, s.a(R.string.pad_control_center), new Runnable() { // from class: p5.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f12932a.q();
            }
        }));
        arrayList.add(new g(R.drawable.button_more_task, s.a(R.string.pad_more_task), new Runnable() { // from class: p5.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f12933a.r();
            }
        }));
        arrayList.add(new g(R.drawable.button_desktop, s.a(R.string.pad_desktop), new Runnable() { // from class: p5.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12794a.s();
            }
        }));
        int i10 = R.drawable.button_shortcut;
        Boolean bool = Boolean.FALSE;
        arrayList.add(new g(i10, "隐私界面（调试占位）", bool, new Runnable() { // from class: p5.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12805a.t();
            }
        }));
        arrayList.add(new g(R.drawable.button_window_up, s.a(R.string.pad_window_top), bool, new Runnable() { // from class: p5.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12809a.u();
            }
        }));
        arrayList.add(new g(R.drawable.button_full_screen, s.a(R.string.pad_window_full), bool, new Runnable() { // from class: p5.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12811a.i();
            }
        }));
        arrayList.add(new g(R.drawable.button_window_screen, s.a(R.string.pad_window_exit), Boolean.valueOf(this.f2116u), new Runnable() { // from class: p5.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12813a.h();
            }
        }, boolValueOf));
        arrayList.add(new g(R.drawable.button_extend_screen, s.a(R.string.phone_phone_extend), boolValueOf, new f0(), bool));
        B(arrayList);
        return arrayList;
    }

    public final List<String> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(s.a(R.string.pad_secret_protect));
        arrayList.add(s.a(R.string.pad_secret_protect_tip));
        arrayList.add(s.a(R.string.pad_screen_lock));
        arrayList.add(s.b(R.string.phone_func_tip3, s.a(R.string.phone_phone_extend)));
        return arrayList;
    }

    public void m() {
        Boolean bool = Boolean.FALSE;
        if (bool.equals(this.f2114s.getValue())) {
            return;
        }
        this.f2114s.postValue(bool);
    }

    public void n(a aVar) {
        this.f2111p = aVar;
        this.f2096a.setValue(k());
        this.f2098c.setValue(l());
    }

    public void o() {
        this.f2098c.setValue(l());
    }

    public final /* synthetic */ void p() {
        m0.f12861a.o0(2);
        x(Boolean.FALSE);
        w(f2094y);
    }

    public final /* synthetic */ void q() {
        m0.f12861a.o0(1);
        x(Boolean.FALSE);
        w(f2095z);
    }

    public final /* synthetic */ void r() {
        m0.f12861a.p0(x5.b.a(187));
        x(Boolean.FALSE);
        w(A);
    }

    public final /* synthetic */ void s() {
        m0.f12861a.p0(x5.b.a(3));
        x(Boolean.FALSE);
        w(B);
    }

    public final /* synthetic */ void t() {
        x(Boolean.FALSE);
        w(C);
    }

    public final /* synthetic */ void u() {
        x(Boolean.FALSE);
        w(D);
    }

    public final void w(String str) {
        m.e(f2091v, "recordBuriedPoint operation = " + str);
        o1.a.f18113a.H(str);
    }

    public Boolean x(Boolean bool) {
        if (bool == this.f2100e.getValue()) {
            return Boolean.FALSE;
        }
        this.f2100e.postValue(bool);
        return Boolean.TRUE;
    }

    public void y() {
        this.f2106k.postValue(Boolean.TRUE);
    }

    public final void z(Boolean bool) {
        this.f2102g.postValue(bool);
    }
}
