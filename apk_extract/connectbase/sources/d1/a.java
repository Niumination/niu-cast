package d1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f3504d = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3505e = "com.google.common.base.FinalizableReference";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    public static final Constructor<Thread> f3506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    public static final Field f3507g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Class<?>> f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhantomReference<Object> f3509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReferenceQueue<Object> f3510c;

    static {
        Constructor<Thread> constructorC = c();
        f3506f = constructorC;
        f3507g = constructorC == null ? e() : null;
    }

    public a(Class<?> finalizableReferenceClass, ReferenceQueue<Object> queue, PhantomReference<Object> frqReference) {
        this.f3510c = queue;
        this.f3508a = new WeakReference<>(finalizableReferenceClass);
        this.f3509b = frqReference;
    }

    @gm.a
    public static Constructor<Thread> c() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @gm.a
    public static Field e() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f3504d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    public static void f(Class<?> finalizableReferenceClass, ReferenceQueue<Object> queue, PhantomReference<Object> frqReference) {
        Thread thread;
        if (!finalizableReferenceClass.getName().equals("c1.p")) {
            throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        a aVar = new a(finalizableReferenceClass, queue, frqReference);
        String name = a.class.getName();
        Constructor<Thread> constructor = f3506f;
        if (constructor != null) {
            try {
                thread = constructor.newInstance(null, aVar, name, 0L, Boolean.FALSE);
            } catch (Throwable th2) {
                f3504d.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th2);
                thread = null;
            }
        } else {
            thread = null;
        }
        if (thread == null) {
            thread = new Thread(null, aVar, name);
        }
        thread.setDaemon(true);
        try {
            Field field = f3507g;
            if (field != null) {
                field.set(thread, null);
            }
        } catch (Throwable th3) {
            f3504d.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th3);
        }
        thread.start();
    }

    public final boolean a(Reference<?> firstReference) {
        Reference<? extends Object> referencePoll;
        Method methodD = d();
        if (methodD == null || !b(firstReference, methodD)) {
            return false;
        }
        do {
            referencePoll = this.f3510c.poll();
            if (referencePoll == null) {
                return true;
            }
        } while (b(referencePoll, methodD));
        return false;
    }

    public final boolean b(Reference<?> reference, Method finalizeReferentMethod) {
        reference.clear();
        if (reference == this.f3509b) {
            return false;
        }
        try {
            finalizeReferentMethod.invoke(reference, null);
            return true;
        } catch (Throwable th2) {
            f3504d.log(Level.SEVERE, "Error cleaning up after reference.", th2);
            return true;
        }
    }

    @gm.a
    public final Method d() {
        Class<?> cls = this.f3508a.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f3510c.remove())) {
        }
    }
}
