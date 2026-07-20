package io.netty.buffer;

import io.netty.util.ReferenceCounted;

/* JADX INFO: loaded from: classes2.dex */
public interface ByteBufHolder extends ReferenceCounted {
    ByteBuf content();

    ByteBufHolder copy();

    ByteBufHolder duplicate();

    ByteBufHolder replace(ByteBuf byteBuf);

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain(int i10);

    ByteBufHolder retainedDuplicate();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch(Object obj);
}
