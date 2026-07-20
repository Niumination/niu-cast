package cf;

import android.content.Context;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements g3.b, u1.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1602a;

    @Override // g3.b
    public int a(Context context, String str, boolean z2) {
        return 0;
    }

    @Override // g3.b
    public int b(Context context, String str) {
        return this.f1602a;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d3  */
    @Override // u1.f0
    public Object c(v1.d dVar, float f) {
        int i8;
        boolean z2;
        int iArgb;
        float f4;
        int iArgb2;
        float f10;
        float fE;
        ArrayList arrayList = new ArrayList();
        int i9 = 1;
        boolean z3 = dVar.s() == v1.c.BEGIN_ARRAY;
        if (z3) {
            dVar.a();
        }
        while (dVar.i()) {
            arrayList.add(Float.valueOf((float) dVar.l()));
        }
        int i10 = 2;
        int i11 = 4;
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.f1602a = 2;
        }
        if (z3) {
            dVar.g();
        }
        if (this.f1602a == -1) {
            this.f1602a = arrayList.size() / 4;
        }
        int i12 = this.f1602a;
        float[] fArr = new float[i12];
        int[] iArr = new int[i12];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i8 = this.f1602a * i11;
            if (i13 >= i8) {
                break;
            }
            int i16 = i13 / 4;
            double dFloatValue = ((Float) arrayList.get(i13)).floatValue();
            int i17 = i13 % 4;
            if (i17 != 0) {
                if (i17 == i9) {
                    i14 = (int) (dFloatValue * 255.0d);
                } else if (i17 == 2) {
                    i15 = (int) (dFloatValue * 255.0d);
                } else if (i17 == 3) {
                    iArr[i16] = Color.argb(255, i14, i15, (int) (dFloatValue * 255.0d));
                }
            } else if (i16 > 0) {
                float f11 = (float) dFloatValue;
                if (fArr[i16 - 1] >= f11) {
                    fArr[i16] = f11 + 0.01f;
                } else {
                    fArr[i16] = (float) dFloatValue;
                }
            } else {
                fArr[i16] = (float) dFloatValue;
            }
            i13++;
            i9 = 1;
            i11 = 4;
        }
        r1.c cVar = new r1.c(fArr, iArr);
        if (arrayList.size() <= i8) {
            return cVar;
        }
        int size = (arrayList.size() - i8) / 2;
        float[] fArr2 = new float[size];
        float[] fArr3 = new float[size];
        int i18 = 0;
        while (i8 < arrayList.size()) {
            if (i8 % 2 == 0) {
                fArr2[i18] = ((Float) arrayList.get(i8)).floatValue();
            } else {
                fArr3[i18] = ((Float) arrayList.get(i8)).floatValue();
                i18++;
            }
            i8++;
        }
        float[] fArrCopyOf = cVar.f9248a;
        if (fArrCopyOf.length == 0) {
            fArrCopyOf = fArr2;
        } else if (size != 0) {
            int length = fArrCopyOf.length + size;
            float[] fArr4 = new float[length];
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            for (int i22 = 0; i22 < length; i22++) {
                float f12 = i20 < fArrCopyOf.length ? fArrCopyOf[i20] : Float.NaN;
                float f13 = i21 < size ? fArr2[i21] : Float.NaN;
                if (Float.isNaN(f13) || f12 < f13) {
                    fArr4[i22] = f12;
                    i20++;
                } else if (Float.isNaN(f12) || f13 < f12) {
                    fArr4[i22] = f13;
                    i21++;
                } else {
                    fArr4[i22] = f12;
                    i20++;
                    i21++;
                    i19++;
                }
            }
            fArrCopyOf = i19 == 0 ? fArr4 : Arrays.copyOf(fArr4, length - i19);
        }
        int length2 = fArrCopyOf.length;
        int[] iArr2 = new int[length2];
        int i23 = 0;
        while (i23 < length2) {
            float f14 = fArrCopyOf[i23];
            int iBinarySearch = Arrays.binarySearch(fArr, f14);
            int iBinarySearch2 = Arrays.binarySearch(fArr2, f14);
            int[] iArr3 = cVar.f9249b;
            if (iBinarySearch < 0 || iBinarySearch2 > 0) {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = -(iBinarySearch2 + 1);
                }
                float f15 = fArr3[iBinarySearch2];
                if (iArr3.length < 2 || f14 == fArr[0]) {
                    z2 = false;
                    iArgb = iArr3[0];
                } else {
                    int i24 = 1;
                    while (true) {
                        if (i24 >= i12) {
                            throw new IllegalArgumentException("Unreachable code.");
                        }
                        f4 = fArr[i24];
                        if (f4 >= f14 || i24 == i12 - 1) {
                            break;
                        }
                        i24++;
                    }
                    if (i24 != i12 - 1 || f14 < f4) {
                        int i25 = i24 - 1;
                        float f16 = fArr[i25];
                        int iC = m3.l.c((f14 - f16) / (f4 - f16), iArr3[i25], iArr3[i24]);
                        iArgb = Color.argb((int) (f15 * 255.0f), Color.red(iC), Color.green(iC), Color.blue(iC));
                    } else {
                        iArgb = Color.argb((int) (f15 * 255.0f), Color.red(iArr3[i24]), Color.green(iArr3[i24]), Color.blue(iArr3[i24]));
                    }
                    z2 = false;
                }
                iArr2[i23] = iArgb;
            } else {
                int i26 = iArr3[iBinarySearch];
                if (size < i10 || f14 <= fArr2[0]) {
                    iArgb2 = Color.argb((int) (fArr3[0] * 255.0f), Color.red(i26), Color.green(i26), Color.blue(i26));
                } else {
                    int i27 = 1;
                    while (true) {
                        if (i27 >= size) {
                            throw new IllegalArgumentException("Unreachable code.");
                        }
                        f10 = fArr2[i27];
                        if (f10 >= f14 || i27 == size - 1) {
                            break;
                        }
                        i27++;
                    }
                    if (f10 <= f14) {
                        fE = fArr3[i27];
                    } else {
                        int i28 = i27 - 1;
                        float f17 = fArr2[i28];
                        fE = w1.f.e(fArr3[i28], fArr3[i27], (f14 - f17) / (f10 - f17));
                    }
                    iArgb2 = Color.argb((int) (fE * 255.0f), Color.red(i26), Color.green(i26), Color.blue(i26));
                }
                iArr2[i23] = iArgb2;
                z2 = false;
            }
            i23++;
            i10 = 2;
        }
        return new r1.c(fArrCopyOf, iArr2);
    }
}
