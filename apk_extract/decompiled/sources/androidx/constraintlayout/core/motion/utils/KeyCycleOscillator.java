package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    public static class CoreSpline extends KeyCycleOscillator {
        String type;
        int typeId;

        public CoreSpline(String str) {
            this.type = str;
            this.typeId = TypedValues.CycleType.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.typeId, get(f));
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        CurveFit mCurveFit;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        float[] mPhase;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i8, String str, int i9, int i10) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = i8;
            this.mVariesBy = i9;
            oscillator.setType(i8, str);
            this.mValues = new float[i10];
            this.mPosition = new double[i10];
            this.mPeriod = new float[i10];
            this.mOffset = new float[i10];
            this.mPhase = new float[i10];
            this.mScale = new float[i10];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d7 = f;
                curveFit.getSlope(d7, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d7, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d10 = f;
            double value = this.mOscillator.getValue(d10, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d10, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mPhase[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i8, int i9, float f, float f4, float f10, float f11) {
            this.mPosition[i8] = ((double) i9) / 100.0d;
            this.mPeriod[i8] = f;
            this.mOffset[i8] = f4;
            this.mPhase[i8] = f10;
            this.mValues[i8] = f11;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i8 = 0; i8 < dArr.length; i8++) {
                double[] dArr3 = dArr[i8];
                dArr3[0] = this.mOffset[i8];
                dArr3[1] = this.mPhase[i8];
                dArr3[2] = this.mValues[i8];
                this.mOscillator.addPoint(this.mPosition[i8], this.mPeriod[i8]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i8, int i9) {
            int i10 = iArr[i9];
            int i11 = i8;
            while (i8 < i9) {
                if (iArr[i8] <= i10) {
                    swap(iArr, fArr, i11, i8);
                    i11++;
                }
                i8++;
            }
            swap(iArr, fArr, i11, i9);
            return i11;
        }

        public static void sort(int[] iArr, float[] fArr, int i8, int i9) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i9;
            iArr2[1] = i8;
            int i10 = 2;
            while (i10 > 0) {
                int i11 = iArr2[i10 - 1];
                int i12 = i10 - 2;
                int i13 = iArr2[i12];
                if (i11 < i13) {
                    int iPartition = partition(iArr, fArr, i11, i13);
                    iArr2[i12] = iPartition - 1;
                    iArr2[i10 - 1] = i11;
                    int i14 = i10 + 1;
                    iArr2[i10] = i13;
                    i10 += 2;
                    iArr2[i14] = iPartition + 1;
                } else {
                    i10 = i12;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, int i8, int i9) {
            int i10 = iArr[i8];
            iArr[i8] = iArr[i9];
            iArr[i9] = i10;
            float f = fArr[i8];
            fArr[i8] = fArr[i9];
            fArr[i9] = f;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i8, int i9) {
            int i10 = iArr[i9];
            int i11 = i8;
            while (i8 < i9) {
                if (iArr[i8] <= i10) {
                    swap(iArr, fArr, fArr2, i11, i8);
                    i11++;
                }
                i8++;
            }
            swap(iArr, fArr, fArr2, i11, i9);
            return i11;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i8, int i9) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i9;
            iArr2[1] = i8;
            int i10 = 2;
            while (i10 > 0) {
                int i11 = iArr2[i10 - 1];
                int i12 = i10 - 2;
                int i13 = iArr2[i12];
                if (i11 < i13) {
                    int iPartition = partition(iArr, fArr, fArr2, i11, i13);
                    iArr2[i12] = iPartition - 1;
                    iArr2[i10 - 1] = i11;
                    int i14 = i10 + 1;
                    iArr2[i10] = i13;
                    i10 += 2;
                    iArr2[i14] = iPartition + 1;
                } else {
                    i10 = i12;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i8, int i9) {
            int i10 = iArr[i8];
            iArr[i8] = iArr[i9];
            iArr[i9] = i10;
            float f = fArr[i8];
            fArr[i8] = fArr[i9];
            fArr[i9] = f;
            float f4 = fArr2[i8];
            fArr2[i8] = fArr2[i9];
            fArr2[i9] = f4;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String type;
        int typeId;

        public PathRotateSet(String str) {
            this.type = str;
            this.typeId = TypedValues.CycleType.getId(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d7, double d10) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d10, d7))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.typeId, get(f));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i8, float f, float f4, float f10, float f11) {
            this.mPosition = i8;
            this.mValue = f11;
            this.mOffset = f4;
            this.mPeriod = f;
            this.mPhase = f10;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i8, int i9, String str, int i10, float f, float f4, float f10, float f11, Object obj) {
        this.mWavePoints.add(new WavePoint(i8, f, f4, f10, f11));
        if (i10 != -1) {
            this.mVariesBy = i10;
        }
        this.mWaveShape = i9;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        int i8 = 0;
        for (WavePoint wavePoint : this.mWavePoints) {
            float f4 = wavePoint.mPeriod;
            dArr[i8] = ((double) f4) * 0.01d;
            double[] dArr3 = dArr2[i8];
            float f10 = wavePoint.mValue;
            dArr3[0] = f10;
            float f11 = wavePoint.mOffset;
            dArr3[1] = f11;
            float f12 = wavePoint.mPhase;
            dArr3[2] = f12;
            this.mCycleOscillator.setPoint(i8, wavePoint.mPosition, f4, f11, f12, f10);
            i8++;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (WavePoint wavePoint : this.mWavePoints) {
            StringBuilder sbT = d.t(string, "[");
            sbT.append(wavePoint.mPosition);
            sbT.append(" , ");
            sbT.append(decimalFormat.format(wavePoint.mValue));
            sbT.append("] ");
            string = sbT.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i8, int i9, String str, int i10, float f, float f4, float f10, float f11) {
        this.mWavePoints.add(new WavePoint(i8, f, f4, f10, f11));
        if (i10 != -1) {
            this.mVariesBy = i10;
        }
        this.mWaveShape = i9;
        this.mWaveString = str;
    }
}
