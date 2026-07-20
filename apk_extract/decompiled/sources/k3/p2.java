package k3;

/* JADX INFO: loaded from: classes.dex */
public final class p2 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f6572a = new p2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f6573b = new q4.c("errorCode", h0.a.s(h0.a.q(x0.class, new t0(1, w0.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f6574c = new q4.c("hasResult", h0.a.s(h0.a.q(x0.class, new t0(2, w0.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f6575d = new q4.c("isColdCall", h0.a.s(h0.a.q(x0.class, new t0(3, w0.DEFAULT))));
    public static final q4.c e = new q4.c("imageInfo", h0.a.s(h0.a.q(x0.class, new t0(4, w0.DEFAULT))));
    public static final q4.c f = new q4.c("options", h0.a.s(h0.a.q(x0.class, new t0(5, w0.DEFAULT))));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f6576g = new q4.c("detectedBarcodeFormats", h0.a.s(h0.a.q(x0.class, new t0(6, w0.DEFAULT))));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f6577h = new q4.c("detectedBarcodeValueTypes", h0.a.s(h0.a.q(x0.class, new t0(7, w0.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        g1 g1Var = (g1) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f6573b, g1Var.f6452a);
        eVar.a(f6574c, null);
        eVar.a(f6575d, g1Var.f6453b);
        eVar.a(e, null);
        eVar.a(f, g1Var.f6454c);
        eVar.a(f6576g, g1Var.f6455d);
        eVar.a(f6577h, g1Var.e);
    }
}
