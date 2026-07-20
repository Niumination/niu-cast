package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
public interface SpdyFrameDecoderDelegate {
    void readDataFrame(int i10, boolean z10, ByteBuf byteBuf);

    void readFrameError(String str);

    void readGoAwayFrame(int i10, int i11);

    void readHeaderBlock(ByteBuf byteBuf);

    void readHeaderBlockEnd();

    void readHeadersFrame(int i10, boolean z10);

    void readPingFrame(int i10);

    void readRstStreamFrame(int i10, int i11);

    void readSetting(int i10, int i11, boolean z10, boolean z11);

    void readSettingsEnd();

    void readSettingsFrame(boolean z10);

    void readSynReplyFrame(int i10, boolean z10);

    void readSynStreamFrame(int i10, int i11, byte b10, boolean z10, boolean z11);

    void readWindowUpdateFrame(int i10, int i11);
}
