package io.netty.handler.codec.http.websocketx;

import androidx.core.view.PointerIconCompat;
import h.a;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketCloseStatus implements Comparable<WebSocketCloseStatus> {
    private final String reasonText;
    private final int statusCode;
    private String text;
    public static final WebSocketCloseStatus NORMAL_CLOSURE = new WebSocketCloseStatus(1000, "Bye");
    public static final WebSocketCloseStatus ENDPOINT_UNAVAILABLE = new WebSocketCloseStatus(1001, "Endpoint unavailable");
    public static final WebSocketCloseStatus PROTOCOL_ERROR = new WebSocketCloseStatus(PointerIconCompat.TYPE_HAND, "Protocol error");
    public static final WebSocketCloseStatus INVALID_MESSAGE_TYPE = new WebSocketCloseStatus(PointerIconCompat.TYPE_HELP, "Invalid message type");
    public static final WebSocketCloseStatus INVALID_PAYLOAD_DATA = new WebSocketCloseStatus(PointerIconCompat.TYPE_CROSSHAIR, "Invalid payload data");
    public static final WebSocketCloseStatus POLICY_VIOLATION = new WebSocketCloseStatus(PointerIconCompat.TYPE_TEXT, "Policy violation");
    public static final WebSocketCloseStatus MESSAGE_TOO_BIG = new WebSocketCloseStatus(PointerIconCompat.TYPE_VERTICAL_TEXT, "Message too big");
    public static final WebSocketCloseStatus MANDATORY_EXTENSION = new WebSocketCloseStatus(PointerIconCompat.TYPE_ALIAS, "Mandatory extension");
    public static final WebSocketCloseStatus INTERNAL_SERVER_ERROR = new WebSocketCloseStatus(PointerIconCompat.TYPE_COPY, "Internal server error");
    public static final WebSocketCloseStatus SERVICE_RESTART = new WebSocketCloseStatus(PointerIconCompat.TYPE_NO_DROP, "Service Restart");
    public static final WebSocketCloseStatus TRY_AGAIN_LATER = new WebSocketCloseStatus(PointerIconCompat.TYPE_ALL_SCROLL, "Try Again Later");
    public static final WebSocketCloseStatus BAD_GATEWAY = new WebSocketCloseStatus(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, "Bad Gateway");
    public static final WebSocketCloseStatus EMPTY = new WebSocketCloseStatus(1005, "Empty", false);
    public static final WebSocketCloseStatus ABNORMAL_CLOSURE = new WebSocketCloseStatus(PointerIconCompat.TYPE_CELL, "Abnormal closure", false);
    public static final WebSocketCloseStatus TLS_HANDSHAKE_FAILED = new WebSocketCloseStatus(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, "TLS handshake failed", false);

    public WebSocketCloseStatus(int i10, String str) {
        this(i10, str, true);
    }

    public static boolean isValidStatusCode(int i10) {
        return i10 < 0 || (1000 <= i10 && i10 <= 1003) || ((1007 <= i10 && i10 <= 1014) || 3000 <= i10);
    }

    public static WebSocketCloseStatus valueOf(int i10) {
        switch (i10) {
            case 1000:
                return NORMAL_CLOSURE;
            case 1001:
                return ENDPOINT_UNAVAILABLE;
            case PointerIconCompat.TYPE_HAND /* 1002 */:
                return PROTOCOL_ERROR;
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                return INVALID_MESSAGE_TYPE;
            case PointerIconCompat.TYPE_WAIT /* 1004 */:
            default:
                return new WebSocketCloseStatus(i10, a.a("Close status #", i10));
            case 1005:
                return EMPTY;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                return ABNORMAL_CLOSURE;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                return INVALID_PAYLOAD_DATA;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                return POLICY_VIOLATION;
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                return MESSAGE_TOO_BIG;
            case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                return MANDATORY_EXTENSION;
            case PointerIconCompat.TYPE_COPY /* 1011 */:
                return INTERNAL_SERVER_ERROR;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                return SERVICE_RESTART;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                return TRY_AGAIN_LATER;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                return BAD_GATEWAY;
            case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                return TLS_HANDSHAKE_FAILED;
        }
    }

    public int code() {
        return this.statusCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WebSocketCloseStatus.class == obj.getClass() && this.statusCode == ((WebSocketCloseStatus) obj).statusCode;
    }

    public int hashCode() {
        return this.statusCode;
    }

    public String reasonText() {
        return this.reasonText;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = code() + " " + reasonText();
        this.text = str2;
        return str2;
    }

    public WebSocketCloseStatus(int i10, String str, boolean z10) {
        if (z10 && !isValidStatusCode(i10)) {
            throw new IllegalArgumentException(a.a("WebSocket close status code does NOT comply with RFC-6455: ", i10));
        }
        this.statusCode = i10;
        this.reasonText = (String) ObjectUtil.checkNotNull(str, "reasonText");
    }

    @Override // java.lang.Comparable
    public int compareTo(WebSocketCloseStatus webSocketCloseStatus) {
        return code() - webSocketCloseStatus.code();
    }
}
