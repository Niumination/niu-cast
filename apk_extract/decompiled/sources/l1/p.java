package l1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7152a;

    static {
        int[] iArr = new int[r1.m.values().length];
        f7152a = iArr;
        try {
            iArr[r1.m.STAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7152a[r1.m.POLYGON.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
