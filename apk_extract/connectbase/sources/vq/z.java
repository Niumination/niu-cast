package vq;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17895a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17896b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17897c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Object f17898d = new u0("CONDITION_FALSE");

    @os.l
    public static final Object a() {
        return f17898d;
    }

    @lm.z0
    public static /* synthetic */ void b() {
    }

    @lm.z0
    public static /* synthetic */ void c() {
    }

    @lm.z0
    public static /* synthetic */ void d() {
    }

    @lm.z0
    public static /* synthetic */ void e() {
    }

    @lm.z0
    @os.l
    public static final a0 f(@os.l Object obj) {
        a0 a0Var;
        o0 o0Var = obj instanceof o0 ? (o0) obj : null;
        if (o0Var != null && (a0Var = o0Var.f17869a) != null) {
            return a0Var;
        }
        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (a0) obj;
    }
}
