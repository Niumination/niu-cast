package an;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kn.l0;
import kn.r1;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public class l {

    @r1({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f414a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        @in.f
        public static final Method f415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        @in.f
        public static final Method f416c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            l0.m(methods);
            int length = methods.length;
            int i10 = 0;
            while (true) {
                method = null;
                if (i10 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i10];
                if (l0.g(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    l0.o(parameterTypes, "getParameterTypes(...)");
                    if (l0.g(nm.r.Bt(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i10++;
            }
            f415b = method2;
            for (Method method3 : methods) {
                if (l0.g(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f416c = method;
        }
    }

    public void a(@os.l Throwable th2, @os.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        l0.p(th2, "cause");
        l0.p(th3, "exception");
        Method method = a.f415b;
        if (method != null) {
            method.invoke(th2, th3);
        }
    }

    @os.l
    public rn.f b() {
        return new rn.b();
    }

    @os.m
    public jq.m c(@os.l MatchResult matchResult, @os.l String str) {
        l0.p(matchResult, "matchResult");
        l0.p(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @os.l
    public List<Throwable> d(@os.l Throwable th2) {
        Object objInvoke;
        List<Throwable> listT;
        l0.p(th2, "exception");
        Method method = a.f416c;
        return (method == null || (objInvoke = method.invoke(th2, null)) == null || (listT = nm.p.t((Throwable[]) objInvoke)) == null) ? k0.INSTANCE : listT;
    }
}
