package jg;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum n {
    SERVER_NAME(0),
    MAX_FRAGMENT_LENGTH(1),
    CLIENT_CERTIFICATE_URL(2),
    TRUSTED_CA_KEYS(3),
    TRUNCATED_HMAC(4),
    STATUS_REQUEST(5),
    ELLIPTIC_CURVES(10),
    EC_POINT_FORMAT(11),
    SIGNATURE_ALGORITHMS(13);

    private final short code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final m Companion = new m();

    n(short s2) {
        this.code = s2;
    }

    public static EnumEntries<n> getEntries() {
        return $ENTRIES;
    }

    public final short getCode() {
        return this.code;
    }
}
