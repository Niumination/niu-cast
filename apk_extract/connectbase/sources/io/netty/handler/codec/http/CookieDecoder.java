package io.netty.handler.codec.http;

import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import ks.g;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class CookieDecoder {
    private static final String COMMENT = "Comment";
    private static final String COMMENTURL = "CommentURL";
    private static final String DISCARD = "Discard";
    private static final String PORT = "Port";
    private static final String VERSION = "Version";
    private final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CookieDecoder.class);
    private final boolean strict;
    private static final CookieDecoder STRICT = new CookieDecoder(true);
    private static final CookieDecoder LAX = new CookieDecoder(false);

    private CookieDecoder(boolean z10) {
        this.strict = z10;
    }

    public static Set<Cookie> decode(String str) {
        return decode(str, true);
    }

    private Set<Cookie> doDecode(String str) {
        int i10;
        int i11;
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z10;
        ArrayList arrayList3 = new ArrayList(8);
        ArrayList arrayList4 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList3, arrayList4);
        if (arrayList3.isEmpty()) {
            return Collections.emptySet();
        }
        boolean z11 = false;
        if (((String) arrayList3.get(0)).equalsIgnoreCase(VERSION)) {
            try {
                i10 = Integer.parseInt((String) arrayList4.get(0));
            } catch (NumberFormatException unused) {
                i10 = 0;
            }
            i11 = 1;
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (arrayList3.size() <= i11) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        while (i11 < arrayList3.size()) {
            String str2 = (String) arrayList3.get(i11);
            String str3 = (String) arrayList4.get(i11);
            if (str3 == null) {
                str3 = "";
            }
            DefaultCookie defaultCookieInitCookie = initCookie(str2, str3);
            if (defaultCookieInitCookie == null) {
                break;
            }
            ArrayList arrayList5 = new ArrayList(2);
            int i12 = i11 + 1;
            String str4 = null;
            boolean z12 = z11;
            boolean z13 = z12;
            TreeSet treeSet2 = treeSet;
            String str5 = null;
            long j10 = Long.MIN_VALUE;
            String str6 = null;
            String str7 = null;
            while (true) {
                if (i12 >= arrayList3.size()) {
                    arrayList = arrayList3;
                    arrayList2 = arrayList4;
                    z10 = z11;
                    break;
                }
                String str8 = (String) arrayList3.get(i12);
                arrayList = arrayList3;
                String str9 = (String) arrayList4.get(i12);
                arrayList2 = arrayList4;
                if (DISCARD.equalsIgnoreCase(str8)) {
                    z11 = true;
                } else if (CookieHeaderNames.SECURE.equalsIgnoreCase(str8)) {
                    z12 = true;
                } else if (CookieHeaderNames.HTTPONLY.equalsIgnoreCase(str8)) {
                    z13 = true;
                } else if (COMMENT.equalsIgnoreCase(str8)) {
                    str4 = str9;
                } else if (COMMENTURL.equalsIgnoreCase(str8)) {
                    str6 = str9;
                } else if (CookieHeaderNames.DOMAIN.equalsIgnoreCase(str8)) {
                    str7 = str9;
                } else if (CookieHeaderNames.PATH.equalsIgnoreCase(str8)) {
                    str5 = str9;
                } else {
                    if (!"Expires".equalsIgnoreCase(str8)) {
                        z10 = z11;
                        if (!CookieHeaderNames.MAX_AGE.equalsIgnoreCase(str8)) {
                            if (!VERSION.equalsIgnoreCase(str8)) {
                                if (!PORT.equalsIgnoreCase(str8)) {
                                    break;
                                }
                                String[] strArrSplit = str9.split(g.f9491d);
                                int length = strArrSplit.length;
                                int i13 = 0;
                                while (i13 < length) {
                                    String[] strArr = strArrSplit;
                                    try {
                                        arrayList5.add(Integer.valueOf(strArrSplit[i13]));
                                    } catch (NumberFormatException unused2) {
                                    }
                                    i13++;
                                    strArrSplit = strArr;
                                }
                            } else {
                                i10 = Integer.parseInt(str9);
                            }
                        } else {
                            j10 = Integer.parseInt(str9);
                        }
                    } else {
                        Date httpDate = DateFormatter.parseHttpDate(str9);
                        if (httpDate != null) {
                            long time = httpDate.getTime() - System.currentTimeMillis();
                            z10 = z11;
                            j10 = (time / 1000) + ((long) (time % 1000 != 0 ? 1 : 0));
                        } else {
                            z10 = z11;
                        }
                    }
                    z11 = z10;
                }
                i12++;
                i11++;
                arrayList4 = arrayList2;
                arrayList3 = arrayList;
            }
            defaultCookieInitCookie.setVersion(i10);
            defaultCookieInitCookie.setMaxAge(j10);
            defaultCookieInitCookie.setPath(str5);
            defaultCookieInitCookie.setDomain(str7);
            defaultCookieInitCookie.setSecure(z12);
            defaultCookieInitCookie.setHttpOnly(z13);
            if (i10 > 0) {
                defaultCookieInitCookie.setComment(str4);
            }
            if (i10 > 1) {
                defaultCookieInitCookie.setCommentUrl(str6);
                defaultCookieInitCookie.setPorts(arrayList5);
                defaultCookieInitCookie.setDiscard(z10);
            }
            treeSet2.add(defaultCookieInitCookie);
            i11++;
            treeSet = treeSet2;
            arrayList4 = arrayList2;
            arrayList3 = arrayList;
            z11 = false;
        }
        return treeSet;
    }

    private static void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String strSubstring;
        String string;
        String strSubstring2;
        int length = str.length();
        int i10 = 0;
        while (i10 != length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != ',' && cCharAt != ';') {
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        while (i10 != length) {
                            if (str.charAt(i10) != '$') {
                                String str2 = null;
                                if (i10 == length) {
                                    string = null;
                                } else {
                                    int i11 = i10;
                                    while (true) {
                                        char cCharAt2 = str.charAt(i11);
                                        if (cCharAt2 == ';') {
                                            strSubstring = str.substring(i10, i11);
                                        } else if (cCharAt2 != '=') {
                                            i11++;
                                            if (i11 == length) {
                                                strSubstring = str.substring(i10);
                                            }
                                        } else {
                                            String strSubstring3 = str.substring(i10, i11);
                                            i10 = i11 + 1;
                                            if (i10 == length) {
                                                string = "";
                                            } else {
                                                char cCharAt3 = str.charAt(i10);
                                                if (cCharAt3 == '\"' || cCharAt3 == '\'') {
                                                    StringBuilder sb2 = new StringBuilder(str.length() - i10);
                                                    int i12 = i11 + 2;
                                                    while (true) {
                                                        boolean z10 = false;
                                                        while (true) {
                                                            if (i12 == length) {
                                                                string = sb2.toString();
                                                                i10 = i12;
                                                            } else if (z10) {
                                                                int i13 = i12 + 1;
                                                                char cCharAt4 = str.charAt(i12);
                                                                if (cCharAt4 == '\"' || cCharAt4 == '\'' || cCharAt4 == '\\') {
                                                                    sb2.setCharAt(sb2.length() - 1, cCharAt4);
                                                                } else {
                                                                    sb2.append(cCharAt4);
                                                                }
                                                                i12 = i13;
                                                            } else {
                                                                int i14 = i12 + 1;
                                                                char cCharAt5 = str.charAt(i12);
                                                                if (cCharAt5 == cCharAt3) {
                                                                    string = sb2.toString();
                                                                    str2 = strSubstring3;
                                                                    i10 = i14;
                                                                } else {
                                                                    sb2.append(cCharAt5);
                                                                    if (cCharAt5 == '\\') {
                                                                        z10 = true;
                                                                    }
                                                                    i12 = i14;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    int iIndexOf = str.indexOf(59, i10);
                                                    if (iIndexOf > 0) {
                                                        strSubstring2 = str.substring(i10, iIndexOf);
                                                    } else {
                                                        strSubstring2 = str.substring(i10);
                                                        iIndexOf = length;
                                                    }
                                                    string = strSubstring2;
                                                    i10 = iIndexOf;
                                                }
                                            }
                                            str2 = strSubstring3;
                                        }
                                        string = null;
                                        str2 = strSubstring;
                                        i10 = i11;
                                    }
                                }
                                list.add(str2);
                                list2.add(string);
                                continue;
                            } else {
                                i10++;
                            }
                            break;
                        }
                        return;
                }
            }
            i10++;
        }
    }

    private DefaultCookie initCookie(String str, String str2) {
        int iFirstInvalidCookieValueOctet;
        int iFirstInvalidCookieNameOctet;
        if (str == null || str.length() == 0) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        }
        if (str2 == null) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        }
        CharSequence charSequenceUnwrapValue = CookieUtil.unwrapValue(str2);
        if (charSequenceUnwrapValue == null) {
            this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", charSequenceUnwrapValue);
            return null;
        }
        if (this.strict && (iFirstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str)) >= 0) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", str, Character.valueOf(str.charAt(iFirstInvalidCookieNameOctet)));
            }
            return null;
        }
        boolean z10 = charSequenceUnwrapValue.length() != str2.length();
        if (!this.strict || (iFirstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(charSequenceUnwrapValue)) < 0) {
            DefaultCookie defaultCookie = new DefaultCookie(str, charSequenceUnwrapValue.toString());
            defaultCookie.setWrap(z10);
            return defaultCookie;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", charSequenceUnwrapValue, Character.valueOf(charSequenceUnwrapValue.charAt(iFirstInvalidCookieValueOctet)));
        }
        return null;
    }

    public static Set<Cookie> decode(String str, boolean z10) {
        return (z10 ? STRICT : LAX).doDecode(str);
    }
}
