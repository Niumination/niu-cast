package m1;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import l1.t;

/* JADX INFO: loaded from: classes.dex */
public final class n extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r1.q f7600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f7601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Path f7602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f7603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f7604m;

    public n(List list) {
        super(list);
        this.f7600i = new r1.q();
        this.f7601j = new Path();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x027b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0334  */
    /* JADX WARN: Code duplicated, block: B:38:0x0152  */
    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        r1.q qVar;
        r1.q qVar2;
        r1.q qVar3;
        r1.q qVar4;
        int i8;
        r1.q qVar5;
        r1.q qVar6;
        int i9;
        boolean z2;
        int i10;
        int i11;
        r1.q qVar7;
        boolean z3;
        r1.q qVar8 = (r1.q) aVar.f10807b;
        r1.q qVar9 = (r1.q) aVar.f10808c;
        r1.q qVar10 = qVar9 == null ? qVar8 : qVar9;
        r1.q qVar11 = this.f7600i;
        if (qVar11.f9289b == null) {
            qVar11.f9289b = new PointF();
        }
        qVar11.f9290c = qVar8.f9290c || qVar10.f9290c;
        ArrayList arrayList = qVar8.f9288a;
        int size = arrayList.size();
        int size2 = qVar10.f9288a.size();
        ArrayList arrayList2 = qVar10.f9288a;
        if (size != size2) {
            w1.b.b("Curves must have the same number of control points. Shape 1: " + arrayList.size() + "\tShape 2: " + arrayList2.size());
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        ArrayList arrayList3 = qVar11.f9288a;
        if (arrayList3.size() < iMin) {
            for (int size3 = arrayList3.size(); size3 < iMin; size3++) {
                arrayList3.add(new p1.a());
            }
        } else if (arrayList3.size() > iMin) {
            for (int size4 = arrayList3.size() - 1; size4 >= iMin; size4--) {
                arrayList3.remove(arrayList3.size() - 1);
            }
        }
        PointF pointF = qVar8.f9289b;
        PointF pointF2 = qVar10.f9289b;
        qVar11.a(w1.f.e(pointF.x, pointF2.x, f), w1.f.e(pointF.y, pointF2.y, f));
        int size5 = arrayList3.size() - 1;
        while (size5 >= 0) {
            p1.a aVar2 = (p1.a) arrayList.get(size5);
            p1.a aVar3 = (p1.a) arrayList2.get(size5);
            PointF pointF3 = aVar2.f8615a;
            PointF pointF4 = aVar3.f8615a;
            r1.q qVar12 = qVar11;
            ((p1.a) arrayList3.get(size5)).f8615a.set(w1.f.e(pointF3.x, pointF4.x, f), w1.f.e(pointF3.y, pointF4.y, f));
            p1.a aVar4 = (p1.a) arrayList3.get(size5);
            PointF pointF5 = aVar2.f8616b;
            float f4 = pointF5.x;
            PointF pointF6 = aVar3.f8616b;
            aVar4.f8616b.set(w1.f.e(f4, pointF6.x, f), w1.f.e(pointF5.y, pointF6.y, f));
            p1.a aVar5 = (p1.a) arrayList3.get(size5);
            PointF pointF7 = aVar2.f8617c;
            float f10 = pointF7.x;
            PointF pointF8 = aVar3.f8617c;
            aVar5.f8617c.set(w1.f.e(f10, pointF8.x, f), w1.f.e(pointF7.y, pointF8.y, f));
            size5--;
            qVar11 = qVar12;
        }
        r1.q qVar13 = qVar11;
        ArrayList arrayList4 = this.f7604m;
        if (arrayList4 != null) {
            int size6 = arrayList4.size() - 1;
            qVar3 = qVar13;
            while (size6 >= 0) {
                t tVar = (t) this.f7604m.get(size6);
                tVar.getClass();
                ArrayList arrayList5 = qVar3.f9288a;
                if (arrayList5.size() <= 2) {
                    qVar5 = qVar8;
                    qVar6 = qVar9;
                    i9 = size6;
                } else {
                    float fFloatValue = ((Float) tVar.f7185b.f()).floatValue();
                    if (fFloatValue == 0.0f) {
                        qVar5 = qVar8;
                        qVar6 = qVar9;
                        i9 = size6;
                    } else {
                        boolean z5 = qVar3.f9290c;
                        int size7 = arrayList5.size() - 1;
                        int i12 = 0;
                        while (size7 >= 0) {
                            p1.a aVar6 = (p1.a) arrayList5.get(size7);
                            p1.a aVar7 = (p1.a) arrayList5.get(t.c(size7 - 1, arrayList5.size()));
                            PointF pointF9 = (size7 != 0 || z5) ? aVar7.f8617c : qVar3.f9289b;
                            i12 = (((size7 != 0 || z5) ? aVar7.f8616b : pointF9).equals(pointF9) && aVar6.f8615a.equals(pointF9) && !(!qVar3.f9290c && (size7 == 0 || size7 == arrayList5.size() + (-1)))) ? i12 + 2 : i12 + 1;
                            size7--;
                        }
                        r1.q qVar14 = tVar.f7186c;
                        if (qVar14 == null || qVar14.f9288a.size() != i12) {
                            ArrayList arrayList6 = new ArrayList(i12);
                            for (int i13 = 0; i13 < i12; i13++) {
                                arrayList6.add(new p1.a());
                            }
                            i8 = 0;
                            tVar.f7186c = new r1.q(new PointF(0.0f, 0.0f), false, arrayList6);
                        } else {
                            i8 = 0;
                        }
                        r1.q qVar15 = tVar.f7186c;
                        qVar15.f9290c = z5;
                        PointF pointF10 = qVar3.f9289b;
                        qVar15.a(pointF10.x, pointF10.y);
                        ArrayList arrayList7 = qVar15.f9288a;
                        boolean z10 = qVar3.f9290c;
                        int i14 = i8;
                        int i15 = i14;
                        while (i14 < arrayList5.size()) {
                            p1.a aVar8 = (p1.a) arrayList5.get(i14);
                            p1.a aVar9 = (p1.a) arrayList5.get(t.c(i14 - 1, arrayList5.size()));
                            p1.a aVar10 = (p1.a) arrayList5.get(t.c(i14 - 2, arrayList5.size()));
                            PointF pointF11 = (i14 != 0 || z10) ? aVar9.f8617c : qVar3.f9289b;
                            PointF pointF12 = (i14 != 0 || z10) ? aVar9.f8616b : pointF11;
                            PointF pointF13 = aVar8.f8615a;
                            PointF pointF14 = aVar10.f8617c;
                            r1.q qVar16 = qVar8;
                            if (!qVar3.f9290c) {
                                if (i14 != 0) {
                                    z3 = true;
                                    if (i14 == arrayList5.size() - 1) {
                                    }
                                    if (pointF12.equals(pointF11) || !pointF13.equals(pointF11) || z2) {
                                        i10 = size6;
                                        i11 = i14;
                                        qVar7 = qVar15;
                                        p1.a aVar11 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                        p1.a aVar12 = (p1.a) arrayList7.get(i15);
                                        PointF pointF15 = aVar9.f8616b;
                                        aVar11.f8616b.set(pointF15.x, pointF15.y);
                                        PointF pointF16 = aVar9.f8617c;
                                        aVar11.f8617c.set(pointF16.x, pointF16.y);
                                        PointF pointF17 = aVar8.f8615a;
                                        aVar12.f8615a.set(pointF17.x, pointF17.y);
                                        i15++;
                                    } else {
                                        float f11 = pointF11.x;
                                        float f12 = f11 - pointF14.x;
                                        float f13 = pointF11.y;
                                        float f14 = f13 - pointF14.y;
                                        PointF pointF18 = aVar8.f8617c;
                                        float f15 = pointF18.x - f11;
                                        float f16 = pointF18.y - f13;
                                        i10 = size6;
                                        i11 = i14;
                                        float fHypot = (float) Math.hypot(f12, f14);
                                        double d7 = f15;
                                        qVar7 = qVar15;
                                        float fHypot2 = (float) Math.hypot(d7, f16);
                                        float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                                        float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                                        float f17 = pointF11.x;
                                        float fB = a1.a.b(pointF14.x, f17, fMin, f17);
                                        float f18 = pointF11.y;
                                        float fB2 = a1.a.b(pointF14.y, f18, fMin, f18);
                                        float fB3 = a1.a.b(pointF18.x, f17, fMin2, f17);
                                        float fB4 = a1.a.b(pointF18.y, f18, fMin2, f18);
                                        float f19 = fB - ((fB - f17) * 0.5519f);
                                        float f20 = fB2 - ((fB2 - f18) * 0.5519f);
                                        float f21 = fB3 - ((fB3 - f17) * 0.5519f);
                                        float f22 = fB4 - ((fB4 - f18) * 0.5519f);
                                        p1.a aVar13 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                        p1.a aVar14 = (p1.a) arrayList7.get(i15);
                                        aVar13.f8616b.set(fB, fB2);
                                        aVar13.f8617c.set(fB, fB2);
                                        if (i11 == 0) {
                                            qVar7.a(fB, fB2);
                                        }
                                        aVar14.f8615a.set(f19, f20);
                                        p1.a aVar15 = (p1.a) arrayList7.get(i15 + 1);
                                        aVar14.f8616b.set(f21, f22);
                                        aVar14.f8617c.set(fB3, fB4);
                                        aVar15.f8615a.set(fB3, fB4);
                                        i15 += 2;
                                    }
                                    i14 = i11 + 1;
                                    qVar15 = qVar7;
                                    z10 = z10;
                                    qVar9 = qVar9;
                                    qVar8 = qVar16;
                                    qVar3 = qVar3;
                                    size6 = i10;
                                    arrayList5 = arrayList5;
                                } else {
                                    z3 = true;
                                }
                                z2 = z3;
                                if (pointF12.equals(pointF11)) {
                                    i10 = size6;
                                    i11 = i14;
                                    qVar7 = qVar15;
                                    p1.a aVar16 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                    p1.a aVar17 = (p1.a) arrayList7.get(i15);
                                    PointF pointF19 = aVar9.f8616b;
                                    aVar16.f8616b.set(pointF19.x, pointF19.y);
                                    PointF pointF110 = aVar9.f8617c;
                                    aVar16.f8617c.set(pointF110.x, pointF110.y);
                                    PointF pointF111 = aVar8.f8615a;
                                    aVar17.f8615a.set(pointF111.x, pointF111.y);
                                    i15++;
                                } else {
                                    i10 = size6;
                                    i11 = i14;
                                    qVar7 = qVar15;
                                    p1.a aVar18 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                    p1.a aVar19 = (p1.a) arrayList7.get(i15);
                                    PointF pointF112 = aVar9.f8616b;
                                    aVar18.f8616b.set(pointF112.x, pointF112.y);
                                    PointF pointF113 = aVar9.f8617c;
                                    aVar18.f8617c.set(pointF113.x, pointF113.y);
                                    PointF pointF114 = aVar8.f8615a;
                                    aVar19.f8615a.set(pointF114.x, pointF114.y);
                                    i15++;
                                }
                                i14 = i11 + 1;
                                qVar15 = qVar7;
                                z10 = z10;
                                qVar9 = qVar9;
                                qVar8 = qVar16;
                                qVar3 = qVar3;
                                size6 = i10;
                                arrayList5 = arrayList5;
                            }
                            z2 = false;
                            if (pointF12.equals(pointF11)) {
                                i10 = size6;
                                i11 = i14;
                                qVar7 = qVar15;
                                p1.a aVar110 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                p1.a aVar111 = (p1.a) arrayList7.get(i15);
                                PointF pointF115 = aVar9.f8616b;
                                aVar110.f8616b.set(pointF115.x, pointF115.y);
                                PointF pointF116 = aVar9.f8617c;
                                aVar110.f8617c.set(pointF116.x, pointF116.y);
                                PointF pointF117 = aVar8.f8615a;
                                aVar111.f8615a.set(pointF117.x, pointF117.y);
                                i15++;
                            } else {
                                i10 = size6;
                                i11 = i14;
                                qVar7 = qVar15;
                                p1.a aVar112 = (p1.a) arrayList7.get(t.c(i15 - 1, arrayList7.size()));
                                p1.a aVar113 = (p1.a) arrayList7.get(i15);
                                PointF pointF118 = aVar9.f8616b;
                                aVar112.f8616b.set(pointF118.x, pointF118.y);
                                PointF pointF119 = aVar9.f8617c;
                                aVar112.f8617c.set(pointF119.x, pointF119.y);
                                PointF pointF1110 = aVar8.f8615a;
                                aVar113.f8615a.set(pointF1110.x, pointF1110.y);
                                i15++;
                            }
                            i14 = i11 + 1;
                            qVar15 = qVar7;
                            z10 = z10;
                            qVar9 = qVar9;
                            qVar8 = qVar16;
                            qVar3 = qVar3;
                            size6 = i10;
                            arrayList5 = arrayList5;
                        }
                        qVar5 = qVar8;
                        qVar6 = qVar9;
                        i9 = size6;
                        qVar3 = qVar15;
                    }
                }
                size6 = i9 - 1;
                qVar9 = qVar6;
                qVar8 = qVar5;
            }
            qVar = qVar8;
            qVar2 = qVar9;
        } else {
            qVar = qVar8;
            qVar2 = qVar9;
            qVar3 = qVar13;
        }
        Path path = this.f7601j;
        w1.f.d(qVar3, path);
        if (this.e == null) {
            return path;
        }
        if (this.f7602k == null) {
            this.f7602k = new Path();
            this.f7603l = new Path();
        }
        w1.f.d(qVar, this.f7602k);
        if (qVar2 != null) {
            qVar4 = qVar2;
            w1.f.d(qVar4, this.f7603l);
        } else {
            qVar4 = qVar2;
        }
        x1.c cVar = this.e;
        float fFloatValue2 = aVar.f10811h.floatValue();
        Path path2 = this.f7602k;
        return (Path) cVar.b(aVar.f10810g, fFloatValue2, path2, qVar4 == null ? path2 : this.f7603l, f, e(), this.f7577d);
    }
}
