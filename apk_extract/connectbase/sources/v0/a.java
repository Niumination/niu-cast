package v0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n0.j;
import q0.o;
import u0.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements p0.e, q0.a.b, s0.g {
    public static final int A = 16;
    public static final int B = 1;
    public static final int C = 19;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f16410z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f16411a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f16412b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f16413c = new o0.a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f16414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f16415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f16416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f16417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f16418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f16419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f16420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f16421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f16422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f16423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f16424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f16425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public q0.g f16426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public q0.c f16427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public a f16428r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public a f16429s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<a> f16430t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<q0.a<?, ?>> f16431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o f16432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16434x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public Paint f16435y;

    /* JADX INFO: renamed from: v0.a$a, reason: collision with other inner class name */
    public class C0442a implements q0.a.b {
        public C0442a() {
        }

        @Override // q0.a.b
        public void a() {
            a aVar = a.this;
            aVar.I(aVar.f16427q.p() == 1.0f);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16438b;

        static {
            int[] iArr = new int[u0.g.a.values().length];
            f16438b = iArr;
            try {
                iArr[u0.g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16438b[u0.g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16438b[u0.g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16438b[u0.g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f16437a = iArr2;
            try {
                iArr2[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16437a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16437a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16437a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16437a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16437a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16437a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(j jVar, d dVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f16414d = new o0.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f16415e = new o0.a(1, mode2);
        o0.a aVar = new o0.a(1);
        this.f16416f = aVar;
        this.f16417g = new o0.a(PorterDuff.Mode.CLEAR);
        this.f16418h = new RectF();
        this.f16419i = new RectF();
        this.f16420j = new RectF();
        this.f16421k = new RectF();
        this.f16423m = new Matrix();
        this.f16431u = new ArrayList();
        this.f16433w = true;
        this.f16424n = jVar;
        this.f16425o = dVar;
        this.f16422l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        o oVarB = dVar.u().b();
        this.f16432v = oVarB;
        oVarB.b(this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            q0.g gVar = new q0.g(dVar.e());
            this.f16426p = gVar;
            Iterator<q0.a<l, Path>> it = gVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (q0.a<Integer, Integer> aVar2 : this.f16426p.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        J();
    }

    @Nullable
    public static a u(d dVar, j jVar, n0.g gVar) {
        switch (b.f16437a[dVar.d().ordinal()]) {
            case 1:
                return new f(jVar, dVar);
            case 2:
                return new v0.b(jVar, dVar, gVar.o(dVar.k()), gVar);
            case 3:
                return new g(jVar, dVar);
            case 4:
                return new c(jVar, dVar);
            case 5:
                return new e(jVar, dVar);
            case 6:
                return new h(jVar, dVar);
            default:
                z0.d.e("Unknown layer type " + dVar.d());
                return null;
        }
    }

    public final void A() {
        this.f16424n.invalidateSelf();
    }

    public final void B(float f10) {
        this.f16424n.t().n().e(this.f16425o.g(), f10);
    }

    public void C(q0.a<?, ?> aVar) {
        this.f16431u.remove(aVar);
    }

    public void D(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
    }

    public void E(@Nullable a aVar) {
        this.f16428r = aVar;
    }

    public void F(boolean z10) {
        if (z10 && this.f16435y == null) {
            this.f16435y = new o0.a();
        }
        this.f16434x = z10;
    }

    public void G(@Nullable a aVar) {
        this.f16429s = aVar;
    }

    public void H(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f16432v.j(f10);
        if (this.f16426p != null) {
            for (int i10 = 0; i10 < this.f16426p.a().size(); i10++) {
                this.f16426p.a().get(i10).m(f10);
            }
        }
        if (this.f16425o.t() != 0.0f) {
            f10 /= this.f16425o.t();
        }
        q0.c cVar = this.f16427q;
        if (cVar != null) {
            cVar.m(f10 / this.f16425o.t());
        }
        a aVar = this.f16428r;
        if (aVar != null) {
            this.f16428r.H(aVar.f16425o.t() * f10);
        }
        for (int i11 = 0; i11 < this.f16431u.size(); i11++) {
            this.f16431u.get(i11).m(f10);
        }
    }

    public final void I(boolean z10) {
        if (z10 != this.f16433w) {
            this.f16433w = z10;
            A();
        }
    }

    public final void J() {
        if (this.f16425o.c().isEmpty()) {
            I(true);
            return;
        }
        q0.c cVar = new q0.c(this.f16425o.c());
        this.f16427q = cVar;
        cVar.l();
        this.f16427q.a(new C0442a());
        I(this.f16427q.h().floatValue() == 1.0f);
        i(this.f16427q);
    }

    @Override // q0.a.b
    public void a() {
        A();
    }

    @Override // p0.c
    public void b(List<p0.c> list, List<p0.c> list2) {
    }

    @Override // p0.e
    @CallSuper
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        this.f16418h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f16423m.set(matrix);
        if (z10) {
            List<a> list = this.f16430t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f16423m.preConcat(this.f16430t.get(size).f16432v.f());
                }
            } else {
                a aVar = this.f16429s;
                if (aVar != null) {
                    this.f16423m.preConcat(aVar.f16432v.f());
                }
            }
        }
        this.f16423m.preConcat(this.f16432v.f());
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        a aVar = this.f16428r;
        if (aVar != null) {
            s0.f fVarA = fVar2.a(aVar.getName());
            if (fVar.c(this.f16428r.getName(), i10)) {
                list.add(fVarA.j(this.f16428r));
            }
            if (fVar.i(getName(), i10)) {
                this.f16428r.D(fVar, fVar.e(this.f16428r.getName(), i10) + i10, list, fVarA);
            }
        }
        if (fVar.h(getName(), i10)) {
            if (!"__container".equals(getName())) {
                fVar2 = fVar2.a(getName());
                if (fVar.c(getName(), i10)) {
                    list.add(fVar2.j(this));
                }
            }
            if (fVar.i(getName(), i10)) {
                D(fVar, fVar.e(getName(), i10) + i10, list, fVar2);
            }
        }
    }

    @Override // s0.g
    @CallSuper
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        this.f16432v.c(t10, jVar);
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        Paint paint;
        n0.e.a(this.f16422l);
        if (!this.f16433w || this.f16425o.v()) {
            n0.e.b(this.f16422l);
            return;
        }
        r();
        n0.e.a("Layer#parentMatrix");
        this.f16412b.reset();
        this.f16412b.set(matrix);
        for (int size = this.f16430t.size() - 1; size >= 0; size--) {
            this.f16412b.preConcat(this.f16430t.get(size).f16432v.f());
        }
        n0.e.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i10 / 255.0f) * (this.f16432v.h() == null ? 100 : this.f16432v.h().h().intValue())) / 100.0f) * 255.0f);
        if (!x() && !w()) {
            this.f16412b.preConcat(this.f16432v.f());
            n0.e.a("Layer#drawLayer");
            t(canvas, this.f16412b, iIntValue);
            n0.e.b("Layer#drawLayer");
            B(n0.e.b(this.f16422l));
            return;
        }
        n0.e.a("Layer#computeBounds");
        c(this.f16418h, this.f16412b, false);
        z(this.f16418h, matrix);
        this.f16412b.preConcat(this.f16432v.f());
        y(this.f16418h, this.f16412b);
        if (!this.f16418h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.f16418h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        n0.e.b("Layer#computeBounds");
        if (this.f16418h.width() >= 1.0f && this.f16418h.height() >= 1.0f) {
            n0.e.a("Layer#saveLayer");
            this.f16413c.setAlpha(255);
            z0.h.n(canvas, this.f16418h, this.f16413c);
            n0.e.b("Layer#saveLayer");
            s(canvas);
            n0.e.a("Layer#drawLayer");
            t(canvas, this.f16412b, iIntValue);
            n0.e.b("Layer#drawLayer");
            if (w()) {
                o(canvas, this.f16412b);
            }
            if (x()) {
                n0.e.a("Layer#drawMatte");
                n0.e.a("Layer#saveLayer");
                z0.h.o(canvas, this.f16418h, this.f16416f, 19);
                n0.e.b("Layer#saveLayer");
                s(canvas);
                this.f16428r.g(canvas, matrix, iIntValue);
                n0.e.a("Layer#restoreLayer");
                canvas.restore();
                n0.e.b("Layer#restoreLayer");
                n0.e.b("Layer#drawMatte");
            }
            n0.e.a("Layer#restoreLayer");
            canvas.restore();
            n0.e.b("Layer#restoreLayer");
        }
        if (this.f16434x && (paint = this.f16435y) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.f16435y.setColor(-251901);
            this.f16435y.setStrokeWidth(4.0f);
            canvas.drawRect(this.f16418h, this.f16435y);
            this.f16435y.setStyle(Paint.Style.FILL);
            this.f16435y.setColor(1357638635);
            canvas.drawRect(this.f16418h, this.f16435y);
        }
        B(n0.e.b(this.f16422l));
    }

    @Override // p0.c
    public String getName() {
        return this.f16425o.g();
    }

    public void i(@Nullable q0.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.f16431u.add(aVar);
    }

    public final void j(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        this.f16413c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f16411a, this.f16413c);
    }

    public final void k(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        z0.h.n(canvas, this.f16418h, this.f16414d);
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        this.f16413c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f16411a, this.f16413c);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        z0.h.n(canvas, this.f16418h, this.f16413c);
        canvas.drawRect(this.f16418h, this.f16413c);
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        this.f16413c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f16411a, this.f16415e);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        z0.h.n(canvas, this.f16418h, this.f16414d);
        canvas.drawRect(this.f16418h, this.f16413c);
        this.f16415e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        canvas.drawPath(this.f16411a, this.f16415e);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        z0.h.n(canvas, this.f16418h, this.f16415e);
        canvas.drawRect(this.f16418h, this.f16413c);
        this.f16415e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        canvas.drawPath(this.f16411a, this.f16415e);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        n0.e.a("Layer#saveLayer");
        z0.h.o(canvas, this.f16418h, this.f16414d, 19);
        n0.e.b("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f16426p.b().size(); i10++) {
            u0.g gVar = this.f16426p.b().get(i10);
            q0.a<l, Path> aVar = this.f16426p.a().get(i10);
            q0.a<Integer, Integer> aVar2 = this.f16426p.c().get(i10);
            int i11 = b.f16438b[gVar.a().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (i10 == 0) {
                        this.f16413c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f16413c.setAlpha(255);
                        canvas.drawRect(this.f16418h, this.f16413c);
                    }
                    if (gVar.d()) {
                        n(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        p(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i11 != 3) {
                    if (i11 == 4) {
                        if (gVar.d()) {
                            l(canvas, matrix, gVar, aVar, aVar2);
                        } else {
                            j(canvas, matrix, gVar, aVar, aVar2);
                        }
                    }
                } else if (gVar.d()) {
                    m(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    k(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (q()) {
                this.f16413c.setAlpha(255);
                canvas.drawRect(this.f16418h, this.f16413c);
            }
        }
        n0.e.a("Layer#restoreLayer");
        canvas.restore();
        n0.e.b("Layer#restoreLayer");
    }

    public final void p(Canvas canvas, Matrix matrix, u0.g gVar, q0.a<l, Path> aVar, q0.a<Integer, Integer> aVar2) {
        this.f16411a.set(aVar.h());
        this.f16411a.transform(matrix);
        canvas.drawPath(this.f16411a, this.f16415e);
    }

    public final boolean q() {
        if (this.f16426p.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f16426p.b().size(); i10++) {
            if (this.f16426p.b().get(i10).a() != u0.g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
        if (this.f16430t != null) {
            return;
        }
        if (this.f16429s == null) {
            this.f16430t = Collections.emptyList();
            return;
        }
        this.f16430t = new ArrayList();
        for (a aVar = this.f16429s; aVar != null; aVar = aVar.f16429s) {
            this.f16430t.add(aVar);
        }
    }

    public final void s(Canvas canvas) {
        n0.e.a("Layer#clearLayer");
        RectF rectF = this.f16418h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f16417g);
        n0.e.b("Layer#clearLayer");
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i10);

    public d v() {
        return this.f16425o;
    }

    public boolean w() {
        q0.g gVar = this.f16426p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    public boolean x() {
        return this.f16428r != null;
    }

    public final void y(RectF rectF, Matrix matrix) {
        this.f16419i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.f16426p.b().size();
            for (int i10 = 0; i10 < size; i10++) {
                u0.g gVar = this.f16426p.b().get(i10);
                this.f16411a.set(this.f16426p.a().get(i10).h());
                this.f16411a.transform(matrix);
                int i11 = b.f16438b[gVar.a().ordinal()];
                if (i11 == 1 || i11 == 2) {
                    return;
                }
                if ((i11 == 3 || i11 == 4) && gVar.d()) {
                    return;
                }
                this.f16411a.computeBounds(this.f16421k, false);
                if (i10 == 0) {
                    this.f16419i.set(this.f16421k);
                } else {
                    RectF rectF2 = this.f16419i;
                    rectF2.set(Math.min(rectF2.left, this.f16421k.left), Math.min(this.f16419i.top, this.f16421k.top), Math.max(this.f16419i.right, this.f16421k.right), Math.max(this.f16419i.bottom, this.f16421k.bottom));
                }
            }
            if (rectF.intersect(this.f16419i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void z(RectF rectF, Matrix matrix) {
        if (x() && this.f16425o.f() != d.b.INVERT) {
            this.f16420j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f16428r.c(this.f16420j, matrix, true);
            if (rectF.intersect(this.f16420j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
}
