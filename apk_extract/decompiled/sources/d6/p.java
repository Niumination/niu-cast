package d6;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f4337b;

    public /* synthetic */ p(t tVar, int i8) {
        this.f4336a = i8;
        this.f4337b = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4336a) {
            case 0:
                t this$0 = this.f4337b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                w wVar = this$0.f4347b;
                if (wVar != null) {
                    wVar.a();
                }
                d dVar = this$0.f4346a;
                ef.g gVar = dVar.p;
                gVar.getClass();
                Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
                Intrinsics.checkNotNullParameter("onDestroy", NotificationCompat.CATEGORY_MESSAGE);
                Iterator it = ((List) gVar.e).iterator();
                while (it.hasNext()) {
                    ((i6.a) it.next()).b();
                }
                w wVar2 = this$0.f4347b;
                if (wVar2 != null) {
                    wVar2.b();
                    d2.a aVar = wVar2.f4369g;
                    EGL10 egl10 = (EGL10) aVar.f4257a;
                    if (egl10 != null) {
                        EGLDisplay eGLDisplay = (EGLDisplay) aVar.f4258b;
                        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                        egl10.eglDestroySurface((EGLDisplay) aVar.f4258b, (EGLSurface) aVar.f4259c);
                        egl10.eglDestroyContext((EGLDisplay) aVar.f4258b, (EGLContext) aVar.f4260d);
                        egl10.eglTerminate((EGLDisplay) aVar.f4258b);
                        Surface surface = (Surface) aVar.f4261h;
                        if (surface != null) {
                            surface.release();
                        }
                        aVar.f4261h = null;
                    }
                }
                this$0.f4347b = null;
                this$0.b();
                if (dVar.f4318j) {
                    Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
                    Intrinsics.checkNotNullParameter("destroyThread", NotificationCompat.CATEGORY_MESSAGE);
                    o oVar = this$0.f4348c;
                    Handler handler = oVar.f4335b;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    o oVar2 = this$0.f4349d;
                    Handler handler2 = oVar2.f4335b;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                    }
                    HandlerThread handlerThread = oVar.f4334a;
                    if (handlerThread != null) {
                        handlerThread.quitSafely();
                    }
                    oVar.f4334a = null;
                    HandlerThread handlerThread2 = oVar2.f4334a;
                    if (handlerThread2 != null) {
                        handlerThread2.quitSafely();
                    }
                    oVar2.f4334a = null;
                    oVar.f4335b = null;
                    oVar2.f4335b = null;
                }
                break;
            default:
                t this$1 = this.f4337b;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                try {
                    SurfaceTexture surfaceTexture = this$1.f4356m;
                    if (surfaceTexture != null) {
                        surfaceTexture.updateTexImage();
                        w wVar3 = this$1.f4347b;
                        if (wVar3 != null) {
                            wVar3.c();
                        }
                        this$1.f4346a.p.c();
                        w wVar4 = this$1.f4347b;
                        if (wVar4 != null) {
                            wVar4.f4369g.c();
                        }
                    }
                } catch (Throwable tr) {
                    String msg = Intrinsics.stringPlus("render exception=", tr);
                    Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(tr, "tr");
                }
                break;
        }
    }
}
