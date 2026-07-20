package x4;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f10860a;

    static {
        y wVar;
        if (j.isJava9OrLater()) {
            try {
                wVar = new w(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
                wVar = null;
            }
        } else {
            wVar = null;
        }
        if (wVar == null) {
            wVar = new x();
        }
        f10860a = wVar;
    }

    public abstract boolean a(AccessibleObject accessibleObject, Object obj);
}
