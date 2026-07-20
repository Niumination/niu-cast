package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class QueryStringDecoder {
    private static final int DEFAULT_MAX_PARAMS = 1024;
    private final Charset charset;
    private final int maxParams;
    private Map<String, List<String>> params;
    private String path;
    private int pathEndIdx;
    private final boolean semicolonIsNormalChar;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static boolean addParam(String str, int i10, int i11, int i12, Map<String, List<String>> map, Charset charset) {
        if (i10 >= i12) {
            return false;
        }
        if (i11 <= i10) {
            i11 = i12 + 1;
        }
        String strDecodeComponent = decodeComponent(str, i10, i11 - 1, charset, false);
        String strDecodeComponent2 = decodeComponent(str, i11, i12, charset, false);
        List<String> arrayList = map.get(strDecodeComponent);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            map.put(strDecodeComponent, arrayList);
        }
        arrayList.add(strDecodeComponent2);
        return true;
    }

    public static String decodeComponent(String str) {
        return decodeComponent(str, HttpConstants.DEFAULT_CHARSET);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    private static Map<String, List<String>> decodeParams(String str, int i10, Charset charset, int i11, boolean z10) {
        int length = str.length();
        if (i10 >= length) {
            return Collections.emptyMap();
        }
        if (str.charAt(i10) == '?') {
            i10++;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i12 = i10;
        int i13 = i12;
        int i14 = -1;
        while (i13 < length) {
            char cCharAt = str.charAt(i13);
            if (cCharAt == '#') {
                break;
            }
            if (cCharAt == '&') {
                if (addParam(str, i12, i14, i13, linkedHashMap, charset) && (i11 = i11 - 1) == 0) {
                    return linkedHashMap;
                }
                i12 = i13 + 1;
            } else if (cCharAt != ';') {
                if (cCharAt == '=') {
                    if (i12 == i13) {
                        i12 = i13 + 1;
                    } else if (i14 < i12) {
                        i14 = i13 + 1;
                    }
                }
            } else if (z10) {
                continue;
            } else {
                if (addParam(str, i12, i14, i13, linkedHashMap, charset)) {
                    return linkedHashMap;
                }
                i12 = i13 + 1;
            }
            i13++;
        }
        addParam(str, i12, i14, i13, linkedHashMap, charset);
        return linkedHashMap;
    }

    private static int findPathEndIndex(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '?' || cCharAt == '#') {
                return i10;
            }
        }
        return length;
    }

    private int pathEndIdx() {
        if (this.pathEndIdx == -1) {
            this.pathEndIdx = findPathEndIndex(this.uri);
        }
        return this.pathEndIdx;
    }

    public Map<String, List<String>> parameters() {
        if (this.params == null) {
            this.params = decodeParams(this.uri, pathEndIdx(), this.charset, this.maxParams, this.semicolonIsNormalChar);
        }
        return this.params;
    }

    public String path() {
        if (this.path == null) {
            this.path = decodeComponent(this.uri, 0, pathEndIdx(), this.charset, true);
        }
        return this.path;
    }

    public String rawPath() {
        return this.uri.substring(0, pathEndIdx());
    }

    public String rawQuery() {
        int iPathEndIdx = pathEndIdx() + 1;
        return iPathEndIdx < this.uri.length() ? this.uri.substring(iPathEndIdx) : "";
    }

    public String toString() {
        return uri();
    }

    public String uri() {
        return this.uri;
    }

    public QueryStringDecoder(String str, boolean z10) {
        this(str, HttpConstants.DEFAULT_CHARSET, z10);
    }

    public static String decodeComponent(String str, Charset charset) {
        return str == null ? "" : decodeComponent(str, 0, str.length(), charset, false);
    }

    public QueryStringDecoder(String str, Charset charset) {
        this(str, charset, true);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z10) {
        this(str, charset, z10, 1024);
    }

    private static String decodeComponent(String str, int i10, int i11, Charset charset, boolean z10) {
        int i12;
        int i13 = i11 - i10;
        if (i13 <= 0) {
            return "";
        }
        int i14 = i10;
        while (true) {
            if (i14 >= i11) {
                i14 = -1;
                break;
            }
            char cCharAt = str.charAt(i14);
            if (cCharAt == '%' || (cCharAt == '+' && !z10)) {
                break;
            }
            i14++;
        }
        if (i14 == -1) {
            return str.substring(i10, i11);
        }
        byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray((i11 - i14) / 3);
        StringBuilder sb2 = new StringBuilder(i13);
        sb2.append((CharSequence) str, i10, i14);
        while (i14 < i11) {
            char cCharAt2 = str.charAt(i14);
            if (cCharAt2 != '%') {
                if (cCharAt2 == '+' && !z10) {
                    cCharAt2 = ' ';
                }
                sb2.append(cCharAt2);
            } else {
                int i15 = 0;
                while (true) {
                    int i16 = i14 + 3;
                    if (i16 <= i11) {
                        i12 = i15 + 1;
                        bArrAllocateUninitializedArray[i15] = StringUtil.decodeHexByte(str, i14 + 1);
                        if (i16 >= i11 || str.charAt(i16) != '%') {
                            break;
                        }
                        i14 = i16;
                        i15 = i12;
                    } else {
                        throw new IllegalArgumentException("unterminated escape sequence at index " + i14 + " of: " + str);
                    }
                }
                i14 += 2;
                sb2.append(new String(bArrAllocateUninitializedArray, 0, i12, charset));
            }
            i14++;
        }
        return sb2.toString();
    }

    public QueryStringDecoder(String str, Charset charset, boolean z10, int i10) {
        this(str, charset, z10, i10, false);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z10, int i10, boolean z11) {
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i10, "maxParams");
        this.semicolonIsNormalChar = z11;
        this.pathEndIdx = z10 ? -1 : 0;
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        this(uri, charset, 1024);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i10) {
        this(uri, charset, i10, false);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i10, boolean z10) {
        String str;
        String rawPath = uri.getRawPath();
        rawPath = rawPath == null ? "" : rawPath;
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null) {
            str = rawPath;
        } else {
            str = rawPath + '?' + rawQuery;
        }
        this.uri = str;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i10, "maxParams");
        this.semicolonIsNormalChar = z10;
        this.pathEndIdx = rawPath.length();
    }
}
