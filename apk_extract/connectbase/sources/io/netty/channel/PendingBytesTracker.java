package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes2.dex */
abstract class PendingBytesTracker implements MessageSizeEstimator.Handle {
    private final MessageSizeEstimator.Handle estimatorHandle;

    public static final class ChannelOutboundBufferPendingBytesTracker extends PendingBytesTracker {
        private final ChannelOutboundBuffer buffer;

        public ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer channelOutboundBuffer, MessageSizeEstimator.Handle handle) {
            super(handle);
            this.buffer = channelOutboundBuffer;
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j10) {
            this.buffer.decrementPendingOutboundBytes(j10);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j10) {
            this.buffer.incrementPendingOutboundBytes(j10);
        }
    }

    public static final class DefaultChannelPipelinePendingBytesTracker extends PendingBytesTracker {
        private final DefaultChannelPipeline pipeline;

        public DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline.estimatorHandle());
            this.pipeline = defaultChannelPipeline;
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j10) {
            this.pipeline.decrementPendingOutboundBytes(j10);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j10) {
            this.pipeline.incrementPendingOutboundBytes(j10);
        }
    }

    public static final class NoopPendingBytesTracker extends PendingBytesTracker {
        public NoopPendingBytesTracker(MessageSizeEstimator.Handle handle) {
            super(handle);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j10) {
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j10) {
        }
    }

    public static PendingBytesTracker newTracker(Channel channel) {
        if (channel.pipeline() instanceof DefaultChannelPipeline) {
            return new DefaultChannelPipelinePendingBytesTracker((DefaultChannelPipeline) channel.pipeline());
        }
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = channel.unsafe().outboundBuffer();
        MessageSizeEstimator.Handle handleNewHandle = channel.config().getMessageSizeEstimator().newHandle();
        return channelOutboundBufferOutboundBuffer == null ? new NoopPendingBytesTracker(handleNewHandle) : new ChannelOutboundBufferPendingBytesTracker(channelOutboundBufferOutboundBuffer, handleNewHandle);
    }

    public abstract void decrementPendingOutboundBytes(long j10);

    public abstract void incrementPendingOutboundBytes(long j10);

    @Override // io.netty.channel.MessageSizeEstimator.Handle
    public final int size(Object obj) {
        return this.estimatorHandle.size(obj);
    }

    private PendingBytesTracker(MessageSizeEstimator.Handle handle) {
        this.estimatorHandle = (MessageSizeEstimator.Handle) ObjectUtil.checkNotNull(handle, "estimatorHandle");
    }
}
