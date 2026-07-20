package l1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import j1.b0;
import j1.x;

/* JADX INFO: loaded from: classes.dex */
public final class j extends b {
    public final m1.j A;
    public m1.r B;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f7139r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f7140s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LongSparseArray f7141t;
    public final LongSparseArray u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f7142v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r1.f f7143w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7144x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m1.j f7145y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m1.j f7146z;

    public j(x xVar, s1.c cVar, r1.e eVar) {
        super(xVar, cVar, eVar.f9261h.toPaintCap(), eVar.f9262i.toPaintJoin(), eVar.f9263j, eVar.f9259d, eVar.f9260g, eVar.f9264k, eVar.f9265l);
        this.f7141t = new LongSparseArray();
        this.u = new LongSparseArray();
        this.f7142v = new RectF();
        this.f7139r = eVar.f9256a;
        this.f7143w = eVar.f9257b;
        this.f7140s = eVar.f9266m;
        this.f7144x = (int) (xVar.f6011a.b() / 32.0f);
        m1.e eVarG = eVar.f9258c.g();
        this.f7145y = (m1.j) eVarG;
        eVarG.a(this);
        cVar.f(eVarG);
        m1.e eVarG2 = eVar.e.g();
        this.f7146z = (m1.j) eVarG2;
        eVarG2.a(this);
        cVar.f(eVarG2);
        m1.e eVarG3 = eVar.f.g();
        this.A = (m1.j) eVarG3;
        eVarG3.a(this);
        cVar.f(eVarG3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l1.b, p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        super.e(colorFilter, cVar);
        if (colorFilter == b0.G) {
            m1.r rVar = this.B;
            s1.c cVar2 = this.f;
            if (rVar != null) {
                cVar2.n(rVar);
            }
            m1.r rVar2 = new m1.r(cVar, null);
            this.B = rVar2;
            rVar2.a(this);
            cVar2.f(this.B);
        }
    }

    public final int[] f(int[] iArr) {
        m1.r rVar = this.B;
        if (rVar != null) {
            Integer[] numArr = (Integer[]) rVar.f();
            int i8 = 0;
            if (iArr.length == numArr.length) {
                while (i8 < iArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i8 < numArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            }
        }
        return iArr;
    }

    @Override // l1.b, l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        Shader linearGradient;
        if (this.f7140s) {
            return;
        }
        d(this.f7142v, matrix, false);
        r1.f fVar = r1.f.LINEAR;
        r1.f fVar2 = this.f7143w;
        m1.j jVar = this.f7145y;
        m1.j jVar2 = this.A;
        m1.j jVar3 = this.f7146z;
        if (fVar2 == fVar) {
            long jH = h();
            LongSparseArray longSparseArray = this.f7141t;
            linearGradient = (LinearGradient) longSparseArray.get(jH);
            if (linearGradient == null) {
                PointF pointF = (PointF) jVar3.f();
                PointF pointF2 = (PointF) jVar2.f();
                r1.c cVar = (r1.c) jVar.f();
                linearGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, f(cVar.f9249b), cVar.f9248a, Shader.TileMode.CLAMP);
                longSparseArray.put(jH, linearGradient);
            }
        } else {
            long jH2 = h();
            LongSparseArray longSparseArray2 = this.u;
            linearGradient = (RadialGradient) longSparseArray2.get(jH2);
            if (linearGradient == null) {
                PointF pointF3 = (PointF) jVar3.f();
                PointF pointF4 = (PointF) jVar2.f();
                r1.c cVar2 = (r1.c) jVar.f();
                int[] iArrF = f(cVar2.f9249b);
                float f = pointF3.x;
                float f4 = pointF3.y;
                RadialGradient radialGradient = new RadialGradient(f, f4, (float) Math.hypot(pointF4.x - f, pointF4.y - f4), iArrF, cVar2.f9248a, Shader.TileMode.CLAMP);
                longSparseArray2.put(jH2, radialGradient);
                linearGradient = radialGradient;
            }
        }
        this.f7089i.setShader(linearGradient);
        super.g(canvas, matrix, i8);
    }

    @Override // l1.d
    public final String getName() {
        return this.f7139r;
    }

    public final int h() {
        float f = this.f7146z.f7577d;
        float f4 = this.f7144x;
        int iRound = Math.round(f * f4);
        int iRound2 = Math.round(this.A.f7577d * f4);
        int iRound3 = Math.round(this.f7145y.f7577d * f4);
        int i8 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i8 = i8 * 31 * iRound2;
        }
        return iRound3 != 0 ? i8 * 31 * iRound3 : i8;
    }
}
