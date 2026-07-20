package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SuppressJava6Requirement(reason = "Usage explicit by the user")
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    private NioChannelOption(SocketOption<T> socketOption) {
        super(socketOption.name());
        this.option = socketOption;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return null;
        }
        if ((networkChannel instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return (T) networkChannel.getOption(((NioChannelOption) nioChannelOption).option);
        } catch (IOException e10) {
            throw new ChannelException(e10);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ChannelOption[] getOptions(Channel channel) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        Set<SocketOption<?>> setSupportedOptions = networkChannel.supportedOptions();
        int i10 = 0;
        if (!(networkChannel instanceof ServerSocketChannel)) {
            ChannelOption[] channelOptionArr = new ChannelOption[setSupportedOptions.size()];
            Iterator<SocketOption<?>> it = setSupportedOptions.iterator();
            while (it.hasNext()) {
                channelOptionArr[i10] = new NioChannelOption(it.next());
                i10++;
            }
            return channelOptionArr;
        }
        ArrayList arrayList = new ArrayList(setSupportedOptions.size());
        for (SocketOption<?> socketOption : setSupportedOptions) {
            if (socketOption != StandardSocketOptions.IP_TOS) {
                arrayList.add(new NioChannelOption(socketOption));
            }
        }
        return (ChannelOption[]) arrayList.toArray(new ChannelOption[0]);
    }

    public static <T> ChannelOption<T> of(SocketOption<T> socketOption) {
        return new NioChannelOption(socketOption);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t10) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return false;
        }
        if ((networkChannel instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            networkChannel.setOption(((NioChannelOption) nioChannelOption).option, t10);
            return true;
        } catch (IOException e10) {
            throw new ChannelException(e10);
        }
    }
}
