package v8;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c implements fh.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16684c = "transsion.log.Athena";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16685d = "com.transsion.log.cloudengine.CloudEngine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f16686a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16687b = new a();

    @Override // fh.a
    public boolean A(String str, String str2, boolean z10) {
        try {
            return ((Boolean) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getEnabledAsName", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10))).booleanValue();
        } catch (Exception unused) {
            return z10;
        }
    }

    @Override // fh.a
    public boolean[] B(String str, String str2, boolean z10) {
        try {
            return (boolean[]) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsBooleanArray", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public String C(String str) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getDefaultFilePath", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public String D(String str, String str2) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getDefaultFileContent", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void E(String str, String str2, boolean z10) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsBoolean", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10));
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String F(String str, String str2) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getFileContent", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void G(String str, String str2, long[] jArr) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsLongArray", String.class, String.class, long[].class).invoke(null, str, str2, jArr);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String H(String str, String str2, boolean z10, String str3) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsStringDef", String.class, String.class, Boolean.TYPE, String.class).invoke(null, str, str2, Boolean.valueOf(z10), str3);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void I(String str, String str2, lb.a aVar) {
        this.f16687b.b(str, str2, aVar);
    }

    @Override // fh.a
    public void J(long j10, String str, int i10, Bundle bundle) {
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("log", Long.TYPE, String.class, Integer.TYPE, Bundle.class).invoke(null, Long.valueOf(j10), str, Integer.valueOf(i10), bundle);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public void K(int i10, String str, int i11, ArrayList<Bundle> arrayList, Bundle bundle) {
        try {
            Class<?> cls = Class.forName("transsion.log.Athena");
            Class cls2 = Integer.TYPE;
            cls.getDeclaredMethod("log", cls2, String.class, cls2, ArrayList.class, Bundle.class).invoke(null, Integer.valueOf(i10), str, Integer.valueOf(i11), arrayList, bundle);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String L(String str, String str2, boolean z10) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsString", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public String a(String str) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getConfig", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public boolean b(String str, boolean z10) {
        try {
            return ((Boolean) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getEnabled", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z10))).booleanValue();
        } catch (Exception unused) {
            return z10;
        }
    }

    @Override // fh.a
    public long c(String str, String str2, boolean z10, long j10) {
        try {
            return ((Long) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsLongDef", String.class, String.class, Boolean.TYPE, Long.TYPE).invoke(null, str, str2, Boolean.valueOf(z10), Long.valueOf(j10))).longValue();
        } catch (Exception unused) {
            return j10;
        }
    }

    @Override // fh.a
    public void d(int i10, String str, int i11, Bundle bundle) {
        try {
            Class<?> cls = Class.forName("transsion.log.Athena");
            Class cls2 = Integer.TYPE;
            cls.getDeclaredMethod("log", cls2, String.class, cls2, Bundle.class).invoke(null, Integer.valueOf(i10), str, Integer.valueOf(i11), bundle);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public void e(String str, String str2, long j10) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsLong", String.class, String.class, Long.TYPE).invoke(null, str, str2, Long.valueOf(j10));
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public long f(String str, String str2, boolean z10) {
        try {
            return ((Long) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsLong", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10))).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // fh.a
    public void g(String str, String str2, String[] strArr) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsStringArray", String.class, String.class, String[].class).invoke(null, str, str2, strArr);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public void h(int i10) {
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("appRequest", Integer.TYPE).invoke(null, Integer.valueOf(i10));
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public boolean i(long j10) {
        try {
            return ((Boolean) Class.forName("transsion.log.Athena").getDeclaredMethod("isEnable", Long.TYPE).invoke(null, Long.valueOf(j10))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // fh.a
    public void j(lb.c cVar) {
        this.f16686a.c(cVar);
    }

    @Override // fh.a
    public String k(String str) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getFilePath", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void l(long j10, String str, int i10, ArrayList<Bundle> arrayList, Bundle bundle) {
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("log", Long.TYPE, String.class, Integer.TYPE, ArrayList.class, Bundle.class).invoke(null, Long.valueOf(j10), str, Integer.valueOf(i10), arrayList, bundle);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public void m(String str, String str2) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putConfig", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String n(Context context, String str) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getConfigStatic", Context.class, String.class).invoke(null, context, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void o(String str, String str2, boolean[] zArr) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsBooleanArray", String.class, String.class, boolean[].class).invoke(null, str, str2, zArr);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String p(String str) {
        try {
            return (String) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getDefaultConfig", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void q(lb.c cVar) {
        this.f16686a.d(cVar);
    }

    @Override // fh.a
    public void r(String str, lb.a aVar) {
        this.f16687b.c(str, aVar);
    }

    @Override // fh.a
    public void s(String str, boolean z10) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("feedBack", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z10));
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public long[] t(String str, String str2, boolean z10) {
        try {
            return (long[]) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsLongArray", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public void u(String str, String str2, String str3) {
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("putAsString", String.class, String.class, String.class).invoke(null, str, str2, str3);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public void v(long j10, String str) {
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("log", Long.TYPE, String.class).invoke(null, Long.valueOf(j10), str);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public String[] w(String str, String str2, boolean z10) {
        try {
            return (String[]) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsStringArray", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // fh.a
    public boolean x(String str, String str2, boolean z10) {
        try {
            return ((Boolean) Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("getAsBoolean", String.class, String.class, Boolean.TYPE).invoke(null, str, str2, Boolean.valueOf(z10))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // fh.a
    public void y(int i10, String str) {
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("log", Integer.TYPE, String.class).invoke(null, Integer.valueOf(i10), str);
        } catch (Exception unused) {
        }
    }

    @Override // fh.a
    public boolean z(String str, String str2, boolean z10, boolean z11) {
        try {
            Class<?> cls = Class.forName("com.transsion.log.cloudengine.CloudEngine");
            Class cls2 = Boolean.TYPE;
            return ((Boolean) cls.getDeclaredMethod("getAsBooleanDef", String.class, String.class, cls2, cls2).invoke(null, str, str2, Boolean.valueOf(z10), Boolean.valueOf(z11))).booleanValue();
        } catch (Exception unused) {
            return z11;
        }
    }
}
