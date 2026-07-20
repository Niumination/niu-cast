package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {
    protected final B bootstrap;

    public AbstractBootstrapConfig(B b10) {
        this.bootstrap = (B) ObjectUtil.checkNotNull(b10, "bootstrap");
    }

    public final Map<AttributeKey<?>, Object> attrs() {
        return this.bootstrap.attrs();
    }

    public final ChannelFactory<? extends C> channelFactory() {
        return this.bootstrap.channelFactory();
    }

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }

    public final ChannelHandler handler() {
        return this.bootstrap.handler();
    }

    public final SocketAddress localAddress() {
        return this.bootstrap.localAddress();
    }

    public final Map<ChannelOption<?>, Object> options() {
        return this.bootstrap.options();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('(');
        EventLoopGroup eventLoopGroupGroup = group();
        if (eventLoopGroupGroup != null) {
            sb2.append("group: ");
            sb2.append(StringUtil.simpleClassName(eventLoopGroupGroup));
            sb2.append(", ");
        }
        ChannelFactory<? extends C> channelFactory = channelFactory();
        if (channelFactory != null) {
            sb2.append("channelFactory: ");
            sb2.append(channelFactory);
            sb2.append(", ");
        }
        SocketAddress socketAddressLocalAddress = localAddress();
        if (socketAddressLocalAddress != null) {
            sb2.append("localAddress: ");
            sb2.append(socketAddressLocalAddress);
            sb2.append(", ");
        }
        Map<ChannelOption<?>, Object> mapOptions = options();
        if (!mapOptions.isEmpty()) {
            sb2.append("options: ");
            sb2.append(mapOptions);
            sb2.append(", ");
        }
        Map<AttributeKey<?>, Object> mapAttrs = attrs();
        if (!mapAttrs.isEmpty()) {
            sb2.append("attrs: ");
            sb2.append(mapAttrs);
            sb2.append(", ");
        }
        ChannelHandler channelHandlerHandler = handler();
        if (channelHandlerHandler != null) {
            sb2.append("handler: ");
            sb2.append(channelHandlerHandler);
            sb2.append(", ");
        }
        if (sb2.charAt(sb2.length() - 1) == '(') {
            sb2.append(')');
        } else {
            sb2.setCharAt(sb2.length() - 2, ')');
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }
}
