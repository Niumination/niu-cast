package xn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Class<?> f20311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<Method> f20312b;

        /* JADX INFO: renamed from: xn.d$a$a, reason: collision with other inner class name */
        public static final class C0519a extends n0 implements jn.l<Method, CharSequence> {
            public static final C0519a INSTANCE = new C0519a();

            public C0519a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final CharSequence invoke(Method method) {
                Class<?> returnType = method.getReturnType();
                l0.o(returnType, "it.returnType");
                return ko.d.b(returnType);
            }
        }

        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return rm.g.l(((Method) t10).getName(), ((Method) t11).getName());
            }
        }

        public a(@os.l Class<?> cls) {
            l0.p(cls, "jClass");
            this.f20311a = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            l0.o(declaredMethods, "jClass.declaredMethods");
            this.f20312b = nm.r.Mv(declaredMethods, new b());
        }

        @Override // xn.d
        @os.l
        public String a() {
            return nm.h0.m3(this.f20312b, "", "<init>(", ")V", 0, null, C0519a.INSTANCE, 24, null);
        }

        @os.l
        public final List<Method> b() {
            return this.f20312b;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Constructor<?> f20313a;

        public static final class a extends n0 implements jn.l<Class<?>, CharSequence> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final CharSequence invoke(Class<?> cls) {
                l0.o(cls, "it");
                return ko.d.b(cls);
            }
        }

        public b(@os.l Constructor<?> constructor) {
            l0.p(constructor, "constructor");
            this.f20313a = constructor;
        }

        @Override // xn.d
        @os.l
        public String a() {
            Class<?>[] parameterTypes = this.f20313a.getParameterTypes();
            l0.o(parameterTypes, "constructor.parameterTypes");
            return nm.r.lh(parameterTypes, "", "<init>(", ")V", 0, null, a.INSTANCE, 24, null);
        }

        @os.l
        public final Constructor<?> b() {
            return this.f20313a;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Method f20314a;

        public c(@os.l Method method) {
            l0.p(method, "method");
            this.f20314a = method;
        }

        @Override // xn.d
        @os.l
        public String a() {
            return e0.b(this.f20314a);
        }

        @os.l
        public final Method b() {
            return this.f20314a;
        }
    }

    /* JADX INFO: renamed from: xn.d$d, reason: collision with other inner class name */
    public static final class C0520d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final cp.d.b f20315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final String f20316b;

        public C0520d(@os.l cp.d.b bVar) {
            l0.p(bVar, "signature");
            this.f20315a = bVar;
            this.f20316b = bVar.a();
        }

        @Override // xn.d
        @os.l
        public String a() {
            return this.f20316b;
        }

        @os.l
        public final String b() {
            return this.f20315a.f3368b;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final cp.d.b f20317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final String f20318b;

        public e(@os.l cp.d.b bVar) {
            l0.p(bVar, "signature");
            this.f20317a = bVar;
            this.f20318b = bVar.a();
        }

        @Override // xn.d
        @os.l
        public String a() {
            return this.f20318b;
        }

        @os.l
        public final String b() {
            return this.f20317a.f3368b;
        }

        @os.l
        public final String c() {
            return this.f20317a.f3367a;
        }
    }

    public d() {
    }

    @os.l
    public abstract String a();

    public d(kn.w wVar) {
    }
}
