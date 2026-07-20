package ze;

/* JADX INFO: loaded from: classes3.dex */
public enum q1 {
    UNARY,
    CLIENT_STREAMING,
    SERVER_STREAMING,
    BIDI_STREAMING,
    UNKNOWN;

    public final boolean clientSendsOneMessage() {
        return this == UNARY || this == SERVER_STREAMING;
    }

    public final boolean serverSendsOneMessage() {
        return this == UNARY || this == CLIENT_STREAMING;
    }
}
