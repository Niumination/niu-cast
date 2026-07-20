package io.netty.handler.codec.base64;

import c.a;
import c1.c;
import fl.h;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;
import lm.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

    public static final class Decoder implements ByteProcessor {

        /* JADX INFO: renamed from: b4, reason: collision with root package name */
        private final byte[] f8305b4;
        private int b4Posn;
        private byte[] decodabet;
        private ByteBuf dest;
        private int outBuffPosn;

        private Decoder() {
            this.f8305b4 = new byte[4];
        }

        private static int decode4to3(byte[] bArr, ByteBuf byteBuf, int i10, byte[] bArr2) {
            int i11;
            int i12;
            int i13;
            byte b10 = bArr[0];
            byte b11 = bArr[1];
            byte b12 = bArr[2];
            if (b12 == 61) {
                try {
                    byteBuf.setByte(i10, ((bArr2[b10] & 255) << 2) | ((bArr2[b11] & 255) >>> 4));
                    return 1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            byte b13 = bArr[3];
            if (b13 == 61) {
                byte b14 = bArr2[b11];
                try {
                    if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                        i13 = ((b14 & c.f1123q) << 4) | ((((bArr2[b10] & h.f6042b) << 2) | ((b14 & 240) >> 4)) << 8) | ((bArr2[b12] & 252) >>> 2);
                    } else {
                        i13 = ((((b14 & c.f1123q) << 4) | ((bArr2[b12] & 252) >>> 2)) << 8) | ((bArr2[b10] & h.f6042b) << 2) | ((b14 & 240) >> 4);
                    }
                    byteBuf.setShort(i10, i13);
                    return 2;
                } catch (IndexOutOfBoundsException unused2) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            try {
                if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                    i11 = ((bArr2[b10] & h.f6042b) << 18) | ((bArr2[b11] & 255) << 12) | ((bArr2[b12] & 255) << 6);
                    i12 = bArr2[b13] & 255;
                } else {
                    byte b15 = bArr2[b11];
                    byte b16 = bArr2[b12];
                    i11 = ((bArr2[b10] & h.f6042b) << 2) | ((b15 & c.f1123q) << 12) | ((b15 & 240) >>> 4) | ((b16 & 3) << 22) | ((b16 & 252) << 6);
                    i12 = (bArr2[b13] & 255) << 16;
                }
                byteBuf.setMedium(i10, i12 | i11);
                return 3;
            } catch (IndexOutOfBoundsException unused3) {
                throw new IllegalArgumentException("not encoded in Base64");
            }
        }

        public ByteBuf decode(ByteBuf byteBuf, int i10, int i11, ByteBufAllocator byteBufAllocator, Base64Dialect base64Dialect) throws Throwable {
            this.dest = byteBufAllocator.buffer(Base64.decodedBufferSize(i11)).order(byteBuf.order());
            this.decodabet = Base64.decodabet(base64Dialect);
            try {
                byteBuf.forEachByte(i10, i11, this);
                return this.dest.slice(0, this.outBuffPosn);
            } catch (Throwable th2) {
                this.dest.release();
                PlatformDependent.throwException(th2);
                return null;
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) throws Exception {
            byte[] bArr;
            byte b11;
            if (b10 <= 0 || (b11 = (bArr = this.decodabet)[b10]) < -5) {
                throw new IllegalArgumentException(a.a(new StringBuilder("invalid Base64 input character: "), (short) (b10 & 255), " (decimal)"));
            }
            if (b11 < -1) {
                return true;
            }
            byte[] bArr2 = this.f8305b4;
            int i10 = this.b4Posn;
            int i11 = i10 + 1;
            this.b4Posn = i11;
            bArr2[i10] = b10;
            if (i11 <= 3) {
                return true;
            }
            int i12 = this.outBuffPosn;
            this.outBuffPosn = i12 + decode4to3(bArr2, this.dest, i12, bArr);
            this.b4Posn = 0;
            return b10 != 61;
        }
    }

    private Base64() {
    }

    private static byte[] alphabet(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).alphabet;
    }

    private static boolean breakLines(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).breakLinesByDefault;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] decodabet(Base64Dialect base64Dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(base64Dialect, "dialect")).decodabet;
    }

    public static ByteBuf decode(ByteBuf byteBuf) {
        return decode(byteBuf, Base64Dialect.STANDARD);
    }

    public static int decodedBufferSize(int i10) {
        return i10 - (i10 >>> 2);
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    private static void encode3to4(ByteBuf byteBuf, int i10, int i11, ByteBuf byteBuf2, int i12, byte[] bArr) {
        int intLE = 0;
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            if (i11 == 1) {
                intLE = toInt(byteBuf.getByte(i10));
            } else if (i11 == 2) {
                intLE = toIntBE(byteBuf.getShort(i10));
            } else if (i11 > 0) {
                intLE = toIntBE(byteBuf.getMedium(i10));
            }
            encode3to4BigEndian(intLE, i11, byteBuf2, i12, bArr);
            return;
        }
        if (i11 == 1) {
            intLE = toInt(byteBuf.getByte(i10));
        } else if (i11 == 2) {
            intLE = toIntLE(byteBuf.getShort(i10));
        } else if (i11 > 0) {
            intLE = toIntLE(byteBuf.getMedium(i10));
        }
        encode3to4LittleEndian(intLE, i11, byteBuf2, i12, bArr);
    }

    private static void encode3to4BigEndian(int i10, int i11, ByteBuf byteBuf, int i12, byte[] bArr) {
        if (i11 == 1) {
            byteBuf.setInt(i12, (bArr[(i10 >>> 12) & 63] << c.f1124r) | (bArr[i10 >>> 18] << c.B) | 15677);
        } else if (i11 == 2) {
            byteBuf.setInt(i12, (bArr[(i10 >>> 6) & 63] << 8) | (bArr[i10 >>> 18] << c.B) | (bArr[(i10 >>> 12) & 63] << c.f1124r) | 61);
        } else {
            if (i11 != 3) {
                return;
            }
            byteBuf.setInt(i12, bArr[i10 & 63] | (bArr[i10 >>> 18] << c.B) | (bArr[(i10 >>> 12) & 63] << c.f1124r) | (bArr[(i10 >>> 6) & 63] << 8));
        }
    }

    private static void encode3to4LittleEndian(int i10, int i11, ByteBuf byteBuf, int i12, byte[] bArr) {
        if (i11 == 1) {
            byteBuf.setInt(i12, (bArr[(i10 >>> 12) & 63] << 8) | bArr[i10 >>> 18] | 1027407872);
        } else if (i11 == 2) {
            byteBuf.setInt(i12, (bArr[(i10 >>> 6) & 63] << c.f1124r) | bArr[i10 >>> 18] | (bArr[(i10 >>> 12) & 63] << 8) | 1023410176);
        } else {
            if (i11 != 3) {
                return;
            }
            byteBuf.setInt(i12, (bArr[i10 & 63] << c.B) | bArr[i10 >>> 18] | (bArr[(i10 >>> 12) & 63] << 8) | (bArr[(i10 >>> 6) & 63] << c.f1124r));
        }
    }

    public static int encodedBufferSize(int i10, boolean z10) {
        long j10 = (((long) i10) << 2) / 3;
        long j11 = (3 + j10) & (-4);
        if (z10) {
            j11 += j10 / 76;
        }
        if (j11 < 2147483647L) {
            return (int) j11;
        }
        return Integer.MAX_VALUE;
    }

    private static int toInt(byte b10) {
        return (b10 & 255) << 16;
    }

    private static int toIntBE(int i10) {
        return i10 & 16777215;
    }

    private static int toIntLE(int i10) {
        return ((i10 & 16711680) >>> 16) | ((i10 & 255) << 16) | (65280 & i10);
    }

    public static ByteBuf decode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ByteBuf byteBufDecode = decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufDecode;
    }

    public static ByteBuf encode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        return encode(byteBuf, breakLines(base64Dialect), base64Dialect);
    }

    private static int toIntBE(short s10) {
        return (s10 & g2.f10190d) << 8;
    }

    private static int toIntLE(short s10) {
        return (s10 & 65280) | ((s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE) << 16);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z10) {
        return encode(byteBuf, z10, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z10, Base64Dialect base64Dialect) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ByteBuf byteBufEncode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z10, base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufEncode;
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i10, int i11) {
        return decode(byteBuf, i10, i11, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i10, int i11, Base64Dialect base64Dialect) {
        return decode(byteBuf, i10, i11, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i10, int i11, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ObjectUtil.checkNotNull(base64Dialect, "dialect");
        return new Decoder().decode(byteBuf, i10, i11, byteBufAllocator, base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i10, int i11) {
        return encode(byteBuf, i10, i11, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i10, int i11, Base64Dialect base64Dialect) {
        return encode(byteBuf, i10, i11, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i10, int i11, boolean z10) {
        return encode(byteBuf, i10, i11, z10, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i10, int i11, boolean z10, Base64Dialect base64Dialect) {
        return encode(byteBuf, i10, i11, z10, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i10, int i11, boolean z10, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        ObjectUtil.checkNotNull(byteBuf, "src");
        ObjectUtil.checkNotNull(base64Dialect, "dialect");
        ByteBuf byteBufOrder = byteBufAllocator.buffer(encodedBufferSize(i11, z10)).order(byteBuf.order());
        byte[] bArrAlphabet = alphabet(base64Dialect);
        int i12 = i11 - 2;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i12) {
            encode3to4(byteBuf, i13 + i10, 3, byteBufOrder, i14, bArrAlphabet);
            i15 += 4;
            if (z10 && i15 == 76) {
                byteBufOrder.setByte(i14 + 4, 10);
                i14++;
                i15 = 0;
            }
            i13 += 3;
            i14 += 4;
        }
        if (i13 < i11) {
            encode3to4(byteBuf, i13 + i10, i11 - i13, byteBufOrder, i14, bArrAlphabet);
            i14 += 4;
        }
        if (i14 > 1 && byteBufOrder.getByte(i14 - 1) == 10) {
            i14--;
        }
        return byteBufOrder.slice(0, i14);
    }
}
