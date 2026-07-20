package e8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class r implements pg.n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4136e = "r";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f4137f = cc.a.a("android.os.Trace");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f4138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f4139b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f4140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f4141d = null;

    @Override // pg.n
    public void a(long j10, String str, int i10) {
        if (this.f4141d == null) {
            this.f4141d = cc.a.g(f4137f, "asyncTraceEnd", Long.class, String.class, Integer.class);
        }
        try {
            this.f4141d.setAccessible(true);
            this.f4141d.invoke(f4137f, Long.valueOf(j10), str, Integer.valueOf(i10));
        } catch (Throwable th2) {
            m7.a.a("asyncTraceEnd: ", th2, f4136e);
        }
    }

    @Override // pg.n
    public void b(long j10, String str, int i10) {
        if (this.f4140c == null) {
            this.f4140c = cc.a.g(f4137f, "asyncTraceBegin", Long.class, String.class, Integer.class);
        }
        try {
            this.f4140c.setAccessible(true);
            this.f4140c.invoke(f4137f, Long.valueOf(j10), str, Integer.valueOf(i10));
        } catch (Throwable th2) {
            m7.a.a("asyncTraceBegin: ", th2, f4136e);
        }
    }

    @Override // pg.n
    public void c(long j10) {
        if (this.f4139b == null) {
            this.f4139b = cc.a.g(f4137f, "traceEnd", Long.class);
        }
        try {
            this.f4139b.setAccessible(true);
            this.f4139b.invoke(f4137f, Long.valueOf(j10));
        } catch (Throwable th2) {
            m7.a.a("traceEnd: ", th2, f4136e);
        }
    }

    @Override // pg.n
    public void d(long j10, String str) {
        if (this.f4138a == null) {
            this.f4138a = cc.a.g(f4137f, "traceBegin", Long.class, String.class);
        }
        try {
            this.f4138a.setAccessible(true);
            this.f4138a.invoke(f4137f, Long.valueOf(j10), str);
            dc.e.a(f4136e, "traceBegin");
        } catch (Throwable th2) {
            m7.a.a("traceBegin: ", th2, f4136e);
        }
    }
}
