package rs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class k implements ps.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ps.a f14864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f14865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f14866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public qs.b f14867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Queue<qs.e> f14868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f14869g;

    public k(String str, Queue<qs.e> queue, boolean z10) {
        this.f14863a = str;
        this.f14868f = queue;
        this.f14869g = z10;
    }

    public ps.a b() {
        if (this.f14864b != null) {
            return this.f14864b;
        }
        return this.f14869g ? g.NOP_LOGGER : c();
    }

    public final ps.a c() {
        if (this.f14867e == null) {
            this.f14867e = new qs.b(this, this.f14868f);
        }
        return this.f14867e;
    }

    public boolean d() {
        Boolean bool = this.f14865c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f14866d = this.f14864b.getClass().getMethod("log", qs.d.class);
            this.f14865c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f14865c = Boolean.FALSE;
        }
        return this.f14865c.booleanValue();
    }

    @Override // ps.a
    public void debug(String str) {
        b().debug(str);
    }

    public boolean e() {
        return this.f14864b instanceof g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f14863a.equals(((k) obj).f14863a);
    }

    @Override // ps.a
    public void error(String str) {
        b().error(str);
    }

    public boolean f() {
        return this.f14864b == null;
    }

    public void g(qs.d dVar) {
        if (d()) {
            try {
                this.f14866d.invoke(this.f14864b, dVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // ps.a
    public String getName() {
        return this.f14863a;
    }

    public void h(ps.a aVar) {
        this.f14864b = aVar;
    }

    public int hashCode() {
        return this.f14863a.hashCode();
    }

    @Override // ps.a
    public void info(String str) {
        b().info(str);
    }

    @Override // ps.a
    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    @Override // ps.a
    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    @Override // ps.a
    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    @Override // ps.a
    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    @Override // ps.a
    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    @Override // ps.a
    public void trace(String str) {
        b().trace(str);
    }

    @Override // ps.a
    public void warn(String str) {
        b().warn(str);
    }

    @Override // ps.a
    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    @Override // ps.a
    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    @Override // ps.a
    public void info(String str, Object obj) {
        b().info(str, obj);
    }

    @Override // ps.a
    public boolean isDebugEnabled(ps.d dVar) {
        return b().isDebugEnabled(dVar);
    }

    @Override // ps.a
    public boolean isErrorEnabled(ps.d dVar) {
        return b().isErrorEnabled(dVar);
    }

    @Override // ps.a
    public boolean isInfoEnabled(ps.d dVar) {
        return b().isInfoEnabled(dVar);
    }

    @Override // ps.a
    public boolean isTraceEnabled(ps.d dVar) {
        return b().isTraceEnabled(dVar);
    }

    @Override // ps.a
    public boolean isWarnEnabled(ps.d dVar) {
        return b().isWarnEnabled(dVar);
    }

    @Override // ps.a
    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    @Override // ps.a
    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    @Override // ps.a
    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    @Override // ps.a
    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    @Override // ps.a
    public void info(String str, Object obj, Object obj2) {
        b().info(str, obj, obj2);
    }

    @Override // ps.a
    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    @Override // ps.a
    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    @Override // ps.a
    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    @Override // ps.a
    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    @Override // ps.a
    public void info(String str, Object... objArr) {
        b().info(str, objArr);
    }

    @Override // ps.a
    public void trace(String str, Object... objArr) {
        b().trace(str, objArr);
    }

    @Override // ps.a
    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    @Override // ps.a
    public void debug(String str, Throwable th2) {
        b().debug(str, th2);
    }

    @Override // ps.a
    public void error(String str, Throwable th2) {
        b().error(str, th2);
    }

    @Override // ps.a
    public void info(String str, Throwable th2) {
        b().info(str, th2);
    }

    @Override // ps.a
    public void trace(String str, Throwable th2) {
        b().trace(str, th2);
    }

    @Override // ps.a
    public void warn(String str, Throwable th2) {
        b().warn(str, th2);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str) {
        b().debug(dVar, str);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str) {
        b().error(dVar, str);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str) {
        b().info(dVar, str);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str) {
        b().trace(dVar, str);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str) {
        b().warn(dVar, str);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj) {
        b().debug(dVar, str, obj);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj) {
        b().error(dVar, str, obj);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj) {
        b().info(dVar, str, obj);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj) {
        b().trace(dVar, str, obj);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj) {
        b().warn(dVar, str, obj);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj, Object obj2) {
        b().debug(dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj, Object obj2) {
        b().error(dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj, Object obj2) {
        b().info(dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj, Object obj2) {
        b().trace(dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj, Object obj2) {
        b().warn(dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object... objArr) {
        b().debug(dVar, str, objArr);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object... objArr) {
        b().error(dVar, str, objArr);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object... objArr) {
        b().info(dVar, str, objArr);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object... objArr) {
        b().trace(dVar, str, objArr);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object... objArr) {
        b().warn(dVar, str, objArr);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Throwable th2) {
        b().debug(dVar, str, th2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Throwable th2) {
        b().error(dVar, str, th2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Throwable th2) {
        b().info(dVar, str, th2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Throwable th2) {
        b().trace(dVar, str, th2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Throwable th2) {
        b().warn(dVar, str, th2);
    }
}
