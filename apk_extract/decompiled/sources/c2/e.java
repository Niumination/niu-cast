package c2;

/* JADX INFO: loaded from: classes.dex */
public final class e implements q4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1379a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f1380b = q4.c.a("eventTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f1381c = q4.c.a("eventCode");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f1382d = q4.c.a("eventUptimeMs");
    public static final q4.c e = q4.c.a("sourceExtension");
    public static final q4.c f = q4.c.a("sourceExtensionJsonProto3");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f1383g = q4.c.a("timezoneOffsetSeconds");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f1384h = q4.c.a("networkConnectionInfo");

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        q4.e eVar = (q4.e) obj2;
        l lVar = (l) ((s) obj);
        eVar.b(f1380b, lVar.f1412a);
        eVar.a(f1381c, lVar.f1413b);
        eVar.b(f1382d, lVar.f1414c);
        eVar.a(e, lVar.f1415d);
        eVar.a(f, lVar.e);
        eVar.b(f1383g, lVar.f);
        eVar.a(f1384h, lVar.f1416g);
    }
}
