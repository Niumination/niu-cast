package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
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
        public static void handleFourBytes(byte b9, byte b10, byte b11, byte b12, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b10)) {
                if ((((b10 + 112) + (b9 << 28)) >> 30) == 0 && !isNotTrailingByte(b11) && !isNotTrailingByte(b12)) {
                    int iTrailingByteValue = ((b9 & 7) << 18) | (trailingByteValue(b10) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12);
                    cArr[i8] = highSurrogate(iTrailingByteValue);
                    cArr[i8 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b9, char[] cArr, int i8) {
            cArr[i8] = (char) b9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b9, byte b10, byte b11, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b10) || ((b9 == -32 && b10 < -96) || ((b9 == -19 && b10 >= -96) || isNotTrailingByte(b11)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i8] = (char) (((b9 & 15) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b9, byte b10, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (b9 < -62 || isNotTrailingByte(b10)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i8] = (char) (((b9 & 31) << 6) | trailingByteValue(b10));
        }

        private static char highSurrogate(int i8) {
            return (char) ((i8 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b9) {
            return b9 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b9) {
            return b9 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b9) {
            return b9 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b9) {
            return b9 < -32;
        }

        private static char lowSurrogate(int i8) {
            return (char) ((i8 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b9) {
            return b9 & 63;
        }
    }

    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i8, i9);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i8, i9) : decodeUtf8Default(byteBuffer, i8, i9);
        }

        public abstract String decodeUtf8(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException;

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            int i10 = i8 + i9;
            char[] cArr = new char[i9];
            int i11 = 0;
            while (i8 < i10) {
                byte b9 = byteBuffer.get(i8);
                if (!DecodeUtil.isOneByte(b9)) {
                    break;
                }
                i8++;
                DecodeUtil.handleOneByte(b9, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i8 < i10) {
                int i13 = i8 + 1;
                byte b10 = byteBuffer.get(i8);
                if (DecodeUtil.isOneByte(b10)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    while (i13 < i10) {
                        byte b11 = byteBuffer.get(i13);
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i8 = i13;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i8 += 2;
                    DecodeUtil.handleTwoBytes(b10, byteBuffer.get(i13), cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = i8 + 2;
                    i8 += 3;
                    DecodeUtil.handleThreeBytes(b10, byteBuffer.get(i13), byteBuffer.get(i15), cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = byteBuffer.get(i13);
                    int i16 = i8 + 3;
                    byte b13 = byteBuffer.get(i8 + 2);
                    i8 += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, byteBuffer.get(i16), cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i8, int i9);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.position(byteBuffer, Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i8 = 0;
            while (i8 < length) {
                try {
                    char cCharAt = charSequence.charAt(i8);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i8, (byte) cCharAt);
                    i8++;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            if (i8 == length) {
                Java8Compatibility.position(byteBuffer, iPosition + i8);
                return;
            }
            iPosition += i8;
            while (i8 < length) {
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i9 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i9, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i9;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i9;
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i10 = i8 + 1;
                        if (i10 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i10);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i11 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        int i12 = iPosition + 2;
                                        try {
                                            byteBuffer.put(i11, (byte) (((codePoint >>> 12) & 63) | 128));
                                            iPosition += 3;
                                            byteBuffer.put(i12, (byte) (((codePoint >>> 6) & 63) | 128));
                                            byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                            i8 = i10;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i8 = i10;
                                            iPosition = i12;
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        iPosition = i11;
                                        i8 = i10;
                                    }
                                } else {
                                    i8 = i10;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                            i8 = i10;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i8) + " at index " + (Math.max(i8, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                        }
                        throw new UnpairedSurrogateException(i8, length);
                    }
                    int i13 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    byteBuffer.put(i13, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i8++;
                iPosition++;
            }
            Java8Compatibility.position(byteBuffer, iPosition);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i8, int i9) {
            return partialIsValidUtf8(0, bArr, i8, i9) == 0;
        }

        public final int partialIsValidUtf8(int i8, ByteBuffer byteBuffer, int i9, int i10) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i8, byteBuffer, i9, i10) : partialIsValidUtf8Default(i8, byteBuffer, i9, i10);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i8, byteBuffer.array(), i9 + iArrayOffset, iArrayOffset + i10);
        }

        public abstract int partialIsValidUtf8(int i8, byte[] bArr, int i9, int i10);

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
        public final int partialIsValidUtf8Default(int r6, java.nio.ByteBuffer r7, int r8, int r9) {
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

        public abstract int partialIsValidUtf8Direct(int i8, ByteBuffer byteBuffer, int i9, int i10);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i8, int i9) {
            return partialIsValidUtf8(0, byteBuffer, i8, i9) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i8, int i9) {
            int iEstimateConsecutiveAscii = i8 + Utf8.estimateConsecutiveAscii(byteBuffer, i8, i9);
            while (iEstimateConsecutiveAscii < i9) {
                int i10 = iEstimateConsecutiveAscii + 1;
                byte b9 = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b9 >= 0) {
                    iEstimateConsecutiveAscii = i10;
                } else if (b9 < -32) {
                    if (i10 >= i9) {
                        return b9;
                    }
                    if (b9 < -62 || byteBuffer.get(i10) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b9 >= -16) {
                        if (i10 >= i9 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b9, i10, i9 - i10);
                        }
                        int i11 = iEstimateConsecutiveAscii + 2;
                        byte b10 = byteBuffer.get(i10);
                        if (b10 <= -65) {
                            if ((((b10 + 112) + (b9 << 28)) >> 30) == 0) {
                                int i12 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i11) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i12) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i9 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b9, i10, i9 - i10);
                    }
                    int i13 = iEstimateConsecutiveAscii + 2;
                    byte b11 = byteBuffer.get(i10);
                    if (b11 > -65 || ((b9 == -32 && b11 < -96) || ((b9 == -19 && b11 >= -96) || byteBuffer.get(i13) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i8, int i9) {
            super(d.f(i8, i9, "Unpaired surrogate at index ", " of "));
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i8, i9);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i8, int i9) {
        return processor.encodeUtf8(charSequence, bArr, i8, i9);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i8 = 0;
        while (i8 < length && charSequence.charAt(i8) < 128) {
            i8++;
        }
        int iEncodedLengthGeneral = length;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i8);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i8++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i8) {
        int length = charSequence.length();
        int i9 = 0;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt < 2048) {
                i9 += (127 - cCharAt) >>> 31;
            } else {
                i9 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i8) < 65536) {
                        throw new UnpairedSurrogateException(i8, length);
                    }
                    i8++;
                }
            }
            i8++;
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i8, int i9) {
        int i10 = i9 - 7;
        int i11 = i8;
        while (i11 < i10 && (byteBuffer.getLong(i11) & (-9187201950435737472L)) == 0) {
            i11 += 8;
        }
        return i11 - i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i8) {
        if (i8 > -12) {
            return -1;
        }
        return i8;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i8, byte[] bArr, int i9, int i10) {
        return processor.partialIsValidUtf8(i8, bArr, i9, i10);
    }

    public static String decodeUtf8(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i8, int i9) {
        if (i8 > -12 || i9 > -65) {
            return -1;
        }
        return i8 ^ (i9 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i8, int i9) {
        return processor.isValidUtf8(bArr, i8, i9);
    }

    public static int partialIsValidUtf8(int i8, ByteBuffer byteBuffer, int i9, int i10) {
        return processor.partialIsValidUtf8(i8, byteBuffer, i9, i10);
    }

    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j8, int i8) {
            int i9 = 0;
            if (i8 < 16) {
                return 0;
            }
            int i10 = 8 - (((int) j8) & 7);
            while (i9 < i10) {
                long j10 = 1 + j8;
                if (UnsafeUtil.getByte(bArr, j8) < 0) {
                    return i9;
                }
                i9++;
                j8 = j10;
            }
            while (true) {
                int i11 = i9 + 8;
                if (i11 > i8 || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j8) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j8 += 8;
                i9 = i11;
            }
            while (i9 < i8) {
                long j11 = j8 + 1;
                if (UnsafeUtil.getByte(bArr, j8) < 0) {
                    return i9;
                }
                i9++;
                j8 = j11;
            }
            return i8;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i8, long j8, int i9) {
            if (i9 == 0) {
                return Utf8.incompleteStateFor(i8);
            }
            if (i9 == 1) {
                return Utf8.incompleteStateFor(i8, UnsafeUtil.getByte(bArr, j8));
            }
            if (i9 == 2) {
                return Utf8.incompleteStateFor(i8, UnsafeUtil.getByte(bArr, j8), UnsafeUtil.getByte(bArr, j8 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i8, i9, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i8, i9 + i8))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i8);
            long j8 = ((long) i9) + jAddressOffset;
            char[] cArr = new char[i9];
            int i10 = 0;
            while (jAddressOffset < j8) {
                byte b9 = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b9)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b9, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (jAddressOffset < j8) {
                long j10 = jAddressOffset + 1;
                byte b10 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b10)) {
                    int i12 = i11 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i11);
                    while (j10 < j8) {
                        byte b11 = UnsafeUtil.getByte(j10);
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        j10++;
                        DecodeUtil.handleOneByte(b11, cArr, i12);
                        i12++;
                    }
                    i11 = i12;
                    jAddressOffset = j10;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (j10 >= j8) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b10, UnsafeUtil.getByte(j10), cArr, i11);
                    i11++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (j10 >= j8 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j11 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b10, UnsafeUtil.getByte(j10), UnsafeUtil.getByte(j11), cArr, i11);
                    i11++;
                } else {
                    if (j10 >= j8 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = UnsafeUtil.getByte(j10);
                    long j12 = 3 + jAddressOffset;
                    byte b13 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, UnsafeUtil.getByte(j12), cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i8, int i9) {
            long j8;
            String str;
            String str2;
            int i10;
            long j10;
            char cCharAt;
            long j11 = i8;
            long j12 = ((long) i9) + j11;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i9 || bArr.length - i9 < i8) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i8 + i9));
            }
            int i11 = 0;
            while (true) {
                j8 = 1;
                if (i11 >= length || (cCharAt = charSequence.charAt(i11)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j11, (byte) cCharAt);
                i11++;
                j11 = 1 + j11;
            }
            if (i11 == length) {
                return (int) j11;
            }
            while (i11 < length) {
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt2 >= 128 || j11 >= j12) {
                    if (cCharAt2 >= 2048 || j11 > j12 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j11 > j12 - 3) {
                            if (j11 > j12 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i11 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                                    throw new UnpairedSurrogateException(i11, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j11);
                            }
                            int i12 = i11 + 1;
                            if (i12 != length) {
                                char cCharAt3 = charSequence.charAt(i12);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j10 = 1;
                                    UnsafeUtil.putByte(bArr, j11, (byte) ((codePoint >>> 18) | 240));
                                    UnsafeUtil.putByte(bArr, j11 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j13 = j11 + 3;
                                    UnsafeUtil.putByte(bArr, j11 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j11 += 4;
                                    UnsafeUtil.putByte(bArr, j13, (byte) ((codePoint & 63) | 128));
                                    i11 = i12;
                                } else {
                                    i11 = i12;
                                }
                            }
                            throw new UnpairedSurrogateException(i11 - 1, length);
                        }
                        UnsafeUtil.putByte(bArr, j11, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j14 = j11 + 2;
                        UnsafeUtil.putByte(bArr, j11 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j11 += 3;
                        UnsafeUtil.putByte(bArr, j14, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j15 = j11 + j8;
                        UnsafeUtil.putByte(bArr, j11, (byte) ((cCharAt2 >>> 6) | 960));
                        j11 += 2;
                        UnsafeUtil.putByte(bArr, j15, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j10 = 1;
                } else {
                    UnsafeUtil.putByte(bArr, j11, (byte) cCharAt2);
                    str = str3;
                    j10 = j8;
                    j11 += j8;
                    str2 = str4;
                }
                i11++;
                str3 = str;
                str4 = str2;
                j8 = j10;
                j12 = j12;
            }
            return (int) j11;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j8;
            char c9;
            long j10;
            int i8;
            int i9;
            char c10;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i10 = 0;
            while (true) {
                j8 = 1;
                c9 = 128;
                if (i10 >= length || (cCharAt = charSequence.charAt(i10)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i10++;
                jPosition = 1 + jPosition;
            }
            if (i10 == length) {
                Java8Compatibility.position(byteBuffer, (int) (jPosition - jAddressOffset));
                return;
            }
            while (i10 < length) {
                char cCharAt2 = charSequence.charAt(i10);
                if (cCharAt2 >= c9 || jPosition >= jLimit) {
                    if (cCharAt2 >= 2048 || jPosition > jLimit - 2) {
                        j10 = jAddressOffset;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            if (jPosition > jLimit - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i8 = i10 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i8)))) {
                                    throw new UnpairedSurrogateException(i10, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            i9 = i10 + 1;
                            if (i9 != length) {
                                char cCharAt3 = charSequence.charAt(i9);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c10 = 128;
                                    UnsafeUtil.putByte(jPosition + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j11 = jPosition + 3;
                                    UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    UnsafeUtil.putByte(j11, (byte) ((codePoint & 63) | 128));
                                } else {
                                    i10 = i9;
                                }
                            }
                            throw new UnpairedSurrogateException(i10 - 1, length);
                        }
                        long j12 = jPosition + j8;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j13 = jPosition + 2;
                        UnsafeUtil.putByte(j12, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        UnsafeUtil.putByte(j13, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        j10 = jAddressOffset;
                        long j14 = jPosition + j8;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.putByte(j14, (byte) ((cCharAt2 & '?') | 128));
                    }
                    i9 = i10;
                    c10 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j10 = jAddressOffset;
                    i9 = i10;
                    c10 = c9;
                    jPosition += j8;
                }
                c9 = c10;
                jAddressOffset = j10;
                j8 = 1;
                i10 = i9 + 1;
            }
            Java8Compatibility.position(byteBuffer, (int) (jPosition - jAddressOffset));
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
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
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
        public int partialIsValidUtf8Direct(int r9, java.nio.ByteBuffer r10, int r11, int r12) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j8, int i8) {
            if (i8 < 16) {
                return 0;
            }
            int i9 = (int) ((-j8) & 7);
            int i10 = i9;
            while (i10 > 0) {
                long j10 = 1 + j8;
                if (UnsafeUtil.getByte(j8) < 0) {
                    return i9 - i10;
                }
                i10--;
                j8 = j10;
            }
            int i11 = i8 - i9;
            while (i11 >= 8 && (UnsafeUtil.getLong(j8) & (-9187201950435737472L)) == 0) {
                j8 += 8;
                i11 -= 8;
            }
            return i8 - i11;
        }

        private static int unsafeIncompleteStateFor(long j8, int i8, int i9) {
            if (i9 == 0) {
                return Utf8.incompleteStateFor(i8);
            }
            if (i9 == 1) {
                return Utf8.incompleteStateFor(i8, UnsafeUtil.getByte(j8));
            }
            if (i9 == 2) {
                return Utf8.incompleteStateFor(i8, UnsafeUtil.getByte(j8), UnsafeUtil.getByte(j8 + 1));
            }
            throw new AssertionError();
        }

        private static int partialIsValidUtf8(byte[] bArr, long j8, int i8) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j8, i8);
            int i9 = i8 - iUnsafeEstimateConsecutiveAscii;
            long j10 = j8 + ((long) iUnsafeEstimateConsecutiveAscii);
            while (true) {
                byte b9 = 0;
                while (i9 > 0) {
                    long j11 = j10 + 1;
                    b9 = UnsafeUtil.getByte(bArr, j10);
                    if (b9 < 0) {
                        j10 = j11;
                        break;
                    }
                    i9--;
                    j10 = j11;
                }
                if (i9 == 0) {
                    return 0;
                }
                int i10 = i9 - 1;
                if (b9 < -32) {
                    if (i10 == 0) {
                        return b9;
                    }
                    i9 -= 2;
                    if (b9 >= -62) {
                        long j12 = 1 + j10;
                        if (UnsafeUtil.getByte(bArr, j10) <= -65) {
                            j10 = j12;
                        }
                    }
                    return -1;
                }
                if (b9 < -16) {
                    if (i10 < 2) {
                        return unsafeIncompleteStateFor(bArr, b9, j10, i10);
                    }
                    i9 -= 3;
                    long j13 = 1 + j10;
                    byte b10 = UnsafeUtil.getByte(bArr, j10);
                    if (b10 <= -65 && ((b9 != -32 || b10 >= -96) && (b9 != -19 || b10 < -96))) {
                        j10 += 2;
                        if (UnsafeUtil.getByte(bArr, j13) > -65) {
                        }
                    }
                    return -1;
                }
                if (i10 < 3) {
                    return unsafeIncompleteStateFor(bArr, b9, j10, i10);
                }
                i9 -= 4;
                long j14 = 1 + j10;
                byte b11 = UnsafeUtil.getByte(bArr, j10);
                if (b11 <= -65) {
                    if ((((b11 + 112) + (b9 << 28)) >> 30) == 0) {
                        long j15 = 2 + j10;
                        if (UnsafeUtil.getByte(bArr, j14) <= -65) {
                            j10 += 3;
                            if (UnsafeUtil.getByte(bArr, j15) > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
        }

        private static int partialIsValidUtf8(long j8, int i8) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j8, i8);
            long j10 = j8 + ((long) iUnsafeEstimateConsecutiveAscii);
            int i9 = i8 - iUnsafeEstimateConsecutiveAscii;
            while (true) {
                byte b9 = 0;
                while (i9 > 0) {
                    long j11 = j10 + 1;
                    b9 = UnsafeUtil.getByte(j10);
                    if (b9 < 0) {
                        j10 = j11;
                        break;
                    }
                    i9--;
                    j10 = j11;
                }
                if (i9 == 0) {
                    return 0;
                }
                int i10 = i9 - 1;
                if (b9 < -32) {
                    if (i10 == 0) {
                        return b9;
                    }
                    i9 -= 2;
                    if (b9 >= -62) {
                        long j12 = 1 + j10;
                        if (UnsafeUtil.getByte(j10) <= -65) {
                            j10 = j12;
                        }
                    }
                    return -1;
                }
                if (b9 < -16) {
                    if (i10 < 2) {
                        return unsafeIncompleteStateFor(j10, b9, i10);
                    }
                    i9 -= 3;
                    long j13 = 1 + j10;
                    byte b10 = UnsafeUtil.getByte(j10);
                    if (b10 <= -65 && ((b9 != -32 || b10 >= -96) && (b9 != -19 || b10 < -96))) {
                        j10 += 2;
                        if (UnsafeUtil.getByte(j13) > -65) {
                        }
                    }
                    return -1;
                }
                if (i10 < 3) {
                    return unsafeIncompleteStateFor(j10, b9, i10);
                }
                i9 -= 4;
                long j14 = 1 + j10;
                byte b11 = UnsafeUtil.getByte(j10);
                if (b11 <= -65) {
                    if ((((b11 + 112) + (b9 << 28)) >> 30) == 0) {
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
    public static int incompleteStateFor(int i8, int i9, int i10) {
        if (i8 > -12 || i9 > -65 || i10 > -65) {
            return -1;
        }
        return (i8 ^ (i9 << 8)) ^ (i10 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i8, int i9) {
        byte b9 = bArr[i8 - 1];
        int i10 = i9 - i8;
        if (i10 == 0) {
            return incompleteStateFor(b9);
        }
        if (i10 == 1) {
            return incompleteStateFor(b9, bArr[i8]);
        }
        if (i10 == 2) {
            return incompleteStateFor(b9, bArr[i8], bArr[i8 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i8, int i9, int i10) {
        if (i10 == 0) {
            return incompleteStateFor(i8);
        }
        if (i10 == 1) {
            return incompleteStateFor(i8, byteBuffer.get(i9));
        }
        if (i10 == 2) {
            return incompleteStateFor(i8, byteBuffer.get(i9), byteBuffer.get(i9 + 1));
        }
        throw new AssertionError();
    }

    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i8, int i9) {
            while (i8 < i9) {
                int i10 = i8 + 1;
                byte b9 = bArr[i8];
                if (b9 < 0) {
                    if (b9 < -32) {
                        if (i10 >= i9) {
                            return b9;
                        }
                        if (b9 >= -62) {
                            i8 += 2;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b9 < -16) {
                        if (i10 >= i9 - 1) {
                            return Utf8.incompleteStateFor(bArr, i10, i9);
                        }
                        int i11 = i8 + 2;
                        byte b10 = bArr[i10];
                        if (b10 <= -65 && ((b9 != -32 || b10 >= -96) && (b9 != -19 || b10 < -96))) {
                            i8 += 3;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i9 - 2) {
                        return Utf8.incompleteStateFor(bArr, i10, i9);
                    }
                    int i12 = i8 + 2;
                    byte b11 = bArr[i10];
                    if (b11 <= -65) {
                        if ((((b11 + 112) + (b9 << 28)) >> 30) == 0) {
                            int i13 = i8 + 3;
                            if (bArr[i12] <= -65) {
                                i8 += 4;
                                if (bArr[i13] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i8 = i10;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((bArr.length - i8) - i9)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            int i10 = i8 + i9;
            char[] cArr = new char[i9];
            int i11 = 0;
            while (i8 < i10) {
                byte b9 = bArr[i8];
                if (!DecodeUtil.isOneByte(b9)) {
                    break;
                }
                i8++;
                DecodeUtil.handleOneByte(b9, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i8 < i10) {
                int i13 = i8 + 1;
                byte b10 = bArr[i8];
                if (DecodeUtil.isOneByte(b10)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    while (i13 < i10) {
                        byte b11 = bArr[i13];
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i8 = i13;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i8 += 2;
                    DecodeUtil.handleTwoBytes(b10, bArr[i13], cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = i8 + 2;
                    i8 += 3;
                    DecodeUtil.handleThreeBytes(b10, bArr[i13], bArr[i15], cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = bArr[i13];
                    int i16 = i8 + 3;
                    byte b13 = bArr[i8 + 2];
                    i8 += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, bArr[i16], cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i8, i9);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i8, int i9) {
            int i10;
            int i11;
            char cCharAt;
            int length = charSequence.length();
            int i12 = i9 + i8;
            int i13 = 0;
            while (i13 < length && (i11 = i13 + i8) < i12 && (cCharAt = charSequence.charAt(i13)) < 128) {
                bArr[i11] = (byte) cCharAt;
                i13++;
            }
            if (i13 == length) {
                return i8 + length;
            }
            int i14 = i8 + i13;
            while (i13 < length) {
                char cCharAt2 = charSequence.charAt(i13);
                if (cCharAt2 < 128 && i14 < i12) {
                    bArr[i14] = (byte) cCharAt2;
                    i14++;
                } else if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                    i14 += 2;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                        if (i14 > i12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                                throw new UnpairedSurrogateException(i13, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                        }
                        int i16 = i13 + 1;
                        if (i16 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i16);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i17 = i14 + 3;
                                bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i14 += 4;
                                bArr[i17] = (byte) ((codePoint & 63) | 128);
                                i13 = i16;
                            } else {
                                i13 = i16;
                            }
                        }
                        throw new UnpairedSurrogateException(i13 - 1, length);
                    }
                    bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i18 = i14 + 2;
                    bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i14 += 3;
                    bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
                }
                i13++;
            }
            return i14;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
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
        public int partialIsValidUtf8Direct(int i8, ByteBuffer byteBuffer, int i9, int i10) {
            return partialIsValidUtf8Default(i8, byteBuffer, i9, i10);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i8, int i9) {
            while (i8 < i9 && bArr[i8] >= 0) {
                i8++;
            }
            if (i8 >= i9) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i8, i9);
        }
    }
}
