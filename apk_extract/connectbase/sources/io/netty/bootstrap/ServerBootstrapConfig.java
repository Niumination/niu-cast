package io.netty.bootstrap;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.internal.StringUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ServerBootstrapConfig extends AbstractBootstrapConfig<ServerBootstrap, ServerChannel> {
    public ServerBootstrapConfig(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
    }

    public Map<AttributeKey<?>, Object> childAttrs() {
        return ((ServerBootstrap) this.bootstrap).childAttrs();
    }

    public EventLoopGroup childGroup() {
        return ((ServerBootstrap) this.bootstrap).childGroup();
    }

    public ChannelHandler childHandler() {
        return ((ServerBootstrap) this.bootstrap).childHandler();
    }

    public Map<ChannelOption<?>, Object> childOptions() {
        return ((ServerBootstrap) this.bootstrap).childOptions();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.setLength(sb2.length() - 1);
        sb2.append(", ");
        EventLoopGroup eventLoopGroupChildGroup = childGroup();
        if (eventLoopGroupChildGroup != null) {
            sb2.append("childGroup: ");
            sb2.append(StringUtil.simpleClassName(eventLoopGroupChildGroup));
            sb2.append(", ");
        }
        Map<ChannelOption<?>, Object> mapChildOptions = childOptions();
        if (!mapChildOptions.isEmpty()) {
            sb2.append("childOptions: ");
            sb2.append(mapChildOptions);
            sb2.append(", ");
        }
        Map<AttributeKey<?>, Object> mapChildAttrs = childAttrs();
        if (!mapChildAttrs.isEmpty()) {
            sb2.append("childAttrs: ");
            sb2.append(mapChildAttrs);
            sb2.append(", ");
        }
        ChannelHandler channelHandlerChildHandler = childHandler();
        if (channelHandlerChildHandler != null) {
            sb2.append("childHandler: ");
            sb2.append(channelHandlerChildHandler);
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
