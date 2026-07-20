package ko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f9398a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public static a f9399b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final Method f9400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final Method f9401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public final Method f9402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.m
        public final Method f9403d;

        public a(@os.m Method method, @os.m Method method2, @os.m Method method3, @os.m Method method4) {
            this.f9400a = method;
            this.f9401b = method2;
            this.f9402c = method3;
            this.f9403d = method4;
        }

        @os.m
        public final Method a() {
            return this.f9401b;
        }

        @os.m
        public final Method b() {
            return this.f9403d;
        }

        @os.m
        public final Method c() {
            return this.f9402c;
        }

        @os.m
        public final Method d() {
            return this.f9400a;
        }
    }

    public final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    public final a b() {
        a aVar = f9399b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f9399b = aVarA;
        return aVarA;
    }

    @os.m
    public final Class<?>[] c(@os.l Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        l0.p(cls, "clazz");
        Method method = b().f9401b;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(cls, null);
        if (objInvoke != null) {
            return (Class[]) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
    }

    @os.m
    public final Object[] d(@os.l Class<?> cls) {
        l0.p(cls, "clazz");
        Method method = b().f9403d;
        if (method == null) {
            return null;
        }
        return (Object[]) method.invoke(cls, null);
    }

    @os.m
    public final Boolean e(@os.l Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        l0.p(cls, "clazz");
        Method method = b().f9402c;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(cls, null);
        if (objInvoke != null) {
            return (Boolean) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @os.m
    public final Boolean f(@os.l Class<?> cls) throws IllegalAccessException, InvocationTargetException {
        l0.p(cls, "clazz");
        Method method = b().f9400a;
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(cls, null);
        if (objInvoke != null) {
            return (Boolean) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
