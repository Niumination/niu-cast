package k3;

/* JADX INFO: loaded from: classes.dex */
public final class o2 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f6557a = new o2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f6558b = new q4.c("logEventKey", h0.a.s(h0.a.q(x0.class, new t0(1, w0.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f6559c = new q4.c("eventCount", h0.a.s(h0.a.q(x0.class, new t0(2, w0.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f6560d = new q4.c("inferenceDurationStats", h0.a.s(h0.a.q(x0.class, new t0(3, w0.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        h1 h1Var = (h1) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f6558b, h1Var.f6466a);
        eVar.a(f6559c, h1Var.f6467b);
        eVar.a(f6560d, h1Var.f6468c);
    }
}
