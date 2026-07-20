package c1;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@k
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.c
    @b1.d
    public static final String f1243a = "sun.misc.JavaLangAccess";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.c
    @b1.e
    @b1.d
    public static final String f1244b = "sun.misc.SharedSecrets";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b1.c
    @gm.a
    @b1.d
    public static final Object f1245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b1.c
    @gm.a
    @b1.d
    public static final Method f1246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b1.c
    @gm.a
    @b1.d
    public static final Method f1247e;

    public class a extends AbstractList<StackTraceElement> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f1248a;

        public a(final Throwable val$t) {
            this.f1248a = val$t;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StackTraceElement get(int n10) {
            Method method = t0.f1246d;
            Objects.requireNonNull(method);
            Object obj = t0.f1245c;
            Objects.requireNonNull(obj);
            return (StackTraceElement) t0.m(method, obj, this.f1248a, Integer.valueOf(n10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            Method method = t0.f1247e;
            Objects.requireNonNull(method);
            Object obj = t0.f1245c;
            Objects.requireNonNull(obj);
            return ((Integer) t0.m(method, obj, this.f1248a)).intValue();
        }
    }

    static {
        Object objH = h();
        f1245c = objH;
        f1246d = objH == null ? null : g();
        f1247e = objH != null ? k(objH) : null;
    }

    public static List<Throwable> e(Throwable throwable) {
        throwable.getClass();
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(throwable);
        boolean z10 = false;
        Throwable cause = throwable;
        while (true) {
            throwable = throwable.getCause();
            if (throwable == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(throwable);
            if (throwable == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", throwable);
            }
            if (z10) {
                cause = cause.getCause();
            }
            z10 = !z10;
        }
    }

    @b1.c
    @gm.a
    @b1.d
    public static <X extends Throwable> X f(Throwable throwable, Class<X> expectedCauseType) {
        try {
            return expectedCauseType.cast(throwable.getCause());
        } catch (ClassCastException e10) {
            e10.initCause(throwable);
            throw e10;
        }
    }

    @b1.c
    @gm.a
    @b1.d
    public static Method g() {
        return i("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @b1.c
    @gm.a
    @b1.d
    public static Object h() {
        try {
            return Class.forName(f1244b, false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    @b1.c
    @gm.a
    @b1.d
    public static Method i(String name, Class<?>... parameterTypes) throws ThreadDeath {
        try {
            return Class.forName(f1243a, false, null).getMethod(name, parameterTypes);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable j(Throwable throwable) {
        boolean z10 = false;
        Throwable cause = throwable;
        while (true) {
            Throwable cause2 = throwable.getCause();
            if (cause2 == null) {
                return throwable;
            }
            if (cause2 == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause2);
            }
            if (z10) {
                cause = cause.getCause();
            }
            z10 = !z10;
            throwable = cause2;
        }
    }

    @b1.c
    @gm.a
    @b1.d
    public static Method k(Object jla) {
        try {
            Method methodI = i("getStackTraceDepth", Throwable.class);
            if (methodI == null) {
                return null;
            }
            methodI.invoke(jla, new Throwable());
            return methodI;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @b1.c
    public static String l(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @b1.c
    @b1.d
    public static Object m(Method method, Object receiver, Object... params) {
        try {
            return method.invoke(receiver, params);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw q(e11.getCause());
        }
    }

    @b1.c
    @b1.d
    public static List<StackTraceElement> n(Throwable t10) {
        t10.getClass();
        return new a(t10);
    }

    @b1.c
    @Deprecated
    @b1.d
    public static List<StackTraceElement> o(Throwable throwable) {
        return p() ? n(throwable) : Collections.unmodifiableList(Arrays.asList(throwable.getStackTrace()));
    }

    @b1.c
    @b1.d
    @Deprecated
    public static boolean p() {
        return (f1246d == null || f1247e == null) ? false : true;
    }

    @b1.c
    @t1.a
    @Deprecated
    @b1.d
    public static RuntimeException q(Throwable throwable) {
        w(throwable);
        throw new RuntimeException(throwable);
    }

    @b1.c
    @Deprecated
    @b1.d
    public static <X extends Throwable> void r(@gm.a Throwable throwable, Class<X> declaredType) throws Throwable {
        if (throwable != null) {
            v(throwable, declaredType);
        }
    }

    @b1.c
    @b1.d
    @Deprecated
    public static void s(@gm.a Throwable throwable) {
        if (throwable != null) {
            w(throwable);
        }
    }

    @b1.c
    @b1.d
    public static <X extends Throwable> void t(@gm.a Throwable throwable, Class<X> declaredType) throws Throwable {
        r(throwable, declaredType);
        s(throwable);
    }

    @b1.c
    @b1.d
    public static <X1 extends Throwable, X2 extends Throwable> void u(@gm.a Throwable throwable, Class<X1> declaredType1, Class<X2> declaredType2) throws Throwable {
        declaredType2.getClass();
        r(throwable, declaredType1);
        t(throwable, declaredType2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @b1.c
    @b1.d
    public static <X extends Throwable> void v(Throwable throwable, Class<X> declaredType) throws Throwable {
        throwable.getClass();
        if (declaredType.isInstance(throwable)) {
            throw declaredType.cast(throwable);
        }
    }

    public static void w(Throwable throwable) {
        throwable.getClass();
        if (throwable instanceof RuntimeException) {
            throw ((RuntimeException) throwable);
        }
        if (throwable instanceof Error) {
            throw ((Error) throwable);
        }
    }
}
