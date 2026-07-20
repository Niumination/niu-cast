package rs;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends j implements ps.a {
    private static final long serialVersionUID = 9044267456635152283L;

    @Override // ps.a
    public void debug(ps.d dVar, String str) {
        debug(str);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str) {
        error(str);
    }

    @Override // rs.j, ps.a
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // ps.a
    public void info(ps.d dVar, String str) {
        info(str);
    }

    @Override // ps.a
    public boolean isDebugEnabled(ps.d dVar) {
        return isDebugEnabled();
    }

    @Override // ps.a
    public boolean isErrorEnabled(ps.d dVar) {
        return isErrorEnabled();
    }

    @Override // ps.a
    public boolean isInfoEnabled(ps.d dVar) {
        return isInfoEnabled();
    }

    @Override // ps.a
    public boolean isTraceEnabled(ps.d dVar) {
        return isTraceEnabled();
    }

    @Override // ps.a
    public boolean isWarnEnabled(ps.d dVar) {
        return isWarnEnabled();
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str) {
        trace(str);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str) {
        warn(str);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj) {
        debug(str, obj);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj) {
        error(str, obj);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj) {
        info(str, obj);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj) {
        trace(str, obj);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj) {
        warn(str, obj);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object... objArr) {
        debug(str, objArr);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object... objArr) {
        error(str, objArr);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object... objArr) {
        info(str, objArr);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object... objArr) {
        trace(str, objArr);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object... objArr) {
        warn(str, objArr);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Throwable th2) {
        debug(str, th2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Throwable th2) {
        error(str, th2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Throwable th2) {
        info(str, th2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Throwable th2) {
        trace(str, th2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Throwable th2) {
        warn(str, th2);
    }
}
