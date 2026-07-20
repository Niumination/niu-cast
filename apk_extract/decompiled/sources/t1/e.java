package t1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f10162a;

    static {
        int[] iArr = new int[c.values().length];
        f10162a = iArr;
        try {
            iArr[c.ZIP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10162a[c.GZIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
