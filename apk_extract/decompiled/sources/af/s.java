package af;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f561a;

    static {
        int[] iArr = new int[ze.h.values().length];
        f561a = iArr;
        try {
            iArr[ze.h.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f561a[ze.h.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f561a[ze.h.INFO.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
