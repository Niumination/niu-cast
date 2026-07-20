package io.netty.handler.codec.http;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private final HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");
    public static final HttpResponseStatus EARLY_HINTS = newStatus(103, "Early Hints");
    public static final HttpResponseStatus OK = newStatus(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, "OK");
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(204, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(205, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(207, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(302, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(303, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(304, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(305, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus PERMANENT_REDIRECT = newStatus(308, "Permanent Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(400, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(TypedValues.CycleType.TYPE_CURVE_FIT, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(TypedValues.CycleType.TYPE_ALPHA, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(408, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(409, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(410, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(411, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(412, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(413, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(417, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(TypedValues.CycleType.TYPE_WAVE_SHAPE, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(TypedValues.CycleType.TYPE_WAVE_PHASE, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(431, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(OSSwipeMenuLayout.D0, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(TypedValues.PositionType.TYPE_DRAWPATH, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(TypedValues.PositionType.TYPE_POSITION_TYPE, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");

    private HttpResponseStatus(int i10) {
        this(i10, ((Object) HttpStatusClass.valueOf(i10).defaultReasonPhrase()) + " (" + i10 + ')', false);
    }

    private static HttpResponseStatus newStatus(int i10, String str) {
        return new HttpResponseStatus(i10, str, true);
    }

    public static HttpResponseStatus parseLine(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? parseLine((AsciiString) charSequence) : parseLine(charSequence.toString());
    }

    public static HttpResponseStatus valueOf(int i10) {
        HttpResponseStatus httpResponseStatusValueOf0 = valueOf0(i10);
        return httpResponseStatusValueOf0 != null ? httpResponseStatusValueOf0 : new HttpResponseStatus(i10);
    }

    private static HttpResponseStatus valueOf0(int i10) {
        if (i10 == 307) {
            return TEMPORARY_REDIRECT;
        }
        if (i10 == 308) {
            return PERMANENT_REDIRECT;
        }
        if (i10 == 428) {
            return PRECONDITION_REQUIRED;
        }
        if (i10 == 429) {
            return TOO_MANY_REQUESTS;
        }
        if (i10 == 431) {
            return REQUEST_HEADER_FIELDS_TOO_LARGE;
        }
        if (i10 == 510) {
            return NOT_EXTENDED;
        }
        if (i10 == 511) {
            return NETWORK_AUTHENTICATION_REQUIRED;
        }
        switch (i10) {
            case 100:
                return CONTINUE;
            case 101:
                return SWITCHING_PROTOCOLS;
            case 102:
                return PROCESSING;
            case 103:
                return EARLY_HINTS;
            default:
                switch (i10) {
                    case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION /* 200 */:
                        return OK;
                    case 201:
                        return CREATED;
                    case 202:
                        return ACCEPTED;
                    case 203:
                        return NON_AUTHORITATIVE_INFORMATION;
                    case 204:
                        return NO_CONTENT;
                    case 205:
                        return RESET_CONTENT;
                    case 206:
                        return PARTIAL_CONTENT;
                    case 207:
                        return MULTI_STATUS;
                    default:
                        switch (i10) {
                            case 300:
                                return MULTIPLE_CHOICES;
                            case 301:
                                return MOVED_PERMANENTLY;
                            case 302:
                                return FOUND;
                            case 303:
                                return SEE_OTHER;
                            case 304:
                                return NOT_MODIFIED;
                            case 305:
                                return USE_PROXY;
                            default:
                                switch (i10) {
                                    case 400:
                                        return BAD_REQUEST;
                                    case TypedValues.CycleType.TYPE_CURVE_FIT /* 401 */:
                                        return UNAUTHORIZED;
                                    case TypedValues.CycleType.TYPE_VISIBILITY /* 402 */:
                                        return PAYMENT_REQUIRED;
                                    case TypedValues.CycleType.TYPE_ALPHA /* 403 */:
                                        return FORBIDDEN;
                                    case 404:
                                        return NOT_FOUND;
                                    case 405:
                                        return METHOD_NOT_ALLOWED;
                                    case 406:
                                        return NOT_ACCEPTABLE;
                                    case 407:
                                        return PROXY_AUTHENTICATION_REQUIRED;
                                    case 408:
                                        return REQUEST_TIMEOUT;
                                    case 409:
                                        return CONFLICT;
                                    case 410:
                                        return GONE;
                                    case 411:
                                        return LENGTH_REQUIRED;
                                    case 412:
                                        return PRECONDITION_FAILED;
                                    case 413:
                                        return REQUEST_ENTITY_TOO_LARGE;
                                    case 414:
                                        return REQUEST_URI_TOO_LONG;
                                    case 415:
                                        return UNSUPPORTED_MEDIA_TYPE;
                                    case TypedValues.CycleType.TYPE_PATH_ROTATE /* 416 */:
                                        return REQUESTED_RANGE_NOT_SATISFIABLE;
                                    case 417:
                                        return EXPECTATION_FAILED;
                                    default:
                                        switch (i10) {
                                            case TypedValues.CycleType.TYPE_WAVE_SHAPE /* 421 */:
                                                return MISDIRECTED_REQUEST;
                                            case TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE /* 422 */:
                                                return UNPROCESSABLE_ENTITY;
                                            case TypedValues.CycleType.TYPE_WAVE_PERIOD /* 423 */:
                                                return LOCKED;
                                            case TypedValues.CycleType.TYPE_WAVE_OFFSET /* 424 */:
                                                return FAILED_DEPENDENCY;
                                            case TypedValues.CycleType.TYPE_WAVE_PHASE /* 425 */:
                                                return UNORDERED_COLLECTION;
                                            case 426:
                                                return UPGRADE_REQUIRED;
                                            default:
                                                switch (i10) {
                                                    case OSSwipeMenuLayout.D0 /* 500 */:
                                                        return INTERNAL_SERVER_ERROR;
                                                    case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                                                        return NOT_IMPLEMENTED;
                                                    case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                                                        return BAD_GATEWAY;
                                                    case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                                                        return SERVICE_UNAVAILABLE;
                                                    case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                                                        return GATEWAY_TIMEOUT;
                                                    case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                                                        return HTTP_VERSION_NOT_SUPPORTED;
                                                    case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                                                        return VARIANT_ALSO_NEGOTIATES;
                                                    case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                                                        return INSUFFICIENT_STORAGE;
                                                    default:
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public int code() {
        return this.code;
    }

    public AsciiString codeAsText() {
        return this.codeAsText;
    }

    public HttpStatusClass codeClass() {
        return this.codeClass;
    }

    public void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            byteBuf.writeBytes(bArr);
            return;
        }
        ByteBufUtil.copy(this.codeAsText, byteBuf);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(this.reasonPhrase, CharsetUtil.US_ASCII);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpResponseStatus) && code() == ((HttpResponseStatus) obj).code();
    }

    public int hashCode() {
        return code();
    }

    public String reasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.reasonPhrase.length() + 4);
        sb2.append((CharSequence) this.codeAsText);
        sb2.append(' ');
        sb2.append(this.reasonPhrase);
        return sb2.toString();
    }

    public HttpResponseStatus(int i10, String str) {
        this(i10, str, false);
    }

    public static HttpResponseStatus parseLine(String str) {
        try {
            int iIndexOf = str.indexOf(32);
            return iIndexOf == -1 ? valueOf(Integer.parseInt(str)) : valueOf(Integer.parseInt(str.substring(0, iIndexOf)), str.substring(iIndexOf + 1));
        } catch (Exception e10) {
            throw new IllegalArgumentException(a.a("malformed status line: ", str), e10);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    private HttpResponseStatus(int i10, String str, boolean z10) {
        ObjectUtil.checkPositiveOrZero(i10, "code");
        ObjectUtil.checkNotNull(str, "reasonPhrase");
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: ".concat(str));
            }
        }
        this.code = i10;
        this.codeClass = HttpStatusClass.valueOf(i10);
        String string = Integer.toString(i10);
        this.codeAsText = new AsciiString(string);
        this.reasonPhrase = str;
        if (z10) {
            this.bytes = (string + ' ' + str).getBytes(CharsetUtil.US_ASCII);
            return;
        }
        this.bytes = null;
    }

    public static HttpResponseStatus valueOf(int i10, String str) {
        HttpResponseStatus httpResponseStatusValueOf0 = valueOf0(i10);
        return (httpResponseStatusValueOf0 == null || !httpResponseStatusValueOf0.reasonPhrase().contentEquals(str)) ? new HttpResponseStatus(i10, str) : httpResponseStatusValueOf0;
    }

    public static HttpResponseStatus parseLine(AsciiString asciiString) {
        try {
            int iForEachByte = asciiString.forEachByte(ByteProcessor.FIND_ASCII_SPACE);
            return iForEachByte == -1 ? valueOf(asciiString.parseInt()) : valueOf(asciiString.parseInt(0, iForEachByte), asciiString.toString(iForEachByte + 1));
        } catch (Exception e10) {
            throw new IllegalArgumentException("malformed status line: " + ((Object) asciiString), e10);
        }
    }
}
