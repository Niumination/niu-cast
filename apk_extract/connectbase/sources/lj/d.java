package lj;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f10030a = 0.3f;

    public static float a(float f10, float f11, int i10) {
        if (Float.compare(f11, 0.0f) == 0) {
            return 0.0f;
        }
        return ((float) Math.pow(1.0f - ((Math.abs(f10) - Math.abs(f11)) / i10), 4.0d)) * 0.6f;
    }

    public static int b(float f10, int i10) {
        if (Float.compare(f10, 0.0f) == 0) {
            return 0;
        }
        float f11 = i10;
        float f12 = f10 / f11;
        float fC = c(Math.abs(f12)) * (f12 / Math.abs(f12));
        if (Math.abs(fC) >= 1.0f) {
            fC /= Math.abs(fC);
        }
        return Math.round(fC * 0.3f * f11);
    }

    public static float c(float f10) {
        float f11 = f10 - 1.0f;
        return (f11 * f11 * f11) + 1.0f;
    }
}
