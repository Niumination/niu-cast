package fk;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ek.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f5080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ck.h f5081c;

    public k(int i8, long j8, ck.h hVar) {
        this.f5079a = i8;
        this.f5080b = j8;
        this.f5081c = hVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new r(this.f5079a, this.f5080b, this.f5081c);
    }
}
