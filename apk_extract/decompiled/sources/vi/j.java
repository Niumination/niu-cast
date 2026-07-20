package vi;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8.a f10603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a8.a f10604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a8.a f10605d;
    public static final a8.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10602a = qi.g.j("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
    public static final int f = qi.g.j("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);

    static {
        int i8 = 15;
        f10603b = new a8.a("PERMIT", i8);
        f10604c = new a8.a("TAKEN", i8);
        f10605d = new a8.a("BROKEN", i8);
        e = new a8.a("CANCELLED", i8);
    }
}
