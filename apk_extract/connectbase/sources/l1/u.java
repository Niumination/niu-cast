package l1;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f9630a = Logger.getLogger(u.class.getName());

    public static void a(Flushable flushable, boolean swallowIOException) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e10) {
            if (!swallowIOException) {
                throw e10;
            }
            f9630a.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e10);
        }
    }

    @b1.a
    public static void b(Flushable flushable) {
        try {
            a(flushable, true);
        } catch (IOException e10) {
            f9630a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e10);
        }
    }
}
