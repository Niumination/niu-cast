package f2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final a f5816g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final String f5817h = "AnimPlayer.EGLUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public EGL10 f5818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public EGLDisplay f5819b = EGL10.EGL_NO_DISPLAY;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public EGLSurface f5820c = EGL10.EGL_NO_SURFACE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public EGLContext f5821d = EGL10.EGL_NO_CONTEXT;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public EGLConfig f5822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public Surface f5823f;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public final EGLConfig a() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArrC = c();
        EGL10 egl10 = this.f5818a;
        if (egl10 != null && egl10.eglChooseConfig(this.f5819b, iArrC, eGLConfigArr, 1, iArr)) {
            return eGLConfigArr[0];
        }
        return null;
    }

    public final EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = {12440, 2, 12344};
        if (egl10 == null) {
            return null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
    }

    public final int[] c() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    public final void d() {
        EGL10 egl10 = this.f5818a;
        if (egl10 == null) {
            return;
        }
        EGLDisplay eGLDisplay = this.f5819b;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroySurface(this.f5819b, this.f5820c);
        egl10.eglDestroyContext(this.f5819b, this.f5821d);
        egl10.eglTerminate(this.f5819b);
        Surface surface = this.f5823f;
        if (surface != null) {
            surface.release();
        }
        this.f5823f = null;
    }

    public final void e(@os.l SurfaceTexture surfaceTexture) {
        l0.p(surfaceTexture, "surfaceTexture");
        try {
            EGL egl = EGLContext.getEGL();
            if (egl == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            }
            EGL10 egl10 = (EGL10) egl;
            this.f5818a = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f5819b = eGLDisplayEglGetDisplay;
            int[] iArr = new int[2];
            EGL10 egl11 = this.f5818a;
            if (egl11 != null) {
                egl11.eglInitialize(eGLDisplayEglGetDisplay, iArr);
            }
            this.f5822e = a();
            Surface surface = new Surface(surfaceTexture);
            this.f5823f = surface;
            EGL10 egl12 = this.f5818a;
            EGLSurface eGLSurfaceEglCreateWindowSurface = null;
            if (egl12 != null) {
                eGLSurfaceEglCreateWindowSurface = egl12.eglCreateWindowSurface(this.f5819b, this.f5822e, surface, null);
            }
            this.f5820c = eGLSurfaceEglCreateWindowSurface;
            this.f5821d = b(this.f5818a, this.f5819b, this.f5822e);
            EGLSurface eGLSurface = this.f5820c;
            int iEglGetError = 0;
            if (eGLSurface != null && !l0.g(eGLSurface, EGL10.EGL_NO_SURFACE)) {
                EGL10 egl13 = this.f5818a;
                if (egl13 == null) {
                    return;
                }
                EGLDisplay eGLDisplay = this.f5819b;
                EGLSurface eGLSurface2 = this.f5820c;
                if (egl13.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f5821d)) {
                    return;
                }
                l2.a aVar = l2.a.f9640a;
                EGL10 egl14 = this.f5818a;
                if (egl14 != null) {
                    iEglGetError = egl14.eglGetError();
                }
                aVar.b(f5817h, l0.C("make current error:", Integer.toHexString(iEglGetError)));
                return;
            }
            l2.a aVar2 = l2.a.f9640a;
            EGL10 egl15 = this.f5818a;
            if (egl15 != null) {
                iEglGetError = egl15.eglGetError();
            }
            aVar2.b(f5817h, l0.C("error:", Integer.toHexString(iEglGetError)));
        } catch (Throwable th2) {
            l2.a.f9640a.c(f5817h, l0.C("error:", th2), th2);
        }
    }

    public final void f() {
        EGLSurface eGLSurface;
        EGL10 egl10;
        EGLDisplay eGLDisplay = this.f5819b;
        if (eGLDisplay == null || (eGLSurface = this.f5820c) == null || (egl10 = this.f5818a) == null) {
            return;
        }
        egl10.eglSwapBuffers(eGLDisplay, eGLSurface);
    }
}
