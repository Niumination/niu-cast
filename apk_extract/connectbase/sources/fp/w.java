package fp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class w extends RuntimeException {
    private final List<String> missingFields;

    public w(q qVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public k asInvalidProtocolBufferException() {
        return new k(getMessage());
    }
}
