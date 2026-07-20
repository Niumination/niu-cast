package m1;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import j1.b0;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f7613a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f7614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f7615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f7616d;
    public final float[] e;
    public e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f7617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f7618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f7619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f7620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f7621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f7622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f7623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f7624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f7625o;

    public q(q1.d dVar) {
        se.e eVar = dVar.f8933a;
        this.f = eVar == null ? null : eVar.g();
        q1.e eVar2 = dVar.f8934b;
        this.f7617g = eVar2 == null ? null : eVar2.g();
        q1.a aVar = dVar.f8935c;
        this.f7618h = aVar == null ? null : aVar.g();
        q1.b bVar = dVar.f8936d;
        this.f7619i = bVar == null ? null : bVar.g();
        q1.b bVar2 = dVar.f;
        i iVarG = bVar2 == null ? null : bVar2.g();
        this.f7621k = iVarG;
        this.f7625o = dVar.f8940j;
        if (iVarG != null) {
            this.f7614b = new Matrix();
            this.f7615c = new Matrix();
            this.f7616d = new Matrix();
            this.e = new float[9];
        } else {
            this.f7614b = null;
            this.f7615c = null;
            this.f7616d = null;
            this.e = null;
        }
        q1.b bVar3 = dVar.f8937g;
        this.f7622l = bVar3 == null ? null : bVar3.g();
        q1.a aVar2 = dVar.e;
        if (aVar2 != null) {
            this.f7620j = aVar2.g();
        }
        q1.b bVar4 = dVar.f8938h;
        if (bVar4 != null) {
            this.f7623m = bVar4.g();
        } else {
            this.f7623m = null;
        }
        q1.b bVar5 = dVar.f8939i;
        if (bVar5 != null) {
            this.f7624n = bVar5.g();
        } else {
            this.f7624n = null;
        }
    }

    public final void a(s1.c cVar) {
        cVar.f(this.f7620j);
        cVar.f(this.f7623m);
        cVar.f(this.f7624n);
        cVar.f(this.f);
        cVar.f(this.f7617g);
        cVar.f(this.f7618h);
        cVar.f(this.f7619i);
        cVar.f(this.f7621k);
        cVar.f(this.f7622l);
    }

    public final void b(a aVar) {
        e eVar = this.f7620j;
        if (eVar != null) {
            eVar.a(aVar);
        }
        e eVar2 = this.f7623m;
        if (eVar2 != null) {
            eVar2.a(aVar);
        }
        e eVar3 = this.f7624n;
        if (eVar3 != null) {
            eVar3.a(aVar);
        }
        e eVar4 = this.f;
        if (eVar4 != null) {
            eVar4.a(aVar);
        }
        e eVar5 = this.f7617g;
        if (eVar5 != null) {
            eVar5.a(aVar);
        }
        e eVar6 = this.f7618h;
        if (eVar6 != null) {
            eVar6.a(aVar);
        }
        e eVar7 = this.f7619i;
        if (eVar7 != null) {
            eVar7.a(aVar);
        }
        i iVar = this.f7621k;
        if (iVar != null) {
            iVar.a(aVar);
        }
        i iVar2 = this.f7622l;
        if (iVar2 != null) {
            iVar2.a(aVar);
        }
    }

    public final boolean c(ColorFilter colorFilter, x1.c cVar) {
        if (colorFilter == b0.f5922a) {
            e eVar = this.f;
            if (eVar == null) {
                this.f = new r(cVar, new PointF());
                return true;
            }
            eVar.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5923b) {
            e eVar2 = this.f7617g;
            if (eVar2 == null) {
                this.f7617g = new r(cVar, new PointF());
                return true;
            }
            eVar2.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5924c) {
            e eVar3 = this.f7617g;
            if (eVar3 instanceof o) {
                o oVar = (o) eVar3;
                x1.c cVar2 = oVar.f7609m;
                oVar.f7609m = cVar;
                return true;
            }
        }
        if (colorFilter == b0.f5925d) {
            e eVar4 = this.f7617g;
            if (eVar4 instanceof o) {
                o oVar2 = (o) eVar4;
                x1.c cVar3 = oVar2.f7610n;
                oVar2.f7610n = cVar;
                return true;
            }
        }
        if (colorFilter == b0.f5929j) {
            e eVar5 = this.f7618h;
            if (eVar5 == null) {
                this.f7618h = new r(cVar, new x1.d());
                return true;
            }
            eVar5.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5930k) {
            e eVar6 = this.f7619i;
            if (eVar6 == null) {
                this.f7619i = new r(cVar, Float.valueOf(0.0f));
                return true;
            }
            eVar6.k(cVar);
            return true;
        }
        if (colorFilter == 3) {
            e eVar7 = this.f7620j;
            if (eVar7 == null) {
                this.f7620j = new r(cVar, 100);
                return true;
            }
            eVar7.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5940x) {
            e eVar8 = this.f7623m;
            if (eVar8 == null) {
                this.f7623m = new r(cVar, Float.valueOf(100.0f));
                return true;
            }
            eVar8.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5941y) {
            e eVar9 = this.f7624n;
            if (eVar9 == null) {
                this.f7624n = new r(cVar, Float.valueOf(100.0f));
                return true;
            }
            eVar9.k(cVar);
            return true;
        }
        if (colorFilter == b0.f5931l) {
            if (this.f7621k == null) {
                this.f7621k = new i(Collections.singletonList(new x1.a(Float.valueOf(0.0f))));
            }
            this.f7621k.k(cVar);
            return true;
        }
        if (colorFilter != b0.f5932m) {
            return false;
        }
        if (this.f7622l == null) {
            this.f7622l = new i(Collections.singletonList(new x1.a(Float.valueOf(0.0f))));
        }
        this.f7622l.k(cVar);
        return true;
    }

    public final void d() {
        for (int i8 = 0; i8 < 9; i8++) {
            this.e[i8] = 0.0f;
        }
    }

    public final Matrix e() {
        PointF pointF;
        x1.d dVar;
        PointF pointF2;
        Matrix matrix = this.f7613a;
        matrix.reset();
        e eVar = this.f7617g;
        if (eVar != null && (pointF2 = (PointF) eVar.f()) != null) {
            float f = pointF2.x;
            if (f != 0.0f || pointF2.y != 0.0f) {
                matrix.preTranslate(f, pointF2.y);
            }
        }
        if (!this.f7625o) {
            e eVar2 = this.f7619i;
            if (eVar2 != null) {
                float fFloatValue = eVar2 instanceof r ? ((Float) eVar2.f()).floatValue() : ((i) eVar2).l();
                if (fFloatValue != 0.0f) {
                    matrix.preRotate(fFloatValue);
                }
            }
        } else if (eVar != null) {
            float f4 = eVar.f7577d;
            PointF pointF3 = (PointF) eVar.f();
            float f10 = pointF3.x;
            float f11 = pointF3.y;
            eVar.j(1.0E-4f + f4);
            PointF pointF4 = (PointF) eVar.f();
            eVar.j(f4);
            matrix.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f11, pointF4.x - f10)));
        }
        i iVar = this.f7621k;
        if (iVar != null) {
            i iVar2 = this.f7622l;
            float fCos = iVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-iVar2.l()) + 90.0f));
            i iVar3 = this.f7622l;
            float fSin = iVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-iVar3.l()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(iVar.l()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f12 = -fSin;
            fArr[3] = f12;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.f7614b;
            matrix2.setValues(fArr);
            d();
            fArr[0] = 1.0f;
            fArr[3] = fTan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.f7615c;
            matrix3.setValues(fArr);
            d();
            fArr[0] = fCos;
            fArr[1] = f12;
            fArr[3] = fSin;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.f7616d;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        e eVar3 = this.f7618h;
        if (eVar3 != null && (dVar = (x1.d) eVar3.f()) != null) {
            float f13 = dVar.f10826a;
            if (f13 != 1.0f || dVar.f10827b != 1.0f) {
                matrix.preScale(f13, dVar.f10827b);
            }
        }
        e eVar4 = this.f;
        if (eVar4 != null && (pointF = (PointF) eVar4.f()) != null) {
            float f14 = pointF.x;
            if (f14 != 0.0f || pointF.y != 0.0f) {
                matrix.preTranslate(-f14, -pointF.y);
            }
        }
        return matrix;
    }

    public final Matrix f(float f) {
        e eVar = this.f7617g;
        PointF pointF = eVar == null ? null : (PointF) eVar.f();
        e eVar2 = this.f7618h;
        x1.d dVar = eVar2 == null ? null : (x1.d) eVar2.f();
        Matrix matrix = this.f7613a;
        matrix.reset();
        if (pointF != null) {
            matrix.preTranslate(pointF.x * f, pointF.y * f);
        }
        if (dVar != null) {
            double d7 = f;
            matrix.preScale((float) Math.pow(dVar.f10826a, d7), (float) Math.pow(dVar.f10827b, d7));
        }
        e eVar3 = this.f7619i;
        if (eVar3 != null) {
            float fFloatValue = ((Float) eVar3.f()).floatValue();
            e eVar4 = this.f;
            PointF pointF2 = eVar4 != null ? (PointF) eVar4.f() : null;
            matrix.preRotate(fFloatValue * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return matrix;
    }
}
