package vj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/1771")
public final class q1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q1 f17248d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<p1> f17250a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, p1> f17251b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17247c = Logger.getLogger(q1.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable<Class<?>> f17249e = d();

    public static final class a implements x2.b<p1> {
        @Override // vj.x2.b
        public boolean a(p1 p1Var) {
            return p1Var.d();
        }

        @Override // vj.x2.b
        public int b(p1 p1Var) {
            return p1Var.c();
        }

        public int c(p1 p1Var) {
            return p1Var.c();
        }

        public boolean d(p1 p1Var) {
            return p1Var.d();
        }
    }

    public static synchronized q1 c() {
        try {
            if (f17248d == null) {
                List<p1> listF = x2.f(p1.class, f17249e, p1.class.getClassLoader(), new a());
                f17248d = new q1();
                for (p1 p1Var : listF) {
                    f17247c.fine("Service loader found " + p1Var);
                    f17248d.a(p1Var);
                }
                f17248d.g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f17248d;
    }

    @b1.e
    public static List<Class<?>> d() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("wj.f2"));
        } catch (ClassNotFoundException e10) {
            f17247c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e10);
        }
        try {
            arrayList.add(Class.forName("ck.p$a"));
        } catch (ClassNotFoundException e11) {
            f17247c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(p1 p1Var) {
        c1.h0.e(p1Var.d(), "isAvailable() returned false");
        this.f17250a.add(p1Var);
    }

    public synchronized void b(p1 p1Var) {
        this.f17250a.remove(p1Var);
        g();
    }

    @gm.j
    public synchronized p1 e(String str) {
        return this.f17251b.get(c1.h0.F(str, "policy"));
    }

    @b1.e
    public synchronized Map<String, p1> f() {
        return new LinkedHashMap(this.f17251b);
    }

    public final synchronized void g() {
        try {
            this.f17251b.clear();
            for (p1 p1Var : this.f17250a) {
                String strB = p1Var.b();
                p1 p1Var2 = this.f17251b.get(strB);
                if (p1Var2 == null || p1Var2.c() < p1Var.c()) {
                    this.f17251b.put(strB, p1Var);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void h(p1 p1Var) {
        a(p1Var);
        g();
    }
}
