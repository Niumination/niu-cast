package an;

import kn.l0;
import lm.a0;
import lm.f1;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public static final l f417a = new cn.a();

    @f1(version = "1.2")
    @z0
    public static final boolean a(int i10, int i11, int i12) {
        return a0.f10167g.k(i10, i11, i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    public static final <T> T b(Object obj) throws ClassNotFoundException {
        try {
            l0.P();
            return obj;
        } catch (ClassCastException e10) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            l0.P();
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (l0.g(classLoader, classLoader2)) {
                throw e10;
            }
            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
        }
    }
}
