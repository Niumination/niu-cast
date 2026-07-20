package yj;

import io.netty.channel.ChannelHandler;
import io.netty.util.AsciiString;
import java.util.concurrent.Executor;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
public interface y0 {

    public interface a {
        y0 a();

        int b();
    }

    public interface b {
        y0 a(z1<? extends Executor> z1Var);
    }

    ChannelHandler a(l lVar);

    void close();

    AsciiString scheme();
}
