package af;

import java.util.Random;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f212d;
    public long e;

    public final long a() {
        long j8 = this.e;
        double d7 = j8;
        this.e = Math.min((long) (this.f211c * d7), this.f210b);
        double d10 = this.f212d;
        double d11 = (-d10) * d7;
        double d12 = d10 * d7;
        v8.e(d12 >= d11);
        return j8 + ((long) ((this.f209a.nextDouble() * (d12 - d11)) + d11));
    }
}
