package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class w9 {
    public static void a(int i8, int i9) {
        String strA;
        if (i8 < 0 || i8 >= i9) {
            if (i8 < 0) {
                strA = x9.a("%s (%s) must not be negative", "index", Integer.valueOf(i8));
            } else {
                if (i9 < 0) {
                    throw new IllegalArgumentException(a1.a.o(i9, "negative size: "));
                }
                strA = x9.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i8), Integer.valueOf(i9));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void b(int i8, int i9) {
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(d(i8, i9, "index"));
        }
    }

    public static void c(int i8, int i9, int i10) {
        String strD;
        if (i8 < 0 || i9 < i8 || i9 > i10) {
            if (i8 < 0 || i8 > i10) {
                strD = d(i8, i10, "start index");
            } else {
                strD = (i9 < 0 || i9 > i10) ? d(i9, i10, "end index") : x9.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i9), Integer.valueOf(i8));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    public static String d(int i8, int i9, String str) {
        if (i8 < 0) {
            return x9.a("%s (%s) must not be negative", str, Integer.valueOf(i8));
        }
        if (i9 >= 0) {
            return x9.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i8), Integer.valueOf(i9));
        }
        throw new IllegalArgumentException(a1.a.o(i9, "negative size: "));
    }
}
