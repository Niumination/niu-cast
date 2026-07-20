package yj;

import io.netty.channel.ChannelHandler;
import io.netty.util.AsciiString;
import java.util.concurrent.Executor;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class y {

    public interface a extends y0.a {
        @Override // yj.y0.a
        b a();
    }

    public interface b extends y0 {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0 f21304a;

        public c(y0 y0Var) {
            this.f21304a = (y0) c1.h0.F(y0Var, "negotiator");
        }

        @Override // yj.y0
        public ChannelHandler a(l lVar) {
            return this.f21304a.a(lVar);
        }

        @Override // yj.y0
        public void close() {
            this.f21304a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21304a.scheme();
        }
    }

    public interface d extends y0.b {
        @Override // yj.y0.b
        b a(z1<? extends Executor> z1Var);

        @Override // yj.y0.b
        /* bridge */ /* synthetic */ default y0 a(z1 z1Var) {
            return a((z1<? extends Executor>) z1Var);
        }
    }
}
