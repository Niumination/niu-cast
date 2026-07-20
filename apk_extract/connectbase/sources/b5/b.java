package b5;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ji.a<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f737b = "ConfirmFileVersionController";

    @Override // ji.a
    public Short a() {
        return Short.valueOf(v4.g.S);
    }

    @Override // ji.a
    public void b(Object obj) {
        p2.c cVar = (p2.c) ji.a.f8709a.a(String.valueOf(obj), p2.c.class);
        if (cVar != null) {
            k4.m.e(f737b, "peer select version:" + cVar.a());
            m5.s.a.f10535a.x(cVar.a());
        }
    }
}
