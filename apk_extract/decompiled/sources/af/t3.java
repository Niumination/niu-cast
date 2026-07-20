package af;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f595a;

    static {
        int[] iArr = new int[v3.values().length];
        f595a = iArr;
        try {
            iArr[v3.HEADER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f595a[v3.BODY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
