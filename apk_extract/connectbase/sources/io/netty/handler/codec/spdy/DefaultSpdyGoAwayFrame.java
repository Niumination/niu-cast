package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdyGoAwayFrame implements SpdyGoAwayFrame {
    private int lastGoodStreamId;
    private SpdySessionStatus status;

    public DefaultSpdyGoAwayFrame(int i10) {
        this(i10, 0);
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public int lastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdyGoAwayFrame setLastGoodStreamId(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "lastGoodStreamId");
        this.lastGoodStreamId = i10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdyGoAwayFrame setStatus(SpdySessionStatus spdySessionStatus) {
        this.status = spdySessionStatus;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdySessionStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb2.append(str);
        sb2.append("--> Last-good-stream-ID = ");
        sb2.append(lastGoodStreamId());
        sb2.append(str);
        sb2.append("--> Status: ");
        sb2.append(status());
        return sb2.toString();
    }

    public DefaultSpdyGoAwayFrame(int i10, int i11) {
        this(i10, SpdySessionStatus.valueOf(i11));
    }

    public DefaultSpdyGoAwayFrame(int i10, SpdySessionStatus spdySessionStatus) {
        setLastGoodStreamId(i10);
        setStatus(spdySessionStatus);
    }
}
