package io.netty.handler.codec.spdy;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface SpdySettingsFrame extends SpdyFrame {
    public static final int SETTINGS_CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    public static final int SETTINGS_CURRENT_CWND = 5;
    public static final int SETTINGS_DOWNLOAD_BANDWIDTH = 2;
    public static final int SETTINGS_DOWNLOAD_RETRANS_RATE = 6;
    public static final int SETTINGS_INITIAL_WINDOW_SIZE = 7;
    public static final int SETTINGS_MAX_CONCURRENT_STREAMS = 4;
    public static final int SETTINGS_MINOR_VERSION = 0;
    public static final int SETTINGS_ROUND_TRIP_TIME = 3;
    public static final int SETTINGS_UPLOAD_BANDWIDTH = 1;

    boolean clearPreviouslyPersistedSettings();

    int getValue(int i10);

    Set<Integer> ids();

    boolean isPersistValue(int i10);

    boolean isPersisted(int i10);

    boolean isSet(int i10);

    SpdySettingsFrame removeValue(int i10);

    SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z10);

    SpdySettingsFrame setPersistValue(int i10, boolean z10);

    SpdySettingsFrame setPersisted(int i10, boolean z10);

    SpdySettingsFrame setValue(int i10, int i11);

    SpdySettingsFrame setValue(int i10, int i11, boolean z10, boolean z11);
}
