package rb;

import android.view.SurfaceControlViewHost;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14401c = "k";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.i f14402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.h f14403b;

    public lh.i a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14401c, "TranThubSurfaceControlViewHost");
            re.i iVar = this.f14402a;
            if (iVar != null) {
                return iVar;
            }
            re.i iVar2 = new re.i();
            this.f14402a = iVar2;
            return iVar2;
        }
        dc.e.f(f14401c, "TranAospSurfaceControlViewHost");
        b9.h hVar = this.f14403b;
        if (hVar != null) {
            return hVar;
        }
        b9.h hVar2 = new b9.h();
        this.f14403b = hVar2;
        return hVar2;
    }

    public void b(SurfaceControlViewHost surfaceControlViewHost, WindowManager.LayoutParams layoutParams) {
        if (surfaceControlViewHost == null || layoutParams == null) {
            throw new IllegalArgumentException("name or parent should not be null");
        }
        a(fc.b.a.H).b(surfaceControlViewHost, layoutParams);
    }

    public void c(SurfaceControlViewHost surfaceControlViewHost, View view, WindowManager.LayoutParams layoutParams) {
        if (surfaceControlViewHost == null || view == null || layoutParams == null) {
            throw new IllegalArgumentException("name or parent should not be null");
        }
        a(fc.b.a.H).a(surfaceControlViewHost, view, layoutParams);
    }
}
