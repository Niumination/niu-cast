package eq;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final boolean a(@l Throwable th2) {
        l0.p(th2, "<this>");
        Class<?> superclass = th2.getClass();
        while (!l0.g(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    @l
    public static final RuntimeException b(@l Throwable th2) throws Throwable {
        l0.p(th2, "e");
        throw th2;
    }
}
