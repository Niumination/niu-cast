package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11953e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11954f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11955g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11949a = new vq.u0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public static final vq.u0 f11950b = new vq.u0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11951c = new vq.u0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11952d = new vq.u0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final vq.u0 f11956h = new vq.u0("SEALED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final q1 f11957i = new q1(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final q1 f11958j = new q1(true);

    @os.m
    public static final Object g(@os.m Object obj) {
        return obj instanceof e2 ? new f2((e2) obj) : obj;
    }

    @os.m
    public static final Object h(@os.m Object obj) {
        e2 e2Var;
        f2 f2Var = obj instanceof f2 ? (f2) obj : null;
        return (f2Var == null || (e2Var = f2Var.f11849a) == null) ? obj : e2Var;
    }
}
