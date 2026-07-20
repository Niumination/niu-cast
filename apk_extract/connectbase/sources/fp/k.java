package fp;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class k extends IOException {
    private q unfinishedMessage;

    public k(String str) {
        super(str);
        this.unfinishedMessage = null;
    }

    public static k invalidEndTag() {
        return new k("Protocol message end-group tag did not match expected tag.");
    }

    public static k invalidTag() {
        return new k("Protocol message contained an invalid tag (zero).");
    }

    public static k invalidUtf8() {
        return new k("Protocol message had invalid UTF-8.");
    }

    public static k invalidWireType() {
        return new k("Protocol message tag had invalid wire type.");
    }

    public static k malformedVarint() {
        return new k("CodedInputStream encountered a malformed varint.");
    }

    public static k negativeSize() {
        return new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static k recursionLimitExceeded() {
        return new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static k sizeLimitExceeded() {
        return new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static k truncatedMessage() {
        return new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public q getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    public k setUnfinishedMessage(q qVar) {
        this.unfinishedMessage = qVar;
        return this;
    }
}
