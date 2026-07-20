package vj;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    default yj.a atDebug() {
        return isDebugEnabled() ? makeLoggingEventBuilder(wj.b.DEBUG) : yj.b.f11227a;
    }

    default yj.a atError() {
        return isErrorEnabled() ? makeLoggingEventBuilder(wj.b.ERROR) : yj.b.f11227a;
    }

    default yj.a atInfo() {
        return isInfoEnabled() ? makeLoggingEventBuilder(wj.b.INFO) : yj.b.f11227a;
    }

    default yj.a atLevel(wj.b bVar) {
        return isEnabledForLevel(bVar) ? makeLoggingEventBuilder(bVar) : yj.b.f11227a;
    }

    default yj.a atTrace() {
        return isTraceEnabled() ? makeLoggingEventBuilder(wj.b.TRACE) : yj.b.f11227a;
    }

    default yj.a atWarn() {
        return isWarnEnabled() ? makeLoggingEventBuilder(wj.b.WARN) : yj.b.f11227a;
    }

    void debug(String str);

    void debug(String str, Throwable th2);

    void error(String str, Throwable th2);

    void info(String str);

    boolean isDebugEnabled();

    default boolean isEnabledForLevel(wj.b bVar) {
        int i8 = bVar.toInt();
        if (i8 == 0) {
            return isTraceEnabled();
        }
        if (i8 == 10) {
            return isDebugEnabled();
        }
        if (i8 == 20) {
            return isInfoEnabled();
        }
        if (i8 == 30) {
            return isWarnEnabled();
        }
        if (i8 == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + bVar + "] not recognized.");
    }

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    yj.a makeLoggingEventBuilder(wj.b bVar);

    void trace(String str);

    void warn(String str);

    void warn(String str, Throwable th2);
}
