package wj;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
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

/* JADX INFO: loaded from: classes2.dex */
public class f0 extends vj.x1 {
    public static final String A;
    public static final String B;
    public static final String C;

    @b1.e
    public static final String D = "networkaddress.cache.ttl";

    @b1.e
    public static final long E = 30;

    @b1.e
    public static boolean F = false;

    @b1.e
    public static boolean G = false;

    @b1.e
    public static boolean H = false;
    public static final g I;
    public static String J = null;
    public static final /* synthetic */ boolean K = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f18630x = "grpc_config=";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f18632z = "_grpc_config.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.e
    public final vj.g2 f18633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f18634b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f18635c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<f> f18636d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f3.d<Executor> f18640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vj.c3 f18642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c1.o0 f18643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f18646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f18647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final vj.x1.i f18648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vj.x1.e f18650r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f18625s = Logger.getLogger(f0.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f18626t = "clientLanguage";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f18627u = "percentage";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f18628v = "clientHostname";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f18629w = "serviceConfig";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Set<String> f18631y = Collections.unmodifiableSet(new HashSet(Arrays.asList(f18626t, f18627u, f18628v, f18629w)));

    @b1.e
    public interface b {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.y2 f18651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<vj.d0> f18652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vj.x1.c f18653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vj.a f18654d;

        public c() {
        }

        public c(a aVar) {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // wj.f0.b
        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.x1.e f18656a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f18658a;

            public a(boolean z10) {
                this.f18658a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f18658a) {
                    f0 f0Var = f0.this;
                    f0Var.f18644l = true;
                    if (f0Var.f18641i > 0) {
                        f0Var.f18643k.j().k();
                    }
                }
                f0.this.f18649q = false;
            }
        }

        public e(vj.x1.e eVar) {
            this.f18656a = (vj.x1.e) c1.h0.F(eVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            vj.c3 c3Var;
            a aVar;
            Logger logger = f0.f18625s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                f0.f18625s.finer("Attempting DNS resolution of " + f0.this.f18638f);
            }
            c cVarO = null;
            try {
                try {
                    vj.d0 d0VarN = f0.this.n();
                    vj.x1.g.a aVar2 = new vj.x1.g.a();
                    if (d0VarN != null) {
                        Logger logger2 = f0.f18625s;
                        if (logger2.isLoggable(level)) {
                            logger2.finer("Using proxy address " + d0VarN);
                        }
                        aVar2.f17536a = Collections.singletonList(d0VarN);
                    } else {
                        cVarO = f0.this.o(false);
                        vj.y2 y2Var = cVarO.f18651a;
                        if (y2Var != null) {
                            this.f18656a.a(y2Var);
                            f0.this.f18642j.execute(new a(cVarO.f18651a == null));
                            return;
                        }
                        List<vj.d0> list = cVarO.f18652b;
                        if (list != null) {
                            aVar2.f17536a = list;
                        }
                        vj.x1.c cVar = cVarO.f18653c;
                        if (cVar != null) {
                            aVar2.f17538c = cVar;
                        }
                        vj.a aVar3 = cVarO.f18654d;
                        if (aVar3 != null) {
                            aVar2.f17537b = aVar3;
                        }
                    }
                    this.f18656a.c(aVar2.a());
                    z10 = cVarO != null && cVarO.f18651a == null;
                    c3Var = f0.this.f18642j;
                    aVar = new a(z10);
                } catch (IOException e10) {
                    this.f18656a.a(vj.y2.f17563t.u("Unable to resolve host " + f0.this.f18638f).t(e10));
                    z10 = 0 != 0 && cVarO.f18651a == null;
                    c3Var = f0.this.f18642j;
                    aVar = new a(z10);
                }
                c3Var.execute(aVar);
            } catch (Throwable th2) {
                f0.this.f18642j.execute(new a(0 != 0 && cVarO.f18651a == null));
                throw th2;
            }
        }
    }

    @b1.e
    public interface f {
        List<String> a(String str) throws Exception;

        List<h> b(String str) throws Exception;
    }

    public interface g {
        @gm.j
        f a();

        @gm.j
        Throwable b();
    }

    @b1.e
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18661b;

        public h(String str, int i10) {
            this.f18660a = str;
            this.f18661b = i10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || h.class != obj.getClass()) {
                return false;
            }
            h hVar = (h) obj;
            return this.f18661b == hVar.f18661b && this.f18660a.equals(hVar.f18660a);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f18660a, Integer.valueOf(this.f18661b)});
        }

        public String toString() {
            return c1.z.c(this).j("host", this.f18660a).d(RtspHeaders.Values.PORT, this.f18661b).toString();
        }
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        A = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        B = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        C = property3;
        F = Boolean.parseBoolean(property);
        G = Boolean.parseBoolean(property2);
        H = Boolean.parseBoolean(property3);
        I = x(f0.class.getClassLoader());
    }

    public f0(@gm.j String str, String str2, vj.x1.b bVar, f3.d<Executor> dVar, c1.o0 o0Var, boolean z10) {
        c1.h0.F(bVar, d6.a.F);
        this.f18640h = dVar;
        URI uriCreate = URI.create("//" + ((String) c1.h0.F(str2, "name")));
        c1.h0.u(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f18637e = (String) c1.h0.V(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f18638f = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f18639g = bVar.f17514a;
        } else {
            this.f18639g = uriCreate.getPort();
        }
        this.f18633a = (vj.g2) c1.h0.F(bVar.f17515b, "proxyDetector");
        this.f18641i = t(z10);
        this.f18643k = (c1.o0) c1.h0.F(o0Var, NotificationCompat.CATEGORY_STOPWATCH);
        this.f18642j = (vj.c3) c1.h0.F(bVar.f17516c, "syncContext");
        Executor executor = bVar.f17520g;
        this.f18646n = executor;
        this.f18647o = executor == null;
        this.f18648p = (vj.x1.i) c1.h0.F(bVar.f17517d, "serviceConfigParser");
    }

    @b1.e
    public static List<Map<String, ?>> A(List<String> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith(f18630x)) {
                Object objA = g1.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException(c0.a.a("wrong type ", objA));
                }
                arrayList.addAll(h1.a((List) objA));
            } else {
                f18625s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    @b1.e
    public static boolean G(boolean z10, boolean z11, String str) {
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z12 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '.') {
                z12 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z12;
    }

    @gm.j
    public static final List<String> p(Map<String, ?> map) {
        return h1.g(map, f18626t);
    }

    @gm.j
    public static final List<String> r(Map<String, ?> map) {
        return h1.g(map, f18628v);
    }

    public static String s() {
        if (J == null) {
            try {
                J = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return J;
    }

    public static long t(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty(D);
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f18625s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{D, property, 30L});
            }
        }
        return j10 > 0 ? TimeUnit.SECONDS.toNanos(j10) : j10;
    }

    @gm.j
    public static final Double u(Map<String, ?> map) {
        return h1.h(map, f18627u);
    }

    @gm.j
    @b1.e
    public static g x(ClassLoader classLoader) {
        try {
            try {
                try {
                    g gVar = (g) Class.forName("wj.f1", true, classLoader).asSubclass(g.class).getConstructor(null).newInstance(null);
                    if (gVar.b() == null) {
                        return gVar;
                    }
                    f18625s.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", gVar.b());
                    return null;
                } catch (Exception e10) {
                    f18625s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e10);
                    return null;
                }
            } catch (Exception e11) {
                f18625s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e11);
                return null;
            }
        } catch (ClassCastException e12) {
            f18625s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e12);
            return null;
        } catch (ClassNotFoundException e13) {
            f18625s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e13);
            return null;
        }
    }

    @gm.j
    @b1.e
    public static Map<String, ?> y(Map<String, ?> map, Random random, String str) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            c1.w0.q(f18631y.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> listG = h1.g(map, f18626t);
        if (listG != null && !listG.isEmpty()) {
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                if ("java".equalsIgnoreCase(it.next())) {
                }
            }
            return null;
        }
        Double dH = h1.h(map, f18627u);
        if (dH != null) {
            int iIntValue = dH.intValue();
            c1.w0.q(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dH);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List<String> listG2 = h1.g(map, f18628v);
        if (listG2 != null && !listG2.isEmpty()) {
            Iterator<String> it2 = listG2.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(str)) {
                }
            }
            return null;
        }
        Map<String, ?> mapL = h1.l(map, f18629w);
        if (mapL != null) {
            return mapL;
        }
        throw new c1.x0(String.format("key '%s' missing in '%s'", map, f18629w));
    }

    @gm.j
    public static vj.x1.c z(List<String> list, Random random, String str) {
        try {
            Iterator<Map<String, ?>> it = A(list).iterator();
            Map<String, ?> mapY = null;
            while (it.hasNext()) {
                try {
                    mapY = y(it.next(), random, str);
                    if (mapY != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    return vj.x1.c.b(vj.y2.f17550g.u("failed to pick service config choice").t(e10));
                }
            }
            if (mapY == null) {
                return null;
            }
            return vj.x1.c.a(mapY);
        } catch (IOException | RuntimeException e11) {
            return vj.x1.c.b(vj.y2.f17550g.u("failed to parse TXT records").t(e11));
        }
    }

    public final void B() {
        if (this.f18649q || this.f18645m || !m()) {
            return;
        }
        this.f18649q = true;
        this.f18646n.execute(new e(this.f18650r));
    }

    public final List<vj.d0> C() {
        Exception exc = null;
        try {
            try {
                List<InetAddress> listResolveAddress = this.f18635c.resolveAddress(this.f18638f);
                ArrayList arrayList = new ArrayList(listResolveAddress.size());
                Iterator<InetAddress> it = listResolveAddress.iterator();
                while (it.hasNext()) {
                    arrayList.add(new vj.d0(new InetSocketAddress(it.next(), this.f18639g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e10) {
                exc = e10;
                c1.t0.w(exc);
                throw new RuntimeException(exc);
            }
        } catch (Throwable th2) {
            if (exc != null) {
                f18625s.log(Level.FINE, "Address resolution failure", (Throwable) exc);
            }
            throw th2;
        }
    }

    @gm.j
    public final vj.x1.c D() {
        List<String> listEmptyList = Collections.emptyList();
        f fVarW = w();
        if (fVarW != null) {
            try {
                listEmptyList = fVarW.a(f18632z + this.f18638f);
            } catch (Exception e10) {
                f18625s.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e10);
            }
        }
        if (listEmptyList.isEmpty()) {
            f18625s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f18638f});
            return null;
        }
        vj.x1.c cVarZ = z(listEmptyList, this.f18634b, s());
        if (cVarZ == null) {
            return null;
        }
        vj.y2 y2Var = cVarZ.f17531a;
        if (y2Var != null) {
            return new vj.x1.c(y2Var);
        }
        return this.f18648p.a((Map) cVarZ.f17532b);
    }

    @b1.e
    public void E(b bVar) {
        this.f18635c = bVar;
    }

    @b1.e
    public void F(f fVar) {
        this.f18636d.set(fVar);
    }

    @Override // vj.x1
    public String a() {
        return this.f18637e;
    }

    @Override // vj.x1
    public void b() {
        c1.h0.h0(this.f18650r != null, "not started");
        B();
    }

    @Override // vj.x1
    public void c() {
        if (this.f18645m) {
            return;
        }
        this.f18645m = true;
        Executor executor = this.f18646n;
        if (executor == null || !this.f18647o) {
            return;
        }
        this.f18646n = (Executor) f3.f(this.f18640h, executor);
    }

    @Override // vj.x1
    public void d(vj.x1.e eVar) {
        c1.h0.h0(this.f18650r == null, "already started");
        if (this.f18647o) {
            this.f18646n = (Executor) f3.d(this.f18640h);
        }
        this.f18650r = (vj.x1.e) c1.h0.F(eVar, "listener");
        B();
    }

    public final boolean m() {
        if (this.f18644l) {
            long j10 = this.f18641i;
            if (j10 != 0 && (j10 <= 0 || this.f18643k.g(TimeUnit.NANOSECONDS) <= this.f18641i)) {
                return false;
            }
        }
        return true;
    }

    @gm.j
    public final vj.d0 n() throws IOException {
        vj.f2 f2VarA = this.f18633a.a(InetSocketAddress.createUnresolved(this.f18638f, this.f18639g));
        if (f2VarA != null) {
            return new vj.d0(f2VarA);
        }
        return null;
    }

    public c o(boolean z10) {
        c cVar = new c();
        try {
            cVar.f18652b = C();
        } catch (Exception e10) {
            if (!z10) {
                cVar.f18651a = vj.y2.f17563t.u("Unable to resolve host " + this.f18638f).t(e10);
                return cVar;
            }
        }
        if (H) {
            cVar.f18653c = D();
        }
        return cVar;
    }

    @b1.e
    public String q() {
        return this.f18638f;
    }

    public final int v() {
        return this.f18639g;
    }

    @gm.j
    public f w() {
        g gVar;
        if (!G(F, G, this.f18638f)) {
            return null;
        }
        f fVar = this.f18636d.get();
        return (fVar != null || (gVar = I) == null) ? fVar : gVar.a();
    }
}
