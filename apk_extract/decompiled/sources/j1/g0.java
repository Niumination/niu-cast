package j1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5961a;

    static {
        int[] iArr = new int[h0.values().length];
        f5961a = iArr;
        try {
            iArr[h0.HARDWARE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5961a[h0.SOFTWARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5961a[h0.AUTOMATIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
