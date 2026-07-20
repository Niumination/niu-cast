package af;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class k3 extends ze.f1 {
    public static final Method D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8.a f382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a8.a f383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.v1 f385d;
    public final String e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ze.b0 f386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ze.p f387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ze.o0 f394o;
    public final boolean p;
    public final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f395r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f396s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f397t;
    public final boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o5.c f398v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a8.a f399w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Logger f379x = Logger.getLogger(k3.class.getName());

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f380y = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f381z = TimeUnit.SECONDS.toMillis(1);
    public static final a8.a A = new a8.a(l1.f425t, 3);
    public static final ze.b0 B = ze.b0.f11324d;
    public static final ze.p C = ze.p.f11394b;

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e) {
            f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e);
            declaredMethod = null;
        } catch (NoSuchMethodException e4) {
            f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            declaredMethod = null;
        }
        D = declaredMethod;
    }

    public k3(String str, o5.c cVar, a8.a aVar) {
        ze.v1 v1Var;
        a8.a aVar2 = A;
        this.f382a = aVar2;
        this.f383b = aVar2;
        this.f384c = new ArrayList();
        Logger logger = ze.v1.f11453d;
        synchronized (ze.v1.class) {
            try {
                if (ze.v1.e == null) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        boolean z2 = c1.f199a;
                        arrayList.add(c1.class);
                    } catch (ClassNotFoundException e) {
                        ze.v1.f11453d.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
                    }
                    List<ze.u1> listE = ze.f0.e(ze.u1.class, Collections.unmodifiableList(arrayList), ze.u1.class.getClassLoader(), new ze.p2(6));
                    if (listE.isEmpty()) {
                        ze.v1.f11453d.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                    }
                    ze.v1.e = new ze.v1();
                    for (ze.u1 u1Var : listE) {
                        ze.v1.f11453d.fine("Service loader found " + u1Var);
                        ze.v1 v1Var2 = ze.v1.e;
                        synchronized (v1Var2) {
                            v8.c("isAvailable() returned false", u1Var.b());
                            v1Var2.f11455b.add(u1Var);
                        }
                    }
                    ze.v1.e.a();
                }
                v1Var = ze.v1.e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f385d = v1Var;
        this.f = "pick_first";
        this.f386g = B;
        this.f387h = C;
        this.f388i = f380y;
        this.f389j = 5;
        this.f390k = 5;
        this.f391l = 16777216L;
        this.f392m = 1048576L;
        this.f393n = true;
        this.f394o = ze.o0.f11389g;
        this.p = true;
        this.q = true;
        this.f395r = true;
        this.f396s = true;
        this.f397t = true;
        this.u = true;
        v8.i(str, TypedValues.AttributesType.S_TARGET);
        this.e = str;
        this.f398v = cVar;
        this.f399w = aVar;
    }

    @Override // ze.f1
    public final ze.e1 a() {
        SSLSocketFactory sSLSocketFactory;
        Method method;
        cf.k kVar = (cf.k) this.f398v.f8405a;
        boolean z2 = kVar.f1579h != Long.MAX_VALUE;
        int i8 = cf.h.f1534b[kVar.f1578g.ordinal()];
        if (i8 == 1) {
            sSLSocketFactory = null;
        } else {
            if (i8 != 2) {
                throw new RuntimeException("Unknown negotiation type: " + kVar.f1578g);
            }
            try {
                if (kVar.e == null) {
                    kVar.e = SSLContext.getInstance("Default", df.k.f4455d.f4456a).getSocketFactory();
                }
                sSLSocketFactory = kVar.e;
            } catch (GeneralSecurityException e) {
                throw new RuntimeException("TLS Provider failure", e);
            }
        }
        cf.j jVar = new cf.j(kVar.f1576c, kVar.f1577d, sSLSocketFactory, kVar.f, kVar.f1582k, z2, kVar.f1579h, kVar.f1580i, kVar.f1581j, kVar.f1583l, kVar.f1575b);
        k2 k2Var = new k2(8);
        a8.a aVar = new a8.a(l1.f425t, 3);
        k2 k2Var2 = l1.f426v;
        ArrayList arrayList = new ArrayList(this.f384c);
        synchronized (ze.f0.class) {
        }
        if (this.q && (method = D) != null) {
            try {
                if (method.invoke(null, Boolean.valueOf(this.f395r), Boolean.valueOf(this.f396s), Boolean.FALSE, Boolean.valueOf(this.f397t)) != null) {
                    throw new ClassCastException();
                }
            } catch (IllegalAccessException e4) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            } catch (InvocationTargetException e10) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
            }
        }
        if (this.u) {
            try {
                if (Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", null).invoke(null, null) != null) {
                    throw new ClassCastException();
                }
            } catch (ClassNotFoundException e11) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
            } catch (IllegalAccessException e12) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e12);
            } catch (NoSuchMethodException e13) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e13);
            } catch (InvocationTargetException e14) {
                f379x.log(Level.FINE, "Unable to apply census stats", (Throwable) e14);
            }
        }
        return new m3(new j3(this, jVar, k2Var, aVar, k2Var2, arrayList));
    }
}
