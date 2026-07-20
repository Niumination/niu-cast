package m8;

/* JADX INFO: loaded from: classes2.dex */
public class a implements wg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10602a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f10603b = cc.a.a("android.provider.DeviceConfig");

    @Override // wg.a
    public int a(String str, String str2, int i10) {
        Object objJ = cc.a.j(cc.a.g(f10603b, "getInt", String.class, String.class, Integer.TYPE), null, str, str2, Integer.valueOf(i10));
        return objJ instanceof Integer ? ((Integer) objJ).intValue() : i10;
    }

    @Override // wg.a
    public boolean b(String str, String str2, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f10603b, "getBoolean", String.class, String.class, Boolean.TYPE), null, str, str2, Boolean.valueOf(z10));
        return objJ instanceof Boolean ? ((Boolean) objJ).booleanValue() : z10;
    }
}
