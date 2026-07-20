package bn;

import an.l;
import in.f;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kn.l0;
import kn.r1;
import nm.p;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public class a extends l {

    /* JADX INFO: renamed from: bn.a$a, reason: collision with other inner class name */
    @r1({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    public static final class C0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final C0033a f984a = new C0033a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m
        @f
        public static final Integer f985b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f985b = num2;
        }
    }

    private final boolean e(int i10) {
        Integer num = C0033a.f985b;
        return num == null || num.intValue() >= i10;
    }

    @Override // an.l
    public void a(@os.l Throwable th2, @os.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        l0.p(th2, "cause");
        l0.p(th3, "exception");
        if (e(19)) {
            th2.addSuppressed(th3);
        } else {
            super.a(th2, th3);
        }
    }

    @Override // an.l
    @os.l
    public List<Throwable> d(@os.l Throwable th2) {
        l0.p(th2, "exception");
        if (!e(19)) {
            return super.d(th2);
        }
        Throwable[] suppressed = th2.getSuppressed();
        l0.o(suppressed, "getSuppressed(...)");
        return p.t(suppressed);
    }
}
