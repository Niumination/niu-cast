package f1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
@b1.d
public final class r4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5217g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5218h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5219i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5221b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5222c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.a
    public s4.q f5223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public s4.q f5224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    public c1.m<Object> f5225f;

    public enum a {
        VALUE;

        public static /* synthetic */ a[] a() {
            return new a[]{VALUE};
        }
    }

    @t1.a
    public r4 a(int concurrencyLevel) {
        int i10 = this.f5222c;
        c1.h0.n0(i10 == -1, "concurrency level was already set to %s", i10);
        c1.h0.d(concurrencyLevel > 0);
        this.f5222c = concurrencyLevel;
        return this;
    }

    public int b() {
        int i10 = this.f5222c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public int c() {
        int i10 = this.f5221b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public c1.m<Object> d() {
        return (c1.m) c1.z.a(this.f5225f, e().defaultEquivalence());
    }

    public s4.q e() {
        return (s4.q) c1.z.a(this.f5223d, s4.q.STRONG);
    }

    public s4.q f() {
        return (s4.q) c1.z.a(this.f5224e, s4.q.STRONG);
    }

    @t1.a
    public r4 g(int initialCapacity) {
        int i10 = this.f5221b;
        c1.h0.n0(i10 == -1, "initial capacity was already set to %s", i10);
        c1.h0.d(initialCapacity >= 0);
        this.f5221b = initialCapacity;
        return this;
    }

    @b1.c
    @t1.a
    public r4 h(c1.m<Object> equivalence) {
        c1.m<Object> mVar = this.f5225f;
        c1.h0.x0(mVar == null, "key equivalence was already set to %s", mVar);
        equivalence.getClass();
        this.f5225f = equivalence;
        this.f5220a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f5220a ? new ConcurrentHashMap(c(), 0.75f, b()) : s4.create(this);
    }

    public r4 j(s4.q strength) {
        s4.q qVar = this.f5223d;
        c1.h0.x0(qVar == null, "Key strength was already set to %s", qVar);
        strength.getClass();
        this.f5223d = strength;
        if (strength != s4.q.STRONG) {
            this.f5220a = true;
        }
        return this;
    }

    public r4 k(s4.q strength) {
        s4.q qVar = this.f5224e;
        c1.h0.x0(qVar == null, "Value strength was already set to %s", qVar);
        strength.getClass();
        this.f5224e = strength;
        if (strength != s4.q.STRONG) {
            this.f5220a = true;
        }
        return this;
    }

    @b1.c
    @t1.a
    public r4 l() {
        return j(s4.q.WEAK);
    }

    @b1.c
    @t1.a
    public r4 m() {
        return k(s4.q.WEAK);
    }

    public String toString() {
        c1.z.b bVarC = c1.z.c(this);
        int i10 = this.f5221b;
        if (i10 != -1) {
            bVarC.d("initialCapacity", i10);
        }
        int i11 = this.f5222c;
        if (i11 != -1) {
            bVarC.d("concurrencyLevel", i11);
        }
        s4.q qVar = this.f5223d;
        if (qVar != null) {
            bVarC.j("keyStrength", c1.c.g(qVar.toString()));
        }
        s4.q qVar2 = this.f5224e;
        if (qVar2 != null) {
            bVarC.j("valueStrength", c1.c.g(qVar2.toString()));
        }
        if (this.f5225f != null) {
            bVarC.s("keyEquivalence");
        }
        return bVarC.toString();
    }
}
