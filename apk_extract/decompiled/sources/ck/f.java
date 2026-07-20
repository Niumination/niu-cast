package ck;

import ik.o;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ek.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qk.a f1732d;
    public final /* synthetic */ o e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f1733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f1734i;

    public f(g gVar, long j8, long j10, qk.a aVar, o oVar, long j11) {
        this.f1734i = gVar;
        this.f1732d = aVar;
        this.e = oVar;
        this.f1733h = j11;
        this.f1730b = j8;
        this.f1731c = j10;
    }

    @Override // ek.a
    public final void call() {
        long j8;
        qk.a aVar = this.f1732d;
        if (aVar.isUnsubscribed()) {
            return;
        }
        this.e.call();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        g gVar = this.f1734i;
        long nanos = timeUnit.toNanos(System.currentTimeMillis());
        long j10 = h.f1735a;
        long j11 = nanos + j10;
        long j12 = this.f1730b;
        long j13 = this.f1733h;
        if (j11 < j12 || nanos >= j12 + j13 + j10) {
            j8 = nanos + j13;
            long j14 = this.f1729a + 1;
            this.f1729a = j14;
            this.f1731c = j8 - (j13 * j14);
        } else {
            long j15 = this.f1731c;
            long j16 = this.f1729a + 1;
            this.f1729a = j16;
            j8 = (j16 * j13) + j15;
        }
        this.f1730b = nanos;
        aVar.a(gVar.a(this, j8 - nanos, TimeUnit.NANOSECONDS));
    }
}
