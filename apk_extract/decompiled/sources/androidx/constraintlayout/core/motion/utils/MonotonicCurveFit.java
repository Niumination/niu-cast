package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i8 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i8, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i9 = 0; i9 < length2; i9++) {
            int i10 = 0;
            while (i10 < i8) {
                int i11 = i10 + 1;
                double d7 = dArr[i11] - dArr[i10];
                double[] dArr5 = dArr3[i10];
                double d10 = (dArr2[i11][i9] - dArr2[i10][i9]) / d7;
                dArr5[i9] = d10;
                if (i10 == 0) {
                    dArr4[i10][i9] = d10;
                } else {
                    dArr4[i10][i9] = (dArr3[i10 - 1][i9] + d10) * 0.5d;
                }
                i10 = i11;
            }
            dArr4[i8][i9] = dArr3[length - 2][i9];
        }
        for (int i12 = 0; i12 < i8; i12++) {
            for (int i13 = 0; i13 < length2; i13++) {
                double d11 = dArr3[i12][i13];
                if (d11 == 0.0d) {
                    dArr4[i12][i13] = 0.0d;
                    dArr4[i12 + 1][i13] = 0.0d;
                } else {
                    double d12 = dArr4[i12][i13] / d11;
                    int i14 = i12 + 1;
                    double d13 = dArr4[i14][i13] / d11;
                    double dHypot = Math.hypot(d12, d13);
                    if (dHypot > 9.0d) {
                        double d14 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i12];
                        double[] dArr7 = dArr3[i12];
                        dArr6[i13] = d12 * d14 * dArr7[i13];
                        dArr4[i14][i13] = d14 * d13 * dArr7[i13];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i8 = 0;
        while (iIndexOf2 != -1) {
            dArr[i8] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i8++;
        }
        dArr[i8] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i8 + 1));
    }

    private static double diff(double d7, double d10, double d11, double d12, double d13, double d14) {
        double d15 = d10 * d10;
        double d16 = d10 * 6.0d;
        double d17 = 6.0d * d15 * d11;
        double d18 = 3.0d * d7;
        return (d7 * d13) + (((((d18 * d13) * d15) + (((d18 * d14) * d15) + ((d17 + ((d16 * d12) + (((-6.0d) * d15) * d12))) - (d16 * d11)))) - (((2.0d * d7) * d14) * d10)) - (((4.0d * d7) * d13) * d10));
    }

    private static double interpolate(double d7, double d10, double d11, double d12, double d13, double d14) {
        double d15 = d10 * d10;
        double d16 = d15 * d10;
        double d17 = 3.0d * d15;
        double d18 = d16 * 2.0d * d11;
        double d19 = ((d18 + ((d17 * d12) + (((-2.0d) * d16) * d12))) - (d17 * d11)) + d11;
        double d20 = d7 * d14;
        double d21 = (d20 * d16) + d19;
        double d22 = d7 * d13;
        return (d22 * d10) + ((((d16 * d22) + d21) - (d20 * d15)) - (((2.0d * d7) * d13) * d15));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d7, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i8 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d10 = dArr2[0];
            if (d7 <= d10) {
                getSlope(d10, this.mSlopeTemp);
                for (int i9 = 0; i9 < length2; i9++) {
                    dArr[i9] = ((d7 - this.mT[0]) * this.mSlopeTemp[i9]) + this.mY[0][i9];
                }
                return;
            }
            int i10 = length - 1;
            double d11 = dArr2[i10];
            if (d7 >= d11) {
                getSlope(d11, this.mSlopeTemp);
                while (i8 < length2) {
                    dArr[i8] = ((d7 - this.mT[i10]) * this.mSlopeTemp[i8]) + this.mY[i10][i8];
                    i8++;
                }
                return;
            }
        } else {
            if (d7 <= dArr2[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d7 >= dArr2[i12]) {
                while (i8 < length2) {
                    dArr[i8] = this.mY[i12][i8];
                    i8++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d7 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            double d12 = dArr3[i15];
            if (d7 < d12) {
                double d13 = dArr3[i13];
                double d14 = d12 - d13;
                double d15 = (d7 - d13) / d14;
                while (i8 < length2) {
                    double[][] dArr4 = this.mY;
                    double d16 = dArr4[i13][i8];
                    double d17 = dArr4[i15][i8];
                    double[][] dArr5 = this.mTangent;
                    dArr[i8] = interpolate(d14, d15, d16, d17, dArr5[i13][i8], dArr5[i15][i8]);
                    i8++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d7, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d10 = dArr2[0];
        if (d7 > d10) {
            d10 = dArr2[length - 1];
            if (d7 < d10) {
                d10 = d7;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            double[] dArr3 = this.mT;
            int i9 = i8 + 1;
            double d11 = dArr3[i9];
            if (d10 <= d11) {
                double d12 = dArr3[i8];
                double d13 = d11 - d12;
                double d14 = (d10 - d12) / d13;
                for (int i10 = 0; i10 < length2; i10++) {
                    double[][] dArr4 = this.mY;
                    double d15 = dArr4[i8][i10];
                    double d16 = dArr4[i9][i10];
                    double[][] dArr5 = this.mTangent;
                    dArr[i10] = diff(d13, d14, d15, d16, dArr5[i8][i10], dArr5[i9][i10]) / d13;
                }
                return;
            }
            i8 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d7 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i8 = 0; i8 < dArr.length; i8++) {
            double d10 = dArr[i8];
            int i9 = i8 + length2;
            dArr2[i9][0] = d10;
            double d11 = ((double) i8) * d7;
            dArr3[i9] = d11;
            if (i8 > 0) {
                int i10 = (length2 * 2) + i8;
                dArr2[i10][0] = d10 + 1.0d;
                dArr3[i10] = d11 + 1.0d;
                int i11 = i8 - 1;
                dArr2[i11][0] = (d10 - 1.0d) - d7;
                dArr3[i11] = (d11 - 1.0d) - d7;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d7, int i8) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i9 = 0;
        double d10 = dArr[0];
        if (d7 >= d10) {
            d10 = dArr[length - 1];
            if (d7 < d10) {
                d10 = d7;
            }
        }
        while (i9 < length - 1) {
            double[] dArr2 = this.mT;
            int i10 = i9 + 1;
            double d11 = dArr2[i10];
            if (d10 <= d11) {
                double d12 = dArr2[i9];
                double d13 = d11 - d12;
                double d14 = (d10 - d12) / d13;
                double[][] dArr3 = this.mY;
                double d15 = dArr3[i9][i8];
                double d16 = dArr3[i10][i8];
                double[][] dArr4 = this.mTangent;
                return diff(d13, d14, d15, d16, dArr4[i9][i8], dArr4[i10][i8]) / d13;
            }
            i9 = i10;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d7, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i8 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d10 = dArr[0];
            if (d7 <= d10) {
                getSlope(d10, this.mSlopeTemp);
                for (int i9 = 0; i9 < length2; i9++) {
                    fArr[i9] = (float) (((d7 - this.mT[0]) * this.mSlopeTemp[i9]) + this.mY[0][i9]);
                }
                return;
            }
            int i10 = length - 1;
            double d11 = dArr[i10];
            if (d7 >= d11) {
                getSlope(d11, this.mSlopeTemp);
                while (i8 < length2) {
                    fArr[i8] = (float) (((d7 - this.mT[i10]) * this.mSlopeTemp[i8]) + this.mY[i10][i8]);
                    i8++;
                }
                return;
            }
        } else {
            if (d7 <= dArr[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d7 >= dArr[i12]) {
                while (i8 < length2) {
                    fArr[i8] = (float) this.mY[i12][i8];
                    i8++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d7 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            double d12 = dArr2[i15];
            if (d7 < d12) {
                double d13 = dArr2[i13];
                double d14 = d12 - d13;
                double d15 = (d7 - d13) / d14;
                while (i8 < length2) {
                    double[][] dArr3 = this.mY;
                    double d16 = dArr3[i13][i8];
                    double d17 = dArr3[i15][i8];
                    double[][] dArr4 = this.mTangent;
                    fArr[i8] = (float) interpolate(d14, d15, d16, d17, dArr4[i13][i8], dArr4[i15][i8]);
                    i8++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d7, int i8) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i9 = 0;
        if (this.mExtrapolate) {
            double d10 = dArr[0];
            if (d7 <= d10) {
                return (getSlope(d10, i8) * (d7 - d10)) + this.mY[0][i8];
            }
            int i10 = length - 1;
            double d11 = dArr[i10];
            if (d7 >= d11) {
                return (getSlope(d11, i8) * (d7 - d11)) + this.mY[i10][i8];
            }
        } else {
            if (d7 <= dArr[0]) {
                return this.mY[0][i8];
            }
            int i11 = length - 1;
            if (d7 >= dArr[i11]) {
                return this.mY[i11][i8];
            }
        }
        while (i9 < length - 1) {
            double[] dArr2 = this.mT;
            double d12 = dArr2[i9];
            if (d7 == d12) {
                return this.mY[i9][i8];
            }
            int i12 = i9 + 1;
            double d13 = dArr2[i12];
            if (d7 < d13) {
                double d14 = d13 - d12;
                double d15 = (d7 - d12) / d14;
                double[][] dArr3 = this.mY;
                double d16 = dArr3[i9][i8];
                double d17 = dArr3[i12][i8];
                double[][] dArr4 = this.mTangent;
                return interpolate(d14, d15, d16, d17, dArr4[i9][i8], dArr4[i12][i8]);
            }
            i9 = i12;
        }
        return 0.0d;
    }
}
