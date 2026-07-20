package f2;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements z {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final a f5682n = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final String f5683o = "AnimPlayer.Render";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l2.c f5684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final l2.c f5685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final l2.c f5686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final q f5690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public int[] f5692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5696m;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public c0(@os.l SurfaceTexture surfaceTexture) {
        l0.p(surfaceTexture, "surfaceTexture");
        this.f5684a = new l2.c();
        this.f5685b = new l2.c();
        this.f5686c = new l2.c();
        q qVar = new q();
        this.f5690g = qVar;
        this.f5692i = new int[1];
        qVar.e(surfaceTexture);
        f();
    }

    @Override // f2.z
    public void a(@os.l f2.a aVar) {
        l0.p(aVar, "config");
        m(aVar);
        l(aVar);
    }

    @Override // f2.z
    public void b() {
        this.f5690g.f();
    }

    @Override // f2.z
    public void c(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.f5687d = true;
        this.f5688e = i10;
        this.f5689f = i11;
    }

    @Override // f2.z
    public void d(int i10, int i11, @os.m byte[] bArr, @os.m byte[] bArr2, @os.m byte[] bArr3) {
        z.a.g(this, i10, i11, bArr, bArr2, bArr3);
    }

    @Override // f2.z
    public void e() {
        int i10;
        int i11;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.f5687d && (i10 = this.f5688e) > 0 && (i11 = this.f5689f) > 0) {
            this.f5687d = false;
            GLES20.glViewport(0, 0, i10, i11);
        }
        k();
    }

    @Override // f2.z
    public void f() {
        int iC = l2.l.f9670a.c(d0.f5701b, d0.f5702c);
        this.f5691h = iC;
        this.f5693j = GLES20.glGetUniformLocation(iC, "texture");
        this.f5694k = GLES20.glGetAttribLocation(this.f5691h, i2.d.f7689k);
        this.f5695l = GLES20.glGetAttribLocation(this.f5691h, "vTexCoordinateAlpha");
        this.f5696m = GLES20.glGetAttribLocation(this.f5691h, "vTexCoordinateRgb");
        int[] iArr = this.f5692i;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20.glBindTexture(36197, this.f5692i[0]);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    @Override // f2.z
    public void g() {
        i();
        this.f5690g.d();
    }

    @Override // f2.z
    public int h() {
        return this.f5692i[0];
    }

    @Override // f2.z
    public void i() {
        int[] iArr = this.f5692i;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // f2.z
    public void j() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f5690g.f();
    }

    public final void k() {
        GLES20.glUseProgram(this.f5691h);
        this.f5684a.c(this.f5694k);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f5692i[0]);
        GLES20.glUniform1i(this.f5693j, 0);
        this.f5685b.c(this.f5695l);
        this.f5686c.c(this.f5696m);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public final void l(f2.a aVar) {
        l2.n nVar = l2.n.f9679a;
        float[] fArrA = nVar.a(aVar.f5655e, aVar.f5656f, aVar.f5660j, this.f5685b.f9644a);
        float[] fArrA2 = nVar.a(aVar.f5655e, aVar.f5656f, aVar.f5661k, this.f5686c.f9644a);
        this.f5685b.b(fArrA);
        this.f5686c.b(fArrA2);
    }

    public final void m(f2.a aVar) {
        l2.c cVar = this.f5684a;
        l2.p pVar = l2.p.f9682a;
        int i10 = aVar.f5653c;
        int i11 = aVar.f5654d;
        cVar.b(pVar.a(i10, i11, new a0(0, 0, i10, i11), this.f5684a.f9644a));
    }
}
