package zj;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k0 f11641b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor f11642a;

    static {
        f11641b = "Dalvik".equals(System.getProperty("java.vm.name")) ? new j0() : new k0();
    }

    public k0() {
        Constructor declaredConstructor = null;
        try {
            declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
        }
        this.f11642a = declaredConstructor;
    }

    public Executor a() {
        return null;
    }
}
