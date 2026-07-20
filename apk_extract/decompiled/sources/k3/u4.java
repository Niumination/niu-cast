package k3;

/* JADX INFO: loaded from: classes.dex */
public final class u4 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u4 f6663a = new u4();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f6664b = new q4.c("maxMs", h0.a.s(h0.a.q(x0.class, new t0(1, w0.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f6665c = new q4.c("minMs", h0.a.s(h0.a.q(x0.class, new t0(2, w0.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f6666d = new q4.c("avgMs", h0.a.s(h0.a.q(x0.class, new t0(3, w0.DEFAULT))));
    public static final q4.c e = new q4.c("firstQuartileMs", h0.a.s(h0.a.q(x0.class, new t0(4, w0.DEFAULT))));
    public static final q4.c f = new q4.c("medianMs", h0.a.s(h0.a.q(x0.class, new t0(5, w0.DEFAULT))));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f6667g = new q4.c("thirdQuartileMs", h0.a.s(h0.a.q(x0.class, new t0(6, w0.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        q9 q9Var = (q9) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f6664b, q9Var.f6630a);
        eVar.a(f6665c, q9Var.f6631b);
        eVar.a(f6666d, q9Var.f6632c);
        eVar.a(e, q9Var.f6633d);
        eVar.a(f, q9Var.e);
        eVar.a(f6667g, q9Var.f);
    }
}
