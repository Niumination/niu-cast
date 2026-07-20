package l1;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class q implements o, m1.a, l {
    public final String e;
    public final x f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r1.m f7157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m1.i f7160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1.e f7161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m1.i f7162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m1.i f7163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m1.i f7164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m1.i f7165o;
    public final m1.i p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7166r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7153a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f7154b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PathMeasure f7155c = new PathMeasure();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f7156d = new float[2];
    public final c q = new c(0);

    public q(x xVar, s1.c cVar, r1.n nVar) {
        this.f = xVar;
        this.e = nVar.f9274a;
        r1.m mVar = nVar.f9275b;
        this.f7157g = mVar;
        this.f7158h = nVar.f9281j;
        this.f7159i = nVar.f9282k;
        m1.i iVarG = nVar.f9276c.g();
        this.f7160j = iVarG;
        m1.e eVarG = nVar.f9277d.g();
        this.f7161k = eVarG;
        m1.i iVarG2 = nVar.e.g();
        this.f7162l = iVarG2;
        m1.i iVarG3 = nVar.f9278g.g();
        this.f7164n = iVarG3;
        m1.i iVarG4 = nVar.f9280i.g();
        this.p = iVarG4;
        r1.m mVar2 = r1.m.STAR;
        if (mVar == mVar2) {
            this.f7163m = nVar.f.g();
            this.f7165o = nVar.f9279h.g();
        } else {
            this.f7163m = null;
            this.f7165o = null;
        }
        cVar.f(iVarG);
        cVar.f(eVarG);
        cVar.f(iVarG2);
        cVar.f(iVarG3);
        cVar.f(iVarG4);
        if (mVar == mVar2) {
            cVar.f(this.f7163m);
            cVar.f(this.f7165o);
        }
        iVarG.a(this);
        eVarG.a(this);
        iVarG2.a(this);
        iVarG3.a(this);
        iVarG4.a(this);
        if (mVar == mVar2) {
            this.f7163m.a(this);
            this.f7165o.a(this);
        }
    }

    @Override // m1.a
    public final void a() {
        this.f7166r = false;
        this.f.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i8 >= arrayList.size()) {
                return;
            }
            d dVar = (d) arrayList.get(i8);
            if (dVar instanceof w) {
                w wVar = (w) dVar;
                if (wVar.f7198c == y.SIMULTANEOUSLY) {
                    this.q.f7096a.add(wVar);
                    wVar.c(this);
                }
            }
            i8++;
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        m1.i iVar;
        m1.i iVar2;
        if (colorFilter == b0.f5935r) {
            this.f7160j.k(cVar);
            return;
        }
        if (colorFilter == b0.f5936s) {
            this.f7162l.k(cVar);
            return;
        }
        if (colorFilter == b0.f5928i) {
            this.f7161k.k(cVar);
            return;
        }
        if (colorFilter == b0.f5937t && (iVar2 = this.f7163m) != null) {
            iVar2.k(cVar);
            return;
        }
        if (colorFilter == b0.u) {
            this.f7164n.k(cVar);
            return;
        }
        if (colorFilter == b0.f5938v && (iVar = this.f7165o) != null) {
            iVar.k(cVar);
        } else if (colorFilter == b0.f5939w) {
            this.p.k(cVar);
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.e;
    }

    @Override // l1.o
    public final Path getPath() {
        float f;
        double d7;
        float f4;
        float f10;
        float f11;
        int i8;
        double d10;
        q qVar;
        float f12;
        q qVar2 = this;
        boolean z2 = qVar2.f7166r;
        Path path = qVar2.f7153a;
        if (z2) {
            return path;
        }
        path.reset();
        if (qVar2.f7158h) {
            qVar2.f7166r = true;
            return path;
        }
        int i9 = p.f7152a[qVar2.f7157g.ordinal()];
        m1.e eVar = qVar2.f7161k;
        m1.i iVar = qVar2.f7164n;
        m1.i iVar2 = qVar2.p;
        m1.i iVar3 = qVar2.f7162l;
        m1.i iVar4 = qVar2.f7160j;
        if (i9 == 1) {
            boolean z3 = false;
            float fFloatValue = ((Float) iVar4.f()).floatValue();
            double radians = Math.toRadians((iVar3 != null ? ((Float) iVar3.f()).floatValue() : 0.0d) - 90.0d);
            double d11 = fFloatValue;
            float f13 = (float) (6.283185307179586d / d11);
            if (qVar2.f7159i) {
                f13 *= -1.0f;
            }
            float f14 = f13;
            float f15 = f14 / 2.0f;
            float f16 = fFloatValue - ((int) fFloatValue);
            if (f16 != 0.0f) {
                radians += (double) ((1.0f - f16) * f15);
            }
            float fFloatValue2 = ((Float) iVar.f()).floatValue();
            float fFloatValue3 = ((Float) qVar2.f7163m.f()).floatValue();
            m1.i iVar5 = qVar2.f7165o;
            float fFloatValue4 = iVar5 != null ? ((Float) iVar5.f()).floatValue() / 100.0f : 0.0f;
            float fFloatValue5 = iVar2 != null ? ((Float) iVar2.f()).floatValue() / 100.0f : 0.0f;
            if (f16 != 0.0f) {
                float fB = a1.a.b(fFloatValue2, fFloatValue3, f16, fFloatValue3);
                double d12 = fB;
                float fCos = (float) (Math.cos(radians) * d12);
                float fSin = (float) (d12 * Math.sin(radians));
                path.moveTo(fCos, fSin);
                d7 = radians + ((double) ((f14 * f16) / 2.0f));
                f10 = fCos;
                f11 = fB;
                f4 = fSin;
                f = f15;
            } else {
                double d13 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d13);
                float fSin2 = (float) (d13 * Math.sin(radians));
                path.moveTo(fCos2, fSin2);
                f = f15;
                d7 = radians + ((double) f);
                f4 = fSin2;
                f10 = fCos2;
                f11 = 0.0f;
            }
            double dCeil = Math.ceil(d11) * 2.0d;
            double d14 = d7;
            int i10 = 0;
            float f17 = fFloatValue3;
            while (true) {
                double d15 = i10;
                if (d15 >= dCeil) {
                    break;
                }
                float f18 = z3 ? fFloatValue2 : f17;
                float f19 = (f11 == 0.0f || d15 != dCeil - 2.0d) ? f : (f14 * f16) / 2.0f;
                double d16 = (f11 == 0.0f || d15 != dCeil - 1.0d) ? f18 : f11;
                float f20 = f11;
                float f21 = f;
                float fCos3 = (float) (Math.cos(d14) * d16);
                float fSin3 = (float) (d16 * Math.sin(d14));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    path.lineTo(fCos3, fSin3);
                } else {
                    float f22 = f4;
                    double dAtan2 = (float) (Math.atan2(f4, f10) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    float f23 = f10;
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f24 = z3 ? fFloatValue4 : fFloatValue5;
                    float f25 = z3 ? fFloatValue5 : fFloatValue4;
                    float f26 = (z3 ? f17 : fFloatValue2) * f24 * 0.47829f;
                    float f27 = fCos4 * f26;
                    float f28 = f26 * fSin4;
                    float f29 = (z3 ? fFloatValue2 : f17) * f25 * 0.47829f;
                    float f30 = fCos5 * f29;
                    float f31 = f29 * fSin5;
                    if (f16 != 0.0f) {
                        if (i10 == 0) {
                            f27 *= f16;
                            f28 *= f16;
                        } else if (d15 == dCeil - 1.0d) {
                            f30 *= f16;
                            f31 *= f16;
                        }
                    }
                    path.cubicTo(f23 - f27, f22 - f28, fCos3 + f30, fSin3 + f31, fCos3, fSin3);
                }
                d14 += (double) f19;
                z3 = !z3;
                i10++;
                f17 = f17;
                f10 = fCos3;
                f4 = fSin3;
                fFloatValue2 = fFloatValue2;
                f14 = f14;
                f = f21;
                f11 = f20;
            }
            PointF pointF = (PointF) eVar.f();
            path.offset(pointF.x, pointF.y);
            path.close();
        } else if (i9 == 2) {
            int iFloor = (int) Math.floor(((Float) iVar4.f()).floatValue());
            double radians2 = Math.toRadians((iVar3 != null ? ((Float) iVar3.f()).floatValue() : 0.0d) - 90.0d);
            double d17 = iFloor;
            float fFloatValue6 = ((Float) iVar2.f()).floatValue() / 100.0f;
            float fFloatValue7 = ((Float) iVar.f()).floatValue();
            double d18 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d18);
            float fSin6 = (float) (Math.sin(radians2) * d18);
            path.moveTo(fCos6, fSin6);
            double d19 = (float) (6.283185307179586d / d17);
            double dCeil2 = Math.ceil(d17);
            double d20 = radians2 + d19;
            int i11 = 0;
            while (true) {
                double d21 = i11;
                if (d21 >= dCeil2) {
                    break;
                }
                m1.e eVar2 = eVar;
                double d22 = d19;
                float fCos7 = (float) (Math.cos(d20) * d18);
                float fSin7 = (float) (Math.sin(d20) * d18);
                if (fFloatValue6 != 0.0f) {
                    d10 = d18;
                    double dAtan4 = (float) (Math.atan2(fSin6, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan4);
                    float fSin8 = (float) Math.sin(dAtan4);
                    float f32 = fCos6;
                    i8 = i11;
                    double dAtan5 = (float) (Math.atan2(fSin7, fCos7) - 1.5707963267948966d);
                    float f33 = fFloatValue7 * fFloatValue6 * 0.25f;
                    float f34 = fCos8 * f33;
                    float f35 = fSin8 * f33;
                    float fCos9 = ((float) Math.cos(dAtan5)) * f33;
                    float fSin9 = f33 * ((float) Math.sin(dAtan5));
                    if (d21 == dCeil2 - 1.0d) {
                        qVar = this;
                        Path path2 = qVar.f7154b;
                        path2.reset();
                        path2.moveTo(f32, fSin6);
                        float f36 = f32 - f34;
                        float f37 = fSin6 - f35;
                        float f38 = fCos7 + fCos9;
                        float f39 = fSin7 + fSin9;
                        path2.cubicTo(f36, f37, f38, f39, fCos7, fSin7);
                        PathMeasure pathMeasure = qVar.f7155c;
                        pathMeasure.setPath(path2, false);
                        float length = pathMeasure.getLength() * 0.9999f;
                        float[] fArr = qVar.f7156d;
                        pathMeasure.getPosTan(length, fArr, null);
                        path.cubicTo(f36, f37, f38, f39, fArr[0], fArr[1]);
                    } else {
                        qVar = this;
                        path.cubicTo(f32 - f34, fSin6 - f35, fCos7 + fCos9, fSin7 + fSin9, fCos7, fSin7);
                    }
                    f12 = fSin7;
                } else {
                    i8 = i11;
                    d10 = d18;
                    fFloatValue7 = fFloatValue7;
                    qVar = qVar2;
                    if (d21 == dCeil2 - 1.0d) {
                        f12 = fSin7;
                    } else {
                        f12 = fSin7;
                        path.lineTo(fCos7, f12);
                    }
                    fSin6 = f12;
                    qVar2 = qVar;
                    i11 = i8 + 1;
                    fCos6 = fCos7;
                    d18 = d10;
                    fFloatValue7 = fFloatValue7;
                    eVar = eVar2;
                    d19 = d22;
                }
                d20 += d22;
                fSin6 = f12;
                qVar2 = qVar;
                i11 = i8 + 1;
                fCos6 = fCos7;
                d18 = d10;
                fFloatValue7 = fFloatValue7;
                eVar = eVar2;
                d19 = d22;
            }
            PointF pointF2 = (PointF) eVar.f();
            path.offset(pointF2.x, pointF2.y);
            path.close();
        }
        path.close();
        this.q.a(path);
        this.f7166r = true;
        return path;
    }
}
