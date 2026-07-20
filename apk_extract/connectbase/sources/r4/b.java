package r4;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f14229k = "uniform mat4 u_Matrix;attribute vec4 vTexCoordinate;attribute vec4 a_position;varying vec2 v_textureCoord;uniform mat4 rotateMatrix;uniform mat4 textureTransform;void main(){gl_Position = a_position;v_textureCoord = (textureTransform * vTexCoordinate).xy;}";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f14230l = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 v_textureCoord;\nuniform samplerExternalOES u_samplerTexture;\nvoid main(){\ngl_FragColor = texture2D(u_samplerTexture,v_textureCoord);\n}\n";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f14231m = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float[] f14232n = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final short[] f14233o = {0, 1, 2, 0, 2, 3};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer f14237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatBuffer f14238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShortBuffer f14239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14243j;

    public final void a() {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f14234a = iGlCreateProgram;
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, this.f14235b);
            GLES20.glAttachShader(this.f14234a, this.f14236c);
            GLES20.glLinkProgram(this.f14234a);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.f14234a, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.f14234a);
                this.f14234a = 0;
            }
        }
        if (this.f14234a == 0) {
            throw new j4.a("Fail to create program!");
        }
        String str = a.K;
        m.c(str, "Create program successful!");
        GLES20.glUseProgram(this.f14234a);
        this.f14240g = GLES20.glGetAttribLocation(this.f14234a, "a_position");
        this.f14241h = GLES20.glGetAttribLocation(this.f14234a, "vTexCoordinate");
        this.f14242i = GLES20.glGetUniformLocation(this.f14234a, "u_samplerTexture");
        this.f14243j = GLES20.glGetUniformLocation(this.f14234a, "textureTransform");
        m.e(str, "   mAPositionIndex=" + this.f14240g + "   mATextureCoordIndex=" + this.f14241h + "   mUniformTextureIndex=" + this.f14242i + "  mTextureTransfromIndex=" + this.f14243j);
    }

    public final int b(String str, int i10) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                m.c(a.K, GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        if (iGlCreateShader == 0) {
            if (i10 == 35633) {
                throw new j4.b("Fail to create Vertex Shader!");
            }
            if (i10 == 35632) {
                throw new j4.b("Fail to create Fragement Shader");
            }
        } else if (i10 == 35633) {
            m.c(a.K, "Create vertex shader successful!");
        } else if (i10 == 35632) {
            m.c(a.K, "Create fragment shader successful!");
        }
        return iGlCreateShader;
    }

    public final void c() {
        this.f14235b = b(f14229k, 35633);
        this.f14236c = b(f14230l, 35632);
    }

    public void d(int i10, float[] fArr) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        GLES20.glUseProgram(this.f14234a);
        GLES20.glEnableVertexAttribArray(this.f14240g);
        GLES20.glVertexAttribPointer(this.f14240g, 3, 5126, false, 12, (Buffer) this.f14237d);
        GLES20.glEnableVertexAttribArray(this.f14241h);
        GLES20.glVertexAttribPointer(this.f14241h, 4, 5126, false, 0, (Buffer) this.f14238e);
        GLES20.glUniform1i(this.f14242i, 0);
        GLES20.glUniformMatrix4fv(this.f14243j, 1, false, fArr, 0);
        GLES20.glDrawElements(4, f14233o.length, 5123, this.f14239f);
    }

    public void e() {
        c();
        a();
        f();
    }

    public final void f() {
        float[] fArr = f14231m;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14237d = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f14232n;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14238e = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        short[] sArr = f14233o;
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.f14239f = shortBufferAsShortBuffer;
        shortBufferAsShortBuffer.put(sArr).position(0);
    }

    public void g() {
        GLES20.glDeleteProgram(this.f14234a);
    }
}
