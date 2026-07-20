package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f5642a = -862048943;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f5643b = 461845907;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5644c = 1073741824;

    public static int a(int expectedEntries, double loadFactor) {
        int iMax = Math.max(expectedEntries, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (loadFactor * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i10 = iHighestOneBit << 1;
        if (i10 > 0) {
            return i10;
        }
        return 1073741824;
    }

    public static boolean b(int size, int tableSize, double loadFactor) {
        return ((double) size) > loadFactor * ((double) tableSize) && tableSize < 1073741824;
    }

    public static int c(int hashCode) {
        return (int) (((long) Integer.rotateLeft((int) (((long) hashCode) * f5642a), 15)) * f5643b);
    }

    public static int d(@gm.a Object o10) {
        return c(o10 == null ? 0 : o10.hashCode());
    }
}
