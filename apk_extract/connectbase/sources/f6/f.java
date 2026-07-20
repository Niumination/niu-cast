package f6;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean a(String str) {
        return b6.b.a().checkSelfPermission(str) == -1;
    }

    public static boolean b(String... strArr) {
        for (String str : strArr) {
            if (a(str)) {
                return true;
            }
        }
        return false;
    }
}
