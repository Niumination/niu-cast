package yk;

import java.lang.reflect.Method;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final lm.d0 f21427a = lm.f0.b(a.INSTANCE);

    public static final class a extends n0 implements jn.a<Method> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Method invoke() {
            try {
                return Class.forName("yl.g").getMethod("isParkingAllowed", null);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static final Method a() {
        return (Method) f21427a.getValue();
    }

    public static final boolean b() {
        boolean zG;
        Method methodA = a();
        if (methodA == null) {
            return false;
        }
        try {
            zG = l0.g(methodA.invoke(null, null), Boolean.TRUE);
        } catch (Throwable unused) {
            zG = false;
        }
        return zG;
    }
}
