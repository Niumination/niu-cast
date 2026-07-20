package vj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@t0
public final class s2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17258c = Logger.getLogger(s2.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static s2 f17259d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hm.a("this")
    public final LinkedHashSet<r2> f17260a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hm.a("this")
    public List<r2> f17261b = Collections.emptyList();

    public class a implements Comparator<r2> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(r2 r2Var, r2 r2Var2) {
            return r2Var.d() - r2Var2.d();
        }
    }

    public static final class b extends RuntimeException {
        private static final long serialVersionUID = 1;

        public b(String str) {
            super(str);
        }
    }

    public static final class c implements x2.b<r2> {
        public c() {
        }

        @Override // vj.x2.b
        public boolean a(r2 r2Var) {
            return r2Var.b();
        }

        @Override // vj.x2.b
        public int b(r2 r2Var) {
            return r2Var.d();
        }

        public int c(r2 r2Var) {
            return r2Var.d();
        }

        public boolean d(r2 r2Var) {
            return r2Var.b();
        }

        public c(a aVar) {
        }
    }

    public static synchronized s2 c() {
        try {
            if (f17259d == null) {
                List<r2> listF = x2.f(r2.class, d(), r2.class.getClassLoader(), new c());
                f17259d = new s2();
                for (r2 r2Var : listF) {
                    f17258c.fine("Service loader found " + r2Var);
                    f17259d.a(r2Var);
                }
                f17259d.h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f17259d;
    }

    @b1.e
    public static List<Class<?>> d() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.okhttp.OkHttpServerProvider"));
        } catch (ClassNotFoundException e10) {
            f17258c.log(Level.FINE, "Unable to find OkHttpServerProvider", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(r2 r2Var) {
        c1.h0.e(r2Var.b(), "isAvailable() returned false");
        this.f17260a.add(r2Var);
    }

    public synchronized void b(r2 r2Var) {
        this.f17260a.remove(r2Var);
        h();
    }

    public j2<?> e(int i10, n2 n2Var) {
        if (g().isEmpty()) {
            throw new b("No functional server found. Try adding a dependency on the grpc-netty, grpc-netty-shaded, or grpc-okhttp artifact");
        }
        StringBuilder sb2 = new StringBuilder();
        for (r2 r2Var : g()) {
            r2.a aVarC = r2Var.c(i10, n2Var);
            j2<?> j2Var = aVarC.f17256a;
            if (j2Var != null) {
                return j2Var;
            }
            sb2.append("; ");
            sb2.append(r2Var.getClass().getName());
            sb2.append(": ");
            sb2.append(aVarC.f17257b);
        }
        throw new b(sb2.substring(2));
    }

    public r2 f() {
        List<r2> listG = g();
        if (listG.isEmpty()) {
            return null;
        }
        return listG.get(0);
    }

    @b1.e
    public synchronized List<r2> g() {
        return this.f17261b;
    }

    public final synchronized void h() {
        ArrayList arrayList = new ArrayList(this.f17260a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f17261b = Collections.unmodifiableList(arrayList);
    }

    public synchronized void i(r2 r2Var) {
        a(r2Var);
        h();
    }
}
