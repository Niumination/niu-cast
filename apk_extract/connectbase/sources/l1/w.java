package l1;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class w {
    public static void a(Buffer b10) {
        b10.clear();
    }

    public static void b(Buffer b10) {
        b10.flip();
    }

    public static void c(Buffer b10, int limit) {
        b10.limit(limit);
    }

    public static void d(Buffer b10) {
        b10.mark();
    }

    public static void e(Buffer b10, int position) {
        b10.position(position);
    }

    public static void f(Buffer b10) {
        b10.reset();
    }
}
