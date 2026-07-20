package af;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f121d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i8, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f118a = i8;
        this.e = obj;
        this.f119b = obj2;
        this.f120c = obj3;
        this.f121d = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f118a) {
            case 0:
                ((b) this.e).p((ze.q2) this.f119b, (c0) this.f120c, (ze.p1) this.f121d);
                return;
            case 1:
                ((d0) ((w0) this.e).f641b).l((ze.q2) this.f119b, (c0) this.f120c, (ze.p1) this.f121d);
                return;
            case 2:
                x2 x2Var = (x2) this.e;
                x2Var.f703z = true;
                x2Var.u.l((ze.q2) this.f119b, (c0) this.f120c, (ze.p1) this.f121d);
                return;
            default:
                synchronized (((g6) this.e)) {
                    try {
                        if (((e6) this.f119b).f250b == 0) {
                            try {
                                ((f6) this.f120c).f(this.f121d);
                                ((g6) this.e).f298a.remove((f6) this.f120c);
                                if (((g6) this.e).f298a.isEmpty()) {
                                    ((g6) this.e).f300c.shutdown();
                                    ((g6) this.e).f300c = null;
                                }
                            } catch (Throwable th2) {
                                ((g6) this.e).f298a.remove((f6) this.f120c);
                                if (((g6) this.e).f298a.isEmpty()) {
                                    ((g6) this.e).f300c.shutdown();
                                    ((g6) this.e).f300c = null;
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
        }
    }
}
