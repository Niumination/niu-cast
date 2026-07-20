package io.netty.buffer;

import dc.d;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    static {
        UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        ALLOC = unpooledByteBufAllocator;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        EMPTY_BUFFER = unpooledByteBufAllocator.buffer(0, 0);
    }

    private Unpooled() {
    }

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static CompositeByteBuf compositeBuffer() {
        return compositeBuffer(16);
    }

    public static ByteBuf copiedBuffer(byte[] bArr) {
        return bArr.length == 0 ? EMPTY_BUFFER : wrappedBuffer((byte[]) bArr.clone());
    }

    private static ByteBuf copiedBufferAscii(CharSequence charSequence) {
        ByteBuf byteBufHeapBuffer = ALLOC.heapBuffer(charSequence.length());
        try {
            ByteBufUtil.writeAscii(byteBufHeapBuffer, charSequence);
            return byteBufHeapBuffer;
        } catch (Throwable th2) {
            byteBufHeapBuffer.release();
            throw th2;
        }
    }

    private static ByteBuf copiedBufferUtf8(CharSequence charSequence) {
        ByteBuf byteBufHeapBuffer = ALLOC.heapBuffer(ByteBufUtil.utf8Bytes(charSequence));
        try {
            ByteBufUtil.writeUtf8(byteBufHeapBuffer, charSequence);
            return byteBufHeapBuffer;
        } catch (Throwable th2) {
            byteBufHeapBuffer.release();
            throw th2;
        }
    }

    public static ByteBuf copyBoolean(boolean z10) {
        ByteBuf byteBufBuffer = buffer(1);
        byteBufBuffer.writeBoolean(z10);
        return byteBufBuffer;
    }

    public static ByteBuf copyDouble(double d10) {
        ByteBuf byteBufBuffer = buffer(8);
        byteBufBuffer.writeDouble(d10);
        return byteBufBuffer;
    }

    public static ByteBuf copyFloat(float f10) {
        ByteBuf byteBufBuffer = buffer(4);
        byteBufBuffer.writeFloat(f10);
        return byteBufBuffer;
    }

    public static ByteBuf copyInt(int i10) {
        ByteBuf byteBufBuffer = buffer(4);
        byteBufBuffer.writeInt(i10);
        return byteBufBuffer;
    }

    public static ByteBuf copyLong(long j10) {
        ByteBuf byteBufBuffer = buffer(8);
        byteBufBuffer.writeLong(j10);
        return byteBufBuffer;
    }

    public static ByteBuf copyMedium(int i10) {
        ByteBuf byteBufBuffer = buffer(3);
        byteBufBuffer.writeMedium(i10);
        return byteBufBuffer;
    }

    public static ByteBuf copyShort(int i10) {
        ByteBuf byteBufBuffer = buffer(2);
        byteBufBuffer.writeShort(i10);
        return byteBufBuffer;
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder byteOrderOrder = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        return byteOrderOrder == byteOrder ? new ReadOnlyByteBuf(byteBuf) : new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        return bArr.length == 0 ? EMPTY_BUFFER : new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(false, byteBufArr);
    }

    public static ByteBuf buffer(int i10) {
        return ALLOC.heapBuffer(i10);
    }

    public static CompositeByteBuf compositeBuffer(int i10) {
        return new CompositeByteBuf(ALLOC, false, i10);
    }

    public static ByteBuf directBuffer(int i10) {
        return ALLOC.directBuffer(i10);
    }

    private static ByteBuf wrappedUnmodifiableBuffer(boolean z10, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return byteBufArr[0].asReadOnly();
        }
        if (z10) {
            byteBufArr = (ByteBuf[]) Arrays.copyOf(byteBufArr, byteBufArr.length, ByteBuf[].class);
        }
        return new FixedCompositeByteBuf(ALLOC, byteBufArr);
    }

    public static ByteBuf buffer(int i10, int i11) {
        return ALLOC.heapBuffer(i10, i11);
    }

    public static ByteBuf copyBoolean(boolean... zArr) {
        if (zArr != null && zArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(zArr.length);
            for (boolean z10 : zArr) {
                byteBufBuffer.writeBoolean(z10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyDouble(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(dArr.length * 8);
            for (double d10 : dArr) {
                byteBufBuffer.writeDouble(d10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyFloat(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(fArr.length * 4);
            for (float f10 : fArr) {
                byteBufBuffer.writeFloat(f10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyInt(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(iArr.length * 4);
            for (int i10 : iArr) {
                byteBufBuffer.writeInt(i10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyLong(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(jArr.length * 8);
            for (long j10 : jArr) {
                byteBufBuffer.writeLong(j10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyMedium(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(iArr.length * 3);
            for (int i10 : iArr) {
                byteBufBuffer.writeMedium(i10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(short... sArr) {
        if (sArr != null && sArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(sArr.length * 2);
            for (short s10 : sArr) {
                byteBufBuffer.writeShort(s10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf directBuffer(int i10, int i11) {
        return ALLOC.directBuffer(i10, i11);
    }

    public static ByteBuf copiedBuffer(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i11);
        System.arraycopy(bArr, i10, bArrAllocateUninitializedArray, 0, i11);
        return wrappedBuffer(bArrAllocateUninitializedArray);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return EMPTY_BUFFER;
        }
        if (i10 == 0 && i11 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i10, i11);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(true, byteBufArr);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(iRemaining);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.get(bArrAllocateUninitializedArray);
        return wrappedBuffer(bArrAllocateUninitializedArray).order(byteBufferDuplicate.order());
    }

    public static ByteBuf copyShort(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf byteBufBuffer = buffer(iArr.length * 2);
            for (int i10 : iArr) {
                byteBufBuffer.writeShort(i10);
            }
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!byteBuffer.isDirect() && byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (byteBuffer.isReadOnly()) {
                if (byteBuffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
        if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        }
        return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 > 0) {
            ByteBuf byteBufBuffer = buffer(i10);
            byteBufBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(byte[]... bArr) {
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            int length2 = 0;
            for (byte[] bArr2 : bArr) {
                if (Integer.MAX_VALUE - length2 >= bArr2.length) {
                    length2 += bArr2.length;
                } else {
                    throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                }
            }
            if (length2 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length2);
            int length3 = 0;
            for (byte[] bArr3 : bArr) {
                System.arraycopy(bArr3, 0, bArrAllocateUninitializedArray, length3, bArr3.length);
                length3 += bArr3.length;
            }
            return wrappedBuffer(bArrAllocateUninitializedArray);
        }
        byte[] bArr4 = bArr[0];
        if (bArr4.length == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(bArr4);
    }

    public static ByteBuf wrappedBuffer(long j10, int i10, boolean z10) {
        return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, j10, i10, z10);
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(bArr.length, bArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuf... byteBufArr) {
        return wrappedBuffer(byteBufArr.length, byteBufArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer... byteBufferArr) {
        return wrappedBuffer(byteBufferArr.length, byteBufferArr);
    }

    public static <T> ByteBuf wrappedBuffer(int i10, CompositeByteBuf.ByteWrapper<T> byteWrapper, T[] tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                int length2 = tArr.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    T t10 = tArr[i11];
                    if (t10 == null) {
                        return EMPTY_BUFFER;
                    }
                    if (!byteWrapper.isEmpty(t10)) {
                        return new CompositeByteBuf(ALLOC, false, i10, byteWrapper, tArr, i11);
                    }
                }
            } else if (!byteWrapper.isEmpty(tArr[0])) {
                return byteWrapper.wrap(tArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            ByteOrder byteOrderOrder = null;
            int i10 = 0;
            for (ByteBuf byteBuf : byteBufArr) {
                int i11 = byteBuf.readableBytes();
                if (i11 > 0) {
                    if (Integer.MAX_VALUE - i10 < i11) {
                        throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                    }
                    i10 += i11;
                    if (byteOrderOrder != null) {
                        if (!byteOrderOrder.equals(byteBuf.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    } else {
                        byteOrderOrder = byteBuf.order();
                    }
                }
            }
            if (i10 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i10);
            int i12 = 0;
            for (ByteBuf byteBuf2 : byteBufArr) {
                int i13 = byteBuf2.readableBytes();
                byteBuf2.getBytes(byteBuf2.readerIndex(), bArrAllocateUninitializedArray, i12, i13);
                i12 += i13;
            }
            return wrappedBuffer(bArrAllocateUninitializedArray).order(byteOrderOrder);
        }
        return copiedBuffer(byteBufArr[0]);
    }

    public static ByteBuf wrappedBuffer(int i10, byte[]... bArr) {
        return wrappedBuffer(i10, CompositeByteBuf.BYTE_ARRAY_WRAPPER, bArr);
    }

    public static ByteBuf wrappedBuffer(int i10, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length != 1) {
                for (int i11 = 0; i11 < byteBufArr.length; i11++) {
                    ByteBuf byteBuf = byteBufArr[i11];
                    if (byteBuf.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, i10, byteBufArr, i11);
                    }
                    byteBuf.release();
                }
            } else {
                ByteBuf byteBuf2 = byteBufArr[0];
                if (byteBuf2.isReadable()) {
                    return wrappedBuffer(byteBuf2.order(BIG_ENDIAN));
                }
                byteBuf2.release();
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            ByteOrder byteOrderOrder = null;
            int i10 = 0;
            for (ByteBuffer byteBuffer : byteBufferArr) {
                int iRemaining = byteBuffer.remaining();
                if (iRemaining > 0) {
                    if (Integer.MAX_VALUE - i10 < iRemaining) {
                        throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                    }
                    i10 += iRemaining;
                    if (byteOrderOrder != null) {
                        if (!byteOrderOrder.equals(byteBuffer.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                    } else {
                        byteOrderOrder = byteBuffer.order();
                    }
                }
            }
            if (i10 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i10);
            int i11 = 0;
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                int iRemaining2 = byteBufferDuplicate.remaining();
                byteBufferDuplicate.get(bArrAllocateUninitializedArray, i11, iRemaining2);
                i11 += iRemaining2;
            }
            return wrappedBuffer(bArrAllocateUninitializedArray).order(byteOrderOrder);
        }
        return copiedBuffer(byteBufferArr[0]);
    }

    public static ByteBuf wrappedBuffer(int i10, ByteBuffer... byteBufferArr) {
        return wrappedBuffer(i10, CompositeByteBuf.BYTE_BUFFER_WRAPPER, byteBufferArr);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        ObjectUtil.checkNotNull(charSequence, "string");
        if (CharsetUtil.UTF_8.equals(charset)) {
            return copiedBufferUtf8(charSequence);
        }
        if (CharsetUtil.US_ASCII.equals(charset)) {
            return copiedBufferAscii(charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return copiedBuffer((CharBuffer) charSequence, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence), charset);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int i10, int i11, Charset charset) {
        ObjectUtil.checkNotNull(charSequence, "string");
        if (i11 == 0) {
            return EMPTY_BUFFER;
        }
        if (charSequence instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) charSequence;
            if (charBuffer.hasArray()) {
                return copiedBuffer(charBuffer.array(), charBuffer.position() + charBuffer.arrayOffset() + i10, i11, charset);
            }
            CharBuffer charBufferSlice = charBuffer.slice();
            charBufferSlice.limit(i11);
            charBufferSlice.position(i10);
            return copiedBuffer(charBufferSlice, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence, i10, i11 + i10), charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, Charset charset) {
        ObjectUtil.checkNotNull(cArr, d.f3685p);
        return copiedBuffer(cArr, 0, cArr.length, charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, int i10, int i11, Charset charset) {
        ObjectUtil.checkNotNull(cArr, d.f3685p);
        if (i11 == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(CharBuffer.wrap(cArr, i10, i11), charset);
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset, 0);
    }
}
