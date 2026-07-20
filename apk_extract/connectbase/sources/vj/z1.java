package vj;

import f1.k3;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/4159")
public final class z1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f17573e = Logger.getLogger(z1.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static z1 f17574f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17575g = "unknown";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.d f17576a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hm.a("this")
    public String f17577b = "unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hm.a("this")
    public final LinkedHashSet<y1> f17578c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hm.a("this")
    public k3<String, y1> f17579d = k3.of();

    public final class b extends x1.d {
        public b() {
        }

        @Override // vj.x1.d
        public String a() {
            return z1.this.e();
        }

        @Override // vj.x1.d
        @gm.j
        public x1 b(URI uri, x1.b bVar) {
            y1 y1VarG = z1.this.g(uri.getScheme());
            if (y1VarG == null) {
                return null;
            }
            return y1VarG.b(uri, bVar);
        }
    }

    public static final class c implements x2.b<y1> {
        public c() {
        }

        @Override // vj.x2.b
        public boolean a(y1 y1Var) {
            return y1Var.e();
        }

        @Override // vj.x2.b
        public int b(y1 y1Var) {
            return y1Var.f();
        }

        public int c(y1 y1Var) {
            return y1Var.f();
        }

        public boolean d(y1 y1Var) {
            return y1Var.e();
        }

        public c(a aVar) {
        }
    }

    public static synchronized z1 d() {
        try {
            if (f17574f == null) {
                List<y1> listF = x2.f(y1.class, f(), y1.class.getClassLoader(), new c());
                if (listF.isEmpty()) {
                    f17573e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f17574f = new z1();
                for (y1 y1Var : listF) {
                    f17573e.fine("Service loader found " + y1Var);
                    f17574f.a(y1Var);
                }
                f17574f.i();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f17574f;
    }

    @b1.e
    public static List<Class<?>> f() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("wj.g0"));
        } catch (ClassNotFoundException e10) {
            f17573e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(y1 y1Var) {
        c1.h0.e(y1Var.e(), "isAvailable() returned false");
        this.f17578c.add(y1Var);
    }

    public x1.d b() {
        return this.f17576a;
    }

    public synchronized void c(y1 y1Var) {
        this.f17578c.remove(y1Var);
        i();
    }

    public synchronized String e() {
        return this.f17577b;
    }

    public y1 g(String str) {
        if (str == null) {
            return null;
        }
        return h().get(str.toLowerCase(Locale.US));
    }

    @b1.e
    public synchronized Map<String, y1> h() {
        return this.f17579d;
    }

    public final synchronized void i() {
        try {
            HashMap map = new HashMap();
            String strD = "unknown";
            int iF = Integer.MIN_VALUE;
            for (y1 y1Var : this.f17578c) {
                String strD2 = y1Var.d();
                y1 y1Var2 = (y1) map.get(strD2);
                if (y1Var2 == null || y1Var2.f() < y1Var.f()) {
                    map.put(strD2, y1Var);
                }
                if (iF < y1Var.f()) {
                    iF = y1Var.f();
                    strD = y1Var.d();
                }
            }
            this.f17579d = k3.copyOf((Map) map);
            this.f17577b = strD;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void j(y1 y1Var) {
        a(y1Var);
        i();
    }
}
