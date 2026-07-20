package qg;

import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends ClassLoader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f9124a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(ArrayList classpath, ClassLoader classLoader) {
        super(classLoader);
        Intrinsics.checkNotNullParameter(classpath, "classpath");
        URL[] urlArr = (URL[]) classpath.toArray(new URL[0]);
        ClassLoader parent = getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
        this.f9124a = new v0(urlArr, parent);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9124a.close();
    }

    @Override // java.lang.ClassLoader
    public final synchronized Class loadClass(String name, boolean z2) {
        Class clsLoadClass;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            clsLoadClass = this.f9124a.findClass(name);
        } catch (ClassNotFoundException unused) {
            clsLoadClass = super.loadClass(name, z2);
        }
        return clsLoadClass;
    }
}
