package xj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements vj.b, Serializable {
    private static final long serialVersionUID = -2529255052481744503L;
    protected String name;

    public final void a(wj.b bVar, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            handleNormalizedLoggingCall(bVar, null, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            handleNormalizedLoggingCall(bVar, null, str, new Object[]{obj, obj2}, null);
        }
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atDebug() {
        return super.atDebug();
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atError() {
        return super.atError();
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atInfo() {
        return super.atInfo();
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atLevel(wj.b bVar) {
        return super.atLevel(bVar);
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atTrace() {
        return super.atTrace();
    }

    @Override // vj.b
    public /* bridge */ /* synthetic */ yj.a atWarn() {
        return super.atWarn();
    }

    public final void b(wj.b bVar, String str, Object[] objArr) {
        Throwable th2 = null;
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                th2 = (Throwable) obj;
            }
        }
        Throwable th3 = th2;
        if (th3 == null) {
            handleNormalizedLoggingCall(bVar, null, str, objArr, null);
            return;
        }
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        handleNormalizedLoggingCall(bVar, null, str, objArr2, th3);
    }

    public final void c(wj.b bVar, String str, Object obj) {
        handleNormalizedLoggingCall(bVar, null, str, new Object[]{obj}, null);
    }

    @Override // vj.b
    public void debug(String str) {
        if (isDebugEnabled()) {
            handleNormalizedLoggingCall(wj.b.DEBUG, null, str, null, null);
        }
    }

    public void error(String str) {
        if (isErrorEnabled()) {
            handleNormalizedLoggingCall(wj.b.ERROR, null, str, null, null);
        }
    }

    public abstract String getFullyQualifiedCallerName();

    public String getName() {
        return this.name;
    }

    public abstract void handleNormalizedLoggingCall(wj.b bVar, vj.e eVar, String str, Object[] objArr, Throwable th2);

    @Override // vj.b
    public void info(String str) {
        if (isInfoEnabled()) {
            handleNormalizedLoggingCall(wj.b.INFO, null, str, null, null);
        }
    }

    @Override // vj.b
    public abstract /* synthetic */ boolean isDebugEnabled();

    public abstract /* synthetic */ boolean isDebugEnabled(vj.e eVar);

    @Override // vj.b
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(wj.b bVar) {
        return super.isEnabledForLevel(bVar);
    }

    @Override // vj.b
    public abstract /* synthetic */ boolean isErrorEnabled();

    public abstract /* synthetic */ boolean isErrorEnabled(vj.e eVar);

    @Override // vj.b
    public abstract /* synthetic */ boolean isInfoEnabled();

    public abstract /* synthetic */ boolean isInfoEnabled(vj.e eVar);

    @Override // vj.b
    public abstract /* synthetic */ boolean isTraceEnabled();

    public abstract /* synthetic */ boolean isTraceEnabled(vj.e eVar);

    @Override // vj.b
    public abstract /* synthetic */ boolean isWarnEnabled();

    public abstract /* synthetic */ boolean isWarnEnabled(vj.e eVar);

    @Override // vj.b
    public yj.a makeLoggingEventBuilder(wj.b bVar) {
        return new yj.b();
    }

    public Object readResolve() throws ObjectStreamException {
        return vj.d.b(getName());
    }

    @Override // vj.b
    public void trace(String str) {
        if (isTraceEnabled()) {
            handleNormalizedLoggingCall(wj.b.TRACE, null, str, null, null);
        }
    }

    @Override // vj.b
    public void warn(String str) {
        if (isWarnEnabled()) {
            handleNormalizedLoggingCall(wj.b.WARN, null, str, null, null);
        }
    }

    public void debug(String str, Object obj) {
        if (isDebugEnabled()) {
            c(wj.b.DEBUG, str, obj);
        }
    }

    public void error(String str, Object obj) {
        if (isErrorEnabled()) {
            c(wj.b.ERROR, str, obj);
        }
    }

    public void info(String str, Object obj) {
        if (isInfoEnabled()) {
            c(wj.b.INFO, str, obj);
        }
    }

    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            c(wj.b.TRACE, str, obj);
        }
    }

    public void warn(String str, Object obj) {
        if (isWarnEnabled()) {
            c(wj.b.WARN, str, obj);
        }
    }

    public void debug(String str, Object obj, Object obj2) {
        if (isDebugEnabled()) {
            a(wj.b.DEBUG, str, obj, obj2);
        }
    }

    public void error(String str, Object obj, Object obj2) {
        if (isErrorEnabled()) {
            a(wj.b.ERROR, str, obj, obj2);
        }
    }

    public void info(String str, Object obj, Object obj2) {
        if (isInfoEnabled()) {
            a(wj.b.INFO, str, obj, obj2);
        }
    }

    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            a(wj.b.TRACE, str, obj, obj2);
        }
    }

    public void warn(String str, Object obj, Object obj2) {
        if (isWarnEnabled()) {
            a(wj.b.WARN, str, obj, obj2);
        }
    }

    public void debug(String str, Object... objArr) {
        if (isDebugEnabled()) {
            b(wj.b.DEBUG, str, objArr);
        }
    }

    public void error(String str, Object... objArr) {
        if (isErrorEnabled()) {
            b(wj.b.ERROR, str, objArr);
        }
    }

    public void info(String str, Object... objArr) {
        if (isInfoEnabled()) {
            b(wj.b.INFO, str, objArr);
        }
    }

    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            b(wj.b.TRACE, str, objArr);
        }
    }

    public void warn(String str, Object... objArr) {
        if (isWarnEnabled()) {
            b(wj.b.WARN, str, objArr);
        }
    }

    @Override // vj.b
    public void debug(String str, Throwable th2) {
        if (isDebugEnabled()) {
            handleNormalizedLoggingCall(wj.b.DEBUG, null, str, null, th2);
        }
    }

    @Override // vj.b
    public void error(String str, Throwable th2) {
        if (isErrorEnabled()) {
            handleNormalizedLoggingCall(wj.b.ERROR, null, str, null, th2);
        }
    }

    public void info(String str, Throwable th2) {
        if (isInfoEnabled()) {
            handleNormalizedLoggingCall(wj.b.INFO, null, str, null, th2);
        }
    }

    public void trace(String str, Throwable th2) {
        if (isTraceEnabled()) {
            handleNormalizedLoggingCall(wj.b.TRACE, null, str, null, th2);
        }
    }

    @Override // vj.b
    public void warn(String str, Throwable th2) {
        if (isWarnEnabled()) {
            handleNormalizedLoggingCall(wj.b.WARN, null, str, null, th2);
        }
    }

    public void debug(vj.e eVar, String str) {
        if (isDebugEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.DEBUG, eVar, str, null, null);
        }
    }

    public void error(vj.e eVar, String str) {
        if (isErrorEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.ERROR, eVar, str, null, null);
        }
    }

    public void info(vj.e eVar, String str) {
        if (isInfoEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.INFO, eVar, str, null, null);
        }
    }

    public void trace(vj.e eVar, String str) {
        if (isTraceEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.TRACE, eVar, str, null, null);
        }
    }

    public void warn(vj.e eVar, String str) {
        if (isWarnEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.WARN, eVar, str, null, null);
        }
    }

    public void debug(vj.e eVar, String str, Object obj) {
        if (isDebugEnabled(eVar)) {
            c(wj.b.DEBUG, str, obj);
        }
    }

    public void error(vj.e eVar, String str, Object obj) {
        if (isErrorEnabled(eVar)) {
            c(wj.b.ERROR, str, obj);
        }
    }

    public void info(vj.e eVar, String str, Object obj) {
        if (isInfoEnabled(eVar)) {
            c(wj.b.INFO, str, obj);
        }
    }

    public void trace(vj.e eVar, String str, Object obj) {
        if (isTraceEnabled(eVar)) {
            c(wj.b.TRACE, str, obj);
        }
    }

    public void warn(vj.e eVar, String str, Object obj) {
        if (isWarnEnabled(eVar)) {
            c(wj.b.WARN, str, obj);
        }
    }

    public void debug(vj.e eVar, String str, Object obj, Object obj2) {
        if (isDebugEnabled(eVar)) {
            a(wj.b.DEBUG, str, obj, obj2);
        }
    }

    public void error(vj.e eVar, String str, Object obj, Object obj2) {
        if (isErrorEnabled(eVar)) {
            a(wj.b.ERROR, str, obj, obj2);
        }
    }

    public void info(vj.e eVar, String str, Object obj, Object obj2) {
        if (isInfoEnabled(eVar)) {
            a(wj.b.INFO, str, obj, obj2);
        }
    }

    public void trace(vj.e eVar, String str, Object obj, Object obj2) {
        if (isTraceEnabled(eVar)) {
            a(wj.b.TRACE, str, obj, obj2);
        }
    }

    public void warn(vj.e eVar, String str, Object obj, Object obj2) {
        if (isWarnEnabled(eVar)) {
            a(wj.b.WARN, str, obj, obj2);
        }
    }

    public void debug(vj.e eVar, String str, Object... objArr) {
        if (isDebugEnabled(eVar)) {
            b(wj.b.DEBUG, str, objArr);
        }
    }

    public void error(vj.e eVar, String str, Object... objArr) {
        if (isErrorEnabled(eVar)) {
            b(wj.b.ERROR, str, objArr);
        }
    }

    public void info(vj.e eVar, String str, Object... objArr) {
        if (isInfoEnabled(eVar)) {
            b(wj.b.INFO, str, objArr);
        }
    }

    public void trace(vj.e eVar, String str, Object... objArr) {
        if (isTraceEnabled(eVar)) {
            b(wj.b.TRACE, str, objArr);
        }
    }

    public void warn(vj.e eVar, String str, Object... objArr) {
        if (isWarnEnabled(eVar)) {
            b(wj.b.WARN, str, objArr);
        }
    }

    public void debug(vj.e eVar, String str, Throwable th2) {
        if (isDebugEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.DEBUG, eVar, str, null, th2);
        }
    }

    public void error(vj.e eVar, String str, Throwable th2) {
        if (isErrorEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.ERROR, eVar, str, null, th2);
        }
    }

    public void info(vj.e eVar, String str, Throwable th2) {
        if (isInfoEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.INFO, eVar, str, null, th2);
        }
    }

    public void trace(vj.e eVar, String str, Throwable th2) {
        if (isTraceEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.TRACE, eVar, str, null, th2);
        }
    }

    public void warn(vj.e eVar, String str, Throwable th2) {
        if (isWarnEnabled(eVar)) {
            handleNormalizedLoggingCall(wj.b.WARN, eVar, str, null, th2);
        }
    }
}
