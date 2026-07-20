package xj;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements vj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile vj.b f11015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f11016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f11017d;
    public wj.a e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedBlockingQueue f11018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f11019i;

    public j(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z2) {
        this.f11014a = str;
        this.f11018h = linkedBlockingQueue;
        this.f11019i = z2;
    }

    public final vj.b a() {
        if (this.f11015b != null) {
            return this.f11015b;
        }
        if (this.f11019i) {
            return d.NOP_LOGGER;
        }
        if (this.e == null) {
            this.e = new wj.a(this, this.f11018h);
        }
        return this.e;
    }

    public final boolean b() {
        Boolean bool = this.f11016c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f11017d = this.f11015b.getClass().getMethod("log", wj.c.class);
            this.f11016c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f11016c = Boolean.FALSE;
        }
        return this.f11016c.booleanValue();
    }

    @Override // vj.b
    public final void debug(String str) {
        a().debug(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && j.class == obj.getClass() && this.f11014a.equals(((j) obj).f11014a);
    }

    @Override // vj.b
    public final void error(String str, Throwable th2) {
        a().error(str, th2);
    }

    public final int hashCode() {
        return this.f11014a.hashCode();
    }

    @Override // vj.b
    public final void info(String str) {
        a().info(str);
    }

    @Override // vj.b
    public final boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // vj.b
    public final boolean isEnabledForLevel(wj.b bVar) {
        return a().isEnabledForLevel(bVar);
    }

    @Override // vj.b
    public final boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // vj.b
    public final boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // vj.b
    public final boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // vj.b
    public final boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // vj.b
    public final yj.a makeLoggingEventBuilder(wj.b bVar) {
        return a().makeLoggingEventBuilder(bVar);
    }

    @Override // vj.b
    public final void trace(String str) {
        a().trace(str);
    }

    @Override // vj.b
    public final void warn(String str) {
        a().warn(str);
    }

    @Override // vj.b
    public final void debug(String str, Throwable th2) {
        a().debug(str, th2);
    }

    @Override // vj.b
    public final void warn(String str, Throwable th2) {
        a().warn("Exception occurred during engine shutdown", th2);
    }
}
