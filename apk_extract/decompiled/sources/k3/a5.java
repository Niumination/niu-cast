package k3;

/* JADX INFO: loaded from: classes.dex */
public final class a5 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a5 f6353a = new a5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f6354b = new q4.c("imageFormat", h0.a.s(h0.a.q(x0.class, new t0(1, w0.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f6355c = new q4.c("originalImageSize", h0.a.s(h0.a.q(x0.class, new t0(2, w0.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f6356d = new q4.c("compressedImageSize", h0.a.s(h0.a.q(x0.class, new t0(3, w0.DEFAULT))));
    public static final q4.c e = new q4.c("isOdmlImage", h0.a.s(h0.a.q(x0.class, new t0(4, w0.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        v9 v9Var = (v9) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f6354b, v9Var.f6682a);
        eVar.a(f6355c, v9Var.f6683b);
        eVar.a(f6356d, null);
        eVar.a(e, null);
    }
}
