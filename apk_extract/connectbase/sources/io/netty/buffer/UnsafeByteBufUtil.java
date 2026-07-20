package io.netty.buffer;

import c1.c;
import h.a;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeByteBufUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();
    private static final byte ZERO = 0;

    private UnsafeByteBufUtil() {
    }

    public static ByteBuf copy(AbstractByteBuf abstractByteBuf, long j10, int i10, int i11) {
        abstractByteBuf.checkIndex(i10, i11);
        ByteBuf byteBufDirectBuffer = abstractByteBuf.alloc().directBuffer(i11, abstractByteBuf.maxCapacity());
        if (i11 != 0) {
            if (byteBufDirectBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j10, byteBufDirectBuffer.memoryAddress(), i11);
                byteBufDirectBuffer.setIndex(0, i11);
            } else {
                byteBufDirectBuffer.writeBytes(abstractByteBuf, i10, i11);
            }
        }
        return byteBufDirectBuffer;
    }

    public static byte getByte(long j10) {
        return PlatformDependent.getByte(j10);
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuf byteBuf, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (MathUtil.isOutOfBounds(i11, i12, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException(a.a("dstIndex: ", i11));
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(j10, byteBuf.memoryAddress() + ((long) i11), i12);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(j10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else {
            byteBuf.setBytes(i11, abstractByteBuf, i10, i12);
        }
    }

    public static int getInt(long j10) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j10 + 3) & 255) | (PlatformDependent.getByte(j10) << c.B) | ((PlatformDependent.getByte(1 + j10) & 255) << 16) | ((PlatformDependent.getByte(2 + j10) & 255) << 8);
        }
        int i10 = PlatformDependent.getInt(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i10 : Integer.reverseBytes(i10);
    }

    public static int getIntLE(long j10) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j10 + 3) << c.B) | (PlatformDependent.getByte(j10) & 255) | ((PlatformDependent.getByte(1 + j10) & 255) << 8) | ((PlatformDependent.getByte(2 + j10) & 255) << 16);
        }
        int i10 = PlatformDependent.getInt(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i10) : i10;
    }

    public static long getLong(long j10) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(j10 + 7)) & 255) | (((long) PlatformDependent.getByte(j10)) << 56) | ((((long) PlatformDependent.getByte(1 + j10)) & 255) << 48) | ((((long) PlatformDependent.getByte(2 + j10)) & 255) << 40) | ((((long) PlatformDependent.getByte(3 + j10)) & 255) << 32) | ((((long) PlatformDependent.getByte(4 + j10)) & 255) << 24) | ((((long) PlatformDependent.getByte(5 + j10)) & 255) << 16) | ((((long) PlatformDependent.getByte(6 + j10)) & 255) << 8);
        }
        long j11 = PlatformDependent.getLong(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j11 : Long.reverseBytes(j11);
    }

    public static long getLongLE(long j10) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(j10 + 7)) << 56) | (((long) PlatformDependent.getByte(j10)) & 255) | ((((long) PlatformDependent.getByte(1 + j10)) & 255) << 8) | ((((long) PlatformDependent.getByte(2 + j10)) & 255) << 16) | ((((long) PlatformDependent.getByte(3 + j10)) & 255) << 24) | ((((long) PlatformDependent.getByte(4 + j10)) & 255) << 32) | ((((long) PlatformDependent.getByte(5 + j10)) & 255) << 40) | ((255 & ((long) PlatformDependent.getByte(6 + j10))) << 48);
        }
        long j11 = PlatformDependent.getLong(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j11) : j11;
    }

    public static short getShort(long j10) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j10 + 1) & 255) | (PlatformDependent.getByte(j10) << 8));
        }
        short s10 = PlatformDependent.getShort(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s10 : Short.reverseBytes(s10);
    }

    public static short getShortLE(long j10) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j10 + 1) << 8) | (PlatformDependent.getByte(j10) & 255));
        }
        short s10 = PlatformDependent.getShort(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s10) : s10;
    }

    public static int getUnsignedMedium(long j10) {
        int i10;
        int i11;
        if (UNALIGNED) {
            i10 = (PlatformDependent.getByte(j10) & 255) << 16;
            i11 = (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? PlatformDependent.getShort(j10 + 1) : Short.reverseBytes(PlatformDependent.getShort(j10 + 1))) & g2.f10190d;
        } else {
            i10 = ((PlatformDependent.getByte(j10) & 255) << 16) | ((PlatformDependent.getByte(1 + j10) & 255) << 8);
            i11 = PlatformDependent.getByte(j10 + 2) & 255;
        }
        return i11 | i10;
    }

    public static int getUnsignedMediumLE(long j10) {
        int i10;
        int iReverseBytes;
        if (UNALIGNED) {
            i10 = PlatformDependent.getByte(j10) & 255;
            iReverseBytes = ((PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(PlatformDependent.getShort(j10 + 1)) : PlatformDependent.getShort(j10 + 1)) & g2.f10190d) << 8;
        } else {
            i10 = (PlatformDependent.getByte(j10) & 255) | ((PlatformDependent.getByte(1 + j10) & 255) << 8);
            iReverseBytes = (PlatformDependent.getByte(j10 + 2) & 255) << 16;
        }
        return iReverseBytes | i10;
    }

    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        return PlatformDependent.useDirectBufferNoCleaner() ? new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i10, i11) : new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i10, i11);
    }

    public static void setByte(long j10, int i10) {
        PlatformDependent.putByte(j10, (byte) i10);
    }

    public static int setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, InputStream inputStream, int i11) throws IOException {
        abstractByteBuf.checkIndex(i10, i11);
        ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(i11);
        try {
            byte[] bArrArray = byteBufHeapBuffer.array();
            int iArrayOffset = byteBufHeapBuffer.arrayOffset();
            int i12 = inputStream.read(bArrArray, iArrayOffset, i11);
            if (i12 > 0) {
                PlatformDependent.copyMemory(bArrArray, iArrayOffset, j10, i12);
            }
            return i12;
        } finally {
            byteBufHeapBuffer.release();
        }
    }

    public static void setInt(long j10, int i10) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i10 = Integer.reverseBytes(i10);
            }
            PlatformDependent.putInt(j10, i10);
        } else {
            PlatformDependent.putByte(j10, (byte) (i10 >>> 24));
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 16));
            PlatformDependent.putByte(2 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 3, (byte) i10);
        }
    }

    public static void setIntLE(long j10, int i10) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i10 = Integer.reverseBytes(i10);
            }
            PlatformDependent.putInt(j10, i10);
        } else {
            PlatformDependent.putByte(j10, (byte) i10);
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(2 + j10, (byte) (i10 >>> 16));
            PlatformDependent.putByte(j10 + 3, (byte) (i10 >>> 24));
        }
    }

    public static void setLong(long j10, long j11) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j11 = Long.reverseBytes(j11);
            }
            PlatformDependent.putLong(j10, j11);
            return;
        }
        PlatformDependent.putByte(j10, (byte) (j11 >>> 56));
        PlatformDependent.putByte(1 + j10, (byte) (j11 >>> 48));
        PlatformDependent.putByte(2 + j10, (byte) (j11 >>> 40));
        PlatformDependent.putByte(3 + j10, (byte) (j11 >>> 32));
        PlatformDependent.putByte(4 + j10, (byte) (j11 >>> 24));
        PlatformDependent.putByte(5 + j10, (byte) (j11 >>> 16));
        PlatformDependent.putByte(6 + j10, (byte) (j11 >>> 8));
        PlatformDependent.putByte(j10 + 7, (byte) j11);
    }

    public static void setLongLE(long j10, long j11) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j11 = Long.reverseBytes(j11);
            }
            PlatformDependent.putLong(j10, j11);
            return;
        }
        PlatformDependent.putByte(j10, (byte) j11);
        PlatformDependent.putByte(1 + j10, (byte) (j11 >>> 8));
        PlatformDependent.putByte(2 + j10, (byte) (j11 >>> 16));
        PlatformDependent.putByte(3 + j10, (byte) (j11 >>> 24));
        PlatformDependent.putByte(4 + j10, (byte) (j11 >>> 32));
        PlatformDependent.putByte(5 + j10, (byte) (j11 >>> 40));
        PlatformDependent.putByte(6 + j10, (byte) (j11 >>> 48));
        PlatformDependent.putByte(j10 + 7, (byte) (j11 >>> 56));
    }

    public static void setMedium(long j10, int i10) {
        PlatformDependent.putByte(j10, (byte) (i10 >>> 16));
        if (!UNALIGNED) {
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 2, (byte) i10);
            return;
        }
        long j11 = j10 + 1;
        short sReverseBytes = (short) i10;
        if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        PlatformDependent.putShort(j11, sReverseBytes);
    }

    public static void setMediumLE(long j10, int i10) {
        PlatformDependent.putByte(j10, (byte) i10);
        if (!UNALIGNED) {
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 2, (byte) (i10 >>> 16));
            return;
        }
        long j11 = j10 + 1;
        short sReverseBytes = (short) (i10 >>> 8);
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        PlatformDependent.putShort(j11, sReverseBytes);
    }

    public static void setShort(long j10, int i10) {
        if (!UNALIGNED) {
            PlatformDependent.putByte(j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 1, (byte) i10);
        } else {
            short sReverseBytes = (short) i10;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(j10, sReverseBytes);
        }
    }

    public static void setShortLE(long j10, int i10) {
        if (UNALIGNED) {
            PlatformDependent.putShort(j10, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i10) : (short) i10);
        } else {
            PlatformDependent.putByte(j10, (byte) i10);
            PlatformDependent.putByte(j10 + 1, (byte) (i10 >>> 8));
        }
    }

    private static void setSingleBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer, int i11) {
        abstractByteBuf.checkIndex(i10, i11);
        int iLimit = byteBuffer.limit();
        for (int iPosition = byteBuffer.position(); iPosition < iLimit; iPosition++) {
            PlatformDependent.putByte(j10, byteBuffer.get(iPosition));
            j10++;
        }
        byteBuffer.position(iLimit);
    }

    public static void setZero(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return;
        }
        PlatformDependent.setMemory(bArr, i10, i11, (byte) 0);
    }

    public static byte getByte(byte[] bArr, int i10) {
        return PlatformDependent.getByte(bArr, i10);
    }

    public static void setByte(byte[] bArr, int i10, int i11) {
        PlatformDependent.putByte(bArr, i10, (byte) i11);
    }

    public static void setZero(long j10, int i10) {
        if (i10 == 0) {
            return;
        }
        PlatformDependent.setMemory(j10, i10, (byte) 0);
    }

    public static short getShort(byte[] bArr, int i10) {
        if (UNALIGNED) {
            short s10 = PlatformDependent.getShort(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s10 : Short.reverseBytes(s10);
        }
        return (short) ((PlatformDependent.getByte(bArr, i10 + 1) & 255) | (PlatformDependent.getByte(bArr, i10) << 8));
    }

    public static short getShortLE(byte[] bArr, int i10) {
        if (UNALIGNED) {
            short s10 = PlatformDependent.getShort(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s10) : s10;
        }
        return (short) ((PlatformDependent.getByte(bArr, i10 + 1) << 8) | (PlatformDependent.getByte(bArr, i10) & 255));
    }

    public static void setMediumLE(byte[] bArr, int i10, int i11) {
        PlatformDependent.putByte(bArr, i10, (byte) i11);
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i10 + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) (i11 >>> 8)) : (short) (i11 >>> 8));
        } else {
            PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 8));
            PlatformDependent.putByte(bArr, i10 + 2, (byte) (i11 >>> 16));
        }
    }

    public static void setInt(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i11 = Integer.reverseBytes(i11);
            }
            PlatformDependent.putInt(bArr, i10, i11);
        } else {
            PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 24));
            PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 16));
            PlatformDependent.putByte(bArr, i10 + 2, (byte) (i11 >>> 8));
            PlatformDependent.putByte(bArr, i10 + 3, (byte) i11);
        }
    }

    public static void setIntLE(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i11 = Integer.reverseBytes(i11);
            }
            PlatformDependent.putInt(bArr, i10, i11);
        } else {
            PlatformDependent.putByte(bArr, i10, (byte) i11);
            PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 8));
            PlatformDependent.putByte(bArr, i10 + 2, (byte) (i11 >>> 16));
            PlatformDependent.putByte(bArr, i10 + 3, (byte) (i11 >>> 24));
        }
    }

    public static void setShort(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i11;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i10, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 1, (byte) i11);
    }

    public static void setShortLE(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            PlatformDependent.putShort(bArr, i10, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) i11) : (short) i11);
        } else {
            PlatformDependent.putByte(bArr, i10, (byte) i11);
            PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 8));
        }
    }

    public static int getInt(byte[] bArr, int i10) {
        if (UNALIGNED) {
            int i11 = PlatformDependent.getInt(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i11 : Integer.reverseBytes(i11);
        }
        return (PlatformDependent.getByte(bArr, i10 + 3) & 255) | (PlatformDependent.getByte(bArr, i10) << c.B) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i10 + 2) & 255) << 8);
    }

    public static int getIntLE(byte[] bArr, int i10) {
        if (UNALIGNED) {
            int i11 = PlatformDependent.getInt(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i11) : i11;
        }
        return (PlatformDependent.getByte(bArr, i10 + 3) << c.B) | (PlatformDependent.getByte(bArr, i10) & 255) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i10 + 2) & 255) << 16);
    }

    public static int getUnsignedMedium(byte[] bArr, int i10) {
        int i11;
        int i12;
        short sReverseBytes;
        if (UNALIGNED) {
            i11 = (PlatformDependent.getByte(bArr, i10) & 255) << 16;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = PlatformDependent.getShort(bArr, i10 + 1);
            } else {
                sReverseBytes = Short.reverseBytes(PlatformDependent.getShort(bArr, i10 + 1));
            }
            i12 = sReverseBytes & g2.f10190d;
        } else {
            i11 = ((PlatformDependent.getByte(bArr, i10) & 255) << 16) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 8);
            i12 = PlatformDependent.getByte(bArr, i10 + 2) & 255;
        }
        return i12 | i11;
    }

    public static int getUnsignedMediumLE(byte[] bArr, int i10) {
        int i11;
        int i12;
        short sReverseBytes;
        if (UNALIGNED) {
            i11 = PlatformDependent.getByte(bArr, i10) & 255;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(PlatformDependent.getShort(bArr, i10 + 1));
            } else {
                sReverseBytes = PlatformDependent.getShort(bArr, i10 + 1);
            }
            i12 = (sReverseBytes & g2.f10190d) << 8;
        } else {
            i11 = (PlatformDependent.getByte(bArr, i10) & 255) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 8);
            i12 = (PlatformDependent.getByte(bArr, i10 + 2) & 255) << 16;
        }
        return i12 | i11;
    }

    public static void setMedium(byte[] bArr, int i10, int i11) {
        PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 16));
        if (UNALIGNED) {
            int i12 = i10 + 1;
            short sReverseBytes = (short) i11;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i12, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 2, (byte) i11);
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuf byteBuf, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i11, i12, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException(a.a("srcIndex: ", i11));
        }
        if (i12 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i11), j10, i12);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i11, j10, i12);
            } else {
                byteBuf.getBytes(i11, abstractByteBuf, i10, i12);
            }
        }
    }

    public static void setLong(byte[] bArr, int i10, long j10) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j10 = Long.reverseBytes(j10);
            }
            PlatformDependent.putLong(bArr, i10, j10);
            return;
        }
        PlatformDependent.putByte(bArr, i10, (byte) (j10 >>> 56));
        PlatformDependent.putByte(bArr, i10 + 1, (byte) (j10 >>> 48));
        PlatformDependent.putByte(bArr, i10 + 2, (byte) (j10 >>> 40));
        PlatformDependent.putByte(bArr, i10 + 3, (byte) (j10 >>> 32));
        PlatformDependent.putByte(bArr, i10 + 4, (byte) (j10 >>> 24));
        PlatformDependent.putByte(bArr, i10 + 5, (byte) (j10 >>> 16));
        PlatformDependent.putByte(bArr, i10 + 6, (byte) (j10 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 7, (byte) j10);
    }

    public static void setLongLE(byte[] bArr, int i10, long j10) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j10 = Long.reverseBytes(j10);
            }
            PlatformDependent.putLong(bArr, i10, j10);
            return;
        }
        PlatformDependent.putByte(bArr, i10, (byte) j10);
        PlatformDependent.putByte(bArr, i10 + 1, (byte) (j10 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 2, (byte) (j10 >>> 16));
        PlatformDependent.putByte(bArr, i10 + 3, (byte) (j10 >>> 24));
        PlatformDependent.putByte(bArr, i10 + 4, (byte) (j10 >>> 32));
        PlatformDependent.putByte(bArr, i10 + 5, (byte) (j10 >>> 40));
        PlatformDependent.putByte(bArr, i10 + 6, (byte) (j10 >>> 48));
        PlatformDependent.putByte(bArr, i10 + 7, (byte) (j10 >>> 56));
    }

    public static long getLong(byte[] bArr, int i10) {
        if (UNALIGNED) {
            long j10 = PlatformDependent.getLong(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j10 : Long.reverseBytes(j10);
        }
        return (((long) PlatformDependent.getByte(bArr, i10 + 7)) & 255) | (((long) PlatformDependent.getByte(bArr, i10)) << 56) | ((((long) PlatformDependent.getByte(bArr, i10 + 1)) & 255) << 48) | ((((long) PlatformDependent.getByte(bArr, i10 + 2)) & 255) << 40) | ((((long) PlatformDependent.getByte(bArr, i10 + 3)) & 255) << 32) | ((((long) PlatformDependent.getByte(bArr, i10 + 4)) & 255) << 24) | ((((long) PlatformDependent.getByte(bArr, i10 + 5)) & 255) << 16) | ((((long) PlatformDependent.getByte(bArr, i10 + 6)) & 255) << 8);
    }

    public static long getLongLE(byte[] bArr, int i10) {
        if (UNALIGNED) {
            long j10 = PlatformDependent.getLong(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j10) : j10;
        }
        return (((long) PlatformDependent.getByte(bArr, i10 + 7)) << 56) | (((long) PlatformDependent.getByte(bArr, i10)) & 255) | ((((long) PlatformDependent.getByte(bArr, i10 + 1)) & 255) << 8) | ((((long) PlatformDependent.getByte(bArr, i10 + 2)) & 255) << 16) | ((((long) PlatformDependent.getByte(bArr, i10 + 3)) & 255) << 24) | ((((long) PlatformDependent.getByte(bArr, i10 + 4)) & 255) << 32) | ((((long) PlatformDependent.getByte(bArr, i10 + 5)) & 255) << 40) | ((255 & ((long) PlatformDependent.getByte(bArr, i10 + 6))) << 48);
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, byte[] bArr, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i11, i12, bArr.length)) {
            throw new IndexOutOfBoundsException(a.a("dstIndex: ", i11));
        }
        if (i12 != 0) {
            PlatformDependent.copyMemory(j10, bArr, i11, i12);
        }
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, byte[] bArr, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(bArr, "src");
        if (MathUtil.isOutOfBounds(i11, i12, bArr.length)) {
            throw new IndexOutOfBoundsException(a.a("srcIndex: ", i11));
        }
        if (i12 != 0) {
            PlatformDependent.copyMemory(bArr, i11, j10, i12);
        }
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i10, byteBuffer.remaining());
        if (byteBuffer.remaining() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j10, PlatformDependent.directBufferAddress(byteBuffer) + ((long) byteBuffer.position()), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
                return;
            }
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j10, byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
            return;
        }
        byteBuffer.put(abstractByteBuf.nioBuffer());
    }

    public static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            abstractByteBuf.checkIndex(i10, iRemaining);
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) byteBuffer.position()), j10, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else {
            if (!byteBuffer.hasArray()) {
                if (iRemaining < 8) {
                    setSingleBytes(abstractByteBuf, j10, i10, byteBuffer, iRemaining);
                    return;
                } else {
                    abstractByteBuf.internalNioBuffer(i10, iRemaining).put(byteBuffer);
                    return;
                }
            }
            abstractByteBuf.checkIndex(i10, iRemaining);
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), j10, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    public static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, OutputStream outputStream, int i11) throws IOException {
        abstractByteBuf.checkIndex(i10, i11);
        if (i11 != 0) {
            int iMin = Math.min(i11, 8192);
            if (iMin > 1024 && abstractByteBuf.alloc().isDirectBufferPooled()) {
                ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(iMin);
                try {
                    getBytes(j10, byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), iMin, outputStream, i11);
                    return;
                } finally {
                    byteBufHeapBuffer.release();
                }
            }
            getBytes(j10, ByteBufUtil.threadLocalTempArray(iMin), 0, iMin, outputStream, i11);
        }
    }

    private static void getBytes(long j10, byte[] bArr, int i10, int i11, OutputStream outputStream, int i12) throws IOException {
        do {
            int iMin = Math.min(i11, i12);
            long j11 = iMin;
            PlatformDependent.copyMemory(j10, bArr, i10, j11);
            outputStream.write(bArr, i10, iMin);
            i12 -= iMin;
            j10 += j11;
        } while (i12 > 0);
    }
}
