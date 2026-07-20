package vj;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class r2 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j2<?> f17256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17257b;

        public a(j2<?> j2Var, String str) {
            this.f17256a = j2Var;
            this.f17257b = str;
        }

        public static a a(String str) {
            str.getClass();
            return new a(null, str);
        }

        public static a d(j2<?> j2Var) {
            j2Var.getClass();
            return new a(j2Var, null);
        }

        public String b() {
            return this.f17257b;
        }

        public j2<?> c() {
            return this.f17256a;
        }
    }

    public static r2 e() {
        r2 r2VarF = s2.c().f();
        if (r2VarF != null) {
            return r2VarF;
        }
        throw new t1.b("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    public abstract j2<?> a(int i10);

    public abstract boolean b();

    public a c(int i10, n2 n2Var) {
        return a.a("ServerCredentials are unsupported");
    }

    public abstract int d();
}
