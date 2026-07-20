package v0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n0.j;
import n0.o;
import q0.p;

/* JADX INFO: loaded from: classes.dex */
public class b extends v0.a {

    @Nullable
    public q0.a<Float, Float> D;
    public final List<v0.a> E;
    public final RectF F;
    public final RectF G;
    public Paint H;

    @Nullable
    public Boolean I;

    @Nullable
    public Boolean J;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16439a;

        static {
            int[] iArr = new int[d.b.values().length];
            f16439a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16439a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(j jVar, d dVar, List<d> list, n0.g gVar) {
        int i10;
        v0.a aVar;
        super(jVar, dVar);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        t0.b bVarS = dVar.s();
        if (bVarS != null) {
            q0.a<Float, Float> aVarL = bVarS.l();
            this.D = aVarL;
            i(aVarL);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(gVar.j().size());
        int size = list.size() - 1;
        v0.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar2 = list.get(size);
            v0.a aVarU = v0.a.u(dVar2, jVar, gVar);
            if (aVarU != null) {
                longSparseArray.put(aVarU.v().b(), aVarU);
                if (aVar2 != null) {
                    aVar2.E(aVarU);
                    aVar2 = null;
                } else {
                    this.E.add(0, aVarU);
                    int i11 = a.f16439a[dVar2.f().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        aVar2 = aVarU;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < longSparseArray.size(); i10++) {
            v0.a aVar3 = (v0.a) longSparseArray.get(longSparseArray.keyAt(i10));
            if (aVar3 != null && (aVar = (v0.a) longSparseArray.get(aVar3.v().h())) != null) {
                aVar3.G(aVar);
            }
        }
    }

    @Override // v0.a
    public void D(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            this.E.get(i11).e(fVar, i10, list, fVar2);
        }
    }

    @Override // v0.a
    public void F(boolean z10) {
        super.F(z10);
        Iterator<v0.a> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().F(z10);
        }
    }

    @Override // v0.a
    public void H(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        super.H(f10);
        if (this.D != null) {
            f10 = ((this.f16425o.a().h() * this.D.h().floatValue()) - this.f16425o.a().p()) / (this.f16424n.t().e() + 0.01f);
        }
        if (this.D == null) {
            f10 -= this.f16425o.p();
        }
        if (this.f16425o.t() != 0.0f) {
            f10 /= this.f16425o.t();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).H(f10);
        }
    }

    public boolean K() {
        if (this.J == null) {
            for (int size = this.E.size() - 1; size >= 0; size--) {
                v0.a aVar = this.E.get(size);
                if (aVar instanceof f) {
                    if (aVar.w()) {
                        this.J = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).K()) {
                    this.J = Boolean.TRUE;
                    return true;
                }
            }
            this.J = Boolean.FALSE;
        }
        return this.J.booleanValue();
    }

    public boolean L() {
        if (this.I == null) {
            if (x()) {
                this.I = Boolean.TRUE;
                return true;
            }
            for (int size = this.E.size() - 1; size >= 0; size--) {
                if (this.E.get(size).x()) {
                    this.I = Boolean.TRUE;
                    return true;
                }
            }
            this.I = Boolean.FALSE;
        }
        return this.I.booleanValue();
    }

    @Override // v0.a, p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        super.c(rectF, matrix, z10);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).c(this.F, this.f16423m, true);
            rectF.union(this.F);
        }
    }

    @Override // v0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == o.C) {
            if (jVar == null) {
                q0.a<Float, Float> aVar = this.D;
                if (aVar != null) {
                    aVar.n(null);
                    return;
                }
                return;
            }
            p pVar = new p(jVar, null);
            this.D = pVar;
            pVar.a(this);
            i(this.D);
        }
    }

    @Override // v0.a
    public void t(Canvas canvas, Matrix matrix, int i10) {
        n0.e.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f16425o.j(), this.f16425o.i());
        matrix.mapRect(this.G);
        boolean z10 = this.f16424n.O() && this.E.size() > 1 && i10 != 255;
        if (z10) {
            this.H.setAlpha(i10);
            z0.h.n(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (!this.G.isEmpty() ? canvas.clipRect(this.G) : true) {
                this.E.get(size).g(canvas, matrix, i10);
            }
        }
        canvas.restore();
        n0.e.b("CompositionLayer#draw");
    }
}
