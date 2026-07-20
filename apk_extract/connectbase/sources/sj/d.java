package sj;

import java.io.File;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Callable;
import tj.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15085a = "config.strategy";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15086b = "config.override_with_env_vars";

    public static class a implements Callable<sj.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f15087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f15088b;

        public a(ClassLoader classLoader, q qVar) {
            this.f15087a = classLoader;
            this.f15088b = qVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sj.a call() {
            return d.u(this.f15087a, d.d(this.f15088b));
        }
    }

    public static sj.a A(String str, q qVar, t tVar) {
        q qVarM = m(qVar, "load");
        return v(qVarM.d(), d0(str, qVarM), tVar);
    }

    public static sj.a B(sj.a aVar) {
        return u(a("load"), aVar);
    }

    public static sj.a C(sj.a aVar, t tVar) {
        return v(a("load"), aVar, tVar);
    }

    public static sj.a D(q qVar) {
        return E(qVar, t.b());
    }

    public static sj.a E(q qVar, t tVar) {
        return C(d(m(qVar, "load")), tVar);
    }

    public static Optional<sj.a> F() {
        return H(q.b());
    }

    public static Optional<sj.a> G(ClassLoader classLoader) {
        return H(q.b().j(classLoader));
    }

    public static Optional<sj.a> H(q qVar) {
        ClassLoader classLoaderD = m(qVar, "parseApplicationReplacement").d();
        String property = System.getProperty("config.resource");
        int i10 = property != null ? 1 : 0;
        String property2 = System.getProperty("config.file");
        if (property2 != null) {
            i10++;
        }
        String property3 = System.getProperty("config.url");
        if (property3 != null) {
            i10++;
        }
        if (i10 == 0) {
            return Optional.empty();
        }
        if (i10 > 1) {
            StringBuilder sb2 = new StringBuilder("You set more than one of config.file='");
            sb2.append(property2);
            sb2.append("', config.url='");
            sb2.append(property3);
            sb2.append("', config.resource='");
            throw new c.e(j.c.a(sb2, property, "'; don't know which one to use!"));
        }
        q qVarI = qVar.i(false);
        if (property != null) {
            if (property.startsWith("/")) {
                property = property.substring(1);
            }
            return Optional.of(V(classLoaderD, property, qVarI));
        }
        if (property2 != null) {
            return Optional.of(J(new File(property2), qVarI));
        }
        try {
            return Optional.of(h0(new URL(property3), qVarI));
        } catch (MalformedURLException e10) {
            StringBuilder sbA = e.a.a("Bad URL in config.url system property: '", property3, "': ");
            sbA.append(e10.getMessage());
            throw new c.e(sbA.toString(), e10);
        }
    }

    public static sj.a I(File file) {
        return J(file, q.b());
    }

    public static sj.a J(File file, q qVar) {
        return o0.n(file, qVar).w().toConfig();
    }

    public static sj.a K(File file) {
        return L(file, q.b());
    }

    public static sj.a L(File file, q qVar) {
        return tj.m.C(file, qVar).toConfig();
    }

    public static sj.a M(Map<String, ? extends Object> map) {
        return N(map, null);
    }

    public static sj.a N(Map<String, ? extends Object> map, String str) {
        return tj.m.t(map, str).toConfig();
    }

    public static sj.a O(Properties properties) {
        return P(properties, q.b());
    }

    public static sj.a P(Properties properties, q qVar) {
        return o0.p(properties, qVar).w().toConfig();
    }

    public static sj.a Q(Reader reader) {
        return R(reader, q.b());
    }

    public static sj.a R(Reader reader, q qVar) {
        return o0.q(reader, qVar).w().toConfig();
    }

    public static sj.a S(Class<?> cls, String str) {
        return T(cls, str, q.b());
    }

    public static sj.a T(Class<?> cls, String str, q qVar) {
        return o0.s(cls, str, qVar).w().toConfig();
    }

    public static sj.a U(ClassLoader classLoader, String str) {
        return V(classLoader, str, q.b());
    }

    public static sj.a V(ClassLoader classLoader, String str, q qVar) {
        return X(str, qVar.j(classLoader));
    }

    public static sj.a W(String str) {
        return X(str, q.b());
    }

    public static sj.a X(String str, q qVar) {
        return o0.t(str, m(qVar, "parseResources")).w().toConfig();
    }

    public static sj.a Y(Class<?> cls, String str) {
        return Z(cls, str, q.b());
    }

    public static sj.a Z(Class<?> cls, String str, q qVar) {
        return tj.m.D(cls, str, qVar).toConfig();
    }

    public static ClassLoader a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            return contextClassLoader;
        }
        throw new c.d(m.a.a("Context class loader is not set for the current thread; if Thread.currentThread().getContextClassLoader() returns null, you must pass a ClassLoader explicitly to ConfigFactory.", str));
    }

    public static sj.a a0(ClassLoader classLoader, String str) {
        return b0(classLoader, str, q.b());
    }

    public static sj.a b() {
        return d(q.b());
    }

    public static sj.a b0(ClassLoader classLoader, String str, q qVar) {
        return tj.m.E(str, qVar.j(classLoader)).toConfig();
    }

    public static sj.a c(ClassLoader classLoader) {
        return d(q.b().j(classLoader));
    }

    public static sj.a c0(String str) {
        return d0(str, q.b());
    }

    public static sj.a d(q qVar) {
        return n().a(m(qVar, "defaultApplication"));
    }

    public static sj.a d0(String str, q qVar) {
        return tj.m.E(str, qVar).toConfig();
    }

    public static sj.a e() {
        return o().booleanValue() ? tj.m.p().withFallback((m) tj.m.I()) : tj.m.I();
    }

    public static sj.a e0(String str) {
        return f0(str, q.b());
    }

    public static sj.a f(ClassLoader classLoader) {
        return e();
    }

    public static sj.a f0(String str, q qVar) {
        return o0.u(str, qVar).w().toConfig();
    }

    public static sj.a g() {
        return tj.m.g(a("defaultReference"));
    }

    public static sj.a g0(URL url) {
        return h0(url, q.b());
    }

    public static sj.a h(ClassLoader classLoader) {
        return tj.m.g(classLoader);
    }

    public static sj.a h0(URL url, q qVar) {
        return o0.v(url, qVar).w().toConfig();
    }

    public static sj.a i() {
        return tj.m.h(a("defaultReferenceUnresolved"));
    }

    public static sj.a i0() {
        return tj.m.n();
    }

    public static sj.a j(ClassLoader classLoader) {
        return tj.m.h(classLoader);
    }

    public static sj.a j0() {
        return tj.m.p();
    }

    public static sj.a k() {
        return tj.m.j(null);
    }

    public static sj.a k0() {
        return tj.m.I();
    }

    public static sj.a l(String str) {
        return tj.m.j(str);
    }

    public static q m(q qVar, String str) {
        return qVar.d() == null ? qVar.j(a(str)) : qVar;
    }

    public static k n() {
        String property = System.getProperties().getProperty(f15085a);
        if (property == null) {
            return new b0();
        }
        try {
            return (k) k.class.cast(Class.forName(property).newInstance());
        } catch (Throwable th2) {
            throw new c.d("Failed to load strategy: ".concat(property), th2);
        }
    }

    public static Boolean o() {
        return Boolean.valueOf(Boolean.parseBoolean(System.getProperties().getProperty(f15086b)));
    }

    public static void p() {
        tj.m.H();
        tj.m.F();
        tj.m.G();
    }

    public static sj.a q() {
        return r(a("load"));
    }

    public static sj.a r(ClassLoader classLoader) {
        return tj.m.e(classLoader, "load", new a(classLoader, q.b().j(classLoader)));
    }

    public static sj.a s(ClassLoader classLoader, String str) {
        return A(str, q.b().j(classLoader), t.b());
    }

    public static sj.a t(ClassLoader classLoader, String str, q qVar, t tVar) {
        return A(str, qVar.j(classLoader), tVar);
    }

    public static sj.a u(ClassLoader classLoader, sj.a aVar) {
        return v(classLoader, aVar, t.b());
    }

    public static sj.a v(ClassLoader classLoader, sj.a aVar, t tVar) {
        return e().withFallback((m) aVar).withFallback((m) tj.m.h(classLoader)).resolve(tVar);
    }

    public static sj.a w(ClassLoader classLoader, q qVar) {
        return D(qVar.j(classLoader));
    }

    public static sj.a x(ClassLoader classLoader, q qVar, t tVar) {
        return v(classLoader, d(m(qVar, "load")), tVar);
    }

    public static sj.a y(ClassLoader classLoader, t tVar) {
        return x(classLoader, q.b(), tVar);
    }

    public static sj.a z(String str) {
        return A(str, q.b(), t.b());
    }
}
