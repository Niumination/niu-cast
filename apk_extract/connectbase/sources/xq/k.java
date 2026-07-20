package xq;

import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@z0
public abstract class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    public long f20516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public l f20517b;

    public k(long j10, @os.l l lVar) {
        this.f20516a = j10;
        this.f20517b = lVar;
    }

    public final int a() {
        return this.f20517b.q();
    }

    public k() {
        this(0L, o.f20528i);
    }
}
