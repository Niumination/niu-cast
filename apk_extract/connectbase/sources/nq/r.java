package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11903a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11904b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11905c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11906d = 29;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11907e = 536870911;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11908f = 536870911;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @in.f
    @os.l
    public static final vq.u0 f11909g = new vq.u0("RESUME_TOKEN");

    public static final int a(int i10, int i11) {
        return (i10 << 29) + i11;
    }

    public static final int b(int i10) {
        return i10 >> 29;
    }

    public static final int c(int i10) {
        return i10 & 536870911;
    }
}
