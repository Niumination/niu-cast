package c1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class b0 extends n {
    public static boolean a(@gm.a Object a10, @gm.a Object b10) {
        return a10 == b10 || (a10 != null && a10.equals(b10));
    }

    public static int b(@gm.a Object... objects) {
        return Arrays.hashCode(objects);
    }
}
