package io.netty.handler.codec.http.cookie;

import fl.h;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;
import k.c;

/* JADX INFO: loaded from: classes3.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS = validCookieNameOctets();
    private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
    private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();

    private CookieUtil() {
    }

    public static void add(StringBuilder sb2, String str, long j10) {
        sb2.append(str);
        sb2.append(h.f6043c);
        sb2.append(j10);
        sb2.append(';');
        sb2.append(' ');
    }

    public static void addQuoted(StringBuilder sb2, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str);
        sb2.append(h.f6043c);
        sb2.append('\"');
        sb2.append(str2);
        sb2.append('\"');
        sb2.append(';');
        sb2.append(' ');
    }

    public static int firstInvalidCookieNameOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_NAME_OCTETS);
    }

    public static int firstInvalidCookieValueOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_VALUE_OCTETS);
    }

    public static int firstInvalidOctet(CharSequence charSequence, BitSet bitSet) {
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!bitSet.get(charSequence.charAt(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public static StringBuilder stringBuilder() {
        return InternalThreadLocalMap.get().stringBuilder();
    }

    public static String stripTrailingSeparator(StringBuilder sb2) {
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 2);
        }
        return sb2.toString();
    }

    public static String stripTrailingSeparatorOrNull(StringBuilder sb2) {
        if (sb2.length() == 0) {
            return null;
        }
        return stripTrailingSeparator(sb2);
    }

    public static CharSequence unwrapValue(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 0 || charSequence.charAt(0) != '\"') {
            return charSequence;
        }
        if (length >= 2) {
            int i10 = length - 1;
            if (charSequence.charAt(i10) == '\"') {
                return length == 2 ? "" : charSequence.subSequence(1, i10);
            }
        }
        return null;
    }

    private static BitSet validCookieAttributeValueOctets() {
        BitSet bitSet = new BitSet();
        for (int i10 = 32; i10 < 127; i10++) {
            bitSet.set(i10);
        }
        bitSet.set(59, false);
        return bitSet;
    }

    private static BitSet validCookieNameOctets() {
        BitSet bitSet = new BitSet();
        for (int i10 = 32; i10 < 127; i10++) {
            bitSet.set(i10);
        }
        int[] iArr = {40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, 125, 32, 9};
        for (int i11 = 0; i11 < 19; i11++) {
            bitSet.set(iArr[i11], false);
        }
        return bitSet;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet();
        bitSet.set(33);
        for (int i10 = 35; i10 <= 43; i10++) {
            bitSet.set(i10);
        }
        for (int i11 = 45; i11 <= 58; i11++) {
            bitSet.set(i11);
        }
        for (int i12 = 60; i12 <= 91; i12++) {
            bitSet.set(i12);
        }
        for (int i13 = 93; i13 <= 126; i13++) {
            bitSet.set(i13);
        }
        return bitSet;
    }

    public static String validateAttributeValue(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String strTrim = str2.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        int iFirstInvalidOctet = firstInvalidOctet(strTrim, VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS);
        if (iFirstInvalidOctet == -1) {
            return strTrim;
        }
        StringBuilder sbA = c.a(str, " contains the prohibited characters: ");
        sbA.append(strTrim.charAt(iFirstInvalidOctet));
        throw new IllegalArgumentException(sbA.toString());
    }

    public static void add(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(h.f6043c);
        sb2.append(str2);
        sb2.append(';');
        sb2.append(' ');
    }

    public static void add(StringBuilder sb2, String str) {
        sb2.append(str);
        sb2.append(';');
        sb2.append(' ');
    }
}
