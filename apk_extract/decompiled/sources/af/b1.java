package af;

import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;
import k3.w8;
import k3.x8;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends ze.i {
    public static String A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Logger f161v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Set f162w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f163x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f164y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f165z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j4 f166d;
    public final Random e = new Random();
    public volatile y0 f = y0.INSTANCE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f167g = new AtomicReference();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k2 f171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ze.v2 f173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z4 f174n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f175o;
    public boolean p;
    public Executor q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k5 f177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f178t;
    public ze.f0 u;

    static {
        Logger logger = Logger.getLogger(b1.class.getName());
        f161v = logger;
        f162w = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f163x = Boolean.parseBoolean(property);
        f164y = Boolean.parseBoolean(property2);
        f165z = Boolean.parseBoolean(property3);
        try {
            try {
                try {
                    if (Class.forName("af.g2", true, b1.class.getClassLoader()).asSubclass(a1.class).getConstructor(null).newInstance(null) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                }
            } catch (Exception e4) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e4);
            }
        } catch (ClassCastException e10) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e10);
        } catch (ClassNotFoundException e11) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e11);
        }
    }

    public b1(String str, jj.g gVar, k2 k2Var, z4 z4Var, boolean z2) {
        v8.i(gVar, "args");
        this.f171k = k2Var;
        v8.i(str, "name");
        URI uriCreate = URI.create("//".concat(str));
        v8.d("Invalid DNS name: %s", uriCreate.getHost() != null, str);
        String authority = uriCreate.getAuthority();
        if (authority == null) {
            throw new NullPointerException(w8.a("nameUri (%s) doesn't have an authority", uriCreate));
        }
        this.f168h = authority;
        this.f169i = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f170j = gVar.f6330b;
        } else {
            this.f170j = uriCreate.getPort();
        }
        j4 j4Var = (j4) gVar.f6331c;
        v8.i(j4Var, "proxyDetector");
        this.f166d = j4Var;
        long nanos = 0;
        if (!z2) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j8 = 30;
            if (property != null) {
                try {
                    j8 = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    f161v.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j8 > 0 ? TimeUnit.SECONDS.toNanos(j8) : j8;
        }
        this.f172l = nanos;
        this.f174n = z4Var;
        ze.v2 v2Var = (ze.v2) gVar.f6332d;
        v8.i(v2Var, "syncContext");
        this.f173m = v2Var;
        z2 z2Var = (z2) gVar.f6334h;
        this.q = z2Var;
        this.f176r = z2Var == null;
        k5 k5Var = (k5) gVar.e;
        v8.i(k5Var, "serviceConfigParser");
        this.f177s = k5Var;
    }

    public static Map v(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            x8.a("Bad key: %s", f162w.contains(entry.getKey()), entry);
        }
        List listD = j2.d("clientLanguage", map);
        if (listD != null && !listD.isEmpty()) {
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                if ("java".equalsIgnoreCase((String) it.next())) {
                }
            }
            return null;
        }
        Double dE = j2.e("percentage", map);
        if (dE != null) {
            int iIntValue = dE.intValue();
            x8.a("Bad percentage: %s", iIntValue >= 0 && iIntValue <= 100, dE);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List listD2 = j2.d("clientHostname", map);
        if (listD2 != null && !listD2.isEmpty()) {
            Iterator it2 = listD2.iterator();
            while (it2.hasNext()) {
                if (((String) it2.next()).equals(str)) {
                }
            }
            return null;
        }
        Map mapG = j2.g("serviceConfig", map);
        if (mapG != null) {
            return mapG;
        }
        throw new h4.w(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static ArrayList w(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                String strSubstring = str.substring(12);
                Logger logger = i2.f324a;
                d5.b bVar = new d5.b(new StringReader(strSubstring));
                try {
                    Object objA = i2.a(bVar);
                    try {
                        bVar.close();
                    } catch (IOException e) {
                        logger.log(Level.WARNING, "Failed to close", (Throwable) e);
                    }
                    if (!(objA instanceof List)) {
                        throw new ClassCastException(a1.a.p(objA, "wrong type "));
                    }
                    List list2 = (List) objA;
                    j2.a(list2);
                    arrayList.addAll(list2);
                } catch (Throwable th2) {
                    try {
                        bVar.close();
                    } catch (IOException e4) {
                        logger.log(Level.WARNING, "Failed to close", (Throwable) e4);
                    }
                    throw th2;
                }
            } else {
                f161v.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    @Override // ze.i
    public final String e() {
        return this.f168h;
    }

    @Override // ze.i
    public final void n() {
        v8.n(this.u != null, "not started");
        x();
    }

    @Override // ze.i
    public final void p() {
        if (this.p) {
            return;
        }
        this.p = true;
        Executor executor = this.q;
        if (executor == null || !this.f176r) {
            return;
        }
        g6.b(this.f171k, executor);
        this.q = null;
    }

    @Override // ze.i
    public final void q(ze.f0 f0Var) {
        v8.n(this.u == null, "already started");
        if (this.f176r) {
            this.q = (Executor) g6.a(this.f171k);
        }
        this.u = f0Var;
        x();
    }

    public final u6.a u() {
        ze.s1 s1Var;
        ze.s1 s1Var2;
        List listW;
        ze.s1 s1Var3;
        String str = this.f169i;
        u6.a aVar = new u6.a(1, false);
        try {
            aVar.f10379c = y();
            if (f165z) {
                List listEmptyList = Collections.emptyList();
                boolean z2 = false;
                if (f163x) {
                    if ("localhost".equalsIgnoreCase(str)) {
                        z2 = f164y;
                    } else if (!str.contains(":")) {
                        boolean z3 = true;
                        for (int i8 = 0; i8 < str.length(); i8++) {
                            char cCharAt = str.charAt(i8);
                            if (cCharAt != '.') {
                                z3 &= cCharAt >= '0' && cCharAt <= '9';
                            }
                        }
                        z2 = !z3;
                    }
                }
                if (z2 && this.f167g.get() != null) {
                    throw new ClassCastException();
                }
                Object s1Var4 = null;
                if (listEmptyList.isEmpty()) {
                    f161v.log(Level.FINE, "No TXT records found for {0}", new Object[]{str});
                } else {
                    Random random = this.e;
                    if (A == null) {
                        try {
                            A = InetAddress.getLocalHost().getHostName();
                        } catch (UnknownHostException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String str2 = A;
                    try {
                        Iterator it = w(listEmptyList).iterator();
                        Map mapV = null;
                        while (it.hasNext()) {
                            try {
                                mapV = v((Map) it.next(), random, str2);
                                if (mapV != null) {
                                    break;
                                }
                            } catch (RuntimeException e4) {
                                s1Var = new ze.s1(ze.q2.f11404g.h("failed to pick service config choice").g(e4));
                            }
                        }
                        s1Var = mapV == null ? null : new ze.s1(mapV);
                    } catch (IOException | RuntimeException e10) {
                        s1Var = new ze.s1(ze.q2.f11404g.h("failed to parse TXT records").g(e10));
                    }
                    if (s1Var != null) {
                        ze.q2 q2Var = s1Var.f11433a;
                        if (q2Var != null) {
                            s1Var4 = new ze.s1(q2Var);
                        } else {
                            Map map = (Map) s1Var.f11434b;
                            k5 k5Var = this.f177s;
                            k5Var.getClass();
                            try {
                                l6 l6Var = k5Var.f404d;
                                l6Var.getClass();
                                if (map != null) {
                                    try {
                                        listW = d6.w(d6.q(map));
                                    } catch (RuntimeException e11) {
                                        s1Var3 = new ze.s1(ze.q2.f11404g.h("can't parse load balancer configuration").g(e11));
                                    }
                                } else {
                                    listW = null;
                                }
                                s1Var3 = (listW == null || listW.isEmpty()) ? null : d6.u(listW, (ze.d1) l6Var.f446b);
                                if (s1Var3 != null) {
                                    ze.q2 q2Var2 = s1Var3.f11433a;
                                    if (q2Var2 != null) {
                                        s1Var4 = new ze.s1(q2Var2);
                                    } else {
                                        s1Var4 = s1Var3.f11434b;
                                    }
                                }
                                s1Var2 = new ze.s1(p3.a(map, k5Var.f401a, k5Var.f402b, k5Var.f403c, s1Var4));
                            } catch (RuntimeException e12) {
                                s1Var2 = new ze.s1(ze.q2.f11404g.h("failed to parse service config").g(e12));
                            }
                            s1Var4 = s1Var2;
                        }
                    }
                }
                aVar.f10380d = s1Var4;
            }
            return aVar;
        } catch (Exception e13) {
            aVar.f10378b = ze.q2.f11411n.h("Unable to resolve host " + str).g(e13);
            return aVar;
        }
    }

    public final void x() {
        if (this.f178t || this.p) {
            return;
        }
        if (this.f175o) {
            long j8 = this.f172l;
            if (j8 != 0 && (j8 <= 0 || this.f174n.a(TimeUnit.NANOSECONDS) <= j8)) {
                return;
            }
        }
        this.f178t = true;
        this.q.execute(new e(this, this.u));
    }

    public final List y() {
        Exception exc = null;
        try {
            try {
                List listResolveAddress = this.f.resolveAddress(this.f169i);
                ArrayList arrayList = new ArrayList(listResolveAddress.size());
                Iterator it = listResolveAddress.iterator();
                while (it.hasNext()) {
                    arrayList.add(new ze.c0(new InetSocketAddress((InetAddress) it.next(), this.f170j)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e) {
                exc = e;
                h4.v.a(exc);
                throw new RuntimeException(exc);
            }
        } catch (Throwable th2) {
            if (exc != null) {
                f161v.log(Level.FINE, "Address resolution failure", (Throwable) exc);
            }
            throw th2;
        }
    }
}
