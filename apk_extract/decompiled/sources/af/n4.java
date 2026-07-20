package af;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class n4 implements s2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f470b = Logger.getLogger(n4.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f472d;
    public static final RuntimeException e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f473h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f474a;

    static {
        Method method;
        Constructor<?> constructor;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                cls.getMethod("sum", null);
                Constructor<?>[] constructors = cls.getConstructors();
                int length = constructors.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        constructor = null;
                        break;
                    }
                    constructor = constructors[i8];
                    if (constructor.getParameterTypes().length == 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
                f470b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                constructor = null;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
        }
        if (th != null || constructor == null) {
            f471c = null;
            f472d = null;
            e = new RuntimeException(th);
        } else {
            f471c = constructor;
            f472d = method;
            e = null;
        }
        f473h = new Object[]{1L};
    }

    public n4() {
        RuntimeException runtimeException = e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f474a = f471c.newInstance(null);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // af.s2
    public final void e() {
        try {
            f472d.invoke(this.f474a, f473h);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }
}
