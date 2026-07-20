package r4;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.view.Surface;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Thread implements SurfaceTexture.OnFrameAvailableListener {
    public static final String K = "r4.a";
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final long O = 3000;
    public long I;
    public long J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f14215b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Surface f14217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14219f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14222n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14223p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EGLDisplay f14224v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public EGLSurface f14225w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EGLContext f14226x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f14214a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f14216c = new float[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14220g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14221i = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14227y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14228z = false;
    public boolean H = false;

    public a(Surface surface, int i10, int i11, int i12) {
        this.f14217d = surface;
        this.f14218e = i10;
        this.f14219f = i11;
        this.J = 1000 / i12;
        start();
    }

    public void a(int i10) {
        this.J = 1000 / i10;
    }

    public final void b() {
        if (this.f14223p) {
            this.f14223p = false;
            EGL14.eglDestroySurface(this.f14224v, this.f14225w);
            EGLDisplay eGLDisplay = this.f14224v;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f14224v, this.f14226x);
            EGL14.eglTerminate(this.f14224v);
        }
    }

    public void c() {
        synchronized (this) {
            this.H = true;
        }
    }

    public Surface d() {
        synchronized (this) {
            while (this.f14227y != 1) {
                try {
                    wait(50L);
                } catch (InterruptedException unused) {
                }
            }
            if (this.f14227y != 1) {
                return null;
            }
            m.e(K, "  getDisplayOutputSurface return mSurfaceTexture=" + this.f14215b);
            return new Surface(this.f14215b);
        }
    }

    public final void e() {
        if (this.f14223p) {
            return;
        }
        this.f14223p = true;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f14224v = eGLDisplayEglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(this.f14224v, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        this.f14226x = EGL14.eglCreateContext(this.f14224v, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f14224v, eGLConfigArr[0], this.f14217d, new int[]{12344}, 0);
        this.f14225w = eGLSurfaceEglCreateWindowSurface;
        EGL14.eglMakeCurrent(this.f14224v, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.f14226x);
    }

    public final void f() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i10 = iArr[0];
        this.f14222n = i10;
        GLES20.glBindTexture(36197, i10);
        GLES20.glTexParameteri(36197, 10242, 10497);
        GLES20.glTexParameteri(36197, 10243, 10497);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f14222n);
        this.f14215b = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.f14218e, this.f14219f);
        this.f14215b.setOnFrameAvailableListener(this);
        this.f14215b.getTransformMatrix(this.f14216c);
        GLES20.glBindTexture(36197, 0);
    }

    public void g() {
        synchronized (this) {
            this.f14227y = 2;
        }
        SurfaceTexture surfaceTexture = this.f14215b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        int i10 = this.f14222n;
        if (i10 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        }
        this.f14214a.g();
    }

    public final void h() {
        long jNanoTime;
        synchronized (this) {
            try {
                try {
                    if (this.f14221i) {
                        this.f14215b.updateTexImage();
                        jNanoTime = this.f14215b.getTimestamp();
                        this.f14221i = false;
                    } else {
                        jNanoTime = System.nanoTime();
                    }
                    this.f14214a.d(this.f14222n, this.f14216c);
                    EGLExt.eglPresentationTimeANDROID(this.f14224v, this.f14225w, jNanoTime);
                    EGL14.eglSwapBuffers(this.f14224v, this.f14225w);
                    this.f14228z = false;
                    this.H = false;
                } catch (Exception e10) {
                    m.c(K, "renderSurfaceTexture fail: " + e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void i(boolean z10) {
        this.f14220g = z10;
    }

    public final boolean j() {
        this.f14221i = (this.f14228z || SystemClock.uptimeMillis() - this.I >= O) && !this.f14220g;
        return (this.f14228z || this.H || SystemClock.uptimeMillis() - this.I >= O) && !this.f14220g;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.f14228z = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        e();
        f();
        this.f14214a.e();
        synchronized (this) {
            this.f14227y = 1;
            notifyAll();
        }
        while (true) {
            synchronized (this) {
                if (this.f14227y != 1) {
                    this.f14214a.g();
                    b();
                    return;
                }
            }
            try {
                if (j()) {
                    this.I = SystemClock.uptimeMillis();
                    h();
                    long jUptimeMillis = (this.I + this.J) - SystemClock.uptimeMillis();
                    if (jUptimeMillis > 0) {
                        Thread.sleep(jUptimeMillis);
                    }
                } else {
                    Thread.sleep(this.J);
                }
            } catch (InterruptedException e10) {
                m.d(K, e10);
            }
        }
    }
}
