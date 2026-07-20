package androidx.transition;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.sqrt(Math.abs(f) * 2.0f) * ((double) Math.signum(f)));
    }

    public void addDataPoint(long j8, float f) {
        int i8 = (this.mIndex + 1) % 20;
        this.mIndex = i8;
        this.mTimeSamples[i8] = j8;
        this.mDataSamples[i8] = f;
    }

    public float calculateVelocity() {
        int i8 = this.mIndex;
        if (i8 == 0 && this.mTimeSamples[i8] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j8 = this.mTimeSamples[i8];
        int i9 = 0;
        long j10 = j8;
        while (true) {
            long j11 = this.mTimeSamples[i8];
            if (j11 == Long.MIN_VALUE) {
                break;
            }
            float f = j8 - j11;
            float fAbs = Math.abs(j11 - j10);
            if (f > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i8 == 0) {
                i8 = 20;
            }
            i8--;
            i9++;
            if (i9 >= 20) {
                break;
            }
            j10 = j11;
        }
        if (i9 < 2) {
            return 0.0f;
        }
        if (i9 == 2) {
            int i10 = this.mIndex;
            int i11 = i10 == 0 ? 19 : i10 - 1;
            long[] jArr = this.mTimeSamples;
            float f4 = jArr[i10] - jArr[i11];
            if (f4 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            return ((fArr[i10] - fArr[i11]) / f4) * 1000.0f;
        }
        int i12 = this.mIndex;
        int i13 = ((i12 - i9) + 21) % 20;
        int i14 = (i12 + 21) % 20;
        long j12 = this.mTimeSamples[i13];
        float f10 = this.mDataSamples[i13];
        int i15 = i13 + 1;
        float f11 = 0.0f;
        for (int i16 = i15 % 20; i16 != i14; i16 = (i16 + 1) % 20) {
            long j13 = this.mTimeSamples[i16];
            float f12 = j13 - j12;
            if (f12 != 0.0f) {
                float f13 = this.mDataSamples[i16];
                float f14 = (f13 - f10) / f12;
                float fAbs2 = (Math.abs(f14) * (f14 - kineticEnergyToVelocity(f11))) + f11;
                if (i16 == i15) {
                    fAbs2 *= 0.5f;
                }
                f11 = fAbs2;
                f10 = f13;
                j12 = j13;
            }
        }
        return kineticEnergyToVelocity(f11) * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
