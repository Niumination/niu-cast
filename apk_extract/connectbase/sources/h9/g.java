package h9;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import ic.o0;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7029c = "g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7030d = "taskInfo cannot be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7031e = "package name should not be null";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7032f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f7033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.e f7034b;

    public interface a {
        void a(Bundle bundle);
    }

    public interface b {
        void a(int i10);
    }

    public interface c {
        void a(int i10, int i11);

        void b(int i10, int i11, boolean z10);

        void c(int i10, int i11, int i12);
    }

    public interface d {
        void a(String str, String str2, int i10);
    }

    public Bundle A() {
        if (fc.a.g()) {
            return C(fc.b.a.C).P();
        }
        return null;
    }

    public void A0(int[] iArr) throws ac.a {
        C(fc.b.a.E).Y(iArr);
    }

    public ComponentName B(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5985e).Q0(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void B0(int i10, int[] iArr, Bundle bundle) throws ac.a {
        C(fc.b.a.G).h(i10, iArr, bundle);
    }

    public bf.d C(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7029c, "TranThubActivityManager");
            o0 o0Var = this.f7033a;
            if (o0Var != null) {
                return o0Var;
            }
            o0 o0Var2 = new o0();
            this.f7033a = o0Var2;
            return o0Var2;
        }
        dc.e.f(f7029c, "TranAospActivityManager");
        p6.e eVar = this.f7034b;
        if (eVar != null) {
            return eVar;
        }
        p6.e eVar2 = new p6.e();
        this.f7034b = eVar2;
        return eVar2;
    }

    public boolean C0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).Z(i10);
        }
        return false;
    }

    public List<String> D() {
        return C(fc.b.a.f5999s).K();
    }

    public boolean D0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).A0(i10);
        }
        return false;
    }

    public int E(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("params cannot be null");
        }
        return C(fc.b.a.f5995o).W(str, str2);
    }

    public boolean E0(boolean z10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).s0(z10);
        }
        return false;
    }

    @yb.a(level = 1)
    public ActivityInfo F() {
        return C(fc.b.a.f5982b).p();
    }

    public boolean F0(UserHandle userHandle) {
        if (userHandle != null) {
            return C(fc.b.a.f5991k).U0(userHandle);
        }
        throw new NullPointerException("startProfile param should not be null");
    }

    public int G(ActivityManager.RunningTaskInfo runningTaskInfo) {
        return C(fc.b.a.f5985e).c0(runningTaskInfo);
    }

    @yb.a(level = 2)
    public void G0(String str, long j10, int i10, String str2) {
        C(fc.b.a.f5981a).y(str, j10, i10, str2);
    }

    public String H(String str) {
        return !fc.a.f() ? "unknown" : C(fc.b.a.f6004x).g(str);
    }

    @yb.a(level = 1)
    public boolean H0(int i10) {
        return C(fc.b.a.f5987g).X(i10);
    }

    public List<String> I(int i10) {
        return C(fc.b.a.f5995o).F0(i10);
    }

    public void I0(String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("packageName cannot be null");
        }
        C(fc.b.a.A).D(str, i10);
    }

    public int J(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5987g).C0(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void J0(boolean z10) {
        C(fc.b.a.f5999s).G(z10);
    }

    public int K(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5984d).j(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void K0(boolean z10) {
        C(fc.b.a.f5999s).G0(z10);
    }

    public void L(int i10) {
        C(fc.b.a.f5988h).O0(i10);
    }

    public void L0(int i10) {
        C(fc.b.a.f5985e).J0(i10);
    }

    public boolean M() {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).W0();
        }
        return false;
    }

    public boolean M0(String str, String str2, int i10) {
        if (!fc.a.g()) {
            return false;
        }
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("process and packageName cannot be null");
        }
        return C(fc.b.a.f6006z).q0(str, str2, i10);
    }

    public boolean N(int i10) {
        return C(fc.b.a.f5981a).a(i10);
    }

    public boolean N0(String str, int i10) {
        if (!fc.a.g()) {
            return false;
        }
        if (str != null) {
            return C(fc.b.a.f6006z).v0(str, i10);
        }
        throw new IllegalArgumentException("packageName cannot be null");
    }

    public boolean O() {
        return C(fc.b.a.f5994n).f();
    }

    public boolean O0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.A).i(i10);
        }
        return false;
    }

    public boolean P() {
        return C(fc.b.a.f6001u).S();
    }

    public boolean P0(long j10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).s(j10);
        }
        return false;
    }

    public boolean Q(String str) {
        return C(fc.b.a.f6001u).z(str);
    }

    public boolean Q0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.A).R(i10);
        }
        return false;
    }

    @yb.a(level = 1)
    public boolean R() {
        return C(fc.b.a.f5982b).p0();
    }

    public boolean R0(long j10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).z0(j10);
        }
        return false;
    }

    public boolean S() {
        return C(fc.b.a.f5987g).I();
    }

    public boolean S0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.A).w0(i10);
        }
        return false;
    }

    public boolean T() {
        return C(fc.b.a.f5999s).b0();
    }

    public boolean T0(long j10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).D0(j10);
        }
        return false;
    }

    public boolean U() {
        return C(fc.b.a.f5999s).E0();
    }

    public boolean U0() {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).m();
        }
        return false;
    }

    public int V(String str) {
        if (str != null) {
            return C(fc.b.a.f5999s).H(str);
        }
        throw new NullPointerException("memFusionSize cannot be null");
    }

    public boolean V0(String str, String str2, int i10) {
        if (!fc.a.g()) {
            return false;
        }
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("process and packageName cannot be null");
        }
        return C(fc.b.a.f6006z).w(str, str2, i10);
    }

    public boolean W(String str, String str2) {
        return C(fc.b.a.f5985e).F(str, str2);
    }

    public void W0(Activity activity) throws ac.a {
        if (fc.a.g()) {
            C(fc.b.a.f6004x).v(k(activity));
        }
    }

    public boolean X(int i10, int i11) {
        if (fc.a.h()) {
            return C(fc.b.a.E).Q(i10, i11);
        }
        return false;
    }

    public void X0(b bVar) throws ac.a {
        if (fc.a.g()) {
            if (bVar == null) {
                throw new IllegalArgumentException("listener cannot be null");
            }
            C(fc.b.a.f6006z).o0(bVar);
        }
    }

    public boolean Y() {
        return C(fc.b.a.f5999s).g0();
    }

    @yb.a(level = 1)
    public void Y0(@gm.i c cVar) {
        if (cVar == null) {
            throw new NullPointerException("unRegisterProcessObserver() parameter observer must not be null");
        }
        C(fc.b.a.f5987g).q(cVar);
    }

    public boolean Z(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5985e).o(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void Z0(d dVar) throws ac.a {
        if (fc.a.g() && dVar != null) {
            C(fc.b.a.B).V(dVar);
        }
    }

    @yb.a(level = 2)
    public void a(int i10) {
        C(fc.b.a.f5989i).K0(i10);
    }

    public boolean a0(String str) {
        if (str != null) {
            return C(fc.b.a.f5994n).b(str);
        }
        throw new NullPointerException("package is null");
    }

    public void a1(s sVar) {
        C(fc.b.a.f5989i).t(sVar);
    }

    public long b() {
        if (fc.a.h()) {
            return C(fc.b.a.G).T0();
        }
        return 0L;
    }

    public void b0(boolean z10) throws ac.a {
        C(fc.b.a.f5994n).U(z10);
    }

    public void b1(u uVar) {
        C(fc.b.a.E).P0(uVar);
    }

    public void c(String str) {
        if (str == null) {
            throw new NullPointerException("meminfo cannot be null");
        }
        C(fc.b.a.f5999s).i0(str);
    }

    public boolean c0(String[] strArr, d dVar) throws ac.a {
        if (fc.a.g() && dVar != null) {
            return C(fc.b.a.B).j0(strArr, dVar);
        }
        return false;
    }

    @yb.a(level = 2)
    public boolean d(@gm.i String str, p6.f.c cVar) {
        return C(fc.b.a.f5989i).t0(str, cVar);
    }

    public void d0(a aVar, Activity activity) throws ac.a {
        if (fc.a.g()) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            C(fc.b.a.f6004x).h0(aVar, k(activity));
        }
    }

    @yb.a(level = 1)
    public void e(int i10, List<String> list) {
        C(fc.b.a.f5988h).A(i10, list);
    }

    public void e0(b bVar) throws ac.a {
        if (fc.a.g()) {
            if (bVar == null) {
                throw new IllegalArgumentException("listener cannot be null");
            }
            C(fc.b.a.f6006z).B0(bVar);
        }
    }

    public void f(boolean z10) {
        C(fc.b.a.f5994n).e(z10);
    }

    @yb.a(level = 1)
    public void f0(@gm.i c cVar) {
        if (cVar == null) {
            throw new NullPointerException("registerProcessObserver() parameter observer must not be null");
        }
        C(fc.b.a.f5987g).L(cVar);
    }

    @yb.a(level = 2)
    public void g(String str) {
        C(fc.b.a.f5982b).k(str);
    }

    public void g0(s sVar) {
        C(fc.b.a.f5989i).Y0(sVar);
    }

    public void h(String str, int i10, int i11) throws ac.a {
        if (str == null) {
            throw new NullPointerException("packageName cannot be null");
        }
        C(fc.b.a.f5994n).k0(str, i10, i11);
    }

    public void h0(u uVar, String str) {
        if (uVar == null || str == null) {
            throw new NullPointerException("Observer name cannot be null");
        }
        C(fc.b.a.f5985e).d0(uVar, str);
    }

    public void i(String str, boolean z10) {
        if (fc.a.f()) {
            C(fc.b.a.f6001u).r0(str, z10);
        }
    }

    public void i0(Bundle bundle, String str, String str2) {
        if (fc.a.g()) {
            if (bundle == null || str == null || str2 == null) {
                throw new IllegalArgumentException("proc,from and reason cannot be null");
            }
            C(fc.b.a.f6006z).x0(bundle, str, str2);
        }
    }

    public void j(String str, String str2, boolean z10, List<String> list) {
        if (fc.a.f()) {
            C(fc.b.a.f6001u).M(str, str2, z10, list);
        }
    }

    public boolean j0() {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).a0();
        }
        return false;
    }

    public IBinder k(Activity activity) {
        Method methodG;
        if (activity == null || (methodG = cc.a.g(activity.getClass(), "getActivityToken", new Class[0])) == null) {
            return null;
        }
        return (IBinder) cc.a.j(methodG, activity, new Object[0]);
    }

    public void k0() {
        C(fc.b.a.A).n();
    }

    public int[] l(int i10) {
        return C(fc.b.a.f5994n).d(i10);
    }

    public boolean l0(String str, String str2) {
        if (fc.a.g()) {
            return C(fc.b.a.C).y0(str, str2);
        }
        return false;
    }

    public int m(int i10) {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("uid cannot be out of range");
        }
        return C(fc.b.a.A).m0(i10);
    }

    public boolean m0(int i10, String str, String str2) {
        if (!fc.a.g()) {
            return false;
        }
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("packageName and processName cannot be null");
        }
        return C(fc.b.a.f6006z).J(i10, str, str2);
    }

    public int n() {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).n0();
        }
        return 0;
    }

    public boolean n0(String str, int i10) {
        if (!fc.a.g()) {
            return false;
        }
        if (str != null) {
            return C(fc.b.a.f6006z).r(str, i10);
        }
        throw new IllegalArgumentException("packageName cannot be null");
    }

    public List<String> o() {
        return C(fc.b.a.f5989i).C();
    }

    public List<String> o0(int i10, String str, boolean z10) {
        if (!fc.a.g()) {
            return Collections.EMPTY_LIST;
        }
        if (str != null) {
            return C(fc.b.a.f6006z).H0(i10, str, z10);
        }
        throw new IllegalArgumentException("packageName cannot be null");
    }

    public Configuration p(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5984d).V0(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void p0(int i10, int i11) {
        C(fc.b.a.f5994n).c(i10, i11);
    }

    @yb.a(level = 1)
    public int q() {
        return C(fc.b.a.f5982b).l0();
    }

    public void q0(String str) {
        if (fc.a.h()) {
            C(fc.b.a.F).T(str);
        }
    }

    public int r(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            return C(fc.b.a.f5985e).e0(runningTaskInfo);
        }
        throw new IllegalArgumentException(f7030d);
    }

    public void r0(List<String> list) throws ac.a {
        if (list == null) {
            throw new NullPointerException("list is null");
        }
        C(fc.b.a.f5994n).L0(list);
    }

    public Bundle s() {
        if (fc.a.g()) {
            return C(fc.b.a.C).u();
        }
        return null;
    }

    @yb.a(level = 1)
    public boolean s0(String str, boolean z10) {
        return C(fc.b.a.f5989i).u0(str, z10);
    }

    public long[] t() {
        if (fc.a.g()) {
            return C(fc.b.a.C).O();
        }
        return null;
    }

    public boolean t0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).Z0(i10);
        }
        return false;
    }

    public String u(IBinder iBinder) {
        return C(fc.b.a.f5988h).N0(iBinder);
    }

    public boolean u0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).B(i10);
        }
        return false;
    }

    public int v(IBinder iBinder) {
        return C(fc.b.a.f5988h).I0(iBinder);
    }

    public boolean v0(int i10) {
        if (fc.a.g()) {
            return C(fc.b.a.f6006z).M0(i10);
        }
        return false;
    }

    public Locale w() {
        return C(fc.b.a.f5992l).X0();
    }

    public void w0() {
        C(fc.b.a.f5985e).R0();
    }

    public int x() {
        return C(fc.b.a.f5989i).l();
    }

    public boolean x0(String str, boolean z10) {
        return C(fc.b.a.f5985e).N(str, z10);
    }

    public List<String> y(String str) {
        if (str != null) {
            return C(fc.b.a.f5995o).f0(str);
        }
        throw new NullPointerException("param key cannot be null");
    }

    public boolean y0(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            throw new NullPointerException("params cannot be null");
        }
        return C(fc.b.a.f5995o).S0(str, str2, str3);
    }

    public int z(String str) {
        if (str != null) {
            return C(fc.b.a.f5999s).E(str);
        }
        throw new NullPointerException("memFusionSize cannot be null");
    }

    public void z0(boolean z10) throws ac.a {
        C(fc.b.a.f5992l).x(z10);
    }
}
