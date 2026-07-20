package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdyWindowUpdateFrame implements SpdyWindowUpdateFrame {
    private int deltaWindowSize;
    private int streamId;

    public DefaultSpdyWindowUpdateFrame(int i10, int i11) {
        setStreamId(i10);
        setDeltaWindowSize(i11);
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int deltaWindowSize() {
        return this.deltaWindowSize;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setDeltaWindowSize(int i10) {
        ObjectUtil.checkPositive(i10, "deltaWindowSize");
        this.deltaWindowSize = i10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setStreamId(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "streamId");
        this.streamId = i10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int streamId() {
        return this.streamId;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb2.append(str);
        sb2.append("--> Stream-ID = ");
        sb2.append(streamId());
        sb2.append(str);
        sb2.append("--> Delta-Window-Size = ");
        sb2.append(deltaWindowSize());
        return sb2.toString();
    }
}
