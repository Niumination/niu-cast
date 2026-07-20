package io.netty.buffer;

import androidx.core.view.ViewCompat;
import el.b0;
import h.b;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractByteBuf extends ByteBuf {
    private static final String LEGACY_PROP_CHECK_ACCESSIBLE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final String PROP_CHECK_ACCESSIBLE = "io.netty.buffer.checkAccessible";
    private static final String PROP_CHECK_BOUNDS = "io.netty.buffer.checkBounds";
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector<ByteBuf> leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) AbstractByteBuf.class);
        logger = internalLoggerFactory;
        if (SystemPropertyUtil.contains(PROP_CHECK_ACCESSIBLE)) {
            checkAccessible = SystemPropertyUtil.getBoolean(PROP_CHECK_ACCESSIBLE, true);
        } else {
            checkAccessible = SystemPropertyUtil.getBoolean(LEGACY_PROP_CHECK_ACCESSIBLE, true);
        }
        boolean z10 = SystemPropertyUtil.getBoolean(PROP_CHECK_BOUNDS, true);
        checkBounds = z10;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", PROP_CHECK_ACCESSIBLE, Boolean.valueOf(checkAccessible));
            internalLoggerFactory.debug("-D{}: {}", PROP_CHECK_BOUNDS, Boolean.valueOf(z10));
        }
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    public AbstractByteBuf(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "maxCapacity");
        this.maxCapacity = i10;
    }

    private static void checkIndexBounds(int i10, int i11, int i12) {
        if (i10 < 0 || i10 > i11 || i11 > i12) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    private static void checkRangeBounds(String str, int i10, int i11, int i12) {
        if (MathUtil.isOutOfBounds(i10, i11, i12)) {
            throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    private static void checkReadableBounds(ByteBuf byteBuf, int i10) {
        if (i10 > byteBuf.readableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i10), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
        }
    }

    private void checkReadableBytes0(int i10) {
        ensureAccessible();
        if (checkBounds && this.readerIndex > this.writerIndex - i10) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.readerIndex), Integer.valueOf(i10), Integer.valueOf(this.writerIndex), this));
        }
    }

    private int setCharSequence0(int i10, CharSequence charSequence, Charset charset, boolean z10) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            int iUtf8MaxBytes = ByteBufUtil.utf8MaxBytes(charSequence);
            if (z10) {
                ensureWritable0(iUtf8MaxBytes);
                checkIndex0(i10, iUtf8MaxBytes);
            } else {
                checkIndex(i10, iUtf8MaxBytes);
            }
            return ByteBufUtil.writeUtf8(this, i10, iUtf8MaxBytes, charSequence, charSequence.length());
        }
        if (!charset.equals(CharsetUtil.US_ASCII) && !charset.equals(CharsetUtil.ISO_8859_1)) {
            byte[] bytes = charSequence.toString().getBytes(charset);
            if (z10) {
                ensureWritable0(bytes.length);
            }
            setBytes(i10, bytes);
            return bytes.length;
        }
        int length = charSequence.length();
        if (z10) {
            ensureWritable0(length);
            checkIndex0(i10, length);
        } else {
            checkIndex(i10, length);
        }
        return ByteBufUtil.writeAscii(this, i10, charSequence, length);
    }

    public abstract byte _getByte(int i10);

    public abstract int _getInt(int i10);

    public abstract int _getIntLE(int i10);

    public abstract long _getLong(int i10);

    public abstract long _getLongLE(int i10);

    public abstract short _getShort(int i10);

    public abstract short _getShortLE(int i10);

    public abstract int _getUnsignedMedium(int i10);

    public abstract int _getUnsignedMediumLE(int i10);

    public abstract void _setByte(int i10, int i11);

    public abstract void _setInt(int i10, int i11);

    public abstract void _setIntLE(int i10, int i11);

    public abstract void _setLong(int i10, long j10);

    public abstract void _setLongLE(int i10, long j10);

    public abstract void _setMedium(int i10, int i11);

    public abstract void _setMediumLE(int i10, int i11);

    public abstract void _setShort(int i10, int i11);

    public abstract void _setShortLE(int i10, int i11);

    public final void adjustMarkers(int i10) {
        int i11 = this.markedReaderIndex;
        if (i11 > i10) {
            this.markedReaderIndex = i11 - i10;
            this.markedWriterIndex -= i10;
            return;
        }
        this.markedReaderIndex = 0;
        int i12 = this.markedWriterIndex;
        if (i12 <= i10) {
            this.markedWriterIndex = 0;
        } else {
            this.markedWriterIndex = i12 - i10;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return isReadOnly() ? this : Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b10) {
        return bytesBefore(readerIndex(), readableBytes(), b10);
    }

    public final void checkDstIndex(int i10, int i11, int i12, int i13) {
        checkIndex(i10, i11);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i12, i11, i13);
        }
    }

    public final void checkIndex(int i10) {
        checkIndex(i10, 1);
    }

    public final void checkIndex0(int i10, int i11) {
        if (checkBounds) {
            checkRangeBounds("index", i10, i11, capacity());
        }
    }

    public final void checkNewCapacity(int i10) {
        ensureAccessible();
        if (checkBounds) {
            if (i10 < 0 || i10 > maxCapacity()) {
                StringBuilder sbA = b.a("newCapacity: ", i10, " (expected: 0-");
                sbA.append(maxCapacity());
                sbA.append(')');
                throw new IllegalArgumentException(sbA.toString());
            }
        }
    }

    public final void checkReadableBytes(int i10) {
        checkReadableBytes0(ObjectUtil.checkPositiveOrZero(i10, "minimumReadableBytes"));
    }

    public final void checkSrcIndex(int i10, int i11, int i12, int i13) {
        checkIndex(i10, i11);
        if (checkBounds) {
            checkRangeBounds("srcIndex", i12, i11, i13);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return copy(this.readerIndex, readableBytes());
    }

    public final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        int i10 = this.readerIndex;
        if (i10 == 0) {
            ensureAccessible();
            return this;
        }
        int i11 = this.writerIndex;
        if (i10 != i11) {
            setBytes(0, this, i10, i11 - i10);
            int i12 = this.writerIndex;
            int i13 = this.readerIndex;
            this.writerIndex = i12 - i13;
            adjustMarkers(i13);
            this.readerIndex = 0;
        } else {
            ensureAccessible();
            adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
            this.writerIndex = 0;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        int i10 = this.readerIndex;
        if (i10 > 0) {
            if (i10 == this.writerIndex) {
                ensureAccessible();
                adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            }
            if (i10 >= (capacity() >>> 1)) {
                int i11 = this.readerIndex;
                setBytes(0, this, i11, this.writerIndex - i11);
                int i12 = this.writerIndex;
                int i13 = this.readerIndex;
                this.writerIndex = i12 - i13;
                adjustMarkers(i13);
                this.readerIndex = 0;
                return this;
            }
        }
        ensureAccessible();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    public final void ensureAccessible() {
        if (checkAccessible && !isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        ensureWritable0(ObjectUtil.checkPositiveOrZero(i10, "minWritableBytes"));
        return this;
    }

    public final void ensureWritable0(int i10) {
        int iWriterIndex = writerIndex();
        int i11 = iWriterIndex + i10;
        if ((i11 <= capacity()) && (i11 >= 0)) {
            ensureAccessible();
            return;
        }
        if (checkBounds && (i11 < 0 || i11 > this.maxCapacity)) {
            ensureAccessible();
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(iWriterIndex), Integer.valueOf(i10), Integer.valueOf(this.maxCapacity), this));
        }
        int iMaxFastWritableBytes = maxFastWritableBytes();
        capacity(iMaxFastWritableBytes >= i10 ? iWriterIndex + iMaxFastWritableBytes : alloc().calculateNewCapacity(i11, this.maxCapacity));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && ByteBufUtil.equals(this, (ByteBuf) obj);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) throws Throwable {
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    public int forEachByteAsc0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        while (i10 < i11) {
            if (!byteProcessor.process(_getByte(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) throws Throwable {
        ensureAccessible();
        try {
            return forEachByteDesc0(this.writerIndex - 1, this.readerIndex, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    public int forEachByteDesc0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        while (i10 >= i11) {
            if (!byteProcessor.process(_getByte(i10))) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i10) {
        return getByte(i10) != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        getBytes(i10, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i10) {
        return (char) getShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i10, int i11, Charset charset) {
        return (CharsetUtil.US_ASCII.equals(charset) || CharsetUtil.ISO_8859_1.equals(charset)) ? new AsciiString(ByteBufUtil.getBytes(this, i10, i11, true), false) : toString(i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex(i10, 4);
        return _getIntLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        checkIndex(i10, 8);
        return _getLongLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i10) {
        int unsignedMedium = getUnsignedMedium(i10);
        return (8388608 & unsignedMedium) != 0 ? unsignedMedium | ViewCompat.MEASURED_STATE_MASK : unsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i10) {
        int unsignedMediumLE = getUnsignedMediumLE(i10);
        return (8388608 & unsignedMediumLE) != 0 ? unsignedMediumLE | ViewCompat.MEASURED_STATE_MASK : unsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex(i10, 2);
        return _getShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        return (short) (getByte(i10) & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        return ((long) getInt(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        return ((long) getIntLE(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        checkIndex(i10, 3);
        return _getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        checkIndex(i10, 3);
        return _getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i10) {
        return getShort(i10) & g2.f10190d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i10) {
        return getShortLE(i10) & g2.f10190d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i10, int i11, byte b10) {
        return i10 <= i11 ? ByteBufUtil.firstIndexOf(this, i10, i11, b10) : ByteBufUtil.lastIndexOf(this, i10, i11, b10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return capacity() > this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    public SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == order()) {
            return this;
        }
        ObjectUtil.checkNotNull(byteOrder, "endianness");
        return newSwappedByteBuf();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return readByte() != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes0(1);
        int i10 = this.readerIndex;
        byte b_getByte = _getByte(i10);
        this.readerIndex = i10 + 1;
        return b_getByte;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        checkReadableBytes(i10);
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = alloc().buffer(i10, this.maxCapacity);
        byteBufBuffer.writeBytes(this, this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char) readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i10, Charset charset) {
        CharSequence charSequence = getCharSequence(this.readerIndex, i10, charset);
        this.readerIndex += i10;
        return charSequence;
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes0(4);
        int i_getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return i_getInt;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        checkReadableBytes0(4);
        int i_getIntLE = _getIntLE(this.readerIndex);
        this.readerIndex += 4;
        return i_getIntLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes0(8);
        long j_getLong = _getLong(this.readerIndex);
        this.readerIndex += 8;
        return j_getLong;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        checkReadableBytes0(8);
        long j_getLongLE = _getLongLE(this.readerIndex);
        this.readerIndex += 8;
        return j_getLongLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        int unsignedMedium = readUnsignedMedium();
        return (8388608 & unsignedMedium) != 0 ? unsignedMedium | ViewCompat.MEASURED_STATE_MASK : unsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        int unsignedMediumLE = readUnsignedMediumLE();
        return (8388608 & unsignedMediumLE) != 0 ? unsignedMediumLE | ViewCompat.MEASURED_STATE_MASK : unsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        checkReadableBytes(i10);
        ByteBuf byteBufRetainedSlice = retainedSlice(this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufRetainedSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes0(2);
        short s_getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return s_getShort;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        checkReadableBytes0(2);
        short s_getShortLE = _getShortLE(this.readerIndex);
        this.readerIndex += 2;
        return s_getShortLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        checkReadableBytes(i10);
        ByteBuf byteBufSlice = slice(this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return ((long) readIntLE()) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        checkReadableBytes0(3);
        int i_getUnsignedMedium = _getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return i_getUnsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        checkReadableBytes0(3);
        int i_getUnsignedMediumLE = _getUnsignedMediumLE(this.readerIndex);
        this.readerIndex += 3;
        return i_getUnsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & g2.f10190d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return readShortLE() & g2.f10190d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        writerIndex(this.markedWriterIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i10, boolean z10) {
        setByte(i10, z10 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr) {
        setBytes(i10, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i10, int i11) {
        setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        return setCharSequence0(i10, charSequence, charset, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i10, double d10) {
        setLong(i10, Double.doubleToRawLongBits(d10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i10, float f10) {
        setInt(i10, Float.floatToRawIntBits(f10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i10, int i11) {
        if (checkBounds) {
            checkIndexBounds(i10, i11, capacity());
        }
        setIndex0(i10, i11);
        return this;
    }

    public final void setIndex0(int i10, int i11) {
        this.readerIndex = i10;
        this.writerIndex = i11;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        checkIndex(i10, 4);
        _setIntLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        checkIndex(i10, 8);
        _setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        checkIndex(i10, 8);
        _setLongLE(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        checkIndex(i10, 3);
        _setMediumLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        checkIndex(i10, 2);
        _setShortLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        if (i11 == 0) {
            return this;
        }
        checkIndex(i10, i11);
        int i12 = i11 & 7;
        for (int i13 = i11 >>> 3; i13 > 0; i13--) {
            _setLong(i10, 0L);
            i10 += 8;
        }
        if (i12 == 4) {
            _setInt(i10, 0);
        } else if (i12 < 4) {
            while (i12 > 0) {
                _setByte(i10, 0);
                i10++;
                i12--;
            }
        } else {
            _setInt(i10, 0);
            int i14 = i10 + 4;
            for (int i15 = i12 - 4; i15 > 0; i15--) {
                _setByte(i14, 0);
                i14++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        checkReadableBytes(i10);
        this.readerIndex += i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return slice(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    public final void trimIndicesToCapacity(int i10) {
        if (writerIndex() > i10) {
            setIndex0(Math.min(readerIndex(), i10), i10);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z10) {
        writeByte(z10 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        ensureWritable0(1);
        int i11 = this.writerIndex;
        this.writerIndex = i11 + 1;
        _setByte(i11, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        ensureWritable(i11);
        setBytes(this.writerIndex, bArr, i10, i11);
        this.writerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i10) {
        writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence0 = setCharSequence0(this.writerIndex, charSequence, charset, true);
        this.writerIndex += charSequence0;
        return charSequence0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d10) {
        writeLong(Double.doubleToRawLongBits(d10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f10) {
        writeInt(Float.floatToRawIntBits(f10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        ensureWritable0(4);
        _setInt(this.writerIndex, i10);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i10) {
        ensureWritable0(4);
        _setIntLE(this.writerIndex, i10);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j10) {
        ensureWritable0(8);
        _setLong(this.writerIndex, j10);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j10) {
        ensureWritable0(8);
        _setLongLE(this.writerIndex, j10);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        ensureWritable0(3);
        _setMedium(this.writerIndex, i10);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i10) {
        ensureWritable0(3);
        _setMediumLE(this.writerIndex, i10);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        ensureWritable0(2);
        _setShort(this.writerIndex, i10);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i10) {
        ensureWritable0(2);
        _setShortLE(this.writerIndex, i10);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        if (i10 == 0) {
            return this;
        }
        ensureWritable(i10);
        int i11 = this.writerIndex;
        checkIndex0(i11, i10);
        int i12 = i10 & 7;
        for (int i13 = i10 >>> 3; i13 > 0; i13--) {
            _setLong(i11, 0L);
            i11 += 8;
        }
        if (i12 == 4) {
            _setInt(i11, 0);
            i11 += 4;
        } else if (i12 < 4) {
            while (i12 > 0) {
                _setByte(i11, 0);
                i11++;
                i12--;
            }
        } else {
            _setInt(i11, 0);
            i11 += 4;
            for (int i14 = i12 - 4; i14 > 0; i14--) {
                _setByte(i11, 0);
                i11++;
            }
        }
        this.writerIndex = i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, byte b10) {
        checkReadableBytes(i10);
        return bytesBefore(readerIndex(), i10, b10);
    }

    public final void checkIndex(int i10, int i11) {
        ensureAccessible();
        checkIndex0(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i10, boolean z10) {
        ensureAccessible();
        ObjectUtil.checkPositiveOrZero(i10, "minWritableBytes");
        if (i10 <= writableBytes()) {
            return 0;
        }
        int iMaxCapacity = maxCapacity();
        int iWriterIndex = writerIndex();
        if (i10 <= iMaxCapacity - iWriterIndex) {
            int iMaxFastWritableBytes = maxFastWritableBytes();
            capacity(iMaxFastWritableBytes >= i10 ? iWriterIndex + iMaxFastWritableBytes : alloc().calculateNewCapacity(iWriterIndex + i10, iMaxCapacity));
            return 2;
        }
        if (!z10 || capacity() == iMaxCapacity) {
            return 1;
        }
        capacity(iMaxCapacity);
        return 3;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf) {
        getBytes(i10, byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i10) {
        return this.writerIndex - this.readerIndex >= i10;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i10) {
        return capacity() - this.writerIndex >= i10;
    }

    public final void maxCapacity(int i10) {
        this.maxCapacity = i10;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i10) {
        if (checkBounds) {
            checkIndexBounds(i10, this.writerIndex, capacity());
        }
        this.readerIndex = i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        return slice(i10, i11).retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf) {
        setBytes(i10, byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        ensureAccessible();
        return new UnpooledSlicedByteBuf(this, i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        return ByteBufUtil.decodeString(this, i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i10) {
        if (checkBounds) {
            checkIndexBounds(this.readerIndex, i10, capacity());
        }
        this.writerIndex = i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11) {
        getBytes(i10, byteBuf, byteBuf.writerIndex(), i11);
        byteBuf.writerIndex(byteBuf.writerIndex() + i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11) {
        checkIndex(i10, i11);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (checkBounds) {
            checkReadableBounds(byteBuf, i11);
        }
        setBytes(i10, byteBuf, byteBuf.readerIndex(), i11);
        byteBuf.readerIndex(byteBuf.readerIndex() + i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(ridx: ");
        sb2.append(this.readerIndex);
        sb2.append(", widx: ");
        sb2.append(this.writerIndex);
        sb2.append(", cap: ");
        sb2.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb2.append(b0.f4502a);
            sb2.append(this.maxCapacity);
        }
        ByteBuf byteBufUnwrap = unwrap();
        if (byteBufUnwrap != null) {
            sb2.append(", unwrapped: ");
            sb2.append(byteBufUnwrap);
        }
        sb2.append(')');
        return sb2.toString();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, int i11, byte b10) {
        int iIndexOf = indexOf(i10, i11 + i10, b10);
        if (iIndexOf < 0) {
            return -1;
        }
        return iIndexOf - i10;
    }

    public final void checkDstIndex(int i10, int i11, int i12) {
        checkReadableBytes(i10);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i11, i10, i12);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) throws Throwable {
        checkIndex(i10, i11);
        try {
            return forEachByteAsc0(i10, i11 + i10, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) throws Throwable {
        checkIndex(i10, i11);
        try {
            return forEachByteDesc0((i11 + i10) - 1, i10, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i10, int i11) {
        checkReadableBytes(i11);
        getBytes(this.readerIndex, bArr, i10, i11);
        this.readerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        if (checkBounds) {
            checkReadableBounds(byteBuf, i10);
        }
        writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        byteBuf.readerIndex(byteBuf.readerIndex() + i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        ensureWritable(i11);
        setBytes(this.writerIndex, byteBuf, i10, i11);
        this.writerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        if (checkBounds && i10 > byteBuf.writableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", Integer.valueOf(i10), Integer.valueOf(byteBuf.writableBytes()), byteBuf));
        }
        readBytes(byteBuf, byteBuf.writerIndex(), i10);
        byteBuf.writerIndex(byteBuf.writerIndex() + i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        ensureWritable0(iRemaining);
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += iRemaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) throws IOException {
        ensureWritable(i10);
        int bytes = setBytes(this.writerIndex, inputStream, i10);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        checkReadableBytes(i11);
        getBytes(this.readerIndex, byteBuf, i10, i11);
        this.readerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) throws IOException {
        ensureWritable(i10);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i10);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkReadableBytes(iRemaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += iRemaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j10, int i10) throws IOException {
        ensureWritable(i10);
        int bytes = setBytes(this.writerIndex, fileChannel, j10, i10);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) throws IOException {
        checkReadableBytes(i10);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i10);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j10, int i10) throws IOException {
        checkReadableBytes(i10);
        int bytes = getBytes(this.readerIndex, fileChannel, j10, i10);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i10) throws IOException {
        checkReadableBytes(i10);
        getBytes(this.readerIndex, outputStream, i10);
        this.readerIndex += i10;
        return this;
    }
}
