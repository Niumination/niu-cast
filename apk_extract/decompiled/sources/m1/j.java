package m1;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f7593j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(List list, int i8) {
        super(list);
        this.f7592i = i8;
        switch (i8) {
            case 1:
                super(list);
                this.f7593j = new PointF();
                break;
            case 2:
                super(list);
                this.f7593j = new x1.d();
                break;
            default:
                int iMax = 0;
                for (int i9 = 0; i9 < list.size(); i9++) {
                    r1.c cVar = (r1.c) ((x1.a) list.get(i9)).f10807b;
                    if (cVar != null) {
                        iMax = Math.max(iMax, cVar.f9249b.length);
                    }
                }
                this.f7593j = new r1.c(new float[iMax], new int[iMax]);
                break;
        }
    }

    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        Object obj;
        switch (this.f7592i) {
            case 0:
                r1.c cVar = (r1.c) aVar.f10807b;
                r1.c cVar2 = (r1.c) aVar.f10808c;
                r1.c cVar3 = (r1.c) this.f7593j;
                cVar3.getClass();
                if (cVar.equals(cVar2) || f <= 0.0f) {
                    cVar3.a(cVar);
                } else if (f >= 1.0f) {
                    cVar3.a(cVar2);
                } else {
                    int[] iArr = cVar.f9249b;
                    int length = iArr.length;
                    int[] iArr2 = cVar2.f9249b;
                    if (length != iArr2.length) {
                        StringBuilder sb2 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
                        sb2.append(iArr.length);
                        sb2.append(" vs ");
                        throw new IllegalArgumentException(h0.a.m(sb2, ")", iArr2.length));
                    }
                    int i8 = 0;
                    while (true) {
                        int length2 = iArr.length;
                        int[] iArr3 = cVar3.f9249b;
                        float[] fArr = cVar3.f9248a;
                        if (i8 < length2) {
                            fArr[i8] = w1.f.e(cVar.f9248a[i8], cVar2.f9248a[i8], f);
                            iArr3[i8] = m3.l.c(f, iArr[i8], iArr2[i8]);
                            i8++;
                        } else {
                            for (int length3 = iArr.length; length3 < fArr.length; length3++) {
                                fArr[length3] = fArr[iArr.length - 1];
                                iArr3[length3] = iArr3[iArr.length - 1];
                            }
                        }
                    }
                }
                return cVar3;
            case 1:
                return l(aVar, f, f, f);
            default:
                Object obj2 = aVar.f10807b;
                if (obj2 == null || (obj = aVar.f10808c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                x1.d dVar = (x1.d) obj2;
                x1.d dVar2 = (x1.d) obj;
                x1.c cVar4 = this.e;
                if (cVar4 != null) {
                    x1.d dVar3 = (x1.d) cVar4.b(aVar.f10810g, aVar.f10811h.floatValue(), dVar, dVar2, f, e(), this.f7577d);
                    if (dVar3 != null) {
                        return dVar3;
                    }
                }
                float fE = w1.f.e(dVar.f10826a, dVar2.f10826a, f);
                float fE2 = w1.f.e(dVar.f10827b, dVar2.f10827b, f);
                x1.d dVar4 = (x1.d) this.f7593j;
                dVar4.f10826a = fE;
                dVar4.f10827b = fE2;
                return dVar4;
        }
    }

    @Override // m1.e
    public /* bridge */ /* synthetic */ Object h(x1.a aVar, float f, float f4, float f10) {
        switch (this.f7592i) {
            case 1:
                return l(aVar, f, f4, f10);
            default:
                return super.h(aVar, f, f4, f10);
        }
    }

    public PointF l(x1.a aVar, float f, float f4, float f10) {
        Object obj;
        Object obj2 = aVar.f10807b;
        if (obj2 == null || (obj = aVar.f10808c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) obj2;
        PointF pointF2 = (PointF) obj;
        x1.c cVar = this.e;
        if (cVar != null) {
            PointF pointF3 = (PointF) cVar.b(aVar.f10810g, aVar.f10811h.floatValue(), pointF, pointF2, f, e(), this.f7577d);
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = (PointF) this.f7593j;
        float f11 = pointF.x;
        float fB = a1.a.b(pointF2.x, f11, f4, f11);
        float f12 = pointF.y;
        pointF4.set(fB, a1.a.b(pointF2.y, f12, f10, f12));
        return pointF4;
    }
}
