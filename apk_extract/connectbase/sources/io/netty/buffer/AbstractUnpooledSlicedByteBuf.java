package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.MathUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    public AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i10, int i11) {
        super(i11);
        checkSliceOutOfBounds(i10, i11, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i10;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i10;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i10;
        }
        initLength(i11);
        writerIndex(i11);
    }

    public static void checkSliceOutOfBounds(int i10, int i11, ByteBuf byteBuf) {
        if (MathUtil.isOutOfBounds(i10, i11, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i10 + ", " + i11 + ')');
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return unwrap().getByte(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return unwrap().getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return unwrap().getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return unwrap().getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return unwrap().getLongLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return unwrap().getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return unwrap().getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return unwrap().getUnsignedMedium(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return unwrap().getUnsignedMediumLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        unwrap().setByte(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        unwrap().setInt(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        unwrap().setIntLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        unwrap().setLong(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        unwrap().setLongLE(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        unwrap().setMedium(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        unwrap().setMediumLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        unwrap().setShort(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        unwrap().setShortLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().copy(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return unwrap().duplicate().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex0(i10, i11);
        int iForEachByte = unwrap().forEachByte(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByte >= i12) {
            return iForEachByte - i12;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex0(i10, i11);
        int iForEachByteDesc = unwrap().forEachByteDesc(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByteDesc >= i12) {
            return iForEachByteDesc - i12;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex0(i10, 1);
        return unwrap().getByte(idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i10, int i11, Charset charset) {
        checkIndex0(i10, i11);
        return unwrap().getCharSequence(idx(i10), i11, charset);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLongLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        checkIndex0(i10, 3);
        return unwrap().getUnsignedMedium(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        checkIndex0(i10, 3);
        return unwrap().getUnsignedMediumLE(idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    public final int idx(int i10) {
        return i10 + this.adjustment;
    }

    public void initLength(int i10) {
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    public int length() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + ((long) this.adjustment);
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffer(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffers(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex0(i10, 1);
        unwrap().setByte(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex0(i10, 4);
        unwrap().setInt(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        checkIndex0(i10, 4);
        unwrap().setIntLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        checkIndex0(i10, 8);
        unwrap().setLong(idx(i10), j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        checkIndex0(i10, 8);
        unwrap().setLongLE(idx(i10), j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex0(i10, 3);
        unwrap().setMedium(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        checkIndex0(i10, 3);
        unwrap().setMediumLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex0(i10, 2);
        unwrap().setShort(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        checkIndex0(i10, 2);
        unwrap().setShortLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().slice(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        checkIndex0(i10, byteBuffer.remaining());
        unwrap().getBytes(idx(i10), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        checkIndex0(i10, byteBuffer.remaining());
        unwrap().setBytes(idx(i10), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        checkIndex0(i10, i11);
        unwrap().getBytes(idx(i10), outputStream, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().getBytes(idx(i10), gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().getBytes(idx(i10), fileChannel, j10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), fileChannel, j10, i11);
    }
}
