package m3;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static float a(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f, int i8, int i9) {
        if (i8 == i9 || f <= 0.0f) {
            return i8;
        }
        if (f >= 1.0f) {
            return i9;
        }
        float f4 = ((i8 >> 24) & 255) / 255.0f;
        float f10 = ((i9 >> 24) & 255) / 255.0f;
        float fA = a(((i8 >> 16) & 255) / 255.0f);
        float fA2 = a(((i8 >> 8) & 255) / 255.0f);
        float fA3 = a((i8 & 255) / 255.0f);
        float fA4 = a(((i9 >> 16) & 255) / 255.0f);
        float fA5 = a(((i9 >> 8) & 255) / 255.0f);
        float fA6 = a((i9 & 255) / 255.0f);
        float fB = a1.a.b(f10, f4, f, f4);
        float fB2 = a1.a.b(fA4, fA, f, fA);
        float fB3 = a1.a.b(fA5, fA2, f, fA2);
        float fB4 = a1.a.b(fA6, fA3, f, fA3);
        float fB5 = b(fB2) * 255.0f;
        float fB6 = b(fB3) * 255.0f;
        return Math.round(b(fB4) * 255.0f) | (Math.round(fB5) << 16) | (Math.round(fB * 255.0f) << 24) | (Math.round(fB6) << 8);
    }
}
