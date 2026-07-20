package x7;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f implements ig.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20117b = "f";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f20118c = cc.a.a("android.media.AudioSystem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20119a = bc.a.a();

    @Override // ig.e
    public int a(int i10, int i11) {
        try {
            Class<?> cls = f20118c;
            Class cls2 = Integer.TYPE;
            Method methodG = cc.a.g(cls, "setForceUse", cls2, cls2);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, null, Integer.valueOf(i10), Integer.valueOf(i11));
            if (objJ == null || !(objJ instanceof Integer)) {
                return 0;
            }
            return ((Integer) objJ).intValue();
        } catch (Throwable th2) {
            m7.a.a("setForceUse fail ", th2, f20117b);
            return 0;
        }
    }

    @Override // ig.e
    public boolean b(int i10) {
        try {
            Method methodG = cc.a.g(f20118c, "isSourceActive", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(Integer.valueOf(i10), null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("isSourceActive fail ", th2, f20117b);
            return false;
        }
    }

    @Override // ig.e
    public int c() {
        try {
            Method methodG = cc.a.g(f20118c, "newAudioSessionId", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("newAudioSessionId fail ", th2, f20117b);
            return 0;
        }
    }

    @Override // ig.e
    public int d(int i10) {
        try {
            Method methodG = cc.a.g(f20118c, "getForceUse", Integer.TYPE);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, null, Integer.valueOf(i10));
            if (objJ == null || !(objJ instanceof Integer)) {
                return 0;
            }
            return ((Integer) objJ).intValue();
        } catch (Throwable th2) {
            m7.a.a("getForceUse fail ", th2, f20117b);
            return 0;
        }
    }

    @Override // ig.e
    public String e(int i10) {
        try {
            Method methodG = cc.a.g(f20118c, "getOutputDeviceName", Integer.TYPE);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, null, Integer.valueOf(i10));
            if (objJ == null || !(objJ instanceof String)) {
                return null;
            }
            return (String) objJ;
        } catch (Throwable th2) {
            m7.a.a("getOutputDeviceName fail ", th2, f20117b);
            return null;
        }
    }
}
