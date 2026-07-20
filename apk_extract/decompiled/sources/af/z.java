package af;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f741b;

    public z(a0 a0Var, long j8) {
        this.f741b = a0Var;
        this.f740a = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t1 t1Var = new t1(0);
        a0 a0Var = this.f741b;
        a0Var.f131j.j(t1Var);
        long j8 = this.f740a;
        long jAbs = Math.abs(j8);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit.toNanos(1L);
        long jAbs2 = Math.abs(j8) % timeUnit.toNanos(1L);
        StringBuilder sb2 = new StringBuilder("deadline exceeded after ");
        if (j8 < 0) {
            sb2.append('-');
        }
        sb2.append(nanos);
        Locale locale = Locale.US;
        sb2.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
        sb2.append("s. ");
        Long l4 = (Long) a0Var.f130i.a(ze.n.f11385a);
        sb2.append(String.format(locale, "Name resolution delay %.9f seconds. ", Double.valueOf(l4 == null ? 0.0d : l4.longValue() / a0.f123t)));
        sb2.append(t1Var);
        a0Var.f131j.h(ze.q2.f11405h.a(sb2.toString()));
    }
}
