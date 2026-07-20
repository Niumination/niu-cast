package v8;

/* JADX INFO: loaded from: classes2.dex */
public class d implements fh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16688a = "com.transsion.log.TranLog";

    @Override // fh.b
    public void a(String str, String str2) {
        try {
            Class.forName(f16688a).getDeclaredMethod("localLogImmediately", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void b(String str, float f10, int i10) {
        try {
            Class.forName(f16688a).getDeclaredMethod("setNvFloat", String.class, Float.TYPE, Integer.TYPE).invoke(null, str, Float.valueOf(f10), Integer.valueOf(i10));
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void c(String str, String str2) {
        try {
            Class.forName(f16688a).getDeclaredMethod("setNvString", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void d(String str, String str2) {
        try {
            Class.forName(f16688a).getDeclaredMethod("localLogKeep", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void e(String str, String str2) {
        try {
            Class.forName(f16688a).getDeclaredMethod("localLog", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void f(String str, int i10, int i11) {
        try {
            Class<?> cls = Class.forName(f16688a);
            Class cls2 = Integer.TYPE;
            cls.getDeclaredMethod("setNvInt", String.class, cls2, cls2).invoke(null, str, Integer.valueOf(i10), Integer.valueOf(i11));
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void g(String str, String str2) throws ac.a {
        throw new ac.a("This interface only can be called above Android T!!!");
    }

    @Override // fh.b
    public void h(String str, String str2) {
        try {
            Class.forName(f16688a).getDeclaredMethod("localRaw", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.b
    public void i(String str, long j10, int i10) {
        try {
            Class.forName(f16688a).getDeclaredMethod("setNvLong", String.class, Long.TYPE, Integer.TYPE).invoke(null, str, Long.valueOf(j10), Integer.valueOf(i10));
        } catch (Exception unused) {
        }
    }
}
