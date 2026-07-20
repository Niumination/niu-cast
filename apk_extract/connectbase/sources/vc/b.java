package vc;

import android.graphics.Rect;
import android.view.Display;
import android.view.SurfaceControl;
import com.transsion.hubsdk.graphics.TranGraphicBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class b implements of.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranGraphicBuffer f16890a = new TranGraphicBuffer();

    @Override // of.b
    public u9.b a(SurfaceControl surfaceControl, Rect rect) {
        return new d7.b().a(surfaceControl, rect);
    }

    @Override // of.b
    public u9.b b(Display display, int i10, int i11) {
        TranGraphicBuffer tranGraphicBuffer = this.f16890a;
        if (tranGraphicBuffer == null) {
            return null;
        }
        TranGraphicBuffer tranGraphicBufferCreateFromHardwareBuffer = tranGraphicBuffer.createFromHardwareBuffer(display, i10, i11);
        u9.b bVar = new u9.b();
        bVar.d(tranGraphicBufferCreateFromHardwareBuffer.getWidth());
        bVar.c(tranGraphicBufferCreateFromHardwareBuffer.getHeight());
        return bVar;
    }
}
