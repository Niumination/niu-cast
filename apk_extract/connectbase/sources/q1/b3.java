package q1;

import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class b3 {

    @b1.e
    public static final class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Logger f13409b = Logger.getLogger(a.class.getName());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runtime f13410a;

        public a(Runtime runtime) {
            this.f13410a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread t10, Throwable e10) {
            try {
                try {
                    f13409b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", t10), e10);
                } catch (Error | RuntimeException e11) {
                    PrintStream printStream = System.err;
                    printStream.println(e10.getMessage());
                    printStream.println(e11.getMessage());
                }
            } finally {
                this.f13410a.exit(1);
            }
        }
    }

    public static Thread.UncaughtExceptionHandler a() {
        return new a(Runtime.getRuntime());
    }
}
