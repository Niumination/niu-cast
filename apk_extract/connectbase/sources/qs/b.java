package qs;

import java.util.Queue;
import rs.f;
import rs.k;

/* JADX INFO: loaded from: classes3.dex */
public class b implements ps.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f14122d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f14124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Queue<e> f14125c;

    public b(k kVar, Queue<e> queue) {
        this.f14124b = kVar;
        this.f14123a = kVar.getName();
        this.f14125c = queue;
    }

    public final void b(c cVar, ps.d dVar, String str, Object[] objArr, Throwable th2) {
        e eVar = new e();
        eVar.f14134h = System.currentTimeMillis();
        eVar.f14127a = cVar;
        eVar.f14130d = this.f14124b;
        eVar.f14129c = this.f14123a;
        eVar.f14128b = dVar;
        eVar.f14132f = str;
        eVar.f14131e = Thread.currentThread().getName();
        eVar.f14133g = objArr;
        eVar.f14135i = th2;
        this.f14125c.add(eVar);
    }

    public final void c(c cVar, ps.d dVar, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            b(cVar, dVar, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            b(cVar, dVar, str, new Object[]{obj, obj2}, null);
        }
    }

    public final void d(c cVar, ps.d dVar, String str, Object[] objArr) {
        Throwable thK = f.k(objArr);
        if (thK != null) {
            b(cVar, dVar, str, f.s(objArr), thK);
        } else {
            b(cVar, dVar, str, objArr, null);
        }
    }

    @Override // ps.a
    public void debug(String str) {
        b(c.DEBUG, null, str, null, null);
    }

    public final void e(c cVar, ps.d dVar, String str, Throwable th2) {
        b(cVar, dVar, str, null, th2);
    }

    @Override // ps.a
    public void error(String str) {
        b(c.ERROR, null, str, null, null);
    }

    public final void f(c cVar, ps.d dVar, String str, Object obj) {
        b(cVar, dVar, str, new Object[]{obj}, null);
    }

    @Override // ps.a
    public String getName() {
        return this.f14123a;
    }

    @Override // ps.a
    public void info(String str) {
        b(c.INFO, null, str, null, null);
    }

    @Override // ps.a
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // ps.a
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // ps.a
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // ps.a
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // ps.a
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // ps.a
    public void trace(String str) {
        b(c.TRACE, null, str, null, null);
    }

    @Override // ps.a
    public void warn(String str) {
        b(c.WARN, null, str, null, null);
    }

    @Override // ps.a
    public boolean isDebugEnabled(ps.d dVar) {
        return true;
    }

    @Override // ps.a
    public boolean isErrorEnabled(ps.d dVar) {
        return true;
    }

    @Override // ps.a
    public boolean isInfoEnabled(ps.d dVar) {
        return true;
    }

    @Override // ps.a
    public boolean isTraceEnabled(ps.d dVar) {
        return true;
    }

    @Override // ps.a
    public boolean isWarnEnabled(ps.d dVar) {
        return true;
    }

    @Override // ps.a
    public void debug(String str, Object obj) {
        f(c.DEBUG, null, str, obj);
    }

    @Override // ps.a
    public void error(String str, Object obj) {
        f(c.ERROR, null, str, obj);
    }

    @Override // ps.a
    public void info(String str, Object obj) {
        f(c.INFO, null, str, obj);
    }

    @Override // ps.a
    public void trace(String str, Object obj) {
        f(c.TRACE, null, str, obj);
    }

    @Override // ps.a
    public void warn(String str, Object obj) {
        f(c.WARN, null, str, obj);
    }

    @Override // ps.a
    public void debug(String str, Object obj, Object obj2) {
        c(c.DEBUG, null, str, obj, obj2);
    }

    @Override // ps.a
    public void error(String str, Object obj, Object obj2) {
        c(c.ERROR, null, str, obj, obj2);
    }

    @Override // ps.a
    public void info(String str, Object obj, Object obj2) {
        c(c.INFO, null, str, obj, obj2);
    }

    @Override // ps.a
    public void trace(String str, Object obj, Object obj2) {
        c(c.TRACE, null, str, obj, obj2);
    }

    @Override // ps.a
    public void warn(String str, Object obj, Object obj2) {
        c(c.WARN, null, str, obj, obj2);
    }

    @Override // ps.a
    public void debug(String str, Object... objArr) {
        d(c.DEBUG, null, str, objArr);
    }

    @Override // ps.a
    public void error(String str, Object... objArr) {
        d(c.ERROR, null, str, objArr);
    }

    @Override // ps.a
    public void info(String str, Object... objArr) {
        d(c.INFO, null, str, objArr);
    }

    @Override // ps.a
    public void trace(String str, Object... objArr) {
        d(c.TRACE, null, str, objArr);
    }

    @Override // ps.a
    public void warn(String str, Object... objArr) {
        d(c.WARN, null, str, objArr);
    }

    @Override // ps.a
    public void debug(String str, Throwable th2) {
        b(c.DEBUG, null, str, null, th2);
    }

    @Override // ps.a
    public void error(String str, Throwable th2) {
        b(c.ERROR, null, str, null, th2);
    }

    @Override // ps.a
    public void info(String str, Throwable th2) {
        b(c.INFO, null, str, null, th2);
    }

    @Override // ps.a
    public void trace(String str, Throwable th2) {
        b(c.TRACE, null, str, null, th2);
    }

    @Override // ps.a
    public void warn(String str, Throwable th2) {
        b(c.WARN, null, str, null, th2);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str) {
        b(c.DEBUG, dVar, str, null, null);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str) {
        b(c.ERROR, dVar, str, null, null);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str) {
        b(c.INFO, dVar, str, null, null);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str) {
        b(c.TRACE, dVar, str, null, null);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str) {
        b(c.WARN, dVar, str, null, null);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj) {
        f(c.DEBUG, dVar, str, obj);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj) {
        f(c.ERROR, dVar, str, obj);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj) {
        f(c.INFO, dVar, str, obj);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj) {
        f(c.TRACE, dVar, str, obj);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj) {
        f(c.WARN, dVar, str, obj);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object obj, Object obj2) {
        c(c.DEBUG, dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object obj, Object obj2) {
        c(c.ERROR, dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object obj, Object obj2) {
        c(c.INFO, dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object obj, Object obj2) {
        c(c.TRACE, dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object obj, Object obj2) {
        c(c.WARN, dVar, str, obj, obj2);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Object... objArr) {
        d(c.DEBUG, dVar, str, objArr);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Object... objArr) {
        d(c.ERROR, dVar, str, objArr);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Object... objArr) {
        d(c.INFO, dVar, str, objArr);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Object... objArr) {
        d(c.TRACE, dVar, str, objArr);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Object... objArr) {
        d(c.WARN, dVar, str, objArr);
    }

    @Override // ps.a
    public void debug(ps.d dVar, String str, Throwable th2) {
        b(c.DEBUG, dVar, str, null, th2);
    }

    @Override // ps.a
    public void error(ps.d dVar, String str, Throwable th2) {
        b(c.ERROR, dVar, str, null, th2);
    }

    @Override // ps.a
    public void info(ps.d dVar, String str, Throwable th2) {
        b(c.INFO, dVar, str, null, th2);
    }

    @Override // ps.a
    public void trace(ps.d dVar, String str, Throwable th2) {
        b(c.TRACE, dVar, str, null, th2);
    }

    @Override // ps.a
    public void warn(ps.d dVar, String str, Throwable th2) {
        b(c.WARN, dVar, str, null, th2);
    }
}
