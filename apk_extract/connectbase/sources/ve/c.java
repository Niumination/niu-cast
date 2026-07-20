package ve;

import android.graphics.Rect;
import android.view.SurfaceControl;
import com.transsion.hubsdk.window.TranScreenCapture;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ph.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranScreenCapture f17019a = new TranScreenCapture();

    @Override // ph.b
    public boolean a(Object obj) {
        return this.f17019a.containsSecureLayers(obj);
    }

    @Override // ph.b
    public Object b(SurfaceControl surfaceControl, Rect rect) {
        return this.f17019a.getCaptureArgs(surfaceControl, rect);
    }
}
