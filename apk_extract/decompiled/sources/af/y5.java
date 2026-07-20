package af;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.b9;

/* JADX INFO: loaded from: classes3.dex */
public final class y5 extends ze.f0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f722r = Logger.getLogger(y5.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a8.a f723s = new a8.a(l1.f425t, 3);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final x5 f724t = new x5();
    public static final ze.b0 u = ze.b0.f11324d;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ze.p f725v = ze.p.f11394b;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f726w = TimeUnit.SECONDS.toMillis(120);
    public final a4.b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final se.e f727a = new se.e(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f728b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f729c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f730d = new ArrayList();
    public final x5 f = f724t;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a8.a f731g = f723s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ze.b0 f732h = u;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ze.p f733i = f725v;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f734j = f726w;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ze.p2 f735k = ze.z.f11480d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f736l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f737m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f738n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f739o = true;
    public final ze.o0 p = ze.o0.f11389g;
    public final k2 q = r.e;

    public y5(a4.b bVar) {
        this.e = bVar;
    }

    public final ze.f0 n(p2.d dVar) {
        ze.m2 m2Var = qa.g.f8974b;
        if (m2Var == null) {
            synchronized (qa.g.class) {
                try {
                    m2Var = qa.g.f8974b;
                    if (m2Var == null) {
                        tc.d dVarA = ze.m2.a("lifecycle._LifecycleService");
                        dVarA.f(qa.g.a());
                        ze.m2 m2Var2 = new ze.m2(dVarA);
                        qa.g.f8974b = m2Var2;
                        m2Var = m2Var2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        u6.a aVar = new u6.a(m2Var);
        aVar.u(qa.g.a(), b9.a(new tj.x(dVar)));
        ze.l2 l2VarW = aVar.w();
        ((LinkedHashMap) this.f727a.f9720b).put(l2VarW.f11373a.f11383a, l2VarW);
        return this;
    }

    public final ze.b2 o() {
        a4.b bVar = this.e;
        ArrayList arrayList = new ArrayList();
        synchronized (ze.f0.class) {
        }
        synchronized (ze.f0.class) {
        }
        if (this.f736l) {
            try {
                Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class cls2 = Boolean.TYPE;
                if (cls.getDeclaredMethod("getServerStreamTracerFactory", cls2, cls2, cls2).invoke(null, Boolean.valueOf(this.f737m), Boolean.valueOf(this.f738n), Boolean.FALSE) != null) {
                    throw new ClassCastException();
                }
            } catch (ClassNotFoundException e) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e);
            } catch (IllegalAccessException e4) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            } catch (NoSuchMethodException e10) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
            } catch (InvocationTargetException e11) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
            }
        }
        if (this.f739o) {
            try {
                if (Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getServerStreamTracerFactory", null).invoke(null, null) != null) {
                    throw new ClassCastException();
                }
            } catch (ClassNotFoundException e12) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e12);
            } catch (IllegalAccessException e13) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e13);
            } catch (NoSuchMethodException e14) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e14);
            } catch (InvocationTargetException e15) {
                f722r.log(Level.FINE, "Unable to apply census stats", (Throwable) e15);
            }
        }
        arrayList.addAll(this.f730d);
        arrayList.trimToSize();
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        cf.y yVar = (cf.y) bVar.f33b;
        yVar.getClass();
        return new w5(this, new cf.x(yVar, listUnmodifiableList, yVar.f1658a.p), ze.y.e);
    }
}
