package cr;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f3493a = 65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.j
    public static w f3494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f3495c;

    public static void a(w wVar) {
        if (wVar.f3491f != null || wVar.f3492g != null) {
            throw new IllegalArgumentException();
        }
        if (wVar.f3489d) {
            return;
        }
        synchronized (x.class) {
            try {
                long j10 = f3495c;
                if (j10 + 8192 > 65536) {
                    return;
                }
                f3495c = j10 + 8192;
                wVar.f3491f = f3494b;
                wVar.f3488c = 0;
                wVar.f3487b = 0;
                f3494b = wVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static w b() {
        synchronized (x.class) {
            try {
                w wVar = f3494b;
                if (wVar == null) {
                    return new w();
                }
                f3494b = wVar.f3491f;
                wVar.f3491f = null;
                f3495c -= 8192;
                return wVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
