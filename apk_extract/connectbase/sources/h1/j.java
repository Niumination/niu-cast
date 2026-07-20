package h1;

import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@e
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Weak
    public f f6947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.e
    public final Object f6948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f6949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f6950d;

    @b1.e
    public static final class b extends j {
        public b(f bus, Object target, Method method) {
            super(bus, target, method);
        }

        @Override // h1.j
        public void e(Object event) throws InvocationTargetException {
            synchronized (this) {
                super.e(event);
            }
        }

        public b(f fVar, Object obj, Method method, a aVar) {
            super(fVar, obj, method);
        }
    }

    public static j c(f bus, Object listener, Method method) {
        return f(method) ? new j(bus, listener, method) : new b(bus, listener, method);
    }

    public static boolean f(Method method) {
        return method.getAnnotation(h1.a.class) != null;
    }

    public final k b(Object event) {
        return new k(this.f6947a, event, this.f6948b, this.f6949c);
    }

    public final void d(final Object event) {
        this.f6950d.execute(new Runnable() { // from class: h1.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f6945a.g(event);
            }
        });
    }

    @b1.e
    public void e(Object event) throws InvocationTargetException {
        try {
            Method method = this.f6949c;
            Object obj = this.f6948b;
            event.getClass();
            method.invoke(obj, event);
        } catch (IllegalAccessException e10) {
            throw new Error(c0.a.a("Method became inaccessible: ", event), e10);
        } catch (IllegalArgumentException e11) {
            throw new Error(c0.a.a("Method rejected target/argument: ", event), e11);
        } catch (InvocationTargetException e12) {
            if (!(e12.getCause() instanceof Error)) {
                throw e12;
            }
            throw ((Error) e12.getCause());
        }
    }

    public final boolean equals(@gm.a Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f6948b == jVar.f6948b && this.f6949c.equals(jVar.f6949c);
    }

    public final /* synthetic */ void g(Object obj) {
        try {
            e(obj);
        } catch (InvocationTargetException e10) {
            this.f6947a.b(e10.getCause(), b(obj));
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f6948b) + ((this.f6949c.hashCode() + 31) * 31);
    }

    public j(f bus, Object target, Method method) {
        this.f6947a = bus;
        target.getClass();
        this.f6948b = target;
        this.f6949c = method;
        method.setAccessible(true);
        this.f6950d = bus.f6940b;
    }
}
