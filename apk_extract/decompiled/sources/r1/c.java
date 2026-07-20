package r1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f9248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f9249b;

    public c(float[] fArr, int[] iArr) {
        this.f9248a = fArr;
        this.f9249b = iArr;
    }

    public final void a(c cVar) {
        int i8 = 0;
        while (true) {
            int[] iArr = cVar.f9249b;
            if (i8 >= iArr.length) {
                return;
            }
            this.f9248a[i8] = cVar.f9248a[i8];
            this.f9249b[i8] = iArr[i8];
            i8++;
        }
    }

    public final c b(float[] fArr) {
        int iC;
        int[] iArr = new int[fArr.length];
        for (int i8 = 0; i8 < fArr.length; i8++) {
            float f = fArr[i8];
            float[] fArr2 = this.f9248a;
            int iBinarySearch = Arrays.binarySearch(fArr2, f);
            int[] iArr2 = this.f9249b;
            if (iBinarySearch >= 0) {
                iC = iArr2[iBinarySearch];
            } else {
                int i9 = -(iBinarySearch + 1);
                if (i9 == 0) {
                    iC = iArr2[0];
                } else if (i9 == iArr2.length - 1) {
                    iC = iArr2[iArr2.length - 1];
                } else {
                    int i10 = i9 - 1;
                    float f4 = fArr2[i10];
                    iC = m3.l.c((f - f4) / (fArr2[i9] - f4), iArr2[i10], iArr2[i9]);
                }
            }
            iArr[i8] = iC;
        }
        return new c(fArr, iArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f9248a, cVar.f9248a) && Arrays.equals(this.f9249b, cVar.f9249b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9249b) + (Arrays.hashCode(this.f9248a) * 31);
    }
}
