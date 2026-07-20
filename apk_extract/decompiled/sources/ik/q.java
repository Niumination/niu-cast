package ik;

import java.security.AccessController;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f5903b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION", true, System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new p())).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        f5902a = iIntValue;
        f5903b = iIntValue != 0;
    }
}
