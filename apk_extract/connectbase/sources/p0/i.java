package p0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f12618z = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f12619o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f12620p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f12621q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f12622r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f12623s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u0.f f12624t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12625u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q0.a<u0.c, u0.c> f12626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q0.a<PointF, PointF> f12627w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q0.a<PointF, PointF> f12628x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public q0.p f12629y;

    public i(n0.j jVar, v0.a aVar, u0.e eVar) {
        super(jVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.f12621q = new LongSparseArray<>();
        this.f12622r = new LongSparseArray<>();
        this.f12623s = new RectF();
        this.f12619o = eVar.j();
        this.f12624t = eVar.f();
        this.f12620p = eVar.n();
        this.f12625u = (int) (jVar.t().d() / 32.0f);
        q0.a<u0.c, u0.c> aVarL = eVar.e().l();
        this.f12626v = aVarL;
        aVarL.a(this);
        aVar.i(aVarL);
        q0.a<PointF, PointF> aVarL2 = eVar.l().l();
        this.f12627w = aVarL2;
        aVarL2.a(this);
        aVar.i(aVarL2);
        q0.a<PointF, PointF> aVarL3 = eVar.d().l();
        this.f12628x = aVarL3;
        aVarL3.a(this);
        aVar.i(aVarL3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == n0.o.F) {
            q0.p pVar = this.f12629y;
            if (pVar != null) {
                this.f12557f.C(pVar);
            }
            if (jVar == null) {
                this.f12629y = null;
                return;
            }
            q0.p pVar2 = new q0.p(jVar, null);
            this.f12629y = pVar2;
            pVar2.a(this);
            this.f12557f.i(this.f12629y);
        }
    }

    @Override // p0.a, p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12620p) {
            return;
        }
        c(this.f12623s, matrix, false);
        Shader shaderK = this.f12624t == u0.f.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.f12560i.setShader(shaderK);
        super.g(canvas, matrix, i10);
    }

    @Override // p0.c
    public String getName() {
        return this.f12619o;
    }

    public final int[] i(int[] iArr) {
        q0.p pVar = this.f12629y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    public final int j() {
        int iRound = Math.round(this.f12627w.f() * this.f12625u);
        int iRound2 = Math.round(this.f12628x.f() * this.f12625u);
        int iRound3 = Math.round(this.f12626v.f() * this.f12625u);
        int i10 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i10 = i10 * 31 * iRound2;
        }
        return iRound3 != 0 ? i10 * 31 * iRound3 : i10;
    }

    public final LinearGradient k() {
        long j10 = j();
        LinearGradient linearGradient = this.f12621q.get(j10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.f12627w.h();
        PointF pointFH2 = this.f12628x.h();
        u0.c cVarH = this.f12626v.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, i(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.f12621q.put(j10, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient l() {
        long j10 = j();
        RadialGradient radialGradient = this.f12622r.get(j10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.f12627w.h();
        PointF pointFH2 = this.f12628x.h();
        u0.c cVarH = this.f12626v.h();
        int[] iArrI = i(cVarH.a());
        float[] fArrB = cVarH.b();
        float f10 = pointFH.x;
        float f11 = pointFH.y;
        RadialGradient radialGradient2 = new RadialGradient(f10, f11, (float) Math.hypot(pointFH2.x - f10, pointFH2.y - f11), iArrI, fArrB, Shader.TileMode.CLAMP);
        this.f12622r.put(j10, radialGradient2);
        return radialGradient2;
    }
}
