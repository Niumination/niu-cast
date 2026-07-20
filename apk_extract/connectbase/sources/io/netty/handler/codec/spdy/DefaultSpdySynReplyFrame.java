package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdySynReplyFrame extends DefaultSpdyHeadersFrame implements SpdySynReplyFrame {
    public DefaultSpdySynReplyFrame(int i10) {
        super(i10);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(last: ");
        sb2.append(isLast());
        sb2.append(')');
        String str = StringUtil.NEWLINE;
        sb2.append(str);
        sb2.append("--> Stream-ID = ");
        sb2.append(streamId());
        sb2.append(str);
        sb2.append("--> Headers:");
        sb2.append(str);
        appendHeaders(sb2);
        sb2.setLength(sb2.length() - str.length());
        return sb2.toString();
    }

    public DefaultSpdySynReplyFrame(int i10, boolean z10) {
        super(i10, z10);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdySynReplyFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynReplyFrame setLast(boolean z10) {
        super.setLast(z10);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynReplyFrame setStreamId(int i10) {
        super.setStreamId(i10);
        return this;
    }
}
