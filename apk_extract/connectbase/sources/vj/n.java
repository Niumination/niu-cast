package vj;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/2861")
public abstract class n extends b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e.c<Long> f17186a = e.c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    public static abstract class a {
        public n a(b bVar, v1 v1Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/2861")
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f17187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17189c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public e f17190a = e.f17085l;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f17191b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f17192c;

            public b a() {
                return new b(this.f17190a, this.f17191b, this.f17192c);
            }

            public a b(e eVar) {
                this.f17190a = (e) c1.h0.F(eVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f17192c = z10;
                return this;
            }

            public a d(int i10) {
                this.f17191b = i10;
                return this;
            }
        }

        public b(e eVar, int i10, boolean z10) {
            this.f17187a = (e) c1.h0.F(eVar, "callOptions");
            this.f17188b = i10;
            this.f17189c = z10;
        }

        public static a d() {
            return new a();
        }

        public e a() {
            return this.f17187a;
        }

        public int b() {
            return this.f17188b;
        }

        public boolean c() {
            return this.f17189c;
        }

        public a e() {
            a aVarB = new a().b(this.f17187a);
            aVarB.f17191b = this.f17188b;
            aVarB.f17192c = this.f17189c;
            return aVarB;
        }

        public String toString() {
            return c1.z.c(this).j("callOptions", this.f17187a).d("previousAttempts", this.f17188b).g("isTransparentRetry", this.f17189c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l(v1 v1Var) {
    }

    public void m() {
    }

    public void n(vj.a aVar, v1 v1Var) {
    }
}
