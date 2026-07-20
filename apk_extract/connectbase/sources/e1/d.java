package e1;

import c1.h0;
import c1.q0;
import c1.r0;
import c1.u0;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@i
public final class d<K, V> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3884q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f3885r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f3886s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3887t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final q0<? extends e1.a.b> f3888u = new r0.g(new a());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f3889v = new h(0, 0, 0, 0, 0, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final q0<e1.a.b> f3890w = new b();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final u0 f3891x = new c();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3892y = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    public b0<? super K, ? super V> f3898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    public m.t f3899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @gm.a
    public m.t f3900h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @gm.a
    public c1.m<Object> f3904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @gm.a
    public c1.m<Object> f3905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public v<? super K, ? super V> f3906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @gm.a
    public u0 f3907o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3893a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3894b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3895c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3896d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3897e = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3901i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3902j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3903k = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q0<? extends e1.a.b> f3908p = f3888u;

    public class a implements e1.a.b {
        @Override // e1.a.b
        public void a(int count) {
        }

        @Override // e1.a.b
        public void b(int count) {
        }

        @Override // e1.a.b
        public void c() {
        }

        @Override // e1.a.b
        public void d(long loadTime) {
        }

        @Override // e1.a.b
        public void e(long loadTime) {
        }

        @Override // e1.a.b
        public h f() {
            return d.f3889v;
        }
    }

    public class b implements q0<e1.a.b> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e1.a.b get() {
            return new e1.a.C0089a();
        }
    }

    public class c extends u0 {
        @Override // c1.u0
        public long a() {
            return 0L;
        }
    }

    /* JADX INFO: renamed from: e1.d$d, reason: collision with other inner class name */
    public static final class C0090d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f3909a = Logger.getLogger(d.class.getName());
    }

    public enum e implements v<Object, Object> {
        INSTANCE;

        public static /* synthetic */ e[] a() {
            return new e[]{INSTANCE};
        }

        @Override // e1.v
        public void onRemoval(z<Object, Object> notification) {
        }
    }

    public enum f implements b0<Object, Object> {
        INSTANCE;

        public static /* synthetic */ f[] a() {
            return new f[]{INSTANCE};
        }

        @Override // e1.b0
        public int weigh(Object key, Object value) {
            return 1;
        }
    }

    public static d<Object, Object> D() {
        return new d<>();
    }

    @b1.c
    public static d<Object, Object> h(e1.e spec) {
        d<Object, Object> dVarF = spec.f();
        dVarF.f3893a = false;
        return dVarF;
    }

    @b1.c
    public static d<Object, Object> i(String spec) {
        return h(e1.e.e(spec));
    }

    @b1.c
    @t1.a
    public d<K, V> A() {
        this.f3893a = false;
        return this;
    }

    @t1.a
    public d<K, V> B(long maximumSize) {
        long j10 = this.f3896d;
        h0.s0(j10 == -1, "maximum size was already set to %s", j10);
        long j11 = this.f3897e;
        h0.s0(j11 == -1, "maximum weight was already set to %s", j11);
        h0.h0(this.f3898f == null, "maximum size can not be combined with weigher");
        h0.e(maximumSize >= 0, "maximum size must not be negative");
        this.f3896d = maximumSize;
        return this;
    }

    @b1.c
    @t1.a
    public d<K, V> C(long maximumWeight) {
        long j10 = this.f3897e;
        h0.s0(j10 == -1, "maximum weight was already set to %s", j10);
        long j11 = this.f3896d;
        h0.s0(j11 == -1, "maximum size was already set to %s", j11);
        h0.e(maximumWeight >= 0, "maximum weight must not be negative");
        this.f3897e = maximumWeight;
        return this;
    }

    @t1.a
    public d<K, V> E() {
        this.f3908p = f3890w;
        return this;
    }

    @b1.c
    @t1.a
    public d<K, V> F(long duration, TimeUnit unit) {
        unit.getClass();
        long j10 = this.f3903k;
        h0.s0(j10 == -1, "refresh was already set to %s ns", j10);
        h0.t(duration > 0, "duration must be positive: %s %s", duration, unit);
        this.f3903k = unit.toNanos(duration);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> d<K1, V1> G(v<? super K1, ? super V1> listener) {
        h0.g0(this.f3906n == null);
        listener.getClass();
        this.f3906n = listener;
        return this;
    }

    @t1.a
    public d<K, V> H(m.t strength) {
        m.t tVar = this.f3899g;
        h0.x0(tVar == null, "Key strength was already set to %s", tVar);
        strength.getClass();
        this.f3899g = strength;
        return this;
    }

    @t1.a
    public d<K, V> I(m.t strength) {
        m.t tVar = this.f3900h;
        h0.x0(tVar == null, "Value strength was already set to %s", tVar);
        strength.getClass();
        this.f3900h = strength;
        return this;
    }

    @b1.c
    @t1.a
    public d<K, V> J() {
        return I(m.t.SOFT);
    }

    @t1.a
    public d<K, V> K(u0 ticker) {
        h0.g0(this.f3907o == null);
        ticker.getClass();
        this.f3907o = ticker;
        return this;
    }

    @b1.c
    @t1.a
    public d<K, V> L(c1.m<Object> equivalence) {
        c1.m<Object> mVar = this.f3905m;
        h0.x0(mVar == null, "value equivalence was already set to %s", mVar);
        equivalence.getClass();
        this.f3905m = equivalence;
        return this;
    }

    @b1.c
    @t1.a
    public d<K, V> M() {
        return H(m.t.WEAK);
    }

    @b1.c
    @t1.a
    public d<K, V> N() {
        return I(m.t.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    @t1.a
    public <K1 extends K, V1 extends V> d<K1, V1> O(b0<? super K1, ? super V1> weigher) {
        h0.g0(this.f3898f == null);
        if (this.f3893a) {
            long j10 = this.f3896d;
            h0.s0(j10 == -1, "weigher can not be combined with maximum size (%s provided)", j10);
        }
        weigher.getClass();
        this.f3898f = weigher;
        return this;
    }

    public <K1 extends K, V1 extends V> e1.c<K1, V1> a() {
        d();
        c();
        return new m.o(this);
    }

    public <K1 extends K, V1 extends V> l<K1, V1> b(g<? super K1, V1> loader) {
        d();
        return new m.n(this, loader);
    }

    public final void c() {
        h0.h0(this.f3903k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void d() {
        if (this.f3898f == null) {
            h0.h0(this.f3897e == -1, "maximumWeight requires weigher");
        } else if (this.f3893a) {
            h0.h0(this.f3897e != -1, "weigher requires maximumWeight");
        } else if (this.f3897e == -1) {
            C0090d.f3909a.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @t1.a
    public d<K, V> e(int concurrencyLevel) {
        int i10 = this.f3895c;
        h0.n0(i10 == -1, "concurrency level was already set to %s", i10);
        h0.d(concurrencyLevel > 0);
        this.f3895c = concurrencyLevel;
        return this;
    }

    @t1.a
    public d<K, V> f(long duration, TimeUnit unit) {
        long j10 = this.f3902j;
        h0.s0(j10 == -1, "expireAfterAccess was already set to %s ns", j10);
        h0.t(duration >= 0, "duration cannot be negative: %s %s", duration, unit);
        this.f3902j = unit.toNanos(duration);
        return this;
    }

    @t1.a
    public d<K, V> g(long duration, TimeUnit unit) {
        long j10 = this.f3901i;
        h0.s0(j10 == -1, "expireAfterWrite was already set to %s ns", j10);
        h0.t(duration >= 0, "duration cannot be negative: %s %s", duration, unit);
        this.f3901i = unit.toNanos(duration);
        return this;
    }

    public int j() {
        int i10 = this.f3895c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public long k() {
        long j10 = this.f3902j;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public long l() {
        long j10 = this.f3901i;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public int m() {
        int i10 = this.f3894b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public c1.m<Object> n() {
        return (c1.m) c1.z.a(this.f3904l, o().defaultEquivalence());
    }

    public m.t o() {
        return (m.t) c1.z.a(this.f3899g, m.t.STRONG);
    }

    public long p() {
        if (this.f3901i == 0 || this.f3902j == 0) {
            return 0L;
        }
        return this.f3898f == null ? this.f3896d : this.f3897e;
    }

    public long q() {
        long j10 = this.f3903k;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public <K1 extends K, V1 extends V> v<K1, V1> r() {
        return (v) c1.z.a(this.f3906n, e.INSTANCE);
    }

    public q0<? extends e1.a.b> s() {
        return this.f3908p;
    }

    public u0 t(boolean recordsTime) {
        u0 u0Var = this.f3907o;
        if (u0Var != null) {
            return u0Var;
        }
        return recordsTime ? u0.b() : f3891x;
    }

    public String toString() {
        c1.z.b bVarC = c1.z.c(this);
        int i10 = this.f3894b;
        if (i10 != -1) {
            bVarC.d("initialCapacity", i10);
        }
        int i11 = this.f3895c;
        if (i11 != -1) {
            bVarC.d("concurrencyLevel", i11);
        }
        long j10 = this.f3896d;
        if (j10 != -1) {
            bVarC.e("maximumSize", j10);
        }
        long j11 = this.f3897e;
        if (j11 != -1) {
            bVarC.e("maximumWeight", j11);
        }
        if (this.f3901i != -1) {
            bVarC.j("expireAfterWrite", k.d.a(new StringBuilder(), this.f3901i, "ns"));
        }
        if (this.f3902j != -1) {
            bVarC.j("expireAfterAccess", k.d.a(new StringBuilder(), this.f3902j, "ns"));
        }
        m.t tVar = this.f3899g;
        if (tVar != null) {
            bVarC.j("keyStrength", c1.c.g(tVar.toString()));
        }
        m.t tVar2 = this.f3900h;
        if (tVar2 != null) {
            bVarC.j("valueStrength", c1.c.g(tVar2.toString()));
        }
        if (this.f3904l != null) {
            bVarC.s("keyEquivalence");
        }
        if (this.f3905m != null) {
            bVarC.s("valueEquivalence");
        }
        if (this.f3906n != null) {
            bVarC.s("removalListener");
        }
        return bVarC.toString();
    }

    public c1.m<Object> u() {
        return (c1.m) c1.z.a(this.f3905m, v().defaultEquivalence());
    }

    public m.t v() {
        return (m.t) c1.z.a(this.f3900h, m.t.STRONG);
    }

    public <K1 extends K, V1 extends V> b0<K1, V1> w() {
        return (b0) c1.z.a(this.f3898f, f.INSTANCE);
    }

    @t1.a
    public d<K, V> x(int initialCapacity) {
        int i10 = this.f3894b;
        h0.n0(i10 == -1, "initial capacity was already set to %s", i10);
        h0.d(initialCapacity >= 0);
        this.f3894b = initialCapacity;
        return this;
    }

    public boolean y() {
        return this.f3908p == f3890w;
    }

    @b1.c
    @t1.a
    public d<K, V> z(c1.m<Object> equivalence) {
        c1.m<Object> mVar = this.f3904l;
        h0.x0(mVar == null, "key equivalence was already set to %s", mVar);
        equivalence.getClass();
        this.f3904l = equivalence;
        return this;
    }
}
