package k4;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8976d = "connectx:Lock";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8977e = "WakeLockHelper";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8978f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f8979g = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public PowerManager f8980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public PowerManager.WakeLock f8981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m4.c f8982c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f8983a = new u();
    }

    public static u b() {
        return a.f8983a;
    }

    public final void a(boolean z10) {
        this.f8982c.g(z10);
    }

    public void c(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.f8980a = powerManager;
        this.f8981b = powerManager.newWakeLock(6, f8976d);
    }

    public void d(long j10) {
        a(true);
    }

    public void e() {
        a(false);
    }

    public u() {
        this.f8982c = m4.a.C0275a.f10375a;
    }
}
