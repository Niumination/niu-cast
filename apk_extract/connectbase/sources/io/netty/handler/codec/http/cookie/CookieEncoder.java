package io.netty.handler.codec.http.cookie;

import m.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    public CookieEncoder(boolean z10) {
        this.strict = z10;
    }

    public void validateCookie(String str, String str2) {
        if (this.strict) {
            int iFirstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (iFirstInvalidCookieNameOctet >= 0) {
                throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(iFirstInvalidCookieNameOctet));
            }
            CharSequence charSequenceUnwrapValue = CookieUtil.unwrapValue(str2);
            if (charSequenceUnwrapValue == null) {
                throw new IllegalArgumentException(a.a("Cookie value wrapping quotes are not balanced: ", str2));
            }
            int iFirstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(charSequenceUnwrapValue);
            if (iFirstInvalidCookieValueOctet < 0) {
                return;
            }
            throw new IllegalArgumentException("Cookie value contains an invalid char: " + charSequenceUnwrapValue.charAt(iFirstInvalidCookieValueOctet));
        }
    }
}
