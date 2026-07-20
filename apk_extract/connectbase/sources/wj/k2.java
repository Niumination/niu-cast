package wj;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 implements l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f18782b = Logger.getLogger(k2.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f18783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f18784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f18785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f18786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f18787g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18788a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", null);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i10];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                    f18782b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                    constructor = null;
                }
            } catch (Throwable th3) {
                th = th3;
                method2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            method = null;
            method2 = null;
        }
        if (th != null || constructor == null) {
            f18783c = null;
            f18784d = null;
            f18785e = null;
            f18786f = new RuntimeException(th);
        } else {
            f18783c = constructor;
            f18784d = method;
            f18785e = method2;
            f18786f = null;
        }
        f18787g = new Object[]{1L};
    }

    public k2() {
        RuntimeException runtimeException = f18786f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f18788a = f18783c.newInstance(null);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static boolean a() {
        return f18786f == null;
    }

    @Override // wj.l1
    public void add(long j10) {
        try {
            f18784d.invoke(this.f18788a, j10 == 1 ? f18787g : new Object[]{Long.valueOf(j10)});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // wj.l1
    public long value() {
        try {
            return ((Long) f18785e.invoke(this.f18788a, null)).longValue();
        } catch (IllegalAccessException unused) {
            throw new RuntimeException();
        } catch (InvocationTargetException unused2) {
            throw new RuntimeException();
        }
    }
}
