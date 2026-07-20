package k3;

/* JADX INFO: loaded from: classes.dex */
public final class z5 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z5 f6742a = new z5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f6743b = new q4.c("inferenceCommonLogEvent", h0.a.s(h0.a.q(x0.class, new t0(1, w0.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f6744c = new q4.c("options", h0.a.s(h0.a.q(x0.class, new t0(2, w0.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f6745d = new q4.c("detectedBarcodeFormats", h0.a.s(h0.a.q(x0.class, new t0(3, w0.DEFAULT))));
    public static final q4.c e = new q4.c("detectedBarcodeValueTypes", h0.a.s(h0.a.q(x0.class, new t0(4, w0.DEFAULT))));
    public static final q4.c f = new q4.c("imageInfo", h0.a.s(h0.a.q(x0.class, new t0(5, w0.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        wa waVar = (wa) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f6743b, waVar.f6696a);
        eVar.a(f6744c, waVar.f6697b);
        eVar.a(f6745d, waVar.f6698c);
        eVar.a(e, waVar.f6699d);
        eVar.a(f, waVar.e);
    }
}
