package ko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f9393a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public static C0247a f9394b;

    /* JADX INFO: renamed from: ko.a$a, reason: collision with other inner class name */
    public static final class C0247a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final Method f9395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final Method f9396b;

        public C0247a(@os.m Method method, @os.m Method method2) {
            this.f9395a = method;
            this.f9396b = method2;
        }

        @os.m
        public final Method a() {
            return this.f9396b;
        }

        @os.m
        public final Method b() {
            return this.f9395a;
        }
    }

    public final C0247a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0247a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0247a(null, null);
        }
    }

    public final C0247a b(Object obj) {
        C0247a c0247a = f9394b;
        if (c0247a != null) {
            return c0247a;
        }
        C0247a c0247aA = a(obj);
        f9394b = c0247aA;
        return c0247aA;
    }

    @os.m
    public final Method c(@os.l Object obj) throws IllegalAccessException, InvocationTargetException {
        l0.p(obj, "recordComponent");
        Method method = b(obj).f9396b;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(obj, null);
        if (objInvoke != null) {
            return (Method) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Method");
    }

    @os.m
    public final Class<?> d(@os.l Object obj) throws IllegalAccessException, InvocationTargetException {
        l0.p(obj, "recordComponent");
        Method method = b(obj).f9395a;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(obj, null);
        if (objInvoke != null) {
            return (Class) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    }
}
