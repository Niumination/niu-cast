package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    public void flush(ByteBuf byteBuf) {
        int i10 = this.bitCount;
        if (i10 > 0) {
            long j10 = this.bitBuffer;
            int i11 = 64 - i10;
            if (i10 <= 8) {
                byteBuf.writeByte((int) ((j10 >>> i11) << (8 - i10)));
                return;
            }
            if (i10 <= 16) {
                byteBuf.writeShort((int) ((j10 >>> i11) << (16 - i10)));
            } else if (i10 <= 24) {
                byteBuf.writeMedium((int) ((j10 >>> i11) << (24 - i10)));
            } else {
                byteBuf.writeInt((int) ((j10 >>> i11) << (32 - i10)));
            }
        }
    }

    public void writeBits(ByteBuf byteBuf, int i10, long j10) {
        if (i10 < 0 || i10 > 32) {
            throw new IllegalArgumentException(b.a("count: ", i10, " (expected: 0-32)"));
        }
        int i11 = this.bitCount;
        long j11 = ((j10 << (64 - i10)) >>> i11) | this.bitBuffer;
        int i12 = i11 + i10;
        if (i12 >= 32) {
            byteBuf.writeInt((int) (j11 >>> 32));
            j11 <<= 32;
            i12 -= 32;
        }
        this.bitBuffer = j11;
        this.bitCount = i12;
    }

    public void writeBoolean(ByteBuf byteBuf, boolean z10) {
        int i10 = this.bitCount + 1;
        long j10 = 0;
        long j11 = this.bitBuffer | (z10 ? 1 << (64 - i10) : 0L);
        if (i10 == 32) {
            byteBuf.writeInt((int) (j11 >>> 32));
            i10 = 0;
        } else {
            j10 = j11;
        }
        this.bitBuffer = j10;
        this.bitCount = i10;
    }

    public void writeInt(ByteBuf byteBuf, int i10) {
        writeBits(byteBuf, 32, i10);
    }

    public void writeUnary(ByteBuf byteBuf, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(b.a("value: ", i10, " (expected 0 or more)"));
        }
        while (true) {
            int i11 = i10 - 1;
            if (i10 <= 0) {
                writeBoolean(byteBuf, false);
                return;
            } else {
                writeBoolean(byteBuf, true);
                i10 = i11;
            }
        }
    }
}
