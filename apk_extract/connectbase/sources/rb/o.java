package rb;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    public void a(Object obj, String str, String str2) {
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "addProperty", String.class, String.class), obj, str, str2);
        }
    }

    public void b(Object obj, String str, boolean z10) {
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "addProperty", String.class, Boolean.TYPE), obj, str, Boolean.valueOf(z10));
        }
    }
}
