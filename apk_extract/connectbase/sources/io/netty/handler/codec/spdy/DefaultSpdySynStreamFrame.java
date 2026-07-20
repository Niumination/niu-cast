package io.netty.handler.codec.spdy;

import h.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdySynStreamFrame extends DefaultSpdyHeadersFrame implements SpdySynStreamFrame {
    private int associatedStreamId;
    private byte priority;
    private boolean unidirectional;

    public DefaultSpdySynStreamFrame(int i10, int i11, byte b10) {
        this(i10, i11, b10, true);
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public int associatedStreamId() {
        return this.associatedStreamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public boolean isUnidirectional() {
        return this.unidirectional;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public byte priority() {
        return this.priority;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setAssociatedStreamId(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "associatedStreamId");
        this.associatedStreamId = i10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setPriority(byte b10) {
        if (b10 < 0 || b10 > 7) {
            throw new IllegalArgumentException(a.a("Priority must be between 0 and 7 inclusive: ", b10));
        }
        this.priority = b10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setUnidirectional(boolean z10) {
        this.unidirectional = z10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(last: ");
        sb2.append(isLast());
        sb2.append("; unidirectional: ");
        sb2.append(isUnidirectional());
        sb2.append(')');
        String str = StringUtil.NEWLINE;
        sb2.append(str);
        sb2.append("--> Stream-ID = ");
        sb2.append(streamId());
        sb2.append(str);
        if (this.associatedStreamId != 0) {
            sb2.append("--> Associated-To-Stream-ID = ");
            sb2.append(associatedStreamId());
            sb2.append(str);
        }
        sb2.append("--> Priority = ");
        sb2.append((int) priority());
        sb2.append(str);
        sb2.append("--> Headers:");
        sb2.append(str);
        appendHeaders(sb2);
        sb2.setLength(sb2.length() - str.length());
        return sb2.toString();
    }

    public DefaultSpdySynStreamFrame(int i10, int i11, byte b10, boolean z10) {
        super(i10, z10);
        setAssociatedStreamId(i11);
        setPriority(b10);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdySynStreamFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setLast(boolean z10) {
        super.setLast(z10);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setStreamId(int i10) {
        super.setStreamId(i10);
        return this;
    }
}
