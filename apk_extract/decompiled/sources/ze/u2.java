package ze;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f11445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11447c;

    public u2(Runnable runnable) {
        this.f11445a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11446b) {
            return;
        }
        this.f11447c = true;
        this.f11445a.run();
    }
}
