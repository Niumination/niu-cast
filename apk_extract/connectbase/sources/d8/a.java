package d8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements og.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3626a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f3627b = cc.a.a("com.transsion.oemunlockdata.OemUnlockDataManager");

    @Override // og.a
    public String a() {
        try {
            Object objNewInstance = f3627b.newInstance();
            Method methodG = cc.a.g(f3627b, "getCpuId", new Class[0]);
            if (methodG == null) {
                return "";
            }
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(objNewInstance, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th2) {
            m7.a.a("getCpuId fail ", th2, f3626a);
            return null;
        }
    }

    @Override // og.a
    public int b(int i10, byte[] bArr) {
        try {
            Object objNewInstance = f3627b.newInstance();
            Method methodG = cc.a.g(f3627b, "writeOemUnlockData", Integer.TYPE, byte[].class);
            if (methodG == null) {
                return -1;
            }
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(objNewInstance, Integer.valueOf(i10), bArr);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return -1;
        } catch (Throwable th2) {
            m7.a.a("writeOemUnlockData fail ", th2, f3626a);
            return -1;
        }
    }
}
