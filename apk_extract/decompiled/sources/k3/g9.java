package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class g9 {
    public static int a(int i8, int i9) {
        if (i9 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int iHighestOneBit = i8 + (i8 >> 1) + 1;
        if (iHighestOneBit < i9) {
            iHighestOneBit = Integer.highestOneBit(i9 - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            return Integer.MAX_VALUE;
        }
        return iHighestOneBit;
    }
}
