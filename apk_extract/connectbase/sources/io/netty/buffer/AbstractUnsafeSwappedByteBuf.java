package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    public AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
        this.wrapped = abstractByteBuf;
        this.nativeByteOrder = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER == (order() == ByteOrder.BIG_ENDIAN);
    }

    public abstract int _getInt(AbstractByteBuf abstractByteBuf, int i10);

    public abstract long _getLong(AbstractByteBuf abstractByteBuf, int i10);

    public abstract short _getShort(AbstractByteBuf abstractByteBuf, int i10);

    public abstract void _setInt(AbstractByteBuf abstractByteBuf, int i10, int i11);

    public abstract void _setLong(AbstractByteBuf abstractByteBuf, int i10, long j10);

    public abstract void _setShort(AbstractByteBuf abstractByteBuf, int i10, short s10);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final char getChar(int i10) {
        return (char) getShort(i10);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i10) {
        this.wrapped.checkIndex(i10, 4);
        int i_getInt = _getInt(this.wrapped, i10);
        return this.nativeByteOrder ? i_getInt : Integer.reverseBytes(i_getInt);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i10) {
        this.wrapped.checkIndex(i10, 8);
        long j_getLong = _getLong(this.wrapped, i10);
        return this.nativeByteOrder ? j_getLong : Long.reverseBytes(j_getLong);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i10) {
        this.wrapped.checkIndex(i10, 2);
        short s_getShort = _getShort(this.wrapped, i10);
        return this.nativeByteOrder ? s_getShort : Short.reverseBytes(s_getShort);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i10) {
        return ((long) getInt(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i10) {
        return getShort(i10) & g2.f10190d;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i10, int i11) {
        setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i10, double d10) {
        setLong(i10, Double.doubleToRawLongBits(d10));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i10, float f10) {
        setInt(i10, Float.floatToRawIntBits(f10));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i10, int i11) {
        this.wrapped.checkIndex(i10, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i11 = Integer.reverseBytes(i11);
        }
        _setInt(abstractByteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i10, long j10) {
        this.wrapped.checkIndex(i10, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            j10 = Long.reverseBytes(j10);
        }
        _setLong(abstractByteBuf, i10, j10);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i10, int i11) {
        this.wrapped.checkIndex(i10, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short sReverseBytes = (short) i11;
        if (!this.nativeByteOrder) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        _setShort(abstractByteBuf, i10, sReverseBytes);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i10) {
        writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d10) {
        writeLong(Double.doubleToRawLongBits(d10));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f10) {
        writeInt(Float.floatToRawIntBits(f10));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i10) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i11 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i10 = Integer.reverseBytes(i10);
        }
        _setInt(abstractByteBuf, i11, i10);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j10) {
        this.wrapped.ensureWritable0(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i10 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            j10 = Long.reverseBytes(j10);
        }
        _setLong(abstractByteBuf, i10, j10);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i10) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i11 = abstractByteBuf.writerIndex;
        short sReverseBytes = (short) i10;
        if (!this.nativeByteOrder) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        _setShort(abstractByteBuf, i11, sReverseBytes);
        this.wrapped.writerIndex += 2;
        return this;
    }
}
