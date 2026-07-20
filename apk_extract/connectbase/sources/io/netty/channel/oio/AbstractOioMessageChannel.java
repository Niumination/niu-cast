package io.netty.channel.oio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List<Object> readBuf;

    public AbstractOioMessageChannel(Channel channel) {
        super(channel);
        this.readBuf = new ArrayList();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    public void doRead() {
        Throwable th2;
        boolean z10;
        if (this.readPending) {
            boolean z11 = false;
            this.readPending = false;
            ChannelConfig channelConfigConfig = config();
            ChannelPipeline channelPipelinePipeline = pipeline();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            while (true) {
                try {
                    int iDoReadMessages = doReadMessages(this.readBuf);
                    if (iDoReadMessages != 0) {
                        if (iDoReadMessages < 0) {
                            z10 = true;
                            break;
                        } else {
                            handleRecvBufAllocHandle.incMessagesRead(iDoReadMessages);
                            if (!handleRecvBufAllocHandle.continueReading()) {
                            }
                        }
                    }
                    z10 = false;
                    break;
                } catch (Throwable th3) {
                    th2 = th3;
                    z10 = false;
                }
            }
            th2 = null;
            int size = this.readBuf.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    this.readPending = false;
                    channelPipelinePipeline.fireChannelRead(this.readBuf.get(i10));
                }
                this.readBuf.clear();
                handleRecvBufAllocHandle.readComplete();
                channelPipelinePipeline.fireChannelReadComplete();
                z11 = true;
            }
            if (th2 != null) {
                boolean z12 = th2 instanceof IOException ? true : z10;
                channelPipelinePipeline.fireExceptionCaught(th2);
                z10 = z12;
            }
            if (z10) {
                if (isOpen()) {
                    unsafe().close(unsafe().voidPromise());
                }
            } else if (this.readPending || channelConfigConfig.isAutoRead() || (!z11 && isActive())) {
                read();
            }
        }
    }

    public abstract int doReadMessages(List<Object> list) throws Exception;
}
