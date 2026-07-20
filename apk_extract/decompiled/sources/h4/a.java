package h4;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5243a;

    static {
        int[] iArr = new int[b.values().length];
        f5243a = iArr;
        try {
            iArr[b.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5243a[b.READY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
