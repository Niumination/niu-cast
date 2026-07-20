package bi;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static <T> T a(String str, Class<T> cls) throws Exception {
        if (str == null) {
            throw new Exception("The Json is Null: ");
        }
        try {
            return (T) new k().b(str, cls);
        } catch (Exception unused) {
            throw new Exception("error json:".concat(str));
        }
    }

    public static String b(Object obj) {
        return c(obj, false);
    }

    public static String c(Object obj, boolean z10) {
        if (obj != null) {
            return new m().b("*.class").a(z10).c(obj);
        }
        throw new IllegalStateException("The Object is Null: ");
    }
}
