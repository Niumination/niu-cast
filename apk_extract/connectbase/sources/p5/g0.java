package p5;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.lang.ref.WeakReference;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0 f12817a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f12818b = "MirrorWindowManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f12819c = "foreground_app";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f12820d = "extend_tip";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final String f12821e = "extend_tip_count";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final String f12822f = "isShow";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12823g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12824h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12825i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12826j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12827k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.m
    public static z4.l f12828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.m
    public static WeakReference<FloatingWindow> f12829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<n2.i> f12834r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<n2.i> f12835s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static MutableLiveData<Integer> f12836t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Integer> f12837u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12838v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final MutableLiveData<Boolean> f12839w;

    static {
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        f12830n = mutableLiveData;
        f12831o = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
        f12832p = mutableLiveData2;
        f12833q = mutableLiveData2;
        MutableLiveData<n2.i> mutableLiveData3 = new MutableLiveData<>(new n2.i());
        f12834r = mutableLiveData3;
        f12835s = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>(0);
        f12836t = mutableLiveData4;
        f12837u = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(bool);
        f12838v = mutableLiveData5;
        f12839w = mutableLiveData5;
    }

    public final void a() {
        WeakReference<FloatingWindow> weakReference = f12829m;
        if (weakReference != null) {
            weakReference.clear();
        }
        f12829m = null;
    }

    public final void b(@os.l String str) {
        kn.l0.p(str, "data");
        k4.m.e(f12818b, "dealNavModeChange:" + str);
        n2.o oVar = (n2.o) k4.j.a.f8962a.a(str, n2.o.class);
        if (oVar == null) {
            k4.m.c(f12818b, "dealNavModeChange:ill param");
        } else {
            o(oVar.a());
        }
    }

    @os.l
    public final MutableLiveData<n2.i> c() {
        return f12835s;
    }

    @os.m
    public final FloatingWindow d() {
        WeakReference<FloatingWindow> weakReference = f12829m;
        k4.m.e(f12818b, "getFloatingView:floating view is null:" + ((weakReference != null ? weakReference.get() : null) == null));
        WeakReference<FloatingWindow> weakReference2 = f12829m;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    @os.m
    public final z4.l e() {
        return f12828l;
    }

    @os.l
    public final MutableLiveData<Boolean> f() {
        return f12833q;
    }

    @os.l
    public final MutableLiveData<Boolean> g() {
        return f12839w;
    }

    @os.l
    public final MutableLiveData<Boolean> h() {
        return f12831o;
    }

    @os.l
    public final MutableLiveData<Integer> i() {
        return f12837u;
    }

    public final void j(@os.l FloatingWindow floatingWindow) {
        kn.l0.p(floatingWindow, "view");
        f12829m = new WeakReference<>(floatingWindow);
    }

    public final void k(@os.l z4.l lVar) {
        kn.l0.p(lVar, "param");
        f12828l = lVar;
    }

    public final void l(@os.l String str) {
        FloatingWindow floatingWindow;
        kn.l0.p(str, "data");
        n2.i iVar = (n2.i) k4.j.a.f8962a.a(str, n2.i.class);
        if (iVar == null) {
            return;
        }
        String strD = iVar.d();
        n2.i value = f12835s.getValue();
        if (kn.l0.g(strD, value != null ? value.d() : null)) {
            return;
        }
        k4.m.e(f12818b, "updateForegroundApp:" + iVar);
        f12834r.postValue(iVar);
        if (!a5.a.f47a.c(a5.a.f54h)) {
            k4.m.e(f12818b, "is not SupportPhoneExtendPad");
            return;
        }
        if (!e5.b.a.f4068a.g(iVar.d())) {
            k4.m.e(f12818b, "is in blackList not enable reparent");
            return;
        }
        Application applicationB = SourceApplication.b();
        String strB = k4.p.a.f8971a.b(applicationB, f12819c, f12821e, hi.b.f7118g);
        kn.l0.o(strB, "getStringValueByKey(...)");
        int i10 = Integer.parseInt(strB);
        k4.m.e(f12818b, "count:" + i10);
        k4.m.e(f12818b, "SharedPreferenceUtils:" + k4.p.a.f8971a.b(applicationB, f12819c, f12820d, ""));
        if (kn.l0.g(f12822f, k4.p.a.f8971a.b(applicationB, f12819c, f12820d, "")) || i10 >= 3) {
            return;
        }
        k4.p.a.f8971a.c(applicationB, f12819c, f12820d, f12822f);
        k4.p.a.f8971a.c(applicationB, f12819c, f12821e, String.valueOf(i10 + 1));
        WeakReference<FloatingWindow> weakReference = f12829m;
        if (weakReference == null || (floatingWindow = weakReference.get()) == null) {
            return;
        }
        floatingWindow.F0();
    }

    public final void m(boolean z10) {
        if (z10) {
            f12836t.postValue(1);
        } else {
            f12836t.postValue(2);
        }
    }

    public final void n(boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        MutableLiveData<Boolean> mutableLiveData = f12838v;
        if (kn.l0.g(boolValueOf, mutableLiveData.getValue())) {
            return;
        }
        mutableLiveData.postValue(Boolean.valueOf(z10));
        o1.a.f18113a.K(z10 ? "lock" : "unlock");
    }

    public final void o(int i10) {
        boolean z10 = i10 == 2;
        Boolean boolValueOf = Boolean.valueOf(z10);
        MutableLiveData<Boolean> mutableLiveData = f12832p;
        if (kn.l0.g(boolValueOf, mutableLiveData.getValue())) {
            return;
        }
        mutableLiveData.postValue(Boolean.valueOf(z10));
    }

    public final void p(boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        MutableLiveData<Boolean> mutableLiveData = f12830n;
        if (kn.l0.g(boolValueOf, mutableLiveData.getValue())) {
            return;
        }
        mutableLiveData.postValue(Boolean.valueOf(z10));
        if (z10) {
            o1.a.f18113a.J();
        }
    }
}
