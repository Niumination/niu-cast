package j2;

import android.opengl.GLES20;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final a f8506i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public static final String f8507j = "attribute vec4 a_Position;  \nattribute vec2 a_TextureSrcCoordinates;\nattribute vec2 a_TextureMaskCoordinates;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    v_TextureSrcCoordinates = a_TextureSrcCoordinates;\n    v_TextureMaskCoordinates = a_TextureMaskCoordinates;\n    gl_Position = a_Position;\n}";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public static final String f8508k = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; \nuniform sampler2D u_TextureSrcUnit;\nuniform samplerExternalOES u_TextureMaskUnit;\nuniform int u_isFill;\nuniform vec4 u_Color;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    vec4 srcRgba = texture2D(u_TextureSrcUnit, v_TextureSrcCoordinates);\n    vec4 maskRgba = texture2D(u_TextureMaskUnit, v_TextureMaskCoordinates);\n    float isFill = step(0.5, float(u_isFill));\n    vec4 srcRgbaCal = isFill * vec4(u_Color.r, u_Color.g, u_Color.b, srcRgba.a) + (1.0 - isFill) * srcRgba;\n    gl_FragColor = vec4(srcRgbaCal.r, srcRgbaCal.g, srcRgbaCal.b, srcRgba.a * maskRgba.r);\n}";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public static final String f8509l = "u_TextureSrcUnit";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public static final String f8510m = "u_TextureMaskUnit";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final String f8511n = "u_isFill";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @l
    public static final String f8512o = "u_Color";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final String f8513p = "a_Position";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @l
    public static final String f8514q = "a_TextureSrcCoordinates";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @l
    public static final String f8515r = "a_TextureMaskCoordinates";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8523h;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public g() {
        int iC = l2.l.f9670a.c(f8507j, f8508k);
        this.f8516a = iC;
        this.f8517b = GLES20.glGetUniformLocation(iC, f8509l);
        this.f8518c = GLES20.glGetUniformLocation(iC, f8510m);
        this.f8519d = GLES20.glGetUniformLocation(iC, f8511n);
        this.f8520e = GLES20.glGetUniformLocation(iC, f8512o);
        this.f8521f = GLES20.glGetAttribLocation(iC, f8513p);
        this.f8522g = GLES20.glGetAttribLocation(iC, f8514q);
        this.f8523h = GLES20.glGetAttribLocation(iC, f8515r);
    }

    public final int a() {
        return this.f8521f;
    }

    public final int b() {
        return this.f8523h;
    }

    public final int c() {
        return this.f8522g;
    }

    public final int d() {
        return this.f8516a;
    }

    public final int e() {
        return this.f8520e;
    }

    public final int f() {
        return this.f8519d;
    }

    public final int g() {
        return this.f8518c;
    }

    public final int h() {
        return this.f8517b;
    }

    public final void i() {
        GLES20.glUseProgram(this.f8516a);
    }
}
