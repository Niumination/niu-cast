package ch;

import cj.k;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements cj.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1687a;
    private static final bj.d descriptor;

    static {
        b bVar = new b();
        f1687a = bVar;
        k kVar = new k("io.ktor.util.date.GMTDate", bVar, 9);
        kVar.f("seconds", false);
        kVar.f("minutes", false);
        kVar.f("hours", false);
        kVar.f("dayOfWeek", false);
        kVar.f("dayOfMonth", false);
        kVar.f("dayOfYear", false);
        kVar.f("month", false);
        kVar.f("year", false);
        kVar.f("timestamp", false);
        descriptor = kVar;
    }

    @Override // aj.a
    public final bj.d getDescriptor() {
        return descriptor;
    }
}
