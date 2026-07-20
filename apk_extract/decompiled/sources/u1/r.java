package u1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f10312a;

    static {
        int[] iArr = new int[s1.h.values().length];
        f10312a = iArr;
        try {
            iArr[s1.h.LUMA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10312a[s1.h.LUMA_INVERTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
