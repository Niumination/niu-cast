package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import java.io.IOException;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public final class KQueueDomainSocketChannel extends AbstractKQueueStreamChannel implements DomainSocketChannel {
    private final KQueueDomainSocketChannelConfig config;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    /* JADX INFO: renamed from: io.netty.channel.kqueue.KQueueDomainSocketChannel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$unix$DomainSocketReadMode;

        static {
            int[] iArr = new int[DomainSocketReadMode.values().length];
            $SwitchMap$io$netty$channel$unix$DomainSocketReadMode = iArr;
            try {
                iArr[DomainSocketReadMode.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$unix$DomainSocketReadMode[DomainSocketReadMode.FILE_DESCRIPTORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final class KQueueDomainUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueDomainUnsafe() {
            super();
        }

        private void readReadyFd() {
            if (KQueueDomainSocketChannel.this.socket.isInputShutdown()) {
                clearReadFilter0();
                return;
            }
            KQueueDomainSocketChannelConfig kQueueDomainSocketChannelConfigConfig = KQueueDomainSocketChannel.this.config();
            KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            ChannelPipeline channelPipelinePipeline = KQueueDomainSocketChannel.this.pipeline();
            kQueueRecvByteAllocatorHandleRecvBufAllocHandle.reset(kQueueDomainSocketChannelConfigConfig);
            readReadyBefore();
            do {
                try {
                    int iRecvFd = KQueueDomainSocketChannel.this.socket.recvFd();
                    if (iRecvFd == -1) {
                        kQueueRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(-1);
                        close(voidPromise());
                        readReadyFinally(kQueueDomainSocketChannelConfigConfig);
                        return;
                    } else {
                        if (iRecvFd == 0) {
                            kQueueRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(0);
                            break;
                        }
                        kQueueRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(1);
                        kQueueRecvByteAllocatorHandleRecvBufAllocHandle.incMessagesRead(1);
                        this.readPending = false;
                        channelPipelinePipeline.fireChannelRead((Object) new FileDescriptor(iRecvFd));
                    }
                } catch (Throwable th2) {
                    try {
                        kQueueRecvByteAllocatorHandleRecvBufAllocHandle.readComplete();
                        channelPipelinePipeline.fireChannelReadComplete();
                        channelPipelinePipeline.fireExceptionCaught(th2);
                    } finally {
                        readReadyFinally(kQueueDomainSocketChannelConfigConfig);
                    }
                }
            } while (kQueueRecvByteAllocatorHandleRecvBufAllocHandle.continueReading());
            kQueueRecvByteAllocatorHandleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        public void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            int i10 = AnonymousClass1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[KQueueDomainSocketChannel.this.config().getReadMode().ordinal()];
            if (i10 == 1) {
                super.readReady(kQueueRecvByteAllocatorHandle);
            } else {
                if (i10 != 2) {
                    throw new Error();
                }
                readReadyFd();
            }
        }

        public /* synthetic */ KQueueDomainUnsafe(KQueueDomainSocketChannel kQueueDomainSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public KQueueDomainSocketChannel() {
        super((Channel) null, BsdSocket.newSocketDomain(), false);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.local = (DomainSocketAddress) socketAddress2;
        this.remote = (DomainSocketAddress) socketAddress;
        return true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel
    public int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object objCurrent = channelOutboundBuffer.current();
        if (!(objCurrent instanceof FileDescriptor) || this.socket.sendFd(((FileDescriptor) objCurrent).intValue()) <= 0) {
            return super.doWriteSingle(channelOutboundBuffer);
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        return obj instanceof FileDescriptor ? obj : super.filterOutboundMessage(obj);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainUnsafe(this, null);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    public KQueueDomainSocketChannel(int i10) {
        this(null, new BsdSocket(i10));
    }

    public KQueueDomainSocketChannel(Channel channel, BsdSocket bsdSocket) {
        super(channel, bsdSocket, true);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDomainSocketChannelConfig config() {
        return this.config;
    }
}
