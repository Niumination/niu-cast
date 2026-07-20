package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import jq.m0;
import kl.f;
import n1.e;
import y5.a;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpHeaderValidationUtil {
    private static final long TOKEN_CHARS_HIGH;
    private static final long TOKEN_CHARS_LOW;

    public static final class BitSet128 {
        private long high;
        private long low;

        private BitSet128() {
        }

        public static boolean contains(byte b10, long j10, long j11) {
            if (b10 < 0) {
                return false;
            }
            if (b10 < 64) {
                return 0 != ((1 << b10) & j11);
            }
            return 0 != (j10 & (1 << (b10 - 64)));
        }

        public BitSet128 bits(char... cArr) {
            for (char c10 : cArr) {
                if (c10 < '@') {
                    this.low = (1 << c10) | this.low;
                } else {
                    this.high = (1 << (c10 - '@')) | this.high;
                }
            }
            return this;
        }

        public long high() {
            return this.high;
        }

        public long low() {
            return this.low;
        }

        public BitSet128 range(char c10, char c11) {
            for (int i10 = c10; i10 <= c11; i10++) {
                if (i10 < 64) {
                    this.low = (1 << i10) | this.low;
                } else {
                    this.high = (1 << (i10 - 64)) | this.high;
                }
            }
            return this;
        }
    }

    static {
        BitSet128 bitSet128Bits = new BitSet128().range('0', '9').range(a.H, 'z').range(a.G, a.O).bits('-', e.f11183c, '_', '~').bits('!', '#', m0.f8865c, '%', m0.f8866d, '\'', f.f9277j, '+', '^', '`', '|');
        TOKEN_CHARS_HIGH = bitSet128Bits.high();
        TOKEN_CHARS_LOW = bitSet128Bits.low();
    }

    private HttpHeaderValidationUtil() {
    }

    public static boolean isConnectionHeader(CharSequence charSequence, boolean z10) {
        int length = charSequence.length();
        if (length == 2) {
            if (z10) {
                return false;
            }
            return AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.TE);
        }
        if (length == 7) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.UPGRADE);
        }
        if (length == 10) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.CONNECTION) || AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.KEEP_ALIVE);
        }
        if (length == 16) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.PROXY_CONNECTION);
        }
        if (length != 17) {
            return false;
        }
        return AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.TRANSFER_ENCODING);
    }

    public static boolean isTeNotTrailers(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() == 2 && AsciiString.contentEqualsIgnoreCase(charSequence, HttpHeaderNames.TE) && !AsciiString.contentEqualsIgnoreCase(charSequence2, HttpHeaderValues.TRAILERS);
    }

    private static int validateAsciiStringToken(AsciiString asciiString) {
        byte[] bArrArray = asciiString.array();
        int length = asciiString.length() + asciiString.arrayOffset();
        for (int iArrayOffset = asciiString.arrayOffset(); iArrayOffset < length; iArrayOffset++) {
            if (!BitSet128.contains(bArrArray[iArrayOffset], TOKEN_CHARS_HIGH, TOKEN_CHARS_LOW)) {
                return iArrayOffset - asciiString.arrayOffset();
            }
        }
        return -1;
    }

    private static int validateCharSequenceToken(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!BitSet128.contains((byte) charSequence.charAt(i10), TOKEN_CHARS_HIGH, TOKEN_CHARS_LOW)) {
                return i10;
            }
        }
        return -1;
    }

    public static int validateToken(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? validateAsciiStringToken((AsciiString) charSequence) : validateCharSequenceToken(charSequence);
    }

    public static int validateValidHeaderValue(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return -1;
        }
        return charSequence instanceof AsciiString ? verifyValidHeaderValueAsciiString((AsciiString) charSequence) : verifyValidHeaderValueCharSequence(charSequence);
    }

    private static int verifyValidHeaderValueAsciiString(AsciiString asciiString) {
        byte[] bArrArray = asciiString.array();
        int iArrayOffset = asciiString.arrayOffset();
        int i10 = bArrArray[iArrayOffset] & 255;
        if (i10 < 33 || i10 == 127) {
            return 0;
        }
        int length = asciiString.length();
        for (int i11 = iArrayOffset + 1; i11 < length; i11++) {
            int i12 = bArrArray[i11] & 255;
            if ((i12 < 32 && i12 != 9) || i12 == 127) {
                return i11 - iArrayOffset;
            }
        }
        return -1;
    }

    private static int verifyValidHeaderValueCharSequence(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        if (cCharAt < '!' || cCharAt == 127) {
            return 0;
        }
        int length = charSequence.length();
        for (int i10 = 1; i10 < length; i10++) {
            char cCharAt2 = charSequence.charAt(i10);
            if ((cCharAt2 < ' ' && cCharAt2 != '\t') || cCharAt2 == 127) {
                return i10;
            }
        }
        return -1;
    }
}
