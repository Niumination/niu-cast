package al;

import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueue;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import kn.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final un.d<? extends ServerSocketChannel> b() {
        if (KQueue.isAvailable()) {
            return l1.d(KQueueServerSocketChannel.class);
        }
        return l1.d(Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class);
    }
}
