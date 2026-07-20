package com.google.protobuf;

import c1.c;
import e0.a;
import fl.h;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import p5.m0;

/* JADX INFO: loaded from: classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(byte2)) {
                if ((((byte2 + 112) + (byte1 << c.F)) >> 30) == 0 && !isNotTrailingByte(byte3) && !isNotTrailingByte(byte4)) {
                    int iTrailingByteValue = ((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12) | (trailingByteValue(byte3) << 6) | trailingByteValue(byte4);
                    resultArr[resultPos] = highSurrogate(iTrailingByteValue);
                    resultArr[resultPos + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || ((byte1 == -32 && byte2 < -96) || ((byte1 == -19 && byte2 >= -96) || isNotTrailingByte(byte3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & c.f1123q) << 12) | (trailingByteValue(byte2) << 6) | trailingByteValue(byte3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < -62 || isNotTrailingByte(byte2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & c.I) << 6) | trailingByteValue(byte2));
        }

        private static char highSurrogate(int codePoint) {
            return (char) ((codePoint >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b10) {
            return b10 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b10) {
            return b10 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b10) {
            return b10 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b10) {
            return b10 < -32;
        }

        private static char lowSurrogate(int codePoint) {
            return (char) ((codePoint & 1023) + 56320);
        }

        private static int trailingByteValue(byte b10) {
            return b10 & h.f6042b;
        }
    }

    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray()) {
                return decodeUtf8(buffer.array(), buffer.arrayOffset() + index, size);
            }
            return buffer.isDirect() ? decodeUtf8Direct(buffer, index, size) : decodeUtf8Default(buffer, index, size);
        }

        public abstract String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException;

        public final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int i10 = index + size;
            char[] cArr = new char[size];
            int i11 = 0;
            while (index < i10) {
                byte b10 = buffer.get(index);
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                index++;
                DecodeUtil.handleOneByte(b10, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (index < i10) {
                int i13 = index + 1;
                byte b11 = buffer.get(index);
                if (DecodeUtil.isOneByte(b11)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i12);
                    while (i13 < i10) {
                        byte b12 = buffer.get(i13);
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b12, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    index = i13;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    index += 2;
                    DecodeUtil.handleTwoBytes(b11, buffer.get(i13), cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = index + 2;
                    index += 3;
                    DecodeUtil.handleThreeBytes(b11, buffer.get(i13), buffer.get(i15), cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = buffer.get(i13);
                    int i16 = index + 3;
                    byte b14 = buffer.get(index + 2);
                    index += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, buffer.get(i16), cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        public abstract String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(String in2, byte[] out, int offset, int length);

        public final void encodeUtf8(String in2, ByteBuffer out) {
            if (out.hasArray()) {
                int iArrayOffset = out.arrayOffset();
                Java8Compatibility.position(out, Utf8.encode(in2, out.array(), out.position() + iArrayOffset, out.remaining()) - iArrayOffset);
            } else if (out.isDirect()) {
                encodeUtf8Direct(in2, out);
            } else {
                encodeUtf8Default(in2, out);
            }
        }

        public final void encodeUtf8Default(String in2, ByteBuffer out) {
            int length = in2.length();
            int iPosition = out.position();
            int i10 = 0;
            while (i10 < length) {
                try {
                    char cCharAt = in2.charAt(i10);
                    if (cCharAt >= 128) {
                        break;
                    }
                    out.put(iPosition + i10, (byte) cCharAt);
                    i10++;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            if (i10 == length) {
                Java8Compatibility.position(out, iPosition + i10);
                return;
            }
            iPosition += i10;
            while (i10 < length) {
                char cCharAt2 = in2.charAt(i10);
                if (cCharAt2 < 128) {
                    out.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i11 = iPosition + 1;
                    try {
                        out.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        out.put(i11, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i11;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i11;
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i12 = i10 + 1;
                        if (i12 != length) {
                            try {
                                char cCharAt3 = in2.charAt(i12);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i13 = iPosition + 1;
                                    try {
                                        out.put(iPosition, (byte) ((codePoint >>> 18) | m0.f12864d));
                                        int i14 = iPosition + 2;
                                        try {
                                            out.put(i13, (byte) (((codePoint >>> 12) & 63) | 128));
                                            iPosition += 3;
                                            out.put(i14, (byte) (((codePoint >>> 6) & 63) | 128));
                                            out.put(iPosition, (byte) ((codePoint & 63) | 128));
                                            i10 = i12;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i10 = i12;
                                            iPosition = i14;
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        iPosition = i13;
                                        i10 = i12;
                                    }
                                } else {
                                    i10 = i12;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                            i10 = i12;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + in2.charAt(i10) + " at index " + (Math.max(i10, (iPosition - out.position()) + 1) + out.position()));
                        }
                        throw new UnpairedSurrogateException(i10, length);
                    }
                    int i15 = iPosition + 1;
                    out.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    out.put(i15, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    out.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i10++;
                iPosition++;
            }
            Java8Compatibility.position(out, iPosition);
        }

        public abstract void encodeUtf8Direct(String in2, ByteBuffer out);

        public final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            return partialIsValidUtf8(0, bytes, index, limit) == 0;
        }

        public final int partialIsValidUtf8(final int state, final ByteBuffer buffer, int index, final int limit) {
            if (!buffer.hasArray()) {
                return buffer.isDirect() ? partialIsValidUtf8Direct(state, buffer, index, limit) : partialIsValidUtf8Default(state, buffer, index, limit);
            }
            int iArrayOffset = buffer.arrayOffset();
            return partialIsValidUtf8(state, buffer.array(), index + iArrayOffset, iArrayOffset + limit);
        }

        public abstract int partialIsValidUtf8(int state, byte[] bytes, int index, int limit);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r7.get(r8) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r7.get(r8) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r7.get(r6) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(final int r6, final java.nio.ByteBuffer r7, int r8, final int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L92
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1e
                r6 = -62
                if (r5 < r6) goto L1d
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
                goto L1d
            L1a:
                r8 = r5
                goto L92
            L1d:
                return r1
            L1e:
                r3 = -16
                if (r5 >= r3) goto L4f
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L38
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r6 < r9) goto L35
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L35:
                r4 = r8
                r8 = r6
                r6 = r4
            L38:
                if (r6 > r2) goto L4e
                r3 = -96
                if (r5 != r0) goto L40
                if (r6 < r3) goto L4e
            L40:
                r0 = -19
                if (r5 != r0) goto L46
                if (r6 >= r3) goto L4e
            L46:
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
            L4e:
                return r1
            L4f:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L64
                int r6 = r8 + 1
                byte r0 = r7.get(r8)
                if (r6 < r9) goto L62
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L62:
                r8 = 0
                goto L6a
            L64:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L6a:
                if (r8 != 0) goto L7c
                int r8 = r6 + 1
                byte r6 = r7.get(r6)
                if (r8 < r9) goto L79
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L79:
                r4 = r8
                r8 = r6
                r6 = r4
            L7c:
                if (r0 > r2) goto L91
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r0 = r0 + r5
                int r5 = r0 >> 30
                if (r5 != 0) goto L91
                if (r8 > r2) goto L91
                int r8 = r6 + 1
                byte r5 = r7.get(r6)
                if (r5 <= r2) goto L92
            L91:
                return r1
            L92:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(final int state, final ByteBuffer buffer, int index, final int limit);

        public final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8(0, buffer, index, limit) == 0;
        }

        private static int partialIsValidUtf8(final ByteBuffer buffer, int index, final int limit) {
            int iEstimateConsecutiveAscii = index + Utf8.estimateConsecutiveAscii(buffer, index, limit);
            while (iEstimateConsecutiveAscii < limit) {
                int i10 = iEstimateConsecutiveAscii + 1;
                byte b10 = buffer.get(iEstimateConsecutiveAscii);
                if (b10 >= 0) {
                    iEstimateConsecutiveAscii = i10;
                } else if (b10 < -32) {
                    if (i10 >= limit) {
                        return b10;
                    }
                    if (b10 < -62 || buffer.get(i10) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b10 >= -16) {
                        if (i10 >= limit - 2) {
                            return Utf8.incompleteStateFor(buffer, b10, i10, limit - i10);
                        }
                        int i11 = iEstimateConsecutiveAscii + 2;
                        byte b11 = buffer.get(i10);
                        if (b11 <= -65) {
                            if ((((b11 + 112) + (b10 << c.F)) >> 30) == 0) {
                                int i12 = iEstimateConsecutiveAscii + 3;
                                if (buffer.get(i11) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (buffer.get(i12) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i10 >= limit - 1) {
                        return Utf8.incompleteStateFor(buffer, b10, i10, limit - i10);
                    }
                    int i13 = iEstimateConsecutiveAscii + 2;
                    byte b12 = buffer.get(i10);
                    if (b12 > -65 || ((b10 == -32 && b12 < -96) || ((b10 == -19 && b12 >= -96) || buffer.get(i13) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int index, int length) {
            super(a.a("Unpaired surrogate at index ", index, " of ", length));
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    public static int encode(String in2, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in2, out, offset, length);
    }

    public static void encodeUtf8(String in2, ByteBuffer out) {
        processor.encodeUtf8(in2, out);
    }

    public static int encodedLength(String string) {
        int length = string.length();
        int i10 = 0;
        while (i10 < length && string.charAt(i10) < 128) {
            i10++;
        }
        int iEncodedLengthGeneral = length;
        while (i10 < length) {
            char cCharAt = string.charAt(i10);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(string, i10);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i10++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(String string, int start) {
        int length = string.length();
        int i10 = 0;
        while (start < length) {
            char cCharAt = string.charAt(start);
            if (cCharAt < 2048) {
                i10 += (127 - cCharAt) >>> 31;
            } else {
                i10 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(string, start) < 65536) {
                        throw new UnpairedSurrogateException(start, length);
                    }
                    start++;
                }
            }
            start++;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int i10 = limit - 7;
        int i11 = index;
        while (i11 < i10 && (buffer.getLong(i11) & ASCII_MASK_LONG) == 0) {
            i11 += 8;
        }
        return i11 - index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1) {
        if (byte1 > -12) {
            return -1;
        }
        return byte1;
    }

    public static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    public static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    public static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 > -12 || byte2 > -65) {
            return -1;
        }
        return byte1 ^ (byte2 << 8);
    }

    public static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    public static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, final int maxChars) {
            int i10 = 0;
            if (maxChars < 16) {
                return 0;
            }
            int i11 = 8 - (((int) offset) & 7);
            while (i10 < i11) {
                long j10 = 1 + offset;
                if (UnsafeUtil.getByte(bytes, offset) < 0) {
                    return i10;
                }
                i10++;
                offset = j10;
            }
            while (true) {
                int i12 = i10 + 8;
                if (i12 > maxChars || (UnsafeUtil.getLong((Object) bytes, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + offset) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                offset += 8;
                i10 = i12;
            }
            while (i10 < maxChars) {
                long j11 = offset + 1;
                if (UnsafeUtil.getByte(bytes, offset) < 0) {
                    return i10;
                }
                i10++;
                offset = j11;
            }
            return maxChars;
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            if (remaining == 0) {
                return Utf8.incompleteStateFor(byte1);
            }
            if (remaining == 1) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset));
            }
            if (remaining == 2) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, offset + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bytes, index, size, charset);
            if (str.indexOf(cr.c.f3402d) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bytes, index, size + index))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long j10 = ((long) size) + jAddressOffset;
            char[] cArr = new char[size];
            int i10 = 0;
            while (jAddressOffset < j10) {
                byte b10 = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b10, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (jAddressOffset < j10) {
                long j11 = jAddressOffset + 1;
                byte b11 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b11)) {
                    int i12 = i11 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i11);
                    while (j11 < j10) {
                        byte b12 = UnsafeUtil.getByte(j11);
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        j11++;
                        DecodeUtil.handleOneByte(b12, cArr, i12);
                        i12++;
                    }
                    i11 = i12;
                    jAddressOffset = j11;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (j11 >= j10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b11, UnsafeUtil.getByte(j11), cArr, i11);
                    i11++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (j11 >= j10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j12 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b11, UnsafeUtil.getByte(j11), UnsafeUtil.getByte(j12), cArr, i11);
                    i11++;
                } else {
                    if (j11 >= j10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = UnsafeUtil.getByte(j11);
                    long j13 = 3 + jAddressOffset;
                    byte b14 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, UnsafeUtil.getByte(j13), cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(final String in2, final byte[] out, final int offset, final int length) {
            long j10;
            String str;
            String str2;
            int i10;
            long j11;
            char cCharAt;
            long j12 = offset;
            long j13 = ((long) length) + j12;
            int length2 = in2.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length2 > length || out.length - length < offset) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in2.charAt(length2 - 1) + " at index " + (offset + length));
            }
            int i11 = 0;
            while (true) {
                j10 = 1;
                if (i11 >= length2 || (cCharAt = in2.charAt(i11)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(out, j12, (byte) cCharAt);
                i11++;
                j12 = 1 + j12;
            }
            if (i11 == length2) {
                return (int) j12;
            }
            while (i11 < length2) {
                char cCharAt2 = in2.charAt(i11);
                if (cCharAt2 >= 128 || j12 >= j13) {
                    if (cCharAt2 >= 2048 || j12 > j13 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j12 > j13 - 3) {
                            if (j12 > j13 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i11 + 1) == length2 || !Character.isSurrogatePair(cCharAt2, in2.charAt(i10)))) {
                                    throw new UnpairedSurrogateException(i11, length2);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j12);
                            }
                            int i12 = i11 + 1;
                            if (i12 != length2) {
                                char cCharAt3 = in2.charAt(i12);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j11 = 1;
                                    UnsafeUtil.putByte(out, j12, (byte) ((codePoint >>> 18) | m0.f12864d));
                                    UnsafeUtil.putByte(out, j12 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j14 = j12 + 3;
                                    UnsafeUtil.putByte(out, j12 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j12 += 4;
                                    UnsafeUtil.putByte(out, j14, (byte) ((codePoint & 63) | 128));
                                    i11 = i12;
                                } else {
                                    i11 = i12;
                                }
                            }
                            throw new UnpairedSurrogateException(i11 - 1, length2);
                        }
                        UnsafeUtil.putByte(out, j12, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j15 = j12 + 2;
                        UnsafeUtil.putByte(out, j12 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j12 += 3;
                        UnsafeUtil.putByte(out, j15, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j16 = j12 + j10;
                        UnsafeUtil.putByte(out, j12, (byte) ((cCharAt2 >>> 6) | 960));
                        j12 += 2;
                        UnsafeUtil.putByte(out, j16, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j11 = 1;
                } else {
                    UnsafeUtil.putByte(out, j12, (byte) cCharAt2);
                    str = str3;
                    j11 = j10;
                    j12 += j10;
                    str2 = str4;
                }
                i11++;
                str3 = str;
                str4 = str2;
                j10 = j11;
                j13 = j13;
            }
            return (int) j12;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String in2, ByteBuffer out) {
            long j10;
            char c10;
            long j11;
            int i10;
            int i11;
            char c11;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(out);
            long jPosition = ((long) out.position()) + jAddressOffset;
            long jLimit = ((long) out.limit()) + jAddressOffset;
            int length = in2.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in2.charAt(length - 1) + " at index " + out.limit());
            }
            int i12 = 0;
            while (true) {
                j10 = 1;
                c10 = 128;
                if (i12 >= length || (cCharAt = in2.charAt(i12)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i12++;
                jPosition = 1 + jPosition;
            }
            if (i12 == length) {
                Java8Compatibility.position(out, (int) (jPosition - jAddressOffset));
                return;
            }
            while (i12 < length) {
                char cCharAt2 = in2.charAt(i12);
                if (cCharAt2 >= c10 || jPosition >= jLimit) {
                    if (cCharAt2 >= 2048 || jPosition > jLimit - 2) {
                        j11 = jAddressOffset;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            if (jPosition > jLimit - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i12 + 1) == length || !Character.isSurrogatePair(cCharAt2, in2.charAt(i10)))) {
                                    throw new UnpairedSurrogateException(i12, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            i11 = i12 + 1;
                            if (i11 != length) {
                                char cCharAt3 = in2.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | m0.f12864d));
                                    c11 = 128;
                                    UnsafeUtil.putByte(jPosition + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j12 = jPosition + 3;
                                    UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    UnsafeUtil.putByte(j12, (byte) ((codePoint & 63) | 128));
                                } else {
                                    i12 = i11;
                                }
                            }
                            throw new UnpairedSurrogateException(i12 - 1, length);
                        }
                        long j13 = jPosition + j10;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j14 = jPosition + 2;
                        UnsafeUtil.putByte(j13, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        UnsafeUtil.putByte(j14, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        j11 = jAddressOffset;
                        long j15 = jPosition + j10;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.putByte(j15, (byte) ((cCharAt2 & '?') | 128));
                    }
                    i11 = i12;
                    c11 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j11 = jAddressOffset;
                    i11 = i12;
                    c11 = c10;
                    jPosition += j10;
                }
                c10 = c11;
                jAddressOffset = j11;
                j10 = 1;
                i12 = i11 + 1;
            }
            Java8Compatibility.position(out, (int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r10, byte[] r11, final int r12, final int r13) {
            /*
                r9 = this;
                r9 = r12 | r13
                int r0 = r11.length
                int r0 = r0 - r13
                r9 = r9 | r0
                if (r9 < 0) goto La8
                long r0 = (long) r12
                long r12 = (long) r13
                if (r10 == 0) goto La1
                int r9 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
                if (r9 < 0) goto L10
                return r10
            L10:
                byte r9 = (byte) r10
                r2 = -32
                r3 = -1
                r4 = -65
                r5 = 1
                if (r9 >= r2) goto L2a
                r10 = -62
                if (r9 < r10) goto L29
                long r5 = r5 + r0
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                if (r9 <= r4) goto L26
                goto L29
            L26:
                r0 = r5
                goto La1
            L29:
                return r3
            L2a:
                r7 = -16
                if (r9 >= r7) goto L5e
                int r10 = r10 >> 8
                int r10 = ~r10
                byte r10 = (byte) r10
                if (r10 != 0) goto L44
                long r7 = r0 + r5
                byte r10 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r0 < 0) goto L43
                int r9 = com.google.protobuf.Utf8.access$000(r9, r10)
                return r9
            L43:
                r0 = r7
            L44:
                if (r10 > r4) goto L5d
                r7 = -96
                if (r9 != r2) goto L4c
                if (r10 < r7) goto L5d
            L4c:
                r2 = -19
                if (r9 != r2) goto L52
                if (r10 >= r7) goto L5d
            L52:
                long r9 = r0 + r5
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                if (r0 <= r4) goto L5b
                goto L5d
            L5b:
                r0 = r9
                goto La1
            L5d:
                return r3
            L5e:
                int r2 = r10 >> 8
                int r2 = ~r2
                byte r2 = (byte) r2
                if (r2 != 0) goto L76
                long r7 = r0 + r5
                byte r2 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                int r10 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r10 < 0) goto L73
                int r9 = com.google.protobuf.Utf8.access$000(r9, r2)
                return r9
            L73:
                r10 = 0
                r0 = r7
                goto L79
            L76:
                int r10 = r10 >> 16
                byte r10 = (byte) r10
            L79:
                if (r10 != 0) goto L8b
                long r7 = r0 + r5
                byte r10 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r9 = com.google.protobuf.Utf8.access$100(r9, r2, r10)
                return r9
            L8a:
                r0 = r7
            L8b:
                if (r2 > r4) goto La0
                int r9 = r9 << 28
                int r2 = r2 + 112
                int r2 = r2 + r9
                int r9 = r2 >> 30
                if (r9 != 0) goto La0
                if (r10 > r4) goto La0
                long r9 = r0 + r5
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r11, r0)
                if (r0 <= r4) goto L5b
            La0:
                return r3
            La1:
                long r12 = r12 - r0
                int r9 = (int) r12
                int r9 = partialIsValidUtf8(r11, r0, r9)
                return r9
            La8:
                java.lang.ArrayIndexOutOfBoundsException r9 = new java.lang.ArrayIndexOutOfBoundsException
                int r10 = r11.length
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r12 = java.lang.Integer.valueOf(r13)
                java.lang.Object[] r10 = new java.lang.Object[]{r10, r11, r12}
                java.lang.String r11 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r10 = java.lang.String.format(r11, r10)
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(final int r9, java.nio.ByteBuffer r10, final int r11, final int r12) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long address, final int maxChars) {
            if (maxChars < 16) {
                return 0;
            }
            int i10 = (int) ((-address) & 7);
            int i11 = i10;
            while (i11 > 0) {
                long j10 = 1 + address;
                if (UnsafeUtil.getByte(address) < 0) {
                    return i10 - i11;
                }
                i11--;
                address = j10;
            }
            int i12 = maxChars - i10;
            while (i12 >= 8 && (UnsafeUtil.getLong(address) & Utf8.ASCII_MASK_LONG) == 0) {
                address += 8;
                i12 -= 8;
            }
            return maxChars - i12;
        }

        private static int unsafeIncompleteStateFor(long address, final int byte1, int remaining) {
            if (remaining == 0) {
                return Utf8.incompleteStateFor(byte1);
            }
            if (remaining == 1) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address));
            }
            if (remaining == 2) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(address + 1));
            }
            throw new AssertionError();
        }

        private static int partialIsValidUtf8(final byte[] bytes, long offset, int remaining) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bytes, offset, remaining);
            int i10 = remaining - iUnsafeEstimateConsecutiveAscii;
            long j10 = offset + ((long) iUnsafeEstimateConsecutiveAscii);
            while (true) {
                byte b10 = 0;
                while (i10 > 0) {
                    long j11 = j10 + 1;
                    b10 = UnsafeUtil.getByte(bytes, j10);
                    if (b10 < 0) {
                        j10 = j11;
                        break;
                    }
                    i10--;
                    j10 = j11;
                }
                if (i10 == 0) {
                    return 0;
                }
                int i11 = i10 - 1;
                if (b10 < -32) {
                    if (i11 == 0) {
                        return b10;
                    }
                    i10 -= 2;
                    if (b10 >= -62) {
                        long j12 = 1 + j10;
                        if (UnsafeUtil.getByte(bytes, j10) <= -65) {
                            j10 = j12;
                        }
                    }
                    return -1;
                }
                if (b10 < -16) {
                    if (i11 < 2) {
                        return unsafeIncompleteStateFor(bytes, b10, j10, i11);
                    }
                    i10 -= 3;
                    long j13 = 1 + j10;
                    byte b11 = UnsafeUtil.getByte(bytes, j10);
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        j10 += 2;
                        if (UnsafeUtil.getByte(bytes, j13) > -65) {
                        }
                    }
                    return -1;
                }
                if (i11 < 3) {
                    return unsafeIncompleteStateFor(bytes, b10, j10, i11);
                }
                i10 -= 4;
                long j14 = 1 + j10;
                byte b12 = UnsafeUtil.getByte(bytes, j10);
                if (b12 <= -65) {
                    if ((((b12 + 112) + (b10 << c.F)) >> 30) == 0) {
                        long j15 = 2 + j10;
                        if (UnsafeUtil.getByte(bytes, j14) <= -65) {
                            j10 += 3;
                            if (UnsafeUtil.getByte(bytes, j15) > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
        }

        private static int partialIsValidUtf8(long address, int remaining) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(address, remaining);
            long j10 = address + ((long) iUnsafeEstimateConsecutiveAscii);
            int i10 = remaining - iUnsafeEstimateConsecutiveAscii;
            while (true) {
                byte b10 = 0;
                while (i10 > 0) {
                    long j11 = j10 + 1;
                    b10 = UnsafeUtil.getByte(j10);
                    if (b10 < 0) {
                        j10 = j11;
                        break;
                    }
                    i10--;
                    j10 = j11;
                }
                if (i10 == 0) {
                    return 0;
                }
                int i11 = i10 - 1;
                if (b10 < -32) {
                    if (i11 == 0) {
                        return b10;
                    }
                    i10 -= 2;
                    if (b10 >= -62) {
                        long j12 = 1 + j10;
                        if (UnsafeUtil.getByte(j10) <= -65) {
                            j10 = j12;
                        }
                    }
                    return -1;
                }
                if (b10 < -16) {
                    if (i11 < 2) {
                        return unsafeIncompleteStateFor(j10, b10, i11);
                    }
                    i10 -= 3;
                    long j13 = 1 + j10;
                    byte b11 = UnsafeUtil.getByte(j10);
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        j10 += 2;
                        if (UnsafeUtil.getByte(j13) > -65) {
                        }
                    }
                    return -1;
                }
                if (i11 < 3) {
                    return unsafeIncompleteStateFor(j10, b10, i11);
                }
                i10 -= 4;
                long j14 = 1 + j10;
                byte b12 = UnsafeUtil.getByte(j10);
                if (b12 <= -65) {
                    if ((((b12 + 112) + (b10 << c.F)) >> 30) == 0) {
                        long j15 = 2 + j10;
                        if (UnsafeUtil.getByte(j14) <= -65) {
                            j10 += 3;
                            if (UnsafeUtil.getByte(j15) > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 > -12 || byte2 > -65 || byte3 > -65) {
            return -1;
        }
        return (byte1 ^ (byte2 << 8)) ^ (byte3 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bytes, int index, int limit) {
        byte b10 = bytes[index - 1];
        int i10 = limit - index;
        if (i10 == 0) {
            return incompleteStateFor(b10);
        }
        if (i10 == 1) {
            return incompleteStateFor(b10, bytes[index]);
        }
        if (i10 == 2) {
            return incompleteStateFor(b10, bytes[index], bytes[index + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(final ByteBuffer buffer, final int byte1, final int index, final int remaining) {
        if (remaining == 0) {
            return incompleteStateFor(byte1);
        }
        if (remaining == 1) {
            return incompleteStateFor(byte1, buffer.get(index));
        }
        if (remaining == 2) {
            return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
        }
        throw new AssertionError();
    }

    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
            while (index < limit) {
                int i10 = index + 1;
                byte b10 = bytes[index];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i10 >= limit) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            index += 2;
                            if (bytes[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 < -16) {
                        if (i10 >= limit - 1) {
                            return Utf8.incompleteStateFor(bytes, i10, limit);
                        }
                        int i11 = index + 2;
                        byte b11 = bytes[i10];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            index += 3;
                            if (bytes[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i10 >= limit - 2) {
                        return Utf8.incompleteStateFor(bytes, i10, limit);
                    }
                    int i12 = index + 2;
                    byte b12 = bytes[i10];
                    if (b12 <= -65) {
                        if ((((b12 + 112) + (b10 << c.F)) >> 30) == 0) {
                            int i13 = index + 3;
                            if (bytes[i12] <= -65) {
                                index += 4;
                                if (bytes[i13] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                index = i10;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((bytes.length - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int i10 = index + size;
            char[] cArr = new char[size];
            int i11 = 0;
            while (index < i10) {
                byte b10 = bytes[index];
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                index++;
                DecodeUtil.handleOneByte(b10, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (index < i10) {
                int i13 = index + 1;
                byte b11 = bytes[index];
                if (DecodeUtil.isOneByte(b11)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i12);
                    while (i13 < i10) {
                        byte b12 = bytes[i13];
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b12, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    index = i13;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    index += 2;
                    DecodeUtil.handleTwoBytes(b11, bytes[i13], cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = index + 2;
                    index += 3;
                    DecodeUtil.handleThreeBytes(b11, bytes[i13], bytes[i15], cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = bytes[i13];
                    int i16 = index + 3;
                    byte b14 = bytes[index + 2];
                    index += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, bytes[i16], cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(String in2, byte[] out, int offset, int length) {
            int i10;
            int i11;
            char cCharAt;
            int length2 = in2.length();
            int i12 = length + offset;
            int i13 = 0;
            while (i13 < length2 && (i11 = i13 + offset) < i12 && (cCharAt = in2.charAt(i13)) < 128) {
                out[i11] = (byte) cCharAt;
                i13++;
            }
            if (i13 == length2) {
                return offset + length2;
            }
            int i14 = offset + i13;
            while (i13 < length2) {
                char cCharAt2 = in2.charAt(i13);
                if (cCharAt2 < 128 && i14 < i12) {
                    out[i14] = (byte) cCharAt2;
                    i14++;
                } else if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                    int i15 = i14 + 1;
                    out[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                    i14 += 2;
                    out[i15] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                        if (i14 > i12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == in2.length() || !Character.isSurrogatePair(cCharAt2, in2.charAt(i10)))) {
                                throw new UnpairedSurrogateException(i13, length2);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                        }
                        int i16 = i13 + 1;
                        if (i16 != in2.length()) {
                            char cCharAt3 = in2.charAt(i16);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                out[i14] = (byte) ((codePoint >>> 18) | m0.f12864d);
                                out[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i17 = i14 + 3;
                                out[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i14 += 4;
                                out[i17] = (byte) ((codePoint & 63) | 128);
                                i13 = i16;
                            } else {
                                i13 = i16;
                            }
                        }
                        throw new UnpairedSurrogateException(i13 - 1, length2);
                    }
                    out[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i18 = i14 + 2;
                    out[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i14 += 3;
                    out[i18] = (byte) ((cCharAt2 & '?') | 128);
                }
                i13++;
            }
            return i14;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String in2, ByteBuffer out) {
            encodeUtf8Default(in2, out);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r7[r8] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r7[r8] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r7[r6] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L86
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1c
                r6 = -62
                if (r5 < r6) goto L1b
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
                goto L1b
            L18:
                r8 = r5
                goto L86
            L1b:
                return r1
            L1c:
                r3 = -16
                if (r5 >= r3) goto L49
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L34
                int r6 = r8 + 1
                r8 = r7[r8]
                if (r6 < r9) goto L31
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L31:
                r4 = r8
                r8 = r6
                r6 = r4
            L34:
                if (r6 > r2) goto L48
                r3 = -96
                if (r5 != r0) goto L3c
                if (r6 < r3) goto L48
            L3c:
                r0 = -19
                if (r5 != r0) goto L42
                if (r6 >= r3) goto L48
            L42:
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
            L48:
                return r1
            L49:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L5c
                int r6 = r8 + 1
                r0 = r7[r8]
                if (r6 < r9) goto L5a
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L5a:
                r8 = 0
                goto L62
            L5c:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L62:
                if (r8 != 0) goto L72
                int r8 = r6 + 1
                r6 = r7[r6]
                if (r8 < r9) goto L6f
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L6f:
                r4 = r8
                r8 = r6
                r6 = r4
            L72:
                if (r0 > r2) goto L85
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r0 = r0 + r5
                int r5 = r0 >> 30
                if (r5 != 0) goto L85
                if (r8 > r2) goto L85
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L86
            L85:
                return r1
            L86:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
            while (index < limit && bytes[index] >= 0) {
                index++;
            }
            if (index >= limit) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }
    }
}
