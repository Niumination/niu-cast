package tj;

import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15648a = "CONFIG_FORCE_";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final sj.o f15649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final tj.g f15650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final tj.g f15651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f15652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e1 f15653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f1 f15654g;

    public static class a implements Callable<sj.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f15655a;

        public a(ClassLoader classLoader) {
            this.f15655a = classLoader;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sj.a call() {
            return m.I().withFallback((sj.m) m.O(this.f15655a)).resolve();
        }
    }

    public static class b implements Callable<sj.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f15656a;

        public b(ClassLoader classLoader) {
            this.f15656a = classLoader;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sj.a call() {
            return o0.t("reference.conf", sj.q.b().j(this.f15656a)).w().toConfig();
        }
    }

    public static class c implements i1.a {
        @Override // tj.i1.a
        public sj.r a(String str, sj.q qVar) {
            return o0.t(str, qVar);
        }
    }

    public static class d implements i1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f15657a;

        public d(Class<?> cls) {
            this.f15657a = cls;
        }

        @Override // tj.i1.a
        public sj.r a(String str, sj.q qVar) {
            return o0.s(this.f15657a, str, qVar);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f15658a = "loads";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f15659b = "substitutions";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Map<String, Boolean> f15660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f15661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final boolean f15662e;

        static {
            Map<String, Boolean> mapA = a();
            f15660c = mapA;
            f15661d = mapA.get(f15658a).booleanValue();
            f15662e = mapA.get(f15659b).booleanValue();
        }

        public static Map<String, Boolean> a() {
            HashMap map = new HashMap();
            String str = f15658a;
            Boolean bool = Boolean.FALSE;
            map.put(str, bool);
            map.put(f15659b, bool);
            String property = System.getProperty("config.trace");
            if (property == null) {
                return map;
            }
            for (String str2 : property.split(ks.g.f9491d)) {
                if (str2.equals(f15658a)) {
                    map.put(f15658a, Boolean.TRUE);
                } else if (str2.equals(f15659b)) {
                    map.put(f15659b, Boolean.TRUE);
                } else {
                    System.err.println("config.trace property contains unknown trace topic '" + str2 + "'");
                }
            }
            return map;
        }

        public static boolean b() {
            return f15661d;
        }

        public static boolean c() {
            return f15662e;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final sj.f f15663a = new i1(null);
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile tj.c f15664a = m.w();
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile tj.c f15665a = m.x();
    }

    public static class i implements i1.a {
        @Override // tj.i1.a
        public sj.r a(String str, sj.q qVar) {
            return o0.n(new File(str), qVar);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public sj.a f15666a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<ClassLoader> f15667b = new WeakReference<>(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, sj.a> f15668c = new HashMap();

        public synchronized sj.a a(ClassLoader classLoader, String str, Callable<sj.a> callable) {
            sj.a aVarCall;
            try {
                if (classLoader != this.f15667b.get()) {
                    this.f15668c.clear();
                    this.f15667b = new WeakReference<>(classLoader);
                }
                sj.a aVarI = m.I();
                if (aVarI != this.f15666a) {
                    this.f15668c.clear();
                    this.f15666a = aVarI;
                }
                aVarCall = this.f15668c.get(str);
                if (aVarCall == null) {
                    try {
                        try {
                            aVarCall = callable.call();
                            if (aVarCall == null) {
                                throw new sj.c.d("null config from cache updater");
                            }
                            this.f15668c.put(str, aVarCall);
                        } catch (Exception e10) {
                            throw new sj.c.e(e10.getMessage(), e10);
                        }
                    } catch (RuntimeException e11) {
                        throw e11;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return aVarCall;
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f15669a = new j();
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile tj.c f15670a = m.y();
    }

    static {
        g1 g1VarT = g1.t("hardcoded value");
        f15649b = g1VarT;
        f15650c = new tj.g(g1VarT, true);
        f15651d = new tj.g(g1VarT, false);
        f15652e = new c0(g1VarT);
        f15653f = new e1(g1VarT, Collections.emptyList());
        f15654g = f1.empty(g1VarT);
    }

    public static sj.o A(String str) {
        return str == null ? f15649b : g1.t(str);
    }

    public static sj.o B(URL url) {
        return g1.u(url);
    }

    public static sj.n C(File file, sj.q qVar) {
        return i1.g(new i(), file.getPath(), qVar);
    }

    public static sj.n D(Class<?> cls, String str, sj.q qVar) {
        return i1.g(new d(cls), str, qVar);
    }

    public static sj.n E(String str, sj.q qVar) {
        return i1.g(new c(), str, qVar);
    }

    public static void F() {
        g.f15664a = w();
    }

    public static void G() {
        h.f15665a = x();
    }

    public static void H() {
        l.f15670a = y();
    }

    public static sj.a I() {
        return J().toConfig();
    }

    public static tj.c J() {
        try {
            return l.f15670a;
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static void K(int i10, String str) {
        while (i10 > 0) {
            System.err.print("  ");
            i10--;
        }
        System.err.println(str);
    }

    public static void L(String str) {
        System.err.println(str);
    }

    public static boolean M() {
        try {
            return e.b();
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static boolean N() {
        try {
            return e.c();
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static sj.a O(ClassLoader classLoader) {
        return e(classLoader, "unresolvedReference", new b(classLoader));
    }

    public static sj.o P(String str) {
        return str == null ? f15649b : g1.t(str);
    }

    public static sj.a e(ClassLoader classLoader, String str, Callable<sj.a> callable) {
        try {
            return k.f15669a.a(classLoader, str, callable);
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static sj.f f() {
        try {
            return f.f15663a;
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static sj.a g(ClassLoader classLoader) {
        return e(classLoader, "defaultReference", new a(classLoader));
    }

    public static sj.a h(ClassLoader classLoader) {
        try {
            g(classLoader);
            return O(classLoader);
        } catch (sj.c.k e10) {
            throw e10.addExtraDetail("Could not resolve substitution in reference.conf to a value: %s. All reference.conf files are required to be fully, independently resolvable, and should not require the presence of values for substitutions from further up the hierarchy.");
        }
    }

    public static tj.c i(sj.o oVar) {
        return m(oVar);
    }

    public static sj.a j(String str) {
        return l(str).toConfig();
    }

    public static e1 k(sj.o oVar) {
        return (oVar == null || oVar == f15649b) ? f15653f : new e1(oVar, Collections.emptyList());
    }

    public static tj.c l(String str) {
        return m(str != null ? g1.t(str) : null);
    }

    public static tj.c m(sj.o oVar) {
        return oVar == f15649b ? f15654g : f1.empty(oVar);
    }

    public static sj.a n() {
        return o().toConfig();
    }

    public static tj.c o() {
        try {
            return g.f15664a;
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static sj.a p() {
        return q().toConfig();
    }

    public static tj.c q() {
        try {
            return h.f15665a;
        } catch (ExceptionInInitializerError e10) {
            throw n.c(e10);
        }
    }

    public static sj.x r(Object obj, String str) {
        return s(obj, P(str), j0.KEYS_ARE_KEYS);
    }

    public static tj.d s(Object obj, sj.o oVar, j0 j0Var) {
        if (oVar == null) {
            throw new sj.c.d("origin not supposed to be null");
        }
        if (obj == null) {
            return oVar != f15649b ? new c0(oVar) : f15652e;
        }
        if (obj instanceof tj.d) {
            return (tj.d) obj;
        }
        if (obj instanceof Boolean) {
            if (oVar != f15649b) {
                return new tj.g(oVar, ((Boolean) obj).booleanValue());
            }
            return ((Boolean) obj).booleanValue() ? f15650c : f15651d;
        }
        if (obj instanceof String) {
            return new g0.a(oVar, (String) obj);
        }
        if (obj instanceof Number) {
            if (obj instanceof Double) {
                return new tj.l(oVar, ((Double) obj).doubleValue(), null);
            }
            if (obj instanceof Integer) {
                return new p(oVar, ((Integer) obj).intValue(), null);
            }
            return obj instanceof Long ? new q(oVar, ((Long) obj).longValue(), null) : d0.newNumber(oVar, ((Number) obj).doubleValue(), (String) null);
        }
        if (obj instanceof Duration) {
            return new q(oVar, ((Duration) obj).toMillis(), null);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof Iterable)) {
                if (obj instanceof sj.l) {
                    return new q(oVar, ((sj.l) obj).c(), null);
                }
                throw new sj.c.d(c0.a.a("bug in method caller: not valid to create ConfigValue from: ", obj));
            }
            Iterator it = ((Iterable) obj).iterator();
            if (!it.hasNext()) {
                return k(oVar);
            }
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                arrayList.add(s(it.next(), oVar, j0Var));
            }
            return new e1(oVar, arrayList);
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            return m(oVar);
        }
        if (j0Var != j0.KEYS_ARE_KEYS) {
            return s0.c(oVar, map);
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String)) {
                throw new sj.c.d(c0.a.a("bug in method caller: not valid to create ConfigObject from map with non-String key: ", key));
            }
            map2.put((String) key, s(entry.getValue(), oVar, j0Var));
        }
        return new f1(oVar, map2);
    }

    public static sj.n t(Map<String, ? extends Object> map, String str) {
        return (sj.n) s(map, P(str), j0.KEYS_ARE_PATHS);
    }

    public static Properties u() {
        Properties properties = System.getProperties();
        Properties properties2 = new Properties();
        synchronized (properties) {
            try {
                for (Map.Entry entry : properties.entrySet()) {
                    if (!entry.getKey().toString().startsWith("java.version.")) {
                        properties2.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return properties2;
    }

    public static sj.c.h v(p0 p0Var, sj.c.h hVar) {
        String str = p0Var.k() + " has not been resolved, you need to call Config#resolve(), see API docs for Config#resolve()";
        return str.equals(hVar.getMessage()) ? hVar : new sj.c.h(str, hVar);
    }

    public static tj.c w() {
        return s0.f(A("env variables"), System.getenv());
    }

    public static tj.c x() {
        HashMap map = new HashMap(System.getenv());
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (str.startsWith(f15648a)) {
                map2.put(n.a(str, f15648a), map.get(str));
            }
        }
        return s0.f(A("env variables overrides"), map2);
    }

    public static tj.c y() {
        return (tj.c) o0.p(u(), sj.q.b().l("system properties")).w();
    }

    public static sj.o z(String str) {
        return g1.q(str);
    }
}
