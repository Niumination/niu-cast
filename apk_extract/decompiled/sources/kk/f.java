package kk;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f6988l = s.a(f.class, "consumerIndex");

    public final boolean l() {
        return s.f6994a.compareAndSwapLong(this, f6988l, 0L, 1L);
    }
}
