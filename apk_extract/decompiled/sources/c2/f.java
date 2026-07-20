package c2;

/* JADX INFO: loaded from: classes.dex */
public final class f implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1385a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f1386b = q4.c.a("requestTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f1387c = q4.c.a("requestUptimeMs");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f1388d = q4.c.a("clientInfo");
    public static final q4.c e = q4.c.a("logSource");
    public static final q4.c f = q4.c.a("logSourceName");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f1389g = q4.c.a("logEvent");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f1390h = q4.c.a("qosTier");

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        q4.e eVar = (q4.e) obj2;
        m mVar = (m) ((t) obj);
        eVar.b(f1386b, mVar.f1417a);
        eVar.b(f1387c, mVar.f1418b);
        eVar.a(f1388d, mVar.f1419c);
        eVar.a(e, mVar.f1420d);
        eVar.a(f, mVar.e);
        eVar.a(f1389g, mVar.f);
        eVar.a(f1390h, mVar.f1421g);
    }
}
