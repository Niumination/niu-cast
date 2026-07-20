package b9;

import android.view.SurfaceControlViewHost;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class h implements lh.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f770a = cc.a.a("android.view.SurfaceControlViewHost");

    @Override // lh.i
    public void a(SurfaceControlViewHost surfaceControlViewHost, View view, WindowManager.LayoutParams layoutParams) {
        cc.a.j(cc.a.g(f770a, "setView", View.class, WindowManager.LayoutParams.class), surfaceControlViewHost, "setView", view, layoutParams);
    }

    @Override // lh.i
    public void b(SurfaceControlViewHost surfaceControlViewHost, WindowManager.LayoutParams layoutParams) {
        cc.a.j(cc.a.g(f770a, "relayout", WindowManager.LayoutParams.class), surfaceControlViewHost, layoutParams);
    }
}
