package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private ByteBuf f8306in;

    public boolean hasReadableBits(int i10) {
        if (i10 >= 0) {
            return this.bitCount >= i10 || ((this.f8306in.readableBytes() << 3) & Integer.MAX_VALUE) >= i10 - this.bitCount;
        }
        throw new IllegalArgumentException(b.a("count: ", i10, " (expected value greater than 0)"));
    }

    public boolean hasReadableBytes(int i10) {
        if (i10 < 0 || i10 > MAX_COUNT_OF_READABLE_BYTES) {
            throw new IllegalArgumentException(b.a("count: ", i10, " (expected: 0-268435455)"));
        }
        return hasReadableBits(i10 << 3);
    }

    public boolean isReadable() {
        return this.bitCount > 0 || this.f8306in.isReadable();
    }

    public int readBits(int i10) {
        long unsignedByte;
        int i11;
        if (i10 < 0 || i10 > 32) {
            throw new IllegalArgumentException(b.a("count: ", i10, " (expected: 0-32 )"));
        }
        int i12 = this.bitCount;
        long j10 = this.bitBuffer;
        if (i12 < i10) {
            int i13 = this.f8306in.readableBytes();
            if (i13 == 1) {
                unsignedByte = this.f8306in.readUnsignedByte();
                i11 = 8;
            } else if (i13 == 2) {
                unsignedByte = this.f8306in.readUnsignedShort();
                i11 = 16;
            } else if (i13 != 3) {
                unsignedByte = this.f8306in.readUnsignedInt();
                i11 = 32;
            } else {
                unsignedByte = this.f8306in.readUnsignedMedium();
                i11 = 24;
            }
            j10 = (j10 << i11) | unsignedByte;
            i12 += i11;
            this.bitBuffer = j10;
        }
        int i14 = i12 - i10;
        this.bitCount = i14;
        return (int) ((i10 != 32 ? (1 << i10) - 1 : 4294967295L) & (j10 >>> i14));
    }

    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    public int readInt() {
        return readBits(32);
    }

    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | ((long) this.f8306in.readUnsignedByte());
        this.bitCount += 8;
    }

    public void setByteBuf(ByteBuf byteBuf) {
        this.f8306in = byteBuf;
    }
}
