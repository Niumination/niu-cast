package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class CoalescingBufferQueue extends AbstractCoalescingBufferQueue {
    private final Channel channel;

    public CoalescingBufferQueue(Channel channel) {
        this(channel, 4);
    }

    @Override // io.netty.channel.AbstractCoalescingBufferQueue
    public ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (!(byteBuf instanceof CompositeByteBuf)) {
            return composeIntoComposite(byteBufAllocator, byteBuf, byteBuf2);
        }
        CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
        compositeByteBuf.addComponent(true, byteBuf2);
        return compositeByteBuf;
    }

    public void releaseAndFailAll(Throwable th2) {
        releaseAndFailAll(this.channel, th2);
    }

    public ByteBuf remove(int i10, ChannelPromise channelPromise) {
        return remove(this.channel.alloc(), i10, channelPromise);
    }

    @Override // io.netty.channel.AbstractCoalescingBufferQueue
    public ByteBuf removeEmptyValue() {
        return Unpooled.EMPTY_BUFFER;
    }

    public CoalescingBufferQueue(Channel channel, int i10) {
        this(channel, i10, false);
    }

    public CoalescingBufferQueue(Channel channel, int i10, boolean z10) {
        super(z10 ? channel : null, i10);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }
}
