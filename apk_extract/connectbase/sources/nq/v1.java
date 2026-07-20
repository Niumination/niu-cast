package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11964b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11965c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11966d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f11967e = 1000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f11968f = 9223372036854L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f11969g = 4611686018427387903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11963a = new vq.u0("REMOVED_TASK");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11970h = new vq.u0("CLOSED_EMPTY");

    public static final long c(long j10) {
        return j10 / f11967e;
    }

    public static final long d(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= f11968f) {
            return Long.MAX_VALUE;
        }
        return f11967e * j10;
    }
}
