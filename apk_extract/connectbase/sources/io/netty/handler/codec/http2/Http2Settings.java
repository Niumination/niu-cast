package io.netty.handler.codec.http2;

import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Settings extends CharObjectHashMap<Long> {
    private static final int DEFAULT_CAPACITY = 13;
    private static final Long FALSE = 0L;
    private static final Long TRUE = 1L;

    public Http2Settings() {
        this(13);
    }

    public static Http2Settings defaultSettings() {
        return new Http2Settings().maxHeaderListSize(8192L);
    }

    private static void verifyStandardSetting(int i10, Long l10) {
        ObjectUtil.checkNotNull(l10, "value");
        switch (i10) {
            case 1:
                if (l10.longValue() < 0 || l10.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting HEADER_TABLE_SIZE is invalid: " + l10 + ", expected [0, 4294967295]");
                }
                return;
            case 2:
                if (l10.longValue() == 0 || l10.longValue() == 1) {
                    return;
                }
                throw new IllegalArgumentException("Setting ENABLE_PUSH is invalid: " + l10 + ", expected [0, 1]");
            case 3:
                if (l10.longValue() < 0 || l10.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_CONCURRENT_STREAMS is invalid: " + l10 + ", expected [0, 4294967295]");
                }
                return;
            case 4:
                if (l10.longValue() < 0 || l10.longValue() > 2147483647L) {
                    throw new IllegalArgumentException("Setting INITIAL_WINDOW_SIZE is invalid: " + l10 + ", expected [0, 2147483647]");
                }
                return;
            case 5:
                if (Http2CodecUtil.isMaxFrameSizeValid(l10.intValue())) {
                    return;
                }
                throw new IllegalArgumentException("Setting MAX_FRAME_SIZE is invalid: " + l10 + ", expected [16384, 16777215]");
            case 6:
                if (l10.longValue() < 0 || l10.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_HEADER_LIST_SIZE is invalid: " + l10 + ", expected [0, 4294967295]");
                }
                return;
            default:
                if (l10.longValue() < 0 || l10.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Non-standard setting 0x" + Integer.toHexString(i10) + " is invalid: " + l10 + ", expected unsigned 32-bit value");
                }
                return;
        }
    }

    public Http2Settings copyFrom(Http2Settings http2Settings) {
        clear();
        putAll(http2Settings);
        return this;
    }

    public Integer getIntValue(char c10) {
        Long l10 = get(c10);
        if (l10 == null) {
            return null;
        }
        return Integer.valueOf(l10.intValue());
    }

    public Long headerTableSize() {
        return get((char) 1);
    }

    public Integer initialWindowSize() {
        return getIntValue((char) 4);
    }

    @Override // io.netty.util.collection.CharObjectHashMap
    public String keyToString(char c10) {
        switch (c10) {
            case 1:
                return "HEADER_TABLE_SIZE";
            case 2:
                return "ENABLE_PUSH";
            case 3:
                return "MAX_CONCURRENT_STREAMS";
            case 4:
                return "INITIAL_WINDOW_SIZE";
            case 5:
                return "MAX_FRAME_SIZE";
            case 6:
                return "MAX_HEADER_LIST_SIZE";
            default:
                return "0x" + Integer.toHexString(c10);
        }
    }

    public Long maxConcurrentStreams() {
        return get((char) 3);
    }

    public Integer maxFrameSize() {
        return getIntValue((char) 5);
    }

    public Long maxHeaderListSize() {
        return get((char) 6);
    }

    public Boolean pushEnabled() {
        Long l10 = get((char) 2);
        if (l10 == null) {
            return null;
        }
        return Boolean.valueOf(TRUE.equals(l10));
    }

    public Http2Settings(int i10, float f10) {
        super(i10, f10);
    }

    public Http2Settings headerTableSize(long j10) {
        put((char) 1, Long.valueOf(j10));
        return this;
    }

    public Http2Settings initialWindowSize(int i10) {
        put((char) 4, Long.valueOf(i10));
        return this;
    }

    public Http2Settings maxConcurrentStreams(long j10) {
        put((char) 3, Long.valueOf(j10));
        return this;
    }

    public Http2Settings maxFrameSize(int i10) {
        put((char) 5, Long.valueOf(i10));
        return this;
    }

    public Http2Settings maxHeaderListSize(long j10) {
        put((char) 6, Long.valueOf(j10));
        return this;
    }

    @Override // io.netty.util.collection.CharObjectHashMap, io.netty.util.collection.CharObjectMap
    public Long put(char c10, Long l10) {
        verifyStandardSetting(c10, l10);
        return (Long) super.put(c10, l10);
    }

    public Http2Settings(int i10) {
        super(i10);
    }

    public Http2Settings pushEnabled(boolean z10) {
        put((char) 2, z10 ? TRUE : FALSE);
        return this;
    }
}
