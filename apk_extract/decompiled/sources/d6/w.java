package d6;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.work.Data;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import k3.ba;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sj.a f4365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sj.a f4366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sj.a f4367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4368d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d2.a f4369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f4371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4375m;

    public w(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        this.f4365a = new sj.a();
        this.f4366b = new sj.a();
        this.f4367c = new sj.a();
        d2.a aVar = new d2.a();
        aVar.f4258b = EGL10.EGL_NO_DISPLAY;
        aVar.f4259c = EGL10.EGL_NO_SURFACE;
        aVar.f4260d = EGL10.EGL_NO_CONTEXT;
        this.f4369g = aVar;
        int[] iArr = new int[1];
        this.f4371i = iArr;
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        try {
            EGL egl = EGLContext.getEGL();
            if (egl == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            }
            EGL10 egl10 = (EGL10) egl;
            aVar.f4257a = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            aVar.f4258b = eGLDisplayEglGetDisplay;
            int[] iArr2 = new int[2];
            EGL10 egl11 = (EGL10) aVar.f4257a;
            if (egl11 != null) {
                egl11.eglInitialize(eGLDisplayEglGetDisplay, iArr2);
            }
            int[] iArr3 = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
            EGL10 egl12 = (EGL10) aVar.f4257a;
            EGLContext eGLContextEglCreateContext = null;
            aVar.e = (egl12 != null && egl12.eglChooseConfig((EGLDisplay) aVar.f4258b, iArr4, eGLConfigArr, 1, iArr3)) ? eGLConfigArr[0] : null;
            Surface surface = new Surface(surfaceTexture);
            aVar.f4261h = surface;
            EGL10 egl13 = (EGL10) aVar.f4257a;
            aVar.f4259c = egl13 == null ? null : egl13.eglCreateWindowSurface((EGLDisplay) aVar.f4258b, (EGLConfig) aVar.e, surface, null);
            EGL10 egl14 = (EGL10) aVar.f4257a;
            EGLDisplay eGLDisplay = (EGLDisplay) aVar.f4258b;
            EGLConfig eGLConfig = (EGLConfig) aVar.e;
            int[] iArr5 = {12440, 2, 12344};
            if (egl14 != null) {
                eGLContextEglCreateContext = egl14.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr5);
            }
            aVar.f4260d = eGLContextEglCreateContext;
            EGLSurface eGLSurface = (EGLSurface) aVar.f4259c;
            if (eGLSurface == null || Intrinsics.areEqual(eGLSurface, EGL10.EGL_NO_SURFACE)) {
                EGL10 egl15 = (EGL10) aVar.f4257a;
                String msg = Intrinsics.stringPlus("error:", Integer.toHexString(egl15 == null ? 0 : egl15.eglGetError()));
                Intrinsics.checkNotNullParameter("AnimPlayer.EGLUtil", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
            } else {
                EGL10 egl16 = (EGL10) aVar.f4257a;
                if (egl16 != null) {
                    EGLDisplay eGLDisplay2 = (EGLDisplay) aVar.f4258b;
                    EGLSurface eGLSurface2 = (EGLSurface) aVar.f4259c;
                    if (!egl16.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, (EGLContext) aVar.f4260d)) {
                        EGL10 egl17 = (EGL10) aVar.f4257a;
                        String msg2 = Intrinsics.stringPlus("make current error:", Integer.toHexString(egl17 == null ? 0 : egl17.eglGetError()));
                        Intrinsics.checkNotNullParameter("AnimPlayer.EGLUtil", "tag");
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                    }
                }
            }
            int iB = ba.b("attribute vec4 vPosition;\nattribute vec4 vTexCoordinateAlpha;\nattribute vec4 vTexCoordinateRgb;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\n\nvoid main() {\n    v_TexCoordinateAlpha = vec2(vTexCoordinateAlpha.x, vTexCoordinateAlpha.y);\n    v_TexCoordinateRgb = vec2(vTexCoordinateRgb.x, vTexCoordinateRgb.y);\n    gl_Position = vPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinateAlpha;\nvarying vec2 v_TexCoordinateRgb;\n\nvoid main () {\n    vec4 alphaColor = texture2D(texture, v_TexCoordinateAlpha);\n    vec4 rgbColor = texture2D(texture, v_TexCoordinateRgb);\n    gl_FragColor = vec4(rgbColor.r, rgbColor.g, rgbColor.b, alphaColor.r);\n}");
            this.f4370h = iB;
            this.f4372j = GLES20.glGetUniformLocation(iB, "texture");
            this.f4373k = GLES20.glGetAttribLocation(this.f4370h, "vPosition");
            this.f4374l = GLES20.glGetAttribLocation(this.f4370h, "vTexCoordinateAlpha");
            this.f4375m = GLES20.glGetAttribLocation(this.f4370h, "vTexCoordinateRgb");
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
        } catch (Throwable tr) {
            String msg3 = Intrinsics.stringPlus("error:", tr);
            Intrinsics.checkNotNullParameter("AnimPlayer.EGLUtil", "tag");
            Intrinsics.checkNotNullParameter(msg3, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
        }
    }

    public final void a() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f4369g.c();
    }

    public final void b() {
        int[] iArr = this.f4371i;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    public final void c() {
        int i8;
        int i9;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.f4368d && (i8 = this.e) > 0 && (i9 = this.f) > 0) {
            this.f4368d = false;
            GLES20.glViewport(0, 0, i8, i9);
        }
        GLES20.glUseProgram(this.f4370h);
        this.f4365a.m(this.f4373k);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f4371i[0]);
        GLES20.glUniform1i(this.f4372j, 0);
        this.f4366b.m(this.f4374l);
        this.f4367c.m(this.f4375m);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public final void d(int i8, int i9) {
        if (i8 <= 0 || i9 <= 0) {
            return;
        }
        this.f4368d = true;
        this.e = i8;
        this.f = i9;
    }
}
