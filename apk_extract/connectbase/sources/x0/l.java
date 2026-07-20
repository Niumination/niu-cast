package x0;

import android.graphics.Color;
import androidx.annotation.IntRange;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l implements k0<u0.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19915a;

    public l(int i10) {
        this.f19915a = i10;
    }

    public final void b(u0.c cVar, List<Float> list) {
        int i10 = this.f19915a * 4;
        if (list.size() <= i10) {
            return;
        }
        int size = (list.size() - i10) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i11 = 0;
        while (i10 < list.size()) {
            if (i10 % 2 == 0) {
                dArr[i11] = list.get(i10).floatValue();
            } else {
                dArr2[i11] = list.get(i10).floatValue();
                i11++;
            }
            i10++;
        }
        for (int i12 = 0; i12 < cVar.c(); i12++) {
            int i13 = cVar.a()[i12];
            cVar.a()[i12] = Color.argb(c(cVar.b()[i12], dArr, dArr2), Color.red(i13), Color.green(i13), Color.blue(i13));
        }
    }

    @IntRange(from = 0, to = 255)
    public final int c(double d10, double[] dArr, double[] dArr2) {
        double dJ;
        for (int i10 = 1; i10 < dArr.length; i10++) {
            int i11 = i10 - 1;
            double d11 = dArr[i11];
            double d12 = dArr[i10];
            if (d12 >= d10) {
                dJ = z0.g.j(dArr2[i11], dArr2[i10], z0.g.b((d10 - d11) / (d12 - d11), 0.0d, 1.0d));
                return (int) (dJ * 255.0d);
            }
        }
        dJ = dArr2[dArr2.length - 1];
        return (int) (dJ * 255.0d);
    }

    @Override // x0.k0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public u0.c a(y0.c cVar, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z10 = cVar.O() == y0.c.b.BEGIN_ARRAY;
        if (z10) {
            cVar.c();
        }
        while (cVar.o()) {
            arrayList.add(Float.valueOf((float) cVar.q()));
        }
        if (z10) {
            cVar.h();
        }
        if (this.f19915a == -1) {
            this.f19915a = arrayList.size() / 4;
        }
        int i10 = this.f19915a;
        float[] fArr = new float[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f19915a * 4; i13++) {
            int i14 = i13 / 4;
            double dFloatValue = ((Float) arrayList.get(i13)).floatValue();
            int i15 = i13 % 4;
            if (i15 == 0) {
                fArr[i14] = (float) dFloatValue;
            } else if (i15 == 1) {
                i11 = (int) (dFloatValue * 255.0d);
            } else if (i15 == 2) {
                i12 = (int) (dFloatValue * 255.0d);
            } else if (i15 == 3) {
                iArr[i14] = Color.argb(255, i11, i12, (int) (dFloatValue * 255.0d));
            }
        }
        u0.c cVar2 = new u0.c(fArr, iArr);
        b(cVar2, arrayList);
        return cVar2;
    }
}
