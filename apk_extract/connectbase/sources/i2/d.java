package i2;

import android.opengl.GLES20;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final a f7683e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final String f7684f = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinateAlphaMask;\n varying vec2 v_TexCoordinateAlphaMask;\n\nvoid main() {\n    v_TexCoordinateAlphaMask = vec2(vTexCoordinateAlphaMask.x, vTexCoordinateAlphaMask.y);\n    gl_Position = vPosition;\n}";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final String f7685g = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\n varying vec2 v_TexCoordinateAlphaMask;\nmat3 weight = mat3(0.0625,0.125,0.0625,0.125,0.25,0.125,0.0625,0.125,0.0625);\n int coreSize=3;\nfloat texelOffset = .01;\n\nvoid main() {\n   float alphaResult = 0.;\n   for(int y = 0; y < coreSize; y++) {\n       for(int x = 0;x < coreSize; x++) {\n           alphaResult += texture2D(uTextureAlphaMask, vec2(v_TexCoordinateAlphaMask.x + (-1.0 + float(x)) * texelOffset,v_TexCoordinateAlphaMask.y + (-1.0 + float(y)) * texelOffset)).a * weight[x][y];\n       }\n    }\n    gl_FragColor = vec4(0, 0, 0, alphaResult);\n}";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final String f7686h = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\n varying vec2 v_TexCoordinateAlphaMask;\n\nvoid main () {\n    vec4 alphaMaskColor = texture2D(uTextureAlphaMask, v_TexCoordinateAlphaMask);\n    gl_FragColor = vec4(0, 0, 0, alphaMaskColor.a);\n}";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final String f7687i = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\n varying vec2 v_TexCoordinateAlphaMask;\nvec3 weight = vec3(0.4026,0.2442,0.0545);\n \nvoid main() {\n   float texelOffset = .01;\n   vec2 uv[5];\n   uv[0]= v_TexCoordinateAlphaMask;\n   uv[1]=vec2(uv[0].x+texelOffset*1.0,  uv[0].y);\n   uv[2]=vec2(uv[0].x-texelOffset*1.0,  uv[0].y);\n   uv[3]=vec2(uv[0].x+texelOffset*2.0,  uv[0].y);\n   uv[4]=vec2(uv[0].x-texelOffset*2.0,  uv[0].y);\n   float alphaResult = texture2D(uTextureAlphaMask, uv[0]).a * weight[0];\n   for(int i = 1; i < 3; ++i) {\n       alphaResult += texture2D(uTextureAlphaMask, uv[2*i-1]).a * weight[i];\n       alphaResult += texture2D(uTextureAlphaMask, uv[2*i]).a * weight[i];\n    }\n    gl_FragColor = vec4(0, 0, 0, alphaResult);\n}";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public static final String f7688j = "uTextureAlphaMask";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public static final String f7689k = "vPosition";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public static final String f7690l = "vTexCoordinateAlphaMask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7694d;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public d(boolean z10) {
        l2.l lVar;
        String str;
        if (z10) {
            lVar = l2.l.f9670a;
            str = f7685g;
        } else {
            lVar = l2.l.f9670a;
            str = f7686h;
        }
        int iC = lVar.c(f7684f, str);
        this.f7691a = iC;
        this.f7692b = GLES20.glGetUniformLocation(iC, f7688j);
        this.f7693c = GLES20.glGetAttribLocation(iC, f7689k);
        this.f7694d = GLES20.glGetAttribLocation(iC, f7690l);
    }

    public final int a() {
        return this.f7693c;
    }

    public final int b() {
        return this.f7694d;
    }

    public final int c() {
        return this.f7692b;
    }

    public final void d() {
        GLES20.glUseProgram(this.f7691a);
    }
}
