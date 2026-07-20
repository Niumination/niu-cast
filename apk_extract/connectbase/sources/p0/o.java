package p0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o implements n, q0.a.b, k {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f12637o = 0.47829f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f12638p = 0.25f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.j f12641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0.i.a f12642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0.a<?, Float> f12644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0.a<?, PointF> f12645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q0.a<?, Float> f12646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final q0.a<?, Float> f12647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q0.a<?, Float> f12648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final q0.a<?, Float> f12649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q0.a<?, Float> f12650l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12652n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12639a = new Path();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f12651m = new b();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12653a;

        static {
            int[] iArr = new int[u0.i.a.values().length];
            f12653a = iArr;
            try {
                iArr[u0.i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12653a[u0.i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(n0.j jVar, v0.a aVar, u0.i iVar) {
        this.f12641c = jVar;
        this.f12640b = iVar.d();
        u0.i.a aVarJ = iVar.j();
        this.f12642d = aVarJ;
        this.f12643e = iVar.k();
        q0.a<Float, Float> aVarL = iVar.g().l();
        this.f12644f = aVarL;
        q0.a<PointF, PointF> aVarL2 = iVar.h().l();
        this.f12645g = aVarL2;
        q0.a<Float, Float> aVarL3 = iVar.i().l();
        this.f12646h = aVarL3;
        q0.a<Float, Float> aVarL4 = iVar.e().l();
        this.f12648j = aVarL4;
        q0.a<Float, Float> aVarL5 = iVar.f().l();
        this.f12650l = aVarL5;
        u0.i.a aVar2 = u0.i.a.STAR;
        if (aVarJ == aVar2) {
            this.f12647i = iVar.b().l();
            this.f12649k = iVar.c().l();
        } else {
            this.f12647i = null;
            this.f12649k = null;
        }
        aVar.i(aVarL);
        aVar.i(aVarL2);
        aVar.i(aVarL3);
        aVar.i(aVarL4);
        aVar.i(aVarL5);
        if (aVarJ == aVar2) {
            aVar.i(this.f12647i);
            aVar.i(this.f12649k);
        }
        aVarL.a(this);
        aVarL2.a(this);
        aVarL3.a(this);
        aVarL4.a(this);
        aVarL5.a(this);
        if (aVarJ == aVar2) {
            this.f12647i.a(this);
            this.f12649k.a(this);
        }
    }

    private void i() {
        this.f12652n = false;
        this.f12641c.invalidateSelf();
    }

    @Override // q0.a.b
    public void a() {
        i();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.i() == u0.q.a.SIMULTANEOUSLY) {
                    this.f12651m.a(tVar);
                    tVar.d(this);
                }
            }
        }
    }

    public final void d() {
        int iFloor = (int) Math.floor(this.f12644f.h().floatValue());
        q0.a<?, Float> aVar = this.f12646h;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d10 = iFloor;
        float fFloatValue = this.f12650l.h().floatValue() / 100.0f;
        float fFloatValue2 = this.f12648j.h().floatValue();
        double d11 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d11);
        float fSin = (float) (Math.sin(radians) * d11);
        this.f12639a.moveTo(fCos, fSin);
        double d12 = (float) (6.283185307179586d / d10);
        double d13 = radians + d12;
        double dCeil = Math.ceil(d10);
        int i10 = 0;
        while (i10 < dCeil) {
            float fCos2 = (float) (Math.cos(d13) * d11);
            double d14 = dCeil;
            float fSin2 = (float) (Math.sin(d13) * d11);
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f10 = fFloatValue2 * fFloatValue * 0.25f;
                this.f12639a.cubicTo(fCos - (fCos3 * f10), fSin - (fSin3 * f10), fCos2 + (((float) Math.cos(dAtan3)) * f10), fSin2 + (f10 * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.f12639a.lineTo(fCos2, fSin2);
            }
            d13 += d12;
            i10++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d14;
            d11 = d11;
            d12 = d12;
        }
        PointF pointFH = this.f12645g.h();
        this.f12639a.offset(pointFH.x, pointFH.y);
        this.f12639a.close();
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        q0.a<?, Float> aVar;
        q0.a<?, Float> aVar2;
        if (t10 == n0.o.f11064u) {
            this.f12644f.n(jVar);
            return;
        }
        if (t10 == n0.o.f11065v) {
            this.f12646h.n(jVar);
            return;
        }
        if (t10 == n0.o.f11055l) {
            this.f12645g.n(jVar);
            return;
        }
        if (t10 == n0.o.f11066w && (aVar2 = this.f12647i) != null) {
            aVar2.n(jVar);
            return;
        }
        if (t10 == n0.o.f11067x) {
            this.f12648j.n(jVar);
            return;
        }
        if (t10 == n0.o.f11068y && (aVar = this.f12649k) != null) {
            aVar.n(jVar);
        } else if (t10 == n0.o.f11069z) {
            this.f12650l.n(jVar);
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12640b;
    }

    @Override // p0.n
    public Path getPath() {
        if (this.f12652n) {
            return this.f12639a;
        }
        this.f12639a.reset();
        if (this.f12643e) {
            this.f12652n = true;
            return this.f12639a;
        }
        int i10 = a.f12653a[this.f12642d.ordinal()];
        if (i10 == 1) {
            h();
        } else if (i10 == 2) {
            d();
        }
        this.f12639a.close();
        this.f12651m.b(this.f12639a);
        this.f12652n = true;
        return this.f12639a;
    }

    public final void h() {
        float f10;
        float f11;
        double d10;
        float fSin;
        float fA;
        float f12;
        float f13;
        float fFloatValue = this.f12644f.h().floatValue();
        q0.a<?, Float> aVar = this.f12646h;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d11 = fFloatValue;
        float f14 = (float) (6.283185307179586d / d11);
        float f15 = f14 / 2.0f;
        float f16 = fFloatValue - ((int) fFloatValue);
        if (f16 != 0.0f) {
            radians += (double) ((1.0f - f16) * f15);
        }
        float fFloatValue2 = this.f12648j.h().floatValue();
        float fFloatValue3 = this.f12647i.h().floatValue();
        q0.a<?, Float> aVar2 = this.f12649k;
        float fFloatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        q0.a<?, Float> aVar3 = this.f12650l;
        float fFloatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (f16 != 0.0f) {
            fA = g.a.a(fFloatValue2, fFloatValue3, f16, fFloatValue3);
            double d12 = fA;
            float fCos = (float) (Math.cos(radians) * d12);
            fSin = (float) (Math.sin(radians) * d12);
            this.f12639a.moveTo(fCos, fSin);
            d10 = radians + ((double) ((f14 * f16) / 2.0f));
            f10 = fCos;
            f11 = f15;
        } else {
            double d13 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d13);
            float fSin2 = (float) (d13 * Math.sin(radians));
            this.f12639a.moveTo(fCos2, fSin2);
            f10 = fCos2;
            f11 = f15;
            d10 = radians + ((double) f11);
            fSin = fSin2;
            fA = 0.0f;
        }
        double dCeil = Math.ceil(d11) * 2.0d;
        int i10 = 0;
        float f17 = f11;
        float f18 = f10;
        boolean z10 = false;
        while (true) {
            double d14 = i10;
            if (d14 >= dCeil) {
                PointF pointFH = this.f12645g.h();
                this.f12639a.offset(pointFH.x, pointFH.y);
                this.f12639a.close();
                return;
            }
            float f19 = z10 ? fFloatValue2 : fFloatValue3;
            float f20 = (fA == 0.0f || d14 != dCeil - 2.0d) ? f17 : (f14 * f16) / 2.0f;
            if (fA == 0.0f || d14 != dCeil - 1.0d) {
                fA = f19;
            }
            double d15 = fA;
            double d16 = dCeil;
            float fCos3 = (float) (Math.cos(d10) * d15);
            float fSin3 = (float) (d15 * Math.sin(d10));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f12639a.lineTo(fCos3, fSin3);
                f12 = fFloatValue4;
                f13 = fFloatValue5;
            } else {
                f12 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f18) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f13 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f21 = z10 ? f12 : f13;
                float f22 = z10 ? f13 : f12;
                float f23 = (z10 ? fFloatValue3 : fFloatValue2) * f21 * 0.47829f;
                float f24 = fCos4 * f23;
                float f25 = f23 * fSin4;
                float f26 = (z10 ? fFloatValue2 : fFloatValue3) * f22 * 0.47829f;
                float f27 = fCos5 * f26;
                float f28 = f26 * fSin5;
                if (f16 != 0.0f) {
                    if (i10 == 0) {
                        f24 *= f16;
                        f25 *= f16;
                    } else if (d14 == d16 - 1.0d) {
                        f27 *= f16;
                        f28 *= f16;
                    }
                }
                this.f12639a.cubicTo(f18 - f24, fSin - f25, fCos3 + f27, fSin3 + f28, fCos3, fSin3);
            }
            d10 += (double) f20;
            z10 = !z10;
            i10++;
            f18 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f13;
            fFloatValue4 = f12;
            fA = fA;
            f14 = f14;
            dCeil = d16;
        }
    }
}
