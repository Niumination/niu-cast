package k3;

import kotlin.Triple;
import kotlin.concurrent.ThreadsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class hc {
    public static void a() {
        oe.c.u++;
        if (oe.c.f8454t) {
            return;
        }
        oe.c.f8454t = true;
        ThreadsKt.thread$default(false, false, null, null, 0, new ob.c(1), 31, null);
    }

    public static void b() {
        int i8 = oe.c.u - 1;
        oe.c.u = i8;
        if (i8 == 0) {
            oe.c.f8454t = false;
            oe.c.f8452r.add(new Triple(0, new Object(), null));
        }
    }
}
