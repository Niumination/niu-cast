package si;

import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f10125c;

    public k(Runnable runnable, long j8, boolean z2) {
        super(j8, z2);
        this.f10125c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10125c.run();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f10125c;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(l0.j(runnable));
        sb2.append(", ");
        sb2.append(this.f10123a);
        sb2.append(", ");
        return a1.a.s(sb2, this.f10124b ? "Blocking" : "Non-blocking", ']');
    }
}
