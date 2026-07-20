package re;

import android.view.SurfaceControlViewHost;
import android.view.View;
import android.view.WindowManager;
import com.transsion.hubsdk.view.TranSurfaceControlViewHost;

/* JADX INFO: loaded from: classes2.dex */
public class i implements lh.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranSurfaceControlViewHost f14474a;

    @Override // lh.i
    public void a(SurfaceControlViewHost surfaceControlViewHost, View view, WindowManager.LayoutParams layoutParams) {
        c().setView(surfaceControlViewHost, view, layoutParams);
    }

    @Override // lh.i
    public void b(SurfaceControlViewHost surfaceControlViewHost, WindowManager.LayoutParams layoutParams) {
        c().relayout(surfaceControlViewHost, layoutParams);
    }

    public final TranSurfaceControlViewHost c() {
        if (this.f14474a == null) {
            this.f14474a = new TranSurfaceControlViewHost();
        }
        return this.f14474a;
    }
}
