package xq;

import nq.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    @os.l
    public final Runnable f20519c;

    public n(@os.l Runnable runnable, long j10, @os.l l lVar) {
        super(j10, lVar);
        this.f20519c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f20519c.run();
        } finally {
            this.f20517b.h();
        }
    }

    @os.l
    public String toString() {
        return "Task[" + x0.a(this.f20519c) + '@' + x0.b(this.f20519c) + ", " + this.f20516a + ", " + this.f20517b + ']';
    }
}
