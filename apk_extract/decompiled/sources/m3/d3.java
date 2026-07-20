package m3;

/* JADX INFO: loaded from: classes.dex */
public final class d3 implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f7653a = new d3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f7654b = new q4.c("durationMs", h0.a.s(h0.a.r(f.class, new c(1, e.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f7655c = new q4.c("imageSource", h0.a.s(h0.a.r(f.class, new c(2, e.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f7656d = new q4.c("imageFormat", h0.a.s(h0.a.r(f.class, new c(3, e.DEFAULT))));
    public static final q4.c e = new q4.c("imageByteSize", h0.a.s(h0.a.r(f.class, new c(4, e.DEFAULT))));
    public static final q4.c f = new q4.c("imageWidth", h0.a.s(h0.a.r(f.class, new c(5, e.DEFAULT))));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f7657g = new q4.c("imageHeight", h0.a.s(h0.a.r(f.class, new c(6, e.DEFAULT))));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f7658h = new q4.c("rotationDegrees", h0.a.s(h0.a.r(f.class, new c(7, e.DEFAULT))));

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        h7 h7Var = (h7) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f7654b, h7Var.f7700a);
        eVar.a(f7655c, h7Var.f7701b);
        eVar.a(f7656d, h7Var.f7702c);
        eVar.a(e, h7Var.f7703d);
        eVar.a(f, h7Var.e);
        eVar.a(f7657g, h7Var.f);
        eVar.a(f7658h, h7Var.f7704g);
    }
}
