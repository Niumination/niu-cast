package cf;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f1534b;

    static {
        int[] iArr = new int[i.values().length];
        f1534b = iArr;
        try {
            iArr[i.PLAINTEXT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1534b[i.TLS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[g.values().length];
        f1533a = iArr2;
        try {
            iArr2[g.TLS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1533a[g.PLAINTEXT.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
