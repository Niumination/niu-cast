package up;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f16392a = a.f16393a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f16393a = new a();

        @os.l
        public final d a(@os.m Runnable runnable, @os.m jn.l<? super InterruptedException, l2> lVar) {
            return (runnable == null || lVar == null) ? new d(null, 1, null) : new c(runnable, lVar);
        }
    }

    void lock();

    void unlock();
}
