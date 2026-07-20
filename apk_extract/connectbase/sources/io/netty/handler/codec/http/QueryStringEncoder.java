package io.netty.handler.codec.http;

import fl.h;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import jq.j;
import p5.m0;

/* JADX INFO: loaded from: classes3.dex */
public class QueryStringEncoder {
    private static final char[] CHAR_MAP = j.f8822b.toCharArray();
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private final Charset charset;
    private boolean hasParams;
    private final StringBuilder uriBuilder;

    public QueryStringEncoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private void appendEncoded(int i10) {
        StringBuilder sb2 = this.uriBuilder;
        sb2.append('%');
        sb2.append(forDigit(i10 >> 4));
        sb2.append(forDigit(i10));
    }

    private static boolean dontNeedEncoding(char c10) {
        return (c10 >= 'a' && c10 <= 'z') || (c10 >= 'A' && c10 <= 'Z') || ((c10 >= '0' && c10 <= '9') || c10 == '-' || c10 == '_' || c10 == '.' || c10 == '*' || c10 == '~');
    }

    private void encodeComponent(CharSequence charSequence) {
        if (this.charset == null) {
            encodeUtf8Component(charSequence);
        } else {
            encodeNonUtf8Component(charSequence);
        }
    }

    private void encodeNonUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = null;
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (dontNeedEncoding(cCharAt)) {
                this.uriBuilder.append(cCharAt);
                i10++;
            } else {
                if (cArr == null) {
                    cArr = new char[charSequence.length() - i10];
                }
                int i11 = 0;
                do {
                    cArr[i11] = cCharAt;
                    i11++;
                    i10++;
                    if (i10 >= charSequence.length()) {
                        break;
                    } else {
                        cCharAt = charSequence.charAt(i10);
                    }
                } while (!dontNeedEncoding(cCharAt));
                for (byte b10 : new String(cArr, 0, i11).getBytes(this.charset)) {
                    appendEncoded(b10);
                }
            }
        }
    }

    private void encodeUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!dontNeedEncoding(charSequence.charAt(i10))) {
                encodeUtf8Component(charSequence, i10, length);
                return;
            }
        }
        this.uriBuilder.append(charSequence);
    }

    private void encodeUtf8ComponentSlow(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt < 128) {
                if (dontNeedEncoding(cCharAt)) {
                    this.uriBuilder.append(cCharAt);
                } else {
                    appendEncoded(cCharAt);
                }
            } else if (cCharAt < 2048) {
                appendEncoded((cCharAt >> 6) | 192);
                appendEncoded((cCharAt & '?') | 128);
            } else if (!StringUtil.isSurrogate(cCharAt)) {
                appendEncoded((cCharAt >> '\f') | 224);
                appendEncoded(((cCharAt >> 6) & 63) | 128);
                appendEncoded((cCharAt & '?') | 128);
            } else if (Character.isHighSurrogate(cCharAt)) {
                i10++;
                if (i10 == charSequence.length()) {
                    appendEncoded(63);
                    return;
                }
                writeUtf8Surrogate(cCharAt, charSequence.charAt(i10));
            } else {
                appendEncoded(63);
            }
            i10++;
        }
    }

    private static char forDigit(int i10) {
        return CHAR_MAP[i10 & 15];
    }

    private void writeUtf8Surrogate(char c10, char c11) {
        if (!Character.isLowSurrogate(c11)) {
            appendEncoded(63);
            if (Character.isHighSurrogate(c11)) {
                c11 = '?';
            }
            appendEncoded(c11);
            return;
        }
        int codePoint = Character.toCodePoint(c10, c11);
        appendEncoded((codePoint >> 18) | m0.f12864d);
        appendEncoded(((codePoint >> 12) & 63) | 128);
        appendEncoded(((codePoint >> 6) & 63) | 128);
        appendEncoded((codePoint & 63) | 128);
    }

    public void addParam(String str, String str2) {
        ObjectUtil.checkNotNull(str, "name");
        if (this.hasParams) {
            this.uriBuilder.append(jq.m0.f8866d);
        } else {
            this.uriBuilder.append('?');
            this.hasParams = true;
        }
        encodeComponent(str);
        if (str2 != null) {
            this.uriBuilder.append(h.f6043c);
            encodeComponent(str2);
        }
    }

    public String toString() {
        return this.uriBuilder.toString();
    }

    public URI toUri() throws URISyntaxException {
        return new URI(toString());
    }

    public QueryStringEncoder(String str, Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        this.uriBuilder = new StringBuilder(str);
        this.charset = CharsetUtil.UTF_8.equals(charset) ? null : charset;
    }

    private void encodeUtf8Component(CharSequence charSequence, int i10, int i11) {
        if (i10 > 0) {
            this.uriBuilder.append(charSequence, 0, i10);
        }
        encodeUtf8ComponentSlow(charSequence, i10, i11);
    }
}
