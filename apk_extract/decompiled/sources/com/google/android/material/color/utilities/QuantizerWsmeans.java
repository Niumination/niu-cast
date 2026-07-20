package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i8) {
        int[] iArr3;
        int i9;
        int i10;
        int i11;
        int i12 = 1;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr = new double[iArr.length][];
        int[] iArr4 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i13 = 0;
        for (int i14 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i14));
            if (num == null) {
                dArr[i13] = pointProviderLab.fromInt(i14);
                iArr4[i13] = i14;
                i13++;
                linkedHashMap.put(Integer.valueOf(i14), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i14), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr5 = new int[i13];
        for (int i15 = 0; i15 < i13; i15++) {
            iArr5[i15] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr4[i15]))).intValue();
        }
        int iMin = Math.min(i8, i13);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr2 = new double[iMin][];
        int i16 = 0;
        for (int i17 = 0; i17 < iArr2.length; i17++) {
            dArr2[i17] = pointProviderLab.fromInt(iArr2[i17]);
            i16++;
        }
        int i18 = iMin - i16;
        if (i18 > 0) {
            for (int i19 = 0; i19 < i18; i19++) {
            }
        }
        int[] iArr6 = new int[i13];
        for (int i20 = 0; i20 < i13; i20++) {
            iArr6[i20] = random.nextInt(iMin);
        }
        int[][] iArr7 = new int[iMin][];
        for (int i21 = 0; i21 < iMin; i21++) {
            iArr7[i21] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i22 = 0; i22 < iMin; i22++) {
            distanceArr[i22] = new Distance[iMin];
            for (int i23 = 0; i23 < iMin; i23++) {
                distanceArr[i22][i23] = new Distance();
            }
        }
        int[] iArr8 = new int[iMin];
        int i24 = 0;
        while (true) {
            if (i24 >= 10) {
                iArr3 = iArr8;
                i9 = 0;
                break;
            }
            int i25 = 0;
            while (i25 < iMin) {
                int i26 = i25 + 1;
                int i27 = i26;
                while (i27 < iMin) {
                    int[] iArr9 = iArr8;
                    double dDistance = pointProviderLab.distance(dArr2[i25], dArr2[i27]);
                    Distance distance = distanceArr[i27][i25];
                    distance.distance = dDistance;
                    distance.index = i25;
                    Distance distance2 = distanceArr[i25][i27];
                    distance2.distance = dDistance;
                    distance2.index = i27;
                    i12 = 1;
                    i27++;
                    iArr8 = iArr9;
                    i24 = i24;
                }
                int[] iArr10 = iArr8;
                int i28 = i24;
                Arrays.sort(distanceArr[i25]);
                for (int i29 = 0; i29 < iMin; i29 += i12) {
                    iArr7[i25][i29] = distanceArr[i25][i29].index;
                }
                iArr8 = iArr10;
                i24 = i28;
                i25 = i26;
            }
            int[] iArr11 = iArr8;
            int i30 = i24;
            int i31 = 0;
            int i32 = 0;
            while (i31 < i13) {
                double[] dArr3 = dArr[i31];
                int i33 = iArr6[i31];
                double dDistance2 = pointProviderLab.distance(dArr3, dArr2[i33]);
                int[][] iArr12 = iArr7;
                double d7 = dDistance2;
                int i34 = -1;
                int i35 = 0;
                while (i35 < iMin) {
                    Distance[][] distanceArr2 = distanceArr;
                    int i36 = i13;
                    if (distanceArr[i33][i35].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr3, dArr2[i35]);
                        if (dDistance3 < d7) {
                            d7 = dDistance3;
                            i34 = i35;
                        }
                    }
                    i35++;
                    i13 = i36;
                    distanceArr = distanceArr2;
                }
                Distance[][] distanceArr3 = distanceArr;
                int i37 = i13;
                if (i34 != -1 && Math.abs(Math.sqrt(d7) - Math.sqrt(dDistance2)) > 3.0d) {
                    i32++;
                    iArr6[i31] = i34;
                }
                i31++;
                iArr7 = iArr12;
                i13 = i37;
                distanceArr = distanceArr3;
            }
            int[][] iArr13 = iArr7;
            Distance[][] distanceArr4 = distanceArr;
            int i38 = i13;
            if (i32 == 0 && i30 != 0) {
                i9 = 0;
                iArr3 = iArr11;
                break;
            }
            double[] dArr4 = new double[iMin];
            double[] dArr5 = new double[iMin];
            double[] dArr6 = new double[iMin];
            char c9 = 0;
            Arrays.fill(iArr11, 0);
            int i39 = 0;
            while (true) {
                i10 = i38;
                if (i39 >= i10) {
                    break;
                }
                int i40 = iArr6[i39];
                double[] dArr7 = dArr[i39];
                int i41 = iArr5[i39];
                iArr11[i40] = iArr11[i40] + i41;
                double d10 = dArr4[i40];
                double d11 = dArr7[c9];
                int[] iArr14 = iArr5;
                double d12 = i41;
                dArr4[i40] = (d11 * d12) + d10;
                dArr5[i40] = (dArr7[1] * d12) + dArr5[i40];
                dArr6[i40] = (dArr7[2] * d12) + dArr6[i40];
                i39++;
                iArr5 = iArr14;
                iArr6 = iArr6;
                c9 = 0;
                i38 = i10;
            }
            int[] iArr15 = iArr5;
            int[] iArr16 = iArr6;
            int i42 = 0;
            while (i42 < iMin) {
                int i43 = iArr11[i42];
                if (i43 == 0) {
                    dArr2[i42] = new double[]{0.0d, 0.0d, 0.0d};
                    i11 = 1;
                } else {
                    double d13 = i43;
                    double d14 = dArr4[i42] / d13;
                    double d15 = dArr5[i42] / d13;
                    double d16 = dArr6[i42] / d13;
                    double[] dArr8 = dArr2[i42];
                    dArr8[0] = d14;
                    i11 = 1;
                    dArr8[1] = d15;
                    dArr8[2] = d16;
                }
                i42 += i11;
            }
            i24 = i30 + 1;
            iArr5 = iArr15;
            i12 = 1;
            iArr7 = iArr13;
            iArr6 = iArr16;
            distanceArr = distanceArr4;
            iArr8 = iArr11;
            i13 = i10;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i44 = i9; i44 < iMin; i44++) {
            int i45 = iArr3[i44];
            if (i45 != 0) {
                int i46 = pointProviderLab.toInt(dArr2[i44]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i46))) {
                    linkedHashMap2.put(Integer.valueOf(i46), Integer.valueOf(i45));
                }
            }
        }
        return linkedHashMap2;
    }
}
