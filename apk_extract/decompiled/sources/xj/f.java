package xj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements vj.b, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

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

    @Override // vj.b
    public abstract /* synthetic */ void debug(String str);

    public abstract /* synthetic */ void debug(String str, Object obj);

    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    @Override // vj.b
    public abstract /* synthetic */ void debug(String str, Throwable th2);

    public abstract /* synthetic */ void debug(String str, Object... objArr);

    public abstract /* synthetic */ void debug(vj.e eVar, String str);

    public abstract /* synthetic */ void debug(vj.e eVar, String str, Object obj);

    public abstract /* synthetic */ void debug(vj.e eVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(vj.e eVar, String str, Throwable th2);

    public abstract /* synthetic */ void debug(vj.e eVar, String str, Object... objArr);

    public abstract /* synthetic */ void error(String str);

    public abstract /* synthetic */ void error(String str, Object obj);

    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    @Override // vj.b
    public abstract /* synthetic */ void error(String str, Throwable th2);

    public abstract /* synthetic */ void error(String str, Object... objArr);

    public abstract /* synthetic */ void error(vj.e eVar, String str);

    public abstract /* synthetic */ void error(vj.e eVar, String str, Object obj);

    public abstract /* synthetic */ void error(vj.e eVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(vj.e eVar, String str, Throwable th2);

    public abstract /* synthetic */ void error(vj.e eVar, String str, Object... objArr);

    public String getName() {
        return this.name;
    }

    @Override // vj.b
    public abstract /* synthetic */ void info(String str);

    public abstract /* synthetic */ void info(String str, Object obj);

    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(String str, Throwable th2);

    public abstract /* synthetic */ void info(String str, Object... objArr);

    public abstract /* synthetic */ void info(vj.e eVar, String str);

    public abstract /* synthetic */ void info(vj.e eVar, String str, Object obj);

    public abstract /* synthetic */ void info(vj.e eVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(vj.e eVar, String str, Throwable th2);

    public abstract /* synthetic */ void info(vj.e eVar, String str, Object... objArr);

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
    public abstract /* synthetic */ void trace(String str);

    public abstract /* synthetic */ void trace(String str, Object obj);

    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(String str, Throwable th2);

    public abstract /* synthetic */ void trace(String str, Object... objArr);

    public abstract /* synthetic */ void trace(vj.e eVar, String str);

    public abstract /* synthetic */ void trace(vj.e eVar, String str, Object obj);

    public abstract /* synthetic */ void trace(vj.e eVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(vj.e eVar, String str, Throwable th2);

    public abstract /* synthetic */ void trace(vj.e eVar, String str, Object... objArr);

    @Override // vj.b
    public abstract /* synthetic */ void warn(String str);

    public abstract /* synthetic */ void warn(String str, Object obj);

    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    @Override // vj.b
    public abstract /* synthetic */ void warn(String str, Throwable th2);

    public abstract /* synthetic */ void warn(String str, Object... objArr);

    public abstract /* synthetic */ void warn(vj.e eVar, String str);

    public abstract /* synthetic */ void warn(vj.e eVar, String str, Object obj);

    public abstract /* synthetic */ void warn(vj.e eVar, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(vj.e eVar, String str, Throwable th2);

    public abstract /* synthetic */ void warn(vj.e eVar, String str, Object... objArr);
}
