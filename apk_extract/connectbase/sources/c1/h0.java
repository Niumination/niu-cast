package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class h0 {
    public static void A(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12, @gm.a Object p13) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, p11, p12, p13));
        }
    }

    public static void A0(boolean expression, String errorMessageTemplate, @gm.a Object p10, long p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, Long.valueOf(p11)));
        }
    }

    public static void B(boolean expression, String errorMessageTemplate, @gm.a Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void B0(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, p11));
        }
    }

    @t1.a
    public static int C(int index, int size) {
        return D(index, size, "index");
    }

    public static void C0(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, p11, p12));
        }
    }

    @t1.a
    public static int D(int index, int size, String desc) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(a(index, size, desc));
        }
        return index;
    }

    public static void D0(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12, @gm.a Object p13) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, p11, p12, p13));
        }
    }

    @t1.a
    public static <T> T E(@gm.a T reference) {
        reference.getClass();
        return reference;
    }

    public static void E0(boolean expression, @gm.a String errorMessageTemplate, @gm.a Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, errorMessageArgs));
        }
    }

    @t1.a
    public static <T> T F(@gm.a T reference, @gm.a Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    @t1.a
    public static <T> T G(@gm.a T reference, String errorMessageTemplate, char p10) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Character.valueOf(p10)));
    }

    @t1.a
    public static <T> T H(@gm.a T reference, String errorMessageTemplate, char p10, char p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Character.valueOf(p10), Character.valueOf(p11)));
    }

    @t1.a
    public static <T> T I(@gm.a T reference, String errorMessageTemplate, char p10, int p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Character.valueOf(p10), Integer.valueOf(p11)));
    }

    @t1.a
    public static <T> T J(@gm.a T reference, String errorMessageTemplate, char p10, long p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Character.valueOf(p10), Long.valueOf(p11)));
    }

    @t1.a
    public static <T> T K(@gm.a T reference, String errorMessageTemplate, char p10, @gm.a Object p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Character.valueOf(p10), p11));
    }

    @t1.a
    public static <T> T L(@gm.a T reference, String errorMessageTemplate, int p10) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Integer.valueOf(p10)));
    }

    @t1.a
    public static <T> T M(@gm.a T reference, String errorMessageTemplate, int p10, char p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Character.valueOf(p11)));
    }

    @t1.a
    public static <T> T N(@gm.a T reference, String errorMessageTemplate, int p10, int p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Integer.valueOf(p11)));
    }

    @t1.a
    public static <T> T O(@gm.a T reference, String errorMessageTemplate, int p10, long p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Long.valueOf(p11)));
    }

    @t1.a
    public static <T> T P(@gm.a T reference, String errorMessageTemplate, int p10, @gm.a Object p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Integer.valueOf(p10), p11));
    }

    @t1.a
    public static <T> T Q(@gm.a T reference, String errorMessageTemplate, long p10) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Long.valueOf(p10)));
    }

    @t1.a
    public static <T> T R(@gm.a T reference, String errorMessageTemplate, long p10, char p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Long.valueOf(p10), Character.valueOf(p11)));
    }

    @t1.a
    public static <T> T S(@gm.a T reference, String errorMessageTemplate, long p10, int p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Long.valueOf(p10), Integer.valueOf(p11)));
    }

    @t1.a
    public static <T> T T(@gm.a T reference, String errorMessageTemplate, long p10, long p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Long.valueOf(p10), Long.valueOf(p11)));
    }

    @t1.a
    public static <T> T U(@gm.a T reference, String errorMessageTemplate, long p10, @gm.a Object p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, Long.valueOf(p10), p11));
    }

    @t1.a
    public static <T> T V(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10));
    }

    @t1.a
    public static <T> T W(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, char p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, Character.valueOf(p11)));
    }

    @t1.a
    public static <T> T X(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, int p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, Integer.valueOf(p11)));
    }

    @t1.a
    public static <T> T Y(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, long p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, Long.valueOf(p11)));
    }

    @t1.a
    public static <T> T Z(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, p11));
    }

    public static String a(int index, int size, String desc) {
        if (index < 0) {
            return p0.e("%s (%s) must not be negative", desc, Integer.valueOf(index));
        }
        if (size >= 0) {
            return p0.e("%s (%s) must be less than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
        throw new IllegalArgumentException(h.a.a("negative size: ", size));
    }

    @t1.a
    public static <T> T a0(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, p11, p12));
    }

    public static String b(int index, int size, String desc) {
        if (index < 0) {
            return p0.e("%s (%s) must not be negative", desc, Integer.valueOf(index));
        }
        if (size >= 0) {
            return p0.e("%s (%s) must not be greater than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
        throw new IllegalArgumentException(h.a.a("negative size: ", size));
    }

    @t1.a
    public static <T> T b0(@gm.a T reference, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12, @gm.a Object p13) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, p10, p11, p12, p13));
    }

    public static String c(int start, int end, int size) {
        if (start < 0 || start > size) {
            return b(start, size, "start index");
        }
        return (end < 0 || end > size) ? b(end, size, "end index") : p0.e("end index (%s) must not be less than start index (%s)", Integer.valueOf(end), Integer.valueOf(start));
    }

    @t1.a
    public static <T> T c0(@gm.a T reference, String errorMessageTemplate, @gm.a Object... errorMessageArgs) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(p0.e(errorMessageTemplate, errorMessageArgs));
    }

    public static void d(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    @t1.a
    public static int d0(int index, int size) {
        return e0(index, size, "index");
    }

    public static void e(boolean expression, @gm.a Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    @t1.a
    public static int e0(int index, int size, String desc) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(b(index, size, desc));
        }
        return index;
    }

    public static void f(boolean expression, String errorMessageTemplate, char p10) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Character.valueOf(p10)));
        }
    }

    public static void f0(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(c(start, end, size));
        }
    }

    public static void g(boolean expression, String errorMessageTemplate, char p10, char p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Character.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void g0(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean expression, String errorMessageTemplate, char p10, int p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Character.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void h0(boolean expression, @gm.a Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void i(boolean expression, String errorMessageTemplate, char p10, long p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Character.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void i0(boolean expression, String errorMessageTemplate, char p10) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Character.valueOf(p10)));
        }
    }

    public static void j(boolean expression, String errorMessageTemplate, char p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Character.valueOf(p10), p11));
        }
    }

    public static void j0(boolean expression, String errorMessageTemplate, char p10, char p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Character.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void k(boolean expression, String errorMessageTemplate, int p10) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Integer.valueOf(p10)));
        }
    }

    public static void k0(boolean expression, String errorMessageTemplate, char p10, int p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Character.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void l(boolean expression, String errorMessageTemplate, int p10, char p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void l0(boolean expression, String errorMessageTemplate, char p10, long p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Character.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void m(boolean expression, String errorMessageTemplate, int p10, int p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void m0(boolean expression, String errorMessageTemplate, char p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Character.valueOf(p10), p11));
        }
    }

    public static void n(boolean expression, String errorMessageTemplate, int p10, long p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void n0(boolean expression, String errorMessageTemplate, int p10) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Integer.valueOf(p10)));
        }
    }

    public static void o(boolean expression, String errorMessageTemplate, int p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Integer.valueOf(p10), p11));
        }
    }

    public static void o0(boolean expression, String errorMessageTemplate, int p10, char p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void p(boolean expression, String errorMessageTemplate, long p10) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Long.valueOf(p10)));
        }
    }

    public static void p0(boolean expression, String errorMessageTemplate, int p10, int p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void q(boolean expression, String errorMessageTemplate, long p10, char p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Long.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void q0(boolean expression, String errorMessageTemplate, int p10, long p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Integer.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void r(boolean expression, String errorMessageTemplate, long p10, int p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Long.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void r0(boolean expression, String errorMessageTemplate, int p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Integer.valueOf(p10), p11));
        }
    }

    public static void s(boolean expression, String errorMessageTemplate, long p10, long p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Long.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void s0(boolean expression, String errorMessageTemplate, long p10) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Long.valueOf(p10)));
        }
    }

    public static void t(boolean expression, String errorMessageTemplate, long p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, Long.valueOf(p10), p11));
        }
    }

    public static void t0(boolean expression, String errorMessageTemplate, long p10, char p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Long.valueOf(p10), Character.valueOf(p11)));
        }
    }

    public static void u(boolean expression, String errorMessageTemplate, @gm.a Object p10) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10));
        }
    }

    public static void u0(boolean expression, String errorMessageTemplate, long p10, int p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Long.valueOf(p10), Integer.valueOf(p11)));
        }
    }

    public static void v(boolean expression, String errorMessageTemplate, @gm.a Object p10, char p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, Character.valueOf(p11)));
        }
    }

    public static void v0(boolean expression, String errorMessageTemplate, long p10, long p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Long.valueOf(p10), Long.valueOf(p11)));
        }
    }

    public static void w(boolean expression, String errorMessageTemplate, @gm.a Object p10, int p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, Integer.valueOf(p11)));
        }
    }

    public static void w0(boolean expression, String errorMessageTemplate, long p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, Long.valueOf(p10), p11));
        }
    }

    public static void x(boolean expression, String errorMessageTemplate, @gm.a Object p10, long p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, Long.valueOf(p11)));
        }
    }

    public static void x0(boolean expression, String errorMessageTemplate, @gm.a Object p10) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10));
        }
    }

    public static void y(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, p11));
        }
    }

    public static void y0(boolean expression, String errorMessageTemplate, @gm.a Object p10, char p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, Character.valueOf(p11)));
        }
    }

    public static void z(boolean expression, String errorMessageTemplate, @gm.a Object p10, @gm.a Object p11, @gm.a Object p12) {
        if (!expression) {
            throw new IllegalArgumentException(p0.e(errorMessageTemplate, p10, p11, p12));
        }
    }

    public static void z0(boolean expression, String errorMessageTemplate, @gm.a Object p10, int p11) {
        if (!expression) {
            throw new IllegalStateException(p0.e(errorMessageTemplate, p10, Integer.valueOf(p11)));
        }
    }
}
