package m1;

import af.r5;
import android.graphics.Color;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1.c f7582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f7584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f7585d;
    public final i e;
    public final i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f7586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7587h = Float.NaN;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f7588i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7589j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7590k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f7591l = new float[9];

    public h(a aVar, s1.c cVar, r5 r5Var) {
        this.f7583b = aVar;
        this.f7582a = cVar;
        e eVarG = ((q1.a) r5Var.f557b).g();
        this.f7584c = (f) eVarG;
        eVarG.a(this);
        cVar.f(eVarG);
        i iVarG = ((q1.b) r5Var.f558c).g();
        this.f7585d = iVarG;
        iVarG.a(this);
        cVar.f(iVarG);
        i iVarG2 = ((q1.b) r5Var.f559d).g();
        this.e = iVarG2;
        iVarG2.a(this);
        cVar.f(iVarG2);
        i iVarG3 = ((q1.b) r5Var.e).g();
        this.f = iVarG3;
        iVarG3.a(this);
        cVar.f(iVarG3);
        i iVarG4 = ((q1.b) r5Var.f560h).g();
        this.f7586g = iVarG4;
        iVarG4.a(this);
        cVar.f(iVarG4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, m1.a] */
    @Override // m1.a
    public final void a() {
        this.f7583b.a();
    }

    public final void b(k1.a aVar, Matrix matrix, int i8) {
        float fL = this.e.l() * 0.017453292f;
        float fFloatValue = ((Float) this.f.f()).floatValue();
        double d7 = fL;
        float fSin = ((float) Math.sin(d7)) * fFloatValue;
        float fCos = ((float) Math.cos(d7 + 3.141592653589793d)) * fFloatValue;
        Matrix matrixE = this.f7582a.f9467w.e();
        float[] fArr = this.f7591l;
        matrixE.getValues(fArr);
        float f = fArr[0];
        float f4 = fArr[4];
        matrix.getValues(fArr);
        float f10 = fArr[0] / f;
        float f11 = fSin * f10;
        float f12 = fCos * (fArr[4] / f4);
        int iIntValue = ((Integer) this.f7584c.f()).intValue();
        int iArgb = Color.argb(Math.round((((Float) this.f7585d.f()).floatValue() * i8) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        float fMax = Math.max(((Float) this.f7586g.f()).floatValue() * f10 * 0.33f, Float.MIN_VALUE);
        if (this.f7587h == fMax && this.f7588i == f11 && this.f7589j == f12 && this.f7590k == iArgb) {
            return;
        }
        this.f7587h = fMax;
        this.f7588i = f11;
        this.f7589j = f12;
        this.f7590k = iArgb;
        aVar.setShadowLayer(fMax, f11, f12, iArgb);
    }

    public final void c(x1.c cVar) {
        this.f7585d.k(new g(cVar));
    }
}
