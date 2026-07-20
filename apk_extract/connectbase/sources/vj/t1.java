package vj;

import java.net.SocketAddress;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class t1 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s1<?> f17265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17266b;

        public a(s1<?> s1Var, String str) {
            this.f17265a = s1Var;
            this.f17266b = str;
        }

        public static a a(s1<?> s1Var) {
            s1Var.getClass();
            return new a(s1Var, null);
        }

        public static a b(String str) {
            str.getClass();
            return new a(null, str);
        }

        public s1<?> c() {
            return this.f17265a;
        }

        public String d() {
            return this.f17266b;
        }
    }

    public static final class b extends RuntimeException {
        private static final long serialVersionUID = 1;

        public b(String str) {
            super(str);
        }
    }

    public static t1 g() {
        t1 t1VarG = u1.c().g();
        if (t1VarG != null) {
            return t1VarG;
        }
        throw new b("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract s1<?> a(String str, int i10);

    public abstract s1<?> b(String str);

    public abstract Collection<Class<? extends SocketAddress>> c();

    public abstract boolean d();

    public a e(String str, g gVar) {
        return a.b("ChannelCredentials are unsupported");
    }

    public abstract int f();
}
