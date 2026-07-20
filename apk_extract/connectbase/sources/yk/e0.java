package yk;

import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends ClassLoader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a f21401a;

    public static final class a extends URLClassLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ClassLoader f21402a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l URL[] urlArr, @os.l ClassLoader classLoader) {
            super(urlArr, null);
            l0.p(urlArr, "urls");
            l0.p(classLoader, "realParent");
            this.f21402a = classLoader;
        }

        @Override // java.net.URLClassLoader, java.lang.ClassLoader
        @os.l
        public Class<?> findClass(@os.l String str) throws ClassNotFoundException {
            l0.p(str, "name");
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                Class<?> clsFindClass = super.findClass(str);
                l0.o(clsFindClass, "super.findClass(name)");
                return clsFindClass;
            } catch (ClassNotFoundException unused) {
                Class<?> clsLoadClass = this.f21402a.loadClass(str);
                l0.o(clsLoadClass, "realParent.loadClass(name)");
                return clsLoadClass;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(@os.l List<URL> list, @os.m ClassLoader classLoader) {
        super(classLoader);
        l0.p(list, "classpath");
        Object[] array = list.toArray(new URL[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        ClassLoader parent = getParent();
        l0.o(parent, "parent");
        this.f21401a = new a((URL[]) array, parent);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21401a.close();
    }

    @Override // java.lang.ClassLoader
    @os.l
    public synchronized Class<?> loadClass(@os.l String str, boolean z10) {
        Class<?> clsLoadClass;
        l0.p(str, "name");
        try {
            clsLoadClass = this.f21401a.findClass(str);
        } catch (ClassNotFoundException unused) {
            clsLoadClass = super.loadClass(str, z10);
            l0.o(clsLoadClass, "{\n        // didn't find…lass(name, resolve)\n    }");
        }
        return clsLoadClass;
    }
}
