package wj;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public interface d1 {
    @gm.j
    vj.a1<vj.v0.l> b();

    SocketAddress g();

    @gm.j
    List<vj.a1<vj.v0.l>> h();

    void i(y2 y2Var) throws IOException;

    List<? extends SocketAddress> l();

    void shutdown();
}
