package p6;

/* JADX INFO: loaded from: classes2.dex */
public class o implements bf.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13007a = "o";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13008b = cc.a.a("android.app.AppGlobals");

    @Override // bf.j
    public int a(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13008b, "getIntCoreSetting", String.class, Integer.TYPE), null, str, Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }
}
