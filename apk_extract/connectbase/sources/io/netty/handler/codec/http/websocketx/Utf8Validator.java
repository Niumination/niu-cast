package io.netty.handler.codec.http.websocketx;

import c1.c;
import fl.h;
import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8Validator implements ByteProcessor {
    private static final int UTF8_ACCEPT = 0;
    private static final int UTF8_REJECT = 12;
    private boolean checking;
    private int codep;
    private int state = 0;
    private static final byte[] TYPES = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, c.f1119m, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    private static final byte[] STATES = {0, c.f1120n, c.B, 36, 60, 96, 84, c.f1120n, c.f1120n, c.f1120n, 48, 72, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, 0, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, 0, c.f1120n, 0, c.f1120n, c.f1120n, c.f1120n, c.B, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.B, c.f1120n, c.B, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.B, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.B, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.B, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, 36, c.f1120n, 36, c.f1120n, c.f1120n, c.f1120n, 36, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, 36, c.f1120n, 36, c.f1120n, c.f1120n, c.f1120n, 36, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n, c.f1120n};

    public void check(ByteBuf byteBuf) {
        this.checking = true;
        byteBuf.forEachByte(this);
    }

    public void finish() {
        this.checking = false;
        this.codep = 0;
        if (this.state == 0) {
            return;
        }
        this.state = 0;
        throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
    }

    public boolean isChecking() {
        return this.checking;
    }

    @Override // io.netty.util.ByteProcessor
    public boolean process(byte b10) throws Exception {
        byte b11 = TYPES[b10 & 255];
        int i10 = this.state;
        this.codep = i10 != 0 ? (b10 & h.f6042b) | (this.codep << 6) : b10 & (255 >> b11);
        byte b12 = STATES[i10 + b11];
        this.state = b12;
        if (b12 != 12) {
            return true;
        }
        this.checking = false;
        throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
    }

    public void check(ByteBuf byteBuf, int i10, int i11) {
        this.checking = true;
        byteBuf.forEachByte(i10, i11, this);
    }
}
