package li;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f7434c;

    public b1(long j8, Runnable runnable) {
        super(j8);
        this.f7434c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7434c.run();
    }

    @Override // li.c1
    public final String toString() {
        return super.toString() + this.f7434c;
    }
}
