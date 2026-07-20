package tl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final lm.d0 f15797a = lm.f0.b(a.INSTANCE);

    public static final class a extends kn.n0 implements jn.a<Method> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Method invoke() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @lm.z0
    public static final void a(@os.l Throwable th2, @os.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        kn.l0.p(th2, "<this>");
        kn.l0.p(th3, "other");
        Method methodB = b();
        if (methodB == null) {
            return;
        }
        methodB.invoke(th2, th3);
    }

    public static final Method b() {
        return (Method) f15797a.getValue();
    }
}
