package h9;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.SurfaceControl;
import com.transsion.hubsdk.api.app.TranRootTaskInfo;
import com.transsion.hubsdk.api.window.TranTaskSnapshot;
import ic.f1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7042c = "j";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7043d = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f1 f7044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.k f7045b;

    public interface a {
        void a(int i10, SurfaceControl.Transaction transaction);
    }

    public List<String> A() {
        return E(fc.b.a.H).I0();
    }

    @yb.a(level = 3)
    public void A0(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("illegal parameter list");
        }
        E(fc.b.a.f5988h).V(list);
    }

    public int B(String str) {
        return E(fc.b.a.f5985e).T0(str);
    }

    @yb.a(level = 1)
    public void B0(String str, List<String> list) {
        if (list == null || str == null) {
            throw new IllegalArgumentException("illegal parameters");
        }
        E(fc.b.a.f5988h).W(str, list);
    }

    @yb.a(level = 1)
    public List<ActivityManager.RecentTaskInfo> C(int i10, int i11, int i12) {
        return E(fc.b.a.f5981a).L0(i10, i11, i12);
    }

    public void C0(int i10, int i11) {
        E(fc.b.a.H).m(i10, i11);
    }

    public TranRootTaskInfo D(int i10, int i11, int i12) {
        return E(fc.b.a.f5987g).M0(i10, i11, i12);
    }

    @yb.a(level = 1)
    public void D0(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        E(fc.b.a.f5989i).A0(bundle);
    }

    public bf.g E(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7042c, "TranThubActivityTaskManager");
            f1 f1Var = this.f7044a;
            if (f1Var != null) {
                return f1Var;
            }
            f1 f1Var2 = new f1();
            this.f7044a = f1Var2;
            return f1Var2;
        }
        dc.e.f(f7042c, "TranAospActivityTaskManager");
        p6.k kVar = this.f7045b;
        if (kVar != null) {
            return kVar;
        }
        p6.k kVar2 = new p6.k();
        this.f7045b = kVar2;
        return kVar2;
    }

    @yb.a(level = 3)
    public void E0(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("illegal parameter list");
        }
        E(fc.b.a.f5988h).H0(list);
    }

    public int F(String str) {
        return E(fc.b.a.f5985e).z(str);
    }

    @yb.a(level = 1)
    public void F0(boolean z10, int i10) {
        E(fc.b.a.f5988h).w0(z10, i10);
    }

    public Rect G(int i10) {
        return E(fc.b.a.f5989i).I(i10);
    }

    public void G0(String str, int i10, int i11, int i12) {
        E(fc.b.a.f5988h).N(str, i10, i11, i12);
    }

    public int H(String str) {
        return E(fc.b.a.f5985e).E(str);
    }

    public void H0(String str, int i10, int i11, int i12, int i13) {
        E(fc.b.a.f5988h).U0(str, i10, i11, i12, i13);
    }

    public int I(String str, int i10) {
        return E(fc.b.a.H).y(str, i10);
    }

    @yb.a(level = 1)
    public void I0(boolean z10, int i10) {
        E(fc.b.a.f5989i).P0(z10, i10);
    }

    @yb.a(level = 1)
    public int J(int i10) {
        return E(fc.b.a.f5988h).K0(i10);
    }

    public void J0(boolean z10) {
        E(fc.b.a.H).G(z10);
    }

    public List<ActivityManager.RunningTaskInfo> K(int i10, boolean z10, boolean z11) {
        return E(fc.b.a.f5988h).q(i10, z10, z11);
    }

    public void K0(boolean z10, int i10) {
        E(fc.b.a.f5985e).h(z10, i10);
    }

    @yb.a(level = 1)
    public ComponentName L() {
        dc.e.f(f7042c, "tran getTopActivityComponent");
        return E(fc.b.a.f5981a).h0();
    }

    @yb.a(level = 1)
    public TranTaskSnapshot L0(int i10, boolean z10) {
        return E(fc.b.a.f5991k).Q0(i10, z10);
    }

    public Bundle M() {
        return E(fc.b.a.G).d0();
    }

    public boolean M0(int i10) {
        if (i10 >= 0) {
            return E(fc.b.a.f5985e).j0(i10);
        }
        throw new IllegalArgumentException("invalid task id");
    }

    @yb.a(level = 1)
    public ActivityManager.RunningTaskInfo N(int i10) {
        if (i10 >= Integer.MAX_VALUE || i10 <= Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Illegal parameters");
        }
        return E(fc.b.a.f5988h).y0(i10);
    }

    public boolean N0(Configuration configuration) {
        if (configuration != null) {
            return E(fc.b.a.f5993m).P(configuration);
        }
        throw new IllegalArgumentException("Configuration is null.");
    }

    public boolean O(String str) {
        return E(fc.b.a.f5985e).o0(str);
    }

    public void O0(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(ob.a.f12167l);
        }
        E(fc.b.a.F).z0(str, z10);
    }

    public boolean P() {
        return E(fc.b.a.f5987g).u0();
    }

    @yb.a(level = 1)
    public void P0(int i10) {
        if (i10 >= Integer.MAX_VALUE || i10 <= Integer.MIN_VALUE) {
            throw new IllegalArgumentException("taskID is out of bounds");
        }
        E(fc.b.a.f5988h).S0(i10);
    }

    public Rect Q(int i10) {
        if (i10 == -1 || i10 == 0 || i10 == 1) {
            return E(fc.b.a.f5985e).r0(i10);
        }
        throw new IllegalArgumentException("invalid orientation type");
    }

    public void R(int i10, int i11) {
        E(fc.b.a.H).t0(i10, i11);
    }

    public void S() {
        E(fc.b.a.A).O();
    }

    @yb.a(level = 1)
    public void T(int i10, int i11) {
        E(fc.b.a.f5988h).D(i10, i11);
    }

    @yb.a(level = 1)
    public void U(Rect rect) {
        if (rect == null) {
            throw new IllegalArgumentException("illegal parameter rect");
        }
        E(fc.b.a.f5988h).B0(rect);
    }

    public void V(SurfaceControl surfaceControl, String str) {
        if (surfaceControl == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appSurface or packageName is null");
        }
        E(fc.b.a.A).s0(surfaceControl, str);
    }

    @yb.a(level = 1)
    public void W() {
        E(fc.b.a.f5988h).W0();
    }

    @yb.a(level = 1)
    public void X(int i10, Rect rect) {
        if (rect == null) {
            throw new IllegalArgumentException("illegal parameter location");
        }
        E(fc.b.a.f5988h).B(i10, rect);
    }

    public void Y(int i10, Rect rect, a aVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException("invalid task id");
        }
        E(fc.b.a.f5985e).G0(i10, rect, aVar);
    }

    @yb.a(level = 1)
    public void Z(int i10, int i11, int i12, Rect rect, a aVar) {
        if (rect == null) {
            throw new IllegalArgumentException("invalid startBound");
        }
        E(fc.b.a.f5989i).c0(i10, i11, i12, rect, aVar);
    }

    public boolean a(String str) {
        if (str != null) {
            return E(fc.b.a.f5985e).n(str);
        }
        throw new IllegalArgumentException("pkgName cannot be null");
    }

    public Bundle a0(String str, Bundle bundle) {
        return E(fc.b.a.H).N0(str, bundle);
    }

    @yb.a(level = 1)
    public void b(SurfaceControl surfaceControl) {
        if (surfaceControl == null) {
            throw new IllegalArgumentException("illegal parameter surface control");
        }
        E(fc.b.a.f5988h).E0(surfaceControl);
    }

    @yb.a(level = 2)
    public boolean b0() {
        dc.e.f(f7042c, "tran inMultiWindowMode");
        return E(fc.b.a.f5981a).S();
    }

    public void c(int i10) {
        E(fc.b.a.A).T(i10);
    }

    @yb.a(level = 1)
    public boolean c0() {
        dc.e.f(f7042c, "tran isIMEShowing");
        return E(fc.b.a.f5981a).o();
    }

    @yb.a(level = 1)
    public void d(int i10) {
        if (i10 < 0 || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("illegal parameter scene");
        }
        E(fc.b.a.f5989i).F(i10);
    }

    @yb.a(level = 1)
    public boolean d0() {
        return E(fc.b.a.f5988h).a0();
    }

    @yb.a(level = 1)
    public void e(int i10) {
        if (i10 < 0 || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("illegal parameter scene");
        }
        E(fc.b.a.f5988h).f0(i10);
    }

    @yb.a(level = 1)
    public boolean e0() {
        return E(fc.b.a.f5988h).R0();
    }

    public void f(int i10) {
        E(fc.b.a.A).L(i10);
    }

    @yb.a(level = 1)
    public boolean f0() {
        return E(fc.b.a.f5989i).V0();
    }

    public boolean g(String str, boolean z10, boolean z11, long j10) {
        if (!fc.a.g()) {
            return false;
        }
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (j10 < Long.MIN_VALUE || j10 > Long.MAX_VALUE) {
            throw new IllegalArgumentException("delayTime is wrong");
        }
        return E(fc.b.a.f6004x).w(str, z10, z11, j10);
    }

    public boolean g0() {
        return E(fc.b.a.f5989i).d();
    }

    @yb.a(level = 2)
    public void h() {
        E(fc.b.a.f5988h).g0();
    }

    public boolean h0() {
        return E(fc.b.a.f5985e).U();
    }

    public void i(int i10) {
        E(fc.b.a.H).r(i10);
    }

    public boolean i0(String str, String str2) {
        return E(fc.b.a.f5985e).e0(str, str2);
    }

    public List<ActivityManager.RunningTaskInfo> j() {
        return E(fc.b.a.f6001u).R();
    }

    public void j0(boolean z10) {
        E(fc.b.a.f6001u).F0(z10);
    }

    public List<TranRootTaskInfo> k(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("displayId is wrong");
        }
        return E(fc.b.a.f5992l).m0(i10);
    }

    public void k0(boolean z10) {
        E(fc.b.a.F).p0(z10);
    }

    @yb.a(level = 1)
    public SurfaceControl l() {
        return E(fc.b.a.f5988h).C();
    }

    public void l0(boolean z10) {
        E(fc.b.a.F).J(z10);
    }

    @yb.a(level = 1)
    public SurfaceControl m(int i10, int i11, int i12, int i13, boolean z10) {
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("illegal parameters width or height");
        }
        return E(fc.b.a.f5988h).p(i10, i11, i12, i13, z10);
    }

    public void m0(boolean z10) {
        if (fc.a.f()) {
            E(fc.b.a.f6006z).b0(z10);
        }
    }

    @yb.a(level = 1)
    public String n() {
        dc.e.f(f7042c, "tran getFocusedWinPkgName");
        return E(fc.b.a.f5981a).v();
    }

    public void n0(IBinder iBinder) {
        E(fc.b.a.H).k0(iBinder);
    }

    public int o(String str) {
        return E(fc.b.a.f5985e).Z(str);
    }

    @yb.a(level = 1)
    public void o0(SurfaceControl surfaceControl) {
        if (surfaceControl == null) {
            throw new IllegalArgumentException("illegal parameter surface control");
        }
        E(fc.b.a.f5988h).K(surfaceControl);
    }

    public int p(String str, String str2) {
        return E(fc.b.a.f5985e).n0(str, str2);
    }

    @yb.a(level = 2)
    public void p0(int[] iArr) {
        E(fc.b.a.f5981a).l0(iArr);
    }

    public HardwareBuffer q(int i10, boolean z10) {
        if (i10 < Integer.MIN_VALUE || i10 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("invalid task id");
        }
        return E(fc.b.a.f5985e).i0(i10, z10);
    }

    @yb.a(level = 2)
    public boolean q0(int i10) {
        dc.e.f(f7042c, "tran removeTask");
        return E(fc.b.a.f5981a).x(i10);
    }

    public int r() {
        return E(fc.b.a.f5989i).O0();
    }

    public void r0(int i10, int i11, boolean z10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("illegal parameter fromDisplayId");
        }
        if (i11 <= Integer.MIN_VALUE || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("illegal parameter destDisplayId");
        }
        E(fc.b.a.f5989i).k(i10, i11, z10);
    }

    @yb.a(level = 1)
    public String s(int i10, int i11) {
        return E(fc.b.a.f5988h).J0(i10, i11);
    }

    public void s0() {
        E(fc.b.a.H).v0();
    }

    @yb.a(level = 1)
    public ActivityManager.RunningTaskInfo t(int i10, int i11) {
        return E(fc.b.a.f5988h).Y(i10, i11);
    }

    public void t0(h9.a aVar, boolean z10) {
        E(fc.b.a.f5981a).M(aVar, z10);
    }

    public List<String> u() {
        return E(fc.b.a.f5985e).u();
    }

    public void u0(int i10, String str, boolean z10) {
        if (fc.a.f()) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("scene is null");
            }
            if (i10 < 0) {
                throw new IllegalArgumentException("type is wrong");
            }
            E(fc.b.a.C).X(i10, str, z10);
        }
    }

    public Rect v() {
        return E(fc.b.a.A).s();
    }

    @yb.a(level = 1)
    public void v0(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null");
        }
        E(fc.b.a.f5989i).C0(list);
    }

    public Bundle w(String str) {
        return E(fc.b.a.f5987g).D0(str);
    }

    @yb.a(level = 2)
    public void w0(SurfaceControl surfaceControl, float[] fArr, float[] fArr2, int i10) {
        if (surfaceControl == null || fArr == null || fArr2 == null) {
            throw new IllegalArgumentException("illegal parameters");
        }
        E(fc.b.a.f5988h).x0(surfaceControl, fArr, fArr2, i10);
    }

    public String x() {
        return E(fc.b.a.f5985e).A();
    }

    public void x0(int i10, String str, boolean z10) {
        if (fc.a.f()) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("jankName is null");
            }
            if (i10 < 0) {
                throw new IllegalArgumentException("type is wrong");
            }
            E(fc.b.a.f6006z).H(i10, str, z10);
        }
    }

    @yb.a(level = 1)
    public boolean y(int i10) {
        return E(fc.b.a.f5988h).t(i10);
    }

    public void y0(boolean z10, Bundle bundle) {
        E(fc.b.a.H).Q(z10, bundle);
    }

    public boolean z(String str) {
        return E(fc.b.a.f5985e).q0(str);
    }

    @yb.a(level = 1)
    public void z0(int i10, boolean z10) {
        if (i10 >= Integer.MAX_VALUE || i10 <= Integer.MIN_VALUE) {
            throw new IllegalArgumentException("multiWindowId has exceeded the maximum value ");
        }
        E(fc.b.a.f5988h).l(i10, z10);
    }
}
