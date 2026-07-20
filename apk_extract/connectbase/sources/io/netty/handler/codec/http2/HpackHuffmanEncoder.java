package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes3.dex */
final class HpackHuffmanEncoder {
    private final int[] codes;
    private final EncodeProcessor encodeProcessor;
    private final EncodedLengthProcessor encodedLengthProcessor;
    private final byte[] lengths;

    public final class EncodeProcessor implements ByteProcessor {
        private long current;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f8316n;
        ByteBuf out;

        private EncodeProcessor() {
        }

        public void end() {
            try {
                int i10 = this.f8316n;
                if (i10 > 0) {
                    long j10 = (this.current << (8 - i10)) | ((long) (255 >>> i10));
                    this.current = j10;
                    this.out.writeByte((int) j10);
                }
            } finally {
                this.out = null;
                this.current = 0L;
                this.f8316n = 0;
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            int i10 = b10 & 255;
            byte b11 = HpackHuffmanEncoder.this.lengths[i10];
            long j10 = this.current << b11;
            this.current = j10;
            this.current = j10 | ((long) HpackHuffmanEncoder.this.codes[i10]);
            this.f8316n += b11;
            while (true) {
                int i11 = this.f8316n;
                if (i11 < 8) {
                    return true;
                }
                int i12 = i11 - 8;
                this.f8316n = i12;
                this.out.writeByte((int) (this.current >> i12));
            }
        }
    }

    public final class EncodedLengthProcessor implements ByteProcessor {
        private long len;

        private EncodedLengthProcessor() {
        }

        public int length() {
            return (int) ((this.len + 7) >> 3);
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            this.len += (long) HpackHuffmanEncoder.this.lengths[b10 & 255];
            return true;
        }

        public void reset() {
            this.len = 0L;
        }
    }

    public HpackHuffmanEncoder() {
        this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    private void encodeSlowPath(ByteBuf byteBuf, CharSequence charSequence) {
        long j10 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            int iC2b = AsciiString.c2b(charSequence.charAt(i11)) & 255;
            int i12 = this.codes[iC2b];
            byte b10 = this.lengths[iC2b];
            j10 = (j10 << b10) | ((long) i12);
            i10 += b10;
            while (i10 >= 8) {
                i10 -= 8;
                byteBuf.writeByte((int) (j10 >> i10));
            }
        }
        if (i10 > 0) {
            byteBuf.writeByte((int) ((j10 << (8 - i10)) | ((long) (255 >>> i10))));
        }
    }

    private int getEncodedLengthSlowPath(CharSequence charSequence) {
        long j10 = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            j10 += (long) this.lengths[AsciiString.c2b(charSequence.charAt(i10)) & 255];
        }
        return (int) ((j10 + 7) >> 3);
    }

    public void encode(ByteBuf byteBuf, CharSequence charSequence) {
        ObjectUtil.checkNotNull(byteBuf, "out");
        if (!(charSequence instanceof AsciiString)) {
            encodeSlowPath(byteBuf, charSequence);
            return;
        }
        AsciiString asciiString = (AsciiString) charSequence;
        try {
            try {
                EncodeProcessor encodeProcessor = this.encodeProcessor;
                encodeProcessor.out = byteBuf;
                asciiString.forEachByte(encodeProcessor);
            } catch (Exception e10) {
                PlatformDependent.throwException(e10);
            }
        } finally {
            this.encodeProcessor.end();
        }
    }

    public int getEncodedLength(CharSequence charSequence) throws Throwable {
        if (!(charSequence instanceof AsciiString)) {
            return getEncodedLengthSlowPath(charSequence);
        }
        AsciiString asciiString = (AsciiString) charSequence;
        try {
            this.encodedLengthProcessor.reset();
            asciiString.forEachByte(this.encodedLengthProcessor);
            return this.encodedLengthProcessor.length();
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    private HpackHuffmanEncoder(int[] iArr, byte[] bArr) {
        this.encodedLengthProcessor = new EncodedLengthProcessor();
        this.encodeProcessor = new EncodeProcessor();
        this.codes = iArr;
        this.lengths = bArr;
    }
}
