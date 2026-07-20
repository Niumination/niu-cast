package wj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class o1 extends vj.s1<o1> {
    public static final String K = "directaddress";

    @b1.e
    public static final long M = 30;
    public static final long S = 16777216;
    public static final long T = 1048576;
    public static final Method U;

    @gm.j
    public vj.g2 A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final c I;
    public final b J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z1<? extends Executor> f19111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z1<? extends Executor> f19112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<vj.l> f19113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vj.z1 f19114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<vj.o> f19115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.j
    public final vj.g f19117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @gm.j
    public final vj.d f19118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @gm.j
    public final SocketAddress f19119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @gm.j
    public String f19120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.j
    public String f19121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f19122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vj.a0 f19124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public vj.t f19125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f19126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f19129s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f19130t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19131u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public vj.v0 f19132v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f19133w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @gm.j
    public Map<String, ?> f19134x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f19135y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @gm.j
    public vj.b f19136z;
    public static final Logger L = Logger.getLogger(o1.class.getName());

    @b1.e
    public static final long N = TimeUnit.MINUTES.toMillis(30);
    public static final long O = TimeUnit.SECONDS.toMillis(1);
    public static final z1<? extends Executor> P = new g3(v0.K);
    public static final vj.a0 Q = vj.a0.c();
    public static final vj.t R = vj.t.a();

    public interface b {
        int b();
    }

    public interface c {
        v a();
    }

    public static class d extends vj.y1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SocketAddress f19137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection<Class<? extends SocketAddress>> f19139c;

        public class a extends vj.x1 {
            public a() {
            }

            @Override // vj.x1
            public String a() {
                return d.this.f19138b;
            }

            @Override // vj.x1
            public void c() {
            }

            @Override // vj.x1
            public void d(vj.x1.e eVar) {
                vj.x1.g.a aVar = new vj.x1.g.a();
                aVar.f17536a = Collections.singletonList(new vj.d0(d.this.f19137a));
                aVar.f17537b = vj.a.f17046c;
                eVar.c(aVar.a());
            }
        }

        public d(SocketAddress socketAddress, String str) {
            this.f19137a = socketAddress;
            this.f19138b = str;
            this.f19139c = Collections.singleton(socketAddress.getClass());
        }

        @Override // vj.x1.d
        public String a() {
            return o1.K;
        }

        @Override // vj.x1.d
        public vj.x1 b(URI uri, vj.x1.b bVar) {
            return new a();
        }

        @Override // vj.y1
        public Collection<Class<? extends SocketAddress>> c() {
            return this.f19139c;
        }

        @Override // vj.y1
        public boolean e() {
            return true;
        }

        @Override // vj.y1
        public int f() {
            return 5;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19141a;

        public e(int i10) {
            this.f19141a = i10;
        }

        @Override // wj.o1.b
        public int b() {
            return this.f19141a;
        }
    }

    public static final class f implements b {
        public f() {
        }

        @Override // wj.o1.b
        public int b() {
            return v0.f19368n;
        }

        public f(a aVar) {
        }
    }

    public static class g implements c {
        @Override // wj.o1.c
        public v a() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e10) {
            L.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
            declaredMethod = null;
        } catch (NoSuchMethodException e11) {
            L.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
            declaredMethod = null;
        }
        U = declaredMethod;
    }

    public o1(String str, @gm.j vj.g gVar, @gm.j vj.d dVar, c cVar, @gm.j b bVar) {
        z1<? extends Executor> z1Var = P;
        this.f19111a = z1Var;
        this.f19112b = z1Var;
        this.f19113c = new ArrayList();
        this.f19114d = vj.z1.d();
        this.f19115e = new ArrayList();
        this.f19122l = v0.H;
        this.f19124n = Q;
        this.f19125o = R;
        this.f19126p = N;
        this.f19127q = 5;
        this.f19128r = 5;
        this.f19129s = 16777216L;
        this.f19130t = 1048576L;
        this.f19131u = true;
        this.f19132v = vj.v0.w();
        this.f19135y = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = false;
        this.G = true;
        this.H = true;
        this.f19116f = (String) c1.h0.F(str, TypedValues.AttributesType.S_TARGET);
        this.f19117g = gVar;
        this.f19118h = dVar;
        this.I = (c) c1.h0.F(cVar, "clientTransportFactoryBuilder");
        this.f19119i = null;
        if (bVar != null) {
            this.J = bVar;
        } else {
            this.J = new f();
        }
    }

    public static List<?> L(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj == null) {
                arrayList.add(null);
            } else if (obj instanceof Map) {
                arrayList.add(M((Map) obj));
            } else if (obj instanceof List) {
                arrayList.add(L((List) obj));
            } else if (obj instanceof String) {
                arrayList.add(obj);
            } else if (obj instanceof Double) {
                arrayList.add(obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("The entry '" + obj + "' is of type '" + obj.getClass() + "', which is not supported");
                }
                arrayList.add(obj);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @gm.j
    public static Map<String, ?> M(@gm.j Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            c1.h0.u(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", entry);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                linkedHashMap.put(str, null);
            } else if (value instanceof Map) {
                linkedHashMap.put(str, M((Map) value));
            } else if (value instanceof List) {
                linkedHashMap.put(str, L((List) value));
            } else if (value instanceof String) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Double) {
                linkedHashMap.put(str, value);
            } else {
                if (!(value instanceof Boolean)) {
                    throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
                }
                linkedHashMap.put(str, value);
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @b1.e
    public static String e0(SocketAddress socketAddress) {
        try {
            return new URI(K, "", "/" + socketAddress, null).toString();
        } catch (URISyntaxException e10) {
            throw new RuntimeException(e10);
        }
    }

    @t1.e("ClientTransportFactoryBuilder is required, use a constructor")
    public static vj.s1<?> l(String str, int i10) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    @t1.e("ClientTransportFactoryBuilder is required, use a constructor")
    public static vj.s1<?> m(String str) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    @Override // vj.s1
    public vj.s1 A(String str) {
        this.f19121k = K(str);
        return this;
    }

    @Override // vj.s1
    public vj.s1 C(@gm.j vj.g2 g2Var) {
        this.A = g2Var;
        return this;
    }

    @Override // vj.s1
    public vj.s1 E(vj.b bVar) {
        this.f19136z = bVar;
        return this;
    }

    @Override // vj.s1
    public vj.s1 I(@gm.j String str) {
        this.f19120j = str;
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public o1 a(vj.o oVar) {
        this.f19115e.add((vj.o) c1.h0.F(oVar, "transport filter"));
        return this;
    }

    @b1.e
    public String K(String str) {
        return this.B ? str : v0.d(str);
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public o1 c(vj.t tVar) {
        if (tVar != null) {
            this.f19125o = tVar;
        } else {
            this.f19125o = R;
        }
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public o1 d(vj.a0 a0Var) {
        if (a0Var != null) {
            this.f19124n = a0Var;
        } else {
            this.f19124n = Q;
        }
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public o1 e(String str) {
        SocketAddress socketAddress = this.f19119i;
        c1.h0.x0(socketAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", socketAddress);
        c1.h0.e(str != null, "policy cannot be null");
        this.f19122l = str;
        return this;
    }

    public o1 Q(@gm.j Map<String, ?> map) {
        this.f19134x = M(map);
        return this;
    }

    public o1 R() {
        return k(q1.n0.INSTANCE);
    }

    public o1 S() {
        this.B = true;
        return this;
    }

    public o1 T() {
        this.f19131u = false;
        return this;
    }

    public o1 U() {
        this.f19135y = false;
        return this;
    }

    public o1 V() {
        this.B = false;
        return this;
    }

    public o1 W() {
        this.f19131u = true;
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public o1 k(Executor executor) {
        if (executor != null) {
            this.f19111a = new k0(executor);
        } else {
            this.f19111a = P;
        }
        return this;
    }

    public int Y() {
        return this.J.b();
    }

    @b1.e
    public List<vj.l> Z() {
        boolean z10;
        vj.l lVar;
        ArrayList arrayList = new ArrayList(this.f19113c);
        List<vj.l> listA = vj.m0.a();
        if (listA != null) {
            arrayList.addAll(listA);
            z10 = true;
        } else {
            z10 = false;
        }
        vj.l lVar2 = null;
        if (!z10 && this.C) {
            Method method = U;
            if (method != null) {
                try {
                    lVar = (vj.l) method.invoke(null, Boolean.valueOf(this.D), Boolean.valueOf(this.E), Boolean.valueOf(this.F), Boolean.valueOf(this.G));
                } catch (IllegalAccessException e10) {
                    L.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
                    lVar = null;
                } catch (InvocationTargetException e11) {
                    L.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
                    lVar = null;
                }
            } else {
                lVar = null;
            }
            if (lVar != null) {
                arrayList.add(0, lVar);
            }
        }
        if (!z10 && this.H) {
            try {
                lVar2 = (vj.l) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
            } catch (ClassNotFoundException e12) {
                L.log(Level.FINE, "Unable to apply census stats", (Throwable) e12);
            } catch (IllegalAccessException e13) {
                L.log(Level.FINE, "Unable to apply census stats", (Throwable) e13);
            } catch (NoSuchMethodException e14) {
                L.log(Level.FINE, "Unable to apply census stats", (Throwable) e14);
            } catch (InvocationTargetException e15) {
                L.log(Level.FINE, "Unable to apply census stats", (Throwable) e15);
            }
            if (lVar2 != null) {
                arrayList.add(0, lVar2);
            }
        }
        return arrayList;
    }

    public z1<? extends Executor> a0() {
        return this.f19112b;
    }

    @Override // vj.s1
    public vj.r1 b() {
        return new p1(new n1(this, this.I.a(), new h0.a(), new g3(v0.K), v0.M, Z(), n3.f19104a));
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public o1 n(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "idle timeout is %s, but must be positive", j10);
        if (timeUnit.toDays(j10) >= 30) {
            this.f19126p = -1L;
        } else {
            this.f19126p = Math.max(timeUnit.toMillis(j10), O);
        }
        return this;
    }

    public o1 c0(List<vj.l> list) {
        this.f19113c.addAll(list);
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public o1 p(vj.l... lVarArr) {
        this.f19113c.addAll(Arrays.asList(lVarArr));
        return this;
    }

    @Override // vj.s1
    public vj.s1 f(@gm.j Map map) {
        this.f19134x = M(map);
        return this;
    }

    public o1 f0(int i10) {
        this.f19128r = i10;
        return this;
    }

    @Override // vj.s1
    public vj.s1 g() {
        return k(q1.n0.INSTANCE);
    }

    public o1 g0(int i10) {
        this.f19127q = i10;
        return this;
    }

    @Override // vj.s1
    public vj.s1 h() {
        this.f19131u = false;
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public o1 x(int i10) {
        c1.h0.e(i10 >= 0, "maxTraceEvents must be non-negative");
        this.f19133w = i10;
        return this;
    }

    @Override // vj.s1
    public vj.s1 i() {
        this.f19135y = false;
        return this;
    }

    @Override // vj.s1
    @Deprecated
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public o1 y(vj.x1.d dVar) {
        SocketAddress socketAddress = this.f19119i;
        c1.h0.x0(socketAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", socketAddress);
        if (dVar != null) {
            vj.z1 z1Var = new vj.z1();
            if (dVar instanceof vj.y1) {
                z1Var.j((vj.y1) dVar);
            } else {
                z1Var.j(new x1(dVar));
            }
            this.f19114d = z1Var;
        } else {
            this.f19114d = vj.z1.d();
        }
        return this;
    }

    @Override // vj.s1
    public vj.s1 j() {
        this.f19131u = true;
        return this;
    }

    public o1 j0(vj.z1 z1Var) {
        this.f19114d = z1Var;
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public o1 z(Executor executor) {
        if (executor != null) {
            this.f19112b = new k0(executor);
        } else {
            this.f19112b = P;
        }
        return this;
    }

    public o1 l0(String str) {
        this.f19121k = K(str);
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public o1 B(long j10) {
        c1.h0.e(j10 > 0, "per RPC buffer limit must be positive");
        this.f19130t = j10;
        return this;
    }

    public o1 n0(@gm.j vj.g2 g2Var) {
        this.A = g2Var;
        return this;
    }

    @Override // vj.s1
    public vj.s1 o(List list) {
        this.f19113c.addAll(list);
        return this;
    }

    @Override // vj.s1
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public o1 D(long j10) {
        c1.h0.e(j10 > 0, "retry buffer size must be positive");
        this.f19129s = j10;
        return this;
    }

    public o1 p0(vj.b bVar) {
        this.f19136z = bVar;
        return this;
    }

    public void q0(boolean z10) {
        this.C = z10;
    }

    public void r0(boolean z10) {
        this.E = z10;
    }

    public void s0(boolean z10) {
        this.F = z10;
    }

    @Override // vj.s1
    public vj.s1 t(int i10) {
        this.f19128r = i10;
        return this;
    }

    public void t0(boolean z10) {
        this.G = z10;
    }

    public void u0(boolean z10) {
        this.D = z10;
    }

    public void v0(boolean z10) {
        this.H = z10;
    }

    @Override // vj.s1
    public vj.s1 w(int i10) {
        this.f19127q = i10;
        return this;
    }

    public o1 w0(@gm.j String str) {
        this.f19120j = str;
        return this;
    }

    public o1(SocketAddress socketAddress, String str, @gm.j vj.g gVar, @gm.j vj.d dVar, c cVar, @gm.j b bVar) {
        z1<? extends Executor> z1Var = P;
        this.f19111a = z1Var;
        this.f19112b = z1Var;
        this.f19113c = new ArrayList();
        this.f19114d = vj.z1.d();
        this.f19115e = new ArrayList();
        this.f19122l = v0.H;
        this.f19124n = Q;
        this.f19125o = R;
        this.f19126p = N;
        this.f19127q = 5;
        this.f19128r = 5;
        this.f19129s = 16777216L;
        this.f19130t = 1048576L;
        this.f19131u = true;
        this.f19132v = vj.v0.w();
        this.f19135y = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = false;
        this.G = true;
        this.H = true;
        this.f19116f = e0(socketAddress);
        this.f19117g = gVar;
        this.f19118h = dVar;
        this.I = (c) c1.h0.F(cVar, "clientTransportFactoryBuilder");
        this.f19119i = socketAddress;
        vj.z1 z1Var2 = new vj.z1();
        z1Var2.j(new d(socketAddress, str));
        this.f19114d = z1Var2;
        if (bVar != null) {
            this.J = bVar;
        } else {
            this.J = new f();
        }
    }

    public o1(String str, c cVar, @gm.j b bVar) {
        this(str, null, null, cVar, bVar);
    }

    public o1(SocketAddress socketAddress, String str, c cVar, @gm.j b bVar) {
        this(socketAddress, str, null, null, cVar, bVar);
    }
}
