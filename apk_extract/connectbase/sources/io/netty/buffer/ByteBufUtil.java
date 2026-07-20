package io.netty.buffer;

import androidx.core.view.ViewCompat;
import c1.c;
import i0.a;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.Recycler;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;
import jq.j;
import lm.g2;
import n1.e;
import p5.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteBufUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    static final int MAX_TL_ARRAY_LEN = 1024;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    static final int WRITE_CHUNK_SIZE = 8192;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final InternalLogger logger;

    public static final class SWARByteSearch {
        private SWARByteSearch() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long compilePattern(byte b10) {
            return (((long) b10) & 255) * 72340172838076673L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int firstAnyPattern(long j10, long j11, boolean z10) {
            long j12 = j10 ^ j11;
            long j13 = ~(j12 | ((j12 & 9187201950435737471L) + 9187201950435737471L) | 9187201950435737471L);
            return (z10 ? Long.numberOfLeadingZeros(j13) : Long.numberOfTrailingZeros(j13)) >>> 3;
        }
    }

    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final Recycler.EnhancedHandle<ThreadLocalDirectByteBuf> handle;

        public static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.unguardedRecycle(this);
            }
        }

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = (Recycler.EnhancedHandle) handle;
        }
    }

    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final Recycler.EnhancedHandle<ThreadLocalUnsafeDirectByteBuf> handle;

        public static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.unguardedRecycle(this);
            }
        }

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = (Recycler.EnhancedHandle) handle;
        }
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
        logger = internalLoggerFactory;
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            @Override // io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() throws Exception {
                return PlatformDependent.allocateUninitializedArray(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String strTrim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(strTrim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else if ("pooled".equals(strTrim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", strTrim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i10 = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i10;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i10));
        int i11 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i11;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i11));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b10) {
                return b10 >= 0;
            }
        };
    }

    private ByteBufUtil() {
    }

    public static void appendPrettyHexDump(StringBuilder sb2, ByteBuf byteBuf) {
        appendPrettyHexDump(sb2, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static CharSequence checkCharSequenceBounds(CharSequence charSequence, int i10, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11 - i10, charSequence.length())) {
            return charSequence;
        }
        StringBuilder sbA = a.a("expected: 0 <= start(", i10, ") <= end (", i11, ") <= seq.length(");
        sbA.append(charSequence.length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        long jCompareUintBigEndianA;
        if (byteBuf == byteBuf2) {
            return 0;
        }
        int i10 = byteBuf.readableBytes();
        int i11 = byteBuf2.readableBytes();
        int iMin = Math.min(i10, i11);
        int i12 = iMin >>> 2;
        int i13 = iMin & 3;
        int i14 = byteBuf.readerIndex();
        int i15 = byteBuf2.readerIndex();
        if (i12 > 0) {
            boolean z10 = byteBuf.order() == ByteOrder.BIG_ENDIAN;
            int i16 = i12 << 2;
            if (byteBuf.order() == byteBuf2.order()) {
                jCompareUintBigEndianA = z10 ? compareUintBigEndian(byteBuf, byteBuf2, i14, i15, i16) : compareUintLittleEndian(byteBuf, byteBuf2, i14, i15, i16);
            } else {
                jCompareUintBigEndianA = z10 ? compareUintBigEndianA(byteBuf, byteBuf2, i14, i15, i16) : compareUintBigEndianB(byteBuf, byteBuf2, i14, i15, i16);
            }
            if (jCompareUintBigEndianA != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, jCompareUintBigEndianA));
            }
            i14 += i16;
            i15 += i16;
        }
        int i17 = i13 + i14;
        while (i14 < i17) {
            int unsignedByte = byteBuf.getUnsignedByte(i14) - byteBuf2.getUnsignedByte(i15);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            i14++;
            i15++;
        }
        return i10 - i11;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long unsignedInt = byteBuf.getUnsignedInt(i10) - byteBuf2.getUnsignedInt(i11);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long unsignedInt = byteBuf.getUnsignedInt(i10) - uintFromLE(byteBuf2.getUnsignedIntLE(i11));
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i10)) - byteBuf2.getUnsignedInt(i11);
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i10)) - uintFromLE(byteBuf2.getUnsignedIntLE(i11));
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    public static byte decodeHexByte(CharSequence charSequence, int i10) {
        return StringUtil.decodeHexByte(charSequence, i10);
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return StringUtil.decodeHexDump(charSequence, 0, charSequence.length());
    }

    public static String decodeString(ByteBuf byteBuf, int i10, int i11, Charset charset) {
        byte[] bArrThreadLocalTempArray;
        int iArrayOffset;
        if (i11 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            bArrThreadLocalTempArray = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i10;
        } else {
            bArrThreadLocalTempArray = threadLocalTempArray(i11);
            byteBuf.getBytes(i10, bArrThreadLocalTempArray, 0, i11);
            iArrayOffset = 0;
        }
        return CharsetUtil.US_ASCII.equals(charset) ? new String(bArrThreadLocalTempArray, 0, iArrayOffset, i11) : new String(bArrThreadLocalTempArray, iArrayOffset, i11, charset);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, 0);
    }

    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z10, CharBuffer charBuffer, Charset charset, int i10) {
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(charset);
        int iRemaining = ((int) (((double) charBuffer.remaining()) * ((double) charsetEncoderEncoder.maxBytesPerChar()))) + i10;
        ByteBuf byteBufHeapBuffer = z10 ? byteBufAllocator.heapBuffer(iRemaining) : byteBufAllocator.buffer(iRemaining);
        try {
            try {
                ByteBuffer byteBufferInternalNioBuffer = byteBufHeapBuffer.internalNioBuffer(byteBufHeapBuffer.readerIndex(), iRemaining);
                int iPosition = byteBufferInternalNioBuffer.position();
                CoderResult coderResultEncode = charsetEncoderEncoder.encode(charBuffer, byteBufferInternalNioBuffer, true);
                if (!coderResultEncode.isUnderflow()) {
                    coderResultEncode.throwException();
                }
                CoderResult coderResultFlush = charsetEncoderEncoder.flush(byteBufferInternalNioBuffer);
                if (!coderResultFlush.isUnderflow()) {
                    coderResultFlush.throwException();
                }
                byteBufHeapBuffer.writerIndex((byteBufHeapBuffer.writerIndex() + byteBufferInternalNioBuffer.position()) - iPosition);
                return byteBufHeapBuffer;
            } catch (CharacterCodingException e10) {
                throw new IllegalStateException(e10);
            }
        } catch (Throwable th2) {
            byteBufHeapBuffer.release();
            throw th2;
        }
    }

    public static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(byteBuf.refCnt());
    }

    public static boolean ensureWritableSuccess(int i10) {
        return i10 == 0 || i10 == 2;
    }

    public static boolean equals(ByteBuf byteBuf, int i10, ByteBuf byteBuf2, int i11, int i12) {
        ObjectUtil.checkNotNull(byteBuf, "a");
        ObjectUtil.checkNotNull(byteBuf2, "b");
        ObjectUtil.checkPositiveOrZero(i10, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(i11, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(i12, "length");
        if (byteBuf.writerIndex() - i12 < i10 || byteBuf2.writerIndex() - i12 < i11) {
            return false;
        }
        int i13 = i12 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i13 > 0) {
                if (byteBuf.getLong(i10) != byteBuf2.getLong(i11)) {
                    return false;
                }
                i10 += 8;
                i11 += 8;
                i13--;
            }
        } else {
            while (i13 > 0) {
                if (byteBuf.getLong(i10) != swapLong(byteBuf2.getLong(i11))) {
                    return false;
                }
                i10 += 8;
                i11 += 8;
                i13--;
            }
        }
        for (int i14 = i12 & 7; i14 > 0; i14--) {
            if (byteBuf.getByte(i10) != byteBuf2.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static int firstIndexOf(AbstractByteBuf abstractByteBuf, int i10, int i11, byte b10) {
        int iMax = Math.max(i10, 0);
        if (iMax < i11 && abstractByteBuf.capacity() != 0) {
            int i12 = i11 - iMax;
            abstractByteBuf.checkIndex(iMax, i12);
            if (!PlatformDependent.isUnaligned()) {
                return linearFirstIndexOf(abstractByteBuf, iMax, i11, b10);
            }
            int i13 = i12 & 7;
            if (i13 > 0) {
                int iUnrolledFirstIndexOf = unrolledFirstIndexOf(abstractByteBuf, iMax, i13, b10);
                if (iUnrolledFirstIndexOf != -1) {
                    return iUnrolledFirstIndexOf;
                }
                iMax += i13;
                if (iMax == i11) {
                    return -1;
                }
            }
            int i14 = i12 >>> 3;
            ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
            boolean z10 = byteOrderNativeOrder == abstractByteBuf.order();
            boolean z11 = byteOrderNativeOrder == ByteOrder.LITTLE_ENDIAN;
            long jCompilePattern = SWARByteSearch.compilePattern(b10);
            for (int i15 = 0; i15 < i14; i15++) {
                int iFirstAnyPattern = SWARByteSearch.firstAnyPattern(z11 ? abstractByteBuf._getLongLE(iMax) : abstractByteBuf._getLong(iMax), jCompilePattern, z10);
                if (iFirstAnyPattern < 8) {
                    return iMax + iFirstAnyPattern;
                }
                iMax += 8;
            }
        }
        return -1;
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int hashCode(ByteBuf byteBuf) {
        int iSwapInt;
        int i10 = byteBuf.readableBytes();
        int i11 = i10 >>> 2;
        int i12 = i10 & 3;
        int i13 = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            iSwapInt = 1;
            while (i11 > 0) {
                iSwapInt = (iSwapInt * 31) + byteBuf.getInt(i13);
                i13 += 4;
                i11--;
            }
        } else {
            iSwapInt = 1;
            while (i11 > 0) {
                iSwapInt = (iSwapInt * 31) + swapInt(byteBuf.getInt(i13));
                i13 += 4;
                i11--;
            }
        }
        while (i12 > 0) {
            iSwapInt = (iSwapInt * 31) + byteBuf.getByte(i13);
            i12--;
            i13++;
        }
        if (iSwapInt == 0) {
            return 1;
        }
        return iSwapInt;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || byteBuf == null || byteBuf.readableBytes() > byteBuf2.readableBytes()) {
            return -1;
        }
        int i10 = byteBuf2.readableBytes();
        int i11 = byteBuf.readableBytes();
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            return byteBuf2.indexOf(byteBuf2.readerIndex(), byteBuf2.writerIndex(), byteBuf.getByte(byteBuf.readerIndex()));
        }
        int i12 = byteBuf.readerIndex();
        int i13 = byteBuf2.readerIndex();
        long jMaxSuf = maxSuf(byteBuf, i11, i12, true);
        long jMaxSuf2 = maxSuf(byteBuf, i11, i12, false);
        int iMax = Math.max((int) (jMaxSuf >> 32), (int) (jMaxSuf2 >> 32));
        int iMax2 = Math.max((int) jMaxSuf, (int) jMaxSuf2);
        int i14 = i11 - iMax2;
        int i15 = iMax + 1;
        if (equals(byteBuf, i12, byteBuf, i12 + iMax2, Math.min(i14, i15))) {
            int i16 = -1;
            int i17 = 0;
            while (i17 <= i10 - i11) {
                int iMax3 = Math.max(iMax, i16) + 1;
                while (iMax3 < i11 && byteBuf.getByte(iMax3 + i12) == byteBuf2.getByte(iMax3 + i17 + i13)) {
                    iMax3++;
                }
                if (iMax3 > i10) {
                    return -1;
                }
                if (iMax3 >= i11) {
                    int i18 = iMax;
                    while (i18 > i16 && byteBuf.getByte(i18 + i12) == byteBuf2.getByte(i18 + i17 + i13)) {
                        i18--;
                    }
                    if (i18 <= i16) {
                        return i17 + i13;
                    }
                    i17 += iMax2;
                    i16 = i14 - 1;
                } else {
                    i17 += iMax3 - iMax;
                    i16 = -1;
                }
            }
        } else {
            int iMax4 = Math.max(i15, (i11 - iMax) - 1) + 1;
            int i19 = 0;
            while (i19 <= i10 - i11) {
                int i20 = i15;
                while (i20 < i11 && byteBuf.getByte(i20 + i12) == byteBuf2.getByte(i20 + i19 + i13)) {
                    i20++;
                }
                if (i20 > i10) {
                    return -1;
                }
                if (i20 >= i11) {
                    int i21 = iMax;
                    while (i21 >= 0 && byteBuf.getByte(i21 + i12) == byteBuf2.getByte(i21 + i19 + i13)) {
                        i21--;
                    }
                    if (i21 < 0) {
                        return i19 + i13;
                    }
                    i19 += iMax4;
                } else {
                    i19 += i20 - iMax;
                }
            }
        }
        return -1;
    }

    public static boolean isAccessible(ByteBuf byteBuf) {
        return byteBuf.isAccessible();
    }

    private static boolean isAscii(ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.forEachByte(i10, i11, FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int i10, int i11) {
        int i12;
        int i13;
        int i14 = i11 + i10;
        while (i10 < i14) {
            int i15 = i10 + 1;
            byte b10 = byteBuf.getByte(i10);
            if ((b10 & 128) == 0) {
                i10 = i15;
            } else if ((b10 & 224) == 192) {
                if (i15 >= i14) {
                    return false;
                }
                i10 += 2;
                if ((byteBuf.getByte(i15) & 192) != 128 || (b10 & 255) < 194) {
                    return false;
                }
            } else if ((b10 & 240) == 224) {
                if (i15 > i14 - 2) {
                    return false;
                }
                int i16 = i10 + 2;
                byte b11 = byteBuf.getByte(i15);
                i10 += 3;
                byte b12 = byteBuf.getByte(i16);
                if ((b11 & 192) != 128 || (b12 & 192) != 128 || ((i12 = b10 & c.f1123q) == 0 && (b11 & 255) < 160)) {
                    return false;
                }
                if (i12 == 13 && (b11 & 255) > 159) {
                    return false;
                }
            } else {
                if ((b10 & 248) != 240 || i15 > i14 - 3) {
                    return false;
                }
                byte b13 = byteBuf.getByte(i15);
                int i17 = i10 + 3;
                byte b14 = byteBuf.getByte(i10 + 2);
                i10 += 4;
                byte b15 = byteBuf.getByte(i17);
                if ((b13 & 192) != 128 || (b14 & 192) != 128 || (b15 & 192) != 128 || (i13 = b10 & 255) > 244 || ((i13 == 240 && (b13 & 255) < 144) || (i13 == 244 && (b13 & 255) > 143))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int lastIndexOf(AbstractByteBuf abstractByteBuf, int i10, int i11, byte b10) {
        int iCapacity = abstractByteBuf.capacity();
        int iMin = Math.min(i10, iCapacity);
        if (iMin >= 0 && iCapacity != 0) {
            abstractByteBuf.checkIndex(i11, iMin - i11);
            for (int i12 = iMin - 1; i12 >= i11; i12--) {
                if (abstractByteBuf._getByte(i12) == b10) {
                    return i12;
                }
            }
        }
        return -1;
    }

    private static int linearFirstIndexOf(AbstractByteBuf abstractByteBuf, int i10, int i11, byte b10) {
        while (i10 < i11) {
            if (abstractByteBuf._getByte(i10) == b10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0028 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0025 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0020 A[SYNTHETIC] */
    private static long maxSuf(ByteBuf byteBuf, int i10, int i11, boolean z10) {
        int i12 = -1;
        int i13 = 1;
        int i14 = 1;
        while (true) {
            int i15 = i11 + i13;
            if (i15 >= i10) {
                return (((long) i12) << 32) + ((long) i14);
            }
            byte b10 = byteBuf.getByte(i15);
            byte b11 = byteBuf.getByte(i12 + i13);
            if (z10) {
                if (b10 < b11) {
                    i14 = i15 - i12;
                    i13 = 1;
                    i11 = i15;
                } else if (b10 == b11) {
                    i13 = 1;
                    i14 = 1;
                    i12 = i11;
                    i11++;
                } else if (i13 != i14) {
                    i13++;
                } else {
                    i11 += i14;
                    i13 = 1;
                }
            } else if (b10 > b11) {
                i14 = i15 - i12;
                i13 = 1;
                i11 = i15;
            } else if (b10 == b11) {
                i13 = 1;
                i14 = 1;
                i12 = i11;
                i11++;
            } else if (i13 != i14) {
                i13++;
            } else {
                i11 += i14;
                i13 = 1;
            }
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i10) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(i10);
        try {
            byteBuf.readBytes(byteBufBuffer);
            return byteBufBuffer;
        } catch (Throwable th2) {
            byteBufBuffer.release();
            throw th2;
        }
    }

    public static int readIntBE(ByteBuf byteBuf) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.readInt() : swapInt(byteBuf.readInt());
    }

    public static int readUnsignedShortBE(ByteBuf byteBuf) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.readUnsignedShort() : swapShort((short) byteBuf.readUnsignedShort()) & g2.f10190d;
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i10) {
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, charSequence.length(), i10);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf byteBuf, CharSequence charSequence, int i10, int i11, int i12) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(i12);
                    int iWriteUtf8 = writeUtf8(abstractByteBuf, abstractByteBuf.writerIndex, i12, charSequence, i10, i11);
                    abstractByteBuf.writerIndex += iWriteUtf8;
                    return iWriteUtf8;
                }
                if (!(byteBuf instanceof WrappedByteBuf)) {
                    byte[] bytes = charSequence.subSequence(i10, i11).toString().getBytes(CharsetUtil.UTF_8);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
                byteBuf = byteBuf.unwrap();
            }
        }
    }

    private static int safeArrayWriteUtf8(byte[] bArr, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                bArr[i13] = (byte) cCharAt;
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((cCharAt >> 6) | 192);
                i13 += 2;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    bArr[i13] = (byte) ((cCharAt >> '\f') | 224);
                    int i15 = i13 + 2;
                    bArr[i13 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    i13 += 3;
                    bArr[i15] = (byte) ((cCharAt & '?') | 128);
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        bArr[i13] = 63;
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        bArr[i13] = (byte) ((codePoint >> 18) | m0.f12864d);
                        bArr[i13 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        int i16 = i13 + 3;
                        bArr[i13 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                        i13 += 4;
                        bArr[i16] = (byte) ((codePoint & 63) | 128);
                    } else {
                        int i17 = i13 + 1;
                        bArr[i13] = 63;
                        i13 += 2;
                        bArr[i17] = (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    bArr[i13] = 63;
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    private static int safeDirectWriteUtf8(ByteBuffer byteBuffer, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                byteBuffer.put(i13, (byte) cCharAt);
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                byteBuffer.put(i13, (byte) ((cCharAt >> 6) | 192));
                i13 += 2;
                byteBuffer.put(i14, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    byteBuffer.put(i13, (byte) ((cCharAt >> '\f') | 224));
                    int i15 = i13 + 2;
                    byteBuffer.put(i13 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i13 += 3;
                    byteBuffer.put(i15, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        byteBuffer.put(i13, (byte) 63);
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        byteBuffer.put(i13, (byte) ((codePoint >> 18) | m0.f12864d));
                        byteBuffer.put(i13 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i16 = i13 + 3;
                        byteBuffer.put(i13 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i13 += 4;
                        byteBuffer.put(i16, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i17 = i13 + 1;
                        byteBuffer.put(i13, (byte) 63);
                        i13 += 2;
                        byteBuffer.put(i17, Character.isHighSurrogate(cCharAt2) ? (byte) 63 : (byte) cCharAt2);
                    }
                } else {
                    byteBuffer.put(i13, (byte) 63);
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    private static int safeWriteUtf8(AbstractByteBuf abstractByteBuf, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                abstractByteBuf._setByte(i13, (byte) cCharAt);
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                abstractByteBuf._setByte(i13, (byte) ((cCharAt >> 6) | 192));
                i13 += 2;
                abstractByteBuf._setByte(i14, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    abstractByteBuf._setByte(i13, (byte) ((cCharAt >> '\f') | 224));
                    int i15 = i13 + 2;
                    abstractByteBuf._setByte(i13 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i13 += 3;
                    abstractByteBuf._setByte(i15, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        abstractByteBuf._setByte(i13, 63);
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        abstractByteBuf._setByte(i13, (byte) ((codePoint >> 18) | m0.f12864d));
                        abstractByteBuf._setByte(i13 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i16 = i13 + 3;
                        abstractByteBuf._setByte(i13 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i13 += 4;
                        abstractByteBuf._setByte(i16, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i17 = i13 + 1;
                        abstractByteBuf._setByte(i13, 63);
                        i13 += 2;
                        abstractByteBuf._setByte(i17, Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    abstractByteBuf._setByte(i13, 63);
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    public static void setLeakListener(ResourceLeakDetector.LeakListener leakListener) {
        AbstractByteBuf.leakDetector.setLeakListener(leakListener);
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.setShort(i10, i11) : byteBuf.setShort(i10, swapShort((short) i11));
    }

    public static int swapInt(int i10) {
        return Integer.reverseBytes(i10);
    }

    public static long swapLong(long j10) {
        return Long.reverseBytes(j10);
    }

    public static int swapMedium(int i10) {
        int i11 = ((i10 >>> 16) & 255) | ((i10 << 16) & 16711680) | (65280 & i10);
        return (8388608 & i11) != 0 ? i11 | ViewCompat.MEASURED_STATE_MASK : i11;
    }

    public static short swapShort(short s10) {
        return Short.reverseBytes(s10);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] threadLocalTempArray(int i10) {
        return i10 <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(i10);
    }

    private static long uintFromLE(long j10) {
        return Long.reverseBytes(j10) >>> 32;
    }

    private static int unrolledFirstIndexOf(AbstractByteBuf abstractByteBuf, int i10, int i11, byte b10) {
        if (abstractByteBuf._getByte(i10) == b10) {
            return i10;
        }
        if (i11 == 1) {
            return -1;
        }
        int i12 = i10 + 1;
        if (abstractByteBuf._getByte(i12) == b10) {
            return i12;
        }
        if (i11 == 2) {
            return -1;
        }
        int i13 = i10 + 2;
        if (abstractByteBuf._getByte(i13) == b10) {
            return i13;
        }
        if (i11 == 3) {
            return -1;
        }
        int i14 = i10 + 3;
        if (abstractByteBuf._getByte(i14) == b10) {
            return i14;
        }
        if (i11 == 4) {
            return -1;
        }
        int i15 = i10 + 4;
        if (abstractByteBuf._getByte(i15) == b10) {
            return i15;
        }
        if (i11 == 5) {
            return -1;
        }
        int i16 = i10 + 5;
        if (abstractByteBuf._getByte(i16) == b10) {
            return i16;
        }
        if (i11 == 6) {
            return -1;
        }
        int i17 = i10 + 6;
        if (abstractByteBuf._getByte(i17) == b10) {
            return i17;
        }
        return -1;
    }

    private static int unsafeWriteUtf8(byte[] bArr, long j10, int i10, CharSequence charSequence, int i11, int i12) {
        long j11;
        long j12 = j10 + ((long) i10);
        int i13 = i11;
        long j13 = j12;
        while (i13 < i12) {
            char cCharAt = charSequence.charAt(i13);
            if (cCharAt < 128) {
                j11 = 1 + j13;
                PlatformDependent.putByte(bArr, j13, (byte) cCharAt);
            } else {
                if (cCharAt < 2048) {
                    long j14 = 1 + j13;
                    PlatformDependent.putByte(bArr, j13, (byte) ((cCharAt >> 6) | 192));
                    j13 += 2;
                    PlatformDependent.putByte(bArr, j14, (byte) ((cCharAt & '?') | 128));
                } else {
                    if (!StringUtil.isSurrogate(cCharAt)) {
                        PlatformDependent.putByte(bArr, j13, (byte) ((cCharAt >> '\f') | 224));
                        long j15 = 2 + j13;
                        PlatformDependent.putByte(bArr, 1 + j13, (byte) (((cCharAt >> 6) & 63) | 128));
                        j13 += 3;
                        PlatformDependent.putByte(bArr, j15, (byte) ((cCharAt & '?') | 128));
                    } else if (Character.isHighSurrogate(cCharAt)) {
                        i13++;
                        if (i13 == i12) {
                            PlatformDependent.putByte(bArr, j13, (byte) 63);
                            j13 = 1 + j13;
                            break;
                        }
                        char cCharAt2 = charSequence.charAt(i13);
                        if (Character.isLowSurrogate(cCharAt2)) {
                            int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                            PlatformDependent.putByte(bArr, j13, (byte) ((codePoint >> 18) | m0.f12864d));
                            PlatformDependent.putByte(bArr, 1 + j13, (byte) (((codePoint >> 12) & 63) | 128));
                            long j16 = 3 + j13;
                            PlatformDependent.putByte(bArr, 2 + j13, (byte) (((codePoint >> 6) & 63) | 128));
                            j13 += 4;
                            PlatformDependent.putByte(bArr, j16, (byte) ((codePoint & 63) | 128));
                        } else {
                            long j17 = 1 + j13;
                            PlatformDependent.putByte(bArr, j13, (byte) 63);
                            j13 += 2;
                            PlatformDependent.putByte(bArr, j17, (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2));
                        }
                    } else {
                        j11 = 1 + j13;
                        PlatformDependent.putByte(bArr, j13, (byte) 63);
                    }
                }
                i13++;
            }
            j13 = j11;
            i13++;
        }
        return (int) (j13 - j12);
    }

    private static int utf8ByteCount(CharSequence charSequence, int i10, int i11) {
        if (charSequence instanceof AsciiString) {
            return i11 - i10;
        }
        int i12 = i10;
        while (i12 < i11 && charSequence.charAt(i12) < 128) {
            i12++;
        }
        int i13 = i12 - i10;
        return i12 < i11 ? i13 + utf8BytesNonAscii(charSequence, i12, i11) : i13;
    }

    public static int utf8Bytes(CharSequence charSequence) {
        return utf8ByteCount(charSequence, 0, charSequence.length());
    }

    private static int utf8BytesNonAscii(CharSequence charSequence, int i10, int i11) {
        int i12 = 0;
        while (i10 < i11) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt < 2048) {
                i12 = ((127 - cCharAt) >>> 31) + 1 + i12;
            } else if (!StringUtil.isSurrogate(cCharAt)) {
                i12 += 3;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i10++;
                if (i10 == i11) {
                    return i12 + 1;
                }
                i12 = !Character.isLowSurrogate(charSequence.charAt(i10)) ? i12 + 2 : i12 + 4;
            } else {
                i12++;
            }
            i10++;
        }
        return i12;
    }

    public static int utf8MaxBytes(int i10) {
        return i10 * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(charSequence.length());
        writeAscii(byteBufBuffer, charSequence);
        return byteBufBuffer;
    }

    private static int writeAsciiCharSequence(AbstractByteBuf abstractByteBuf, int i10, CharSequence charSequence, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            abstractByteBuf._setByte(i10, AsciiString.c2b(charSequence.charAt(i12)));
            i12++;
            i10++;
        }
        return i11;
    }

    public static void writeAsciiString(AbstractByteBuf abstractByteBuf, int i10, AsciiString asciiString, int i11, int i12) {
        int iArrayOffset = asciiString.arrayOffset() + i11;
        int i13 = i12 - i11;
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i10, i13);
                return;
            } else if (abstractByteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.memoryAddress() + ((long) i10), i13);
                return;
            }
        }
        if (abstractByteBuf.hasArray()) {
            System.arraycopy(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i10, i13);
        } else {
            abstractByteBuf.setBytes(i10, asciiString.array(), iArrayOffset, i13);
        }
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i10) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeMedium(i10) : byteBuf.writeMedium(swapMedium(i10));
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i10) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeShort(i10) : byteBuf.writeShort(swapShort((short) i10));
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(utf8MaxBytes(charSequence));
        writeUtf8(byteBufBuffer, charSequence);
        return byteBufBuffer;
    }

    public static void appendPrettyHexDump(StringBuilder sb2, ByteBuf byteBuf, int i10, int i11) {
        HexUtil.appendPrettyHexDump(sb2, byteBuf, i10, i11);
    }

    public static void copy(AsciiString asciiString, int i10, ByteBuf byteBuf, int i11, int i12) {
        if (!MathUtil.isOutOfBounds(i10, i12, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i11, asciiString.array(), asciiString.arrayOffset() + i10, i12);
            return;
        }
        StringBuilder sbA = a.a("expected: 0 <= srcIdx(", i10, ") <= srcIdx + length(", i12, ") <= srcLen(");
        sbA.append(asciiString.length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i10, int i11) {
        return StringUtil.decodeHexDump(charSequence, i10, i11);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset, int i10) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, i10);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i10, int i11) {
        return getBytes(byteBuf, i10, i11, true);
    }

    public static String hexDump(ByteBuf byteBuf, int i10, int i11) {
        return HexUtil.hexDump(byteBuf, i10, i11);
    }

    public static boolean isText(ByteBuf byteBuf, int i10, int i11, Charset charset) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        ObjectUtil.checkNotNull(charset, "charset");
        int i12 = byteBuf.readableBytes() + byteBuf.readerIndex();
        if (i10 < 0 || i11 < 0 || i10 > i12 - i11) {
            throw new IndexOutOfBoundsException(e0.a.a("index: ", i10, " length: ", i11));
        }
        if (charset.equals(CharsetUtil.UTF_8)) {
            return isUtf8(byteBuf, i10, i11);
        }
        if (charset.equals(CharsetUtil.US_ASCII)) {
            return isAscii(byteBuf, i10, i11);
        }
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        CharsetDecoder charsetDecoderDecoder = CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
        try {
            if (byteBuf.nioBufferCount() == 1) {
                charsetDecoderDecoder.decode(byteBuf.nioBuffer(i10, i11));
            } else {
                ByteBuf byteBufHeapBuffer = byteBuf.alloc().heapBuffer(i11);
                try {
                    byteBufHeapBuffer.writeBytes(byteBuf, i10, i11);
                    charsetDecoderDecoder.decode(byteBufHeapBuffer.internalNioBuffer(byteBufHeapBuffer.readerIndex(), i11));
                } finally {
                    byteBufHeapBuffer.release();
                }
            }
            return true;
        } catch (CharacterCodingException unused) {
            return false;
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i10, int i11) {
        return HexUtil.prettyHexDump(byteBuf, i10, i11);
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i10, int i11, int i12) {
        return reserveAndWriteUtf8Seq(byteBuf, checkCharSequenceBounds(charSequence, i10, i11), i10, i11, i12);
    }

    public static int utf8Bytes(CharSequence charSequence, int i10, int i11) {
        return utf8ByteCount(checkCharSequenceBounds(charSequence, i10, i11), i10, i11);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? charSequence.length() : utf8MaxBytes(charSequence.length());
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i10, int i11, boolean z10) {
        int iCapacity = byteBuf.capacity();
        if (!MathUtil.isOutOfBounds(i10, i11, iCapacity)) {
            if (byteBuf.hasArray()) {
                int iArrayOffset = byteBuf.arrayOffset() + i10;
                byte[] bArrArray = byteBuf.array();
                return (!z10 && iArrayOffset == 0 && i11 == bArrArray.length) ? bArrArray : Arrays.copyOfRange(bArrArray, iArrayOffset, i11 + iArrayOffset);
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i11);
            byteBuf.getBytes(i10, bArrAllocateUninitializedArray);
            return bArrAllocateUninitializedArray;
        }
        throw new IndexOutOfBoundsException(u.a.a(a.a("expected: 0 <= start(", i10, ") <= start + length(", i11, ") <= buf.capacity("), iCapacity, ')'));
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    int length = charSequence.length();
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(length);
                    if (charSequence instanceof AsciiString) {
                        writeAsciiString(abstractByteBuf, abstractByteBuf.writerIndex, (AsciiString) charSequence, 0, length);
                    } else {
                        writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
                    }
                    abstractByteBuf.writerIndex += length;
                    return length;
                }
                if (byteBuf instanceof WrappedByteBuf) {
                    byteBuf = byteBuf.unwrap();
                } else {
                    byte[] bytes = charSequence.toString().getBytes(CharsetUtil.US_ASCII);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
            }
        }
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, length, utf8MaxBytes(length));
    }

    public static String hexDump(byte[] bArr, int i10, int i11) {
        return HexUtil.hexDump(bArr, i10, i11);
    }

    public static void readBytes(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i10, int i11, OutputStream outputStream) throws IOException {
        if (byteBuffer.hasArray()) {
            outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
            return;
        }
        int iMin = Math.min(i11, 8192);
        byteBuffer.clear().position(i10);
        if (i11 > 1024 && byteBufAllocator.isDirectBufferPooled()) {
            ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(iMin);
            try {
                getBytes(byteBuffer, byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), iMin, outputStream, i11);
                return;
            } finally {
                byteBufHeapBuffer.release();
            }
        }
        getBytes(byteBuffer, threadLocalTempArray(iMin), 0, iMin, outputStream, i11);
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence, int i10, int i11) {
        checkCharSequenceBounds(charSequence, i10, i11);
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, i10, i11, utf8MaxBytes(i11 - i10));
    }

    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        static {
            char[] charArray = j.f8821a.toCharArray();
            int i10 = 0;
            for (int i11 = 0; i11 < 256; i11++) {
                char[] cArr = HEXDUMP_TABLE;
                int i12 = i11 << 1;
                cArr[i12] = charArray[(i11 >>> 4) & 15];
                cArr[i12 + 1] = charArray[i11 & 15];
            }
            int i13 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i13 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i13;
                StringBuilder sb2 = new StringBuilder(length * 3);
                for (int i14 = 0; i14 < length; i14++) {
                    sb2.append("   ");
                }
                HEXPADDING[i13] = sb2.toString();
                i13++;
            }
            int i15 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i15 >= strArr2.length) {
                    break;
                }
                StringBuilder sb3 = new StringBuilder(12);
                sb3.append(StringUtil.NEWLINE);
                sb3.append(Long.toHexString((((long) (i15 << 4)) & 4294967295L) | 4294967296L));
                sb3.setCharAt(sb3.length() - 9, '|');
                sb3.append('|');
                strArr2[i15] = sb3.toString();
                i15++;
            }
            int i16 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i16 >= strArr3.length) {
                    break;
                }
                strArr3[i16] = " " + StringUtil.byteToHexStringPadded(i16);
                i16++;
            }
            int i17 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i17 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i17;
                StringBuilder sb4 = new StringBuilder(length2);
                for (int i18 = 0; i18 < length2; i18++) {
                    sb4.append(' ');
                }
                BYTEPADDING[i17] = sb4.toString();
                i17++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i10 >= cArr2.length) {
                    return;
                }
                if (i10 <= 31 || i10 >= 127) {
                    cArr2[i10] = e.f11183c;
                } else {
                    cArr2[i10] = (char) i10;
                }
                i10++;
            }
        }

        private HexUtil() {
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb2, int i10, int i11) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i10 < strArr.length) {
                sb2.append(strArr[i10]);
                return;
            }
            sb2.append(StringUtil.NEWLINE);
            sb2.append(Long.toHexString((((long) i11) & 4294967295L) | 4294967296L));
            sb2.setCharAt(sb2.length() - 9, '|');
            sb2.append('|');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb2, ByteBuf byteBuf, int i10, int i11) {
            if (MathUtil.isOutOfBounds(i10, i11, byteBuf.capacity())) {
                StringBuilder sbA = a.a("expected: 0 <= offset(", i10, ") <= offset + length(", i11, ") <= buf.capacity(");
                sbA.append(byteBuf.capacity());
                sbA.append(')');
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            if (i11 == 0) {
                return;
            }
            StringBuilder sb3 = new StringBuilder("         +-------------------------------------------------+");
            String str = StringUtil.NEWLINE;
            sb3.append(str);
            sb3.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
            sb3.append(str);
            sb3.append("+--------+-------------------------------------------------+----------------+");
            sb2.append(sb3.toString());
            int i12 = i11 >>> 4;
            int i13 = i11 & 15;
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = (i14 << 4) + i10;
                appendHexDumpRowPrefix(sb2, i14, i15);
                int i16 = i15 + 16;
                for (int i17 = i15; i17 < i16; i17++) {
                    sb2.append(BYTE2HEX[byteBuf.getUnsignedByte(i17)]);
                }
                sb2.append(" |");
                while (i15 < i16) {
                    sb2.append(BYTE2CHAR[byteBuf.getUnsignedByte(i15)]);
                    i15++;
                }
                sb2.append('|');
            }
            if (i13 != 0) {
                int i18 = (i12 << 4) + i10;
                appendHexDumpRowPrefix(sb2, i12, i18);
                int i19 = i18 + i13;
                for (int i20 = i18; i20 < i19; i20++) {
                    sb2.append(BYTE2HEX[byteBuf.getUnsignedByte(i20)]);
                }
                sb2.append(HEXPADDING[i13]);
                sb2.append(" |");
                while (i18 < i19) {
                    sb2.append(BYTE2CHAR[byteBuf.getUnsignedByte(i18)]);
                    i18++;
                }
                sb2.append(BYTEPADDING[i13]);
                sb2.append('|');
            }
            sb2.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i10, int i11) {
            ObjectUtil.checkPositiveOrZero(i11, "length");
            if (i11 == 0) {
                return "";
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11 << 1];
            int i13 = 0;
            while (i10 < i12) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i10) << 1, cArr, i13, 2);
                i10++;
                i13 += 2;
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i10, int i11) {
            if (i11 == 0) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder(((i11 / 16) + ((i11 & 15) == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb2, byteBuf, i10, i11);
            return sb2.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i10, int i11) {
            ObjectUtil.checkPositiveOrZero(i11, "length");
            if (i11 == 0) {
                return "";
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11 << 1];
            int i13 = 0;
            while (i10 < i12) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i10] & 255) << 1, cArr, i13, 2);
                i10++;
                i13 += 2;
            }
            return new String(cArr);
        }
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i10, int i11, CharSequence charSequence, int i12) {
        return writeUtf8(abstractByteBuf, i10, i11, charSequence, 0, i12);
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i10, int i11, CharSequence charSequence, int i12, int i13) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i10, (AsciiString) charSequence, i12, i13);
            return i13 - i12;
        }
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                return unsafeWriteUtf8(abstractByteBuf.array(), PlatformDependent.byteArrayBaseOffset(), abstractByteBuf.arrayOffset() + i10, charSequence, i12, i13);
            }
            if (abstractByteBuf.hasMemoryAddress()) {
                return unsafeWriteUtf8(null, abstractByteBuf.memoryAddress(), i10, charSequence, i12, i13);
            }
        } else {
            if (abstractByteBuf.hasArray()) {
                return safeArrayWriteUtf8(abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i10, charSequence, i12, i13);
            }
            if (abstractByteBuf.isDirect()) {
                ByteBuffer byteBufferInternalNioBuffer = abstractByteBuf.internalNioBuffer(i10, i11);
                return safeDirectWriteUtf8(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), charSequence, i12, i13);
            }
        }
        return safeWriteUtf8(abstractByteBuf, i10, charSequence, i12, i13);
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == byteBuf2) {
            return true;
        }
        int i10 = byteBuf.readableBytes();
        if (i10 != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), i10);
    }

    public static void copy(AsciiString asciiString, int i10, ByteBuf byteBuf, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), asciiString.arrayOffset() + i10, i11);
            return;
        }
        StringBuilder sbA = a.a("expected: 0 <= srcIdx(", i10, ") <= srcIdx + length(", i11, ") <= srcLen(");
        sbA.append(asciiString.length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static int writeAscii(AbstractByteBuf abstractByteBuf, int i10, CharSequence charSequence, int i11) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i10, (AsciiString) charSequence, 0, i11);
        } else {
            writeAsciiCharSequence(abstractByteBuf, i10, charSequence, i11);
        }
        return i11;
    }

    public static int indexOf(ByteBuf byteBuf, int i10, int i11, byte b10) {
        return byteBuf.indexOf(i10, i11, b10);
    }

    private static void getBytes(ByteBuffer byteBuffer, byte[] bArr, int i10, int i11, OutputStream outputStream, int i12) throws IOException {
        do {
            int iMin = Math.min(i11, i12);
            byteBuffer.get(bArr, i10, iMin);
            outputStream.write(bArr, i10, iMin);
            i12 -= iMin;
        } while (i12 > 0);
    }
}
