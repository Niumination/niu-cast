package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class yb {
    public static Object a(String str, Class cls) throws Exception {
        if (str == null) {
            throw new Exception("The Json is Null: ");
        }
        try {
            return new i1.b(4).a(cls, str);
        } catch (Exception unused) {
            throw new Exception("error json:".concat(str));
        }
    }
}
