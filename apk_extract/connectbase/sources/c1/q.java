package c1;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public class q implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1232e = "com.google.common.base.internal.Finalizer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue<Object> f1234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhantomReference<Object> f1235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f1231d = Logger.getLogger(q.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f1233f = d(h(new d(), new a(), new b()));

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1237a = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        @Override // c1.q.c
        @gm.a
        public Class<?> a() {
            try {
                return c(b()).loadClass(q.f1232e);
            } catch (Exception e10) {
                q.f1231d.log(Level.WARNING, f1237a, (Throwable) e10);
                return null;
            }
        }

        public URL b() throws IOException {
            String str = q.f1232e.replace(n1.e.f11183c, el.b0.f4502a) + p1.c.f12696d;
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String string = resource.toString();
            if (string.endsWith(str)) {
                return new URL(resource, string.substring(0, string.length() - str.length()));
            }
            throw new IOException("Unsupported path style: ".concat(string));
        }

        public URLClassLoader c(URL base) {
            return new URLClassLoader(new URL[]{base}, null);
        }
    }

    public static class b implements c {
        @Override // c1.q.c
        public Class<?> a() {
            try {
                return Class.forName("d1.a");
            } catch (ClassNotFoundException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public interface c {
        @gm.a
        Class<?> a();
    }

    public static class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @b1.e
        public static boolean f1238a;

        @Override // c1.q.c
        @gm.a
        public Class<?> a() {
            if (f1238a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(q.f1232e);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                q.f1231d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public q() {
        boolean z10;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f1234a = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.f1235b = phantomReference;
        try {
            f1233f.invoke(null, p.class, referenceQueue, phantomReference);
            z10 = true;
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (Throwable th2) {
            f1231d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th2);
            z10 = false;
        }
        this.f1236c = z10;
    }

    public static Method d(Class<?> finalizer) {
        try {
            return finalizer.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    public static Class<?> h(c... loaders) {
        for (c cVar : loaders) {
            Class<?> clsA = cVar.a();
            if (clsA != null) {
                return clsA;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        if (this.f1236c) {
            return;
        }
        while (true) {
            Reference<? extends Object> referencePoll = this.f1234a.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((p) referencePoll).a();
            } catch (Throwable th2) {
                f1231d.log(Level.SEVERE, "Error cleaning up after reference.", th2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1235b.enqueue();
        c();
    }
}
