package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class q3 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f19190m = new b(n3.f19104a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3 f19191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f19194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f19197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f19198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l1 f19201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f19202l;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n3 f19203a;

        @b1.e
        public b(n3 n3Var) {
            this.f19203a = n3Var;
        }

        public q3 a() {
            return new q3(this.f19203a);
        }
    }

    public interface c {
        d read();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19205b;

        public d(long j10, long j11) {
            this.f19205b = j10;
            this.f19204a = j11;
        }
    }

    public static b a() {
        return f19190m;
    }

    public vj.v0.o b() {
        c cVar = this.f19198h;
        long j10 = cVar == null ? -1L : cVar.read().f19205b;
        c cVar2 = this.f19198h;
        return new vj.v0.o(this.f19192b, this.f19193c, this.f19194d, this.f19195e, this.f19196f, this.f19199i, this.f19201k.value(), this.f19197g, this.f19200j, this.f19202l, j10, cVar2 != null ? cVar2.read().f19204a : -1L);
    }

    public void c() {
        this.f19197g++;
    }

    public void d() {
        this.f19192b++;
        this.f19193c = this.f19191a.a();
    }

    public void e() {
        this.f19201k.add(1L);
        this.f19202l = this.f19191a.a();
    }

    public void f(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f19199i += (long) i10;
        this.f19200j = this.f19191a.a();
    }

    public void g() {
        this.f19192b++;
        this.f19194d = this.f19191a.a();
    }

    public void h(boolean z10) {
        if (z10) {
            this.f19195e++;
        } else {
            this.f19196f++;
        }
    }

    public void i(c cVar) {
        cVar.getClass();
        this.f19198h = cVar;
    }

    public q3() {
        this.f19201k = m1.a();
        this.f19191a = n3.f19104a;
    }

    public q3(n3 n3Var) {
        this.f19201k = m1.a();
        this.f19191a = n3Var;
    }
}
