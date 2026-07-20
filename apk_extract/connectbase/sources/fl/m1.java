package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {
    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    @os.l
    public static final StackTraceElement c(@os.l un.d<?> dVar, @os.l String str, @os.l String str2, int i10) {
        kn.l0.p(dVar, "kClass");
        kn.l0.p(str, "methodName");
        kn.l0.p(str2, "fileName");
        return new StackTraceElement(in.b.e(dVar).getName(), str, str2, i10);
    }
}
