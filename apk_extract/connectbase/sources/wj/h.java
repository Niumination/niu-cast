package wj;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f18699c = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f18701b;

    @hm.d
    public final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f18702c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18703a;

        public void a() {
            long j10 = this.f18703a;
            long jMax = Math.max(2 * j10, j10);
            if (h.this.f18701b.compareAndSet(this.f18703a, jMax)) {
                h.f18699c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{h.this.f18700a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f18703a;
        }

        public b(long j10) {
            this.f18703a = j10;
        }
    }

    public h(String str, long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.f18701b = atomicLong;
        c1.h0.e(j10 > 0, "value must be positive");
        this.f18700a = str;
        atomicLong.set(j10);
    }

    public b d() {
        return new b(this.f18701b.get());
    }
}
