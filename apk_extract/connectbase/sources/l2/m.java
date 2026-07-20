package l2;

import kn.l0;
import kn.w;
import nq.v1;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f9672f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final String f9673g = "AnimPlayer.SpeedControlUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9677d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9674a = v1.f11967e;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9678e = true;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public final void a(long j10) {
        long j11 = this.f9676c;
        long j12 = 0;
        if (j11 == 0) {
            this.f9676c = System.nanoTime() / ((long) 1000);
            this.f9675b = j10;
            return;
        }
        if (this.f9678e) {
            this.f9675b = j10 - (this.f9674a / ((long) 30));
            this.f9678e = false;
        }
        long j13 = this.f9677d;
        if (j13 == 0) {
            j13 = j10 - this.f9675b;
        }
        if (j13 >= 0) {
            long j14 = this.f9674a;
            j12 = j13 > ((long) 10) * j14 ? j14 * ((long) 5) : j13;
        }
        long j15 = j11 + j12;
        long jNanoTime = System.nanoTime();
        long j16 = 1000;
        while (true) {
            long j17 = jNanoTime / j16;
            if (j17 >= j15 - ((long) 100)) {
                this.f9676c += j12;
                this.f9675b += j12;
                return;
            }
            long j18 = j15 - j17;
            if (j18 > 500000) {
                j18 = 500000;
            }
            try {
                Thread.sleep(j18 / j16, ((int) (j18 % j16)) * 1000);
            } catch (InterruptedException e10) {
                l2.a.f9640a.c(f9673g, l0.C("e=", e10), e10);
            }
            jNanoTime = System.nanoTime();
        }
    }

    public final void b() {
        this.f9675b = 0L;
        this.f9676c = 0L;
    }

    public final void c(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.f9677d = this.f9674a / ((long) i10);
    }
}
