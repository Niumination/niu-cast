package kk;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f6989k = s.a(i.class, "producerIndex");

    public final boolean k() {
        return s.f6994a.compareAndSwapLong(this, f6989k, 0L, 1L);
    }
}
