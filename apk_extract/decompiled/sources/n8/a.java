package n8;

import java.lang.reflect.Method;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements da.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f8127c = o9.a("android.os.SystemProperties");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f8128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f8129b;

    @Override // da.a
    public final boolean a(String str) {
        Method method = this.f8129b;
        Class cls = f8127c;
        if (method == null) {
            this.f8129b = o9.d(cls, "getBoolean", String.class, Boolean.TYPE);
        }
        try {
            this.f8129b.setAccessible(true);
            Object objInvoke = this.f8129b.invoke(cls, str, Boolean.FALSE);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // da.a
    public final String b(String str, String str2) {
        Method method = this.f8128a;
        Class cls = f8127c;
        if (method == null) {
            this.f8128a = o9.d(cls, "get", String.class, String.class);
        }
        try {
            this.f8128a.setAccessible(true);
            Object objInvoke = this.f8128a.invoke(cls, str, str2);
            return (objInvoke == null || !(objInvoke instanceof String)) ? str2 : (String) objInvoke;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
