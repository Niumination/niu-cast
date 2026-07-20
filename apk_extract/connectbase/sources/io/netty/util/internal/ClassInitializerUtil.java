package io.netty.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassInitializerUtil {
    private ClassInitializerUtil() {
    }

    private static void tryLoadClass(ClassLoader classLoader, String str) {
        try {
            Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException | SecurityException unused) {
        }
    }

    public static void tryLoadClasses(Class<?> cls, Class<?>... clsArr) {
        ClassLoader classLoader = PlatformDependent.getClassLoader(cls);
        for (Class<?> cls2 : clsArr) {
            tryLoadClass(classLoader, cls2.getName());
        }
    }
}
