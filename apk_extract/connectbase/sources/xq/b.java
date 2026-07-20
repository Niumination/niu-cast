package xq;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @in.i(name = "isSchedulerWorker")
    public static final boolean a(@os.l Thread thread) {
        return thread instanceof a.c;
    }

    @in.i(name = "mayNotBlock")
    public static final boolean b(@os.l Thread thread) {
        return (thread instanceof a.c) && ((a.c) thread).f20489c == a.d.CPU_ACQUIRED;
    }
}
