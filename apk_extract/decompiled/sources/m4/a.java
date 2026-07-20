package m4;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f7910c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuntimeException f7911a;

    static {
        if (j.f7928d) {
            f7910c = null;
            f7909b = null;
        } else {
            f7910c = new a(false, null);
            f7909b = new a(true, null);
        }
    }

    public a(boolean z2, RuntimeException runtimeException) {
        this.f7911a = runtimeException;
    }
}
