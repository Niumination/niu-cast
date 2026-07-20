package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d7, float f) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d7);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d7;
        this.mPeriod[iBinarySearch] = f;
        this.mNormalized = false;
    }

    public double getDP(double d7) {
        if (d7 <= 0.0d) {
            d7 = 1.0E-5d;
        } else if (d7 >= 1.0d) {
            d7 = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d7);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i8 = -iBinarySearch;
        int i9 = i8 - 1;
        float[] fArr = this.mPeriod;
        float f = fArr[i9];
        int i10 = i8 - 2;
        float f4 = fArr[i10];
        double[] dArr = this.mPosition;
        double d10 = dArr[i9];
        double d11 = dArr[i10];
        double d12 = ((double) (f - f4)) / (d10 - d11);
        return (((double) f4) - (d12 * d11)) + (d7 * d12);
    }

    public double getP(double d7) {
        if (d7 < 0.0d) {
            d7 = 0.0d;
        } else if (d7 > 1.0d) {
            d7 = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d7);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i8 = -iBinarySearch;
        int i9 = i8 - 1;
        float[] fArr = this.mPeriod;
        float f = fArr[i9];
        int i10 = i8 - 2;
        float f4 = fArr[i10];
        double[] dArr = this.mPosition;
        double d10 = dArr[i9];
        double d11 = dArr[i10];
        double d12 = ((double) (f - f4)) / (d10 - d11);
        return ((((d7 * d7) - (d11 * d11)) * d12) / 2.0d) + ((d7 - d11) * (((double) f4) - (d12 * d11))) + this.mArea[i10];
    }

    public double getSlope(double d7, double d10, double d11) {
        double d12;
        double dSignum;
        double p = getP(d7) + d10;
        double dp = getDP(d7) + d11;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d12 = dp * 4.0d;
                dSignum = Math.signum((((p * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d13 = this.PI2;
                return Math.sin(d13 * p) * (-d13) * dp;
            case 6:
                return ((((p * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p % 1.0d, 0);
            default:
                double d14 = this.PI2;
                d12 = dp * d14;
                dSignum = Math.cos(d14 * p);
                break;
        }
        return dSignum * d12;
    }

    public double getValue(double d7, double d10) {
        double p = getP(d7) + d10;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p % 1.0d));
            case 2:
                return 1.0d - Math.abs((((p * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((p * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((p * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos((d10 + p) * this.PI2);
            case 6:
                double dAbs = 1.0d - Math.abs(((p * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (dAbs * dAbs);
            case 7:
                return this.mCustomCurve.getPos(p % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p);
        }
    }

    public void normalize() {
        double d7 = 0.0d;
        int i8 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i8 >= fArr.length) {
                break;
            }
            d7 += (double) fArr[i8];
            i8++;
        }
        double d10 = 0.0d;
        int i9 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i9 >= fArr2.length) {
                break;
            }
            int i10 = i9 - 1;
            float f = (fArr2[i10] + fArr2[i9]) / 2.0f;
            double[] dArr = this.mPosition;
            d10 += (dArr[i9] - dArr[i10]) * ((double) f);
            i9++;
        }
        int i11 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i11 >= fArr3.length) {
                break;
            }
            fArr3[i11] = (float) (((double) fArr3[i11]) * (d7 / d10));
            i11++;
        }
        this.mArea[0] = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i12 >= fArr4.length) {
                this.mNormalized = true;
                return;
            }
            int i13 = i12 - 1;
            float f4 = (fArr4[i13] + fArr4[i12]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d11 = dArr2[i12] - dArr2[i13];
            double[] dArr3 = this.mArea;
            dArr3[i12] = (d11 * ((double) f4)) + dArr3[i13];
            i12++;
        }
    }

    public void setType(int i8, String str) {
        this.mType = i8;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
