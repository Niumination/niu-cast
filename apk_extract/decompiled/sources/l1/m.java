package l1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7147a;

    static {
        int[] iArr = new int[r1.k.values().length];
        f7147a = iArr;
        try {
            iArr[r1.k.MERGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7147a[r1.k.ADD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7147a[r1.k.SUBTRACT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7147a[r1.k.INTERSECT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7147a[r1.k.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
