package qg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends URLClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f9123a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(URL[] urls, ClassLoader realParent) {
        super(urls, null);
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(realParent, "realParent");
        this.f9123a = realParent;
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    public final Class findClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Class<?> clsFindLoadedClass = findLoadedClass(name);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException unused) {
            return this.f9123a.loadClass(name);
        }
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    public final URL findResource(String str) {
        return null;
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    public final Enumeration findResources(String str) {
        Enumeration enumerationEmptyEnumeration = Collections.emptyEnumeration();
        Intrinsics.checkNotNullExpressionValue(enumerationEmptyEnumeration, "emptyEnumeration(...)");
        return enumerationEmptyEnumeration;
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.f9123a.getResource(str);
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.f9123a.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration getResources(String str) throws IOException {
        Enumeration<URL> resources = this.f9123a.getResources(str);
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return resources;
    }
}
