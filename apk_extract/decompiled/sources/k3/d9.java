package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class d9 {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(a1.a.p(obj2, "null key in entry: null="));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void b(int i8, String str) {
        if (i8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i8);
    }
}
