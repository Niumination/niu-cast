package io.netty.handler.codec.http2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.util.Arrays;
import java.util.List;
import wj.h2;
import wj.v0;

/* JADX INFO: loaded from: classes3.dex */
final class HpackStaticTable {
    private static final HeaderIndex[] HEADERS_WITH_NON_EMPTY_VALUES;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SIZE = 64;
    private static final HeaderNameIndex[] HEADER_NAMES;
    private static final int HEADER_NAMES_TABLE_SHIFT;
    private static final int HEADER_NAMES_TABLE_SIZE = 512;
    static final int NOT_FOUND = -1;
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    public static final class HeaderIndex {
        final int index;
        final CharSequence name;
        final CharSequence value;

        public HeaderIndex(CharSequence charSequence, CharSequence charSequence2, int i10) {
            this.name = charSequence;
            this.value = charSequence2;
            this.index = i10;
        }
    }

    public static final class HeaderNameIndex {
        final boolean emptyValue;
        final int index;
        final CharSequence name;

        public HeaderNameIndex(CharSequence charSequence, int i10, boolean z10) {
            this.name = charSequence;
            this.index = i10;
            this.emptyValue = z10;
        }
    }

    static {
        List<HpackHeaderField> listAsList = Arrays.asList(newEmptyHeaderField(":authority"), newHeaderField(":method", "GET"), newHeaderField(":method", v0.f19370p), newHeaderField(":path", "/"), newHeaderField(":path", "/index.html"), newHeaderField(":scheme", "http"), newHeaderField(":scheme", h2.f18719h), newHeaderField(":status", "200"), newHeaderField(":status", "204"), newHeaderField(":status", "206"), newHeaderField(":status", "304"), newHeaderField(":status", "400"), newHeaderField(":status", "404"), newHeaderField(":status", "500"), newEmptyHeaderField("accept-charset"), newHeaderField(v0.f19376v, "gzip, deflate"), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField(v0.f19375u), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField("etag"), newEmptyHeaderField("expect"), newEmptyHeaderField("expires"), newEmptyHeaderField(TypedValues.TransitionType.S_FROM), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField("location"), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField("user-agent"), newEmptyHeaderField("vary"), newEmptyHeaderField("via"), newEmptyHeaderField("www-authenticate"));
        STATIC_TABLE = listAsList;
        HEADER_NAMES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 22 : 18;
        HEADER_NAMES = new HeaderNameIndex[512];
        int size = listAsList.size();
        while (true) {
            boolean z10 = false;
            if (size <= 0) {
                HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 0 : 6;
                HEADERS_WITH_NON_EMPTY_VALUES = new HeaderIndex[64];
                for (int size2 = STATIC_TABLE.size(); size2 > 0; size2--) {
                    HpackHeaderField entry = getEntry(size2);
                    if (entry.value.length() > 0) {
                        int iHeaderBucket = headerBucket(entry.value);
                        HeaderIndex[] headerIndexArr = HEADERS_WITH_NON_EMPTY_VALUES;
                        HeaderIndex headerIndex = headerIndexArr[iHeaderBucket];
                        if (headerIndex != null) {
                            throw new IllegalStateException("Hash bucket collision between " + ((Object) headerIndex.value) + " and " + ((Object) entry.value));
                        }
                        headerIndexArr[iHeaderBucket] = new HeaderIndex(entry.name, entry.value, size2);
                    }
                }
                length = STATIC_TABLE.size();
                return;
            }
            HpackHeaderField entry2 = getEntry(size);
            int iHeaderNameBucket = headerNameBucket(entry2.name);
            HeaderNameIndex[] headerNameIndexArr = HEADER_NAMES;
            HeaderNameIndex headerNameIndex = headerNameIndexArr[iHeaderNameBucket];
            if (headerNameIndex != null && !HpackUtil.equalsVariableTime(headerNameIndex.name, entry2.name)) {
                throw new IllegalStateException("Hash bucket collision between " + ((Object) headerNameIndex.name) + " and " + ((Object) entry2.name));
            }
            CharSequence charSequence = entry2.name;
            if (entry2.value.length() == 0) {
                z10 = true;
            }
            headerNameIndexArr[iHeaderNameBucket] = new HeaderNameIndex(charSequence, size, z10);
            size--;
        }
    }

    private HpackStaticTable() {
    }

    private static int bucket(CharSequence charSequence, int i10, int i11) {
        return (AsciiString.hashCode(charSequence) >> i10) & i11;
    }

    public static HpackHeaderField getEntry(int i10) {
        return STATIC_TABLE.get(i10 - 1);
    }

    public static int getIndex(CharSequence charSequence) {
        HeaderNameIndex entry = getEntry(charSequence);
        if (entry == null) {
            return -1;
        }
        return entry.index;
    }

    public static int getIndexInsensitive(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() == 0) {
            HeaderNameIndex entry = getEntry(charSequence);
            if (entry == null || !entry.emptyValue) {
                return -1;
            }
            return entry.index;
        }
        HeaderIndex headerIndex = HEADERS_WITH_NON_EMPTY_VALUES[headerBucket(charSequence2)];
        if (headerIndex != null && HpackUtil.equalsVariableTime(headerIndex.name, charSequence) && HpackUtil.equalsVariableTime(headerIndex.value, charSequence2)) {
            return headerIndex.index;
        }
        return -1;
    }

    private static int headerBucket(CharSequence charSequence) {
        return bucket(charSequence, HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT, 63);
    }

    private static int headerNameBucket(CharSequence charSequence) {
        return bucket(charSequence, HEADER_NAMES_TABLE_SHIFT, FrameMetricsAggregator.EVERY_DURATION);
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }

    private static HeaderNameIndex getEntry(CharSequence charSequence) {
        HeaderNameIndex headerNameIndex = HEADER_NAMES[headerNameBucket(charSequence)];
        if (headerNameIndex != null && HpackUtil.equalsVariableTime(headerNameIndex.name, charSequence)) {
            return headerNameIndex;
        }
        return null;
    }
}
