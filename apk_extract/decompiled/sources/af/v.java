package af;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f625c = Logger.getLogger(ze.i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f626a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.r0 f627b;

    public v(ze.r0 r0Var, long j8, String str) {
        v8.i(str, "description");
        this.f627b = r0Var;
        String strConcat = str.concat(" created");
        ze.l0 l0Var = ze.l0.CT_INFO;
        v8.i(strConcat, "description");
        v8.i(l0Var, "severity");
        b(new ze.m0(strConcat, l0Var, j8, null));
    }

    public static void a(ze.r0 r0Var, Level level, String str) {
        Logger logger = f625c;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + r0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public final void b(ze.m0 m0Var) {
        Level level;
        int i8 = u.f603a[m0Var.f11376b.ordinal()];
        if (i8 != 1) {
            level = i8 != 2 ? Level.FINEST : Level.FINER;
        } else {
            level = Level.FINE;
        }
        synchronized (this.f626a) {
        }
        a(this.f627b, level, m0Var.f11375a);
    }
}
