package xn;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
public class a0 {

    public static class a<T> extends c<T> implements jn.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jn.a<T> f20302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile SoftReference<Object> f20303c;

        public a(@os.m T t10, @os.l jn.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f20303c = null;
            this.f20302b = aVar;
            if (t10 != null) {
                this.f20303c = new SoftReference<>(a(t10));
            }
        }

        public static /* synthetic */ void d(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // xn.a0.c, jn.a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f20303c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T tInvoke = this.f20302b.invoke();
            this.f20303c = new SoftReference<>(a(tInvoke));
            return tInvoke;
        }
    }

    public static class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jn.a<T> f20304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile Object f20305c;

        public b(@os.l jn.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f20305c = null;
            this.f20304b = aVar;
        }

        private static /* synthetic */ void d(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // xn.a0.c, jn.a
        public T invoke() {
            Object obj = this.f20305c;
            if (obj != null) {
                return c(obj);
            }
            T tInvoke = this.f20304b.invoke();
            this.f20305c = a(tInvoke);
            return tInvoke;
        }
    }

    public static abstract class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f20306a = new a();

        public static class a {
        }

        public Object a(T t10) {
            return t10 == null ? f20306a : t10;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T c(Object obj) {
            if (obj == f20306a) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i10 == 1 || i10 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @os.l
    public static <T> b<T> b(@os.l jn.a<T> aVar) {
        if (aVar == null) {
            a(0);
        }
        return new b<>(aVar);
    }

    @os.l
    public static <T> a<T> c(@os.m T t10, @os.l jn.a<T> aVar) {
        if (aVar == null) {
            a(1);
        }
        return new a<>(t10, aVar);
    }

    @os.l
    public static <T> a<T> d(@os.l jn.a<T> aVar) {
        if (aVar == null) {
            a(2);
        }
        return c(null, aVar);
    }
}
