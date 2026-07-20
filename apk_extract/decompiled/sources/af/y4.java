package af;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class y4 extends ze.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e5 f719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x2 f721d;

    public y4(x2 x2Var, e5 e5Var) {
        this.f721d = x2Var;
        this.f719b = e5Var;
    }

    @Override // ze.n
    public final void l(long j8) {
        if (this.f721d.f695o.f != null) {
            return;
        }
        synchronized (this.f721d.f689i) {
            try {
                if (this.f721d.f695o.f == null) {
                    e5 e5Var = this.f719b;
                    if (!e5Var.f246b) {
                        long j10 = this.f720c + j8;
                        this.f720c = j10;
                        x2 x2Var = this.f721d;
                        long j11 = x2Var.f698t;
                        if (j10 <= j11) {
                            return;
                        }
                        if (j10 > x2Var.f691k) {
                            e5Var.f247c = true;
                        } else {
                            long jAddAndGet = ((AtomicLong) x2Var.f690j.f8405a).addAndGet(j10 - j11);
                            x2 x2Var2 = this.f721d;
                            x2Var2.f698t = this.f720c;
                            if (jAddAndGet > x2Var2.f692l) {
                                this.f719b.f247c = true;
                            }
                        }
                        e5 e5Var2 = this.f719b;
                        r4 r4VarN = e5Var2.f247c ? this.f721d.n(e5Var2) : null;
                        if (r4VarN != null) {
                            r4VarN.run();
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
