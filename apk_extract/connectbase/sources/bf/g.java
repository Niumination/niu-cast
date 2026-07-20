package bf;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.SurfaceControl;
import com.transsion.hubsdk.api.app.TranRootTaskInfo;
import com.transsion.hubsdk.api.window.TranTaskSnapshot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface g {
    String A();

    void A0(Bundle bundle);

    void B(int i10, Rect rect);

    void B0(Rect rect);

    SurfaceControl C();

    void C0(List<String> list);

    void D(int i10, int i11);

    Bundle D0(String str);

    int E(String str);

    void E0(SurfaceControl surfaceControl);

    void F(int i10);

    void F0(boolean z10);

    void G(boolean z10);

    void G0(int i10, Rect rect, h9.j.a aVar);

    void H(int i10, String str, boolean z10);

    void H0(List<String> list);

    Rect I(int i10);

    List<String> I0();

    void J(boolean z10);

    String J0(int i10, int i11);

    void K(SurfaceControl surfaceControl);

    int K0(int i10);

    void L(int i10);

    List<ActivityManager.RecentTaskInfo> L0(int i10, int i11, int i12);

    void M(h9.a aVar, boolean z10);

    TranRootTaskInfo M0(int i10, int i11, int i12);

    void N(String str, int i10, int i11, int i12);

    Bundle N0(String str, Bundle bundle);

    void O();

    int O0();

    boolean P(Configuration configuration);

    void P0(boolean z10, int i10);

    void Q(boolean z10, Bundle bundle);

    TranTaskSnapshot Q0(int i10, boolean z10);

    List<ActivityManager.RunningTaskInfo> R();

    boolean R0();

    boolean S();

    void S0(int i10);

    void T(int i10);

    int T0(String str);

    boolean U();

    void U0(String str, int i10, int i11, int i12, int i13);

    void V(List<String> list);

    boolean V0();

    void W(String str, List<String> list);

    void W0();

    void X(int i10, String str, boolean z10);

    ActivityManager.RunningTaskInfo Y(int i10, int i11);

    int Z(String str);

    boolean a0();

    void b0(boolean z10);

    void c0(int i10, int i11, int i12, Rect rect, h9.j.a aVar);

    boolean d();

    Bundle d0();

    boolean e0(String str, String str2);

    void f0(int i10);

    void g0();

    void h(boolean z10, int i10);

    ComponentName h0();

    HardwareBuffer i0(int i10, boolean z10);

    boolean j0(int i10);

    void k(int i10, int i11, boolean z10);

    void k0(IBinder iBinder);

    void l(int i10, boolean z10);

    void l0(int[] iArr);

    void m(int i10, int i11);

    List<TranRootTaskInfo> m0(int i10);

    boolean n(String str);

    int n0(String str, String str2);

    boolean o();

    boolean o0(String str);

    SurfaceControl p(int i10, int i11, int i12, int i13, boolean z10);

    void p0(boolean z10);

    List<ActivityManager.RunningTaskInfo> q(int i10, boolean z10, boolean z11);

    boolean q0(String str);

    void r(int i10);

    Rect r0(int i10);

    Rect s();

    void s0(SurfaceControl surfaceControl, String str);

    boolean t(int i10);

    void t0(int i10, int i11);

    List<String> u();

    boolean u0();

    String v();

    void v0();

    boolean w(String str, boolean z10, boolean z11, long j10);

    void w0(boolean z10, int i10);

    boolean x(int i10);

    void x0(SurfaceControl surfaceControl, float[] fArr, float[] fArr2, int i10);

    int y(String str, int i10);

    ActivityManager.RunningTaskInfo y0(int i10);

    int z(String str);

    void z0(String str, boolean z10);
}
