package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CookieDecoder {
    private final InternalLogger logger = InternalLoggerFactory.getInstance(getClass());
    private final boolean strict;

    public CookieDecoder(boolean z10) {
        this.strict = z10;
    }

    public DefaultCookie initCookie(String str, int i10, int i11, int i12, int i13) {
        int iFirstInvalidCookieValueOctet;
        int iFirstInvalidCookieNameOctet;
        if (i10 == -1 || i10 == i11) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        }
        if (i12 == -1) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        }
        CharBuffer charBufferWrap = CharBuffer.wrap(str, i12, i13);
        CharSequence charSequenceUnwrapValue = CookieUtil.unwrapValue(charBufferWrap);
        if (charSequenceUnwrapValue == null) {
            this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", charBufferWrap);
            return null;
        }
        String strSubstring = str.substring(i10, i11);
        if (this.strict && (iFirstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(strSubstring)) >= 0) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", strSubstring, Character.valueOf(strSubstring.charAt(iFirstInvalidCookieNameOctet)));
            }
            return null;
        }
        boolean z10 = charSequenceUnwrapValue.length() != i13 - i12;
        if (!this.strict || (iFirstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(charSequenceUnwrapValue)) < 0) {
            DefaultCookie defaultCookie = new DefaultCookie(strSubstring, charSequenceUnwrapValue.toString());
            defaultCookie.setWrap(z10);
            return defaultCookie;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", charSequenceUnwrapValue, Character.valueOf(charSequenceUnwrapValue.charAt(iFirstInvalidCookieValueOctet)));
        }
        return null;
    }
}
