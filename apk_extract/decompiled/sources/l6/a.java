package l6;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f7334c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f7335d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f7337b;

    static {
        for (int i8 = 0; i8 < 32; i8++) {
            f7335d.put(Character.valueOf(f7334c[i8]), Integer.valueOf(i8));
        }
    }

    public static a b(int i8, double d7, double d10) {
        if (i8 > 12) {
            throw new IllegalArgumentException("A geohash can only be 12 character long.");
        }
        int i9 = i8 * 5;
        if (i9 > 60) {
            i9 = 60;
        }
        a aVar = new a();
        aVar.f7336a = 0L;
        aVar.f7337b = (byte) 0;
        int iMin = Math.min(i9, 64);
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        boolean z2 = true;
        while (aVar.f7337b < iMin) {
            if (z2) {
                aVar.c(d10, dArr2);
            } else {
                aVar.c(d7, dArr);
            }
            z2 = !z2;
        }
        aVar.f7336a <<= 64 - iMin;
        return aVar;
    }

    public final String a() {
        if (this.f7337b % 5 != 0) {
            throw new IllegalStateException("Cannot convert a geohash to base32 if the precision is not a multiple of 5.");
        }
        StringBuilder sb2 = new StringBuilder();
        long j8 = this.f7336a;
        int iCeil = (int) Math.ceil(((double) this.f7337b) / 5.0d);
        for (int i8 = 0; i8 < iCeil; i8++) {
            sb2.append(f7334c[(int) (((-576460752303423488L) & j8) >>> 59)]);
            j8 <<= 5;
        }
        return sb2.toString();
    }

    public final void c(double d7, double[] dArr) {
        double d10 = (dArr[0] + dArr[1]) / 2.0d;
        if (d7 >= d10) {
            this.f7337b = (byte) (this.f7337b + 1);
            this.f7336a = (this.f7336a << 1) | 1;
            dArr[0] = d10;
        } else {
            this.f7337b = (byte) (this.f7337b + 1);
            this.f7336a <<= 1;
            dArr[1] = d10;
        }
    }
}
