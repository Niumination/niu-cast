package y8;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f20766a = cc.a.a("com.transsion.hubsdk.tranthubutils.TranAppProperties");

    @Override // hh.a
    public boolean a(String str, boolean z10) {
        Class cls = f20766a;
        if (cls == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(cls, "getBoolean", String.class, Boolean.TYPE), f20766a, str, Boolean.valueOf(z10)));
    }

    @Override // hh.a
    public void b(String str) {
        Class cls = f20766a;
        if (cls == null) {
            return;
        }
        cc.a.j(cc.a.g(cls, "initialize", String.class), f20766a, str);
    }

    @Override // hh.a
    public String get(String str) {
        Class cls = f20766a;
        return cls == null ? "" : (String) cc.a.j(cc.a.g(cls, "get", String.class), f20766a, str);
    }
}
