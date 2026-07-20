package vb;

import android.graphics.Rect;
import android.view.SurfaceControl;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16880c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve.c f16881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.b f16882b;

    public boolean a(Object obj) {
        if (!fc.a.g()) {
            return false;
        }
        if (obj != null) {
            return c(fc.b.a.A).a(obj);
        }
        throw new IllegalArgumentException("obj should not be null");
    }

    public Object b(SurfaceControl surfaceControl, Rect rect) {
        if (!fc.a.g()) {
            return null;
        }
        if (surfaceControl == null || rect == null) {
            throw new IllegalArgumentException("appSurface or rect should not be null");
        }
        return c(fc.b.a.A).b(surfaceControl, rect);
    }

    public ph.b c(String str) {
        if (fc.b.b(str)) {
            ve.c cVar = this.f16881a;
            if (cVar != null) {
                return cVar;
            }
            ve.c cVar2 = new ve.c();
            this.f16881a = cVar2;
            return cVar2;
        }
        e.f(f16880c, "TranAospSurfaceControl");
        f9.b bVar = this.f16882b;
        if (bVar != null) {
            return bVar;
        }
        f9.b bVar2 = new f9.b();
        this.f16882b = bVar2;
        return bVar2;
    }
}
