package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class UnpooledUnsafeDirectByteBuf extends UnpooledDirectByteBuf {
    long memoryAddress;

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return UnsafeByteBufUtil.getLongLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        UnsafeByteBufUtil.setIntLE(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        UnsafeByteBufUtil.setLong(addr(i10), j10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        UnsafeByteBufUtil.setLongLE(addr(i10), j10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        UnsafeByteBufUtil.setMediumLE(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        UnsafeByteBufUtil.setShortLE(addr(i10), i11);
    }

    public final long addr(int i10) {
        return this.memoryAddress + ((long) i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        return UnsafeByteBufUtil.copy(this, addr(i10), i10, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        checkIndex(i10, 3);
        return _getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeDirectSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public final void setByteBuffer(ByteBuffer byteBuffer, boolean z10) {
        super.setByteBuffer(byteBuffer, z10);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        checkIndex(i10, 8);
        _setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        checkIndex(i10, i11);
        UnsafeByteBufUtil.setZero(addr(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        ensureWritable(i10);
        int i11 = this.writerIndex;
        UnsafeByteBufUtil.setZero(addr(i11), i10);
        this.writerIndex = i11 + i10;
        return this;
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i10) {
        super(byteBufAllocator, byteBuffer, i10, false, true);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, bArr, i11, i12);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, bArr, i11, i12);
        return this;
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i10, boolean z10) {
        super(byteBufAllocator, byteBuffer, i10, z10, false);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int i10, ByteBuffer byteBuffer, boolean z10) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int i10, OutputStream outputStream, int i11, boolean z10) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, outputStream, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(i10), i10, inputStream, i11);
    }
}
