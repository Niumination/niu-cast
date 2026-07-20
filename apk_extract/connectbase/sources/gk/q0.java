package gk;

import ik.l1;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kn.m1;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements l1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f6691h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final gk.a f6692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final gk.a f6693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final gk.a f6694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final gk.a f6695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final gk.a f6696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final gk.a f6697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final gk.a f6698g;

    public static final class a extends kn.n0 implements jn.a<String> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return this.$delegate.b();
        }
    }

    public static final class b extends kn.n0 implements jn.a<ik.p0> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final ik.p0 invoke() {
            return this.$delegate.getMethod();
        }
    }

    public static final class c extends kn.n0 implements jn.a<Integer> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Integer invoke() {
            return Integer.valueOf(this.$delegate.a());
        }
    }

    public static final class d extends kn.n0 implements jn.a<String> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return this.$delegate.c();
        }
    }

    public static final class e extends kn.n0 implements jn.a<String> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return this.$delegate.d();
        }
    }

    public static final class f extends kn.n0 implements jn.a<String> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return this.$delegate.getUri();
        }
    }

    public static final class g extends kn.n0 implements jn.a<String> {
        final /* synthetic */ l1 $delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(l1 l1Var) {
            super(0);
            this.$delegate = l1Var;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return this.$delegate.getVersion();
        }
    }

    static {
        un.l lVarK = kn.l1.k(new kn.x0(q0.class, lb.f.f9782f, "getVersion()Ljava/lang/String;", 0));
        kn.x0 x0Var = new kn.x0(q0.class, "uri", "getUri()Ljava/lang/String;", 0);
        m1 m1Var = kn.l1.f9319a;
        f6691h = new un.o[]{lVarK, m1Var.i(x0Var), m1Var.i(new kn.x0(q0.class, "method", "getMethod()Lio/ktor/http/HttpMethod;", 0)), m1Var.i(new kn.x0(q0.class, "scheme", "getScheme()Ljava/lang/String;", 0)), m1Var.i(new kn.x0(q0.class, "host", "getHost()Ljava/lang/String;", 0)), m1Var.i(new kn.x0(q0.class, RtspHeaders.Values.PORT, "getPort()I", 0)), m1Var.i(new kn.x0(q0.class, "remoteHost", "getRemoteHost()Ljava/lang/String;", 0))};
    }

    @lm.k(level = lm.m.WARNING, message = "Instantiating CP is no longer supported: this will become internal.")
    public q0(@os.l l1 l1Var) {
        kn.l0.p(l1Var, "delegate");
        this.f6692a = new gk.a(new g(l1Var));
        this.f6693b = new gk.a(new f(l1Var));
        this.f6694c = new gk.a(new b(l1Var));
        this.f6695d = new gk.a(new e(l1Var));
        this.f6696e = new gk.a(new a(l1Var));
        this.f6697f = new gk.a(new c(l1Var));
        this.f6698g = new gk.a(new d(l1Var));
    }

    @Override // ik.l1
    public int a() {
        return ((Number) this.f6697f.b(this, f6691h[5])).intValue();
    }

    @Override // ik.l1
    @os.l
    public String b() {
        return (String) this.f6696e.b(this, f6691h[4]);
    }

    @Override // ik.l1
    @os.l
    public String c() {
        return (String) this.f6698g.b(this, f6691h[6]);
    }

    @Override // ik.l1
    @os.l
    public String d() {
        return (String) this.f6695d.b(this, f6691h[3]);
    }

    public void e(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f6696e.c(this, f6691h[4], str);
    }

    public void f(@os.l ik.p0 p0Var) {
        kn.l0.p(p0Var, "<set-?>");
        this.f6694c.c(this, f6691h[2], p0Var);
    }

    public void g(int i10) {
        this.f6697f.c(this, f6691h[5], Integer.valueOf(i10));
    }

    @Override // ik.l1
    @os.l
    public ik.p0 getMethod() {
        return (ik.p0) this.f6694c.b(this, f6691h[2]);
    }

    @Override // ik.l1
    @os.l
    public String getUri() {
        return (String) this.f6693b.b(this, f6691h[1]);
    }

    @Override // ik.l1
    @os.l
    public String getVersion() {
        return (String) this.f6692a.b(this, f6691h[0]);
    }

    public void h(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f6698g.c(this, f6691h[6], str);
    }

    public void i(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f6695d.c(this, f6691h[3], str);
    }

    public void j(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f6693b.c(this, f6691h[1], str);
    }

    public void k(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f6692a.c(this, f6691h[0], str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q0(@os.l t0 t0Var) {
        this((l1) t0Var);
        kn.l0.p(t0Var, "delegate");
    }
}
