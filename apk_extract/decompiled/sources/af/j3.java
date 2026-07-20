package af;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class j3 extends ze.e1 implements ze.q0 {
    public static final Logger c0 = Logger.getLogger(j3.class.getName());
    public static final Pattern d0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ze.q2 f342e0;
    public static final ze.q2 f0;
    public static final ze.q2 g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final p3 f343h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final t2 f344i0;
    public static final o0 j0;
    public LinkedHashSet A;
    public final Object B;
    public final HashSet C;
    public final t0 D;
    public final r E;
    public final AtomicBoolean F;
    public boolean G;
    public boolean H;
    public volatile boolean I;
    public final CountDownLatch J;
    public final k2 K;
    public final r L;
    public final v M;
    public final t N;
    public final ze.o0 O;
    public final f3 P;
    public g3 Q;
    public p3 R;
    public boolean S;
    public final boolean T;
    public final o5.c U;
    public final long V;
    public final long W;
    public final boolean X;
    public final ze.p2 Y;
    public final v1 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.r0 f345a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final k0 f346a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final p4 f348b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze.v1 f349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jj.g f350d;
    public final l6 e;
    public final q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h3 f351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a8.a f353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z2 f354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z2 f355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k2 f356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ze.v2 f357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ze.b0 f358n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ze.p f359o;
    public final k2 p;
    public final long q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k0 f360r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k2 f361s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ze.g f362t;
    public j5 u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a3 f364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile ze.z0 f365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashSet f367z;

    static {
        ze.q2 q2Var = ze.q2.f11411n;
        f342e0 = q2Var.h("Channel shutdownNow invoked");
        f0 = q2Var.h("Channel shutdown invoked");
        g0 = q2Var.h("Subchannel shutdown invoked");
        f343h0 = new p3(null, new HashMap(), new HashMap(), null, null, null);
        f344i0 = new t2();
        j0 = new o0(1);
    }

    public j3(k3 k3Var, cf.j jVar, k2 k2Var, a8.a aVar, k2 k2Var2, ArrayList arrayList) {
        int i8;
        k2 k2Var3 = k2.f377c;
        ze.v2 v2Var = new ze.v2(new w2(this));
        this.f357m = v2Var;
        k0 k0Var = new k0();
        k0Var.f375b = new ArrayList();
        k0Var.f374a = ze.q.IDLE;
        this.f360r = k0Var;
        this.f367z = new HashSet(16, 0.75f);
        this.B = new Object();
        this.C = new HashSet(1, 0.75f);
        this.E = new r(this);
        this.F = new AtomicBoolean(false);
        this.J = new CountDownLatch(1);
        this.Q = g3.NO_RESOLUTION;
        this.R = f343h0;
        this.S = false;
        this.U = new o5.c(2);
        this.Y = ze.z.f11480d;
        tj.x xVar = new tj.x(this);
        this.Z = new v1(this, 1);
        k0 k0Var2 = new k0();
        k0Var2.f375b = this;
        this.f346a0 = k0Var2;
        String str = k3Var.e;
        v8.i(str, TypedValues.AttributesType.S_TARGET);
        this.f347b = str;
        ze.r0 r0Var = new ze.r0("Channel", str, ze.r0.f11418d.incrementAndGet());
        this.f345a = r0Var;
        this.f356l = k2Var3;
        a8.a aVar2 = k3Var.f382a;
        v8.i(aVar2, "executorPool");
        this.f353i = aVar2;
        Executor executor = (Executor) g6.a((f6) aVar2.f44b);
        v8.i(executor, "executor");
        this.f352h = executor;
        a8.a aVar3 = k3Var.f383b;
        v8.i(aVar3, "offloadExecutorPool");
        z2 z2Var = new z2(aVar3);
        this.f355k = z2Var;
        q qVar = new q(jVar, z2Var);
        this.f = qVar;
        h3 h3Var = new h3(jVar.f1560d);
        this.f351g = h3Var;
        v vVar = new v(r0Var, k2Var3.g(), h0.a.j("Channel for '", str, "'"));
        this.M = vVar;
        t tVar = new t(vVar, k2Var3);
        this.N = tVar;
        j4 j4Var = l1.q;
        boolean z2 = k3Var.f393n;
        this.X = z2;
        l6 l6Var = new l6(k3Var.f);
        this.e = l6Var;
        ze.v1 v1Var = k3Var.f385d;
        this.f349c = v1Var;
        k5 k5Var = new k5(z2, k3Var.f389j, k3Var.f390k, l6Var);
        cf.k kVar = (cf.k) k3Var.f399w.f44b;
        kVar.getClass();
        int i9 = cf.h.f1534b[kVar.f1578g.ordinal()];
        if (i9 == 1) {
            i8 = 80;
        } else {
            if (i9 != 2) {
                throw new AssertionError(kVar.f1578g + " not handled");
            }
            i8 = 443;
        }
        Integer numValueOf = Integer.valueOf(i8);
        j4Var.getClass();
        jj.g gVar = new jj.g(numValueOf, j4Var, v2Var, k5Var, h3Var, tVar, z2Var);
        this.f350d = gVar;
        qVar.f520a.getClass();
        this.u = n(str, v1Var, gVar, Collections.singleton(InetSocketAddress.class));
        this.f354j = new z2(aVar);
        t0 t0Var = new t0(executor, v2Var);
        this.D = t0Var;
        t0Var.g(xVar);
        this.f361s = k2Var;
        boolean z3 = k3Var.p;
        this.T = z3;
        f3 f3Var = new f3(this, this.u.e());
        this.P = f3Var;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            v8.i(null, "interceptor");
            throw null;
        }
        this.f362t = f3Var;
        v8.i(k2Var2, "stopwatchSupplier");
        this.p = k2Var2;
        long j8 = k3Var.f388i;
        if (j8 == -1) {
            this.q = j8;
        } else {
            v8.f(j8 >= k3.f381z, "invalid idleTimeoutMillis %s", j8);
            this.q = k3Var.f388i;
        }
        this.f348b0 = new p4(new u2(this, 3), v2Var, jVar.f1560d, new z4(1));
        ze.b0 b0Var = k3Var.f386g;
        v8.i(b0Var, "decompressorRegistry");
        this.f358n = b0Var;
        ze.p pVar = k3Var.f387h;
        v8.i(pVar, "compressorRegistry");
        this.f359o = pVar;
        this.W = k3Var.f391l;
        this.V = k3Var.f392m;
        this.K = new k2(15);
        this.L = new r();
        ze.o0 o0Var = k3Var.f394o;
        o0Var.getClass();
        this.O = o0Var;
        ze.o0.a(o0Var.f11391b, this);
        if (z3) {
            return;
        }
        this.S = true;
    }

    public static void j(j3 j3Var) {
        if (j3Var.G) {
            for (f2 f2Var : j3Var.f367z) {
                f2Var.getClass();
                ze.q2 q2Var = f342e0;
                x1 x1Var = new x1(f2Var, q2Var, 0);
                ze.v2 v2Var = f2Var.f267j;
                v2Var.execute(x1Var);
                v2Var.execute(new x1(f2Var, q2Var, 1));
            }
            Iterator it = j3Var.C.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    public static void k(j3 j3Var) {
        if (!j3Var.I && j3Var.F.get() && j3Var.f367z.isEmpty() && j3Var.C.isEmpty()) {
            j3Var.N.f(ze.h.INFO, "Terminated");
            ze.o0.b(j3Var.O.f11391b, j3Var);
            j3Var.f353i.n(j3Var.f352h);
            z2 z2Var = j3Var.f354j;
            synchronized (z2Var) {
                Executor executor = z2Var.f748b;
                if (executor != null) {
                    z2Var.f747a.n(executor);
                    z2Var.f748b = null;
                }
            }
            z2 z2Var2 = j3Var.f355k;
            synchronized (z2Var2) {
                Executor executor2 = z2Var2.f748b;
                if (executor2 != null) {
                    z2Var2.f747a.n(executor2);
                    z2Var2.f748b = null;
                }
            }
            j3Var.f.close();
            j3Var.I = true;
            j3Var.J.countDown();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [ze.u1] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static j5 n(String str, ze.v1 v1Var, jj.g gVar, Collection collection) {
        URI uri;
        ?? r7;
        String str2;
        String str3;
        String str4;
        i4.t0 t0Var;
        i4.t0 t0Var2;
        StringBuilder sb2 = new StringBuilder();
        b1 b1Var = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            sb2.append(e.getMessage());
            uri = null;
        }
        if (uri == null) {
            r7 = 0;
        } else {
            String scheme = uri.getScheme();
            if (scheme == null) {
                v1Var.getClass();
                r7 = 0;
            } else {
                synchronized (v1Var) {
                    t0Var2 = v1Var.f11456c;
                }
                r7 = (ze.u1) t0Var2.get(scheme.toLowerCase(Locale.US));
            }
        }
        if (r7 == 0 && !d0.matcher(str).matches()) {
            try {
                synchronized (v1Var) {
                    str4 = v1Var.f11454a;
                }
                uri = new URI(str4, "", "/" + str, null);
                String scheme2 = uri.getScheme();
                if (scheme2 == null) {
                    r7 = 0;
                } else {
                    synchronized (v1Var) {
                        t0Var = v1Var.f11456c;
                    }
                    r7 = (ze.u1) t0Var.get(scheme2.toLowerCase(Locale.US));
                }
            } catch (URISyntaxException e4) {
                throw new IllegalArgumentException(e4);
            }
        }
        if (r7 == 0) {
            if (sb2.length() > 0) {
                str3 = " (" + ((Object) sb2) + ")";
            } else {
                str3 = "";
            }
            throw new IllegalArgumentException(h0.a.j("Could not find a NameResolverProvider for ", str, str3));
        }
        if (collection != null && !collection.containsAll(r7.a())) {
            throw new IllegalArgumentException(h0.a.l("Address types of NameResolver '", uri.getScheme(), "' for '", str, "' not supported by transport"));
        }
        if ("dns".equals(uri.getScheme())) {
            String path = uri.getPath();
            v8.i(path, "targetPath");
            v8.g(path.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", path, uri);
            String strSubstring = path.substring(1);
            uri.getAuthority();
            b1Var = new b1(strSubstring, gVar, l1.f425t, new z4(1), c1.f199a);
        }
        if (b1Var != null) {
            k2 k2Var = new k2(8);
            h3 h3Var = (h3) gVar.f;
            if (h3Var == null) {
                throw new IllegalStateException("ScheduledExecutorService not set in Builder");
            }
            ze.v2 v2Var = (ze.v2) gVar.f6332d;
            return new j5(b1Var, new o(k2Var, h3Var, v2Var), v2Var);
        }
        if (sb2.length() > 0) {
            str2 = " (" + ((Object) sb2) + ")";
        } else {
            str2 = "";
        }
        throw new IllegalArgumentException(h0.a.j("cannot create a NameResolver for ", str, str2));
    }

    @Override // ze.g
    public final String b() {
        return this.f362t.b();
    }

    @Override // ze.q0
    public final ze.r0 d() {
        return this.f345a;
    }

    @Override // ze.g
    public final ze.j e(ze.r1 r1Var, ze.f fVar) {
        return this.f362t.e(r1Var, fVar);
    }

    @Override // ze.e1
    public final ze.q h() {
        ze.q qVar = (ze.q) this.f360r.f374a;
        if (qVar != null) {
            return qVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    @Override // ze.e1
    public final ze.e1 i() {
        ze.h hVar = ze.h.DEBUG;
        t tVar = this.N;
        tVar.f(hVar, "shutdownNow() called");
        tVar.f(hVar, "shutdown() called");
        boolean zCompareAndSet = this.F.compareAndSet(false, true);
        f3 f3Var = this.P;
        ze.v2 v2Var = this.f357m;
        if (zCompareAndSet) {
            v2Var.execute(new u2(this, 1));
            f3Var.f281d.f357m.execute(new d3(f3Var, 0));
            v2Var.execute(new u2(this, 0));
        }
        f3Var.f281d.f357m.execute(new d3(f3Var, 1));
        v2Var.execute(new u2(this, 2));
        return this;
    }

    public final void l(boolean z2) {
        ScheduledFuture scheduledFuture;
        p4 p4Var = this.f348b0;
        p4Var.f = false;
        if (!z2 || (scheduledFuture = p4Var.f508g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        p4Var.f508g = null;
    }

    public final void m() {
        this.f357m.d();
        if (this.F.get() || this.f366y) {
            return;
        }
        if (((Set) this.Z.f574b).isEmpty()) {
            o();
        } else {
            l(false);
        }
        if (this.f364w != null) {
            return;
        }
        this.N.f(ze.h.INFO, "Exiting idle mode");
        a3 a3Var = new a3(this);
        l6 l6Var = this.e;
        l6Var.getClass();
        a3Var.f140a = new r(l6Var, a3Var);
        this.f364w = a3Var;
        this.u.q(new b3(this, a3Var, this.u));
        this.f363v = true;
    }

    public final void o() {
        long j8 = this.q;
        if (j8 == -1) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        p4 p4Var = this.f348b0;
        p4Var.getClass();
        long nanos = timeUnit.toNanos(j8);
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jA = p4Var.f507d.a(timeUnit2) + nanos;
        p4Var.f = true;
        if (jA - p4Var.e < 0 || p4Var.f508g == null) {
            ScheduledFuture scheduledFuture = p4Var.f508g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            p4Var.f508g = p4Var.f504a.schedule(new o4(p4Var, 1), nanos, timeUnit2);
        }
        p4Var.e = jA;
    }

    public final void p(boolean z2) {
        this.f357m.d();
        if (z2) {
            v8.n(this.f363v, "nameResolver is not started");
            v8.n(this.f364w != null, "lbHelper is null");
        }
        j5 j5Var = this.u;
        if (j5Var != null) {
            j5Var.p();
            this.f363v = false;
            if (z2) {
                String str = this.f347b;
                ze.v1 v1Var = this.f349c;
                jj.g gVar = this.f350d;
                this.f.f520a.getClass();
                this.u = n(str, v1Var, gVar, Collections.singleton(InetSocketAddress.class));
            } else {
                this.u = null;
            }
        }
        a3 a3Var = this.f364w;
        if (a3Var != null) {
            r rVar = a3Var.f140a;
            ((ze.b1) rVar.f539b).f();
            rVar.f539b = null;
            this.f364w = null;
        }
        this.f365x = null;
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.e("logId", this.f345a.f11421c);
        aVarA.d(this.f347b, TypedValues.AttributesType.S_TARGET);
        return aVarA.toString();
    }
}
