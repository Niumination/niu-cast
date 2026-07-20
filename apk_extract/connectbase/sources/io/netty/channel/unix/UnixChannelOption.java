package io.netty.channel.unix;

import io.netty.channel.ChannelOption;
import sk.w;

/* JADX INFO: loaded from: classes2.dex */
public class UnixChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> SO_REUSEPORT = ChannelOption.valueOf(UnixChannelOption.class, w.f15160a);
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(UnixChannelOption.class, "DOMAIN_SOCKET_READ_MODE");

    public UnixChannelOption() {
        super(null);
    }

    public UnixChannelOption(String str) {
        super(str);
    }
}
