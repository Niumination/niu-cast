package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final h1 f6045a = new h1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f6046b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f6047c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f6048d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f6049e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f6050f;

    static {
        String property = System.getProperty(i1.f6054a);
        boolean z10 = false;
        if (property != null && Boolean.parseBoolean(property)) {
            z10 = true;
        }
        f6050f = z10;
    }

    public final boolean a() {
        return f6046b;
    }

    public final boolean b() {
        return f6050f;
    }

    public final boolean c() {
        return f6048d;
    }

    public final boolean d() {
        return f6049e;
    }

    public final boolean e() {
        return f6047c;
    }
}
