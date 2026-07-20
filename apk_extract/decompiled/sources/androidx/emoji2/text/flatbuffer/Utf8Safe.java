package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i8, int i9) {
            super(d.f(i8, i9, "Unpaired surrogate at index ", " of "));
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
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

    public static String decodeUtf8Array(byte[] bArr, int i8, int i9) {
        if ((i8 | i9 | ((bArr.length - i8) - i9)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
        }
        int i10 = i8 + i9;
        char[] cArr = new char[i9];
        int i11 = 0;
        while (i8 < i10) {
            byte b9 = bArr[i8];
            if (!Utf8.DecodeUtil.isOneByte(b9)) {
                break;
            }
            i8++;
            Utf8.DecodeUtil.handleOneByte(b9, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i8 < i10) {
            int i13 = i8 + 1;
            byte b10 = bArr[i8];
            if (Utf8.DecodeUtil.isOneByte(b10)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b10, cArr, i12);
                while (i13 < i10) {
                    byte b11 = bArr[i13];
                    if (!Utf8.DecodeUtil.isOneByte(b11)) {
                        break;
                    }
                    i13++;
                    Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i8 = i13;
            } else if (Utf8.DecodeUtil.isTwoBytes(b10)) {
                if (i13 >= i10) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i8 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b10, bArr[i13], cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b10)) {
                if (i13 >= i10 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i15 = i8 + 2;
                i8 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b10, bArr[i13], bArr[i15], cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b12 = bArr[i13];
                int i16 = i8 + 3;
                byte b13 = bArr[i8 + 2];
                i8 += 4;
                Utf8.DecodeUtil.handleFourBytes(b10, b12, b13, bArr[i16], cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i8, int i9) {
        if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)));
        }
        int i10 = i8 + i9;
        char[] cArr = new char[i9];
        int i11 = 0;
        while (i8 < i10) {
            byte b9 = byteBuffer.get(i8);
            if (!Utf8.DecodeUtil.isOneByte(b9)) {
                break;
            }
            i8++;
            Utf8.DecodeUtil.handleOneByte(b9, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i8 < i10) {
            int i13 = i8 + 1;
            byte b10 = byteBuffer.get(i8);
            if (Utf8.DecodeUtil.isOneByte(b10)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b10, cArr, i12);
                while (i13 < i10) {
                    byte b11 = byteBuffer.get(i13);
                    if (!Utf8.DecodeUtil.isOneByte(b11)) {
                        break;
                    }
                    i13++;
                    Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i8 = i13;
            } else if (Utf8.DecodeUtil.isTwoBytes(b10)) {
                if (i13 >= i10) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i8 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b10, byteBuffer.get(i13), cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b10)) {
                if (i13 >= i10 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i15 = i8 + 2;
                i8 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b10, byteBuffer.get(i13), byteBuffer.get(i15), cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b12 = byteBuffer.get(i13);
                int i16 = i8 + 3;
                byte b13 = byteBuffer.get(i8 + 2);
                i8 += 4;
                Utf8.DecodeUtil.handleFourBytes(b10, b12, b13, byteBuffer.get(i16), cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i8, int i9) {
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

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
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
            byteBuffer.position(iPosition + i8);
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
        byteBuffer.position(iPosition);
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

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i8, int i9) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i8, i9) : decodeUtf8Buffer(byteBuffer, i8, i9);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
