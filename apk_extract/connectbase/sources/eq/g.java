package eq;

import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4680a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f4681b = false;

    public static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f4682a;

        public /* synthetic */ b(Throwable th2, a aVar) {
            this(th2);
        }

        public static /* synthetic */ void a(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i10 != 1) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @l
        public Throwable b() {
            Throwable th2 = this.f4682a;
            if (th2 == null) {
                a(1);
            }
            return th2;
        }

        public String toString() {
            return this.f4682a.toString();
        }

        public b(@l Throwable th2) {
            if (th2 == null) {
                a(0);
            }
            this.f4682a = th2;
        }
    }

    public static class c extends RuntimeException {
        public c(Throwable th2) {
            super("Rethrow stored exception", th2);
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i10 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i10 == 1 || i10 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i10 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @l
    public static <V> Object b(@m V v10) {
        if (v10 == null && (v10 = (V) f4680a) == null) {
            a(1);
        }
        return v10;
    }

    @l
    public static Object c(@l Throwable th2) {
        if (th2 == null) {
            a(3);
        }
        return new b(th2);
    }

    @m
    public static <V> V d(@l Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static <V> V e(@l Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == f4680a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static <V> V f(@m Object obj) throws Throwable {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable thB = ((b) obj).b();
        if (f4681b && eq.c.a(thB)) {
            throw new c(thB);
        }
        l0.p(thB, "e");
        throw thB;
    }
}
