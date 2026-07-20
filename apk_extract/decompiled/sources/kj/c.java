package kj;

/* JADX INFO: loaded from: classes3.dex */
public enum c {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public static final b Companion = new b();
    private final int httpCode;

    c(int i8) {
        this.httpCode = i8;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
