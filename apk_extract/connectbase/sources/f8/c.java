package f8;

import android.os.storage.StorageVolume;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements qg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5936a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f5937b = cc.a.a("android.os.storage.StorageVolume");

    @Override // qg.b
    public boolean a(StorageVolume storageVolume) {
        Method methodG = cc.a.g(f5937b, "isRemovable", new Class[0]);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageVolume, null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("isRemovable fail ", th2, f5936a);
            return false;
        }
    }

    @Override // qg.b
    public File b(StorageVolume storageVolume) {
        Method methodG = cc.a.g(f5937b, "getDirectory", new Class[0]);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageVolume, null);
            if (objInvoke == null || !(objInvoke instanceof File)) {
                return null;
            }
            return (File) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getPath fail ", th2, f5936a);
            return null;
        }
    }

    @Override // qg.b
    public String c(StorageVolume storageVolume) {
        Method methodG = cc.a.g(f5937b, "getState", new Class[0]);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageVolume, null);
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("isRemovable fail ", th2, f5936a);
            return null;
        }
    }
}
