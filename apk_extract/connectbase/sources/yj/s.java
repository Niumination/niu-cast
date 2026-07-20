package yj;

import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;
import wj.g3;
import wj.q3;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class s {

    public class a implements y0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21291a;

        public a(b bVar) {
            this.f21291a = bVar;
        }

        @Override // yj.y0.a
        public y0 a() {
            return this.f21291a.a();
        }

        @Override // yj.y0.a
        public int b() {
            return wj.v0.f19368n;
        }
    }

    public interface b {
        y.b a();
    }

    public static wj.v a(e0 e0Var) {
        return e0Var.N();
    }

    public static void b(e0 e0Var) {
        e0Var.T();
    }

    public static void c(e0 e0Var) {
        e0Var.U();
    }

    public static void d(e0 e0Var, b bVar) {
        e0Var.q0(new a(bVar));
    }

    public static void e(e0 e0Var, y.a aVar) {
        e0Var.q0(aVar);
    }

    public static void f(e0 e0Var, boolean z10) {
        e0Var.f20900a.C = z10;
    }

    public static void g(e0 e0Var, boolean z10) {
        e0Var.f20900a.E = z10;
    }

    public static void h(e0 e0Var, boolean z10) {
        e0Var.f20900a.F = z10;
    }

    public static void i(e0 e0Var, boolean z10) {
        e0Var.f20900a.G = z10;
    }

    public static void j(e0 e0Var, boolean z10) {
        e0Var.f20900a.D = z10;
    }

    public static void k(e0 e0Var, boolean z10) {
        e0Var.f20900a.H = z10;
    }

    @b1.e
    public static void l(e0 e0Var, q3.b bVar) {
        e0Var.f20901b = bVar;
    }

    public static void m(e0 e0Var) {
        e0Var.R(NioSocketChannel.class, InetSocketAddress.class);
        e0Var.W(new g3(i1.f21000m));
    }
}
