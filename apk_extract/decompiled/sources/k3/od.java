package k3;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class od {
    public static q1.a a(v1.e eVar, j1.j jVar) {
        return new q1.a(u1.q.a(eVar, jVar, 1.0f, u1.f.f10284b, false), 0);
    }

    public static q1.b b(v1.d dVar, j1.j jVar, boolean z2) {
        return new q1.b(u1.q.a(dVar, jVar, z2 ? w1.g.c() : 1.0f, u1.f.f10285c, false));
    }

    public static q1.a c(v1.e eVar, j1.j jVar, int i8) {
        cf.n0 n0Var = new cf.n0();
        n0Var.f1602a = i8;
        ArrayList arrayListA = u1.q.a(eVar, jVar, 1.0f, n0Var, false);
        for (int i9 = 0; i9 < arrayListA.size(); i9++) {
            x1.a aVar = (x1.a) arrayListA.get(i9);
            r1.c cVar = (r1.c) aVar.f10807b;
            r1.c cVar2 = (r1.c) aVar.f10808c;
            if (cVar != null && cVar2 != null) {
                float[] fArr = cVar.f9248a;
                int length = fArr.length;
                float[] fArr2 = cVar2.f9248a;
                if (length != fArr2.length) {
                    int length2 = fArr.length + fArr2.length;
                    float[] fArr3 = new float[length2];
                    System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
                    System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
                    Arrays.sort(fArr3);
                    float f = Float.NaN;
                    int i10 = 0;
                    for (int i11 = 0; i11 < length2; i11++) {
                        float f4 = fArr3[i11];
                        if (f4 != f) {
                            fArr3[i10] = f4;
                            i10++;
                            f = fArr3[i11];
                        }
                    }
                    float[] fArrCopyOfRange = Arrays.copyOfRange(fArr3, 0, i10);
                    aVar = new x1.a(cVar.b(fArrCopyOfRange), cVar2.b(fArrCopyOfRange));
                }
            }
            arrayListA.set(i9, aVar);
        }
        return new q1.a(arrayListA, 1);
    }

    public static q1.a d(v1.d dVar, j1.j jVar) {
        return new q1.a(u1.q.a(dVar, jVar, 1.0f, u1.f.f10286d, false), 2);
    }

    public static q1.a e(v1.e eVar, j1.j jVar) {
        return new q1.a(u1.q.a(eVar, jVar, w1.g.c(), u1.f.f10287h, true), 3);
    }
}
