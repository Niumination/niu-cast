package f2;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements z {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final a f5705w = new a();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final String f5706x = "AnimPlayer.YUVRender";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l2.c f5707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final l2.c f5708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final l2.c f5709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public int[] f5717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5719m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.m
    public ByteBuffer f5722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.m
    public ByteBuffer f5723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.m
    public ByteBuffer f5724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public final q f5725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5726t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public final float[] f5727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final float[] f5728v;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public e0(@os.l SurfaceTexture surfaceTexture) {
        l0.p(surfaceTexture, "surfaceTexture");
        this.f5707a = new l2.c();
        this.f5708b = new l2.c();
        this.f5709c = new l2.c();
        this.f5717k = new int[3];
        q qVar = new q();
        this.f5725s = qVar;
        this.f5726t = 4;
        this.f5727u = new float[]{0.0f, -0.5019608f, -0.5019608f};
        this.f5728v = new float[]{1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};
        qVar.e(surfaceTexture);
        f();
    }

    private final void k() {
        if (this.f5720n <= 0 || this.f5721o <= 0 || this.f5722p == null || this.f5723q == null || this.f5724r == null) {
            return;
        }
        GLES20.glUseProgram(this.f5710d);
        this.f5707a.c(this.f5711e);
        this.f5708b.c(this.f5713g);
        this.f5709c.c(this.f5712f);
        GLES20.glPixelStorei(3317, this.f5726t);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f5717k[0]);
        GLES20.glTexImage2D(3553, 0, 6409, this.f5720n, this.f5721o, 0, 6409, 5121, this.f5722p);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f5717k[1]);
        GLES20.glTexImage2D(3553, 0, 6409, this.f5720n / 2, this.f5721o / 2, 0, 6409, 5121, this.f5723q);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f5717k[2]);
        GLES20.glTexImage2D(3553, 0, 6409, this.f5720n / 2, this.f5721o / 2, 0, 6409, 5121, this.f5724r);
        GLES20.glUniform1i(this.f5714h, 0);
        GLES20.glUniform1i(this.f5715i, 1);
        GLES20.glUniform1i(this.f5716j, 2);
        GLES20.glUniform3fv(this.f5719m, 1, FloatBuffer.wrap(this.f5727u));
        GLES20.glUniformMatrix3fv(this.f5718l, 1, false, this.f5728v, 0);
        GLES20.glDrawArrays(5, 0, 4);
        ByteBuffer byteBuffer = this.f5722p;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f5723q;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = this.f5724r;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
        }
        this.f5722p = null;
        this.f5723q = null;
        this.f5724r = null;
        GLES20.glDisableVertexAttribArray(this.f5711e);
        GLES20.glDisableVertexAttribArray(this.f5712f);
        GLES20.glDisableVertexAttribArray(this.f5713g);
    }

    @Override // f2.z
    public void a(@os.l f2.a aVar) {
        l0.p(aVar, "config");
        l2.c cVar = this.f5707a;
        l2.p pVar = l2.p.f9682a;
        int i10 = aVar.f5653c;
        int i11 = aVar.f5654d;
        cVar.b(pVar.a(i10, i11, new a0(0, 0, i10, i11), this.f5707a.f9644a));
        l2.n nVar = l2.n.f9679a;
        float[] fArrA = nVar.a(aVar.f5655e, aVar.f5656f, aVar.f5660j, this.f5708b.f9644a);
        float[] fArrA2 = nVar.a(aVar.f5655e, aVar.f5656f, aVar.f5661k, this.f5709c.f9644a);
        this.f5708b.b(fArrA);
        this.f5709c.b(fArrA2);
    }

    @Override // f2.z
    public void b() {
        this.f5725s.f();
    }

    @Override // f2.z
    public void c(int i10, int i11) {
    }

    @Override // f2.z
    public void d(int i10, int i11, @os.m byte[] bArr, @os.m byte[] bArr2, @os.m byte[] bArr3) {
        this.f5720n = i10;
        this.f5721o = i11;
        this.f5722p = ByteBuffer.wrap(bArr);
        this.f5723q = ByteBuffer.wrap(bArr2);
        this.f5724r = ByteBuffer.wrap(bArr3);
        int i12 = this.f5720n;
        if ((i12 / 2) % 4 != 0) {
            this.f5726t = (i12 / 2) % 2 != 0 ? 1 : 2;
        }
    }

    @Override // f2.z
    public void e() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        k();
    }

    @Override // f2.z
    public void f() {
        int iC = l2.l.f9670a.c(f0.f5733b, f0.f5734c);
        this.f5710d = iC;
        this.f5711e = GLES20.glGetAttribLocation(iC, "v_Position");
        this.f5712f = GLES20.glGetAttribLocation(this.f5710d, "vTexCoordinateRgb");
        this.f5713g = GLES20.glGetAttribLocation(this.f5710d, "vTexCoordinateAlpha");
        this.f5714h = GLES20.glGetUniformLocation(this.f5710d, "sampler_y");
        this.f5715i = GLES20.glGetUniformLocation(this.f5710d, "sampler_u");
        this.f5716j = GLES20.glGetUniformLocation(this.f5710d, "sampler_v");
        this.f5718l = GLES20.glGetUniformLocation(this.f5710d, "convertMatrix");
        this.f5719m = GLES20.glGetUniformLocation(this.f5710d, TypedValues.CycleType.S_WAVE_OFFSET);
        int[] iArr = this.f5717k;
        int i10 = 0;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        int[] iArr2 = this.f5717k;
        int length = iArr2.length;
        while (i10 < length) {
            int i11 = iArr2[i10];
            i10++;
            GLES20.glBindTexture(3553, i11);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
        }
    }

    @Override // f2.z
    public void g() {
        i();
        this.f5725s.d();
    }

    @Override // f2.z
    public int h() {
        return this.f5717k[0];
    }

    @Override // f2.z
    public void i() {
        int[] iArr = this.f5717k;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // f2.z
    public void j() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f5725s.f();
    }
}
