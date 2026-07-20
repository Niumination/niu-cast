package s1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f9492a;

    static {
        int[] iArr = new int[p1.b.values().length];
        f9492a = iArr;
        try {
            iArr[p1.b.LEFT_ALIGN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9492a[p1.b.RIGHT_ALIGN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9492a[p1.b.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
