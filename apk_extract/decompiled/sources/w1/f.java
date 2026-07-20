package w1;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import l1.l;
import r1.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f10646a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f4, float f10) {
        return Math.max(f4, Math.min(f10, f));
    }

    public static int c(float f, float f4) {
        int i8 = (int) f;
        int i9 = (int) f4;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (!((i8 ^ i9) >= 0) && i11 != 0) {
            i10--;
        }
        return i8 - (i9 * i10);
    }

    public static void d(q qVar, Path path) {
        path.reset();
        PointF pointF = qVar.f9289b;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = f10646a;
        pointF2.set(pointF.x, pointF.y);
        int i8 = 0;
        while (true) {
            ArrayList arrayList = qVar.f9288a;
            if (i8 >= arrayList.size()) {
                break;
            }
            p1.a aVar = (p1.a) arrayList.get(i8);
            PointF pointF3 = aVar.f8615a;
            boolean zEquals = pointF3.equals(pointF2);
            PointF pointF4 = aVar.f8616b;
            PointF pointF5 = aVar.f8617c;
            if (zEquals && pointF4.equals(pointF5)) {
                path.lineTo(pointF5.x, pointF5.y);
            } else {
                path.cubicTo(pointF3.x, pointF3.y, pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            }
            pointF2.set(pointF5.x, pointF5.y);
            i8++;
        }
        if (qVar.f9290c) {
            path.close();
        }
    }

    public static float e(float f, float f4, float f10) {
        return a1.a.b(f4, f, f10, f);
    }

    public static void f(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2, l lVar) {
        if (fVar.a(i8, lVar.getName())) {
            String name = lVar.getName();
            fVar2.getClass();
            p1.f fVar3 = new p1.f(fVar2);
            fVar3.f8638a.add(name);
            p1.f fVar4 = new p1.f(fVar3);
            fVar4.f8639b = lVar;
            arrayList.add(fVar4);
        }
    }
}
