package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StepCurve extends Easing {
    private static final boolean DEBUG = false;
    MonotonicCurveFit mCurveFit;

    public StepCurve(String str) {
        this.str = str;
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
        this.mCurveFit = genSpline(Arrays.copyOf(dArr, i8 + 1));
    }

    private static MonotonicCurveFit genSpline(String str) {
        String[] strArrSplit = str.split("\\s+");
        int length = strArrSplit.length;
        double[] dArr = new double[length];
        for (int i8 = 0; i8 < length; i8++) {
            dArr[i8] = Double.parseDouble(strArrSplit[i8]);
        }
        return genSpline(dArr);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d7) {
        return this.mCurveFit.getPos(d7, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d7) {
        return this.mCurveFit.getSlope(d7, 0);
    }

    private static MonotonicCurveFit genSpline(double[] dArr) {
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
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr3, dArr2);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + monotonicCurveFit.getPos(0.0d, 0));
        printStream.println(" 1 " + monotonicCurveFit.getPos(1.0d, 0));
        return monotonicCurveFit;
    }
}
