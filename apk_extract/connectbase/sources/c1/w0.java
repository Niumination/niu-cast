package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class w0 {
    public static void a(boolean expression) {
        if (!expression) {
            throw new x0();
        }
    }

    public static void b(boolean expression, String errorMessageTemplate, char p10) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Character.valueOf(p10)));
        }
    }

    public static void c(boolean expression, String errorMessageTemplate, char p10, char p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Character.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void d(boolean expression, String errorMessageTemplate, char p10, int p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Character.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void e(boolean expression, String errorMessageTemplate, char p10, long p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Character.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void f(boolean expression, String errorMessageTemplate, char p10, @gm.a Object p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Character.valueOf(p10), p11));
        }
    }

    public static void g(boolean expression, String errorMessageTemplate, int p10) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Integer.valueOf(p10)));
        }
    }

    public static void h(boolean expression, String errorMessageTemplate, int p10, char p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Integer.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void i(boolean expression, String errorMessageTemplate, int p10, int p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Integer.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void j(boolean expression, String errorMessageTemplate, int p10, long p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Integer.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void k(boolean expression, String errorMessageTemplate, int p10, @gm.a Object p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Integer.valueOf(p10), p11));
        }
    }

    public static void l(boolean expression, String errorMessageTemplate, long p10) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Long.valueOf(p10)));
        }
    }

    public static void m(boolean expression, String errorMessageTemplate, long p10, char p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Long.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void n(boolean expression, String errorMessageTemplate, long p10, int p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Long.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void o(boolean expression, String errorMessageTemplate, long p10, long p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Long.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void p(boolean expression, String errorMessageTemplate, long p10, @gm.a Object p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, Long.valueOf(p10), p11));
        }
    }

    public static void q(boolean expression, String errorMessageTemplate, @gm.a Object p10) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10));
        }
    }

    public static void r(boolean expression, String errorMessageTemplate, @gm.a Object p10, char p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, Character.valueOf(p11)));
        }
    }

    public static void s(boolean expression, String errorMessageTemplate, @gm.a Object p10, int p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, Integer.valueOf(p11)));
        }
    }

    public static void t(boolean expression, String errorMessageTemplate, @gm.a Object p10, long p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, Long.valueOf(p11)));
        }
    }

    public static void u(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, p11));
        }
    }

    public static void v(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, p11, p12));
        }
    }

    public static void w(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12, @gm.a Object p13) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, p10, p11, p12, p13));
        }
    }

    public static void x(boolean expression, String errorMessageTemplate, @gm.a Object... errorMessageArgs) {
        if (!expression) {
            throw new x0(p0.e(errorMessageTemplate, errorMessageArgs));
        }
    }

    @t1.a
    public static <T> T y(@gm.a T t10) {
        return (T) z(t10, "expected a non-null reference", new Object[0]);
    }

    @t1.a
    public static <T> T z(@gm.a T reference, String errorMessageTemplate, @gm.a Object... errorMessageArgs) {
        if (reference != null) {
            return reference;
        }
        throw new x0(p0.e(errorMessageTemplate, errorMessageArgs));
    }
}
