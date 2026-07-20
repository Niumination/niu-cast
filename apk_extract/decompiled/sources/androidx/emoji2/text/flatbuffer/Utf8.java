package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    public static class DecodeUtil {
        public static void handleFourBytes(byte b9, byte b10, byte b11, byte b12, char[] cArr, int i8) throws IllegalArgumentException {
            if (!isNotTrailingByte(b10)) {
                if ((((b10 + 112) + (b9 << 28)) >> 30) == 0 && !isNotTrailingByte(b11) && !isNotTrailingByte(b12)) {
                    int iTrailingByteValue = ((b9 & 7) << 18) | (trailingByteValue(b10) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12);
                    cArr[i8] = highSurrogate(iTrailingByteValue);
                    cArr[i8 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte b9, char[] cArr, int i8) {
            cArr[i8] = (char) b9;
        }

        public static void handleThreeBytes(byte b9, byte b10, byte b11, char[] cArr, int i8) throws IllegalArgumentException {
            if (isNotTrailingByte(b10) || ((b9 == -32 && b10 < -96) || ((b9 == -19 && b10 >= -96) || isNotTrailingByte(b11)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i8] = (char) (((b9 & 15) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11));
        }

        public static void handleTwoBytes(byte b9, byte b10, char[] cArr, int i8) throws IllegalArgumentException {
            if (b9 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b10)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i8] = (char) (((b9 & 31) << 6) | trailingByteValue(b10));
        }

        private static char highSurrogate(int i8) {
            return (char) ((i8 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b9) {
            return b9 > -65;
        }

        public static boolean isOneByte(byte b9) {
            return b9 >= 0;
        }

        public static boolean isThreeBytes(byte b9) {
            return b9 < -16;
        }

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

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i8, int i9) {
            super(d.f(i8, i9, "Unpaired surrogate at index ", " of "));
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i8, int i9);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
