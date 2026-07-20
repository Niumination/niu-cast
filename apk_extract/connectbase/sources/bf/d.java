package bf;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import h9.u;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    void A(int i10, List<String> list);

    boolean A0(int i10);

    boolean B(int i10);

    void B0(h9.g.b bVar) throws ac.a;

    List<String> C();

    int C0(ActivityManager.RunningTaskInfo runningTaskInfo);

    void D(String str, int i10);

    boolean D0(long j10);

    int E(String str);

    boolean E0();

    boolean F(String str, String str2);

    List<String> F0(int i10);

    void G(boolean z10);

    void G0(boolean z10);

    int H(String str);

    List<String> H0(int i10, String str, boolean z10);

    boolean I();

    int I0(IBinder iBinder);

    boolean J(int i10, String str, String str2);

    void J0(int i10);

    List<String> K();

    void K0(int i10);

    void L(h9.g.c cVar);

    void L0(List<String> list) throws ac.a;

    void M(String str, String str2, boolean z10, List<String> list);

    boolean M0(int i10);

    boolean N(String str, boolean z10);

    String N0(IBinder iBinder);

    long[] O();

    void O0(int i10);

    Bundle P();

    void P0(u uVar);

    boolean Q(int i10, int i11);

    ComponentName Q0(ActivityManager.RunningTaskInfo runningTaskInfo);

    boolean R(int i10);

    void R0();

    boolean S();

    boolean S0(String str, String str2, String str3);

    void T(String str);

    long T0();

    void U(boolean z10) throws ac.a;

    boolean U0(UserHandle userHandle);

    void V(h9.g.d dVar) throws ac.a;

    Configuration V0(ActivityManager.RunningTaskInfo runningTaskInfo);

    int W(String str, String str2);

    boolean W0();

    boolean X(int i10);

    Locale X0();

    void Y(int[] iArr) throws ac.a;

    void Y0(h9.s sVar);

    boolean Z(int i10);

    boolean Z0(int i10);

    boolean a(int i10);

    boolean a0();

    boolean b(String str);

    boolean b0();

    void c(int i10, int i11);

    int c0(ActivityManager.RunningTaskInfo runningTaskInfo);

    int[] d(int i10);

    void d0(u uVar, String str);

    void e(boolean z10);

    int e0(ActivityManager.RunningTaskInfo runningTaskInfo);

    boolean f();

    List<String> f0(String str);

    String g(String str);

    boolean g0();

    void h(int i10, int[] iArr, Bundle bundle) throws ac.a;

    void h0(h9.g.a aVar, IBinder iBinder) throws ac.a;

    boolean i(int i10);

    void i0(String str);

    int j(ActivityManager.RunningTaskInfo runningTaskInfo);

    boolean j0(String[] strArr, h9.g.d dVar) throws ac.a;

    void k(String str);

    void k0(String str, int i10, int i11) throws ac.a;

    int l();

    int l0();

    boolean m();

    int m0(int i10);

    void n();

    int n0();

    boolean o(ActivityManager.RunningTaskInfo runningTaskInfo);

    void o0(h9.g.b bVar) throws ac.a;

    ActivityInfo p();

    boolean p0();

    void q(h9.g.c cVar);

    boolean q0(String str, String str2, int i10);

    boolean r(String str, int i10);

    void r0(String str, boolean z10);

    boolean s(long j10);

    boolean s0(boolean z10);

    void t(h9.s sVar);

    boolean t0(String str, p6.f.c cVar);

    Bundle u();

    boolean u0(String str, boolean z10);

    void v(IBinder iBinder) throws ac.a;

    boolean v0(String str, int i10);

    boolean w(String str, String str2, int i10);

    boolean w0(int i10);

    void x(boolean z10) throws ac.a;

    void x0(Bundle bundle, String str, String str2);

    void y(String str, long j10, int i10, String str2);

    boolean y0(String str, String str2);

    boolean z(String str);

    boolean z0(long j10);
}
