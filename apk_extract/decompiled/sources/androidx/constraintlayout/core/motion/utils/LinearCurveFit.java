package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i8 = 0;
        double d7 = 0.0d;
        while (true) {
            double d10 = d7;
            if (i8 >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d11 = dArr2[i8][0];
            if (i8 > 0) {
                Math.hypot(d11 - d7, d11 - d10);
            }
            i8++;
            d7 = d11;
        }
    }

    private double getLength2D(double d7) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d7 <= dArr[0]) {
            return 0.0d;
        }
        int i8 = length - 1;
        if (d7 >= dArr[i8]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i9 = 0;
        while (i9 < i8) {
            double[] dArr2 = this.mY[i9];
            double d12 = dArr2[0];
            double d13 = dArr2[1];
            if (i9 > 0) {
                dHypot += Math.hypot(d12 - d10, d13 - d11);
            }
            double[] dArr3 = this.mT;
            double d14 = dArr3[i9];
            if (d7 == d14) {
                return dHypot;
            }
            int i10 = i9 + 1;
            double d15 = dArr3[i10];
            if (d7 < d15) {
                double d16 = (d7 - d14) / (d15 - d14);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i9];
                double d17 = dArr5[0];
                double[] dArr6 = dArr4[i10];
                double d18 = dArr6[0];
                double d19 = 1.0d - d16;
                return Math.hypot(d13 - ((dArr6[1] * d16) + (dArr5[1] * d19)), d12 - ((d18 * d16) + (d17 * d19))) + dHypot;
            }
            i9 = i10;
            d10 = d12;
            d11 = d13;
        }
        return 0.0d;
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
                double d14 = (d7 - d13) / (d12 - d13);
                while (i8 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i8] = (dArr4[i15][i8] * d14) + ((1.0d - d14) * dArr4[i13][i8]);
                    i8++;
                }
                return;
            }
            i13 = i15;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d7, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d10 = dArr2[0];
        if (d7 <= d10) {
            d7 = d10;
        } else {
            d10 = dArr2[length - 1];
            if (d7 >= d10) {
                d7 = d10;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            double[] dArr3 = this.mT;
            int i9 = i8 + 1;
            double d11 = dArr3[i9];
            if (d7 <= d11) {
                double d12 = d11 - dArr3[i8];
                for (int i10 = 0; i10 < length2; i10++) {
                    double[][] dArr4 = this.mY;
                    dArr[i10] = (dArr4[i9][i10] - dArr4[i8][i10]) / d12;
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

    /* JADX WARN: Code duplicated, block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d7, int i8) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i9 = 0;
        double d10 = dArr[0];
        if (d7 < d10) {
            d7 = d10;
        } else {
            d10 = dArr[length - 1];
            if (d7 >= d10) {
                d7 = d10;
            }
        }
        while (i9 < length - 1) {
            double[] dArr2 = this.mT;
            int i10 = i9 + 1;
            double d11 = dArr2[i10];
            if (d7 <= d11) {
                double d12 = d11 - dArr2[i9];
                double[][] dArr3 = this.mY;
                return (dArr3[i10][i8] - dArr3[i9][i8]) / d12;
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
                double d14 = (d7 - d13) / (d12 - d13);
                while (i8 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i8] = (float) ((dArr3[i15][i8] * d14) + ((1.0d - d14) * dArr3[i13][i8]));
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
                double d14 = (d7 - d12) / (d13 - d12);
                double[][] dArr3 = this.mY;
                return (dArr3[i12][i8] * d14) + ((1.0d - d14) * dArr3[i9][i8]);
            }
            i9 = i12;
        }
        return 0.0d;
    }
}
