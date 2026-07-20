package v0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n0.j;
import n0.o;
import n0.v;
import q0.n;
import q0.p;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class h extends v0.a {
    public final StringBuilder D;
    public final RectF E;
    public final Matrix F;
    public final Paint G;
    public final Paint H;
    public final Map<s0.e, List<p0.d>> I;
    public final LongSparseArray<String> J;
    public final n K;
    public final j L;
    public final n0.g M;

    @Nullable
    public q0.a<Integer, Integer> N;

    @Nullable
    public q0.a<Integer, Integer> O;

    @Nullable
    public q0.a<Integer, Integer> P;

    @Nullable
    public q0.a<Integer, Integer> Q;

    @Nullable
    public q0.a<Float, Float> R;

    @Nullable
    public q0.a<Float, Float> S;

    @Nullable
    public q0.a<Float, Float> T;

    @Nullable
    public q0.a<Float, Float> U;

    @Nullable
    public q0.a<Float, Float> V;

    @Nullable
    public q0.a<Float, Float> W;

    public class a extends Paint {
        public a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    public class b extends Paint {
        public b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16466a;

        static {
            int[] iArr = new int[s0.c.a.values().length];
            f16466a = iArr;
            try {
                iArr[s0.c.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16466a[s0.c.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16466a[s0.c.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(j jVar, d dVar) {
        t0.b bVar;
        t0.b bVar2;
        t0.a aVar;
        t0.a aVar2;
        super(jVar, dVar);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.L = jVar;
        this.M = dVar.a();
        n nVarL = dVar.q().l();
        this.K = nVarL;
        nVarL.a(this);
        i(nVarL);
        k kVarR = dVar.r();
        if (kVarR != null && (aVar2 = kVarR.f15419a) != null) {
            q0.a<Integer, Integer> aVarL = aVar2.l();
            this.N = aVarL;
            aVarL.a(this);
            i(this.N);
        }
        if (kVarR != null && (aVar = kVarR.f15420b) != null) {
            q0.a<Integer, Integer> aVarL2 = aVar.l();
            this.P = aVarL2;
            aVarL2.a(this);
            i(this.P);
        }
        if (kVarR != null && (bVar2 = kVarR.f15421c) != null) {
            q0.a<Float, Float> aVarL3 = bVar2.l();
            this.R = aVarL3;
            aVarL3.a(this);
            i(this.R);
        }
        if (kVarR == null || (bVar = kVarR.f15422d) == null) {
            return;
        }
        q0.a<Float, Float> aVarL4 = bVar.l();
        this.T = aVarL4;
        aVarL4.a(this);
        i(this.T);
    }

    public final void K(s0.c.a aVar, Canvas canvas, float f10) {
        int i10 = c.f16466a[aVar.ordinal()];
        if (i10 == 2) {
            canvas.translate(-f10, 0.0f);
        } else {
            if (i10 != 3) {
                return;
            }
            canvas.translate((-f10) / 2.0f, 0.0f);
        }
    }

    public final String L(String str, int i10) {
        int iCodePointAt = str.codePointAt(i10);
        int iCharCount = Character.charCount(iCodePointAt) + i10;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!X(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j10 = iCodePointAt;
        if (this.J.containsKey(j10)) {
            return this.J.get(j10);
        }
        this.D.setLength(0);
        while (i10 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i10);
            this.D.appendCodePoint(iCodePointAt3);
            i10 += Character.charCount(iCodePointAt3);
        }
        String string = this.D.toString();
        this.J.put(j10, string);
        return string;
    }

    public final void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void N(s0.e eVar, Matrix matrix, float f10, s0.c cVar, Canvas canvas) {
        List<p0.d> listU = U(eVar);
        for (int i10 = 0; i10 < listU.size(); i10++) {
            Path path = listU.get(i10).getPath();
            path.computeBounds(this.E, false);
            this.F.set(matrix);
            this.F.preTranslate(0.0f, z0.h.e() * (-cVar.f14894g));
            this.F.preScale(f10, f10);
            path.transform(this.F);
            if (cVar.f14898k) {
                Q(path, this.G, canvas);
                Q(path, this.H, canvas);
            } else {
                Q(path, this.H, canvas);
                Q(path, this.G, canvas);
            }
        }
    }

    public final void O(String str, s0.c cVar, Canvas canvas) {
        if (cVar.f14898k) {
            M(str, this.G, canvas);
            M(str, this.H, canvas);
        } else {
            M(str, this.H, canvas);
            M(str, this.G, canvas);
        }
    }

    public final void P(String str, s0.c cVar, Canvas canvas, float f10) {
        int length = 0;
        while (length < str.length()) {
            String strL = L(str, length);
            length += strL.length();
            O(strL, cVar, canvas);
            canvas.translate(this.G.measureText(strL) + f10, 0.0f);
        }
    }

    public final void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void R(String str, s0.c cVar, Matrix matrix, s0.d dVar, Canvas canvas, float f10, float f11) {
        float fFloatValue;
        for (int i10 = 0; i10 < str.length(); i10++) {
            s0.e eVar = this.M.c().get(s0.e.e(str.charAt(i10), dVar.b(), dVar.d()));
            if (eVar != null) {
                N(eVar, matrix, f11, cVar, canvas);
                float fE = z0.h.e() * ((float) eVar.d()) * f11 * f10;
                float f12 = cVar.f14892e / 10.0f;
                q0.a<Float, Float> aVar = this.U;
                if (aVar != null) {
                    fFloatValue = aVar.h().floatValue();
                } else {
                    q0.a<Float, Float> aVar2 = this.T;
                    if (aVar2 != null) {
                        fFloatValue = aVar2.h().floatValue();
                    }
                    canvas.translate((f12 * f10) + fE, 0.0f);
                }
                f12 += fFloatValue;
                canvas.translate((f12 * f10) + fE, 0.0f);
            }
        }
    }

    public final void S(s0.c cVar, Matrix matrix, s0.d dVar, Canvas canvas) {
        float fFloatValue;
        q0.a<Float, Float> aVar = this.W;
        if (aVar != null) {
            fFloatValue = aVar.h().floatValue();
        } else {
            q0.a<Float, Float> aVar2 = this.V;
            fFloatValue = aVar2 != null ? aVar2.h().floatValue() : cVar.f14890c;
        }
        float f10 = fFloatValue / 100.0f;
        float fG = z0.h.g(matrix);
        String str = cVar.f14888a;
        float fE = z0.h.e() * cVar.f14893f;
        List<String> listW = W(str);
        int size = listW.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = listW.get(i10);
            float fV = V(str2, dVar, f10, fG);
            canvas.save();
            K(cVar.f14891d, canvas, fV);
            canvas.translate(0.0f, (i10 * fE) - (((size - 1) * fE) / 2.0f));
            R(str2, cVar, matrix, dVar, canvas, fG, f10);
            canvas.restore();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a7 A[LOOP:0: B:23:0x00a5->B:24:0x00a7, LOOP_END] */
    public final void T(s0.c cVar, s0.d dVar, Matrix matrix, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float fE;
        List<String> listW;
        int size;
        int i10;
        z0.h.g(matrix);
        Typeface typefaceK = this.L.K(dVar.b(), dVar.d());
        if (typefaceK == null) {
            return;
        }
        String strB = cVar.f14888a;
        v vVarJ = this.L.J();
        if (vVarJ != null) {
            strB = vVarJ.b(strB);
        }
        this.G.setTypeface(typefaceK);
        q0.a<Float, Float> aVar = this.W;
        if (aVar != null) {
            fFloatValue = aVar.h().floatValue();
        } else {
            q0.a<Float, Float> aVar2 = this.V;
            fFloatValue = aVar2 != null ? aVar2.h().floatValue() : cVar.f14890c;
        }
        this.G.setTextSize(z0.h.e() * fFloatValue);
        this.H.setTypeface(this.G.getTypeface());
        this.H.setTextSize(this.G.getTextSize());
        float fE2 = z0.h.e() * cVar.f14893f;
        float f10 = cVar.f14892e / 10.0f;
        q0.a<Float, Float> aVar3 = this.U;
        if (aVar3 == null) {
            q0.a<Float, Float> aVar4 = this.T;
            if (aVar4 != null) {
                fFloatValue2 = aVar4.h().floatValue();
            }
            fE = ((z0.h.e() * f10) * fFloatValue) / 100.0f;
            listW = W(strB);
            size = listW.size();
            for (i10 = 0; i10 < size; i10++) {
                String str = listW.get(i10);
                float length = ((str.length() - 1) * fE) + this.H.measureText(str);
                canvas.save();
                K(cVar.f14891d, canvas, length);
                canvas.translate(0.0f, (i10 * fE2) - (((size - 1) * fE2) / 2.0f));
                P(str, cVar, canvas, fE);
                canvas.restore();
            }
        }
        fFloatValue2 = aVar3.h().floatValue();
        f10 += fFloatValue2;
        fE = ((z0.h.e() * f10) * fFloatValue) / 100.0f;
        listW = W(strB);
        size = listW.size();
        while (i10 < size) {
            String str2 = listW.get(i10);
            float length2 = ((str2.length() - 1) * fE) + this.H.measureText(str2);
            canvas.save();
            K(cVar.f14891d, canvas, length2);
            canvas.translate(0.0f, (i10 * fE2) - (((size - 1) * fE2) / 2.0f));
            P(str2, cVar, canvas, fE);
            canvas.restore();
        }
    }

    public final List<p0.d> U(s0.e eVar) {
        if (this.I.containsKey(eVar)) {
            return this.I.get(eVar);
        }
        List<u0.n> listA = eVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new p0.d(this.L, this, listA.get(i10)));
        }
        this.I.put(eVar, arrayList);
        return arrayList;
    }

    public final float V(String str, s0.d dVar, float f10, float f11) {
        float fD = 0.0f;
        for (int i10 = 0; i10 < str.length(); i10++) {
            s0.e eVar = this.M.c().get(s0.e.e(str.charAt(i10), dVar.b(), dVar.d()));
            if (eVar != null) {
                fD = (float) ((eVar.d() * ((double) f10) * ((double) z0.h.e()) * ((double) f11)) + ((double) fD));
            }
        }
        return fD;
    }

    public final List<String> W(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    public final boolean X(int i10) {
        return Character.getType(i10) == 16 || Character.getType(i10) == 27 || Character.getType(i10) == 6 || Character.getType(i10) == 28 || Character.getType(i10) == 19;
    }

    @Override // v0.a, p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        super.c(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.M.b().width(), this.M.b().height());
    }

    @Override // v0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == o.f11044a) {
            q0.a<Integer, Integer> aVar = this.O;
            if (aVar != null) {
                C(aVar);
            }
            if (jVar == null) {
                this.O = null;
                return;
            }
            p pVar = new p(jVar, null);
            this.O = pVar;
            pVar.a(this);
            i(this.O);
            return;
        }
        if (t10 == o.f11045b) {
            q0.a<Integer, Integer> aVar2 = this.Q;
            if (aVar2 != null) {
                C(aVar2);
            }
            if (jVar == null) {
                this.Q = null;
                return;
            }
            p pVar2 = new p(jVar, null);
            this.Q = pVar2;
            pVar2.a(this);
            i(this.Q);
            return;
        }
        if (t10 == o.f11060q) {
            q0.a<Float, Float> aVar3 = this.S;
            if (aVar3 != null) {
                C(aVar3);
            }
            if (jVar == null) {
                this.S = null;
                return;
            }
            p pVar3 = new p(jVar, null);
            this.S = pVar3;
            pVar3.a(this);
            i(this.S);
            return;
        }
        if (t10 == o.f11061r) {
            q0.a<Float, Float> aVar4 = this.U;
            if (aVar4 != null) {
                C(aVar4);
            }
            if (jVar == null) {
                this.U = null;
                return;
            }
            p pVar4 = new p(jVar, null);
            this.U = pVar4;
            pVar4.a(this);
            i(this.U);
            return;
        }
        if (t10 == o.D) {
            q0.a<Float, Float> aVar5 = this.W;
            if (aVar5 != null) {
                C(aVar5);
            }
            if (jVar == null) {
                this.W = null;
                return;
            }
            p pVar5 = new p(jVar, null);
            this.W = pVar5;
            pVar5.a(this);
            i(this.W);
        }
    }

    @Override // v0.a
    public void t(Canvas canvas, Matrix matrix, int i10) {
        canvas.save();
        if (!this.L.D0()) {
            canvas.concat(matrix);
        }
        s0.c cVarH = this.K.h();
        s0.d dVar = this.M.g().get(cVarH.f14889b);
        if (dVar == null) {
            canvas.restore();
            return;
        }
        q0.a<Integer, Integer> aVar = this.O;
        if (aVar != null) {
            this.G.setColor(aVar.h().intValue());
        } else {
            q0.a<Integer, Integer> aVar2 = this.N;
            if (aVar2 != null) {
                this.G.setColor(aVar2.h().intValue());
            } else {
                this.G.setColor(cVarH.f14895h);
            }
        }
        q0.a<Integer, Integer> aVar3 = this.Q;
        if (aVar3 != null) {
            this.H.setColor(aVar3.h().intValue());
        } else {
            q0.a<Integer, Integer> aVar4 = this.P;
            if (aVar4 != null) {
                this.H.setColor(aVar4.h().intValue());
            } else {
                this.H.setColor(cVarH.f14896i);
            }
        }
        int iIntValue = ((this.f16432v.h() == null ? 100 : this.f16432v.h().h().intValue()) * 255) / 100;
        this.G.setAlpha(iIntValue);
        this.H.setAlpha(iIntValue);
        q0.a<Float, Float> aVar5 = this.S;
        if (aVar5 != null) {
            this.H.setStrokeWidth(aVar5.h().floatValue());
        } else {
            q0.a<Float, Float> aVar6 = this.R;
            if (aVar6 != null) {
                this.H.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.H.setStrokeWidth(z0.h.e() * cVarH.f14897j * z0.h.g(matrix));
            }
        }
        if (this.L.D0()) {
            S(cVarH, matrix, dVar, canvas);
        } else {
            T(cVarH, dVar, matrix, canvas);
        }
        canvas.restore();
    }
}
