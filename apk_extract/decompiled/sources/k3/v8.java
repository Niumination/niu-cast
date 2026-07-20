package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class v8 {
    public static String a(int i8, int i9, String str) {
        if (i8 < 0) {
            return w8.a("%s (%s) must not be negative", str, Integer.valueOf(i8));
        }
        if (i9 >= 0) {
            return w8.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i8), Integer.valueOf(i9));
        }
        throw new IllegalArgumentException(a1.a.o(i9, "negative size: "));
    }

    public static void b(int i8, String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(w8.a(str, Integer.valueOf(i8)));
        }
    }

    public static void c(String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(String str, boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(w8.a(str, obj));
        }
    }

    public static void e(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void f(boolean z2, String str, long j8) {
        if (!z2) {
            throw new IllegalArgumentException(w8.a(str, Long.valueOf(j8)));
        }
    }

    public static void g(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalArgumentException(w8.a(str, obj, obj2));
        }
    }

    public static void h(int i8, int i9) {
        String strA;
        if (i8 < 0 || i8 >= i9) {
            if (i8 < 0) {
                strA = w8.a("%s (%s) must not be negative", "index", Integer.valueOf(i8));
            } else {
                if (i9 < 0) {
                    throw new IllegalArgumentException(a1.a.o(i9, "negative size: "));
                }
                strA = w8.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i8), Integer.valueOf(i9));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static void j(int i8, int i9) {
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(a(i8, i9, "index"));
        }
    }

    public static void k(int i8, int i9, int i10) {
        String strA;
        if (i8 < 0 || i9 < i8 || i9 > i10) {
            if (i8 < 0 || i8 > i10) {
                strA = a(i8, i10, "start index");
            } else {
                strA = (i9 < 0 || i9 > i10) ? a(i9, i10, "end index") : w8.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i9), Integer.valueOf(i8));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void l(String str, boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(w8.a(str, obj));
        }
    }

    public static void m(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void n(boolean z2, String str) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }
}
