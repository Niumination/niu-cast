package af;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f203a;

    static {
        int[] iArr = new int[ze.q.values().length];
        f203a = iArr;
        try {
            iArr[ze.q.IDLE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f203a[ze.q.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f203a[ze.q.READY.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f203a[ze.q.TRANSIENT_FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
