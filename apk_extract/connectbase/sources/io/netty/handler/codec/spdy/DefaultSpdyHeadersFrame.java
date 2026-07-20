package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdyHeadersFrame extends DefaultSpdyStreamFrame implements SpdyHeadersFrame {
    private final SpdyHeaders headers;
    private boolean invalid;
    private boolean truncated;

    public DefaultSpdyHeadersFrame(int i10) {
        this(i10, true);
    }

    public void appendHeaders(StringBuilder sb2) {
        for (Map.Entry<CharSequence, CharSequence> entry : headers()) {
            sb2.append("    ");
            sb2.append(entry.getKey());
            sb2.append(": ");
            sb2.append(entry.getValue());
            sb2.append(StringUtil.NEWLINE);
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isInvalid() {
        return this.invalid;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isTruncated() {
        return this.truncated;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setInvalid() {
        this.invalid = true;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setTruncated() {
        this.truncated = true;
        return this;
    }

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

    public DefaultSpdyHeadersFrame(int i10, boolean z10) {
        super(i10);
        this.headers = new DefaultSpdyHeaders(z10);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setLast(boolean z10) {
        super.setLast(z10);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setStreamId(int i10) {
        super.setStreamId(i10);
        return this;
    }
}
