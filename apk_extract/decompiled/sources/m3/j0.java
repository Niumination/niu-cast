package m3;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s9.a f7751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static n8.a f7752b;

    public static da.a a() {
        if (l9.b.a(l9.a.f)) {
            j9.a.c("j0", "TranThubSystemProperties");
            s9.a aVar = f7751a;
            if (aVar != null) {
                return aVar;
            }
            s9.a aVar2 = new s9.a();
            f7751a = aVar2;
            return aVar2;
        }
        j9.a.c("j0", "TranAospSystemProperties");
        n8.a aVar3 = f7752b;
        if (aVar3 != null) {
            return aVar3;
        }
        n8.a aVar4 = new n8.a();
        aVar4.f8128a = null;
        aVar4.f8129b = null;
        f7752b = aVar4;
        return aVar4;
    }
}
