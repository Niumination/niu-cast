package m3;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ka implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f7764h = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7768d = 2147483647L;
    public long e = -2147483648L;

    public ka(String str) {
    }

    public void a() {
        this.f7766b = SystemClock.elapsedRealtimeNanos() / 1000;
    }

    public void c(long j8) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j10 = this.f7767c;
        if (j10 != 0 && jElapsedRealtimeNanos - j10 >= 1000000) {
            this.f7765a = 0;
            this.f7766b = 0L;
            this.f7768d = 2147483647L;
            this.e = -2147483648L;
        }
        this.f7767c = jElapsedRealtimeNanos;
        this.f7765a++;
        this.f7768d = Math.min(this.f7768d, j8);
        this.e = Math.max(this.e, j8);
        if (this.f7765a % 50 == 0) {
            Locale locale = Locale.US;
            sa.b();
        }
        if (this.f7765a % 500 == 0) {
            this.f7765a = 0;
            this.f7766b = 0L;
            this.f7768d = 2147483647L;
            this.e = -2147483648L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j8 = this.f7766b;
        if (j8 == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        g(j8);
    }

    public void g(long j8) {
        c((SystemClock.elapsedRealtimeNanos() / 1000) - j8);
    }
}
