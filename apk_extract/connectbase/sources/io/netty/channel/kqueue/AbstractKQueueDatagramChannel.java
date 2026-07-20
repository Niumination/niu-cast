package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractKQueueDatagramChannel extends AbstractKQueueChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);

    public AbstractKQueueDatagramChannel(Channel channel, BsdSocket bsdSocket, boolean z10) {
        super(channel, bsdSocket, z10);
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int iMaxMessagesPerWrite = maxMessagesPerWrite();
        loop0: while (iMaxMessagesPerWrite > 0) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                break;
            }
            try {
                int writeSpinCount = config().getWriteSpinCount();
                while (true) {
                    if (writeSpinCount <= 0) {
                        break loop0;
                    }
                    if (doWriteMessage(objCurrent)) {
                        channelOutboundBuffer.remove();
                        iMaxMessagesPerWrite--;
                        break;
                    }
                    writeSpinCount--;
                }
            } catch (IOException e10) {
                iMaxMessagesPerWrite--;
                channelOutboundBuffer.remove(e10);
            }
        }
        writeFilter(!channelOutboundBuffer.isEmpty());
    }

    public abstract boolean doWriteMessage(Object obj) throws Exception;

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }
}
