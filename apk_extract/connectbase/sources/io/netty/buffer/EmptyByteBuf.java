package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyByteBuf extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER;
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    static final int EMPTY_BYTE_BUF_HASH_CODE = 1;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    static {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(0);
        EMPTY_BYTE_BUFFER = byteBufferAllocateDirect;
        long jDirectBufferAddress = 0;
        try {
            if (PlatformDependent.hasUnsafe()) {
                jDirectBufferAddress = PlatformDependent.directBufferAddress(byteBufferAllocateDirect);
            }
        } catch (Throwable unused) {
        }
        EMPTY_BYTE_BUFFER_ADDRESS = jDirectBufferAddress;
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        this(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private ByteBuf checkIndex(int i10) {
        if (i10 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "length");
        if (i10 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b10) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "minWritableBytes");
        if (i10 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && !((ByteBuf) obj).isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf) {
        return checkIndex(i10, byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i10, int i11, Charset charset) {
        checkIndex(i10, i11);
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i10, int i11, byte b10) {
        checkIndex(i10);
        checkIndex(i11);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        if (hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i10, Charset charset) {
        checkLength(i10);
        return "";
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return 0;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i10, boolean z10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i10, double d10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i10, float f10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i10, int i11) {
        checkIndex(i10);
        checkIndex(i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return "";
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return 0;
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.order = byteOrder;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append(byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
        this.str = sb2.toString();
    }

    private ByteBuf checkIndex(int i10, int i11) {
        ObjectUtil.checkPositiveOrZero(i11, "length");
        if (i10 == 0 && i11 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, byte b10) {
        checkLength(i10);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return byteBuf.isReadable() ? -1 : 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex(i10, i11);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex(i10, i11);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i10) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i10) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return nioBuffer();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex(i10, i11);
        return nioBuffers();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf = this.swapped;
        if (emptyByteBuf != null) {
            return emptyByteBuf;
        }
        EmptyByteBuf emptyByteBuf2 = new EmptyByteBuf(alloc(), byteOrder);
        this.swapped = emptyByteBuf2;
        return emptyByteBuf2;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i10) {
        return checkIndex(i10);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i10) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i10) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        checkIndex(i10, i11);
        return toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i10) {
        return checkIndex(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, int i11, byte b10) {
        checkIndex(i10, i11);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i10, boolean z10) {
        ObjectUtil.checkPositiveOrZero(i10, "minWritableBytes");
        return i10 == 0 ? 0 : 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        return checkIndex(i10, i12);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        return checkIndex(i10, i12);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        return checkLength(i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        return checkIndex(i10, bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        return checkLength(i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr) {
        return checkIndex(i10, bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return this.str;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        return checkIndex(i10, i12);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        return checkIndex(i10, i12);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        return checkLength(i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        return checkIndex(i10, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i10, int i11) {
        return checkLength(i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        return checkIndex(i10, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) {
        return checkIndex(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        checkIndex(i10, i11);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) {
        checkLength(i10);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        checkIndex(i10, i11);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i10) {
        return checkLength(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        checkIndex(i10, i11);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) {
        checkLength(i10);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) {
        checkIndex(i10, i11);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) {
        checkLength(i10);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) {
        checkIndex(i10, i11);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j10, int i10) {
        checkLength(i10);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j10, int i10) {
        checkLength(i10);
        return 0;
    }
}
